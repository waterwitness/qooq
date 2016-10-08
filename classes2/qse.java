import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class qse
  implements Runnable
{
  public qse(DynamicAvatarManager paramDynamicAvatarManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (DynamicAvatarManager.a(this.a) != null) {
      ShortVideoUtils.a(DynamicAvatarManager.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */