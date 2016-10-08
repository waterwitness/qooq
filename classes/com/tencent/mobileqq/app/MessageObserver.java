package com.tencent.mobileqq.app;

import QQService.RespTmpChatPicDownload;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.OffLineFileInfo;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MessageObserver
  implements BusinessObserver
{
  public MessageObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject3 = null;
    String str1 = null;
    String str2 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject2 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    String str3 = null;
    int i = 0;
    if ((paramObject instanceof Object[])) {}
    for (Object localObject1 = (Object[])paramObject;; localObject1 = null)
    {
      switch (paramInt)
      {
      default: 
      case 6008: 
      case 999: 
      case 6005: 
      case 6004: 
      case 6006: 
      case 1000: 
      case 1003: 
      case 1004: 
      case 8015: 
      case 1005: 
      case 2000: 
      case 2001: 
      case 2002: 
      case 3001: 
      case 3002: 
      case 3008: 
      case 3013: 
      case 6000: 
      case 6009: 
      case 6010: 
      case 6012: 
      case 6013: 
      case 7000: 
      case 8002: 
      case 8005: 
      case 8006: 
      case 8010: 
      case 8012: 
      case 8014: 
      case 1002: 
      case 4003: 
      case 3012: 
      case 4005: 
      case 4006: 
      case 4011: 
      case 4012: 
      case 4001: 
      case 4004: 
      case 4016: 
      case 4017: 
      case 4018: 
      case 6003: 
        do
        {
          do
          {
            do
            {
              return;
              d(paramBoolean);
              return;
              if ((paramObject instanceof String))
              {
                d(paramBoolean, (String)paramObject);
                return;
              }
              d(paramBoolean, "");
              return;
              c(paramBoolean);
              return;
              a(paramBoolean, paramObject);
              return;
              l(paramBoolean);
              return;
              g();
              return;
              a(paramBoolean);
              return;
              b(paramBoolean, paramObject);
              return;
              c(paramBoolean, paramObject);
              return;
              b(paramBoolean);
              return;
              c();
              return;
              a();
              b();
              return;
              b();
              return;
            } while ((localObject1 == null) || (localObject1.length <= 2));
            str1 = (String)localObject1[0];
            paramInt = ((Integer)localObject1[1]).intValue();
            i = ((Integer)localObject1[2]).intValue();
            long l1;
            long l2;
            if (localObject1.length >= 6)
            {
              paramObject = (SendMessageHandler)localObject1[3];
              l1 = ((Long)localObject1[4]).longValue();
              l2 = ((Long)localObject1[5]).longValue();
            }
            for (;;)
            {
              localObject2 = "";
              if (localObject1.length >= 7) {
                localObject2 = (String)localObject1[6];
              }
              a(str1, paramInt, i, (SendMessageHandler)paramObject, l1, l2, (String)localObject2);
              return;
              l1 = 96000L;
              l2 = 0L;
              paramObject = str3;
            }
          } while ((localObject1 == null) || (localObject1.length <= 2));
          a((String)localObject1[0], ((Integer)localObject1[1]).intValue(), ((Integer)localObject1[2]).intValue());
          return;
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramObject = new String[localObject1.length];
            paramInt = 0;
            while (paramInt < paramObject.length)
            {
              paramObject[paramInt] = ((String)localObject1[paramInt]);
              paramInt += 1;
            }
            a(paramBoolean, (String[])paramObject);
            return;
          }
          a(paramBoolean, null);
          return;
          if (paramBoolean)
          {
            paramObject = localObject3;
            if (localObject1 != null)
            {
              paramObject = localObject3;
              if (localObject1.length > 0) {
                paramObject = (RespTmpChatPicDownload)localObject1[0];
              }
            }
            a(paramBoolean, (RespTmpChatPicDownload)paramObject);
            return;
          }
          a(paramBoolean, null);
          return;
          a(paramBoolean, false);
          return;
          a(false, true);
          return;
          paramObject = (ToServiceMsg)paramObject;
          str2 = (String)((ToServiceMsg)paramObject).getAttribute("_tag_LOGSTR");
          paramInt = ((ToServiceMsg)paramObject).extraData.getInt("system_msg_action_type");
          localObject1 = ((ToServiceMsg)paramObject).extraData.getString("system_msg_action_resp_key");
          localObject2 = ((ToServiceMsg)paramObject).extraData.getString("system_msg_action_resp_error_key");
          i = ((ToServiceMsg)paramObject).extraData.getInt("system_msg_action_resp_result_code_key");
          int j = ((ToServiceMsg)paramObject).extraData.getInt("system_msg_action_resp_type_key");
          str1 = ((ToServiceMsg)paramObject).extraData.getString("system_msg_action_resp_invalid_decided_key");
          int k = ((ToServiceMsg)paramObject).extraData.getInt("system_msg_action_resp_remark_result_key");
          paramObject = localObject1;
          if (localObject1 == null) {
            paramObject = "";
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject2 = str1;
          if (str1 == null) {
            localObject2 = "";
          }
          if (QLog.isColorLevel()) {
            QLog.d("MessageObserver", 2, "sendSystemMsgActionResult logStr=" + str2 + ";actionType=" + paramInt + ";msgDetail=" + (String)paramObject + ";resultCode=" + i + ";respType=" + j + ";msgFail=" + (String)localObject1 + ";msgInvalidDecided=" + (String)localObject2 + ";remarkRet=" + k);
          }
          a(paramBoolean, str2, paramInt, (String)paramObject, i, j, (String)localObject1, (String)localObject2, k);
          return;
          a((String)((ToServiceMsg)paramObject).getAttribute("_tag_LOGSTR"));
          return;
          e(paramBoolean);
          return;
          f(paramBoolean);
          return;
          h(paramBoolean);
          return;
          i(paramBoolean);
          return;
          j(paramBoolean);
          return;
        } while (localObject1 == null);
        if (localObject1.length >= 3) {
          a(paramBoolean, (String)localObject1[0], (MessageHandler.MsgSendCostParams)localObject1[2]);
        }
        while (localObject1.length >= 2)
        {
          a(paramBoolean, (String)localObject1[0], Long.parseLong((String)localObject1[1]));
          return;
          if (localObject1.length >= 1) {
            a(paramBoolean, (String)localObject1[0]);
          }
        }
      case 5002: 
        k(paramBoolean);
        return;
      case 5003: 
        if (paramBoolean) {
          if ((localObject1 == null) || (localObject1.length < 1)) {
            break label2523;
          }
        }
        break;
      }
      label2513:
      label2523:
      for (paramObject = (byte[])localObject1[0];; paramObject = null)
      {
        localObject2 = str1;
        if (localObject1 != null)
        {
          localObject2 = str1;
          if (localObject1.length >= 2) {
            localObject2 = (MessageObserver.StatictisInfo)localObject1[1];
          }
        }
        a(paramBoolean, (byte[])paramObject, (MessageObserver.StatictisInfo)localObject2);
        return;
        if ((localObject1 != null) && (localObject1.length >= 2)) {}
        for (paramObject = (MessageObserver.StatictisInfo)localObject1[1];; paramObject = null)
        {
          a(paramBoolean, null, (MessageObserver.StatictisInfo)paramObject);
          return;
          if (paramBoolean) {
            if ((localObject1 == null) || (localObject1.length < 1)) {
              break label2513;
            }
          }
          for (paramObject = (MessageFactoryReceiver.OffLineFileInfo)localObject1[0];; paramObject = null)
          {
            localObject2 = str2;
            if (localObject1 != null)
            {
              localObject2 = str2;
              if (localObject1.length >= 2) {
                localObject2 = (MessageObserver.StatictisInfo)localObject1[1];
              }
            }
            a(paramBoolean, (MessageFactoryReceiver.OffLineFileInfo)paramObject, (MessageObserver.StatictisInfo)localObject2);
            return;
            if ((localObject1 != null) && (localObject1.length >= 2)) {}
            for (paramObject = (MessageObserver.StatictisInfo)localObject1[1];; paramObject = null)
            {
              a(paramBoolean, null, (MessageObserver.StatictisInfo)paramObject);
              return;
              if (paramBoolean)
              {
                paramObject = localObject4;
                if (localObject1 != null)
                {
                  paramObject = localObject4;
                  if (localObject1.length >= 1) {
                    paramObject = (MessageFactoryReceiver.OffLineFileInfo)localObject1[0];
                  }
                }
                a(paramBoolean, (MessageFactoryReceiver.OffLineFileInfo)paramObject);
                return;
              }
              a(paramBoolean, null);
              return;
              g(paramBoolean);
              return;
              if ((localObject1 != null) && (localObject1.length >= 2))
              {
                a(paramBoolean, ((Long)localObject1[0]).longValue(), ((Long)localObject1[1]).longValue());
                return;
              }
              a(paramBoolean, 0L, 0L);
              return;
              if ((localObject1 != null) && (localObject1.length >= 1))
              {
                a(paramBoolean, (MessageFactoryReceiver.UploadStreamStruct)localObject1[0]);
                return;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              if ("Stream ptt:UploadStreamStruct : arrayLength:" + localObject1 == null) {}
              for (paramObject = "null";; paramObject = localObject1.length + "")
              {
                QLog.d("streamptt.send", 2, (String)paramObject);
                return;
              }
              if (!(paramObject instanceof String)) {
                break;
              }
              b(paramBoolean, (String)paramObject);
              return;
              if (!(paramObject instanceof Object[])) {
                break;
              }
              a(paramBoolean, (Object[])paramObject);
              return;
              paramObject = (Object[])paramObject;
              if ((paramObject == null) || (paramObject.length != 2)) {
                break;
              }
              c(paramBoolean, (String)paramObject[0]);
              a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
              return;
              if ((localObject1 == null) || (localObject1.length <= 1)) {
                break;
              }
              a(((Byte)localObject1[0]).byteValue(), ((Byte)localObject1[1]).byteValue());
              return;
              if ((localObject1 == null) || (localObject1.length <= 1)) {
                break;
              }
              b(((Byte)localObject1[0]).byteValue(), ((Byte)localObject1[1]).byteValue());
              return;
              paramObject = localObject5;
              if (localObject1 != null)
              {
                paramObject = localObject5;
                if (localObject1.length >= 1) {
                  paramObject = (MessageObserver.StatictisInfo)localObject1[0];
                }
              }
              a(paramBoolean, (MessageObserver.StatictisInfo)paramObject);
              return;
              if ((localObject1 == null) || (localObject1.length < 2)) {
                break;
              }
              paramObject = (Integer)localObject1[0];
              localObject2 = (String)localObject1[1];
              localObject1 = (String)localObject1[2];
              a(paramBoolean, (String)localObject2, ((Integer)paramObject).intValue(), (String)localObject1);
              return;
              d();
              return;
              if (QLog.isColorLevel()) {
                QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_GET_MSG");
              }
              localObject1 = localObject6;
              if (paramObject != null) {
                localObject1 = ((SubAccountBackProtocData)paramObject).c;
              }
              b(paramBoolean, (String)localObject1, (SubAccountBackProtocData)paramObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_MSG_NUM_READED_CONFIRM isSucc=" + paramBoolean + " data=" + String.valueOf(paramObject));
              }
              if ((paramObject instanceof String[]))
              {
                localObject1 = (String[])paramObject;
                if (localObject1.length == 2) {
                  paramObject = localObject1[0];
                }
              }
              for (localObject1 = localObject1[1];; localObject1 = localObject2)
              {
                a(paramBoolean, (String)paramObject, (String)localObject1);
                return;
                localObject1 = localObject7;
                if (paramObject != null) {
                  localObject1 = ((SubAccountBackProtocData)paramObject).c;
                }
                a(paramBoolean, (String)localObject1, (SubAccountBackProtocData)paramObject);
                return;
                if ((localObject1 == null) || (localObject1.length != 6)) {
                  break;
                }
                paramObject = (Boolean)localObject1[0];
                localObject2 = (String)localObject1[1];
                str1 = (String)localObject1[2];
                str2 = (String)localObject1[3];
                str3 = (String)localObject1[4];
                localObject1 = (ArrayList)localObject1[5];
                a(paramBoolean, ((Boolean)paramObject).booleanValue(), (String)localObject2, str1, str2, str3, (ArrayList)localObject1);
                return;
                if ((localObject1 == null) || (localObject1.length != 4)) {
                  break;
                }
                a(paramBoolean, (String)localObject1[0], (String)localObject1[1], (String)localObject1[2], (String)localObject1[3]);
                return;
                b(paramBoolean, false);
                return;
                f();
                return;
                boolean bool;
                if ((localObject1 != null) && (localObject1.length == 2))
                {
                  paramObject = (List)localObject1[0];
                  bool = ((Boolean)localObject1[1]).booleanValue();
                }
                for (;;)
                {
                  a(paramBoolean, (List)paramObject, bool);
                  return;
                  paramInt = i;
                  if (localObject1 != null)
                  {
                    paramInt = i;
                    if (localObject1.length == 1) {
                      paramInt = ((Integer)localObject1[0]).intValue();
                    }
                  }
                  a(paramBoolean, paramInt);
                  return;
                  if ((localObject1 == null) || (localObject1.length != 2)) {
                    break;
                  }
                  a(paramBoolean, ((Integer)localObject1[0]).intValue(), ((Long)localObject1[1]).longValue());
                  return;
                  if ((paramObject == null) || (!(paramObject instanceof List))) {
                    break;
                  }
                  a((List)paramObject);
                  return;
                  if ((localObject1 == null) || (localObject1.length != 1)) {
                    break;
                  }
                  b((String)localObject1[0]);
                  return;
                  e();
                  return;
                  bool = true;
                  paramObject = localObject8;
                }
                paramObject = null;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2) {}
  
  public void a(List paramList) {}
  
  protected void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, RespTmpChatPicDownload paramRespTmpChatPicDownload) {}
  
  protected void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  protected void a(boolean paramBoolean, String paramString, MessageHandler.MsgSendCostParams paramMsgSendCostParams) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void b() {}
  
  protected void b(int paramInt1, int paramInt2) {}
  
  public void b(String paramString) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c() {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  protected void d() {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void d(boolean paramBoolean, String paramString) {}
  
  public void e() {}
  
  public void e(boolean paramBoolean) {}
  
  protected void f() {}
  
  protected void f(boolean paramBoolean) {}
  
  protected void g() {}
  
  protected void g(boolean paramBoolean) {}
  
  protected void h(boolean paramBoolean) {}
  
  protected void i(boolean paramBoolean) {}
  
  protected void j(boolean paramBoolean) {}
  
  protected void k(boolean paramBoolean) {}
  
  protected void l(boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\MessageObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */