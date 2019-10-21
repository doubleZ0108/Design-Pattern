//
//  ReferenceCounting.h
//  Design Pattern
//
//  Created by double Z on 2019/10/20.
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef ReferenceCounting_h
#define ReferenceCounting_h

#include <iostream>
#include <cstring>
using namespace std;

class myString
{
public:
	friend ostream& operator<<(ostream& os, const myString& str);

private:
	struct StringValue {
		int refCount;
		char* data;
		bool shareable;
		StringValue(const char* initValue);
		~StringValue();
	};
	StringValue* value = NULL;

public:
	myString() {}
	myString(const char* cstr);

	myString(const myString& rhs);
	~myString();
	myString& operator=(const myString& rhs);

	char* get_c_str() const { return value->data; }
};

ostream& operator<<(ostream& os, const myString& str)
{
	os << str.value->data;
	return os;
}

myString::StringValue::StringValue(const char* initValue)
	:refCount(1), shareable(true)
{
	data = new char[strlen(initValue) + 1];
	strcpy(data, initValue);
}

myString::StringValue::~StringValue()
{
	delete[] data;      //判断计数器为0的语句在外层做了
}

myString::myString(const char* cstr)
	:value(new StringValue(cstr)) {}     //唤起StringValue的构造函数

myString::myString(const myString& rhs)
	: value(rhs.value)
{
	++value->refCount;		//因为这是构造函数,只可能在刚刚创建一个新的变量时才可能被调用,所以不用做相等检测和释放原来的value
}

myString::~myString()
{
	if (--value->refCount == 0) {
		delete value;       //唤起StringValue的析构函数
	}
}

myString& myString::operator=(const myString& rhs)
{
	if (value == rhs.value) {
		return *this;
	}

	if (value && --value->refCount == 0) {
		delete value;
	}

	value = rhs.value;		//二者的类型都是指针
	++value->refCount;		//递增this->value的refCount, rhs.value的refCount也同步变化
	return *this;
}

#endif /* ReferenceCounting_h */
