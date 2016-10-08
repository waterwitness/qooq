import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lxk
  implements Runnable
{
  lxk(lxj paramlxj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(1500L);
      this.a.a.a.a();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lxk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */