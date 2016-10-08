package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.dataline.util.file.FileUtil;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.MusicCacheManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridgeUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.GuideViewBuilder;
import com.tencent.mobileqq.widget.GuideViewBuilder.GuideLayoutParams;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CacheManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.Vector;
import mgg;
import mgh;
import mgj;
import mgk;
import mgl;
import mgm;
import mgn;
import mgo;
import mgp;
import mgr;
import mgt;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QQSettingMsgHistoryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, CompoundButton.OnCheckedChangeListener
{
  static final int jdField_a_of_type_Int = 1;
  static final int jdField_b_of_type_Int = 1000;
  static final int jdField_c_of_type_Int = 0;
  static final String jdField_c_of_type_JavaLangString = "http://imgcache.qq.com/qqshow/admindata/comdata/chatHistoryEvent/xydata.json";
  static final int jdField_d_of_type_Int = 1;
  public static final String d;
  static final int jdField_e_of_type_Int = 2;
  static final String jdField_e_of_type_JavaLangString = "chatHistoryEventJsonLastModified";
  static final int jdField_f_of_type_Int = 1;
  static final String jdField_f_of_type_JavaLangString = "chatHistoryEventName";
  static final int jdField_g_of_type_Int = 0;
  static final String jdField_g_of_type_JavaLangString = "chatHistoryEventEntryFirstShow";
  static final int jdField_h_of_type_Int = 0;
  static final String jdField_h_of_type_JavaLangString = "URL";
  static final String i = "EventName";
  static final String j = "EndTime";
  static final String k = "isShow";
  static final String l = "new_guide";
  private long jdField_a_of_type_Long;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mgj(this);
  public RedTouch a;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public DownloadListener a;
  public FormSimpleItem a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  public String a;
  boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String b;
  private View jdField_c_of_type_AndroidViewView;
  private View jdField_d_of_type_AndroidViewView;
  private String m = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_d_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "ChatHistoryEventConfig.json";
  }
  
  public QQSettingMsgHistoryActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new mgn(this);
    this.jdField_a_of_type_AndroidOsHandler = new mgp(this);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    try
    {
      Intent localIntent = new Intent("qqplayer_exit_action");
      localIntent.putExtra("musicplayer.isDelFileOnDonwloadThreadOver", true);
      paramQQAppInterface.getApplication().getApplicationContext().sendBroadcast(localIntent);
      QZoneHelper.a(paramQQAppInterface.getApplication().getApplicationContext(), paramQQAppInterface.a());
      a(paramQQAppInterface.f(), false);
      a(paramQQAppInterface);
      c();
      b(paramQQAppInterface);
      MusicCacheManager.a();
      if (paramActivity != null) {
        QfavHelper.a(paramActivity, paramQQAppInterface.a());
      }
      ArkAppCenter.e();
      SwiftWebViewHttpBridgeUtils.a();
      PublicAccountJavascriptInterface.deleteAllH5Data(paramQQAppInterface);
      FileUtil.a(new File(PublicAccountJavascriptInterface.jdField_d_of_type_JavaLangString + "/" + HexUtil.b(paramQQAppInterface.getAccount())));
      FileUtil.a(new File(AppConstants.bh + "/" + "tencent/MobileQQ/qbiz/"));
      FileUtil.a(new File(AppConstants.cW));
      paramActivity = CacheManager.getCacheFileBaseDir();
      if (paramActivity != null) {
        FileUtil.a(paramActivity);
      }
      ShortVideoUtils.a();
      paramActivity = new File(AppConstants.cY);
      if (paramActivity.exists()) {
        FileUtil.a(paramActivity);
      }
      if (!paramActivity.exists()) {
        paramActivity.mkdirs();
      }
      paramActivity = new File(AppConstants.bD);
      if (paramActivity.exists()) {
        FileUtil.a(paramActivity);
      }
      paramActivity = new File(AppConstants.bE);
      if (paramActivity.exists()) {
        FileUtil.a(paramActivity);
      }
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AssitantSettingActivity", 2, "deleteOfflineData got exception:" + paramActivity.getMessage());
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.a() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    c(Utils.a(BaseApplication.getContext()) + "thumbnails/");
  }
  
  private void a(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.z == 0) && (this.app != null))
    {
      this.app.getPreferences().edit().putLong("chatHistoryEventJsonLastModified", paramDownloadTask.i).commit();
      if ((200 == paramDownloadTask.D) || (304 == paramDownloadTask.D)) {
        ThreadManager.a().post(new mgo(this));
      }
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(jdField_d_of_type_JavaLangString);
      long l1 = 0L;
      if (localFile.exists()) {
        l1 = localFile.lastModified();
      }
      QLog.d("IphoneTitleBarActivity", 2, "onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.z + "," + "httpCode=" + paramDownloadTask.D + ",local lastModify=" + l1 + ",server lastModify=" + paramDownloadTask.i);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      c(AppConstants.bj + paramString + "/" + "photo/");
    }
    int n = 0;
    while (n < CardHandler.a.size())
    {
      c(CardHandler.c + ((Integer)CardHandler.a.get(n)).intValue() + "/");
      n += 1;
    }
    c(CardHandler.c + "background" + "/");
    c(AppConstants.bj + "temp" + "/");
    c(CardHandler.c + "temp" + "/");
    c(CardHandler.c + "HDAvatar" + "/");
    c(AppConstants.cM);
    c(CardHandler.c + "voice" + "/");
    c(GCCommon.a() + "/");
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (URLDrawableHelper.a != null)
    {
      c(URLDrawableHelper.a.getAbsolutePath());
      paramQQAppInterface = paramQQAppInterface.a();
      if ((paramQQAppInterface instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl localBaseApplicationImpl = (BaseApplicationImpl)paramQQAppInterface;
        if (BaseApplicationImpl.a != null)
        {
          paramQQAppInterface = (BaseApplicationImpl)paramQQAppInterface;
          BaseApplicationImpl.a.evictAll();
        }
      }
    }
  }
  
  static void c()
  {
    c(AppConstants.bj + "photo/");
  }
  
  private static void c(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int n = 0;
        while (n < paramString.length)
        {
          boolean bool = paramString[n].delete();
          if (QLog.isColorLevel())
          {
            QLog.d("AvatarUtil", 2, "path: " + paramString[n].getAbsolutePath());
            QLog.d("AvatarUtil", 2, "ret : " + bool);
          }
          n += 1;
        }
      }
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302411));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    ThreadManager.b().post(new mgm(this));
  }
  
  private void g()
  {
    int n = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.a(), 0);
    Object localObject = null;
    switch (n)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      }
      break;
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject = getResources().getString(2131368136);
      break;
      localObject = getResources().getString(2131368135);
      break;
      localObject = getResources().getString(2131368134);
      break;
      localObject = getResources().getString(2131368133);
      break;
    }
    QLog.d("QQSettingMsgHistoryActivity", 2, "messge roam flag is error ,is : " + n);
  }
  
  private void h()
  {
    c(AppConstants.bj + this.m + "/" + "ptt/");
  }
  
  private void i()
  {
    try
    {
      this.app.a().f();
      this.app.a().g();
      this.app.a().h();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 8)) {}
    RedTouchManager localRedTouchManager;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      localAppInfo = localRedTouchManager.a("100190.100194.100195");
    } while (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    localRedTouchManager.a(localAppInfo);
  }
  
  public void a()
  {
    this.app.a().g();
    a(this.m, true);
    h();
    c();
    i();
    b(this.app);
    b();
    MqqHandler localMqqHandler = this.app.a(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void a(String paramString)
  {
    if (this.app.getPreferences().getBoolean("chatHistoryEventEntryFirstShow", true))
    {
      ThreadManager.b().post(new mgg(this));
      GuideViewBuilder localGuideViewBuilder = new GuideViewBuilder(this);
      localGuideViewBuilder.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 0);
      localGuideViewBuilder.a(0, new mgk(this));
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      View localView = new View(this);
      localView.setBackgroundResource(2130840954);
      GuideViewBuilder.GuideLayoutParams localGuideLayoutParams1 = new GuideViewBuilder.GuideLayoutParams((int)(17.0F * localDisplayMetrics.density), (int)(31.0F * localDisplayMetrics.density), 48);
      localGuideLayoutParams1.c = 100;
      localGuideLayoutParams1.d = (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getMeasuredHeight() + 18);
      TextView localTextView = new TextView(this);
      GuideViewBuilder.GuideLayoutParams localGuideLayoutParams2 = new GuideViewBuilder.GuideLayoutParams(-2, -2, 48);
      localTextView.setText(paramString);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setGravity(17);
      localTextView.setMaxWidth((int)(localDisplayMetrics.density * 240.0F));
      localGuideLayoutParams2.c = 50;
      localGuideLayoutParams2.d = (localGuideLayoutParams1.d + localGuideLayoutParams1.height + 18);
      localGuideViewBuilder.a(0, localView, localGuideLayoutParams1);
      localGuideViewBuilder.a(0, localTextView, localGuideLayoutParams2);
      localGuideViewBuilder.a(new mgl(this));
    }
  }
  
  void b()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(91);
    localMessageRoamManager.i();
    localMessageRoamManager.b();
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void d()
  {
    ((RedTouchManager)this.app.getManager(35)).b("100190.100194.100195");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      startActivity(localIntent);
      VipUtils.a(this.app, "chat_history", "Setting_tab", "Clk_ChatHistoryRed", 0, 0, null);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904348);
    setTitle(2131370975);
    this.m = this.app.a();
    setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302412));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.app.f() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setChecked(bool);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131302414);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131302415);
      this.c = findViewById(2131302416);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131302417);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302413));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (!JumpQqPimSecureUtil.a(this)) {
        break;
      }
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_installed_secure", 0, 0, null);
      return true;
    }
    VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_not_intalled_secure", 0, 0, null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.jdField_a_of_type_Boolean) {
      f();
    }
  }
  
  protected void doOnResume()
  {
    j();
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    g();
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int i1 = 1;
    if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131369008, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      paramBoolean = bool;
      if (this.app.f() == 1) {
        paramBoolean = true;
      }
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
    paramCompoundButton = this.app;
    if (paramBoolean)
    {
      n = 1;
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, n, "0", "0", "", "");
      b(getApplication().getResources().getString(2131370422));
      if (!paramBoolean) {
        break label158;
      }
    }
    label158:
    for (int n = i1;; n = 0)
    {
      this.app.g(n);
      return;
      n = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = null;
    if (paramView.getId() == 2131302417) {
      startActivity(new Intent(this, QQSpaceCleanActivity.class));
    }
    long l1;
    long l2;
    do
    {
      return;
      if (paramView.getId() == 2131302413)
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "http://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123&ADTAG=msgRoam");
        startActivity(paramView);
        VipUtils.a(this.app, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 2, 0, new String[] { "0", "0", "msgRoam" });
        return;
      }
      if (paramView.getId() == 2131302411)
      {
        d();
        return;
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((isFinishing()) || (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int n;
    int i1;
    switch (paramView.getId())
    {
    default: 
      n = 0;
      i1 = 0;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localActionSheet.a(i1, 3, false);
      localActionSheet.d(getString(2131367262));
      localActionSheet.a(paramView);
      localActionSheet.a(n);
      localActionSheet.show();
      return;
      i1 = 2131369619;
      n = 2131369639;
      paramView = new mgr(this, localActionSheet);
      continue;
      i1 = 2131369621;
      n = 2131369638;
      paramView = new mgt(this, localActionSheet);
      continue;
      i1 = 2131369620;
      n = 2131370976;
      paramView = new mgh(this, localActionSheet);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131368310));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected String setLastActivityName()
  {
    return getString(2131367904);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQSettingMsgHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */