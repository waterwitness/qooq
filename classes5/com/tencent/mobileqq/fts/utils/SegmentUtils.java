package com.tencent.mobileqq.fts.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.logger.ILogger;
import com.tencent.mobileqq.fts.tokenizer.Token;
import com.tencent.mobileqq.fts.tokenizer.cjk.CJKTokenizer;
import com.tencent.mobileqq.fts.tokenizer.cn.ChineseTokenizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SegmentUtils
{
  private static final String a = "SegmentUtils";
  
  public SegmentUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder(64);
        CJKTokenizer localCJKTokenizer = new CJKTokenizer(new StringReader(paramString), paramString.length());
        paramString = null;
        try
        {
          localToken = localCJKTokenizer.a();
          if (localToken != null) {
            continue;
          }
          if ((paramString != null) && (TextUtils.equals(paramString.b(), "double")) && (!TextUtils.isEmpty(paramString.a())))
          {
            localStringBuilder.append(paramString.a().charAt(paramString.a().length() - 1));
            localStringBuilder.append("*");
          }
        }
        catch (IOException paramString)
        {
          Token localToken;
          paramString.printStackTrace();
          FTSDatabase.a().a("SegmentUtils", "e", "tokenSegment: failure", paramString);
          continue;
        }
        paramString = localStringBuilder.toString();
        return paramString;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder;
        paramString.printStackTrace();
        FTSDatabase.a().a("SegmentUtils", "e", "tokenSegment: failure", paramString);
      }
      if ((paramString != null) && (TextUtils.equals(paramString.b(), "double")) && ((!TextUtils.equals(localToken.b(), "double")) || (paramString.c() < localToken.b())) && (!TextUtils.isEmpty(paramString.a())))
      {
        localStringBuilder.append(paramString.a().charAt(paramString.a().length() - 1));
        localStringBuilder.append("*");
        localStringBuilder.append(' ');
      }
      if ((!TextUtils.isEmpty(localToken.a())) && ((!TextUtils.equals(localToken.b(), "double")) || (localToken.a().length() != 1)))
      {
        localStringBuilder.append(localToken.a());
        localStringBuilder.append(' ');
      }
      paramString = localToken;
    }
    return null;
  }
  
  public static ArrayList a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\s");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].trim();
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String[] a(String paramString)
  {
    int j = 0;
    Object localObject = a(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      String str = a((String)((ArrayList)localObject).get(i));
      if (!TextUtils.isEmpty(str)) {
        paramString.add(str.trim());
      }
      i += 1;
    }
    if (paramString.size() == 0) {
      return null;
    }
    localObject = new String[paramString.size()];
    i = j;
    while (i < paramString.size())
    {
      localObject[i] = ((String)paramString.get(i));
      i += 1;
    }
    return (String[])localObject;
  }
  
  public static String[] b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localObject = new StringBuilder(32);
    paramString = new ChineseTokenizer(new StringReader(paramString));
    try
    {
      for (;;)
      {
        Token localToken = paramString.a();
        if (localToken == null) {
          break;
        }
        if (!TextUtils.isEmpty(localToken.a()))
        {
          ((StringBuilder)localObject).append(localToken.a());
          ((StringBuilder)localObject).append(' ');
        }
      }
      int i;
      return (String[])localObject;
    }
    catch (IOException paramString)
    {
      ((StringBuilder)localObject).setLength(0);
      paramString.printStackTrace();
      FTSDatabase.a().a("SegmentUtils", "e", "keywordSegment: failure", paramString);
      paramString = new ArrayList();
      if (((StringBuilder)localObject).length() > 0) {
        paramString.add(((StringBuilder)localObject).toString().trim());
      }
      if (paramString.size() == 0) {
        return null;
      }
      localObject = new String[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        localObject[i] = ((String)paramString.get(i));
        i += 1;
      }
    }
  }
  
  public static String[] c(String paramString)
  {
    Object localObject2 = a(paramString);
    FTSDatabase.a().a("SegmentUtils", "i", "query segments = " + Arrays.toString((Object[])localObject2));
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label218;
      }
      localObject1 = new String[1];
      localObject1[0] = paramString;
    }
    paramString = new String[localObject1.length];
    int i = 0;
    while (i < localObject1.length)
    {
      localObject2 = new StringBuilder(64);
      String[] arrayOfString = localObject1[i].split(" ");
      int j = 0;
      if (j < arrayOfString.length)
      {
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(" ");
        }
        if ((arrayOfString[j].length() == 1) || ((arrayOfString[j].charAt(0) >= '0') && (arrayOfString[j].charAt(0) <= '9')) || ((arrayOfString[j].charAt(0) >= 'a') && (arrayOfString[j].charAt(0) <= 'z')))
        {
          ((StringBuilder)localObject2).append(arrayOfString[j]);
          ((StringBuilder)localObject2).append("*");
        }
        for (;;)
        {
          j += 1;
          break;
          label218:
          return null;
          ((StringBuilder)localObject2).append(arrayOfString[j]);
        }
      }
      paramString[i] = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\fts\utils\SegmentUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */