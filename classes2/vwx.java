import android.app.Application;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

public final class vwx
  implements Runnable
{
  public vwx(Application paramApplication)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    UnifiedDebugManager.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */