//
//  Observer.h
//  Design Pattern
//
//  Created by double Z on 2019/10/16.
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef Observer_h
#define Observer_h

#include <iostream>
#include <vector>
using namespace std;

class Observer
{
public:
    virtual void update(int value) = 0;
};

class Subject
{
private:
    vector<Observer*> obs;      //Observers pool
    int value;
    
public:
    Subject(){}
    
    /*此函数被调用意味着数据有变化 -> 通知所有Observers*/
    void updateValue(int value){
        this->value = value;
        norifyAllObservers();
    }
    
    void addObserver(Observer *o){
        obs.push_back(o);
    }
    
    void notifyObserver(Observer &o){
        o.update(value);
    }
    
    void norifyAllObservers(){
        for(int i=0;i<obs.size();++i){
            obs[i]->update(value);
        }
    }
};


class DivObserver : public Observer
{
private:
    int div;
public:
    DivObserver(){}
    
    DivObserver(int div){
        this->div = div;
    }
    
    void update(int value){
        cout << value << " div " << this->div << " = " << value/this->div << endl;
    }
};

class ModObserver : public Observer
{
private:
    int mod;
public:
    ModObserver(){}
    
    ModObserver(int mod){
        this->mod =mod;
    }
    
    void update(int value){
        cout << value << " mod " << this->mod << " = " << value/this->mod << endl;
    }
};

#endif /* Observer_h */
