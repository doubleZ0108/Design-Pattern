/**
 * @program: Design Pattern
 * @description: Builder
 * @author: Zhe Zhang
 * @create: 2020/02/05
 **/

/**
 * Product
 */
class Pizza{
    private String dough = "";      //面团
    private String sauce = "";      //酱汁
    private String topping = "";    //配料

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "this is a " + this.dough + "-" + this.sauce + "-" + this.topping + " pizza!";
    }
}


/**
 * Abstract Builder
 */
abstract class PizzaBuilder{
    protected Pizza pizza;      //基类里有一个product，子类完成对product对一系列做法

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizza(){
        pizza = new Pizza();
    }

    /* 使用产品提供对接口进行制作 */
    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

class HawaiianPizzaBuilder extends PizzaBuilder{
    @Override
    public void buildDough() {
        pizza.setDough("cross");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("mild");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("ham");
    }
}

class SpicyPizzaBuilder extends PizzaBuilder{
    @Override
    public void buildDough() {
        pizza.setDough("pan baked");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("hot");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("pepperoni");
    }
}


/**
 * Director
 * 1. 提供方法设定builder
 * 2. 完成有一系列步骤对construction
 * 3. 供用户取得product
 */
class Waiter{
    private PizzaBuilder pizzaBuilder;      //使用基类指针，运行时指向子类对象，用来切换builder

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza(){
        return pizzaBuilder.getPizza();
    }

    /* 生产需要一些步骤 */
    public void constructPizza(){
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();    //使用基类指针
        PizzaBuilder spicy_pizzabuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder(hawaiian_pizzabuilder);  //通过director设定builder
        waiter.constructPizza();                        //通过director执行生产
        System.out.println(waiter.getPizza());          //通过director取得产品

        waiter.setPizzaBuilder(spicy_pizzabuilder);     //可以直接动态切换
        waiter.constructPizza();
        System.out.println(waiter.getPizza());
    }
}
