package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import vat;
import vau;

public class FileAssistantDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  private static final String a = "FileAssistantDownloader";
  protected BaseApplicationImpl a;
  
  public FileAssistantDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBaseApplicationImpl;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private Bitmap a(vat paramvat)
  {
    Object localObject2 = null;
    int i = paramvat.jdField_a_of_type_Int;
    int j = paramvat.jdField_b_of_type_Int;
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramvat.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      ((BitmapFactory.Options)localObject1).inSampleSize = ImageUtil.b((BitmapFactory.Options)localObject1, i, j);
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramvat.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      localObject1 = localObject2;
      if (localBitmap != null) {
        localObject1 = new ExifBitmapCreator(paramvat.jdField_a_of_type_JavaLangString).a(localBitmap);
      }
    }
    catch (Exception paramvat)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("AlbumThumbManager", 2, "make Thumb", paramvat);
      return null;
    }
    catch (OutOfMemoryError paramvat)
    {
      do
      {
        Object localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("AlbumThumbManager", 2, "make Thumb. OutOfMemoryError", paramvat);
    }
    return (Bitmap)localObject1;
    return null;
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap)
  {
    for (;;)
    {
      float f3;
      int j;
      int n;
      int k;
      int i1;
      try
      {
        f3 = this.a.getResources().getDisplayMetrics().density;
        int m = this.a.getResources().getDisplayMetrics().densityDpi;
        j = FilePicURLDrawlableHelper.jdField_b_of_type_Int;
        i = FilePicURLDrawlableHelper.jdField_a_of_type_Int;
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        i1 = FilePicURLDrawlableHelper.c;
        int i2 = FilePicURLDrawlableHelper.d;
        if ((n >= i2) && (k >= i2)) {
          break label339;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label310;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, URLDrawableHelper.b);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), localPaint);
          return new RoundRectBitmap(localBitmap, 8.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label332;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        return new RoundRectBitmap(paramBitmap, 8.0F);
      }
      if (n > k)
      {
        f1 = i / n;
        if (n > k)
        {
          f2 = j / k;
          f1 = Math.max(f1, f2);
          j = (int)(n * f1 + 0.5F);
          i = (int)(f1 * k + 0.5F);
        }
      }
      else
      {
        f1 = i / k;
        continue;
      }
      f2 = j / n;
      continue;
      label310:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label332:
        i = k;
      }
      label339:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f = this.a.getResources().getDisplayMetrics().density;
    paramInt1 = (int)(paramInt1 * f);
    paramInt2 = (int)(f * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if ((paramOutputStream == null) || (paramOutputStream.jdField_a_of_type_JavaLangString == null)) {
      return new File(AppConstants.bh);
    }
    return new File(paramOutputStream.jdField_a_of_type_JavaLangString);
  }
  
  public Object a(DownloadParams paramDownloadParams, vat paramvat)
  {
    Object localObject = null;
    BitmapFactory.Options localOptions = null;
    String str = paramvat.jdField_a_of_type_JavaLangString;
    if (str == null) {
      paramvat = localOptions;
    }
    File localFile;
    for (;;)
    {
      return paramvat;
      localFile = new File(str);
      try
      {
        if ((GifDrawable.isGifFile(localFile)) && (paramvat.jdField_a_of_type_Boolean))
        {
          paramvat = localOptions;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FileAssistantDownloader", 2, "DecodeFile END,GIF image,cacheFile=" + localFile.getAbsolutePath() + ",url=" + str);
          return null;
        }
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = URLDrawableHelper.a;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    paramDownloadParams.outOrientation = JpegExifReader.readOrientation(str);
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
    if ((localOptions.outHeight == 0) || (localOptions.outWidth == 0)) {
      throw new IOException("step:decode bounds error, not valid pic");
    }
    localOptions.inSampleSize = AbstractImageDownloader.a(localOptions, paramvat.jdField_a_of_type_Int, paramvat.jdField_b_of_type_Int);
    int i = localOptions.outWidth;
    i = localOptions.outHeight;
    localOptions.inJustDecodeBounds = false;
    i = 1;
    paramvat = null;
    label237:
    paramDownloadParams = (DownloadParams)localObject;
    if (i <= 3)
    {
      paramDownloadParams = paramvat;
      try
      {
        paramvat = SafeBitmapFactory.decodeFile(localFile.getAbsolutePath(), localOptions);
        if (paramvat == null)
        {
          paramDownloadParams = paramvat;
          throw new OutOfMemoryError("DecodeFile Failed,bitmap == null, url:" + str + " ,retry count: " + i + ",path:" + localFile.getAbsolutePath());
        }
      }
      catch (OutOfMemoryError paramvat)
      {
        if (paramDownloadParams != null) {
          paramDownloadParams.recycle();
        }
        if (paramvat == null) {}
      }
    }
    for (paramvat = paramvat.getMessage();; paramvat = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistantDownloader", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",cacheFile=" + localFile.getAbsolutePath() + ",url=" + str + ",oom.msg:" + paramvat);
      }
      localOptions.inSampleSize *= 2;
      i += 1;
      paramvat = paramDownloadParams;
      break label237;
      paramDownloadParams = paramvat;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramDownloadParams = paramvat;
        boolean bool = SliceBitmap.needSlice(paramvat);
        if (!bool) {}
      }
      paramDownloadParams = paramvat;
      paramvat = paramDownloadParams;
      if (paramDownloadParams != null) {
        break;
      }
      throw new IOException("decode image failed");
    }
  }
  
  public vat a(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      vat localvat = new vat(this);
      localvat.jdField_a_of_type_JavaLangString = paramURL[0];
      localvat.jdField_a_of_type_Int = Integer.parseInt(paramURL[1]);
      localvat.jdField_b_of_type_Int = Integer.parseInt(paramURL[2]);
      localvat.jdField_b_of_type_Long = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          localvat.jdField_a_of_type_Boolean = bool1;
        }
      }
      else
      {
        if (paramURL.length > 5)
        {
          if (Integer.parseInt(paramURL[5]) != 1) {
            break label164;
          }
          bool1 = true;
          label101:
          localvat.jdField_b_of_type_Boolean = bool1;
        }
        if (paramURL.length > 6)
        {
          if (Integer.parseInt(paramURL[6]) != 1) {
            break label169;
          }
          bool1 = true;
          label126:
          localvat.c = bool1;
        }
        if (paramURL.length > 7) {
          if (Integer.parseInt(paramURL[7]) != 1) {
            break label174;
          }
        }
      }
      label164:
      label169:
      label174:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localvat.d = bool1;
        return localvat;
        bool1 = false;
        break;
        bool1 = false;
        break label101;
        bool1 = false;
        break label126;
      }
      return null;
    }
    catch (Exception paramURL) {}
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object b(DownloadParams paramDownloadParams, vat paramvat)
  {
    paramDownloadParams = paramvat.jdField_a_of_type_JavaLangString;
    if (paramDownloadParams == null) {
      paramDownloadParams = null;
    }
    for (;;)
    {
      return paramDownloadParams;
      File localFile = new File(paramDownloadParams);
      try
      {
        paramDownloadParams = new BitmapFactory.Options();
        paramDownloadParams.inPreferredConfig = URLDrawableHelper.b;
        paramDownloadParams.inDensity = 160;
        paramDownloadParams.inTargetDensity = 160;
        paramDownloadParams.inScreenDensity = 160;
        paramDownloadParams.inJustDecodeBounds = false;
        paramvat = SafeBitmapFactory.decodeFile(localFile.getAbsolutePath(), paramDownloadParams);
        paramDownloadParams = paramvat;
        if (paramvat == null) {
          continue;
        }
        paramDownloadParams = a(paramvat);
        if (!paramvat.equals(paramDownloadParams.mBitmap)) {
          paramvat.recycle();
        }
        paramvat = new RoundRectBitmap(new ExifBitmapCreator(localFile.getAbsolutePath()).a(paramDownloadParams.mBitmap), paramDownloadParams.mCornerRadius, paramDownloadParams.mBoardColor, paramDownloadParams.mBorderWidth);
        paramDownloadParams = paramvat;
        if (this.a == null) {
          continue;
        }
        paramvat.mDisplayWidth = this.a.getResources().getDisplayMetrics().widthPixels;
        paramvat.mDisplayHeight = this.a.getResources().getDisplayMetrics().heightPixels;
        return paramvat;
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = AlbumThumbManager.a(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = a(paramDownloadParams.url);
    if (paramURLDrawableHandler == null) {
      paramDownloadParams = null;
    }
    do
    {
      return paramDownloadParams;
      if ((paramURLDrawableHandler.jdField_a_of_type_Boolean) && (!paramURLDrawableHandler.jdField_b_of_type_Boolean) && (!paramURLDrawableHandler.c))
      {
        if (paramURLDrawableHandler.d) {
          return b(paramDownloadParams, paramURLDrawableHandler);
        }
        return a(paramDownloadParams, paramURLDrawableHandler);
      }
      if (paramURLDrawableHandler.c)
      {
        paramFile = FileCategoryUtil.b(this.a, paramURLDrawableHandler.jdField_a_of_type_JavaLangString);
        if (paramFile != null) {
          paramFile = a(paramFile);
        }
      }
      while (paramFile == null)
      {
        return null;
        paramFile = a(BaseApplicationImpl.getContext().getResources().getDrawable(2130840343));
        continue;
        paramFile = paramFile.b(paramDownloadParams.url, new vau(this));
      }
      paramDownloadParams = paramFile;
    } while (!paramURLDrawableHandler.jdField_b_of_type_Boolean);
    return a(paramFile, paramFile.getWidth(), paramFile.getHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\FileAssistantDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */