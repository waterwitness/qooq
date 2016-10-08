import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.huangye.HYBlankActivity;

public class ych
  implements View.OnClickListener
{
  public ych(HYBlankActivity paramHYBlankActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    HYBlankActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ych.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */