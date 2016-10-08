import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest;
import com.tencent.qphone.base.util.BaseApplication;

public final class vbv
  implements Runnable
{
  public vbv(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, StringBuilder paramStringBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ShortVideoUploadABTest.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */