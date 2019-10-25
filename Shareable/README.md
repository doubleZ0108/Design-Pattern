# Shareable

> 例. 此时无法解决的问题
>
> ```c++
> myString s1 = "hello";
> char *p = &s1[1];
> myString s2 = s1;
> *p = 'x';		//同时修改s1和s2
> ```
>
> 此时无法知道“目前存在一个ptr(一种handle)指向s1”

> 解决方法
>
> **【引入shareable】**
>
> 为每个StringValue object加上一个flag，只是可否被共享
>
> - 初始化为<u>可共享</u>
> - 一旦有non-const operator[]作用其上，悲观的假设它是被用来取handle的，把flag设为<u>不可共享</u>
>
> 1. StringValue增加一个属性bool shareable
>
> 2. StringValue::constructor 中将shareable初始化为true
>
> 3. String::copy constructor中根据shareable判断copy方式
>
> ```java
> myString::myString(const myString& rhs)
> {
>   if(rhs.value->shareable){
>     value = rhs.value;
>     ++value->refCount;
>   }
>   else{
>     value = new StringValue(rhs.value->data);
>   }
> }
> ```
>
> 4. String::non-const operator[] 中令value->shareable = false
>
> 5. String::所有其他member functin(例如operator=)都检查可共享位
