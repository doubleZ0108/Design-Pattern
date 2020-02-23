# Observer

pubish-subscribe 发行-订阅

在objects之间定义“一对多”的依存体系，使得当某个objec(Subject)t改变自身状态时，其他所有依存者都会被通知到并自动被更新

> 定义了一个“图书馆”Subject，和许多“读者”Observers，当某个读者更改了图书馆的数据时，图书馆可以法通知给其他所有的读者，让所有读者都更新的数据

- Observer是被动获得通知，而非主动观察
- Subject应该有
  - 注册()
  - 注销()
  - 通知()
  - 通知所有()
  - 一个容器存放所有的Obversers
- Observers应该有一个同名函数Update：用于让自己订阅的Subject更新自己
- **OCP：**添加Observer不需要修改Subject内部

<img src="../ScreenShots/Observer/Observer_principle.png" alt="image-20191015195451730" style="zoom:50%;" />

> 例. java
>
> - **Subject**
>   - **obs:Vector:** 存放所有观察者
>   - **setHint(Observer o, Object hint):** 根据Observer传入的hint修改自身信息，并广播给其他所有观察者
> - **Observer**
>   - **update(Object sender, Object hint)：**双方握手🤝说好调用update()
>     - **sender:Object:** 指定是谁把信息发送给的Subject，如果为null则表示Subject主动发送的通知
>     - **hint:Object:** 用作hint，跟应用有关，可以是任意类型*(因为这里是Object类型)*
>   - **sendMyData():** 将自身信息发送给自己的Subject，请求Subject更新自身数据并广播给所有其他观察者
>
> <img src="../ScreenShots/Observer/Observer_javademo_UML.png" alt="image-20191016092906646" style="zoom:50%;" />

> 例. C++ MFC
>
> MFC中是以view作为document的user interface，对document的任何操作一定是通过view来完成的
>
> 某一个view修改了document，document通知给其他所有用户进行修改
>
> <img src="../ScreenShots/Observer/Observer_cppdemo.png" alt="image-20191016093733074" style="zoom:50%;" />

> 例. C++
>
> - 调用Subject的`updateValue()`意味着数据有变化 -> 通知所有Observers
>
> <img src="../ScreenShots/Observer/Observer_cppdemo_UML.png" alt="image-20191016155341753" style="zoom:50%;" />