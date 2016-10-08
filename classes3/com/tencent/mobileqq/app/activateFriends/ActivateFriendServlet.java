package com.tencent.mobileqq.app.activateFriends;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0x7c9.cmd0x7c9.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.reminder.im_reminder.PkgHead;
import tencent.im.reminder.im_reminder.Reminder;
import tencent.im.reminder.im_reminder.Reminder.User;
import tencent.im.reminder.im_reminder.ReminderPackage;
import tencent.im.reminder.im_reminder.Request;
import tencent.im.reminder.im_reminder.Request.Add;
import tencent.im.reminder.im_reminder.Response;

public class ActivateFriendServlet
  extends MSFServlet
{
  public static final int a = 113;
  public static final String a = "ReminderSvc.Reminder";
  private static final boolean a = true;
  public static final int b = 114;
  public static final String b = "p_uin_list";
  public static final int c = 115;
  public static final String c = "p_time_list";
  public static final String d = "p_msg";
  public static final String e = "OidbSvc.0x7c9_2";
  public static final String f = "param_has_data";
  private static final String g = "ActivateFriends.Servlet";
  private static final String h = "param_req_type";
  
  public ActivateFriendServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    long[] arrayOfLong = paramIntent.getExtras().getLongArray("p_uin_list");
    ArrayList localArrayList = new ArrayList();
    ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)getAppRuntime().getManager(84);
    Bundle localBundle = new Bundle();
    im_reminder.ReminderPackage localReminderPackage;
    if (paramFromServiceMsg.isSuccess()) {
      localReminderPackage = new im_reminder.ReminderPackage();
    }
    for (;;)
    {
      int i;
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(arrayOfByte);
        localReminderPackage.mergeFrom(arrayOfByte);
        if (localReminderPackage.head.result.get() != 0) {
          break label388;
        }
        i = 0;
        if (i < localReminderPackage.response.get().size())
        {
          paramFromServiceMsg = (im_reminder.Response)localReminderPackage.response.get().get(i);
          if (paramFromServiceMsg.result.get() != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.Servlet", 2, "respSendTiming | " + localActivateFriendsManager.a(String.valueOf(arrayOfLong[i])) + " ret = " + paramFromServiceMsg.result.get());
            }
          }
          else {
            localArrayList.add(Long.valueOf(((im_reminder.Reminder)paramFromServiceMsg.reminder.get().get(0)).to_user.uin.get()));
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.Servlet", 2, "respSendTimingMsg erro ", paramFromServiceMsg);
        }
      }
      if (localArrayList.size() == arrayOfLong.length) {
        i = 0;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.Servlet", 2, "respSendMsg | send count = " + arrayOfLong.length + " | suc count = " + localArrayList.size());
        }
        if (i == 2) {
          break label497;
        }
        paramFromServiceMsg = new long[localArrayList.size()];
        int j = 0;
        while (j < localArrayList.size())
        {
          paramFromServiceMsg[j] = ((Long)localArrayList.get(j)).longValue();
          j += 1;
        }
        label388:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ActivateFriends.Servlet", 2, "respSendMsg | package.result = " + localReminderPackage.head.result.get());
        break;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ActivateFriends.Servlet", 2, "respSendMsg | response.result = " + paramFromServiceMsg.getResultCode());
        break;
        if (localArrayList.size() > 0) {
          i = 1;
        } else {
          i = 2;
        }
      }
      localActivateFriendsManager.a(paramFromServiceMsg, 2);
      label497:
      localBundle.putInt("key_rt_type", i);
      notifyObserver(paramIntent, 113, true, localBundle, ActivateFriendsObserver.class);
      return;
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
    localNewIntent.putExtra("param_req_type", 114);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Servlet", 2, "sendGetBirthDayMsgForce");
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
    localNewIntent.putExtra("param_req_type", 114);
    localNewIntent.putExtra("param_has_data", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1.length == 0) || (paramArrayOfLong1.length != paramArrayOfLong2.length)) {
      return false;
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), ActivateFriendServlet.class);
    localNewIntent.putExtra("param_req_type", 113);
    localNewIntent.putExtra("p_msg", paramString);
    localNewIntent.putExtra("p_uin_list", paramArrayOfLong1);
    localNewIntent.putExtra("p_time_list", paramArrayOfLong2);
    paramQQAppInterface.startServlet(localNewIntent);
    return true;
  }
  
  /* Error */
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_2
    //   7: invokevirtual 223	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   10: sipush 1000
    //   13: if_icmpne +293 -> 306
    //   16: new 275	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   19: dup
    //   20: invokespecial 276	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 89	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   28: invokestatic 95	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 99	java/nio/ByteBuffer:getInt	()I
    //   36: iconst_4
    //   37: isub
    //   38: newarray <illegal type>
    //   40: astore_3
    //   41: aload_2
    //   42: aload_3
    //   43: invokevirtual 102	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   46: pop
    //   47: aload_1
    //   48: aload_3
    //   49: invokevirtual 277	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   52: pop
    //   53: aload_1
    //   54: astore_3
    //   55: iload 6
    //   57: istore 4
    //   59: aload_3
    //   60: ifnull +158 -> 218
    //   63: aload_3
    //   64: getfield 280	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   67: invokevirtual 120	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   70: istore 7
    //   72: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +30 -> 105
    //   78: ldc 32
    //   80: iconst_2
    //   81: new 147	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 282
    //   91: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload 7
    //   96: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: iload 6
    //   107: istore 4
    //   109: iload 7
    //   111: ifne +107 -> 218
    //   114: iload 6
    //   116: istore 4
    //   118: aload_3
    //   119: getfield 286	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   122: invokevirtual 291	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   125: ifeq +93 -> 218
    //   128: iload 6
    //   130: istore 4
    //   132: aload_3
    //   133: getfield 286	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   136: invokevirtual 294	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   139: ifnull +79 -> 218
    //   142: aload_3
    //   143: getfield 286	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   146: invokevirtual 294	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   149: invokevirtual 299	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   152: astore_1
    //   153: new 301	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody
    //   156: dup
    //   157: invokespecial 302	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody:<init>	()V
    //   160: astore_2
    //   161: aload_2
    //   162: aload_1
    //   163: invokevirtual 303	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   166: pop
    //   167: iload 6
    //   169: istore 4
    //   171: aload_2
    //   172: getfield 306	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody:uint32_next_time_gap	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   175: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   178: ifeq +40 -> 218
    //   181: aload_2
    //   182: getfield 306	tencent/im/oidb/cmd0x7c9/cmd0x7c9$RspBody:uint32_next_time_gap	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   185: invokevirtual 120	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   188: istore 4
    //   190: aload_0
    //   191: invokevirtual 67	com/tencent/mobileqq/app/activateFriends/ActivateFriendServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   194: bipush 84
    //   196: invokevirtual 73	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   199: checkcast 75	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +14 -> 218
    //   207: aload_1
    //   208: iload 4
    //   210: sipush 1000
    //   213: imul
    //   214: i2l
    //   215: invokevirtual 310	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(J)V
    //   218: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +30 -> 251
    //   224: ldc 32
    //   226: iconst_2
    //   227: new 147	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 312
    //   237: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: iload 4
    //   242: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: astore_2
    //   253: aconst_null
    //   254: astore_1
    //   255: aload_1
    //   256: astore_3
    //   257: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq -205 -> 55
    //   263: ldc 32
    //   265: iconst_2
    //   266: ldc_w 314
    //   269: aload_2
    //   270: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload_1
    //   274: astore_3
    //   275: goto -220 -> 55
    //   278: astore_1
    //   279: iload 5
    //   281: istore 4
    //   283: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq -68 -> 218
    //   289: ldc 32
    //   291: iconst_2
    //   292: ldc_w 314
    //   295: aload_1
    //   296: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   299: iload 5
    //   301: istore 4
    //   303: goto -85 -> 218
    //   306: iload 6
    //   308: istore 4
    //   310: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -95 -> 218
    //   316: ldc 32
    //   318: iconst_2
    //   319: new 147	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 316
    //   329: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_2
    //   333: invokevirtual 223	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   336: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: iload 6
    //   347: istore 4
    //   349: goto -131 -> 218
    //   352: astore_1
    //   353: iload 4
    //   355: istore 5
    //   357: goto -78 -> 279
    //   360: astore_2
    //   361: goto -106 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	ActivateFriendServlet
    //   0	364	1	paramIntent	Intent
    //   0	364	2	paramFromServiceMsg	FromServiceMsg
    //   40	235	3	localObject	Object
    //   57	297	4	i	int
    //   1	355	5	j	int
    //   4	342	6	k	int
    //   70	40	7	m	int
    // Exception table:
    //   from	to	target	type
    //   16	24	252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   153	167	278	java/lang/Exception
    //   171	190	278	java/lang/Exception
    //   190	203	352	java/lang/Exception
    //   207	218	352	java/lang/Exception
    //   24	53	360	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(Intent paramIntent, Packet paramPacket)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Servlet", 2, "req send get birthday message");
    }
    Object localObject = new cmd0x7c9.ReqBody();
    ((cmd0x7c9.ReqBody)localObject).uint32_req_type.set(1);
    if (paramIntent.hasExtra("param_has_data"))
    {
      boolean bool = paramIntent.getBooleanExtra("param_has_data", false);
      paramIntent = ((cmd0x7c9.ReqBody)localObject).uint32_has_data;
      if (!bool) {
        break label159;
      }
    }
    for (;;)
    {
      paramIntent.set(i);
      paramIntent = new oidb_sso.OIDBSSOPkg();
      paramIntent.uint32_command.set(1993);
      paramIntent.uint32_service_type.set(2);
      paramIntent.uint32_result.set(0);
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c9.ReqBody)localObject).toByteArray()));
      paramPacket.setSSOCommand("OidbSvc.0x7c9_2");
      paramIntent = paramIntent.toByteArray();
      localObject = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject).array());
      return;
      label159:
      i = 0;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {}
    label97:
    do
    {
      return;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
        if (!bool) {
          break label97;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("ActivateFriends.Servlet", 2, str1 + " success");
        if (!str2.equals("OidbSvc.0x7c9_2")) {
          break;
        }
        b(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("ReminderSvc.Reminder"));
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {
      return;
    }
    switch (((Bundle)localObject1).getInt("param_req_type", 0))
    {
    default: 
      return;
    case 113: 
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Servlet", 2, "req send timing message");
      }
      localObject1 = new im_reminder.ReminderPackage();
      Object localObject2 = new im_reminder.PkgHead();
      ((im_reminder.PkgHead)localObject2).bussi_type.set(5);
      ((im_reminder.PkgHead)localObject2).password.set("BIRTH_06b904887f6437d0c8b9fc37971f4014");
      ((im_reminder.PkgHead)localObject2).uin.set(getAppRuntime().getLongAccountUin());
      ((im_reminder.ReminderPackage)localObject1).head.set((MessageMicro)localObject2);
      localObject2 = new im_reminder.Request.Add();
      Object localObject3 = new im_reminder.Reminder();
      Object localObject4 = new im_reminder.Reminder.User();
      ((im_reminder.Reminder)localObject3).to_user.set((MessageMicro)localObject4);
      ((im_reminder.Reminder.User)localObject4).uin.set(((QQAppInterface)getAppRuntime()).getLongAccountUin());
      ((im_reminder.Reminder)localObject3).from_user.set((MessageMicro)localObject4);
      localObject4 = new im_msg_body.MsgBody();
      ((im_msg_body.MsgBody)localObject4).rich_text.set(MessageProtoCodec.a(paramIntent.getStringExtra("p_msg"), null));
      ((im_reminder.Reminder)localObject3).msg_body.set((MessageMicro)localObject4);
      ((im_reminder.Request.Add)localObject2).reminder.set((MessageMicro)localObject3);
      localObject3 = paramIntent.getLongArrayExtra("p_uin_list");
      paramIntent = paramIntent.getLongArrayExtra("p_time_list");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Servlet", 2, "onSendTiming | uin = " + Arrays.toString((long[])localObject3) + " | time = " + Arrays.toString(paramIntent));
      }
      int i = 0;
      while (i < localObject3.length)
      {
        localObject4 = new im_reminder.Request();
        ((im_reminder.Request.Add)localObject2).reminder.to_user.uin.set(localObject3[i]);
        ((im_reminder.Request.Add)localObject2).reminder.at_time.set(paramIntent[i]);
        ((im_reminder.Request)localObject4).add.set((MessageMicro)localObject2);
        ((im_reminder.ReminderPackage)localObject1).request.add((MessageMicro)localObject4);
        i += 1;
      }
      paramPacket.setSSOCommand("ReminderSvc.Reminder");
      paramIntent = ((im_reminder.ReminderPackage)localObject1).toByteArray();
      localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject1).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject1).array());
      return;
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\activateFriends\ActivateFriendServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */