import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.arrange.ui.EditMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gdx
  implements DialogInterface.OnDismissListener
{
  public gdx(EditMemberActivity paramEditMemberActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentArrangeUiEditMemberActivity.findViewById(2131305207).getHandler().postDelayed(new gdy(this), 150L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */