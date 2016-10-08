import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomedTabWidget;

public class wlu
  implements View.OnClickListener
{
  public wlu(CustomedTabWidget paramCustomedTabWidget)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.setCurrentTab(this.a.indexOfChild(paramView));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */