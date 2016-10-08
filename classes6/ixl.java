import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.control.ColorPicker.ColorSelectListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixl
  implements ColorPicker.ColorSelectListener
{
  public ixl(EditTextDialog paramEditTextDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c = paramInt;
    this.a.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */