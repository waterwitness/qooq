import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

public class leb
  extends TransProcessorHandler
{
  public leb(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((Conversation.a(this.a) == null) || (localFileMsg == null) || (TextUtils.isEmpty(localFileMsg.r))) {}
    do
    {
      int k;
      int i;
      do
      {
        return;
        k = paramMessage.what;
        if (localFileMsg.e != 1)
        {
          i = j;
          if (localFileMsg.e != 2) {}
        }
        else if ((k != 1001) && (k != 1002) && (k != 1000) && (k != 1005))
        {
          i = j;
          if (k != 1003) {}
        }
        else
        {
          i = 1;
        }
      } while ((i == 0) && (((k != 1003) && (k != 2003)) || ((localFileMsg.e != 2) && (!Conversation.a(this.a)))));
      this.a.a(8, localFileMsg.r, Integer.MIN_VALUE);
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "refresh recent, from_transferListener2");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\leb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */