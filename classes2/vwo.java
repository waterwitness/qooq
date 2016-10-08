import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.qphone.base.util.QLog;

public class vwo
  extends BroadcastReceiver
{
  public vwo(SnapshotService paramSnapshotService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("id", -1L);
    int i = paramIntent.getIntExtra("action", -1);
    if ((l == 0L) && (i == 1) && (SnapshotService.a(this.a) > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i(SnapshotService.a(), 2, "receive broadcast: destroy snapshot service");
      }
      SnapshotService.a(false);
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */