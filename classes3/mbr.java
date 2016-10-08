import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mbr
  implements View.OnClickListener
{
  public mbr(PublicAccountListActivity paramPublicAccountListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.a.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */