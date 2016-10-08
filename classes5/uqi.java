import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class uqi
  implements Runnable
{
  public uqi(ShortVideoPreDownloader paramShortVideoPreDownloader, ShortVideoReq paramShortVideoReq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ShortVideoPreDownloader.a("consumeShortVideo", "start pre download short video type=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.g + " uniseq=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_Long + ", uuid=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */