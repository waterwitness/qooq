package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import val;
import vam;

public class DataLineDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  private static final String a = "_dataline_file";
  protected BaseApplicationImpl a;
  
  public DataLineDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBaseApplicationImpl;
  }
  
  private Bitmap a(val paramval)
  {
    int j = 0;
    Object localObject2;
    if (paramval == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return (Bitmap)localObject2;
      int i = paramval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.f;
      int k = paramval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.g;
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localOptions.inDensity = 160;
        localOptions.inTargetDensity = 160;
        localOptions.inScreenDensity = 160;
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a, localOptions);
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = a(localOptions, i, k);
        Object localObject1 = BitmapFactory.decodeFile(paramval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a, localOptions);
        k = AIOUtils.a(135.0F, BaseApplicationImpl.getContext().getResources());
        if (localOptions.outHeight > localOptions.outWidth * 2.0F)
        {
          i = (int)((localOptions.outHeight - localOptions.outWidth * 2.0F) / 2.0F);
          localOptions.outHeight = ((int)(localOptions.outWidth * 2.0F));
        }
        for (;;)
        {
          localObject2 = Bitmap.createBitmap((Bitmap)localObject1, j, i, localOptions.outWidth, localOptions.outHeight);
          if (localOptions.outWidth <= k)
          {
            localObject1 = localObject2;
            if (localOptions.outHeight <= k) {}
          }
          else
          {
            localObject1 = ImageUtil.b((Bitmap)localObject2, k);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            break;
          }
          return new ExifBitmapCreator(paramval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a).a((Bitmap)localObject1);
          if (localOptions.outWidth <= localOptions.outHeight * 2.0F) {
            break label356;
          }
          j = (int)((localOptions.outWidth - localOptions.outHeight * 2.0F) / 2.0F);
          localOptions.outWidth = ((int)(localOptions.outHeight * 2.0F));
          i = 0;
        }
      }
      catch (Exception paramval)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "make Thumb ", paramval);
        }
        return null;
      }
      catch (OutOfMemoryError paramval)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("_dataline_file", 2, "make Thumb OOM ", paramval);
            continue;
            label356:
            i = 0;
          }
        }
      }
    }
  }
  
  public int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      if (paramOptions.outWidth * paramOptions.outHeight > 5000000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "calculateInSampleSize options.outWidth*options.outHeight=" + paramOptions.outWidth * paramOptions.outHeight);
        }
        j = 2;
      }
    }
    int k;
    int m;
    label95:
    do
    {
      do
      {
        return j;
        k = paramOptions.outHeight;
        m = paramOptions.outWidth;
        j = i;
      } while (k <= paramInt2);
      j = i;
    } while (m <= paramInt1);
    int n = Math.round(k / paramInt2);
    j = Math.round(m / paramInt1);
    if (n < j) {}
    for (;;)
    {
      j = i;
      if (n < 2) {
        break;
      }
      m /= 2;
      k /= 2;
      i *= 2;
      break label95;
      n = j;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if (paramOutputStream != null) {
      return new File(paramOutputStream.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a);
    }
    return new File(AppConstants.bh);
  }
  
  public val a(URL paramURL)
  {
    try
    {
      val localval = new val(this);
      paramURL = paramURL.getFile().split("\\|");
      localval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      localval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.a = paramURL[0];
      localval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.f = Integer.parseInt(paramURL[1]);
      localval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.g = Integer.parseInt(paramURL[2]);
      localval.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.d = Long.parseLong(paramURL[3]);
      localval.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramURL[4]);
      return localval;
    }
    catch (Exception paramURL) {}
    return null;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = AlbumThumbManager.a(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = new vam(this);
    paramFile = paramFile.b(paramDownloadParams.url, paramURLDrawableHandler);
    if (paramFile == null) {
      return null;
    }
    paramDownloadParams = a(paramDownloadParams.url);
    if ((paramDownloadParams != null) && (paramDownloadParams.jdField_a_of_type_Boolean))
    {
      paramDownloadParams = ImageUtil.a(paramFile, AIOUtils.a(12.0F, BaseApplicationImpl.getContext().getResources()));
      paramFile.recycle();
      return paramDownloadParams;
    }
    return paramFile;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\DataLineDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */