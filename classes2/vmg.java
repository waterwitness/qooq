import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopEntranceBar;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import org.json.JSONObject;

class vmg
  implements HttpWebCgiAsyncTask.Callback
{
  vmg(vmf paramvmf, TroopBindPublicAccountMgr paramTroopBindPublicAccountMgr, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode", -1) == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBindPublicAccountMgr.a(this.jdField_a_of_type_Vmf.a.a.a, 0, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */