package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EmoticonUtils
{
  public static final String a = "EmoticonUtils";
  
  public EmoticonUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString.getBytes().length <= paramInt) {
      return paramString;
    }
    int k = paramString.length();
    int j = 0;
    for (int i = 0;; i = j) {
      if (j < k)
      {
        j += Character.charCount(paramString.codePointAt(j));
        if (paramString.substring(0, j).getBytes().length <= paramInt) {}
      }
      else
      {
        return paramString.substring(0, i);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\EmoticonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */