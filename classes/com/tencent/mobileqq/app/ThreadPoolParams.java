package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolParams
{
  public int a;
  public String a;
  public BlockingQueue a;
  public int b;
  public int c;
  public int d;
  
  public ThreadPoolParams()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "default_name";
    this.jdField_a_of_type_Int = 5;
    this.b = 5;
    this.c = 20;
    this.d = 1;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue(128);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ThreadPoolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */