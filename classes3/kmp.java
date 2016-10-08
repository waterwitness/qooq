import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;

public class kmp
  implements DialogInterface.OnClickListener
{
  public kmp(BaseChatPie paramBaseChatPie, List paramList, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */