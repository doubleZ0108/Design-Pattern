/**
 * @program: Design Pattern
 * @description: 外观模式
 * @author: doubleZ
 * @create: 2020/02/22
 **/

/**
 * 外观
 */
class Facade{
    private SubSystem1 obj1 = new SubSystem1();
    private SubSystem2 obj2 = new SubSystem2();
    private SubSystem3 obj3 = new SubSystem3();

    public void method(){
        obj1.method1();
        obj2.method2();
        obj3.method3();
    }
}


/**
 * 子系统
 */
class SubSystem1{
    public void method1(){
        System.out.println("SubSystem1.method1");
    }
}

class SubSystem2{
    public void method2(){
        System.out.println("SubSystem2.method2");
    }
}

class SubSystem3{
    public void method3(){
        System.out.println("SubSystem3.method3");
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
