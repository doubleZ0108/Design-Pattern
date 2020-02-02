//
//  Composite.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/02 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef _COMPOSITE_H_
#define _COMPOSITE_H_

#include <iostream>
#include <vector>
using namespace std;

class Compont{
public:
    virtual void traverse() = 0;
};

class Leaf : public Compont{
    int value;
public:
    Leaf() = default;
    Leaf(int value){ this->value = value; }

    void traverse(){
        cout << this->value << " ";
    }
};

class Composite : public Compont{
    vector<Compont*> children;
public:
    void add(Compont* compont){
        children.push_back(compont);
    }

    void traverse(){
        for(vector<Compont*>::iterator iter = children.begin(); iter!=children.end();++iter){
            (*iter)->traverse();
        }
    }
};

#endif //_COMPOSITE_H_
