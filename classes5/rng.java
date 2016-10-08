import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rng
  implements View.OnClickListener
{
  public rng(FMActivity paramFMActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FMActivity.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */