import java.util.ArrayList;
import java.util.List;

/**
 * @program: Design Pattern
 * @description: 中介者
 * @author: doubleZ
 * @create: 2020/02/22
 **/

abstract class Mediator{
    public abstract void register(Colleague colleague);     //注册
    public abstract void relay(Colleague colleague);        //转发
}

class ConcreteMediator extends Mediator{
    private List<Colleague> colleagues = new ArrayList<Colleague>();

    @Override
    public void register(Colleague colleague) {
        if(!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for(Colleague obj : colleagues){
            if(!obj.equals(colleague)){
                ((Colleague)obj).receive();
            }
        }
    }
}

abstract class Colleague{
    protected Mediator mediator;

    public void setMedium(Mediator mediator){
        this.mediator = mediator;
    }

    public abstract void receive();
    public abstract void send();
}

class ConcreteColleague1 extends Colleague{
    @Override
    public void receive() {
        System.out.println("ConcreteColleague1收到请求");
    }

    @Override
    public void send() {
        System.out.println("ConcreteColleague1发出请求");
        mediator.relay(this);       //请中介者转发
    }
}

class ConcreteColleague2 extends Colleague{
    @Override
    public void receive() {
        System.out.println("ConcreteColleague2收到请求");
    }

    @Override
    public void send() {
        System.out.println("ConcreteColleague2发出请求");
        mediator.relay(this);       //请中介者转发
    }
}


public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague c1, c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();

        mediator.register(c1);
        mediator.register(c2);

        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}
