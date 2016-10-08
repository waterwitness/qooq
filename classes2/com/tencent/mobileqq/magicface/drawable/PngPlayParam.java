package com.tencent.mobileqq.magicface.drawable;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class PngPlayParam
{
  public int a;
  public boolean a;
  public String[] a;
  public int b;
  public String[] b;
  public int c;
  public int d;
  
  public PngPlayParam()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.c = 100;
    this.d = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_b_of_type_ArrayOfJavaLangString = null;
  }
  
  public boolean a()
  {
    int i;
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (!new File(this.jdField_a_of_type_ArrayOfJavaLangString[i]).exists()) {
          return false;
        }
        i += 1;
      }
    }
    if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (this.jdField_b_of_type_ArrayOfJavaLangString.length > 0))
    {
      i = 0;
      for (;;)
      {
        if (i >= this.jdField_b_of_type_ArrayOfJavaLangString.length) {
          break label106;
        }
        if (!new File(this.jdField_b_of_type_ArrayOfJavaLangString[i]).exists()) {
          break;
        }
        i += 1;
      }
    }
    label106:
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\drawable\PngPlayParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */