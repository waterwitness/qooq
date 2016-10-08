import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;

public class kgi
  implements View.OnClickListener
{
  public kgi(AboutActivity paramAboutActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.startActivity(ShareAppLogActivity.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */