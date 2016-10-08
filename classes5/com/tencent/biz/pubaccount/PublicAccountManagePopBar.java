package com.tencent.biz.pubaccount;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import hqe;
import java.util.ArrayList;
import java.util.List;

public class PublicAccountManagePopBar
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "PublicAccountManagePopBar";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131372563, 2131372564 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130838848, 2130838851 };
  private static final int[] c = { 2131372563, 2131372564 };
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private boolean jdField_a_of_type_Boolean;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PublicAccountManagePopBar(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void c()
  {
    int i = 0;
    Object localObject = new ArrayList();
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = i;
      localMenuItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(jdField_a_of_type_ArrayOfInt[i]);
      localMenuItem.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(c[i]);
      localMenuItem.jdField_b_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      ((List)localObject).add(localMenuItem);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (List)localObject, new hqe(this));
    try
    {
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131297013);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(((ViewGroup)localObject).getContext(), ((ViewGroup)localObject).getChildAt(0).findViewById(2131301929));
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(8).c(12).a();
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(((ViewGroup)localObject).getContext(), ((ViewGroup)localObject).getChildAt(1).findViewById(2131301929));
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(8).c(12).a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35)).a("101000.101001");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label88;
      }
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(new BusinessInfoCheckUpdate.RedTypeInfo());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
      return;
      label88:
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.a();
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountManagePopBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */