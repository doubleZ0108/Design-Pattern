# Strategy

定义a family of algorithms，封装其中的每一个使得可以被交换使用，算法交换不影响用户

- **表现手法：**polymorphism
- 可以在**runtime**时改变策略（不关掉程序）
  - 指针变换到另一个子类
  - 添加一个新的子类，让指针指向新的子类
- 使用指针或引用
  - 让指针指向父类，在运行的时候可以很方便的指向子类

> 例. C++
>
> - **StrategyTest**
>   - setStrategy()根据传入的type设置选择哪个策略（使用哪个子类）
>   - run()调用Strategy类的solve()方法
> - **Strategy**
>   - solve()调用虚函数solutioin()
>
> ```C++
> void solve(){
>   			//...
>        //这里省略所有子类都需要做的（没区别的）
>        //TODO
>        //...
>        
>        /*
>         用指针实现的多态
>         这里的this是base class的指针
>         他可以在运行时自由的指向derived class
>         */
>        this->solution();   //即使不写this编译器也会把虚函数解释成  this->solution()
>    }
> ```
>
> - **StrategyOne, StrategyTwo, StrategyThr**
>   - 实现虚函数solutioin()
>
> <img src="../ScreenShots/Strategy/Strategy_cppdemo_classdiagram.png" alt="Strategy_cppdemo_classdiagram" style="zoom:50%;" />
>
> **如果有新的策略加入，需要改动的地方**
>
> 1. 修改用户UI
> 2. 在StrategyTest::setStrategy()中增加一个策略的选择
> 3. 增加一个Strategy的子类实现新的策略

> 例. Java
>
> - **Strategy**：接口类，定义solve()方法 **[多态]**
>   - **Strategy1**：第一种solve()的实现逻辑，并且solve()的实现逻辑是虚函数 **[虚函数]**
>     - **Implementation1_1**：具体写虚函数的逻辑
>     - **Implementation1_2**：具体写虚函数的逻辑
>   - **Strategy2**：第二种solve()的实现逻辑，并且solve()的实现逻辑是虚函数 **[虚函数]**
>     - **Implementation2**：具体写虚函数的逻辑
>
> <img src="../ScreenShots/Strategy/Strategy_javademo_classdiagram.png" alt="image-20191012164402716" style="zoom:50%;" />

------

## 