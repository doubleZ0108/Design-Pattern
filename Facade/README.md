# Facade

为多个复杂的子系统提供一个统一的接口

<img src="http://c.biancheng.net/uploads/allimg/181115/3-1Q115152143509.gif" alt="外观模式的结构图" style="zoom: 50%;" />

- 降低子系统和客户端之间的耦合度，使得子系统变化不会影响调用他的客户端
- 对客户屏蔽了子系统
- 降低了大型软件的编译依赖性，简化系统的跨平台移植过程（编译一个子系统不影响其他子系统）

> 例. Java
>
> **Facade**
>
> - subsystem1
> - subsystem2
> - subsystem3
> - `method()`
>
> **Subsystem1**
>
> **Subsystem2**
>
> **Subsystem3**