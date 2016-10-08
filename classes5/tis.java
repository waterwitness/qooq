import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NeighborComm.RespHeader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.SpecialNearbyListActivity;
import com.tencent.mobileqq.nearby.SpecialNearbyListActivity.SpecialData;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x683.cmd0x683.RankListInfo;

public class tis
  extends NearbyObserver
{
  public tis(SpecialNearbyListActivity paramSpecialNearbyListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, String paramString2, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.c) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.c = false;
    if (paramBoolean) {
      this.a.a(true, false);
    }
    paramString1 = Message.obtain();
    paramString1.what = 3;
    if (paramBoolean)
    {
      paramString1.arg1 = paramInt1;
      if (!paramBoolean) {
        break label88;
      }
    }
    for (;;)
    {
      paramString1.obj = paramList;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      return;
      paramInt1 = 0;
      break;
      label88:
      paramList = paramString2;
    }
  }
  
  protected void b(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, cmd0x683.RankListInfo paramRankListInfo, ToServiceMsg paramToServiceMsg, List paramList)
  {
    long l = paramToServiceMsg.extraData.getLong("requestId");
    boolean bool = paramToServiceMsg.extraData.getBoolean("first");
    if (NearbyUtils.b()) {
      NearbyUtils.a(SpecialNearbyListActivity.jdField_a_of_type_JavaLangString, "onUpdateGetSameInterestEncounter", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), Long.valueOf(l), Long.valueOf(this.a.jdField_a_of_type_Long), Boolean.valueOf(this.a.jdField_b_of_type_Boolean) });
    }
    if (l != this.a.jdField_a_of_type_Long) {}
    int i;
    label210:
    label287:
    label295:
    label364:
    do
    {
      return;
      this.a.c = false;
      if (((!paramBoolean) || (paramRespGetEncounterV2 == null)) && (paramRespHeader != null) && (paramRespHeader.eReplyCode == 7))
      {
        if (NearbyUtils.b()) {
          NearbyUtils.a(SpecialNearbyListActivity.jdField_a_of_type_JavaLangString, "onUpdateGetSameInterestEncounter _REPLYCODE_ERR_Session_TimeOut", new Object[0]);
        }
        this.a.a(true, false);
        return;
      }
      if (!this.a.jdField_b_of_type_Boolean) {
        this.a.jdField_b_of_type_Boolean = true;
      }
      paramRespHeader = Message.obtain();
      paramRespHeader.what = 1;
      if (!bool) {
        break;
      }
      i = 1;
      paramRespHeader.arg1 = i;
      if (!paramBoolean) {
        break label489;
      }
      i = 1;
      paramRespHeader.arg2 = i;
      if ((paramBoolean) && (paramRespGetEncounterV2 != null))
      {
        this.a.jdField_a_of_type_Int = paramRespGetEncounterV2.stUserData.iLat;
        this.a.jdField_b_of_type_Int = paramRespGetEncounterV2.stUserData.iLon;
        this.a.jdField_b_of_type_Long = System.currentTimeMillis();
        if (paramRespGetEncounterV2.stUserData.lNextGrid == -1L) {
          break label495;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_b_of_type_Boolean = true;
        if (paramList != null) {
          break label509;
        }
        i = 0;
        if (bool)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_JavaUtilList.clear();
          if (paramRespGetEncounterV2.can_add_sub_interest != 1) {
            break label521;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Boolean = true;
          if (this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTag == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.a(this.a.getResources());
          }
        }
        if (i > 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramRespHeader);
    } while ((paramBoolean) || (!paramToServiceMsg.extraData.getBoolean("isLbsInfoNull", false)));
    paramRespGetEncounterV2 = Message.obtain();
    paramRespGetEncounterV2.what = 2;
    paramRespGetEncounterV2.arg1 = 0;
    paramRespGetEncounterV2.arg2 = 1;
    if (DatingUtil.a()) {
      if (QLog.isColorLevel()) {
        QLog.d(SpecialNearbyListActivity.jdField_a_of_type_JavaLangString, 2, "onUpdateGetEncounter.lbsinfo is null and permission is denied");
      }
    }
    for (paramRespGetEncounterV2.obj = this.a.getString(2131368230);; paramRespGetEncounterV2.obj = this.a.getString(2131368220))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramRespHeader);
      return;
      i = 0;
      break;
      label489:
      i = 0;
      break label210;
      label495:
      this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_b_of_type_Boolean = false;
      break label287;
      label509:
      i = paramList.size();
      break label295;
      label521:
      this.a.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Boolean = false;
      break label364;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */