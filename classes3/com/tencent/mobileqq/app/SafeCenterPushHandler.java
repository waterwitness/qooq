package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.ims.AccountSecurityInfo.SecCheckBanner;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqpsdk.MQPSecServiceManager;
import com.tencent.mqpsdk.secsrv.MQPAPPScanService;
import com.tencent.mqpsdk.secsrv.MQPIntChkService;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.msfmqpsdkbridge.MSFSigCheckWrapper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x4a.MsgBody;

public class SafeCenterPushHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "SafeCenterPushHandler";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static int e;
  
  SafeCenterPushHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    return e;
  }
  
  public static void a()
  {
    try
    {
      e += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void b()
  {
    try
    {
      e -= 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new MsgBody();
    try
    {
      ((MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if ((!((MsgBody)localObject).has()) || (!((MsgBody)localObject).uint32_sec_cmd.has())) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SafeCenterPushHandler", 2, "onReceive: onReceive push package: msgbody parse fail");
                }
                paramArrayOfByte.printStackTrace();
              }
              switch (((MsgBody)localObject).uint32_sec_cmd.get())
              {
              default: 
                return;
              case 1: 
                new MSFSigCheckWrapper(this.b).a(true);
                return;
              case 2: 
                paramArrayOfByte = (MSFNetTransportProvider)this.b.a(63);
                paramArrayOfByte = new MQPSecServiceManager(this.b.a().getApplicationContext(), paramArrayOfByte);
              }
            } while (paramArrayOfByte == null);
            paramArrayOfByte = (MQPIntChkService)paramArrayOfByte.a("intchk");
          } while (paramArrayOfByte == null);
          paramArrayOfByte.a(1, new MSFIntChkStrike(this.b, 1));
          paramArrayOfByte.a(2, new MSFIntChkStrike(this.b, 2));
          paramArrayOfByte.a(3, new MSFIntChkStrike(this.b, 3));
          paramArrayOfByte.b("6.5.5.229354");
          return;
          paramArrayOfByte = (MSFNetTransportProvider)this.b.a(63);
          paramArrayOfByte = new MQPSecServiceManager(this.b.a().getApplicationContext(), paramArrayOfByte);
        } while (paramArrayOfByte == null);
        paramArrayOfByte = (MQPAPPScanService)paramArrayOfByte.a("app_scan");
      } while (paramArrayOfByte == null);
      paramArrayOfByte.a(((MsgBody)localObject).bytes_data.get().toByteArray());
      return;
    }
    localObject = ((MsgBody)localObject).bytes_data.get().toByteArray();
    paramArrayOfByte = new AccountSecurityInfo.SecCheckBanner();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      localObject = paramArrayOfByte.str_wording.get();
      int i = paramArrayOfByte.u32_timeToShow.get();
      paramArrayOfByte = new Intent();
      paramArrayOfByte.putExtra("wording", (String)localObject);
      paramArrayOfByte.putExtra("timetowait", i);
      this.b.a(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SafeCenterPushHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */