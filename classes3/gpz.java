import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gpz
  extends BroadcastReceiver
{
  public gpz(AVLoadingDialogActivity paramAVLoadingDialogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH")) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */