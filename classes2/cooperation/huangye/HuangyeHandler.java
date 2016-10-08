package cooperation.huangye;

import android.os.Bundle;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.ipc.HYRemoteManager;
import java.util.ArrayList;
import java.util.Timer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x97.submsgtype0x97.MsgBody;
import ycw;

public class HuangyeHandler
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = "HuangyeHandler";
  private static final String b = "huangye_try_Index";
  private static final String c = "msg_data";
  private HYRemoteManager jdField_a_of_type_CooperationHuangyeIpcHYRemoteManager;
  
  public HuangyeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new HYRemoteManager(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new ycw(paramQQAppInterface);
    new Timer().schedule(paramQQAppInterface, 20000L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    int i = 1;
    Object localObject1 = new submsgtype0x97.MsgBody();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = "o3276479029";
      localObject1 = "测试wording";
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("HuangyeHandler", 2, "handle_msg0x210_0x97: receive 0x97 push message, uin=" + paramArrayOfByte + ", context=" + (String)localObject1);
      }
      Object localObject2 = paramArrayOfByte;
      if (paramArrayOfByte.charAt(0) == 'o') {}
      for (;;)
      {
        if ((i >= paramArrayOfByte.length()) || (paramArrayOfByte.charAt(i) != '0'))
        {
          localObject2 = paramArrayOfByte.substring(i);
          paramQQAppInterface = paramQQAppInterface.a(AVNotifyCenter.class);
          if (paramQQAppInterface == null) {
            return;
          }
          paramArrayOfByte = paramQQAppInterface.obtainMessage(10014);
          paramArrayOfByte.obj = new String[] { localObject2, localObject1 };
          paramQQAppInterface.sendMessage(paramArrayOfByte);
          return;
          ((submsgtype0x97.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
          paramArrayOfByte = ((submsgtype0x97.MsgBody)localObject1).string_business_uin.get();
          localObject1 = ((submsgtype0x97.MsgBody)localObject1).string_json_context.get();
          break;
        }
        i += 1;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HuangyeHandler", 2, "handle_msg0x210_0x97:parse msg error", paramQQAppInterface);
      }
    }
  }
  
  public ToServiceMsg a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = a(paramString);
    localToServiceMsg.extraData.putInt("huangye_try_Index", 0);
    localToServiceMsg.extraData.putLong("sessionId", paramLong);
    localToServiceMsg.extraData.putByteArray("msg_data", paramArrayOfByte);
    localToServiceMsg.putWupBuffer(paramArrayOfByte);
    if (NetworkUtil.h(this.b.getApplication().getApplicationContext()))
    {
      b(localToServiceMsg);
      return localToServiceMsg;
    }
    paramString = new FromServiceMsg(this.b.getAccount(), paramString);
    paramString.setBusinessFail(1001);
    this.a.a(localToServiceMsg, paramString, MessageCache.a());
    return localToServiceMsg;
  }
  
  public HYRemoteManager a()
  {
    return this.a;
  }
  
  protected Class a()
  {
    return HYBusinessObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("HuangyeHandler", 2, "onReceive");
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      int i = paramToServiceMsg.extraData.getInt("huangye_try_Index");
      if (QLog.isColorLevel()) {
        QLog.d("HuangyeHandler", 2, "Huangye SendCmd Error, retry = " + i);
      }
      if (i < 3)
      {
        paramFromServiceMsg = paramToServiceMsg.extraData.getByteArray("msg_data");
        if (paramFromServiceMsg != null)
        {
          paramToServiceMsg.putWupBuffer(paramFromServiceMsg);
          paramToServiceMsg.extraData.putInt("huangye_try_Index", i + 1);
          b(paramToServiceMsg);
        }
        return;
      }
    }
    this.a.a(paramToServiceMsg, paramFromServiceMsg, MessageCache.a());
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    HYBusinessPhone localHYBusinessPhone = new HYBusinessPhone();
    localHYBusinessPhone.jdField_a_of_type_JavaLangString = paramString1;
    localHYBusinessPhone.jdField_b_of_type_JavaLangString = paramString2;
    localHYBusinessPhone.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    localHYBusinessPhone.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    a(0, true, localHYBusinessPhone);
  }
  
  public void g()
  {
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HuangyeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */