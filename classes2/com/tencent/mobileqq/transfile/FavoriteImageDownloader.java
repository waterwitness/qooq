package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class FavoriteImageDownloader
  extends AbstractImageDownloader
{
  public static final String f = "favimage";
  private static final String k = "qqfav.FavoriteImageDownloader";
  
  public FavoriteImageDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("favimage", paramBaseApplicationImpl);
  }
  
  public FavoriteImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static File a(URL paramURL)
  {
    paramURL = a(paramURL, new String[] { null });
    if (paramURL == null) {
      return null;
    }
    return new File(paramURL);
  }
  
  private static String a(URL paramURL, String[] paramArrayOfString)
  {
    Object localObject = paramURL.getFile();
    if (((String)localObject).startsWith("file/")) {
      paramURL = ((String)localObject).substring("file/".length());
    }
    do
    {
      do
      {
        return paramURL;
        if (((String)localObject).startsWith("file://")) {
          return ((String)localObject).substring(7);
        }
        paramURL = (URL)localObject;
      } while (!((String)localObject).startsWith("http"));
      paramURL = (URL)localObject;
      if (((String)localObject).startsWith("http/")) {
        paramURL = ((String)localObject).substring("http/".length());
      }
      localObject = paramURL.split("\\|");
    } while (localObject.length < 2);
    paramArrayOfString[0] = localObject[0];
    return localObject[1];
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = new String[1];
    paramOutputStream[0] = null;
    String str1 = a(paramDownloadParams.url, paramOutputStream);
    int i;
    Object localObject;
    if (paramOutputStream[0] != null)
    {
      if (new File(str1).exists()) {
        break label404;
      }
      i = 1;
      j = i;
      if (i == 0)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
    }
    try
    {
      BitmapFactory.decodeFile(str1, (BitmapFactory.Options)localObject);
      i = ((BitmapFactory.Options)localObject).outHeight;
      j = ((BitmapFactory.Options)localObject).outWidth;
      if (j + i != 0) {
        break label410;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label100:
        String str2;
        i = 1;
      }
    }
    int j = i;
    if (i != 0)
    {
      new File(str1).delete();
      j = i;
    }
    String str3;
    if ((j != 0) && (NetworkUtil.h(this.a.getApplicationContext())))
    {
      localObject = paramDownloadParams.url;
      str2 = paramDownloadParams.urlStr;
      paramDownloadParams.url = new URL(paramOutputStream[0]);
      paramDownloadParams.urlStr = paramOutputStream[0];
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav", 4, "favimage download: " + paramOutputStream[0] + " -> " + str1);
      }
      str3 = str1 + ".tmp";
      paramOutputStream = new File(str3);
      if (paramOutputStream.exists()) {
        paramOutputStream.delete();
      }
      paramURLDrawableHandler.publishProgress(0);
    }
    for (;;)
    {
      try
      {
        paramOutputStream = new FileOutputStream(str3);
      }
      catch (Exception paramOutputStream)
      {
        File localFile;
        label404:
        label410:
        paramOutputStream = null;
      }
      try
      {
        new HttpDownloader().a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        paramOutputStream.close();
        paramURLDrawableHandler = new File(str3);
        localFile = new File(str1);
        if (!paramURLDrawableHandler.renameTo(localFile))
        {
          FileUtils.a(paramURLDrawableHandler, localFile);
          paramURLDrawableHandler.delete();
        }
        QfavReport.a(this.a.waitAppRuntime(null), false, new File(str1).length());
        paramDownloadParams.url = ((URL)localObject);
        paramDownloadParams.urlStr = str2;
        paramOutputStream = new File(str1);
        if ((!paramOutputStream.exists()) || (paramOutputStream.length() <= 0L)) {
          break label451;
        }
        return paramOutputStream;
      }
      catch (Exception paramURLDrawableHandler)
      {
        for (;;) {}
      }
      i = 0;
      break;
      i = 0;
      break label100;
      if (paramOutputStream != null) {
        paramOutputStream.close();
      }
      new File(str3).delete();
    }
    label451:
    paramOutputStream.delete();
    QLog.e("qqfav.FavoriteImageDownloader", 1, "downloadImage|file not exist or empty. filepath=" + str1);
    throw new IOException("File not Found. url: " + paramDownloadParams.url);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramFile == null) {
      return null;
    }
    if (GifDrawable.isGifFile(paramFile)) {
      return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
    }
    if (5 == FileManagerUtil.a(paramFile.getName()))
    {
      paramDownloadParams = FileCategoryUtil.b(this.a, paramFile.getPath());
      if (paramDownloadParams != null)
      {
        if ((paramDownloadParams instanceof BitmapDrawable)) {
          return ((BitmapDrawable)paramDownloadParams).getBitmap();
        }
        paramFile = Bitmap.createBitmap(paramDownloadParams.getIntrinsicWidth(), paramDownloadParams.getIntrinsicHeight(), Bitmap.Config.RGB_565);
        paramURLDrawableHandler = new Canvas(paramFile);
        paramDownloadParams.setBounds(0, 0, paramURLDrawableHandler.getWidth(), paramURLDrawableHandler.getHeight());
        paramDownloadParams.draw(paramURLDrawableHandler);
        return paramFile;
      }
    }
    paramFile = paramFile.getPath();
    if (!TextUtils.isEmpty(paramFile)) {
      try
      {
        paramFile = BitmapFactory.decodeFile(paramFile);
        return paramFile;
      }
      catch (OutOfMemoryError paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\FavoriteImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */