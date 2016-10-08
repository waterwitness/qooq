import android.os.Handler;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nwm
  extends MessageObserver
{
  public nwm(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    this.a.a.sendEmptyMessage(0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nwm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */