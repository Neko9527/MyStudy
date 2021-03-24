package com.xcw.practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author wangxuechao
 * @date 2021-03-24
 * 使用延时队列实现延时消息处理
 */
class DelayMessage implements Delayed {

    private long delayTime;

    private String name;

    private String message;

    public DelayMessage(long delayTime, String name, String message) {
        this.delayTime = System.currentTimeMillis() + delayTime;
        this.name = name;
        this.message = message;
    }

    /**
     * Returns the remaining delay associated with this object, in the
     * given time unit.
     *
     * @param unit the time unit
     * @return the remaining delay; zero or negative values indicate
     * that the delay has already elapsed
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long diff = delayTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Delayed o) {
        if (this.delayTime < ((DelayMessage) o).delayTime) {
            return -1;
        }
        if (this.delayTime > ((DelayMessage) o).delayTime) {
            return 1;
        }
        return 0;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(this.delayTime);
        return "DelayMessage{" +
                "delayTime=" + sd.format(date) +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<DelayMessage> dq = new DelayQueue<>();
        //根据"延时时间"来确定队列内的元素的处理优先级（即根据队列元素的“延时时间”进行排序）。
        dq.add(new DelayMessage(5000L,"A","A消息"));
        dq.add(new DelayMessage(4000L,"B","B消息"));
        dq.add(new DelayMessage(6000L,"C","C消息"));
        dq.add(new DelayMessage(5000L,"D","D消息"));


//        while (!dq.isEmpty()) {
//            DelayMessage dm = dq.poll();
//            if(dm != null) {
//                System.out.println(dm);
//            }
//        }
        System.out.println(dq.take());
        System.out.println(dq.take());
        System.out.println(dq.take());
        System.out.println(dq.take());
    }
}
