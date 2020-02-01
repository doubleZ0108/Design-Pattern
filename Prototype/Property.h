//
//  Property.h
//  DesignPattern
//  
//  Created by double Z on 2020/02/01 .
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef DESIGNPATTERN_PROPERTY_H
#define DESIGNPATTERN_PROPERTY_H

#include "imagetype.h"
#include "image.h"
#include "landsatimage.h"
#include "sportimage.h"
#include "portimage.h"
#include <vector>

const int NUM_IMAGES = 12;
ImageType input[NUM_IMAGES] = {
        LSAT, LSAT, LSAT, SPOT, LSAT, SPOT, SPOT, LSAT, SPOT, PORT, PORT, LSAT,
};

void testProperty(){

    vector<Image*> images(NUM_IMAGES);

    for(int i=0;i<NUM_IMAGES;++i){
        images[i] = Image::findAndClond(input[i]);
    }

    for(int i=0;i<NUM_IMAGES;++i){
        images[i]->draw();
    }

    for(int i=0;i<NUM_IMAGES;++i){
        delete images[i];
    }
}


#endif //DESIGNPATTERN_PROPERTY_H
