import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;

public class lff
  implements Runnable
{
  public lff(DevlockQuickLoginActivity paramDevlockQuickLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.app == null) {
      return;
    }
    Object localObject = this.a.app.a();
    localObject = FaceDrawable.a(this.a.app, 3, (String)localObject);
    this.a.runOnUiThread(new lfg(this, (Drawable)localObject));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */