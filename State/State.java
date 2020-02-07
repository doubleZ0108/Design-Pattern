package State;

/**
 * @program: Design Pattern
 * @description: State
 * @author: Zhe Zhang
 * @create: 2020/02/06
 **/
interface State {
    void doClock(Context context, int hour);
    void doUse(Context context);
    void doAlarm(Context context);
    void doPhone(Context context);
}

class DayState implements State{
    private static DayState sigleton = new DayState();      //单例

    private DayState(){ }       //private

    public static State getInstance(){
        return sigleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if(hour < 9 || 17 <= hour){     //9~17视为[白天]
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {    //把context传过来是为了让state回调context
        context.recordLog("使用金库（白天）");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurity("警铃（白天）");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurity("一般的通话（白天）");
    }

    @Override
    public String toString() {
        return "[白天]";
    }
}

class NightState implements State{
    private static NightState sigleton = new NightState();

    private NightState(){ }

    public static State getInstance(){
        return sigleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if(9 <= hour && hour < 17){     //17~9视为[晚间]
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurity("异常：晚间使用金库！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurity("警铃（晚间）");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("晚间对通话录音");
    }

    @Override
    public String toString() {
        return "[晚间]";
    }
}