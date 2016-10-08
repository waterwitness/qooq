import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class yso
  extends BroadcastReceiver
{
  private WeakReference a;
  
  public yso(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramActivity);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.get() != null) {
      ((Activity)this.a.get()).finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */