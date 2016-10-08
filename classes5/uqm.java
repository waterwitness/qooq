import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoDownload;

public final class uqm
  implements Runnable
{
  public uqm(VideoEnvironment.ShortVideoDownload paramShortVideoDownload, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoDownload.a(this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */