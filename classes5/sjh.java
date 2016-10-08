import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public final class sjh
  implements ActionSheet.OnButtonClickListener
{
  public sjh(ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */