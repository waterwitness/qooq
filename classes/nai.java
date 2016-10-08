import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nai
  implements View.OnClickListener
{
  public nai(VerifyCodeActivity paramVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.b) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */