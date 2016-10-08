package cooperation.comic.emoticon;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VipComicEmoticonJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String a = "VipComicEmoticonJsPlugin";
  public static final String b = "comicFavor";
  public static final String c = "setComicEmoji";
  public static final String d = "getAddComicEmojiList";
  public static final String e = "listArray";
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  BrowserAppInterface jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
  
  public VipComicEmoticonJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.mPluginNameSpace = "comicFavor";
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: ldc 8
    //   8: iconst_2
    //   9: new 59	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   16: ldc 62
    //   18: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 68
    //   27: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_3
    //   31: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 70
    //   36: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 4
    //   41: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_2
    //   51: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifne +20 -> 74
    //   57: ldc 11
    //   59: aload_3
    //   60: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +11 -> 74
    //   66: aload 4
    //   68: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifeq +5 -> 76
    //   74: iconst_0
    //   75: ireturn
    //   76: new 91	org/json/JSONObject
    //   79: dup
    //   80: aload 5
    //   82: iconst_0
    //   83: aaload
    //   84: invokespecial 94	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull -15 -> 74
    //   92: aload_2
    //   93: ldc 96
    //   95: invokevirtual 100	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_1
    //   99: ldc 17
    //   101: aload 4
    //   103: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +66 -> 172
    //   109: aload_0
    //   110: ldc 102
    //   112: aload_1
    //   113: aload_0
    //   114: getfield 106	cooperation/comic/emoticon/VipComicEmoticonJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   117: getfield 112	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   120: aconst_null
    //   121: invokestatic 117	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   124: iconst_0
    //   125: iconst_1
    //   126: invokespecial 121	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_1
    //   132: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +28 -> 163
    //   138: ldc 8
    //   140: iconst_2
    //   141: new 59	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   148: ldc 123
    //   150: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aconst_null
    //   154: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_1
    //   164: invokevirtual 129	org/json/JSONException:printStackTrace	()V
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -81 -> 88
    //   172: ldc 14
    //   174: aload 4
    //   176: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq -50 -> 129
    //   182: new 91	org/json/JSONObject
    //   185: dup
    //   186: invokespecial 130	org/json/JSONObject:<init>	()V
    //   189: astore_3
    //   190: aload_0
    //   191: getfield 39	cooperation/comic/emoticon/VipComicEmoticonJsPlugin:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   194: invokestatic 136	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   197: ifne +39 -> 236
    //   200: aload_3
    //   201: ldc -118
    //   203: bipush -2
    //   205: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   208: pop
    //   209: aload_3
    //   210: ldc -112
    //   212: ldc -110
    //   214: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload_0
    //   219: aload_1
    //   220: iconst_1
    //   221: anewarray 85	java/lang/String
    //   224: dup
    //   225: iconst_0
    //   226: aload_3
    //   227: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   230: aastore
    //   231: invokespecial 154	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   234: iconst_1
    //   235: ireturn
    //   236: ldc -100
    //   238: invokestatic 161	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   241: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifne +39 -> 283
    //   247: aload_3
    //   248: ldc -118
    //   250: bipush -3
    //   252: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload_3
    //   257: ldc -112
    //   259: ldc -93
    //   261: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload_0
    //   266: aload_1
    //   267: iconst_1
    //   268: anewarray 85	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: aload_3
    //   274: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   277: aastore
    //   278: invokespecial 154	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   281: iconst_1
    //   282: ireturn
    //   283: aload_2
    //   284: ldc -91
    //   286: invokevirtual 169	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   289: astore_2
    //   290: aload_2
    //   291: ifnull +10 -> 301
    //   294: aload_2
    //   295: invokevirtual 175	org/json/JSONArray:length	()I
    //   298: ifne +39 -> 337
    //   301: aload_3
    //   302: ldc -118
    //   304: bipush -4
    //   306: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload_3
    //   311: ldc -112
    //   313: ldc -79
    //   315: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   318: pop
    //   319: aload_0
    //   320: aload_1
    //   321: iconst_1
    //   322: anewarray 85	java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: aload_3
    //   328: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   331: aastore
    //   332: invokespecial 154	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   335: iconst_1
    //   336: ireturn
    //   337: new 179	android/os/Bundle
    //   340: dup
    //   341: invokespecial 180	android/os/Bundle:<init>	()V
    //   344: astore_3
    //   345: aload_3
    //   346: ldc 20
    //   348: aload_2
    //   349: invokevirtual 181	org/json/JSONArray:toString	()Ljava/lang/String;
    //   352: invokevirtual 185	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload_0
    //   356: ldc -69
    //   358: aload_1
    //   359: aload_0
    //   360: getfield 106	cooperation/comic/emoticon/VipComicEmoticonJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   363: getfield 112	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   366: aload_3
    //   367: invokestatic 117	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   370: iconst_0
    //   371: iconst_1
    //   372: invokespecial 121	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   375: goto -246 -> 129
    //   378: astore_3
    //   379: aload_1
    //   380: astore_2
    //   381: aload_3
    //   382: astore_1
    //   383: new 91	org/json/JSONObject
    //   386: dup
    //   387: invokespecial 130	org/json/JSONObject:<init>	()V
    //   390: astore_3
    //   391: aload_3
    //   392: ldc -118
    //   394: iconst_m1
    //   395: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   398: pop
    //   399: aload_3
    //   400: ldc -112
    //   402: aload_1
    //   403: invokevirtual 190	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   406: invokevirtual 149	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload_0
    //   411: aload_2
    //   412: iconst_1
    //   413: anewarray 85	java/lang/String
    //   416: dup
    //   417: iconst_0
    //   418: aload_3
    //   419: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   422: aastore
    //   423: invokevirtual 191	cooperation/comic/emoticon/VipComicEmoticonJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   426: goto -297 -> 129
    //   429: astore_2
    //   430: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq -304 -> 129
    //   436: ldc 8
    //   438: iconst_2
    //   439: aload_1
    //   440: invokevirtual 190	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   443: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: goto -317 -> 129
    //   449: astore_1
    //   450: aconst_null
    //   451: astore_2
    //   452: goto -69 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	VipComicEmoticonJsPlugin
    //   0	455	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	455	2	paramString1	String
    //   0	455	3	paramString2	String
    //   0	455	4	paramString3	String
    //   0	455	5	paramVarArgs	String[]
    // Exception table:
    //   from	to	target	type
    //   76	88	131	org/json/JSONException
    //   99	129	378	java/lang/Throwable
    //   172	234	378	java/lang/Throwable
    //   236	281	378	java/lang/Throwable
    //   283	290	378	java/lang/Throwable
    //   294	301	378	java/lang/Throwable
    //   301	335	378	java/lang/Throwable
    //   337	375	378	java/lang/Throwable
    //   383	426	429	java/lang/Exception
    //   92	99	449	java/lang/Throwable
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a().getApplicationContext();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = null;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      String str1;
      String str2;
      String str3;
      JSONObject localJSONObject;
      try
      {
        if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
          return;
        }
        str1 = paramBundle.getString("cmd");
        str2 = paramBundle.getString("callbackid");
        str3 = paramBundle.getString("result");
        if (QLog.isColorLevel()) {
          QLog.e("VipComicEmoticonJsPlugin", 2, "onResponse,callback=" + str2 + ",cmd=" + str1 + ",result=" + str3);
        }
        if (str1 == null) {
          return;
        }
        localJSONObject = new JSONObject();
        if ("ipc_comic_emoticon_add_info".equals(str1))
        {
          if (TextUtils.isEmpty(str3))
          {
            localJSONObject.put("code", -5);
            localJSONObject.put("message", "invalid data, response data is null");
            super.callJs(str2, new String[] { localJSONObject.toString() });
            return;
          }
          super.callJs(str2, new String[] { str3 });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if ("ipc_comic_emoticon_query_info".equals(str1))
      {
        if (TextUtils.isEmpty(str3))
        {
          localJSONObject.put("code", -5);
          localJSONObject.put("message", "invalid data, response data is null");
          super.callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        super.callJs(str2, new String[] { str3 });
        return;
      }
      super.onResponse(paramBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\emoticon\VipComicEmoticonJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */