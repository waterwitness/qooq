import android.os.Handler;
import com.tencent.biz.helper.TroopInfoActivityHelper.IGetSameCityCheckTypeInfo;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import tencent.im.oidb.cmd0x79a.oidb_0x79a.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class mrf
  implements TroopInfoActivityHelper.IGetSameCityCheckTypeInfo
{
  public mrf(TroopInfoActivity paramTroopInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.stopTitleProgress();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L) {
      TroopInfoActivity.h(this.a);
    }
  }
  
  public void a(oidb_0x79a.RspBody paramRspBody)
  {
    oidb_0x88d.GroupInfo localGroupInfo = paramRspBody.info;
    this.a.stopTitleProgress();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus = paramRspBody.uint32_tribe_status.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.modifyCount = paramRspBody.uint32_modify_countdown.get();
    int j = 0;
    int i;
    if (4 != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
    {
      i = j;
      if (3 != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {}
    }
    else
    {
      i = j;
      if (localGroupInfo != null) {
        if (4 != localGroupInfo.uint32_group_type_flag.get())
        {
          i = j;
          if (3 != localGroupInfo.uint32_group_type_flag.get()) {}
        }
        else
        {
          this.a.a(localGroupInfo);
          i = 1;
        }
      }
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 1) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 2) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeStatus == 3))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId = paramRspBody.uint64_tribe_id.get();
      this.a.c = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeId;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.tribeName = paramRspBody.str_tribe_name.get();
      if (i == 0) {
        this.a.a(localGroupInfo);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwAppPrivilegeFlag & 0x4000) != 0L)
    {
      TroopInfoActivity.h(this.a);
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */