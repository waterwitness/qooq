package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.NumRedMsgManager;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgReqBody;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class NumRedMsgHandler
  extends BusinessHandler
{
  public static final String a = "NumRedMsgHandler";
  public static final String b = "red_touch_num_svr.get_num_msg";
  protected QQAppInterface a;
  
  protected NumRedMsgHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("red_touch_num_svr.get_num_msg".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NumRedMsgHandler", 2, "onReceive called.");
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(List paramList, int paramInt, String paramString, long[] paramArrayOfLong)
  {
    NumRedMsg.NumMsgReqBody localNumMsgReqBody = new NumRedMsg.NumMsgReqBody();
    localNumMsgReqBody.i_proto_ver.set(1);
    localNumMsgReqBody.ui_plat_id.set(109);
    localNumMsgReqBody.str_client_ver.set("6.5.5.2880");
    localNumMsgReqBody.ui64_uin.set(Long.parseLong(this.a.a()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    localNumMsgReqBody.rpt_num_msg.set(localArrayList);
    paramList = new ToServiceMsg("mobileqq.service", this.a.a(), "red_touch_num_svr.get_num_msg");
    paramList.putWupBuffer(localNumMsgReqBody.toByteArray());
    paramList.extraData.putInt("NumMsgListenerKey", paramInt);
    paramList.extraData.putLongArray("NumMsgIDList", paramArrayOfLong);
    paramList.extraData.putString("NumMsgListenerCmd", paramString);
    b(paramList);
    if (QLog.isColorLevel()) {
      QLog.i("NumRedMsgHandler", 2, "sendPbReq called.");
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
      paramFromServiceMsg = (NumRedMsgManager)this.a.getManager(64);
      if (i != 0)
      {
        NumRedMsg.NumMsgRspBody localNumMsgRspBody = new NumRedMsg.NumMsgRspBody();
        try
        {
          localNumMsgRspBody.mergeFrom((byte[])paramObject);
          if (localNumMsgRspBody.i_retcode.get() == 0)
          {
            paramFromServiceMsg.a(localNumMsgRspBody, paramToServiceMsg, true);
            return;
            i = 0;
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          for (;;)
          {
            ((InvalidProtocolBufferMicroException)paramObject).printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("NumRedMsgHandler", 2, "mergeFrom failed");
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("NumRedMsgHandler", 2, "rsp code != 0 , error msg == " + localNumMsgRspBody.str_errmsg.get());
          }
          paramFromServiceMsg.a(localNumMsgRspBody, paramToServiceMsg, false);
          return;
        }
      }
    }
    paramFromServiceMsg.a(null, paramToServiceMsg, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NumRedMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */