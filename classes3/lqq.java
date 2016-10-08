import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqq
  implements Runnable
{
  public lqq(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Leba.b(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */