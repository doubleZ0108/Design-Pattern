//
//  portimage.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/01 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef _PORTIMAGE_H_
#define _PORTIMAGE_H_

#include <iostream>
#include "imagetype.h"
#include "image.h"
using namespace std;

class PortImage : public Image{
private:
    static PortImage _portImage;  //初始化Image subclass -> 调用默认构造函数将这个类注册进_property里
    int _id;
    static int _count;

    /* only called when the private static data member is inited */
    PortImage(){
        addProperty(this);      //创建这第一个很花时间
    }

protected:
    /* 对原型进行memcpy */
    PortImage(int dummy){
        _id = _count++;
    }

public:
    /* 调用有参数的ctor */
    Image * clone() {
        return new PortImage(1);
    }

    ~PortImage() {}

    ImageType getType(){ return PORT; }

    void draw(){
        cout << "PortImage::draw" << _id << endl;
    }
};

// register the subclass's prototype
PortImage PortImage::_portImage;

int PortImage::_count = 1;

#endif //_PORTIMAGE_H_
