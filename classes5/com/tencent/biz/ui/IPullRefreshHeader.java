package com.tencent.biz.ui;

import android.graphics.drawable.Drawable;
import android.view.View;

public abstract interface IPullRefreshHeader
{
  public abstract long a();
  
  public abstract View a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(long paramLong);
  
  public abstract void b(long paramLong);
  
  public abstract void c(long paramLong);
  
  public abstract void setHeaderBgColor(int paramInt);
  
  public abstract void setHeaderBgDrawable(Drawable paramDrawable);
  
  public abstract void setHeaderBgRes(int paramInt);
  
  public abstract void setPullType(int paramInt);
  
  public abstract void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\ui\IPullRefreshHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */