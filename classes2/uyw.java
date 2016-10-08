import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class uyw
  implements Runnable
{
  public uyw(ShareAppLogActivity paramShareAppLogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (ShareAppLogActivity.a(this.a) == null)
      {
        ShareAppLogActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        ShareAppLogActivity.a(this.a).b(2131369268);
      }
      ShareAppLogActivity.a(this.a).show();
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */