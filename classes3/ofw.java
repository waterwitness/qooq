import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ofw
  implements Runnable
{
  public ofw(BlessManager paramBlessManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool2 = false;
    if ((BlessManager.a(this.a) != null) && (BlessManager.a(this.a) != null))
    {
      if ((!BlessManager.a(this.a)) || (!BlessManager.b(this.a)))
      {
        BlessManager.b(this.a, BlessManager.a(this.a, BlessManager.a(this.a)));
        BlessManager.c(this.a, BlessManager.a(this.a, BlessManager.a(this.a)));
        BlessManager localBlessManager = this.a;
        boolean bool1 = bool2;
        if (BlessManager.a(this.a))
        {
          bool1 = bool2;
          if (BlessManager.b(this.a)) {
            bool1 = true;
          }
        }
        BlessManager.a(localBlessManager, bool1);
      }
      return;
    }
    BlessManager.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */