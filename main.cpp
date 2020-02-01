//
//  main.cpp
//  Design Pattern
//
//  Created by double Z on 2019/10/11.
//  Copyright © 2019 double Z. All rights reserved.
//

#include <iostream>
//#include "TemplateMethod.h"
//#include "Strategy.h"
//#include "Observer.h"
//#include "Iterator.h"
//#include "Singleton.h"
//#include "myString.h"
//#include "ReferenceCounting.h"
//#include "CopyOnWrite.h"
//#include "Shareable.h"
//#include "FactoryMethod.h"
#include "Property.h"

using namespace std;

//void Test_TemplateMethod()
//{
//    CMyDoc myDoc;
//    myDoc.OnFileOpen();
//}
//
//void Test_Strategy()
//{
//    int op;
//    StrategyTest stest;
//
//    while(true){
//        /* 有新的策略，在这里修改一下UI */
//        cout << "你想使用那种解决方案1~3 [0 to quit] " << endl;
//        cin >> op;
//        if(!op){break;}
//
//        stest.setStrategy(op, 999);
//        stest.run();
//
//    }
//
//}
//
//void Test_Observer()
//{
//    Subject subj;
//    DivObserver divobs1(4);    subj.addObserver(&divobs1);
//    DivObserver divobs2(3);    subj.addObserver(&divobs2);
//    ModObserver modobs3(3);    subj.addObserver(&modobs3);
//
//    subj.updateValue(14);
//}
//
//void Test_Iterator()
//{
//    Iterator();
//}
//
//void Test_Singleton()
//{
//    Singleton::Instance();
//    MayersSingleton::Instance();
//
//}
//
//void Test_ReferenceCounting()
//{
//    myString str = "hello";     //myString(const char* cstr);
//    myString str1;              //myString() {}
//    str1 = str;                 //myString& operator=(const myString& rhs);
//    myString str2(str);         //myString(const myString& rhs);
//}
//
//void Test_CopyOnWrite()
//{
//    const myString cstr = "hello";
//    cout << cstr[2];        //调用@1
//
//    myString str = "world";
//    myString str1(str);
//    cout << str[2];                //调用@2 read
//
//    myString str2;
//    str2 = str;
//    str[1] = 'O';                //调用@2 write
//}
//
//void Test_Shareable()
//{
//    myString s1 = "hello";
//    char *p = &s1[1];   //使用了non-const operator[]，悲观的认为是外界拥有handle了 => 将shareable设为false
//    myString s2 = s1;   //这里s1的shareable已经被设为false，所以此时s2的value要new一个新的
//    *p = 'x';
//}
//
//void Test_FactoryMethod()
//{
//    myApp *myapp = new myApp();
//    myapp->NewDocument("doc1");
//    myapp->NewDocument("doc2");
//    myapp->OutputDocument();
//}

void Test_Property()
{
    testProperty();
}

int main(int argc, const char * argv[]) {
    
    Test_Property();
    
    return 0;
}
