/**
 * Created by Wee on 2015/2/10.
 * 写一个程序，让用户来决定Windows任务管理器（Task Manager）的CPU占用率。程序越精简越好，计算机语言不限。例如，可以实现下面三种情况：

 1.    CPU的占用率固定在50%，为一条直线；

 2.    CPU的占用率为一条直线，但是具体占用率由命令行参数决定（参数范围1~ 100）；

 3.    CPU的占用率状态是一个正弦曲线。


 首先什么是CPU占用率？

 在任务管理器的一个刷新周期内，CPU忙（执行应用程序）的时间和刷新周期总时间的比率，就是CPU的占用率，也就是说，任务管理器中显示的是每个刷新周期内CPU占用率的统计平均值。

 因此可以写个程序，在一个刷新周期中，一会儿忙，一会儿闲，调节忙/闲比例，就可以控制CPU占有率！
 */
public class CpuTest {

    public static void main(String[] args) {
        int busyTime = 10;
        int idleTime = busyTime;
        long startTime = 0;
        while (true) {
            startTime = System.currentTimeMillis();
            // busy loop
            while ((System.currentTimeMillis() - startTime) <= busyTime)
                ;
            // idle loop
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    }
