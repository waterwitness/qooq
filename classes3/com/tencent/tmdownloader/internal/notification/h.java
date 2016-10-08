package com.tencent.tmdownloader.internal.notification;

import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class h
{
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      if (a(paramString.charAt(j))) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label141;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label141:
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    if (!paramBoolean) {
      return a(paramString, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label156;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label156:
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label148;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label148:
      if ((!paramBoolean1) || (paramBoolean2)) {
        break label188;
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label188:
      if ((paramBoolean1) && (paramBoolean2)) {
        localStringBuilder.append("…");
      }
    }
  }
  
  protected static boolean a(char paramChar)
  {
    return (paramChar >= 'ÿ') || (paramChar < 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\notification\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */