package com.tencent.mqpsdk.secsrv;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ims.intchk.AppInfo;
import com.tencent.ims.intchk.CheckItem;
import com.tencent.ims.intchk.CheckResult;
import com.tencent.ims.intchk.FetchCheckConfigReq;
import com.tencent.ims.intchk.FetchCheckConfigRsp;
import com.tencent.ims.intchk.ReportCheckResultReq;
import com.tencent.ims.intchk.ReportCheckResultRsp;
import com.tencent.ims.intchk.ReportStrikeResultReq;
import com.tencent.ims.intchk.ReqBody;
import com.tencent.ims.intchk.RspBody;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mqp.app.sec.MQPSecUtil;
import com.tencent.mqpsdk.INetTransportProvider;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportEventListener;
import com.tencent.mqpsdk.MQPSecServiceManager;
import com.tencent.mqpsdk.util.NetUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MQPIntChkService
  implements INetTransportProvider.INetTransportEventListener, IIntChkStrikeResultListener
{
  private static int jdField_a_of_type_Int = 1;
  public static final String a = "toast_config";
  public static final String b = "launch_package_name";
  public static final String c = "strike_result";
  private MQPSecServiceManager jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager;
  private Map jdField_a_of_type_JavaUtilMap;
  private int b;
  private int c = 65535;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MQPIntChkService(MQPSecServiceManager paramMQPSecServiceManager)
  {
    INetTransportProvider localINetTransportProvider = paramMQPSecServiceManager.jdField_a_of_type_ComTencentMqpsdkINetTransportProvider;
    if (localINetTransportProvider != null) {
      localINetTransportProvider.a("intchk", this);
    }
    this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager = paramMQPSecServiceManager;
  }
  
  private intchk.AppInfo a()
  {
    intchk.AppInfo localAppInfo = new intchk.AppInfo();
    localAppInfo.uint32_platform_type.set(1);
    String str = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext.getPackageName();
    localAppInfo.bytes_package_name.set(ByteStringMicro.copyFromUtf8(str));
    int i;
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      str = "1.0";
      localAppInfo.bytes_app_version.set(ByteStringMicro.copyFromUtf8(str));
      localAppInfo.uint32_intchk_module_version.set(jdField_a_of_type_Int);
      switch (NetUtil.a(this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext))
      {
      default: 
        i = 5;
      }
    }
    for (;;)
    {
      str = NetUtil.a(this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_AndroidContentContext);
      int j = i;
      if (str != null)
      {
        j = i;
        if (str.contains("wap")) {
          j = 4;
        }
      }
      localAppInfo.uint32_net_type.set(j);
      return localAppInfo;
      str = this.jdField_d_of_type_JavaLangString;
      break;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
    }
  }
  
  private void a(intchk.RspBody paramRspBody)
  {
    if (paramRspBody.uint32_result.has()) {}
    for (int i = paramRspBody.uint32_result.get();; i = 2)
    {
      if (i != 1) {
        break label25;
      }
      for (;;)
      {
        label25:
        return;
        label422:
        label438:
        if (paramRspBody.msg_check_config_rsp.has())
        {
          paramRspBody = (intchk.FetchCheckConfigRsp)paramRspBody.msg_check_config_rsp.get();
          if (paramRspBody.uint32_need_intchk.has()) {}
          for (i = paramRspBody.uint32_need_intchk.get();; i = 2)
          {
            if ((i != 1) || (!paramRspBody.rpt_msg_check_item.has())) {
              break label438;
            }
            if (paramRspBody.uint32_intchk_id.has()) {}
            for (i = paramRspBody.uint32_intchk_id.get();; i = 0)
            {
              Object localObject2 = new intchk.ReportCheckResultReq();
              ((intchk.ReportCheckResultReq)localObject2).uint32_intchk_id.set(i);
              Object localObject3 = paramRspBody.rpt_msg_check_item.get();
              i = 0;
              if (i < ((List)localObject3).size())
              {
                paramRspBody = (intchk.CheckItem)((List)localObject3).get(i);
                if (!paramRspBody.uint32_check_item_id.has()) {
                  break label422;
                }
              }
              for (int j = paramRspBody.uint32_check_item_id.get();; j = 0)
              {
                if (paramRspBody.uint32_check_type.has()) {}
                for (int k = paramRspBody.uint32_check_type.get();; k = 1)
                {
                  intchk.CheckResult localCheckResult = new intchk.CheckResult();
                  localCheckResult.uint32_check_item_id.set(j);
                  localCheckResult.uint32_check_type.set(k);
                  switch (k)
                  {
                  }
                  for (;;)
                  {
                    ((intchk.ReportCheckResultReq)localObject2).rpt_msg_check_result.add(localCheckResult);
                    i += 1;
                    break;
                    if (a(paramRspBody)) {}
                    for (j = 1;; j = 2)
                    {
                      localCheckResult.uint32_memchk_result.set(j);
                      break;
                    }
                    localObject1 = HexUtil.a(a(paramRspBody));
                    paramRspBody = (intchk.RspBody)localObject1;
                    if (localObject1 == null) {
                      paramRspBody = "";
                    }
                    localCheckResult.bytes_memreport_result.set(ByteStringMicro.copyFromUtf8(paramRspBody));
                  }
                  paramRspBody = new intchk.ReqBody();
                  paramRspBody.uint32_subcmd.set(2);
                  paramRspBody.msg_app_info.set(a());
                  paramRspBody.msg_report_check_result_req.set((MessageMicro)localObject2);
                  localObject2 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_ComTencentMqpsdkINetTransportProvider;
                  if (localObject2 == null) {
                    break;
                  }
                  Object localObject1 = paramRspBody.toByteArray();
                  localObject3 = ((INetTransportProvider)localObject2).a("intchk");
                  paramRspBody = (intchk.RspBody)localObject1;
                  if (localObject3 != null) {
                    paramRspBody = ((INetTransportProvider.INetTransportCodec)localObject3).a(localObject1);
                  }
                  ((INetTransportProvider)localObject2).a(paramRspBody);
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(intchk.CheckItem paramCheckItem)
  {
    if (paramCheckItem.uint32_start_offset.has()) {}
    for (int i = paramCheckItem.uint32_start_offset.get();; i = 0)
    {
      if (paramCheckItem.uint32_end_offset.has()) {}
      for (int j = paramCheckItem.uint32_end_offset.get();; j = 0)
      {
        if (j <= i) {}
        String str1;
        String str2;
        do
        {
          do
          {
            return false;
            str1 = "";
            if (paramCheckItem.bytes_module_name.has()) {
              str1 = paramCheckItem.bytes_module_name.get().toStringUtf8();
            }
          } while (TextUtils.isEmpty(str1.trim()));
          str2 = "";
          if (paramCheckItem.bytes_match_pattern.has()) {
            str2 = paramCheckItem.bytes_match_pattern.get().toStringUtf8();
          }
        } while (TextUtils.isEmpty(str2.trim()));
        try
        {
          boolean bool = MQPSecUtil.memchk(str1, i, j, HexUtil.a(str2));
          return bool;
        }
        catch (Throwable paramCheckItem)
        {
          paramCheckItem.printStackTrace();
          return false;
        }
      }
    }
  }
  
  private byte[] a(intchk.CheckItem paramCheckItem)
  {
    if (paramCheckItem.uint32_start_offset.has()) {}
    for (int i = paramCheckItem.uint32_start_offset.get();; i = 0)
    {
      if (paramCheckItem.uint32_end_offset.has()) {}
      for (int j = paramCheckItem.uint32_end_offset.get();; j = 0)
      {
        if (j <= i) {}
        String str;
        do
        {
          return null;
          str = "";
          if (paramCheckItem.bytes_module_name.has()) {
            str = paramCheckItem.bytes_module_name.get().toStringUtf8();
          }
        } while (TextUtils.isEmpty(str.trim()));
        try
        {
          paramCheckItem = MQPSecUtil.memreport(str, i, j);
          return paramCheckItem;
        }
        catch (Throwable paramCheckItem)
        {
          for (;;)
          {
            paramCheckItem.printStackTrace();
            paramCheckItem = null;
          }
        }
      }
    }
  }
  
  private void b(intchk.RspBody paramRspBody)
  {
    int j = 2;
    if (paramRspBody.uint32_result.has()) {}
    for (int i = paramRspBody.uint32_result.get();; i = 2)
    {
      if (i != 1) {}
      do
      {
        do
        {
          return;
        } while (!paramRspBody.msg_report_check_result_rsp.has());
        paramRspBody = (intchk.ReportCheckResultRsp)paramRspBody.msg_report_check_result_rsp.get();
        i = j;
        if (paramRspBody.uint32_need_strike.has()) {
          i = paramRspBody.uint32_need_strike.get();
        }
      } while ((i != 1) || (!paramRspBody.bytes_strike_config.has()));
      if (paramRspBody.uint32_intchk_id.has()) {
        this.b = paramRspBody.uint32_intchk_id.get();
      }
      c(paramRspBody.bytes_strike_config.get().toStringUtf8());
      return;
    }
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 275	java/lang/String:trim	()Ljava/lang/String;
    //   6: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +4 -> 13
    //   12: return
    //   13: invokestatic 322	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 326	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   21: new 328	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokevirtual 331	java/lang/String:getBytes	()[B
    //   29: invokespecial 334	java/io/ByteArrayInputStream:<init>	([B)V
    //   32: invokevirtual 340	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   35: invokeinterface 346 1 0
    //   40: astore_3
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 41	com/tencent/mqpsdk/secsrv/MQPIntChkService:c	I
    //   46: aload_3
    //   47: ldc_w 348
    //   50: invokeinterface 354 2 0
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 275	java/lang/String:trim	()Ljava/lang/String;
    //   60: invokevirtual 357	java/lang/String:length	()I
    //   63: ifle +11 -> 74
    //   66: aload_0
    //   67: aload_1
    //   68: invokestatic 363	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: putfield 41	com/tencent/mqpsdk/secsrv/MQPIntChkService:c	I
    //   74: aload_0
    //   75: getfield 41	com/tencent/mqpsdk/secsrv/MQPIntChkService:c	I
    //   78: tableswitch	default:+343->421, 1:+26->104, 2:+160->238, 3:+215->293
    //   104: aload_0
    //   105: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   108: ifnull -96 -> 12
    //   111: aload_0
    //   112: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   115: iconst_1
    //   116: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokeinterface 375 2 0
    //   124: ifeq +292 -> 416
    //   127: aload_0
    //   128: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   131: iconst_1
    //   132: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: invokeinterface 377 2 0
    //   140: checkcast 379	com/tencent/mqpsdk/secsrv/MQPIntChkService$IIntChkStrike
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull -133 -> 12
    //   148: new 381	javax/xml/transform/dom/DOMSource
    //   151: dup
    //   152: aload_3
    //   153: invokespecial 384	javax/xml/transform/dom/DOMSource:<init>	(Lorg/w3c/dom/Node;)V
    //   156: astore_3
    //   157: new 386	java/io/StringWriter
    //   160: dup
    //   161: invokespecial 387	java/io/StringWriter:<init>	()V
    //   164: astore_2
    //   165: new 389	javax/xml/transform/stream/StreamResult
    //   168: dup
    //   169: aload_2
    //   170: invokespecial 392	javax/xml/transform/stream/StreamResult:<init>	(Ljava/io/Writer;)V
    //   173: astore 4
    //   175: invokestatic 397	javax/xml/transform/TransformerFactory:newInstance	()Ljavax/xml/transform/TransformerFactory;
    //   178: invokevirtual 401	javax/xml/transform/TransformerFactory:newTransformer	()Ljavax/xml/transform/Transformer;
    //   181: aload_3
    //   182: aload 4
    //   184: invokevirtual 407	javax/xml/transform/Transformer:transform	(Ljavax/xml/transform/Source;Ljavax/xml/transform/Result;)V
    //   187: new 409	org/json/JSONObject
    //   190: dup
    //   191: invokespecial 410	org/json/JSONObject:<init>	()V
    //   194: astore_3
    //   195: aload_3
    //   196: ldc 14
    //   198: aload_2
    //   199: invokevirtual 413	java/io/StringWriter:toString	()Ljava/lang/String;
    //   202: invokevirtual 417	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload_1
    //   207: aload_3
    //   208: invokevirtual 418	org/json/JSONObject:toString	()Ljava/lang/String;
    //   211: aload_0
    //   212: invokeinterface 421 3 0
    //   217: return
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 422	java/lang/Exception:printStackTrace	()V
    //   223: return
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 422	java/lang/Exception:printStackTrace	()V
    //   229: return
    //   230: astore_2
    //   231: aload_2
    //   232: invokevirtual 422	java/lang/Exception:printStackTrace	()V
    //   235: goto -29 -> 206
    //   238: aload_0
    //   239: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   242: ifnull -230 -> 12
    //   245: aload_2
    //   246: astore_1
    //   247: aload_0
    //   248: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   251: iconst_2
    //   252: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: invokeinterface 375 2 0
    //   260: ifeq +20 -> 280
    //   263: aload_0
    //   264: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   267: iconst_2
    //   268: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: invokeinterface 377 2 0
    //   276: checkcast 379	com/tencent/mqpsdk/secsrv/MQPIntChkService$IIntChkStrike
    //   279: astore_1
    //   280: aload_1
    //   281: ifnull -269 -> 12
    //   284: aload_1
    //   285: aconst_null
    //   286: aload_0
    //   287: invokeinterface 421 3 0
    //   292: return
    //   293: aload_0
    //   294: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   297: ifnull -285 -> 12
    //   300: aload_0
    //   301: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   304: iconst_3
    //   305: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: invokeinterface 375 2 0
    //   313: ifeq +98 -> 411
    //   316: aload_0
    //   317: getfield 365	com/tencent/mqpsdk/secsrv/MQPIntChkService:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   320: iconst_3
    //   321: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: invokeinterface 377 2 0
    //   329: checkcast 379	com/tencent/mqpsdk/secsrv/MQPIntChkService$IIntChkStrike
    //   332: astore_1
    //   333: aload_1
    //   334: ifnull -322 -> 12
    //   337: aload_3
    //   338: ldc_w 424
    //   341: invokeinterface 428 2 0
    //   346: astore_2
    //   347: aload_2
    //   348: invokeinterface 433 1 0
    //   353: ifeq -341 -> 12
    //   356: aload_2
    //   357: iconst_0
    //   358: invokeinterface 437 2 0
    //   363: checkcast 350	org/w3c/dom/Element
    //   366: ldc_w 439
    //   369: invokeinterface 354 2 0
    //   374: astore_3
    //   375: new 409	org/json/JSONObject
    //   378: dup
    //   379: invokespecial 410	org/json/JSONObject:<init>	()V
    //   382: astore_2
    //   383: aload_2
    //   384: ldc 17
    //   386: aload_3
    //   387: invokevirtual 417	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   390: pop
    //   391: aload_1
    //   392: aload_2
    //   393: invokevirtual 418	org/json/JSONObject:toString	()Ljava/lang/String;
    //   396: aload_0
    //   397: invokeinterface 421 3 0
    //   402: return
    //   403: astore_3
    //   404: aload_3
    //   405: invokevirtual 422	java/lang/Exception:printStackTrace	()V
    //   408: goto -17 -> 391
    //   411: aconst_null
    //   412: astore_1
    //   413: goto -80 -> 333
    //   416: aconst_null
    //   417: astore_1
    //   418: goto -274 -> 144
    //   421: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	MQPIntChkService
    //   0	422	1	paramString	String
    //   1	198	2	localStringWriter	java.io.StringWriter
    //   230	16	2	localException1	Exception
    //   346	47	2	localObject1	Object
    //   16	371	3	localObject2	Object
    //   403	2	3	localException2	Exception
    //   173	10	4	localStreamResult	javax.xml.transform.stream.StreamResult
    // Exception table:
    //   from	to	target	type
    //   148	195	218	java/lang/Exception
    //   206	217	218	java/lang/Exception
    //   231	235	218	java/lang/Exception
    //   17	74	224	java/lang/Exception
    //   74	104	224	java/lang/Exception
    //   104	144	224	java/lang/Exception
    //   219	223	224	java/lang/Exception
    //   238	245	224	java/lang/Exception
    //   247	280	224	java/lang/Exception
    //   284	292	224	java/lang/Exception
    //   293	333	224	java/lang/Exception
    //   337	383	224	java/lang/Exception
    //   391	402	224	java/lang/Exception
    //   404	408	224	java/lang/Exception
    //   195	206	230	java/lang/Exception
    //   383	391	403	java/lang/Exception
  }
  
  public void a(int paramInt, MQPIntChkService.IIntChkStrike paramIIntChkStrike)
  {
    if (paramIIntChkStrike == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramIIntChkStrike);
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_ComTencentMqpsdkINetTransportProvider;
      if (localObject != null)
      {
        paramObject1 = null;
        localObject = ((INetTransportProvider)localObject).a("intchk");
        if (localObject != null) {
          paramObject1 = (byte[])((INetTransportProvider.INetTransportCodec)localObject).b(paramObject2);
        }
        if (paramObject1 != null) {
          break label53;
        }
      }
    }
    return;
    label53:
    paramObject2 = new intchk.RspBody();
    int i;
    try
    {
      ((intchk.RspBody)paramObject2).mergeFrom((byte[])paramObject1);
      i = 0;
      if (!((intchk.RspBody)paramObject2).uint32_subcmd.has()) {
        break label110;
      }
      i = ((intchk.RspBody)paramObject2).uint32_subcmd.get();
    }
    catch (InvalidProtocolBufferMicroException paramObject1)
    {
      ((InvalidProtocolBufferMicroException)paramObject1).printStackTrace();
      return;
    }
    a((intchk.RspBody)paramObject2);
    return;
    b((intchk.RspBody)paramObject2);
    return;
    label110:
    switch (i)
    {
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("strike_result"))
        {
          this.jdField_d_of_type_Int = paramString.getInt("strike_result");
          Object localObject = new intchk.ReportStrikeResultReq();
          ((intchk.ReportStrikeResultReq)localObject).uint32_intchk_id.set(this.b);
          ((intchk.ReportStrikeResultReq)localObject).uint32_strike_type.set(this.c);
          ((intchk.ReportStrikeResultReq)localObject).uint32_strike_result.set(this.jdField_d_of_type_Int);
          paramString = new intchk.ReqBody();
          paramString.uint32_subcmd.set(3);
          paramString.msg_app_info.set(a());
          paramString.msg_report_strike_result_req.set((MessageMicro)localObject);
          if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null)
          {
            INetTransportProvider localINetTransportProvider = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_ComTencentMqpsdkINetTransportProvider;
            if (localINetTransportProvider != null)
            {
              localObject = paramString.toByteArray();
              INetTransportProvider.INetTransportCodec localINetTransportCodec = localINetTransportProvider.a("intchk");
              paramString = (String)localObject;
              if (localINetTransportCodec != null) {
                paramString = localINetTransportCodec.a(localObject);
              }
              localINetTransportProvider.a(paramString);
              return;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    Object localObject = new intchk.FetchCheckConfigReq();
    ((intchk.FetchCheckConfigReq)localObject).uint32_reserved.set(0);
    paramString = new intchk.ReqBody();
    paramString.uint32_subcmd.set(1);
    paramString.msg_app_info.set(a());
    paramString.msg_check_config_req.set((MessageMicro)localObject);
    INetTransportProvider localINetTransportProvider = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.jdField_a_of_type_ComTencentMqpsdkINetTransportProvider;
    if (localINetTransportProvider == null) {
      return;
    }
    localObject = paramString.toByteArray();
    INetTransportProvider.INetTransportCodec localINetTransportCodec = localINetTransportProvider.a("intchk");
    paramString = (String)localObject;
    if (localINetTransportCodec != null) {
      paramString = localINetTransportCodec.a(localObject);
    }
    localINetTransportProvider.a(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqpsdk\secsrv\MQPIntChkService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */