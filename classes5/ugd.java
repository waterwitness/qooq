import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class ugd
  implements UpCallBack
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public ugd(VideoSendTaskManager paramVideoSendTaskManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreUploadVideo", 2, "[attachRichText2Msg]id=" + this.jdField_a_of_type_JavaLangString);
    }
    MessageRecord localMessageRecord = ((TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager).get(this.jdField_a_of_type_JavaLangString)).a;
    if ((localMessageRecord instanceof MessageForShortVideo)) {
      ((MessageForShortVideo)localMessageRecord).richText = paramRichText;
    }
    return localMessageRecord;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Object localObject = (TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager).get(this.jdField_a_of_type_JavaLangString);
    if ((((TransferRequest)localObject).a instanceof MessageForShortVideo))
    {
      localObject = (MessageForShortVideo)((TransferRequest)localObject).a;
      if (!TextUtils.isEmpty(paramSendResult.d)) {
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[updateMsg]id=" + this.jdField_a_of_type_JavaLangString + ", md5=" + paramSendResult.d);
      }
    }
    return;
    label93:
    LogTag.a();
    for (;;)
    {
      try
      {
        ((MessageForShortVideo)localObject).videoFileSize = ((int)paramSendResult.a);
        ((MessageForShortVideo)localObject).videoFileStatus = 1003;
        ((MessageForShortVideo)localObject).uuid = paramSendResult.jdField_c_of_type_JavaLangString;
        ((MessageForShortVideo)localObject).md5 = paramSendResult.d;
        ((MessageForShortVideo)localObject).thumbFileSize = ((int)paramSendResult.jdField_c_of_type_Long);
        ((MessageForShortVideo)localObject).serial();
        LogTag.a("PreUploadVideo", "[updateMsg]");
        paramSendResult = ShortVideoUtils.a((MessageForShortVideo)localObject, "mp4");
        if (!TextUtils.isEmpty(((MessageForShortVideo)localObject).videoFileName))
        {
          if ((!((MessageForShortVideo)localObject).videoFileName.equals(paramSendResult)) && (FileUtils.c(((MessageForShortVideo)localObject).videoFileName, paramSendResult))) {
            ((MessageForShortVideo)localObject).videoFileName = paramSendResult;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).istroop, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).msgData);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          VideoSendTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager).post(new ugf(this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager, this.jdField_a_of_type_JavaLangString));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("PreUploadVideo", 2, "[updateMsg]id=" + this.jdField_a_of_type_JavaLangString + ", mr=" + ((MessageForShortVideo)localObject).toString());
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[updateMsg] mr.videoFileName is empty");
      }
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    VideoSendTaskManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager).post(new uge(this, paramSendResult));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */