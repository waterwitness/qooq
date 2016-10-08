import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class gkj
  implements Runnable
{
  public gkj(RandomController paramRandomController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.a().removeCallbacks(this.a.c);
    if (!this.a.a.g) {
      PopupDialog.a(this.a.a.a().getApplicationContext(), this.a.a.a().getResources().getString(2131363822), RandomController.a(this.a, this.a.q));
    }
    do
    {
      RandomController localRandomController;
      while (this.a.q > 60)
      {
        this.a.a.a().postDelayed(this.a.c, 60000L);
        localRandomController = this.a;
        localRandomController.q -= 60;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "backgroud remainBlockTime : " + this.a.q);
        }
      }
      if ((this.a.q <= 60) && (this.a.q > 0))
      {
        this.a.a.a().postDelayed(this.a.c, 10000L);
        localRandomController = this.a;
        localRandomController.q -= 10;
        return;
      }
    } while (this.a.q > 0);
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */