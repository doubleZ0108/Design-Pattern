# Abstract Factory

以同一interface创建一整族相关或相依的objects，不需指明各objects真正所属的具体classes

<img src="http://c.biancheng.net/uploads/allimg/181114/3-1Q11416002NW.gif" alt="抽象工厂模式的结构图" style="zoom:50%;" />

- 不真的去new 具体的class，而是使用抽象的父类

- **实例**：跨平台

- **production terminology**

  - **product**: the object being created
  - **factory**: the object that creates other objects
  - factory use **factory method** to create products

- **优**：

  - 将concreate classes隔离开，client使用abstract factory's interface创建产品
  - 易于更替一整租products（只需更换一个concrete factory即可）

- **缺**：

  - 助长了products之间的一致性（用了某个concrete factory就是用了同一族的所有products）
  - 难以支持新品种products（abstract factory interface已写死了能生产的所有products）

- **比较**

  - factory method只考虑生产同等级的产品
  - abstract factory考虑**多等级产品的生产**：*例如农场里既养动物又种植物；电器场既生产电视又生产洗衣机又生产空调；大学既有软件专业又有化学专业*

- 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品

  <img src="http://c.biancheng.net/uploads/allimg/181114/3-1Q1141559151S.gif" alt="电器工厂的产品等级与产品族" style="zoom:50%;" />

  > 例. Java 农场
  >
  > <img src="../ScreenShots/Abstract Factory/example_uml.png" alt="image-20200206112900797" style="zoom:50%;" />
  >
  > **ProductFactory**
  >
  > - `基类``：
  >   - `createFruit()`：指定返回值为Fruit基类，具体生产交由子类实现
  >   - `createVegetable()`：指定返回值为Vegetable基类，具体生产交由子类实现
  > - `SpringProductFactory`：生产Apple + Potato
  > - `SummerProductFactory`：生产Cherry + Tomato
  >
  > **Fruit**
  >
  > - `基类``
  > - `Apple`
  > - `Cherry`
  >
  > **Vegetable**
  >
  > - `基类`
  > - `Potato`
  > - `Tomato`
  >
  > 从逻辑上来讲，春季工厂和夏季工厂都生产蔬菜和水果，只是二者种植的蔬菜和水果种类不同，将他们共同的特点——产品工厂抽象成父类，并在父类中将生产的蔬菜和水果也抽象化。如此一来，可以在具体的产品工厂中指定要生产的蔬菜及水果种类，同时用户可以方便的切换工厂，以生产不同种类的产品。
  >
  > 在该API中，为抽象工厂添加蔬菜仓库和水果仓库，将具体工厂生产的响应产品加入到仓库中，方便管理、并易于用户进行操作（如售卖、食用、种植等）。用户可以动态的更改所选的工厂，如果选择的工厂与之前相同，则继续生产该工厂的产品，并加入之前到仓库中；如果用户更换仓库，则生产不同的产品，并把原工厂生产的产品移动到现在的工厂中，从用户角度看，蔬菜仓库和水果仓库存储的是各个季节的蔬菜水果，既与真实场景相同，又便于管理和用户操作。
  >
  > 该API满足开放闭守原则，如果天天农场打算在秋天额外种植柚子和白菜，只需构建AutumnProductFactory，在工厂中种植Grapefruit和Cabbage，并由用户自己选择秋季工厂，不需要修改工厂的内部实现也不需要增加额外的接口，并且一切选择权交由用户自己决定。