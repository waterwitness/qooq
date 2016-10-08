import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.EditTextDialogEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixi
  implements TextWatcher
{
  public ixi(EditTextDialog paramEditTextDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null) {}
    do
    {
      do
      {
        return;
      } while (this.a.a(paramCharSequence.toString()) <= 420);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence.subSequence(0, paramInt1));
      this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt1);
    } while (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.b(420);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */