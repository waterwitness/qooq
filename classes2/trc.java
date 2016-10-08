import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;

public class trc
  implements Runnable
{
  public trc(OlympicManager paramOlympicManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b(OlympicManager.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */