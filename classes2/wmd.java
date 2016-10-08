import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.GraphicTabBarView;

public class wmd
  implements View.OnClickListener
{
  public wmd(GraphicTabBarView paramGraphicTabBarView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.setTabSelected(((Integer)paramView.getTag()).intValue());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */