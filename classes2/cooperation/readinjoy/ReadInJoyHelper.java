package cooperation.readinjoy;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReadInJoyHelper
{
  public static final String A = "config_feeds_publishfail_leba_max_id";
  public static final String B = "config_feeds_publishfail_leba_unread_count";
  public static final String C = "config_feeds_process_seq";
  public static final String D = "config_new_channel_notify_flag";
  public static final String E = "config_new_channel_notify_flag_for_plugin";
  public static final String F = "config_new_channel_id_list";
  public static final String G = "config_notify_guide_flag";
  public static final String H = "config_notify_guide_wording";
  public static final String I = "config_notify_guide_updated_time";
  public static final String J = "readinjoy_push_channel_article_flag";
  public static final String K = "readinjoy_push_channel_article_updated_time";
  public static final String L = "readinjoy_push_channel_article_content_channel_id";
  public static final String M = "readinjoy_push_channel_article_content_channel_name";
  public static final String N = "readinjoy_push_channel_article_content_wording";
  public static final String O = "readinjoy_push_channel_article_content_article_id_list";
  public static final String P = "config_local_channel_flag";
  public static final String Q = "config_follow_uin";
  public static final String R = "config_update_app_setting";
  public static final String S = "config_feeds_group_setting";
  public static final String T = "readinjoy_config_push_msg_switch";
  public static final String U = "config_smart_crop_pic_setting";
  public static final String V = "config_readinjoy_interested_push_switch";
  public static final String W = "notify_main_feeds_msg_newfeeds_read";
  public static final String X = "notify_main_feeds_msg_newcomment_read";
  public static final String Y = "notify_main_feeds_msg_publish_fail";
  public static final String Z = "notify_main_feeds_msg_republish";
  public static final int a = 0;
  public static final String a = "ReadInJoyHelper";
  private static HashMap a;
  protected static boolean a = false;
  public static final String aA = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
  public static final String aB = "mqqapi://readinjoy/open?src_type=internal&version=1&channelId=";
  public static final String aC = "last_req_article_time";
  public static final String aD = "show_interest_label";
  public static final String aE = "last_exit_kandian_time";
  public static final String aF = "stop_readinjoy_function";
  public static final String aG = "last_exit_channel_time";
  public static final String aH = "readinjoy_video_channel_info_config_version";
  public static final String aI = "readinjoy_video_channel_info_channel_id";
  public static final String aJ = "readinjoy_video_channel_info_channel_name";
  public static final String aK = "readinjoy_video_channel_info_channel_type";
  public static final String aL = "readyinjoy_video_support_multi_video";
  public static final String aM = "READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT";
  public static final String aN = "READINJOY_VIDEO_CHANNEL_LIKE_UNLIKE_SP2";
  public static final String aO = "readinjoy_show_recommend_reason_in_title_b";
  private static final String aP = "com.tencent.qqreadinjoy.common.ReadInJoyAppInterface";
  public static final String aa = "notify_main_new_channel_clear";
  public static final String ab = "notify_main_guide_clear";
  public static final String ac = "notify_main_share_friend_video";
  public static final String ad = "readInJoy_video_play_real_time_report";
  public static final String ae = "notify_main_feeds_msg_response";
  public static final String af = "notify_main_subscribe_follow_state";
  public static final String ag = "readinjoy_channel_list_update_time";
  public static final String ah = "readinjoy_channel_list_update_setting";
  public static final String ai = "readinjoy_individual_push_date";
  public static final String aj = "readinjoy_individual_push_switch";
  public static final String ak = "read_id";
  public static final String al = "feed_owner";
  public static final String am = "fail_reason";
  public static final String an = "channel_id";
  public static final String ao = "channel_name";
  public static final String ap = "subscription_all_article_id";
  public static final String aq = "subscription_click_article_id";
  public static final String ar = "follow_uin_position";
  public static final String as = "follow_uin_smooth_dx";
  public static final String at = "follow_uin_status";
  public static final String au = "follow_uin";
  public static final String av = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
  public static final String aw = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
  public static final String ax = "mqqapi://readinjoy/open?src_type=internal&version=1";
  public static final String ay = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
  public static final String az = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
  public static final int b = 1;
  public static final String b = "com.tencent.qqreadinjoy";
  private static boolean b = false;
  public static final int c = 2;
  public static final String c = "readinjoy_launch_source";
  public static final int d = 3;
  public static final String d = "readinjoy_launch_style";
  public static final int e = 4;
  public static final String e = "readinjoy_launch_start_time";
  public static final int f = 5;
  public static final String f = "推荐";
  public static final int g = 6;
  public static final String g = "readinjoy_launch_needs_loading";
  public static final int h = 7;
  public static final String h = "cooperation.readinjoy.ReadInJoyProxyActivity";
  public static final int i = 8;
  public static final String i = "cooperation.readinjoy.ReadInJoyPluginInstallActivity";
  public static final int j = 9;
  public static final String j = "com.tencent.qqreadinjoy.ReadInJoyStartActivity";
  public static final int k = 10;
  public static final String k = "share_to_news";
  public static final int l = 11;
  public static final String l = "synchronize_to_qzone";
  public static final int m = 1;
  public static final String m = "merge_feeds";
  public static final int n = 2;
  public static final String n = "kandian_feeds";
  public static final int o = 4;
  public static final String o = "updated_msg_count";
  public static final int p = 0;
  public static final String p = "readInJoy_subscribeAcc_gray_enable";
  public static final int q = 9999;
  public static final String q = "config_feeds_newfeeds_leba_read_id";
  public static final int r = 0;
  public static final String r = "config_feeds_newfeeds_leba_max_id";
  public static final int s = 1;
  public static final String s = "config_feeds_newfeeds_leba_unread_count";
  public static final int t = 2;
  public static final String t = "config_feeds_newfeeds_leba_latest_owner";
  public static final int u = 4;
  public static final String u = "config_feeds_newfeeds_leba_updated_time";
  private static int v = 0;
  public static final String v = "config_feeds_newcomment_leba_read_id";
  public static final String w = "config_feeds_newcomment_leba_max_id";
  public static final String x = "config_feeds_newcomment_leba_unread_count";
  public static final String y = "config_feeds_newcomment_leba_latest_uin";
  public static final String z = "config_feeds_publishfail_leba_read_id";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
    v = -1;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("readinjoy_video_channel_info_config_version" + paramQQAppInterface.a(), -1);
  }
  
  public static long a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder("last_req_article_time");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong("last_exit_kandian_time", 0L);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return paramQQAppInterface.getLong(paramInt + "_" + "last_exit_channel_time", 0L);
  }
  
  public static long a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return 0L;
    }
    return paramAppRuntime.getLong("readinjoy_channel_list_update_time", 0L);
  }
  
  @Deprecated
  public static SharedPreferences a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    while (paramInt == 2) {
      return null;
    }
    if ((paramInt == 0) && (Build.VERSION.SDK_INT >= 11)) {}
    for (int i1 = 4;; i1 = 0)
    {
      paramQQAppInterface = String.format("readinjoy_%s_%d", new Object[] { paramQQAppInterface.getAccount(), Integer.valueOf(paramInt) });
      return BaseApplicationImpl.a().getSharedPreferences(paramQQAppInterface, i1);
    }
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    if (paramBoolean1) {
      paramAppRuntime = paramAppRuntime.getAccount();
    }
    for (paramAppRuntime = "readinjoy_sp" + "_" + paramAppRuntime;; paramAppRuntime = "readinjoy_sp")
    {
      int i2 = 0;
      int i1 = i2;
      if (paramBoolean2)
      {
        i1 = i2;
        if (Build.VERSION.SDK_INT >= 11) {
          i1 = 4;
        }
      }
      return BaseApplicationImpl.a().getSharedPreferences(paramAppRuntime, i1);
    }
  }
  
  public static LebaViewItem a(QQAppInterface paramQQAppInterface)
  {
    List localList = LebaShowListManager.a().a();
    Object localObject;
    if (localList != null)
    {
      localObject = localList;
      if (!localList.isEmpty()) {}
    }
    else
    {
      LebaShowListManager.a().a(paramQQAppInterface.getApplication().getApplicationContext(), paramQQAppInterface);
      localObject = LebaShowListManager.a().a();
    }
    if (localObject != null)
    {
      paramQQAppInterface = ((List)localObject).iterator();
      while (paramQQAppInterface.hasNext())
      {
        localObject = (LebaViewItem)paramQQAppInterface.next();
        if ((localObject != null) && (((LebaViewItem)localObject).a != null) && (((LebaViewItem)localObject).a.uiResId == 1130L)) {
          return (LebaViewItem)localObject;
        }
      }
    }
    return null;
  }
  
  public static ResourcePluginInfo a()
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "qqreadinjoy";
    localResourcePluginInfo.strResName = "看点-常在";
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 1130L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://readinjoy/open?src_type=internal&version=1&channelid=16&channelname=财经";
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 900;
    return localResourcePluginInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getString("readinjoy_video_channel_info_channel_name", "");
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp IndividualPushDate");
      return "";
    }
    return paramAppRuntime.getString("readinjoy_individual_push_date", "");
  }
  
  public static HashMap a(AppRuntime paramAppRuntime)
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaUtilHashMap.putAll(b(paramAppRuntime));
    return jdField_a_of_type_JavaUtilHashMap;
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.qqreadinjoy.common.ReadInJoyAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          QLog.e("ReadInJoyLog", 1, "*createReadInJoyAppInterface load class fail");
          return null;
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "readinjoy_plugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.qqreadinjoy.common.ReadInJoyAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
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
  
  public static void a(int paramInt, long paramLong, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder("last_req_article_time");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putLong(localStringBuilder.toString(), paramLong);
    a(paramQQAppInterface, true);
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putLong("last_exit_kandian_time", paramLong).commit();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((a(paramActivity)) && (paramActivity.getPackageName().equalsIgnoreCase("com.tencent.qqreadinjoy")))
    {
      paramIntent.setClassName("com.tencent.qqreadinjoy", "com.tencent.qqreadinjoy.ReadInJoyStartActivity");
      paramActivity.startActivityForResult(paramIntent, -1);
    }
    a(null, paramActivity, paramIntent, paramInt, paramOnDismissListener);
  }
  
  public static void a(SharedPreferences.Editor paramEditor, boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 9))
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = BaseApplicationImpl.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    if (paramQQAppInterface == null)
    {
      jdField_a_of_type_Boolean = true;
      return;
    }
    jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("readInJoy_subscribeAcc_gray_enable", true);
    QLog.d("SPLASH_ConfigServlet", 1, "ReadinjoyFolderMerge config " + jdField_a_of_type_Boolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = paramInt1;
    localReportInfo.mSourceArticleId = paramLong;
    localReportInfo.mOperation = paramInt2;
    localReportInfo.mOpSource = paramInt3;
    localArrayList.add(localReportInfo);
    new UserOperationModule(paramQQAppInterface, null, null, ReadInJoyMSFService.a(), null).a(localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    paramQQAppInterface.putInt("readinjoy_video_channel_info_channel_id", paramInt1);
    paramQQAppInterface.putString("readinjoy_video_channel_info_channel_name", paramString);
    paramQQAppInterface.putInt("readinjoy_video_channel_info_channel_type", paramInt2);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.edit().putLong(paramInt + "_" + "last_exit_channel_time", paramLong).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent)
  {
    a(paramQQAppInterface, paramActivity, paramIntent, -1, null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (a(paramActivity))
    {
      paramIntent.putExtra("readinjoy_launch_needs_loading", false);
      ReadInJoyProxyActivity.a(paramQQAppInterface, paramActivity, paramIntent, paramInt, paramOnDismissListener);
      return;
    }
    paramIntent.setClassName("com.tencent.mobileqq", "cooperation.readinjoy.ReadInJoyPluginInstallActivity");
    paramIntent.addCategory("android.intent.category.LAUNCHER");
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    paramActivity.startActivityForResult(paramIntent, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i1 = 4;
    try
    {
      int i2 = Integer.valueOf(paramString).intValue();
      i1 = i2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.d("ReadInJoyHelper", 1, "updateReadInJoyFeedsGroupSetting failed " + paramString.toString());
      }
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("config_feeds_group_setting", i1);
      a(paramQQAppInterface, true);
    }
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_1
    //   4: putstatic 750	cooperation/readinjoy/ReadInJoyHelper:b	Z
    //   7: aload_0
    //   8: iconst_1
    //   9: invokestatic 364	cooperation/readinjoy/ReadInJoyHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Landroid/content/SharedPreferences;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: aload_2
    //   22: invokeinterface 606 1 0
    //   27: astore_2
    //   28: aload_2
    //   29: ldc 106
    //   31: iload_1
    //   32: invokeinterface 754 3 0
    //   37: pop
    //   38: aload_2
    //   39: iconst_1
    //   40: invokestatic 615	cooperation/readinjoy/ReadInJoyHelper:a	(Landroid/content/SharedPreferences$Editor;Z)V
    //   43: aload_0
    //   44: iload_1
    //   45: invokestatic 756	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   48: goto -31 -> 17
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramQQAppInterface	QQAppInterface
    //   0	57	1	paramBoolean	boolean
    //   12	27	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	51	finally
    //   21	48	51	finally
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = a(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("share_to_news", bool);
    a(paramString, true);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      ReadInJoyBaseAdapter.t = 1000;
      QLog.d("ReadInJoyHelper", 1, "app null update feeds group setting:" + ReadInJoyBaseAdapter.t);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i1 = 4;; i1 = 0)
    {
      paramAppRuntime = String.format("readinjoy_%s_%d", new Object[] { paramAppRuntime.getAccount(), Integer.valueOf(1) });
      paramAppRuntime = BaseApplicationImpl.a().getSharedPreferences(paramAppRuntime, i1);
      if (paramAppRuntime == null)
      {
        ReadInJoyBaseAdapter.t = 1000;
        QLog.d("ReadInJoyHelper", 1, "sp null update feeds group setting:" + ReadInJoyBaseAdapter.t);
        return;
      }
      ReadInJoyBaseAdapter.t = paramAppRuntime.getInt("config_feeds_group_setting", 1000);
      QLog.d("ReadInJoyHelper", 1, "update feeds group setting:" + ReadInJoyBaseAdapter.t);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putLong("readinjoy_channel_list_update_time", paramLong);
    a(paramAppRuntime, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_channel_list_update_setting", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  @Deprecated
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b = paramBoolean;
      return;
    }
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "isReadinjoyVideoChannel() channelType=" + paramInt);
    }
    return paramInt == 3;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.endsWith(":readinjoy"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    return (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) && (((Boolean)jdField_a_of_type_JavaUtilHashMap.get(paramString)).booleanValue());
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT", true);
    if (bool)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("READINJOY_VIDEO_CHANNEL_AUTO_PLAY_NEXT_VIDEO_HINT", false);
      a(paramAppRuntime, true);
    }
    return bool;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(paramBoolean));
    Object localObject = b(paramAppRuntime);
    if (paramBoolean) {
      ((HashMap)localObject).put(paramString, Boolean.valueOf(true));
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localStringBuilder = new StringBuilder();
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((Boolean)localEntry.getValue()).booleanValue()) {
          localStringBuilder.append((String)localEntry.getKey()).append(";");
        }
      }
      ((HashMap)localObject).remove(paramString);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyHelper", 2, "setLikeUnLikeSP innerUniqueID:" + paramString + " isLike:" + paramBoolean);
      QLog.d("ReadInJoyHelper", 2, "setLikeUnLikeSP sb.toString():" + localStringBuilder.toString());
    }
    paramAppRuntime = a(paramAppRuntime, true, true).edit();
    paramAppRuntime.putString("READINJOY_VIDEO_CHANNEL_LIKE_UNLIKE_SP2", localStringBuilder.toString());
    a(paramAppRuntime, true);
    return true;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("readinjoy_video_channel_info_channel_id", -1);
  }
  
  private static HashMap b(AppRuntime paramAppRuntime)
  {
    HashMap localHashMap = new HashMap();
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return localHashMap;
    }
    paramAppRuntime = paramAppRuntime.getString("READINJOY_VIDEO_CHANNEL_LIKE_UNLIKE_SP2", "");
    if (TextUtils.isEmpty(paramAppRuntime)) {
      return localHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "getLikeUnLikeSP likeUnLikeSp:" + paramAppRuntime);
    }
    paramAppRuntime = paramAppRuntime.split(";");
    if ((paramAppRuntime != null) && (paramAppRuntime.length > 0))
    {
      int i1 = 0;
      while (i1 < paramAppRuntime.length)
      {
        if (!TextUtils.isEmpty(paramAppRuntime[i1])) {
          localHashMap.put(paramAppRuntime[i1], Boolean.valueOf(true));
        }
        i1 += 1;
      }
    }
    return localHashMap;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("show_interest_label", false);
    a(paramQQAppInterface, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      i1 = Integer.valueOf(paramString).intValue();
      paramQQAppInterface = a(paramQQAppInterface, 1);
      if (paramQQAppInterface == null) {
        return;
      }
    }
    catch (Exception paramString)
    {
      int i1;
      for (;;)
      {
        QLog.w("ReadInJoyHelper", 1, "updateReadInJoyPushMsgSwitch failed: " + paramString.toString());
        i1 = 1;
      }
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putInt("readinjoy_config_push_msg_switch", i1);
      a(paramQQAppInterface, true);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).edit();
    paramQQAppInterface.putBoolean("hot_shortvideo_multi_video_support", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = a(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("synchronize_to_qzone", bool);
    a(paramString, true);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp IndividualPushDate");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("readinjoy_individual_push_date", ReadInJoyUtils.a.format(Long.valueOf(System.currentTimeMillis())));
    a(paramAppRuntime, true);
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp IndividualPushSwitch");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_individual_push_switch", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean b()
  {
    return QLog.isColorLevel();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return false;
    }
    return paramQQAppInterface.getBoolean("show_interest_label", true);
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    int i2 = 0;
    if (paramAppRuntime == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i1 = 4;; i1 = 0)
    {
      paramAppRuntime = String.format("readinjoy_%s_%d", new Object[] { paramAppRuntime.getAccount(), Integer.valueOf(1) });
      paramAppRuntime = BaseApplicationImpl.a().getSharedPreferences(paramAppRuntime, i1);
      if (paramAppRuntime == null) {
        break;
      }
      boolean bool = paramAppRuntime.getBoolean("config_smart_crop_pic_setting", false);
      if (v != -1) {
        if (!bool) {
          break label126;
        }
      }
      label126:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != v)
        {
          i1 = i2;
          if (bool) {
            i1 = 1;
          }
          v = i1;
          QLog.d("ReadInJoyHelper", 1, "getReadinjoySmartCropSwitch : " + bool);
        }
        return bool;
      }
    }
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("readinjoy_video_channel_info_channel_type", -1);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    b = e(paramQQAppInterface);
    QLog.d("SPLASH_ConfigServlet", 1, "ReadinjooyStopFunctionSwitch config:" + b);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("config_smart_crop_pic_setting", "1".equals(paramString));
    a(paramQQAppInterface, true);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = a(paramQQAppInterface, true, true);
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putBoolean("config_readinjoy_interested_push_switch", paramBoolean);
    a(paramQQAppInterface, true);
  }
  
  public static void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = "1".equals(paramString);
    paramString = BaseApplicationImpl.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("readInJoy_subscribeAcc_gray_enable", bool);
    a(paramString, true);
  }
  
  public static void c(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to update sp updateShowRecommendReasonInTitle");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("readinjoy_show_recommend_reason_in_title_b", paramBoolean);
    a(paramAppRuntime, true);
  }
  
  public static boolean c()
  {
    return b;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return false;
    }
    if ((a()) && (paramQQAppInterface.getBoolean("kandian_feeds", true))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_channel_list_update_setting", false);
  }
  
  public static void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = a(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("merge_feeds", bool);
    a(paramString, true);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    int i1 = b(paramQQAppInterface);
    String str = a(paramQQAppInterface);
    int i2 = c(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHelper", 2, "isNeedShowReadinjoyVideoChannel() channelID=" + i1 + ", channelName=" + str + ", channelType=" + i2);
    }
    return (i1 != -1) && (i2 != -1) && (!TextUtils.isEmpty(str));
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("ReadInJoyHelper", 1, "failed to get sp IndividualPushSwitch");
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_individual_push_switch", false);
  }
  
  public static void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramString.equals("1");
    paramString = a(paramQQAppInterface, 1);
    if (paramString == null) {
      return;
    }
    paramString = paramString.edit();
    paramString.putBoolean("kandian_feeds", bool);
    a(paramString, true);
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static boolean e(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("readinjoy_show_recommend_reason_in_title_b", false);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0).getBoolean("hot_shortvideo_multi_video_support", true);
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface)
  {
    return true;
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    paramQQAppInterface = a(paramQQAppInterface, 1);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (paramQQAppInterface.getInt("readinjoy_config_push_msg_switch", 1) == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\readinjoy\ReadInJoyHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */