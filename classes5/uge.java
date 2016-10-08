import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class uge
  implements Runnable
{
  uge(ugd paramugd, UpCallBack.SendResult paramSendResult)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_Ugd.a).get(ugd.a(this.jdField_a_of_type_Ugd)) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult.a != 0) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[onSend]ResultOk id=" + ugd.a(this.jdField_a_of_type_Ugd));
      }
      this.jdField_a_of_type_Ugd.a(this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult);
    }
    label85:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PreUploadVideo", 2, "[onSend]ResultFail id=" + ugd.a(this.jdField_a_of_type_Ugd));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */