package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mmt;
import mmv;
import mqq.os.MqqHandler;

public class SubAccountInfoListActivity
  extends SubAccountBaseActivity
  implements Handler.Callback, View.OnClickListener
{
  public static final int a = 1991;
  private static final String b = "0X800445B";
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private List jdField_a_of_type_JavaUtilList;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public SubAccountInfoListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new mmt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mmv(this);
  }
  
  private boolean c()
  {
    this.jdField_a_of_type_JavaUtilList = ((SubAccountManager)this.app.getManager(60)).b();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "refresh() go to SubaccountUgActivity, mAccountList == null || mAccountList.size() < 1");
      }
      Intent localIntent = new Intent();
      localIntent.setClass(this, SubAccountUgActivity.class);
      localIntent.putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
      startActivity(localIntent);
      finish();
      return false;
    }
    d();
    return true;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    View localView;
    if (i < j)
    {
      localView = getLayoutInflater().inflate(2130905019, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      if (i == 0) {
        localView.setBackgroundResource(2130838357);
      }
      for (;;)
      {
        localView.setTag(Integer.valueOf(i));
        localView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
        i += 1;
        break;
        if (i == j - 1) {
          localView.setBackgroundResource(2130838352);
        }
      }
    }
    if (j == 1)
    {
      localView = getLayoutInflater().inflate(2130903046, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      localView.setBackgroundResource(2130838352);
      TextView localTextView = (TextView)localView.findViewById(2131296825);
      localTextView.setText(2131370509);
      if (AppSetting.j) {
        localTextView.setContentDescription(getString(2131370509) + "按钮");
      }
      localView.setTag(Integer.valueOf(Integer.MAX_VALUE));
      localView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      e();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateAccounts() return, mAccountListContainer == null || mAccountListContainer.getChildCount() <= 0");
      }
    }
    label333:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "updateAccounts() return,mAccountList == null || mAccountList.size() == 0");
        }
      }
      else
      {
        int i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label333;
          }
          View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          Object localObject1 = localView.getTag();
          if (!(localObject1 instanceof Integer)) {
            break;
          }
          int j = ((Integer)localObject1).intValue();
          if ((this.jdField_a_of_type_JavaUtilList == null) || (j >= this.jdField_a_of_type_JavaUtilList.size())) {
            break;
          }
          localObject1 = (SubAccountInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          if (localObject1 == null) {
            break;
          }
          ImageView localImageView = (ImageView)localView.findViewById(2131296821);
          TextView localTextView2 = (TextView)localView.findViewById(2131299254);
          TextView localTextView1 = (TextView)localView.findViewById(2131305051);
          ((ImageView)localView.findViewById(2131305052)).setVisibility(0);
          String str = ((SubAccountInfo)localObject1).subuin;
          Object localObject2 = ContactUtils.i(this.app, str);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = str;
          }
          localObject2 = localObject1;
          if (str.equals(localObject1)) {
            localObject2 = ContactUtils.j(this.app, str);
          }
          localTextView2.setText((CharSequence)localObject2);
          localObject1 = this.app.b(str);
          localTextView1.setText((CharSequence)localObject1);
          if (AppSetting.j) {
            localView.setContentDescription((String)localObject2 + "," + (String)localObject1);
          }
          localObject1 = FaceDrawable.a(this.app, 1, str);
          if (localObject1 != null) {
            localImageView.setBackgroundDrawable((Drawable)localObject1);
          }
          i += 1;
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130905021);
    setContentBackgroundResource(2130837958);
    setTitle(2131370492);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131305054));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305055));
    paramBundle = getString(2131370510, new Object[] { this.app.b() });
    ((TextView)findViewById(2131305053)).setText(paramBundle);
    if (!c()) {
      return false;
    }
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(getClass());
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.app != null) && (this.app.isRunning())) {
      c();
    }
    do
    {
      return;
      finish();
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "SubAccountInfoListActivity.doOnResume() return.app.isRunning == false");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      i = j;
      if ((paramView.getTag() instanceof Integer)) {
        i = ((Integer)paramView.getTag()).intValue();
      }
    }
    if (i < 0) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "onClick() return, index<0:" + i);
      }
    }
    do
    {
      return;
      if (i == Integer.MAX_VALUE)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "onAddAccountClick.onClick() add account");
        }
        if (((SubAccountManager)this.app.getManager(60)).a() >= 2)
        {
          SubAccountControll.a(this.app, this);
          c();
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(paramView.getContext(), SubAccountBindActivity.class);
        ((Intent)localObject).putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
        startActivity((Intent)localObject);
        ReportController.b(this.app, "CliOper", "", "", "0X800445B", "0X800445B", 0, 0, "", "", "", "");
        return;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "onClick() return,mAccountList == null || index >= mAccountList.size()");
    return;
    Object localObject = (SubAccountInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if (((SubAccountManager)this.app.getManager(60)).a(((SubAccountInfo)localObject).subuin) == 1) {}
    for (paramView = new Intent(this, SubAccountSettingActivity.class);; paramView = new Intent(this, SubAccountUgActivity.class))
    {
      paramView.putExtra("subAccount", ((SubAccountInfo)localObject).subuin);
      paramView.putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
      startActivity(paramView);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SubAccountInfoListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */