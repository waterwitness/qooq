import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.phone.TosActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oqc
  implements View.OnLongClickListener
{
  public oqc(TosActivity paramTosActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */