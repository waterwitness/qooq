import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class lla
  implements IIconListener
{
  public lla(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.a.a != null) && (this.a.a.a.actionId == paramInt1) && (paramInt2 == 200) && (paramBitmap != null)) {
      this.a.a.a(this.a.a.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */