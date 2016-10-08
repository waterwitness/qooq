package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.ReqBody;

public class LoginWelcomeHandler
  extends BusinessHandler
{
  public static final String a = "OidbSvc.0x59f";
  
  public LoginWelcomeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Class a()
  {
    return LoginWelcomeManager.class;
  }
  
  public void a()
  {
    b(a("OidbSvc.0x59f", 1439, 1, new oidb_0x59f.ReqBody().toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("OidbSvc.0x59f")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_1
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 4
    //   14: iload 8
    //   16: istore 7
    //   18: aload_2
    //   19: invokevirtual 61	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   22: ifeq +145 -> 167
    //   25: new 63	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   28: dup
    //   29: invokespecial 64	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   32: astore_1
    //   33: aload_1
    //   34: aload_3
    //   35: checkcast 66	[B
    //   38: checkcast 66	[B
    //   41: invokevirtual 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   44: pop
    //   45: aload_1
    //   46: getfield 74	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   49: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   52: ifeq +164 -> 216
    //   55: aload_1
    //   56: getfield 74	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   59: invokevirtual 83	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   62: ifne +154 -> 216
    //   65: new 85	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody
    //   68: dup
    //   69: invokespecial 86	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:<init>	()V
    //   72: astore_3
    //   73: aload_3
    //   74: aload_1
    //   75: getfield 90	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   78: invokevirtual 95	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   81: invokevirtual 98	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   84: invokevirtual 99	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   87: pop
    //   88: aload_3
    //   89: getfield 102	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:uint32_is_first_login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   92: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   95: ifeq +152 -> 247
    //   98: aload_3
    //   99: getfield 102	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:uint32_is_first_login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   102: invokevirtual 83	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   105: iconst_1
    //   106: if_icmpne +141 -> 247
    //   109: iconst_2
    //   110: anewarray 104	java/lang/Object
    //   113: astore_1
    //   114: aload_3
    //   115: getfield 108	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:str_reg_mobile	Lcom/tencent/mobileqq/pb/PBStringField;
    //   118: invokevirtual 111	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   121: ifeq +90 -> 211
    //   124: aload_3
    //   125: getfield 108	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:str_reg_mobile	Lcom/tencent/mobileqq/pb/PBStringField;
    //   128: invokevirtual 113	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   131: astore_2
    //   132: aload_1
    //   133: iconst_0
    //   134: aload_2
    //   135: aastore
    //   136: aload 4
    //   138: astore_2
    //   139: aload_3
    //   140: getfield 117	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:msg_contact_bind_info	Ltencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo;
    //   143: invokevirtual 120	tencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo:has	()Z
    //   146: ifeq +14 -> 160
    //   149: aload_3
    //   150: getfield 117	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:msg_contact_bind_info	Ltencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo;
    //   153: invokevirtual 123	tencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   156: checkcast 119	tencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo
    //   159: astore_2
    //   160: aload_1
    //   161: iconst_1
    //   162: aload_2
    //   163: aastore
    //   164: iconst_1
    //   165: istore 7
    //   167: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +29 -> 199
    //   173: ldc -126
    //   175: iconst_2
    //   176: new 132	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   183: ldc -121
    //   185: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload 7
    //   190: invokevirtual 142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   193: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: sipush 558
    //   203: iload 7
    //   205: aload_1
    //   206: iconst_1
    //   207: invokevirtual 152	com/tencent/mobileqq/loginwelcome/LoginWelcomeHandler:a	(IZLjava/lang/Object;Z)V
    //   210: return
    //   211: aconst_null
    //   212: astore_2
    //   213: goto -81 -> 132
    //   216: ldc -126
    //   218: iconst_1
    //   219: new 132	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   226: ldc -102
    //   228: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: getfield 74	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   235: invokevirtual 83	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   238: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: iconst_0
    //   248: istore 7
    //   250: aload 6
    //   252: astore_1
    //   253: goto -86 -> 167
    //   256: astore_3
    //   257: aload 5
    //   259: astore_2
    //   260: aload_2
    //   261: astore_1
    //   262: iload 8
    //   264: istore 7
    //   266: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -102 -> 167
    //   272: ldc -126
    //   274: iconst_2
    //   275: ldc -94
    //   277: aload_3
    //   278: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_2
    //   282: astore_1
    //   283: iload 8
    //   285: istore 7
    //   287: goto -120 -> 167
    //   290: astore_3
    //   291: aload_1
    //   292: astore_2
    //   293: goto -33 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	LoginWelcomeHandler
    //   0	296	1	paramToServiceMsg	ToServiceMsg
    //   0	296	2	paramFromServiceMsg	FromServiceMsg
    //   0	296	3	paramObject	Object
    //   12	125	4	localObject1	Object
    //   9	249	5	localObject2	Object
    //   4	247	6	localObject3	Object
    //   16	270	7	bool1	boolean
    //   1	283	8	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   25	114	256	java/lang/Throwable
    //   216	247	256	java/lang/Throwable
    //   114	132	290	java/lang/Throwable
    //   139	160	290	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\loginwelcome\LoginWelcomeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */