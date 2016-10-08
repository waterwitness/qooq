import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import java.lang.ref.WeakReference;

class rin
  implements ThemeDiyStyleLogic.StyleCallBack
{
  rin(rhz paramrhz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int callback(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    paramResData = (MessengerService)rhz.a(this.a).get();
    Bundle localBundle;
    if (paramResData != null)
    {
      localBundle = new Bundle();
      localBundle.putString("themeId", paramBundle.getString("themeId"));
      if (paramInt2 != 4) {
        break label73;
      }
    }
    label73:
    for (paramInt1 = 0;; paramInt1 = -2)
    {
      localBundle.putInt("themeStatus", paramInt1);
      paramBundle.putBundle("response", localBundle);
      paramResData.a(paramBundle);
      return 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */