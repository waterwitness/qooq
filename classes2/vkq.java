import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vkq
  implements ActionSheet.OnButtonClickListener
{
  public vkq(TroopLocationModifyActivity paramTroopLocationModifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    TroopLocationModifyActivity.a(this.a);
    if (paramInt == 0) {
      TroopLocationModifyActivity.a(this.a, "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */