import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

public class lqw
  extends GetRedPointExObserver
{
  public lqw(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    Leba.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */