package State;

/**
 * @program: Design Pattern
 * @description: Context
 * @author: Zhe Zhang
 * @create: 2020/02/06
 **/

/**
 * 负责state的管理
 */
interface Context {
    void setClock(int hour);        //设定时间
    void changeState(State state);  //状态变化
    void callSecurity(String msg);  //呼叫保安
    void recordLog(String msg);     //记录日志
}


/**
 * 安全系统
 */
class SafeFrame implements Context{
    private State state = DayState.getInstance();   //拥有一个State指针，默认为白天状态

    @Override
    public void setClock(int hour) {
        String clockString = "现在对时间是";
        if(hour < 10){
            clockString += "0" + hour + ":00";
        }else{
            clockString += hour + ":00";
        }
        System.out.println(clockString);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println("状态已经从" + this.state + "变为" + state);
        this.state = state;
    }

    @Override
    public void callSecurity(String msg) {
        System.out.println("call..." + msg);
    }

    @Override
    public void recordLog(String msg) {
        System.out.println("recode..." + msg);
    }

    /* 用户接口，根据用户的指令执行操作 */
    void respondEvent(String action){
        if(action.equals("use")){
            state.doUse(this);
        } else if(action.equals("alarm")){
            state.doAlarm(this);
        } else if(action.equals("phone")){
            state.doPhone(this);
        } else{
            System.out.println("!! ERROR ACTION !!");
        }
    }
}