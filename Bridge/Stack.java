package Bridge;

/**
 * @program: Design Pattern
 * @description: Stack
 * @author: Zhe Zhang
 * @create: 2020/02/05
 **/

class Stack {
    private StackImpl impl;

    public Stack(){
        this("array");      //默认为array
    }
    public Stack(String s){
        if(s.equals("array")){
            impl = new StackArray();
        } else if(s.equals("list")){
            impl = new StackList();
        } else{
            System.out.println("Stack: unknow parameter");
        }
    }

    public void push(int in) { impl.push(in); }
    public int pop() { return impl.pop(); }
    public int top() { return impl.top(); }
    public boolean isEmpty() { return impl.isEmpty(); }
    public boolean isFull() { return impl.isFull(); }
}

class StackHanoi extends Stack{
    private int totalRejected = 0;

    public StackHanoi() { super("array"); }
    public StackHanoi(String s) {super(s); }

    public int reportRejected() { return totalRejected; }

    @Override
    public void push(int in) {
        if(!isEmpty() && in > top()){
            totalRejected++;
        } else{
            super.push(in);
        }
    }
}


class StackFIFO extends Stack{
    private StackImpl temp = new StackList();

    public StackFIFO() { super("array"); }
    public StackFIFO(String s) { super(s); }

    @Override
    public int pop() {
        while(!isEmpty()){
            temp.push(super.pop());
        }
        int ret = temp.pop();
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return ret;
    }
}