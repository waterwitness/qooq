import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

public class uxe
  extends Handler
{
  private WeakReference a;
  
  public uxe(StructMsgItemVideo paramStructMsgItemVideo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramStructMsgItemVideo);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((StructMsgItemVideo)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130840871);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */