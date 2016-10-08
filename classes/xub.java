import android.content.Context;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class xub
  extends FrameLayout
{
  public xub(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(ViewParent paramViewParent)
  {
    this.mParent = paramViewParent;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */