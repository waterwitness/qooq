import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class mhp
  implements Runnable
{
  public mhp(RecentLoginDevActivity paramRecentLoginDevActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((RecentLoginDevActivity.a(this.a) != null) && (RecentLoginDevActivity.a(this.a).isShowing()))
      {
        RecentLoginDevActivity.a(this.a).dismiss();
        RecentLoginDevActivity.a(this.a).cancel();
      }
      RecentLoginDevActivity.a(this.a, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */