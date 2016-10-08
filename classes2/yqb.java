import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqb
  extends BroadcastReceiver
{
  public yqb(RecordSVInteractActivity paramRecordSVInteractActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.qzone.live.RECORD_CLOSE".equals(paramIntent.getAction())) {
      this.a.p();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */