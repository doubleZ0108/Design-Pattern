# Proxy

为object提供一个代理人，用以控制对该object的访问（有些情况下，client不能或不想直接访问另一个对象，这时需要找一个中介帮忙完成）

<img src="../ScreenShots/Proxy/uml.png" alt="image-20200206135844378" style="zoom:50%;" />

- `RealSubject`: 实现例抽象Subject的具体业务，是**最终要引用的对象**
- `Proxy`:提供了与RealSubject相同的接口，内部含有对RealSubject对引用

- **优**
  - 保护目标对象
  - 代理可以扩展目标对象的功能
  - 解耦客户端与目标端
- **缺**
  - 增加一层代理，会使处理速度变慢
- **应用场景**：
  - **远程代理**
  - **虚拟代理**：创建目标对象开销比较大时，例如，下载一个很大的视频时，可以效用小比例的虚拟代理替换真实的对象，消除用户对服务器慢点感觉
  - **安全代理**
  - **延迟加载**：提高系统的性能，延迟对目标加载

> 例. Java
>
> **abstract Subject**：抽象Subject
>
> **RealSubject**：真实要访问的Subject
>
> **Proxy**：代理人
>
> - 提供与RealSubject相同的接口
>
> - 在内部拥有一个RealSubject对象
>
> - 进行预处理和后续处理
>
>   ```java
>   preRequest();
>   realSubject.Request();
>   postRequest();
>   ```