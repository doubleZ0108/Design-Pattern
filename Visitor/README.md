# Visitor

表现object structure中的某个操作，可以定义一个新操作而不需改变其所操作的元素所属的class

- Iterator和Visitor都是在data structure身上进行

  - **Iterator**：逐一取得data structure的元素
  - **Visitor**：逐一对data structure的元素进行某种操作
    - 需要Iterator协助

- Visitor让data structure和operations分离，若要添加新的operations，只需派生新的visitor subclass即可

  > 例. file system
  >
  > `printList()`在Composite时放在File和Directory class内
  >
  > 如果使用Visitor，则把`printList()`做成`ListVisitor`，如果要新增一个operation，再派生一个concrete Visitor subclass即可，数据结构（File和Directory）完全不用改动

- **Visitor的关键**：最可能变动的是algorithm applied over an object structure，element class hierarchy已经稳定，需要添加operations或改变algorithm

  - 数据是稳定的，如果要增加功能需要添加成员函数（违反OCP）
  - 增加功能的时候只要增加visitor
  - 把操作抽出来由访问者代表

- 访问者执行操作  -- 把操作传过去 --> 执行操作的是原始DS

  ​						 <-- 把自己传过去 --

> 例. Java 文件系统
>
> <img src="../ScreenShots/Adaptor/example_uml.jpeg" alt="example_uml" style="zoom:50%;" />
>
> - Composite实现Acceptor接口
>
> - acceptor必须**开放足够多信息**给visitor以便操作（`iterator()`）
>
> - 整个acceptor class只看到抽象的visitor，不会看得到concrete Visitor subclass，因此**它和visitor解耦很成功**；而visitor classes面对所有concrete acceptor classes（File和Directory）
>
> - *Q：File和Directory的`add()`写法完全一样，为什么不提升到Acceptor里？*
>
>   A：二者的this含义不同，调用的是不同的函数
>
> - 通过`someDir.accept(new ListVisitor())`对数据结构进行操作