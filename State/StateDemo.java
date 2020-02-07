package State;

/**
 * @program: Design Pattern
 * @description: State Demo
 * @author: Zhe Zhang
 * @create: 2020/02/06
 **/

/**
 * 金库：白天正常使用，夜晚通知保安
 * 电话：白天呼叫保安，夜晚监听异常
 * 警铃：白天或夜晚都通知保安
 */
public class StateDemo {
    public static void main(String[] args) {
        String[] actions = {"use", "alarm", "phone"};

        SafeFrame safeFrame = new SafeFrame();
        for(int i = 0; i < 2; ++i){
            for(int hour=0; hour < 24; ++hour){     //模拟时间推进
                System.out.println("==================================");
                safeFrame.setClock(hour);

                for(String action : actions){   //这里草率的执行所有命令
                    safeFrame.respondEvent(action);
                }
                System.out.println("==================================\n");
            }
        }
    }
}
