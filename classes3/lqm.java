import android.view.ViewStub;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqm
  implements Runnable
{
  public lqm(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ViewStub localViewStub = (ViewStub)this.a.a(2131298405);
    ((CommonLoadingView)this.a.a(2131297685)).setVisibility(8);
    localViewStub.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */