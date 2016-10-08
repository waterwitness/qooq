package com.tencent.mobileqq.olympic.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARFragment;
import com.tencent.mobileqq.ar.ARListener;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.olympic.view.ScanTorchViewFinder;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.QQBroadcastReceiver;
import tru;
import trv;
import trw;
import trx;
import try;
import trz;
import tsa;

public class ScanTorchActivity
  extends OlympicToolBaseActivity
  implements Handler.Callback, View.OnClickListener, ARListener, ScreenshotObserver.Listener
{
  public static final String a = "Olympic.ScanTorchActivity";
  public static boolean a = false;
  public static final String b = "log_on";
  public static boolean b = false;
  public static final String c = "icon_url";
  public static final String d = "icon_text";
  public static final int k = 292;
  public static final int l = 294;
  public static final int m = 295;
  public static final int n = 296;
  public long a;
  public Handler a;
  public ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  public RelativeLayout a;
  public TextView a;
  public ARArguments a;
  public ARFragment a;
  private ARTarget jdField_a_of_type_ComTencentMobileqqArARTarget;
  public RemoteArConfigManager a;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  private ArEffectConfig jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  private ScreenshotObserver jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver;
  public ScanTorchViewFinder a;
  public QQProgressDialog a;
  private QQBroadcastReceiver jdField_a_of_type_MqqAppQQBroadcastReceiver;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  public RelativeLayout b;
  public TextView b;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  public TextView c;
  public boolean c;
  private long jdField_d_of_type_Long;
  public RelativeLayout d;
  public TextView d;
  private boolean jdField_d_of_type_Boolean;
  public RelativeLayout e;
  public TextView e;
  public String e;
  private boolean e;
  public TextView f;
  public String f;
  public TextView g;
  public String g;
  public TextView h;
  public String h;
  private TextView i;
  public String i;
  private TextView j;
  public String j;
  public int o;
  public int p;
  private int q;
  
  public ScanTorchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.o = -1;
    this.p = -1;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_MqqAppQQBroadcastReceiver = new tsa(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      localIntent.setExtrasClassLoader(ScanTorchActivity.class.getClassLoader());
      jdField_a_of_type_Boolean = localIntent.getBooleanExtra("log_on", false);
      this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("icon_text");
      this.jdField_j_of_type_JavaLangString = localIntent.getStringExtra("icon_url");
    }
    this.jdField_a_of_type_ComTencentMobileqqArARArguments = new ARArguments(false);
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager = new RemoteArConfigManager();
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a(this, new tru(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScanTorchActivity", 2, "showArProgress");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Olympic.ScanTorchActivity", 2, paramString.toString());
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramString4, false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    int i2 = 1;
    this.jdField_e_of_type_JavaLangString = paramString1;
    this.jdField_f_of_type_JavaLangString = paramString2;
    this.jdField_g_of_type_JavaLangString = paramString3;
    this.jdField_h_of_type_JavaLangString = paramString4;
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = 1;
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        break label199;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = 1;
      label88:
      if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        break label211;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      i1 = i2;
      label121:
      paramString1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (i1 == 0) {
        break label223;
      }
    }
    label199:
    label211:
    label223:
    for (int i1 = 0;; i1 = 4)
    {
      paramString1.setVisibility(i1);
      if (this.jdField_e_of_type_Boolean != paramBoolean)
      {
        this.jdField_e_of_type_Boolean = paramBoolean;
        paramString1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        if (!paramBoolean) {
          break label229;
        }
        paramString1.addRule(2, 0);
        paramString1.addRule(13);
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      i1 = 0;
      break;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label88;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      break label121;
    }
    label229:
    paramString1.addRule(2, 2131300064);
    paramString1.addRule(13, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLine1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLine1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      label43:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLine2)) {
        break label219;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLine2);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label78:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLineLink)) {
        break label231;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLineLink);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.scanLinkUrl;
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.addRule(2, 2131300064);
        localLayoutParams.addRule(13, 0);
      }
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a("CliOper", "", "", "0X80069D2", "0X80069D2", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(), "", "");
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label43;
      label219:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label78;
      label231:
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296895));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297082));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297139));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297083));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302122));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302123));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302124));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300070));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300067));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300071));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300068));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131302125));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131302121));
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanTorchViewFinder = ((ScanTorchViewFinder)super.findViewById(2131302120));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131302126));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131302127));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131302130));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131297388));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302128));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302129));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302132));
    this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302133));
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("扫一扫");
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    g();
    i();
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      findViewById(2131300060).setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString))
    {
      int i1 = AIOUtils.a(55.0F, getResources());
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130840982);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
    }
    try
    {
      localObject = URLDrawable.getDrawable(this.jdField_j_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(new trv(this));
        this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanTorchViewFinder.post(new trw(this));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Olympic.ScanTorchActivity", 2, "initView, setIconDrawable", localException);
          localException.printStackTrace();
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840982);
        continue;
        this.jdField_j_of_type_AndroidWidgetTextView.setText("QQ-AR");
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanTorchViewFinder.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2131427379);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    int i1 = AIOUtils.a(15.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(i1, i1, i1, 0);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanTorchViewFinder.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      localLayoutParams.addRule(2, 2131300064);
      localLayoutParams.addRule(13, 0);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanTorchViewFinder.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130840983);
    int i1 = AIOUtils.a(15.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.bottomMargin = i1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(i1, i1, i1, AIOUtils.a(7.0F, getResources()));
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanTorchViewFinder.b();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      localLayoutParams.addRule(2, 2131300064);
      localLayoutParams.addRule(13, 0);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARFragment != null) {}
    do
    {
      return;
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      this.jdField_a_of_type_ComTencentMobileqqArARFragment = ARFragment.a(this.jdField_a_of_type_ComTencentMobileqqArARArguments, this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo);
      localFragmentTransaction.add(2131302119, this.jdField_a_of_type_ComTencentMobileqqArARFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_a_of_type_ComTencentMobileqqArARFragment.a(this);
    } while (this.jdField_d_of_type_Long >= 0L);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a())
    {
      e();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(292);
  }
  
  private void g()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScanTorchActivity", 2, "showTouchView");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (this.jdField_a_of_type_ComTencentMobileqqArARTarget.a != null))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_j_of_type_JavaLangString)) {
        a(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.k, null, null);
      }
      return;
    }
    QLog.d("Olympic.ScanTorchActivity", 1, "mArTarget == null || mArTarget.arResourceInfo == null");
  }
  
  private void i()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void j()
  {
    Intent localIntent = getIntent();
    HashMap localHashMap;
    if ((localIntent != null) && (this.jdField_b_of_type_Long > 0L) && (this.jdField_d_of_type_Long > 0L) && (this.jdField_c_of_type_Long > 0L))
    {
      localHashMap = new HashMap();
      if (!localIntent.getBooleanExtra("proc_exist", false)) {
        break label234;
      }
      str = "1";
      localHashMap.put("proc_exist", str);
      if (!localIntent.getBooleanExtra("first_click", false)) {
        break label241;
      }
    }
    label234:
    label241:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("first_click", str);
      localHashMap.put("rcv_kill_broadcast", String.valueOf(this.q));
      long l1 = localIntent.getLongExtra("click_time", 0L);
      long l2 = this.jdField_b_of_type_Long;
      long l3 = this.jdField_c_of_type_Long - this.jdField_d_of_type_Long;
      long l4 = this.jdField_d_of_type_Long;
      localHashMap.put("time_oncreate", String.valueOf(l2 - l1));
      localHashMap.put("time_ar_ready", String.valueOf(l3));
      localHashMap.put("time_add_fragment", String.valueOf(l4 - l1));
      StatisticCollector.a(this).a("", "olympic_tool_proc_report", true, l3, 0L, localHashMap, "", true);
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.ScanTorchActivity", 2, new Object[] { "doReport, params=", localHashMap });
      }
      return;
      str = "0";
      break;
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScanTorchActivity", 2, "hideArProgress");
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Olympic.ScanTorchActivity", 2, localException.toString());
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_c_of_type_Long < 0L) {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.ScanTorchActivity", 2, "onArReady success");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(295);
      return;
    case 1: 
      if (this.jdField_c_of_type_Long < 0L) {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.ScanTorchActivity", 2, "onArReady open camera failed.");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(294);
      return;
    }
    if (this.jdField_c_of_type_Long < 0L) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScanTorchActivity", 2, "onArReady start ar failed.");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(296);
  }
  
  public void a(int paramInt, ARTarget paramARTarget)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScanTorchActivity", 2, new Object[] { "onARStateChanged, state=", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.o = paramInt;
      return;
      if ((paramARTarget == null) || (paramARTarget.a == null)) {
        QLog.d("Olympic.ScanTorchActivity", 1, "onARStateChanged, ARListener.AR_STATE_TRACKED, arTarget or arTarget.arResourceInfo is null");
      } else if (QLog.isColorLevel()) {
        QLog.d("Olympic.ScanTorchActivity", 2, new Object[] { "Olympic.ScanTorchActivity", "onARStateChanged, mLastArState=", Integer.valueOf(this.o), ", newState=", Integer.valueOf(paramInt), ", targetId=", paramARTarget.a.jdField_c_of_type_JavaLangString, ", type=", Integer.valueOf(paramARTarget.a.jdField_c_of_type_Int) });
      }
    }
  }
  
  public void a(Uri paramUri)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = paramUri;
      if (paramUri == null) {
        localObject = "null";
      }
      QLog.d("Olympic.ScanTorchActivity", 2, new Object[] { "onDetectScreenshot, uri=", localObject });
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a("CliOper", "", "", "0X8006ABD", "0X8006ABD", 0, 0, "1", "", "", "");
  }
  
  public void b(int paramInt, ARTarget paramARTarget)
  {
    if ((paramARTarget == null) || (paramARTarget.a == null))
    {
      QLog.d("Olympic.ScanTorchActivity", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Olympic.ScanTorchActivity", 2, new Object[] { "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(this.p), ", newState=", Integer.valueOf(paramInt) });
    }
    this.p = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramARTarget;
      this.jdField_a_of_type_AndroidOsHandler.post(new trx(this));
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a("CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(), paramARTarget.a.jdField_c_of_type_JavaLangString, "2");
      return;
    case 1: 
      this.jdField_a_of_type_AndroidOsHandler.post(new try(this));
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a("CliOper", "", "", "0X80069CF", "0X80069CF", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(), paramARTarget.a.jdField_c_of_type_JavaLangString, "");
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
    this.jdField_a_of_type_AndroidOsHandler.post(new trz(this));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a("CliOper", "", "", "0X80069D0", "0X80069D0", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(), paramARTarget.a.jdField_c_of_type_JavaLangString, "");
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Olympic.ScanTorchActivity", 2, "doOnBackPressed");
    }
    setResult(11);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Olympic.ScanTorchActivity", 2, "doOnCreate");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    getWindow().addFlags(128);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(ArConfigInfo.class.getClassLoader());
      super.doOnCreate(paramBundle);
      super.setContentView(2130904271);
      a();
      b();
      if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null)
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq__alive");
        registerReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver, paramBundle);
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver = new ScreenshotObserver(this.jdField_a_of_type_AndroidOsHandler, this);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.a(this);
      a("正在加载...");
      return true;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("Olympic.ScanTorchActivity", 2, "e= " + paramBundle.getMessage());
      }
      this.jdField_a_of_type_MqqAppQQBroadcastReceiver = null;
      super.finish();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Olympic.ScanTorchActivity", 2, "doOnDestroy");
    }
    try
    {
      if (this.jdField_a_of_type_MqqAppQQBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_a_of_type_MqqAppQQBroadcastReceiver);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      j();
    }
    catch (Exception localException1)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.a();
        }
        super.doOnDestroy();
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Olympic.ScanTorchActivity", 2, "e= " + localException2.getMessage());
          }
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Olympic.ScanTorchActivity", 2, "doOnPause");
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Olympic.ScanTorchActivity", 2, "doOnResume");
    }
    if (!this.jdField_d_of_type_Boolean) {
      c();
    }
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Olympic.ScanTorchActivity", 2, "doOnCreate");
    }
    super.doOnStart();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.a();
    }
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Olympic.ScanTorchActivity", 2, "doOnStop");
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a("CliOper", "", "", "0X80069CB", "0X80069CB", 0, 0, "1", String.valueOf(l1 - l2), "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScreenshotObserver.b();
    }
    super.doOnStop();
  }
  
  protected String getModuleId()
  {
    return "module_olympic";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      k();
      continue;
      k();
      a("打开摄像头失败", "请允许QQ访问摄像头并稍后重试", null, null);
      continue;
      a(false);
      k();
      continue;
      k();
      a("启动AR失败", "无法加载核心库", null, null);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131300070: 
    default: 
    case 2131297083: 
    case 2131302124: 
    case 2131300067: 
    case 2131302125: 
      do
      {
        do
        {
          return;
          doOnBackPressed();
          return;
          if (QLog.isColorLevel()) {
            QLog.i("Olympic.ScanTorchActivity", 2, "onClick R.id.text_help");
          }
        } while (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString));
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_h_of_type_JavaLangString);
        startActivity(paramView);
        this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a("CliOper", "", "", "0X80069D3", "0X80069D3", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(), "", "");
        return;
        paramView = new Intent(this, ScannerActivity.class);
        paramView.addFlags(67108864);
        paramView.putExtra("from", ScanTorchActivity.class.getSimpleName());
        startActivity(paramView);
        overridePendingTransition(0, 0);
        finish();
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArARTarget != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.m)))
        {
          this.jdField_a_of_type_ComTencentMobileqqArARFragment.a();
          setResult(11);
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.m);
          startActivity(paramView);
          i();
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqArARTarget == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_c_of_type_JavaLangString)));
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a("CliOper", "", "", "0X80069D1", "0X80069D1", 0, 0, "1", this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqArARTarget.a.jdField_c_of_type_JavaLangString, "");
      return;
    case 2131302133: 
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a()))
      {
        QQToast.a(this, 0, 2131369830, 0).a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 2131302132: 
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicToolAppInterface.a()))
      {
        QQToast.a(this, 0, 2131369830, 0).a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.c();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArRemoteArConfigManager.b();
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\activity\ScanTorchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */