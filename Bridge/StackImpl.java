package Bridge;

/**
 * @program: Design Pattern
 * @description:
 * @author: Zhe Zhang
 * @create: 2020/02/05
 **/
interface StackImpl {
    void push(int in);
    int pop();
    int top();
    boolean isEmpty();
    boolean isFull();
}

class StackArray implements StackImpl{
    private int[] items = new int[12];
    private int total = -1;

    @Override
    public void push(int in) {
        if(!isFull()){
            items[++total] = in;
        }
    }

    @Override
    public int pop() {
        if(!isEmpty()){
            return items[total--];
        }else{
            return -1;
        }
    }

    @Override
    public int top() {
        if(!isEmpty()){
            return items[total];
        }else{
            return -1;
        }
    }

    @Override
    public boolean isEmpty() {
        return total == -1;
    }

    @Override
    public boolean isFull() {
        return total == 11;
    }
}


class Node{
    public int value;
    public Node prev, next;

    public Node(int value) { this.value = value; }
}

class StackList implements StackImpl{
    private Node last;

    @Override
    public void push(int in) {
        if(last == null){
            last = new Node(in);
        }else{
            last.next = new Node(in);
            last.next.prev = last;
            last = last.next;
        }
    }

    @Override
    public int pop() {
        if(!isEmpty()){
            int tmp = last.value;
            last = last.prev;
            return tmp;
        }else{
            return -1;
        }
    }

    @Override
    public int top() {
        if(!isEmpty()){
            return last.value;
        }else{
            return -1;
        }
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}