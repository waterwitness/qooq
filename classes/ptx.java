import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ptx
  implements Runnable
{
  public ptx(BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LeakInspector.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ptx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */