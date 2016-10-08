package com.facebook.react.modules.network;

import com.squareup.okhttp.OkHttpClient;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class OkHttpClientProvider
{
  @Nullable
  private static OkHttpClient sClient;
  
  private static OkHttpClient createClient()
  {
    OkHttpClient localOkHttpClient = new OkHttpClient();
    localOkHttpClient.setConnectTimeout(0L, TimeUnit.MILLISECONDS);
    localOkHttpClient.setReadTimeout(0L, TimeUnit.MILLISECONDS);
    localOkHttpClient.setWriteTimeout(0L, TimeUnit.MILLISECONDS);
    return localOkHttpClient;
  }
  
  public static OkHttpClient getOkHttpClient()
  {
    if (sClient == null) {
      sClient = createClient();
    }
    return sClient;
  }
  
  public static void onDestroy()
  {
    sClient = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\network\OkHttpClientProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */