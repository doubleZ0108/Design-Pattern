# Singleton

确保class只能生成唯一一个实例，且提供全局访问点

<img src="../ScreenShots/Singleton/uml.jpeg" alt="uml" style="zoom:50%;" />

- **禁止外界创建对象** => 把构造函数设计成private
  - 每当生成一个object时一定有一个ctor被唤醒
- **Singleton class**
  - 有一个静态的自己
  - 通过`Instance()`获取
- 为例节省内存资源、保证数据内容的一致性

> 例. C++
>
> - **每个Singleton都该将以下设置为private**
>   - `Singleton()`
>   - `Singleton(const Singleton&)`
>   - `~Singleton()`
>   - `Singleton& operator=(const Singleton&)`
> - 取用：`Singleton::INstance()`
>
> **第一种Singleton**
>
> - 拥有一个静态的指针，如果该指针未初始化过则new一次，否则直接使用
> - 更漂亮，不需要一个指针，不需要new
>
> ```c++
> static Singleton* pInstance_;
> static Singleton& Instance(){
>   if(!pInstance_){
>     pInstance = new Singleton;
>   }
>   return *pInstance_;
> }
> ```
>
> **第二种Singleton**
>
> - 设置static Singleton变量
>
> ```c++
> static Singleton& Instance(){
>   static Singleton singleton;	//在函数第一次被调用时才产生
>   return singleton;
> }
> ```