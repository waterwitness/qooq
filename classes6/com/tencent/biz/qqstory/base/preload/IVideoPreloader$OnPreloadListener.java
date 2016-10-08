package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;

public abstract interface IVideoPreloader$OnPreloadListener
{
  public abstract void a(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, ErrorMessage paramErrorMessage);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, File paramFile);
  
  public abstract void a(String paramString1, int paramInt1, String paramString2, File paramFile, int paramInt2);
  
  public abstract void b(String paramString1, int paramInt, String paramString2);
  
  public abstract void b(String paramString1, int paramInt, String paramString2, File paramFile);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\IVideoPreloader$OnPreloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */