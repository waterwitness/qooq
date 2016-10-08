package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicAccountMenuEntity;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ActionInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendOrderPayEventRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SendPublicAccountMessageReceiptRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.SetRefuseFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import hqg;
import hqi;
import hqj;
import hqk;
import hql;
import hqm;
import hqn;
import hqo;
import hqp;
import hqr;
import hqs;
import hqu;
import hqv;
import hqw;
import hqx;
import hqy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountManager
{
  public static final String A = "history_msg_params";
  public static final String B = "post_punchcard_info";
  public static final String E = "com.tencent.msg.permission.pushnotify";
  public static final String F = "com.tencent.biz.pubaccount.scanResultAction";
  public static final String G = "com.tencent.biz.pubaccount.scanResultData";
  public static final String H = "com.tencent.biz.pubaccount.scanResultType";
  public static final String I = "com.tencent.biz.pubaccount.picResultAction";
  public static final String J = "com.tencent.biz.pubaccount.picResultData";
  public static final String K = "com.tencent.biz.pubaccount.picResult_md5s";
  public static final String L = "com.tencent.biz.pubaccount.locationResultAction";
  public static final String M = "latitude";
  public static final String N = "longitude";
  public static final String O = "name";
  public static final int a = 0;
  public static final long a = 350749526L;
  private static final PublicAccountManager a;
  public static final String a = "PublicAccountManager";
  public static final boolean a = false;
  public static final int b = 1;
  static final long jdField_b_of_type_Long = 21600000L;
  public static final String b = "menuEventSharePre";
  public static final int c = 2;
  public static final String c = "update_type";
  public static final int d = 0;
  public static final String d = "menuCacheTime";
  public static final int e = 1;
  public static final String e = "PubAccountSvc";
  public static final int f = 2;
  public static final String f = "get_follow_list";
  public static final int g = 0;
  public static final String g = "get_detail_info";
  public static final int h = 1;
  public static final String h = "follow";
  public static final int i = 2;
  public static final String i = "unfollow";
  public static final String j = "get_account_menu";
  public static final String k = "get_share_list";
  public static final String l = "set_recv_msg";
  public static final String m = "set_share_lbs";
  public static final String n = "share_to_public";
  public static final String o = "set_function_flag";
  public static final String p = "send_menu_evt";
  public static final String q = "set_refuse_follow";
  public static final String r = "send_msg_receipt";
  public static final String s = "send_pay_info";
  public static final String t = "set_message_configuration";
  public static final String u = "get_business_recommend";
  public static final String v = "secmsg.configs";
  public static final String w = "send_pre_message_status";
  public static final String x = "pull_aio_history_msg";
  public static final String y = "pull_account_detail_dynamic_list";
  public static final String z = "lola_update_req";
  String C = null;
  public String D = null;
  private String P;
  public BroadcastReceiver a;
  protected Runnable a;
  public WeakReference a;
  public Map a;
  public BroadcastReceiver b;
  public WeakReference b;
  Map jdField_b_of_type_JavaUtilMap = new HashMap();
  public boolean b;
  public BroadcastReceiver c;
  private WeakReference c;
  public Map c;
  public Map d = new HashMap();
  public int j = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager = new PublicAccountManager();
  }
  
  private PublicAccountManager()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_c_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangRunnable = new hqs(this);
  }
  
  public static int a(String paramString, AppInterface paramAppInterface)
  {
    paramString = ((PublicAccountDataManager)paramAppInterface.getManager(55)).b(paramString + "");
    if ((paramString != null) && (paramString.extendType == 2)) {
      return 1;
    }
    return 2;
  }
  
  public static PublicAccountManager a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager;
  }
  
  private mobileqq_mp.SendMenuEventRequest a(int paramInt, String paramString, boolean paramBoolean)
  {
    String str = this.C;
    try
    {
      long l1 = Long.valueOf(str).longValue();
      mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = new mobileqq_mp.SendMenuEventRequest();
      localSendMenuEventRequest.uin.set((int)l1);
      localSendMenuEventRequest.type.set(paramInt);
      localSendMenuEventRequest.key.set(paramString);
      localSendMenuEventRequest.msg_id.set(0L);
      localSendMenuEventRequest.s_type.set(1);
      localSendMenuEventRequest.versionInfo.set("6.5.5,3,2880");
      localSendMenuEventRequest.menu_type.set(b(str));
      if (paramBoolean) {
        localSendMenuEventRequest.is_new_menu.set(paramBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-init:", 2, "type:" + localSendMenuEventRequest.type.get() + " uin:" + localSendMenuEventRequest.uin.get() + " key:" + localSendMenuEventRequest.key.get() + " msg_id:" + localSendMenuEventRequest.msg_id.get() + " s_type:" + localSendMenuEventRequest.s_type.get() + " versionInfo:" + localSendMenuEventRequest.versionInfo.get() + " is_new_menu:" + localSendMenuEventRequest.is_new_menu.get());
      }
      return localSendMenuEventRequest;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountManager", 2, "puin is invalid format:" + str);
      }
    }
    return null;
  }
  
  public static String a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("luin", paramLong1);
      localJSONObject.put("msg_id", paramLong2);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      localJSONObject.put("order_id", str);
      localJSONObject.put("ret_code", paramInt1);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localJSONObject.put("ret_str", paramString1);
      localJSONObject.put("msg_type", paramInt2);
      localJSONObject.put("pay_time", paramInt3);
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      localJSONObject.put("reserve_1", paramString1);
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      localJSONObject.put("reserve_2", paramString1);
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
    return localJSONObject.toString();
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://imgcache.qq.com/zzapp/widget/city_selector/city.html?_wv=5127&redirect_url=http%3A%2F%2Fweather.mp.qq.com%2F&from=aio");
    localIntent.putExtra("fromAio", true);
    paramContext.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "weather_othercity_click", 0, 0, "", "", "", "");
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (AudioHelper.b(0))
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131367661), paramContext.getString(2131367662), new hqx(this), null).show();
      return;
    }
    if (AudioHelper.a(0))
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131367661), paramContext.getString(2131367663), new hqy(this), null).show();
      return;
    }
    paramQQAppInterface.a().c();
    PlusPanelUtils.a(paramQQAppInterface, (BaseActivity)paramContext, 1, paramSessionInfo);
    ((BaseActivity)paramContext).setCanLock(false);
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      paramContext.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new hqi(this);
      paramQQAppInterface = new IntentFilter("com.tencent.biz.pubaccount.picResultAction");
      paramContext.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramQQAppInterface, "com.tencent.msg.permission.pushnotify", null);
      this.j = 1;
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;) {}
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramString == null)) {
      return;
    }
    paramContext = new NewIntent(paramContext, PublicAccountServlet.class);
    paramContext.putExtra("cmd", "send_pay_info");
    mobileqq_mp.SendOrderPayEventRequest localSendOrderPayEventRequest = new mobileqq_mp.SendOrderPayEventRequest();
    localSendOrderPayEventRequest.versionInfo.set("6.5.5,3,2880");
    localSendOrderPayEventRequest.cmd.set(1);
    localSendOrderPayEventRequest.body.set(paramString);
    paramContext.putExtra("data", localSendOrderPayEventRequest.toByteArray());
    paramContext.setObserver(new hqo(paramContext));
    paramQQAppInterface.startServlet(paramContext);
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    Object localObject;
    if ((paramContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)paramContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof PublicAccountChatPie))
        {
          localObject = (PublicAccountChatPie)localObject;
          ((PublicAccountChatPie)localObject).eb += 1;
        }
      }
    }
    if (paramButtonInfo.url.has())
    {
      paramButtonInfo = paramButtonInfo.url.get();
      paramButtonInfo = new StringBuilder(paramButtonInfo);
      if (paramButtonInfo.indexOf("?") >= 0) {
        break label276;
      }
      paramButtonInfo.append("?");
    }
    for (;;)
    {
      paramButtonInfo.append("uin=" + paramQQAppInterface.a());
      paramButtonInfo.append("&puin=" + paramString);
      localObject = new Intent(paramContext, PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("from", QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramButtonInfo.toString());
      ((Intent)localObject).putExtra("uin", paramQQAppInterface.a());
      ((Intent)localObject).putExtra("puin", paramString);
      ((Intent)localObject).putExtra("assignBackText", paramContext.getResources().getString(2131367975));
      ((Intent)localObject).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
      if (paramString.equalsIgnoreCase("2632129500")) {
        ((Intent)localObject).putExtra("hide_operation_bar", true);
      }
      paramContext.startActivity((Intent)localObject);
      return;
      paramButtonInfo = "";
      break;
      label276:
      if (paramButtonInfo.indexOf("?") < paramButtonInfo.length() - 1) {
        if (paramButtonInfo.indexOf("&") < 0) {
          paramButtonInfo.append("&");
        } else if (paramButtonInfo.lastIndexOf("&") < paramButtonInfo.length() - 1) {
          paramButtonInfo.append("&");
        }
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
    localIntent.putExtra("from", QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("click_from", paramString3);
    localIntent.putExtra("uin", paramQQAppInterface.a());
    localIntent.putExtra("puin", paramString2);
    localIntent.putExtra("assignBackText", paramContext.getResources().getString(2131367975));
    paramContext.startActivity(localIntent);
  }
  
  private void a(Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ScannerActivity.class);
    localIntent.putExtra("from", PublicAccountManager.class.getName());
    localIntent.putExtra("finishAfterSucc", true);
    localIntent.putExtra("scanForResult", paramBoolean);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new hqw(this, paramBoolean, paramMqqHandler);
      paramMqqHandler = new IntentFilter("com.tencent.biz.pubaccount.scanResultAction");
      paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramMqqHandler, "com.tencent.msg.permission.pushnotify", null);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    PublicAccountUtil.a(localIntent, paramQQAppInterface, paramContext, paramString, -1);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if ((paramButtonInfo.item_id.has()) && (paramButtonInfo.item_id.get() == 5))
    {
      paramQQAppInterface = new Intent(paramContext, CouponActivity.class);
      paramQQAppInterface.putExtra("url", "http://web.p.qq.com/qqmpmobile/coupon/mycoupons.html?_bid=108");
      paramQQAppInterface.putExtra("source", "1");
      paramQQAppInterface.putExtra("from", 5);
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    if ((paramButtonInfo.item_id.has()) && (paramButtonInfo.item_id.get() == 6))
    {
      paramQQAppInterface = new Intent(paramContext, CouponActivity.class);
      if (paramButtonInfo.url.has()) {
        paramQQAppInterface.putExtra("url", paramButtonInfo.url.get());
      }
      paramQQAppInterface.putExtra("webStyle", "noBottomBar");
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    a(paramContext, paramQQAppInterface, paramString, paramButtonInfo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, mobileqq_mp.ButtonInfo paramButtonInfo, String paramString2)
  {
    boolean bool = true;
    long l1 = paramButtonInfo.actionInfo.appid.get();
    Object localObject = Uri.parse(paramString2);
    paramString2 = ((Uri)localObject).getScheme();
    localObject = ((Uri)localObject).getHost();
    if ((!TextUtils.isEmpty(paramString2)) && (AppUtil.a(paramString2)))
    {
      AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
      int i1;
      Bundle localBundle;
      int i2;
      if (AppLaucherHelper.a((String)localObject) == 0)
      {
        i1 = 0;
        localBundle = AppLaucherHelper.a((String)localObject);
        i2 = localBundle.getInt("a_launch_mode", 268435456);
        if (i1 == 0) {
          break label136;
        }
        localAppLaucherHelper.a(paramQQAppInterface, paramContext, String.valueOf(l1), (String)localObject, paramString2, i2);
      }
      for (;;)
      {
        if (!bool) {
          a(paramQQAppInterface, paramContext, paramString1, paramButtonInfo);
        }
        return;
        i1 = 1;
        break;
        label136:
        bool = AppUtil.a(paramContext, paramString2, localBundle, i2);
      }
    }
    a(paramQQAppInterface, paramContext, paramString1, paramButtonInfo);
  }
  
  private void a(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler)
  {
    if (paramMqqHandler != null) {
      paramMqqHandler.sendEmptyMessage(19);
    }
    ((PublicAccountHandler)paramQQAppInterface.a(11)).a(0, 0, 0, 0);
    ReportController.b(paramQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "weather_newcity_click", 0, 0, "", "", "", "");
  }
  
  private void a(mobileqq_mp.SendMenuEventRequest paramSendMenuEventRequest)
  {
    BusinessObserver localBusinessObserver = (BusinessObserver)this.jdField_c_of_type_JavaLangRefWeakReference.get();
    Context localContext = (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.C;
    NewIntent localNewIntent = new NewIntent(localContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "send_menu_evt");
    localNewIntent.putExtra("data", paramSendMenuEventRequest.toByteArray());
    localNewIntent.setObserver(new hqm(this, localNewIntent, localContext, str, localBusinessObserver, localQQAppInterface));
    if (localQQAppInterface != null) {
      localQQAppInterface.startServlet(localNewIntent);
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramString.toString());
    if (localPublicAccountInfo == null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if (paramQQAppInterface == null) {
        return false;
      }
      if ((paramQQAppInterface.accountFlag & 0x8EA00000) == 0) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if ((localPublicAccountInfo.accountFlag & 0x8EA00000) == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      long l3 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
      long l4 = System.currentTimeMillis();
      long l2 = paramContext.getSharedPreferences("menuEventSharePre", 0).getLong("menuCacheTime", -1L);
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 21600000L;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Menu", 2, "cacheTime(ms):" + l1);
      }
      return l4 - l3 >= l1;
    }
    return true;
  }
  
  private void b(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface.a().c();
    Uri localUri = CommonUtil.a();
    if (localUri != null)
    {
      ActionSheet localActionSheet = ActionSheet.a((BaseActivity)paramContext);
      String[] arrayOfString = paramContext.getResources().getStringArray(2131230728);
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localActionSheet.c(arrayOfString[i1]);
        i1 += 1;
      }
      localActionSheet.d(2131367262);
      localActionSheet.a(new hqj(this, paramQQAppInterface, paramContext, localUri, paramSessionInfo, localActionSheet));
      localActionSheet.show();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {}
      try
      {
        paramContext.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
        this.jdField_b_of_type_AndroidContentBroadcastReceiver = new hqk(this);
        paramQQAppInterface = new IntentFilter("com.tencent.biz.pubaccount.picResultAction");
        paramContext.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramQQAppInterface, "com.tencent.msg.permission.pushnotify", null);
        this.j = 2;
        return;
        PlusPanelUtils.a(paramQQAppInterface, (Activity)paramContext, paramSessionInfo, null, null);
        paramQQAppInterface = (TroopHandler)paramQQAppInterface.a(20);
        if ((!TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (paramSessionInfo.jdField_a_of_type_Int == 1)) {
          paramQQAppInterface.e(paramSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        ((BaseActivity)paramContext).setCanLock(false);
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;) {}
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (!a(paramQQAppInterface, paramString)) {
      return;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(paramString, 1008);
    if (localRecentUser.lastmsgtime < l1)
    {
      localRecentUser.lastmsgtime = l1;
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager", 2, "addPublicAccountToRu->pUin:" + paramString + ", currentTime:" + l1);
      }
    }
    localRecentUserProxy.a(localRecentUser);
    ThreadManager.b(new hqn(paramQQAppInterface, paramString));
  }
  
  private void c(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = this.D;
    boolean bool = this.jdField_b_of_type_Boolean;
    try
    {
      ((FragmentActivity)paramContext).getChatFragment().a().as();
      Intent localIntent = new Intent(paramContext, PoiMapActivity.class);
      localIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      ((FragmentActivity)paramContext).startActivityForResult(localIntent, 18);
      ((BaseActivity)paramContext).setCanLock(false);
      if (this.jdField_c_of_type_AndroidContentBroadcastReceiver == null) {}
    }
    catch (Exception paramSessionInfo)
    {
      try
      {
        paramContext.unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
        this.jdField_c_of_type_AndroidContentBroadcastReceiver = null;
        this.jdField_c_of_type_AndroidContentBroadcastReceiver = new hql(this, paramQQAppInterface, bool);
        paramQQAppInterface = new IntentFilter("com.tencent.biz.pubaccount.locationResultAction");
        paramContext.registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, paramQQAppInterface, "com.tencent.msg.permission.pushnotify", null);
        return;
        paramSessionInfo = paramSessionInfo;
        paramSessionInfo.printStackTrace();
      }
      catch (Exception paramSessionInfo)
      {
        for (;;) {}
      }
    }
  }
  
  public int a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
      return ((Integer)this.jdField_b_of_type_JavaUtilMap.get(paramString)).intValue();
    }
    return 0;
  }
  
  public long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return paramQQAppInterface.a().getSharedPreferences("history_msg_params_" + paramQQAppInterface.getAccount(), 0).getLong(paramString + "_msgid", 0L);
  }
  
  public mobileqq_mp.ButtonInfo a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    List localList = b(paramQQAppInterface, paramString);
    if ((localList == null) || (localList.isEmpty()))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= localList.size()) {
        break label190;
      }
      paramString = (mobileqq_mp.ButtonInfo)localList.get(i1);
      if (paramString.id.has())
      {
        paramQQAppInterface = paramString;
        if (paramString.id.get() == paramInt) {
          break;
        }
      }
      if (paramString.sub_button.has())
      {
        paramQQAppInterface = paramString.sub_button.get();
        if (paramQQAppInterface.size() > 0)
        {
          int i2 = 0;
          while (i2 < paramQQAppInterface.size())
          {
            if ((((mobileqq_mp.ButtonInfo)paramQQAppInterface.get(i2)).id.has()) && (((mobileqq_mp.ButtonInfo)paramQQAppInterface.get(i2)).id.get() == paramInt)) {
              return (mobileqq_mp.ButtonInfo)paramQQAppInterface.get(i2);
            }
            i2 += 1;
          }
        }
      }
      i1 += 1;
    }
    label190:
    return null;
  }
  
  public String a()
  {
    return this.P;
  }
  
  public List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return b(paramQQAppInterface, paramString);
  }
  
  public NewIntent a(Context paramContext, AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountManager", 2, String.format("sendMsgArriveReceipt request: msgId:%d msgOp:%d pcuin:%d cuin:%d type:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt) }));
    }
    paramContext = new NewIntent(paramContext, PublicAccountServlet.class);
    paramContext.putExtra("cmd", "send_msg_receipt");
    mobileqq_mp.SendPublicAccountMessageReceiptRequest localSendPublicAccountMessageReceiptRequest = new mobileqq_mp.SendPublicAccountMessageReceiptRequest();
    if (paramInt == 1)
    {
      localSendPublicAccountMessageReceiptRequest.uint64_unique_id.set(paramLong1);
      localSendPublicAccountMessageReceiptRequest.uint32_op.set(paramLong2);
    }
    for (;;)
    {
      localSendPublicAccountMessageReceiptRequest.receipt_type.set(paramInt);
      localSendPublicAccountMessageReceiptRequest.pcuin.set(paramLong3);
      localSendPublicAccountMessageReceiptRequest.cuin.set(paramLong4);
      paramContext.putExtra("data", localSendPublicAccountMessageReceiptRequest.toByteArray());
      paramContext.setObserver(new hqv(this, paramContext));
      if (paramAppInterface != null) {
        paramAppInterface.startServlet(paramContext);
      }
      return paramContext;
      if (paramInt == 2) {
        localSendPublicAccountMessageReceiptRequest.unique_ids.set(paramList);
      }
    }
  }
  
  public NewIntent a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    NewIntent localNewIntent = null;
    label106:
    do
    {
      long l1;
      try
      {
        l1 = Long.valueOf(paramString).longValue();
        if ((paramBoolean) || (a("" + l1, paramContext))) {
          break label106;
        }
        paramContext = localNewIntent;
        if (QLog.isColorLevel())
        {
          QLog.i("PublicAccountManager", 2, "menu setting not outdate yet--");
          paramContext = localNewIntent;
        }
      }
      catch (NumberFormatException paramContext)
      {
        do
        {
          paramContext = localNewIntent;
        } while (!QLog.isColorLevel());
        QLog.e("PublicAccountManager", 2, "puin is invalid format:" + paramString);
        return null;
      }
      return paramContext;
      int i1 = 0;
      if (this.jdField_b_of_type_JavaUtilMap.containsKey("" + l1)) {
        i1 = ((Integer)this.jdField_b_of_type_JavaUtilMap.get("" + l1)).intValue();
      }
      localNewIntent = new NewIntent(paramContext, PublicAccountServlet.class);
      localNewIntent.putExtra("cmd", "get_account_menu");
      mobileqq_mp.GetPublicAccountMenuRequest localGetPublicAccountMenuRequest = new mobileqq_mp.GetPublicAccountMenuRequest();
      localGetPublicAccountMenuRequest.seqno.set(i1);
      localGetPublicAccountMenuRequest.uin.set((int)l1);
      localNewIntent.putExtra("data", localGetPublicAccountMenuRequest.toByteArray());
      localNewIntent.setObserver(new hqp(this, localNewIntent, paramQQAppInterface, paramString, paramContext, paramBusinessObserver));
      paramContext = localNewIntent;
    } while (paramQQAppInterface == null);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  public NewIntent a(String paramString, int paramInt, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, PublicAccountManager.refuseAcceptDone paramrefuseAcceptDone)
  {
    paramContext = new NewIntent(paramContext, PublicAccountServlet.class);
    paramContext.putExtra("cmd", "set_refuse_follow");
    mobileqq_mp.SetRefuseFollowRequest localSetRefuseFollowRequest = new mobileqq_mp.SetRefuseFollowRequest();
    localSetRefuseFollowRequest.luin.set(Long.parseLong(paramString));
    localSetRefuseFollowRequest.account_type.set(1);
    localSetRefuseFollowRequest.refuse_forever.set(paramBoolean);
    if (!paramBoolean) {
      localSetRefuseFollowRequest.refuse_period.set(paramInt);
    }
    paramContext.putExtra("data", localSetRefuseFollowRequest.toByteArray());
    paramContext.setObserver(new hqu(this, paramContext, paramrefuseAcceptDone));
    if (paramAppInterface != null) {
      paramAppInterface.startServlet(paramContext);
    }
    return paramContext;
  }
  
  public void a(double paramDouble1, double paramDouble2, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = a(3, paramString2, paramBoolean);
    if (paramString2 != null)
    {
      paramString2.is_need_lbs.set(true);
      paramString2.latitude.set(paramDouble1);
      paramString2.longitude.set(paramDouble2);
      paramString2.event_id.set(15);
      if (paramString1 != null) {
        paramString2.lbsAddressLabel.set(paramString1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Location:", 2, "event_id:" + paramString2.event_id.get() + " is_need_lbs:" + paramString2.is_need_lbs.get() + " latitude:" + paramString2.latitude.get() + " longitude:" + paramString2.longitude.get() + " lbsAddressLabel:" + paramString2.lbsAddressLabel.get());
      }
      a(paramString2);
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {}
      try
      {
        paramContext.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
        if (this.jdField_c_of_type_AndroidContentBroadcastReceiver != null) {}
        try
        {
          paramContext.unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
          this.jdField_c_of_type_AndroidContentBroadcastReceiver = null;
          return;
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, PublicAccountManager.InitDoneObserver paramInitDoneObserver)
  {
    if ((paramString1 != null) && (!paramString1.equals(this.P))) {
      a(paramString1);
    }
    this.P = paramString1;
    ThreadManager.b(new hqg(this, paramString2, paramQQAppInterface, paramInitDoneObserver, paramContext));
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver)
  {
    a(paramContext, paramQQAppInterface, paramString1, paramString2, paramBoolean, paramDouble1, paramDouble2, paramBusinessObserver, 1, 0L, 0);
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2, BusinessObserver paramBusinessObserver, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("reportsendMenuEventequest", 2, "key:" + paramString2 + "uin:" + paramString1 + "type:" + paramInt1 + "msg_id:" + paramLong + "s_type" + paramInt2);
    }
    try
    {
      long l1 = Long.valueOf(paramString1).longValue();
      NewIntent localNewIntent = new NewIntent(paramContext, PublicAccountServlet.class);
      localNewIntent.putExtra("cmd", "send_menu_evt");
      mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = new mobileqq_mp.SendMenuEventRequest();
      localSendMenuEventRequest.key.set(paramString2);
      localSendMenuEventRequest.uin.set((int)l1);
      localSendMenuEventRequest.type.set(paramInt1);
      localSendMenuEventRequest.msg_id.set(paramLong);
      localSendMenuEventRequest.s_type.set(paramInt2);
      localSendMenuEventRequest.menu_type.set(b(paramString1));
      if (paramBoolean)
      {
        localSendMenuEventRequest.is_need_lbs.set(true);
        localSendMenuEventRequest.latitude.set(paramDouble1);
        localSendMenuEventRequest.longitude.set(paramDouble2);
      }
      localNewIntent.putExtra("data", localSendMenuEventRequest.toByteArray());
      localNewIntent.setObserver(new hqr(this, localNewIntent, paramContext, paramString1, paramBusinessObserver, paramQQAppInterface));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.startServlet(localNewIntent);
      }
      return;
    }
    catch (NumberFormatException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublicAccountManager", 2, "puin is invalid format:" + paramString1);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, BusinessObserver paramBusinessObserver)
  {
    this.C = paramString1;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("app", "QD");
      if (paramString2 != null) {
        paramString1.put("assignType", Long.parseLong(paramString2));
      }
      if (paramString3 != null) {
        paramString1.put("assignKey", Long.parseLong(paramString3));
      }
      if (paramString4 != null) {
        paramString1.put("ext", paramString4);
      }
      i1 = 0;
    }
    catch (Exception paramString2)
    {
      do
      {
        for (;;)
        {
          int i1 = 1;
          continue;
          paramString1 = paramString1.toString();
        }
        paramString1.menu_type.set(1001);
        paramString2 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        paramString2 = this.C;
        paramString2 = new NewIntent(paramBaseActivity, PublicAccountServlet.class);
        paramString2.putExtra("cmd", "send_menu_evt");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(paramBusinessObserver);
      } while (paramBaseActivity.app == null);
      paramBaseActivity.app.startServlet(paramString2);
    }
    if (i1 != 0)
    {
      paramString1 = "QD";
      paramString1 = a(1, paramString1, false);
      if (paramString1 != null) {
        break label125;
      }
    }
    label125:
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a().getSharedPreferences("history_msg_params_" + paramQQAppInterface.getAccount(), 0).edit().remove(paramString + "_msgid").commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface.a().getSharedPreferences("history_msg_params_" + paramQQAppInterface.getAccount(), 0).edit().putLong(paramString + "_msgid", paramLong).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountManager", 4, "savePublicAccountMenuSetting");
    }
    if (paramGetPublicAccountMenuResponse == null) {}
    label19:
    int i1;
    label43:
    Object localObject;
    PublicAccountMenuEntity localPublicAccountMenuEntity1;
    label137:
    label206:
    do
    {
      do
      {
        break label19;
        do
        {
          return;
        } while (paramQQAppInterface == null);
        if (!paramGetPublicAccountMenuResponse.seqno.has()) {
          break;
        }
        i1 = paramGetPublicAccountMenuResponse.seqno.get();
        a(paramString, i1);
        l1 = System.currentTimeMillis();
        a(paramString, l1);
      } while (paramGetPublicAccountMenuResponse.toByteArray() == null);
      localObject = paramQQAppInterface.a().createEntityManager();
      localPublicAccountMenuEntity1 = new PublicAccountMenuEntity(paramString, paramGetPublicAccountMenuResponse, l1);
      if (((EntityManager)localObject).a(PublicAccountMenuEntity.class, paramString) == null) {
        break label391;
      }
      PublicAccountMenuEntity localPublicAccountMenuEntity2 = (PublicAccountMenuEntity)((EntityManager)localObject).a(PublicAccountMenuEntity.class, paramString);
      if (localPublicAccountMenuEntity2 == null) {
        break label381;
      }
      localPublicAccountMenuEntity2.clone(localPublicAccountMenuEntity1);
      ((EntityManager)localObject).a(localPublicAccountMenuEntity2);
      ((EntityManager)localObject).a();
      localObject = paramGetPublicAccountMenuResponse.button_info.get();
      long l1 = localPublicAccountMenuEntity1.savedDateTime;
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l1));
      this.jdField_c_of_type_JavaUtilMap.put(paramString, localObject);
      if (!paramGetPublicAccountMenuResponse.menu_type.has()) {
        break label401;
      }
      i1 = paramGetPublicAccountMenuResponse.menu_type.get();
      this.d.put(paramString, Integer.valueOf(i1));
    } while (i1 == 0);
    if (i1 == 1) {}
    for (paramGetPublicAccountMenuResponse = "icon";; paramGetPublicAccountMenuResponse = "text")
    {
      ReportController.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC2", "0X8005EC2", 0, 0, paramString, paramGetPublicAccountMenuResponse, "", "");
      if ((((List)localObject).size() <= 0) || (((List)localObject).get(0) == null) || (!((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.has()) || (((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.get() == null)) {
        break;
      }
      ReportController.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC3", "0X8005EC3", 0, 0, paramString, String.valueOf(((mobileqq_mp.ButtonInfo)((List)localObject).get(0)).sub_button.get().size()), "", "");
      return;
      i1 = 0;
      break label43;
      label381:
      ((EntityManager)localObject).a(localPublicAccountMenuEntity1);
      break label137;
      label391:
      ((EntityManager)localObject).a(localPublicAccountMenuEntity1);
      break label137;
      label401:
      i1 = 0;
      break label206;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    this.jdField_b_of_type_JavaUtilMap.remove(paramString);
    this.jdField_c_of_type_JavaUtilMap.remove(paramString);
    this.d.remove(paramString);
    if (QLog.isColorLevel()) {
      QLog.e("PublicAccountManager", 2, "left menu size:" + this.jdField_c_of_type_JavaUtilMap.size());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, List paramList)
  {
    mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = a(3, this.D, this.jdField_b_of_type_Boolean);
    if (localSendMenuEventRequest != null)
    {
      localSendMenuEventRequest.event_id.set(paramInt2);
      if (paramString != null)
      {
        localSendMenuEventRequest.scan_result.set(paramString);
        localSendMenuEventRequest.scanType.set(paramInt1);
      }
      if (paramInt3 >= 0) {
        localSendMenuEventRequest.pictureCount.set(paramInt3);
      }
      if (paramList != null) {
        localSendMenuEventRequest.picture_Md5s.set(paramList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Event:", 2, "event_id:" + localSendMenuEventRequest.event_id.get() + " scan_result:" + localSendMenuEventRequest.scan_result.get() + " pictureCount:" + localSendMenuEventRequest.pictureCount.get());
      }
      a(localSendMenuEventRequest);
    }
  }
  
  public void a(String paramString1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2, int paramInt1, BusinessObserver paramBusinessObserver, MqqHandler paramMqqHandler, int paramInt2, SessionInfo paramSessionInfo)
  {
    mobileqq_mp.ButtonInfo localButtonInfo = a(paramQQAppInterface, paramString2, paramInt1);
    if (localButtonInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountManager", 2, "Can't find menu via menu id:" + paramInt1 + ".");
      }
    }
    label117:
    label137:
    label214:
    label273:
    label382:
    label546:
    label552:
    label558:
    label565:
    label571:
    label577:
    label717:
    label777:
    label784:
    label790:
    do
    {
      return;
      if ((paramSessionInfo.jdField_a_of_type_Int == 1008) && (((paramInt2 == 1) && (!localButtonInfo.sub_button.has())) || (paramInt2 == 2))) {
        b(paramQQAppInterface, paramString2);
      }
      int i1;
      Object localObject;
      if (localButtonInfo.type.has())
      {
        i1 = localButtonInfo.type.get();
        if (!localButtonInfo.name.has()) {
          break label546;
        }
        paramString1 = localButtonInfo.name.get();
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramString2, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(paramInt2), String.valueOf(paramInt1), paramString1, String.valueOf(i1));
        localObject = new StringBuilder();
        paramString1 = "";
        if (i1 == 2)
        {
          if (!localButtonInfo.url.has()) {
            break label552;
          }
          paramString1 = AbsStructMsgElement.a(localButtonInfo.url.get());
        }
        StringBuilder localStringBuilder = ((StringBuilder)localObject).append("MENUID=").append(String.valueOf(paramInt1)).append(";LEVELID=").append(String.valueOf(paramInt2)).append(";NAME=");
        if (!localButtonInfo.name.has()) {
          break label558;
        }
        localObject = localButtonInfo.name.get();
        ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", paramString2, "0X8005D4B", "0X8005D4B", 0, 0, (String)localObject + ";REFERRER=" + paramString1, "", "", "");
        this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramBusinessObserver);
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
        this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
        this.C = paramString2;
        if (!localButtonInfo.key.has()) {
          break label565;
        }
        paramString1 = localButtonInfo.key.get();
        this.D = paramString1;
        if (!localButtonInfo.is_new_menu.has()) {
          break label571;
        }
      }
      for (boolean bool = localButtonInfo.is_new_menu.get();; bool = false)
      {
        this.jdField_b_of_type_Boolean = bool;
        if ((paramContext instanceof FragmentActivity))
        {
          paramString1 = ((FragmentActivity)paramContext).getChatFragment();
          if (paramString1 != null)
          {
            paramString1 = paramString1.a();
            if ((paramString1 instanceof PublicAccountChatPie))
            {
              paramString1 = (PublicAccountChatPie)paramString1;
              paramString1.dZ += 1;
            }
          }
        }
        switch (i1)
        {
        default: 
          return;
        case 1: 
          if (paramMqqHandler != null) {
            paramMqqHandler.sendEmptyMessage(1001);
          }
          if ((!localButtonInfo.is_need_lbs.has()) || (!localButtonInfo.is_need_lbs.get())) {
            break label577;
          }
          new Thread(this.jdField_a_of_type_JavaLangRunnable).start();
          return;
          i1 = 0;
          break label117;
          paramString1 = "";
          break label137;
          paramString1 = "";
          break label214;
          localObject = "";
          break label273;
          paramString1 = "";
          break label382;
        }
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(19);
      }
      if (localButtonInfo.media_id.has()) {}
      for (paramString1 = localButtonInfo.media_id.get();; paramString1 = null)
      {
        a(false, 0.0D, 0.0D, null, paramString1, this.D, this.jdField_b_of_type_Boolean);
        return;
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(1001);
      }
      if (paramMqqHandler != null) {
        paramMqqHandler.sendEmptyMessage(1001);
      }
      paramString1 = localButtonInfo.actionInfo.a_actionData.get();
      paramBusinessObserver = localButtonInfo.actionInfo.actionData.get();
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = paramBusinessObserver;
        if (!localButtonInfo.url.has()) {
          break label777;
        }
        paramBusinessObserver = localButtonInfo.url.get();
        if (!localButtonInfo.media_id.has()) {
          break label784;
        }
      }
      for (paramMqqHandler = localButtonInfo.media_id.get();; paramMqqHandler = null)
      {
        if (!TextUtils.isEmpty(paramString1)) {
          break label790;
        }
        a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
        a(paramBusinessObserver, (mobileqq_mp.ActionInfo)localButtonInfo.actionInfo.get(), paramMqqHandler);
        return;
        break;
        paramBusinessObserver = "";
        break label717;
      }
      paramSessionInfo = JumpParser.a(paramQQAppInterface, paramContext, paramString1);
      if (paramSessionInfo == null)
      {
        if (localButtonInfo.actionInfo.appid.has())
        {
          a(paramQQAppInterface, paramContext, paramString2, localButtonInfo, paramString1);
          return;
        }
        a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
        a(paramBusinessObserver, (mobileqq_mp.ActionInfo)localButtonInfo.actionInfo.get(), paramMqqHandler);
        return;
      }
      if (TextUtils.isEmpty(paramSessionInfo.a()))
      {
        a(paramQQAppInterface, paramContext, paramString2, localButtonInfo, paramString1);
        return;
      }
    } while (paramSessionInfo.b());
    a(paramQQAppInterface, paramContext, paramString2, localButtonInfo);
    a(paramBusinessObserver, (mobileqq_mp.ActionInfo)localButtonInfo.actionInfo.get(), paramMqqHandler);
    return;
    if (localButtonInfo.event_id.has()) {}
    for (paramInt1 = localButtonInfo.event_id.get();; paramInt1 = 0) {
      switch (paramInt1)
      {
      default: 
        return;
      case 1: 
        a(paramQQAppInterface, paramContext, paramString2);
        a(null, 0, 1, -1, null);
        return;
      }
    }
    a(paramContext, paramMqqHandler, false);
    return;
    a(paramContext, paramMqqHandler, true);
    return;
    a(paramContext, paramQQAppInterface, paramSessionInfo);
    return;
    b(paramContext, paramQQAppInterface, paramSessionInfo);
    return;
    c(paramContext, paramQQAppInterface, paramSessionInfo);
    return;
    a(paramQQAppInterface, paramMqqHandler);
    return;
    a(paramContext, paramQQAppInterface);
  }
  
  public void a(String paramString1, mobileqq_mp.ActionInfo paramActionInfo, String paramString2)
  {
    mobileqq_mp.SendMenuEventRequest localSendMenuEventRequest = a(2, this.D, this.jdField_b_of_type_Boolean);
    if (localSendMenuEventRequest != null)
    {
      localSendMenuEventRequest.url.set(paramString1);
      localSendMenuEventRequest.actionInfo.set(paramActionInfo);
      if (paramString2 != null) {
        localSendMenuEventRequest.media_id.set(paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Url:", 2, "url:" + localSendMenuEventRequest.url.get() + " actionInfo:" + localSendMenuEventRequest.actionInfo.get() + " media_id:" + localSendMenuEventRequest.media_id.get());
      }
      a(localSendMenuEventRequest);
    }
  }
  
  public void a(NewIntent paramNewIntent)
  {
    if (paramNewIntent != null) {
      paramNewIntent.setObserver(null);
    }
  }
  
  public void a(boolean paramBoolean1, double paramDouble1, double paramDouble2, String paramString1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    paramString3 = a(1, paramString3, paramBoolean2);
    if (paramString3 != null)
    {
      if (paramBoolean1)
      {
        paramString3.is_need_lbs.set(true);
        paramString3.latitude.set(paramDouble1);
        paramString3.longitude.set(paramDouble2);
      }
      if (paramString1 != null) {
        paramString3.lbsAddressLabel.set(paramString1);
      }
      if (paramString2 != null) {
        paramString3.media_id.set(paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManager-Click:", 2, "is_need_lbs:" + paramString3.is_need_lbs.get() + " latitude:" + paramString3.latitude.get() + " longitude:" + paramString3.longitude.get() + " lbsAddressLabel:" + paramString3.lbsAddressLabel.get() + " media_id:" + paramString3.media_id.get());
      }
      a(paramString3);
    }
  }
  
  public int b(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return ((Integer)this.d.get(paramString)).intValue();
    }
    return 0;
  }
  
  public List b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return (List)this.jdField_c_of_type_JavaUtilMap.get(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */