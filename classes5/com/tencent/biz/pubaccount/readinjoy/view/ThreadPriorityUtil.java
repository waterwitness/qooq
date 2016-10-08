package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ThreadPriorityUtil
{
  private int jdField_a_of_type_Int;
  private Thread jdField_a_of_type_JavaLangThread;
  private int jdField_b_of_type_Int;
  private Thread jdField_b_of_type_JavaLangThread;
  
  public ThreadPriorityUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangThread = Looper.getMainLooper().getThread();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangThread.getPriority();
    for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
    Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
    localThreadGroup.enumerate(arrayOfThread);
    int i = 0;
    for (;;)
    {
      if (i < arrayOfThread.length)
      {
        if ((arrayOfThread[i] != null) && (arrayOfThread[i].isAlive()) && (arrayOfThread[i].getName().equalsIgnoreCase("RenderThread")))
        {
          this.jdField_b_of_type_JavaLangThread = arrayOfThread[i];
          this.jdField_b_of_type_Int = this.jdField_b_of_type_JavaLangThread.getPriority();
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangThread.setPriority(10);
    if (this.jdField_b_of_type_JavaLangThread != null) {
      this.jdField_b_of_type_JavaLangThread.setPriority(10);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangThread.setPriority(this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_JavaLangThread != null) {
      this.jdField_b_of_type_JavaLangThread.setPriority(this.jdField_b_of_type_Int);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("main:" + this.jdField_a_of_type_JavaLangThread.getPriority());
    if (this.jdField_b_of_type_JavaLangThread != null) {
      localStringBuilder.append(" render:" + this.jdField_b_of_type_JavaLangThread.getPriority());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ThreadPriorityUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */