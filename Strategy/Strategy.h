//
//  Strategy.h
//  Design Pattern
//
//  Created by double Z on 2019/10/11.
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef Strategy_h
#define Strategy_h

#include <iostream>
using namespace std;

class Strategy
{
public:
    Strategy(int mess) :_mess(mess){}
    
    void solve(){
        
        //...
        //这里省略所有子类都需要做的（没区别的）
        //TODO
        //...
        
        /*
         用指针实现的多态
         这里的this是base class的指针
         他可以在运行时自由的指向derived class
         */
        this->solution();   //即使不写this编译器也会把虚函数解释成  this->solution()
    }
    
protected:
    int _mess;
    
private:
    virtual void solution() = 0;
};

class StrategyOne : public Strategy
{
public:
    StrategyOne(int mess) :Strategy(mess) {}
    
private:
    void solution(){
        cout << "Solution 1..." << endl;
    }
};

class StrategyTwo : public Strategy
{
public:
    StrategyTwo(int mess) :Strategy(mess) {}
    
private:
    void solution(){
        cout << "Solution 2..." << endl;
    }
};

class StrategyThr : public Strategy
{
public:
    StrategyThr(int mess) :Strategy(mess) {}
    
private:
    void solution(){
        cout << "Solution 3..." << endl;
    }
};

/* 有新的策略，在这添加一个新的策略子类 */


/* test for strategy */
class StrategyTest
{
public:
    StrategyTest(){
        this->_strategy = NULL;
    }
    
    enum StrategyType{ DUMMY, TYPE1, TYPE2, TYPE3 };
    
    void setStrategy(int type, int other_mess);
    
    void run();
    
private:
    Strategy* _strategy;
};

void StrategyTest::setStrategy(int type, int other_mess) {
    if(this->_strategy){
        delete this->_strategy;
    }
    
    switch (type) {
        case TYPE1:
            this->_strategy = new StrategyOne(other_mess);
            break;
            
        case TYPE2:
            this->_strategy = new StrategyTwo(other_mess);
            break;
            
        case TYPE3:
            this->_strategy = new StrategyThr(other_mess);
            break;
            
        /* 有新的策略，在这添加一个case †*/
            
        default:
            break;
    }
}

void StrategyTest::run() {
    this->_strategy->solve();
}

#endif /* Strategy_h */
