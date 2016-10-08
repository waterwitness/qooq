import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;

public class vix
  implements View.OnClickListener
{
  public vix(TroopCreateAvatarActivity paramTroopCreateAvatarActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.a.putExtra("isBack", 1);
    this.a.setResult(-1, this.a.a);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */