import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class ltm
  implements Runnable
{
  public ltm(LoginInfoActivity paramLoginInfoActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.isFinishing())
        {
          if ((LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity) != null) && (LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).isShowing()))
          {
            LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).dismiss();
            LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).cancel();
            LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, null);
          }
          LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight()));
          int i = this.jdField_a_of_type_Int;
          switch (i)
          {
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).b(2131369268);
        continue;
      }
      if ((LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity) != null) && (!LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).isShowing())) {
        LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).show();
      }
      return;
      LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).b(2131367254);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */