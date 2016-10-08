import android.view.View;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ree
  implements ActionSheet.OnButtonClickListener
{
  public ree(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (DatingTopListActivity.a(this.a) != null) {
        DatingTopListActivity.a(this.a).dismiss();
      }
      return;
      if (!DatingTopListActivity.c(this.a))
      {
        DatingTopListActivity.c(this.a);
        this.a.b("0X800527B");
      }
      else
      {
        DatingTopListActivity.d(this.a);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */