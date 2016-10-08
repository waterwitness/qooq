import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rnj
  extends BroadcastReceiver
{
  public rnj(FMActivity paramFMActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qlink.destory.fmactivity".equalsIgnoreCase(paramIntent.getAction()))
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rnj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */