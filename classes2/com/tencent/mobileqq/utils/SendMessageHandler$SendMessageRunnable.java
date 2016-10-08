package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SendMessageHandler$SendMessageRunnable
  implements Runnable
{
  public int a;
  public String a;
  public String[] a;
  public long c;
  public boolean c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  
  public SendMessageHandler$SendMessageRunnable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Long = -1L;
    this.d = Long.MAX_VALUE;
    this.e = Long.MAX_VALUE;
    this.f = -1L;
    this.g = -1L;
    this.h = -1L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  }
  
  public void run() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("index:");
    localStringBuilder.append(String.valueOf(this.jdField_a_of_type_Int));
    localStringBuilder.append(",reason:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",startTime:");
    localStringBuilder.append(String.valueOf(this.g - this.f));
    localStringBuilder.append(",timeOut:");
    localStringBuilder.append(String.valueOf(this.g - this.f + this.jdField_c_of_type_Long));
    if (this.jdField_c_of_type_Boolean)
    {
      localStringBuilder.append(",duration:");
      localStringBuilder.append(String.valueOf(this.h - this.g));
      localStringBuilder.append(",error:");
      localStringBuilder.append(String.valueOf(this.d));
      if (this.e != Long.MAX_VALUE)
      {
        localStringBuilder.append(",serverReply:");
        localStringBuilder.append(String.valueOf(this.e));
      }
    }
    for (;;)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append(",status:RUNNING");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\SendMessageHandler$SendMessageRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */