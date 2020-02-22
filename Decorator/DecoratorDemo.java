/**
 * @program: Design Pattern
 * @description: 装饰器
 * @author: doubleZ
 * @create: 2020/02/22
 **/

/**
 * 抽象构建
 */
interface Component{
    void operation();
}

/**
 * 具体构建
 */
class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("ConcreteComponent.operation");
    }
}


/**
 * 抽象装饰器
 */
class Decorator implements Component{
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}


/**
 * 具体装饰器
 */
class ConcreteDecorator extends Decorator{
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedOperation();
    }

    public void addedOperation(){
        System.out.println("为构建增加的额外功能addedOperation");
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        Component decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
