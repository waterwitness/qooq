import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.dataline.activities.RouterAdvanceActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ck
  extends Handler
{
  public ck(RouterAdvanceActivity paramRouterAdvanceActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (paramMessage.arg1 != 0) {
        RouterAdvanceActivity.a(this.a, paramMessage.arg1);
      }
    }
    else {
      return;
    }
    this.a.getIntent().putExtra("unbind_flag", true);
    this.a.setResult(-1, this.a.getIntent());
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */