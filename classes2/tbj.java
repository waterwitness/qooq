import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.QLog;

public class tbj
  implements Runnable
{
  public tbj(MagicfaceViewController paramMagicfaceViewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(MagicfaceViewController.a, 2, "func run, magicValue:" + MagicfaceViewController.a(this.a).magicValue);
    }
    this.a.a(MagicfaceViewController.a(this.a), 1, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */