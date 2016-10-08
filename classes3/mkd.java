import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SecurityPickproofActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mkd
  implements Runnable
{
  public mkd(SecurityPickproofActivity paramSecurityPickproofActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SecurityPickproofActivity.a(this.a, false);
    FMToastUtil.a(2131368805);
    SecurityPickproofActivity.a(this.a).setText(SecurityPickproofActivity.a(this.a));
    SecurityPickproofActivity.b(this.a).setVisibility(0);
    SecurityPickproofActivity.a(this.a).setVisibility(0);
    SecurityPickproofActivity.a(this.a).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mkd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */