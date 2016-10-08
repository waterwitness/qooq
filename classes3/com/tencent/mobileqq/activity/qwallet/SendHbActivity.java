package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment.OnCommonHbListener;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment.OnQzoneHbClickListener;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.OnThemeHbClickListener;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;
import otq;
import otr;
import ots;

public class SendHbActivity
  extends FragmentActivity
  implements View.OnClickListener, CommonHbFragment.OnCommonHbListener, QzoneHbFragment.OnQzoneHbClickListener, ThemeHbFragment.OnThemeHbClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "64";
  private static final String jdField_b_of_type_JavaLangString = "128";
  private static final String jdField_c_of_type_JavaLangString = "256";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private QWalletPayProgressDialog jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  
  public SendHbActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.k = "1";
    this.s = "";
    this.t = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ots(this);
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(a(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "0";
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = this.mSystemBarComp;
    this.mSystemBarComp = null;
    new SystemBarCompact(this, true, paramInt).init();
  }
  
  private void a(int paramInt, JSONObject paramJSONObject)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_AndroidSupportV4AppFragment = null;
    int i1 = -3064501;
    if (this.c) {
      paramInt = 64;
    }
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(16777215);
      paramJSONObject = new Bundle();
      paramJSONObject.putString("channel", this.k);
      paramJSONObject.putString("placeholder", this.j);
      paramJSONObject.putString("people_num", this.r);
      paramJSONObject.putString("recv_type", this.jdField_d_of_type_JavaLangString);
      paramJSONObject.putString("bus_type", this.v);
      this.jdField_a_of_type_AndroidSupportV4AppFragment = new CommonHbFragment();
      this.jdField_a_of_type_AndroidSupportV4AppFragment.setArguments(paramJSONObject);
      paramInt = i1;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null)
      {
        ((FrameLayout)findViewById(2131300451)).setVisibility(0);
        localFragmentTransaction.add(2131300451, this.jdField_a_of_type_AndroidSupportV4AppFragment);
        localFragmentTransaction.commit();
      }
      a(paramInt);
      return;
      a(paramJSONObject);
      paramInt = 184549376;
      continue;
      a(paramJSONObject);
      paramInt = 184549376;
      continue;
      paramJSONObject = getIntent().getStringExtra("theme_config");
      Bundle localBundle = new Bundle();
      if (("64".equals(this.k)) || ((this.jdField_b_of_type_Int & 0x40) > 0))
      {
        this.c = true;
        this.q = getIntent().getStringExtra("theme_type");
        this.n = getIntent().getStringExtra("group_id");
        this.m = getIntent().getStringExtra("group_member_number");
      }
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragment = new ThemeHbFragment();
        localBundle.putString("group_count", this.m);
        localBundle.putString("channel", this.k);
        localBundle.putString("config", paramJSONObject);
        this.jdField_a_of_type_AndroidSupportV4AppFragment.setArguments(localBundle);
      }
      paramInt = 184549376;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296895);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300452);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300453));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((Button)findViewById(2131300454)).setOnClickListener(this);
  }
  
  private void b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", paramString);
      localJSONObject.put("comeForm", this.jdField_a_of_type_Int);
      localJSONObject.put("h5_success", true);
      localJSONObject.put("appInfo", this.h);
      paramString = new Bundle();
      paramString.putString("json", localJSONObject.toString());
      paramString.putString("callbackSn", "0");
      paramString.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      PayBridgeActivity.a(this, 9, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    if ("5".equals(this.k))
    {
      if (("1".equals(this.jdField_d_of_type_JavaLangString)) || ("7".equals(this.jdField_d_of_type_JavaLangString))) {
        return 146;
      }
      return 145;
    }
    if (this.jdField_b_of_type_Boolean) {
      return 131;
    }
    if ((this.c) && (!this.jdField_f_of_type_Boolean) && ((this.jdField_b_of_type_Int & 0x40) == 0)) {
      return 149;
    }
    if ((this.c) && (this.jdField_f_of_type_Boolean) && ((this.jdField_b_of_type_Int & 0x40) == 0)) {
      return 157;
    }
    if ((this.c) && ((this.jdField_b_of_type_Int & 0x40) > 0)) {
      return 156;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CommonHbFragment)) && (((CommonHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a() == 2)) {
      return 150;
    }
    if (("1".equals(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CommonHbFragment)) && (((CommonHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a() == 1)) {
      return 153;
    }
    if (("4".equals(this.jdField_d_of_type_JavaLangString)) || ("5".equals(this.jdField_d_of_type_JavaLangString))) {
      return 155;
    }
    if (("1".equals(this.jdField_d_of_type_JavaLangString)) || ("7".equals(this.jdField_d_of_type_JavaLangString))) {
      return 133;
    }
    return 132;
  }
  
  public int a(Context paramContext)
  {
    try
    {
      int i1 = paramContext.getResources().getDimensionPixelSize(2131492908);
      float f1 = paramContext.getResources().getDisplayMetrics().density;
      return i1 - (int)(f1 * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public Intent a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("result", paramInt);
      return localIntent;
      localIntent.putExtra("retmsg", paramString1);
    }
  }
  
  public String a()
  {
    String str2 = this.k;
    String str1 = str2;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null)
    {
      str1 = str2;
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CommonHbFragment)) {
        str1 = ((CommonHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
      }
    }
    return str1;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.jdField_f_of_type_JavaLangString);
      localJSONObject.put("recv_uin", this.jdField_e_of_type_JavaLangString);
      localJSONObject.put("recv_type", this.o);
      localJSONObject.put("na_from_h5_data", this.l);
      localJSONObject.put("session_token", this.i);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("hb_id", this.u);
    localIntent.putExtra("send_uin", this.p);
    localIntent.putExtra("hb_type", "1");
    localIntent.putExtra("forward_text", "发红包啦!");
    localIntent.putExtra("forward_type", 17);
    localIntent.putExtra("invoke_from", "qwallet");
    ForwardBaseOption.a(this, localIntent);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      new Bundle();
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("resultCode", paramInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.g);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", paramBundle.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(this.p, paramInt1, paramString, "", "", paramInt2, "");
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a(this.p, a(), paramString1, paramString2, "", paramInt2, "");
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      a("红包金额为空");
      return;
    }
    this.s = paramString3;
    this.t = paramString4;
    try
    {
      paramString4 = a();
      paramString4.put("total_num", "1");
      paramString4.put("total_amount", a(paramString3));
      paramString4.put("wishing", paramString2);
      paramString4.put("channel", this.k);
      paramString4.put("type", paramInt);
      if ("64".equals(this.k))
      {
        paramString4.put("groupid", this.n);
        paramString4.put("theme_type", this.q);
        paramString4.put("total_num", this.m);
      }
      paramString4.put("bus_type", paramString1);
      paramString1 = b();
      paramString1.put("extra_data", paramString4.toString());
      paramString2 = new Bundle();
      paramString2.putString("json", paramString1.toString());
      paramString2.putString("callbackSn", "0");
      paramString2.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      PayBridgeActivity.a(this, 5, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).b(a(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sp_data", paramString);
      localJSONObject.put("channel", this.k);
      paramString = new JSONObject();
      paramString.put("userId", this.p);
      paramString.put("viewTag", "sendHbCallback");
      paramString.put("comeForm", 2);
      paramString.put("appInfo", this.h);
      paramString.put("extra_data", localJSONObject.toString());
      PayBridgeActivity.tenpay(this, paramString.toString(), 5, "0");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(this.p, a(), paramString, "", "", paramInt, "");
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    paramString5 = new StringBuilder();
    paramString5.append("Tenpay_mqq");
    paramString5.append("|");
    paramString5.append(paramString1);
    paramString5.append("||");
    paramString5.append(paramInt1);
    paramString5.append("|");
    paramString5.append(paramString2);
    paramString5.append("|0|1|0|android.");
    try
    {
      paramString5.append(this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName);
      paramString5.append("|");
      paramString5.append(CommonUtil.a());
      paramString5.append("|");
      if ((!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
      {
        paramString5.append(paramString3);
        paramString5.append(".");
        paramString5.append(paramString4);
      }
      paramString5.append("|");
      paramString5.append(this.jdField_a_of_type_Int);
      paramString5.append(".");
      if (!TextUtils.isEmpty(this.h)) {
        paramString5.append(this.h.replace("|", ","));
      }
      paramString5.append("|");
      VACDReportUtil.a(this.jdField_a_of_type_Long, null, paramString2, "op_type=" + paramInt1, 0, "");
      StatisticCollector.a(BaseApplication.getContext()).c(this.app, paramString5.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    DialogUtil.a(this, 230, null, paramString1, paramString2, paramString3, new otq(this), new otr(this)).show();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString4))
    {
      a("红包金额为空");
      return;
    }
    this.s = paramString4;
    this.t = paramString5;
    try
    {
      JSONObject localJSONObject = a();
      localJSONObject.put("total_num", paramString5);
      localJSONObject.put("total_amount", a(paramString4));
      localJSONObject.put("wishing", paramString2);
      localJSONObject.put("channel", paramString1);
      localJSONObject.put("bus_type", paramString3);
      localJSONObject.put("type", "1");
      paramString1 = b();
      paramString1.put("extra_data", localJSONObject.toString());
      paramString2 = new Bundle();
      paramString2.putString("json", paramString1.toString());
      paramString2.putString("callbackSn", "0");
      paramString2.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      PayBridgeActivity.a(this, 5, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      a("红包金额为空");
      return;
    }
    this.s = paramString3;
    this.t = paramString4;
    try
    {
      paramString4 = a();
      paramString4.put("total_num", "1");
      paramString4.put("total_amount", a(paramString3));
      paramString4.put("wishing", paramString2);
      paramString4.put("channel", paramString1);
      paramString4.put("feeds_name", paramString5);
      paramString4.put("feeds_sid", paramString6);
      paramString1 = b();
      paramString1.put("extra_data", paramString4.toString());
      paramString2 = new Bundle();
      paramString2.putString("json", paramString1.toString());
      paramString2.putString("callbackSn", "0");
      paramString2.putLong("vacreport_key_seq", this.jdField_a_of_type_Long);
      PayBridgeActivity.a(this, 5, paramString2);
      overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("feedsid");
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = new QzoneHbFragment();
    paramJSONObject = new Bundle();
    paramJSONObject.putString("send_name", this.jdField_f_of_type_JavaLangString);
    paramJSONObject.putString("recv_name", this.w);
    paramJSONObject.putString("feedsid", str);
    paramJSONObject.putString("recv_uin", this.jdField_e_of_type_JavaLangString);
    paramJSONObject.putString("send_uin", this.p);
    paramJSONObject.putString("channel", this.k);
    this.jdField_a_of_type_AndroidSupportV4AppFragment.setArguments(paramJSONObject);
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.p);
      localJSONObject.put("viewTag", "sendHb");
      localJSONObject.put("comeForm", 2);
      localJSONObject.put("appInfo", this.h);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    a(-1, null);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    this.c = getIntent().getBooleanExtra("theme", false);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.jdField_a_of_type_Long = getIntent().getLongExtra("vacreport_key_seq", 0L);
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "hbinvoke", null, 0, null);
      this.jdField_a_of_type_AndroidContentContext = this;
    }
    for (;;)
    {
      try
      {
        this.p = this.app.a();
        this.jdField_f_of_type_JavaLangString = this.app.b();
        this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("is_H5", false);
        this.jdField_a_of_type_Int = getIntent().getIntExtra("come_from", 1);
        this.g = getIntent().getStringExtra("callbackSn");
        this.h = getIntent().getStringExtra("app_info");
        paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
      }
      catch (Exception localException1)
      {
        paramBundle = null;
      }
      try
      {
        this.jdField_e_of_type_JavaLangString = paramBundle.optString("recv_uin");
        this.w = paramBundle.optString("recv_name");
        this.r = paramBundle.optString("people_num");
        this.jdField_d_of_type_JavaLangString = paramBundle.optString("recv_type");
        this.o = this.jdField_d_of_type_JavaLangString;
        this.v = paramBundle.optString("bus_type");
        this.i = paramBundle.optString("session_token");
        this.k = paramBundle.optString("channel", "1");
        this.jdField_f_of_type_Boolean = paramBundle.optBoolean("feedback", false);
        this.jdField_b_of_type_Int = Integer.parseInt(this.k);
        if (("5".equals(this.k)) || ("128".equals(this.k)) || ("256".equals(this.k)))
        {
          this.jdField_f_of_type_JavaLangString = ContactUtils.o(this.app, this.p);
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
            this.jdField_f_of_type_JavaLangString = this.app.b();
          }
        }
        this.j = paramBundle.optString("placeholder");
        this.l = paramBundle.optString("na_from_h5_data");
        this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)getIntent().getParcelableExtra("receiver"));
        setContentView(2130903856);
        b();
        a(this.jdField_b_of_type_Int, paramBundle);
        c();
        QWalletHelper.a();
        return true;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      VACDReportUtil.a(this.jdField_a_of_type_Long, null, "hbinvoke", null, 0, null);
      break;
      localException1.printStackTrace();
    }
  }
  
  protected void doOnDestroy()
  {
    this.mSystemBarComp = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    if (this.jdField_a_of_type_Long != 0L) {
      VACDReportUtil.a(this.jdField_a_of_type_Long, "hongbao.wrap.destroy", null, 0, null);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Boolean = false;
    a(this.p, a(), "hongbao.wrap.show", "", "", 2, "");
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 490	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_Boolean	Z
    //   5: aload_3
    //   6: ifnull +150 -> 156
    //   9: iload_2
    //   10: iconst_m1
    //   11: if_icmpne +145 -> 156
    //   14: aload_3
    //   15: ldc_w 400
    //   18: invokevirtual 248	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 6
    //   23: aload 6
    //   25: ifnull +137 -> 162
    //   28: aload 6
    //   30: invokevirtual 765	java/lang/String:length	()I
    //   33: ifle +129 -> 162
    //   36: new 294	org/json/JSONObject
    //   39: dup
    //   40: aload 6
    //   42: invokespecial 698	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: ifnull +1022 -> 1071
    //   52: aload 4
    //   54: ldc_w 405
    //   57: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_3
    //   61: aload 4
    //   63: ldc_w 450
    //   66: iconst_m1
    //   67: invokevirtual 768	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   70: istore_2
    //   71: aload 4
    //   73: ldc_w 394
    //   76: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore 4
    //   81: aload 4
    //   83: ifnull +92 -> 175
    //   86: aload 4
    //   88: invokevirtual 765	java/lang/String:length	()I
    //   91: ifle +84 -> 175
    //   94: new 294	org/json/JSONObject
    //   97: dup
    //   98: aload 4
    //   100: invokespecial 698	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   103: astore 4
    //   105: aload_3
    //   106: astore 5
    //   108: aload 4
    //   110: astore_3
    //   111: aload 5
    //   113: astore 4
    //   115: aload_0
    //   116: getfield 515	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   119: invokevirtual 771	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   122: iload_2
    //   123: ifne +818 -> 941
    //   126: aload_3
    //   127: ifnull +814 -> 941
    //   130: iload_1
    //   131: lookupswitch	default:+25->156, 5:+56->187, 9:+289->420
    //   156: return
    //   157: astore_3
    //   158: aload_3
    //   159: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   162: aconst_null
    //   163: astore 4
    //   165: goto -118 -> 47
    //   168: astore 4
    //   170: aload 4
    //   172: invokevirtual 341	java/lang/Exception:printStackTrace	()V
    //   175: aconst_null
    //   176: astore 5
    //   178: aload_3
    //   179: astore 4
    //   181: aload 5
    //   183: astore_3
    //   184: goto -69 -> 115
    //   187: aload_0
    //   188: getfield 508	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   191: ifeq +127 -> 318
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 508	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   199: aload_3
    //   200: ldc_w 773
    //   203: invokevirtual 775	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   206: iconst_1
    //   207: if_icmpne +45 -> 252
    //   210: aload_0
    //   211: getfield 280	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   214: iconst_0
    //   215: invokevirtual 776	android/view/View:setVisibility	(I)V
    //   218: aload_0
    //   219: aload_3
    //   220: ldc_w 778
    //   223: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: putfield 86	com/tencent/mobileqq/activity/qwallet/SendHbActivity:u	Ljava/lang/String;
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 276	com/tencent/mobileqq/activity/qwallet/SendHbActivity:p	Ljava/lang/String;
    //   234: aload_0
    //   235: invokevirtual 464	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()I
    //   238: ldc_w 780
    //   241: ldc 68
    //   243: ldc 68
    //   245: iconst_2
    //   246: ldc 68
    //   248: invokevirtual 462	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: ldc 22
    //   254: aload_0
    //   255: getfield 66	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   258: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifne +15 -> 276
    //   264: ldc 19
    //   266: aload_0
    //   267: getfield 66	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   270: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   273: ifeq +37 -> 310
    //   276: new 245	android/content/Intent
    //   279: dup
    //   280: invokespecial 392	android/content/Intent:<init>	()V
    //   283: astore 4
    //   285: aload 4
    //   287: ldc_w 405
    //   290: aload_3
    //   291: invokevirtual 322	org/json/JSONObject:toString	()Ljava/lang/String;
    //   294: invokevirtual 398	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   297: pop
    //   298: aload_0
    //   299: iconst_m1
    //   300: aload 4
    //   302: invokevirtual 458	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   305: aload_0
    //   306: invokevirtual 783	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   309: return
    //   310: aload_0
    //   311: ldc_w 785
    //   314: invokevirtual 470	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   317: return
    //   318: ldc 16
    //   320: aload_0
    //   321: getfield 66	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   324: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifne +13 -> 340
    //   330: aload_0
    //   331: getfield 83	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_b_of_type_Int	I
    //   334: bipush 64
    //   336: iand
    //   337: ifle +71 -> 408
    //   340: new 294	org/json/JSONObject
    //   343: dup
    //   344: invokespecial 295	org/json/JSONObject:<init>	()V
    //   347: astore 4
    //   349: aload 4
    //   351: ldc_w 787
    //   354: aload_3
    //   355: ldc_w 787
    //   358: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: invokevirtual 790	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   364: pop
    //   365: aload 4
    //   367: ldc_w 476
    //   370: aload_0
    //   371: getfield 70	com/tencent/mobileqq/activity/qwallet/SendHbActivity:s	Ljava/lang/String;
    //   374: invokevirtual 790	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   377: pop
    //   378: aload_0
    //   379: iconst_m1
    //   380: aload_0
    //   381: iload_2
    //   382: ldc 68
    //   384: aload 4
    //   386: invokevirtual 322	org/json/JSONObject:toString	()Ljava/lang/String;
    //   389: invokevirtual 792	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(ILjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   392: invokevirtual 458	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   395: aload_0
    //   396: invokevirtual 783	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   399: return
    //   400: astore_3
    //   401: aload_3
    //   402: invokevirtual 340	org/json/JSONException:printStackTrace	()V
    //   405: goto -27 -> 378
    //   408: aload_0
    //   409: aload_3
    //   410: ldc_w 787
    //   413: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   416: invokespecial 794	com/tencent/mobileqq/activity/qwallet/SendHbActivity:b	(Ljava/lang/String;)V
    //   419: return
    //   420: aload_3
    //   421: ldc_w 796
    //   424: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   427: astore 4
    //   429: new 798	java/lang/StringBuffer
    //   432: dup
    //   433: invokespecial 799	java/lang/StringBuffer:<init>	()V
    //   436: astore 5
    //   438: aload 5
    //   440: ldc_w 801
    //   443: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   446: pop
    //   447: aload 5
    //   449: aload_0
    //   450: getfield 72	com/tencent/mobileqq/activity/qwallet/SendHbActivity:t	Ljava/lang/String;
    //   453: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   456: pop
    //   457: aload 5
    //   459: ldc_w 806
    //   462: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   465: pop
    //   466: ldc 64
    //   468: aload_0
    //   469: getfield 198	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   472: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   475: ifne +42 -> 517
    //   478: ldc_w 357
    //   481: aload_0
    //   482: getfield 198	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   485: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   488: ifne +29 -> 517
    //   491: ldc_w 365
    //   494: aload_0
    //   495: getfield 198	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   498: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   501: ifne +16 -> 517
    //   504: ldc_w 355
    //   507: aload_0
    //   508: getfield 198	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   511: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   514: ifeq +378 -> 892
    //   517: aload 5
    //   519: ldc_w 808
    //   522: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   525: pop
    //   526: aload 5
    //   528: ldc_w 810
    //   531: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   534: pop
    //   535: aload 5
    //   537: aload_0
    //   538: invokevirtual 811	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()Ljava/lang/String;
    //   541: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   544: pop
    //   545: aload 5
    //   547: ldc_w 813
    //   550: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   553: pop
    //   554: aload 5
    //   556: aload_0
    //   557: getfield 70	com/tencent/mobileqq/activity/qwallet/SendHbActivity:s	Ljava/lang/String;
    //   560: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   563: pop
    //   564: aload_0
    //   565: aload_0
    //   566: getfield 276	com/tencent/mobileqq/activity/qwallet/SendHbActivity:p	Ljava/lang/String;
    //   569: aload_0
    //   570: invokevirtual 464	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	()I
    //   573: ldc_w 815
    //   576: aload 5
    //   578: invokevirtual 816	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   581: aconst_null
    //   582: iconst_2
    //   583: ldc 68
    //   585: invokevirtual 462	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   588: aload 4
    //   590: ifnull -434 -> 156
    //   593: aload_0
    //   594: getfield 416	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   597: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   600: ifne +329 -> 929
    //   603: ldc 19
    //   605: aload_0
    //   606: getfield 66	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   609: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   612: ifne +317 -> 929
    //   615: ldc 22
    //   617: aload_0
    //   618: getfield 66	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   621: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifne +305 -> 929
    //   627: new 798	java/lang/StringBuffer
    //   630: dup
    //   631: aload 4
    //   633: invokestatic 821	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   636: invokespecial 822	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   639: astore 4
    //   641: aload_3
    //   642: ldc_w 520
    //   645: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   648: astore 5
    //   650: aload 5
    //   652: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   655: ifne +20 -> 675
    //   658: aload 4
    //   660: ldc_w 824
    //   663: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   666: pop
    //   667: aload 4
    //   669: aload 5
    //   671: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   674: pop
    //   675: aload_3
    //   676: ldc_w 826
    //   679: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   682: astore 5
    //   684: aload 5
    //   686: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   689: ifne +20 -> 709
    //   692: aload 4
    //   694: ldc_w 828
    //   697: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   700: pop
    //   701: aload 4
    //   703: aload 5
    //   705: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   708: pop
    //   709: aload_3
    //   710: ldc_w 830
    //   713: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   716: astore 5
    //   718: aload 5
    //   720: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   723: ifne +20 -> 743
    //   726: aload 4
    //   728: ldc_w 832
    //   731: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   734: pop
    //   735: aload 4
    //   737: aload 5
    //   739: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   742: pop
    //   743: aload_3
    //   744: ldc_w 834
    //   747: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   750: astore_3
    //   751: aload_3
    //   752: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   755: ifne +19 -> 774
    //   758: aload 4
    //   760: ldc_w 836
    //   763: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   766: pop
    //   767: aload 4
    //   769: aload_3
    //   770: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   773: pop
    //   774: new 294	org/json/JSONObject
    //   777: dup
    //   778: invokespecial 295	org/json/JSONObject:<init>	()V
    //   781: astore_3
    //   782: new 294	org/json/JSONObject
    //   785: dup
    //   786: invokespecial 295	org/json/JSONObject:<init>	()V
    //   789: astore 5
    //   791: aload 5
    //   793: ldc_w 796
    //   796: aload 4
    //   798: invokevirtual 816	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   801: invokevirtual 301	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   804: pop
    //   805: aload_3
    //   806: ldc_w 450
    //   809: iconst_0
    //   810: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   813: pop
    //   814: aload_3
    //   815: ldc_w 405
    //   818: ldc_w 838
    //   821: invokevirtual 301	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   824: pop
    //   825: aload_3
    //   826: ldc_w 394
    //   829: aload 5
    //   831: invokevirtual 301	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   834: pop
    //   835: new 245	android/content/Intent
    //   838: dup
    //   839: invokespecial 392	android/content/Intent:<init>	()V
    //   842: astore 4
    //   844: aload 4
    //   846: ldc_w 324
    //   849: aload_0
    //   850: getfield 452	com/tencent/mobileqq/activity/qwallet/SendHbActivity:g	Ljava/lang/String;
    //   853: invokevirtual 398	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   856: pop
    //   857: aload 4
    //   859: ldc_w 454
    //   862: iconst_5
    //   863: invokevirtual 403	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   866: pop
    //   867: aload 4
    //   869: ldc_w 400
    //   872: aload_3
    //   873: invokevirtual 322	org/json/JSONObject:toString	()Ljava/lang/String;
    //   876: invokevirtual 398	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   879: pop
    //   880: aload_0
    //   881: iconst_m1
    //   882: aload 4
    //   884: invokevirtual 458	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   887: aload_0
    //   888: invokevirtual 783	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   891: return
    //   892: ldc_w 840
    //   895: aload_0
    //   896: getfield 198	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   899: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   902: ifeq +15 -> 917
    //   905: aload 5
    //   907: ldc_w 842
    //   910: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   913: pop
    //   914: goto -388 -> 526
    //   917: aload 5
    //   919: ldc_w 844
    //   922: invokevirtual 804	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   925: pop
    //   926: goto -400 -> 526
    //   929: aload_0
    //   930: aload_3
    //   931: ldc_w 520
    //   934: invokevirtual 637	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   937: invokevirtual 846	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/String;)V
    //   940: return
    //   941: iload_2
    //   942: ifle +88 -> 1030
    //   945: ldc 22
    //   947: aload_0
    //   948: getfield 66	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   951: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   954: ifne +22 -> 976
    //   957: ldc 19
    //   959: aload_0
    //   960: getfield 66	com/tencent/mobileqq/activity/qwallet/SendHbActivity:k	Ljava/lang/String;
    //   963: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   966: ifeq +38 -> 1004
    //   969: aload_0
    //   970: getfield 508	com/tencent/mobileqq/activity/qwallet/SendHbActivity:jdField_e_of_type_Boolean	Z
    //   973: ifeq +31 -> 1004
    //   976: new 245	android/content/Intent
    //   979: dup
    //   980: invokespecial 392	android/content/Intent:<init>	()V
    //   983: astore_3
    //   984: aload_3
    //   985: ldc_w 405
    //   988: aload 6
    //   990: invokevirtual 398	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   993: pop
    //   994: aload_0
    //   995: iconst_m1
    //   996: aload_3
    //   997: invokevirtual 458	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1000: aload_0
    //   1001: invokevirtual 783	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   1004: aload_0
    //   1005: ldc_w 847
    //   1008: invokevirtual 851	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1011: astore_3
    //   1012: aload 4
    //   1014: ifnull +10 -> 1024
    //   1017: aload_0
    //   1018: aload 4
    //   1020: invokevirtual 470	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1023: return
    //   1024: aload_0
    //   1025: aload_3
    //   1026: invokevirtual 470	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1029: return
    //   1030: iload_2
    //   1031: bipush -10
    //   1033: if_icmpge -877 -> 156
    //   1036: aload_0
    //   1037: new 535	java/lang/StringBuilder
    //   1040: dup
    //   1041: invokespecial 536	java/lang/StringBuilder:<init>	()V
    //   1044: ldc_w 853
    //   1047: invokevirtual 542	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: iload_2
    //   1051: invokevirtual 549	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1054: invokevirtual 583	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokevirtual 470	com/tencent/mobileqq/activity/qwallet/SendHbActivity:a	(Ljava/lang/CharSequence;)V
    //   1060: return
    //   1061: astore 4
    //   1063: goto -228 -> 835
    //   1066: astore 5
    //   1068: goto -946 -> 122
    //   1071: aconst_null
    //   1072: astore_3
    //   1073: aconst_null
    //   1074: astore 4
    //   1076: goto -961 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1079	0	this	SendHbActivity
    //   0	1079	1	paramInt1	int
    //   0	1079	2	paramInt2	int
    //   0	1079	3	paramIntent	Intent
    //   45	119	4	localObject1	Object
    //   168	3	4	localException1	Exception
    //   179	840	4	localObject2	Object
    //   1061	1	4	localException2	Exception
    //   1074	1	4	localObject3	Object
    //   106	812	5	localObject4	Object
    //   1066	1	5	localException3	Exception
    //   21	968	6	str	String
    // Exception table:
    //   from	to	target	type
    //   36	47	157	java/lang/Exception
    //   94	105	168	java/lang/Exception
    //   349	378	400	org/json/JSONException
    //   782	835	1061	java/lang/Exception
    //   115	122	1066	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131300454)
    {
      a(this.p, a(), "hongbao.wrapped.send", "", "", 2, "");
      a();
    }
    while (i1 != 2131300453) {
      return;
    }
    a("未发送的红包可在“红包记录>发出的红包”里找到并继续发送", "稍后再发", "现在发送");
    if (this.jdField_d_of_type_Boolean)
    {
      a(this.p, a(), "hongbao.wrapped.keyback", "", "", 2, "");
      return;
    }
    a(this.p, a(), "hongbao.wrapped.close", "", "", 2, "");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof CommonHbFragment))
        {
          if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8) {
            break label91;
          }
          ((CommonHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof ThemeHbFragment)) {
          ((ThemeHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
        }
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof QzoneHbFragment)) {
          ((QzoneHbFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
        }
        return true;
        label91:
        this.jdField_a_of_type_AndroidWidgetButton.performClick();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\SendHbActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */