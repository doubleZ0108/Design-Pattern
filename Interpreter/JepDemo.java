/**
 * Java expression parser 表达式分析器
 *  以字符串对形式输入公式，然后得到结果
 *
 *  【例】利息 = 本金*利率*时间
 */

import com.singularsys.jep.*;

public class JepDemo {
    public static void main(String[] args) throw JepException{
        Jep jep = new Jep();

        /* 定义要计算对数据表达式 */
        String interest = "本金*利率*时间";

        /* 给相关变量赋值 */
        jep.addVariable("本金", 10000);
        jep.addVariable("利率", 0.038);
        jep.addVariable("时间", 2);

        /* 解析表达式 */
        jep.parse(interest);

        /* 计算 */
        Object accrual =jep.evaluate();
        System.out.println("存款利息" + accrual);
    }
}
