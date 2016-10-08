import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.C2BBindNumberActivity;

public class yca
  extends BroadcastReceiver
{
  public yca(C2BBindNumberActivity paramC2BBindNumberActivity)
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */