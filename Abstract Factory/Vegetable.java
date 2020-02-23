package AbstractFactory;

/**
 * @program: Design Pattern
 * @description: Vegetable
 * @author: Zhe Zhang
 * @create: 2020/02/06
 **/
abstract class Vegetable {
    protected String speice;

    public Vegetable(String speice) {
        this.speice = speice;
    }
}

class Potato extends Vegetable{
    Potato(){
        super("Potato");
    }

    static String getSpeice(){
        return "Potato";
    }

    @Override
    public String toString() {
        return "Potato";
    }
}

class Tomato extends Vegetable{
    Tomato(){
        super("Tomato");
    }

    static String getSpeice(){
        return "Tomato";
    }

    @Override
    public String toString() {
        return "Tomato";
    }
}