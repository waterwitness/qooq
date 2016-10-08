import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class loz
  implements View.OnLongClickListener
{
  public loz(IndividuationSetActivity paramIndividuationSetActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "onLongClick, disable");
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\loz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */