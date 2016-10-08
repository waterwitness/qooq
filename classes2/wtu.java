import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.applist.WebAppActivity;

public class wtu
  implements View.OnLongClickListener
{
  public wtu(WebAppActivity paramWebAppActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */