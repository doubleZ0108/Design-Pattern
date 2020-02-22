# Mediator

定义一个中介对象封装一系列对象之间的交互

- 将“网状结构”转为“星型结构”（一对多转变为一对一）
- 原有对象之间可以解耦，且可以独立的改变它们之间的交互
- 但是中介者的职责可能过大，导致系统难以维护

<img src="http://c.biancheng.net/uploads/allimg/181116/3-1Q1161I532V0.gif" alt="中介者模式的结构图" style="zoom:50%;" />

> 例. Java
>
> **Mediator**
>
> - `abstract register(colleague)`：注册
> - `abstract relay(colleague)`：转发同事的信息给其他所有同事
>
> **Concrete Mediator**
>
> - `register()`：在自己的仓库(用来管理Colleague)里存下这个人；指定这个人的中介是自己
>
> **Colleague**
>
> - 保存一个Mediator对象
> - `abstract receive()`
> - `abstract send()`
>
> **Concrete Colleague**
>
> - `send()`： 请求中介者发送，调用Mediator的`relay(this)`，参数是自己