//
//  Iterator.h
//  Design Pattern
//
//  Created by double Z on 2019/10/16.
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef Iterator_h
#define Iterator_h

#include <vector>
#include <list>

void Iterator()
{
    int iarr[5] = {1,3,5,7,9};
    list<int> ilist(iarr, iarr + 5);
    
    list<int>::iterator iter = ilist.begin();
    for(iter = ilist.begin(); iter != ilist.end(); ++iter){
        cout << *iter <<endl;
    }
}


#endif /* Iterator_h */
