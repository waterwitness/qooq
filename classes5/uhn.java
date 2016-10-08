import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class uhn
  implements ActionSheet.OnButtonClickListener
{
  public uhn(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.a.dismiss();
    switch (paramInt)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (System.currentTimeMillis() - this.a.d <= 1300L);
      this.a.e();
      return;
    }
    EditActivity.a(this.a).locationText = null;
    EditActivity.c(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */