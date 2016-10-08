package com.tencent.av.utils;

import android.text.TextPaint;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EllipsisUtil
{
  public EllipsisUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static float a(StringBuilder paramStringBuilder, String paramString, TextPaint paramTextPaint, float paramFloat)
  {
    float f1;
    if (paramString == null)
    {
      f1 = paramFloat;
      return f1;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    for (;;)
    {
      f1 = paramFloat;
      if (i >= paramString.length) {
        break;
      }
      float f2 = paramTextPaint.measureText(paramString, i, 1);
      f1 = paramFloat;
      if (f2 >= paramFloat) {
        break;
      }
      paramFloat -= f2;
      paramStringBuilder.append(paramString[i]);
      i += 1;
    }
  }
  
  public static float b(StringBuilder paramStringBuilder, String paramString, TextPaint paramTextPaint, float paramFloat)
  {
    float f = paramTextPaint.measureText("...");
    if (f > a(paramStringBuilder, paramString, paramTextPaint, paramFloat - f)) {
      paramStringBuilder.append("...");
    }
    return f;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\EllipsisUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */