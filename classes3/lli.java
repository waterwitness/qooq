import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;

public class lli
  implements DialogInterface.OnClickListener
{
  public lli(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.g == 1) {
      VipUtils.a(this.a, 1, ProfileCardUtil.a(3));
    }
    for (;;)
    {
      this.a.z();
      return;
      if (this.a.g == 2) {
        VipUtils.b(this.a, 1, ProfileCardUtil.a(6));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */