package com.tencent.mobileqq.transfile;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.VoiceGifFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class PicEmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  private static final String S = "emoticon_key";
  private static final String k = "PicEmotionDownloader";
  private BitmapFactory.Options a;
  protected BaseApplicationImpl a;
  
  public PicEmotionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inScreenDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Bitmap a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString1 = EmoticonUtils.m.replace("[epId]", paramString1).replace("[eId]", paramString2); !TextUtils.isEmpty(paramString1); paramString1 = EmoticonUtils.l.replace("[epId]", paramString1).replace("[eId]", paramString2)) {
      try
      {
        paramString2 = BitmapFactory.decodeFile(paramString1, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
        return paramString2;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.e("PicEmotionDownloader", 1, "decode oom11 :path = " + paramString1);
        return null;
      }
    }
    return null;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| useGifAnimation=" + paramDownloadParams.useGifAnimation + " url.toString=" + paramDownloadParams.url.toString());
    }
    if (!(paramDownloadParams.tag instanceof Emoticon)) {
      throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }
    Emoticon localEmoticon = (Emoticon)paramDownloadParams.tag;
    paramURLDrawableHandler = paramDownloadParams.getHeader("my_uin");
    paramOutputStream = null;
    if (paramURLDrawableHandler != null) {
      paramOutputStream = paramURLDrawableHandler.getValue();
    }
    if (TextUtils.isEmpty(paramOutputStream))
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| uin is null");
      throw new FileDownloadFailedException(9302, 0L, "can't find myUin!", false, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| myUin:" + paramOutputStream);
    }
    Bundle localBundle;
    try
    {
      paramURLDrawableHandler = (AppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramOutputStream);
      if (paramURLDrawableHandler == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage app is null");
        }
        throw new FileDownloadFailedException(9301, 0L, "qqAppInterface is null", false, false);
      }
    }
    catch (Throwable paramOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "exception:" + paramOutputStream.getMessage());
      }
      paramOutputStream = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (i = 4;; i = 0)
      {
        paramOutputStream = paramOutputStream.getSharedPreferences("Last_Login", i).getString("uin", "");
        paramURLDrawableHandler = (AppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramOutputStream);
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage| a second time: uin->" + paramOutputStream);
        }
        break;
      }
      localBundle = new Bundle();
      paramDownloadParams.tag = localBundle;
      localBundle.putSerializable("emoticon_key", localEmoticon);
      if ((paramURLDrawableHandler instanceof QQAppInterface)) {
        break label527;
      }
    }
    if (localEmoticon.jobType == 3)
    {
      paramOutputStream = new String[2];
      paramOutputStream[0] = EmoticonUtils.c.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
      paramOutputStream[1] = EmoticonUtils.l.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
      i = DownloaderFactory.a(new DownloadTask(paramOutputStream[0], new File(paramOutputStream[1])), paramURLDrawableHandler);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "download small emoji, ret:" + i);
      }
    }
    return new File(AppConstants.bj);
    label527:
    paramOutputStream = paramDownloadParams.getHeader("emo_type");
    boolean bool2 = EmoticonUtils.a();
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (paramOutputStream != null) {
        bool2 = paramOutputStream.getValue().equals(String.valueOf(2));
      }
      paramOutputStream = paramDownloadParams.getHeader("emo_big");
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (paramOutputStream != null) {
          bool1 = paramOutputStream.getValue().equals("true");
        }
      }
    }
    if (localEmoticon.jobType == 3) {}
    for (int i = 2;; i = 1)
    {
      paramOutputStream = paramDownloadParams.url.getHost();
      if (paramOutputStream != null) {
        break;
      }
      QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
    }
    if (paramOutputStream.equals("fromPanel"))
    {
      i = 2;
      paramOutputStream = "panel_preview";
    }
    for (;;)
    {
      localBundle.putString("display_type", paramOutputStream);
      paramOutputStream = (EmojiManager)paramURLDrawableHandler.getManager(42);
      if (!paramOutputStream.c(localEmoticon, i)) {}
      for (bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "need download:" + bool1);
        }
        if (!bool1) {
          break;
        }
        bool1 = paramOutputStream.b(localEmoticon, i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "downloadImage| downloadAIOEmoticon result=" + bool1 + " eId: " + localEmoticon.eId);
        }
        if (bool1) {
          break;
        }
        QLog.e("PicEmotionDownloader", 1, "emotion down fail : epid = " + localEmoticon.epId + ";eid = " + localEmoticon.eId);
        throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
        if ((!paramOutputStream.equals("fromAIO")) || (!bool1)) {
          break label941;
        }
        if (localEmoticon.jobType == 3) {}
        for (i = 6;; i = 4)
        {
          if (!localEmoticon.isSound) {
            break label934;
          }
          paramOutputStream = "big_sound";
          i = 12;
          break;
        }
      }
      label934:
      paramOutputStream = "big_img";
      continue;
      label941:
      paramOutputStream = "aio_preview";
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramDownloadParams == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
    }
    if (!(paramDownloadParams.tag instanceof Bundle)) {
      throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }
    paramURLDrawableHandler = (Bundle)paramDownloadParams.tag;
    Emoticon localEmoticon = (Emoticon)paramURLDrawableHandler.getSerializable("emoticon_key");
    paramFile = paramDownloadParams.url.getHost();
    if (paramFile == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
    }
    paramDownloadParams = paramURLDrawableHandler.getString("display_type");
    boolean bool3 = paramFile.equals("fromAIO");
    paramFile = paramDownloadParams;
    if (bool3)
    {
      paramFile = paramDownloadParams;
      if (paramDownloadParams.equals("aio_preview"))
      {
        paramFile = paramDownloadParams;
        if (new File(EmoticonUtils.o.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId)).exists()) {
          if (!localEmoticon.isSound) {
            break label337;
          }
        }
      }
    }
    int i;
    label337:
    for (paramFile = "big_sound";; paramFile = "big_img")
    {
      i = localEmoticon.jobType;
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "showType: " + paramFile);
      }
      if ((!"big_img".equals(paramFile)) && (!"big_sound".equals(paramFile))) {
        break;
      }
      switch (i)
      {
      case 1: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile jobType not supported: " + i);
        }
        paramDownloadParams = null;
        return paramDownloadParams;
      }
    }
    paramURLDrawableHandler.putString("display_type", paramFile);
    paramFile = new File(EmoticonUtils.o.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId));
    if (!paramFile.exists())
    {
      paramFile = a(localEmoticon.epId, localEmoticon.eId, bool3);
      if ((paramFile != null) && (bool3)) {
        paramURLDrawableHandler.putString("display_type", "aio_preview");
      }
      return paramFile;
    }
    paramFile = NativeGifFactory.getNativeGifObject(paramFile, true, true, 0, 0, 0.0F);
    paramFile.setDensity(320);
    return paramFile;
    paramURLDrawableHandler.putString("display_type", paramFile);
    String str = EmoticonUtils.o.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
    if (!new File(str).exists())
    {
      paramFile = localEmoticon.epId;
      paramDownloadParams = localEmoticon.eId;
      if ((i != 3) && (bool3)) {}
      for (;;)
      {
        paramFile = a(paramFile, paramDownloadParams, bool1);
        if ((paramFile != null) && (bool3)) {
          paramURLDrawableHandler.putString("display_type", "aio_preview");
        }
        return paramFile;
        bool1 = false;
      }
    }
    for (;;)
    {
      try
      {
        if (EmosmUtils.b(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmotionDownloader", 2, "decodeFile isGifFile,path=" + str);
          }
          paramDownloadParams = new File(str);
          if ("big_img".equals(paramFile))
          {
            paramFile = NativeGifFactory.getNativeGifObject(paramDownloadParams, true, true, 0, 0, 0.0F);
            paramDownloadParams = paramFile;
            if (paramFile == null) {
              break;
            }
            paramFile.setDensity(320);
            return paramFile;
          }
        }
      }
      catch (FileNotFoundException paramFile)
      {
        QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramFile);
        return null;
        if (!"big_sound".equals(paramFile)) {
          break label893;
        }
        paramFile = VoiceGifFactory.a(paramDownloadParams, 0, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "decodeFile getDecryptFileData,path=" + str);
        }
        paramFile = EmosmUtils.b(str);
        if (paramFile == null) {
          continue;
        }
        try
        {
          paramFile = BitmapFactory.decodeByteArray(paramFile, 0, paramFile.length, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          paramDownloadParams = paramFile;
          if (paramFile != null) {
            break;
          }
          QLog.e("PicEmotionDownloader", 2, "decode MARKET File:file error" + str);
          return null;
        }
        catch (OutOfMemoryError paramFile)
        {
          QLog.e("emoticon", 1, "decode oom path = " + str);
          paramFile = null;
          continue;
        }
      }
      catch (IOException paramFile)
      {
        QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramFile);
        continue;
      }
      catch (Exception paramFile)
      {
        QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramFile);
        continue;
      }
      if (bool3)
      {
        paramFile = "aio_preview";
        paramURLDrawableHandler.putString("display_type", paramFile);
        if ((!bool3) || (i == 1) || (i == 3)) {
          break label887;
        }
      }
      label887:
      for (bool1 = bool2;; bool1 = false)
      {
        return a(localEmoticon.epId, localEmoticon.eId, bool1);
        paramFile = "panel_preview";
        break;
      }
      label893:
      paramFile = null;
    }
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\PicEmotionDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */