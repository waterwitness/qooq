import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class wbg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public wbg(QQCustomDialog paramQQCustomDialog, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getLineCount() > this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      boolean bool1 = QQText.a(this.jdField_a_of_type_JavaLangString);
      boolean bool2 = QQText.b(this.jdField_a_of_type_JavaLangString);
      if ((!bool1) && (!bool2))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getText().subSequence(0, i - 3) + "...";
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.setText(str);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */