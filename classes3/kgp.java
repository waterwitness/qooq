import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;

class kgp
  extends GestureDetector.SimpleOnGestureListener
{
  kgp(kgo paramkgo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (Math.abs(paramFloat1) > 20.0F) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.d) && (this.a.jdField_a_of_type_AndroidViewView != null))
    {
      paramMotionEvent1 = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131296816);
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent1.getVisibility() == 0) {
          break label462;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AccountManage", 2, "hide previous selectedAccountView");
          }
          paramMotionEvent2 = AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView);
          if ((paramMotionEvent2 instanceof ShaderAnimLayout)) {
            ((ShaderAnimLayout)paramMotionEvent2).d();
          }
          paramMotionEvent2 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView, 2130968579, 3);
          localLayoutParams = paramMotionEvent2.getLayoutParams();
          if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b) {
            break label411;
          }
          localLayoutParams.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - AccountManageActivity.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) * 40.0F));
          paramMotionEvent2.setLayoutParams(localLayoutParams);
        }
        if (QLog.isColorLevel()) {
          QLog.i("AccountManage", 2, "show current selectedAccountView");
        }
        ((ShaderAnimLayout)paramMotionEvent1).a();
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView = this.a.jdField_a_of_type_AndroidViewView.findViewById(2131296827);
        paramMotionEvent1 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView, 2130968580, 2);
        paramMotionEvent2 = paramMotionEvent1.getLayoutParams();
        if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b) {
          break label430;
        }
      }
    }
    label411:
    label430:
    for (paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - 75.0F * AccountManageActivity.d(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity)));; paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - 35.0F * AccountManageActivity.e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity))))
    {
      paramMotionEvent1.setLayoutParams(paramMotionEvent2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(true);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.d = true;
      this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
      return true;
      localLayoutParams.width = ((int)AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity));
      break;
    }
    label462:
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "hide current selectedAccountView");
    }
    ((ShaderAnimLayout)paramMotionEvent1).d();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView != null)
    {
      paramMotionEvent1 = AccountManageActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView, 2130968579, 3);
      paramMotionEvent2 = paramMotionEvent1.getLayoutParams();
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b) {
        break label651;
      }
    }
    label651:
    for (paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) - AccountManageActivity.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity) * 40.0F));; paramMotionEvent2.width = ((int)AccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity)))
    {
      paramMotionEvent1.setLayoutParams(paramMotionEvent2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView = null;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(false);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.d = true;
      this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */