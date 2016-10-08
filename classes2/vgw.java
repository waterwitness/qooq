import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class vgw
  implements View.OnClickListener
{
  public vgw(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296815: 
      paramView = (ActionSheet)ActionSheetHelper.a(this.a, null);
      paramView.a(2131370107, 3);
      paramView.d(2131367262);
      paramView.a(new vgx(this, paramView));
      paramView.show();
      return;
    }
    TroopAvatarWallPreviewActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */