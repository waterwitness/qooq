package com.tencent.open.base.http;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.Executor;

public abstract class HttpAsyncTask
  extends AsyncTask
{
  protected static final String j = "https://openmobile.qq.com/";
  protected String k;
  protected String l;
  
  public HttpAsyncTask(String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = paramString1;
    if (!paramString1.toLowerCase().startsWith("http")) {
      this.k = ("https://openmobile.qq.com/" + paramString1);
    }
    this.l = paramString2;
  }
  
  public Executor a()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return AsyncTask.THREAD_POOL_EXECUTOR;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\http\HttpAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */