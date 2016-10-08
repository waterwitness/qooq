import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class osl
  implements Runnable
{
  osl(osk paramosk, boolean paramBoolean, String[] paramArrayOfString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      StatisticConstants.e();
    }
    try
    {
      StatisticConstants.a(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Int, false, false, -1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */