package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.utils.httputils.HttpMsg;

public abstract interface ThumbHttpDownloader$WhatHappen
{
  public abstract void a(long paramLong, int paramInt, ThumbHttpDownloader.DownloadTask paramDownloadTask);
  
  public abstract void a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask);
  
  public abstract void a(long paramLong, HttpMsg paramHttpMsg);
  
  public abstract void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask);
  
  public abstract boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask);
  
  public abstract void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\ThumbHttpDownloader$WhatHappen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */