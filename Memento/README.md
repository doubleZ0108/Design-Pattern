# Memento

不违背封装原则而捕获object的internal state，使object日后得以恢复该状态（snapshot）

<img src="../ScreenShots/Memento/uml.png" alt="image-20200203230541424" style="zoom:50%;" />

- **undo**：恢复状态
  - 不能理解为反操作，比如画了一个矩形，undo的时候用透明颜色填充，只是视觉上恢复了，但是矩形的这个数据还存储着
- **redo**：重新执行command
- memento是object，它存储了另一个object内部状态的一份快照，undo机制会向originator请求一个memento，originator以足以代表当前状态的信息来初始化memento
  - originator将自己恢复原状态所需的信息托付给其他object而不暴露其内部结构和表示

> 例. C++ undo/redo
>
> <img src="../ScreenShots/Memento/example_uml.jpeg" alt="example_uml" style="zoom:50%;" />
>
> `class Memento`：类似于一张快照，储存拍摄时的状态（数据信息）
>
> - 将Number设置为friend，记录了Originator的state而又不影响封装性（通过friend和private）
>
> `class Number`：要进行备忘录的数据结构
>
> - **Number的身份**
>   - Receiver (in Command)
>   - Originator (int Memento)
> - `createMemento()`：对数据结构拍摄一张快照
> - `reinstateMemento()`：通过快照恢复当时的状态
>
> `class Command`: 使用Command设计模式，将method抽取出来
>
> - `excute()`：执行操作前先记录一个memento和一个command
> - `undo()：`取出last command，用其储存的receiver唤起reinstateMemento()，并用last memento为参数，恢复origin state
> - `redo()`：取出current command，用其储存的receiver唤起action()