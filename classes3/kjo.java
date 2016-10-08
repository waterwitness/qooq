import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kjo
  extends CardObserver
{
  public kjo(AddRequestActivity paramAddRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!AddRequestActivity.a(this.a).equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a(2130838452, this.a.getString(2131367716));
      return;
    }
    this.a.a(2130838442, this.a.getString(2131367715));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */