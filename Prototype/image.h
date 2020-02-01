//
//  image.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/01 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef _IMAGE_H_
#define _IMAGE_H_

#include <iostream>
#include <vector>
#include "imagetype.h"
using namespace std;

class Image{
private:
    static vector<Image*> _prototypes;     //静态的容器
    static int _nextSlot;

protected:
    virtual Image* clone() = 0;

    static void addProperty(Image* image){
        _prototypes.push_back(image);
        _nextSlot++;
    }

    virtual ImageType getType() = 0;

public:
    virtual ~Image(){}

    /* client调用该方法创建实例 */
    static Image* findAndClond(ImageType type){
        for(int i=0;i< _nextSlot;++i){
            if(_prototypes[i]->getType() == type){
                return _prototypes[i]->clone();
            }
        }
    }

    virtual void draw() = 0;

};

//得到内存
vector<Image*> Image::_prototypes;
int Image::_nextSlot = 0;

#endif //_IMAGE_H_
