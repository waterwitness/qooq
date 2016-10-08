package cooperation.qzone.webviewplugin;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import yrj;

public class QzoneFamousSpaceWebViewLogic
{
  private static QzoneFamousSpaceWebViewLogic jdField_a_of_type_CooperationQzoneWebviewpluginQzoneFamousSpaceWebViewLogic;
  public static final String a = "UpdateFamousSpaceVpageOptions";
  public static final String b = "UpdateFamousSpaceVpageConcern";
  private WebViewPlugin jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
  private Object jdField_a_of_type_JavaLangObject;
  
  private QzoneFamousSpaceWebViewLogic()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    a();
  }
  
  public static QzoneFamousSpaceWebViewLogic a()
  {
    if (jdField_a_of_type_CooperationQzoneWebviewpluginQzoneFamousSpaceWebViewLogic == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQzoneWebviewpluginQzoneFamousSpaceWebViewLogic == null) {
        jdField_a_of_type_CooperationQzoneWebviewpluginQzoneFamousSpaceWebViewLogic = new QzoneFamousSpaceWebViewLogic();
      }
      return jdField_a_of_type_CooperationQzoneWebviewpluginQzoneFamousSpaceWebViewLogic;
    }
    finally {}
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("NativeCallJsAction");
    BaseApplicationImpl.a().registerReceiver(new yrj(this), localIntentFilter);
  }
  
  /* Error */
  public void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: new 61	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 62	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 64
    //   13: lload_1
    //   14: invokestatic 70	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   17: invokevirtual 74	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload 4
    //   23: ldc 76
    //   25: iload_3
    //   26: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: getfield 26	cooperation/qzone/webviewplugin/QzoneFamousSpaceWebViewLogic:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   34: astore 5
    //   36: aload 5
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 81	cooperation/qzone/webviewplugin/QzoneFamousSpaceWebViewLogic:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   43: ifnull +15 -> 58
    //   46: aload_0
    //   47: getfield 81	cooperation/qzone/webviewplugin/QzoneFamousSpaceWebViewLogic:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   50: ldc 12
    //   52: aload 4
    //   54: aconst_null
    //   55: invokevirtual 87	com/tencent/mobileqq/webview/swift/WebViewPlugin:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   58: aload 5
    //   60: monitorexit
    //   61: return
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 90	org/json/JSONException:printStackTrace	()V
    //   69: goto -39 -> 30
    //   72: astore 4
    //   74: aload 5
    //   76: monitorexit
    //   77: aload 4
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	QzoneFamousSpaceWebViewLogic
    //   0	80	1	paramLong	long
    //   0	80	3	paramInt	int
    //   7	46	4	localJSONObject	org.json.JSONObject
    //   72	6	4	localObject1	Object
    //   62	13	5	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   9	30	62	org/json/JSONException
    //   39	58	72	finally
    //   58	61	72	finally
    //   74	77	72	finally
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramWebViewPlugin;
      return;
    }
  }
  
  /* Error */
  public void a(String... arg1)
  {
    // Byte code:
    //   0: ldc 94
    //   2: astore_2
    //   3: new 61	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: iconst_0
    //   9: aaload
    //   10: invokespecial 96	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 76
    //   17: invokevirtual 100	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   20: istore 4
    //   22: aload_1
    //   23: ldc 64
    //   25: invokevirtual 104	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: new 106	android/content/Intent
    //   32: dup
    //   33: invokespecial 107	android/content/Intent:<init>	()V
    //   36: astore_2
    //   37: aload_2
    //   38: ldc 109
    //   40: invokevirtual 113	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   43: pop
    //   44: aload_2
    //   45: ldc 76
    //   47: iload 4
    //   49: invokevirtual 117	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   52: pop
    //   53: aload_2
    //   54: ldc 64
    //   56: aload_1
    //   57: invokestatic 123	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   60: invokevirtual 126	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   63: pop
    //   64: aload_0
    //   65: getfield 26	cooperation/qzone/webviewplugin/QzoneFamousSpaceWebViewLogic:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   68: astore_1
    //   69: aload_1
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 81	cooperation/qzone/webviewplugin/QzoneFamousSpaceWebViewLogic:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   75: ifnonnull +19 -> 94
    //   78: aload_1
    //   79: monitorexit
    //   80: return
    //   81: astore_1
    //   82: iconst_m1
    //   83: istore 4
    //   85: aload_1
    //   86: invokevirtual 90	org/json/JSONException:printStackTrace	()V
    //   89: aload_2
    //   90: astore_1
    //   91: goto -62 -> 29
    //   94: aload_0
    //   95: getfield 81	cooperation/qzone/webviewplugin/QzoneFamousSpaceWebViewLogic:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   98: getfield 130	com/tencent/mobileqq/webview/swift/WebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnonnull +11 -> 114
    //   106: aload_1
    //   107: monitorexit
    //   108: return
    //   109: astore_2
    //   110: aload_1
    //   111: monitorexit
    //   112: aload_2
    //   113: athrow
    //   114: aload_3
    //   115: invokevirtual 135	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   118: astore_3
    //   119: aload_3
    //   120: ifnull +8 -> 128
    //   123: aload_3
    //   124: aload_2
    //   125: invokevirtual 141	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   128: aload_1
    //   129: monitorexit
    //   130: return
    //   131: astore_1
    //   132: goto -47 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	QzoneFamousSpaceWebViewLogic
    //   2	88	2	localObject1	Object
    //   109	16	2	localIntent	android.content.Intent
    //   101	23	3	localObject2	Object
    //   20	64	4	i	int
    // Exception table:
    //   from	to	target	type
    //   3	22	81	org/json/JSONException
    //   71	80	109	finally
    //   94	102	109	finally
    //   106	108	109	finally
    //   110	112	109	finally
    //   114	119	109	finally
    //   123	128	109	finally
    //   128	130	109	finally
    //   22	29	131	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneFamousSpaceWebViewLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */