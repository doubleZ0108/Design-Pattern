# Bridge

将abstraction和implementation解耦，使二者可以独立变化

- **Abstraction**：功能性class hierarchy
  - 在subclass要为base class 添加新功能
- **Implementation**：创作型class hierarchy
  - subclass要为base class's abstract method给出具体实现

<img src="../ScreenShots/Bridge/uml.jpeg" alt="uml" style="zoom:50%;" />

- 隔离了Abstract hierarchy和Implement hierarchy
- 如果要添加新功能：在Abstract hierarchy中派生新的subclass
- 如果要更新版本（更新底部实现、GUI等）：在Implement hierarchy中派生新的subclass
- 由于Abstract hierarchy内的methods所用的都是Implementor的abstract method，所以两个继承体系彼此不影响（因为interface无变化）

> 例. java 栈
>
> <img src="../ScreenShots/Bridge/example_uml.jpeg" alt="example_uml" style="zoom:50%;" />
>
> **Stack**
>
> - **StackHanoi**：在栈的基础上添加Hanoi的规则
> - **StackFIFO**：在栈的基础上添加FIFO访问顺序
>
> **StackImpl**
>
> - **StackArray**：底层是数组实现的栈
> - **StackList**：底层是链表实现的栈
>
> ------
>
> - 客户端在使用的时候不对它暴露implementation hierarchy