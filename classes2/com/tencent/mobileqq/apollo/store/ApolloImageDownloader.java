package com.tencent.mobileqq.apollo.store;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ApolloImageDownloader
  extends AbsDownloader
{
  public static int a = 0;
  public static final String a = "apollo_image";
  public static int b = 2;
  private static final String b = "ApolloImageDownloader";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 1;
  }
  
  public static URLDrawable a(String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2)
  {
    return a(false, paramString1, paramURLDrawableOptions, paramString2);
  }
  
  public static URLDrawable a(boolean paramBoolean, String paramString1, URLDrawable.URLDrawableOptions paramURLDrawableOptions, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (!paramBoolean) {}
    for (String str = ApolloConstant.o + "boxcard/" + paramString1;; str = paramString1)
    {
      File localFile = new File(str);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
      if (paramURLDrawableOptions == null)
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mExtraInfo = null;
      }
      if (localURLDrawableOptions.mLoadingDrawable == null) {
        localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.e;
      }
      if (localURLDrawableOptions.mFailedDrawable == null) {
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.e;
      }
      if (localURLDrawableOptions.mExtraInfo == null) {
        localURLDrawableOptions.mExtraInfo = new ApolloImageDownloader.ApolloDrawableExtraInfo();
      }
      if ((localURLDrawableOptions.mExtraInfo instanceof ApolloImageDownloader.ApolloDrawableExtraInfo))
      {
        paramURLDrawableOptions = (ApolloImageDownloader.ApolloDrawableExtraInfo)localURLDrawableOptions.mExtraInfo;
        if (!TextUtils.isEmpty(str)) {
          paramURLDrawableOptions.jdField_a_of_type_JavaLangString = str;
        }
        if (!TextUtils.isEmpty(paramString2)) {
          paramURLDrawableOptions.b = paramString2;
        }
        if (paramURLDrawableOptions.jdField_a_of_type_Int != jdField_a_of_type_Int) {}
      }
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (localFile.exists()))
        {
          paramURLDrawableOptions = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
          paramString1 = paramURLDrawableOptions;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloImageDownloader", 2, "getDrawable file exsit path->" + str);
            paramString1 = paramURLDrawableOptions;
          }
        }
        for (;;)
        {
          return paramString1;
          try
          {
            paramString1 = URLDrawable.getDrawable(new URL("apollo_image", "", paramString1), localURLDrawableOptions);
          }
          catch (Exception paramString1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloImageDownloader", 2, paramString1.getMessage());
            }
            paramString1 = null;
          }
        }
      }
    }
  }
  
  public static final String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3) {
      return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramInt2 + "/float.gif";
    }
    return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_" + paramInt2 + "/float.png";
  }
  
  public static final String a(String paramString)
  {
    return "http://cmshow.gtimg.cn/client/img/" + paramString;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadStarted();
    }
    if ((paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof ApolloImageDownloader.ApolloDrawableExtraInfo)))
    {
      paramOutputStream = (ApolloImageDownloader.ApolloDrawableExtraInfo)paramDownloadParams.mExtraInfo;
      paramDownloadParams = paramOutputStream.jdField_a_of_type_JavaLangString;
      paramOutputStream = paramOutputStream.b;
      paramDownloadParams = new File(paramDownloadParams);
      if (paramDownloadParams.exists())
      {
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.length());
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloImageDownloader", 2, "downloadImage file exsit url->" + paramOutputStream);
        }
      }
      int i;
      do
      {
        return paramDownloadParams;
        paramDownloadParams.getParentFile().mkdirs();
        if ((BaseApplicationImpl.a != null) && (!NetworkUtil.h(BaseApplicationImpl.a)) && (paramURLDrawableHandler != null)) {
          paramURLDrawableHandler.onFileDownloadFailed(0);
        }
        DownloadTask localDownloadTask = new DownloadTask(paramOutputStream, paramDownloadParams);
        localDownloadTask.A = 1;
        localDownloadTask.n = false;
        i = DownloaderFactory.a(localDownloadTask, null);
        if (i != 0) {
          break;
        }
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.length());
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloImageDownloader", 2, "url->" + paramOutputStream + " result->0");
      return paramDownloadParams;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloImageDownloader", 2, "url->" + paramOutputStream + " result->" + i);
      }
    }
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadFailed(0);
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramFile != null) && (paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof ApolloImageDownloader.ApolloDrawableExtraInfo)) && (((ApolloImageDownloader.ApolloDrawableExtraInfo)paramDownloadParams.mExtraInfo).jdField_a_of_type_Int == jdField_a_of_type_Int)) {
      try
      {
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath());
        localBitmap = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        return localBitmap;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloImageDownloader", 2, localThrowable.getMessage());
        }
      }
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */