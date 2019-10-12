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


int main(int argc, const char * argv[]) {
    
    Test_TemplateMethod();
    
    return 0;
}
