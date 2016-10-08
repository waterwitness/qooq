package com.tencent.open.base.http;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.InputStream;

public class HttpBaseUtil$Statistic
{
  public int a;
  public long a;
  public InputStream a;
  public String a;
  public long b;
  
  public HttpBaseUtil$Statistic(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.b = this.jdField_a_of_type_JavaLangString.length();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\http\HttpBaseUtil$Statistic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */