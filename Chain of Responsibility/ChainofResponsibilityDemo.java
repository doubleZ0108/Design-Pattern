/**
 * @program: Design Pattern
 * @description: 责任链
 * @author: Zhe Zhang
 * @create: 2020/02/22
 **/

/**
 * 抽象处理者
 */
abstract class Handler{
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    /* 请求处理的方法 */
    public abstract void handleRequest(String request);
}

/* 具体处理者1 */
class ConcreteHandler1 extends Handler{
    @Override
    public void handleRequest(String request) {
        if (request.equals("one")) {
            System.out.println("ConcreteHandler1负责处理该请求");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(request);
            }else{
                System.out.println("没有人处理该请求");
            }
        }
    }
}

/* 具体处理者2 */
class ConcreteHandler2 extends Handler{
    @Override
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("ConcreteHandler2负责处理该请求");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(request);
            }else{
                System.out.println("没有人处理该请求");
            }
        }
    }
}

public class ChainofResponsibilityDemo {
    public static void main(String[] args) {
        /* 组装责任链 */
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        /* 提交请求 */
        handler1.handleRequest("two");      //向头发请求
    }
}
