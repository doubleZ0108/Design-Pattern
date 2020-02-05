# Builder

将complex object的construction从其representation分离出来，使得相同的construction process可以创建不同的representation

- 生产某个产品需要一系列步骤
- 每个步骤可以有不同的花样

> 例. Java 做pizza
>
> <img src="../ScreenShots/Builder/example_uml.jpeg" alt="example_uml" style="zoom:50%;" />
>
> **Product**
>
> - **属性**
>   - dough
>   - sauce
>   - topping
>
> **Builder**
>
> - 基类里有一个product
> - 子类完成对product对一系列做法
> - **属性**：pizza
> - **方法**：
>   - `getPizza()`
>   - `createNewPizza`
>   - `buildDough()`
>   - `builderSauce()`
>   - `builderTopping()`
>
> **Director**
>
> - **职责**
>   - 提供方法设定builder
>   - 完成有一系列步骤对construction
>   - 供用户取得product
> - **属性**：pizzaBuilder
>   - 使用基类的指针，在运行时可以动态切换builder
> - **方法**：
>   - `setPizzaBuilder()`
>   - `getPizza()`
>   - `constructPizza()`

