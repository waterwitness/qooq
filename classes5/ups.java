import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

public class ups
  implements Runnable
{
  ShortVideoUploadInfo jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
  
  public ups(BaseShortVideoOprerator paramBaseShortVideoOprerator, ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo = paramShortVideoUploadInfo;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo == null) {}
    for (;;)
    {
      return;
      ShortVideoUploadInfo localShortVideoUploadInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
      Object localObject;
      int i;
      if (!localShortVideoUploadInfo.b)
      {
        localObject = (MessageForShortVideo)localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject;
        i = 0;
      }
      while (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.jdField_b_of_type_JavaLangString = ((MessageRecord)localObject).selfuin;
        localTransferRequest.c = ((MessageRecord)localObject).frienduin;
        localTransferRequest.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localTransferRequest.jdField_b_of_type_Int = 6;
          label103:
          localTransferRequest.jdField_a_of_type_Long = ((MessageRecord)localObject).uniseq;
          localTransferRequest.jdField_a_of_type_Boolean = true;
          localTransferRequest.e = localShortVideoUploadInfo.jdField_a_of_type_Int;
          localTransferRequest.f = localShortVideoUploadInfo.e;
          localTransferRequest.i = (localShortVideoUploadInfo.h + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.j + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.f + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.jdField_g_of_type_JavaLangString);
          localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator;
          localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
          localTransferRequest.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
          if (!localShortVideoUploadInfo.d)
          {
            if (localShortVideoUploadInfo.b) {
              break label418;
            }
            this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
          }
        }
        for (;;)
        {
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          Logger.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.f, "doSendShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
          return;
          if (localShortVideoUploadInfo.jdField_g_of_type_Int == 0)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a(localShortVideoUploadInfo);
            i = 1;
            break;
          }
          if (localShortVideoUploadInfo.jdField_g_of_type_Int != 1) {
            break label434;
          }
          localObject = (MessageForShortVideo)localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject;
          i = 0;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localTransferRequest.jdField_b_of_type_Int = 17;
            break label103;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label103;
          }
          localTransferRequest.jdField_b_of_type_Int = 9;
          break label103;
          label418:
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoBaseShortVideoOprerator.a((MessageRecord)localObject);
          }
        }
        label434:
        localObject = null;
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ups.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */