package com.tencent.mobileqq.activity.qqcard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.BaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;

public class NearbyQQCardActivity
  extends IphoneTitleBarActivity
  implements TabBarView.OnTabChangeListener
{
  public static final int a = 0;
  public static final String a = "NearbyQQCardActivity";
  public static final int b = 1;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private BaseFragment jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  
  public NearbyQQCardActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyQQCardActivity", 2, "onTabSelected, " + paramInt1 + ", " + paramInt2);
    }
    Object localObject2 = (BaseFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      switch (paramInt2)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    while (localObject1 == null)
    {
      return;
      localObject1 = NearByQQCardFragment.a(1);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1, localObject1);
      continue;
      localObject1 = NearByQQCardFragment.a(0);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(0, localObject1);
    }
    localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment == localObject1)
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment.b();
        return;
      }
      ((FragmentTransaction)localObject2).hide(this.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment);
    }
    if (!((BaseFragment)localObject1).isAdded()) {
      ((FragmentTransaction)localObject2).add(2131303217, (Fragment)localObject1);
    }
    for (;;)
    {
      ((FragmentTransaction)localObject2).commitAllowingStateLoss();
      this.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment = ((BaseFragment)localObject1);
      ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", this.app.getAccount(), "wallet", "nearticket.tabselect." + paramInt2, 1, 0, "", "", "", "");
      return;
      ((FragmentTransaction)localObject2).show((Fragment)localObject1);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904567);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    setTitle(getString(2131366552));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131303216));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getString(2131366554));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getString(2131366553));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
    ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", this.app.getAccount(), "wallet", "cardmenu.nearticket.show", 1, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\NearbyQQCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */