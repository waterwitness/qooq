import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import cooperation.secmsg.SecSnapChatPicUploader;
import cooperation.secmsg.SecSnapChatPicUploader.OnSnapChatUploadListener;
import cooperation.secmsg.SecSnapChatPicUploader.PicUploadInfo;
import java.util.concurrent.ConcurrentHashMap;

public class yss
  extends TransProcessorHandler
{
  public yss(SecSnapChatPicUploader paramSecSnapChatPicUploader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.e != 23)) {}
    SecSnapChatPicUploader.PicUploadInfo localPicUploadInfo;
    do
    {
      do
      {
        do
        {
          return;
          localPicUploadInfo = (SecSnapChatPicUploader.PicUploadInfo)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(localFileMsg.g));
        } while (localPicUploadInfo == null);
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1001: 
          localPicUploadInfo.jdField_a_of_type_Int = 1;
        }
      } while (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener == null);
      this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener.a(localPicUploadInfo);
      return;
      localPicUploadInfo.jdField_a_of_type_Int = 4;
      localPicUploadInfo.c = localFileMsg.k;
      localPicUploadInfo.e = localFileMsg.l;
      localPicUploadInfo.d = localFileMsg.m;
      localPicUploadInfo.jdField_b_of_type_Int = 100;
      if (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener != null) {
        this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener.a(localPicUploadInfo);
      }
      paramMessage = new Bundle();
      paramMessage.putLong("key_secmsg_id", localPicUploadInfo.jdField_a_of_type_Long);
      paramMessage.putString("key_secgroup_id", localPicUploadInfo.jdField_b_of_type_JavaLangString);
      this.a.c(paramMessage);
      return;
      localPicUploadInfo.jdField_a_of_type_Int = 5;
    } while (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener == null);
    this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener.a(localPicUploadInfo);
    return;
    localPicUploadInfo.jdField_a_of_type_Int = 2;
    if (localFileMsg.jdField_a_of_type_Long > 0L) {}
    for (int i = (int)(localFileMsg.f * 100L / localFileMsg.jdField_a_of_type_Long);; i = 0)
    {
      localPicUploadInfo.jdField_b_of_type_Int = i;
      if (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener == null) {
        break;
      }
      this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener.a(localPicUploadInfo);
      return;
      localPicUploadInfo.jdField_a_of_type_Int = 6;
      if (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener == null) {
        break;
      }
      this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader$OnSnapChatUploadListener.a(localPicUploadInfo);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */