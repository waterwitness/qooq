package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqi;
import mqj;
import mqm;
import mqo;

public class TroopGagActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  static final String jdField_a_of_type_JavaLangString = "TroopGagActivity";
  public View a;
  public LinearLayout a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  public Switch a;
  public XListView a;
  public List a;
  public mqo a;
  LinearLayout b;
  public String b;
  
  public TroopGagActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new mqj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new mqm(this);
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator))
      {
        arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.split("\\|");
        bool1 = bool2;
        if (arrayOfString != null)
        {
          j = arrayOfString.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TroopManager)this.app.getManager(51);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("troopuin");
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.b(this.jdField_b_of_type_JavaLangString);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903688, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131297613));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    Object localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject = View.inflate(this, 2130904388, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131493191), 0, getResources().getDimensionPixelSize(2131493191), getResources().getDimensionPixelSize(2131493189));
    ((TextView)localObject).setTextAppearance(this, 2131558594);
    ((TextView)localObject).setText(getResources().getString(2131364317));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    localObject = new AbsListView.LayoutParams(-1, -2);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130904388, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    localObject = View.inflate(this, 2130903668, null);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)((View)localObject).findViewById(2131299650));
    TroopGagMgr.TroopGagInfo localTroopGagInfo = ((TroopGagMgr)this.app.getManager(47)).a(this.jdField_b_of_type_JavaLangString);
    if ((localTroopGagInfo != null) && (localTroopGagInfo.a != 0L))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      localObject = View.inflate(this, 2130904388, null);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_Mqo = new mqo(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Mqo);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837958);
      super.setContentView(paramBundle);
      setTitle(getString(2131369569));
      if (!NetworkUtil.e(BaseApplication.getContext())) {
        QQToast.a(this, 2131367481, 0).b(getTitleBarHeight());
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      long l = getSharedPreferences("last_update_time" + this.app.a(), 0).getLong("key_last_update_time" + this.jdField_b_of_type_JavaLangString, 0L);
      if (System.currentTimeMillis() - l <= 86400000L) {
        break label694;
      }
      paramBundle = (TroopManager)this.app.getManager(51);
      if (paramBundle == null) {
        break label694;
      }
      paramBundle = paramBundle.a(this.jdField_b_of_type_JavaLangString);
      ((TroopHandler)this.app.a(20)).a(true, this.jdField_b_of_type_JavaLangString, paramBundle.troopcode, 8);
    }
    label694:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ThreadManager.a(new mqi(this, (TroopGagMgr)this.app.getManager(47)), 8, null, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGagActivity", 2, "doOnCreate: isRequestedTroopList=" + bool);
      }
      return true;
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_Mqo != null) {
      this.jdField_a_of_type_Mqo.b();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    super.doOnDestroy();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (TroopGagMgr)this.app.getManager(47);
    if (paramBoolean)
    {
      paramCompoundButton.a(this.jdField_b_of_type_JavaLangString, 268435455L);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_all", 0, 0, this.jdField_b_of_type_JavaLangString + "", paramCompoundButton.a(this.jdField_b_of_type_JavaLangString), "", "");
      return;
    }
    paramCompoundButton.a(this.jdField_b_of_type_JavaLangString, 0L);
    ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "close_all", 0, 0, this.jdField_b_of_type_JavaLangString + "", paramCompoundButton.a(this.jdField_b_of_type_JavaLangString), "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopGagActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */