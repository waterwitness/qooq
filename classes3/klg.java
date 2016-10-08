import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.AuthDevForRoamMsgActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class klg
  implements Handler.Callback
{
  public klg(AuthDevForRoamMsgActivity paramAuthDevForRoamMsgActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.a.findViewById(2131303043).setEnabled(true);
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramMessage.arg1 == 0) {
      QQToast.a(this.a.getApplicationContext(), 2, "开启保护成功", 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.a.setResult(1);
      this.a.finish();
      return false;
      QQToast.a(this.a.getApplicationContext(), 2, "开启保护失败", 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */