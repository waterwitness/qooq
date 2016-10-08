import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;

public class ttd
  implements Runnable
{
  public ttd(PicPreDownloader paramPicPreDownloader, PicReq paramPicReq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PicBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq, this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ttd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */