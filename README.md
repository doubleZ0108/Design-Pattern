# 设计模式 | Design Pattern

Table of Contents
=================

   * [设计模式 | Design Pattern](#设计模式--design-pattern)
     * [关于作者 | About the Auther](#关于作者--about-the-auther)
     * [笔记 | Note](#笔记--note)
     * [代码 | Code](#代码--code)
     * [项目结构 | Project Structure](#项目结构--project-structure)

------

## 关于作者 | About the Auther

| 姓名 \| Name:bust_in_silhouette: | 张喆 \| doubleZ          |
| -------------------------------- | ------------------------ |
| 学校 \| University:school:       | 同济大学 \| Tongji Univ. |
| 联系方式 \| Email:email:         | doubleZ0108@163.com      |





## 笔记 | Note

[设计模式笔记(完整版) | Design Pattern Notes(full version)](https://github.com/doubleZ0108/Design-Pattern/blob/master/doc/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.pdf)





## 代码 | Code

- [单例模式 | Singleton](https://github.com/doubleZ0108/Design-Pattern/tree/master/Singleton)
- [原型模式 | Prototype](https://github.com/doubleZ0108/Design-Pattern/tree/master/Prototype)
- [工厂方法 | Factory Method](https://github.com/doubleZ0108/Design-Pattern/tree/master/Factory%20Method)
- [抽象工厂模式 | Abstract Factory](https://github.com/doubleZ0108/Design-Pattern/tree/master/Abstract%20Factory)
- [建造者模式 | Builder](https://github.com/doubleZ0108/Design-Pattern/tree/master/Builder)
- [代理模式 | Proxy](https://github.com/doubleZ0108/Design-Pattern/tree/master/Proxy)
- [适配器模式 | Adapter](https://github.com/doubleZ0108/Design-Pattern/tree/master/Adapter)
- [桥接模式 | Bridge](https://github.com/doubleZ0108/Design-Pattern/tree/master/Bridge)
- [装饰器模式 | Decorator](https://github.com/doubleZ0108/Design-Pattern/tree/master/Decorator)
- [外观模式 | Facade](https://github.com/doubleZ0108/Design-Pattern/tree/master/Facade)
- [享元模式 | Flyweight](https://github.com/doubleZ0108/Design-Pattern/tree/master/Flyweight)
- [组合模式 | Composite](https://github.com/doubleZ0108/Design-Pattern/tree/master/Composite)
- [模板方法 | Template Method](https://github.com/doubleZ0108/Design-Pattern/tree/master/Template%20Method)
- [策略模式 | Strategy](https://github.com/doubleZ0108/Design-Pattern/tree/master/Strategy)
- [命令模式 | Command](https://github.com/doubleZ0108/Design-Pattern/tree/master/Command)
- [责任链模式 | Chain of Responsibility](https://github.com/doubleZ0108/Design-Pattern/tree/master/Chain%20of%20Responsibility)
- [状态模式 | State](https://github.com/doubleZ0108/Design-Pattern/tree/master/State)
- [观察者模式 | Observer](https://github.com/doubleZ0108/Design-Pattern/tree/master/Observer)
- [中介者模式 | Mediator](https://github.com/doubleZ0108/Design-Pattern/tree/master/Mediator)
- [迭代器模式 | Iterator](https://github.com/doubleZ0108/Design-Pattern/tree/master/Iterator)
- [访问者模式 | Visitor](https://github.com/doubleZ0108/Design-Pattern/tree/master/Visitor)
- [备忘录模式 | Memento](https://github.com/doubleZ0108/Design-Pattern/tree/master/Memento)
- [解释器模式 | Interpreter](https://github.com/doubleZ0108/Design-Pattern/tree/master/Interpreter)
- [引用计数 | Reference Counting](https://github.com/doubleZ0108/Design-Pattern/tree/master/Reference%20Counting)
- [写时拷贝 | Copy on Write](https://github.com/doubleZ0108/Design-Pattern/tree/master/Copy%20on%20Write)
- [共享机制 | Shareable](https://github.com/doubleZ0108/Design-Pattern/tree/master/Shareable)





## 项目结构 | Project Structure

```
.
├── Abstract Factory
│   ├── AbstractFactoryDemo.java
│   ├── Fruit.java
│   ├── ProductFactory.java
│   ├── README.md
│   └── Vegetable.java
├── Adapter
│   ├── Adaptee.java
│   ├── AdapterDemo.java
│   ├── ClassAdapterDemo.java
│   ├── ObjectAdapterDemo.java
│   ├── README.md
│   └── Target.java
├── Bridge
│   ├── BridgeDemo.java
│   ├── README.md
│   ├── Stack.java
│   └── StackImpl.java
├── Builder
│   ├── BuilderDemo.java
│   └── README.md
├── Chain of Responsibility
│   ├── ChainofResponsibilityDemo.java
│   └── README.md
├── Command
│   ├── BeforeCommand.h
│   ├── Command.h
│   └── README.md
├── Composite
│   ├── Composite.h
│   ├── CompositeDemo.java
│   └── README.md
├── Copy on Write
│   ├── CopyOnWrite.h
│   └── README.md
├── Decorator
│   ├── DecoratorDemo.java
│   └── README.md
├── Facade
│   ├── FacadeDemo.java
│   └── README.md
├── Factory Method
│   ├── FactoryMethod.h
│   └── README.md
├── Flyweight
│   ├── FlyWeightDemo.java
│   ├── README.md
│   └── data
│       ├── 1.txt
│       ├── 2.txt
│       ├── 3.txt
│       ├── 4.txt
│       ├── 5.txt
│       ├── 6.txt
│       ├── 7.txt
│       ├── 8.txt
│       └── 9.txt
├── Interpreter
│   ├── InterpreterDemo.java
│   ├── JepDemo.java
│   └── README.md
├── Iterator
│   ├── Iterator.h
│   ├── IteratorDemo.java
│   └── README.md
├── Mediator
│   ├── MediatorDemo.java
│   └── README.md
├── Memento
│   ├── Memento.h
│   └── README.md
├── Observer
│   ├── Observer.h
│   ├── ObserverDemo.java
│   └── README.md
├── Prototype
│   ├── Property.h
│   ├── README.md
│   ├── image.h
│   ├── imagetype.h
│   ├── landsatimage.h
│   ├── portimage.h
│   └── sportimage.h
├── Proxy
│   ├── ProxyDemo.java
│   └── README.md
├── README.md
├── Reference Counting
│   ├── README.md
│   ├── ReferenceCounting.h
│   └── myString.h
├── Shareable
│   ├── README.md
│   └── Shareable.h
├── Singleton
│   ├── README.md
│   └── Singleton.h
├── State
│   ├── Context.java
│   ├── README.md
│   ├── State.java
│   └── StateDemo.java
├── Strategy
│   ├── README.md
│   ├── Strategy.h
│   └── StrategyDemo.java
├── Template Method
│   ├── README.md
│   ├── TemplateMethod.h
│   └── TemplateMethodDemo.java
├── Visitor
│   ├── Acceptor.java
│   ├── README.md
│   ├── Visitor.java
│   └── VisitorDemo.java
├── doc
│   ├── 设计模式.md
│   └── 设计模式.pdf
└── main.cpp

28 directories, 91 files
```

