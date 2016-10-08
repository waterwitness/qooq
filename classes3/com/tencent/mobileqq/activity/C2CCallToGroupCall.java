package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import kri;
import krj;

public class C2CCallToGroupCall
  extends BaseActivity
  implements View.OnClickListener, ContactSearchResultPresenter.OnActionListener
{
  static final String jdField_a_of_type_JavaLangString = "C2CCallToGroupCall";
  public int a;
  public Activity a;
  public Context a;
  public Intent a;
  private DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  public QQAppInterface a;
  public QQProgressDialog a;
  Thread jdField_a_of_type_JavaLangThread;
  public int b;
  public String b;
  private int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public C2CCallToGroupCall()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangThread = new krj(this);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.d = "";
    this.e = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.f = "";
  }
  
  public C2CCallToGroupCall(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangThread = new krj(this);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.d = "";
    this.e = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.f = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new kri(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
  }
  
  public void a(View paramView) {}
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.f = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.e = paramString4;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new ArrayList();
    paramString2.add(this.e);
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3000, paramString1, true, true, true, null, paramString2, 1, this.jdField_b_of_type_Int);
  }
  
  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramContext, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368254);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    this.jdField_a_of_type_JavaLangThread.setName("PhoneContactSelectActivity_addDiscussion");
    ThreadManager.a(this.jdField_a_of_type_JavaLangThread, null, false);
    return true;
  }
  
  public void onClick(View paramView) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\C2CCallToGroupCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */