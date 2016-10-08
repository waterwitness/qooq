import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowLoadingActivity;

public class svt
  implements View.OnClickListener
{
  public svt(NowLoadingActivity paramNowLoadingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.d)
    {
      this.a.d = false;
      this.a.a.setVisibility(8);
      NowLoadingActivity.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\svt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */