import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class sll
  extends Handler
{
  public sll(ForwardSdkBaseOption paramForwardSdkBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      QQToast.a(this.a.a, "网络异常", 0).a();
    }
    while (1 != paramMessage.what) {
      return;
    }
    this.a.a.setResult(-1);
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */