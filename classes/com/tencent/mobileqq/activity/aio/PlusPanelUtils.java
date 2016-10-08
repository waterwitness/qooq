package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import com.dataline.activities.LiteActivity;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.sensewhere.SenseWhereManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.HbThemeConfigManager.HBThemeConfig;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import ndw;
import ndx;
import ndy;
import ndz;
import nea;
import neb;
import nec;
import ned;
import nee;
import nef;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlusPanelUtils
{
  public static final int a = 1;
  private static TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  public static String a;
  public static final int b = 2;
  public static String b;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 5;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 0;
  public static final int k = 3;
  static int l;
  public static int m;
  public static int n;
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  
  public PlusPanelUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int a(SessionInfo paramSessionInfo)
  {
    if (AlbumUtil.a(paramSessionInfo.jdField_a_of_type_Int)) {}
    for (int i1 = 0; AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString); i1 = 1) {
      return 1;
    }
    return i1;
  }
  
  public static ActionSheet a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, Handler.Callback paramCallback, int paramInt2)
  {
    paramCallback = ActionSheet.a(paramActivity);
    int i2 = 0;
    int i1;
    if (paramInt2 == 0)
    {
      paramCallback.c(2131365082);
      paramCallback.a(2131365083, 5);
      i1 = i2;
    }
    for (;;)
    {
      paramCallback.d(2131367262);
      paramCallback.a(new ndz(paramQQAppInterface));
      paramCallback.a(new nea(paramCallback, paramQQAppInterface, paramActivity, paramInt1, paramString, paramInt2, i1));
      paramCallback.show();
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D6C", "0X8004D6C", 0, 0, "", "", "", "");
      return paramCallback;
      i1 = i2;
      if (paramInt2 == 1)
      {
        paramCallback.c(2131368096);
        PstnManager localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
        PstnCardInfo localPstnCardInfo = localPstnManager.a(paramQQAppInterface.a());
        i1 = i2;
        if (localPstnCardInfo != null)
        {
          i1 = i2;
          if (localPstnManager.a() == 1)
          {
            i1 = i2;
            if (localPstnManager.a().f == 1)
            {
              paramCallback.a(2131372446);
              if (localPstnCardInfo.pstn_multi_call_time > 0)
              {
                paramCallback.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131372444), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130839269), 0);
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 1, 0, "", "", "", "");
                i1 = 3;
              }
              else if ((localPstnManager.c() == 1) && (localPstnCardInfo.pstn_multi_try_status == 0))
              {
                paramCallback.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131372444), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130839268), 0);
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 3, 0, "", "", "", "");
                i1 = 4;
              }
              else
              {
                paramCallback.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131372444), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130839267), 0);
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 2, 0, "", "", "", "");
                i1 = 5;
              }
            }
          }
        }
      }
    }
  }
  
  public static String a()
  {
    return a(AppConstants.bt);
  }
  
  public static String a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i1 = localCalendar.get(2) + 1;
    if (i1 < 10)
    {
      paramString = "0" + i1;
      localStringBuilder.append(paramString);
      i1 = localCalendar.get(5);
      if (i1 >= 10) {
        break label291;
      }
      paramString = "0" + i1;
      label102:
      localStringBuilder.append(paramString);
      i1 = localCalendar.get(11);
      if (i1 >= 10) {
        break label299;
      }
      paramString = "0" + i1;
      label141:
      localStringBuilder.append(paramString);
      i1 = localCalendar.get(12);
      if (i1 >= 10) {
        break label307;
      }
      paramString = "0" + i1;
      label180:
      localStringBuilder.append(paramString);
      i1 = localCalendar.get(13);
      if (i1 >= 10) {
        break label315;
      }
    }
    label291:
    label299:
    label307:
    label315:
    for (paramString = "0" + i1;; paramString = Integer.valueOf(i1))
    {
      localStringBuilder.append(paramString);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label323;
      }
      return localStringBuilder.toString() + ".jpg";
      paramString = Integer.valueOf(i1);
      break;
      paramString = Integer.valueOf(i1);
      break label102;
      paramString = Integer.valueOf(i1);
      break label141;
      paramString = Integer.valueOf(i1);
      break label180;
    }
    label323:
    paramString = new StringBuilder(localStringBuilder);
    int i2 = localStringBuilder.length();
    i1 = 1;
    for (;;)
    {
      if (i1 < Integer.MAX_VALUE)
      {
        paramString.append('(');
        paramString.append(i1);
        paramString.append(')');
        paramString.append(".jpg");
        if (new File(paramString.toString()).exists()) {}
      }
      else
      {
        return paramString.toString();
      }
      paramString.delete(i2, paramString.length());
      i1 += 1;
    }
  }
  
  /* Error */
  public static List a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: invokestatic 258	com/tencent/mobileqq/util/HbThemeConfigManager:a	()Lcom/tencent/mobileqq/util/HbThemeConfigManager;
    //   3: astore_1
    //   4: new 260	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 261	java/util/ArrayList:<init>	()V
    //   11: astore_2
    //   12: aload_1
    //   13: getfield 264	com/tencent/mobileqq/util/HbThemeConfigManager:a	Ljava/util/List;
    //   16: ifnull +175 -> 191
    //   19: aload_1
    //   20: getfield 264	com/tencent/mobileqq/util/HbThemeConfigManager:a	Ljava/util/List;
    //   23: invokeinterface 269 1 0
    //   28: ifle +163 -> 191
    //   31: iconst_0
    //   32: istore 4
    //   34: iload 4
    //   36: aload_1
    //   37: getfield 264	com/tencent/mobileqq/util/HbThemeConfigManager:a	Ljava/util/List;
    //   40: invokeinterface 269 1 0
    //   45: if_icmpge +146 -> 191
    //   48: aload_1
    //   49: getfield 264	com/tencent/mobileqq/util/HbThemeConfigManager:a	Ljava/util/List;
    //   52: iload 4
    //   54: invokeinterface 272 2 0
    //   59: checkcast 274	com/tencent/mobileqq/util/HbThemeConfigManager$HBThemeConfig
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +35 -> 99
    //   67: aload_3
    //   68: getfield 275	com/tencent/mobileqq/util/HbThemeConfigManager$HBThemeConfig:jdField_a_of_type_Int	I
    //   71: iconst_1
    //   72: if_icmple +27 -> 99
    //   75: aload_3
    //   76: getfield 276	com/tencent/mobileqq/util/HbThemeConfigManager$HBThemeConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   79: ifnull +20 -> 99
    //   82: aload_3
    //   83: getfield 279	com/tencent/mobileqq/util/HbThemeConfigManager$HBThemeConfig:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   86: ifnull +13 -> 99
    //   89: aload_3
    //   90: getfield 279	com/tencent/mobileqq/util/HbThemeConfigManager$HBThemeConfig:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   93: invokevirtual 282	org/json/JSONArray:length	()I
    //   96: ifgt +12 -> 108
    //   99: iload 4
    //   101: iconst_1
    //   102: iadd
    //   103: istore 4
    //   105: goto -71 -> 34
    //   108: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   111: lstore 9
    //   113: new 290	java/text/SimpleDateFormat
    //   116: dup
    //   117: ldc_w 292
    //   120: invokespecial 293	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   123: astore_0
    //   124: aload_0
    //   125: aload_3
    //   126: getfield 295	com/tencent/mobileqq/util/HbThemeConfigManager$HBThemeConfig:e	Ljava/lang/String;
    //   129: invokevirtual 299	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   132: invokevirtual 304	java/util/Date:getTime	()J
    //   135: lstore 5
    //   137: aload_0
    //   138: aload_3
    //   139: getfield 306	com/tencent/mobileqq/util/HbThemeConfigManager$HBThemeConfig:f	Ljava/lang/String;
    //   142: invokevirtual 299	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   145: invokevirtual 304	java/util/Date:getTime	()J
    //   148: lstore 7
    //   150: lload 9
    //   152: lload 5
    //   154: lcmp
    //   155: iflt -56 -> 99
    //   158: lload 9
    //   160: lload 7
    //   162: lcmp
    //   163: ifgt -64 -> 99
    //   166: aload_2
    //   167: aload_3
    //   168: invokeinterface 310 2 0
    //   173: pop
    //   174: goto -75 -> 99
    //   177: astore_0
    //   178: lconst_0
    //   179: lstore 5
    //   181: aload_0
    //   182: invokevirtual 313	java/text/ParseException:printStackTrace	()V
    //   185: lconst_0
    //   186: lstore 7
    //   188: goto -38 -> 150
    //   191: aload_2
    //   192: areturn
    //   193: astore_0
    //   194: goto -13 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramQQAppInterface	QQAppInterface
    //   3	46	1	localHbThemeConfigManager	com.tencent.mobileqq.util.HbThemeConfigManager
    //   11	181	2	localArrayList	ArrayList
    //   62	106	3	localHBThemeConfig	HbThemeConfigManager.HBThemeConfig
    //   32	72	4	i1	int
    //   135	45	5	l1	long
    //   148	39	7	l2	long
    //   111	48	9	l3	long
    // Exception table:
    //   from	to	target	type
    //   124	137	177	java/text/ParseException
    //   137	150	193	java/text/ParseException
  }
  
  public static List a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    return a(paramQQAppInterface);
  }
  
  public static void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
    localIntent.putExtra("url", "http://app.p.qq.com/games/zhuagui/game.html");
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("uin_name", paramSessionInfo.d);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (a(paramSessionInfo, paramQQAppInterface.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "prepareForPicPresend add binder!");
      }
      paramIntent.putExtra("binder_presendService", new BinderWarpper(new PresendPicMgrService(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramQQAppInterface.getAccount()).asBinder()));
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt, SessionInfo paramSessionInfo)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    if (!Utils.b())
    {
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131368967), 0).a();
      return;
    }
    long l1 = System.currentTimeMillis();
    boolean bool = CameraUtils.a();
    l1 = System.currentTimeMillis() - l1;
    String str = a(AppConstants.bo);
    paramSessionInfo = new File(AppConstants.bo);
    if (!paramSessionInfo.exists()) {
      paramSessionInfo.mkdirs();
    }
    if (!bool)
    {
      paramAppInterface = Uri.fromFile(new File(str));
      PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", str).commit();
      paramSessionInfo = new Intent("android.media.action.IMAGE_CAPTURE");
      paramSessionInfo.putExtra("output", paramAppInterface);
      paramSessionInfo.putExtra("android.intent.extra.quickCapture", true);
      paramAppInterface = paramSessionInfo;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.camera.enterCamera", 2, "[enterCamera] + ENTER sysCamera takeTime: " + l1);
        paramAppInterface = paramSessionInfo;
      }
    }
    for (;;)
    {
      paramAppInterface.setFlags(536870912);
      paramAppInterface.putExtra("android.intent.extra.videoQuality", 100);
      try
      {
        paramActivity.startActivityForResult(paramAppInterface, paramInt);
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        QQToast.a(paramActivity, 2131368990, 0).a();
        return;
      }
      PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", str).commit();
      paramSessionInfo = new Intent(paramActivity, QQCameraActivity.class);
      paramSessionInfo.putExtra("qcamera_photo_filepath", str);
      paramSessionInfo.putExtra("PhotoConst.MY_UIN", paramAppInterface.getAccount());
      paramAppInterface = paramSessionInfo;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.camera.enterCamera", 2, "[enterCamera] + ENTER qCamera takeTime: " + l1);
        paramAppInterface = paramSessionInfo;
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    a(paramBaseActivity.app, paramBaseActivity, paramSessionInfo, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      ((FragmentActivity)paramActivity).getChatFragment().a().as();
      Intent localIntent = new Intent(paramActivity, PoiMapActivity.class).putExtra("uin", paramQQAppInterface.getAccount());
      localIntent.putExtra("is_need_destroy_broadcast", false);
      paramActivity.startActivityForResult(localIntent, 18);
      ((SenseWhereManager)paramQQAppInterface.getManager(125)).e();
      return;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    localIntent = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        localIntent.putExtra("from_aio", true);
        localIntent.addFlags(536870912);
        localIntent.putExtra("selectMode", true);
        localIntent.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramSessionInfo.jdField_a_of_type_Int == 1000) {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_b_of_type_JavaLangString);
        } else if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.e);
        } else {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_c_of_type_JavaLangString);
        }
      }
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 9501) && (paramQQAppInterface != null) && (paramQQAppInterface.a()))
    {
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", paramQQAppInterface.a(l1));
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130968585, 2130968586);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt)
  {
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
    long l1;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a())) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1;
        localException.printStackTrace();
      }
    }
    i1 = paramQQAppInterface.a(l1);
    paramQQAppInterface = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface.putExtra("category", 6);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("tab_tab_type", 5);
    paramQQAppInterface.putExtra("smart_device_support_flag", i1);
    paramQQAppInterface.putExtra("smart_device_switch_tab_flag", paramInt);
    paramActivity.startActivityForResult(paramQQAppInterface, 5);
    paramActivity.overridePendingTransition(2130968585, 2130968586);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, HbThemeConfigManager.HBThemeConfig paramHBThemeConfig, int paramInt)
  {
    Object localObject3 = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
    int i1 = 0;
    int i3 = 1;
    int i2;
    Object localObject1;
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      i2 = 0;
      i1 = 1;
      localObject1 = "";
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("recv_uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (i2 > 0) {
          localJSONObject.put("people_num", i2);
        }
        localJSONObject.put("recv_type", i1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localJSONObject.put("session_token", localObject1);
        }
        localJSONObject.put("channel", i3);
        if (localObject3 != null)
        {
          localObject1 = ((PasswdRedBagManager)localObject3).a();
          if (localObject1 != null) {
            localJSONObject.put("placeholder", localObject1);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "click HongBao:params=" + localJSONObject.toString());
      }
      localObject1 = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
      ((Intent)localObject1).putExtra("come_from", 2);
      localObject3 = new JSONObject();
      boolean bool1 = false;
      boolean bool2;
      if (paramHBThemeConfig != null) {
        bool2 = true;
      }
      try
      {
        ((JSONObject)localObject3).put("hb_theme_id", paramHBThemeConfig.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(paramHBThemeConfig.jdField_a_of_type_JavaLangString)) {
          ((JSONObject)localObject3).put("hb_theme_name", paramHBThemeConfig.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramHBThemeConfig.jdField_b_of_type_JavaLangString)) {
          ((JSONObject)localObject3).put("hb_theme_img", paramHBThemeConfig.jdField_b_of_type_JavaLangString);
        }
        if ((paramHBThemeConfig.jdField_b_of_type_OrgJsonJSONArray != null) && (paramHBThemeConfig.jdField_b_of_type_OrgJsonJSONArray.length() > 0)) {
          ((JSONObject)localObject3).put("hb_theme_money_array", paramHBThemeConfig.jdField_b_of_type_OrgJsonJSONArray);
        }
        bool1 = bool2;
        if (paramHBThemeConfig.jdField_a_of_type_OrgJsonJSONArray != null)
        {
          bool1 = bool2;
          if (paramHBThemeConfig.jdField_a_of_type_OrgJsonJSONArray.length() > 0)
          {
            ((JSONObject)localObject3).put("hb_theme_wish_array", paramHBThemeConfig.jdField_a_of_type_OrgJsonJSONArray);
            bool1 = bool2;
          }
        }
      }
      catch (JSONException paramHBThemeConfig)
      {
        do
        {
          for (;;)
          {
            Object localObject2;
            paramHBThemeConfig.printStackTrace();
            bool1 = bool2;
          }
        } while (paramInt != 1);
        AIOPanelUtiles.a(paramQQAppInterface, "0X8005FC9", paramSessionInfo.jdField_a_of_type_Int);
        return;
      }
      ((Intent)localObject1).putExtra("theme", bool1);
      ((Intent)localObject1).putExtra("theme_config", ((JSONObject)localObject3).toString());
      ((Intent)localObject1).putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#aio");
      ((Intent)localObject1).putExtra("extra_data", localJSONObject.toString());
      ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i1, 0, null));
      paramActivity.startActivity((Intent)localObject1);
      if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        paramActivity = (HotChatManager)paramQQAppInterface.getManager(59);
        if ((paramActivity != null) && (paramActivity.b(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9C", "0X8005B9C", 0, 0, "", "", "", "");
        }
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1001) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9D", "0X8005B9D", 0, 0, "", "", "", "");
      }
      if (paramInt == 0)
      {
        AIOPanelUtiles.a(paramQQAppInterface, "0X8005CAF", paramSessionInfo.jdField_a_of_type_Int);
        return;
        if (paramSessionInfo.jdField_a_of_type_Int == 3000)
        {
          i1 = 2;
          i2 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          localObject1 = "";
          continue;
        }
        if (paramSessionInfo.jdField_a_of_type_Int == 1)
        {
          localObject1 = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject1 != null)
          {
            i1 = ((TroopInfo)localObject1).wMemberNum;
            if (QLog.isColorLevel()) {
              QLog.d("PlusPanelUtils", 2, "群uin：" + paramSessionInfo.jdField_a_of_type_JavaLangString + " 群成员个数：" + i1);
            }
          }
          if (QWalletHelper.a(paramSessionInfo.jdField_a_of_type_JavaLangString)) {}
          try
          {
            long l1 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
            localObject1 = (TroopHandler)paramQQAppInterface.a(20);
            if (jdField_a_of_type_ComTencentMobileqqAppTroopObserver == null) {
              jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new nee(paramSessionInfo);
            }
            paramQQAppInterface.a(jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
            ((TroopHandler)localObject1).a(l1, 32, 0);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              int i4;
              if (QLog.isColorLevel())
              {
                QLog.d("angelzhuang", 2, "群uin：" + paramSessionInfo.jdField_a_of_type_JavaLangString + " 解析失败");
                continue;
                i3 = 3;
                i2 = 1;
              }
            }
          }
          localObject1 = (HotChatManager)paramQQAppInterface.getManager(59);
          if ((localObject1 != null) && (((HotChatManager)localObject1).b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            i3 = 6;
            i2 = 5;
            i4 = i1;
            i1 = i3;
            localObject1 = "";
            i3 = i2;
            i2 = i4;
            continue;
          }
        }
        if (paramSessionInfo.jdField_a_of_type_Int == 1000)
        {
          localObject2 = paramSessionInfo.jdField_b_of_type_JavaLangString;
          i2 = 0;
          i1 = 4;
          continue;
        }
        if (paramSessionInfo.jdField_a_of_type_Int == 1004)
        {
          localObject2 = paramSessionInfo.jdField_b_of_type_JavaLangString;
          i2 = 0;
          i1 = 5;
          continue;
        }
        if (paramSessionInfo.jdField_a_of_type_Int != 1001) {
          break label1021;
        }
        i3 = 5;
        localObject2 = paramQQAppInterface.a().k(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          break label1007;
        }
        localObject2 = Base64Util.encodeToString((byte[])localObject2, 2);
        i2 = 0;
        i1 = 7;
      }
      label1007:
      String str = "";
      i2 = 0;
      i1 = 7;
      continue;
      label1021:
      i2 = 0;
      i1 = 0;
      str = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "Music_gene", "Music_gene_AIO", 0, 0, String.valueOf(a(paramSessionInfo.jdField_a_of_type_Int)), "", "", "");
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface.putExtra("url", "http://y.qq.com/m/qzonemusic/mqzsearch.html" + "?touin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&uintype=" + paramSessionInfo.jdField_a_of_type_Int + "&_wv=1&entry=aio&_bid=203");
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is null");
      }
    }
    for (;;)
    {
      paramQQAppInterface.putExtra("hide_left_button", true);
      paramQQAppInterface.putExtra("show_right_close_button", true);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramActivity.startActivity(paramQQAppInterface);
      paramActivity.overridePendingTransition(2130968585, 0);
      return;
      paramQQAppInterface.putExtra("url", paramString.replace("$FriendUin$", paramSessionInfo.jdField_a_of_type_JavaLangString).replace("$CurType$", String.valueOf(paramSessionInfo.jdField_a_of_type_Int)));
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is get from file");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList paramArrayList, Intent paramIntent)
  {
    Object localObject = new Intent(paramActivity, AlbumListActivity.class);
    paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(59);
    ((Intent)localObject).putExtra("showFlashPic", FlashPicHelper.a(paramSessionInfo.jdField_a_of_type_Int, paramQQAppInterface, paramSessionInfo.jdField_b_of_type_JavaLangString));
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    int i2;
    boolean bool2;
    int i1;
    boolean bool1;
    if ((!SplashActivity.class.isInstance(paramActivity)) && (!ChatActivity.class.isInstance(paramActivity)) && (!LiteActivity.class.isInstance(paramActivity)))
    {
      ((Intent)localObject).putExtras(paramActivity.getIntent());
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "enterAlbum() INIT_ACTIVITY_CLASS_NAME=" + ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
      }
      ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      i2 = 20;
      bool2 = false;
      if (paramIntent == null) {
        break label941;
      }
      i1 = paramIntent.getIntExtra("peakconstant.request_code", -1);
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      i2 = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      bool2 = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      bool1 = paramIntent.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      int i3 = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      if (i3 == 1039) {
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      }
      if (i3 == 1040) {
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      PhotoUtils.a(paramIntent, (Intent)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterAlbum  maxNum = " + i2);
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 9501) {
        ((Intent)localObject).putExtra("isdevicesupportmultiupload", true);
      }
      ((Intent)localObject).putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", bool2);
      ((Intent)localObject).putExtra("filter_photolist_troopalbum_toolbar", bool1);
      ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", i2);
      ((Intent)localObject).putExtra("extra_image_sender_tag", "sessionInfo.enterAlbum");
      ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      ((Intent)localObject).putExtra("album_enter_directly", true);
      ((Intent)localObject).putExtra("ALBUM_ID", AlbumUtil.a(paramActivity));
      ((Intent)localObject).putExtra("ALBUM_NAME", AlbumUtil.b(paramActivity));
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uinname", paramSessionInfo.d);
      ((Intent)localObject).putExtra("entrance", paramSessionInfo.jdField_c_of_type_Int);
      ((Intent)localObject).putExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if ((((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))) && (((FragmentActivity)paramActivity).getChatFragment() != null)) {
        ((Intent)localObject).putExtra("isBack2Root", ((FragmentActivity)paramActivity).getChatFragment().a().h);
      }
      ((Intent)localObject).putExtra("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      ((Intent)localObject).putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", a(paramSessionInfo));
      ((Intent)localObject).getExtras().remove("forward_type");
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        ((Intent)localObject).putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      }
      if (i1 == -1) {
        paramActivity.startActivity((Intent)localObject);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "enterPhotoPicker");
        }
        AlbumUtil.a(paramActivity, false, true);
        if (PeakUtils.a != null) {
          PeakUtils.a.b();
        }
        return;
        if ((paramActivity instanceof SplashActivity))
        {
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          paramQQAppInterface = AIOUtils.a((Intent)localObject, null);
          label695:
          paramQQAppInterface.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          paramQQAppInterface.putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
          if (paramSessionInfo.jdField_a_of_type_Int != 9501) {
            break label893;
          }
          if (!(paramActivity instanceof SplashActivity)) {
            break label876;
          }
          paramQQAppInterface.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          paramQQAppInterface = AIOUtils.a(paramQQAppInterface, null);
          label755:
          paramQQAppInterface.putExtra(AlbumConstants.i, 80);
          paramQQAppInterface.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          paramQQAppInterface.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          paramQQAppInterface.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        }
        for (;;)
        {
          paramQQAppInterface.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
          paramQQAppInterface.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          localObject = paramQQAppInterface;
          break;
          if ((paramActivity instanceof LiteActivity))
          {
            ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
            paramQQAppInterface = (QQAppInterface)localObject;
            break label695;
          }
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          paramQQAppInterface = (QQAppInterface)localObject;
          break label695;
          label876:
          paramQQAppInterface.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          break label755;
          label893:
          paramQQAppInterface.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
          paramQQAppInterface.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          paramQQAppInterface.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        }
        paramActivity.startActivityForResult((Intent)localObject, i1);
      }
      label941:
      bool1 = false;
      i1 = -1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new neb(paramSessionInfo, paramQQAppInterface, paramContext, ImageUtil.c(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, BaseChatPie paramBaseChatPie)
  {
    if (VideoActionSheet.a()) {
      return;
    }
    VideoActionSheet localVideoActionSheet = VideoActionSheet.a(paramContext);
    int[] arrayOfInt = new int[5];
    if (((paramSessionInfo.jdField_a_of_type_Int == 1025) || (paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1004)) && (((QidianManager)paramQQAppInterface.getManager(164)).c(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      arrayOfInt[0] = 5;
      localVideoActionSheet.c(2131361806);
    }
    for (int i1 = 1;; i1 = 0)
    {
      arrayOfInt[i1] = 1;
      localVideoActionSheet.c(2131368096);
      int i2 = i1 + 1;
      Object localObject1 = (PstnManager)paramQQAppInterface.getManager(142);
      Object localObject2 = ((PstnManager)localObject1).a(paramQQAppInterface.a());
      PstnSessionInfo localPstnSessionInfo = PstnUtils.a(paramQQAppInterface, new PstnSessionInfo(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      int i3;
      if ((localPstnSessionInfo.jdField_b_of_type_JavaLangString != null) && (localPstnSessionInfo.jdField_c_of_type_JavaLangString != null))
      {
        localPstnSessionInfo.d = paramSessionInfo.d;
        if ((localObject2 != null) && (((PstnManager)localObject1).a() == 1) && (((PstnManager)localObject1).a().jdField_c_of_type_Int == 1))
        {
          localVideoActionSheet.a(2131372446);
          if (((PstnCardInfo)localObject2).pstn_c2c_call_time > 0)
          {
            localVideoActionSheet.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131372444), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130839269), 0);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
            i1 = 1;
            arrayOfInt[i2] = 4;
            i3 = i2 + 1;
            i2 = i1;
            i1 = i3;
          }
        }
      }
      for (;;)
      {
        arrayOfInt[i1] = 2;
        localVideoActionSheet.c(2131368093);
        if ((paramBaseChatPie instanceof FriendChatPie))
        {
          localObject1 = ((FriendChatPie)paramBaseChatPie).a();
          if (localObject1 != null)
          {
            if ((!NetworkUtil.e(paramContext)) || (TextUtils.isEmpty(((AIOJumpLightalkConfig)localObject1).g))) {
              break label656;
            }
            localObject2 = URLDrawable.getDrawable(((AIOJumpLightalkConfig)localObject1).g, 0, 0, null, null, false);
            localVideoActionSheet.a(((AIOJumpLightalkConfig)localObject1).f, (Drawable)localObject2, 0);
          }
        }
        for (;;)
        {
          arrayOfInt[(i1 + 1)] = 3;
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005B01", "0X8005B01", 0, 0, "", "", "", "");
          localVideoActionSheet.d(2131367262);
          localVideoActionSheet.a(new ndw(paramQQAppInterface, arrayOfInt));
          localVideoActionSheet.a(new ndy(localVideoActionSheet, arrayOfInt, i2, paramQQAppInterface, paramContext, localPstnSessionInfo, paramSessionInfo, paramBaseChatPie, paramString));
          localVideoActionSheet.show();
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
          return;
          if ((((PstnManager)localObject1).b() == 1) && (((PstnCardInfo)localObject2).pstn_c2c_try_status == 0))
          {
            localVideoActionSheet.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131372444), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130839268), 0);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
            i1 = 2;
            break;
          }
          localVideoActionSheet.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131372444), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130839267), 0);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
          i1 = 5;
          break;
          label656:
          localVideoActionSheet.c(((AIOJumpLightalkConfig)localObject1).f);
        }
        i3 = 0;
        i1 = i2;
        i2 = i3;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map paramMap)
  {
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "0X80049C5";
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        str1 = "0";
      }
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", str2, str2, 0, 0, str1, "", "", "");
      b(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString, paramMap);
      return;
      str2 = "0X80049C7";
      break;
      str1 = "0";
      continue;
      str1 = "1";
      continue;
      str1 = "2";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
      continue;
      str1 = "5";
      continue;
      str1 = "6";
      continue;
      str1 = "7";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, int paramInt)
  {
    QLog.i("Q.aio.xxx", 2, "[enterCamera] + Enter");
    if (AudioHelper.b(0)) {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131367661), paramContext.getString(2131367662), new nec(), null).show();
    }
    do
    {
      return;
      if (AudioHelper.a(0))
      {
        DialogUtil.a(paramContext, 230, paramContext.getString(2131367661), paramContext.getString(2131367663), new ned(), null).show();
        return;
      }
      paramQQAppInterface.a().c();
      a(paramQQAppInterface, paramBaseActivity, 1, paramSessionInfo);
      paramBaseActivity.setCanLock(false);
    } while (paramSessionInfo.jdField_a_of_type_Int != 9501);
    SmartDeviceReport.a(paramQQAppInterface, Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 2, 0, paramInt);
  }
  
  public static boolean a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool4 = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpresend_whitelist.name());
    Object localObject = BaseApplication.getContext();
    int i1;
    boolean bool2;
    boolean bool1;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if (Build.VERSION.SDK_INT > 10)
    {
      i1 = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i1);
      bool2 = ((SharedPreferences)localObject).getBoolean("key_presend_off_flag", false);
      bool1 = bool2;
      if (bool2)
      {
        long l1 = ((SharedPreferences)localObject).getLong("key_presend_off_time", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l1 > 86400000L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed,PicPresend off more than 24h ,enable PicPresend!");
          }
          ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", false).commit();
          bool1 = false;
        }
      }
      if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "isPresendAllowed ,is VIP User");
        }
        bool1 = false;
      }
      bool2 = bool1;
      if (paramSessionInfo.jdField_a_of_type_Int == 1001)
      {
        bool2 = bool1;
        if (!paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PEAK", 2, "isPresendAllowed,old lbs protocol ,disable PicPresend!");
          }
          bool2 = true;
        }
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 9500)
      {
        paramBoolean = bool2;
        if (paramSessionInfo.jdField_a_of_type_Int != 9501) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "curType is smart device ,disable PicPresend!");
        }
        paramBoolean = true;
      }
      paramSessionInfo = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pic_presend.name(), "0|0|0|0|1|0|1|1|1048576|0|307200|307200|0|90|70|50");
      bool1 = paramBoolean;
      if (!paramBoolean)
      {
        bool1 = paramBoolean;
        if (paramSessionInfo != null)
        {
          bool1 = paramBoolean;
          if (paramSessionInfo.length() > 0)
          {
            paramSessionInfo = paramSessionInfo.split("\\|");
            bool1 = paramBoolean;
            if (paramSessionInfo.length >= 4)
            {
              bool2 = paramSessionInfo[0].equals("1");
              bool5 = paramSessionInfo[1].equals("1");
              bool6 = paramSessionInfo[2].equals("1");
              bool7 = paramSessionInfo[3].equals("1");
              i1 = NetworkUtil.a(BaseApplicationImpl.getContext());
            }
          }
        }
      }
      switch (i1)
      {
      default: 
        label384:
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("PEAK", 2, "isPresendAllowed netType = " + i1 + ",enablePreCompress_WIFI:" + bool2 + ", enablePreCompress_2G = " + bool5 + ", enablePreCompress_3G = " + bool6 + ", enablePreCompress_4G = " + bool7 + ", presendOFF  = " + paramBoolean);
          bool1 = paramBoolean;
        }
        if ((bool4) || (bool1)) {
          break;
        }
      }
    }
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "isPresendAllowed, isInDPCPicPresendWhiteList :" + bool4 + ", presendOFF = " + bool1 + ", result  = " + paramBoolean);
      }
      return paramBoolean;
      i1 = 0;
      break;
      if (!bool2)
      {
        paramBoolean = true;
        break label384;
      }
      paramBoolean = false;
      break label384;
      if (!bool5)
      {
        paramBoolean = true;
        break label384;
      }
      paramBoolean = false;
      break label384;
      if (!bool6)
      {
        paramBoolean = true;
        break label384;
      }
      paramBoolean = false;
      break label384;
      if (!bool7)
      {
        paramBoolean = true;
        break label384;
      }
      paramBoolean = false;
      break label384;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Grp", "Up_sent_files\t", 0, 0, "", paramSessionInfo.jdField_a_of_type_JavaLangString, "", "");
    paramQQAppInterface = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface.putExtra("from_aio", true);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("tab_tab_type", 5);
    paramQQAppInterface.putExtra("key_check_troop_privilege", true);
    paramActivity.startActivityForResult(paramQQAppInterface, 5);
    paramActivity.overridePendingTransition(2130968585, 2130968586);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map paramMap)
  {
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
    String str;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      str = ((PhoneContactManager)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (localObject = paramSessionInfo.jdField_a_of_type_JavaLangString; paramString == null; localObject = ((PhoneContactManager)localObject).b(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, paramString, paramMap);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    QfavHelper.a(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1, false);
    QfavReport.b(paramQQAppInterface, 3, paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, FMLocalFileActivity.class);
    paramQQAppInterface.putExtra("category", 15);
    paramQQAppInterface.putExtra("busiType", 5);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("STRING_Show_Music_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Video_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Apk_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Pic_Category", false);
    paramQQAppInterface.putExtra("STRING_SingleSelect", true);
    paramQQAppInterface.putExtra(AlbumConstants.i, 84);
    paramQQAppInterface.putExtra("STRING_Show_Within_Suffixs", new String[] { "doc", "docx", "txt", "pdf", "ppt", "pptx", "xls", "xlsx", "bmp", "jpg", "gif", "png" });
    paramActivity.startActivityForResult(paramQQAppInterface, 84);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, List paramList)
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "showActionSheet");
    }
    a();
    if (this.jdField_a_of_type_AndroidAppDialog != null) {}
    Object localObject;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception paramQQAppInterface) {}
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      i1 = 0;
      while (i1 < paramList.size())
      {
        localObject = (HbThemeConfigManager.HBThemeConfig)paramList.get(i1);
        if (!TextUtils.isEmpty(((HbThemeConfigManager.HBThemeConfig)localObject).jdField_a_of_type_JavaLangString))
        {
          localArrayList1.add(new Pair(Integer.valueOf(l + i1), ((HbThemeConfigManager.HBThemeConfig)localObject).jdField_a_of_type_JavaLangString));
          localArrayList2.add(localObject);
        }
        i1 += 1;
      }
    }
    int i1 = localArrayList2.size();
    if (i1 > 0)
    {
      m = i1 + l;
      n = m + 1;
      paramList = paramActivity.getResources().getString(2131372044);
      localObject = paramActivity.getResources().getString(2131372045);
      localArrayList1.add(new Pair(Integer.valueOf(m), paramList));
      localArrayList1.add(new Pair(Integer.valueOf(n), localObject));
    }
    paramList = ActionSheet.c(paramActivity);
    i1 = i2;
    if (i1 < localArrayList1.size())
    {
      if (n == ((Integer)((Pair)localArrayList1.get(i1)).first).intValue()) {
        paramList.d((CharSequence)((Pair)localArrayList1.get(i1)).second);
      }
      for (;;)
      {
        i1 += 1;
        break;
        paramList.c((CharSequence)((Pair)localArrayList1.get(i1)).second);
      }
    }
    paramList.a(new nef(this, localArrayList1, paramQQAppInterface, paramActivity, paramSessionInfo, localArrayList2, paramList));
    paramList.a(new ndx(this));
    paramList.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog = paramList;
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt)
  {
    List localList = a(paramQQAppInterface, paramActivity, paramSessionInfo);
    if ((localList != null) && (localList.size() > 0))
    {
      a(paramQQAppInterface, paramActivity, paramSessionInfo, localList);
      return;
    }
    a(paramQQAppInterface, paramActivity, paramSessionInfo, null, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\PlusPanelUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */