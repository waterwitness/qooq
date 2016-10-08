import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13;

public class uwh
  implements TextUtils.EllipsizeCallback
{
  public uwh(StructMsgItemLayout13 paramStructMsgItemLayout13, TextView paramTextView, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString.substring(0, paramInt1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str + "...");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */