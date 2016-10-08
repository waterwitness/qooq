import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class odp
  implements AnonymousChatHelper.AnonymousStatusListener
{
  public odp(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.a.a))) {
      TroopChatPie.l(this.a).post(new odq(this, paramString2));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */