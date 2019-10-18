# Flyweight

享元，将**细粒度**object进行**共享**

- **细粒度：**不是细粒度可能没法跟别人分享（带着一堆其他信息，没法共享）
- 重要的是flyweight你怎么设计细分
- 把可共享的数据放在享元里；不可共享的独立出去

<img src="../ScreenShots/Flyweight/Flyweight_main.jpeg" alt="Flyweight_main" style="zoom:50%;" />

- **Flyweight Factory：**作为Flyweight的interface，用来维护flyweight objects，并负责分配给client

> 例. java
>
> - **BigChar:** fine-grained objects & **Flyweight objects**
>   - BigChar(): 创建大字（从文件读入）
>   - print()：输出大字
> - **BigCharFactory:** flyweight工厂**（控制中心）** **「Singleton」**
> - **BigString:** 
>   - BigString: 通过工厂获取共享元素，而不是每次new
>     - 每次new就失去了控制，没法sharing
>
> > 工厂的设计已经很规范了，重要的是BigChar的设计，究竟应该包含写什么内容需要自己权衡
> >
> > 如果大字还有颜色、大小、字体等属性，把他们都封装进BigChar中也可以进行Flyweight，取决于自己的设计
>
> <img src="../ScreenShots/Flyweight/Flyweight_javademo_UML.jpeg" alt="Flyweight_javademo_UML" style="zoom:50%;" />