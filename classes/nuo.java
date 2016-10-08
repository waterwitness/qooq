import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AccountNotMatchException;

public class nuo
  implements Runnable
{
  public nuo(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      do
      {
        return;
        localObject = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      } while ((localObject == null) || (!MessageForPic.class.isInstance(localObject)));
      localObject = (MessageForPic)localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "payFlow,id:" + this.jdField_a_of_type_Long + ",subId:" + this.jdField_a_of_type_Int);
        }
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.b);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localQQAppInterface, (MessageForPic)localObject);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException) {}
    } while (!QLog.isColorLevel());
    QLog.d("AIOImageProviderService", 2, "no appRuntime");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nuo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */