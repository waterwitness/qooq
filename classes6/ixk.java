import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixk
  implements View.OnFocusChangeListener
{
  public ixk(EditTextDialog paramEditTextDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    SLog.b("EditTextDialog", "onFocusChange:" + paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */