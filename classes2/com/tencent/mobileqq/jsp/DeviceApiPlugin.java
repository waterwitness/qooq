package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
import sxp;

public class DeviceApiPlugin
  extends WebViewPlugin
{
  public static PowerManager.WakeLock a;
  public static final String a = "DeviceApiPlugin";
  public static boolean a = false;
  public static final String b = "device";
  private int[] a;
  private String c;
  
  public DeviceApiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "";
    this.mPluginNameSpace = "device";
  }
  
  private int a()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new sxp(this)).length;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 1;
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
        jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(10, "VasWakeLock");
      }
      jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      if ((jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
        jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
    } while (paramBoolean2);
    jdField_a_of_type_Boolean = false;
  }
  
  public long a()
  {
    ActivityManager localActivityManager = (ActivityManager)this.mRuntime.a().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L;
  }
  
  public String a()
  {
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        str1 = str1 + new String(arrayOfByte);
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        String str2 = "N/A";
      }
    }
    return str1.trim();
  }
  
  /* Error */
  public long b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: aconst_null
    //   6: astore_3
    //   7: lconst_0
    //   8: lstore 6
    //   10: new 174	java/io/BufferedReader
    //   13: dup
    //   14: new 176	java/io/FileReader
    //   17: dup
    //   18: ldc -78
    //   20: invokespecial 179	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   23: bipush 8
    //   25: invokespecial 182	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokevirtual 185	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore 5
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: ifnull +6 -> 47
    //   44: aload 5
    //   46: astore_1
    //   47: aload_1
    //   48: astore_3
    //   49: aload_2
    //   50: ifnull +9 -> 59
    //   53: aload_2
    //   54: invokevirtual 186	java/io/BufferedReader:close	()V
    //   57: aload_1
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +30 -> 90
    //   63: aload_3
    //   64: aload_3
    //   65: bipush 58
    //   67: invokevirtual 190	java/lang/String:indexOf	(I)I
    //   70: iconst_1
    //   71: iadd
    //   72: aload_3
    //   73: bipush 107
    //   75: invokevirtual 190	java/lang/String:indexOf	(I)I
    //   78: invokevirtual 194	java/lang/String:substring	(II)Ljava/lang/String;
    //   81: invokevirtual 167	java/lang/String:trim	()Ljava/lang/String;
    //   84: invokestatic 200	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   87: i2l
    //   88: lstore 6
    //   90: lload 6
    //   92: lreturn
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   98: aload_1
    //   99: astore_3
    //   100: goto -41 -> 59
    //   103: astore_3
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: astore_1
    //   108: aload_3
    //   109: invokevirtual 201	java/io/FileNotFoundException:printStackTrace	()V
    //   112: aload 4
    //   114: astore_3
    //   115: aload_2
    //   116: ifnull -57 -> 59
    //   119: aload_2
    //   120: invokevirtual 186	java/io/BufferedReader:close	()V
    //   123: aload 4
    //   125: astore_3
    //   126: goto -67 -> 59
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   134: aload 4
    //   136: astore_3
    //   137: goto -78 -> 59
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   149: aload 4
    //   151: astore_3
    //   152: aload_2
    //   153: ifnull -94 -> 59
    //   156: aload_2
    //   157: invokevirtual 186	java/io/BufferedReader:close	()V
    //   160: aload 4
    //   162: astore_3
    //   163: goto -104 -> 59
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   171: aload 4
    //   173: astore_3
    //   174: goto -115 -> 59
    //   177: astore_3
    //   178: aload_1
    //   179: astore_2
    //   180: aload_3
    //   181: astore_1
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 186	java/io/BufferedReader:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore_2
    //   193: aload_2
    //   194: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   197: goto -7 -> 190
    //   200: astore_3
    //   201: aload_1
    //   202: astore_2
    //   203: aload_3
    //   204: astore_1
    //   205: goto -23 -> 182
    //   208: astore_3
    //   209: goto -66 -> 143
    //   212: astore_3
    //   213: goto -107 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	DeviceApiPlugin
    //   4	104	1	localObject1	Object
    //   129	2	1	localIOException1	IOException
    //   144	1	1	localObject2	Object
    //   166	13	1	localIOException2	IOException
    //   181	24	1	localObject3	Object
    //   28	26	2	localBufferedReader	BufferedReader
    //   93	2	2	localIOException3	IOException
    //   105	82	2	localIOException4	IOException
    //   192	2	2	localIOException5	IOException
    //   202	1	2	localObject4	Object
    //   6	94	3	localObject5	Object
    //   103	6	3	localFileNotFoundException1	FileNotFoundException
    //   114	23	3	localObject6	Object
    //   140	6	3	localIOException6	IOException
    //   151	23	3	localObject7	Object
    //   177	4	3	localObject8	Object
    //   200	4	3	localObject9	Object
    //   208	1	3	localIOException7	IOException
    //   212	1	3	localFileNotFoundException2	FileNotFoundException
    //   1	171	4	localObject10	Object
    //   35	10	5	str	String
    //   8	83	6	l	long
    // Exception table:
    //   from	to	target	type
    //   53	57	93	java/io/IOException
    //   10	29	103	java/io/FileNotFoundException
    //   119	123	129	java/io/IOException
    //   10	29	140	java/io/IOException
    //   156	160	166	java/io/IOException
    //   10	29	177	finally
    //   186	190	192	java/io/IOException
    //   31	37	200	finally
    //   108	112	200	finally
    //   145	149	200	finally
    //   31	37	208	java/io/IOException
    //   31	37	212	java/io/FileNotFoundException
  }
  
  public String b()
  {
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        str1 = str1 + new String(arrayOfByte);
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        String str2 = "N/A";
      }
    }
    return str1.trim();
  }
  
  public String c()
  {
    try
    {
      Object localObject = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
      BufferedReader localBufferedReader = new BufferedReader((Reader)localObject);
      String str = localBufferedReader.readLine();
      ((FileReader)localObject).close();
      localBufferedReader.close();
      localObject = str.trim();
      return (String)localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return "N/A";
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return "N/A";
  }
  
  public String d()
  {
    try
    {
      Object localObject = new FileReader("/proc/cpuinfo");
      BufferedReader localBufferedReader = new BufferedReader((Reader)localObject);
      String str = localBufferedReader.readLine();
      ((FileReader)localObject).close();
      localBufferedReader.close();
      localObject = str.split(":\\s+", 2);
      int i = 0;
      while (i < localObject.length) {
        i += 1;
      }
      localObject = localObject[1];
      return (String)localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceApiPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"device".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    int i = paramString1.indexOf("=");
    if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
      return false;
    }
    paramString2 = paramString1.substring(i + 1);
    if (paramString2 == null) {
      return false;
    }
    try
    {
      paramJsBridgeListener = URLDecoder.decode(paramString2, "UTF-8");
      if (paramJsBridgeListener == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DeviceApiPlugin", 2, "Failed to decode json str, josn=" + paramString2);
        }
        paramJsBridgeListener = null;
      }
      try
      {
        paramString2 = new JSONObject(paramJsBridgeListener);
        if (paramString2 == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DeviceApiPlugin", 2, "Failed to parse json str,json=");
          }
          paramString2 = null;
        }
        try
        {
          if (paramString2.has("callback"))
          {
            paramJsBridgeListener = paramString2.getString("callback");
          }
          else
          {
            i = paramString1.indexOf("#");
            if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
              break label963;
            }
            paramJsBridgeListener = paramString1.substring(i + 1);
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DeviceApiPlugin", 2, "Failed to parse callbackid,json=" + paramString2);
          }
          paramJsBridgeListener = null;
        }
      }
    }
    if ("setScreenStatus".equals(paramString3)) {}
    for (;;)
    {
      try
      {
        if (!paramString2.has("status")) {
          break label951;
        }
        i = paramString2.getInt("status");
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DeviceApiPlugin", 2, "Failed to setScreenStatus:" + paramString1.getMessage());
        callJs(paramJsBridgeListener, new String[] { "{'result':-1,'message':" + paramString1.getMessage() + "}" });
        break label977;
      }
      a(bool, this.mRuntime.a().getApplicationContext(), false);
      if (jdField_a_of_type_Boolean)
      {
        paramString1 = "{'result':1,'message':'light'}";
        callJs(paramJsBridgeListener, new String[] { paramString1 });
      }
      else
      {
        paramString1 = "{'result':0,'message':'dim'}";
        continue;
        if ("getWebpDecoderVersion".equals(paramString3))
        {
          paramString1 = new JSONObject();
          try
          {
            paramString1.put("result", -1);
            if (this.jdField_a_of_type_ArrayOfInt != null)
            {
              paramString1.put("result", 0);
              paramString1.put("type", this.c);
              paramString1.put("version", String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[2]) }));
            }
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else
        {
          if ("canInstallThirdPartyApp".equals(paramString3))
          {
            paramString1 = this.mRuntime.a();
            if (paramString1 != null) {
              i = Settings.Secure.getInt(paramString1.getContentResolver(), "install_non_market_apps", 0);
            }
            for (paramString1 = "{'result':" + i + "}";; paramString1 = "{'result':-1,'message':'Context is null!'}")
            {
              callJs(paramJsBridgeListener, new String[] { paramString1 });
              break;
            }
          }
          if ("getCPUInfo".equals(paramString3)) {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("maxFreq", a());
              paramString1.put("minFreq", b());
              paramString1.put("curFreq", c());
              paramString1.put("CPUName", d());
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          if ("getMemInfo".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("idleMem", a());
              paramString1.put("totalMem", b());
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if ("getCPUCoreNum".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("count", a());
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.w("DeviceApiPlugin", 2, "NOT support method " + paramString3 + " yet!!");
            }
            return false;
            label951:
            i = 0;
            break label965;
            if (paramJsBridgeListener != null) {
              break;
            }
            return false;
            label963:
            return false;
            label965:
            if (i != 1) {
              break label979;
            }
            bool = true;
            continue;
          }
        }
      }
      label977:
      return true;
      label979:
      boolean bool = false;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    if (jdField_a_of_type_Boolean) {
      a(false, null, false);
    }
    if (jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
      jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
    super.onDestroy();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if ((paramCustomWebView != null) && (paramCustomWebView.getX5WebViewExtension() != null))
    {
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 3, 0, 0 };
      this.c = "QQBrowser";
    }
    do
    {
      return;
      this.jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
    } while (this.jdField_a_of_type_ArrayOfInt == null);
    if (WebpSoLoader.jdField_a_of_type_ArrayOfInt != null)
    {
      this.c = "Hook";
      return;
    }
    this.c = "System";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\DeviceApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */