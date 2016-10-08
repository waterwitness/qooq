package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.adapter.TroopListAdapterOfContactsMode;
import com.tencent.mobileqq.adapter.TroopListAdapterOfContactsMode.OnTroopListClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.OverScrollViewListener;
import java.util.List;
import vdk;
import vdl;
import vdm;
import vdn;

public class ContactsTroopActivity
  extends IphoneTitleBarActivity
  implements TroopListAdapterOfContactsMode.OnTroopListClickListener
{
  private static final int jdField_a_of_type_Int = 100;
  public static final String a = "need_pull_troop_contacts_mode";
  private static final int jdField_b_of_type_Int = 101;
  private static final String jdField_b_of_type_JavaLangString = "ContactsTroopView";
  private static final int jdField_c_of_type_Int = 102;
  private static final String jdField_c_of_type_JavaLangString = "Contacts_Mode_GuideTips_value";
  private static final int jdField_d_of_type_Int = 1000;
  private static final String jdField_d_of_type_JavaLangString = "last_contacts_troop_list_refresh_time";
  private static final int e = 800;
  private static final int f = 1200;
  private static final int g = 1;
  public Handler a;
  public TroopListAdapterOfContactsMode a;
  protected ContactsTroopActivity.MyTroopObserver a;
  public HttpWebCgiAsyncTask.Callback a;
  public PullRefreshHeader a;
  public SlideDetectListView a;
  protected OverScrollViewListener a;
  boolean jdField_a_of_type_Boolean;
  
  public ContactsTroopActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityContactsTroopActivity$MyTroopObserver = new ContactsTroopActivity.MyTroopObserver(this);
    this.jdField_a_of_type_AndroidOsHandler = new vdk(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new vdl(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new vdm(this);
  }
  
  private long a()
  {
    return getSharedPreferences("last_contacts_troop_list_refresh_time", 0).getLong("last_contacts_troop_list_refresh_time", 0L);
  }
  
  private boolean a()
  {
    if (NetworkUtil.e(this))
    {
      ((TroopHandler)this.app.a(20)).a();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    getSharedPreferences("last_contacts_troop_list_refresh_time", 0).edit().putLong("last_contacts_troop_list_refresh_time", l).commit();
  }
  
  void a()
  {
    setContentView(2130905055);
    setTitle(2131367931);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131305140));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode = new TroopListAdapterOfContactsMode(this, this.app, this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode);
    }
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode.a().size() == 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X8005B3A", "0X8005B3A", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode.b() != null) {
      ReportController.b(this.app, "CliOper", "", "", "0X8005B3B", "0X8005B3B", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode.b() == null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode.c() != null)) {
      ReportController.b(this.app, "CliOper", "", "", "0X8005B3C", "0X8005B3C", 0, 0, "", "", "", "");
    }
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, getString(2131367481), 0).b(getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopView", 2, "切换成通讯录模式 troopuin: " + paramTroopInfo.troopuin);
    }
    ThreadManager.a(new vdn(this, paramTroopInfo), 5, null, false);
    ReportController.b(this.app, "CliOper", "", "", "0X8005B3E", "0X8005B3E", 0, 0, "", "", "", "");
  }
  
  public void a(TroopInfo paramTroopInfo, int paramInt)
  {
    Intent localIntent = new Intent(this, TroopMemberListActivity.class);
    localIntent.putExtra("troop_uin", paramTroopInfo.troopuin);
    localIntent.putExtra("param_from", 0);
    localIntent.putExtra("selfSet_leftViewText", getString(2131367975));
    localIntent.putExtra("custom_title_name", paramTroopInfo.troopname);
    if (paramInt == 3)
    {
      paramTroopInfo = this.app.a().getSharedPreferences(this.app.a(), 0);
      if (!paramTroopInfo.getBoolean("Contacts_Mode_GuideTips_value", false))
      {
        paramTroopInfo.edit().putBoolean("Contacts_Mode_GuideTips_value", true).commit();
        localIntent.putExtra("Show_Newer_GuideFlag_Of_ContactsMode", true);
      }
    }
    startActivityForResult(localIntent, 1);
    ReportController.b(this.app, "CliOper", "", "", "0X8005B3D", "0X8005B3D", 0, 0, "", "", "", "");
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode.notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode.a().size() == 0)
      {
        ((RelativeLayout)findViewById(2131297950)).setVisibility(8);
        ((LinearLayout)findViewById(2131305141)).setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.i("ContactsTroopView", 2, "没有需要显示的列表 显示引导图片");
        }
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    b();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityContactsTroopActivity$MyTroopObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode.b();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopActivityContactsTroopActivity$MyTroopObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\ContactsTroopActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */