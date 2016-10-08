package com.tencent.biz.pubaccount.readinjoy.protocol;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ReadInJoyOidbHelper
{
  public ReadInJoyOidbHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static int a(com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject, com.tencent.mobileqq.pb.MessageMicro paramMessageMicro)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 25	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   7: istore 5
    //   9: invokestatic 31	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   12: ifeq +215 -> 227
    //   15: new 33	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   22: astore_3
    //   23: iload 5
    //   25: sipush 1000
    //   28: if_icmpne +173 -> 201
    //   31: aload_1
    //   32: ifnull +132 -> 164
    //   35: new 36	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   38: dup
    //   39: invokespecial 37	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   42: astore_0
    //   43: aload_0
    //   44: aload_1
    //   45: checkcast 39	[B
    //   48: checkcast 39	[B
    //   51: invokevirtual 43	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   54: checkcast 36	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_0
    //   61: ifnull +163 -> 224
    //   64: aload_0
    //   65: getfield 47	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   68: invokevirtual 52	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   71: istore 5
    //   73: aload_0
    //   74: ifnull +42 -> 116
    //   77: aload_0
    //   78: getfield 56	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   81: invokevirtual 61	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   84: ifeq +32 -> 116
    //   87: aload_0
    //   88: getfield 56	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   91: invokevirtual 64	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   94: ifnull +22 -> 116
    //   97: aload_2
    //   98: ifnull +18 -> 116
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 56	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   106: invokevirtual 64	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 70	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   112: invokevirtual 73	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: pop
    //   116: aload_3
    //   117: ifnull +16 -> 133
    //   120: aload_3
    //   121: invokevirtual 76	java/lang/StringBuilder:length	()I
    //   124: ifle +9 -> 133
    //   127: invokestatic 31	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   130: ifeq +3 -> 133
    //   133: iload 5
    //   135: ireturn
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_3
    //   140: ifnull +17 -> 157
    //   143: aload_3
    //   144: ldc 78
    //   146: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 86	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   161: goto -101 -> 60
    //   164: aload 4
    //   166: astore_0
    //   167: aload_3
    //   168: ifnull -108 -> 60
    //   171: aload_3
    //   172: ldc 91
    //   174: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 4
    //   180: astore_0
    //   181: goto -121 -> 60
    //   184: astore_0
    //   185: aload_3
    //   186: ifnull -70 -> 116
    //   189: aload_3
    //   190: aload_0
    //   191: invokevirtual 86	java/lang/Exception:toString	()Ljava/lang/String;
    //   194: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: goto -82 -> 116
    //   201: aload_3
    //   202: ifnull +15 -> 217
    //   205: aload_3
    //   206: ldc 93
    //   208: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload 5
    //   213: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: goto -101 -> 116
    //   220: astore_1
    //   221: goto -82 -> 139
    //   224: goto -151 -> 73
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -206 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	232	1	paramObject	Object
    //   0	232	2	paramMessageMicro	com.tencent.mobileqq.pb.MessageMicro
    //   22	207	3	localStringBuilder	StringBuilder
    //   1	178	4	localObject	Object
    //   7	205	5	i	int
    // Exception table:
    //   from	to	target	type
    //   35	43	136	java/lang/Exception
    //   101	116	184	java/lang/Exception
    //   43	58	220	java/lang/Exception
  }
  
  public static ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", ReadInJoyUtils.a(), paramString);
  }
  
  public static ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.str_client_version.set(AppSetting.d());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\protocol\ReadInJoyOidbHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */