import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.EditTextDialogEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private ixn(EditTextDialog paramEditTextDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(EditTextDialog.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */