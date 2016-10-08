import com.tencent.biz.helper.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class mqt
  implements TroopInfoActivityHelper.ISetSameCityCheckTypeInfo
{
  public mqt(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = 4;
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_create", "", "edit_data", "local_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.d, "", "");
    TroopInfoActivity.a(this.a, true, 0L, "");
  }
  
  public void b()
  {
    this.a.j();
    TroopInfoActivity.a(this.a, false, 0L, "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */