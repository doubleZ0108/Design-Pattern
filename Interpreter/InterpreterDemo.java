import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Design Pattern
 * @description: 解释器例子 公交车卡的读卡器
 * @author: doubleZ
 * @create: 2020/02/22
 **/

/**
 * 文法规则
 *      <expression> ::= <city>的<person>
 *      <city> ::= 上海｜广州
 *      <person> ::= 老人｜妇女｜儿童
 */
interface Expression{
    boolean interpret(String info);
}

class TerminalExpression implements Expression{
    private Set<String> set = new HashSet<String>();

    public TerminalExpression(String[] data){
        Collections.addAll(set, data);
    }

    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}

class NonterminalExpression implements Expression{
    private Expression city = null;
    private Expression person = null;

    public NonterminalExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String s[] = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}

class Context{
    private String[] citys = {"广州", "上海"};
    private String[] persons = {"老人", "妇女", "儿童"};
    private Expression cityPerson;

    public Context(){
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new NonterminalExpression(city, person);
    }

    public void freeRide(String info){
        if(cityPerson.interpret(info)){
            System.out.println("您是" + info + ", 本次乘车免费！");
        }else{
            System.out.println(info + "您不是免费人员，本次乘车扣费2元！");
        }
    }
}


public class InterpreterDemo {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("上海的老人");
        bus.freeRide("上海的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }
}
