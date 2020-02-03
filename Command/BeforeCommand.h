//
//  beforecommand.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/03 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef _BEFORECOMMAND_H_
#define _BEFORECOMMAND_H_
#include <iostream>
#include <queue>
using namespace std;

class BeforeGiant{
public:
    enum Type{
        Fee, Phi, Pheaux,
    };

    BeforeGiant(){
        _id = _next++;
        _type = (Type)(_id % 3);    //这里随机指定type
    }

    Type getType(){
        return _type;
    }

    void fee(){ cout << _id << "-fee" << endl; }
    void phi(){ cout << _id << "-phi" << endl; }
    void pheaux(){ cout << _id << "-pheaux" << endl; }

private:
    Type _type;
    int _id;
    static int _next;
};
int BeforeGiant::_next = 0;

void beforeCommand(){
    queue<BeforeGiant*> queue;
    BeforeGiant input[6];
    BeforeGiant* pbg;

    for(int i=0;i<6;++i){
        queue.push(&input[i]);
    }

    for(int i=0;i<6;++i){
        pbg = queue.front();
        queue.pop();

        /**
         * 根据type执行相应的函数
         * 如果class中添加新的方法，这里又要加判断
         */
        if(pbg->getType() == BeforeGiant::Fee){
            pbg->fee();
        }else if(pbg->getType() == BeforeGiant::Phi){
            pbg->phi();
        }else if(pbg->getType() == BeforeGiant::Pheaux){
            pbg->pheaux();
        }
    }
}

#endif //_BEFORECOMMAND_H_
