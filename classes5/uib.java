import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;

public class uib
  implements View.OnClickListener
{
  public uib(EditActivity paramEditActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.a(this.jdField_a_of_type_Int, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */