package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.NumRedPointManager;
import com.tencent.pb.getnumred.NumRedPoint.NumRedReqBody;
import com.tencent.pb.getnumred.NumRedPoint.NumRedRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class NumRedPointHandler
  extends BusinessHandler
{
  public static final String a = "red_touch_num_svr.get_num_red";
  public static final String b = "NumRedPointHandler";
  protected QQAppInterface a;
  
  protected NumRedPointHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  protected Class a()
  {
    return NumRedPointObserver.class;
  }
  
  public void a()
  {
    NumRedPoint.NumRedReqBody localNumRedReqBody = new NumRedPoint.NumRedReqBody();
    localNumRedReqBody.i_proto_ver.set(1);
    localNumRedReqBody.uint32_plat_id.set(109);
    localNumRedReqBody.str_client_ver.set("6.5.5.2880");
    localNumRedReqBody.uint64_uin.set(Long.parseLong(this.a.a()));
    Object localObject = (NumRedPointManager)this.a.getManager(63);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((NumRedPointManager)localObject).a());
    localNumRedReqBody.rpt_num_red.set(localArrayList);
    localObject = new ToServiceMsg("mobileqq.service", this.a.a(), "red_touch_num_svr.get_num_red");
    ((ToServiceMsg)localObject).putWupBuffer(localNumRedReqBody.toByteArray());
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("NumRedPointHandler", 2, "sendPbReq called.");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("red_touch_num_svr.get_num_red".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NumRedPointHandler", 2, "onReceive called.");
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      paramToServiceMsg = (NumRedPointManager)this.a.getManager(63);
      NumRedPoint.NumRedRspBody localNumRedRspBody;
      if (i != 0) {
        localNumRedRspBody = new NumRedPoint.NumRedRspBody();
      }
      try
      {
        localNumRedRspBody.mergeFrom((byte[])paramObject);
        if (localNumRedRspBody.i_retcode.get() == 0)
        {
          paramToServiceMsg.a(localNumRedRspBody);
          paramToServiceMsg.a(100, paramFromServiceMsg.isSuccess(), paramObject);
          return;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          if (QLog.isColorLevel())
          {
            QLog.i("NumRedPointHandler", 2, "mergeFrom failed");
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("NumRedPointHandler", 2, "rsp code != 0 , error msg == " + localNumRedRspBody.str_errmsg.get());
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NumRedPointHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */