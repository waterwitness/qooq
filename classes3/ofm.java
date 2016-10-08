import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ofm
  extends BroadcastReceiver
{
  public ofm(BlessActivity paramBlessActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) {
      BlessActivity.a(this.a, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */