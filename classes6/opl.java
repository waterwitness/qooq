import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class opl
  extends Handler
{
  private WeakReference a;
  
  public opl(DialogBaseActivity paramDialogBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramDialogBaseActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    DialogBaseActivity localDialogBaseActivity = (DialogBaseActivity)this.a.get();
    if (localDialogBaseActivity == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        localDialogBaseActivity.a(i, bool);
        return;
        bool = false;
      }
    }
    localDialogBaseActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */