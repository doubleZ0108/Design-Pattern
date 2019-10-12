interface Strategy{
    public void solve();
}

abstract class Strategy1 implements Strategy{
    @Override
    public void solve(){
        start();
        //TODO
        end();
    }

    protected abstract void start();
    protected abstract void end();
}

class Implementation1_1 extends Strategy1{
    @Override
    protected void start() {
        System.out.println("Implementation1:start");
    }

    @Override
    protected void end() {
        System.out.println("Implementation1:end");
    }
}

class Implementation1_2 extends Strategy1{
    @Override
    protected void start() {
        System.out.println("Implementation2:start");
    }

    @Override
    protected void end() {
        System.out.println("Implementation2:end");
    }
}

abstract class Strategy2 implements Strategy{
    @Override
    public void solve() {
        preProcess();
        //TODO
        postProcess();
    }

    protected abstract void preProcess();
    protected abstract void postProcess();
}

class Implementation2 extends Strategy2{
    @Override
    protected void preProcess() {
        System.out.println("Implementation2:preProcess");
    }

    @Override
    protected void postProcess() {
        System.out.println("Implementation2:postProcess");
    }
}

public class StrategyDemo {

    public static void main(String[] args) {
        Strategy[] algorithms = {new Implementation1_1(), new Implementation1_2(), new Implementation2()};
        for(Strategy algorithm : algorithms){
            algorithm.solve();
        }
    }

}
