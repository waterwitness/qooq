import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class mho
  implements Runnable
{
  public mho(RecentLoginDevActivity paramRecentLoginDevActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((RecentLoginDevActivity.a(this.a) == null) && (!this.a.isFinishing())) {
        RecentLoginDevActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
      }
      if ((RecentLoginDevActivity.a(this.a) != null) && (!RecentLoginDevActivity.a(this.a).isShowing())) {
        RecentLoginDevActivity.a(this.a).show();
      }
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */