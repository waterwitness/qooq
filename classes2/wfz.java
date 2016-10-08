import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class wfz
  implements Runnable
{
  wfz(wfy paramwfy, DownloadTask paramDownloadTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(wfy.jdField_a_of_type_JavaLangString, 2, "doTask | run() downloadLimitCount=" + this.jdField_a_of_type_Wfy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",task=" + this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.c) && (DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.z = -101;
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a(-1);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.f();
      this.jdField_a_of_type_Wfy.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
      this.jdField_a_of_type_Wfy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1);
      this.jdField_a_of_type_Wfy.c();
      if (QLog.isColorLevel()) {
        QLog.d(wfy.jdField_a_of_type_JavaLangString, 2, "doTask | run() task is limit of failTime, task=" + this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
      }
      return;
    }
    int i = DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask, this.jdField_a_of_type_Wfy.jdField_a_of_type_MqqAppAppRuntime);
    if (QLog.isColorLevel()) {
      QLog.d(wfy.jdField_a_of_type_JavaLangString, 2, "doTask | run() download task result=" + i + ",task=" + this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
    }
    this.jdField_a_of_type_Wfy.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
    this.jdField_a_of_type_Wfy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1);
    this.jdField_a_of_type_Wfy.c();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */