import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import cooperation.c2b.C2BUploadFileActivity;

public class xzn
  extends TransProcessorHandler
{
  public xzn(C2BUploadFileActivity paramC2BUploadFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((this.a.a == null) || (localFileMsg == null) || (localFileMsg.jdField_f_of_type_Int != 13)) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 1001: 
      case 1004: 
      default: 
        return;
      }
    } while (localFileMsg.jdField_a_of_type_Long <= 0L);
    int i = (int)(localFileMsg.jdField_f_of_type_Long * 100L / localFileMsg.jdField_a_of_type_Long);
    this.a.a(i);
    return;
    paramMessage = ((NearbyPeoplePhotoUploadProcessor)localFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor).k;
    this.a.b("http://" + paramMessage);
    return;
    this.a.a("上传文件失败！");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */