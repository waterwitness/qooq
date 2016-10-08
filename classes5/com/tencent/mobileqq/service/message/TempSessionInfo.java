package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TempSessionInfo
{
  public static final int a = -1;
  public static final long a = -1L;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public TempSessionInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("----dump tempSession info----");
    localStringBuilder.append("friendType:").append(this.jdField_b_of_type_Int).append(" groupCode:").append(this.jdField_b_of_type_Long).append(" groupUin:").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\message\TempSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */