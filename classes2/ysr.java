import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.secmsg.SecMessagerService;
import cooperation.secmsg.SecSnapChatPicUploader;

public class ysr
  extends Handler
{
  public ysr(SecMessagerService paramSecMessagerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localBundle = paramMessage.getData();
            } while (localBundle == null);
            if (paramMessage.replyTo != null) {
              this.a.jdField_a_of_type_AndroidOsMessenger = paramMessage.replyTo;
            }
            switch (paramMessage.what)
            {
            default: 
              super.handleMessage(paramMessage);
              return;
            case 1: 
              this.a.jdField_a_of_type_AndroidOsMessenger = paramMessage.replyTo;
              return;
            case 2: 
              this.a.jdField_a_of_type_AndroidOsMessenger = null;
              return;
            }
          } while (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader == null);
          this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader.a(localBundle);
          return;
        } while (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader == null);
        this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader.b(localBundle);
        return;
      } while (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader == null);
      this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader.d(localBundle);
      return;
    } while (this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader == null);
    this.a.jdField_a_of_type_CooperationSecmsgSecSnapChatPicUploader.c(localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */