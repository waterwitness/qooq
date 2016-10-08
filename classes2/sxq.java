import android.content.BroadcastReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.EventApiPlugin;

public class sxq
  extends BroadcastReceiver
{
  public sxq(EventApiPlugin paramEventApiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: aload_2
    //   8: ldc 26
    //   10: iconst_1
    //   11: invokevirtual 32	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   14: ifeq -8 -> 6
    //   17: aload_2
    //   18: ldc 34
    //   20: invokevirtual 38	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +17 -> 42
    //   28: aload_1
    //   29: aload_0
    //   30: getfield 10	sxq:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   33: invokestatic 43	com/tencent/mobileqq/jsp/EventApiPlugin:a	(Lcom/tencent/mobileqq/jsp/EventApiPlugin;)Ljava/lang/String;
    //   36: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifne -33 -> 6
    //   42: aload_2
    //   43: ldc 51
    //   45: invokevirtual 38	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 4
    //   50: aload 4
    //   52: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne -49 -> 6
    //   58: aload_2
    //   59: ldc 59
    //   61: invokevirtual 38	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +199 -> 265
    //   69: new 61	org/json/JSONObject
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 64	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   77: astore_1
    //   78: aload_2
    //   79: ldc 66
    //   81: invokevirtual 70	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   84: astore 5
    //   86: aload 5
    //   88: ifnull -82 -> 6
    //   91: aload_2
    //   92: ldc 72
    //   94: invokevirtual 38	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 6
    //   99: aload_3
    //   100: astore_2
    //   101: aload 6
    //   103: ifnull +13 -> 116
    //   106: new 61	org/json/JSONObject
    //   109: dup
    //   110: aload 6
    //   112: invokespecial 64	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_0
    //   117: getfield 10	sxq:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   120: getfield 76	com/tencent/mobileqq/jsp/EventApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   123: invokevirtual 81	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull -122 -> 6
    //   131: aload_3
    //   132: invokevirtual 87	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   135: astore_3
    //   136: aload_3
    //   137: ifnull -131 -> 6
    //   140: aload_3
    //   141: invokestatic 93	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   144: invokevirtual 96	android/net/Uri:getHost	()Ljava/lang/String;
    //   147: astore 6
    //   149: aload 4
    //   151: ldc 98
    //   153: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifne +13 -> 169
    //   159: aload 4
    //   161: ldc 100
    //   163: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +39 -> 205
    //   169: invokestatic 105	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   172: aload_3
    //   173: ldc 107
    //   175: invokevirtual 110	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   178: ifne +15 -> 193
    //   181: invokestatic 105	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   184: aload_3
    //   185: ldc 112
    //   187: invokevirtual 110	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   190: ifeq +15 -> 205
    //   193: aload_0
    //   194: getfield 10	sxq:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   197: aload 4
    //   199: aload_1
    //   200: aload_2
    //   201: invokevirtual 116	com/tencent/mobileqq/jsp/EventApiPlugin:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   204: return
    //   205: aload 5
    //   207: invokevirtual 122	java/util/ArrayList:size	()I
    //   210: istore 8
    //   212: iconst_0
    //   213: istore 7
    //   215: iload 7
    //   217: iload 8
    //   219: if_icmpge -213 -> 6
    //   222: aload 5
    //   224: iload 7
    //   226: invokevirtual 126	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   229: checkcast 45	java/lang/String
    //   232: aload 6
    //   234: invokestatic 129	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   237: ifeq +15 -> 252
    //   240: aload_0
    //   241: getfield 10	sxq:a	Lcom/tencent/mobileqq/jsp/EventApiPlugin;
    //   244: aload 4
    //   246: aload_1
    //   247: aload_2
    //   248: invokevirtual 116	com/tencent/mobileqq/jsp/EventApiPlugin:dispatchJsEvent	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   251: return
    //   252: iload 7
    //   254: iconst_1
    //   255: iadd
    //   256: istore 7
    //   258: goto -43 -> 215
    //   261: astore_1
    //   262: return
    //   263: astore_1
    //   264: return
    //   265: aconst_null
    //   266: astore_1
    //   267: goto -189 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	sxq
    //   0	270	1	paramContext	android.content.Context
    //   0	270	2	paramIntent	android.content.Intent
    //   1	184	3	localObject	Object
    //   48	197	4	str1	String
    //   84	139	5	localArrayList	java.util.ArrayList
    //   97	136	6	str2	String
    //   213	44	7	i	int
    //   210	10	8	j	int
    // Exception table:
    //   from	to	target	type
    //   106	116	261	org/json/JSONException
    //   69	78	263	org/json/JSONException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sxq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */