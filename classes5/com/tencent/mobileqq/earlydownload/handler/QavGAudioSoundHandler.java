package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QavGAudioSoundData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QavGAudioSoundHandler
  extends EarlyHandler
{
  public static final String a = "QavGAudioSoundHandler";
  public static final String b = "qq.android.qav.muteaudio";
  
  public QavGAudioSoundHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.muteaudio", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Class a()
  {
    return QavGAudioSoundData.class;
  }
  
  public String a()
  {
    return "qavDownloadGAudioSoundDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavGAudioSoundHandler", 2, "download success: " + paramString);
    }
    try
    {
      FileUtils.a(paramString, GAudioSoundUtil.a(), false);
      super.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QavGAudioSoundData localQavGAudioSoundData = (QavGAudioSoundData)a();
    if ((localQavGAudioSoundData != null) && (!localQavGAudioSoundData.autoDownload))
    {
      localQavGAudioSoundData.autoDownload = true;
      EarlyDataFactory.a(localQavGAudioSoundData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean d_()
  {
    QavGAudioSoundData localQavGAudioSoundData = (QavGAudioSoundData)a();
    if (localQavGAudioSoundData == null) {
      return super.d_();
    }
    return localQavGAudioSoundData.autoDownload;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QavGAudioSoundHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */