import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.lang.ref.WeakReference;

public class xvx
  extends Handler
{
  public xvx()
  {
    super(Looper.getMainLooper());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.obj == null);
      paramMessage = ((WeakReference)paramMessage.obj).get();
    } while ((paramMessage == null) || (!(paramMessage instanceof CalloutPopupWindow)));
    ((CalloutPopupWindow)paramMessage).dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */