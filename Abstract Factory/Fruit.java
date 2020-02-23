package AbstractFactory;

/**
 * @program: Design Pattern
 * @description: Fruit
 * @author: Zhe Zhang
 * @create: 2020/02/06
 **/

abstract class Fruit {
    protected String speice;

    public Fruit(String speice) {
        this.speice = speice;
    }
}

class Apple extends Fruit{
    Apple(){
        super("Apple");
    }

    static String getSpeice(){
        return "Apple";
    }

    @Override
    public String toString() {
        return "Apple";
    }
}

class Cherry extends Fruit{
    Cherry(){
        super("Cherry");
    }

    static String getSpeice(){
        return "Cherry";
    }

    @Override
    public String toString() {
        return "Cherry";
    }
}