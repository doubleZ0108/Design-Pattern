//
//  main.cpp
//  Design Pattern
//
//  Created by double Z on 2019/10/11.
//  Copyright © 2019 double Z. All rights reserved.
//

#include <iostream>
#include "TemplateMethod.h"
#include "Strategy.h"
#include "Observer.h"
#include "Iterator.h"
#include "Singleton.h"
#include "myString.h"
using namespace std;

void Test_TemplateMethod()
{
    CMyDoc myDoc;
    myDoc.OnFileOpen();
}

void Test_Strategy()
{
    int op;
    StrategyTest stest;
    
    while(true){
        /* 有新的策略，在这里修改一下UI */
        cout << "你想使用那种解决方案1~3 [0 to quit] " << endl;
        cin >> op;
        if(!op){break;}
        
        stest.setStrategy(op, 999);
        stest.run();
        
    }
    
}

void Test_Observer()
{
    Subject subj;
    DivObserver divobs1(4);    subj.addObserver(&divobs1);
    DivObserver divobs2(3);    subj.addObserver(&divobs2);
    ModObserver modobs3(3);    subj.addObserver(&modobs3);
    
    subj.updateValue(14);
}

void Test_Iterator()
{
    Iterator();
}

void Test_Singleton()
{
    Singleton::Instance();
    MayersSingleton::Instance();
    
}

void Test_myString()
{
    myString s1 = "hello world";
    myString s2;
    s2 = s1;
    myString s3 = s2;
    

    cout << s1 <<endl;
    cout << s2 <<endl;
    cout << s3 <<endl;
}


int main(int argc, const char * argv[]) {
    
    Test_myString();
    
    return 0;
}
