//
//  myString.h
//  Design Pattern
//
//  Created by double Z on 2019/10/20.
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef myString_h
#define myString_h

#include <iostream>
#include <cstring>
using namespace std;

class myString
{
public:
    friend ostream& operator<<(ostream &os, const myString& str);
private:
    char *data = NULL;
public:
    myString(){}
    myString(const char* cstr);
    
    myString(const myString& str);
    ~myString();
    myString& operator=(const myString& str);
    myString& operator=(const char* cstr);
    myString& operator=(char ch);
    
    char* get_c_str() const {return data;}
};

ostream& operator<<(ostream &os, const myString& str)
{
    os << str.data;
    return os;
}

myString::myString(const char* cstr)
{
    if(cstr){       //判断赋值字串是否为空
        data = new char[strlen(cstr) + 1];
        strcpy(data, cstr);
    }
    else{
        data = new char[1];
        data[0] = '\0';
    }
}

myString::myString(const myString& str)
{
    if(!str.get_c_str()){
        return;
    }
    
    data = new char[strlen(str.get_c_str()) + 1];
    strcpy(data, str.get_c_str());
}

myString::~myString()
{
    delete[] data;
}

myString& myString::operator=(const myString& str)
{
    if(&str == this){       //拷贝构造函数瑶检测自我赋值
        return *this;
    }
    if(!str.get_c_str()){
        return *this;
    }
    
    delete[] data;
    data = new char[strlen(str.get_c_str()) + 1];
    strcpy(data, str.get_c_str());
    return *this;
}

myString& myString::operator=(const char* cstr)
{
    delete[] data;
    data = new char[strlen(cstr) + 1];
    strcpy(data, cstr);
    return *this;
}

myString& myString::operator=(char ch)
{
    delete[] data;
    data = new char[2];
    data[0] = ch;
    return *this
}



#endif /* myString_h */
