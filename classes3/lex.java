import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class lex
  implements ConditionSearchManager.IConfigListener
{
  public lex(DetailProfileActivity paramDetailProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.a.s == 1) || (this.a.s == 2))
    {
      if (paramBoolean) {
        break label55;
      }
      this.a.b();
      QQToast.a(this.a, 2131371451, 0).b(this.a.getTitleBarHeight());
    }
    label55:
    while (paramInt != 2) {
      return;
    }
    this.a.b();
    this.a.b(this.a.s);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */