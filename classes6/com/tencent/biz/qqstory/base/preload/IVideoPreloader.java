package com.tencent.biz.qqstory.base.preload;

import java.util.List;

public abstract interface IVideoPreloader
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  
  public abstract String a(String paramString, int paramInt);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean);
  
  public abstract void a(List paramList, int paramInt, boolean paramBoolean);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\IVideoPreloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */