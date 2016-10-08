package com.tencent.mobileqq.transfile;

import android.content.res.Resources.NotFoundException;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;

public class VasExtensionDownloader
  extends AbsDownloader
{
  public static final String S = "REDPACKET_SEND_PIC";
  public static final String a = "VasExtensionDownloader";
  public static final String b = "protocol_vas_extension_image";
  public static final String d = "EMOTICON_TAB";
  public static final String e = "EMOTICON_DIY";
  public static final String f = "FAVOROTE_PANEL";
  public static final String k = "RESOURCE_IMG";
  protected BaseApplicationImpl a;
  
  public VasExtensionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBaseApplicationImpl;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {}
    do
    {
      return null;
      paramURLDrawableHandler = paramDownloadParams.url.getHost();
      paramOutputStream = paramDownloadParams.url.getFile();
      if (!"EMOTICON_TAB".equals(paramURLDrawableHandler)) {
        break;
      }
    } while ((paramDownloadParams.mExtraInfo == null) || (paramOutputStream == null));
    if (paramOutputStream.startsWith("/")) {
      paramOutputStream = paramOutputStream.substring(1, paramOutputStream.length());
    }
    for (;;)
    {
      paramURLDrawableHandler = ((String)paramDownloadParams.mExtraInfo).split(":");
      boolean bool1 = Boolean.valueOf(paramURLDrawableHandler[0]).booleanValue();
      boolean bool2 = Boolean.valueOf(paramURLDrawableHandler[1]).booleanValue();
      label114:
      File localFile;
      if (bool2)
      {
        paramURLDrawableHandler = EmosmUtils.a(3, paramOutputStream);
        localFile = new File(paramURLDrawableHandler);
      }
      for (;;)
      {
        try
        {
          boolean bool3 = localFile.exists();
          if (bool3)
          {
            return localFile;
            paramURLDrawableHandler = EmosmUtils.a(4, paramOutputStream);
            break label114;
          }
          if (!bool2) {
            continue;
          }
          if (bool1) {
            continue;
          }
          paramOutputStream = EmosmUtils.b(3, paramOutputStream);
        }
        catch (OutOfMemoryError paramOutputStream)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("EmoticonTabAdapter", 2, "getTabDrawable OOM return null");
          paramOutputStream = null;
          continue;
        }
        if (paramOutputStream == null) {
          break;
        }
        paramDownloadParams.url = new URL(paramOutputStream);
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 4, "downloadImage : " + paramOutputStream + " -> " + paramURLDrawableHandler);
        }
        paramDownloadParams = new File(paramURLDrawableHandler);
        if (DownloaderFactory.a(new DownloadTask(paramOutputStream, paramDownloadParams), null) != 0) {
          break;
        }
        return paramDownloadParams;
        paramOutputStream = EmosmUtils.b(17, paramOutputStream);
        continue;
        if (!bool1)
        {
          paramOutputStream = EmosmUtils.b(4, paramOutputStream);
        }
        else
        {
          paramOutputStream = EmosmUtils.b(18, paramOutputStream);
          continue;
          if ("FAVOROTE_PANEL".equals(paramURLDrawableHandler))
          {
            if (TextUtils.isEmpty(paramOutputStream)) {
              break;
            }
            paramOutputStream = new File(paramOutputStream);
            if (!paramOutputStream.exists()) {
              break;
            }
            return paramOutputStream;
          }
          if ("RESOURCE_IMG".equals(paramURLDrawableHandler)) {
            break;
          }
          if ("EMOTICON_DIY".equals(paramURLDrawableHandler)) {
            return new File(AppConstants.bj);
          }
          if ("REDPACKET_SEND_PIC".equals(paramURLDrawableHandler))
          {
            paramOutputStream = BaseApplicationImpl.a.a().getAccount();
            try
            {
              paramOutputStream = (AppInterface)this.a.getAppRuntime(paramOutputStream);
              if ((paramOutputStream == null) || (!(paramOutputStream instanceof QQAppInterface)))
              {
                QLog.e("VasExtensionDownloader", 2, "downloadImage redpacket send img app ==null or app not instanceof qqapp");
                return null;
              }
            }
            catch (Throwable paramOutputStream)
            {
              for (;;)
              {
                QLog.d("VasExtensionDownloader", 2, "exception:" + paramOutputStream.getMessage());
                paramOutputStream = null;
              }
              paramOutputStream = (IndividualRedPacketManager)paramOutputStream.getManager(130);
            }
            if (paramOutputStream == null) {
              break;
            }
            paramOutputStream = paramOutputStream.a();
            if (QLog.isColorLevel()) {
              QLog.d("VasExtensionDownloader", 2, "downloadImage redpacket send img filename = " + paramOutputStream);
            }
            if (TextUtils.isEmpty(paramOutputStream)) {
              break;
            }
            return new File(paramOutputStream);
          }
          paramURLDrawableHandler = null;
          paramOutputStream = null;
        }
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {
      paramDownloadParams = null;
    }
    for (;;)
    {
      return paramDownloadParams;
      paramURLDrawableHandler = paramDownloadParams.url.getHost();
      if ("RESOURCE_IMG".equals(paramURLDrawableHandler))
      {
        paramDownloadParams = paramDownloadParams.url.getFile();
        paramFile = paramDownloadParams;
        if (paramDownloadParams.startsWith("/")) {
          paramFile = paramDownloadParams.substring(1, paramDownloadParams.length());
        }
        if (TextUtils.isEmpty(paramFile))
        {
          QLog.e("VasExtensionDownloader", 1, "decodeFile res is null ");
          return null;
        }
        try
        {
          int i = Integer.valueOf(paramFile).intValue();
          paramDownloadParams = BitmapFactory.decodeResource(BaseApplicationImpl.a().getResources(), i);
          return paramDownloadParams;
        }
        catch (NumberFormatException paramDownloadParams)
        {
          QLog.e("VasExtensionDownloader", 1, "decodeFile resid number exception res = " + paramFile);
          return null;
        }
        catch (Resources.NotFoundException paramDownloadParams)
        {
          QLog.e("VasExtensionDownloader", 1, "decodeFile res not fontexcetpion ;res = " + paramFile);
          return null;
        }
        catch (OutOfMemoryError paramDownloadParams)
        {
          QLog.e("VasExtensionDownloader", 1, "decodeFile res OutOfMemoryError ;res = " + paramFile);
          return null;
        }
      }
      if ("EMOTICON_DIY".equals(paramURLDrawableHandler)) {
        try
        {
          paramURLDrawableHandler = paramDownloadParams.url.getFile();
          if (EmosmUtils.b(paramURLDrawableHandler))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasExtensionDownloader", 2, "decodeFile isGifFile,path=" + paramURLDrawableHandler);
            }
            return NativeGifFactory.getNativeGifObject(new File(paramURLDrawableHandler), true, true, 0, 0, 0.0F);
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasExtensionDownloader", 2, "decodeFile getDecryptFileData,path=" + paramURLDrawableHandler);
          }
          paramFile = EmosmUtils.b(paramURLDrawableHandler);
          if (paramFile != null) {
            try
            {
              paramFile = BitmapFactory.decodeByteArray(paramFile, 0, paramFile.length, null);
              paramDownloadParams = paramFile;
              if (paramFile != null) {
                continue;
              }
              QLog.e("VasExtensionDownloader", 2, "decode MARKET File:file error" + paramURLDrawableHandler);
              return null;
            }
            catch (OutOfMemoryError paramFile)
            {
              for (;;)
              {
                QLog.e("emoticon", 1, "decode oom path = " + paramURLDrawableHandler);
                paramFile = null;
              }
            }
          } else {
            if (!"REDPACKET_SEND_PIC".equals(paramURLDrawableHandler)) {
              break label515;
            }
          }
        }
        catch (FileNotFoundException paramFile)
        {
          QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramFile);
          return null;
        }
        catch (IOException paramFile)
        {
          for (;;)
          {
            QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramFile);
          }
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramFile);
          }
        }
      }
    }
    if (paramFile == null)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile redpacket send pic f is null");
      return null;
    }
    paramFile = paramFile.getAbsolutePath();
    if (QLog.isColorLevel()) {
      QLog.d("VasExtensionDownloader", 2, "decodeFile redpacket send pic fileName = " + paramFile);
    }
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile redpacket send pic decode exception e = " + paramFile.getMessage());
      return null;
    }
    label515:
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\VasExtensionDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */