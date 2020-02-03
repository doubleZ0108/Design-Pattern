//
//  Memento.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/03 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef _MEMENTO_H_
#define _MEMENTO_H_

#include <iostream>
#include <vector>
using namespace std;

class Number;

/**
 * 记录了Originator的state
 * 而又维护了封装性（friend和private）
 */
class Memento{
public:
    Memento(int state) : _state(state) {}
private:
    friend class Number;
    int _state;
};

/**
 * 要进行备忘录的数据结构和操作
 * 1. Receiver（in Command）
 * 2. Originator（int Memento）
 */
class Number{
public:
    Number(int value) : _value(value) {}

    void dubble(){ _value *= 2; }
    void half(){ _value /= 2; }
    int getValue(){ return _value;}

    /* 拍摄快照 */
    Memento* createMemento(){
        return new Memento(_value);
    }
    /* 恢复状态 */
    void reinstateMemento(const Memento* memento){
        _value = memento->_state;       //因为Number是Memento的friend
    }
private:
    int _value;     //真正要储存的信息，要配合memento里的数据
};


class Command{
public:
    typedef void(Number::*Action)();    //指定Number的method

    Command(Number* receiver, Action action){
        _receiver = receiver;
        _action = action;
    }

    virtual void execute(){
        // 每执行前先要记录一个memento和一个command
        _mementoList.push_back(_receiver->createMemento());
        _commandList.push_back(this);

        // 同步升降
        if(_numCommands > _highWater){
            _highWater = _numCommands;
        }
        _numCommands++;

        //执行method
        (_receiver->*_action)();
    }

    static void undo(){
        if(_numCommands == 0){
            cout << "*** 没有更多的undo可做 ***" << endl;
            return;
        }

        //取出last command，用其储存的receiver唤起reinstateMemento()，并用last memento为参数，恢复origin state
        _commandList[_numCommands - 1]->_receiver->reinstateMemento(_mementoList[_numCommands - 1]);
        _numCommands--;
    }

    static void redo(){
        if(_numCommands > _highWater){
            cout << "*** 没有更多的redo可做 ***" << endl;
            return;
        }

        //取出current command，用其储存的receiver唤起action()
        (_commandList[_numCommands]->_receiver->*(_commandList[_numCommands]->_action))();
        _numCommands++;
    }
private:
    Number* _receiver;
    Action _action;

    /* 做成静态成员（提供一种统一的接口）*/
    static vector<Command*> _commandList;   //实现redo
    static vector<Memento*> _mementoList;   //实现undo
    static int _numCommands;
    static int _highWater;
};

vector<Command*> Command::_commandList;
vector<Memento*> Command::_mementoList;
int Command::_numCommands = 0;
int Command::_highWater = 0;


void testMemento(){
    int i;
    cout << "Please input a integer: ";
    cin >> i;
    Number* object = new Number(i);

    Command* command[3];
    command[1] = new Command(object, &Number::dubble);
    command[2] = new Command(object, &Number::half);

    do{
        cout << "Exit[0], Double[1], Half[2], Undo[3], Redo[4]: ";
        cin >> i;
        if(i == 0){
            break;
        } else if(i == 3){
            Command::undo();
        } else if(i == 4){
            Command::redo();
        } else{
            command[i]->execute();
        }
        cout << object->getValue() << endl;
    }while(true);
}


#endif //_MEMENTO_H_
