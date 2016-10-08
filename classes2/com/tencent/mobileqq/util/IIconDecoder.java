package com.tencent.mobileqq.util;

import android.graphics.Bitmap;

public abstract interface IIconDecoder
{
  public static final int b = 1;
  public static final String b = "_s_";
  public static final int c = 200;
  public static final int d = 201;
  
  public abstract Bitmap a(int paramInt1, int paramInt2);
  
  public abstract Bitmap a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a();
  
  public abstract void a(IIconDecoder.IIconListener paramIIconListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void b(IIconDecoder.IIconListener paramIIconListener);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\IIconDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */