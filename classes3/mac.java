import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mac
  implements Runnable
{
  public mac(PortraitImageview paramPortraitImageview, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */