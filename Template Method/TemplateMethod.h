//
//  TemplateMethod.h
//  Design Pattern
//
//  Created by double Z on 2019/10/11.
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef TemplateMethod_h
#define TemplateMethod_h

#include <iostream>
using namespace std;

/* application framework */
class CDocument
{
public:
    /* skeleton */
    void OnFileOpen()
    {
        cout<<"CDocument::dialog..."<<endl;
        cout<<"CDocument::checkout file status..."<<endl;
        cout<<"CDocument::open file..."<<endl;
        Serialize();
        cout<<"CDocument::close file..."<<endl;
        cout<<"CDocument::update all views..."<<endl;
    }
    
    /* 推迟该步骤使得在subclass在才完成 */
    virtual void Serialize(){};
};

/* application */
class CMyDoc : public CDocument
{
public:
    virtual void Serialize()
    {
        cout<<"CMyDoc::Serialize()"<<endl;
    }
};

#endif /* TemplateMethod_h */
