import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oko
  extends BizTroopObserver
{
  public oko(TroopView paramTroopView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt2 == 0) {
      this.a.a();
    }
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.a.a(paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */