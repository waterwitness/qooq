package com.tencent.mobileqq.apollo.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ApolloRedTouchInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  
  public ApolloRedTouchInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[").append("actionId: ").append(this.jdField_a_of_type_Int).append(",Ts: ").append(this.jdField_b_of_type_Int).append(",text=").append(this.jdField_a_of_type_JavaLangString).append(",url=").append(this.jdField_b_of_type_JavaLangString).append(",path=").append(this.c);
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\data\ApolloRedTouchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */