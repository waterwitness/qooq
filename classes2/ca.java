import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ca
  implements View.OnClickListener
{
  public ca(LiteVideoActivity paramLiteVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a) && (NetworkUtil.h(this.a)) && (!NetworkUtil.i(this.a)) && (LiteVideoActivity.a(this.a) > LiteVideoActivity.a()))
    {
      LiteVideoActivity.a(this.a);
      return;
    }
    LiteVideoActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */