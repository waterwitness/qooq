package com.tencent.image;

public abstract interface URLDrawableHandler
{
  public abstract void doCancel();
  
  public abstract boolean isCancelled();
  
  public abstract void onFileDownloadFailed(int paramInt);
  
  public abstract void onFileDownloadStarted();
  
  public abstract void onFileDownloadSucceed(long paramLong);
  
  public abstract void publishProgress(int paramInt);
  
  public static class Adapter
    implements URLDrawableHandler
  {
    public void doCancel() {}
    
    public boolean isCancelled()
    {
      return false;
    }
    
    public void onFileDownloadFailed(int paramInt) {}
    
    public void onFileDownloadStarted() {}
    
    public void onFileDownloadSucceed(long paramLong) {}
    
    public void publishProgress(int paramInt) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\URLDrawableHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */