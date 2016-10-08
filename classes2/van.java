import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class van
  implements BitmapDecoder
{
  public van(DeviceMsgThumbDownloader paramDeviceMsgThumbDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Bitmap a(URL paramURL)
  {
    LocalMediaInfo localLocalMediaInfo = this.a.a(paramURL);
    if (localLocalMediaInfo == null) {}
    for (;;)
    {
      return null;
      paramURL = new BitmapFactory.Options();
      paramURL.inDensity = 160;
      paramURL.inTargetDensity = 160;
      paramURL.inScreenDensity = 160;
      try
      {
        paramURL = BitmapFactory.decodeFile(localLocalMediaInfo.a, paramURL);
        if (paramURL == null) {
          continue;
        }
        return ThumbnailUtils.extractThumbnail(paramURL, localLocalMediaInfo.f, localLocalMediaInfo.g, 2);
      }
      catch (OutOfMemoryError paramURL)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VIdeoThumbDownloader", 2, "DeviceImgBitmapDecoder getBitmap", paramURL);
          }
          paramURL = null;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\van.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */