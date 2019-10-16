import java.util.Vector;

/**
 * Subject 发行方
 */
class Subject{
    private Vector obs;     //记录下所有订阅自己的Observer
    private Object hint = "This is the origin hint of Subject";     //将hint存储成Object类型

    public Subject(){
        obs = new Vector();
    }

    public void addObserver(Observer o){
        if(!obs.contains(o)){
            obs.addElement(o);
        }
    }

    public void removeObserver(Observer o){
        obs.removeElement(o);
    }

    public void notifyObserver(Observer o){
        o.update(o, hint);
    }

    public void notifyAllObserver(){
        Object[] arrLocal = obs.toArray();
        for(Object obj : arrLocal){
            ((Observer)obj).update(null, hint);
        }
    }

    public void notifyAllObserver(Observer o){
        /**
         * @description: 更新除o以外的全部观察者
         *
         * @param o : 向Subject传入hint的观察者
         *
         * @return : void
         **/
        Object[] arrLocal = obs.toArray();
        for(Object obj : arrLocal){
            if(obj != o){
                ((Observer)obj).update(o, hint);
            }
        }
    }

    public void setHint(Observer o, Object hint) {
        /**
         * @description: 根据Observer传入的hint修改自身信息，并广播给其他所有观察者
         *
         * @param o : 向自己传入hint的观察者
         * @param hint : 观察者传入的信息
         **/

        this.hint = hint;
        notifyAllObserver(o);
    }
}


/**
 * Observer 订阅方
 */
abstract class Observer{
    protected Subject subject;
    protected Object data;

    public Observer() {
    }

    public Observer(Subject s, Object data){
        this.subject = s;   //在初始化时记录下自己的Subject，以便自己可以向Subject传递信息
        this.data = data;
        subject.addObserver(this);  //在Subject中添加自己
    }

    public abstract void update(Observer sender, Object hint);

    public abstract void sendMyData();
}

class Observer1 extends Observer{
    public Observer1() {
    }

    /*
    必须重载父类的此构造函数，将自己加入到Subject中
     */
    public Observer1(Subject s, Object data) {
        super(s, data);
    }

    @Override
    public void update(Observer sender, Object hint) {
        /**
         * @description: 接受Subject的通知，并根据hint内容进行定制化
         *
         * @param sender : 谁把信息发送给的Subject导致Subject广播给自己
         * @param hint : Subject通知时附带的提示，可以是任意类型(因为形参定义为Object)
         **/
        System.out.println("Observer1 receive hint {" + hint + "} from Subject. The sender is " + sender);
    }

    @Override
    public void sendMyData() {
        /**
         * @description: 将自己的data信息发送给自己的subject，并请求Subject广播给其他所有观察者
         **/
        System.out.println("Observer1 send data to Subject");
        subject.setHint(this, data);
    }
}

class Observer2 extends Observer{
    public Observer2(){

    }

    public Observer2(Subject s, Object data) {
        super(s, data);
    }

    @Override
    public void update(Observer sender, Object hint) {
        System.out.println("Observer2 receive hint {" + hint + "} from Subject. The sender is " + sender);
    }

    @Override
    public void sendMyData() {
        System.out.println("Observer2 send data to Subject");
        subject.setHint(this, data);
    }
}

class Observer3 extends Observer{
    public Observer3(){

    }

    public Observer3(Subject s, Object data) {
        super(s, data);
    }

    @Override
    public void update(Observer sender, Object hint) {
        System.out.println("Observer3 receive hint {" + hint + "} from Subject. The sender is " + sender);
    }

    @Override
    public void sendMyData() {
        System.out.println("Observer3 send data to Subject");
        subject.setHint(this, data);
    }
}

public class ObserverDemo {

    public static void main(String[] args) {
        Subject s = new Subject();
        Observer o1 = new Observer1(s, "Observer1 data");
        Observer o2 = new Observer2(s, "Observer2 data");
        Observer o3 = new Observer3(s, "Observer3 data");

        //测试一 Subject将自身信息广播给所有观察者
//        s.notifyAllObserver();

        //测试二 o2观察者将自身信息发送给Subject，请求Subject更新自身数据并广播给所有其他观察者
        o2.sendMyData();
    }

}
