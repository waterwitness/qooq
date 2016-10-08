import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyk
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private String jdField_a_of_type_JavaLangString;
  
  private iyk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (iyk)paramObject;
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidViewView.equals(((iyk)paramObject).jdField_a_of_type_AndroidViewView));
    while (((iyk)paramObject).jdField_a_of_type_AndroidViewView != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView.hashCode();
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */