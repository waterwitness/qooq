import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class mqy
  extends BizTroopObserver
{
  public mqy(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (paramLong1 != 0L) {}
    this.a.jdField_a_of_type_Long = paramLong2;
    this.a.b = paramLong3;
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (paramBoolean)) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt != 2) {
        break label115;
      }
    }
    label115:
    for (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = 3;; this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
    {
      if ((this.a.aU == 0) || (1 == this.a.aU)) {
        ReportController.b(this.a.app, "P_CliOper", "Grp_create", "", "edit_data", "ordinary_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.d, "", "");
      }
      TroopInfoActivity.a(this.a, paramBoolean, paramLong, paramString);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */