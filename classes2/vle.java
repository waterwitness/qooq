import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vle
  implements ActionSheet.OnButtonClickListener
{
  public vle(TroopWebviewPlugin paramTroopWebviewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    TroopWebviewPlugin.a(this.a);
    if (paramInt == 0) {
      TroopWebviewPlugin.a(this.a, "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */