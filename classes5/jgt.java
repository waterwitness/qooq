import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jgt
  implements View.OnClickListener
{
  public jgt(WebAIOController paramWebAIOController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    WebAIOController.b = true;
    this.a.b(false);
    this.a.a(paramView.getContext());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */