import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.qphone.base.util.QLog;

public class tsz
  implements Runnable
{
  public tsz(PicPreDownloader paramPicPreDownloader, MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productAysnc(): cannot predownload");
      }
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */