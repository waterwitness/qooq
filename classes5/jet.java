import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftAioPanelData.CoinInfo;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

public class jet
  implements DialogInterface.OnClickListener
{
  public jet(TroopGiftPanel paramTroopGiftPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData != null) && (this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioPanelData.a.c)))
    {
      this.a.b();
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_topay", 0, 0, this.a.a(), "", this.a.c, "" + TroopMemberUtil.a((AppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.a.a()));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */