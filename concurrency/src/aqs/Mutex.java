package aqs;

/**
 * @author 海想着你
 * @create 2018-10-06 21:21
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自己定义锁(独占锁)
 */
public class Mutex implements Lock {
    /**
     * 内部类继承同步器
     */
    private static class Sych extends AbstractQueuedSynchronizer {

        /**
         * 检查是否处于占用状态
         *
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 当状态为0的时候获取锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 释放锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 返回一个condition
         *
         * @return
         */
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sych sych = new Sych();

    @Override
    public void lock() {
        sych.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sych.acquireInterruptibly(1);
    }


    @Override
    public boolean tryLock() {
        return sych.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sych.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sych.release(1);
    }

    @Override
    public Condition newCondition() {
        return newCondition();
    }

}
