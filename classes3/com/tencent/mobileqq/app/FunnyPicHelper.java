package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import pyf;

public class FunnyPicHelper
{
  public static final int a = 1;
  public static final String a = "FunyPicHelper";
  public static Set a = new HashSet();
  public static final int b = 2;
  public static final String b = "funny_pic_info";
  public static final int c = 3;
  public static final String c = "funnypic_count_sp_key";
  public static final String d = "funnypic_name_sp_key";
  public static final String e = "funnypic_type_sp_key";
  public static final String f = "http://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_item_";
  public static final String g = "funnypic_type";
  public static final String h = "";
  public static final String i = "qto_";
  public static final String j = "qto@";
  public static final String k = "/client_100.png";
  public static final String l = "funny_pic";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    String str2 = "0";
    String str1 = str2;
    int m;
    if (!TextUtils.isEmpty(paramString))
    {
      m = paramString.lastIndexOf("qto_");
      str1 = str2;
      if (m >= 0) {
        str1 = paramString.substring("qto_".length() + m, paramString.length());
      }
    }
    try
    {
      m = Integer.parseInt(str1);
      return m;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, paramString.getMessage());
      }
    }
    return 0;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    Object localObject = paramQQAppInterface.a().getSharedPreferences("funny_pic_info", 0);
    paramQQAppInterface = ((SharedPreferences)localObject).getString("funnypic_count_sp_key", "");
    localObject = ((SharedPreferences)localObject).getString("funnypic_name_sp_key", "");
    return "http://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_item_" + paramQQAppInterface + "/" + (String)localObject;
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      int m = paramString.lastIndexOf("qto_");
      str1 = str2;
      if (m >= 0) {
        str1 = paramString.substring(m, paramString.length());
      }
    }
    return str1;
  }
  
  public static void a(Context paramContext, List paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener)
  {
    a(true, paramContext, paramList, paramAppInterface, paramIPicDownloadListener);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      Object localObject1 = FileUtils.a(new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), ClubContentJsonTask.j.b));
      Object localObject2 = "";
      String str = "";
      n = 1;
      m = n;
      localObject5 = str;
      localObject6 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = str;
        localObject4 = localObject2;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        m = n;
        localObject5 = str;
        localObject6 = localObject2;
        localObject3 = str;
        localObject4 = localObject2;
        if (((JSONObject)localObject1).has("data"))
        {
          localObject3 = str;
          localObject4 = localObject2;
          localObject1 = ((JSONObject)localObject1).getJSONObject("data");
          m = n;
          localObject5 = str;
          localObject6 = localObject2;
          localObject3 = str;
          localObject4 = localObject2;
          if (((JSONObject)localObject1).has("releaseZipInfo"))
          {
            localObject3 = str;
            localObject4 = localObject2;
            localObject1 = ((JSONObject)localObject1).getJSONArray("releaseZipInfo");
            m = n;
            localObject5 = str;
            localObject6 = localObject2;
            localObject3 = str;
            localObject4 = localObject2;
            if (((JSONArray)localObject1).length() > 0)
            {
              localObject3 = str;
              localObject4 = localObject2;
              JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(0);
              localObject1 = localObject2;
              localObject3 = str;
              localObject4 = localObject2;
              if (localJSONObject.has("zipID"))
              {
                localObject3 = str;
                localObject4 = localObject2;
                localObject1 = localJSONObject.getString("zipID");
              }
              localObject2 = str;
              localObject3 = str;
              localObject4 = localObject1;
              if (localJSONObject.has("img"))
              {
                localObject3 = str;
                localObject4 = localObject1;
                localObject2 = localJSONObject.getString("img");
              }
              m = n;
              localObject5 = localObject2;
              localObject6 = localObject1;
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (localJSONObject.has("type"))
              {
                localObject3 = localObject2;
                localObject4 = localObject1;
                m = localJSONObject.getInt("type");
                localObject6 = localObject1;
                localObject5 = localObject2;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          m = n;
          localObject5 = localObject3;
          localObject6 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.d("FunyPicHelper", 2, localException.getMessage());
            m = n;
            localObject5 = localObject3;
            localObject6 = localObject4;
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("funny_pic_info", 0);
      if (!TextUtils.isEmpty((CharSequence)localObject6)) {
        paramQQAppInterface.edit().putString("funnypic_count_sp_key", (String)localObject6).commit();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        paramQQAppInterface.edit().putString("funnypic_name_sp_key", (String)localObject5).commit();
      }
      paramQQAppInterface.edit().putInt("funnypic_type_sp_key", m).commit();
    } while (!QLog.isColorLevel());
    QLog.d("FunyPicHelper", 2, "funnypic zipID->" + (String)localObject6 + ";imgName -> " + (String)localObject5 + ";type -> " + m);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, List paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext == null) || (paramAppInterface == null) || (paramList == null) || (paramList.isEmpty())) {}
    label124:
    label234:
    label749:
    label899:
    label978:
    label985:
    do
    {
      DownloaderInterface localDownloaderInterface;
      do
      {
        return;
        if (!NetworkUtil.h(paramContext)) {
          break;
        }
        localDownloaderInterface = ((DownloaderFactory)paramAppInterface.getManager(46)).a(1);
      } while (localDownloaderInterface == null);
      FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)paramAppInterface.getManager(148);
      VipComicMqqManager localVipComicMqqManager = (VipComicMqqManager)paramAppInterface.getManager(140);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
      AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        CustomEmotionData localCustomEmotionData;
        if (localIterator.hasNext())
        {
          localCustomEmotionData = (CustomEmotionData)localIterator.next();
          if (!TextUtils.isEmpty(localCustomEmotionData.url))
          {
            if (localDownloaderInterface.a(localCustomEmotionData.url) != null)
            {
              localAtomicInteger1.decrementAndGet();
              continue;
            }
            paramList = AppConstants.bs;
            boolean bool1 = false;
            File localFile;
            if ((localVipComicMqqManager != null) && (localVipComicMqqManager.a(localCustomEmotionData))) {
              if ((!TextUtils.isEmpty(localCustomEmotionData.emoPath)) && (localCustomEmotionData.emoPath.startsWith(AppConstants.bs)))
              {
                paramList = localCustomEmotionData.emoPath;
                localFile = new File(paramList);
                if (!localFile.exists()) {
                  break label749;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("FunyPicHelper", 2, "download path is exsit->" + paramList);
                }
                localAtomicInteger1.decrementAndGet();
                localCustomEmotionData.emoPath = localFile.getAbsolutePath();
                if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
                  localCustomEmotionData.RomaingType = "isUpdate";
                }
                if (bool1) {
                  localCustomEmotionData.eId = "";
                }
                if ((TextUtils.isEmpty(localCustomEmotionData.md5)) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath))) {
                  localCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath));
                }
                if (paramBoolean) {
                  localFavroamingDBManager.b(localCustomEmotionData);
                }
                if (paramIPicDownloadListener != null) {
                  paramIPicDownloadListener.onFileDone(localCustomEmotionData, true);
                }
                localArrayList1.add(localCustomEmotionData);
                if (QLog.isColorLevel()) {
                  QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + localCustomEmotionData.eId + " emoPath->" + localCustomEmotionData.emoPath + " download->sucess");
                }
              }
            }
            for (;;)
            {
              if ((localAtomicInteger1.get() != 0) || (paramIPicDownloadListener == null)) {
                break label899;
              }
              paramIPicDownloadListener.onDone(localArrayList1, localArrayList2);
              break;
              if (!TextUtils.isEmpty(localCustomEmotionData.md5))
              {
                paramList = localVipComicMqqManager.a(localCustomEmotionData.md5);
                break label234;
              }
              if (!TextUtils.isEmpty(localCustomEmotionData.resid))
              {
                paramList = paramList + localCustomEmotionData.resid;
                break label234;
              }
              paramList = paramList + localCustomEmotionData.url.substring(localCustomEmotionData.url.lastIndexOf("/") + 1);
              break label234;
              if (localCustomEmotionData.url.contains("qto_"))
              {
                paramList = paramList + a(localCustomEmotionData.url);
                break label234;
              }
              if (!TextUtils.isEmpty(a(localCustomEmotionData.eId)))
              {
                paramAppInterface = paramList + localCustomEmotionData.eId;
                boolean bool2 = true;
                paramList = paramAppInterface;
                bool1 = bool2;
                if (!QLog.isColorLevel()) {
                  break label234;
                }
                QLog.d("FunyPicHelper", 2, "emotion is FunnyPic path download from server->" + localCustomEmotionData.eId);
                paramList = paramAppInterface;
                bool1 = bool2;
                break label234;
              }
              paramList = paramList + localCustomEmotionData.resid;
              break label234;
              DownloadTask localDownloadTask = new DownloadTask(localCustomEmotionData.url, localFile);
              localDownloadTask.n = false;
              localDownloadTask.f = "emotion_pic";
              localDownloadTask.A = 1;
              paramList = "";
              if (localCustomEmotionData.url.contains("qto_"))
              {
                paramAppInterface = a(localCustomEmotionData.url);
                paramList = paramAppInterface;
                if (!TextUtils.isEmpty(paramAppInterface))
                {
                  paramList = paramAppInterface;
                  if (paramAppInterface.length() > "qto_".length() + 8)
                  {
                    paramList = paramAppInterface.substring(0, "qto_".length() + 8);
                    a.add(paramList);
                  }
                }
              }
              localDownloaderInterface.a(localDownloadTask, new pyf(paramList, localFile, localCustomEmotionData, bool1, paramBoolean, localFavroamingDBManager, paramIPicDownloadListener, localArrayList1, localArrayList2, paramContext, localAtomicInteger2, localAtomicInteger1), null);
            }
            continue;
          }
          if (paramIPicDownloadListener != null) {
            paramIPicDownloadListener.onFileDone(localCustomEmotionData, false);
          }
          if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType)) {
            break label978;
          }
        }
        for (paramList = "null";; paramList = localCustomEmotionData.RomaingType)
        {
          if (!QLog.isColorLevel()) {
            break label985;
          }
          QLog.d("FunyPicHelper", 2, "checkLoadEmotionPic, url is null : " + localCustomEmotionData.resid + ", romaingType:" + paramList);
          break label124;
          break;
        }
      }
    } while (paramIPicDownloadListener == null);
    paramIPicDownloadListener.onDone(new ArrayList(), paramList);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FunnyPicHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */