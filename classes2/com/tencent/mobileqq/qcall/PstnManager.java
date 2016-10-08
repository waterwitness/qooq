package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PstnManager
  implements Manager
{
  public static final String A = "pstn_multi_trans_setting_wording";
  public static final String B = "key_pstn_vip_red_dot";
  private static final String C = "PstnManager";
  private static final String D = "user_pstn_gray_flag";
  private static final String E = "user_pstn_req_gray_inter";
  private static final String F = "user_pstn_gray_cookies";
  private static final String G = "user_pstn_c2c_trial_authority";
  private static final String H = "user_pstn_multi_trial_authority";
  private static final String I = "key_pstn_c2c_switch_setting";
  private static final String J = "key_pstn_multi_switch_setting";
  private static final String K = "key_gray_switch_need_popup_confirm";
  private static final String L = "key_c2c_warning_time";
  private static final String M = "key_multi_warning_time";
  public static final String a = "key_gray_switch_no_need_add_address";
  public static final String b = "key_pstn_multi_no_try_chance_tips";
  public static final String c = "key_pstn_multi_has_try_chance_tips";
  public static final String d = "key_pstn_tried_c2c_recharge_title";
  public static final String e = "key_pstn_tried_c2c_recharge_content";
  public static final String f = "key_pstn_tried_c2c_recharge_confirm_text";
  public static final String g = "key_pstn_tried_multi_recharge_title";
  public static final String h = "key_pstn_tried_multi_recharge_content";
  public static final String i = "key_pstn_tried_multi_recharge_confirm_text";
  public static final String j = "key_pstn_untried_c2c_recharge_title";
  public static final String k = "key_pstn_untried_c2c_recharge_content";
  public static final String l = "key_pstn_untried_c2c_recharge_confirm_text";
  public static final String m = "key_pstn_untried_multi_recharge_title";
  public static final String n = "key_pstn_untried_multi_recharge_content";
  public static final String o = "key_pstn_untried_multi_recharge_confirm_text";
  public static final String p = "key_pstn_c2c_try_over_recharge_title";
  public static final String q = "key_pstn_c2c_try_over_recharge_content";
  public static final String r = "key_pstn_c2c_try_over_recharge_confirm_text";
  public static final String s = "key_pstn_multi_try_over_recharge_title";
  public static final String t = "key_pstn_multi_try_over_recharge_content";
  public static final String u = "key_pstn_multi_try_over_recharge_confirm_text";
  public static final String v = "pstn_c2c_trans_wording";
  public static final String w = "pstn_c2c_trans_check_wording";
  public static final String x = "pstn_c2c_trans_setting_wording";
  public static final String y = "pstn_multi_trans_wording";
  public static final String z = "pstn_multi_trans_check_wording";
  public int a;
  public long a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
  private PstnSwitchConfig jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int jdField_c_of_type_Int;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int jdField_d_of_type_Int;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public PstnManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = 30;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.e = -1;
    this.f = -1;
    this.g = 3;
    this.h = 3;
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    this.g = paramQQAppInterface.getInt("key_c2c_warning_time", 3);
    this.h = paramQQAppInterface.getInt("key_multi_warning_time", 3);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PstnManager", 2, "=== app is null ===");
      }
    }
    Resources localResources;
    do
    {
      return;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
    } while ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (localResources == null));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_no_try_chance_tips", localResources.getString(2131372489));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_has_try_chance_tips", localResources.getString(2131372490));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_c2c_recharge_title", localResources.getString(2131372491));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_c2c_recharge_content", localResources.getString(2131372492));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_c2c_recharge_confirm_text", localResources.getString(2131372493));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_multi_recharge_title", localResources.getString(2131372494));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_multi_recharge_content", localResources.getString(2131372495));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_tried_multi_recharge_confirm_text", localResources.getString(2131372496));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_c2c_recharge_title", localResources.getString(2131372497));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_c2c_recharge_content", localResources.getString(2131372498));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_c2c_recharge_confirm_text", localResources.getString(2131372499));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_multi_recharge_title", localResources.getString(2131372500));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_multi_recharge_content", localResources.getString(2131372501));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_untried_multi_recharge_confirm_text", localResources.getString(2131372502));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_c2c_try_over_recharge_title", localResources.getString(2131372503));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_c2c_try_over_recharge_content", localResources.getString(2131372504));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_c2c_try_over_recharge_confirm_text", localResources.getString(2131372505));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_try_over_recharge_title", localResources.getString(2131372506));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_try_over_recharge_content", localResources.getString(2131372507));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_pstn_multi_try_over_recharge_confirm_text", localResources.getString(2131372508));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_c2c_trans_wording", localResources.getString(2131372509));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_c2c_trans_check_wording", localResources.getString(2131372510));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_c2c_trans_setting_wording", localResources.getString(2131372511));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_multi_trans_wording", localResources.getString(2131372512));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_multi_trans_check_wording", localResources.getString(2131372513));
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put("pstn_multi_trans_setting_wording", localResources.getString(2131372514));
  }
  
  public int a()
  {
    int i2 = this.jdField_b_of_type_Int;
    int i1 = i2;
    if (i2 == -1) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("user_pstn_gray_flag", 0);
    }
    return i1;
  }
  
  public MessageRecord a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (MessageRecord)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public ByteStringMicro a()
  {
    ByteStringMicro localByteStringMicro2 = this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
    ByteStringMicro localByteStringMicro1;
    String str;
    if (localByteStringMicro2 != null)
    {
      localByteStringMicro1 = localByteStringMicro2;
      if (localByteStringMicro2.toString().length() != 0) {}
    }
    else
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getString("user_pstn_gray_cookies", "00");
      QLog.d("PstnManager", 1, " === get cookies : " + str + " ====");
      if ((str == null) || (!str.equals("00"))) {
        break label100;
      }
      localByteStringMicro1 = null;
    }
    label100:
    do
    {
      return localByteStringMicro1;
      localByteStringMicro1 = localByteStringMicro2;
    } while (TextUtils.isEmpty(str));
    return ByteStringMicro.copyFrom(HexUtil.a(str));
  }
  
  public PstnCardInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("PstnManager", 1, " getPstnCardInfo uin is null ");
      paramString = null;
    }
    PstnCardInfo localPstnCardInfo;
    do
    {
      do
      {
        return paramString;
        localPstnCardInfo = (PstnCardInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        paramString = localPstnCardInfo;
      } while (localPstnCardInfo == null);
      paramString = localPstnCardInfo;
    } while (!QLog.isColorLevel());
    QLog.d("PstnManager", 2, "getPstnCardInfo, " + localPstnCardInfo.toString());
    return localPstnCardInfo;
  }
  
  public PstnSwitchConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig = new PstnSwitchConfig();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_c_of_type_Int = localSharedPreferences.getInt("key_pstn_c2c_aio_flag", 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.e = localSharedPreferences.getInt("key_pstn_c2c_ip_call_flag", 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_d_of_type_Int = localSharedPreferences.getInt("key_pstn_c2c_profile_card_flag", 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.f = localSharedPreferences.getInt("key_pstn_multi_aio_flag", 0);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.g = localSharedPreferences.getInt("key_pstn_auto_trans_time", 100000);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.h = localSharedPreferences.getInt("key_pstn_miss_delay_time", 20);
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.i = localSharedPreferences.getInt("key_pstn_miss_show_time", 60);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PstnManager", 2, "getPstnSwitchConfig, " + this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig;
  }
  
  public String a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.toString();
    }
    return "pstnTipsCache is null";
  }
  
  public String a(String paramString)
  {
    Object localObject = "";
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("PstnManager", 1, " getPstnTips key is null");
    }
    String str;
    do
    {
      do
      {
        do
        {
          return (String)localObject;
          if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
          }
          if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            a();
          }
          str = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = str;
        } while (!TextUtils.isEmpty(str));
        localObject = str;
      } while (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getString(paramString, (String)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
      localObject = str;
    } while (TextUtils.isEmpty(str));
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, str);
    return str;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putInt("key_gray_switch_need_popup_confirm", paramInt);
    localEditor.commit();
  }
  
  public void a(int paramInt1, int paramInt2, ByteStringMicro paramByteStringMicro, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramByteStringMicro;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putInt("user_pstn_gray_flag", paramInt1);
    localEditor.putInt("user_pstn_req_gray_inter", paramInt2);
    if (paramByteStringMicro != null)
    {
      paramByteStringMicro = HexUtil.a(paramByteStringMicro.toByteArray());
      if (!TextUtils.isEmpty(paramByteStringMicro)) {
        localEditor.putString("user_pstn_gray_cookies", paramByteStringMicro);
      }
    }
    localEditor.putInt("user_pstn_c2c_trial_authority", paramInt3);
    localEditor.putInt("user_pstn_multi_trial_authority", paramInt4);
    localEditor.commit();
  }
  
  public void a(PstnCardInfo paramPstnCardInfo)
  {
    if ((paramPstnCardInfo == null) || (TextUtils.isEmpty(paramPstnCardInfo.uin)))
    {
      QLog.d("PstnManager", 1, " savePstnCardInfo pstnCardInfo is null or uin is null ");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramPstnCardInfo.uin)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramPstnCardInfo.uin);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramPstnCardInfo.uin, paramPstnCardInfo);
  }
  
  public void a(PstnSwitchConfig paramPstnSwitchConfig)
  {
    if (paramPstnSwitchConfig == null)
    {
      QLog.i("PstnManager", 1, " setpstnswitchconfig  config is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig = paramPstnSwitchConfig;
    paramPstnSwitchConfig = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    paramPstnSwitchConfig.putInt("key_pstn_c2c_aio_flag", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_c_of_type_Int);
    paramPstnSwitchConfig.putInt("key_pstn_c2c_ip_call_flag", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.e);
    paramPstnSwitchConfig.putInt("key_pstn_c2c_profile_card_flag", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.jdField_d_of_type_Int);
    paramPstnSwitchConfig.putInt("key_pstn_multi_aio_flag", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.f);
    paramPstnSwitchConfig.putInt("key_pstn_auto_trans_time", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.g);
    paramPstnSwitchConfig.putInt("key_pstn_miss_delay_time", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.h);
    paramPstnSwitchConfig.putInt("key_pstn_miss_show_time", this.jdField_a_of_type_ComTencentMobileqqQcallPstnSwitchConfig.i);
    paramPstnSwitchConfig.commit();
  }
  
  public void a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMessageRecord == null)) {
      return;
    }
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramMessageRecord);
  }
  
  public void a(HashMap paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(paramHashMap);
      }
      SharedPreferences.Editor localEditor;
      for (;;)
      {
        localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
        Object localObject = paramHashMap.keySet();
        if ((localObject == null) || (((Set)localObject).size() <= 0)) {
          break;
        }
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = (String)paramHashMap.get(str1);
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            localEditor.putString(str1, str2);
          }
        }
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramHashMap);
      }
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.i("PstnManager", 2, " setPstnTips, " + paramHashMap.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putBoolean("key_pstn_c2c_switch_setting", paramBoolean);
    localEditor.commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("key_pstn_c2c_switch_setting", false);
  }
  
  public int b()
  {
    int i2 = this.jdField_c_of_type_Int;
    int i1 = i2;
    if (i2 == -1) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("user_pstn_c2c_trial_authority", 0);
    }
    return i1;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putInt("key_gray_switch_no_need_add_address", paramInt);
    localEditor.commit();
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putBoolean("key_pstn_multi_switch_setting", paramBoolean);
    localEditor.commit();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("key_pstn_multi_switch_setting", false);
  }
  
  public int c()
  {
    int i2 = this.jdField_d_of_type_Int;
    int i1 = i2;
    if (i2 == -1) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("user_pstn_multi_trial_authority", 0);
    }
    return i1;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putInt("key_c2c_warning_time", this.g);
    localEditor.commit();
  }
  
  public void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putBoolean("key_pstn_vip_red_dot", paramBoolean);
    localEditor.commit();
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("key_pstn_vip_red_dot", true)) && (a() == 1);
  }
  
  public int d()
  {
    int i2 = this.jdField_a_of_type_Int;
    int i1 = i2;
    if (i2 == -1) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("user_pstn_req_gray_inter", 300);
    }
    return i1;
  }
  
  public void d(int paramInt)
  {
    this.h = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putInt("key_multi_warning_time", this.h);
  }
  
  public void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
    localEditor.putBoolean("key_pstn_vip_call_tab", paramBoolean);
    localEditor.commit();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("key_pstn_vip_call_tab", true)) && (a() == 1);
  }
  
  public int e()
  {
    if (this.e == -1) {
      this.e = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("key_gray_switch_need_popup_confirm", 0);
    }
    return this.e;
  }
  
  public int f()
  {
    if (this.f == -1) {
      this.f = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("key_gray_switch_no_need_add_address", 0);
    }
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\PstnManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */