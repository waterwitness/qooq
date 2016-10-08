import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import mqq.os.MqqHandler;

public class qsl
  implements Runnable
{
  public qsl(DynamicAvatarManager paramDynamicAvatarManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (DynamicFaceDrawable.a)
    {
      DynamicFaceDrawable.b = false;
      ThreadManager.c().post(new qsm(this));
      this.a.c();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */