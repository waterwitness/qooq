import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class upq
  implements Runnable
{
  public upq(QQAppInterface paramQQAppInterface, ShortVideoReq paramShortVideoReq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ShortVideoPreDownloader localShortVideoPreDownloader = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq))
    {
      localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
      localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localShortVideoPreDownloader.a.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_JavaLangString);
      Logger.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_Long + ",curHandingNum:" + localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */