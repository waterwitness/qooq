package com.tencent.tmassistantbase.a;

import android.content.Context;
import android.content.res.Resources;

public class i
{
  protected Context a;
  protected Resources b;
  
  public i(Context paramContext)
  {
    this.a = paramContext;
    this.b = paramContext.getResources();
  }
  
  private int a(String paramString1, String paramString2)
  {
    return this.b.getIdentifier(paramString2, paramString1, this.a.getPackageName());
  }
  
  public int a(String paramString)
  {
    return a("string", paramString);
  }
  
  public int b(String paramString)
  {
    return a("drawable", paramString);
  }
  
  public int c(String paramString)
  {
    return a("layout", paramString);
  }
  
  public int d(String paramString)
  {
    return a("id", paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */