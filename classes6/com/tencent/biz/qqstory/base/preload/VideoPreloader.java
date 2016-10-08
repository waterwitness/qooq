package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.List;

public class VideoPreloader
  implements IVideoPreloader
{
  public int h;
  
  public VideoPreloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a(String paramString, int paramInt)
  {
    return PreloadUtils.a(paramString, paramInt).getAbsolutePath();
  }
  
  public void a()
  {
    ((PreloadDownloaderManager)SuperManager.a(6)).a(this.h);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener)
  {
    ((PreloadDownloaderManager)SuperManager.a(6)).a(paramOnPreloadListener);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ((PreloadDownloaderManager)SuperManager.a(6)).a(paramString1, paramString2, this.h, paramInt, paramBoolean);
  }
  
  public void a(List paramList, int paramInt, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    ((PreloadDownloaderManager)SuperManager.a(6)).a(paramList, paramInt, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\VideoPreloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */