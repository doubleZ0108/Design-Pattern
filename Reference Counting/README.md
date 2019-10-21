# Reference Counting

使多个等值的objects共享同一个值

1. 简化heap objects的记录工作：使用Reference Counting之后，object便拥有自己，一旦不再有任何人使用它，它便自行摧毁自己（Garbage Collection的简单模型）

>  一旦某个object以new的方式分配出来，记录其拥有者是件重要的是，因为只有他才有责任删除该object，但是某个函数调用中这个objects可能被移除

2. 让所有等值objects共享一份数值，不仅节省memory，也加速运行（因为不再需要构造和析构同值objects的多余附件）

> 如果许多objects有相同值，存放多次是件愚蠢的事

- 共享：发生copy的时候才能共享
  - =：赋值
  - pass by value
  - return by value

> 例. myString实现
>
> **【基础方法】**
>
> - 类中属性有指针，一定要写Big3
>
>   - 拷贝构造: myString(const myString &);
>   - 拷贝赋值: myString& operator=(const myString &);
>   - 析构函数: ~myString();
>
> - 拷贝赋值
>
>   - 要检测自我赋值
>
> ```c++
> if(this == &str){
> return *this;
> }
> ```
>
>   - 要提供三种overwrite
>
> ```c++
> myString& operator=(const myString& str);	//解决赋值对象
> myString& operator=(const char *cstr);		//解决赋值字符串
> myString& operator=(char ch);							//解决赋值字符
> ```
>
> 这样可解决连续赋值
>
> ```c++
> myString a, b, c, d;
> a = b = c = d = "hello";
> ```
>
> <img src="../ScreenShots/Reference Counting/Basic_myString.jpeg" alt="Basic_myString" style="zoom: 33%;" />
>
> ------
>
> **【引入Reference Counting】**
>
> <img src="../ScreenShots/Reference Counting/ReferenceCounting_myString.jpeg" alt="ReferenceCounting_myString" style="zoom:50%;" />
>
> - 引入一个`Reference Counter`（不改变原本设计，就不可能添加`Reference Counting`功能）
>
> - `shared_ptr`：不改变`String`本身，用一个外套（模板）套上去
>
> ```C++
> std::shared_ptr<string>
> ```
>
> - 在`myString`内部封装结构体`StringValue`
>
>   - 引用计数器`refCount`
>   - 真实字符串数据
>
> - 在`StringValue`外部(String内)定义指针指向内部的结构体
>
> - **构造函数:** 
>
>   - 首先调用`myString()`: 初始化指向`StringValue`的指针`value`
>   - 调用`StringValue()`: 
>     - 引用计数器置为1: *<u>这是构造函数, 能调用到这里的一定是通过原始字符串定义的, 引用计数都应该初始化为1</u>*
>     - 填充内部的字符串数据
>
> - **析构函数:**
>
>   1. 首先调用`~myString()`
>   2. 当引用计数器归零时调用`~StringValue()`
>
> - **拷贝共享:**
>
>   - `copy constructor`
>
> ```c++
> /* 调用实例 */
> myString s1("hello");
> myString s2(s1);
> ```
>
> ```C++
> myString::myString(const myString& rhs)
> 	: value(rhs.value)
> {
> 	++value->refCount;		//因为这是构造函数,只可能在刚刚创建一个新的变量时才可能被调用,所以不用做相等检测和释放原来的value
> }
> ```
>
>   - `copy assignment operator`
>
> ```c++
> /* 调用实例 */
> myString s1("hello");
> myString s2 = 21;
> ```
>
> ```c++
> myString& myString::operator=(const myString& rhs)
> {
>   if (value == rhs.value) {
>       return *this;
>   }
> 
>   if (value && --value->refCount == 0) {
>       delete value;
>   }
> 
>   value = rhs.value;		//二者的类型都是指针
>   ++value->refCount;		//递增this->value的refCount, rhs.value的refCount也同步变化
>   return *this;
> }
> ```
>
> <img src="../ScreenShots/Reference Counting/ReferenceCounting_myString2.jpg" alt="ReferenceCounting_myString2" style="zoom:50%;" />
>
>   > **此时无法解决的问题**
>   >
>   > 如果有多个`objects`初始值相同, 同样会重复占用内存
>   >
>   > ```c++
>   > myString s1("hello");
>   > myString s2("hello");
>   > ```
>   >
>   > 可以在构造函数中维护一个`lookup table`(存放所有出现过的初值), 但是成本太高
>
>   > **小知识点**
>   >
>   > ```c++
>   > myString s1 = "hello";		//唤起的是 myString(const char* cstr) 构造函数
>   > ```

​	