# Adapter

将一个类的接口转换为客户希望的另外一个接口，解决接口不兼容的问题

- 需要开发的具有某种业务功能的组件在现有的组件库中已经存在，但它们与当前系统的接口规范不兼容，如果重新开发这些组件成本又很高，这时用适配器模式能很好地解决这些问题

- **优**

  - 客户端通过适配器可以透明的调用目标接口
  - 复用了现有的类
  - 将目标器和适配者解耦
  - OCP：只需要增加新的适配器而不需要更改原类

- **实现方式**

  - C++：可定义适配器类同时继承当前系统的业务接口和组件库中的组件接口
  - java：不支持多继承，可以定义一个适配器类实现当前业务的业务接口，同时继承现有组件库中的组件

- **结构**

  - **Target**：系统业务期待的接口
  - **Adaptee**：适配者抽象类
  - **Adapter**：继承适配者，把适配者接口转换为目标接口

- **分类**

  - 类适配器

    <img src="http://c.biancheng.net/uploads/allimg/181115/3-1Q1151045351c.gif" alt="类适配器模式的结构图" style="zoom:50%;" />

  - 对象适配器

    <img src="http://c.biancheng.net/uploads/allimg/181115/3-1Q1151046105A.gif" alt="对象适配器模式的结构图" style="zoom:50%;" />

> 例. Java 电能发动机和光能发动机统一接口给用户
>
> <img src="http://c.biancheng.net/uploads/allimg/181115/3-1Q115104I22F.gif" alt="发动机适配器的结构图" style="zoom:50%;" />
>
> - **Motor**：Target
> - **ElectricMotor**：适配者-电能发动机
> - **OpticalMotor**：适配者-光能发动机
> - **ElectricAdapter**：电能适配器
> - **OpticalAdapter**：光能适配器