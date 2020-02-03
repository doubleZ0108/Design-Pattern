//
//  Command.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/03 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef _COMMAND_H_
#define _COMMAND_H_

#include <iostream>
using namespace std;

class AfterGiant{
public:
    AfterGiant(){
        _id = _next++;
    }

    void fee(){ cout << _id << "-fee" << endl; }
    void phi(){ cout << _id << "-phi" << endl; }
    void pheaux(){ cout << _id << "-pheaux" << endl; }

private:
    /**
     * 不需要用type指明将来要执行哪个method，只需创建Command object时指定即可
     * 有新的方法，只需创建新的Command object
     */
    int _id;
    static int _next;
};
int AfterGiant::_next = 0;

class Command{
public:
    /**
     * pointer to member function
     * 指向Giant的成员函数
     * ()说明指向的是没有参数的member function
     */
    typedef void(AfterGiant::*Action)();

    Command(AfterGiant* object, Action method){
        _object = object;
        _method = method;
    }

    void execute(){
        (_object->*_method)();
    }

private:
    AfterGiant* _object;
    Action _method;
};

void afterCommand(){
    queue<Command*> queue;
    Command* input[] = {
            new Command(new AfterGiant, &AfterGiant::fee),
            new Command(new AfterGiant, &AfterGiant::phi),
            new Command(new AfterGiant, &AfterGiant::pheaux),
            new Command(new AfterGiant, &AfterGiant::fee),
            new Command(new AfterGiant, &AfterGiant::phi),
            new Command(new AfterGiant, &AfterGiant::pheaux),
    };

    for(int i=0;i<6;++i){
        queue.push(input[i]);
    }

    for(int i=0;i<6;++i){
        queue.front()->execute();   //这里不用判断取出元素的type
        queue.pop();
    }
}

#endif //_COMMAND_H_
