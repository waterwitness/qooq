package com.tencent.mobileqq.mqsafeedit;

public class StringUtil
{
  public static String toSemiAngleString(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i >= paramString.length) {
      return String.valueOf(paramString);
    }
    if (paramString[i] == '　') {
      paramString[i] = 32;
    }
    for (;;)
    {
      i += 1;
      break;
      if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
        paramString[i] = ((char)(paramString[i] - 65248));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\mqsafeedit\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */