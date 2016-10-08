package cooperation.dingdong.data;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.dingdong.DingdongOpenIdProvider;
import cooperation.dingdong.OfficeCenterProtoManager;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;
import ybn;
import ybo;

public class DingdongOfficeOpenService
{
  public static final int a = 1;
  public static final String a = "KeyMsg";
  public static final int b = 2;
  public static final String b = "KeyReq";
  public static final String c = "KeyOpenId";
  public static final String d = "KeyAppId";
  public static final String e = "CheckOpenIdResult";
  public static final String f = "AddAppResult";
  private TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DingdongOpenIdProvider jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider;
  private OfficeCenterProtoManager jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager;
  
  public DingdongOfficeOpenService(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(Bundle paramBundle, long paramLong)
  {
    if (this.jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager == null) {
      this.jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager = new OfficeCenterProtoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager.a(paramLong, new ybn(this, paramBundle));
  }
  
  private void a(Bundle paramBundle, String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider == null) {
        this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider = new DingdongOpenIdProvider(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      ArrayList localArrayList = new ArrayList(1);
      oidb_0x589.GetUserOpenIdReq localGetUserOpenIdReq = new oidb_0x589.GetUserOpenIdReq();
      localGetUserOpenIdReq.setHasFlag(true);
      localGetUserOpenIdReq.uint32_req_flag.set(1);
      localGetUserOpenIdReq.uint64_req_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()));
      localArrayList.add(localGetUserOpenIdReq);
      this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider.a(paramLong, localArrayList, true, new ybo(this, paramString, paramBundle));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider != null)
    {
      this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider.a();
      this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider = null;
    }
    if (this.jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager != null)
    {
      this.jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager.a();
      this.jdField_a_of_type_CooperationDingdongOfficeCenterProtoManager = null;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int i;
    Bundle localBundle;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("KeyMsg", -1);
      localBundle = new Bundle(2);
      localBundle.putInt("KeyMsg", i);
      int j = paramBundle.getInt("KeyReq", -1);
      if (j != -1) {
        localBundle.putInt("KeyReq", j);
      }
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
      a(localBundle, paramBundle.getString("KeyOpenId"), paramBundle.getLong("KeyAppId"));
      return;
    }
    a(localBundle, paramBundle.getLong("KeyAppId"));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\data\DingdongOfficeOpenService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */