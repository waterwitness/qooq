package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.PreViewDataHandler;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class FMConfig
{
  public static final String a = "FMConfig<FileAssistant>";
  public static boolean a = false;
  public static final String b = "FileMaxSize";
  public static boolean b = false;
  public static final String c = "WhetyeDownloadMaxSize";
  public static boolean c = true;
  public static final String d = "FileType";
  public static final String e = "InterfacePage";
  public static final String f = "PreviewMode";
  public static final String g = "FunctionSwitch";
  public static final String h = "WiFiMaxSize";
  public static final String i = "3GMaxSize";
  public static final String j = "WiFiGroupMaxSize";
  public static final String k = "3GGroupMaxSize";
  public static final String l = "OfflineFileList";
  public static final String m = "OpenForQQMusic";
  public static final String n = "OpenForQQBrowse";
  public static final String o = "Merge";
  public static final String p = "FunctionalSwitch";
  public static final String q = "SupportVersion";
  public static final String r = "FormatSupport";
  QQAppInterface a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FMConfig(QQAppInterface paramQQAppInterface, FileManagerUtil.PreViewDataHandler paramPreViewDataHandler, long paramLong)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfigV2", 0).edit();
    paramQQAppInterface.clear();
    Object localObject1 = (HashMap)paramPreViewDataHandler.a().get("OnlinePreView");
    Object localObject2 = ((HashMap)localObject1).keySet().iterator();
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = (HashMap)((HashMap)localObject1).get(localObject3);
      localObject5 = ((HashMap)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        str1 = (String)((Iterator)localObject5).next();
        String str2 = String.valueOf(((HashMap)localObject4).get(str1));
        paramQQAppInterface.putString(("OnlinePreView" + (String)localObject3 + str1).toLowerCase(), str2);
      }
    }
    paramPreViewDataHandler = (HashMap)paramPreViewDataHandler.a().get("OfflineConfig");
    localObject1 = paramPreViewDataHandler.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = paramPreViewDataHandler.get(localObject2);
      if ((localObject3 instanceof HashMap))
      {
        localObject3 = (HashMap)localObject3;
        localObject4 = ((HashMap)localObject3).keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          str1 = String.valueOf(((HashMap)localObject3).get(localObject5));
          paramQQAppInterface.putString(("OfflineConfig" + (String)localObject2 + (String)localObject5).toLowerCase(), str1);
        }
      }
    }
    paramQQAppInterface.putLong("FileOnlinePreviewVersionKey", paramLong);
    long l1 = MessageCache.a();
    paramQQAppInterface.putLong("FMConfigUpdateLastTime", l1);
    paramQQAppInterface.commit();
    QLog.i("FMConfig<FileAssistant>", 1, "commit Config data, time[" + l1 + "], ver[" + paramLong + "]");
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("OfflineFileConfigV2", 0).getString(paramString.toLowerCase(), null);
    if ((paramContext != null) && (paramContext.length() > 0)) {
      return paramContext;
    }
    return FileManagerUtil.c(paramString);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "OnlinePreView", FileUtil.a(paramString1).replace(".", ""), paramString2);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return a(paramContext, paramString1 + paramString2 + paramString3);
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return a(paramContext, "OnlinePreView", "PreloadPreview", paramString);
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "AutoDownload", FileUtil.a(paramString1).replace(".", ""), paramString2);
  }
  
  public static String c(Context paramContext, String paramString)
  {
    return a(paramContext, "OnlinePreView", "AutoPreview", paramString);
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "OfflineConfig", paramString1, paramString2);
  }
  
  public static String d(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, "OfflineConfig", paramString1, paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\FMConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */