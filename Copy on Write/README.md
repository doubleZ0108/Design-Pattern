# Copy on Write

在write的时候copy一份出来，防止共享内容的其他对象受到影响

- C++编译器无法告诉我们operator[]是被用于write还是read（[]作用完才知道是write还是read）
- 只好悲观保守的假设non-const operator[]都用于write，在用户可能改的所有地方都是用COW

> **C++ operator[]调用说明**
>
> - 两个重载下标运算符的**函数签名**不同，所以是正确的overloading
>   - 函数的<u>return type</u>不属于签名部分
>   - 函数的<u>const性</u>属于签名部分
> - const object一定调用const function，如果没有，编译出错
> - non-const object调用non-const function，除非没有non-const function，只好调用const function
>
> ```c++
> class myString{
> public:
>   const char& operator[](int index) const;		//@1 针对const myString
>   char& operator[](int index);								//@2 针对non-const myString
> };
> ```
>
> ```c++
> /* 使用 */
> const myString cstr = "hello";
> cout << cstr[2];		//调用@1
> cstr[1] = 'A';			//编译错误，operator[]返回const char& 不可被修改
> 
> myString str = "world";
> cout << str[2];				//调用@2 read
> str[1] = 'O';				//调用@2 write
> ```
>
> > Q. 如果定义const object，但是没提供const的function会发生什么？
> >
> > A. 编译出错
>
> > Q. 有没有可能non-const object唤起const function
> >
> > A. 如果只有const function时，non-const object可以唤起它。单只要non-const function存在时，non-const object唤起的一定是non-const function
>
> > Q. 为什么non-const object一定会调non-const function，除非只有const function
> >
> > A. non-const object调non-const function；const object调const function
>
> > Q. 为什么const object调用non-const function是*<u>编译器</u>*所不允许的？
> >
> > A. 【zz自己想的】编译器吧函数的入口地址放进去的时候就发现这个地址的函数是non-const的，即使你的non-const function没修改任何东西（compiler不会看那么多），也是不被允许的，它认为你只要没声明为const function，就存在着改的风险，这是绝对禁止的
>
> > Q. non-const object即使只读还是会COW？
> >
> > A. 没法尽善尽美，提供中间层总会是灵丹妙药



> 例. myString实现
>
> **【引入COW】**
>
> ```c++
> const char& myString::operator[](int index) const
> {
>   return value->data[index];      //这是const object唤起的const function，一定不会改动，即使很多人共享，也不用考虑COW
> }
> 
> char& myString::operator[](int index)
> {
>   /* 悲观的假设每次都用于写 */
>   if(value->refCount > 1){    //如果这个object是和其他人共享的，复制一份COW
>     --value->refCount;      //自己被分割出去，所以引用减少一个
>     value = new StringValue(value->data);   //用之前的data创建新的value
>   }
> 
>   return value->data[index];      //此时的myString是一个绝对未被共享的
> }
> ```
>
> <img src="../ScreenShots/Copy on Write/CopyOnWrite_example.jpeg" alt="CopyOnWrite_example" style="zoom:50%;" />

------

​	