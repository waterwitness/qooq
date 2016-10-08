import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.activity.BlessPTVActivity.MusicItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasH5PayUtil;

public class kqz
  implements DialogInterface.OnClickListener
{
  public kqz(BlessPTVActivity paramBlessPTVActivity, int paramInt, BlessPTVActivity.MusicItemData paramMusicItemData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity, "mvip.pt.vipzx.xgn_ptv_qfzf_" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int, 1, "1450000515", "LTMCLUB", this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity.getString(2131370893), "vip");
      return;
    }
    VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity, "mvip.pt.vipzx.xgn_ptv_qfzf_" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int, 1, "1450000516", "CJCLUBT", this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity.getString(2131371097), "svip");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */