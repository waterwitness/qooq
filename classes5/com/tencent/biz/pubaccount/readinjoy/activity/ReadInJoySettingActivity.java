package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.react.ReactInstanceManager;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyRNManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import cooperation.readinjoy.ReadInJoyHelper;
import hwv;
import hww;
import hwx;
import hwy;
import hwz;
import hxa;
import hxb;
import hxc;
import hxd;
import hxe;
import hxf;
import hxg;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a;
  public static final String b = "ReadInJoySettingActivity";
  public int a;
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new hwy(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  public ReadInjoyRNManager a;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  public QQAppInterface a;
  public QQProgressDialog a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int = 2;
  private View jdField_b_of_type_AndroidViewView;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  public boolean b;
  private ActionSheet jdField_c_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private String jdField_c_of_type_JavaLangString = "QQ看点";
  public boolean c;
  private final String jdField_d_of_type_JavaLangString = "关闭后你将不再收到看点的精选推荐，已订阅内容的提醒将不受影响";
  private boolean jdField_d_of_type_Boolean;
  private final String jdField_e_of_type_JavaLangString = "关闭后你将不再收到看点的精选推荐，已订阅内容的提醒将不受影响";
  private boolean jdField_e_of_type_Boolean;
  private final String jdField_f_of_type_JavaLangString = "根据你的兴趣爱好，为你推荐最想看的资讯：新闻时事、娱乐八卦、科技动漫、文化历史……你想看的，尽在%s。";
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = "接收看点推荐";
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = "置顶%s";
  private boolean jdField_h_of_type_Boolean;
  private final String i = "关闭看点推荐";
  private final String j = "启用%s";
  private final String k = "停用%s";
  private final String l = "停用%s后将无法接收看点及订阅内容的消息及提醒";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AppConstants.aZ;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    PublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localPublicAccountConfigFolder != null) && (localPublicAccountConfigFolder.a() != null)) {
      return localPublicAccountConfigFolder.a();
    }
    return PublicAccountConfigUtil.a(this.jdField_a_of_type_AndroidContentContext, 3);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
      setTitle("设置");
      this.leftView.setContentDescription("返回");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d();
      this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_kandian_download_pic_flag", false);
      boolean bool;
      if (!ReadInJoyHelper.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        bool = true;
        label132:
        this.jdField_g_of_type_Boolean = bool;
      }
      try
      {
        if (ReadInJoyUtils.b() != null) {
          this.jdField_b_of_type_Int = Integer.parseInt(ReadInJoyUtils.b());
        }
        this.jdField_c_of_type_JavaLangString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
        Object localObject = a();
        ((ImageView)findViewById(2131296790)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131298586);
        ((TextView)localObject).setText(this.jdField_c_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_c_of_type_JavaLangString);
        localObject = (TextView)findViewById(2131299943);
        ((TextView)localObject).setText(String.format("根据你的兴趣爱好，为你推荐最想看的资讯：新闻时事、娱乐八卦、科技动漫、文化历史……你想看的，尽在%s。", new Object[] { this.jdField_c_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format("根据你的兴趣爱好，为你推荐最想看的资讯：新闻时事、娱乐八卦、科技动漫、文化历史……你想看的，尽在%s。", new Object[] { this.jdField_c_of_type_JavaLangString }));
        e(this.jdField_g_of_type_Boolean);
        localObject = (TextView)findViewById(2131299953);
        ((TextView)localObject).setText("接收看点推荐");
        ((TextView)localObject).setContentDescription("接收看点推荐");
        localObject = (TextView)findViewById(2131299955);
        ((TextView)localObject).setText(String.format("关闭后你将不再收到看点的精选推荐，已订阅内容的提醒将不受影响", new Object[] { this.jdField_c_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format("关闭后你将不再收到看点的精选推荐，已订阅内容的提醒将不受影响", new Object[] { this.jdField_c_of_type_JavaLangString }));
        c();
        b();
        b(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131299954));
        this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new hwv(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new hwz(this));
        this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131299948));
        this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
        this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new hxa(this));
        this.jdField_b_of_type_AndroidViewView = findViewById(2131299947);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        findViewById(2131299949).setOnClickListener(this);
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131362989), this.jdField_a_of_type_AndroidContentResResources.getString(2131362990), this.jdField_a_of_type_AndroidContentResResources.getString(2131362991) };
        ((TextView)findViewById(2131299950)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_b_of_type_Int]);
        bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_AndroidViewView = findViewById(2131296808);
        if (bool) {
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
        }
        while (!SharedPreUtils.e(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyRNManager = new ReadInjoyRNManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyRNManager;
          ReadInjoyRNManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 35, 1);
          return;
          bool = false;
          break label132;
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    a(2131362996);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "set_message_configuration");
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(PublicAccountUtil.a());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.setObserver(new hxb(this, paramBoolean));
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      localSetMessageConfigurationRequest.type.set(2);
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showConfirmDialog");
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    String str = String.format("关闭后你将不再收到看点的精选推荐，已订阅内容的提醒将不受影响", new Object[] { this.jdField_c_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(str);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("关闭看点推荐", 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new hxd(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new hxe(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "createVideoActionSheet");
    }
    if (this.jdField_c_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    this.jdField_c_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131362989), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131362990), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131362991), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.e(paramInt);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(new hww(this));
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(new hwx(this));
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      ReportController.b(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", ReadInJoyUtils.c());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(paramBoolean);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    String str = String.format("停用%s后将无法接收看点及订阅内容的消息及提醒", new Object[] { this.jdField_c_of_type_JavaLangString });
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(str);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(String.format("停用%s", new Object[] { this.jdField_c_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new hxf(this));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new hxg(this));
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      ReportController.b(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", ReadInJoyUtils.c());
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoyHelper.a(localQQAppInterface, bool);
      this.jdField_d_of_type_Boolean = paramBoolean;
      a(this.jdField_d_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      e(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      ReportController.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", ReadInJoyUtils.c());
    e(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131299944);
    TextView localTextView = (TextView)findViewById(2131299940);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText("已启用");
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText("已停用");
  }
  
  protected void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.postDelayed(new hxc(this, paramInt), 500L);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903754);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    a();
    this.jdField_h_of_type_Boolean = false;
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if ((this.jdField_b_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    }
    if ((RNPreDownloadFacade.a()) && (ReactInstanceManager.mReactInstanceManager != null)) {
      BitAppInstanceManager.getInstance().onDestroy();
    }
    if ((this.jdField_c_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_c_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_c_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_c_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyRNManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyRNManager.onDestroy();
    }
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_h_of_type_Boolean)
    {
      QLog.d("ReadInJoySettingActivity", 1, "refresh channel list while leave interest label");
      ReadInJoyLogicEngine.a().a(2, 1);
      this.jdField_h_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131299948: 
    default: 
      return;
    case 2131299947: 
      this.jdField_h_of_type_Boolean = true;
      ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReadInJoyActivityHelper.a(this);
      ReportController.b(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", ReadInJoyUtils.c());
      return;
    }
    this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\activity\ReadInJoySettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */