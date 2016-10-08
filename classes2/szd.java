import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class szd
  implements Runnable
{
  public szd(ReportLog paramReportLog, MobileQQ paramMobileQQ)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_MqqAppMobileQQ instanceof BaseApplicationImpl))
    {
      Object localObject = ((BaseApplicationImpl)this.jdField_a_of_type_MqqAppMobileQQ).a();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        QLog.d("ReportLog", 1, "uncaughtException QQAppInterface exit.");
        ((QQAppInterface)localObject).b(false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\szd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */