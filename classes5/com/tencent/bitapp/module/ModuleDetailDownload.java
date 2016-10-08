package com.tencent.bitapp.module;

public class ModuleDetailDownload
{
  private IDownloadAction mDownloadAction;
  
  public static final ModuleDetailDownload getInstance()
  {
    return Holder.INSTANCE;
  }
  
  public void downloadDetail(int paramInt, IDownloadListener paramIDownloadListener)
  {
    if (this.mDownloadAction != null) {
      this.mDownloadAction.downloadDetail(paramInt, paramIDownloadListener);
    }
  }
  
  public void setDownloadAction(IDownloadAction paramIDownloadAction)
  {
    this.mDownloadAction = paramIDownloadAction;
  }
  
  private static class Holder
  {
    private static final ModuleDetailDownload INSTANCE = new ModuleDetailDownload();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\ModuleDetailDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */