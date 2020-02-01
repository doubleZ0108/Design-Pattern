# Prototype

也是一种**共享**，用的时候不是直接共享原型，而是copy一份原型来创建objects

- 共享就一定要有一个**控制中心**
- 做第一个东西的时候很花时间，因此想只做一次，把它变成原型；以后再用直接memcpy就可以了

<img src="../ScreenShots/Property/property_uml.png" alt="property_uml" style="zoom:33%;" />

<img src="../ScreenShots/Property/property_uml.png" alt="property_uml" style="zoom:33%;" />

- 子类有一个静态的自己，并在ctor时调用父类的`add()`，把自己放到容器里
- 客户端还什么都没做就已经初始化好这些东西了，用的时候不能new(ctor是private)，用的时候`clone()`一个

> 例. C++
>
> <img src="../../../../document/软件架构与设计模式/ScreenShots/Property/example_uml.png" alt="image-20200201162719996" style="zoom:50%;" />
>
> - **如果一个class要做父类，它一定要有virtual dtor**
> - 基类有个容器承装子类
> - 子类不对外提供new的接口，而是自己里面有自己这个对象，在这唯一的对象创建时调用private的ctor
> - 外界要创建的时候调用`clone()`进行memcpy
> - 添加新的image drived classes时，只需修改application端的`input`

