package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import common.config.service.QzoneConfig;
import cooperation.qzone.font.FontInterface;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class QzoneOfflinePluginJsForQQ
  extends QzoneInternalWebViewPlugin
{
  private static final String a = "QzoneOfflinePluginJsForQQ";
  private static final String b = ".qzonestyle.gtimg.cn,qzonestyle.gtimg.cn,qzs.qzone.qq.com,imgcache.qq.com,p.qpic.cn";
  private static final String c = "{\"html\":\"text/html\",\"css\":\"text/css\",\"js\":\"application/javascript\",\"jpg\":\"image/jpeg\",\"jpeg\":\"image/jpeg\",\"png\":\"image/png\",\"bmp\":\"image/bmp\",\"image\":\"image\",\"webp\":\"image/webp\"}";
  
  public QzoneOfflinePluginJsForQQ()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getQuery();
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        int k = ((String)localObject).indexOf('=');
        if ((k > 0) && (k < ((String)localObject).length() - 1) && ("fontId".equalsIgnoreCase(((String)localObject).substring(0, k))))
        {
          i = Integer.parseInt(((String)localObject).substring(k + 1));
          return i;
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneOfflinePluginJsForQQ", 1, paramString.getMessage());
    }
  }
  
  public static Object a(AppInterface paramAppInterface, String paramString)
  {
    Object localObject2;
    if (a(paramString))
    {
      localObject1 = a();
      localObject2 = b(paramString);
      if ((localObject1 == null) || (!((HashMap)localObject1).containsKey(localObject2))) {
        break label249;
      }
    }
    label249:
    for (Object localObject1 = (String)((HashMap)localObject1).get(localObject2);; localObject1 = null)
    {
      if ((localObject1 == null) || (((String)localObject1).length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneOfflinePluginJsForQQ", 2, String.format("not support this ext,url:%s,minetype:%s", new Object[] { paramString, localObject1 }));
        }
        paramAppInterface = null;
      }
      for (;;)
      {
        return paramAppInterface;
        paramAppInterface = QzoneOfflineCacheHelper.a(paramAppInterface, paramString);
        if ((paramAppInterface == null) || (!paramAppInterface.exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QzoneOfflinePluginJsForQQ", 2, String.format("not get offline cache,start download,url:%s,minetype:%s", new Object[] { paramString, localObject1 }));
          }
          return null;
        }
        try
        {
          localObject2 = new WebResourceResponse((String)localObject1, "utf-8", new FileInputStream(paramAppInterface));
          paramAppInterface = (AppInterface)localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("QzoneOfflinePluginJsForQQ", 2, String.format("[SUCC] get offline cache,url:%s,minetype:%s", new Object[] { paramString, localObject1 }));
            return localObject2;
          }
        }
        catch (Exception paramAppInterface)
        {
          QLog.e("QzoneOfflinePluginJsForQQ", 1, "shouldInterceptRequest Exception: " + paramAppInterface);
        }
      }
      for (;;)
      {
        return null;
        if (b(paramString)) {
          return a(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QzoneOfflinePluginJsForQQ", 2, String.format("not get offline cache,not offline,url:%s", new Object[] { paramString }));
        }
      }
    }
  }
  
  private static Object a(String paramString)
  {
    int i = a(paramString);
    if (i > 0)
    {
      Object localObject = FontInterface.a(i, paramString, null, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!new File((String)localObject).exists())
        {
          QLog.e("QzoneOfflinePluginJsForQQ", 1, "getResponse local file not exists :" + (String)localObject);
          return null;
        }
        try
        {
          localObject = new WebResourceResponse("application/octet-stream", "utf-8", new FileInputStream((String)localObject));
          if (QLog.isColorLevel()) {
            QLog.i("QzoneOfflinePluginJsForQQ", 2, String.format("[SUCC] get offline cache,url : %s,mineType : %s", new Object[] { paramString, "application/octet-stream" }));
          }
          return localObject;
        }
        catch (Exception localException)
        {
          QLog.e("QzoneOfflinePluginJsForQQ", 1, "interceptDownloadFontRequest Exception: " + localException);
        }
      }
    }
    QLog.e("QzoneOfflinePluginJsForQQ", 1, "[FAIL] interceptDownloadFontRequest fontId: +" + i + ",url : " + paramString);
    return null;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  private static HashMap a()
  {
    return a(QzoneConfig.a().a("QzUrlCache", "OfflineCacheExt2MimeType", "{\"html\":\"text/html\",\"css\":\"text/css\",\"js\":\"application/javascript\",\"jpg\":\"image/jpeg\",\"jpeg\":\"image/jpeg\",\"png\":\"image/png\",\"bmp\":\"image/bmp\",\"image\":\"image\",\"webp\":\"image/webp\"}"));
  }
  
  private static HashMap a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0))
    {
      localObject = null;
      return (HashMap)localObject;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        localIterator = localJSONObject.keys();
        if (localIterator == null) {
          break label125;
        }
        if (localIterator.hasNext()) {
          break label120;
        }
      }
      catch (Throwable paramString)
      {
        JSONObject localJSONObject;
        Iterator localIterator;
        String str1;
        String str2;
        return null;
      }
      localObject = paramString;
      if (!localIterator.hasNext()) {
        break;
      }
      str1 = (String)localIterator.next();
      localObject = paramString;
      if (str1 != null)
      {
        str2 = localJSONObject.optString(str1);
        localObject = paramString;
        if (str2 != null)
        {
          localObject = paramString;
          if (paramString == null) {
            localObject = new HashMap();
          }
          ((HashMap)localObject).put(str1, str2);
        }
      }
      paramString = (String)localObject;
      continue;
      label120:
      paramString = null;
    }
    label125:
    return null;
  }
  
  public static boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.contains("?_offline=1")) && (!paramString.contains("&_offline=1")))) {
      return false;
    }
    return c(a(paramString));
  }
  
  private static String b(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString = new URL(paramString);
        Object localObject1 = paramString.getQuery();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split("&");
          if (localObject1 != null)
          {
            int j = localObject1.length;
            if (i < j)
            {
              Object localObject2 = localObject1[i];
              int k = ((String)localObject2).indexOf('=');
              if ((k <= 0) || (k >= ((String)localObject2).length() - 1) || (!"_fileExt".equalsIgnoreCase(((String)localObject2).substring(0, k)))) {
                break label137;
              }
              return ((String)localObject2).substring(k + 1);
            }
          }
        }
        paramString = paramString.getPath();
        if (paramString != null)
        {
          i = paramString.lastIndexOf(".");
          if ((i >= 0) && (i < paramString.length() - 1))
          {
            paramString = paramString.substring(i + 1);
            return paramString;
          }
        }
      }
      catch (Throwable paramString) {}
      return null;
      label137:
      i += 1;
    }
  }
  
  public static boolean b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.contains("?_offline=1")) && (!paramString.contains("&_offline=1")))) {}
    while ((!paramString.contains("&fontId=")) && (!paramString.contains("?fontId="))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    Object localObject = QzoneConfig.a().a("QzUrlCache", "OfflineCacheWhiteList", ".qzonestyle.gtimg.cn,qzonestyle.gtimg.cn,qzs.qzone.qq.com,imgcache.qq.com,p.qpic.cn");
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      return false;
    }
    localObject = ((String)localObject).split(",");
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      if (str == null) {}
      label100:
      do
      {
        do
        {
          i += 1;
          break;
          str = str.trim();
          if (!str.startsWith(".")) {
            break label100;
          }
        } while (!paramString.endsWith(str));
        return true;
      } while (!paramString.equals(str));
      return true;
    }
    return false;
  }
  
  public Object a(String paramString, long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramLong == 8L)
    {
      localObject1 = localObject2;
      if (this.a != null)
      {
        localObject1 = localObject2;
        if (this.a.mRuntime != null) {
          localObject1 = this.a.mRuntime.a();
        }
      }
      localObject1 = a((AppInterface)localObject1, paramString);
    }
    return localObject1;
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneOfflinePluginJsForQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */