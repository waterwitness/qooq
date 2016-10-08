import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.sensewhere.SenseWhereManager;
import mqq.os.MqqHandler;

public class uoo
  implements Runnable
{
  public uoo(SenseWhereManager paramSenseWhereManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a();
    this.a.b();
    ThreadManager.b().postDelayed(SenseWhereManager.a(this.a), SenseWhereManager.a() * 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uoo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */