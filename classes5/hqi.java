import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hqi
  extends BroadcastReceiver
{
  public hqi(PublicAccountManager paramPublicAccountManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.j == 1)
    {
      int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.picResultData", -1);
      paramIntent = paramIntent.getStringArrayListExtra("com.tencent.biz.pubaccount.picResult_md5s");
      this.a.a(null, 0, 13, i, paramIntent);
    }
    try
    {
      paramContext.unregisterReceiver(this.a.b);
      this.a.b = null;
      this.a.j = 0;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */