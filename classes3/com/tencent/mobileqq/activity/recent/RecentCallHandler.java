package com.tencent.mobileqq.activity.recent;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x7d7.oidb_cmd0x7d7.ReqBody;
import tencent.im.oidb.cmd0x7d7.oidb_cmd0x7d7.RspBody;
import tencent.im.oidb.cmd0x7d7.oidb_cmd0x7d7.recommendinfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class RecentCallHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "RecentCallHandler";
  public static final String b = "OidbSvc.0x7d7_0";
  
  public RecentCallHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHandler", 2, "handle_oidb_0x7d7_0 " + paramFromServiceMsg.getResultCode());
    }
    boolean bool2 = false;
    int k = 0;
    int i = 0;
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramObject == null) {
            break label615;
          }
          j = ((oidb_sso.OIDBSSOPkg)paramObject).uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.d("RecentCallHandler", 2, "handle_oidb_0x7d7_0|oidb_sso.OIDBSSOPkg.result " + j);
          }
          if ((j != 0) || (!((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get() == null)) {
            break label562;
          }
          paramToServiceMsg = ((oidb_sso.OIDBSSOPkg)paramObject).bytes_bodybuffer.get().toByteArray();
          if (QLog.isColorLevel()) {
            QLog.d("RecentCallHandler", 2, "handle_oidb_0x7d7_0|oidb_sso.OIDBSSOPkg.bytes_bodybuffer " + HexUtil.a(paramToServiceMsg));
          }
          HexUtil.a("RecentCallHandler", paramToServiceMsg);
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          int j;
          for (;;) {}
        }
        try
        {
          paramFromServiceMsg = new oidb_cmd0x7d7.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          if ((!paramFromServiceMsg.bytes_cookies.has()) || (paramFromServiceMsg.bytes_cookies.get() == null)) {
            break label635;
          }
          paramToServiceMsg = String.valueOf(paramFromServiceMsg.bytes_cookies.get().toByteArray());
          j = k;
        }
        catch (Exception paramObject)
        {
          paramToServiceMsg = null;
          i = 0;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
        try
        {
          if (paramFromServiceMsg.uint32_request_gap.has())
          {
            j = k;
            i = paramFromServiceMsg.uint32_request_gap.get();
          }
          j = i;
          if (!paramFromServiceMsg.rpt_msg_frdlist.has()) {
            break label630;
          }
          j = i;
          if (paramFromServiceMsg.rpt_msg_frdlist.get() == null) {
            break label630;
          }
          j = i;
          paramObject = paramFromServiceMsg.rpt_msg_frdlist.get();
          if (paramObject == null)
          {
            k = 0;
            j = i;
            paramFromServiceMsg = new ArrayList();
            j = 0;
            if (j >= k) {
              break label426;
            }
          }
        }
        catch (Exception paramObject)
        {
          for (;;)
          {
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = null;
            i = j;
          }
        }
        try
        {
          paramFromServiceMsg.add(Long.valueOf(((oidb_cmd0x7d7.recommendinfo)((List)paramObject).get(j)).uint64_uin.get()));
          j += 1;
        }
        catch (Exception localException)
        {
          paramObject = paramToServiceMsg;
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = (FromServiceMsg)paramObject;
          paramObject = localException;
          break label541;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        paramToServiceMsg = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("RecentCallHandler", 2, "handle_oidb_0x7d7_0|oidb_sso parseFrom byte", paramFromServiceMsg);
        paramObject = paramToServiceMsg;
        continue;
        j = i;
        k = ((List)paramObject).size();
        continue;
        label426:
        label541:
        label562:
        label615:
        label630:
        for (paramObject = paramFromServiceMsg;; paramObject = null)
        {
          boolean bool1 = true;
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = (ToServiceMsg)paramObject;
          boolean bool3 = false;
          bool2 = bool1;
          bool1 = bool3;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecentCallHandler", 2, "handle_oidb_0x7d7_0|requestGap = " + i + ", cookies = " + paramFromServiceMsg + ", uinList = " + paramToServiceMsg);
            }
            a(1, bool2, new Object[] { Integer.valueOf(i), paramFromServiceMsg, paramToServiceMsg, Boolean.valueOf(bool1) });
            return;
            if (QLog.isColorLevel()) {
              QLog.d("RecentCallHandler", 2, "handle_oidb_0x7d7_0|oidb_sso parseFrom byte", (Throwable)paramObject);
            }
            bool1 = false;
            break;
            if (j == 1203)
            {
              bool1 = true;
              i = 0;
              paramFromServiceMsg = (FromServiceMsg)localObject3;
              paramToServiceMsg = (ToServiceMsg)localObject2;
            }
            else
            {
              bool1 = false;
              i = 0;
              paramFromServiceMsg = (FromServiceMsg)localObject3;
              paramToServiceMsg = (ToServiceMsg)localObject2;
            }
          }
        }
        label635:
        paramToServiceMsg = null;
      }
    }
  }
  
  protected Class a()
  {
    return RecentCallObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHandler", 2, "onReceive");
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (a(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallHandler", 2, "cmdfilter error = " + str);
      }
    }
    while (!"OidbSvc.0x7d7_0".equalsIgnoreCase(str)) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHandler", 2, "send_oidb_0x7d7_0 strCookies = " + paramString);
    }
    Object localObject = new oidb_cmd0x7d7.ReqBody();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.getBytes();
      ((oidb_cmd0x7d7.ReqBody)localObject).bytes_cookies.set(ByteStringMicro.copyFrom(paramString));
    }
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2007);
    paramString.uint32_service_type.set(0);
    paramString.uint32_result.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0x7d7.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x7d7_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  protected boolean a(String paramString)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("OidbSvc.0x7d7_0");
    }
    return !this.b.contains(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentCallHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */