package com.tencent.mobileqq.emosm.favroaming;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ResidParser
{
  public static final int a = 7;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public ResidParser(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("_");
      if (paramString.length >= 7)
      {
        this.g = paramString[0];
        this.h = paramString[1];
        this.b = paramString[2];
        this.c = paramString[3];
        this.d = paramString[4];
        this.e = paramString[5];
        this.f = paramString[6];
      }
    }
  }
  
  public boolean a()
  {
    return this.a.split("_").length >= 7;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\favroaming\ResidParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */