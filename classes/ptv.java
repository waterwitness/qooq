import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;

public class ptv
  implements Runnable
{
  public ptv(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ActivityLifecycle.onResume(this.a.getActivity());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ptv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */