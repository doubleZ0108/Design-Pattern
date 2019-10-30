//
//  FactoryMethod.h
//  Design Pattern
//
//  Created by double Z on 2019/10/30.
//  Copyright © 2019 double Z. All rights reserved.
//

#ifndef FactoryMethod_h
#define FactoryMethod_h

#include <iostream>
#include <vector>
using namespace std;

/* Frame Work */
class Document {
protected:
    string _name;
public:
    Document(){}
    Document(const string &name) :_name(name) {}
    
    virtual void Open() = 0;
    
    string getName(){
        return this->_name;
    }
};

class App {
private:
    vector<Document *> docs;
protected:
    virtual Document* CreateDocument(const string &name) = 0;   //返回值写的尽量模糊，因为new的是用户的应用
public:
    
    void NewDocument(const string &name){   //通过将CreateDocument封装成虚函数可以提前写好这个函数
        cout << "App::NewDocument()" << endl;
        Document* doc = CreateDocument(name);
        docs.push_back(doc);
        doc->Open();
    }
    
    void OutputDocument(){
        cout << "== docs in App:" << endl;
        for(vector<Document *>::iterator iter = docs.begin(); iter != docs.end(); ++iter){
            cout << "\t" << (*iter)->getName() << endl;     //*iter的类型是Document *
        }
    }
};

/* Application */
class myDoc : public Document {
public:
    myDoc(){}
    myDoc(const string& name) :Document(name){}
    
    void Open(){
        cout << "myDoc::Open()" << endl;
    }
};

class myApp : public App{
protected:
    Document* CreateDocument(const string &name){   //myApp和myDoc是同一个人实现的，因此这里彼此耦合是ok的
        cout << "myApp::CreateDocument()" << endl;
        return new myDoc(name);
    }
};

#endif /* FactoryMethod_h */
