package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class QQMessageFacade$RefreshMessageContext
{
  public static final int e = 9;
  public static final int f = 1;
  public int a;
  long a;
  public Object a;
  public String a;
  public List a;
  public boolean a;
  public int b;
  long b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public volatile boolean h;
  public volatile boolean i;
  
  public QQMessageFacade$RefreshMessageContext()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
    this.d = true;
    this.f = true;
    this.g = true;
    this.jdField_a_of_type_Long = Long.MAX_VALUE;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public String toString()
  {
    return "[isComplete = " + this.jdField_a_of_type_Boolean + ", isJoined = " + this.jdField_b_of_type_Boolean + ", isLocalOnly = " + this.c + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\QQMessageFacade$RefreshMessageContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */