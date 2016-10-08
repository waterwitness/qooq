import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;

public class tcq
  implements DialogInterface.OnDismissListener
{
  public tcq(RoamLocalSearchBar paramRoamLocalSearchBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog = null;
    paramDialogInterface = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2130968620);
    this.a.startAnimation(paramDialogInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */