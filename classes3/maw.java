import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class maw
  extends CardObserver
{
  public maw(ProfileLabelEditorActivity paramProfileLabelEditorActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.setResult(-1);
      this.a.b(2131369177);
    }
    for (;;)
    {
      this.a.a = false;
      this.a.finish();
      return;
      this.a.b(2131369178);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\maw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */