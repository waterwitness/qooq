import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.FilterVideoSoCallback;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.SVFilterDownloadSession;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class usn
  implements Runnable
{
  private PtvFilterSoLoad.FilterVideoSoCallback jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback;
  private boolean jdField_a_of_type_Boolean;
  
  public usn(boolean paramBoolean, PtvFilterSoLoad.FilterVideoSoCallback paramFilterVideoSoCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback = paramFilterVideoSoCallback;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback != null) {
      if (PtvFilterSoLoad.a().a.get() == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback.a(1, true);
        if (PtvFilterSoLoad.b().a.get() == 3) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback.a(2, true);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback.a(1, false);
      } while (!this.jdField_a_of_type_Boolean);
      PtvFilterSoLoad.a().a.getAndSet(0);
      return;
    }
    QLog.d("PtvFilterSoLoad", 2, "CONST ele == null ");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */