package cooperation.huangye;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class HuangyeHttpDownloader
  extends HttpDownloader
{
  public HuangyeHttpDownloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          m = j;
        }
      }
    }
    label43:
    int k;
    label55:
    do
    {
      do
      {
        return m;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      i <<= 1;
      k >>= 1;
      j >>= 1;
      break label55;
      n = m;
    }
  }
  
  public HuangyeHttpDownloader.DownloadInfo a(URL paramURL)
  {
    try
    {
      HuangyeHttpDownloader.DownloadInfo localDownloadInfo = new HuangyeHttpDownloader.DownloadInfo(this);
      paramURL = paramURL.getFile().split("\\|");
      localDownloadInfo.jdField_a_of_type_JavaLangString = paramURL[0];
      localDownloadInfo.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(Boolean.parseBoolean(paramURL[1]));
      localDownloadInfo.b = Boolean.valueOf(Boolean.parseBoolean(paramURL[2]));
      return localDownloadInfo;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    HuangyeHttpDownloader.DownloadInfo localDownloadInfo = a(paramDownloadParams.url);
    if ((localDownloadInfo.b.booleanValue()) || (NetworkUtil.b(BaseApplication.getContext()) == 1))
    {
      DownloadParams localDownloadParams = new DownloadParams();
      localDownloadParams.url = new URL(localDownloadInfo.jdField_a_of_type_JavaLangString);
      localDownloadParams.urlStr = paramDownloadParams.urlStr;
      localDownloadParams.reqWidth = paramDownloadParams.reqWidth;
      localDownloadParams.reqHeight = paramDownloadParams.reqHeight;
      localDownloadParams.useGifAnimation = paramDownloadParams.useGifAnimation;
      localDownloadParams.mGifRoundCorner = paramDownloadParams.mGifRoundCorner;
      localDownloadParams.headers = paramDownloadParams.headers;
      localDownloadParams.cookies = paramDownloadParams.cookies;
      localDownloadParams.tag = paramDownloadParams.tag;
      localDownloadParams.useExifOrientation = paramDownloadParams.useExifOrientation;
      localDownloadParams.outOrientation = paramDownloadParams.outOrientation;
      localDownloadParams.downloaded = paramDownloadParams.downloaded;
      localDownloadParams.outWidth = paramDownloadParams.outWidth;
      localDownloadParams.outHeight = paramDownloadParams.outHeight;
      localDownloadParams.mAutoScaleByDensity = paramDownloadParams.mAutoScaleByDensity;
      localDownloadParams.mDecodeHandler = paramDownloadParams.mDecodeHandler;
      return super.a(paramOutputStream, localDownloadParams, paramURLDrawableHandler);
    }
    throw new IOException(paramDownloadParams.url + " huangye can not download in mobile network");
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    HuangyeHttpDownloader.DownloadInfo localDownloadInfo = a(paramDownloadParams.url);
    String str = paramFile.getAbsolutePath();
    paramURLDrawableHandler = null;
    try
    {
      paramFile = new BitmapFactory.Options();
      paramFile.inJustDecodeBounds = true;
      paramFile.inPreferredConfig = Bitmap.Config.ARGB_8888;
      paramFile.inDensity = 160;
      paramFile.inTargetDensity = 160;
      paramFile.inScreenDensity = 160;
      BitmapFactory.decodeFile(str, paramFile);
      paramFile.inJustDecodeBounds = false;
      paramFile.inSampleSize = a(paramFile, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
      paramFile = BitmapFactory.decodeFile(str, paramFile);
      if (paramFile == null) {
        throw new IOException("decode cache file failed: " + str);
      }
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        paramFile = paramURLDrawableHandler;
        if (QLog.isColorLevel())
        {
          QLog.e("HuangyeHttpDownLoader", 2, "HuangyeHttpDownLoader OOM");
          paramFile = paramURLDrawableHandler;
        }
      }
      if ((localDownloadInfo != null) && (localDownloadInfo.jdField_a_of_type_JavaLangBoolean.booleanValue()))
      {
        paramDownloadParams = ImageUtil.a(paramFile, paramFile.getWidth() / 2);
        paramFile.recycle();
        return paramDownloadParams;
      }
    }
    return paramFile;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HuangyeHttpDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */