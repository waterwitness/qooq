import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

public class jez
  implements TextView.OnEditorActionListener
{
  public jez(TroopGiftPanel.GiftNumInputDialog paramGiftNumInputDialog, TroopGiftPanel paramTroopGiftPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.c();
      paramTextView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (!TextUtils.isEmpty(paramTextView)) {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(paramTextView);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.b();
        ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.get()).a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
        return true;
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$GiftNumInputDialog.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a("1");
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */