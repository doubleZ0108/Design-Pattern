import sun.misc.OSEnvironment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/* fine-grained objects & Flyweight objects */
class BigChar{
    private char ch;    //大字的原始字符
    private String fontdata;    //组成大字的字符串

    /* 创建一个大字（读取文件） */
    public BigChar(char ch) {
        this.ch = ch;

        String file_path = "data/";
        String file_name = ch + ".txt";

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(file_path + file_name));
            String line;
            StringBuffer buf = new StringBuffer();
            while((line = reader.readLine()) != null){
                buf.append(line);
                buf.append('\n');
            }

            reader.close();
            this.fontdata = buf.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.fontdata = ch + "?";
        } catch (IOException e) {
            e.printStackTrace();
            this.fontdata = ch + "?";
        }

    }

    public void print(){
        System.out.print(fontdata);
    }
}

/* flyweight工厂 （控制中心）「Singleton」 */
class BigCharFactory{

    //这里使用了java泛型反而窄化，默认是Hashtable<Object,Object>，但是这样做更安全
    private Hashtable<Character, BigChar> pool = new Hashtable<Character, BigChar>();   //Character -> 容器里不允许放基本类型
    private static BigCharFactory factory = new BigCharFactory();

    private BigCharFactory(){}

    public static BigCharFactory getInstance(){
        return factory;
    }

    /* 从pool中取大字，如果没有大字就创建一个并加入到pool中 */
    public synchronized BigChar getBigChar(char ch){    //制作fresh到pool.put()之间不能被其他县城插队，所以要宣告为synchronized
        Character character = new Character(ch);

        if(pool.containsKey(character)){
            return pool.get(character);
        }else{
            BigChar fresh_bc = new BigChar(ch);
            pool.put(character, fresh_bc);
            return fresh_bc;
        }
    }
}

class BigString{
    private BigChar[] bcs;

    public BigString(String s) {
        int N = s.length();
        bcs = new BigChar[N];

        /* 通过工厂获取共享元素，而不是每次new */
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < N; i++) {
            bcs[i] = factory.getBigChar(s.charAt(i));
        }

        /* 这样做失去了控制，没法sharing */
//        for (int i = 0; i < N; i++) {
//            bcs[i] = new BigChar(s.charAt(i));
//        }
    }

    public void print(){
        int N = bcs.length;
        for (int i = 0; i < N; i++) {
            bcs[i].print();
        }
    }
}

public class FlyWeightDemo {
    public static void main(String[] args) {
        String bignum_str = "6324598761532";
        BigString bs = new BigString(bignum_str);
        bs.print();
    }
}
