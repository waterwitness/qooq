import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nwd
  extends Handler
{
  public nwd(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.i.isShown()) {
      this.a.i.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */