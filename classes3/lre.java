import android.text.TextUtils;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class lre
  extends FriendListObserver
{
  public lre(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((QZoneManagerImp)this.a.a.getManager(9) == null) {
      return;
    }
    Leba.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */