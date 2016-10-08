package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import org.json.JSONObject;

public class ArkAppMessage
{
  private static final String JsonAppDesc = "desc";
  private static final String JsonAppMinVersion = "ver";
  private static final String JsonAppName = "app";
  private static final String JsonAppView = "view";
  private static final String JsonConfig = "config";
  private static final String JsonMetaList = "meta";
  private static final String JsonPromptText = "prompt";
  public final String TAG;
  public String appDesc;
  public String appMinVersion;
  public String appName;
  public String appView;
  public String compatibleText;
  public String config;
  public String metaList;
  public String promptText;
  
  public ArkAppMessage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.TAG = "ArkApp.Message";
    reset();
  }
  
  public ArkAppMessage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.TAG = "ArkApp.Message";
    this.promptText = paramString1;
    this.appDesc = paramString3;
    this.appName = paramString2;
    this.appView = paramString4;
    this.appMinVersion = paramString5;
    this.metaList = paramString6;
    this.config = paramString7;
    this.compatibleText = paramString8;
  }
  
  public boolean fromAppXml(String paramString)
  {
    reset();
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.appName = paramString.optString("app");
      this.appView = paramString.optString("view");
      this.appDesc = paramString.optString("desc");
      this.appMinVersion = paramString.optString("ver");
      this.promptText = paramString.optString("prompt");
      this.metaList = paramString.optString("meta");
      this.config = paramString.optString("config");
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean fromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      boolean bool = fromAppXml((String)new ObjectInputStream(paramArrayOfByte).readObject());
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public String getSummery()
  {
    if (!TextUtils.isEmpty(this.promptText)) {
      return this.promptText;
    }
    return BaseApplication.getContext().getString(2131372346);
  }
  
  public void reset()
  {
    this.promptText = null;
    this.appName = null;
    this.appDesc = null;
    this.appView = null;
    this.appMinVersion = null;
    this.metaList = null;
    this.config = null;
    this.compatibleText = null;
  }
  
  /* Error */
  public String toAppXml()
  {
    // Byte code:
    //   0: new 81	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 134	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 59	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   12: ifnull +14 -> 26
    //   15: aload_1
    //   16: ldc 14
    //   18: aload_0
    //   19: getfield 59	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   22: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   25: pop
    //   26: aload_0
    //   27: getfield 57	com/tencent/mobileqq/data/ArkAppMessage:appDesc	Ljava/lang/String;
    //   30: ifnull +14 -> 44
    //   33: aload_1
    //   34: ldc 8
    //   36: aload_0
    //   37: getfield 57	com/tencent/mobileqq/data/ArkAppMessage:appDesc	Ljava/lang/String;
    //   40: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_0
    //   45: getfield 61	com/tencent/mobileqq/data/ArkAppMessage:appView	Ljava/lang/String;
    //   48: ifnull +14 -> 62
    //   51: aload_1
    //   52: ldc 17
    //   54: aload_0
    //   55: getfield 61	com/tencent/mobileqq/data/ArkAppMessage:appView	Ljava/lang/String;
    //   58: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   61: pop
    //   62: aload_0
    //   63: getfield 63	com/tencent/mobileqq/data/ArkAppMessage:appMinVersion	Ljava/lang/String;
    //   66: ifnull +14 -> 80
    //   69: aload_1
    //   70: ldc 11
    //   72: aload_0
    //   73: getfield 63	com/tencent/mobileqq/data/ArkAppMessage:appMinVersion	Ljava/lang/String;
    //   76: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_0
    //   81: getfield 55	com/tencent/mobileqq/data/ArkAppMessage:promptText	Ljava/lang/String;
    //   84: ifnull +14 -> 98
    //   87: aload_1
    //   88: ldc 26
    //   90: aload_0
    //   91: getfield 55	com/tencent/mobileqq/data/ArkAppMessage:promptText	Ljava/lang/String;
    //   94: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: aload_0
    //   99: getfield 65	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +21 -> 125
    //   107: aload_1
    //   108: ldc 23
    //   110: new 81	org/json/JSONObject
    //   113: dup
    //   114: aload_0
    //   115: getfield 65	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   118: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   124: pop
    //   125: aload_0
    //   126: getfield 67	com/tencent/mobileqq/data/ArkAppMessage:config	Ljava/lang/String;
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +21 -> 152
    //   134: aload_1
    //   135: ldc 20
    //   137: new 81	org/json/JSONObject
    //   140: dup
    //   141: aload_0
    //   142: getfield 67	com/tencent/mobileqq/data/ArkAppMessage:config	Ljava/lang/String;
    //   145: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload_1
    //   153: invokevirtual 141	org/json/JSONObject:toString	()Ljava/lang/String;
    //   156: areturn
    //   157: astore_2
    //   158: ldc 46
    //   160: new 143	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   167: ldc -110
    //   169: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_2
    //   173: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   176: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 160	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -60 -> 125
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 161	org/json/JSONException:printStackTrace	()V
    //   193: aconst_null
    //   194: areturn
    //   195: astore_2
    //   196: ldc 46
    //   198: new 143	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   205: ldc -93
    //   207: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   214: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 160	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: goto -71 -> 152
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   231: goto -38 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	ArkAppMessage
    //   7	146	1	localJSONObject	JSONObject
    //   188	2	1	localJSONException	org.json.JSONException
    //   226	2	1	localException1	Exception
    //   102	29	2	str	String
    //   157	16	2	localException2	Exception
    //   195	16	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   107	125	157	java/lang/Exception
    //   0	26	188	org/json/JSONException
    //   26	44	188	org/json/JSONException
    //   44	62	188	org/json/JSONException
    //   62	80	188	org/json/JSONException
    //   80	98	188	org/json/JSONException
    //   98	103	188	org/json/JSONException
    //   107	125	188	org/json/JSONException
    //   125	130	188	org/json/JSONException
    //   134	152	188	org/json/JSONException
    //   152	157	188	org/json/JSONException
    //   158	185	188	org/json/JSONException
    //   196	223	188	org/json/JSONException
    //   134	152	195	java/lang/Exception
    //   0	26	226	java/lang/Exception
    //   26	44	226	java/lang/Exception
    //   44	62	226	java/lang/Exception
    //   62	80	226	java/lang/Exception
    //   80	98	226	java/lang/Exception
    //   98	103	226	java/lang/Exception
    //   125	130	226	java/lang/Exception
    //   152	157	226	java/lang/Exception
    //   158	185	226	java/lang/Exception
    //   196	223	226	java/lang/Exception
  }
  
  public byte[] toBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream((OutputStream)localObject).writeObject(toAppXml());
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public byte[] toPbData()
  {
    Object localObject = toAppXml();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((String)localObject).getBytes("utf-8");
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ArkAppMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */