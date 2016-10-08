import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.arrange.ui.EditMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gdu
  implements View.OnClickListener
{
  public gdu(EditMemberActivity paramEditMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    EditMemberActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */