package com.tencent.image;

public abstract class AbsThirdDataSourceAdapter
{
  public static final int STATUS_NOT_PREPARED = 0;
  public static final int STATUS_PREPARED = 2;
  public static final int STATUS_PREPARING = 1;
  
  public abstract int getStaus();
  
  public abstract String getURL();
  
  public abstract void requestPrepare(String paramString, OnPreparedCallback paramOnPreparedCallback);
  
  public static abstract interface OnPreparedCallback
  {
    public abstract void onPrepared(String paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\AbsThirdDataSourceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */