import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopPrivateSettingActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class mwj
  extends BizTroopObserver
{
  public mwj(TroopPrivateSettingActivity paramTroopPrivateSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramInt2 != 0) && (this.a.b.equals(paramString1)))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        QQToast.a(this.a, paramString2, 0).b(this.a.getTitleBarHeight());
      }
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */