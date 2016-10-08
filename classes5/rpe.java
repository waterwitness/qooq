import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rpe
  implements Runnable
{
  public rpe(MPFileVerifyPwdView paramMPFileVerifyPwdView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MPFileVerifyPwdView.b(this.a).setEnabled(true);
    MPFileVerifyPwdView.b(this.a).setTextColor(Color.parseColor("#00a5e0"));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */