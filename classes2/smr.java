import android.view.View;
import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class smr
  implements ActionSheet.OnButtonClickListener
{
  public smr(FreshNewsFragment paramFreshNewsFragment)
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
      if (this.a.a != null) {
        this.a.a.dismiss();
      }
      return;
      FreshNewsUtil.a(this.a.getActivity(), 9, this.a.getActivity().getClass().getName(), null);
      continue;
      this.a.b = FreshNewsUtil.a(this.a.getActivity(), 2, this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */