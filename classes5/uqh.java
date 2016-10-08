import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class uqh
  implements Runnable
{
  public uqh(ShortVideoPreDownloader paramShortVideoPreDownloader, ShortVideoDownloadInfo paramShortVideoDownloadInfo, MessageForShortVideo paramMessageForShortVideo, ShortVideoReq paramShortVideoReq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ShortVideoPreDownloader.a("consumeShortVideoThumb", "start download thumb, fileType=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.g + ", uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */