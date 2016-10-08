import com.tencent.mobileqq.app.QPSafeCheckHandler;
import com.tencent.mobileqq.app.SafeCenterPushHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qdv
  implements Runnable
{
  public qdv(QPSafeCheckHandler paramQPSafeCheckHandler, byte[] paramArrayOfByte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SafeCenterPushHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQPSafeCheckHandler.b(this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */