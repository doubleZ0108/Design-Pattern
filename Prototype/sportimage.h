//
//  sportimage.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/01 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef _SPORTIMAGE_H_
#define _SPORTIMAGE_H_

#include <iostream>
#include "imagetype.h"
#include "image.h"
using namespace std;

class SpotImage : public Image{
private:
    static SpotImage _spotImage;  //初始化Image subclass -> 调用默认构造函数将这个类注册进_property里
    int _id;
    static int _count;

    /* only called when the private static data member is inited */
    SpotImage(){
        addProperty(this);      //创建这第一个很花时间
    }

protected:
    /* 对原型进行memcpy */
    SpotImage(int dummy){
        _id = _count++;
    }

public:
    /* 调用有参数的ctor */
    Image * clone() {
        return new SpotImage(1);
    }

    ~SpotImage() {}

    ImageType getType(){ return SPOT; }

    void draw(){
        cout << "SpotImage::draw" << _id << endl;
    }
};

// register the subclass's prototype
SpotImage SpotImage::_spotImage;

int SpotImage::_count = 1;

#endif //_SPORTIMAGE_H_
