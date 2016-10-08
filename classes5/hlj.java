import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class hlj
  implements ActionSheet.OnButtonClickListener
{
  public hlj(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.r) {
      return;
    }
    this.a.r = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      this.a.M();
      continue;
      this.a.z();
      continue;
      this.a.B();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */