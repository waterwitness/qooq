import android.widget.FrameLayout;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;
import com.tencent.mobileqq.troopreward.TroopRewardInfo;
import com.tencent.qphone.base.util.QLog;

public class vvw
  extends TroopObserver
{
  public vvw(TroopRewardDetailActivity paramTroopRewardDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, TroopRewardInfo paramTroopRewardInfo)
  {
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.troopUin.equals(paramString1)) || (!this.a.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.ownerUin.equals(paramString2)) || (!this.a.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.rewardId.equals(paramString3)) || (paramInt != 4)) {
      return;
    }
    if ((paramBoolean) && (paramTroopRewardInfo != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo = paramTroopRewardInfo;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("onGetTroopRewardDetail: isSucc=").append(paramBoolean).append(", isInPayCheck=").append(this.a.b).append(", checkIdx=").append(this.a.jdField_a_of_type_Int).append(", ");
        if (paramTroopRewardInfo != null) {
          break label259;
        }
      }
    }
    label259:
    for (paramString1 = "";; paramString1 = paramTroopRewardInfo.toString())
    {
      QLog.d(".troop.troop_reward.detailActivity", 2, paramString1);
      if (!this.a.b) {
        break label372;
      }
      paramString1 = this.a;
      paramString1.jdField_a_of_type_Int += 1;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardInfo.privilege == 22) {
        break label268;
      }
      this.a.b = false;
      this.a.jdField_a_of_type_Int = 0;
      this.a.b();
      this.a.e();
      return;
      if (this.a.b) {
        break;
      }
      this.a.a(this.a.getString(2131365296));
      break;
    }
    label268:
    if (this.a.jdField_a_of_type_Int > 4)
    {
      this.a.b = false;
      this.a.jdField_a_of_type_Int = 0;
      this.a.a(this.a.getString(2131365299));
      this.a.e();
      ReportController.b(this.a.app, "dc00899", "BizTechReport", "", "Grp_troop_reward", "check_pay_result_failed", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new vvx(this), 2000L);
    return;
    label372:
    this.a.e();
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */