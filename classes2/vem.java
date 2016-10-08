import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;

public class vem
  implements View.OnClickListener
{
  public vem(NearbyTroopsActivity paramNearbyTroopsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    NearbyTroopsActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */