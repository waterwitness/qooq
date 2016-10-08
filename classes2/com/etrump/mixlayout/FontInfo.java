package com.etrump.mixlayout;

import android.graphics.Typeface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FontInfo
{
  public int a;
  public Typeface a;
  public String a;
  public int b;
  
  public FontInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FontInfo(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "[id=" + this.jdField_a_of_type_Int + ",path=" + this.jdField_a_of_type_JavaLangString + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\etrump\mixlayout\FontInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */