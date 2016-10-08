import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopCreateEnterActivity;

public final class vlj
  implements View.OnClickListener
{
  public vlj(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a instanceof Activity)) {
      TroopCreateEnterActivity.a((Activity)this.a, 2, 51);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vlj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */