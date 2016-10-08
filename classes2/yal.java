import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.emoticon.VipComicEmoticonUploadManager;
import tencent.im.msg.im_msg_body.RichText;

public class yal
  implements UpCallBack
{
  public yal(VipComicEmoticonUploadManager paramVipComicEmoticonUploadManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if ((paramSendResult == null) || (VipComicEmoticonUploadManager.a(this.a) == null)) {
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploader", 2, "Upload finish, id=" + paramSendResult.c);
      }
      localBundle = new Bundle();
      localBundle.putInt("result", 0);
      localBundle.putString("id", paramSendResult.c);
      VipComicEmoticonUploadManager.a(this.a).onInvokeFinish(localBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicEmoticonUploader", 2, "Upload error");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 1);
    localBundle.putInt("errCode", paramSendResult.b);
    localBundle.putString("errMsg", paramSendResult.jdField_a_of_type_JavaLangString);
    VipComicEmoticonUploadManager.a(this.a).onInvokeFinish(localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */