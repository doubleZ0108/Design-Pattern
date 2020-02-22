# Interpreter

给分析对象定义一个语言，并定义该语言的文法表示，再设计一个解释器来解释语言中的句子

- 实现了文法表达式处理的接口，该接口解释一个特定的上下文
- 软件开发中，会遇到有些问题多次重复出现，有一定的相似性和规律性，可以将它们归为一种简单的语言，那么问题实例就是该语言的一些句子
- **扩展性好**：Interpreter使用类表示语言的文法规则，因此可以通过继承等机制改变和扩展文法
- **缺**
  - 执行效率低
  - 每条规则至少要定义一个类，文法规则很多时，系统难以维护

<img src="http://c.biancheng.net/uploads/allimg/181119/3-1Q119150626422.gif" alt="解释器模式的结构图" style="zoom:50%;" />

- **结构**
  - **Abstract Expression**：定义解释器接口，约定解释器等解释操作
  - **Terminal Expression**：实现文法中与终结符相关的操作，每一个终结符都有一个终结表达式与之对应
  - **Nonterminal Expression**：实现文法中与终结符相关的操作，每条规则对应一个非终结符表达式
  - **Context**：解释器需要的数据或公共的功能
  - **Client**：将要分析的句子转化为用解释器对象描述的抽象语法树，然后调用解释器的解释方法

```java
interface AbstractExpression{
    Object interpret(String info);	//解释
}

class TerminalExpression implements AbstractExpression{
    @Override
    public Object interpret(String info) {
        //对终结符表达式的处理
    }
}

class NonterminalExpression implements AbstractExpression{
    private AbstractExpression exp1, exp2;

    @Override
    public Object interpret(String info) {
        //对非终结符表达式的处理
    }
}

class Context{
    private AbstractExpression exp;

    public Context() {
        //数据初始化
    }
    
    public void operation(String info){
        //调用相关表达式的解释方法
    }
}
```

> 例. Java 公交卡读卡器
>
> 读卡器判断乘客的身份，如果是<u>上海或广州</u>的<u>老人妇女儿童</u>，则免费乘车，否则乘车2元
>
> **文法规则**
>
> ```xml
> <expression> ::= <city>的<person>
> <city> ::= 上海｜广州
> <person> ::= 老人｜妇女｜儿童
> ```
>
> **Expression**：抽象表达式接口
>
> - `abstract interpret(String info)`
>
> **Terminal Expression**
>
> - 用Set保存满足条件的城市
> - 用Set保存满足条件的人
> - `interpret()`：判断被分析的字符串是否是集合中的终结符
>
> **Nonterminal Expression**
>
> - 满足条件的城市的终结符表达式对象
> - 满足条件的人的终结符表达式对象
> - `interpret()`：判断被分析的字符串是否是满足条件的城市中的满足条件的人
>
> **Context**
>
> - 解释器所需要的城市
> - 解释器所需要的人
> - 完成对终结符表达式的初始化
> - `freeRide(String info)`：提供给client用来对字符串进行解释
>
> <img src="http://c.biancheng.net/uploads/allimg/181119/3-1Q119150Q6401.gif" alt="“韶粵通”公交车读卡器程序的结构图" style="zoom:50%;" />

