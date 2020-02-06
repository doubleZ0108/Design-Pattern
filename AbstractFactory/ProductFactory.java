package AbstractFactory;

/**
 * @program: Design Pattern
 * @description: Product Factory
 * @author: Zhe Zhang
 * @create: 2020/02/06
 **/

/**
 * 抽象工厂
 */
abstract class ProductFactory {
    protected String fruitSpeice;
    protected String vegetableSpeice;

    abstract public Fruit createFruit();            //返回值是基类Fruit，但生产但具体水果方法由子类实现
    abstract public Vegetable createVegetable();
}


/**
 * 春季工厂
 * 生产 苹果 + 土豆
 */
class SpringProductFactory extends ProductFactory{
    SpringProductFactory(){
        this.fruitSpeice = Apple.getSpeice();
        this.vegetableSpeice = Potato.getSpeice();
    }

    @Override
    public Fruit createFruit() {
        Fruit apple = new Apple();
        System.out.println("SpringProductFactory创建了一个" + apple.toString());
        return apple;
    }

    @Override
    public Vegetable createVegetable() {
        Vegetable potato = new Potato();
        System.out.println("SpringProductFactory创建了一个" + potato.toString());
        return potato;
    }
}


/**
 * 夏季工厂
 * 生产 樱桃 + 番茄
 */
class SummerProductFactory extends ProductFactory{
    SummerProductFactory(){
        this.fruitSpeice = Cherry.getSpeice();
        this.vegetableSpeice = Tomato.getSpeice();
    }

    @Override
    public Fruit createFruit() {
        Fruit cherry = new Cherry();
        System.out.println("SummerProductFactory创建了一个" + cherry.toString());
        return cherry;
    }

    @Override
    public Vegetable createVegetable() {
        Vegetable tomato = new Tomato();
        System.out.println("SummerProductFactory创建了一个" + tomato.toString());
        return tomato;
    }
}