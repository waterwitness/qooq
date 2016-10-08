import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.ThreadRegulator.CpuBusyness;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qhh
  implements Runnable
{
  public qhh(ThreadRegulator paramThreadRegulator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ThreadRegulator.a(this.a) == null) {}
    ThreadRegulator.CpuBusyness localCpuBusyness;
    do
    {
      return;
      localCpuBusyness = ThreadRegulator.a(this.a);
      ThreadRegulator.a(this.a, null);
    } while (localCpuBusyness == null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */