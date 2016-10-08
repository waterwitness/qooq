package bolts;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewAppLinkResolver
  implements AppLinkResolver
{
  private static final String KEY_AL_VALUE = "value";
  private static final String KEY_ANDROID = "android";
  private static final String KEY_APP_NAME = "app_name";
  private static final String KEY_CLASS = "class";
  private static final String KEY_PACKAGE = "package";
  private static final String KEY_SHOULD_FALLBACK = "should_fallback";
  private static final String KEY_URL = "url";
  private static final String KEY_WEB = "web";
  private static final String KEY_WEB_URL = "url";
  private static final String META_TAG_PREFIX = "al";
  private static final String PREFER_HEADER = "Prefer-Html-Meta-Tags";
  private static final String TAG_EXTRACTION_JAVASCRIPT = "javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";
  private final Context context;
  
  public WebViewAppLinkResolver(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static List<Map<String, Object>> getAlList(Map<String, Object> paramMap, String paramString)
  {
    paramString = (List)paramMap.get(paramString);
    paramMap = paramString;
    if (paramString == null) {
      paramMap = Collections.emptyList();
    }
    return paramMap;
  }
  
  private static AppLink makeAppLinkFromAlData(Map<String, Object> paramMap, Uri paramUri)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (List)paramMap.get("android");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Collections.emptyList();
    }
    localObject2 = ((List)localObject1).iterator();
    if (!((Iterator)localObject2).hasNext())
    {
      localObject1 = paramUri;
      paramMap = (List)paramMap.get("web");
      localObject2 = localObject1;
      if (paramMap != null)
      {
        localObject2 = localObject1;
        if (paramMap.size() > 0)
        {
          paramMap = (Map)paramMap.get(0);
          localList1 = (List)paramMap.get("url");
          localObject2 = (List)paramMap.get("should_fallback");
          paramMap = (Map<String, Object>)localObject1;
          if (localObject2 != null)
          {
            paramMap = (Map<String, Object>)localObject1;
            if (((List)localObject2).size() > 0)
            {
              localObject2 = (String)((Map)((List)localObject2).get(0)).get("value");
              paramMap = (Map<String, Object>)localObject1;
              if (Arrays.asList(new String[] { "no", "false", "0" }).contains(((String)localObject2).toLowerCase())) {
                paramMap = null;
              }
            }
          }
          localObject2 = paramMap;
          if (paramMap != null)
          {
            localObject2 = paramMap;
            if (localList1 != null)
            {
              localObject2 = paramMap;
              if (localList1.size() > 0) {
                localObject2 = tryCreateUrl((String)((Map)localList1.get(0)).get("value"));
              }
            }
          }
        }
      }
      return new AppLink(paramUri, localArrayList, (Uri)localObject2);
    }
    localObject1 = (Map)((Iterator)localObject2).next();
    List localList1 = getAlList((Map)localObject1, "url");
    List localList2 = getAlList((Map)localObject1, "package");
    List localList3 = getAlList((Map)localObject1, "class");
    List localList4 = getAlList((Map)localObject1, "app_name");
    int j = Math.max(localList1.size(), Math.max(localList2.size(), Math.max(localList3.size(), localList4.size())));
    int i = 0;
    label336:
    label375:
    Uri localUri;
    label416:
    String str1;
    label454:
    String str2;
    if (i < j)
    {
      if (localList1.size() <= i) {
        break label526;
      }
      localObject1 = ((Map)localList1.get(i)).get("value");
      localUri = tryCreateUrl((String)localObject1);
      if (localList2.size() <= i) {
        break label531;
      }
      localObject1 = ((Map)localList2.get(i)).get("value");
      str1 = (String)localObject1;
      if (localList3.size() <= i) {
        break label536;
      }
      localObject1 = ((Map)localList3.get(i)).get("value");
      str2 = (String)localObject1;
      if (localList4.size() <= i) {
        break label541;
      }
    }
    label526:
    label531:
    label536:
    label541:
    for (localObject1 = ((Map)localList4.get(i)).get("value");; localObject1 = null)
    {
      localArrayList.add(new AppLink.Target(str1, str2, localUri, (String)localObject1));
      i += 1;
      break label336;
      break;
      localObject1 = null;
      break label375;
      localObject1 = null;
      break label416;
      localObject1 = null;
      break label454;
    }
  }
  
  private static Map<String, Object> parseAlData(JSONArray paramJSONArray)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i >= paramJSONArray.length()) {
      return localHashMap;
    }
    JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
    String[] arrayOfString = localJSONObject.getString("property").split(":");
    if (!arrayOfString[0].equals("al")) {}
    for (;;)
    {
      i += 1;
      break;
      Object localObject1 = localHashMap;
      int j = 1;
      if (j >= arrayOfString.length)
      {
        if (!localJSONObject.has("content")) {
          continue;
        }
        if (localJSONObject.isNull("content")) {
          ((Map)localObject1).put("value", null);
        }
      }
      else
      {
        List localList = (List)((Map)localObject1).get(arrayOfString[j]);
        Object localObject2 = localList;
        if (localList == null)
        {
          localObject2 = new ArrayList();
          ((Map)localObject1).put(arrayOfString[j], localObject2);
        }
        if (((List)localObject2).size() > 0) {}
        for (localObject1 = (Map)((List)localObject2).get(((List)localObject2).size() - 1);; localObject1 = null)
        {
          if ((localObject1 == null) || (j == arrayOfString.length - 1))
          {
            localObject1 = new HashMap();
            ((List)localObject2).add(localObject1);
          }
          j += 1;
          break;
        }
      }
      ((Map)localObject1).put("value", localJSONObject.getString("content"));
    }
  }
  
  /* Error */
  private static String readFromConnection(java.net.URLConnection paramURLConnection)
    throws java.io.IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: instanceof 220
    //   7: ifeq +98 -> 105
    //   10: aload_0
    //   11: checkcast 220	java/net/HttpURLConnection
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 226	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   19: astore_1
    //   20: new 228	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 229	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore 4
    //   29: sipush 1024
    //   32: newarray <illegal type>
    //   34: astore_2
    //   35: aload_1
    //   36: aload_2
    //   37: invokevirtual 235	java/io/InputStream:read	([B)I
    //   40: istore 6
    //   42: iload 6
    //   44: iconst_m1
    //   45: if_icmpne +68 -> 113
    //   48: aload_0
    //   49: invokevirtual 238	java/net/URLConnection:getContentEncoding	()Ljava/lang/String;
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: ifnonnull +20 -> 76
    //   59: aload_0
    //   60: invokevirtual 241	java/net/URLConnection:getContentType	()Ljava/lang/String;
    //   63: ldc -13
    //   65: invokevirtual 199	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   68: astore_0
    //   69: aload_0
    //   70: arraylength
    //   71: istore 6
    //   73: goto +97 -> 170
    //   76: new 123	java/lang/String
    //   79: dup
    //   80: aload 4
    //   82: invokevirtual 247	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   85: aload_2
    //   86: invokespecial 250	java/lang/String:<init>	([BLjava/lang/String;)V
    //   89: astore_0
    //   90: aload_1
    //   91: invokevirtual 253	java/io/InputStream:close	()V
    //   94: aload_0
    //   95: areturn
    //   96: astore_1
    //   97: aload_2
    //   98: invokevirtual 256	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   101: astore_1
    //   102: goto -82 -> 20
    //   105: aload_0
    //   106: invokevirtual 226	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   109: astore_1
    //   110: goto -90 -> 20
    //   113: aload 4
    //   115: aload_2
    //   116: iconst_0
    //   117: iload 6
    //   119: invokevirtual 260	java/io/ByteArrayOutputStream:write	([BII)V
    //   122: goto -87 -> 35
    //   125: astore_0
    //   126: aload_1
    //   127: invokevirtual 253	java/io/InputStream:close	()V
    //   130: aload_0
    //   131: athrow
    //   132: aload_0
    //   133: iload 5
    //   135: aaload
    //   136: invokevirtual 263	java/lang/String:trim	()Ljava/lang/String;
    //   139: astore_2
    //   140: aload_2
    //   141: ldc_w 265
    //   144: invokevirtual 268	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   147: ifeq +17 -> 164
    //   150: aload_2
    //   151: ldc_w 265
    //   154: invokevirtual 269	java/lang/String:length	()I
    //   157: invokevirtual 273	java/lang/String:substring	(I)Ljava/lang/String;
    //   160: astore_0
    //   161: goto +18 -> 179
    //   164: iload 5
    //   166: iconst_1
    //   167: iadd
    //   168: istore 5
    //   170: iload 5
    //   172: iload 6
    //   174: if_icmplt -42 -> 132
    //   177: aload_3
    //   178: astore_0
    //   179: aload_0
    //   180: astore_2
    //   181: aload_0
    //   182: ifnonnull -106 -> 76
    //   185: ldc_w 275
    //   188: astore_2
    //   189: goto -113 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramURLConnection	java.net.URLConnection
    //   19	72	1	localInputStream1	java.io.InputStream
    //   96	1	1	localException	Exception
    //   101	26	1	localInputStream2	java.io.InputStream
    //   14	175	2	localObject	Object
    //   52	126	3	str	String
    //   27	87	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	174	5	i	int
    //   40	135	6	j	int
    // Exception table:
    //   from	to	target	type
    //   15	20	96	java/lang/Exception
    //   20	35	125	finally
    //   35	42	125	finally
    //   48	53	125	finally
    //   59	73	125	finally
    //   76	90	125	finally
    //   113	122	125	finally
    //   132	161	125	finally
  }
  
  private static Uri tryCreateUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  public Task<AppLink> getAppLinkFromUrlInBackground(final Uri paramUri)
  {
    final Capture localCapture1 = new Capture();
    final Capture localCapture2 = new Capture();
    Task.callInBackground(new Callable()
    {
      /* Error */
      public Void call()
        throws Exception
      {
        // Byte code:
        //   0: new 43	java/net/URL
        //   3: dup
        //   4: aload_0
        //   5: getfield 25	bolts/WebViewAppLinkResolver$1:val$url	Landroid/net/Uri;
        //   8: invokevirtual 49	android/net/Uri:toString	()Ljava/lang/String;
        //   11: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
        //   14: astore_1
        //   15: aconst_null
        //   16: astore_2
        //   17: aload_1
        //   18: ifnonnull +41 -> 59
        //   21: aload_0
        //   22: getfield 27	bolts/WebViewAppLinkResolver$1:val$content	Lbolts/Capture;
        //   25: aload_2
        //   26: invokestatic 56	bolts/WebViewAppLinkResolver:access$0	(Ljava/net/URLConnection;)Ljava/lang/String;
        //   29: invokevirtual 62	bolts/Capture:set	(Ljava/lang/Object;)V
        //   32: aload_0
        //   33: getfield 29	bolts/WebViewAppLinkResolver$1:val$contentType	Lbolts/Capture;
        //   36: aload_2
        //   37: invokevirtual 67	java/net/URLConnection:getContentType	()Ljava/lang/String;
        //   40: invokevirtual 62	bolts/Capture:set	(Ljava/lang/Object;)V
        //   43: aload_2
        //   44: instanceof 69
        //   47: ifeq +10 -> 57
        //   50: aload_2
        //   51: checkcast 69	java/net/HttpURLConnection
        //   54: invokevirtual 72	java/net/HttpURLConnection:disconnect	()V
        //   57: aconst_null
        //   58: areturn
        //   59: aload_1
        //   60: invokevirtual 76	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   63: astore_2
        //   64: aload_2
        //   65: instanceof 69
        //   68: ifeq +11 -> 79
        //   71: aload_2
        //   72: checkcast 69	java/net/HttpURLConnection
        //   75: iconst_1
        //   76: invokevirtual 80	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
        //   79: aload_2
        //   80: ldc 82
        //   82: ldc 84
        //   84: invokevirtual 88	java/net/URLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   87: aload_2
        //   88: invokevirtual 91	java/net/URLConnection:connect	()V
        //   91: aload_2
        //   92: instanceof 69
        //   95: ifeq +54 -> 149
        //   98: aload_2
        //   99: checkcast 69	java/net/HttpURLConnection
        //   102: astore_3
        //   103: aload_3
        //   104: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
        //   107: sipush 300
        //   110: if_icmplt +34 -> 144
        //   113: aload_3
        //   114: invokevirtual 95	java/net/HttpURLConnection:getResponseCode	()I
        //   117: sipush 400
        //   120: if_icmpge +24 -> 144
        //   123: new 43	java/net/URL
        //   126: dup
        //   127: aload_3
        //   128: ldc 97
        //   130: invokevirtual 101	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   133: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
        //   136: astore_1
        //   137: aload_3
        //   138: invokevirtual 72	java/net/HttpURLConnection:disconnect	()V
        //   141: goto -124 -> 17
        //   144: aconst_null
        //   145: astore_1
        //   146: goto -129 -> 17
        //   149: aconst_null
        //   150: astore_1
        //   151: goto -134 -> 17
        //   154: astore_1
        //   155: aload_2
        //   156: instanceof 69
        //   159: ifeq +10 -> 169
        //   162: aload_2
        //   163: checkcast 69	java/net/HttpURLConnection
        //   166: invokevirtual 72	java/net/HttpURLConnection:disconnect	()V
        //   169: aload_1
        //   170: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	171	0	this	1
        //   14	137	1	localURL	java.net.URL
        //   154	16	1	localObject	Object
        //   16	147	2	localURLConnection	java.net.URLConnection
        //   102	36	3	localHttpURLConnection	java.net.HttpURLConnection
        // Exception table:
        //   from	to	target	type
        //   21	43	154	finally
      }
    }).onSuccessTask(new Continuation()
    {
      public Task<JSONArray> then(Task<Void> paramAnonymousTask)
        throws Exception
      {
        final Task.TaskCompletionSource localTaskCompletionSource = Task.create();
        WebView localWebView = new WebView(WebViewAppLinkResolver.this.context);
        localWebView.getSettings().setJavaScriptEnabled(true);
        localWebView.setNetworkAvailable(false);
        localWebView.setWebViewClient(new WebViewClient()
        {
          private boolean loaded = false;
          
          private void runJavaScript(WebView paramAnonymous2WebView)
          {
            if (!this.loaded)
            {
              this.loaded = true;
              paramAnonymous2WebView.loadUrl("javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())");
            }
          }
          
          public void onLoadResource(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            super.onLoadResource(paramAnonymous2WebView, paramAnonymous2String);
            runJavaScript(paramAnonymous2WebView);
          }
          
          public void onPageFinished(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            super.onPageFinished(paramAnonymous2WebView, paramAnonymous2String);
            runJavaScript(paramAnonymous2WebView);
          }
        });
        localWebView.addJavascriptInterface(new Object()
        {
          public void setValue(String paramAnonymous2String)
          {
            try
            {
              localTaskCompletionSource.trySetResult(new JSONArray(paramAnonymous2String));
              return;
            }
            catch (JSONException paramAnonymous2String)
            {
              localTaskCompletionSource.trySetError(paramAnonymous2String);
            }
          }
        }, "boltsWebViewAppLinkResolverResult");
        paramAnonymousTask = null;
        if (localCapture2.get() != null) {
          paramAnonymousTask = ((String)localCapture2.get()).split(";")[0];
        }
        localWebView.loadDataWithBaseURL(paramUri.toString(), (String)localCapture1.get(), paramAnonymousTask, null, null);
        return localTaskCompletionSource.getTask();
      }
    }, Task.UI_THREAD_EXECUTOR).onSuccess(new Continuation()
    {
      public AppLink then(Task<JSONArray> paramAnonymousTask)
        throws Exception
      {
        return WebViewAppLinkResolver.makeAppLinkFromAlData(WebViewAppLinkResolver.access$2((JSONArray)paramAnonymousTask.getResult()), paramUri);
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\bolts\WebViewAppLinkResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */