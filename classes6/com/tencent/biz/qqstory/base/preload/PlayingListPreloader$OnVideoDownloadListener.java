package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;

public abstract interface PlayingListPreloader$OnVideoDownloadListener
{
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage);
  
  public abstract void a(String paramString1, String paramString2, File paramFile);
  
  public abstract void b(String paramString1, String paramString2, File paramFile);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\PlayingListPreloader$OnVideoDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */