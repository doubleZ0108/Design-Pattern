import java.net.NoRouteToHostException;

/**
 * @program: Design Pattern
 * @description: Proxy Framework
 * @author: Zhe Zhang
 * @create: 2020/02/06
 **/

/**
 * 抽象Subject
 */
interface Subject{
    void Request();
}

/**
 * 真实要访问的Subject
 */
class RealSubject implements Subject{
    @Override
    public void Request() {
        System.out.println("访问真实主题的方法...");
    }
}

/**
 * 代理人
 */
class Proxy implements Subject{
    private RealSubject realSubject;

    /* 代理提供与真实Subject一样的接口 */
    @Override
    public void Request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    private void preRequest(){
        System.out.println("预处理...");
    }

    private void postRequest(){
        System.out.println("后续处理...");
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();      //使用的时候用代理进行操作
        proxy.Request();
    }
}
