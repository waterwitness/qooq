package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ShortVideoThumbDownloader
  extends AbsDownloader
{
  public static final String a = "shortVideoThumb";
  private static final String b = "ShortVideoThumbDownloader";
  
  public ShortVideoThumbDownloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = null;
    paramFile = paramFile.getAbsolutePath();
    if (!FileUtils.b(paramFile))
    {
      paramFile = paramDownloadParams;
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoThumbDownloader", 2, "decodeFile file not exits. just return");
        paramFile = paramDownloadParams;
      }
    }
    do
    {
      for (;;)
      {
        return paramFile;
        paramURLDrawableHandler = new BitmapFactory.Options();
        paramURLDrawableHandler.inDensity = 160;
        paramURLDrawableHandler.inTargetDensity = 160;
        paramURLDrawableHandler.inScreenDensity = 160;
        try
        {
          paramURLDrawableHandler = BitmapFactory.decodeFile(paramFile, paramURLDrawableHandler);
          int i = paramURLDrawableHandler.getWidth();
          int j = paramURLDrawableHandler.getHeight();
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoThumbDownloader", 2, "decodeFile : thumbPath = " + paramFile + ", w=" + i + ", h=" + j);
          }
          Object localObject = new int[2];
          localObject[0] = i;
          localObject[1] = j;
          paramFile = paramDownloadParams;
          if (localObject != null)
          {
            int k = localObject[0];
            int m = localObject[1];
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoThumbDownloader", 2, "decodeFile ==> dstW:" + k + ", dstH:" + m);
            }
            float f1 = k / i;
            float f2 = m / j;
            paramDownloadParams = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
            paramDownloadParams.setDensity(160);
            paramFile = new Canvas(paramDownloadParams);
            localObject = new Paint(3);
            ((Paint)localObject).setColor(-16777216);
            paramFile.scale(f1, f2);
            paramFile.drawBitmap(paramURLDrawableHandler, 0.0F, 0.0F, (Paint)localObject);
            paramFile = paramDownloadParams;
            if (paramURLDrawableHandler != null)
            {
              paramFile = paramDownloadParams;
              if (!paramURLDrawableHandler.isRecycled())
              {
                paramURLDrawableHandler.recycle();
                return paramDownloadParams;
              }
            }
          }
        }
        catch (OutOfMemoryError paramURLDrawableHandler)
        {
          paramFile = paramDownloadParams;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoThumbDownloader", 2, "decodeFile : OutOfMemoryError ", paramURLDrawableHandler);
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\ShortVideoThumbDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */