//
//  landsatimage.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/01 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef _LANDSATIMAGE_H_
#define _LANDSATIMAGE_H_

#include <iostream>
#include "imagetype.h"
#include "image.h"
using namespace std;

class LandSatImage : public Image{
private:
    static LandSatImage _landSatImage;  //初始化Image subclass -> 调用默认构造函数将这个类注册进_property里
    int _id;
    static int _count;

    /* only called when the private static data member is inited */
    LandSatImage(){
        addProperty(this);      //创建这第一个很花时间
    }

protected:
    /* 对原型进行memcpy */
    LandSatImage(int dummy){
        _id = _count++;
    }

public:
    /* 调用有参数的ctor */
    Image * clone() {
        return new LandSatImage(1);
    }

    ~LandSatImage() {}

    ImageType getType(){ return LSAT; }

    void draw(){
        cout << "LandSatImage::draw" << _id << endl;
    }
};

// register the subclass's prototype
LandSatImage LandSatImage::_landSatImage;

int LandSatImage::_count = 1;

#endif //_LANDSATIMAGE_H_
