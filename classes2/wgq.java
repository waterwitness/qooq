import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.QbSdk;

public final class wgq
  implements Runnable
{
  public wgq(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QbSdk.preInit(this.a.getApplicationContext(), new wgr(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */