import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class kww
  implements Handler.Callback
{
  public kww(ChatHistoryForC2C paramChatHistoryForC2C)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      ChatHistoryForC2C.a(this.a, paramMessage);
      return true;
      ChatHistoryForC2C.b(this.a, paramMessage);
      return true;
      ChatHistoryForC2C.c(this.a, paramMessage);
      return true;
      ChatHistoryForC2C.d(this.a, paramMessage);
      return true;
      ChatHistoryForC2C.e(this.a, paramMessage);
      return true;
      ChatHistoryForC2C.f(this.a, paramMessage);
      return true;
      ChatHistoryForC2C.g(this.a, paramMessage);
      return true;
      ChatHistoryForC2C.a(this.a);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "handle_get_roam_msg_auth_mode notify UI");
      }
      if (ChatHistoryForC2C.a(this.a).e())
      {
        ChatHistoryForC2C.a(this.a, false);
        return true;
      }
      ChatHistoryForC2C.b(this.a);
      return true;
    } while (paramMessage.obj == null);
    ChatHistoryForC2C localChatHistoryForC2C = this.a;
    BaseApplication localBaseApplication = this.a.app.a();
    if (((Boolean)paramMessage.obj).booleanValue() == true) {}
    for (int i = 2131367983;; i = 2131367984)
    {
      localChatHistoryForC2C.a(localBaseApplication.getString(i));
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */