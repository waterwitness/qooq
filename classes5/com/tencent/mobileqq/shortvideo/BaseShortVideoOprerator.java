package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;
import upp;
import upq;
import upr;
import ups;
import uqe;

public abstract class BaseShortVideoOprerator
  implements DownCallBack, UpCallBack, InfoBuilder, uqe
{
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  protected Handler a;
  public QQAppInterface a;
  public MessageRecord a;
  public ShortVideoReq a;
  protected UiCallBack a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new upp(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ShortVideoReq paramShortVideoReq)
  {
    ThreadManager.a(new upq(paramQQAppInterface, paramShortVideoReq), 8, null, false);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  protected void a(int paramInt1, int paramInt2, ShortVideoResult paramShortVideoResult)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramShortVideoResult;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramErrInfo;
    localShortVideoResult.d = -1;
    a(paramInt, -1, localShortVideoResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.g, this.f, paramErrInfo.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    Logger.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    ShortVideoResult localShortVideoResult = paramShortVideoResult;
    if (paramShortVideoResult == null) {
      localShortVideoResult = new ShortVideoResult();
    }
    localShortVideoResult.d = 0;
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    a(paramInt, 0, localShortVideoResult);
    Logger.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.d = 0;
    localShortVideoResult.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localShortVideoResult);
  }
  
  public void a(Message paramMessage)
  {
    Logger.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack == null) {}
    int i;
    ShortVideoResult localShortVideoResult;
    do
    {
      return;
      i = paramMessage.arg1;
      localShortVideoResult = (ShortVideoResult)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.a(i, localShortVideoResult);
        return;
      }
    } while (!(localShortVideoResult.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.a(((Integer)localShortVideoResult.jdField_a_of_type_JavaLangObject).intValue());
    return;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.b(i, localShortVideoResult);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Logger.a(this.g, this.f, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (paramDownResult == null)
    {
      paramDownResult = new PicInfoInterface.ErrInfo();
      paramDownResult.jdField_b_of_type_JavaLangString = "result == null";
      paramDownResult.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramDownResult);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
    Logger.a(this.g, this.f, "onDownload", "result:" + paramDownResult.jdField_a_of_type_Int);
    Object localObject = new ShortVideoResult();
    ((ShortVideoResult)localObject).d = paramDownResult.jdField_a_of_type_Int;
    ((ShortVideoResult)localObject).jdField_a_of_type_JavaLangObject = paramDownResult;
    if (paramDownResult.jdField_a_of_type_Int == 0)
    {
      a(0, (ShortVideoResult)localObject);
      return;
    }
    if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
    {
      localObject = new PicInfoInterface.ErrInfo();
      ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = (paramDownResult.jdField_b_of_type_Int + "_" + paramDownResult.jdField_a_of_type_JavaLangString);
      ((PicInfoInterface.ErrInfo)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (PicInfoInterface.ErrInfo)localObject);
      return;
    }
    a(0, paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    Logger.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramShortVideoDownloadInfo))
    {
      b(paramShortVideoDownloadInfo);
      return;
    }
    DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
    localDownResult.jdField_a_of_type_Int = -1;
    localDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramShortVideoDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    a(localDownResult);
  }
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    Logger.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramShortVideoForwardInfo)) {
      ThreadManager.b().post(new upr(this, paramShortVideoForwardInfo));
    }
    while (paramShortVideoForwardInfo == null) {
      return;
    }
    a(3, paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    Logger.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramShortVideoUploadInfo)) {
      ThreadManager.b().post(new ups(this, paramShortVideoUploadInfo));
    }
    while (paramShortVideoUploadInfo == null) {
      return;
    }
    a(2, paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = paramUiCallBack;
  }
  
  boolean a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    if (paramShortVideoDownloadInfo != null)
    {
      Logger.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + paramShortVideoDownloadInfo);
      return paramShortVideoDownloadInfo.a();
    }
    Logger.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    if (paramShortVideoForwardInfo != null)
    {
      Logger.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + paramShortVideoForwardInfo);
      return paramShortVideoForwardInfo.a();
    }
    Logger.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    if (paramShortVideoUploadInfo != null)
    {
      Logger.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + paramShortVideoUploadInfo);
      return paramShortVideoUploadInfo.a();
    }
    Logger.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(2, null);
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      localObject = new ShortVideoResult();
      ((ShortVideoResult)localObject).d = 0;
      ((ShortVideoResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(2, (ShortVideoResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
    a(2, (PicInfoInterface.ErrInfo)localObject);
  }
  
  void b(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    long l = System.currentTimeMillis();
    paramShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = paramShortVideoDownloadInfo.jdField_b_of_type_JavaLangString;
    localTransferRequest.jdField_c_of_type_JavaLangString = paramShortVideoDownloadInfo.jdField_c_of_type_JavaLangString;
    localTransferRequest.d = paramShortVideoDownloadInfo.d;
    localTransferRequest.jdField_a_of_type_Int = paramShortVideoDownloadInfo.jdField_b_of_type_Int;
    localTransferRequest.jdField_a_of_type_Long = paramShortVideoDownloadInfo.jdField_a_of_type_Long;
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.e = paramShortVideoDownloadInfo.jdField_a_of_type_Int;
    localTransferRequest.jdField_g_of_type_Int = paramShortVideoDownloadInfo.jdField_h_of_type_Int;
    localTransferRequest.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramShortVideoDownloadInfo.k);
    localTransferRequest.jdField_g_of_type_Boolean = paramShortVideoDownloadInfo.jdField_b_of_type_Boolean;
    if ((paramShortVideoDownloadInfo.jdField_g_of_type_Int == 1001) || (paramShortVideoDownloadInfo.jdField_g_of_type_Int == 1003) || (paramShortVideoDownloadInfo.jdField_g_of_type_Int == 1005) || (paramShortVideoDownloadInfo.jdField_g_of_type_Int == 1002) || (paramShortVideoDownloadInfo.jdField_g_of_type_Int == 1004) || (paramShortVideoDownloadInfo.jdField_g_of_type_Int == 1006)) {
      localTransferRequest.f = paramShortVideoDownloadInfo.e;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack != null) {
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = this;
    }
    switch (paramShortVideoDownloadInfo.jdField_g_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a != null)) {
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramShortVideoDownloadInfo.jdField_g_of_type_Int + "downloadvideo MD5==" + paramShortVideoDownloadInfo.e);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
      Logger.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
      return;
      localTransferRequest.jdField_b_of_type_Int = 7;
      localTransferRequest.i = (paramShortVideoDownloadInfo.i + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_g_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 16;
      localTransferRequest.i = (paramShortVideoDownloadInfo.i + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_g_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 18;
      localTransferRequest.i = (paramShortVideoDownloadInfo.i + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_g_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 6;
      localTransferRequest.i = (paramShortVideoDownloadInfo.jdField_h_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_g_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_c_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 9;
      localTransferRequest.i = (paramShortVideoDownloadInfo.jdField_h_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_g_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_c_of_type_Int);
      continue;
      localTransferRequest.jdField_b_of_type_Int = 17;
      localTransferRequest.i = (paramShortVideoDownloadInfo.jdField_h_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_g_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramShortVideoDownloadInfo.jdField_c_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\BaseShortVideoOprerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */