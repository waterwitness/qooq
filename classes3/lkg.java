import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class lkg
  implements View.OnLayoutChangeListener
{
  public lkg(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.a.post(new lkh(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */