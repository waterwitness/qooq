package com.tencent.mobileqq.troop.org.pb;

import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopOrgProtocolManager
  implements Manager
{
  public static final int a = 1;
  public static final String a = "ProtocolManager";
  public static final int b = 2;
  public static final String b = "http://qun.qq.com/cgi-bin/qteam/short_url";
  public static final String c = "OidbSvc.0x496";
  QQAppInterface a;
  
  public TroopOrgProtocolManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, BusinessObserver paramBusinessObserver)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt2);
    localOIDBSSOPkg.uint32_service_type.set(paramInt1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = new NewIntent(this.a.a(), ProtoServlet.class);
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    paramArrayOfByte.setObserver(paramBusinessObserver);
    this.a.startServlet(paramArrayOfByte);
  }
  
  public void a(String paramString, long paramLong, int paramInt, boolean paramBoolean, BusinessObserver paramBusinessObserver)
  {
    oidb_0x496.ReqBody localReqBody = new oidb_0x496.ReqBody();
    if (!TextUtils.isEmpty(paramString)) {
      localReqBody.uint64_group_code.set(Long.parseLong(paramString));
    }
    if (paramLong != 0L) {
      localReqBody.uint64_update_time.set(paramLong);
    }
    if (paramInt == 1) {
      localReqBody.uint64_first_unread_manager_msg_seq.set(1L);
    }
    for (;;)
    {
      if (!paramBoolean) {
        localReqBody.uint32_just_fetch_msg_config.set(1);
      }
      a(0, localReqBody.toByteArray(), 1174, "OidbSvc.0x496", paramBusinessObserver);
      return;
      if (paramInt == 2) {
        localReqBody.uint64_manager_uin_list.set(1L);
      }
    }
  }
  
  public Object[] a(byte[] paramArrayOfByte)
  {
    Object[] arrayOfObject = new Object[2];
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramArrayOfByte);
      int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
      arrayOfObject[0] = localObject;
      if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) && (i == 0))
      {
        paramArrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
        switch (((oidb_sso.OIDBSSOPkg)localObject).uint32_command.get())
        {
        case 1174: 
          localObject = new oidb_0x496.RspBody();
          ((oidb_0x496.RspBody)localObject).mergeFrom(paramArrayOfByte);
          arrayOfObject[1] = localObject;
          return arrayOfObject;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProtocolManager", 2, "decode sso failed!");
      }
      paramArrayOfByte.printStackTrace();
      return arrayOfObject;
    }
    return arrayOfObject;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\org\pb\TroopOrgProtocolManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */