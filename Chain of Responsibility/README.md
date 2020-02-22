# Chain of Responsibility

为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一个对象记住下一个对象的引用而形成一条链；当有请求发生时，将请求沿着这条链传递下去

- **例**：员工请假，可批假的领导有部门负责人、副总经理、总经理等，但每个领导能批准的天数不同，员工需要根据自己的情况找不同的领导签字

- **优**

  - 客户只需将请求发送到责任链上即可，无需关心请求的处理细节和传递过程等，<u>实现发送者和处理者的解耦</u>（事实上发送者根本不知道是哪个处理者处理自己的）
  - OCP：有新的业务添加新的请求处理类
  - 工作流程发生变化时，可以动态改变链内成员或者调动次序

- **缺**

  - 不能保证每个请求一定被处理
  - 系统的瓶颈

- **结构**

  - **Handler**：处理请求接口（抽象处理方法/后继连接）
  - **Concrete Handler**：具体处理方法
  - **Client**：创建处理链；向链头提交请求

  <img src="http://c.biancheng.net/uploads/allimg/181116/3-1Q116135Z11C.gif" alt="责任链模式的结构图" style="zoom:50%;" />

  <img src="http://c.biancheng.net/uploads/allimg/181116/3-1Q11613592TF.gif" alt="责任链" style="zoom:50%;" />

> 例. Java
>
> **Client**
>
> ```java
> /* 组装责任链 */
> Handler handler1 = new ConcreteHandler1();
> Handler handler2 = new ConcreteHandler2();
> handler1.setNext(handler2);
> 
> /* 提交请求 */
> handler1.handleRequest("two");      //向头发请求
> ```
>
> **Handler**
>
> ```java
> void handleRequest(/*请求*/){
>   if(/*自己能处理*/){
>   }else{
>     if(getNext()!=null){
>       getNext().handleRequest(/*请求*/);
>     }else{
>       /*没有人处理该请求*/
>     }
>   }
> }
> ```