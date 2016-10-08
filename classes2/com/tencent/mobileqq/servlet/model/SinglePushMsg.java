package com.tencent.mobileqq.servlet.model;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Map;

public class SinglePushMsg
{
  public int a;
  public long a;
  public String a;
  public Map a;
  public boolean a;
  public long b;
  public boolean b;
  
  public SinglePushMsg(long paramLong1, Map paramMap, long paramLong2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\servlet\model\SinglePushMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */