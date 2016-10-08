package com.tencent.mqpsdk.secsrv;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.ims.safecheckPB.ReportItem;
import com.tencent.ims.safecheckPB.ReqMQScanRequest;
import com.tencent.ims.safecheckPB.RspMQScanReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mqpsdk.MQPSecServiceManager;
import com.tencent.mqpsdk.util.NetUtil;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import wph;

public class MQPAPPScanService
{
  public static final int a = 1001;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 1002;
  public static final int c = 1003;
  public static final int d = 1004;
  public static final int e = 1005;
  public static final int f = 1006;
  public static final int g = 1007;
  public static int h = 0;
  private static final int i = 1;
  private MQPSecServiceManager jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager;
  
  public MQPAPPScanService(MQPSecServiceManager paramMQPSecServiceManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager = paramMQPSecServiceManager;
  }
  
  /* Error */
  private void b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 46	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_Boolean	Z
    //   8: ifne -4 -> 4
    //   11: iconst_1
    //   12: putstatic 46	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_Boolean	Z
    //   15: new 48	com/tencent/ims/safecheckPB$ReqMQScanRequest
    //   18: dup
    //   19: invokespecial 49	com/tencent/ims/safecheckPB$ReqMQScanRequest:<init>	()V
    //   22: astore_2
    //   23: new 51	com/tencent/ims/safecheckPB$RspMQScanReport
    //   26: dup
    //   27: invokespecial 52	com/tencent/ims/safecheckPB$RspMQScanReport:<init>	()V
    //   30: astore_3
    //   31: aload_2
    //   32: aload_1
    //   33: invokevirtual 56	com/tencent/ims/safecheckPB$ReqMQScanRequest:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   36: pop
    //   37: aload_2
    //   38: getfield 60	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_condition	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   41: invokevirtual 66	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   44: ifeq +526 -> 570
    //   47: aload_2
    //   48: getfield 60	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_condition	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   51: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   54: istore 6
    //   56: aload_0
    //   57: iload 6
    //   59: invokevirtual 73	com/tencent/mqpsdk/secsrv/MQPAPPScanService:a	(I)Z
    //   62: ifne +60 -> 122
    //   65: aload_0
    //   66: monitorenter
    //   67: getstatic 75	com/tencent/mqpsdk/secsrv/MQPAPPScanService:h	I
    //   70: iconst_1
    //   71: isub
    //   72: putstatic 75	com/tencent/mqpsdk/secsrv/MQPAPPScanService:h	I
    //   75: aload_0
    //   76: monitorexit
    //   77: iconst_0
    //   78: putstatic 46	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_Boolean	Z
    //   81: return
    //   82: astore_1
    //   83: iconst_0
    //   84: putstatic 46	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_Boolean	Z
    //   87: aload_1
    //   88: invokevirtual 78	java/lang/Exception:printStackTrace	()V
    //   91: aload_0
    //   92: iload 6
    //   94: invokevirtual 73	com/tencent/mqpsdk/secsrv/MQPAPPScanService:a	(I)Z
    //   97: ifne +170 -> 267
    //   100: aload_0
    //   101: monitorenter
    //   102: getstatic 75	com/tencent/mqpsdk/secsrv/MQPAPPScanService:h	I
    //   105: iconst_1
    //   106: isub
    //   107: putstatic 75	com/tencent/mqpsdk/secsrv/MQPAPPScanService:h	I
    //   110: aload_0
    //   111: monitorexit
    //   112: iconst_0
    //   113: putstatic 46	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_Boolean	Z
    //   116: return
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    //   122: aload_2
    //   123: getfield 81	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 66	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   129: ifeq +435 -> 564
    //   132: aload_2
    //   133: getfield 81	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   136: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   139: istore 7
    //   141: aload_3
    //   142: getfield 84	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   145: aload_2
    //   146: getfield 85	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   149: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   152: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   155: aload_3
    //   156: getfield 92	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   159: iconst_0
    //   160: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   163: iload 7
    //   165: tableswitch	default:+411->576, 1001:+43->208, 1002:+52->217, 1003:+411->576, 1004:+70->235, 1005:+79->244, 1006:+88->253, 1007:+61->226
    //   208: aload_0
    //   209: aload_2
    //   210: aload_3
    //   211: invokevirtual 95	com/tencent/mqpsdk/secsrv/MQPAPPScanService:a	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   214: goto -123 -> 91
    //   217: aload_0
    //   218: aload_2
    //   219: aload_3
    //   220: invokevirtual 97	com/tencent/mqpsdk/secsrv/MQPAPPScanService:b	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   223: goto -132 -> 91
    //   226: aload_0
    //   227: aload_2
    //   228: aload_3
    //   229: invokevirtual 99	com/tencent/mqpsdk/secsrv/MQPAPPScanService:c	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   232: goto -141 -> 91
    //   235: aload_0
    //   236: aload_2
    //   237: aload_3
    //   238: invokevirtual 101	com/tencent/mqpsdk/secsrv/MQPAPPScanService:e	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   241: goto -150 -> 91
    //   244: aload_0
    //   245: aload_2
    //   246: aload_3
    //   247: invokevirtual 103	com/tencent/mqpsdk/secsrv/MQPAPPScanService:f	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   250: goto -159 -> 91
    //   253: aload_0
    //   254: aload_2
    //   255: aload_3
    //   256: invokevirtual 105	com/tencent/mqpsdk/secsrv/MQPAPPScanService:d	(Lcom/tencent/ims/safecheckPB$ReqMQScanRequest;Lcom/tencent/ims/safecheckPB$RspMQScanReport;)V
    //   259: goto -168 -> 91
    //   262: astore_1
    //   263: aload_0
    //   264: monitorexit
    //   265: aload_1
    //   266: athrow
    //   267: iconst_0
    //   268: istore 6
    //   270: new 51	com/tencent/ims/safecheckPB$RspMQScanReport
    //   273: dup
    //   274: invokespecial 52	com/tencent/ims/safecheckPB$RspMQScanReport:<init>	()V
    //   277: astore_1
    //   278: aload_3
    //   279: getfield 92	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   282: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   285: bipush 48
    //   287: if_icmple +197 -> 484
    //   290: aload_1
    //   291: getfield 92	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   294: bipush 48
    //   296: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   299: aload_1
    //   300: getfield 84	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   303: aload_3
    //   304: getfield 84	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   307: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   310: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   313: new 107	java/util/ArrayList
    //   316: dup
    //   317: invokespecial 108	java/util/ArrayList:<init>	()V
    //   320: astore_2
    //   321: iconst_0
    //   322: istore 7
    //   324: iload 7
    //   326: bipush 48
    //   328: if_icmpge +35 -> 363
    //   331: aload_2
    //   332: aload_3
    //   333: getfield 112	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   336: iconst_0
    //   337: invokevirtual 117	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   340: invokeinterface 123 2 0
    //   345: pop
    //   346: aload_3
    //   347: getfield 112	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   350: iconst_0
    //   351: invokevirtual 126	com/tencent/mobileqq/pb/PBRepeatMessageField:remove	(I)V
    //   354: iload 7
    //   356: iconst_1
    //   357: iadd
    //   358: istore 7
    //   360: goto -36 -> 324
    //   363: aload_1
    //   364: getfield 112	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   367: aload_2
    //   368: invokevirtual 129	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   371: aload_3
    //   372: getfield 92	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   375: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   378: istore 7
    //   380: aload_3
    //   381: getfield 92	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   384: iload 7
    //   386: bipush 48
    //   388: isub
    //   389: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   392: aload_0
    //   393: getfield 37	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager	Lcom/tencent/mqpsdk/MQPSecServiceManager;
    //   396: ifnull -392 -> 4
    //   399: aload_0
    //   400: getfield 37	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager	Lcom/tencent/mqpsdk/MQPSecServiceManager;
    //   403: getfield 134	com/tencent/mqpsdk/MQPSecServiceManager:jdField_a_of_type_ComTencentMqpsdkINetTransportProvider	Lcom/tencent/mqpsdk/INetTransportProvider;
    //   406: astore 4
    //   408: aload 4
    //   410: ifnull -406 -> 4
    //   413: aload_1
    //   414: invokevirtual 138	com/tencent/ims/safecheckPB$RspMQScanReport:toByteArray	()[B
    //   417: astore_2
    //   418: aload 4
    //   420: ldc -116
    //   422: invokeinterface 145 2 0
    //   427: astore 5
    //   429: aload_2
    //   430: astore_1
    //   431: aload 5
    //   433: ifnull +12 -> 445
    //   436: aload 5
    //   438: aload_2
    //   439: invokeinterface 150 2 0
    //   444: astore_1
    //   445: aload 4
    //   447: aload_1
    //   448: invokeinterface 153 2 0
    //   453: pop
    //   454: iload 6
    //   456: istore 7
    //   458: iload 7
    //   460: istore 6
    //   462: iload 7
    //   464: ifeq -194 -> 270
    //   467: aload_0
    //   468: monitorenter
    //   469: getstatic 75	com/tencent/mqpsdk/secsrv/MQPAPPScanService:h	I
    //   472: iconst_1
    //   473: isub
    //   474: putstatic 75	com/tencent/mqpsdk/secsrv/MQPAPPScanService:h	I
    //   477: aload_0
    //   478: monitorexit
    //   479: iconst_0
    //   480: putstatic 46	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_Boolean	Z
    //   483: return
    //   484: aload_0
    //   485: getfield 37	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager	Lcom/tencent/mqpsdk/MQPSecServiceManager;
    //   488: ifnull -484 -> 4
    //   491: aload_0
    //   492: getfield 37	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager	Lcom/tencent/mqpsdk/MQPSecServiceManager;
    //   495: getfield 134	com/tencent/mqpsdk/MQPSecServiceManager:jdField_a_of_type_ComTencentMqpsdkINetTransportProvider	Lcom/tencent/mqpsdk/INetTransportProvider;
    //   498: astore 4
    //   500: aload 4
    //   502: ifnull -498 -> 4
    //   505: aload_3
    //   506: invokevirtual 138	com/tencent/ims/safecheckPB$RspMQScanReport:toByteArray	()[B
    //   509: astore_2
    //   510: aload 4
    //   512: ldc -116
    //   514: invokeinterface 145 2 0
    //   519: astore 5
    //   521: aload_2
    //   522: astore_1
    //   523: aload 5
    //   525: ifnull +12 -> 537
    //   528: aload 5
    //   530: aload_2
    //   531: invokeinterface 150 2 0
    //   536: astore_1
    //   537: aload 4
    //   539: aload_1
    //   540: invokeinterface 153 2 0
    //   545: pop
    //   546: iconst_1
    //   547: istore 7
    //   549: goto -91 -> 458
    //   552: astore_1
    //   553: aload_0
    //   554: monitorexit
    //   555: aload_1
    //   556: athrow
    //   557: astore_1
    //   558: iconst_0
    //   559: istore 6
    //   561: goto -478 -> 83
    //   564: iconst_0
    //   565: istore 7
    //   567: goto -426 -> 141
    //   570: iconst_0
    //   571: istore 6
    //   573: goto -517 -> 56
    //   576: goto -485 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	MQPAPPScanService
    //   0	579	1	paramArrayOfByte	byte[]
    //   22	509	2	localObject	Object
    //   30	476	3	localRspMQScanReport	safecheckPB.RspMQScanReport
    //   406	132	4	localINetTransportProvider	com.tencent.mqpsdk.INetTransportProvider
    //   427	102	5	localINetTransportCodec	com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec
    //   54	518	6	j	int
    //   139	427	7	k	int
    // Exception table:
    //   from	to	target	type
    //   56	67	82	java/lang/Exception
    //   77	81	82	java/lang/Exception
    //   120	122	82	java/lang/Exception
    //   122	141	82	java/lang/Exception
    //   141	163	82	java/lang/Exception
    //   208	214	82	java/lang/Exception
    //   217	223	82	java/lang/Exception
    //   226	232	82	java/lang/Exception
    //   235	241	82	java/lang/Exception
    //   244	250	82	java/lang/Exception
    //   253	259	82	java/lang/Exception
    //   67	77	117	finally
    //   118	120	117	finally
    //   102	112	262	finally
    //   263	265	262	finally
    //   469	479	552	finally
    //   553	555	552	finally
    //   31	56	557	java/lang/Exception
  }
  
  public void a(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      Object localObject2 = ((Context)localObject1).getPackageManager();
      try
      {
        localObject2 = ((PackageManager)localObject2).getPackageInfo(((Context)localObject1).getPackageName(), 1);
        localObject1 = SecUtil.getSign((Context)localObject1);
        new String();
        localObject1 = SecUtil.getSignatureHash((byte[])localObject1);
        new String();
        if (!paramReqMQScanRequest.string_check_target.get().equalsIgnoreCase((String)localObject1))
        {
          paramReqMQScanRequest = new safecheckPB.ReportItem();
          paramReqMQScanRequest.string_target_packname.set(((PackageInfo)localObject2).packageName);
          paramReqMQScanRequest.string_target_md5.set(SecUtil.getFileMd5(((PackageInfo)localObject2).applicationInfo.sourceDir));
          paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
          paramRspMQScanReport.uint32_check_count.set(1);
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
      {
        paramReqMQScanRequest.printStackTrace();
        return;
      }
      catch (RuntimeException paramReqMQScanRequest)
      {
        paramReqMQScanRequest.printStackTrace();
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    try
    {
      if (h >= 1) {
        return;
      }
    }
    finally {}
    new wph(this, paramArrayOfByte).start();
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    int j;
    switch (NetUtil.a(this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext))
    {
    default: 
      j = 0;
    }
    while ((j & paramInt) == 0)
    {
      return false;
      j = 1;
      continue;
      j = 2;
      continue;
      j = 4;
      continue;
      j = 8;
      continue;
      j = 16;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramString1.length() == 0) || (paramString2.length() == 0)) {
      return false;
    }
    try
    {
      boolean bool = Pattern.compile(paramString1, 2).matcher(paramString2).find();
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public void b(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    paramReqMQScanRequest = null;
    if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null) {
      paramReqMQScanRequest = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext;
    }
    if (paramReqMQScanRequest == null) {
      return;
    }
    paramReqMQScanRequest = paramReqMQScanRequest.getPackageManager();
    List localList = paramReqMQScanRequest.getInstalledApplications(8192);
    int k = 0;
    int j = 0;
    for (;;)
    {
      if (k < localList.size()) {
        try
        {
          safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
          try
          {
            PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ApplicationInfo)localList.get(k)).packageName, 1);
            localReportItem.string_target_packname.set(localPackageInfo.packageName);
            localReportItem.string_target_md5.set(SecUtil.getFileMd5(localPackageInfo.applicationInfo.sourceDir));
            paramRspMQScanReport.rpt_check_item.add(localReportItem);
            j += 1;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
            return;
          }
          paramRspMQScanReport.uint32_check_count.set(j);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      } else {
        return;
      }
      k += 1;
    }
  }
  
  public void c(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null) {
      localObject = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext;
    }
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getPackageManager();
    int j;
    label78:
    String str;
    do
    {
      try
      {
        localObject = ((PackageManager)localObject).getInstalledApplications(8192);
        j = 0;
        while (j < ((List)localObject).size())
        {
          if ((ApplicationInfo)((List)localObject).get(j) != null) {
            break label78;
          }
          j += 1;
        }
        str = ((ApplicationInfo)((List)localObject).get(j)).processName;
      }
      catch (RuntimeException paramReqMQScanRequest)
      {
        paramReqMQScanRequest.printStackTrace();
        return;
      }
    } while ((str == null) || (!a(paramReqMQScanRequest.string_check_target.get(), str)));
    paramReqMQScanRequest = new safecheckPB.ReportItem();
    paramReqMQScanRequest.string_target_packname.set(((ApplicationInfo)((List)localObject).get(j)).packageName);
    paramReqMQScanRequest.string_target_md5.set(SecUtil.getFileMd5(((ApplicationInfo)((List)localObject).get(j)).sourceDir));
    paramRspMQScanReport.rpt_check_item.add(paramReqMQScanRequest);
    paramRspMQScanReport.uint32_check_count.set(1);
  }
  
  /* Error */
  public void d(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 37	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager	Lcom/tencent/mqpsdk/MQPSecServiceManager;
    //   7: ifnull +319 -> 326
    //   10: aload_0
    //   11: getfield 37	com/tencent/mqpsdk/secsrv/MQPAPPScanService:jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager	Lcom/tencent/mqpsdk/MQPSecServiceManager;
    //   14: getfield 160	com/tencent/mqpsdk/MQPSecServiceManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload_3
    //   24: invokevirtual 166	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   27: astore 4
    //   29: aload 4
    //   31: aload_3
    //   32: invokevirtual 170	android/content/Context:getPackageName	()Ljava/lang/String;
    //   35: iconst_1
    //   36: invokevirtual 176	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   39: astore 6
    //   41: new 292	java/util/zip/ZipFile
    //   44: dup
    //   45: aload 6
    //   47: getfield 223	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   50: getfield 228	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   53: invokespecial 294	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   56: astore 4
    //   58: aload 4
    //   60: ldc_w 296
    //   63: invokevirtual 300	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   66: astore_3
    //   67: aload_3
    //   68: ifnull +196 -> 264
    //   71: aload 4
    //   73: aload_3
    //   74: invokevirtual 304	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   77: astore_3
    //   78: sipush 8192
    //   81: newarray <illegal type>
    //   83: astore 5
    //   85: ldc_w 306
    //   88: invokestatic 312	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   91: astore 7
    //   93: aload_3
    //   94: aload 5
    //   96: invokevirtual 318	java/io/InputStream:read	([B)I
    //   99: istore 8
    //   101: iload 8
    //   103: ifle +63 -> 166
    //   106: aload 7
    //   108: aload 5
    //   110: iconst_0
    //   111: iload 8
    //   113: invokevirtual 322	java/security/MessageDigest:update	([BII)V
    //   116: goto -23 -> 93
    //   119: astore_2
    //   120: aload_3
    //   121: astore_1
    //   122: aload_2
    //   123: invokevirtual 236	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 325	java/io/InputStream:close	()V
    //   134: aload 4
    //   136: ifnull -114 -> 22
    //   139: aload 4
    //   141: invokevirtual 326	java/util/zip/ZipFile:close	()V
    //   144: return
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 327	java/lang/Throwable:printStackTrace	()V
    //   150: return
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 237	java/lang/RuntimeException:printStackTrace	()V
    //   156: return
    //   157: astore_2
    //   158: aconst_null
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_1
    //   163: goto -41 -> 122
    //   166: aload 7
    //   168: invokevirtual 330	java/security/MessageDigest:digest	()[B
    //   171: invokestatic 333	com/tencent/mobileqq/utils/SecUtil:toHexString	([B)Ljava/lang/String;
    //   174: astore 7
    //   176: new 184	java/lang/String
    //   179: dup
    //   180: invokespecial 185	java/lang/String:<init>	()V
    //   183: pop
    //   184: aload_3
    //   185: astore 5
    //   187: aload_1
    //   188: getfield 193	com/tencent/ims/safecheckPB$ReqMQScanRequest:string_check_target	Lcom/tencent/mobileqq/pb/PBStringField;
    //   191: invokevirtual 197	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   194: aload 7
    //   196: invokevirtual 201	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   199: ifne +65 -> 264
    //   202: aload_2
    //   203: getfield 84	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   206: aload_1
    //   207: getfield 85	com/tencent/ims/safecheckPB$ReqMQScanRequest:uint32_check_uid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   210: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   213: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   216: aload_2
    //   217: getfield 92	com/tencent/ims/safecheckPB$RspMQScanReport:uint32_check_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   220: iconst_1
    //   221: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   224: new 203	com/tencent/ims/safecheckPB$ReportItem
    //   227: dup
    //   228: invokespecial 204	com/tencent/ims/safecheckPB$ReportItem:<init>	()V
    //   231: astore_1
    //   232: aload_1
    //   233: getfield 207	com/tencent/ims/safecheckPB$ReportItem:string_target_packname	Lcom/tencent/mobileqq/pb/PBStringField;
    //   236: aload 6
    //   238: getfield 213	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   241: invokevirtual 216	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   244: aload_1
    //   245: getfield 219	com/tencent/ims/safecheckPB$ReportItem:string_target_md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   248: aload 7
    //   250: invokevirtual 216	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   253: aload_2
    //   254: getfield 112	com/tencent/ims/safecheckPB$RspMQScanReport:rpt_check_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   257: aload_1
    //   258: invokevirtual 235	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   261: aload_3
    //   262: astore 5
    //   264: aload 5
    //   266: astore_1
    //   267: goto -141 -> 126
    //   270: astore_2
    //   271: aconst_null
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_1
    //   276: aload_2
    //   277: invokevirtual 334	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   280: goto -154 -> 126
    //   283: astore_2
    //   284: aconst_null
    //   285: astore 4
    //   287: aconst_null
    //   288: astore_1
    //   289: aload_2
    //   290: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   293: goto -167 -> 126
    //   296: astore_2
    //   297: aconst_null
    //   298: astore_1
    //   299: goto -10 -> 289
    //   302: astore_2
    //   303: aload_3
    //   304: astore_1
    //   305: goto -16 -> 289
    //   308: astore_2
    //   309: aconst_null
    //   310: astore_1
    //   311: goto -35 -> 276
    //   314: astore_2
    //   315: aload_3
    //   316: astore_1
    //   317: goto -41 -> 276
    //   320: astore_2
    //   321: aconst_null
    //   322: astore_1
    //   323: goto -201 -> 122
    //   326: aconst_null
    //   327: astore_3
    //   328: goto -310 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	MQPAPPScanService
    //   0	331	1	paramReqMQScanRequest	safecheckPB.ReqMQScanRequest
    //   0	331	2	paramRspMQScanReport	safecheckPB.RspMQScanReport
    //   17	311	3	localObject1	Object
    //   27	259	4	localObject2	Object
    //   1	264	5	localObject3	Object
    //   39	198	6	localPackageInfo	PackageInfo
    //   91	158	7	localObject4	Object
    //   99	13	8	j	int
    // Exception table:
    //   from	to	target	type
    //   78	93	119	android/content/pm/PackageManager$NameNotFoundException
    //   93	101	119	android/content/pm/PackageManager$NameNotFoundException
    //   106	116	119	android/content/pm/PackageManager$NameNotFoundException
    //   166	184	119	android/content/pm/PackageManager$NameNotFoundException
    //   187	261	119	android/content/pm/PackageManager$NameNotFoundException
    //   130	134	145	java/lang/Throwable
    //   139	144	145	java/lang/Throwable
    //   29	41	151	java/lang/RuntimeException
    //   29	41	157	android/content/pm/PackageManager$NameNotFoundException
    //   41	58	157	android/content/pm/PackageManager$NameNotFoundException
    //   152	156	157	android/content/pm/PackageManager$NameNotFoundException
    //   29	41	270	java/security/NoSuchAlgorithmException
    //   41	58	270	java/security/NoSuchAlgorithmException
    //   152	156	270	java/security/NoSuchAlgorithmException
    //   29	41	283	java/io/IOException
    //   41	58	283	java/io/IOException
    //   152	156	283	java/io/IOException
    //   58	67	296	java/io/IOException
    //   71	78	296	java/io/IOException
    //   78	93	302	java/io/IOException
    //   93	101	302	java/io/IOException
    //   106	116	302	java/io/IOException
    //   166	184	302	java/io/IOException
    //   187	261	302	java/io/IOException
    //   58	67	308	java/security/NoSuchAlgorithmException
    //   71	78	308	java/security/NoSuchAlgorithmException
    //   78	93	314	java/security/NoSuchAlgorithmException
    //   93	101	314	java/security/NoSuchAlgorithmException
    //   106	116	314	java/security/NoSuchAlgorithmException
    //   166	184	314	java/security/NoSuchAlgorithmException
    //   187	261	314	java/security/NoSuchAlgorithmException
    //   58	67	320	android/content/pm/PackageManager$NameNotFoundException
    //   71	78	320	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public void e(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext;; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        Object localObject2 = (ActivityManager)((Context)localObject1).getSystemService("activity");
        localObject1 = ((Context)localObject1).getPackageManager();
        localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
        while (j < ((List)localObject2).size())
        {
          if (a(paramReqMQScanRequest.string_check_target.get(), ((ActivityManager.RunningAppProcessInfo)((List)localObject2).get(j)).processName)) {
            try
            {
              paramReqMQScanRequest = ((PackageManager)localObject1).getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject2.get(j)).pkgList[0], 1);
              localObject1 = new safecheckPB.ReportItem();
              ((safecheckPB.ReportItem)localObject1).string_target_packname.set(paramReqMQScanRequest.packageName);
              ((safecheckPB.ReportItem)localObject1).string_target_md5.set(SecUtil.getFileMd5(paramReqMQScanRequest.applicationInfo.sourceDir));
              paramRspMQScanReport.rpt_check_item.add((MessageMicro)localObject1);
              paramRspMQScanReport.uint32_check_count.set(1);
              return;
            }
            catch (PackageManager.NameNotFoundException paramReqMQScanRequest)
            {
              paramReqMQScanRequest.printStackTrace();
              return;
            }
            catch (RuntimeException paramReqMQScanRequest)
            {
              paramReqMQScanRequest.printStackTrace();
              return;
            }
          }
          j += 1;
        }
      }
    }
  }
  
  public void f(safecheckPB.ReqMQScanRequest paramReqMQScanRequest, safecheckPB.RspMQScanReport paramRspMQScanReport)
  {
    int j = 0;
    Object localObject;
    int k;
    if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null)
    {
      paramReqMQScanRequest = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext;
      if (paramReqMQScanRequest == null) {
        return;
      }
      localObject = (ActivityManager)paramReqMQScanRequest.getSystemService("activity");
      paramReqMQScanRequest = paramReqMQScanRequest.getPackageManager();
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      k = 0;
    }
    for (;;)
    {
      if (k < ((List)localObject).size())
      {
        try
        {
          safecheckPB.ReportItem localReportItem = new safecheckPB.ReportItem();
          try
          {
            PackageInfo localPackageInfo = paramReqMQScanRequest.getPackageInfo(((ActivityManager.RunningAppProcessInfo)localObject.get(k)).pkgList[0], 1);
            localReportItem.string_target_packname.set(localPackageInfo.packageName);
            localReportItem.string_target_md5.set(SecUtil.getFileMd5(localPackageInfo.applicationInfo.sourceDir));
            paramRspMQScanReport.rpt_check_item.add(localReportItem);
            j += 1;
          }
          catch (RuntimeException localRuntimeException)
          {
            localRuntimeException.printStackTrace();
            return;
          }
          paramRspMQScanReport.uint32_check_count.set(j);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
      else
      {
        return;
        paramReqMQScanRequest = null;
        break;
      }
      k += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqpsdk\secsrv\MQPAPPScanService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */