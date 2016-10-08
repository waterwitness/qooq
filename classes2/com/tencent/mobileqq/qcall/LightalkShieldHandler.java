package com.tencent.mobileqq.qcall;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.cmd0x488.oidb_0x488.AddBlockReq;
import tencent.im.oidb.cmd0x488.oidb_0x488.OneAddBlockData;
import tencent.im.oidb.cmd0x488.oidb_0x488.ReqBody;
import tencent.im.oidb.cmd0x489.oidb_0x489.DelBlockReq;
import tencent.im.oidb.cmd0x489.oidb_0x489.OneDelBlockData;
import tencent.im.oidb.cmd0x489.oidb_0x489.ReqBody;
import tencent.im.oidb.cmd0x48a.oidb_0x48a.ChkBlockReq;
import tencent.im.oidb.cmd0x48a.oidb_0x48a.OneBlockAccountData;
import tencent.im.oidb.cmd0x48a.oidb_0x48a.ReqBody;
import tencent.im.oidb.cmd0x48b.oidb_0x48b.GetblockListReq;
import tencent.im.oidb.cmd0x48b.oidb_0x48b.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class LightalkShieldHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "OidbSvc.0x488_0";
  public static final int b = 2;
  public static final String b = "OidbSvc.0x489_0";
  public static final int c = 3;
  public static final String c = "OidbSvc.0x48a_0";
  public static final int d = 4;
  public static final String d = "OidbSvc.0x48b_0";
  public static final int e = 10;
  public static final String e = "OidbSvc.0x492_114";
  public static final int f = 20;
  private static final String f = LightalkShieldHandler.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LightalkShieldHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = new oidb_0x48b.ReqBody();
    Object localObject2 = new oidb_0x48b.GetblockListReq();
    ((oidb_0x48b.GetblockListReq)localObject2).uint32_start_idx.set(paramInt1);
    ((oidb_0x48b.GetblockListReq)localObject2).uint32_req_num.set(100);
    ((oidb_0x48b.GetblockListReq)localObject2).uint32_last_get_time.set(paramInt2);
    ((oidb_0x48b.ReqBody)localObject1).msg_get_blocklist_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1163);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.d());
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x48b.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x48b_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  /* Error */
  private void b(FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 145	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifne +14 -> 22
    //   11: aload_0
    //   12: iconst_1
    //   13: iconst_0
    //   14: iconst_m1
    //   15: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   21: return
    //   22: new 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   25: dup
    //   26: invokespecial 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   29: astore_2
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual 157	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   35: invokevirtual 161	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   38: checkcast 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +306 -> 349
    //   46: aload_1
    //   47: getfield 164	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   50: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   53: ifeq +296 -> 349
    //   56: aload_1
    //   57: getfield 164	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   63: istore 4
    //   65: iload 4
    //   67: istore_3
    //   68: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +47 -> 118
    //   74: ldc -78
    //   76: iconst_2
    //   77: new 180	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   84: ldc -73
    //   86: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: iload 4
    //   91: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: ldc -64
    //   96: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: getfield 195	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   103: invokevirtual 197	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   106: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: iload 4
    //   117: istore_3
    //   118: iload_3
    //   119: ifne +219 -> 338
    //   122: aload_1
    //   123: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   126: invokevirtual 204	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   129: ifeq +209 -> 338
    //   132: aload_1
    //   133: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   136: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   139: ifnull +199 -> 338
    //   142: aload_1
    //   143: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   146: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   149: invokevirtual 208	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   152: astore_2
    //   153: new 210	tencent/im/oidb/cmd0x488/oidb_0x488$RspBody
    //   156: dup
    //   157: invokespecial 211	tencent/im/oidb/cmd0x488/oidb_0x488$RspBody:<init>	()V
    //   160: astore_1
    //   161: aload_1
    //   162: aload_2
    //   163: invokevirtual 212	tencent/im/oidb/cmd0x488/oidb_0x488$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   166: pop
    //   167: aload_1
    //   168: getfield 216	tencent/im/oidb/cmd0x488/oidb_0x488$RspBody:msg_add_block_rsp	Ltencent/im/oidb/cmd0x488/oidb_0x488$AddBlockRsp;
    //   171: getfield 222	tencent/im/oidb/cmd0x488/oidb_0x488$AddBlockRsp:msg_one_block_data	Ltencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData;
    //   174: invokevirtual 227	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   177: checkcast 224	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData
    //   180: astore_1
    //   181: aload_1
    //   182: getfield 228	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   185: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   188: istore_3
    //   189: iload_3
    //   190: ifeq +8 -> 198
    //   193: iload_3
    //   194: iconst_1
    //   195: if_icmpne +132 -> 327
    //   198: new 230	com/tencent/mobileqq/qcall/LightalkShieldData
    //   201: dup
    //   202: invokespecial 231	com/tencent/mobileqq/qcall/LightalkShieldData:<init>	()V
    //   205: astore_2
    //   206: aload_2
    //   207: aload_1
    //   208: getfield 235	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData:uint64_block_qcall_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   211: invokevirtual 240	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   214: putfield 244	com/tencent/mobileqq/qcall/LightalkShieldData:qcallId	J
    //   217: aload_2
    //   218: aload_1
    //   219: getfield 247	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData:bytes_mobile	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   222: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   225: invokevirtual 250	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   228: putfield 253	com/tencent/mobileqq/qcall/LightalkShieldData:phone	Ljava/lang/String;
    //   231: aload_0
    //   232: getfield 256	com/tencent/mobileqq/qcall/LightalkShieldHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   235: sipush 138
    //   238: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   241: checkcast 264	com/tencent/mobileqq/qcall/LightalkShieldManager
    //   244: aload_2
    //   245: invokevirtual 267	com/tencent/mobileqq/qcall/LightalkShieldManager:a	(Lcom/tencent/mobileqq/qcall/LightalkShieldData;)V
    //   248: aload_0
    //   249: iconst_1
    //   250: iconst_1
    //   251: iload_3
    //   252: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   258: return
    //   259: astore_1
    //   260: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   263: iconst_4
    //   264: aload_1
    //   265: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   268: aload_1
    //   269: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload_2
    //   273: astore_1
    //   274: goto -232 -> 42
    //   277: astore_1
    //   278: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   281: iconst_4
    //   282: aload_1
    //   283: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: aload_1
    //   287: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   290: aload_2
    //   291: astore_1
    //   292: goto -250 -> 42
    //   295: astore_2
    //   296: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   299: iconst_4
    //   300: aload_2
    //   301: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   304: aload_2
    //   305: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   308: goto -141 -> 167
    //   311: astore_2
    //   312: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   315: iconst_4
    //   316: aload_2
    //   317: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   320: aload_2
    //   321: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: goto -157 -> 167
    //   327: aload_0
    //   328: iconst_1
    //   329: iconst_0
    //   330: iload_3
    //   331: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   337: return
    //   338: aload_0
    //   339: iconst_1
    //   340: iconst_0
    //   341: iconst_m1
    //   342: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   345: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   348: return
    //   349: iconst_m1
    //   350: istore_3
    //   351: goto -233 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	LightalkShieldHandler
    //   0	354	1	paramFromServiceMsg	FromServiceMsg
    //   29	262	2	localObject	Object
    //   295	10	2	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   311	10	2	localException	Exception
    //   67	284	3	i	int
    //   63	53	4	j	int
    // Exception table:
    //   from	to	target	type
    //   30	42	259	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   30	42	277	java/lang/Exception
    //   161	167	295	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   161	167	311	java/lang/Exception
  }
  
  private void c()
  {
    a(0, ((LightalkShieldManager)this.b.getManager(138)).a());
  }
  
  /* Error */
  private void c(FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 145	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifne +14 -> 22
    //   11: aload_0
    //   12: iconst_1
    //   13: iconst_0
    //   14: iconst_m1
    //   15: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   21: return
    //   22: new 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   25: dup
    //   26: invokespecial 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   29: astore_2
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual 157	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   35: invokevirtual 161	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   38: checkcast 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +307 -> 350
    //   46: aload_1
    //   47: getfield 164	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   50: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   53: ifeq +297 -> 350
    //   56: aload_1
    //   57: getfield 164	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   63: istore 4
    //   65: iload 4
    //   67: istore_3
    //   68: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +48 -> 119
    //   74: ldc -78
    //   76: iconst_2
    //   77: new 180	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 281
    //   87: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload 4
    //   92: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc -64
    //   97: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: getfield 195	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   104: invokevirtual 197	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   107: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: iload 4
    //   118: istore_3
    //   119: iload_3
    //   120: ifne +219 -> 339
    //   123: aload_1
    //   124: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   127: invokevirtual 204	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   130: ifeq +209 -> 339
    //   133: aload_1
    //   134: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   137: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   140: ifnull +199 -> 339
    //   143: aload_1
    //   144: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   147: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   150: invokevirtual 208	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   153: astore_2
    //   154: new 283	tencent/im/oidb/cmd0x489/oidb_0x489$RspBody
    //   157: dup
    //   158: invokespecial 284	tencent/im/oidb/cmd0x489/oidb_0x489$RspBody:<init>	()V
    //   161: astore_1
    //   162: aload_1
    //   163: aload_2
    //   164: invokevirtual 285	tencent/im/oidb/cmd0x489/oidb_0x489$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   167: pop
    //   168: aload_1
    //   169: getfield 289	tencent/im/oidb/cmd0x489/oidb_0x489$RspBody:msg_del_block_rsp	Ltencent/im/oidb/cmd0x489/oidb_0x489$DelBlockRsp;
    //   172: getfield 294	tencent/im/oidb/cmd0x489/oidb_0x489$DelBlockRsp:msg_one_block_data	Ltencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData;
    //   175: invokevirtual 297	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   178: checkcast 296	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData
    //   181: astore_1
    //   182: aload_1
    //   183: getfield 298	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   186: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   189: istore_3
    //   190: iload_3
    //   191: ifeq +8 -> 199
    //   194: iload_3
    //   195: iconst_1
    //   196: if_icmpne +132 -> 328
    //   199: new 230	com/tencent/mobileqq/qcall/LightalkShieldData
    //   202: dup
    //   203: invokespecial 231	com/tencent/mobileqq/qcall/LightalkShieldData:<init>	()V
    //   206: astore_2
    //   207: aload_2
    //   208: aload_1
    //   209: getfield 299	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData:uint64_block_qcall_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   212: invokevirtual 240	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   215: putfield 244	com/tencent/mobileqq/qcall/LightalkShieldData:qcallId	J
    //   218: aload_2
    //   219: aload_1
    //   220: getfield 300	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData:bytes_mobile	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   226: invokevirtual 250	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   229: putfield 253	com/tencent/mobileqq/qcall/LightalkShieldData:phone	Ljava/lang/String;
    //   232: aload_0
    //   233: getfield 256	com/tencent/mobileqq/qcall/LightalkShieldHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   236: sipush 138
    //   239: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   242: checkcast 264	com/tencent/mobileqq/qcall/LightalkShieldManager
    //   245: aload_2
    //   246: invokevirtual 302	com/tencent/mobileqq/qcall/LightalkShieldManager:b	(Lcom/tencent/mobileqq/qcall/LightalkShieldData;)V
    //   249: aload_0
    //   250: iconst_2
    //   251: iconst_1
    //   252: iload_3
    //   253: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   259: return
    //   260: astore_1
    //   261: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   264: iconst_4
    //   265: aload_1
    //   266: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   269: aload_1
    //   270: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload_2
    //   274: astore_1
    //   275: goto -233 -> 42
    //   278: astore_1
    //   279: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   282: iconst_4
    //   283: aload_1
    //   284: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   287: aload_1
    //   288: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: aload_2
    //   292: astore_1
    //   293: goto -251 -> 42
    //   296: astore_2
    //   297: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   300: iconst_4
    //   301: aload_2
    //   302: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   305: aload_2
    //   306: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   309: goto -141 -> 168
    //   312: astore_2
    //   313: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   316: iconst_4
    //   317: aload_2
    //   318: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   321: aload_2
    //   322: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   325: goto -157 -> 168
    //   328: aload_0
    //   329: iconst_2
    //   330: iconst_0
    //   331: iload_3
    //   332: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   338: return
    //   339: aload_0
    //   340: iconst_2
    //   341: iconst_0
    //   342: iconst_m1
    //   343: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   349: return
    //   350: iconst_m1
    //   351: istore_3
    //   352: goto -233 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	LightalkShieldHandler
    //   0	355	1	paramFromServiceMsg	FromServiceMsg
    //   29	263	2	localObject	Object
    //   296	10	2	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   312	10	2	localException	Exception
    //   67	285	3	i	int
    //   63	54	4	j	int
    // Exception table:
    //   from	to	target	type
    //   30	42	260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   30	42	278	java/lang/Exception
    //   162	168	296	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   162	168	312	java/lang/Exception
  }
  
  /* Error */
  private void d(FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 145	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifne +11 -> 19
    //   11: aload_0
    //   12: iconst_3
    //   13: iconst_0
    //   14: aconst_null
    //   15: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   18: return
    //   19: new 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   22: dup
    //   23: invokespecial 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: aload_1
    //   29: invokevirtual 157	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   32: invokevirtual 161	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   35: checkcast 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   38: astore_1
    //   39: iconst_m1
    //   40: istore 4
    //   42: iload 4
    //   44: istore_3
    //   45: aload_1
    //   46: ifnull +79 -> 125
    //   49: iload 4
    //   51: istore_3
    //   52: aload_1
    //   53: getfield 164	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   56: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   59: ifeq +66 -> 125
    //   62: aload_1
    //   63: getfield 164	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   66: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   69: istore 4
    //   71: iload 4
    //   73: istore_3
    //   74: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +48 -> 125
    //   80: ldc -78
    //   82: iconst_2
    //   83: new 180	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 304
    //   93: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload 4
    //   98: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc -64
    //   103: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: getfield 195	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   110: invokevirtual 197	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   113: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: iload 4
    //   124: istore_3
    //   125: iload_3
    //   126: ifne +194 -> 320
    //   129: aload_1
    //   130: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 204	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   136: ifeq +184 -> 320
    //   139: aload_1
    //   140: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   143: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   146: ifnull +174 -> 320
    //   149: aload_1
    //   150: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   153: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   156: invokevirtual 208	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   159: astore_2
    //   160: new 306	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody
    //   163: dup
    //   164: invokespecial 307	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody:<init>	()V
    //   167: astore_1
    //   168: aload_1
    //   169: aload_2
    //   170: invokevirtual 308	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   173: pop
    //   174: aload_1
    //   175: getfield 312	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody:msg_chk_block_rsp	Ltencent/im/oidb/cmd0x48a/oidb_0x48a$ChkBlockRsp;
    //   178: getfield 315	tencent/im/oidb/cmd0x48a/oidb_0x48a$ChkBlockRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: istore_3
    //   185: aload_1
    //   186: getfield 312	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody:msg_chk_block_rsp	Ltencent/im/oidb/cmd0x48a/oidb_0x48a$ChkBlockRsp;
    //   189: getfield 319	tencent/im/oidb/cmd0x48a/oidb_0x48a$ChkBlockRsp:msg_block_account_data	Ltencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData;
    //   192: invokevirtual 322	tencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   195: checkcast 321	tencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData
    //   198: astore_1
    //   199: aload_1
    //   200: getfield 323	tencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData:uint64_block_qcall_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   203: invokevirtual 240	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   206: pop2
    //   207: aload_1
    //   208: getfield 326	tencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData:uint32_account_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   211: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   214: pop
    //   215: iload_3
    //   216: bipush 100
    //   218: irem
    //   219: bipush 10
    //   221: idiv
    //   222: istore 4
    //   224: iload_3
    //   225: bipush 10
    //   227: irem
    //   228: ifne +86 -> 314
    //   231: iconst_0
    //   232: istore 5
    //   234: aload_0
    //   235: iconst_3
    //   236: iconst_1
    //   237: iload 5
    //   239: invokestatic 331	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   242: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   245: return
    //   246: astore_1
    //   247: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   250: iconst_4
    //   251: aload_1
    //   252: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   255: aload_1
    //   256: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload_2
    //   260: astore_1
    //   261: goto -222 -> 39
    //   264: astore_1
    //   265: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   268: iconst_4
    //   269: aload_1
    //   270: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   273: aload_1
    //   274: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: aload_2
    //   278: astore_1
    //   279: goto -240 -> 39
    //   282: astore_2
    //   283: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   286: iconst_4
    //   287: aload_2
    //   288: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   291: aload_2
    //   292: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   295: goto -121 -> 174
    //   298: astore_2
    //   299: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   302: iconst_4
    //   303: aload_2
    //   304: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   307: aload_2
    //   308: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: goto -137 -> 174
    //   314: iconst_1
    //   315: istore 5
    //   317: goto -83 -> 234
    //   320: aload_0
    //   321: iconst_3
    //   322: iconst_0
    //   323: aconst_null
    //   324: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   327: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	LightalkShieldHandler
    //   0	328	1	paramFromServiceMsg	FromServiceMsg
    //   26	252	2	localObject	Object
    //   282	10	2	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   298	10	2	localException	Exception
    //   44	184	3	i	int
    //   40	183	4	j	int
    //   232	84	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   27	39	246	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   27	39	264	java/lang/Exception
    //   168	174	282	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   168	174	298	java/lang/Exception
  }
  
  /* Error */
  private void e(FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 145	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifne +11 -> 19
    //   11: aload_0
    //   12: iconst_4
    //   13: iconst_0
    //   14: aconst_null
    //   15: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   18: return
    //   19: new 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   22: dup
    //   23: invokespecial 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: aload_1
    //   29: invokevirtual 157	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   32: invokevirtual 161	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   35: checkcast 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   38: astore_1
    //   39: iconst_m1
    //   40: istore 6
    //   42: iload 6
    //   44: istore 5
    //   46: aload_1
    //   47: ifnull +82 -> 129
    //   50: iload 6
    //   52: istore 5
    //   54: aload_1
    //   55: getfield 164	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   58: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   61: ifeq +68 -> 129
    //   64: aload_1
    //   65: getfield 164	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   68: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   71: istore 6
    //   73: iload 6
    //   75: istore 5
    //   77: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +49 -> 129
    //   83: ldc -78
    //   85: iconst_2
    //   86: new 180	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 333
    //   96: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload 6
    //   101: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc -64
    //   106: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: getfield 195	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   113: invokevirtual 197	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   116: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: iload 6
    //   127: istore 5
    //   129: iload 5
    //   131: ifne +346 -> 477
    //   134: aload_1
    //   135: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   138: invokevirtual 204	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   141: ifeq +336 -> 477
    //   144: aload_1
    //   145: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   148: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   151: ifnull +326 -> 477
    //   154: aload_1
    //   155: getfield 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   158: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: invokevirtual 208	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   164: astore_1
    //   165: new 335	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody
    //   168: dup
    //   169: invokespecial 336	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:<init>	()V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_1
    //   175: invokevirtual 337	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   178: pop
    //   179: aload_2
    //   180: getfield 341	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:msg_get_blocklist_rsp	Ltencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp;
    //   183: getfield 346	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp:uint32_over	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   186: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   189: istore 5
    //   191: aload_2
    //   192: getfield 341	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:msg_get_blocklist_rsp	Ltencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp;
    //   195: getfield 349	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp:uint32_next_start_idx	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   198: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   201: istore 6
    //   203: aload_2
    //   204: getfield 341	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:msg_get_blocklist_rsp	Ltencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp;
    //   207: getfield 352	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp:uint32_get_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   210: invokevirtual 171	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   213: istore 7
    //   215: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +52 -> 270
    //   221: ldc -78
    //   223: iconst_2
    //   224: new 180	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 354
    //   234: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: iload 5
    //   239: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc_w 356
    //   245: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: iload 6
    //   250: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc_w 358
    //   256: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: iload 7
    //   261: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_0
    //   271: getfield 256	com/tencent/mobileqq/qcall/LightalkShieldHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   274: sipush 138
    //   277: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   280: checkcast 264	com/tencent/mobileqq/qcall/LightalkShieldManager
    //   283: astore_1
    //   284: aload_2
    //   285: getfield 341	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:msg_get_blocklist_rsp	Ltencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp;
    //   288: getfield 362	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp:rpt_msg_get_total_block_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   291: invokevirtual 367	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   294: astore_2
    //   295: aload_2
    //   296: ifnull +151 -> 447
    //   299: aload_2
    //   300: invokeinterface 372 1 0
    //   305: ifle +142 -> 447
    //   308: aload_2
    //   309: invokeinterface 376 1 0
    //   314: astore_2
    //   315: aload_2
    //   316: invokeinterface 381 1 0
    //   321: ifeq +126 -> 447
    //   324: aload_2
    //   325: invokeinterface 385 1 0
    //   330: checkcast 387	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetTotalblockInfo
    //   333: astore_3
    //   334: new 230	com/tencent/mobileqq/qcall/LightalkShieldData
    //   337: dup
    //   338: invokespecial 231	com/tencent/mobileqq/qcall/LightalkShieldData:<init>	()V
    //   341: astore 4
    //   343: aload 4
    //   345: aload_3
    //   346: getfield 388	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetTotalblockInfo:uint64_block_qcall_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   349: invokevirtual 240	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   352: putfield 244	com/tencent/mobileqq/qcall/LightalkShieldData:qcallId	J
    //   355: aload 4
    //   357: aload_3
    //   358: getfield 389	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetTotalblockInfo:bytes_mobile	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   361: invokevirtual 207	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   364: invokevirtual 250	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   367: putfield 253	com/tencent/mobileqq/qcall/LightalkShieldData:phone	Ljava/lang/String;
    //   370: aload_1
    //   371: aload 4
    //   373: invokevirtual 267	com/tencent/mobileqq/qcall/LightalkShieldManager:a	(Lcom/tencent/mobileqq/qcall/LightalkShieldData;)V
    //   376: goto -61 -> 315
    //   379: astore_1
    //   380: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   383: iconst_4
    //   384: aload_1
    //   385: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   388: aload_1
    //   389: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   392: aload_2
    //   393: astore_1
    //   394: goto -355 -> 39
    //   397: astore_1
    //   398: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   401: iconst_4
    //   402: aload_1
    //   403: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   406: aload_1
    //   407: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   410: aload_2
    //   411: astore_1
    //   412: goto -373 -> 39
    //   415: astore_1
    //   416: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   419: iconst_4
    //   420: aload_1
    //   421: invokevirtual 270	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   424: aload_1
    //   425: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: goto -249 -> 179
    //   431: astore_1
    //   432: getstatic 44	com/tencent/mobileqq/qcall/LightalkShieldHandler:f	Ljava/lang/String;
    //   435: iconst_4
    //   436: aload_1
    //   437: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   440: aload_1
    //   441: invokestatic 274	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   444: goto -265 -> 179
    //   447: iload 5
    //   449: ifne +14 -> 463
    //   452: aload_0
    //   453: iload 6
    //   455: aload_1
    //   456: invokevirtual 277	com/tencent/mobileqq/qcall/LightalkShieldManager:a	()I
    //   459: invokespecial 279	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(II)V
    //   462: return
    //   463: aload_1
    //   464: iload 7
    //   466: invokevirtual 391	com/tencent/mobileqq/qcall/LightalkShieldManager:a	(I)V
    //   469: aload_0
    //   470: iconst_4
    //   471: iconst_1
    //   472: aconst_null
    //   473: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   476: return
    //   477: aload_0
    //   478: iconst_4
    //   479: iconst_0
    //   480: aconst_null
    //   481: invokevirtual 154	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   484: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	LightalkShieldHandler
    //   0	485	1	paramFromServiceMsg	FromServiceMsg
    //   26	385	2	localObject	Object
    //   333	25	3	localGetTotalblockInfo	tencent.im.oidb.cmd0x48b.oidb_0x48b.GetTotalblockInfo
    //   341	31	4	localLightalkShieldData	LightalkShieldData
    //   44	404	5	i	int
    //   40	414	6	j	int
    //   213	252	7	k	int
    // Exception table:
    //   from	to	target	type
    //   27	39	379	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   27	39	397	java/lang/Exception
    //   173	179	415	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   173	179	431	java/lang/Exception
  }
  
  private void f(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
      a(4, false, null);
    }
    label220:
    do
    {
      do
      {
        for (;;)
        {
          return;
          oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
          try
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(paramFromServiceMsg.getWupBuffer());
            int j = -1;
            int i = j;
            if (paramFromServiceMsg != null)
            {
              i = j;
              if (paramFromServiceMsg.uint32_result.has())
              {
                j = paramFromServiceMsg.uint32_result.get();
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.d("lightalk_shield_handler", 2, "handleShieldLightalkFlag| ret:" + j + " errMsg:" + paramFromServiceMsg.str_error_msg.get());
                  i = j;
                }
              }
            }
            if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()))
            {
              paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
              if (paramFromServiceMsg.length != 5) {
                break label220;
              }
              if (paramFromServiceMsg[4] == 1)
              {
                c();
                return;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            for (;;)
            {
              QLog.w(f, 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
              paramFromServiceMsg = localOIDBSSOPkg;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              QLog.w(f, 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
              paramFromServiceMsg = localOIDBSSOPkg;
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("lightalk_shield_handler", 2, "handleShieldLightalkFlag| flag!=1.");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("lightalk_shield_handler", 2, "handleShieldLightalkFlag| data.len!=5.");
  }
  
  protected Class a()
  {
    return LightalkShieldObserver.class;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt, long paramLong)
  {
    oidb_0x488.OneAddBlockData localOneAddBlockData = new oidb_0x488.OneAddBlockData();
    localOneAddBlockData.uint32_account_type.set(paramInt);
    localOneAddBlockData.uint64_block_qcall_id.set(paramLong);
    a(localOneAddBlockData, 0);
  }
  
  public void a(int paramInt, String paramString)
  {
    oidb_0x488.OneAddBlockData localOneAddBlockData = new oidb_0x488.OneAddBlockData();
    localOneAddBlockData.uint32_account_type.set(paramInt);
    localOneAddBlockData.bytes_mobile.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    a(localOneAddBlockData, 1);
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new oidb_0x48a.ReqBody();
    Object localObject2 = new oidb_0x48a.ChkBlockReq();
    oidb_0x48a.OneBlockAccountData localOneBlockAccountData = new oidb_0x48a.OneBlockAccountData();
    localOneBlockAccountData.uint32_account_type.set(10);
    localOneBlockAccountData.uint64_block_qcall_id.set(paramLong);
    ((oidb_0x48a.ChkBlockReq)localObject2).msg_block_account_data.set(localOneBlockAccountData);
    ((oidb_0x48a.ReqBody)localObject1).msg_chk_block_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1162);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.d());
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x48a.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x48a_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      return;
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
      if (paramToServiceMsg.equals("OidbSvc.0x488_0"))
      {
        b(paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.equals("OidbSvc.0x489_0"))
      {
        c(paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.equals("OidbSvc.0x48a_0"))
      {
        d(paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.equals("OidbSvc.0x48b_0"))
      {
        e(paramFromServiceMsg);
        return;
      }
    } while (!paramToServiceMsg.equals("OidbSvc.0x492_114"));
    f(paramFromServiceMsg);
  }
  
  public void a(oidb_0x488.OneAddBlockData paramOneAddBlockData, int paramInt)
  {
    Object localObject = new oidb_0x488.AddBlockReq();
    ((oidb_0x488.AddBlockReq)localObject).msg_one_block_data.set(paramOneAddBlockData);
    paramOneAddBlockData = new oidb_0x488.ReqBody();
    paramOneAddBlockData.msg_add_block_req.set((MessageMicro)localObject);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1160);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.d());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramOneAddBlockData.toByteArray()));
    paramOneAddBlockData = a("OidbSvc.0x488_0");
    paramOneAddBlockData.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    b(paramOneAddBlockData);
  }
  
  public void a(oidb_0x489.OneDelBlockData paramOneDelBlockData, int paramInt)
  {
    Object localObject = new oidb_0x489.ReqBody();
    oidb_0x489.DelBlockReq localDelBlockReq = new oidb_0x489.DelBlockReq();
    localDelBlockReq.msg_one_block_data.set(paramOneDelBlockData);
    ((oidb_0x489.ReqBody)localObject).msg_del_block_req.set(localDelBlockReq);
    paramOneDelBlockData = new oidb_sso.OIDBSSOPkg();
    paramOneDelBlockData.uint32_command.set(1161);
    paramOneDelBlockData.uint32_service_type.set(paramInt);
    paramOneDelBlockData.str_client_version.set(AppSetting.d());
    paramOneDelBlockData.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x489.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x489_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramOneDelBlockData.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1170);
    localOIDBSSOPkg.uint32_service_type.set(114);
    Object localObject = this.b.f();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    try
    {
      localByteBuffer.putInt(Integer.parseInt((String)localObject));
      localObject = localByteBuffer.array();
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = a("OidbSvc.0x492_114");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("lightalk_shield_handler", 2, "reqShieldLightalkFlag| uin format exception.");
    }
  }
  
  public void b(int paramInt, long paramLong)
  {
    oidb_0x489.OneDelBlockData localOneDelBlockData = new oidb_0x489.OneDelBlockData();
    localOneDelBlockData.uint32_account_type.set(paramInt);
    localOneDelBlockData.uint64_block_qcall_id.set(paramLong);
    a(localOneDelBlockData, 0);
  }
  
  public void b(int paramInt, String paramString)
  {
    oidb_0x489.OneDelBlockData localOneDelBlockData = new oidb_0x489.OneDelBlockData();
    localOneDelBlockData.uint32_account_type.set(paramInt);
    localOneDelBlockData.bytes_mobile.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    a(localOneDelBlockData, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\LightalkShieldHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */