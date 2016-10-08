import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class uqj
  implements Runnable
{
  public uqj(ShortVideoPreDownloader paramShortVideoPreDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      ShortVideoReq localShortVideoReq = (ShortVideoReq)localIterator.next();
      ShortVideoBusiManager.a(localShortVideoReq, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localShortVideoReq.a != null) {
        ShortVideoPreDownloader.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localShortVideoReq.a.a);
      }
    }
    this.a.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */