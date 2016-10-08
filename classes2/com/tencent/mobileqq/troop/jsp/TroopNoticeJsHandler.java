package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vnn;
import vno;
import vnp;
import vnq;

public class TroopNoticeJsHandler
  extends WebViewPlugin
{
  public static final byte a = 100;
  public static final String a = "troopNotice";
  public static final String b = "showPicture";
  public static final String c = "sendPicture";
  public static final String d = "sendBatchPicture";
  public static String f = "pic_up";
  public static String g = "pic";
  private BroadcastReceiver a;
  protected String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TroopNoticeJsHandler()
  {
    this.mPluginNameSpace = "troopNotice";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = 5381;
    int i = 0;
    int k = paramString.length();
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return Integer.toString(0x7FFFFFFF & j);
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: aload_2
    //   1: sipush 640
    //   4: invokestatic 86	com/tencent/biz/common/util/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   7: astore 7
    //   9: aload 7
    //   11: ifnonnull +15 -> 26
    //   14: aload 7
    //   16: ifnull +8 -> 24
    //   19: aload 7
    //   21: invokevirtual 91	android/graphics/Bitmap:recycle	()V
    //   24: aconst_null
    //   25: areturn
    //   26: aload 7
    //   28: astore_2
    //   29: new 93	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 99	com/tencent/mobileqq/app/AppConstants:by	Ljava/lang/String;
    //   39: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 105
    //   44: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 8
    //   52: aload 7
    //   54: astore_2
    //   55: aload 7
    //   57: new 110	java/io/File
    //   60: dup
    //   61: aload 8
    //   63: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: invokestatic 118	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   69: aload 7
    //   71: ifnull +8 -> 79
    //   74: aload 7
    //   76: invokevirtual 91	android/graphics/Bitmap:recycle	()V
    //   79: new 120	java/util/HashMap
    //   82: dup
    //   83: invokespecial 121	java/util/HashMap:<init>	()V
    //   86: astore_2
    //   87: aload_2
    //   88: ldc 123
    //   90: aload 5
    //   92: invokestatic 125	com/tencent/mobileqq/troop/jsp/TroopNoticeJsHandler:a	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokeinterface 131 3 0
    //   100: pop
    //   101: aload_3
    //   102: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +62 -> 167
    //   108: new 133	org/json/JSONObject
    //   111: dup
    //   112: aload_3
    //   113: invokespecial 134	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   116: astore_3
    //   117: aload_3
    //   118: invokevirtual 138	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   121: astore 7
    //   123: aload 7
    //   125: invokeinterface 144 1 0
    //   130: ifeq +37 -> 167
    //   133: aload 7
    //   135: invokeinterface 148 1 0
    //   140: checkcast 57	java/lang/String
    //   143: astore 9
    //   145: aload_2
    //   146: aload 9
    //   148: aload_3
    //   149: aload 9
    //   151: invokevirtual 152	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   154: invokevirtual 155	java/lang/Object:toString	()Ljava/lang/String;
    //   157: invokeinterface 131 3 0
    //   162: pop
    //   163: goto -40 -> 123
    //   166: astore_3
    //   167: new 120	java/util/HashMap
    //   170: dup
    //   171: invokespecial 121	java/util/HashMap:<init>	()V
    //   174: astore_3
    //   175: aload_3
    //   176: aload 6
    //   178: aload 8
    //   180: invokeinterface 131 3 0
    //   185: pop
    //   186: aload_0
    //   187: invokevirtual 61	java/lang/String:length	()I
    //   190: istore 11
    //   192: new 157	java/lang/StringBuffer
    //   195: dup
    //   196: ldc -97
    //   198: invokespecial 160	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   201: astore 6
    //   203: iconst_0
    //   204: istore 10
    //   206: iload 10
    //   208: bipush 10
    //   210: iload 11
    //   212: isub
    //   213: if_icmpge +79 -> 292
    //   216: aload 6
    //   218: ldc -94
    //   220: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   223: pop
    //   224: iload 10
    //   226: iconst_1
    //   227: iadd
    //   228: istore 10
    //   230: goto -24 -> 206
    //   233: astore_0
    //   234: aconst_null
    //   235: astore 7
    //   237: aload 7
    //   239: astore_2
    //   240: aload_0
    //   241: invokevirtual 168	java/lang/OutOfMemoryError:printStackTrace	()V
    //   244: aload 7
    //   246: ifnull +8 -> 254
    //   249: aload 7
    //   251: invokevirtual 91	android/graphics/Bitmap:recycle	()V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_0
    //   257: aconst_null
    //   258: astore 7
    //   260: aload 7
    //   262: astore_2
    //   263: aload_0
    //   264: invokevirtual 169	java/io/IOException:printStackTrace	()V
    //   267: aload 7
    //   269: ifnull +8 -> 277
    //   272: aload 7
    //   274: invokevirtual 91	android/graphics/Bitmap:recycle	()V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_2
    //   282: aload_2
    //   283: ifnull +7 -> 290
    //   286: aload_2
    //   287: invokevirtual 91	android/graphics/Bitmap:recycle	()V
    //   290: aload_0
    //   291: athrow
    //   292: aload 6
    //   294: aload_0
    //   295: invokevirtual 165	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   298: pop
    //   299: new 120	java/util/HashMap
    //   302: dup
    //   303: invokespecial 121	java/util/HashMap:<init>	()V
    //   306: astore_0
    //   307: aload_0
    //   308: ldc -85
    //   310: new 173	java/net/URL
    //   313: dup
    //   314: aload_1
    //   315: invokespecial 174	java/net/URL:<init>	(Ljava/lang/String;)V
    //   318: invokevirtual 177	java/net/URL:getRef	()Ljava/lang/String;
    //   321: invokeinterface 131 3 0
    //   326: pop
    //   327: aload 4
    //   329: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   332: ifne +67 -> 399
    //   335: new 133	org/json/JSONObject
    //   338: dup
    //   339: aload 4
    //   341: invokespecial 134	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   344: astore 4
    //   346: aload 4
    //   348: invokevirtual 138	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   351: astore 7
    //   353: aload 7
    //   355: invokeinterface 144 1 0
    //   360: ifeq +39 -> 399
    //   363: aload 7
    //   365: invokeinterface 148 1 0
    //   370: checkcast 57	java/lang/String
    //   373: astore 8
    //   375: aload_0
    //   376: aload 8
    //   378: aload 4
    //   380: aload 8
    //   382: invokevirtual 152	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   385: invokevirtual 155	java/lang/Object:toString	()Ljava/lang/String;
    //   388: invokeinterface 131 3 0
    //   393: pop
    //   394: goto -41 -> 353
    //   397: astore 4
    //   399: aload_1
    //   400: aload 6
    //   402: invokevirtual 178	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   405: aload 5
    //   407: aload_2
    //   408: aload_3
    //   409: aload_0
    //   410: invokestatic 183	com/tencent/biz/common/util/HttpUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   413: areturn
    //   414: astore_0
    //   415: aload_0
    //   416: invokevirtual 184	java/net/MalformedURLException:printStackTrace	()V
    //   419: aconst_null
    //   420: areturn
    //   421: astore_0
    //   422: goto -140 -> 282
    //   425: astore_0
    //   426: goto -166 -> 260
    //   429: astore_0
    //   430: goto -193 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	paramString1	String
    //   0	433	1	paramString2	String
    //   0	433	2	paramString3	String
    //   0	433	3	paramString4	String
    //   0	433	4	paramString5	String
    //   0	433	5	paramString6	String
    //   0	433	6	paramString7	String
    //   7	357	7	localObject	Object
    //   50	331	8	str1	String
    //   143	7	9	str2	String
    //   204	25	10	i	int
    //   190	23	11	j	int
    // Exception table:
    //   from	to	target	type
    //   108	123	166	org/json/JSONException
    //   123	163	166	org/json/JSONException
    //   0	9	233	java/lang/OutOfMemoryError
    //   0	9	256	java/io/IOException
    //   0	9	279	finally
    //   335	353	397	org/json/JSONException
    //   353	394	397	org/json/JSONException
    //   307	327	414	java/net/MalformedURLException
    //   29	52	421	finally
    //   55	69	421	finally
    //   240	244	421	finally
    //   263	267	421	finally
    //   29	52	425	java/io/IOException
    //   55	69	425	java/io/IOException
    //   29	52	429	java/lang/OutOfMemoryError
    //   55	69	429	java/lang/OutOfMemoryError
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList paramArrayList, boolean paramBoolean, String paramString, int paramInt2)
  {
    a(paramActivity, paramInt1, paramArrayList, null, null, false, paramBoolean, paramString, paramInt2, null);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2)
  {
    a(paramActivity, paramInt1, paramArrayList1, paramArrayOfBoolean, paramArrayList2, paramBoolean1, paramBoolean2, paramString, paramInt2, null);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport)
  {
    Intent localIntent = new Intent(paramActivity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putStringArrayList("seqNum", paramArrayList1);
    if (paramArrayList2 != null) {
      localBundle.putStringArrayList("descs", paramArrayList2);
    }
    if (paramArrayOfBoolean != null) {
      localBundle.putBooleanArray("likes", paramArrayOfBoolean);
    }
    if ((paramPublicAccountShowPictureReport != null) && (paramPublicAccountShowPictureReport.isReport)) {
      localBundle.putString("PublicAccountShowPictureReport", paramPublicAccountShowPictureReport.toString());
    }
    localBundle.putBoolean("needBottomBar", paramBoolean1);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", paramBoolean2);
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("src_id", paramString);
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramActivity, 0, localArrayList, true, "", 1000);
  }
  
  protected void a(String paramString)
  {
    Object localObject1 = null;
    int j = 0;
    try
    {
      Object localObject2 = new JSONObject(paramString);
      this.e = ((JSONObject)localObject2).optString("callback");
      Object localObject5 = ((JSONObject)localObject2).optJSONArray("imageIDs");
      Object localObject4 = ((JSONObject)localObject2).optJSONArray("likes");
      Object localObject3 = ((JSONObject)localObject2).optJSONArray("descs");
      boolean bool1 = ((JSONObject)localObject2).optBoolean("needBottomBar");
      int k = ((JSONObject)localObject2).optInt("index");
      String str = ((JSONObject)localObject2).optString("srcID");
      paramString = (String)localObject1;
      if (Boolean.valueOf(((JSONObject)localObject2).optBoolean("isReport")).booleanValue())
      {
        paramString = new PublicAccountShowPictureReport();
        paramString.parse((JSONObject)localObject2);
      }
      boolean bool2 = ((JSONObject)localObject2).optBoolean("isNotShowIndex", true);
      if (localObject5 != null)
      {
        if (((JSONArray)localObject5).length() == 0) {
          return;
        }
        if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null))
        {
          localObject2 = this.mRuntime.a();
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if ((localObject2 instanceof BasePluginActivity)) {
              localObject1 = ((BasePluginActivity)localObject2).getOutActivity();
            }
            localObject2 = new ArrayList();
            int m = ((JSONArray)localObject5).length();
            int i = 0;
            while (i < m)
            {
              ((ArrayList)localObject2).add(((JSONArray)localObject5).get(i).toString());
              i += 1;
            }
            if (bool1)
            {
              if (localObject4 != null)
              {
                localObject5 = new boolean[((JSONArray)localObject4).length()];
                i = 0;
                while (i < ((JSONArray)localObject4).length())
                {
                  localObject5[i] = ((JSONArray)localObject4).getBoolean(i);
                  i += 1;
                }
                localObject4 = new ArrayList();
                if ((localObject3 != null) && (((JSONArray)localObject3).length() != 0))
                {
                  m = ((JSONArray)localObject3).length();
                  i = j;
                  while (i < m)
                  {
                    ((ArrayList)localObject4).add(((JSONArray)localObject3).get(i).toString());
                    i += 1;
                  }
                }
                if (this.a == null)
                {
                  this.a = new vnn(this);
                  localObject3 = new IntentFilter("android.intent.action.WEBJSCALL");
                  ((Activity)localObject1).registerReceiver(this.a, (IntentFilter)localObject3);
                }
                a((Activity)localObject1, k, (ArrayList)localObject2, (boolean[])localObject5, (ArrayList)localObject4, bool1, bool2, str, 100, paramString);
              }
            }
            else {
              a((Activity)localObject1, k, (ArrayList)localObject2, null, null, false, bool2, str, 100, paramString);
            }
          }
        }
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  protected void b(String paramString)
  {
    ThreadManager.a(new vno(this, paramString), 5, null, true);
  }
  
  public void c(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = this.mRuntime.a();
      if (paramString == null) {
        return;
      }
      AppInterface localAppInterface = this.mRuntime.a();
      if (localAppInterface != null)
      {
        Activity localActivity = this.mRuntime.a();
        if (localActivity != null)
        {
          String str1 = ((JSONObject)localObject).optString("callback");
          String str2 = ((JSONObject)localObject).optString("cgiURL");
          String str3 = ((JSONObject)localObject).optString("imageID");
          String str4 = ((JSONObject)localObject).optString("headFields");
          localObject = ((JSONObject)localObject).optString("postParams");
          String str5 = LoginHelper.a(localAppInterface);
          localActivity.runOnUiThread(new vnp(this, paramString, str1, a(localAppInterface.a(), str2, str3, (String)localObject, str4, str5, f)));
          return;
        }
      }
    }
    catch (InterruptedException paramString) {}catch (Exception paramString) {}catch (OutOfMemoryError paramString) {}catch (JSONException paramString) {}
  }
  
  protected void d(String paramString)
  {
    ThreadManager.a(new vnq(this, paramString), 5, null, false);
  }
  
  public void e(String paramString)
  {
    if ((this.mRuntime == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.e))) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.a();
    } while (localCustomWebView == null);
    localCustomWebView.loadUrl("javascript: " + this.e + "(" + paramString + ")");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopNotice".equals(paramString2))
    {
      if ((!"showPicture".equals(paramString3)) || (paramVarArgs.length != 1)) {
        break label36;
      }
      a(paramVarArgs[0]);
    }
    label36:
    do
    {
      return false;
      if (("sendPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        b(paramVarArgs[0]);
        return false;
      }
    } while ((!"sendBatchPicture".equals(paramString3)) || (paramVarArgs.length != 1));
    d(paramVarArgs[0]);
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    CustomWebView localCustomWebView;
    if (paramByte == 100)
    {
      localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.hasExtra("DeletedList")));
      paramIntent = paramIntent.getStringArrayListExtra("DeletedList");
    } while ((paramIntent == null) || (paramIntent.size() <= 0));
    localCustomWebView.loadUrl("javascript: " + this.e + "([])");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Activity localActivity2;
    if ((this.a != null) && (this.mRuntime != null))
    {
      localActivity2 = this.mRuntime.a();
      if (localActivity2 != null) {}
    }
    else
    {
      return;
    }
    Activity localActivity1 = localActivity2;
    if ((localActivity2 instanceof BasePluginActivity)) {
      localActivity1 = ((BasePluginActivity)localActivity2).getOutActivity();
    }
    localActivity1.unregisterReceiver(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\jsp\TroopNoticeJsHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */