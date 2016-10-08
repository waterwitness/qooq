package com.tencent.open.appcommon.js;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LastDownloadAction
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public LastDownloadAction(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label58;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (!bool1)
      {
        this.jdField_a_of_type_JavaLangString = paramString1;
        this.b = paramString2;
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return bool1;
      label58:
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == paramInt)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaLangString.equals(paramString1))
        {
          bool1 = bool2;
          if (this.b.equals(paramString2))
          {
            bool1 = bool2;
            if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\js\LastDownloadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */