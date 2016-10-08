package cooperation.qzone.webviewplugin;

import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import java.io.File;
import yrl;
import yrm;

public class QzoneOfflineCacheHelper
{
  private static final int jdField_a_of_type_Int = 10000;
  private static FileCacheService jdField_a_of_type_CooperationQzoneCacheFileCacheService;
  private static final String jdField_a_of_type_JavaLangString = "QzoneOfflineCacheHelper";
  
  public QzoneOfflineCacheHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static File a(AppInterface paramAppInterface, String paramString)
  {
    File localFile;
    try
    {
      if (!URLUtil.isNetworkUrl(paramString)) {
        return null;
      }
      String str = a(paramString, true);
      str = b().a(str);
      localFile = new File(str);
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        a(paramString, str);
        if (QLog.isColorLevel()) {
          QLog.i("QzoneOfflineCacheHelper", 2, String.format("file exist,update lru,url:%s,path:%s", new Object[] { paramString, str }));
        }
      }
      else
      {
        PriorityThreadPool.getDefault().submit(new yrm(paramString, str, paramAppInterface), PriorityThreadPool.Priority.LOW);
        return null;
      }
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("QzoneOfflineCacheHelper", 1, paramAppInterface, new Object[0]);
      return null;
    }
    return localFile;
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = String.valueOf(paramString.hashCode());
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.startsWith("file://"));
    return paramString.substring("file://".length(), paramString.length());
  }
  
  private static void a(String paramString1, String paramString2)
  {
    PriorityThreadPool.getDefault().submit(new yrl(paramString2), PriorityThreadPool.Priority.LOW);
  }
  
  public static boolean a(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    String str;
    do
    {
      return false;
      str = a(paramString, true);
      str = b().a(str);
      if (new File(str).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.i("QzoneOfflineCacheHelper", 2, String.format("check result file exist,url:%s,path:%s", new Object[] { paramString, str }));
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QzoneOfflineCacheHelper", 2, String.format("check result file not exist,url:%s,path:%s", new Object[] { paramString, str }));
    return false;
  }
  
  private static FileCacheService b()
  {
    if (a == null) {
      a = CacheManager.b();
    }
    return a;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneOfflineCacheHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */