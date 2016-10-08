import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.ipc.CorpReq;
import cooperation.qwallet.plugin.ipc.CorpResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class yjt
  implements BusinessObserver
{
  public yjt(CorpReq paramCorpReq, CorpResp paramCorpResp, QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(CorpReq.TAG + ".troop.get_troop_mem_card_4_tentpay", 2, "onReceive success=" + paramBoolean + " troopUin=" + this.jdField_a_of_type_CooperationQwalletPluginIpcCorpResp.troopUin);
    }
    if (paramBoolean) {}
    label904:
    label938:
    for (;;)
    {
      Object localObject3;
      try
      {
        Object localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom(paramBundle.getByteArray("data"));
        Object localObject2;
        Object localObject4;
        Object localObject6;
        Object localObject5;
        Object localObject7;
        if (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.has())
        {
          localObject1 = ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get().toByteArray();
          paramBundle = new oidb_0x787.RspBody();
          paramBundle.mergeFrom((byte[])localObject1);
          localObject3 = new StringBuffer();
          paramBundle = paramBundle.rpt_msg_member_level_info.get();
          localObject2 = new HashMap(paramBundle.size());
          localObject4 = paramBundle.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject6 = (oidb_0x787.MemberLevelInfo)((Iterator)localObject4).next();
            localObject1 = "";
            localObject5 = String.valueOf(((oidb_0x787.MemberLevelInfo)localObject6).uint64_uin.get());
            if (QLog.isColorLevel())
            {
              ((StringBuffer)localObject3).append(" uin=");
              ((StringBuffer)localObject3).append(((String)localObject5).substring(0, 4));
            }
            localObject7 = ((oidb_0x787.MemberLevelInfo)localObject6).str_name.get().toByteArray();
            paramBundle = (Bundle)localObject1;
            if (localObject7 != null)
            {
              paramBundle = (Bundle)localObject1;
              if (localObject7.length > 0) {
                paramBundle = new String((byte[])localObject7);
              }
            }
            localObject1 = ((oidb_0x787.MemberLevelInfo)localObject6).bytes_nick_name.get().toByteArray();
            if ((localObject1 == null) || (localObject1.length <= 0) || (!TextUtils.isEmpty(paramBundle))) {
              break label938;
            }
            localObject1 = new String((byte[])localObject1);
            paramBundle = (Bundle)localObject1;
            if (QLog.isColorLevel())
            {
              ((StringBuffer)localObject3).append(" nick=");
              ((StringBuffer)localObject3).append(Utils.a((String)localObject1));
              paramBundle = (Bundle)localObject1;
            }
            ((Map)localObject2).put(localObject5, paramBundle);
            continue;
          }
        }
        this.jdField_a_of_type_CooperationQwalletPluginIpcCorpResp.troopMemNickJson = ((JSONArray)localObject4).toString();
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.w(CorpReq.TAG + ".troop.get_troop_mem_card_4_tentpay", 2, "handleGetTroopCardDefaultNickBatch ex", paramBundle);
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d(CorpReq.TAG + ".troop.get_troop_mem_card_4_tentpay", 2, ((StringBuffer)localObject3).toString());
        }
        localObject3 = new Bundle();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationQwalletPluginIpcCorpReq.memUin))
        {
          this.jdField_a_of_type_CooperationQwalletPluginIpcCorpResp.memUin = this.jdField_a_of_type_CooperationQwalletPluginIpcCorpReq.memUin;
          localObject1 = (String)((Map)localObject2).get(this.jdField_a_of_type_CooperationQwalletPluginIpcCorpReq.memUin);
          localObject2 = this.jdField_a_of_type_CooperationQwalletPluginIpcCorpResp;
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramBundle = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_CooperationQwalletPluginIpcCorpReq.troopUin, this.jdField_a_of_type_CooperationQwalletPluginIpcCorpReq.memUin);
          }
          ((CorpResp)localObject2).memNick = paramBundle;
          this.jdField_a_of_type_CooperationQwalletPluginIpcCorpResp.toBundle((Bundle)localObject3);
          this.jdField_a_of_type_CooperationQwalletPluginIpcCorpReq.doCallback((Bundle)localObject3);
          return;
        }
        try
        {
          localObject4 = new JSONArray(this.jdField_a_of_type_CooperationQwalletPluginIpcCorpResp.troopMemNickJson);
          localObject5 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break label904;
          }
          localObject7 = (String)((Iterator)localObject5).next();
          localObject6 = new JSONObject();
          localObject1 = (String)((Map)localObject2).get(localObject7);
          ((JSONObject)localObject6).put("memUin", localObject7);
          paramBundle = (Bundle)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramBundle = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_CooperationQwalletPluginIpcCorpReq.troopUin, (String)localObject7);
          }
          ((JSONObject)localObject6).put("memNick", paramBundle);
          ((JSONArray)localObject4).put(localObject6);
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        catch (JSONException paramBundle) {}
        QLog.d(CorpReq.TAG + ".troop.get_troop_mem_card_4_tentpay", 2, "onBatchTroopCardDefaultNick JSONException resp.troopMemNickJson=" + this.jdField_a_of_type_CooperationQwalletPluginIpcCorpResp.troopMemNickJson);
        continue;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d(CorpReq.TAG + ".troop.get_troop_mem_card_4_tentpay", 2, "handleGetTroopCardDefaultNickBatch over time=" + System.currentTimeMillis());
        }
      }
      this.jdField_a_of_type_CooperationQwalletPluginIpcCorpResp.toBundle((Bundle)localObject3);
      this.jdField_a_of_type_CooperationQwalletPluginIpcCorpReq.doCallback((Bundle)localObject3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */