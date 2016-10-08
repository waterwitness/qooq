package com.tencent.mobileqq.vipav;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.pb.funcall.VipFunCallAndRing.TSourceInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;
import wga;
import wgb;
import wgc;
import wgd;
import wge;

public class VipFunCallManager
  implements Manager
{
  public static final String A = "group_";
  public static final String B = "local_version";
  public static final String C = "bundle";
  public static final String D = "update_time";
  public static final String E = "path";
  public static final String F = "isExists";
  public static final String G = "from";
  public static String H = "Vip_FunCall";
  public static final int a = 0;
  public static final String a = "VipFunCallManager";
  public static JSONObject a;
  public static final int b = 0;
  public static final String b = "_";
  public static final int c = 1;
  public static final String c = ",";
  public static final int d = 0;
  public static final String d = "-";
  public static final int e = 1;
  public static final String e = "last_fun_call_play_id";
  public static final int f = 2;
  public static final String f = "uin_fun_call_id_change";
  public static final int g = 6;
  public static final String g = "dealType";
  public static final int h = 7;
  public static final String h = "resourceType";
  public static final int i = 8;
  public static final String i = "isIPC";
  public static final int j = 9;
  public static final String j = "fcStatus";
  public static final int k = 3;
  public static final String k = "name";
  public static int l = -3;
  public static final String l = "callId";
  public static int m = -6;
  public static final String m = "ringId";
  public static int n = -7;
  public static final String n = "feeType";
  public static int o = -1;
  public static final String o = "progress";
  public static final int p = 0;
  public static final String p = "result";
  public static final int q = 1;
  public static final String q = "result_boo";
  public static final int r = 2;
  public static final String r = "message";
  public static final String s = "svr_url";
  public static final String t = "svr_actStr";
  public static final String u = "url_Video";
  public static final String v = "url_Fuzz";
  public static final String w = "url_Picture";
  public static final String x = "url_Ring";
  public static final String y = "url_call_thum";
  public static final String z = "group";
  MediaController jdField_a_of_type_AndroidWidgetMediaController;
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new wge(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  public IPCDownloadListener a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public VipFunCallManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(46));
    paramQQAppInterface = new File(VipFunCallConstants.a + File.separator);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    Object localObject;
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "<<need to copy a default config file.");
      }
      localObject = null;
      paramQQAppInterface = null;
    }
    for (;;)
    {
      try
      {
        localInputStream = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getAssets().open("funcall/vipfuncall_config.json");
        paramQQAppInterface = localInputStream;
        localObject = localInputStream;
        FileUtils.a(VipFunCallConstants.a + File.separator, new StringBuffer("config.json"), localInputStream);
      }
      catch (IOException localIOException)
      {
        InputStream localInputStream;
        localObject = paramQQAppInterface;
        localIOException.printStackTrace();
        if (paramQQAppInterface == null) {
          continue;
        }
        try
        {
          paramQQAppInterface.close();
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localObject == null) {
          break label206;
        }
      }
      try
      {
        localInputStream.close();
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    try
    {
      ((InputStream)localObject).close();
      label206:
      throw paramQQAppInterface;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "Build.MODEL=[" + Build.MODEL + "],android.os.Build.VERSION.SDK_INT=[" + Build.VERSION.SDK_INT + "]");
    }
    if (o < 0) {
      try
      {
        String[] arrayOfString = "R8007,SCH-I869,K-Touch E780,HUAWEI C8812E,AMOI N828,7,8,9,10,11,12,13,HUAWEI Y320-T00,gt-s7568i".split(",");
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          if ((arrayOfString[i1] != null) && ((arrayOfString[i1].equalsIgnoreCase(Build.VERSION.SDK_INT + "")) || (arrayOfString[i1].equalsIgnoreCase(Build.MODEL)))) {
            o = 7;
          }
          i1 += 1;
        }
        if (o >= 0) {
          break label192;
        }
      }
      catch (Exception localException)
      {
        QLog.e("VipFunCallManager", 1, "Build.MODEL=[" + Build.MODEL + "],android.os.Build.VERSION.SDK_INT=[" + Build.VERSION.SDK_INT + "]");
      }
    }
    o = 6;
    label192:
    return o;
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, 1, null);
    int i1 = paramAppRuntime.getInt("last_fun_call_play_id", 0);
    paramAppRuntime.edit().remove("last_fun_call_play_id").commit();
    return i1;
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = BaseApplicationImpl.a.a();
    }
    if (localAppRuntime == null)
    {
      QLog.e("VipFunCallManager", 1, "getResIdByUin null == app");
      return 0;
    }
    SharedPreferences localSharedPreferences = a(localAppRuntime, 1, null);
    if (localSharedPreferences == null)
    {
      QLog.e("VipFunCallManager", 1, "getResIdByUin null == sp");
      return 0;
    }
    paramAppRuntime = paramString1;
    int i1;
    int i2;
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramBoolean) {
        paramAppRuntime = localAppRuntime.getAccount();
      }
    }
    else
    {
      i1 = localSharedPreferences.getInt(paramAppRuntime + "callId" + paramInt, 0);
      if ((paramBoolean) || (TextUtils.isEmpty(paramString2))) {
        break label381;
      }
      paramAppRuntime = localSharedPreferences.getString("group", null);
      if (TextUtils.isEmpty(paramAppRuntime)) {
        break label376;
      }
      paramAppRuntime = paramAppRuntime.split(",");
      i2 = 0;
      label148:
      if (i2 >= paramAppRuntime.length) {
        break label376;
      }
      paramString1 = localSharedPreferences.getString("group_" + paramAppRuntime[i2], null);
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.indexOf("-" + paramString2 + "-") <= 0)) {
        break label334;
      }
      paramAppRuntime = paramString1.split(",");
      if (paramAppRuntime.length < 3) {
        break label376;
      }
      if (3 != paramInt) {
        break label327;
      }
      paramAppRuntime = paramAppRuntime[1];
      label247:
      if (TextUtils.isEmpty(paramAppRuntime)) {
        break label373;
      }
    }
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(paramAppRuntime);
        i1 = i2;
        i2 = i1;
        if (i1 == 0) {
          i2 = localSharedPreferences.getInt(localAppRuntime.getAccount() + "callId" + paramInt, 0);
        }
        return i2;
      }
      catch (Exception paramAppRuntime)
      {
        label327:
        label334:
        QLog.e("VipFunCallManager", 1, "getResIdByUin err:" + paramAppRuntime.getMessage());
      }
      QLog.e("VipFunCallManager", 1, "getResIdByUin null == uin, isICall = false");
      paramAppRuntime = paramString1;
      break;
      paramAppRuntime = paramAppRuntime[0];
      break label247;
      i2 += 1;
      break label148;
      label373:
      continue;
      label376:
      paramAppRuntime = null;
      break label247;
      label381:
      i2 = i1;
    }
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    int i1 = a(paramAppRuntime, 1, null).getInt("uin_fun_call_id_change_" + paramString1 + "_" + paramString2, 2);
    if (i1 != 0) {
      a(paramAppRuntime, paramString1, 0, paramString2, 0);
    }
    return i1;
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = BaseApplicationImpl.a.a();
    }
    if (localAppRuntime == null)
    {
      QLog.e("VipFunCallManager", 1, "getFunCallUinSP app == null");
      return null;
    }
    if (1 == paramInt) {}
    for (paramAppRuntime = "fun_call_uinSp_" + localAppRuntime.getAccount();; paramAppRuntime = "fun_call_appSp")
    {
      Object localObject = paramAppRuntime;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = paramAppRuntime + "_" + paramString;
      }
      return localAppRuntime.getApplication().getSharedPreferences((String)localObject, 4);
    }
  }
  
  public static VipFullScreenVideoView a(Activity paramActivity, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramRelativeLayout == null)) {}
    View localView;
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      return null;
      localView = paramActivity.getLayoutInflater().inflate(2130905097, null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
    } while (paramActivity.isFinishing());
    paramRelativeLayout.addView(localView, 0, localLayoutParams);
    return (VipFullScreenVideoView)localView.findViewById(2131303298);
  }
  
  public static String a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = b(paramAppRuntime, paramInt1, paramInt2, null);
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.e("VipFunCallManager", 1, "getResourcePathByUrl, url=null , id=" + paramInt1 + ", type=" + paramInt2);
      return null;
    }
    paramAppRuntime = str.substring(str.lastIndexOf("/") + 1);
    paramString = VipFunCallConstants.a + File.separator + paramInt1 + File.separator;
    return paramString + paramAppRuntime;
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a(paramAppRuntime, 1, null).edit().putInt("last_fun_call_play_id", paramInt).commit();
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, Bundle paramBundle, VipFunCallAndRing.TSourceInfo paramTSourceInfo, boolean paramBoolean)
  {
    int i3 = 0;
    int i2 = -1;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject1 = null;
    String str1 = null;
    Object localObject2 = null;
    int i1;
    if (paramBundle != null)
    {
      i1 = paramBundle.getInt("callId");
      localObject1 = paramBundle.getString("name");
      i3 = paramBundle.getInt("ringId");
      i2 = paramBundle.getInt("feeType");
      str4 = paramBundle.getString("url_Video");
      str3 = paramBundle.getString("url_Fuzz");
      str2 = paramBundle.getString("url_Picture");
      paramTSourceInfo = paramBundle.getString("url_Ring");
      str1 = paramBundle.getString("url_call_thum");
      paramBundle = (Bundle)localObject1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "downloadFCSuit callid=" + paramInt + ", ringid=" + i3 + ", feeType" + i2 + ", mediaUrl=" + str4 + ", fuzzImageUrl" + str3 + ", imageUrl=" + str2 + ", ringUrl" + paramTSourceInfo);
      }
      if (i1 == 0) {}
      do
      {
        return;
        if (paramTSourceInfo == null) {
          break label537;
        }
        str4 = paramTSourceInfo.str_media_url.get();
        str3 = paramTSourceInfo.str_image_url.get();
        str2 = paramTSourceInfo.str_image_url.get();
        localObject1 = paramTSourceInfo.str_ring_url.get();
        paramBundle = paramTSourceInfo.str_fc_name.get();
        str1 = paramTSourceInfo.str_thumb_url.get();
        i1 = paramInt;
        paramTSourceInfo = (VipFunCallAndRing.TSourceInfo)localObject1;
        break;
        localObject1 = new File(VipFunCallConstants.a + File.separator + paramInt + File.separator);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        localObject1 = a(paramAppRuntime, 0, String.valueOf(paramInt));
        if (localObject1 != null)
        {
          localObject1 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject1).putInt("callId", i1);
          ((SharedPreferences.Editor)localObject1).putInt("ringId", i3);
          if (i2 != 0) {
            ((SharedPreferences.Editor)localObject1).putInt("feeType", i2);
          }
          if (!TextUtils.isEmpty(paramBundle)) {
            ((SharedPreferences.Editor)localObject1).putString("name", paramBundle);
          }
          ((SharedPreferences.Editor)localObject1).putString("_6", str4);
          ((SharedPreferences.Editor)localObject1).putString("_9", str3);
          ((SharedPreferences.Editor)localObject1).putString("_7", str2);
          ((SharedPreferences.Editor)localObject1).putString("_3", paramTSourceInfo);
          ((SharedPreferences.Editor)localObject1).putString("_8", str1);
          ((SharedPreferences.Editor)localObject1).commit();
        }
        paramAppRuntime = a(paramAppRuntime, 0, null);
      } while (paramAppRuntime == null);
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putString("_3_" + i3, paramTSourceInfo);
      paramAppRuntime.commit();
      return;
      label537:
      i1 = paramInt;
      paramBundle = (Bundle)localObject2;
      paramTSourceInfo = (VipFunCallAndRing.TSourceInfo)localObject1;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a(paramAppRuntime, 1, null).edit().putInt("uin_fun_call_id_change_" + paramString1 + "_" + paramString2, paramInt1).commit();
    if (paramInt2 == 0) {}
    do
    {
      return;
      paramString2 = a(paramAppRuntime, paramInt2, 8, null);
      paramString1 = new File(paramString2);
    } while (FileUtils.a(paramString2));
    String str = b(paramAppRuntime, paramInt2, 8, null);
    paramString2 = new Bundle();
    paramString1 = new DownloadTask(str, paramString1);
    ((DownloaderFactory)paramAppRuntime.getManager(46)).a(1).a(paramString1, null, paramString2);
  }
  
  public static boolean a()
  {
    return new File(VipFunCallConstants.b).exists();
  }
  
  public static boolean a(Context paramContext, VideoView paramVideoView, String paramString, int paramInt1, VipFunCallMediaListener paramVipFunCallMediaListener, int paramInt2, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramVideoView == null) || (paramString == null)) {
      return false;
    }
    paramContext = new File(paramString);
    if ((paramContext.exists()) && (!paramVideoView.isPlaying()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "playing");
      }
      if (paramInt1 == 6)
      {
        paramVideoView.setOnTouchListener(new wga());
        paramVideoView.setVideoPath(paramContext.getAbsolutePath());
        paramVideoView.requestFocus();
        paramVideoView.setVisibility(0);
        paramVideoView.setOnPreparedListener(new wgb(paramVipFunCallMediaListener));
        paramVideoView.setOnCompletionListener(new wgc(paramVideoView));
        paramVideoView.setOnErrorListener(new wgd(paramInt2, paramVipFunCallMediaListener, paramVideoView, paramBoolean));
        return true;
      }
      if (paramInt1 == 7)
      {
        paramContext = BitmapManager.a(paramString);
        if (paramContext != null) {}
        for (paramContext = new BitmapDrawable(paramContext); paramContext != null; paramContext = null)
        {
          paramVideoView = (RelativeLayout)paramVideoView.getParent();
          if (paramVideoView == null) {
            break;
          }
          if (paramVipFunCallMediaListener != null) {
            paramVipFunCallMediaListener.a();
          }
          paramVideoView.setBackgroundDrawable(paramContext);
          return true;
        }
      }
    }
    return false;
  }
  
  public static String b(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = a(paramAppRuntime, 0, String.valueOf(paramInt1));
    paramAppRuntime = (AppRuntime)localObject;
    if (localSharedPreferences != null)
    {
      if (paramInt2 <= -1) {
        break label100;
      }
      paramAppRuntime = localSharedPreferences.getString("_" + paramInt2, null);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramAppRuntime)) {
        QLog.e("VipFunCallManager", 1, "getResourceUrl, url=null , id=" + paramInt1 + ", type=" + paramInt2);
      }
      return paramAppRuntime;
      label100:
      paramAppRuntime = (AppRuntime)localObject;
      if (!TextUtils.isEmpty(paramString)) {
        paramAppRuntime = localSharedPreferences.getString(paramString, null);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "startDownload, id=" + paramInt1 + ", resType=" + paramInt2 + ", isIPC=" + paramBoolean + ", srcType=" + paramInt3);
    }
    if (paramInt1 == 0) {}
    String str1;
    String str2;
    Object localObject;
    boolean bool;
    label254:
    do
    {
      return;
      str1 = b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, null);
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("VipFunCallManager", 1, "startDownload error0 url=null, id=" + paramInt1 + ", resType=" + paramInt2 + ", isIPC=" + paramBoolean + ", srcType=" + paramInt3);
        return;
      }
      str2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, null);
      if (TextUtils.isEmpty(str2))
      {
        QLog.e("VipFunCallManager", 1, "startDownload error resPath=null, id=" + paramInt1 + ", resType=" + paramInt2 + ", isIPC=" + paramBoolean + ", srcType=" + paramInt3);
        return;
      }
      localObject = new File(str2);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "startDownload exists(), id=" + paramInt1 + ", resType=" + paramInt2 + ", isIPC=" + paramBoolean + ", srcType=" + paramInt3 + ", fileExist=" + bool);
      }
    } while ((bool) && (!paramBoolean));
    Bundle localBundle = new Bundle();
    if ((7 != a()) && (7 == paramInt2)) {}
    for (int i1 = 0;; i1 = paramInt2)
    {
      localBundle.putInt("callId", paramInt1);
      localBundle.putString("path", str2);
      localBundle.putBoolean("isIPC", paramBoolean);
      localBundle.putInt("resourceType", paramInt2);
      localBundle.putInt("srcType", paramInt3);
      localBundle.putInt("dealType", i1);
      if (bool)
      {
        localBundle.putBoolean("isExists", true);
        localObject = new DownloadTask(str1, (File)localObject);
        ((DownloadTask)localObject).a(3);
        ((DownloadTask)localObject).z = 0;
        ((DownloadTask)localObject).a(localBundle);
        this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener.onDone((DownloadTask)localObject);
        return;
        bool = false;
        break label254;
      }
      if (i1 == 0)
      {
        label481:
        localObject = new DownloadTask(str1, (File)localObject);
        ((DownloadTask)localObject).a = 1;
        ((DownloadTask)localObject).jdField_e_of_type_Long = 5242880L;
        ((DownloadTask)localObject).jdField_e_of_type_JavaLangString = H;
        if ((9 == paramInt2) || (7 == paramInt2)) {
          if (WebpSoLoader.a() == null) {
            break label662;
          }
        }
      }
      label662:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((DownloadTask)localObject).j = paramBoolean;
        if (7 != paramInt2) {
          ((DownloadTask)localObject).b = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VipFunCallManager", 2, "startDownload, id=" + paramInt1 + ", resType=" + paramInt2 + ", url=" + str1);
        return;
        localObject = new File(str2 + ".tmp");
        break label481;
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2, int paramInt3, List paramList, long paramLong)
  {
    Object localObject1 = paramAppRuntime;
    if (paramAppRuntime == null) {
      localObject1 = BaseApplicationImpl.a.a();
    }
    if (localObject1 == null) {
      QLog.e("VipFunCallManager", 1, "setFunCallData null == app opType=" + paramInt1 + ", callId=" + paramInt2);
    }
    SharedPreferences localSharedPreferences;
    label233:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localSharedPreferences = a((AppRuntime)localObject1, 1, null);
            if (localSharedPreferences == null)
            {
              QLog.e("VipFunCallManager", 1, "setFunCallData null == sp");
              return;
            }
            if (2 != paramInt1) {
              break;
            }
            if (paramInt2 == 0)
            {
              QLog.e("VipFunCallManager", 1, "setGroup callId == 0, opType=SET_DATA_DELET_GROUP");
              return;
            }
            paramList = String.valueOf(paramInt2);
          } while (TextUtils.isEmpty(paramList));
          localObject1 = localSharedPreferences.getString("group", null);
        } while (TextUtils.isEmpty((CharSequence)localObject1));
        localObject2 = ((String)localObject1).split(",");
        paramAppRuntime = "";
        paramInt1 = 0;
        if (paramInt1 < localObject2.length)
        {
          paramString = paramAppRuntime;
          if (!paramList.equals(localObject2[paramInt1]))
          {
            paramString = new StringBuilder().append(paramAppRuntime);
            if (paramAppRuntime.length() <= 0) {
              break label233;
            }
          }
          for (paramAppRuntime = "," + localObject2[paramInt1];; paramAppRuntime = localObject2[paramInt1])
          {
            paramString = paramAppRuntime;
            paramInt1 += 1;
            paramAppRuntime = paramString;
            break;
          }
        }
      } while (((String)localObject1).equals(paramAppRuntime));
      localSharedPreferences.edit().putString("group", paramAppRuntime).commit();
      return;
      if (1 != paramInt1) {
        break;
      }
      if ((paramInt2 == 0) || (paramList == null) || (paramList.size() < 1))
      {
        QLog.e("VipFunCallManager", 1, "setGroup uins.size() < 1 opType=" + paramInt1 + ", callId=" + paramInt2);
        return;
      }
      paramString = String.valueOf(paramInt2);
    } while ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.size() < 1));
    String str1 = localSharedPreferences.getString("group", null);
    Object localObject2 = localSharedPreferences.edit();
    String[] arrayOfString;
    int i1;
    int i2;
    if (!TextUtils.isEmpty(str1))
    {
      arrayOfString = str1.split(",");
      i1 = -1;
      paramInt1 = 0;
      i2 = i1;
      if (paramInt1 >= arrayOfString.length) {
        break label622;
      }
      if (paramString.equals(arrayOfString[paramInt1])) {
        i2 = paramInt1;
      }
      do
      {
        paramInt1 += 1;
        i1 = i2;
        break;
        i2 = i1;
      } while (TextUtils.isEmpty(arrayOfString[paramInt1]));
      localObject1 = localSharedPreferences.getString("group_" + arrayOfString[paramInt1], "");
      Iterator localIterator = paramList.iterator();
      paramAppRuntime = (AppRuntime)localObject1;
      label504:
      if (localIterator.hasNext())
      {
        String str2 = String.valueOf((Long)localIterator.next());
        if (TextUtils.isEmpty(str2)) {
          break label996;
        }
        paramAppRuntime = paramAppRuntime.replace(str2 + "-", "");
      }
    }
    label622:
    label730:
    label996:
    for (;;)
    {
      break label504;
      i2 = i1;
      if (((String)localObject1).equals(paramAppRuntime)) {
        break;
      }
      ((SharedPreferences.Editor)localObject2).putString("group_" + arrayOfString[paramInt1], paramAppRuntime);
      i2 = i1;
      break;
      i2 = -1;
      if (i2 < 0) {
        if (TextUtils.isEmpty(str1)) {
          break label730;
        }
      }
      for (paramAppRuntime = str1 + "," + paramString;; paramAppRuntime = paramString)
      {
        ((SharedPreferences.Editor)localObject2).putString("group", paramAppRuntime);
        paramString = paramList.iterator();
        for (paramAppRuntime = "-"; paramString.hasNext(); paramAppRuntime = paramAppRuntime + paramList + "-") {
          paramList = (Long)paramString.next();
        }
      }
      paramAppRuntime = paramInt2 + "," + paramInt3 + "," + paramAppRuntime + "," + paramLong;
      ((SharedPreferences.Editor)localObject2).putString("group_" + paramInt2, paramAppRuntime);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
      if (paramInt1 == 0)
      {
        paramAppRuntime = localSharedPreferences.edit();
        paramAppRuntime.putInt(paramString + "callId" + 6, paramInt2);
        paramAppRuntime.putInt(paramString + "callId" + 9, paramInt2);
        paramAppRuntime.putInt(paramString + "callId" + 7, paramInt2);
        paramAppRuntime.putInt(paramString + "callId" + 3, paramInt3);
        paramAppRuntime.commit();
        return;
      }
      QLog.e("VipFunCallManager", 1, "setFunCallData opType == unknow " + paramInt1);
      return;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
    int i1 = a();
    a(paramInt1, 9, paramBoolean, paramInt3);
    a(paramInt1, i1, paramBoolean, paramInt3);
    if (paramInt2 != 0)
    {
      ColorRingManager localColorRingManager = (ColorRingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
      localColorRingManager.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
      localColorRingManager.a(paramInt2, 3, paramBoolean, paramInt3, "comering");
    }
    if (i1 == 6) {
      a(paramInt1, 7, false, 0);
    }
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vipav\VipFunCallManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */