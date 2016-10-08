import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class wan
  implements Runnable
{
  public wan(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, 0L, 0L, new HashMap(), "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */