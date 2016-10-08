import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class xsl
  implements View.OnClickListener
{
  public xsl(ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (ActionSheet.a(this.a) != null) {
      ActionSheet.a(this.a).onDismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */