package com.tencent.open.business.base;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import wuh;

public class OpenConfig
{
  protected static final String a = "com.tencent.open.config.json";
  protected static HashMap a;
  protected static final String b = "http://mapp.qzone.qq.com/cgi-bin/mapp/mapp_policy_config";
  protected static String c;
  public int a;
  protected long a;
  protected Context a;
  protected JSONObject a;
  protected String d;
  
  protected OpenConfig(Context paramContext, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.d = paramString;
    a();
    b();
  }
  
  public static OpenConfig a(Context paramContext, String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (paramString != null) {
      c = paramString;
    }
    String str = paramString;
    if (paramString == null) {
      if (c == null) {
        break label78;
      }
    }
    label78:
    for (str = c;; str = "0")
    {
      OpenConfig localOpenConfig = (OpenConfig)jdField_a_of_type_JavaUtilHashMap.get(str);
      paramString = localOpenConfig;
      if (localOpenConfig == null)
      {
        paramString = new OpenConfig(paramContext, str);
        jdField_a_of_type_JavaUtilHashMap.put(str, paramString);
      }
      return paramString;
    }
  }
  
  public int a(String paramString)
  {
    c();
    return this.jdField_a_of_type_OrgJsonJSONObject.optInt(paramString);
  }
  
  public long a(String paramString)
  {
    c();
    return this.jdField_a_of_type_OrgJsonJSONObject.optLong(paramString);
  }
  
  /* Error */
  protected String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/open/business/base/OpenConfig:d	Ljava/lang/String;
    //   4: ifnull +102 -> 106
    //   7: new 79	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   14: aload_1
    //   15: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 86
    //   20: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 33	com/tencent/open/business/base/OpenConfig:d	Ljava/lang/String;
    //   27: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 31	com/tencent/open/business/base/OpenConfig:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   38: aload_2
    //   39: invokevirtual 96	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   42: astore_2
    //   43: aload_2
    //   44: astore_1
    //   45: new 98	java/io/BufferedReader
    //   48: dup
    //   49: new 100	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_2
    //   61: new 108	java/lang/StringBuffer
    //   64: dup
    //   65: invokespecial 109	java/lang/StringBuffer:<init>	()V
    //   68: astore_3
    //   69: aload_2
    //   70: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +58 -> 135
    //   80: aload_3
    //   81: aload 4
    //   83: invokevirtual 115	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   86: pop
    //   87: goto -18 -> 69
    //   90: astore_3
    //   91: aload_3
    //   92: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   95: aload_1
    //   96: invokevirtual 123	java/io/InputStream:close	()V
    //   99: aload_2
    //   100: invokevirtual 124	java/io/BufferedReader:close	()V
    //   103: ldc 126
    //   105: areturn
    //   106: aload_1
    //   107: astore_2
    //   108: goto -74 -> 34
    //   111: astore_2
    //   112: aload_0
    //   113: getfield 31	com/tencent/open/business/base/OpenConfig:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   116: invokevirtual 130	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   119: aload_1
    //   120: invokevirtual 136	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   123: astore_1
    //   124: goto -79 -> 45
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   132: ldc 126
    //   134: areturn
    //   135: aload_3
    //   136: invokevirtual 137	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   139: astore_3
    //   140: aload_1
    //   141: invokevirtual 123	java/io/InputStream:close	()V
    //   144: aload_2
    //   145: invokevirtual 124	java/io/BufferedReader:close	()V
    //   148: aload_3
    //   149: areturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   155: aload_3
    //   156: areturn
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   162: ldc 126
    //   164: areturn
    //   165: astore_3
    //   166: aload_1
    //   167: invokevirtual 123	java/io/InputStream:close	()V
    //   170: aload_2
    //   171: invokevirtual 124	java/io/BufferedReader:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   181: goto -7 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	OpenConfig
    //   0	184	1	paramString	String
    //   33	75	2	localObject1	Object
    //   111	60	2	localFileNotFoundException	java.io.FileNotFoundException
    //   68	13	3	localStringBuffer	StringBuffer
    //   90	46	3	localIOException	IOException
    //   139	17	3	str1	String
    //   165	10	3	localObject2	Object
    //   73	9	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   69	75	90	java/io/IOException
    //   80	87	90	java/io/IOException
    //   135	140	90	java/io/IOException
    //   0	34	111	java/io/FileNotFoundException
    //   34	43	111	java/io/FileNotFoundException
    //   112	124	127	java/io/IOException
    //   140	148	150	java/io/IOException
    //   95	103	157	java/io/IOException
    //   69	75	165	finally
    //   80	87	165	finally
    //   91	95	165	finally
    //   135	140	165	finally
    //   166	174	176	java/io/IOException
  }
  
  protected void a()
  {
    String str = a("com.tencent.open.config.json");
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
      return;
    }
    catch (JSONException localJSONException)
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    String str = paramString1;
    try
    {
      if (this.d != null) {
        str = paramString1 + "." + this.d;
      }
      paramString1 = new OutputStreamWriter(this.jdField_a_of_type_AndroidContentContext.openFileOutput(str, 0));
      paramString1.write(paramString2);
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    a("com.tencent.open.config.json", paramJSONObject.toString());
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean a(String paramString)
  {
    c();
    paramString = this.jdField_a_of_type_OrgJsonJSONObject.opt(paramString);
    if (paramString == null) {}
    do
    {
      return false;
      if ((paramString instanceof Integer))
      {
        if (!paramString.equals(Integer.valueOf(0))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    } while (!(paramString instanceof Boolean));
    return ((Boolean)paramString).booleanValue();
  }
  
  public String b(String paramString)
  {
    c();
    return this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.d);
    localBundle.putString("appid_for_getting_config", this.d);
    localBundle.putString("status_os", Build.VERSION.RELEASE);
    localBundle.putString("status_machine", Build.MODEL);
    localBundle.putString("status_version", Build.VERSION.SDK);
    localBundle.putString("sdkv", "1.5");
    localBundle.putString("sdkp", "a");
    ThreadManager.d(new wuh(this, localBundle));
  }
  
  public boolean b(String paramString)
  {
    c();
    paramString = this.jdField_a_of_type_OrgJsonJSONObject.opt(paramString);
    if (paramString == null) {
      return true;
    }
    if ((paramString instanceof Integer))
    {
      if (!paramString.equals(Integer.valueOf(0))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    if ((paramString instanceof Boolean)) {
      return ((Boolean)paramString).booleanValue();
    }
    return false;
  }
  
  protected void c()
  {
    int j = this.jdField_a_of_type_OrgJsonJSONObject.optInt("Common_frequency");
    int i = j;
    if (j == 0) {
      i = 1;
    }
    long l = i * 3600000;
    if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long >= l) {
      b();
    }
  }
  
  public boolean c(String paramString)
  {
    c();
    paramString = this.jdField_a_of_type_OrgJsonJSONObject.opt(paramString);
    if (paramString == null) {}
    do
    {
      return false;
      if ((paramString instanceof Integer))
      {
        if (!paramString.equals(Integer.valueOf(0))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    } while (!(paramString instanceof Boolean));
    return ((Boolean)paramString).booleanValue();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\base\OpenConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */