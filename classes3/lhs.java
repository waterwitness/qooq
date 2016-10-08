import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.EditTagActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lhs
  extends Handler
{
  public lhs(EditTagActivity paramEditTagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.setResult(-1);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */