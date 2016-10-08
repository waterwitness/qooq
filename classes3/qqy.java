import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qqy
  implements Runnable
{
  public qqy(ArkLocalAppMgr paramArkLocalAppMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ThreadManager.a(new qqz(this), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */