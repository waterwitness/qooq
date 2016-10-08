package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import pgo;
import pgp;
import pgq;

public class RenMaiQuanMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  public int a;
  public CircleManager a;
  IGroupObserver jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  public pgp a;
  
  public RenMaiQuanMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver = new pgo(this);
  }
  
  public RenMaiQuanMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver = new pgo(this);
  }
  
  public RenMaiQuanMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver = new pgo(this);
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 2048, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_Int);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130904987);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299813));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131427379);
    this.jdField_a_of_type_Pgp = new pgp(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Pgp);
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    this.jdField_a_of_type_Int = paramBundle.getInt("group_uin");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, "人脉圈", this.jdField_a_of_type_JavaLangString);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, true);
    if (i != 0)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c(i);
      if (i != 0) {
        break label96;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.m();
    }
    for (;;)
    {
      this.jdField_a_of_type_Pgp.notifyDataSetChanged();
      return;
      label96:
      if (i == -2) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131367256), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.getHeight());
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Pgp != null) {
      this.jdField_a_of_type_Pgp.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Pgp.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    pgq localpgq = (pgq)paramView.getTag();
    if ((localpgq != null) && (localpgq.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localpgq.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy != null))
    {
      CircleBuddy localCircleBuddy = localpgq.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy;
      if (localpgq.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localCircleBuddy.uin, this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy), 3, "-1");
        localpgq.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.j)
        {
          if (!localpgq.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label125;
          }
          paramView.setContentDescription(localpgq.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "已选中,双击取消");
        }
      }
    }
    return;
    label125:
    paramView.setContentDescription(localpgq.jdField_a_of_type_AndroidWidgetTextView.getText().toString() + "未选中,双击选中");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\RenMaiQuanMemberListInnerFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */