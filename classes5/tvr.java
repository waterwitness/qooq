import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class tvr
  extends CardObserver
{
  public tvr(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "user binding shoppingNo = " + paramString1 + "Threadid=" + Thread.currentThread().getId());
    }
    if ((this.a.app == null) || (this.a.isFinishing())) {}
    do
    {
      return;
      this.a.app.b(this);
      VipProfileCardPreviewActivity.a(this.a, null);
    } while (!paramBoolean);
    if ("0".equals(paramString1))
    {
      paramString1 = this.a.a;
      paramString2 = this.a.a;
      paramString1 = paramString1.getSharedPreferences("is_binding_shop", 1).edit();
      paramString1.putBoolean(this.a.l, false);
      paramString1.commit();
      return;
    }
    paramString1 = this.a.a;
    paramString2 = this.a.a;
    paramString1 = paramString1.getSharedPreferences("is_binding_shop", 1).edit();
    paramString1.putBoolean(this.a.l, true);
    paramString1.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */