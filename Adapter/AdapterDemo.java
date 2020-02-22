package Adapter;

/**
 * @program: Design Pattern
 * @description: 新能源汽车例子
 * @author: Zhe Zhang
 * @create: 2020/02/22
 **/

/**
 * 有两种新能源汽车发动机，现在想统一一个接口提供给用户
 */


/* Target */
interface Motor{
    void drive();
}

/* 适配者：电能发动机 */
class ElectricMotor{
    public void electricDrive(){
        System.out.println("电能发动机汽车");
    }
}

/* 适配者：光能发动机 */
class OpticalMotor{
    public void opticalDrive(){
        System.out.println("光能发动机汽车");
    }
}

/* 电能适配器 */
class ElectricAdapter implements Motor{
    private ElectricMotor electricMotor;

    public ElectricAdapter() {
        this.electricMotor = new ElectricMotor();
    }

    @Override
    public void drive() {
        electricMotor.electricDrive();
    }
}

/* 光能适配器 */
class OpticalAdapter implements Motor{
    public OpticalMotor opticalMotor;

    public OpticalAdapter() {
        this.opticalMotor = new OpticalMotor();
    }

    @Override
    public void drive() {
        opticalMotor.opticalDrive();
    }
}

/**
 * 客户端
 */
public class AdapterDemo {
    public static void main(String[] args) {
        Motor motor;

        motor = new ElectricAdapter();
        motor.drive();

        motor = new OpticalAdapter();
        motor.drive();
    }
}
