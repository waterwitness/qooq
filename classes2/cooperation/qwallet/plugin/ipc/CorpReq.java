package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.openapi.sdk.QQResult.QQStringResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import yjs;
import yjt;
import yju;

public class CorpReq
  extends BaseReq
{
  public static final int CORPREQ_TYPE_DELETEOB = 6;
  public static final int CORPREQ_TYPE_FACEFILEPATH = 1;
  public static final int CORPREQ_TYPE_GET_ENCRYPTION = 8;
  public static final int CORPREQ_TYPE_ISFRIEND = 2;
  public static final int CORPREQ_TYPE_PUT_ENCRYPTION = 7;
  public static final int CORPREQ_TYPE_TENWATCH = 4;
  public static final int CORPREQ_TYPE_TROOP_MEM_NICK = 5;
  public static final int CORPREQ_TYPE_USERNICK = 3;
  public static final String TAG = CorpReq.class.getSimpleName();
  public static int corpReqType;
  public static Bundle encryptionData;
  public int channel;
  public Bundle data;
  public int faceType;
  public String groupId;
  public String memUin;
  public ArrayList memUinArrayList;
  public int subType;
  public String troopUin;
  public String uin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void onTroopMemNick()
  {
    int i = 0;
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    localCorpResp.troopUin = this.troopUin;
    if (TextUtils.isEmpty(this.troopUin)) {
      QLog.d(TAG + ".troop.get_troop_mem_card_4_tentpay", 2, "onTroopMemNick:TextUtils.isEmpty(troopUin), troopUin" + this.troopUin);
    }
    for (;;)
    {
      return;
      Object localObject1 = QWalletHelper.a();
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      if (!TextUtils.isEmpty(this.memUin))
      {
        localObject2 = ContactUtils.g((QQAppInterface)localObject1, this.troopUin, this.memUin);
        if (ContactUtils.a((String)localObject2, this.memUin))
        {
          localCorpResp.memUin = this.memUin;
          localCorpResp.memNick = ((String)localObject2);
          label146:
          if ((i != 0) && ((short)localArrayList.size() > 500)) {
            continue;
          }
        }
      }
      try
      {
        long l = Long.parseLong(this.troopUin);
        localObject2 = new oidb_0x787.ReqBody();
        ((oidb_0x787.ReqBody)localObject2).uint64_group_code.set(l);
        ((oidb_0x787.ReqBody)localObject2).uint64_begin_uin.set(0L);
        ((oidb_0x787.ReqBody)localObject2).uint64_data_time.set(0L);
        Object localObject3 = localArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            try
            {
              l = Long.parseLong(str);
              ((oidb_0x787.ReqBody)localObject2).rpt_uin_list.add(Long.valueOf(l));
            }
            catch (Exception localException2) {}
            if (QLog.isColorLevel())
            {
              QLog.d(TAG + ".troop.get_troop_mem_card_4_tentpay", 2, "getTroopCardDefaultNickBatch parseLong err uin=" + str, localException2);
              continue;
              localArrayList.add(this.memUin);
              i = 1;
              break label146;
              if ((this.memUinArrayList == null) || (this.memUinArrayList.isEmpty()))
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(TAG + ".troop.get_troop_mem_card_4_tentpay", 2, "onTroopMemNick:TextUtils.isEmpty(troopUin) || memUinArrayList == null || memUinArrayList.isEmpty(), troopUin" + this.troopUin);
                return;
              }
              int k = this.memUinArrayList.size();
              localObject2 = new JSONArray();
              int j = 0;
              i = 0;
              if (j < k)
              {
                localObject3 = (String)this.memUinArrayList.get(j);
                str = ContactUtils.g((QQAppInterface)localObject1, this.troopUin, (String)localObject3);
                JSONObject localJSONObject;
                if (ContactUtils.a(str, (String)localObject3)) {
                  localJSONObject = new JSONObject();
                }
                for (;;)
                {
                  try
                  {
                    localJSONObject.put("memUin", localObject3);
                    localJSONObject.put("memNick", str);
                    ((JSONArray)localObject2).put(localJSONObject);
                    j += 1;
                  }
                  catch (JSONException localJSONException)
                  {
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.e(TAG + ".troop.get_troop_mem_card_4_tentpay", 2, "onTroopMemNick:JSONException， memUinTemp：" + (String)localObject3);
                    continue;
                  }
                  localArrayList.add(localObject3);
                  i = 1;
                }
              }
              localCorpResp.troopMemNickJson = ((JSONArray)localObject2).toString();
              break label146;
            }
          }
        }
        localObject3 = new oidb_0x787.Filter();
        ((oidb_0x787.Filter)localObject3).uint32_member_level_info_uin.set(1);
        ((oidb_0x787.Filter)localObject3).uint32_member_level_info_name.set(1);
        ((oidb_0x787.Filter)localObject3).uint32_nick_name.set(1);
        ((oidb_0x787.ReqBody)localObject2).opt_filter.set((MessageMicro)localObject3);
        localObject3 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1927);
        ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject2).toByteArray()));
        if ((localObject1 != null) && (((QQAppInterface)localObject1).a() != null))
        {
          localObject2 = new NewIntent(((QQAppInterface)localObject1).a(), ProtoServlet.class);
          ((NewIntent)localObject2).putExtra("cmd", "OidbSvc.0x787_1");
          ((NewIntent)localObject2).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
          ((NewIntent)localObject2).setObserver(new yjt(this, localCorpResp, (QQAppInterface)localObject1, localArrayList));
          ((QQAppInterface)localObject1).startServlet((NewIntent)localObject2);
          return;
        }
      }
      catch (Exception localException1) {}
    }
    localObject1 = new Bundle();
    localCorpResp.toBundle((Bundle)localObject1);
    doCallback((Bundle)localObject1);
    return;
  }
  
  public void deleteUserNickOB()
  {
    QQAppInterface localQQAppInterface = QWalletHelper.a();
    yju localyju = yju.a(this.fromReceiver);
    if ((localQQAppInterface != null) && (localyju != null))
    {
      localQQAppInterface.b(localyju);
      localyju.d();
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    corpReqType = paramBundle.getInt("_qwallet_ipc_CorpReq_corpReqType");
    this.faceType = paramBundle.getInt("_qwallet_ipc_CorpReq_faceType");
    this.uin = paramBundle.getString("_qwallet_ipc_CorpReq_uin");
    this.subType = paramBundle.getInt("_qwallet_ipc_CorpReq_subType");
    this.groupId = paramBundle.getString("_qwallet_ipc_CorpReq_groupId");
    this.channel = paramBundle.getInt("_qwallet_ipc_CorpReq_channel");
    this.troopUin = paramBundle.getString("_qwallet_ipc_CorpReq_troopUin");
    this.memUin = paramBundle.getString("_qwallet_ipc_CorpReq_memUin");
    this.memUinArrayList = paramBundle.getStringArrayList("_qwallet_ipc_CorpReq_memUinArrayList");
    this.data = paramBundle.getBundle("_qwallet_ipc_CorpReq_data");
    if (corpReqType == 7) {
      encryptionData = paramBundle.getBundle("_qwallet_ipc_CorpReq_encryptionData");
    }
  }
  
  public void onGetEncryption()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    localCorpResp.encryptionData = encryptionData;
    Bundle localBundle = new Bundle();
    localCorpResp.toBundle(localBundle);
    doCallback(localBundle);
  }
  
  public void onGetFaceFilePath()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    Object localObject = QWalletHelper.a();
    if (localObject != null) {
      localCorpResp.faceFilePath = ((QQAppInterface)localObject).a(this.faceType, this.uin, this.subType);
    }
    localObject = new Bundle();
    localCorpResp.toBundle((Bundle)localObject);
    doCallback((Bundle)localObject);
  }
  
  public void onIsFriend()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    Object localObject = QWalletHelper.a();
    if (localObject != null) {
      if (!((QQAppInterface)localObject).a().equals(this.uin)) {
        break label62;
      }
    }
    label62:
    for (localCorpResp.isFriend = false;; localCorpResp.isFriend = ((FriendsManager)((QQAppInterface)localObject).getManager(50)).b(this.uin))
    {
      localObject = new Bundle();
      localCorpResp.toBundle((Bundle)localObject);
      doCallback((Bundle)localObject);
      return;
    }
  }
  
  public void onReceive()
  {
    if (corpReqType == 4)
    {
      onTenWatch();
      return;
    }
    if (corpReqType == 8)
    {
      onGetEncryption();
      return;
    }
    ThreadManager.a().post(new yjs(this));
  }
  
  public void onTenWatch()
  {
    if (this.data == null) {
      return;
    }
    QQResult.QQStringResult localQQStringResult = new QQResult.QQStringResult(this.data.getInt("businessType"), 0, this.data.getString("retData"));
    OpenApiManager.a().a(localQQStringResult);
  }
  
  public void onUserNcik()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = corpReqType;
    if (TextUtils.isEmpty(this.uin))
    {
      localCorpResp.userNick = this.uin;
      return;
    }
    Object localObject1 = QWalletHelper.a();
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = (FriendsManager)((QQAppInterface)localObject1).getManager(50);
      if (((this.channel == 5) || ((this.channel & 0x10) != 0)) && ((!((FriendsManager)localObject3).b(this.uin)) || (((QQAppInterface)localObject1).a().equals(this.uin)))) {
        break label317;
      }
      if (TextUtils.isEmpty(this.groupId)) {
        break label290;
      }
      localObject2 = (TroopManager)((QQAppInterface)localObject1).getManager(51);
      localObject3 = ((FriendsManager)localObject3).c(this.uin);
      localObject2 = ((TroopManager)localObject2).a(this.groupId, this.uin);
      if ((localObject3 == null) || (TextUtils.isEmpty(((Friends)localObject3).remark))) {
        break label202;
      }
      localObject1 = ((Friends)localObject3).remark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.uin;
      }
      localCorpResp.userNick = ((String)localObject2);
      for (;;)
      {
        localObject1 = new Bundle();
        localCorpResp.toBundle((Bundle)localObject1);
        doCallback((Bundle)localObject1);
        return;
        label202:
        if ((localObject2 != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick)))
        {
          localObject1 = ((TroopMemberInfo)localObject2).troopnick;
          break;
        }
        if (localObject3 != null)
        {
          localObject1 = ((Friends)localObject3).name;
          break;
        }
        if (localObject2 == null) {
          break label348;
        }
        if (this.uin.equals(((QQAppInterface)localObject1).a()))
        {
          localObject1 = ((TroopMemberInfo)localObject2).friendnick;
          break;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).autoremark))
        {
          localObject1 = ((TroopMemberInfo)localObject2).autoremark;
          break;
        }
        localObject1 = ((TroopMemberInfo)localObject2).friendnick;
        break;
        label290:
        ((QQAppInterface)localObject1).a(yju.a(this.fromReceiver));
        localCorpResp.userNick = ContactUtils.b((QQAppInterface)localObject1, this.uin, true);
        continue;
        label317:
        localObject2 = ContactUtils.o((QQAppInterface)localObject1, this.uin);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.uin;
        }
        localCorpResp.userNick = ((String)localObject1);
      }
      label348:
      localObject1 = null;
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putInt("_qwallet_ipc_CorpReq_corpReqType", corpReqType);
    paramBundle.putInt("_qwallet_ipc_CorpReq_faceType", this.faceType);
    paramBundle.putString("_qwallet_ipc_CorpReq_uin", this.uin);
    paramBundle.putInt("_qwallet_ipc_CorpReq_subType", this.subType);
    paramBundle.putString("_qwallet_ipc_CorpReq_groupId", this.groupId);
    paramBundle.putInt("_qwallet_ipc_CorpReq_channel", this.channel);
    paramBundle.putString("_qwallet_ipc_CorpReq_troopUin", this.troopUin);
    paramBundle.putString("_qwallet_ipc_CorpReq_memUin", this.memUin);
    paramBundle.putStringArrayList("_qwallet_ipc_CorpReq_memUinArrayList", this.memUinArrayList);
    paramBundle.putBundle("_qwallet_ipc_CorpReq_data", this.data);
    paramBundle.putBundle("_qwallet_ipc_CorpReq_encryptionData", encryptionData);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\ipc\CorpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */