import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mat
  extends CardObserver
{
  public mat(ProfileCardMoreActivity paramProfileCardMoreActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.a.equals(paramString)) {
      return;
    }
    this.a.f();
    if (paramBoolean)
    {
      this.a.a(2131367716, 2);
      return;
    }
    this.a.a(2131367715, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */