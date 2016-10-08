package com.tencent.feedback.upload;

public abstract interface UploadHandleListener
{
  public abstract void onUploadEnd(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString);
  
  public abstract void onUploadStart(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\feedback\upload\UploadHandleListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */