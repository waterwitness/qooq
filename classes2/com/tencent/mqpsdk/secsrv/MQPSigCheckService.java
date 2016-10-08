package com.tencent.mqpsdk.secsrv;

import com.tencent.ims.signature.SignatureReport;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mqpsdk.INetTransportProvider;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportEventListener;
import com.tencent.mqpsdk.MQPSecServiceManager;
import org.json.JSONObject;

public class MQPSigCheckService
  implements INetTransportProvider.INetTransportEventListener
{
  public static final String a = "client_type";
  public static final String b = "package_name";
  public static final String c = "package_version";
  public static final String d = "package_md5";
  public static final String e = "package_signature";
  public static final String f = "sig_check_result";
  public static final String g = "dialog_config";
  public static final String h = "dialog_title";
  public static final String i = "dialog_content";
  public static final String j = "dialog_left_button";
  public static final String k = "dialog_right_button";
  public static final String l = "url";
  private static final String m = "uin";
  private static final String n = "is_repack";
  private MQPSecServiceManager jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager;
  private MQPSigCheckService.ISigCheckResultListener jdField_a_of_type_ComTencentMqpsdkSecsrvMQPSigCheckService$ISigCheckResultListener;
  
  public MQPSigCheckService(MQPSecServiceManager paramMQPSecServiceManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    INetTransportProvider localINetTransportProvider = paramMQPSecServiceManager.a;
    if (localINetTransportProvider != null) {
      localINetTransportProvider.a("sig_check", this);
    }
    this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager = paramMQPSecServiceManager;
  }
  
  public void a(MQPSigCheckService.ISigCheckResultListener paramISigCheckResultListener)
  {
    this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPSigCheckService$ISigCheckResultListener = paramISigCheckResultListener;
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    if (this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPSigCheckService$ISigCheckResultListener == null) {}
    label7:
    do
    {
      do
      {
        do
        {
          break label7;
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager == null);
          paramObject1 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.a;
        } while (paramObject1 == null);
        paramObject1 = ((INetTransportProvider)paramObject1).a("sig_check");
      } while (paramObject1 == null);
      paramObject1 = (byte[])((INetTransportProvider.INetTransportCodec)paramObject1).b(paramObject2);
    } while (paramObject1 == null);
    Object localObject = new signature.SignatureResult();
    try
    {
      ((signature.SignatureResult)localObject).mergeFrom((byte[])paramObject1);
      int i1 = -1;
      paramObject1 = "";
      paramObject2 = "";
      String str1 = "";
      String str2 = "";
      String str3 = "";
      if (((signature.SignatureResult)localObject).u32_check_result.has()) {
        i1 = ((signature.SignatureResult)localObject).u32_check_result.get();
      }
      if (((signature.SignatureResult)localObject).str_title.has()) {
        paramObject1 = ((signature.SignatureResult)localObject).str_title.get();
      }
      if (((signature.SignatureResult)localObject).str_content.has()) {
        paramObject2 = ((signature.SignatureResult)localObject).str_content.get();
      }
      if (((signature.SignatureResult)localObject).str_left_button.has()) {
        str1 = ((signature.SignatureResult)localObject).str_left_button.get();
      }
      if (((signature.SignatureResult)localObject).str_right_button.has()) {
        str2 = ((signature.SignatureResult)localObject).str_right_button.get();
      }
      if (((signature.SignatureResult)localObject).str_url.has()) {
        str3 = ((signature.SignatureResult)localObject).str_url.get();
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("dialog_title", paramObject1);
        ((JSONObject)localObject).put("dialog_content", paramObject2);
        ((JSONObject)localObject).put("dialog_left_button", str1);
        ((JSONObject)localObject).put("dialog_right_button", str2);
        ((JSONObject)localObject).put("url", str3);
        paramObject1 = new JSONObject();
        ((JSONObject)paramObject1).put("sig_check_result", i1);
        ((JSONObject)paramObject1).put("dialog_config", localObject);
        this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPSigCheckService$ISigCheckResultListener.a(((JSONObject)paramObject1).toString());
        return;
      }
      catch (Exception paramObject1)
      {
        ((Exception)paramObject1).printStackTrace();
        return;
      }
    }
    catch (Exception paramObject1)
    {
      for (;;)
      {
        ((Exception)paramObject1).printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    int i3 = 0;
    int i4 = 0;
    int i1 = 0;
    long l3 = 0L;
    Object localObject1 = "";
    Object localObject2 = "";
    String str2 = "";
    long l2 = l3;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        l1 = l3;
        l2 = l3;
        if (localJSONObject.has("uin"))
        {
          l2 = l3;
          l1 = localJSONObject.getLong("uin");
        }
        l2 = l1;
        if (!localJSONObject.has("client_type")) {
          break label537;
        }
        l2 = l1;
        i2 = localJSONObject.getInt("client_type");
        localObject5 = localObject2;
        localObject3 = localObject1;
        i3 = i4;
      }
      catch (Exception localException1)
      {
        try
        {
          JSONObject localJSONObject;
          Object localObject3;
          if (localJSONObject.has("package_signature"))
          {
            localObject3 = localJSONObject.getString("package_signature");
            l2 = l1;
            i4 = i2;
            i3 = i1;
            str1 = paramString;
            localObject6 = localObject1;
            localObject5 = localObject2;
          }
          paramString = new signature.SignatureReport();
          paramString.u64_uin.set(l2);
          paramString.u32_client_type.set(i4);
          paramString.u32_is_repack.set(i3);
          paramString.str_packname.set(str1);
          paramString.str_version.set((String)localObject6);
          paramString.str_md5.set((String)localObject5);
          paramString.str_signature.set((String)localObject3);
          if (this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager != null) {
            continue;
          }
          return;
        }
        catch (Exception localException2)
        {
          long l1;
          Object localObject5;
          Object localObject6;
          String str1;
          Object localObject4;
          continue;
        }
        localException1 = localException1;
        i2 = 0;
        localObject5 = "";
        l1 = l2;
        i1 = i3;
        paramString = (String)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject5;
        localException1.printStackTrace();
        localObject4 = str2;
        localObject5 = localObject2;
        localObject6 = localObject1;
        str1 = paramString;
        i3 = i1;
        i4 = i2;
        l2 = l1;
        continue;
        localObject2 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager.a;
        if (localObject2 == null) {
          continue;
        }
        localObject1 = paramString.toByteArray();
        localObject4 = ((INetTransportProvider)localObject2).a("sig_check");
        paramString = (String)localObject1;
        if (localObject4 != null) {
          paramString = ((INetTransportProvider.INetTransportCodec)localObject4).a(localObject1);
        }
        ((INetTransportProvider)localObject2).a(paramString);
        return;
      }
      try
      {
        if (localJSONObject.has("is_repack"))
        {
          localObject5 = localObject2;
          localObject3 = localObject1;
          i3 = i4;
          i1 = localJSONObject.getInt("is_repack");
        }
        paramString = (String)localObject1;
        localObject5 = localObject2;
        localObject3 = localObject1;
        i3 = i1;
        if (localJSONObject.has("package_name"))
        {
          localObject5 = localObject2;
          localObject3 = localObject1;
          i3 = i1;
          paramString = localJSONObject.getString("package_name");
        }
        localObject1 = localObject2;
        localObject5 = localObject2;
        localObject3 = paramString;
        i3 = i1;
        if (localJSONObject.has("package_version"))
        {
          localObject5 = localObject2;
          localObject3 = paramString;
          i3 = i1;
          localObject1 = localJSONObject.getString("package_version");
        }
        localObject5 = localObject1;
        localObject3 = paramString;
        i3 = i1;
        if (!localJSONObject.has("package_md5")) {
          break label531;
        }
        localObject5 = localObject1;
        localObject3 = paramString;
        i3 = i1;
        localObject2 = localJSONObject.getString("package_md5");
      }
      catch (Exception localException3)
      {
        localObject2 = "";
        localObject1 = localObject5;
        paramString = (String)localObject4;
        i1 = i3;
        localObject4 = localException3;
        continue;
        localObject2 = "";
        continue;
      }
      localObject3 = str2;
      localObject5 = localObject2;
      localObject6 = localObject1;
      str1 = paramString;
      i3 = i1;
      i4 = i2;
      l2 = l1;
      label531:
      label537:
      int i2 = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mqpsdk\secsrv\MQPSigCheckService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */