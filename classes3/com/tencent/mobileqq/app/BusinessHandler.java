package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class BusinessHandler
  extends BaseBusinessHandler
{
  public static final int T = 1000277;
  public final AppInterface a;
  public final QQAppInterface b;
  
  public BusinessHandler(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {}
    for (this.b = ((QQAppInterface)paramAppInterface);; this.b = null)
    {
      this.a = paramAppInterface;
      return;
    }
  }
  
  public BusinessHandler(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramQQAppInterface;
    this.a = paramQQAppInterface;
  }
  
  public List a(int paramInt)
  {
    return this.a.a(paramInt);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg)
  {
    if (a(paramFromServiceMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("msgCmdFilter", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + b());
      }
      ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), b(), 1000277, "[地点漫游]拉取后台数据失败" + paramFromServiceMsg.getServiceCmd(), true);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.a.a(paramToServiceMsg);
  }
  
  protected boolean a(FromServiceMsg paramFromServiceMsg)
  {
    return (!paramFromServiceMsg.isSuccess()) && ((paramFromServiceMsg.getServiceCmd().equals("EncounterSvc.ReqGetEncounter")) || (paramFromServiceMsg.getServiceCmd().equals("RoamClientSvr.GetQualify")) || (paramFromServiceMsg.getServiceCmd().equals("NeighborSvc.ReqGetPoint")));
  }
  
  protected final boolean a(ToServiceMsg paramToServiceMsg)
  {
    boolean bool = false;
    if (paramToServiceMsg != null) {
      bool = paramToServiceMsg.extraData.getBoolean("req_pb_protocol_flag", false);
    }
    return bool;
  }
  
  public String b()
  {
    return this.a.a();
  }
  
  public final void b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      this.a.a(paramToServiceMsg);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\BusinessHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */