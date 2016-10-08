import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QlinkStandardDialogActivity;

public class yfe
  extends BroadcastReceiver
{
  public yfe(QlinkStandardDialogActivity paramQlinkStandardDialogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.finishdlg".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */