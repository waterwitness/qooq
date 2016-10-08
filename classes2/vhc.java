import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class vhc
  implements View.OnClickListener
{
  public vhc(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298355: 
      TroopAvatarWallPreviewActivity.b(this.a);
      return;
    case 2131298356: 
      TroopAvatarWallPreviewActivity.c(this.a);
      return;
    case 2131298357: 
      TroopAvatarWallPreviewActivity.d(this.a);
      return;
    }
    TroopAvatarWallPreviewActivity.e(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */