import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;

public class nat
  extends NearbyCardObserver
{
  public nat(VisitorsActivity paramVisitorsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.a.app.a())) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        if (!paramBoolean)
        {
          this.a.a(paramString2, paramInt1, false);
          return;
        }
        this.a.b(paramString2, paramInt1, false);
        return;
      }
    } while (paramInt2 != 0);
    this.a.b(Long.parseLong(paramString2));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */