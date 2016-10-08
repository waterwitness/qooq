import android.os.Process;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pum
  implements Runnable
{
  public pum(BrowserAppInterface paramBrowserAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */