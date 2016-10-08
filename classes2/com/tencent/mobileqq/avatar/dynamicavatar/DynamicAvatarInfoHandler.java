package com.tencent.mobileqq.avatar.dynamicavatar;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.ReqBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class DynamicAvatarInfoHandler
  extends BusinessHandler
{
  public static final int a = 600;
  public static final String a = "OidbSvc.0x74b";
  public static final int b = 1001;
  
  public DynamicAvatarInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Class a()
  {
    return DynamicAvatarInfoObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      do
      {
        return;
      } while (a(paramFromServiceMsg.getServiceCmd()));
      paramFromServiceMsg.getServiceCmd();
    } while (!"OidbSvc.0x74b".equals(paramFromServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject = null;
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(Integer.valueOf(17));
    localArrayList2.add(Integer.valueOf(18));
    ArrayList localArrayList1;
    if (paramInt1 != 18)
    {
      localArrayList1 = new ArrayList();
      localArrayList1.add(paramLong);
    }
    for (;;)
    {
      oidb_0x74b.ReqBody localReqBody = new oidb_0x74b.ReqBody();
      if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
        localReqBody.rpt_uint64_uin.set(localArrayList1);
      }
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        localReqBody.rpt_uint64_tinyid.set((List)localObject);
      }
      if ((localArrayList2 != null) && (!localArrayList2.isEmpty())) {
        localReqBody.rpt_head_type.set(localArrayList2);
      }
      localObject = a("OidbSvc.0x74b", 1867, 0, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("id", paramLong.longValue());
      ((ToServiceMsg)localObject).extraData.putInt("type", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("headType", paramInt2);
      ((ToServiceMsg)localObject).extraData.putInt("sizeType", paramInt3);
      ((ToServiceMsg)localObject).extraData.putBoolean("isSmartMode", paramBoolean);
      b((ToServiceMsg)localObject);
      return;
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramLong);
      localArrayList1 = null;
    }
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    oidb_0x74b.ReqBody localReqBody = new oidb_0x74b.ReqBody();
    if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty())) {
      localReqBody.rpt_uint64_uin.set(paramArrayList1);
    }
    if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {
      localReqBody.rpt_uint64_tinyid.set(paramArrayList2);
    }
    if ((paramArrayList3 != null) && (!paramArrayList3.isEmpty())) {
      localReqBody.rpt_head_type.set(paramArrayList3);
    }
    b(a("OidbSvc.0x74b", 1867, 0, localReqBody.toByteArray()));
  }
  
  protected boolean a(String paramString)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("OidbSvc.0x74b");
    }
    return !this.b.contains(paramString);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      a(1001, false, null);
    }
    oidb_0x74b.RspBody localRspBody;
    int j;
    int k;
    int m;
    boolean bool;
    do
    {
      return;
      localRspBody = new oidb_0x74b.RspBody();
      int i = a(paramFromServiceMsg, paramObject, localRspBody);
      paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("id"));
      j = paramToServiceMsg.extraData.getInt("type");
      k = paramToServiceMsg.extraData.getInt("headType");
      m = paramToServiceMsg.extraData.getInt("sizeType");
      bool = paramToServiceMsg.extraData.getBoolean("isSmartMode");
      QLog.i("Q.dynamicAvatar", 2, "handleDynamicAvatarInfo, result : " + i);
      if (i != 0) {
        break;
      }
      paramToServiceMsg = DynamicAvatarInfo.a(localRspBody);
      a(1001, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
      paramFromServiceMsg = (DynamicAvatarManager)this.a.getManager(179);
    } while (paramFromServiceMsg == null);
    if ((this.a instanceof QQAppInterface))
    {
      paramFromServiceMsg.a(paramToServiceMsg);
      return;
    }
    paramFromServiceMsg.a(localRspBody.toByteArray());
    return;
    QLog.i("Q.dynamicAvatar", 1, "handleGetDynamicAvatarInfo result not success.");
    a(1001, false, new Object[] { null, paramFromServiceMsg, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\DynamicAvatarInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */