import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.ui.BaseCallbackUI;
import com.tencent.av.ui.CallbackWaitingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class gqi
  implements Runnable
{
  public gqi(CallbackWaitingActivity paramCallbackWaitingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.a.removeCallbacksAndMessages(null);
    DialogUtil.a(this.a, 230, this.a.getResources().getString(2131364024), this.a.getResources().getString(2131364025), 2131363162, 2131363162, null, new gqj(this)).show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */