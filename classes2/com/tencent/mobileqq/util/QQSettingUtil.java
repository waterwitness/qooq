package com.tencent.mobileqq.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import vzg;
import vzh;
import vzi;

public class QQSettingUtil
{
  public static int a = 0;
  public static final String a = "QQSetting";
  public static final String b = "Setting_Quit";
  
  public QQSettingUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt("setting_quit_" + paramString, 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getApplicationContext().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("mywallet_flag", 1);
  }
  
  public static SpannableString a(Resources paramResources, int paramInt)
  {
    if (paramResources == null) {
      return new SpannableString("");
    }
    Object localObject;
    if (paramInt == 0)
    {
      localObject = new SpannableString("*");
      paramInt = (int)paramResources.getDimension(2131492997);
      paramResources = paramResources.getDrawable(2130841092);
      paramResources.setBounds(0, 0, paramInt, paramInt);
      ((SpannableString)localObject).setSpan(new ImageSpan(paramResources), 0, 1, 33);
      return (SpannableString)localObject;
    }
    int k = paramInt / 64;
    paramInt %= 64;
    int m = paramInt / 16;
    int i1 = paramInt % 16;
    int n = i1 / 4;
    String str1 = "";
    int i = 0;
    while (i < 4)
    {
      paramInt = 0;
      localObject = "";
      switch (i)
      {
      }
      for (;;)
      {
        int j = 0;
        while (j < paramInt)
        {
          str1 = str1 + (String)localObject;
          j += 1;
        }
        localObject = "!";
        paramInt = k;
        continue;
        localObject = "@";
        paramInt = m;
        continue;
        localObject = "#";
        paramInt = n;
        continue;
        localObject = "%";
        paramInt = i1 % 4;
      }
      i += 1;
    }
    if ((a > 1) && (str1.length() > a))
    {
      localObject = str1.substring(0, a - 1);
      str1 = (String)localObject + "$";
    }
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str1);
      i = (int)paramResources.getDimension(2131492997);
      paramInt = 0;
      if (paramInt < str1.length())
      {
        String str2 = str1.substring(paramInt, paramInt + 1);
        if ("!".equalsIgnoreCase(str2))
        {
          localObject = paramResources.getDrawable(2130841090);
          label336:
          if (localObject != null)
          {
            if (!"&".equalsIgnoreCase(str2)) {
              break label475;
            }
            ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), paramInt, paramInt + 1, 33);
          paramInt += 1;
          break;
          if ("@".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130841094);
            break label336;
          }
          if ("#".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130841091);
            break label336;
          }
          if ("%".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130841093);
            break label336;
          }
          if ("$".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130843493);
            break label336;
          }
          localObject = null;
          break label336;
          label475:
          ((Drawable)localObject).setBounds(0, 0, i, i);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseQQLevel, sLevel = " + str1 + ", span = " + localSpannableString);
      }
      return localSpannableString;
    }
  }
  
  public static SpannableString a(View paramView, Resources paramResources, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(paramView);
    SpannableString localSpannableString = new SpannableString("");
    paramView = null;
    int i = (int)paramResources.getDimension(2131492997);
    Drawable localDrawable;
    if ((paramBoolean1) && (paramInt > 0))
    {
      localSpannableString = new SpannableString("sb");
      paramView = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/svip_" + paramInt + ".png";
      localDrawable = paramResources.getDrawable(2130841101);
      paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
      paramView.setBounds(0, 0, (int)(68.0D * (i / 24.0D)), i);
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.mutate();
        ((URLDrawable)paramView).setURLDrawableListener(new vzh(localWeakReference));
        localSpannableString.setSpan(new ImageSpan(paramView), 0, 1, 33);
        paramView = paramResources.getDrawable(2130841108);
        paramView.setBounds(0, 0, (int)paramResources.getDimension(2131492998), i);
        localSpannableString.setSpan(new ImageSpan(paramView), 1, 2, 33);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseClubLevel, bSuperVipOpen=" + paramBoolean1 + ", bQQVipOpen=" + paramBoolean2 + ",iVipLevel=" + paramInt);
      }
      return localSpannableString;
      if ((paramBoolean2) && (paramInt > 0))
      {
        localSpannableString = new SpannableString("vb");
        paramView = "http://i.gtimg.cn/club/mobile/profile/vipicon2016/android/vip_" + paramInt + ".png";
        localDrawable = paramResources.getDrawable(2130841107);
        paramView = URLDrawable.getDrawable(paramView, localDrawable, localDrawable);
        paramView.setBounds(0, 0, (int)(58.0D * (i / 24.0D)), i);
      }
    }
  }
  
  public static String a(long paramLong)
  {
    if (paramLong == 11L) {
      return "在线";
    }
    if (paramLong == 41L) {
      return "隐身";
    }
    if (paramLong == 31L) {
      return "离线";
    }
    return "";
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = true;
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.a();
    if (paramBoolean)
    {
      bool = false;
      localIntent.putExtra("tab_index", MainFragment.a);
    }
    paramQQAppInterface.logout(bool);
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
    int i = a(paramActivity, paramQQAppInterface.a());
    a(paramActivity, paramQQAppInterface.a(), i + 1);
    paramActivity.startActivityForResult(localIntent, 1000);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt("setting_quit_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(ImageView paramImageView, long paramLong)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "online status = " + paramLong);
      }
      if (paramLong == 11L)
      {
        paramImageView.setImageResource(2130843343);
        return;
      }
      if (paramLong == 41L)
      {
        paramImageView.setImageResource(2130843339);
        return;
      }
    } while (paramLong != 31L);
    paramImageView.setImageResource(2130843341);
  }
  
  public static void a(TextView paramTextView, BusinessInfoCheckUpdate.AppInfo paramAppInfo, QQAppInterface paramQQAppInterface)
  {
    Object localObject = null;
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag != null) && (paramAppInfo.iNewFlag.get() != 0)) {}
    int j;
    int i;
    switch (paramAppInfo.type.get())
    {
    case 3: 
    default: 
      j = 0;
      i = 0;
      paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject;
    }
    for (;;)
    {
      if (i == 1)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(2130841855, 0, 0, 0);
        paramTextView.setVisibility(0);
        paramTextView.setText("");
        paramTextView.setBackgroundResource(0);
        paramTextView.setPadding(0, 0, 0, 0);
        return;
        i = 2;
        j = 0;
        paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject;
        continue;
        j = 0;
        i = 1;
        paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject;
        continue;
        if (paramAppInfo.num != null) {}
        for (j = paramAppInfo.num.get();; j = 0)
        {
          if (j <= 0) {
            break label208;
          }
          i = 3;
          paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject;
          break;
        }
        paramQQAppInterface = (RedTouchManager)paramQQAppInterface.getManager(35);
        i = 5;
        paramAppInfo = paramQQAppInterface.a(paramAppInfo);
        j = 0;
      }
      else
      {
        CustomWidgetUtil.a(paramTextView, i, j, 0, 99, paramAppInfo);
        return;
        label208:
        i = 0;
        paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a(new vzg(paramQQAppInterface));
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = paramQQAppInterface.a();
    boolean bool = SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131367826), "qqsetting_auto_receive_pic_key", true);
    int i;
    Object localObject3;
    if (bool)
    {
      i = 1;
      ((Map)localObject1).put("Clk_auto_receive_pic", Integer.valueOf(i));
      localObject3 = (StatusManager)paramQQAppInterface.getManager(14);
      if (localObject3 != null)
      {
        bool = ((StatusManager)localObject3).b();
        if (!bool) {
          break label1144;
        }
        i = 1;
        label82:
        ((Map)localObject1).put("Clk_signature_qzone", Integer.valueOf(i));
        if (!ConfigHandler.a(paramQQAppInterface, false)) {
          break label1150;
        }
        i = 1;
        label108:
        ((Map)localObject1).put("Download_new", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, ((Context)localObject2).getString(2131370224), "qqsetting_notify_icon_key", false)) {
          break label1156;
        }
        i = 1;
        label145:
        ((Map)localObject1).put("System_icon", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, null, paramQQAppInterface.a().getString(2131367880), "qqsetting_enter_sendmsg_key", false)) {
          break label1162;
        }
        i = 1;
        label185:
        ((Map)localObject1).put("Enter_sendmsg", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject2, paramQQAppInterface.a(), "login_accounts", "qqsetting_bothonline_key", true)) {
          break label1168;
        }
        i = 1;
        label221:
        ((Map)localObject1).put("Mobile_pc_online", Integer.valueOf(i));
        if (!paramQQAppInterface.n()) {
          break label1174;
        }
        i = 1;
        label246:
        ((Map)localObject1).put("Visible_same", Integer.valueOf(i));
        if (!paramQQAppInterface.p()) {
          break label1180;
        }
        i = 1;
        label271:
        ((Map)localObject1).put("Same_likeme", Integer.valueOf(i));
        if (!paramQQAppInterface.b(true)) {
          break label1186;
        }
        i = 1;
        label297:
        ((Map)localObject1).put("Search_number", Integer.valueOf(i));
        if (!NearbySPUtil.b(paramQQAppInterface.getAccount())) {
          break label1192;
        }
        i = 1;
        label325:
        ((Map)localObject1).put("Visible_nearby", Integer.valueOf(i));
        if (!paramQQAppInterface.o()) {
          break label1198;
        }
        i = 1;
        label350:
        ((Map)localObject1).put("Nearby_likeme", Integer.valueOf(i));
        if (paramQQAppInterface.f() != 0) {
          break label1204;
        }
        i = 0;
        label375:
        if (i == 0) {
          break label1210;
        }
        i = 1;
        label383:
        ((Map)localObject1).put("Latest_chatlog_syn", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.a()) != 2) {
          break label1216;
        }
        i = 1;
        label413:
        if (i == 0) {
          break label1222;
        }
        i = 1;
        label421:
        ((Map)localObject1).put("Gesture_password", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue(paramQQAppInterface.a(), null, "security_scan_key", "qqsetting_security_scan_key", false)) {
          break label1228;
        }
        i = 1;
        label457:
        ((Map)localObject1).put("Security_check", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject2, paramQQAppInterface.a()) != 2) {
          break label1234;
        }
        i = 1;
        label487:
        if (i == 0) {
          break label1240;
        }
        i = 1;
        label495:
        ((Map)localObject1).put("Setting_Gesture_password", Integer.valueOf(i));
        if (!TroopAssistantManager.a().a()) {
          break label1246;
        }
        i = 1;
        label522:
        ((Map)localObject1).put("Clk_hide_grp_heper", Integer.valueOf(i));
        if (!TroopAssistantManager.a().b()) {
          break label1252;
        }
        i = 1;
        label549:
        ((Map)localObject1).put("Clk_grp_heper_top", Integer.valueOf(i));
        localObject2 = ((Map)localObject1).keySet();
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", (String)localObject3, 0, 0, String.valueOf(((Map)localObject1).get(localObject3)), "", "", "");
          continue;
        }
        if (!SettingCloneUtil.readValue(paramQQAppInterface.a(), null, paramQQAppInterface.a().getString(2131367835), "qqsetting_screenshot_key", false)) {
          break label1258;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", "Shake_screenshot_switch", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.c(false)) {
          break label1264;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X80044D1", "0X80044D1", 0, 0, String.valueOf(i), "", "", "");
        localObject1 = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramQQAppInterface.a());
        if (localObject1 != null)
        {
          if (!((Card)localObject1).allowPeopleSee) {
            break label1270;
          }
          i = 1;
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004884", "0X8004884", 0, 0, String.valueOf(i), "", "", "");
        }
        if (!paramQQAppInterface.a().a()) {
          break label1276;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004956", "0X8004956", 0, 0, String.valueOf(i), "", "", "");
        if (!HotChatManager.b(paramQQAppInterface)) {
          break label1282;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004B1E", "0X8004B1E", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.d(false)) {
          break label1288;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C5C", "0X8004C5C", 0, 0, String.valueOf(i), "", "", "");
        if (!paramQQAppInterface.e(false)) {
          break label1294;
        }
        i = 1;
        ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C5D", "0X8004C5D", 0, 0, String.valueOf(i), "", "", "");
        localObject3 = (FriendsManager)paramQQAppInterface.getManager(50);
        i = ((FriendsManager)localObject3).e();
        if (i <= 0) {
          break label1300;
        }
        localObject1 = "1";
        if (i > 0)
        {
          localObject2 = String.valueOf(i);
          ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004C69", "0X8004C69", 0, 0, (String)localObject1, (String)localObject2, String.valueOf(((FriendsManager)localObject3).d()), "");
          if (((ActivateFriendsManager)paramQQAppInterface.getManager(84)).a(false))
          {
            i = 1;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004E0C", "0X8004E0C", 0, i, String.valueOf(i), "", "", "");
            if (!paramQQAppInterface.m) {
              continue;
            }
            i = 1;
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "0X8004EDE", "0X8004EDE", 0, 0, String.valueOf(i), "", "", "");
          }
        }
        else
        {
          localObject2 = "";
          continue;
        }
        i = 0;
        continue;
        i = 0;
        continue;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      i = 0;
      break;
      label1144:
      i = 0;
      break label82;
      label1150:
      i = 0;
      break label108;
      label1156:
      i = 0;
      break label145;
      label1162:
      i = 0;
      break label185;
      label1168:
      i = 0;
      break label221;
      label1174:
      i = 0;
      break label246;
      label1180:
      i = 0;
      break label271;
      label1186:
      i = 0;
      break label297;
      label1192:
      i = 0;
      break label325;
      label1198:
      i = 0;
      break label350;
      label1204:
      i = 1;
      break label375;
      label1210:
      i = 0;
      break label383;
      label1216:
      i = 0;
      break label413;
      label1222:
      i = 0;
      break label421;
      label1228:
      i = 0;
      break label457;
      label1234:
      i = 0;
      break label487;
      label1240:
      i = 0;
      break label495;
      label1246:
      i = 0;
      break label522;
      label1252:
      i = 0;
      break label549;
      label1258:
      i = 0;
      continue;
      label1264:
      i = 0;
      continue;
      label1270:
      i = 0;
      continue;
      label1276:
      i = 0;
      continue;
      label1282:
      i = 0;
      continue;
      label1288:
      i = 0;
      continue;
      label1294:
      i = 0;
      continue;
      label1300:
      localObject1 = "0";
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Vip_pay_mywallet").append('|').append(paramQQAppInterface.a()).append('|').append("").append('|').append("wallet").append('|').append("index").append('|').append(0).append('|').append(1).append('|').append(0).append('|').append("").append('|').append("").append('|').append("").append('|').append("").append('|');
      StatisticCollector.a(null).c(paramQQAppInterface, localStringBuilder.toString());
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    if (!TextUtils.equals(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()), localSharedPreferences.getString("vip_qqsetting_last_update_time", "2015-04-17")))
    {
      paramQQAppInterface = paramQQAppInterface.a(0);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_JavaLangString = "http://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json";
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new vzi(localSharedPreferences);
      paramQQAppInterface.a(localHttpNetReq);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\QQSettingUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */