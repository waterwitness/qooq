package com.tencent.bitapp.utils;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloaderUtils
{
  public static final int DEFAULT_MAX_CONNECT_TIME = 5000;
  private static final String TAG = DownloaderUtils.class.getSimpleName();
  
  public static InputStream download(String paramString)
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new URL(paramString);
      try
      {
        localObject2 = (HttpURLConnection)((URL)localObject2).openConnection();
        ((HttpURLConnection)localObject2).setConnectTimeout(5000);
        ((HttpURLConnection)localObject2).setRequestMethod("GET");
        int i = ((HttpURLConnection)localObject2).getResponseCode();
        if (FLog.isLoggable(3)) {
          FLog.i(TAG, "download url: " + paramString + " response code is: " + i);
        }
        paramString = (String)localObject1;
        if (i == 200) {
          paramString = ((HttpURLConnection)localObject2).getInputStream();
        }
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      return null;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean download(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "download url: " + paramString1 + " | out: " + paramString2);
    }
    boolean bool1 = bool2;
    InputStream localInputStream;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        localInputStream = download(paramString1);
        if (localInputStream == null) {
          break label89;
        }
        bool1 = FileUtils.writeFile(localInputStream, paramString2);
      }
    }
    label89:
    do
    {
      try
      {
        localInputStream.close();
        return bool1;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return bool1;
      }
      bool1 = bool2;
    } while (!FLog.isLoggable(3));
    FLog.i(TAG, "download fail url: " + paramString1 + " | out: " + paramString2 + " InputStream is null");
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\DownloaderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */