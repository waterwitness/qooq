import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class rzw
  extends BroadcastReceiver
{
  public rzw()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getBundleExtra("param");
    paramIntent = paramIntent.getStringExtra("url");
    UniformDownloadMgr.a().a(paramIntent, paramContext);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */