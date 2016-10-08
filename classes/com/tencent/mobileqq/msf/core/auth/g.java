package com.tencent.mobileqq.msf.core.auth;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.core.y;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.msf.service.protocol.security.c;
import com.tencent.msf.service.protocol.security.d;
import com.tencent.msf.service.protocol.security.h;
import com.tencent.msf.service.protocol.security.k;
import com.tencent.msf.service.protocol.security.m;
import com.tencent.msf.service.protocol.security.n;
import com.tencent.msf.service.protocol.security.o;
import com.tencent.msf.service.protocol.security.p;
import com.tencent.msf.service.protocol.security.q;
import com.tencent.msf.service.protocol.security.r;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class g
{
  public static final String a = "test";
  public static final String b = "cmdstr";
  public static final String c = "123";
  public static final String d = "RequestHeader";
  public static final String e = "RequestVerifyPic";
  public static final String f = "RespondVerifyPic";
  public static final String g = "RequestRefreshVPic";
  public static final String h = "RespondRefreshVPic";
  public static final String i = "RespondAuth";
  public static final String j = "RespondHeader";
  public static final String k = "RequestCustomSig";
  public static final String l = "RespondCustomSig";
  public static final int m = 0;
  private static final String o = "MSF.C.AuthCoder";
  b n;
  
  public g(b paramb)
  {
    this.n = paramb;
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt1, paramInt2);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  /* Error */
  private static boolean a(ToServiceMsg paramToServiceMsg, k paramk, a parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: new 73	com/tencent/qphone/base/util/Cryptor
    //   6: dup
    //   7: invokespecial 74	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   10: astore_3
    //   11: aload_2
    //   12: ifnull +236 -> 248
    //   15: aload_2
    //   16: aload_1
    //   17: getfield 79	com/tencent/msf/service/protocol/security/k:h	[B
    //   20: invokevirtual 84	com/tencent/mobileqq/msf/core/auth/a:g	([B)V
    //   23: aload_2
    //   24: aload_1
    //   25: getfield 86	com/tencent/msf/service/protocol/security/k:g	[B
    //   28: invokevirtual 88	com/tencent/mobileqq/msf/core/auth/a:f	([B)V
    //   31: aload_2
    //   32: invokevirtual 91	com/tencent/mobileqq/msf/core/auth/a:j	()[B
    //   35: astore 4
    //   37: aload_3
    //   38: aload_1
    //   39: getfield 79	com/tencent/msf/service/protocol/security/k:h	[B
    //   42: aload 4
    //   44: invokevirtual 95	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   47: astore 4
    //   49: bipush 16
    //   51: newarray <illegal type>
    //   53: astore 5
    //   55: aload 4
    //   57: arraylength
    //   58: bipush 16
    //   60: isub
    //   61: newarray <illegal type>
    //   63: astore 6
    //   65: aload 5
    //   67: iconst_0
    //   68: aload 4
    //   70: bipush 16
    //   72: invokestatic 97	com/tencent/mobileqq/msf/core/auth/g:a	([BI[BI)V
    //   75: aload 6
    //   77: iconst_0
    //   78: aload 4
    //   80: bipush 16
    //   82: aload 4
    //   84: arraylength
    //   85: bipush 16
    //   87: isub
    //   88: invokestatic 99	com/tencent/mobileqq/msf/core/auth/g:a	([BI[BII)V
    //   91: aload_2
    //   92: aload 6
    //   94: invokevirtual 101	com/tencent/mobileqq/msf/core/auth/a:e	([B)V
    //   97: aload_3
    //   98: aload_1
    //   99: getfield 86	com/tencent/msf/service/protocol/security/k:g	[B
    //   102: aload 5
    //   104: invokevirtual 95	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   107: astore 5
    //   109: new 103	java/io/ByteArrayInputStream
    //   112: dup
    //   113: aload 5
    //   115: invokespecial 105	java/io/ByteArrayInputStream:<init>	([B)V
    //   118: astore_3
    //   119: new 107	java/io/DataInputStream
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 110	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   127: astore 4
    //   129: aload 4
    //   131: invokevirtual 114	java/io/DataInputStream:readInt	()I
    //   134: iconst_4
    //   135: isub
    //   136: istore 7
    //   138: iload 7
    //   140: newarray <illegal type>
    //   142: astore 6
    //   144: aload 4
    //   146: aload 6
    //   148: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   151: pop
    //   152: aload_2
    //   153: aload 6
    //   155: invokevirtual 120	com/tencent/mobileqq/msf/core/auth/a:h	([B)V
    //   158: iconst_4
    //   159: newarray <illegal type>
    //   161: astore 6
    //   163: aload 4
    //   165: aload 6
    //   167: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   170: pop
    //   171: aload_1
    //   172: getfield 122	com/tencent/msf/service/protocol/security/k:f	I
    //   175: bipush 10
    //   177: if_icmpeq +31 -> 208
    //   180: aload 5
    //   182: arraylength
    //   183: istore 7
    //   185: aload_1
    //   186: getfield 124	com/tencent/msf/service/protocol/security/k:j	I
    //   189: ifeq +62 -> 251
    //   192: aload_1
    //   193: getfield 124	com/tencent/msf/service/protocol/security/k:j	I
    //   196: istore 7
    //   198: aload 4
    //   200: iload 7
    //   202: newarray <illegal type>
    //   204: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   207: pop
    //   208: bipush 16
    //   210: newarray <illegal type>
    //   212: astore_1
    //   213: aload_1
    //   214: iconst_0
    //   215: aload 6
    //   217: aload 6
    //   219: arraylength
    //   220: invokestatic 97	com/tencent/mobileqq/msf/core/auth/g:a	([BI[BI)V
    //   223: aload_2
    //   224: aload_1
    //   225: invokevirtual 126	com/tencent/mobileqq/msf/core/auth/a:j	([B)V
    //   228: aload_2
    //   229: aload_0
    //   230: invokestatic 131	com/tencent/mobileqq/msf/service/g:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   233: invokevirtual 134	com/tencent/mobileqq/msf/core/auth/a:c	(Ljava/lang/String;)V
    //   236: aload_3
    //   237: invokevirtual 137	java/io/ByteArrayInputStream:close	()V
    //   240: aload 4
    //   242: invokevirtual 138	java/io/DataInputStream:close	()V
    //   245: iconst_1
    //   246: istore 8
    //   248: iload 8
    //   250: ireturn
    //   251: bipush 24
    //   253: istore 7
    //   255: goto -57 -> 198
    //   258: astore_0
    //   259: aload_3
    //   260: invokevirtual 137	java/io/ByteArrayInputStream:close	()V
    //   263: aload 4
    //   265: invokevirtual 138	java/io/DataInputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: aload_3
    //   272: invokevirtual 137	java/io/ByteArrayInputStream:close	()V
    //   275: aload 4
    //   277: invokevirtual 138	java/io/DataInputStream:close	()V
    //   280: goto -35 -> 245
    //   283: astore_0
    //   284: goto -39 -> 245
    //   287: astore_1
    //   288: goto -20 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramToServiceMsg	ToServiceMsg
    //   0	291	1	paramk	k
    //   0	291	2	parama	a
    //   10	262	3	localObject1	Object
    //   35	241	4	localObject2	Object
    //   53	128	5	arrayOfByte1	byte[]
    //   63	155	6	arrayOfByte2	byte[]
    //   136	118	7	i1	int
    //   1	248	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   129	198	258	finally
    //   198	208	258	finally
    //   208	236	258	finally
    //   129	198	270	java/io/IOException
    //   198	208	270	java/io/IOException
    //   208	236	270	java/io/IOException
    //   236	245	283	java/lang/Exception
    //   271	280	283	java/lang/Exception
    //   259	268	287	java/lang/Exception
  }
  
  private byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[24];
    int i2 = (short)paramArrayOfByte.length;
    int i1 = i2;
    if (i2 > 16) {
      i1 = 16;
    }
    long l1 = Long.valueOf(paramString).longValue();
    paramString = new byte[8];
    a(paramString, 4, l1);
    a(arrayOfByte, 0, paramArrayOfByte, i1);
    a(arrayOfByte, 16, paramString, paramString.length);
    return MD5.toMD5Byte(arrayOfByte);
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, int paramInt)
  {
    // Byte code:
    //   0: new 160	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 161	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: new 163	java/io/DataOutputStream
    //   12: dup
    //   13: aload 5
    //   15: invokespecial 166	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 6
    //   20: aload 6
    //   22: iconst_1
    //   23: invokevirtual 170	java/io/DataOutputStream:writeShort	(I)V
    //   26: aload 6
    //   28: new 172	java/util/Random
    //   31: dup
    //   32: invokespecial 173	java/util/Random:<init>	()V
    //   35: invokevirtual 176	java/util/Random:nextInt	()I
    //   38: iconst_1
    //   39: iushr
    //   40: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   43: aload 6
    //   45: iconst_1
    //   46: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   49: aload 6
    //   51: iload 4
    //   53: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   56: aload 6
    //   58: iconst_1
    //   59: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   62: aload 6
    //   64: aload_2
    //   65: invokestatic 183	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   68: invokevirtual 187	java/io/DataOutputStream:writeLong	(J)V
    //   71: aload 6
    //   73: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   76: ldc2_w 191
    //   79: ldiv
    //   80: l2i
    //   81: aload_0
    //   82: getfield 56	com/tencent/mobileqq/msf/core/auth/g:n	Lcom/tencent/mobileqq/msf/core/auth/b;
    //   85: invokevirtual 196	com/tencent/mobileqq/msf/core/auth/b:e	()I
    //   88: iadd
    //   89: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   92: aload 6
    //   94: iconst_0
    //   95: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   98: aload 6
    //   100: iconst_0
    //   101: invokevirtual 199	java/io/DataOutputStream:writeByte	(I)V
    //   104: aload 6
    //   106: aload_3
    //   107: invokevirtual 202	java/io/DataOutputStream:write	([B)V
    //   110: aload 6
    //   112: bipush 16
    //   114: newarray <illegal type>
    //   116: invokevirtual 202	java/io/DataOutputStream:write	([B)V
    //   119: aload 6
    //   121: iconst_0
    //   122: invokevirtual 170	java/io/DataOutputStream:writeShort	(I)V
    //   125: aload 6
    //   127: invokevirtual 205	java/io/DataOutputStream:flush	()V
    //   130: aload 5
    //   132: invokevirtual 208	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   135: astore_2
    //   136: new 73	com/tencent/qphone/base/util/Cryptor
    //   139: dup
    //   140: invokespecial 74	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   143: aload_2
    //   144: aload_1
    //   145: invokevirtual 211	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   148: astore_1
    //   149: aload_1
    //   150: astore_2
    //   151: aload 5
    //   153: invokevirtual 212	java/io/ByteArrayOutputStream:close	()V
    //   156: aload_1
    //   157: astore_2
    //   158: aload 6
    //   160: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   163: aload_1
    //   164: areturn
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +29 -> 200
    //   174: ldc 47
    //   176: iconst_2
    //   177: new 221	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   184: ldc -32
    //   186: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_2
    //   190: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aload_2
    //   197: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload_1
    //   201: astore_2
    //   202: aload 5
    //   204: invokevirtual 212	java/io/ByteArrayOutputStream:close	()V
    //   207: aload_1
    //   208: astore_2
    //   209: aload 6
    //   211: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   214: aload_1
    //   215: areturn
    //   216: astore_1
    //   217: aload_2
    //   218: areturn
    //   219: astore_1
    //   220: aload 5
    //   222: invokevirtual 212	java/io/ByteArrayOutputStream:close	()V
    //   225: aload 6
    //   227: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_2
    //   233: goto -3 -> 230
    //   236: astore_3
    //   237: aload_2
    //   238: astore_1
    //   239: aload_3
    //   240: astore_2
    //   241: goto -73 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	g
    //   0	244	1	paramArrayOfByte1	byte[]
    //   0	244	2	paramString	String
    //   0	244	3	paramArrayOfByte2	byte[]
    //   0	244	4	paramInt	int
    //   7	214	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   18	208	6	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   20	136	165	java/lang/Exception
    //   151	156	216	java/lang/Exception
    //   158	163	216	java/lang/Exception
    //   202	207	216	java/lang/Exception
    //   209	214	216	java/lang/Exception
    //   20	136	219	finally
    //   136	149	219	finally
    //   168	200	219	finally
    //   220	230	232	java/lang/Exception
    //   136	149	236	java/lang/Exception
  }
  
  public void a(UniPacket paramUniPacket, a parama)
  {
    if ((paramUniPacket == null) || (parama == null)) {
      return;
    }
    Object localObject = (RespondCustomSig)paramUniPacket.getByClass("RespondCustomSig", new RespondCustomSig());
    if (localObject != null)
    {
      int i1 = 0;
      if (i1 < ((RespondCustomSig)localObject).SigList.size())
      {
        CustomSigContent localCustomSigContent = (CustomSigContent)((RespondCustomSig)localObject).SigList.get(i1);
        if (localCustomSigContent.ulSigType == 1L) {
          parama.l(localCustomSigContent.SigContent);
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localCustomSigContent.ulSigType == 3L) || (localCustomSigContent.ulSigType != 8L)) {}
        }
      }
    }
    localObject = (q)paramUniPacket.getByClass("UserMainAccount", new q());
    if (localObject != null)
    {
      if (((q)localObject).a != 2L) {
        break label210;
      }
      parama.m(((q)localObject).c);
    }
    for (;;)
    {
      paramUniPacket = (r)paramUniPacket.getByClass("UserSimpleInfo", new r());
      if (paramUniPacket == null) {
        break;
      }
      parama.a(paramUniPacket.a);
      parama.b(paramUniPacket.b);
      parama.c(paramUniPacket.c);
      parama.n(paramUniPacket.d);
      return;
      label210:
      parama.m(parama.d().getBytes());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket, k paramk)
  {
    y.a(paramFromServiceMsg);
    VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
    localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
    localVerifyCodeInfo.wupSeq = paramUniPacket.getRequestId();
    if (paramk.b == 0)
    {
      paramUniPacket = (com.tencent.msf.service.protocol.security.i)paramUniPacket.getByClass("RespondAuth", new com.tencent.msf.service.protocol.security.i());
      localVerifyCodeInfo.vpicSid = paramUniPacket.c;
      localVerifyCodeInfo.svrSeqNo = paramk.e;
      localVerifyCodeInfo.verifyimage = paramUniPacket.a;
      localVerifyCodeInfo.verifyNote = paramUniPacket.b;
    }
    for (;;)
    {
      VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.AuthCoder", 2, "rece loginVerifyCode seq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + paramFromServiceMsg.getServiceCmd() + " svrseqNo:" + localVerifyCodeInfo.svrSeqNo + " vipsid:" + localVerifyCodeInfo.vpicSid + " wupSeq:" + localVerifyCodeInfo.wupSeq);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.AuthCoder", 2, "add " + paramToServiceMsg + " to mutilActionQueue.");
      }
      return;
      if (paramk.b == 12)
      {
        paramUniPacket = (com.tencent.msf.service.protocol.security.i)paramUniPacket.getByClass("RespondAuth", new com.tencent.msf.service.protocol.security.i());
        localVerifyCodeInfo.vpicSid = paramUniPacket.c;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = paramUniPacket.b;
      }
      else if (paramk.b == 1)
      {
        paramUniPacket = (n)paramUniPacket.getByClass("RespondVerifyPic", new n());
        localVerifyCodeInfo.vpicSid = paramUniPacket.b;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = "";
      }
      else if (paramk.b == 2)
      {
        paramUniPacket = (m)paramUniPacket.getByClass("RespondRefreshVPic", new m());
        localVerifyCodeInfo.vpicSid = paramUniPacket.c;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = paramUniPacket.b;
      }
      else if (paramk.b == 13)
      {
        paramUniPacket = (p)paramUniPacket.getByClass("ResponseNameExchangeUin", new p());
        localVerifyCodeInfo.vpicSid = paramUniPacket.c;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = paramUniPacket.b;
      }
      else if (paramk.b == 14)
      {
        paramUniPacket = (o)paramUniPacket.getByClass("ResponseAuthWlogin", new o());
        byte[] arrayOfByte = paramUniPacket.d;
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
        localVerifyCodeInfo.vpicSid = paramUniPacket.c;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = paramUniPacket.b;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, k paramk)
  {
    if (paramk == null) {}
    a locala;
    do
    {
      return;
      locala = (a)this.n.b.remove(paramk.d);
      if (locala != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.AuthCoder", 2, "can not find account " + paramFromServiceMsg.getUin() + " info.");
    return;
    QLog.d("MSF.C.AuthCoder", 1, MD5.toMD5(paramFromServiceMsg.getUin()) + " login succ.");
    locala.c(com.tencent.mobileqq.msf.service.g.b(paramToServiceMsg));
    this.n.a(locala);
    if (a(paramToServiceMsg, paramk, locala))
    {
      long l1 = System.currentTimeMillis();
      locala.a(true);
      locala.a(l1);
      paramk = locala.d();
      byte[] arrayOfByte1 = locala.f();
      byte[] arrayOfByte2 = locala.g();
      byte[] arrayOfByte3 = locala.h();
      byte[] arrayOfByte4 = locala.i();
      byte[] arrayOfByte5 = locala.j();
      byte[] arrayOfByte6 = locala.k();
      CodecWarpper.setAccountKey(paramk, new byte[0], arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, new byte[0], null);
      this.n.n(locala.d());
      w.a(locala.d(), false);
    }
    for (;;)
    {
      try
      {
        this.n.a.getWtLoginCenter().a(locala, true);
        this.n.a.sender.a(paramFromServiceMsg.getAppId(), paramFromServiceMsg.getUin());
        paramFromServiceMsg.addAttribute("resp_simpleAccount", locala.o().toStoreString());
        this.n.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Throwable paramk)
      {
        QLog.d("MSF.C.AuthCoder", 1, MD5.toMD5(paramFromServiceMsg.getUin()) + " set key to wt error " + paramk, paramk);
        continue;
      }
      QLog.d("MSF.C.AuthCoder", 1, MD5.toMD5(paramFromServiceMsg.getUin()) + "decode login failed.");
    }
  }
  
  public byte[] a(int paramInt1, String paramString, int paramInt2, HashMap paramHashMap)
  {
    this.n.b(paramString);
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    localUniPacket.put("RequestHeader", new d(1, paramInt2, MsfCore.getNextSeq(), 1, paramString, paramInt1, String.valueOf(paramInt1), "123", 0));
    if (paramHashMap != null)
    {
      paramString = paramHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (Map.Entry)paramString.next();
        localUniPacket.put((String)paramHashMap.getKey(), paramHashMap.getValue());
      }
    }
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt, String paramString, VerifyCodeInfo paramVerifyCodeInfo)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    String str2 = this.n.j(paramString);
    int i1 = paramVerifyCodeInfo.wupSeq;
    int i2 = paramVerifyCodeInfo.svrSeqNo;
    String str1 = str2;
    if (str2 == null) {
      str1 = paramString;
    }
    localUniPacket.put("RequestHeader", new d(1, 2, i1, i2, str1, paramInt, String.valueOf(paramInt), "123", 0));
    localUniPacket.put("RequestRefreshVPic", new com.tencent.msf.service.protocol.security.g(1, 1));
    localUniPacket.setRequestId(paramVerifyCodeInfo.wupSeq);
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt, String paramString1, String paramString2, VerifyCodeInfo paramVerifyCodeInfo)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    String str2 = this.n.j(paramString1);
    int i1 = paramVerifyCodeInfo.wupSeq;
    int i2 = paramVerifyCodeInfo.svrSeqNo;
    String str1 = str2;
    if (str2 == null) {
      str1 = paramString1;
    }
    localUniPacket.put("RequestHeader", new d(1, 1, i1, i2, str1, paramInt, String.valueOf(paramInt), "123", 0));
    localUniPacket.put("RequestVerifyPic", new h(paramVerifyCodeInfo.vpicSid, paramString2));
    localUniPacket.setRequestId(paramVerifyCodeInfo.wupSeq);
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt1, String paramString, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    this.n.b(paramString);
    a locala = (a)this.n.b.get(paramString);
    localUniPacket.put("RequestHeader", new d(1, 14, MsfCore.getNextSeq(), locala.w(), paramString, paramInt1, String.valueOf(paramInt1), "123", 0));
    byte[] arrayOfByte2 = a(paramString, paramArrayOfByte1);
    byte[] arrayOfByte1 = a(arrayOfByte2, paramString, paramArrayOfByte1, paramInt2);
    locala.i(arrayOfByte2);
    paramArrayOfByte1 = this.n.f();
    paramString = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      paramString = new byte[0];
    }
    localUniPacket.put("RequestAuthWlogin", new com.tencent.msf.service.protocol.security.b(arrayOfByte1, 1, 0, paramString, paramInt3, paramArrayOfByte2));
    paramString = new c();
    paramString.a = ((int)(System.currentTimeMillis() / 1000L) + this.n.e());
    localUniPacket.put("RequestGetServerTime", paramString);
    return localUniPacket.encode();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\auth\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */