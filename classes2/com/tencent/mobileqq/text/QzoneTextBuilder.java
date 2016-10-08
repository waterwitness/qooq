package com.tencent.mobileqq.text;

import android.text.Editable.Factory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import uzi;
import uzj;

public class QzoneTextBuilder
  extends QQTextBuilder
{
  public static Editable.Factory b = new uzi();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QzoneTextBuilder(int paramInt)
  {
    super(paramInt);
  }
  
  public QzoneTextBuilder(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public QzoneTextBuilder(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
  }
  
  public Object a(int paramInt1, int paramInt2, Class paramClass)
  {
    int i = 1;
    int j = 0;
    paramInt1 = nextSpanTransition(paramInt1, paramInt2, paramClass);
    if (paramInt1 >= paramInt2) {
      return null;
    }
    paramClass = getSpans(paramInt1, paramInt2, paramClass);
    if (paramClass.length >= 1)
    {
      int k = getSpanStart(paramClass[0]);
      paramInt2 = j;
      paramInt1 = i;
      while (paramInt1 < paramClass.length)
      {
        if (getSpanStart(paramClass[paramInt1]) < k) {
          paramInt2 = paramInt1;
        }
        paramInt1 += 1;
      }
      return paramClass[paramInt2];
    }
    return null;
  }
  
  public String a()
  {
    int i = 0;
    int m = length();
    char[] arrayOfChar = new char[m];
    getChars(0, m, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(m);
    QQText.EmotcationSpan[] arrayOfEmotcationSpan = (QQText.EmotcationSpan[])getSpans(0, m, QQText.EmotcationSpan.class);
    Arrays.sort(arrayOfEmotcationSpan, new uzj(this));
    int n = arrayOfEmotcationSpan.length;
    int j = 0;
    QQText.EmotcationSpan localEmotcationSpan;
    int i1;
    int k;
    if (j < n)
    {
      localEmotcationSpan = arrayOfEmotcationSpan[j];
      i1 = getSpanStart(localEmotcationSpan);
      k = getSpanEnd(localEmotcationSpan);
      if ((localEmotcationSpan != null) && (i1 < k) && (k > 0)) {}
    }
    else
    {
      if (i < m) {
        localStringBuilder.append(arrayOfChar, i, m - i);
      }
      return localStringBuilder.toString();
    }
    if (i1 > i) {
      localStringBuilder.append(arrayOfChar, i, i1 - i);
    }
    switch (localEmotcationSpan.c)
    {
    }
    for (;;)
    {
      j += 1;
      i = k;
      break;
      try
      {
        localStringBuilder.append(TextUtils.a(localEmotcationSpan.a));
      }
      catch (Exception localException1)
      {
        try
        {
          String str = toString();
          if ((android.text.TextUtils.isEmpty(str)) || (str.length() < k)) {
            continue;
          }
          localStringBuilder.append(str.substring(i1, k));
        }
        catch (Exception localException2)
        {
          QLog.e("QzoneTextBuilder", 1, localException2.getStackTrace());
        }
      }
      continue;
      localStringBuilder.append(localException2.a());
      continue;
      localStringBuilder.append(EmotcationConstants.a[(localException2.a & 0x7FFFFFFF)]);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\text\QzoneTextBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */