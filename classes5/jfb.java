import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jfb
  implements DialogInterface.OnShowListener
{
  public jfb(TroopGiftPanel.GiftNumInputDialog paramGiftNumInputDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ((InputMethodManager)this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getContext().getSystemService("input_method")).showSoftInput(this.a.jdField_a_of_type_AndroidWidgetEditText, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */