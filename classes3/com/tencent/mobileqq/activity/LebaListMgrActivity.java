package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.LebaItemFilter;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.LebaPluginStateListener;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.ViewHolder;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import lrw;
import lrx;
import lrz;
import lsa;
import lsc;
import lse;
import lsg;

public class LebaListMgrActivity
  extends IphoneTitleBarActivity
  implements LebaListMgrAdapter.LebaItemFilter, LebaListMgrAdapter.LebaPluginStateListener, AdapterView.OnItemClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 500L;
  private static final int b = 2;
  char jdField_a_of_type_Char;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LebaListMgrAdapter jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter;
  protected RedTouchObserver a;
  public DownloadIconsListener a;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean;
  
  public LebaListMgrActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new lrz(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new lsa(this);
    this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver = new lsc(this);
    this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener = new lse(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2130904207, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      View localView = View.inflate(this, 2130904206, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297123));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368195);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localView, null, false);
      localView = View.inflate(this, 2130904205, null);
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131298128);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new lrw(this));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838349);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131298129).setVisibility(8);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298131)).setText(2131368196);
      this.jdField_a_of_type_ComTencentWidgetXListView.b(localView, null, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter = new LebaListMgrAdapter(this.app, this, LebaShowListManager.a().a(), this, this);
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver.onChanged();
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter);
    setTitle(2131368194);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "initUi, " + LebaShowListManager.a().jdField_a_of_type_Boolean);
    }
    this.app.o();
    if (!LebaShowListManager.a().jdField_a_of_type_Boolean) {
      ThreadManager.a(new lrx(this), 5, null, true);
    }
  }
  
  public void a(LebaViewItem paramLebaViewItem)
  {
    if (paramLebaViewItem != null) {
      QQToast.a(this, 2, "成功开启" + paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      paramView.postDelayed(new lsg(this), 500L);
      paramAdapterView = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
      if (paramAdapterView != null) {
        break label41;
      }
    }
    label41:
    LebaViewItem localLebaViewItem;
    do
    {
      return;
      localLebaViewItem = paramAdapterView.a;
    } while ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null));
    paramInt = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.sResSubType;
    Object localObject = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strGotoUrl;
    String str = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName;
    if (paramInt == 0)
    {
      paramAdapterView = (AdapterView)localObject;
      if (((String)localObject).contains("plg_uin=1")) {
        paramAdapterView = (String)localObject + "&mqquin=" + this.app.a();
      }
      localObject = paramAdapterView;
      if (paramAdapterView.contains("plg_vkey=1")) {
        localObject = paramAdapterView + "&mqqvkey=" + this.app.e();
      }
      paramAdapterView = new Intent(this, LebaSearchMoreInfoActivity.class);
      if (((String)localObject).contains("plg_nld=1")) {
        paramAdapterView.putExtra("reportNld", true);
      }
      paramAdapterView.putExtra("uin", this.app.a());
      paramAdapterView.putExtra("plugin_start_time", System.nanoTime());
      paramAdapterView.putExtra("click_start_time", System.currentTimeMillis());
      paramAdapterView.putExtra("url", (String)localObject);
      paramAdapterView.putExtra("id", localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId);
      paramAdapterView.putExtra("title", str);
      startActivityForResult(paramAdapterView, 2);
      if ((paramView instanceof RedTouch)) {
        ((RedTouch)paramView).b();
      }
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)
      {
        paramView = (RedTouchManager)this.app.getManager(35);
        if (localLebaViewItem.jdField_a_of_type_Byte != 0) {
          break label536;
        }
      }
    }
    for (paramAdapterView = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "";; paramAdapterView = "100600." + (100000000L + paramLong))
    {
      paramView.b(paramAdapterView);
      ReportController.b(this.app, "CliOper", "", "", "0X8004D99", "0X8004D99", 0, 0, "" + localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, "", "", "");
      return;
      if (paramInt != 2) {
        break;
      }
      paramAdapterView = JumpParser.a(this.app, this, (String)localObject);
      if (paramAdapterView == null) {
        break;
      }
      if ((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName.equals("com.tx.gamecenter.android")) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName.contains(this.app.a().getResources().getString(2131369269)))) {
        paramAdapterView.c("platformId=qq_m");
      }
      paramAdapterView.b(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
      paramAdapterView.a("from_leba_mgr", "fromlebamgr");
      paramAdapterView.b();
      break;
      label536:
      paramLong = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
    }
  }
  
  public boolean a(LebaViewItem paramLebaViewItem)
  {
    return (paramLebaViewItem != null) && (paramLebaViewItem.jdField_a_of_type_Byte != 0) && (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 3050L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LebaShowListManager.d |= 0x1;
    this.jdField_a_of_type_Char = this.app.a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.app.a(), "00000").charAt(2);
    a();
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver, true);
    paramBundle = this.app.a();
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter = null;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppRedTouchObserver);
    LebaHelper localLebaHelper = this.app.a();
    if (localLebaHelper != null) {
      localLebaHelper.b(this.jdField_a_of_type_ComTencentMobileqqConfigDownloadIconsListener);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (-1 == paramInt2) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter.a(LebaShowListManager.a().a());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\LebaListMgrActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */