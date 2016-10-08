import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.startup.director.StartupDirector;

public class utj
  implements Runnable
{
  public utj(StartupDirector paramStartupDirector) {}
  
  public void run()
  {
    ThreadManager.b();
    ThreadOptimizer.a().a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\utj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */