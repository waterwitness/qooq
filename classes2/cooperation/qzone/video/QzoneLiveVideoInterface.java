package cooperation.qzone.video;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QZoneVideoCommonUtils.VideoSupport;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.QZoneVipInfoManager;
import cooperation.qzone.ServerListProvider;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.Constants.PropertiesKey;
import ypv;
import ypw;
import ypx;

public class QzoneLiveVideoInterface
{
  public static final int RET_CODE_COMPRESS_SUCCESS = 2;
  public static final String TAG = "QzoneLiveVideoInterface";
  private static HashMap friNickNameMap = new HashMap();
  private static String version;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    version = "0";
  }
  
  public static void addFriend(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    paramActivity.startActivityForResult(AddFriendLogicActivity.a(BaseApplication.getContext(), 1, paramString1, "", 3011, 0, null, null, null, paramString2, null), paramInt);
  }
  
  public static void addLiveVideoComment(Intent paramIntent, Handler paramHandler)
  {
    paramIntent = paramIntent.getExtras();
    RemoteHandleManager.a().a("cmd.uploadCommentVideo", paramIntent, true);
    paramIntent = new ypw(paramHandler);
    RemoteHandleManager.a().a(paramIntent);
  }
  
  public static boolean checkAVCameraUsed(Context paramContext)
  {
    return QavCameraUsage.a(paramContext, false);
  }
  
  public static void collectPerformance(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3)
  {
    StatisticCollector.a(getContext()).a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public static void forwardOpenQzoneVip(Activity paramActivity, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    paramString2 = QZoneHelper.UserInfo.a();
    paramString2.a = (paramLong + "");
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString2, paramString1, paramLong, "", -1);
      return;
    }
    QZoneHelper.a(paramActivity, paramString2, paramString1, paramLong, "", -1);
  }
  
  public static void forwardToBrowser(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString1, paramInt, paramBundle, paramString2);
      return;
    }
    QZoneHelper.a(paramActivity, paramString1, paramInt, paramBundle, paramString2);
  }
  
  public static void forwardToFeedActionPanel(Activity paramActivity, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString6, int paramInt8, int paramInt9, boolean paramBoolean1, String paramString7, boolean paramBoolean2)
  {
    paramString2 = QZoneHelper.UserInfo.a();
    paramString2.a = paramString1;
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.a(((BasePluginActivity)paramActivity).getOutActivity(), paramString2, paramInt1, "", "", "", "", 0, 0, 1, 0, 0, 0, "", 40, 0, paramBoolean1, paramString7, paramBoolean2);
      return;
    }
    QZoneHelper.a(paramActivity, paramString2, paramInt1, "", "", "", "", 0, 0, 1, 0, 0, 0, "", 40, 0, paramBoolean1, paramString7, paramBoolean2);
  }
  
  public static void forwardToMoodSelectLocation(Activity paramActivity, String paramString, int paramInt, Bundle paramBundle)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = paramString;
    if ((paramActivity instanceof BasePluginActivity))
    {
      QZoneHelper.a(((BasePluginActivity)paramActivity).getOutActivity(), localUserInfo, paramInt, paramBundle);
      return;
    }
    QZoneHelper.a(paramActivity, localUserInfo, paramInt, paramBundle);
  }
  
  public static void forwardToUserHome(Activity paramActivity, long paramLong1, long paramLong2, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = (paramLong1 + "");
    if (paramLong2 > 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action_js2qzone");
      localIntent.putExtra("cmd", "QZonelive2Homepage");
      localIntent.putExtra("visitUin", paramLong2);
      localIntent.putExtra("requestCode", paramInt);
      if ((paramActivity instanceof BasePluginActivity))
      {
        QZoneHelper.a(((BasePluginActivity)paramActivity).getOutActivity(), localUserInfo, localIntent);
        return;
      }
      QZoneHelper.a(paramActivity, localUserInfo, localIntent);
      return;
    }
    QLog.w("QzoneLiveVideoInterface", 2, "startUserHomeActivity, invalid uin");
  }
  
  public static void forwardToVideoInteract(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, QZoneVideoDownloadActivity.class);
    paramActivity.putExtra("encode_video_params", paramBundle);
    paramActivity.putExtra("video_refer", "video_interact");
    localActivity.startActivityForResult(paramActivity, paramInt);
  }
  
  public static int getAppId()
  {
    return AppSetting.a;
  }
  
  public static Application getApplication()
  {
    return BaseApplicationImpl.a();
  }
  
  public static String getBuilderNumber()
  {
    return "100084";
  }
  
  public static String getCacheDir(String paramString)
  {
    return CacheManager.a(paramString);
  }
  
  public static Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static long getCpuFrequency()
  {
    return QZoneVideoCommonUtils.a();
  }
  
  public static String getDeviceInfor()
  {
    return PlatformInfor.a().e();
  }
  
  public static String getFilterSoPath(Context paramContext)
  {
    return PtvFilterSoLoad.a(getContext());
  }
  
  public static void getFriendListFromResultRecord(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getStringArrayListExtra("friendsList");
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Object localObject3 = paramIntent.getParcelableArrayListExtra("result_set");
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((ArrayList)localObject3).size() > 0)
          {
            localObject1 = new ArrayList();
            localObject2 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ResultRecord)((Iterator)localObject2).next();
              if ((localObject3 != null) && (!TextUtils.isEmpty(((ResultRecord)localObject3).a))) {
                ((ArrayList)localObject1).add(((ResultRecord)localObject3).a);
              }
            }
          }
        }
      }
      paramIntent.putStringArrayListExtra("friendsList", (ArrayList)localObject1);
    }
  }
  
  public static int getIntConfig(String paramString1, String paramString2, int paramInt)
  {
    return QzoneConfig.a().a(paramString1, paramString2, paramInt);
  }
  
  public static String getLiveVideoDownLoadClassName()
  {
    if ("qzone_live_video_plugin_hack.apk".equals(QZonePluginUtils.a())) {
      return "cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2";
    }
    return "cooperation.qzone.QZoneLiveVideoDownloadActivity";
  }
  
  public static int getMultiProcInt(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.a(paramString, paramInt);
  }
  
  public static int getNetWorkType()
  {
    return HttpUtil.a();
  }
  
  public static int getNetworkType()
  {
    return NetworkState.b();
  }
  
  public static String getNickname(String paramString)
  {
    return BaseApplicationImpl.a().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
  }
  
  /* Error */
  public static String getNickname(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 33	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   3: aload_1
    //   4: invokevirtual 358	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7: ifne +160 -> 167
    //   10: invokestatic 228	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: invokevirtual 362	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   16: new 113	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 364
    //   26: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 370	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   39: iconst_3
    //   40: anewarray 317	java/lang/String
    //   43: dup
    //   44: iconst_0
    //   45: ldc_w 372
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: ldc_w 374
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: ldc_w 376
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 382	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull +88 -> 157
    //   72: aload_2
    //   73: astore_0
    //   74: aload_2
    //   75: invokeinterface 387 1 0
    //   80: ifeq +77 -> 157
    //   83: aload_2
    //   84: astore_0
    //   85: aload_2
    //   86: ldc_w 372
    //   89: invokeinterface 391 2 0
    //   94: istore 6
    //   96: aload_2
    //   97: astore_0
    //   98: aload_2
    //   99: ldc_w 374
    //   102: invokeinterface 391 2 0
    //   107: istore 7
    //   109: aload_2
    //   110: astore_0
    //   111: aload_2
    //   112: ldc_w 376
    //   115: invokeinterface 391 2 0
    //   120: istore 8
    //   122: aload_2
    //   123: astore_0
    //   124: aload_2
    //   125: iload 6
    //   127: invokeinterface 395 2 0
    //   132: astore_3
    //   133: aload_2
    //   134: astore_0
    //   135: aload_3
    //   136: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifeq +39 -> 178
    //   142: aload_2
    //   143: astore_0
    //   144: aload_2
    //   145: invokeinterface 398 1 0
    //   150: istore 9
    //   152: iload 9
    //   154: ifne -32 -> 122
    //   157: aload_2
    //   158: ifnull +9 -> 167
    //   161: aload_2
    //   162: invokeinterface 401 1 0
    //   167: getstatic 33	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   170: aload_1
    //   171: invokevirtual 405	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: checkcast 317	java/lang/String
    //   177: areturn
    //   178: aload_2
    //   179: astore_0
    //   180: new 317	java/lang/String
    //   183: dup
    //   184: aload_3
    //   185: invokevirtual 409	java/lang/String:getBytes	()[B
    //   188: ldc_w 411
    //   191: invokespecial 414	java/lang/String:<init>	([BLjava/lang/String;)V
    //   194: invokestatic 417	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   197: astore 5
    //   199: aload_2
    //   200: astore_0
    //   201: aload_2
    //   202: iload 7
    //   204: invokeinterface 395 2 0
    //   209: astore_3
    //   210: aload_2
    //   211: astore_0
    //   212: aload_3
    //   213: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +63 -> 279
    //   219: aload_2
    //   220: astore_0
    //   221: new 317	java/lang/String
    //   224: dup
    //   225: aload_3
    //   226: invokevirtual 409	java/lang/String:getBytes	()[B
    //   229: ldc_w 411
    //   232: invokespecial 414	java/lang/String:<init>	([BLjava/lang/String;)V
    //   235: invokestatic 417	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   238: astore_3
    //   239: aload_2
    //   240: astore_0
    //   241: getstatic 33	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   244: aload 5
    //   246: aload_3
    //   247: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: goto -109 -> 142
    //   254: astore_1
    //   255: aload_2
    //   256: astore_0
    //   257: ldc 11
    //   259: iconst_2
    //   260: ldc_w 423
    //   263: aload_1
    //   264: invokestatic 426	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: aload_2
    //   268: ifnull +9 -> 277
    //   271: aload_2
    //   272: invokeinterface 401 1 0
    //   277: aconst_null
    //   278: areturn
    //   279: aload_2
    //   280: astore_0
    //   281: aload_2
    //   282: iload 8
    //   284: invokeinterface 395 2 0
    //   289: astore_3
    //   290: aload_2
    //   291: astore_0
    //   292: aload_3
    //   293: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   296: ifne -154 -> 142
    //   299: aload_2
    //   300: astore_0
    //   301: new 317	java/lang/String
    //   304: dup
    //   305: aload_3
    //   306: invokevirtual 409	java/lang/String:getBytes	()[B
    //   309: ldc_w 411
    //   312: invokespecial 414	java/lang/String:<init>	([BLjava/lang/String;)V
    //   315: invokestatic 417	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   318: astore 4
    //   320: aload 4
    //   322: astore_3
    //   323: aload_2
    //   324: astore_0
    //   325: aload 4
    //   327: invokevirtual 429	java/lang/String:length	()I
    //   330: iconst_1
    //   331: if_icmple +41 -> 372
    //   334: aload 4
    //   336: astore_3
    //   337: aload_2
    //   338: astore_0
    //   339: aload 4
    //   341: aload 4
    //   343: invokevirtual 429	java/lang/String:length	()I
    //   346: iconst_1
    //   347: isub
    //   348: invokevirtual 433	java/lang/String:charAt	(I)C
    //   351: bipush 10
    //   353: if_icmpne +19 -> 372
    //   356: aload_2
    //   357: astore_0
    //   358: aload 4
    //   360: iconst_0
    //   361: aload 4
    //   363: invokevirtual 429	java/lang/String:length	()I
    //   366: iconst_1
    //   367: isub
    //   368: invokevirtual 437	java/lang/String:substring	(II)Ljava/lang/String;
    //   371: astore_3
    //   372: aload_2
    //   373: astore_0
    //   374: getstatic 33	cooperation/qzone/video/QzoneLiveVideoInterface:friNickNameMap	Ljava/util/HashMap;
    //   377: aload 5
    //   379: aload_3
    //   380: invokevirtual 421	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: goto -242 -> 142
    //   387: astore_2
    //   388: aload_0
    //   389: astore_1
    //   390: aload_2
    //   391: astore_0
    //   392: aload_1
    //   393: ifnull +9 -> 402
    //   396: aload_1
    //   397: invokeinterface 401 1 0
    //   402: aload_0
    //   403: athrow
    //   404: astore_0
    //   405: aconst_null
    //   406: astore_1
    //   407: goto -15 -> 392
    //   410: astore_1
    //   411: aconst_null
    //   412: astore_2
    //   413: goto -158 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramString1	String
    //   0	416	1	paramString2	String
    //   67	306	2	localCursor	android.database.Cursor
    //   387	4	2	localObject1	Object
    //   412	1	2	localObject2	Object
    //   132	248	3	localObject3	Object
    //   318	44	4	str1	String
    //   197	181	5	str2	String
    //   94	32	6	i	int
    //   107	96	7	j	int
    //   120	163	8	k	int
    //   150	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   74	83	254	java/lang/Exception
    //   85	96	254	java/lang/Exception
    //   98	109	254	java/lang/Exception
    //   111	122	254	java/lang/Exception
    //   124	133	254	java/lang/Exception
    //   135	142	254	java/lang/Exception
    //   144	152	254	java/lang/Exception
    //   180	199	254	java/lang/Exception
    //   201	210	254	java/lang/Exception
    //   212	219	254	java/lang/Exception
    //   221	239	254	java/lang/Exception
    //   241	251	254	java/lang/Exception
    //   281	290	254	java/lang/Exception
    //   292	299	254	java/lang/Exception
    //   301	320	254	java/lang/Exception
    //   325	334	254	java/lang/Exception
    //   339	356	254	java/lang/Exception
    //   358	372	254	java/lang/Exception
    //   374	384	254	java/lang/Exception
    //   74	83	387	finally
    //   85	96	387	finally
    //   98	109	387	finally
    //   111	122	387	finally
    //   124	133	387	finally
    //   135	142	387	finally
    //   144	152	387	finally
    //   180	199	387	finally
    //   201	210	387	finally
    //   212	219	387	finally
    //   221	239	387	finally
    //   241	251	387	finally
    //   257	267	387	finally
    //   281	290	387	finally
    //   292	299	387	finally
    //   301	320	387	finally
    //   325	334	387	finally
    //   339	356	387	finally
    //   358	372	387	finally
    //   374	384	387	finally
    //   10	68	404	finally
    //   10	68	410	java/lang/Exception
  }
  
  public static String getPluginID()
  {
    return QZonePluginUtils.a();
  }
  
  public static String getPluginId()
  {
    return QZonePluginUtils.a();
  }
  
  public static String getPluginVersion()
  {
    String str = QZonePluginUtils.a();
    if (!str.equals("qzone_live_video_plugin.apk")) {
      QZonePluginMangerHelper.a(getContext(), new ypv(str));
    }
    for (;;)
    {
      return version;
      version = "2013 6.5.5";
    }
  }
  
  public static String getQUA3()
  {
    return QUA.a();
  }
  
  public static int getRegionWidth(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (int)(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 0.7D);
  }
  
  public static String getServerListCmdPrefix()
  {
    return ServerListProvider.a();
  }
  
  public static SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return BaseApplicationImpl.a().getSharedPreferences(paramString, paramInt);
  }
  
  public static String getStringConfig(String paramString1, String paramString2, String paramString3)
  {
    return QzoneConfig.a().a(paramString1, paramString2, paramString3);
  }
  
  public static long getSystemAvaialbeMemory()
  {
    return DeviceInfoUtil.c() / 1048576L;
  }
  
  public static String getVersion()
  {
    return AppSetting.d();
  }
  
  public static String getVideoPlayCacheDir()
  {
    return CacheManager.c();
  }
  
  public static int getVipLevel()
  {
    return QZoneVipInfoManager.a().b();
  }
  
  public static int getVipType()
  {
    return QZoneVipInfoManager.a().a();
  }
  
  public static void init(long paramLong)
  {
    CacheManager.a(paramLong);
  }
  
  public static void initUpload()
  {
    if (!IUploadService.UploadServiceCreator.getInstance().isInitialized()) {
      IUploadService.UploadServiceCreator.getInstance().init(getApplication(), new ypx(getAppId()), null, null, new UploadEnv());
    }
  }
  
  public static boolean isAnnualVip()
  {
    return QZoneVipInfoManager.a().a();
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static boolean isFileExist(String paramString)
  {
    return FileUtils.a(paramString);
  }
  
  public static boolean isMobile()
  {
    return NetworkState.b();
  }
  
  public static boolean isNetSupport()
  {
    return NetworkState.d();
  }
  
  public static boolean isServerListDebug()
  {
    return ServerListProvider.a();
  }
  
  public static boolean isServerListFileExits()
  {
    return ServerListProvider.b();
  }
  
  public static boolean isValidUrl(String paramString)
  {
    return HttpUtil.a(paramString);
  }
  
  public static boolean isVideoInteractSupport()
  {
    QZoneVideoCommonUtils.VideoSupport localVideoSupport = QZoneVideoCommonUtils.a();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLiveVideoInterface", 2, "isVideoInteractSupport " + localVideoSupport.a());
    }
    return localVideoSupport.a();
  }
  
  public static boolean isWap()
  {
    initUpload();
    return NetworkState.a();
  }
  
  public static boolean isWifiConn()
  {
    return NetworkState.c();
  }
  
  public static void launchLiveVideo(String paramString1, String paramString2, String paramString3)
  {
    if (QzoneConfig.a().a("LiveSetting", "LiveVideoFloatLayerEntry", 1) == 1)
    {
      if (supportLaunchLiveVideo())
      {
        paramString1 = Uri.parse("mqzonev2://arouse/livevideo?room=&uin=&nickname=&source=qq&version=1&type=1&syncuin=" + paramString1 + "&from=" + paramString3);
        paramString2 = new Intent();
        paramString2.setData(paramString1);
        paramString2.setPackage("com.qzone");
        paramString2.setFlags(268435456);
        BaseApplicationImpl.getContext().startActivity(paramString2);
        return;
      }
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = QzoneConfig.a().a("LiveSetting", "LiveVideoDuliDownload", "http://act.qzone.qq.com/meteor/ekko/prod/57512bc9fbd5ebd076552787/index.html?_wv=1");
      }
      paramString2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("fromQZone", true);
      if (WebViewPluginFactory.a.containsKey("Qzone")) {
        paramString2.putExtra("insertPluginsArray", new String[] { "Qzone" });
      }
      paramString2.setData(Uri.parse(paramString1));
      paramString2.addFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(paramString2);
      return;
    }
    paramString1 = new Intent();
    paramString1.setClassName(BaseApplicationImpl.getContext(), getLiveVideoDownLoadClassName());
    paramString1.putExtra("mode", 1);
    paramString1.putExtra("from", paramString3);
    paramString1.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(paramString1);
  }
  
  public static boolean loadFilterSo(Context paramContext)
  {
    return PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
  }
  
  public static boolean loadNativeLibrary(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    return SoLoadUtil.a(paramContext, paramString, paramInt, paramBoolean);
  }
  
  public static Toast makeToast(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    return QQToast.a(BaseApplication.getContext(), paramInt1, paramCharSequence, paramInt2).a(paramInt3);
  }
  
  public static void publishMood(String paramString, ArrayList paramArrayList1, int paramInt1, int paramInt2, ArrayList paramArrayList2, long paramLong, HashMap paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param.content", paramString);
    localBundle.putStringArrayList("param.images", paramArrayList1);
    localBundle.putInt("param.quality", paramInt1);
    localBundle.putInt("param.priv", paramInt2);
    localBundle.putStringArrayList("param.privList", paramArrayList2);
    localBundle.putLong("param.time", paramLong);
    localBundle.putSerializable("param.extMap", paramHashMap);
    RemoteHandleManager.a().a("cmd.publishMood", localBundle, false);
  }
  
  public static void shareToQQ(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    paramActivity = new Intent(localActivity, ForwardRecentActivity.class);
    paramActivity.putExtra("forward_type", 2);
    paramActivity.putExtra("req_type", 1);
    paramActivity.putExtra("req_share_id", Long.parseLong("1103584836"));
    paramActivity.putExtra("title", paramString1);
    paramActivity.putExtra("image_url_remote", paramString3);
    paramActivity.putExtra("desc", paramString2);
    paramActivity.putExtra("detail_url", paramString4);
    localActivity.startActivity(paramActivity);
  }
  
  public static void shareToQzone(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.b = paramString1;
    localQZoneShareData.c = paramString2;
    localQZoneShareData.a = new ArrayList();
    localQZoneShareData.a.add(paramString3);
    localQZoneShareData.d = paramString4;
    localQZoneShareData.g = 0;
    localQZoneShareData.f = paramString5;
    QZoneShareManager.a(paramContext, paramString5, localQZoneShareData, null, paramInt);
  }
  
  public static void showToastInQZone(CharSequence paramCharSequence)
  {
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("param.toastText", paramCharSequence);
    RemoteHandleManager.a().a("cmd.showToast", localBundle, false);
  }
  
  public static void startAlbumListActivity(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    int i = getRegionWidth((Activity)paramContext);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", PhotoListActivity.class.getName());
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt1);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt2);
    localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.qzone.cover.ui.activity");
    paramContext.startActivity(localIntent);
  }
  
  public static void startPhotoCropActivity(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    int i = getRegionWidth((Activity)paramContext);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", PhotoCropActivity.class.getName());
    localIntent.putExtra("fromWhereClick", 10);
    localIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramContext.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString2);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", i);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", i);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt1);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt2);
    localIntent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.qzone.cover.ui.activity");
    paramContext.startActivity(localIntent);
  }
  
  public static void startSelectMemberForResult(Context paramContext, Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.setClassName("com.tencent.mobileqq", SelectMemberActivity.class.getName());
    if (paramContext != null) {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    }
  }
  
  public static boolean supportLaunchLiveVideo()
  {
    boolean bool2 = false;
    Object localObject = null;
    try
    {
      PackageInfo localPackageInfo = BaseApplicationImpl.getContext().getPackageManager().getPackageInfo("com.qzone", 0);
      localObject = localPackageInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      boolean bool1;
      for (;;) {}
    }
    bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((PackageInfo)localObject).versionCode >= 91) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\QzoneLiveVideoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */