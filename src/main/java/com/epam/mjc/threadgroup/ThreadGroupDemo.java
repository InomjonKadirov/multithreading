package com.epam.mjc.threadgroup;

import lombok.extern.slf4j.Slf4j;

/**
 * https://www.geeksforgeeks.org/java-lang-threadgroup-class-java/
 */
@Slf4j
public class ThreadGroupDemo {

    public static void main(String[] args)
    {
        // creating the thread group
        ThreadGroup gfg = new ThreadGroup("parent thread group");

        ThreadGroup gfg_child = new ThreadGroup(gfg, "child");

        NewThread t1 = new NewThread("one", gfg);
        log.info("Starting one");
        NewThread t2 = new NewThread("two", gfg);
        log.info("Starting two");

        // checking the number of active thread
        log.info("number of active thread: {}", gfg.activeCount());

        gfg.checkAccess();
        log.info("The group has access {}", gfg.getName());
        gfg_child.checkAccess();
        log.info("The child group has access {}", gfg_child.getName());

    }
}

@Slf4j
class NewThread extends Thread
{
    NewThread(String threadName, ThreadGroup tgob)
    {
        super(tgob, threadName);
        start();
    }
    public void run()
    {

        for (int i = 0; i < 1000; i++)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException ex)
            {
                log.info("Exception encounterted");
            }
        }
    }
}
