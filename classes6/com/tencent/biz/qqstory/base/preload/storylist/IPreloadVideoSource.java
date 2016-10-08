package com.tencent.biz.qqstory.base.preload.storylist;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public abstract interface IPreloadVideoSource
{
  public static final int a = 5;
  public static final String a = String.valueOf(0);
  public static final int b = 0;
  public static final String b = String.valueOf(1);
  public static final int c = 1;
  public static final String c = String.valueOf(2);
  public static final int d = 2;
  public static final String d = String.valueOf(3);
  public static final String e = String.valueOf(4);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract UserClickManager a();
  
  public abstract void a();
  
  public abstract void a(String paramString1, String paramString2, List paramList, boolean paramBoolean);
  
  public abstract void a(String paramString, List paramList);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\IPreloadVideoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */