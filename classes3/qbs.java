import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qbs
  implements Runnable
{
  public qbs(NewFriendManager paramNewFriendManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b();
    NewFriendManager.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */