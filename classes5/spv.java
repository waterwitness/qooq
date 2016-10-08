import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class spv
  implements Runnable
{
  public spv(FreshNewsFeedAdapter paramFreshNewsFeedAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null) {}
    try
    {
      this.a.a.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.nearby.freshNews", 2, "showJuhuaRunnable", localThrowable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */