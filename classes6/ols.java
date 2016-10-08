import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ols
  extends PublicAccountObserver
{
  public ols(MainAssistObserver paramMainAssistObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ols.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */