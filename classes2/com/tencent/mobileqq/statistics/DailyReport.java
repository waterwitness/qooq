package com.tencent.mobileqq.statistics;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uuf;

public class DailyReport
  extends AsyncStep
{
  private static final long c = 86400000L;
  private static int j = 50000;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new uuf(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static String a(Context paramContext)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = (InputMethodManager)paramContext.getSystemService("input_method");
    try
    {
      localObject = ((InputMethodManager)localObject).getInputMethodList();
      int i;
      if (localObject == null) {
        i = 0;
      }
      while (k < i)
      {
        localStringBuffer.append(((InputMethodInfo)((List)localObject).get(k)).loadLabel(paramContext.getPackageManager()));
        localStringBuffer.append(';');
        k += 1;
        continue;
        i = ((List)localObject).size();
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      paramContext = localStringBuffer.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.a().getApplicationContext();
    try
    {
      String str = Settings.Secure.getString(((Context)localObject).getContentResolver(), "default_input_method");
      localObject = a((Context)localObject);
      ReportController.b(paramQQAppInterface, "CliOper", "", paramQQAppInterface.a(), "Type_input", "Type_input", 0, 0, "", "", str, (String)localObject);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MainActivityReportHelper", 1, "reportIMEInfo fail", paramQQAppInterface);
    }
  }
  
  private void a(StatisticCollector paramStatisticCollector)
  {
    HashMap localHashMap = new HashMap();
    int i = 89050;
    if (SkinEngine.IS_PROBLEM_MIUI)
    {
      localHashMap.put("param_FailCode", Integer.toString(i));
      if ((!BaseApplicationImpl.jdField_a_of_type_Boolean) || (SkinEngine.IS_PROBLEM_MIUI)) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      paramStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "report_skin_engine_enable", bool, 0L, 0L, localHashMap, "");
      return;
      i = 89051;
      break;
    }
  }
  
  private void a(String paramString)
  {
    int i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4dongtai");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 8, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4buddylist");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 21, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_op4recent");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clk_data_wire_in", 22, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckpic");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_pic", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckvideo");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_video", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckfile");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_file", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_cktxt");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_text", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_cktkphoto");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Upload_photo", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_copy");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_copy", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forward");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_retran", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_delete");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_delete", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_save2weiyun");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Long_press_weiyun", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckadv");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "data_wire_setting", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckviewrecvfile");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Chkfiles_data_wire", 0, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_ckclearmsg");
    if (i > 0) {
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Clean_data_wire", 0, i, 0);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("auto_receive_files", false);
    StatisticCollector localStatisticCollector = StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    HashMap localHashMap = new HashMap();
    localHashMap.clear();
    if (bool) {}
    for (i = 1;; i = 0)
    {
      localHashMap.put("auto_receive_files", Integer.valueOf(i));
      localStatisticCollector.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, localHashMap);
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_text");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_text", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_image");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_pic", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_file");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_file", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_forwardin_link");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Retran_link", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_open_via_qq");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "Open_via_qq", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_share_my_pc");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "share_my_PC", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "dl_share_frd");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "data_wire", "share_frd", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Clk_disconnect_wp");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Clk_disconnect_wp", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Clk_wp_back");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Clk_wp_back", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, paramString, "Open_wp");
      if (i > 0) {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramString, "Wifiphoto", "Open_wp", 0, i, 0);
      }
      return;
    }
  }
  
  private void b(StatisticCollector paramStatisticCollector)
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity");
    HashMap localHashMap = new HashMap();
    int i = localActivityManager.getMemoryClass();
    localHashMap.put("param_FailCode", Integer.toString(89000 + i));
    paramStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "report_mem_cache_size", false, i, 0L, localHashMap, "");
  }
  
  private static void b(String paramString)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (((SharedPreferences)localObject).getBoolean("hasReportDeviceProfile", false)) {
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("hasReportDeviceProfile", true);
    localObject = new HashMap();
    int i = (int)Math.min(DeviceInfoUtil.i(), DeviceInfoUtil.h());
    int k = DeviceInfoUtil.b() * 100 + j;
    if (i <= 240) {
      i = k + 1;
    }
    for (;;)
    {
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      StatisticCollector.a(BaseApplication.getContext()).a(paramString, "reportDeviceProfile", false, 0L, 0L, (HashMap)localObject, "");
      return;
      if (i <= 320) {
        i = k + 2;
      } else if (i <= 480) {
        i = k + 3;
      } else if (i <= 640) {
        i = k + 4;
      } else if (i <= 720) {
        i = k + 5;
      } else if (i <= 1080) {
        i = k + 6;
      } else {
        i = k + 7;
      }
    }
  }
  
  private void d()
  {
    HashMap localHashMap = new HashMap();
    int i = StatisticTroopAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (i > 0) {
      localHashMap.put("Click_grp_asst", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.b(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (i > 0) {
      localHashMap.put("grp_setting_asst", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.c(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (i > 0) {
      localHashMap.put("grp_setting_msg", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.d(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (i > 0) {
      localHashMap.put("grp_msg_equ", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.e(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (i > 0) {
      localHashMap.put("grp_msg_dec", Integer.valueOf(i));
    }
    i = StatisticTroopAssist.f(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (i > 0) {
      localHashMap.put("grp_msg_inc", Integer.valueOf(i));
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localHashMap);
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    int i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_tab");
    if (i > 0) {
      localStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_tab", 1, i, 0);
    }
    i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_mall_in2");
    if (i > 0) {
      localStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_mall_in", 2, i, 0);
    }
    Object localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localObject != null)
    {
      localObject = ((EmoticonManager)localObject).a();
      if (localObject == null) {}
    }
    for (i = ((List)localObject).size();; i = 0)
    {
      localObject = new HashMap();
      ((Map)localObject).put("Ep_amount", Integer.valueOf(i));
      localStatisticCollector.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, (Map)localObject);
      i = 0;
      while (i < 3)
      {
        int k = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "ep_tab2" + i);
        localStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "ep_tab2", 0, k, 0, i);
        i += 1;
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Ep_manage");
      if (i > 0) {
        localStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Ep_manage", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Clk_ep_edit");
      if (i > 0) {
        localStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Clk_ep_edit", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Delete_ep");
      if (i > 0) {
        localStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Delete_ep", 0, i, 0);
      }
      i = StatisticAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, str, "Ep_order");
      if (i > 0) {
        localStatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "", "ep_mall", "Ep_order", 0, i, 0);
      }
      return;
    }
  }
  
  private void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localObject2 != null)
    {
      localObject1 = ((FriendsManager)localObject2).a((String)localObject1);
      if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid())) {}
    }
    else
    {
      return;
    }
    File localFile = new File(AvatarPendantUtil.a(((ExtensionInfo)localObject1).pendantId, 4));
    if (!localFile.exists())
    {
      localObject2 = (DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      String str = AvatarPendantUtil.b(((ExtensionInfo)localObject1).pendantId, 4);
      Bundle localBundle = new Bundle();
      localBundle.putLong("id", ((ExtensionInfo)localObject1).pendantId);
      localObject1 = new DownloadTask(str, localFile);
      ((DownloaderFactory)localObject2).a(1).a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      return;
    }
    localObject2 = AvatarPendantUtil.a(localFile);
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(((ExtensionInfo)localObject1).pendantId), 0, 0, 0, 0, (String)localObject2, "");
  }
  
  private void g()
  {
    List localList = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a();
    String str = "";
    Object localObject = str;
    int i;
    if (localList != null)
    {
      i = 0;
      localObject = str;
      if (i < localList.size())
      {
        localObject = (EmoticonPackage)localList.get(i);
        if ((3 != ((EmoticonPackage)localObject).jobType) && (5 != ((EmoticonPackage)localObject).jobType)) {
          break label143;
        }
        if (str.equals("")) {
          str = ((EmoticonPackage)localObject).epId;
        }
      }
    }
    label143:
    for (;;)
    {
      i += 1;
      break;
      str = str + "|" + ((EmoticonPackage)localObject).epId;
      continue;
      VasWebviewUtil.reportVasStatus("MbBaoyou", "MbBaoyouID", "0", 0, 0, 0, 0, (String)localObject, "");
      return;
    }
  }
  
  private void h()
  {
    String str3 = ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62)).c(null);
    String str2;
    String str1;
    if (str3.equals("custom"))
    {
      str2 = "0X8004E10";
      str1 = "0X8004E10";
    }
    for (;;)
    {
      VasWebviewUtil.reportVasStatus(str2, str1, str3, 0, 0);
      return;
      str1 = "0X8004E0F";
      str2 = "0X8004E0F";
    }
  }
  
  private void i()
  {
    VasWebviewUtil.reportVasStatus("0X800498F", "0X800498F", ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).h(), 0);
  }
  
  private void j()
  {
    SVIPHandler localSVIPHandler = (SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
    VasWebviewUtil.reportVasStatus("0X8004990", "0X8004990", String.valueOf(localSVIPHandler.e()), localSVIPHandler.h(), 0);
  }
  
  private void k()
  {
    boolean bool1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("font_open_switch", 0).getBoolean("isUserOpenFontSwitch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
    int i;
    if (bool1) {
      i = 2;
    }
    for (;;)
    {
      VasWebviewUtil.reportVasStatus("font_switch", "switch_on", "0", 0, 0, i, 0, "", "");
      return;
      if (bool2) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private void l()
  {
    Object localObject1 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    if (localObject1 != null)
    {
      localObject1 = ((ApolloManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
      if ((localObject1 == null) || (((ApolloBaseInfo)localObject1).apolloStatus != 1)) {
        break label316;
      }
      Object localObject2 = ((ApolloBaseInfo)localObject1).getApolloDress();
      int k = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      if (localObject2 != null)
      {
        int m = ((ApolloDress)localObject2).a;
        localObject2 = ((ApolloDress)localObject2).a();
        int n = localObject2.length;
        int i = 0;
        for (;;)
        {
          k = m;
          if (i >= n) {
            break;
          }
          localStringBuilder.append(localObject2[i]).append("|");
          i += 1;
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "dress", 0, 0, k + "", ((ApolloBaseInfo)localObject1).apolloVipFlag + "", localStringBuilder.toString(), "");
    }
    for (;;)
    {
      if ((ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (localObject1 != null)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "white", 0, 0, ((ApolloBaseInfo)localObject1).apolloStatus + "", "0", "", "");
      }
      localObject1 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
      if (localObject1 != null)
      {
        localObject1 = ((ApolloDaoManager)localObject1).e();
        if (localObject1 != null) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "action_added", ((List)localObject1).size(), 0, "0", "0", "", "");
        }
      }
      return;
      label316:
      if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloStatus == 2)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "ApolloStatus", "close", 0, 0, "0", "0", "", "");
      }
    }
  }
  
  private void m()
  {
    Object localObject = (PhoneUnityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(101);
    QQAppInterface localQQAppInterface;
    if (((PhoneUnityManager)localObject).d)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((PhoneUnityManager)localObject).a()) {
        break label63;
      }
    }
    label63:
    for (localObject = "1";; localObject = "0")
    {
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8005B8B", "0X8005B8B", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
  
  private void n()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    QQAppInterface localQQAppInterface;
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() });
      if (localNearbyPeopleCard != null)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localNearbyPeopleCard.switchHobby) {
          break label140;
        }
        str = "1";
        ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A12", "0X8004A12", 0, 0, str, "", "", "");
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!localNearbyPeopleCard.switchQzone) {
          break label147;
        }
      }
    }
    label140:
    label147:
    for (String str = "1";; str = "0")
    {
      ReportController.b(localQQAppInterface, "CliStatus", "", "", "0X8004A13", "0X8004A13", 0, 0, str, "", "", "");
      localEntityManager.a();
      return;
      str = "0";
      break;
    }
  }
  
  /* Error */
  protected int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 697	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   5: getfield 701	com/tencent/mobileqq/app/automator/Automator:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: putfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: aload_0
    //   12: invokestatic 704	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: putfield 189	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: aload_0
    //   19: getfield 189	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   22: ldc_w 706
    //   25: iconst_0
    //   26: invokevirtual 707	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   29: astore_2
    //   30: aload_2
    //   31: new 427	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 709
    //   41: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   48: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   51: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: lconst_0
    //   58: invokeinterface 713 4 0
    //   63: lstore 13
    //   65: invokestatic 718	java/lang/System:currentTimeMillis	()J
    //   68: ldc2_w 719
    //   71: lsub
    //   72: lstore 15
    //   74: invokestatic 726	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   77: astore_3
    //   78: invokestatic 726	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   81: astore 4
    //   83: aload 4
    //   85: lload 13
    //   87: invokevirtual 730	java/util/Calendar:setTimeInMillis	(J)V
    //   90: aload 4
    //   92: iconst_5
    //   93: iconst_1
    //   94: invokevirtual 734	java/util/Calendar:add	(II)V
    //   97: aload 4
    //   99: bipush 10
    //   101: invokevirtual 737	java/util/Calendar:clear	(I)V
    //   104: aload 4
    //   106: bipush 12
    //   108: invokevirtual 737	java/util/Calendar:clear	(I)V
    //   111: aload 4
    //   113: bipush 13
    //   115: invokevirtual 737	java/util/Calendar:clear	(I)V
    //   118: aload 4
    //   120: bipush 14
    //   122: invokevirtual 737	java/util/Calendar:clear	(I)V
    //   125: invokestatic 726	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   128: astore_1
    //   129: aload_1
    //   130: iconst_5
    //   131: iconst_1
    //   132: invokevirtual 734	java/util/Calendar:add	(II)V
    //   135: aload_1
    //   136: bipush 10
    //   138: invokevirtual 737	java/util/Calendar:clear	(I)V
    //   141: aload_1
    //   142: bipush 12
    //   144: invokevirtual 737	java/util/Calendar:clear	(I)V
    //   147: aload_1
    //   148: bipush 13
    //   150: invokevirtual 737	java/util/Calendar:clear	(I)V
    //   153: aload_1
    //   154: bipush 14
    //   156: invokevirtual 737	java/util/Calendar:clear	(I)V
    //   159: aload_1
    //   160: invokevirtual 740	java/util/Calendar:getTimeInMillis	()J
    //   163: lload 15
    //   165: lsub
    //   166: ldc2_w 741
    //   169: lsub
    //   170: lconst_0
    //   171: lcmp
    //   172: ifge +3 -> 175
    //   175: lload 13
    //   177: lconst_0
    //   178: lcmp
    //   179: ifle +1377 -> 1556
    //   182: aload_3
    //   183: aload 4
    //   185: invokevirtual 745	java/util/Calendar:after	(Ljava/lang/Object;)Z
    //   188: ifeq +1368 -> 1556
    //   191: aload_0
    //   192: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   195: invokevirtual 609	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   198: invokestatic 747	com/tencent/mobileqq/statistics/DailyReport:b	(Ljava/lang/String;)V
    //   201: aload_0
    //   202: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   205: invokestatic 749	com/tencent/mobileqq/statistics/DailyReport:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   208: aload_0
    //   209: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   212: invokestatic 752	com/tencent/mobileqq/util/QQSettingUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   215: aload_0
    //   216: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   219: aload_0
    //   220: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   223: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   226: invokestatic 757	com/tencent/mobileqq/activity/NotifyPushSettingActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   229: aload_0
    //   230: invokespecial 759	com/tencent/mobileqq/statistics/DailyReport:n	()V
    //   233: aload_0
    //   234: invokespecial 761	com/tencent/mobileqq/statistics/DailyReport:d	()V
    //   237: aload_0
    //   238: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: aload_0
    //   242: getfield 189	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   245: invokestatic 766	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)V
    //   248: aload_0
    //   249: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   252: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   255: astore 6
    //   257: aload_0
    //   258: aload 6
    //   260: invokespecial 768	com/tencent/mobileqq/statistics/DailyReport:a	(Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 189	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   267: astore 7
    //   269: aload 7
    //   271: invokestatic 199	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   274: astore 5
    //   276: aload_0
    //   277: invokespecial 770	com/tencent/mobileqq/statistics/DailyReport:e	()V
    //   280: aload_0
    //   281: invokespecial 772	com/tencent/mobileqq/statistics/DailyReport:f	()V
    //   284: aload_0
    //   285: invokespecial 774	com/tencent/mobileqq/statistics/DailyReport:g	()V
    //   288: aload_0
    //   289: invokespecial 776	com/tencent/mobileqq/statistics/DailyReport:h	()V
    //   292: aload_0
    //   293: invokespecial 778	com/tencent/mobileqq/statistics/DailyReport:i	()V
    //   296: aload_0
    //   297: invokespecial 780	com/tencent/mobileqq/statistics/DailyReport:j	()V
    //   300: aload_0
    //   301: invokespecial 782	com/tencent/mobileqq/statistics/DailyReport:k	()V
    //   304: aload_0
    //   305: invokespecial 784	com/tencent/mobileqq/statistics/DailyReport:l	()V
    //   308: aload_0
    //   309: invokespecial 786	com/tencent/mobileqq/statistics/DailyReport:m	()V
    //   312: aload_0
    //   313: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   316: bipush 91
    //   318: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   321: checkcast 788	com/tencent/mobileqq/app/MessageRoamManager
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +60 -> 386
    //   329: aload_1
    //   330: invokevirtual 790	com/tencent/mobileqq/app/MessageRoamManager:g	()Z
    //   333: ifeq +53 -> 386
    //   336: aload_1
    //   337: invokevirtual 791	com/tencent/mobileqq/app/MessageRoamManager:b	()I
    //   340: iconst_1
    //   341: if_icmpne +352 -> 693
    //   344: ldc_w 793
    //   347: astore_1
    //   348: aload_0
    //   349: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   352: ldc_w 795
    //   355: ldc_w 797
    //   358: ldc_w 799
    //   361: iconst_1
    //   362: iconst_0
    //   363: iconst_3
    //   364: anewarray 368	java/lang/String
    //   367: dup
    //   368: iconst_0
    //   369: ldc_w 538
    //   372: aastore
    //   373: dup
    //   374: iconst_1
    //   375: ldc_w 538
    //   378: aastore
    //   379: dup
    //   380: iconst_2
    //   381: aload_1
    //   382: aastore
    //   383: invokestatic 804	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   386: aload_0
    //   387: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   390: bipush 50
    //   392: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   395: checkcast 450	com/tencent/mobileqq/app/FriendsManager
    //   398: astore 8
    //   400: aconst_null
    //   401: astore_1
    //   402: aload 8
    //   404: ifnull +11 -> 415
    //   407: aload 8
    //   409: aload 6
    //   411: invokevirtual 453	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   414: astore_1
    //   415: aload_1
    //   416: ifnull +21 -> 437
    //   419: ldc_w 806
    //   422: ldc_w 808
    //   425: aload_1
    //   426: getfield 811	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   429: invokestatic 510	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   432: iconst_0
    //   433: iconst_0
    //   434: invokestatic 550	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:reportVasStatus	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   437: aload_1
    //   438: ifnull +48 -> 486
    //   441: aload_0
    //   442: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: bipush 13
    //   447: invokevirtual 563	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   450: checkcast 565	com/tencent/mobileqq/app/SVIPHandler
    //   453: invokevirtual 567	com/tencent/mobileqq/app/SVIPHandler:h	()I
    //   456: istore 10
    //   458: iload 10
    //   460: iconst_2
    //   461: if_icmpne +239 -> 700
    //   464: iconst_0
    //   465: istore 9
    //   467: ldc_w 813
    //   470: ldc_w 813
    //   473: aload_1
    //   474: getfield 816	com/tencent/mobileqq/data/ExtensionInfo:colorRingId	J
    //   477: invokestatic 510	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   480: iload 9
    //   482: iconst_0
    //   483: invokestatic 550	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:reportVasStatus	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   486: aload_0
    //   487: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   490: bipush 13
    //   492: invokevirtual 563	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   495: checkcast 565	com/tencent/mobileqq/app/SVIPHandler
    //   498: invokevirtual 567	com/tencent/mobileqq/app/SVIPHandler:h	()I
    //   501: istore 9
    //   503: aload_1
    //   504: ifnull +22 -> 526
    //   507: ldc_w 818
    //   510: ldc_w 818
    //   513: aload_1
    //   514: getfield 821	com/tencent/mobileqq/data/ExtensionInfo:commingRingId	J
    //   517: invokestatic 510	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   520: iload 9
    //   522: iconst_0
    //   523: invokestatic 550	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:reportVasStatus	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   526: aload_0
    //   527: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   530: aload_0
    //   531: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   534: invokevirtual 600	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   537: bipush 6
    //   539: iconst_1
    //   540: aconst_null
    //   541: invokestatic 826	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;Ljava/lang/String;IZLjava/lang/String;)I
    //   544: istore 10
    //   546: iload 9
    //   548: iconst_2
    //   549: if_icmpne +167 -> 716
    //   552: iconst_0
    //   553: istore 9
    //   555: aload_0
    //   556: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   559: ldc -125
    //   561: ldc 103
    //   563: aload_0
    //   564: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   567: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   570: ldc_w 828
    //   573: ldc_w 830
    //   576: iconst_0
    //   577: iconst_0
    //   578: iload 10
    //   580: invokestatic 370	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   583: iload 9
    //   585: invokestatic 370	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   588: aconst_null
    //   589: invokestatic 835	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   592: invokestatic 370	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   595: ldc_w 659
    //   598: invokestatic 141	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   601: aload_0
    //   602: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   605: invokestatic 838	com/tencent/mobileqq/app/SecMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   608: aload_0
    //   609: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   612: invokestatic 841	com/tencent/mobileqq/statistics/StatisticAssist:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   615: astore_1
    //   616: aload_1
    //   617: ifnull +151 -> 768
    //   620: aload_1
    //   621: invokeinterface 845 1 0
    //   626: astore_1
    //   627: aload_1
    //   628: invokeinterface 850 1 0
    //   633: ifeq +135 -> 768
    //   636: aload_1
    //   637: invokeinterface 854 1 0
    //   642: checkcast 856	com/tencent/mobileqq/data/MessageReportData
    //   645: astore 8
    //   647: aload 8
    //   649: getfield 859	com/tencent/mobileqq/data/MessageReportData:msgCount	I
    //   652: ifle -25 -> 627
    //   655: aload 5
    //   657: aload_0
    //   658: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   661: aload 8
    //   663: invokevirtual 862	com/tencent/mobileqq/data/MessageReportData:getMsgReport	()Ljava/lang/String;
    //   666: invokevirtual 865	com/tencent/mobileqq/statistics/StatisticCollector:b	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   669: goto -42 -> 627
    //   672: astore_1
    //   673: invokestatic 868	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   676: ifeq -396 -> 280
    //   679: ldc_w 870
    //   682: iconst_2
    //   683: ldc_w 872
    //   686: aload_1
    //   687: invokestatic 874	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   690: goto -410 -> 280
    //   693: ldc_w 876
    //   696: astore_1
    //   697: goto -349 -> 348
    //   700: iload 10
    //   702: istore 9
    //   704: iload 10
    //   706: iconst_3
    //   707: if_icmpne -240 -> 467
    //   710: iconst_2
    //   711: istore 9
    //   713: goto -246 -> 467
    //   716: iload 9
    //   718: iconst_3
    //   719: if_icmpne +998 -> 1717
    //   722: iconst_2
    //   723: istore 9
    //   725: goto -170 -> 555
    //   728: astore_1
    //   729: invokestatic 868	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   732: ifeq -124 -> 608
    //   735: ldc_w 878
    //   738: iconst_2
    //   739: new 427	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   746: ldc_w 880
    //   749: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_1
    //   753: invokevirtual 883	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   756: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 886	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: goto -157 -> 608
    //   768: aload 7
    //   770: aload 6
    //   772: invokestatic 887	com/tencent/mobileqq/util/QQSettingUtil:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   775: istore 9
    //   777: iload 9
    //   779: ifle +28 -> 807
    //   782: invokestatic 371	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   785: invokestatic 199	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   788: aload_0
    //   789: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   792: aload_0
    //   793: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   796: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   799: ldc_w 889
    //   802: iload 9
    //   804: invokevirtual 892	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;I)V
    //   807: aload 7
    //   809: aload 6
    //   811: ldc_w 894
    //   814: invokestatic 896	com/tencent/mobileqq/activity/NotifyPushSettingActivity:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    //   817: istore 9
    //   819: new 154	java/util/HashMap
    //   822: dup
    //   823: invokespecial 155	java/util/HashMap:<init>	()V
    //   826: astore_1
    //   827: aload_1
    //   828: invokevirtual 273	java/util/HashMap:clear	()V
    //   831: aload_1
    //   832: ldc_w 894
    //   835: iload 9
    //   837: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   840: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   843: pop
    //   844: aload 5
    //   846: aload_0
    //   847: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   850: aload 6
    //   852: aload_1
    //   853: invokevirtual 280	com/tencent/mobileqq/statistics/StatisticCollector:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/util/Map;)V
    //   856: aload_0
    //   857: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   860: invokevirtual 900	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   863: invokestatic 905	com/tencent/util/BadgeUtils:a	(Landroid/content/Context;)Z
    //   866: ifeq +60 -> 926
    //   869: aload_0
    //   870: getfield 189	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   873: aconst_null
    //   874: aconst_null
    //   875: ldc_w 907
    //   878: iconst_1
    //   879: invokestatic 913	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   882: istore 17
    //   884: aload_0
    //   885: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   888: astore 7
    //   890: iload 17
    //   892: ifeq +768 -> 1660
    //   895: ldc_w 659
    //   898: astore_1
    //   899: aload 7
    //   901: ldc_w 630
    //   904: ldc 103
    //   906: ldc 103
    //   908: ldc_w 915
    //   911: ldc_w 915
    //   914: iconst_0
    //   915: iconst_0
    //   916: aload_1
    //   917: ldc 103
    //   919: ldc 103
    //   921: ldc 103
    //   923: invokestatic 141	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   926: invokestatic 918	com/tencent/mobileqq/pic/PicReporter:a	()V
    //   929: aload_0
    //   930: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   933: invokestatic 922	com/tencent/mobileqq/theme/ThemeUtil:getThemeSwitchTimes	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   936: istore 9
    //   938: iload 9
    //   940: ifle +26 -> 966
    //   943: aload 5
    //   945: aload_0
    //   946: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   949: aload 6
    //   951: ldc 103
    //   953: ldc_w 924
    //   956: ldc_w 926
    //   959: iconst_0
    //   960: iload 9
    //   962: iconst_0
    //   963: invokevirtual 206	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V
    //   966: aload_0
    //   967: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   970: bipush 62
    //   972: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   975: checkcast 540	com/tencent/mobileqq/model/ChatBackgroundManager
    //   978: aload_0
    //   979: getfield 189	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   982: aload_0
    //   983: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   986: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   989: invokevirtual 927	com/tencent/mobileqq/model/ChatBackgroundManager:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   992: istore 9
    //   994: iload 9
    //   996: ifle +26 -> 1022
    //   999: aload 5
    //   1001: aload_0
    //   1002: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1005: aload 6
    //   1007: ldc 103
    //   1009: ldc_w 929
    //   1012: ldc_w 931
    //   1015: iconst_0
    //   1016: iload 9
    //   1018: iconst_0
    //   1019: invokevirtual 206	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V
    //   1022: aload_0
    //   1023: getfield 189	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1026: aload_0
    //   1027: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1030: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1033: aload_0
    //   1034: getfield 189	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1037: ldc_w 932
    //   1040: invokevirtual 934	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   1043: ldc_w 936
    //   1046: iconst_1
    //   1047: invokestatic 913	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   1050: istore 17
    //   1052: aload_0
    //   1053: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1056: astore 6
    //   1058: iload 17
    //   1060: invokestatic 941	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1063: invokevirtual 944	java/lang/Boolean:booleanValue	()Z
    //   1066: ifeq +601 -> 1667
    //   1069: ldc_w 659
    //   1072: astore_1
    //   1073: aload 6
    //   1075: ldc_w 630
    //   1078: ldc 103
    //   1080: ldc 103
    //   1082: ldc_w 946
    //   1085: ldc_w 946
    //   1088: iconst_0
    //   1089: iconst_0
    //   1090: aload_1
    //   1091: ldc 103
    //   1093: ldc 103
    //   1095: ldc 103
    //   1097: invokestatic 141	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1100: aload_0
    //   1101: aload 5
    //   1103: invokespecial 948	com/tencent/mobileqq/statistics/DailyReport:b	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)V
    //   1106: aload_0
    //   1107: aload 5
    //   1109: invokespecial 950	com/tencent/mobileqq/statistics/DailyReport:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)V
    //   1112: getstatic 955	android/os/Build$VERSION:SDK_INT	I
    //   1115: bipush 19
    //   1117: if_icmplt +364 -> 1481
    //   1120: new 154	java/util/HashMap
    //   1123: dup
    //   1124: invokespecial 155	java/util/HashMap:<init>	()V
    //   1127: astore 5
    //   1129: invokestatic 959	com/tencent/mobileqq/widget/QQToast:a	()I
    //   1132: istore 9
    //   1134: aload 5
    //   1136: ldc_w 961
    //   1139: iload 9
    //   1141: invokestatic 370	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1144: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1147: pop
    //   1148: aload 5
    //   1150: ldc_w 963
    //   1153: aload_0
    //   1154: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1157: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1160: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1163: pop
    //   1164: invokestatic 965	com/tencent/mobileqq/utils/DeviceInfoUtil:j	()Ljava/lang/String;
    //   1167: astore_1
    //   1168: aload_1
    //   1169: ifnonnull +545 -> 1714
    //   1172: ldc 103
    //   1174: astore_1
    //   1175: aload 5
    //   1177: ldc_w 967
    //   1180: aload_1
    //   1181: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1184: pop
    //   1185: aload_0
    //   1186: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1189: invokevirtual 109	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1192: invokestatic 337	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   1195: astore 6
    //   1197: aload 6
    //   1199: new 427	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   1206: aload_0
    //   1207: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1210: invokevirtual 609	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   1213: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: ldc_w 969
    //   1219: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: ldc_w 971
    //   1225: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1231: invokeinterface 974 2 0
    //   1236: istore 17
    //   1238: aload 6
    //   1240: new 427	java/lang/StringBuilder
    //   1243: dup
    //   1244: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   1247: aload_0
    //   1248: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1251: invokevirtual 609	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   1254: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: ldc_w 969
    //   1260: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: ldc_w 976
    //   1266: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1272: iconst_0
    //   1273: invokeinterface 980 3 0
    //   1278: istore 10
    //   1280: aload 6
    //   1282: new 427	java/lang/StringBuilder
    //   1285: dup
    //   1286: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   1289: aload_0
    //   1290: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1293: invokevirtual 609	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   1296: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: ldc_w 969
    //   1302: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: ldc_w 982
    //   1308: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1314: iconst_0
    //   1315: invokeinterface 980 3 0
    //   1320: istore 11
    //   1322: aload 6
    //   1324: new 427	java/lang/StringBuilder
    //   1327: dup
    //   1328: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   1331: aload_0
    //   1332: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1335: invokevirtual 609	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   1338: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: ldc_w 969
    //   1344: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: ldc_w 984
    //   1350: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1356: iconst_0
    //   1357: invokeinterface 980 3 0
    //   1362: istore 12
    //   1364: aload 5
    //   1366: ldc_w 986
    //   1369: iload 17
    //   1371: invokestatic 989	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1374: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1377: pop
    //   1378: aload 5
    //   1380: ldc_w 991
    //   1383: iload 10
    //   1385: invokestatic 370	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1388: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1391: pop
    //   1392: aload 5
    //   1394: ldc_w 993
    //   1397: iload 11
    //   1399: invokestatic 370	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1402: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1405: pop
    //   1406: aload 5
    //   1408: ldc_w 995
    //   1411: iload 12
    //   1413: invokestatic 370	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1416: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1419: pop
    //   1420: invokestatic 371	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1423: invokestatic 199	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1426: aload_0
    //   1427: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1430: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1433: ldc_w 997
    //   1436: iconst_1
    //   1437: lconst_0
    //   1438: lconst_0
    //   1439: aload 5
    //   1441: ldc 103
    //   1443: invokevirtual 185	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1446: invokestatic 868	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1449: ifeq +32 -> 1481
    //   1452: ldc_w 878
    //   1455: iconst_2
    //   1456: ldc_w 999
    //   1459: iconst_2
    //   1460: anewarray 1001	java/lang/Object
    //   1463: dup
    //   1464: iconst_0
    //   1465: iload 9
    //   1467: invokestatic 277	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1470: aastore
    //   1471: dup
    //   1472: iconst_1
    //   1473: aload_1
    //   1474: aastore
    //   1475: invokestatic 1005	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1478: invokestatic 886	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1481: invokestatic 1010	com/tencent/mobileqq/activity/leba/LebaShowListManager:a	()Lcom/tencent/mobileqq/activity/leba/LebaShowListManager;
    //   1484: aload_0
    //   1485: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1488: invokevirtual 1011	com/tencent/mobileqq/activity/leba/LebaShowListManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   1491: aload_0
    //   1492: invokevirtual 1013	com/tencent/mobileqq/statistics/DailyReport:c	()V
    //   1495: invokestatic 868	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1498: ifeq +13 -> 1511
    //   1501: ldc_w 878
    //   1504: iconst_2
    //   1505: ldc_w 1015
    //   1508: invokestatic 886	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1511: aload_2
    //   1512: invokeinterface 343 1 0
    //   1517: new 427	java/lang/StringBuilder
    //   1520: dup
    //   1521: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   1524: ldc_w 709
    //   1527: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: aload_0
    //   1531: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1534: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1537: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1543: lload 15
    //   1545: invokeinterface 1018 4 0
    //   1550: invokeinterface 1021 1 0
    //   1555: pop
    //   1556: aload_3
    //   1557: aload 4
    //   1559: invokevirtual 745	java/util/Calendar:after	(Ljava/lang/Object;)Z
    //   1562: ifeq +43 -> 1605
    //   1565: aload_0
    //   1566: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1569: aload_0
    //   1570: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1573: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1576: invokestatic 1026	com/tencent/mobileqq/vaswebviewplugin/ThemeUiPlugin:reportThemeNumAndCurrThemeName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   1579: aload_0
    //   1580: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1583: bipush 62
    //   1585: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1588: checkcast 540	com/tencent/mobileqq/model/ChatBackgroundManager
    //   1591: aload_0
    //   1592: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1595: aload_0
    //   1596: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1599: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1602: invokevirtual 1027	com/tencent/mobileqq/model/ChatBackgroundManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   1605: lload 13
    //   1607: lconst_0
    //   1608: lcmp
    //   1609: ifne +48 -> 1657
    //   1612: aload_2
    //   1613: invokeinterface 343 1 0
    //   1618: new 427	java/lang/StringBuilder
    //   1621: dup
    //   1622: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   1625: ldc_w 709
    //   1628: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: aload_0
    //   1632: getfield 178	com/tencent/mobileqq/statistics/DailyReport:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1635: invokevirtual 133	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1638: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1641: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1644: lload 15
    //   1646: invokeinterface 1018 4 0
    //   1651: invokeinterface 1021 1 0
    //   1656: pop
    //   1657: bipush 7
    //   1659: ireturn
    //   1660: ldc_w 538
    //   1663: astore_1
    //   1664: goto -765 -> 899
    //   1667: ldc_w 538
    //   1670: astore_1
    //   1671: goto -598 -> 1073
    //   1674: astore_1
    //   1675: invokestatic 868	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1678: ifeq -197 -> 1481
    //   1681: ldc_w 878
    //   1684: iconst_2
    //   1685: new 427	java/lang/StringBuilder
    //   1688: dup
    //   1689: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   1692: ldc_w 1029
    //   1695: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: aload_1
    //   1699: invokevirtual 883	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1702: invokevirtual 433	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: invokestatic 886	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1711: goto -230 -> 1481
    //   1714: goto -539 -> 1175
    //   1717: goto -1162 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1720	0	this	DailyReport
    //   128	509	1	localObject1	Object
    //   672	15	1	localException	Exception
    //   696	1	1	str	String
    //   728	25	1	localThrowable1	Throwable
    //   826	845	1	localObject2	Object
    //   1674	25	1	localThrowable2	Throwable
    //   29	1584	2	localSharedPreferences	SharedPreferences
    //   77	1480	3	localCalendar1	java.util.Calendar
    //   81	1477	4	localCalendar2	java.util.Calendar
    //   274	1166	5	localObject3	Object
    //   255	1068	6	localObject4	Object
    //   267	633	7	localObject5	Object
    //   398	264	8	localObject6	Object
    //   465	1001	9	i	int
    //   456	928	10	k	int
    //   1320	78	11	m	int
    //   1362	50	12	n	int
    //   63	1543	13	l1	long
    //   72	1573	15	l2	long
    //   882	488	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   276	280	672	java/lang/Exception
    //   601	608	728	java/lang/Throwable
    //   1112	1168	1674	java/lang/Throwable
    //   1175	1481	1674	java/lang/Throwable
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    StatisticTroopAssist.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    QQSettingUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    ThemeUtil.resetThemeSwitchTimes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(62)).b(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\DailyReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */