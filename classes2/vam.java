import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.DataLineDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class vam
  implements BitmapDecoder
{
  public val a;
  
  public vam(DataLineDownloader paramDataLineDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap a(URL paramURL)
  {
    this.jdField_a_of_type_Val = this.jdField_a_of_type_ComTencentMobileqqTransfileDataLineDownloader.a(paramURL);
    return DataLineDownloader.a(this.jdField_a_of_type_ComTencentMobileqqTransfileDataLineDownloader, this.jdField_a_of_type_Val);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */