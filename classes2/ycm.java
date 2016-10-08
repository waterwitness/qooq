import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.HYConfigLoader;
import java.util.TimerTask;

public class ycm
  extends TimerTask
{
  public ycm(HYConfigLoader paramHYConfigLoader, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_CooperationHuangyeHYConfigLoader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_CooperationHuangyeHYConfigLoader.a(), 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ycm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */