import android.app.Activity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class onl
  extends UniPayHandler.UniPayUpdateListener
{
  public onl(AvatarPendantActivity paramAvatarPendantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void update()
  {
    this.a.runOnUiThread(new onm(this));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */