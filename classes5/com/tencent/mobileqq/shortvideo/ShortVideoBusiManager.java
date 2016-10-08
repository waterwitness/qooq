package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import com.tencent.device.file.DevLittleVideoOperator;
import com.tencent.device.file.DevShortVideoOperator;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ShortVideoBusiManager
{
  public static final int a = 0;
  public static long a = 0L;
  private static final String a;
  public static boolean a = false;
  public static final int b = 1;
  public static long b = 0L;
  public static final int c = 2;
  public static final long c = 300000L;
  public static final int d = 3;
  public static final int e = 4;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ShortVideoBusiManager.class.getSimpleName();
  }
  
  static BaseShortVideoOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 2: 
    case 3: 
      return new AioShortVideoOperator(paramQQAppInterface);
    case 1: 
      return new DevShortVideoOperator(paramQQAppInterface);
    }
    return new DevLittleVideoOperator(paramQQAppInterface);
  }
  
  static InfoBuilder a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 2: 
    case 3: 
      return new AioShortVideoOperator();
    case 1: 
      return new DevShortVideoOperator();
    }
    return new DevLittleVideoOperator();
  }
  
  public static ShortVideoDownloadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static ShortVideoForwardInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static ShortVideoReq a(int paramInt1, int paramInt2)
  {
    ShortVideoReq localShortVideoReq = new ShortVideoReq();
    localShortVideoReq.f = paramInt1;
    localShortVideoReq.g = paramInt2;
    return localShortVideoReq;
  }
  
  public static ShortVideoReq a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createShortVideoReqByMsg expired");
      }
      return null;
    }
    ShortVideoReq localShortVideoReq = a(2, paramMessageForShortVideo.busiType);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.g);
    localShortVideoDownloadInfo.jdField_h_of_type_JavaLangString = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.jdField_h_of_type_Int = paramInt;
    if (paramMessageForShortVideo.busiType == 0) {
      localShortVideoDownloadInfo.b = true;
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if ((paramQQAppInterface.a()) && (paramQQAppInterface.a().equals(paramMessageForShortVideo.frienduin)))
    {
      localShortVideoDownloadInfo.k = 2;
      if ((paramMessageForShortVideo.istroop != 0) && (paramMessageForShortVideo.istroop != 1008)) {
        break label155;
      }
      localShortVideoDownloadInfo.g = 1001;
    }
    for (;;)
    {
      localShortVideoReq.a(localShortVideoDownloadInfo);
      localShortVideoReq.a(paramMessageForShortVideo);
      return localShortVideoReq;
      localShortVideoDownloadInfo.k = 1;
      break;
      label155:
      if (paramMessageForShortVideo.istroop == 3000) {
        localShortVideoDownloadInfo.g = 1005;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localShortVideoDownloadInfo.g = 1003;
      }
    }
  }
  
  public static ShortVideoUploadInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramShortVideoReq.g);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileMsg paramFileMsg, TransferRequest paramTransferRequest)
  {
    if ((paramFileMsg == null) || (paramTransferRequest == null)) {
      Logger.b(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "fileMsg or req is null");
    }
    MessageRecord localMessageRecord;
    do
    {
      return;
      if (paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        localMessageRecord = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
      while (localMessageRecord == null)
      {
        Logger.b(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "msg null");
        return;
        localMessageRecord = paramQQAppInterface.a().a(paramTransferRequest.c, paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Long);
        Logger.a(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
      }
    } while (!(localMessageRecord instanceof MessageForShortVideo));
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    if (paramFileMsg.jdField_a_of_type_Long == 0L) {}
    for (int i = 0;; i = (int)(100L * paramFileMsg.f / paramFileMsg.jdField_a_of_type_Long))
    {
      if (localMessageForShortVideo.videoFileProgress < 0) {
        localMessageForShortVideo.videoFileProgress = 0;
      }
      int j = localMessageForShortVideo.videoFileProgress;
      if (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (localMessageForShortVideo.videoFileStatus == paramFileMsg.Z) && (i - j < 10)) {
        break;
      }
      if ((paramFileMsg.e == 6) || (paramFileMsg.e == 17) || (paramFileMsg.e == 9) || (paramFileMsg.e == 20))
      {
        if (paramFileMsg.Z == 2002) {
          localMessageForShortVideo.transferedSize = ((int)paramFileMsg.f);
        }
        if (paramFileMsg.Z == 2003) {
          localMessageForShortVideo.transferedSize = 0;
        }
      }
      if (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramFileMsg.Z == 1002) || (paramFileMsg.Z == 2002))) {
        break;
      }
      localMessageForShortVideo.videoFileStatus = paramFileMsg.Z;
      localMessageForShortVideo.fileType = paramFileMsg.e;
      if ((paramFileMsg.e != 7) && (paramFileMsg.e != 16) && (paramFileMsg.e != 18)) {
        localMessageForShortVideo.videoFileProgress = i;
      }
      if ((localMessageForShortVideo.mPreUpload) && (paramFileMsg.Z == 1003) && (paramTransferRequest.f != null)) {
        localMessageForShortVideo.md5 = paramTransferRequest.f;
      }
      if (paramFileMsg.Z == 2003) {
        localMessageForShortVideo.lastModified = new File(paramTransferRequest.jdField_h_of_type_JavaLangString).lastModified();
      }
      localMessageForShortVideo.serial();
      if ((localMessageForShortVideo instanceof MessageForBlessPTV)) {
        break;
      }
      paramQQAppInterface.a().a(paramTransferRequest.c, paramTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      if ((paramFileMsg.Z != 1003) && (paramFileMsg.Z != 2003)) {
        break;
      }
      paramQQAppInterface.a().a(999, true, paramTransferRequest.c);
      Logger.a(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
      return;
    }
  }
  
  public static void a(ShortVideoReq paramShortVideoReq, QQAppInterface paramQQAppInterface)
  {
    if (paramShortVideoReq == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramShortVideoReq.g, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,busiInterface == null,req.busiType:" + paramShortVideoReq.g);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
    localBaseShortVideoOprerator.f = paramShortVideoReq.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = paramShortVideoReq.b;
    localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack);
    Logger.a(jdField_a_of_type_JavaLangString, "launch", "cmd:" + ShortVideoUtils.c(paramShortVideoReq.f) + ", reqBusiType" + paramShortVideoReq.g + ", uuid:" + paramShortVideoReq.jdField_a_of_type_JavaLangString);
    switch (paramShortVideoReq.f)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      return;
    case 1: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo);
      return;
    case 3: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo);
      return;
    }
    localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoForwardInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoBusiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */