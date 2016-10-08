package com.tencent.mobileqq.theme;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadTask;

public abstract interface ThemeDownloader$ThemeDownloadListener
{
  public abstract void a(Bundle paramBundle, int paramInt, DownloadTask paramDownloadTask);
  
  public abstract void a(Bundle paramBundle, int paramInt, DownloadTask paramDownloadTask, ThemeDownloader paramThemeDownloader);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\ThemeDownloader$ThemeDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */