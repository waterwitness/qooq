package com.tencent.biz.common.offline.util;

import android.content.Context;
import com.tencent.biz.common.offline.AsyncBack;
import java.util.Map;

public abstract interface IOfflineDownloader
{
  public abstract int a(Context paramContext, String paramString);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack, Map paramMap);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, AsyncBack paramAsyncBack, Map paramMap);
  
  public abstract void a(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\offline\util\IOfflineDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */