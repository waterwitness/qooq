package com.tencent.bitapp.view;

public abstract interface IBitAppBaseViewListener
{
  public abstract void onInvalidViewClick();
  
  public abstract void onLoadFail(String paramString, int paramInt);
  
  public abstract void onLoadSuccess(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\view\IBitAppBaseViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */