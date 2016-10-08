import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager.OnSdCardChangedListener;

public class usx
  extends BroadcastReceiver
{
  public usx(StorageManager paramStorageManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {}
    do
    {
      do
      {
        return;
        paramContext = this.a.c;
        this.a.c();
      } while ((this.a.a == null) || (paramContext.equals(this.a.c)));
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED"))
      {
        this.a.b();
        this.a.a.a(0, this.a.c);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.MEDIA_MOUNTED"));
    this.a.a.a(1, this.a.c);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */