import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.C2BAuthorityActivity;

public class ybz
  extends BroadcastReceiver
{
  public ybz(C2BAuthorityActivity paramC2BAuthorityActivity)
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */