import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class vao
  implements BitmapDecoder
{
  public vao(DeviceMsgThumbDownloader paramDeviceMsgThumbDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.a.a(paramURL);
    if (paramURL == null) {
      paramURL = null;
    }
    for (;;)
    {
      return paramURL;
      String str = paramURL.a;
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      try
      {
        Bitmap localBitmap = this.a.a(str);
        paramURL = localBitmap;
        if (localBitmap == null)
        {
          paramURL = this.a.b(str);
          return paramURL;
        }
      }
      catch (Throwable paramURL)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VIdeoThumbDownloader", 2, "getBitmap", paramURL);
        }
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */