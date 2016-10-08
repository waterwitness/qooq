import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;

public class rea
  implements Runnable
{
  public rea(DatingManager paramDatingManager, Oidb_0x686.NearbyRankConfig paramNearbyRankConfig)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = false;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a.a(), 0).edit();
    if (this.jdField_a_of_type_TencentImOidbCmd0x686Oidb_0x686$NearbyRankConfig.uint32_rank_sw.has())
    {
      int i = this.jdField_a_of_type_TencentImOidbCmd0x686Oidb_0x686$NearbyRankConfig.uint32_rank_sw.get();
      int j = i & 0x5;
      if (j == 0) {
        bool = true;
      }
      localEditor.putBoolean("toplist_hide_boygod_flag", bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_bank", 2, "saveBoyGodHideConfig,config:" + i + ",configFlag:" + j + ",isHide:" + bool);
      }
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0x686Oidb_0x686$NearbyRankConfig.rpt_msg_title_configs.has()) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a(this.jdField_a_of_type_TencentImOidbCmd0x686Oidb_0x686$NearbyRankConfig.rpt_msg_title_configs.get());
    }
    localEditor.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */