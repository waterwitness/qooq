package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.LebaItemFilter;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.ViewHolder;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

public class LebaEnabledPluginsActivity
  extends IphoneTitleBarActivity
  implements LebaListMgrAdapter.LebaItemFilter, AdapterView.OnItemClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  char jdField_a_of_type_Char;
  private LebaListMgrAdapter jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public LebaEnabledPluginsActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
    paramView = new Intent(this, LebaSearchPluginManagerActivity.class);
    paramView.putExtra("id", paramAdapterView.a.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId);
    startActivityForResult(paramView, 1);
  }
  
  public boolean a(LebaViewItem paramLebaViewItem)
  {
    return (paramLebaViewItem != null) && (paramLebaViewItem.jdField_a_of_type_Byte == 0) && (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != 3050L);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Char = this.app.a().getSharedPreferences("now_tab_sp", 0).getString("now_show_key" + this.app.a(), "00000").charAt(2);
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2130904207, null));
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter = new LebaListMgrAdapter(this.app, this, LebaShowListManager.a().a(), this, null);
    }
    super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter);
    setTitle(2131368197);
    return true;
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
    setResult(-1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\LebaEnabledPluginsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */