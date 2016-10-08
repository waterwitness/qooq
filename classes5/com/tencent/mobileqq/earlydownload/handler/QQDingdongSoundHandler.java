package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.utils.DingdongSoundUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QQDingdongSoundData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QQDingdongSoundHandler
  extends EarlyHandler
{
  public static final String a = "QQDingdongSoundHandler";
  public static final String b = "qq.android.dingdong.ring";
  
  public QQDingdongSoundHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.dingdong.ring", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Class a()
  {
    return QQDingdongSoundData.class;
  }
  
  public String a()
  {
    return "dingdongDownloadAudioSoundDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDingdongSoundHandler", 2, "download success: " + paramString);
    }
    try
    {
      FileUtils.a(paramString, DingdongSoundUtil.a(), false);
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
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)a();
    if ((localQQDingdongSoundData != null) && (!localQQDingdongSoundData.autoDownload))
    {
      localQQDingdongSoundData.autoDownload = true;
      EarlyDataFactory.a(localQQDingdongSoundData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean d_()
  {
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)a();
    if (localQQDingdongSoundData == null) {
      return super.d_();
    }
    return localQQDingdongSoundData.autoDownload;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\QQDingdongSoundHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */