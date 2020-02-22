//
//  Singleton.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/22 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef SINGLETON_H_
#define SINGLETON_H_

class Singleton{
public:
    static Singleton& Instance(){       //根本没有object，所以要用static定义Instance
        if(!pInstance_){
            pInstance_ = new Singleton;
        }
        return *pInstance_;
    }
private:
    Singleton();
    Singleton(const Singleton&);
    ~Singleton();
    Singleton& operator=(const Singleton&);

private:
    static Singleton* pInstance_;
};

Singleton* Singleton::pInstance_ = 0;


class AnotherSingleton{
public:
    static AnotherSingleton& Instance(){
        static AnotherSingleton anotherSingleton;       //更漂亮，不需要一个指针，不需要new
        return anotherSingleton;
    }

private:
    AnotherSingleton();
    AnotherSingleton(const AnotherSingleton&);
    ~AnotherSingleton();
    AnotherSingleton& operator=(const AnotherSingleton&);
};
#endif //SINGLETON_H_
