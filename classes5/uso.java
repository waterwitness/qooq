import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.FilterVideoSoCallback;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.SVFilterDownloadSession;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class uso
  implements Runnable
{
  private PtvFilterSoLoad.FilterVideoSoCallback jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback;
  private boolean jdField_a_of_type_Boolean;
  
  public uso(boolean paramBoolean, PtvFilterSoLoad.FilterVideoSoCallback paramFilterVideoSoCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback = paramFilterVideoSoCallback;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback != null) {
      if (PtvFilterSoLoad.b().a.get() == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback.a(2, true);
        if (PtvFilterSoLoad.a().a.get() == 3) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback.a(1, true);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$FilterVideoSoCallback.a(2, false);
      } while (!this.jdField_a_of_type_Boolean);
      PtvFilterSoLoad.b().a.getAndSet(0);
      return;
    }
    QLog.d("PtvFilterSoLoad", 2, "Var ele == null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */