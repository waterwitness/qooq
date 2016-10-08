import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class jbb
  implements View.OnClickListener
{
  jbb(jaz paramjaz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (TextView)this.a.a.findViewById(2131297013);
    if ((paramView.getText() instanceof String)) {
      this.a.a((String)paramView.getText());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */