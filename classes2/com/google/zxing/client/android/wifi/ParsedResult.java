package com.google.zxing.client.android.wifi;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ParsedResult
{
  private final ParsedResultType a;
  
  protected ParsedResult(ParsedResultType paramParsedResultType)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramParsedResultType;
  }
  
  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append('\n');
      }
      paramStringBuilder.append(paramString);
    }
  }
  
  public static void a(String[] paramArrayOfString, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfString[i], paramStringBuilder);
        i += 1;
      }
    }
  }
  
  public final ParsedResultType a()
  {
    return this.a;
  }
  
  public abstract String a();
  
  public final String toString()
  {
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\google\zxing\client\android\wifi\ParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */