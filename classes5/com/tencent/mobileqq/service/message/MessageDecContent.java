package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;

public class MessageDecContent
{
  public int a;
  public long a;
  public Object a;
  public String a;
  
  public MessageDecContent(int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("-----MessageDecContent----");
    localStringBuilder.append("msgType:").append(this.jdField_a_of_type_Int).append(" content:").append(Utils.a(this.jdField_a_of_type_JavaLangString));
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\message\MessageDecContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */