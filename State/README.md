# State

允许object在内部state有变化时改变其行为，就好像其class也随之改变一样

<img src="../ScreenShots/State/uml.png" alt="image-20200206141930839" style="zoom:50%;" />

> 例. Java 白天/夜晚
>
>  * 金库：白天正常使用，夜晚通知保安
>  * 电话：白天呼叫保安，夜晚监听异常
>  * 警铃：白天或夜晚都通知保安
>
> <img src="../ScreenShots/State/example_uml.jpeg" alt="example_uml" style="zoom:50%;" />
>
> **Context**：负责State的管理
>
> - **SafeFrame**：派生出的安全系统
>
> **State**
>
> - **DayState**
> - **NightState**
>
> 不使用State设计模式的话，直接在SafeFrame的每个方法中判断时间，以决定接下来的执行逻辑，难以进行扩展，如果有更多的时间段划分，需要增加else判断
>
> 而加入State设计模式后，SafeFrame中的方法调用其内成员变量state所拥有的方法进行处理（处理时是在state的方法内部回调SafeFrame的方法，因为只有SafeFrame才提供方法，state只是使用接口），并在Context中动态切换state所指向的子类
>
> 如果要新增加时间段，只需在State的基础上派生子类完成基类的方法即可