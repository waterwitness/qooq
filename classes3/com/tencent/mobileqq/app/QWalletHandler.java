package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qwallet.CodeGenerate.CodeGenerateReq;
import com.tencent.qwallet.CodeGenerate.CodeGenerateRes;
import java.util.List;
import tencent.im.oidb.cmd0x438.oidb_0x438.ReqBody;
import tencent.im.oidb.cmd0x438.oidb_0x438.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QWalletHandler
  extends BusinessHandler
{
  public static final int a = 0;
  public static final String a = QWalletHandler.class.getSimpleName();
  public static final int b = 1;
  public static final String b = "OidbSvc.0x438";
  public static final int c = 1;
  public static final String c = "QPayWalletPayCode.code_generate";
  public static final int d = 100;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected QWalletHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  protected Class a()
  {
    return QWalletObserver.class;
  }
  
  public void a(int paramInt, List paramList)
  {
    Object localObject = new oidb_0x438.ReqBody();
    ((oidb_0x438.ReqBody)localObject).stReqInfo.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1080);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(paramInt);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x438.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x438");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, "onReceive");
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    String str = paramToServiceMsg.getServiceCmd();
    if (QLog.isDevelopLevel())
    {
      QLog.i(a, 4, "cmd=" + str);
      QLog.i(a, 4, "data length =" + ((byte[])paramObject).length);
    }
    if (TextUtils.isEmpty(str)) {}
    label207:
    do
    {
      do
      {
        return;
        if (str.compareTo("OidbSvc.0x438") != 0) {
          break label207;
        }
        paramToServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if (paramToServiceMsg != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(a, 2, "onReceive: ssoPkg parse failed");
      return;
      paramFromServiceMsg = new oidb_0x438.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = paramFromServiceMsg.PasswdRedBag.get();
        if (paramFromServiceMsg != null)
        {
          a(paramToServiceMsg.uint32_service_type.get(), true, paramFromServiceMsg);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        a(paramToServiceMsg.uint32_service_type.get(), false, null);
        return;
      }
    } while (str.compareTo("QPayWalletPayCode.code_generate") != 0);
    paramToServiceMsg = new CodeGenerate.CodeGenerateRes();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      a(100, bool, paramToServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
      }
    }
  }
  
  public void a(CodeGenerate.CodeGenerateReq paramCodeGenerateReq)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, "sendQrcodePayCodeGenCmd");
    }
    ToServiceMsg localToServiceMsg = a("QPayWalletPayCode.code_generate");
    localToServiceMsg.putWupBuffer(paramCodeGenerateReq.toByteArray());
    b(localToServiceMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QWalletHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */