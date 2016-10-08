package cooperation.qzone;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.SurfaceView;
import com.facebook.stetho.common.ProcessUtil;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.video.QzoneVideoPluginProxyService;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.MD5;
import ykp;
import ykq;
import ykr;

public class QZoneHelper
{
  public static final String A = "isconcern";
  public static final String B = "uin";
  public static final String C = "JsCallNativeAction";
  public static final String D = "NativeCallJsAction";
  public static final String E = "videoPluginSupportTrim";
  public static final String F = "bNeedCallBack";
  public static final String G = "SQQzoneSvc.";
  public static final String H = "qzone_entry";
  public static final String I = "key_has_talk";
  public static final String J = "key_nearby_profile";
  public static final String K = "key_nearby_qzone_to_aio";
  public static final String L = "nearby_qzone_to_aio";
  public static final String M = "qqid";
  public static final String N = "famous_space_webview_url";
  public static final String O = "famous_space_page_type";
  public static final String P = "QzoneFamousSpaceSp";
  public static final String Q = "k_modal";
  public static final String R = "k_hide_qzone_icon";
  public static final String S = "qqid";
  public static final String T = "com.qzone.detail.ui.activity.QzoneDetailActivity";
  public static final String U = "com.qzone.publish.ui.activity.QZonePublishMoodActivity";
  public static final String V = "com.qzone.publish.ui.activity.QZonePublishOperationMoodActivity";
  public static final String W = "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity";
  public static final String X = "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity";
  public static final String Y = "com.qzone.album.ui.activity.QZonePersonalAlbumActivity";
  public static final String Z = "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity";
  private static final int a = 1;
  public static final String a;
  public static boolean a = false;
  public static final String aA = "FriendProfileCardActivity";
  public static final String aB = "MainAssistObserver";
  public static final String aC = "Leba";
  public static final String aD = "QZoneDistributedAppCtrl";
  public static final String aE = "MsgNotification";
  public static final String aF = "troop_chat_pie";
  private static final String aG = "com.qzone.app.QZoneAppInterface";
  private static final String aH = "com.qzone.video.service.QZoneVideoAppInterface";
  private static final String aI = "com.tencent.zebra.app.PhotoplusAppInterface";
  private static final String aJ = "com.qzone.live.app.QZoneLiveVideoAppInterface";
  private static final String aK = "total_retried_times_";
  private static volatile String aL;
  public static final String aa = "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity";
  public static final String ab = "com.qzone.homepage.ui.activity.QZoneUserHomeActivity";
  public static final String ac = "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity";
  public static final String ad = "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity";
  public static final String ae = "com.qzone.setting.QZoneSettingManager";
  public static final String af = "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity";
  public static final String ag = "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity";
  public static final String ah = "com.qzone.lbsv2.ui.QZoneMoodSelectLocation";
  public static final String ai = "com.qzone.feed.ui.activity.QZoneFriendFeedActivity";
  public static final String aj = "com.qzone.cover.ui.activity.QZoneCoverStoreActivity";
  public static final String ak = "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity";
  public static final String al = "com.qzone.share.QZoneShareActionActivity";
  public static final String am = "com.qzone.preview.QzonePictureViewer";
  public static final String an = "com.qzone.video.activity.RecordActivity";
  public static final String ao = "com.qzone.video.activity.TrimVideoActivity";
  public static final String ap = "com.qzone.video.activity.PreviewVideoActivity";
  public static final String aq = "com.qzone.commoncode.module.videorecommend.ui.QzoneVideoRecommendActivity";
  public static final String ar = "com.qzonex.app.tab.QZoneTabActivity";
  public static final String as = "com.qzone.common.activities.FeedActionPanelActivity";
  public static final String at = "com.qzone.web.QZoneTranslucentActivity";
  public static final String au = "qzone";
  public static final String av = "usersummary";
  public static final String aw = "userhome";
  public static final String ax = "主人~~你的手机系统不太适应漂浮装扮，请升级后再体验";
  public static final String ay = "com.tencent.qq.syncQunMsg";
  public static final String az = "com.tencent.qq.unreadcount";
  private static final int jdField_b_of_type_Int = 1100;
  public static final String b = "qzone_key_publish_mood_camera_flag";
  private static boolean jdField_b_of_type_Boolean = false;
  private static final int jdField_c_of_type_Int = 700;
  public static final String c = "qzone_key_skip_from_widget";
  private static boolean jdField_c_of_type_Boolean = false;
  private static final int jdField_d_of_type_Int = 3;
  public static final String d = "qzone_start";
  private static volatile boolean jdField_d_of_type_Boolean = false;
  public static final String e = "key_select_poi";
  public static final String f = "com.qzone";
  public static final String g = "com.tencent.qqmusic";
  public static final String h = "com.adobe.flashplayer";
  public static final String i = "aciton_check_qzone_vip_info";
  public static final String j = "requestQzoneOpenVip";
  public static final String k = "qzone_vip_open_succ_str";
  public static final String l = "http://pay.qq.com/h5/index.shtml?m=buy&c=xxjzgw&aid={AID}&sid={SID}&u={UIN}&pf=2103&su=pay%3A%2F%2FrequestQzoneOpenVip";
  public static final String m = "pay://requestQzoneOpenVip";
  public static final String n = "key_qzone_vip_open_back_need_check_vipinfo";
  public static final String o = "file" + File.separator + "image";
  public static final String p = "qzone_uin";
  public static final String q = "nickname";
  public static final String r = "sid";
  public static final String s = "com.qzone.preview.service.PictureService";
  public static final String t = "com.qzone.publish.service.PublishQueueService";
  public static final String u = "com.qzone.intent.action.PRELOAD_FRIEND_FEEDS";
  public static final String v = "com.qzone.intent.action.PRELOAD_USER_HOME";
  public static final String w = "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS";
  public static final String x = "com.qzone.intent.action.LAUNCH_BY_WEB_MUSIC";
  public static final String y = "com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE";
  public static final String z = "com.qzone.intent.action.HABO_REPORT";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = QZoneHelper.class.getSimpleName();
  }
  
  public static int a()
  {
    int i1 = QzoneConfig.a().a("QZoneSetting", "UpdateCountIntervalWhenClickFeedTab", 30) * 1000;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString + ".UndealCount", 2, "getUpdateCountIntervalWhenClickFeedTab:" + i1);
    }
    return i1;
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, int paramInt)
  {
    paramPluginRuntime = paramPluginRuntime.a();
    int i1 = paramInt;
    if ((paramPluginRuntime instanceof WebViewPluginContainer)) {
      i1 = ((WebViewPluginContainer)paramPluginRuntime).switchRequestCode(paramWebViewPlugin, (byte)paramInt);
    }
    return i1;
  }
  
  public static Intent a()
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    return localIntent;
  }
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.a(paramContext, "com.qzone.feed.ui.activity.QZoneSpecialActiveFeedsActivity");
    return paramContext;
  }
  
  private static Intent a(Context paramContext, Long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_left_tab_title", paramContext.getString(2131366974));
    localIntent.putExtra("key_rihgt_tab_title", paramContext.getString(2131366975));
    localIntent.putExtra("key_album_owner_uin", paramLong);
    localIntent.putExtra("key_selected_tab", paramInt);
    a(localIntent);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.album.ui.activity.QZonePersonalAlbumActivity");
    return localIntent;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, Serializable paramSerializable, Parcelable paramParcelable, int paramInt2, String paramString5, boolean paramBoolean)
  {
    paramContext = new Intent();
    paramContext.putExtra("autoSaveStorageKey", paramString5);
    paramContext.putExtra("extraRequestCode", paramInt2);
    paramContext.putExtra("showkeyicon", paramInt1);
    if (paramString3 != null) {
      paramContext.putExtra("extraCommentID", paramString3);
    }
    if (paramString4 != null) {
      paramContext.putExtra("extraReplyID", paramString4);
    }
    if (paramSerializable != null) {
      paramContext.putExtra("extraIntentKey", paramSerializable);
    }
    if (paramString2 != null) {
      paramContext.putExtra("feedTextAutoFillKey", paramString2);
    }
    if (paramParcelable != null) {
      paramContext.putExtra("extraIntentKeyParcelable", paramParcelable);
    }
    if (paramString1 != null) {
      paramContext.putExtra("feedTextHintKey", paramString1);
    }
    paramContext.putExtra("extraIsSystemTransparentBar", 1);
    return paramContext;
  }
  
  private static Intent a(QZoneHelper.UserInfo paramUserInfo, String paramString)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, paramString);
    return localIntent;
  }
  
  public static Intent a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qqid", Long.parseLong(paramString));
    localIntent.putExtra("qzone_entry", paramInt);
    a(localIntent);
    return localIntent;
  }
  
  private static Intent a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("QZoneUploadPhotoActivity.key_state_type_src", paramInt);
    paramString1.putExtra("key_qun_id", paramString2);
    paramString1.putExtra("ken_qun_name", paramString3);
    paramString1.putExtra("UploadPhoto.key_album_id", paramString4);
    paramString1.putExtra("UploadPhoto.key_album_name", paramString5);
    paramString1.putExtra("key_need_load_photo_from_intent", false);
    paramString1.putExtra("refer", paramString6);
    paramString1.putExtra("IsBack", true);
    return paramString1;
  }
  
  public static Bundle a(String paramString)
  {
    int i1 = 0;
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int i2 = paramString.indexOf('?');
    if ((i2 < 0) || (i2 + 1 >= paramString.length())) {
      return localBundle;
    }
    paramString = paramString.substring(i2 + 1);
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i1 < paramString.length))
      {
        String[] arrayOfString = paramString[i1].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i1 += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return localBundle;
  }
  
  public static SurfaceView a(Context paramContext, String paramString)
  {
    try
    {
      if (e())
      {
        ToastUtil.a().a("主人~~你的手机系统不太适应漂浮装扮，请升级后再体验", 1);
        return null;
      }
      try
      {
        Class localClass1 = Class.forName("com.qzone.floatobject.ui.FloatItemView");
        if (localClass1 == null)
        {
          QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
          return null;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Class localClass2;
        for (;;)
        {
          ClassLoader localClassLoader = QzonePluginProxyActivity.a(paramContext);
          localClass2 = localClassLoader.loadClass("com.qzone.floatobject.ui.FloatItemView");
          BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        }
        paramContext = localClass2.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        localClass2.getMethod("initObjects", new Class[] { String.class, Boolean.TYPE }).invoke(paramContext, new Object[] { paramString, Boolean.valueOf(true) });
        if (paramContext == null) {
          break label154;
        }
      }
      if ((paramContext instanceof SurfaceView))
      {
        paramContext = (SurfaceView)paramContext;
        return paramContext;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        label154:
        paramContext.printStackTrace();
      }
    }
  }
  
  public static IUploadConfig.UploadImageSize a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      Class localClass = Class.forName("com.qzone.network.uploader.QZoneImageSizeStrategy");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "*QZoneImageSizeStrategy load class fail");
          return null;
        }
        catch (ClassNotFoundException paramContext)
        {
          ClassLoader localClassLoader;
          paramContext.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.a(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.network.uploader.QZoneImageSizeStrategy");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      return null;
      paramContext = (IUploadConfig.UploadImageSize)paramContext.getMethod("getTargetSize", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    if (paramContext != null) {}
  }
  
  public static BaseBusinessAlbumInfo a(String paramString1, String paramString2)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    paramString2 = LocalMultiProcConfig.a(str, "");
    paramString1 = LocalMultiProcConfig.a(paramString1, "");
    paramString2 = new BaseBusinessAlbumInfo(paramString2);
    paramString2.jdField_b_of_type_JavaLangString = paramString1;
    return paramString2;
  }
  
  public static String a()
  {
    return QUA.a();
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.tencent.zebra.app.PhotoplusAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "createPhotoPlusAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.b(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.tencent.zebra.app.PhotoplusAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    PerfTracer.a("Runtime_load_runtime");
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qzone.app.QZoneAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = paramString;
        paramString = QzonePluginProxyActivity.a(paramBaseApplicationImpl);
        paramBaseApplicationImpl = paramString.loadClass("com.qzone.app.QZoneAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      for (;;)
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
        {
          paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
          return paramBaseApplicationImpl;
        }
        PerfTracer.b("Runtime_load_runtime");
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.b("Runtime_load_runtime");
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.b("Runtime_load_runtime");
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.b("Runtime_load_runtime");
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.b("Runtime_load_runtime");
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.b("Runtime_load_runtime");
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
        PerfTracer.b("Runtime_load_runtime");
      }
    }
    finally
    {
      PerfTracer.b("Runtime_load_runtime");
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt4, Bundle paramBundle, String paramString4, String paramString5, String paramString6)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    localIntent.putExtra("PhotoConst.VIDEO_TYPE", paramInt1);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_VIDEO_ID", str);
    localIntent.putExtra("file_send_path", paramString2);
    localIntent.putExtra("thumbnail_path", paramString3);
    localIntent.putExtra("thumbnail_height", paramInt3);
    localIntent.putExtra("thumbnail_width", paramInt2);
    localIntent.putExtra("need_process", paramBoolean);
    localIntent.putExtra("start_time", paramLong2);
    localIntent.putExtra("end_time", paramLong3);
    localIntent.putExtra("total_duration", paramLong1);
    localIntent.putExtra("file_send_duration", paramLong3 - paramLong2);
    localIntent.putExtra("sv_total_frame_count", paramInt4);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLong4);
    if (paramBundle != null) {
      localIntent.putExtra("encode_video_params", paramBundle);
    }
    localIntent.putExtra("defaultText", paramString4);
    if (!TextUtils.isEmpty(paramString5)) {
      localIntent.putExtra("refer", paramString5);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localIntent.putExtra("video_refer", paramString6);
    }
    paramString1 = BaseApplicationImpl.a().a().getAccount();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity");
    if (a())
    {
      localIntent.setClassName(paramActivity, "com.qzone.cover.ui.activity.QzoneVideoCoverPreviewActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, -1);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishQueueAcitvity");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.lbsv2.ui.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    for (;;)
    {
      paramInt7 = paramInt2;
      if (paramInt6 == 1)
      {
        paramInt7 = paramInt2;
        if (paramInt2 == 1) {
          if (paramInt2 != 1) {
            break label169;
          }
        }
      }
      label169:
      for (paramInt7 = 1;; paramInt7 = 0)
      {
        paramString1 = a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt7, Integer.valueOf(0), null, paramInt1, "", false);
        a(paramString1, paramUserInfo);
        paramString1.putExtra("showaticon", paramInt3);
        paramString1.putExtra("showemotionicon", paramInt4);
        paramString1.putExtra("showxuantuicon", paramInt5);
        paramString1.putExtra("needtransemoj", 1);
        paramString1.putExtra("sendbtntext", paramString5);
        paramString1.putExtra("inputmax", paramInt8);
        if (paramInt9 != 0)
        {
          paramString1.putExtra("extraIsQun", true);
          paramString1.putExtra("extraIsQunID", String.valueOf(paramInt9));
        }
        QzonePluginProxyActivity.a(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
        QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString1, paramInt1);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9, boolean paramBoolean)
  {
    a(paramActivity, paramUserInfo, paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramString5, paramInt8, paramInt9, paramBoolean, "", false);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, int paramInt9, boolean paramBoolean1, String paramString6, boolean paramBoolean2)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    for (;;)
    {
      paramInt7 = paramInt2;
      if (paramInt6 == 1)
      {
        paramInt7 = paramInt2;
        if (paramInt2 == 1) {
          if (paramInt2 != 1) {
            break label200;
          }
        }
      }
      label200:
      for (paramInt7 = 1;; paramInt7 = 0)
      {
        paramString1 = a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt7, Integer.valueOf(0), null, paramInt1, "", false);
        a(paramString1, paramUserInfo);
        paramString1.putExtra("showaticon", paramInt3);
        paramString1.putExtra("showemotionicon", paramInt4);
        paramString1.putExtra("showxuantuicon", paramInt5);
        paramString1.putExtra("needtransemoj", 1);
        paramString1.putExtra("sendbtntext", paramString5);
        paramString1.putExtra("inputmax", paramInt8);
        if (paramInt9 != 0)
        {
          paramString1.putExtra("extraIsQun", true);
          paramString1.putExtra("extraIsQunID", String.valueOf(paramInt9));
        }
        if (!TextUtils.isEmpty(paramString6)) {
          paramString1.putExtra("extraCacheKey", paramString6);
        }
        paramString1.putExtra("is_live_mode", paramBoolean2);
        QzonePluginProxyActivity.a(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
        QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString1, paramInt1, null, paramBoolean1);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString5, int paramInt8, Bundle paramBundle)
  {
    if (paramInt6 == 0) {
      paramInt2 = -1;
    }
    for (;;)
    {
      paramInt7 = paramInt2;
      if (paramInt6 == 1)
      {
        paramInt7 = paramInt2;
        if (paramInt2 == 1) {
          if (paramInt2 != 1) {
            break label163;
          }
        }
      }
      label163:
      for (paramInt7 = 1;; paramInt7 = 0)
      {
        paramString1 = a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt7, Integer.valueOf(0), null, paramInt1, "", false);
        a(paramString1, paramUserInfo);
        paramString1.putExtra("showaticon", paramInt3);
        paramString1.putExtra("showemotionicon", paramInt4);
        paramString1.putExtra("showxuantuicon", paramInt5);
        paramString1.putExtra("needtransemoj", 1);
        paramString1.putExtra("sendbtntext", paramString5);
        paramString1.putExtra("inputmax", paramInt8);
        paramString1.putExtra("extra_key_bundle_priv", paramBundle);
        paramString1.putExtra("video_edit_mode", true);
        QzonePluginProxyActivity.a(paramString1, "com.qzone.common.activities.FeedActionPanelActivity");
        QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString1, paramInt1, null, true);
        return;
      }
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.permissionsetting.ui.activities.QZoneSinglePermissionSettingActivity");
    localIntent.putExtra("qqid", paramLong);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent)
  {
    a(paramActivity, paramUserInfo, paramIntent, -1);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt)
  {
    a(paramIntent, paramUserInfo);
    if (paramInt >= 0) {
      paramIntent.putExtra("bNeedCallBack", true);
    }
    for (;;)
    {
      QzonePluginProxyActivity.a(paramIntent, "com.qzone.web.QZoneTranslucentActivity");
      QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramIntent, paramInt);
      return;
      paramIntent.putExtra("bNeedCallBack", false);
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramIntent, paramInt, paramOnDismissListener, true);
  }
  
  @Deprecated
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, ArrayList paramArrayList, int paramInt2, int paramInt3)
  {
    paramString1 = a(null, 1, paramString1, paramString2, paramString3, paramString4, "mqqChat");
    a(paramString1, paramUserInfo);
    QzonePluginProxyActivity.a(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    if (paramString1 == null) {
      return;
    }
    int i1 = paramInt1;
    switch (paramInt1)
    {
    default: 
      i1 = paramInt1;
    }
    for (;;)
    {
      paramString1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      paramString1.putExtra("key_quality", i1);
      paramString1.putExtra("key_album_upload_immediately", true);
      paramString1.putExtra("photoactivity_key_type", 1);
      paramString1.putExtra("up_way", paramInt3);
      paramString2 = String.valueOf(MessageUtils.a());
      paramIntent.putExtra("key_upload_client_key", paramString2);
      paramString1.putExtra("key_upload_client_key", paramString2);
      QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString1, paramInt2);
      return;
      i1 = 0;
      continue;
      i1 = 3;
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = a(paramUserInfo, "com.qzone.album.ui.activity.QZonePersonalAlbumSelectActivity");
    localIntent.putExtras(paramBundle);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtra("key_album_id", paramBaseBusinessAlbumInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_album_name", paramBaseBusinessAlbumInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_album_owner_uin", paramBaseBusinessAlbumInfo.jdField_a_of_type_Long);
    localIntent.putExtra("key_is_individual_album", paramBaseBusinessAlbumInfo.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_personal_album_enter_model", 0);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, BaseBusinessAlbumInfo paramBaseBusinessAlbumInfo, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity");
    localIntent.putExtra("key_album_id", paramBaseBusinessAlbumInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_album_name", paramBaseBusinessAlbumInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_album_owner_uin", paramBaseBusinessAlbumInfo.jdField_a_of_type_Long);
    localIntent.putExtra("key_is_individual_album", paramBaseBusinessAlbumInfo.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_album_anonymity", paramBaseBusinessAlbumInfo.d);
    localIntent.putExtra("QZ_ALBUM_THEME", paramBaseBusinessAlbumInfo.c);
    localIntent.putExtra("key_personal_album_enter_model", 2);
    localIntent.putExtra("key_album_refer", paramString);
    if (a())
    {
      localIntent.setClassName(paramActivity, "com.qzone.album.ui.activity.QZonePersonalPhotoListActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, CoverCacheData paramCoverCacheData, String paramString, int paramInt)
  {
    paramUserInfo = QZoneHelper.QZoneCoverConstants.a(paramUserInfo.jdField_a_of_type_JavaLangString, paramString, "usersummary", true);
    paramCoverCacheData = new Intent(paramActivity, QQBrowserActivity.class);
    paramCoverCacheData.putExtra("url", paramUserInfo);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramCoverCacheData.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramCoverCacheData.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramCoverCacheData, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramUserInfo, paramLong, paramInt1, paramInt2, paramInt3, null);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    paramLong = a(paramActivity, paramLong, paramInt1);
    a(paramLong, paramUserInfo);
    a(paramLong, paramInt2);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramLong, paramInt3, paramPreloadProcHitPluginSession);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    LocalMultiProcConfig.b("key_photo_guide_is_red", paramBoolean);
    paramLong = a(paramActivity, paramLong, paramInt1);
    a(paramLong, paramUserInfo);
    paramLong.putExtra("startup_sceneid", 3);
    paramLong.putExtra("key_need_show_album_recent_photo", true);
    paramLong.putExtra("refer", "mqqSetting");
    paramLong.putExtra("key_redTouch", paramBoolean);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramLong, paramInt2);
  }
  
  @Deprecated
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramUserInfo, paramString, paramInt1, paramInt2, paramInt3, null);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, int paramInt3, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    paramString = a(paramString, paramInt3);
    a(paramString, paramUserInfo);
    QzonePluginProxyActivity.a(paramString, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramString.putExtra("startup_sceneid", 2);
    a(paramString, paramInt1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString, paramInt2, paramPreloadProcHitPluginSession);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ProfileActivity.AllInOne paramAllInOne)
  {
    paramString = a(paramString, 6);
    a(paramString, paramUserInfo);
    QzonePluginProxyActivity.a(paramString, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramString.putExtra("key_has_talk", paramBoolean);
    paramString.putExtra("key_nearby_profile", paramAllInOne);
    paramString.putExtra("startup_sceneid", 2);
    a(paramString, paramInt1);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramString, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("qzone.cellid", paramString);
    localIntent.putExtra("qzone.sourceFrom", true);
    localIntent.putExtra("qzone.favorOwner", paramLong);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_select_video", true);
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramLong);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", paramInt2);
    if (paramActivity.getIntent() != null) {
      localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", paramActivity.getIntent().getBooleanExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("refer", paramString2);
    }
    localIntent.putExtra("video_refer", paramString3);
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.video.activity.TrimVideoActivity");
    if (a())
    {
      localIntent.setClassName(paramActivity, "com.qzone.video.activity.TrimVideoActivity");
      paramActivity.startActivity(localIntent);
      return;
    }
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_VIP");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("uin", paramLong);
    if (!TextUtils.isEmpty(paramString2))
    {
      localIntent.putExtra("direct_go", false);
      localIntent.putExtra("key_open_qzone_vip_dialog_title", paramString2);
    }
    for (;;)
    {
      QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
      return;
      localIntent.putExtra("direct_go", true);
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, long paramLong, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_OPEN_VIP");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", paramString1);
    localIntent.putExtra("provide_uin", paramLong);
    localIntent.putExtra("success_tips", paramString3);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localIntent.putExtra("direct_go", paramBoolean);
      localIntent.putExtra("need_loading_dialog", true);
      localIntent.putExtra("key_open_qzone_vip_dialog_title", paramString2);
      QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
      return;
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("appid", paramInt1);
    localIntent.setFlags(67108864);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_PUBLISH_QR_CODE");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    localIntent.putExtra("startup_sceneid", 5);
    localIntent.putExtra("key_file_path", paramString1);
    localIntent.putExtra("key_title", paramString2);
    localIntent.putExtra("key_desc", paramString3);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    localIntent.putExtra("startup_sceneid", 4);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    try
    {
      long l1 = Long.parseLong(paramString1);
      int i1 = Integer.valueOf(paramString2).intValue();
      paramString1 = new Bundle();
      paramString1.putLong("targetuin", l1);
      paramString1.putInt("appid", i1);
      paramString1.putString("subid", paramString4);
      paramString1.putString("cellid", paramString3);
      paramString1.putBoolean("messagelist", true);
      localIntent.putExtras(paramString1);
      QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "forwardToDetail error", paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("startup_sceneid", 6);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_RESHIP_FROM_QUN_AIO_TO_QUN");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("startup_sceneid", 6);
    localIntent.putExtra("key_qun_id", paramString1);
    localIntent.putExtra("key_qun_code", paramString2);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList3);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    paramUserInfo = QzoneConfig.a().a("QunAlbumSetting", "QunFeed", "http://h5.qzone.qq.com/groupphoto/inqq/recent/{QUN_ID}/groupphoto?_wv=3").replace("{QUN_ID}", paramString1);
    paramString1 = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString1.putExtra("url", paramUserInfo);
    paramString1.putExtra("fromQZone", true);
    paramString1.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
    paramString1.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("startup_sceneid", 6);
    if (paramBoolean)
    {
      localIntent.putExtra("key_qun_id", paramString1);
      localIntent.putExtra("key_qun_code", paramString2);
      localIntent.putExtra("key_big_photo_file_id", paramLong2);
    }
    localIntent.putExtra("key_quote_src_type", paramInt1);
    localIntent.putExtra("key_thumb_file_path", paramString3);
    localIntent.putExtra("key_big_photo_uuid", paramString4);
    localIntent.putExtra("key_msg_time", paramLong1);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, boolean paramBoolean, String paramString1, String paramString2, int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.intent.QZONE_QUOTE_FROM_AIO");
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("startup_sceneid", 6);
    if (paramBoolean)
    {
      localIntent.putExtra("key_qun_id", paramString1);
      localIntent.putExtra("key_qun_code", paramString2);
      localIntent.putExtra("key_big_photo_fileids", paramArrayList4);
    }
    localIntent.putExtra("key_quote_src_type", paramInt1);
    localIntent.putExtra("key_thumb_file_paths", paramArrayList1);
    localIntent.putExtra("key_big_photo_uuids", paramArrayList2);
    localIntent.putExtra("key_msg_times", paramArrayList3);
    localIntent.putExtra("refer", "mqqChat");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.flashnickname.ui.QZoneFlashNickNameSetting");
    QzonePluginProxyActivity.a(paramActivity, paramString, localIntent, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, int paramInt5)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = paramString1;
    paramString1 = a(null, paramInt1, String.valueOf(paramInt3), paramString2, paramString3, paramString4, "mqqChat");
    paramString1.putExtra("photoactivity_key_type", paramInt2);
    paramString1.putExtra("up_way", paramInt5);
    a(paramString1, localUserInfo);
    QzonePluginProxyActivity.a(paramString1, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    QzonePluginProxyActivity.a(paramActivity, localUserInfo.jdField_a_of_type_JavaLangString, paramString1, paramInt4);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.setData(Uri.parse(paramString1));
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = null;; paramString1 = paramString2.getBytes())
    {
      if (paramString1 != null) {
        localIntent.putExtra("post_data", paramString1);
      }
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QzonePluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.stopService(new Intent(paramContext, QzonePluginPublishQueueProxyService.class));
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.qq.syncQunMsg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.tencent.qq.unreadcount", paramInt);
    localIntent.putExtras(localBundle);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Context paramContext, QZoneHelper.UserInfo paramUserInfo)
  {
    paramUserInfo = QzoneConfig.a().a("H5Url", "QzonePictureSettingPage", "http://h5.qzone.qq.com/image/setting/imageSetting?_wv=3&_proxy=1&uin={uin}").replace("{uin}", String.valueOf(paramUserInfo.jdField_a_of_type_JavaLangString)).replace("{host_uin}", paramUserInfo.jdField_a_of_type_JavaLangString).replace("{UIN}", String.valueOf(paramUserInfo.jdField_a_of_type_JavaLangString)).replace("{HOST_UIN}", paramUserInfo.jdField_a_of_type_JavaLangString);
    if (!URLUtil.b(paramUserInfo).containsKey("_wv")) {
      URLUtil.a(paramUserInfo, "_wv", "5");
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "jump qzone setting URL:" + paramUserInfo);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramUserInfo);
    localIntent.putExtra("isFromQQ", true);
    localIntent.putExtra("fromQZone", false);
    localIntent.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
    localIntent.setData(Uri.parse(paramUserInfo));
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, Object paramObject)
  {
    if ((paramContext == null) || (paramObject == null)) {
      return;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.floatobject.ui.FloatItemView");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ClassLoader localClassLoader = QzonePluginProxyActivity.a(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.floatobject.ui.FloatItemView");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramContext == null) {
      try
      {
        QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    paramContext.getMethod("stop", new Class[0]).invoke(paramObject, new Object[0]);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:picture");
      localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzonevideo");
      CacheManager.a(paramContext);
      if (!TextUtils.isEmpty(paramString)) {
        paramContext.deleteDatabase(SecurityUtil.a(paramString));
      }
      QZConfigProviderUtil.a();
      paramContext = paramContext.getFilesDir().getParent() + File.separator + "shared_prefs";
      if (!TextUtils.isEmpty(paramContext))
      {
        FileUtil.c(paramContext + File.separator + "qz_predownload_config.xml");
        FileUtil.c(paramContext + File.separator + "QZ_Per_Config.xml");
        FileUtil.c(paramContext + File.separator + "QZONE_UNREAD.xml");
      }
      paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace";
    } while (paramContext == null);
    FileUtil.c(paramContext);
  }
  
  public static void a(Context paramContext, String paramString, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramContext, QzoneVideoPluginProxyService.class);
    localIntent.putExtra("qzone_uin", paramString);
    QzoneVideoPluginProxyService.a(paramContext, paramString, localIntent, paramServiceConnection);
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("key_time_record", System.currentTimeMillis());
  }
  
  private static void a(Intent paramIntent, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramIntent.putExtra("refer", "mqqSetProfile");
      return;
    case 2: 
      paramIntent.putExtra("refer", "mqqAvatar");
      return;
    case 3: 
      paramIntent.putExtra("refer", "mqqQuanzi");
      return;
    case 4: 
      paramIntent.putExtra("refer", "mqqNearby");
      return;
    case 5: 
      paramIntent.putExtra("refer", "mqqChat");
      return;
    }
    paramIntent.putExtra("refer", "mqqQunSpace");
  }
  
  public static void a(Intent paramIntent, QZoneHelper.UserInfo paramUserInfo)
  {
    paramIntent.putExtra("qzone_uin", paramUserInfo.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("nickname", paramUserInfo.jdField_b_of_type_JavaLangString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3)
  {
    LocalMultiProcConfig.b("support_trim", paramBoolean1);
    paramUserInfo = new Intent(paramActivity, NewFlowCameraActivity.class);
    paramUserInfo.putExtra("from_type", 1);
    paramUserInfo.putExtra("enable_front", true);
    paramUserInfo.putExtra("enable_edit_video", paramBoolean3);
    paramUserInfo.putExtra("enable_local_video", true);
    paramUserInfo.putExtra("is_qzone_vip", paramBoolean2);
    paramUserInfo.putExtra("set_user_callback", "cooperation.qzone.video.VideoComponentCallback");
    paramUserInfo.putExtra("flow_camera_video_mode", true);
    paramUserInfo.putExtra("flow_camera_capture_mode", false);
    paramUserInfo.putExtra("short_video_refer", paramString2);
    paramUserInfo.putExtra("flow_camera_use_filter_function", PtvFilterSoLoad.a(paramQQAppInterface, BaseApplicationImpl.getContext()));
    paramActivity.startActivity(paramUserInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ServiceConnection paramServiceConnection)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginPublishQueueProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.LAUNCH_PUBLISH_QUEUE");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.a();
    localPluginParams.d = "QQ空间";
    localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    localPluginParams.e = "com.qzone.publish.service.PublishQueueService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "start and bind QzonePublishQueueService");
    }
    IPluginManager.b(paramQQAppInterface.a(), localPluginParams);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    ThreadManager.a(new ykr(paramQQAppInterface, paramPreloadProcHitPluginSession), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong)
  {
    if ((paramQQAppInterface == null) || (c())) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.HABO_REPORT");
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putInt("resultCode", paramInt1);
    localBundle.putString("detail", paramString2);
    localBundle.putInt("frequency", paramInt2);
    localBundle.putLong("timestamp", paramLong);
    localIntent.putExtras(localBundle);
    paramString1 = new IPluginManager.PluginParams(0);
    paramString1.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.a();
    paramString1.d = "QQ空间";
    paramString1.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    paramString1.e = "com.qzone.preview.service.PictureService";
    paramString1.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.i("QPlugin", 2, "Start QZone Haboreport");
    }
    IPluginManager.b(paramQQAppInterface.a(), paramString1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, PreloadProcHitPluginSession paramPreloadProcHitPluginSession)
  {
    if ((paramQQAppInterface == null) || (c())) {
      return;
    }
    if ("MainAssistObserver".equals(paramString))
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
      StatisticHitRateCollector.a().a("actQZLoadHitRateRed", true);
    }
    for (;;)
    {
      ThreadManager.a(new ykq(paramQQAppInterface), null, false);
      try
      {
        localObject = BaseApplicationImpl.a().getSharedPreferences("CrashControl_com.tencent.mobileqq:qzone", 4);
        if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("allowpreload", true)))
        {
          long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
          int i1 = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
          long l2 = System.currentTimeMillis();
          if ((l1 <= 0L) || (i1 <= 0) || (l2 <= l1) || (l2 - l1 <= i1 * 1000)) {
            break;
          }
          ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          localException.printStackTrace();
          continue;
          localException.setAction("com.qzone.intent.action.PRELOAD_FRIEND_FEEDS");
        }
      }
      QLog.d("qzone_launch", 1, "preloadQzone from: " + paramString);
      localObject = new Intent(paramQQAppInterface.a(), QzonePluginProxyService.class);
      try
      {
        ((Intent)localObject).putExtra("useSkinEngine", 1);
        if (!"FriendProfileCardActivity".equals(paramString)) {
          break label446;
        }
        ((Intent)localObject).setAction("com.qzone.intent.action.PRELOAD_USER_HOME");
        ((Intent)localObject).putExtra("cpuNum", DeviceInfoUtil.b());
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      paramString = new IPluginManager.PluginParams(0);
      paramString.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.a();
      paramString.d = "QQ空间";
      paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      paramString.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = paramPreloadProcHitPluginSession;
      paramString.e = "com.qzone.preview.service.PictureService";
      paramString.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
      IPluginManager.b(paramQQAppInterface.a(), paramString);
      return;
      if ("Leba".equals(paramString))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005E9C", "0X8005E9C", 1, 0, "", "", "", "");
        StatisticHitRateCollector.a().a("actQZLoadHitRateLeba", true);
      }
      else if ("FriendProfileCardActivity".equals(paramString))
      {
        StatisticHitRateCollector.a().a("actQZLoadHitRateProfile", true);
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "preloadQzone is not allowed as crash frequently.");
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramQQAppInterface.a(), "actNoPreloadQzone", true, 0L, 0L, null, "");
  }
  
  public static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZoneUploadPhotoActivity");
    localIntent.putExtra("startup_sceneid", 6);
    paramString2 = a(paramString2);
    localIntent.putExtra("IsBack", true);
    if (paramString2.containsKey("albumid")) {
      localIntent.putExtra("UploadPhoto.key_album_id", paramString2.getString("albumid"));
    }
    if (paramString2.containsKey("albumtitle")) {
      localIntent.putExtra("UploadPhoto.key_album_name", paramString2.getString("albumtitle"));
    }
    localIntent.putExtra("photoactivity_key_type", 1);
    localIntent.putExtras(paramString2);
    QzonePluginProxyActivity.a(paramActivity, paramString1, localIntent, a(paramWebViewPlugin, paramPluginRuntime, 1));
  }
  
  public static void a(String paramString, Context paramContext)
  {
    String str = LocalMultiProcConfig.a("qzh5_url", "");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "http://m.qzone.com/infocenter";
    }
    paramString = (String)localObject + "?sid=" + paramString;
    if (paramContext == null) {
      return;
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("plugin_start_time", System.nanoTime());
    ((Intent)localObject).putExtra("click_start_time", System.currentTimeMillis());
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
    paramContext.startActivity(((Intent)localObject).putExtra("url", paramString));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_id");
    paramString1 = MD5.toMD5(paramString1 + "_" + paramString2 + "_album_title");
    LocalMultiProcConfig.a(str, paramString3);
    LocalMultiProcConfig.a(paramString1, paramString4);
  }
  
  public static void a(boolean paramBoolean, QZoneHelper.StartActivity paramStartActivity)
  {
    if (!paramBoolean)
    {
      paramStartActivity.a(false, true);
      return;
    }
    ThreadManager.a(new ykp(paramStartActivity), null, true);
  }
  
  public static boolean a()
  {
    String str = ProcessUtil.getProcessName();
    return (str != null) && (str.endsWith(":qzone"));
  }
  
  public static boolean a(Context paramContext, int paramInt, long paramLong, String paramString)
  {
    boolean bool = true;
    try
    {
      Object localObject1 = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
      if (localObject1 != null)
      {
        i1 = ((PackageInfo)localObject1).versionCode;
        if (i1 >= paramInt)
        {
          if (bool)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("qqid", paramLong);
            ((Bundle)localObject1).putLong("uin", paramLong);
            ((Bundle)localObject1).putBoolean("isbackmenu", false);
            ((Bundle)localObject1).putString("selfUin", String.valueOf(paramLong));
            ((Bundle)localObject1).putString("AccountInfoSync", "mobileqq.service");
            ((Bundle)localObject1).putString("ClassNameSync", paramString);
            paramString = new Intent();
            paramString.setClassName("com.qzone", "com.qzone.QZoneSyncAccountActivity");
            paramString.putExtras((Bundle)localObject1);
            paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            paramContext.startActivity(paramString);
          }
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        int i1;
        if (QLog.isColorLevel()) {
          QLog.d("QZoneHelper", 2, localNameNotFoundException.getMessage());
        }
        Object localObject2 = null;
        continue;
        if (i1 >= 80)
        {
          paramString = new Intent();
          paramString.setData(Uri.parse("mqzone://arouse/activefeed?source=qq&version=1"));
          paramString.setPackage("com.qzone");
          paramContext.startActivity(paramString);
          return true;
        }
        bool = false;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getInstalledPackages(4).iterator();
    while (paramContext.hasNext()) {
      if (paramString.equals(((PackageInfo)paramContext.next()).packageName)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      if (Build.VERSION.SDK_INT != 18) {
        return false;
      }
      String str = Build.MODEL;
      if ((str != null) && (str.length() != 0) && (paramString != null) && (paramString.length() != 0))
      {
        str = "," + str + ",";
        boolean bool = ("," + paramString + ",").contains(str);
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static int b()
  {
    return QzoneConfig.a().a("MiniVideo", "VideoCanUploadDurationThreshold", 600000);
  }
  
  public static Intent b(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.a(paramContext, "com.qzone.feed.ui.activity.QZoneMyFeedActivity");
    return paramContext;
  }
  
  public static AppRuntime b(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (paramBaseApplicationImpl == null) {
      return null;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.live.app.QZoneLiveVideoAppInterface");
      paramBaseApplicationImpl = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "createQzoneLiveAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = QzonePluginProxyActivity.c(paramBaseApplicationImpl);
        paramBaseApplicationImpl = localClassLoader.loadClass("com.qzone.live.app.QZoneLiveVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      do
      {
        return null;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static AppRuntime b(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qzone.video.service.QZoneVideoAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("QZLog", 1, "*createQZoneVideoAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramBaseApplicationImpl = QzonePluginProxyActivity.a(paramBaseApplicationImpl).loadClass("com.qzone.video.service.QZoneVideoAppInterface");
        continue;
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime))) {
          break label87;
        }
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
      return null;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl != null) {}
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    paramUserInfo = QzoneConfig.a().a("H5Url", "QzoneSettingMainPage", "http://h5.qzone.qq.com/qzone/setting?_wv=3&_proxy=1&uin={uin}").replace("{uin}", String.valueOf(paramUserInfo.jdField_a_of_type_JavaLangString)).replace("{host_uin}", paramUserInfo.jdField_a_of_type_JavaLangString).replace("{UIN}", String.valueOf(paramUserInfo.jdField_a_of_type_JavaLangString)).replace("{HOST_UIN}", paramUserInfo.jdField_a_of_type_JavaLangString);
    if (!URLUtil.b(paramUserInfo).containsKey("_wv")) {
      URLUtil.a(paramUserInfo, "_wv", "5");
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "jump qzone setting URL:" + paramUserInfo);
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramUserInfo);
    localIntent.putExtra("isFromQQ", true);
    localIntent.putExtra("fromQZone", false);
    localIntent.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
    localIntent.setData(Uri.parse(paramUserInfo));
    localIntent.addFlags(268435456);
    paramActivity.startActivity(localIntent);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Intent paramIntent, int paramInt)
  {
    paramIntent = new Intent(paramIntent);
    a(paramIntent, paramUserInfo);
    QzonePluginProxyActivity.a(paramIntent, "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, paramIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = a(paramUserInfo, "com.qzone.preview.QzonePictureViewer");
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("fromQZone", false);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt, null, false);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString, int paramInt)
  {
    paramUserInfo = QzoneConfig.a().a("QunAlbumSetting", "QunPassiveFeed", "http://h5.qzone.qq.com/groupphoto/inqq/relatedme/{QUN_ID}/{UIN}?_wv=3").replace("{QUN_ID}", paramString).replace("{UIN}", paramUserInfo.jdField_a_of_type_JavaLangString);
    paramString = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString.putExtra("url", paramUserInfo);
    paramString.putExtra("fromQZone", true);
    paramString.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
    paramString.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramString, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("jumpToDetailFromQQWhat", 0);
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.detail.ui.activity.QzoneDetailActivity");
    localIntent.putExtra("jumpToDetailFromQQWhat", 1);
    localIntent.putExtra("startup_sceneid", 4);
    localIntent.putExtra("mqqflag", 1);
    localIntent.putExtra("cell_operation.qq_url", paramString1);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("appid", paramInt1);
    localIntent.setFlags(67108864);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt2);
  }
  
  public static void b(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    paramUserInfo = QzoneConfig.a().a("QunAlbumSetting", "QunAlbumPhotoList", "http://h5.qzone.qq.com/groupphoto/inqq/photo/{QUN_ID}/{ALBUM_ID}?_wv=3").replace("{QUN_ID}", paramString1).replace("{ALBUM_ID}", paramString2);
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString1.putExtra("url", paramUserInfo);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void b(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    QLog.d("qzone_launch", 4, "forwardToFriendFeed click");
    paramIntent.putExtra("startup_sceneid", 1);
    QzonePluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static void b(Context paramContext, Object paramObject)
  {
    if ((paramContext == null) || (paramObject == null)) {
      return;
    }
    try
    {
      Class localClass = Class.forName("com.qzone.floatobject.ui.FloatItemView");
      paramContext = localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ClassLoader localClassLoader = QzonePluginProxyActivity.a(paramContext);
        paramContext = localClassLoader.loadClass("com.qzone.floatobject.ui.FloatItemView");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramContext == null) {
      try
      {
        QLog.e("QZLog", 1, "*createQZoneFloatObjectView load class fail");
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    paramContext.getMethod("start", new Class[0]).invoke(paramObject, new Object[0]);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePictureViewerProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:picture");
      localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
      BaseApplicationImpl.getContext().stopService(localIntent);
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
      Utils.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzonevideo");
    } while (TextUtils.isEmpty(paramString));
    paramContext.deleteDatabase(SecurityUtil.a(paramString));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (b()) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS");
    localIntent.putExtra("qunid", paramString);
    localIntent.putExtra("qzone_uin", paramQQAppInterface.a());
    paramString = new IPluginManager.PluginParams(0);
    paramString.jdField_b_of_type_JavaLangString = QzonePluginProxyActivity.a();
    paramString.d = "QQ空间";
    paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    paramString.e = "com.qzone.preview.service.PictureService";
    paramString.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "Start QZone QunAlbum Preload");
    }
    IPluginManager.b(paramQQAppInterface.a(), paramString);
  }
  
  public static boolean b()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.mobileqq:qzone".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QzoneProcess is exist");
        }
        return true;
      }
    }
    return false;
  }
  
  public static int c()
  {
    return QzoneConfig.a().a("MiniVideo", "VideoDurationThreshold", 60000);
  }
  
  public static Intent c(Context paramContext)
  {
    paramContext = new Intent();
    QzonePluginProxyActivity.a(paramContext, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    return paramContext;
  }
  
  public static void c(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    a(localIntent, paramUserInfo);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.lbsv2.ui.QZoneMoodSelectLocation");
    localIntent.putExtra("k_modal", true);
    localIntent.putExtra("k_hide_qzone_icon", true);
    QzonePluginProxyActivity.a(paramActivity, paramUserInfo.jdField_a_of_type_JavaLangString, localIntent, paramInt);
  }
  
  public static void c(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    paramUserInfo = QzoneConfig.a().a("QunAlbumSetting", "QunAlbumDetail", "http://h5.qzone.qq.com/groupphoto/inqq/detail/{QQ_URL}?_wv=3").replace("{QQ_URL}", URLEncoder.encode(paramString1));
    paramString1 = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
    paramString1.putExtra("url", paramUserInfo);
    paramString1.putExtra("fromQZone", true);
    paramString1.putExtra("injectrecommend", true);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
    paramString1.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static void c(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramUserInfo = QzoneConfig.a().a("QunAlbumSetting", "QunAlbum", "http://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}?_wv=3").replace("{QUN_ID}", paramString1);
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString1.putExtra("url", paramUserInfo);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramString1, paramInt2);
  }
  
  public static boolean c()
  {
    jdField_a_of_type_Boolean = LocalMultiProcConfig.a("comboqz_protect_enable", false);
    if (jdField_a_of_type_Boolean)
    {
      String str = LocalMultiProcConfig.a("comboqz_qua", "");
      if (!QUA.a().equals(str))
      {
        LocalMultiProcConfig.b("comboqz_protect_enable", false);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "QzoneEntranceProtectEnable:" + jdField_a_of_type_Boolean);
    }
    return jdField_a_of_type_Boolean;
  }
  
  public static void d(Activity paramActivity, QZoneHelper.UserInfo paramUserInfo, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramUserInfo = QzoneConfig.a().a("QunAlbumSetting", "QunAlbumSelect", "http://h5.qzone.qq.com/groupphoto/inqq/album/{QUN_ID}/select?_wv=3").replace("{QUN_ID}", paramString1);
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString1.putExtra("url", paramUserInfo);
    if (WebViewPluginFactory.a.containsKey("Qzone")) {
      paramString1.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    paramString1.setData(Uri.parse(paramUserInfo));
    paramActivity.startActivityForResult(paramString1, paramInt);
  }
  
  public static boolean d()
  {
    if (!c)
    {
      jdField_b_of_type_Boolean = g();
      c = true;
    }
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean e()
  {
    String str = QzoneConfig.a().a("QZoneSetting", "FloatModelBlacklist", "N5117,R8007,Coolpad 8720L,R7007,GN9000L,G620-L75,R2017,R6007,R831S,HM 1SC,Coolpad 8705,HUAWEI B199,Coolpad 9190L,HM 1SW,Coolpad 8730L");
    if (str == null) {
      return false;
    }
    if (!str.equals(aL))
    {
      d = a(str);
      aL = str;
    }
    return d;
  }
  
  private static boolean f()
  {
    File localFile = new File(Environment.getExternalStorageDirectory().getPath(), "disable_preload");
    return (localFile != null) && (localFile.exists());
  }
  
  private static boolean g()
  {
    boolean bool2 = true;
    long l1 = System.currentTimeMillis();
    int i1 = QzoneConfig.a().a("QzoneCover", "HtmlStandardCpuCore", 1);
    int i2 = QzoneConfig.a().a("QzoneCover", "HtmlStandardCpuFequency", 1100);
    int i3 = QzoneConfig.a().a("QzoneCover", "HtmlStandardRAMSize", 700);
    long l2 = DeviceInfoUtil.b() * DeviceInfoUtil.a();
    long l3 = i1 * i2;
    boolean bool1;
    if (l2 > 0L) {
      if (l2 > l3) {
        bool1 = true;
      }
    }
    for (;;)
    {
      l2 = DeviceInfoUtil.c();
      if (l2 > 0L) {
        if ((bool1) && (l2 > 1048576L * i3)) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isBestPerformanceDeviceImpl standardCpuCore=" + i1 + ",standardCpuFequency=" + i2 + ",standardRAMSize=" + i3 + ",cpu count=" + DeviceInfoUtil.b() + ",cpu frequency=" + DeviceInfoUtil.a() + ",total memory=" + l2 + ",use time=" + (l3 - l1));
        }
        return bool1;
        bool1 = false;
        break;
        bool1 = false;
      }
      bool1 = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */