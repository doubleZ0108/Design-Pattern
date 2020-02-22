# Decorator

不改变现有对象结构的情况下，动态的给该对象增加一些额外的功能

<img src="http://c.biancheng.net/uploads/allimg/181115/3-1Q115142115M2.gif" alt="装饰模式的结构图" style="zoom:50%;" />

- 采用装饰模式扩展对象的功能比采用继承方式更加灵活
- 通常扩展一个类的功能会使用继承方式，但继承具有静态特性，耦合度高，并且随着扩展功能的增多，子类会膨胀；这时使用组合关系创建装饰对象包裹真实对象，<u>并在保持真实对象的类结构不变的前提下，为其提供额外的功能</u>

> 例. Java
>
> **Component**：抽象构建
>
> - `abstract operation()`
>
> **ConcreteComponent**：实现抽象构建，通过装饰角色为其添加一些职责
>
> - `operation()`
>
> **Decorator**：继承抽象构建，并包含具体构建的实例
>
> ```java
> Component component;
> void operation(){
>   component.operation();
> }
> ```
>
> **ConcreteDecorator**：实现抽象装饰的方法，并给具体构建对象添加附加的责任
>
> ```java
> void operation(){
>   super.operation();
>   //TODO
> }
> ```
>
> > **个人理解**：是对原class的装饰，比如原class是一个人，可以通过引入Decorator类对其增加换装的功能，在使用的时候直接使用装饰对象即可