package Visitor;


/**
 * @program: Design Pattern
 * @description: Visitor control class
 * @author: Zhe Zhang
 * @create: 2020/02/02
 **/

public class VisitorDemo {
    public static void main(String[] args) {
        try{
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.accept(new ListVisitor());      //对数据结构进行操作对方法
        } catch (FileTreatmentException e){
            e.printStackTrace();
        }
    }
}
