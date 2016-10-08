import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lnw
  extends FriendListObserver
{
  public lnw(GesturePWDUnlockActivity paramGesturePWDUnlockActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.app.a()))) {}
    while (this.a.a == null) {
      return;
    }
    paramString = this.a.app.a(this.a.app.a(), (byte)3, false);
    this.a.a.setImageBitmap(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */