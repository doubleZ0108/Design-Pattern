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

int main(int argc, const char * argv[]) {
    
    
    
    return 0;
}
