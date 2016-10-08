import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pzh
  implements View.OnClickListener
{
  public pzh(IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */