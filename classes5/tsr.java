import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import java.io.File;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class tsr
  implements Runnable
{
  public tsr(BasePicOprerator paramBasePicOprerator, DownCallBack.DownResult paramDownResult)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject;
    PicStatisticsManager localPicStatisticsManager;
    long l;
    if ((this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b);
      if (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.a == 0)
      {
        localPicStatisticsManager = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
        if (localPicStatisticsManager != null)
        {
          l = localFile.length();
          switch (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.c)
          {
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (((PicPreDownloader)localObject).b.contains(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq))
      {
        ((PicPreDownloader)localObject).b.remove(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq);
        ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g);
        Logger.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",cmd:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.n + ",curHandingNum:" + ((PicPreDownloader)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        if ((this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b != null))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          if ((localObject != null) && (((MessageForPic)localObject).size == 0L))
          {
            l = new File(this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b).length();
            this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForPic)localObject, l);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
      }
      return;
      localPicStatisticsManager.a(13059, l);
      continue;
      localPicStatisticsManager.a(13060, l);
      localPicStatisticsManager.c((MessageForPic)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */