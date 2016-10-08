import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public final class wdd
  implements Runnable
{
  public wdd(boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = null;
    if (this.jdField_a_of_type_Boolean) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369477);
    }
    if (str != null) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2, str, 0).b(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */