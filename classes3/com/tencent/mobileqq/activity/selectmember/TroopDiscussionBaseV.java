package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class TroopDiscussionBaseV
  extends FrameLayout
{
  public Context a;
  public LayoutInflater a;
  public InnerFrameManager a;
  public SelectMemberActivity a;
  public QQAppInterface a;
  
  public TroopDiscussionBaseV(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramSelectMemberActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = paramSelectMemberActivity;
    this.jdField_a_of_type_AndroidContentContext = paramSelectMemberActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramSelectMemberActivity.getLayoutInflater();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = paramSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager;
  }
  
  protected void a() {}
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {}
  
  protected void b() {}
  
  public void b(Bundle paramBundle) {}
  
  protected void e() {}
  
  protected void f() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\TroopDiscussionBaseV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */