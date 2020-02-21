## Factory Method

也称Object Factory, Virtual Constructor，一种Template Method，用于生产产品时

定义一个creating object的界面，但是让subclass决定最终要实例化哪个class。将实例化动作**推迟**到子类进行。

- 你用Application Framework并不是直接new里面的类，通常Application Framework中的类有很多virtual function，使用的时候需要继承Application Framework中的class，实现自己的功能，new的是自己写的类

> 例. C++
>
> **【Framework】**
>
> - **App:** 
>
>   - `CreateDocument()`: 返回值尽量模糊，因为new的是用户的应用
>
> Framework无法预知将要产生那种document object，**所以利用Factory Method将动作推迟到subclass中**。subclass谓语Application层次，必定能知道要产生哪种类型的document
>
>     > 由于Framework无法知道document的确切类型，所以宣告type时必须足够模糊、泛化 -> 选择基类的Document是最保险的方法
>
>   - `NewDocument()`：这个函数所要做的动作其实是固定下来的，不涉及到new哪个Document的问题，因此把new的动作封装成虚函数放到`CreateDocument()`里，这个方法就可以固定下来了
>
> - **Document:** 
>
> ------
>
> >**【Application】**
>
> 用户级别，myApp和myDoc同时存在，myApp知道myDoc的确切名字
>
> myApp和myDoc是同一个人实现的，因此彼此耦合是ok的
>
> - **myApp** 
> - **myDoc** 
>
> <img src="../ScreenShots/Factory Method/factorymethod_cppdemo_UML.JPG" alt="factorymethod_cppdemo_UML" style="zoom:50%;" />