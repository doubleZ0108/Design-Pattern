# Template Method

定义算法骨干(skeleton)，推迟其中某些步骤让他们在subclass中才能真正的完成

这使得subclass能够重新定义算法内的某些步骤，而不需改变算法的架构

<img src="../ScreenShots/Template Method/uml.jpeg" alt="uml" style="zoom: 33%;" />

- **表现手法：**virtual function
  
- Template Method是利用继承来改变函数的行为，在<u>base class指定行事大纲，在subclass中指定具体的行为</u>
  
  - 固定不变的抽象概念：每次都必须执行这几个步骤
  - **一组无限可能的行为：**子类可以无限多（每一个子类只定义一个行为而已）
  
- 用**虚函数**可以实现调用用户自己写的东西

- 频繁的使用在**application framework**上
  
  - Windows的程序打开文件框都是一致的，都是调用了MFC的这部分代码
  
- 不同语言比较

  | java               | C++                 |
  | ------------------ | ------------------- |
  | 所有方法都是虚函数 | 必须要明确写virtual |

> 例. MicroSoft打开文件时共有七个步骤
>
> 1. 拉下Menu
> 2. 弹出对话框
> 3. 用户输入文件名
> 4. 检查文件名
> 5. 搜索文件
> 6. 打开file
> 7. Serialize
>
> 算法骨干1～6已经被实现好了，只有7没法提前给你做（微软在写这个函数的时候并不知道你的东西长什么样，没办法写好，留一个虚函数给你），你只需要自己实现7就好，算法的架构（开启文件永远是1～7）不会变
>
> <img src="../ScreenShots/Template Method/example1.png" alt="image-20191011093235087" style="zoom:50%;" />
