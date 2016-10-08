package com.tencent.mobileqq.shortvideo;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.prediction.PredictionReporter;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.ArrayList;

public class ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler
  implements FileTransferManager.Callback
{
  public View a;
  private ShortVideoReq jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
  
  public ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler(ShortVideoPreDownloaderWithSdkSupport paramShortVideoPreDownloaderWithSdkSupport, ShortVideoReq paramShortVideoReq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.a());
  }
  
  private void a()
  {
    if (!ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport))
    {
      TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport, true);
    }
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      if (ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport) == null) {
        ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport, TVK_SDKMgr.getProxyFactory());
      }
      if (ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport) != null)
      {
        if (ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport) == null) {
          ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport, ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport).getCacheMgr(BaseApplicationImpl.getContext()));
        }
        if (ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport) != null)
        {
          TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
          String str = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a, "mp4");
          localTVK_PlayerVideoInfo.setConfigMap("file_dir", str);
          localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160518");
          localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(ShortVideoUtils.a()));
          localTVK_PlayerVideoInfo.setVid(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.getMd5());
          ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport).preLoadVideoByUrl(BaseApplicationImpl.getContext(), ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport)[0], null, localTVK_PlayerVideoInfo);
          if (QLog.isColorLevel()) {
            QLog.d(ShortVideoPreDownloader.a, 2, "pre-download handle short video:" + str);
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.setBitValue(0, (byte)1);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.serial();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.a.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.frienduin, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.istroop, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.uniseq, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.msgData);
          PredictionReporter.a(1000, 100);
        }
      }
    }
    for (;;)
    {
      BaseShortVideoOprerator.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.a, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(ShortVideoPreDownloader.a, 2, "pre-download handle short video but sdk not installed");
      }
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ShortVideoPreDownloader.a, 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2);
    }
    if (paramFileMsg.jdField_c_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.uniseq) {}
    while ((paramFileMsg.e != 6) && (paramFileMsg.e != 17) && (paramFileMsg.e != 9) && (paramFileMsg.e != 20)) {
      return;
    }
    switch (paramFileMsg.Z)
    {
    default: 
      return;
    case 2002: 
      if (QLog.isColorLevel()) {
        QLog.d(ShortVideoPreDownloader.a, 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (paramFileMsg.jdField_c_of_type_ArrayOfJavaLangString != null)
      {
        ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport, paramFileMsg.jdField_c_of_type_ArrayOfJavaLangString);
        ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport, paramFileMsg.w);
        paramInt1 = 0;
      }
      break;
    case 2004: 
    case 2005: 
    case 5001: 
    case 5002: 
      while (paramInt1 < 1)
      {
        if (!StringUtil.b(ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport)))
        {
          paramView = new StringBuilder();
          paramFileMsg = ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport);
          paramFileMsg[paramInt1] = (paramFileMsg[paramInt1] + "&txhost=" + ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport));
        }
        paramInt1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(ShortVideoPreDownloader.a, 2, "STATUS_RECV_FAILED");
        }
        ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport).remove(this);
        return;
      }
      a();
    }
    ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport).remove(this);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */