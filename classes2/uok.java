import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;

public class uok
  implements Runnable
{
  public uok(SecSpyFileManager paramSecSpyFileManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    UnifiedDebugManager.a(this.a.a.getApplication());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */