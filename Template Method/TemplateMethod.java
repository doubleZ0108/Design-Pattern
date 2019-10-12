/* application framework */
abstract class Generalization{

    /* skeleton */
    public void findSolution(){
        stepOne();
        stepTwo();
        stepThr();
        stepFor();
    }

    protected void stepOne(){
        System.out.println("Generalization.stepOne");
    }

    /* 推迟该步骤使得在subclass在才完成 */
    abstract protected void stepTwo();
    abstract protected void stepThr();

    protected void stepFor(){
        System.out.println("Generalization.stepFor");
    }
}

abstract class Specialization extends Generalization{

    /* subclass - skeleton */
    protected void stepThr(){
        step3_1();
        step3_2();
        step3_3();
    }

    protected void step3_1(){
        System.out.println("Specializatino.step3_1");
    }

    abstract protected void step3_2();

    protected void step3_3(){
        System.out.println("Specializatino.step3_3");
    }
}

class Realization extends Specialization{
    protected void stepTwo(){
        System.out.println("Realization.stepTwo");
    }

    protected void step3_2(){
        System.out.println("Realization.step3_2");
    }

    protected void stepFor(){       //覆盖父类的函数
        System.out.println("Realization.stepFor");
        super.stepFor();    //调用父类的同名函数
    }
}

public class TemplateMethod {

    public static void main(String[] args) {
        Generalization algorithm = new Realization();   //使用者一定是new最具体的class
        algorithm.findSolution();
    }

}
