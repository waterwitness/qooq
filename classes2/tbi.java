import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

public class tbi
  implements Runnable
{
  public tbi(MagicfaceViewController paramMagicfaceViewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MagicfaceViewController.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */