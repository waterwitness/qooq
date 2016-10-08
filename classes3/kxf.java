import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class kxf
  extends Handler
{
  public kxf(ChatHistoryForC2C paramChatHistoryForC2C)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      this.a.a = new QQProgressDialog(this.a, this.a.getTitleBarHeight());
      this.a.a.setCancelable(false);
      this.a.a.b(2131368351);
      this.a.a.show();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */