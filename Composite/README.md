# Composite

将objects复合成树状结构(只是个说法，不是真正的树)，让clients得以一致方式对待“个别物”和“合成物”

- **常见例子**
  - File system：directory里有许多files，但二者被一视同仁
  - 每一个视窗还可以再开视窗
- **Composite**：对内容和容器一视同仁
- **Decorator**：对内容和经过装饰的内容一视同仁

> 例. Java文件系统
>
> <img src="../ScreenShots/Composite/example_java_uml.jpeg" alt="example_uml" style="zoom:50%;" />
>
> - **基类Entry**：
>   - `add()`：只有directory才能add，为什么这个方法要放在基类中？因为既可以add file，也可以add directory，二者被一视同仁；否则当面对一个entry object时要先判断它是一个file还是一个directory，是directory才可以add
> - **子类File**
> - **子类Directory**：
>   - `Vector<Entry>`：由于directory中既可以有file又可以有directory，所以设计一个父类
>   - `getSize()`：在基类中被设置为虚函数（多态）
>   - `add()`：既然有容器，肯定有add能把东西放进来

> 例. C++
>
> <img src="../../../../document/软件架构与设计模式/ScreenShots/Composite/example_cpp_uml.jpeg" alt="example_uml" style="zoom:50%;" />
>
> <img src="../ScreenShots/Composite/example_cpp.jpeg" alt="example_cpp" style="zoom:33%;" />

------

