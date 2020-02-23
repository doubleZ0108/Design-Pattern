package AbstractFactory;

/**
 * @program: Design Pattern
 * @description: Abstract Factory
 * @author: Zhe Zhang
 * @create: 2020/02/06
 **/
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        ProductFactory productFactory;      //基类指针

        productFactory = new SpringProductFactory();        //指向春季产品族
        productFactory.createFruit();
        productFactory.createVegetable();

        productFactory = new SummerProductFactory();        //指向夏季产品族
        productFactory.createFruit();
        productFactory.createVegetable();
    }
}
