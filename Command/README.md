# Command

将repuest(成员函数)分装成object，使得可以用不同的requests将client参数化；或将requests放进queue中，用以支持udno操作

- `object.memberFunction(...)`：将object和member function分装成一个东西
- 函数指针

<img src="../ScreenShots/Command/uml.png" alt="image-20200203153921351" style="zoom:50%;" />

> 例. C++
>
> **Before**
>
> - 在原始class中有一个成员为type，通过type指示日后要执行哪个method
> - 如果扩展了成员方法，那还要增加if判断type是否匹配
>
> **After**
>
> - 不需要用type指明将来要执行哪个method，只需创建Command object时指定即可
>   - 有新的方法，只需创建新的Command object
> - Command把Giant和复合Action type的操作包裹起来
> - `typedef void(AfterGiant::*Action)()`：pointer to member function
>   - 指向Giant的成员函数
>   - `()`说明指向的是没有参数的member function
> - `execute()`：每个object只需执行相同的函数，不需要判断该元素的type
>
> **区别**
>
> - before：存储的是Giant object，取出后，根据它存储的type决定调用哪个方法
> - after：存储的是Command object（内含一个Giant object和一个Giant method），取出后不必判断type（根本没携带type），只需要调用Command提供的method即可

