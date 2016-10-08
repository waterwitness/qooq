import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class vau
  implements BitmapDecoder
{
  public vau(FileAssistantDownloader paramFileAssistantDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.a.a(paramURL);
    if (paramURL == null) {
      return null;
    }
    return FileAssistantDownloader.a(this.a, paramURL);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */