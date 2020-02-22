package Adapter;

/**
 * @program: Design Pattern
 * @description: 类适配器
 * @author: Zhe Zhang
 * @create: 2020/02/22
 **/


class ClassAdapter extends Adaptee implements Target{
    @Override
    public void request() {
        specificRequest();
    }
}

public class ClassAdapterDemo {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request();
    }
}
