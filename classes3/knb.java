import android.app.Dialog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class knb
  implements Runnable
{
  public knb(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.e != null) && (this.a.e.isShowing())) {
      this.a.e.dismiss();
    }
    while ((this.a.f == null) || (!this.a.f.isShowing())) {
      return;
    }
    this.a.f.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\knb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */