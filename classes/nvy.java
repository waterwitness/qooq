import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class nvy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public nvy(BaseTroopChatPie paramBaseTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    if (this.a.J)
    {
      this.a.J = false;
      BaseTroopChatPie.a(this.a).sendEmptyMessageDelayed(23, 100L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseTroopChatPie", 2, " doOnCreate_initUI onGlobalLayout");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */