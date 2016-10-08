import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class vcl
  implements Runnable
{
  public vcl(TransFileController paramTransFileController, String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    CompressInfo localCompressInfo = new CompressInfo(this.jdField_a_of_type_JavaLangString, 0);
    localCompressInfo.f = 0;
    CompressOperator.a(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, ".uploadPhoto(), img_path = " + localCompressInfo.e);
    }
    if (!StringUtil.b(localCompressInfo.e))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.jdField_a_of_type_Boolean = true;
      localTransferRequest.i = localCompressInfo.e;
      localTransferRequest.b = 22;
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new vcm(this);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(localTransferRequest);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */