package com.tencent.upload.uinterface;

public abstract interface IUploadTaskCallback
{
  public static final int STATE_CANCEL = 5;
  public static final int STATE_CONNECTING = 4;
  public static final int STATE_PAUSE = 2;
  public static final int STATE_RUNNING = 1;
  public static final int STATE_UNKNOWN = -1000;
  
  public abstract void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString);
  
  public abstract void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2);
  
  public abstract void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt);
  
  public abstract void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\IUploadTaskCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */