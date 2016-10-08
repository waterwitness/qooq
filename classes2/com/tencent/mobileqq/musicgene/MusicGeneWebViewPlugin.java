package com.tencent.mobileqq.musicgene;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tgf;
import tgg;
import tgh;
import tgi;
import tgk;

public class MusicGeneWebViewPlugin
  extends WebViewPlugin
{
  private static final String A = "data";
  private static final String B = "list";
  private static final String C = "uin";
  private static final String D = "geneId";
  private static final String E = "index";
  private static final String F = "state";
  private static final String G = "code";
  private static final String H = "playUrl";
  private static final String I = "songPage";
  private static final String J = "songId";
  private static final String K = "songName";
  private static final String L = "singerName";
  private static final String M = "albumName";
  private static final String N = "albumImg";
  private static final String O = "curTime";
  private static final String P = "totalTime";
  private static final String Q = "type";
  private static final String R = "volume";
  private static final String S = "imgUrl";
  private static final String T = "title";
  private static final String U = "desc";
  private static final String V = "src";
  private static final String W = "audioUrl";
  private static final String X = "appid";
  private static final String Y = "iconUrl";
  private static final String Z = "geneType";
  public static final long a = 1101244924L;
  public static final String a = "2ua27x0nPOgcDHFM";
  private static final String aA = "CALLPAGE_SHARE";
  private static final String aB = "playType";
  private static final String aa = "degree";
  private static final String ab = "pageUrl";
  private static final String ac = "0";
  private static final String ad = "1";
  private static final String ae = "0";
  private static final String af = "webCallApp";
  private static final String ag = "bindApp";
  private static final String ah = "unbindApp";
  private static final String ai = "SONG_PLAY";
  private static final String aj = "SONG_PAUSE";
  private static final String ak = "SONG_RESUME";
  private static final String al = "SONG_STOP";
  private static final String am = "SONG_PLAY_NEXT";
  private static final String an = "SONG_PLAY_PREV";
  private static final String ao = "SONG_GET_SONG_INFO";
  private static final String ap = "SONG_GET_LIST_INFO";
  private static final String aq = "SONG_SET_PLAYMODE";
  private static final String ar = "SONG_SET_VOLUME";
  private static final String as = "SONG_GET_VOLUME";
  private static final String at = "DO_MACK_IMG";
  private static final String au = "SHARE_SONG";
  private static final String av = "SHARE_GENE";
  private static final String aw = "MANUAL_INIT";
  private static final String ax = "CALLPAGE_SONG_STATE_CHANGE";
  private static final String ay = "CALLPAGE_SONG_TIME_UPDATE";
  private static final String az = "DO_MACK_IMG_CALLBACK";
  private static final long jdField_b_of_type_Long = 1000L;
  public static final String b = "http://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif";
  public static final String c = "http://y.qq.com/m/recent_listen/play.html?uin=%s&_bid=266&_wv=14115";
  public static final String d = "http://y.qq.com/m/gene/play.html";
  public static final String e = "BROAD_CAST_SHARE_MUSIC_GENE";
  public static final String f = "BROAD_CAST_SHARE_SONG";
  public static final String g = "BROAD_CAST_CALL_PAGE_SHARE";
  public static final String h = "BROAD_CAST_UPDATE_TITLE";
  public static final String i = "BUNDLE_KEY_TITLE";
  public static final String j = "BUNDLE_KEY_DESC";
  public static final String k = "BUDNLE_KEY_IMG_URL";
  public static final String l = "BUNDLE_KEY_SRC";
  public static final String m = "BUNDLE_KEY_AUDIO_URL";
  public static final String n = "BUNDKE_KEY_APP_ID";
  public static final String o = "BUNDLE_KEY_ICON_URL";
  public static final String p = "BUNDLE_KEY_UIN";
  public static final String q = "BUNDLE_KEY_GENE_ID";
  public static final String r = "BUDNLE_KEY_IS_MY_PROFILE";
  public static final String s = "BUNDLE_KEY_URL";
  public static final String t = "BUNDLE_KEY_FROM_PLAY_BAR";
  public static final String u = "BUNDLE_KEY_JSONARRAY_SONG_LIST";
  public static final String v = "BUNDLE_KEY_PLAY_TYPE";
  public static final String w = "qqmusic";
  private static final String x = MusicGeneWebViewPlugin.class.getSimpleName();
  private static final String y = "BUNDLE_KEY_FILE_PATH";
  private static final String z = "action";
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new tgh(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new tgf(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new tgi(this, Looper.getMainLooper());
  private IQQPlayerCallback.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub = new tgg(this);
  private IQQPlayerService jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  private JsBridgeListener jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener;
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MusicGeneWebViewPlugin()
  {
    this.mPluginNameSpace = "qqmusic";
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)) {}
    try
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.c();
      return this.jdField_a_of_type_Int;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return 103;
    case 0: 
      return 102;
    }
    return 101;
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private SongInfo a()
  {
    SongInfo localSongInfo2 = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null)
    {
      localSongInfo1 = localSongInfo2;
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null) {}
    }
    try
    {
      localSongInfo1 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
      return localSongInfo1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localSongInfo2;
  }
  
  private String a()
  {
    try
    {
      if (c()) {
        return MusicPendantManager.a();
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(3, x);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private HashMap a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    int i1 = 0;
    try
    {
      while (i1 < paramJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i1);
        if (localJSONObject != null) {
          localHashMap.put(localJSONObject.getString("songId"), localJSONObject);
        }
        i1 += 1;
      }
      return localHashMap;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  private JSONObject a(SongInfo paramSongInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramSongInfo != null)
    {
      localJSONObject.put("playUrl", paramSongInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("songPage", paramSongInfo.e);
      localJSONObject.put("songId", paramSongInfo.jdField_a_of_type_Long);
      localJSONObject.put("songName", paramSongInfo.b);
      localJSONObject.put("singerName", paramSongInfo.g);
      localJSONObject.put("albumName", paramSongInfo.f);
      localJSONObject.put("albumImg", paramSongInfo.d);
    }
    return localJSONObject;
  }
  
  private void a()
  {
    tgk localtgk = new tgk(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localtgk, 1000L, 1000L);
  }
  
  private void a(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      paramBitmap = Base64Util.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      localObject = "data:image\\/jpg;base64," + paramBitmap;
      paramBitmap = new JSONObject();
    }
    try
    {
      paramBitmap.put("code", "0");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("imgUrl", localObject);
      paramBitmap.put("data", localJSONObject);
      callJs(String.format("try{qqmusicBridge.appTrigger('%s',  %s);}catch(e){}", new Object[] { "DO_MACK_IMG_CALLBACK", paramBitmap }));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iload 11
    //   5: istore 10
    //   7: aload_0
    //   8: getfield 506	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Boolean	Z
    //   11: ifeq +261 -> 272
    //   14: aload_0
    //   15: invokespecial 507	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   23: ifnull +410 -> 433
    //   26: aload_0
    //   27: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   30: invokeinterface 509 1 0
    //   35: istore 6
    //   37: aload_0
    //   38: invokespecial 511	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()I
    //   41: istore 8
    //   43: iload 6
    //   45: istore 9
    //   47: aload_1
    //   48: astore_3
    //   49: ldc 103
    //   51: astore_2
    //   52: aload_0
    //   53: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   56: ifnull +366 -> 422
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   64: invokeinterface 512 1 0
    //   69: invokespecial 514	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	(I)I
    //   72: istore 6
    //   74: aload_2
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   80: invokeinterface 517 1 0
    //   85: astore 4
    //   87: aload 4
    //   89: ifnull +328 -> 417
    //   92: aload_2
    //   93: astore_1
    //   94: aload 4
    //   96: ldc -36
    //   98: invokevirtual 520	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: aload_2
    //   103: astore_1
    //   104: new 408	org/json/JSONObject
    //   107: dup
    //   108: aload 4
    //   110: ldc 8
    //   112: invokevirtual 520	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: invokespecial 521	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   118: astore 4
    //   120: aload 4
    //   122: astore_1
    //   123: aload_1
    //   124: ifnonnull +290 -> 414
    //   127: new 408	org/json/JSONObject
    //   130: dup
    //   131: invokespecial 419	org/json/JSONObject:<init>	()V
    //   134: astore_1
    //   135: iload 11
    //   137: istore 10
    //   139: aload_3
    //   140: ifnull +132 -> 272
    //   143: aload_0
    //   144: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   147: ifnull +292 -> 439
    //   150: aload_0
    //   151: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   154: invokeinterface 517 1 0
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull +156 -> 319
    //   166: aload 4
    //   168: ldc -21
    //   170: iconst_0
    //   171: invokevirtual 525	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   174: istore 7
    //   176: aload_0
    //   177: aload_3
    //   178: invokespecial 527	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   181: astore_3
    //   182: aload_3
    //   183: ifnull +152 -> 335
    //   186: aload_3
    //   187: invokevirtual 531	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   190: astore 4
    //   192: aload 4
    //   194: invokeinterface 536 1 0
    //   199: ifeq +136 -> 335
    //   202: aload 4
    //   204: invokeinterface 540 1 0
    //   209: checkcast 492	java/lang/String
    //   212: astore 5
    //   214: aload_1
    //   215: aload 5
    //   217: aload_3
    //   218: aload 5
    //   220: invokevirtual 543	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   223: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: goto -35 -> 192
    //   230: astore_2
    //   231: aload_2
    //   232: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   235: iload 11
    //   237: istore 10
    //   239: aload_1
    //   240: ifnull +32 -> 272
    //   243: aload_0
    //   244: ldc_w 545
    //   247: iconst_2
    //   248: anewarray 490	java/lang/Object
    //   251: dup
    //   252: iconst_0
    //   253: ldc -89
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: aload_1
    //   259: invokevirtual 546	org/json/JSONObject:toString	()Ljava/lang/String;
    //   262: aastore
    //   263: invokestatic 496	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   266: invokevirtual 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:callJs	(Ljava/lang/String;)V
    //   269: iconst_1
    //   270: istore 10
    //   272: iload 10
    //   274: ireturn
    //   275: astore_2
    //   276: aconst_null
    //   277: astore_1
    //   278: iconst_0
    //   279: istore 6
    //   281: aload_2
    //   282: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   285: iconst_0
    //   286: istore 8
    //   288: aload_1
    //   289: astore_3
    //   290: iload 6
    //   292: istore 9
    //   294: goto -245 -> 49
    //   297: astore_2
    //   298: ldc 103
    //   300: astore_1
    //   301: iconst_0
    //   302: istore 6
    //   304: aload_2
    //   305: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   308: aconst_null
    //   309: astore 4
    //   311: aload_1
    //   312: astore_2
    //   313: aload 4
    //   315: astore_1
    //   316: goto -193 -> 123
    //   319: iconst_0
    //   320: istore 7
    //   322: goto -146 -> 176
    //   325: astore 4
    //   327: aload 4
    //   329: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   332: goto +107 -> 439
    //   335: aload_1
    //   336: ldc 50
    //   338: iload 9
    //   340: sipush 1000
    //   343: idiv
    //   344: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   347: pop
    //   348: aload_1
    //   349: ldc 53
    //   351: iload 8
    //   353: sipush 1000
    //   356: idiv
    //   357: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   360: pop
    //   361: aload_1
    //   362: ldc 17
    //   364: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   367: ifne +11 -> 378
    //   370: aload_1
    //   371: ldc 17
    //   373: aload_2
    //   374: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   377: pop
    //   378: aload_1
    //   379: ldc 23
    //   381: iload 6
    //   383: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   386: pop
    //   387: aload_1
    //   388: ldc 94
    //   390: iload 7
    //   392: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   395: pop
    //   396: goto -161 -> 235
    //   399: astore_2
    //   400: goto -96 -> 304
    //   403: astore_2
    //   404: iconst_0
    //   405: istore 6
    //   407: goto -126 -> 281
    //   410: astore_2
    //   411: goto -130 -> 281
    //   414: goto -279 -> 135
    //   417: aconst_null
    //   418: astore_1
    //   419: goto -296 -> 123
    //   422: iconst_0
    //   423: istore 6
    //   425: aconst_null
    //   426: astore_1
    //   427: ldc 103
    //   429: astore_2
    //   430: goto -307 -> 123
    //   433: iconst_0
    //   434: istore 6
    //   436: goto -399 -> 37
    //   439: iconst_0
    //   440: istore 7
    //   442: goto -266 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	MusicGeneWebViewPlugin
    //   18	409	1	localObject1	Object
    //   51	52	2	str1	String
    //   230	2	2	localException1	Exception
    //   275	7	2	localException2	Exception
    //   297	8	2	localException3	Exception
    //   312	62	2	localObject2	Object
    //   399	1	2	localException4	Exception
    //   403	1	2	localException5	Exception
    //   410	1	2	localException6	Exception
    //   429	1	2	str2	String
    //   48	242	3	localObject3	Object
    //   85	229	4	localObject4	Object
    //   325	3	4	localException7	Exception
    //   212	7	5	str3	String
    //   35	400	6	i1	int
    //   174	267	7	i2	int
    //   41	316	8	i3	int
    //   45	299	9	i4	int
    //   5	268	10	bool1	boolean
    //   1	235	11	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   176	182	230	java/lang/Exception
    //   186	192	230	java/lang/Exception
    //   192	227	230	java/lang/Exception
    //   327	332	230	java/lang/Exception
    //   335	378	230	java/lang/Exception
    //   378	396	230	java/lang/Exception
    //   14	19	275	java/lang/Exception
    //   59	74	297	java/lang/Exception
    //   143	161	325	java/lang/Exception
    //   166	176	325	java/lang/Exception
    //   76	87	399	java/lang/Exception
    //   94	102	399	java/lang/Exception
    //   104	120	399	java/lang/Exception
    //   19	37	403	java/lang/Exception
    //   37	43	410	java/lang/Exception
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (localObject == null) {}
    }
    try
    {
      i1 = ((IQQPlayerService)localObject).e();
      int i2 = b(paramInt);
      localObject = new JSONObject();
      try
      {
        Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
        if (localBundle == null) {
          break label165;
        }
        paramInt = localBundle.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          paramInt = 0;
          continue;
          localRemoteException.put("code", "0");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      ((JSONObject)localObject).put("state", i2);
      ((JSONObject)localObject).put("index", i1);
      ((JSONObject)localObject).put("playType", paramInt);
      if (b())
      {
        ((JSONObject)localObject).put("code", "0");
        bool1 = bool2;
        if (localObject != null)
        {
          callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", new Object[] { "CALLPAGE_SONG_STATE_CHANGE", ((JSONObject)localObject).toString() }));
          bool1 = true;
        }
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
        int i1 = 0;
        continue;
        label165:
        paramInt = 0;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return bool1;
      }
      paramString = Uri.parse(paramString);
      String str = paramString.getScheme();
      if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str)))
      {
        paramString = paramString.getHost();
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString)) {
          return bool1;
        }
        if ((!paramString.contains("y.qq.com")) && (!paramString.contains("music.qq.com")))
        {
          bool1 = bool2;
          if (!paramString.contains("imgcache.gtimg.cn")) {
            return bool1;
          }
        }
      }
      else
      {
        QLog.e(x, 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic urlString is not url!");
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e(x, 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic exception: " + paramString);
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  private SongInfo[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (!paramJSONObject.has("list")) {
      return null;
    }
    JSONArray localJSONArray = paramJSONObject.getJSONArray("list");
    SongInfo[] arrayOfSongInfo = new SongInfo[localJSONArray.length()];
    int i1 = 0;
    if (i1 < localJSONArray.length())
    {
      Object localObject = (JSONObject)localJSONArray.get(i1);
      label81:
      String str1;
      label99:
      String str2;
      label117:
      String str3;
      label136:
      String str4;
      label155:
      String str5;
      label174:
      label193:
      SongInfo localSongInfo;
      if (localObject != null)
      {
        if (!((JSONObject)localObject).has("playUrl")) {
          break label282;
        }
        paramJSONObject = ((JSONObject)localObject).getString("playUrl");
        if (!((JSONObject)localObject).has("songPage")) {
          break label289;
        }
        str1 = ((JSONObject)localObject).getString("songPage");
        if (!((JSONObject)localObject).has("songId")) {
          break label296;
        }
        str2 = ((JSONObject)localObject).getString("songId");
        if (!((JSONObject)localObject).has("songName")) {
          break label303;
        }
        str3 = ((JSONObject)localObject).getString("songName");
        if (!((JSONObject)localObject).has("singerName")) {
          break label311;
        }
        str4 = ((JSONObject)localObject).getString("singerName");
        if (!((JSONObject)localObject).has("albumName")) {
          break label319;
        }
        str5 = ((JSONObject)localObject).getString("albumName");
        if (!((JSONObject)localObject).has("albumImg")) {
          break label327;
        }
        localObject = ((JSONObject)localObject).getString("albumImg");
        localSongInfo = new SongInfo();
        localSongInfo.b = str3;
        localSongInfo.jdField_a_of_type_JavaLangString = paramJSONObject;
        localSongInfo.c = str5;
        localSongInfo.d = ((String)localObject);
        localSongInfo.e = str1;
        if (!TextUtils.isEmpty(str2)) {
          break label335;
        }
      }
      label282:
      label289:
      label296:
      label303:
      label311:
      label319:
      label327:
      label335:
      for (long l1 = 0L;; l1 = Long.parseLong(str2))
      {
        localSongInfo.jdField_a_of_type_Long = l1;
        localSongInfo.f = str5;
        localSongInfo.g = str4;
        arrayOfSongInfo[i1] = localSongInfo;
        i1 += 1;
        break;
        paramJSONObject = "";
        break label81;
        str1 = "";
        break label99;
        str2 = "";
        break label117;
        str3 = "";
        break label136;
        str4 = "";
        break label155;
        str5 = "";
        break label174;
        localObject = "";
        break label193;
      }
    }
    return arrayOfSongInfo;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 4;
    case 3: 
      return 2;
    }
    return 64535;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null) {}
    try
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
      String str2 = a();
      bool1 = bool2;
      if (!TextUtils.isEmpty(str1))
      {
        boolean bool3 = str1.equals(str2);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  private void c()
  {
    callJs(String.format("try{qqmusicBridge.appTrigger('%s');}catch(e){}", new Object[] { "CALLPAGE_SHARE" }));
  }
  
  private boolean c()
  {
    return (1 == this.c) || (2 == this.c);
  }
  
  private void d()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.a();
        if ((localActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null))
        {
          localActivity.bindService(new Intent(localActivity, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
          QLog.e(x, 1, "MusicGeneWebViewPlugin.bindQQPlayerService end!");
          return;
        }
        QLog.e(x, 1, "MusicGeneWebViewPlugin.bindQQPlayerService activity is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(x, 1, "MusicGeneWebViewPlugin.bindQQPlayerService exception", localException);
      return;
    }
    QLog.e(x, 1, "MusicGeneWebViewPlugin.bindQQPlayerService mRuntime is null!");
  }
  
  private void e()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.a();
        if (localActivity != null) {
          localActivity.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934594L) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      Intent localIntent = new Intent("BROAD_CAST_UPDATE_TITLE");
      localIntent.putExtra("BUNDLE_KEY_URL", paramString);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.music.data.permission");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  /* Error */
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: new 703	java/util/ArrayList
    //   3: dup
    //   4: aload 5
    //   6: invokestatic 709	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   9: invokespecial 712	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   12: astore 8
    //   14: ldc -18
    //   16: aload_3
    //   17: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +2814 -> 2834
    //   23: ldc 110
    //   25: aload 4
    //   27: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +2610 -> 2640
    //   33: aload 8
    //   35: iconst_0
    //   36: invokevirtual 713	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   39: checkcast 492	java/lang/String
    //   42: astore_2
    //   43: new 408	org/json/JSONObject
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 521	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: ldc -11
    //   55: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   58: ifeq +103 -> 161
    //   61: aload_2
    //   62: ldc -11
    //   64: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore_3
    //   68: aload_2
    //   69: ldc 8
    //   71: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   74: ifeq +2855 -> 2929
    //   77: aload_2
    //   78: ldc 8
    //   80: invokevirtual 717	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +63 -> 148
    //   88: aload_2
    //   89: ldc 94
    //   91: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   94: ifeq +54 -> 148
    //   97: aload_0
    //   98: aload_2
    //   99: ldc 94
    //   101: invokevirtual 720	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   104: putfield 639	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	I
    //   107: ldc -95
    //   109: aload_3
    //   110: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: istore 23
    //   115: iload 23
    //   117: ifeq +86 -> 203
    //   120: getstatic 269	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:x	Ljava/lang/String;
    //   123: iconst_1
    //   124: ldc_w 722
    //   127: invokestatic 607	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_0
    //   131: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   134: ifnonnull +29 -> 163
    //   137: aload_0
    //   138: aload_1
    //   139: putfield 378	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener	Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;
    //   142: aload_0
    //   143: invokespecial 724	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	()V
    //   146: iconst_1
    //   147: ireturn
    //   148: aload_0
    //   149: iconst_0
    //   150: putfield 639	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	I
    //   153: goto -46 -> 107
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   161: iconst_1
    //   162: ireturn
    //   163: new 408	org/json/JSONObject
    //   166: dup
    //   167: invokespecial 419	org/json/JSONObject:<init>	()V
    //   170: astore_2
    //   171: aload_2
    //   172: ldc 26
    //   174: ldc 103
    //   176: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   179: pop
    //   180: aload_1
    //   181: aload_2
    //   182: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   185: goto -39 -> 146
    //   188: astore_1
    //   189: getstatic 269	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:x	Ljava/lang/String;
    //   192: iconst_1
    //   193: ldc_w 731
    //   196: aload_1
    //   197: invokestatic 670	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: goto -54 -> 146
    //   203: aload_0
    //   204: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   207: astore 9
    //   209: aload 9
    //   211: ifnonnull +5 -> 216
    //   214: iconst_0
    //   215: ireturn
    //   216: ldc 119
    //   218: aload_3
    //   219: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   222: ifeq +412 -> 634
    //   225: ldc 106
    //   227: astore_3
    //   228: aload_0
    //   229: aload_2
    //   230: invokespecial 733	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lorg/json/JSONObject;)[Lcom/tencent/mobileqq/music/SongInfo;
    //   233: astore 8
    //   235: aload 8
    //   237: ifnull +288 -> 525
    //   240: aload_2
    //   241: ldc 20
    //   243: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   246: ifeq +2677 -> 2923
    //   249: aload_2
    //   250: ldc 20
    //   252: invokevirtual 720	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   255: istore 12
    //   257: aload_2
    //   258: ldc 17
    //   260: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   263: ifeq +2654 -> 2917
    //   266: aload_2
    //   267: ldc 17
    //   269: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   272: astore_3
    //   273: aload_2
    //   274: ldc 14
    //   276: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   279: ifeq +2632 -> 2911
    //   282: aload_2
    //   283: ldc 14
    //   285: invokevirtual 736	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   288: lstore 17
    //   290: aload_2
    //   291: ldc 83
    //   293: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   296: ifeq +10 -> 306
    //   299: aload_2
    //   300: ldc 83
    //   302: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   305: pop
    //   306: aload_2
    //   307: ldc 11
    //   309: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   312: ifeq +2593 -> 2905
    //   315: aload_2
    //   316: ldc 11
    //   318: invokevirtual 617	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   321: astore 4
    //   323: lload 17
    //   325: invokestatic 740	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   328: astore 10
    //   330: aload_0
    //   331: invokespecial 382	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	()Z
    //   334: ifeq +215 -> 549
    //   337: aload_0
    //   338: getfield 684	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   341: aload_0
    //   342: getfield 643	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   345: invokevirtual 743	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   348: aload 10
    //   350: iconst_0
    //   351: invokestatic 746	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Z)Landroid/content/Intent;
    //   354: astore 5
    //   356: aload_2
    //   357: ldc 100
    //   359: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   362: ifeq +30 -> 392
    //   365: aload_2
    //   366: ldc 100
    //   368: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   371: astore 10
    //   373: aload 10
    //   375: invokestatic 572	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   378: ifne +14 -> 392
    //   381: aload 5
    //   383: ldc_w 748
    //   386: aload 10
    //   388: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   391: pop
    //   392: new 519	android/os/Bundle
    //   395: dup
    //   396: invokespecial 749	android/os/Bundle:<init>	()V
    //   399: astore 10
    //   401: aload 10
    //   403: ldc -39
    //   405: lload 17
    //   407: invokevirtual 753	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   410: aload 10
    //   412: ldc -36
    //   414: aload_3
    //   415: invokevirtual 757	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: aload 10
    //   420: ldc -21
    //   422: aload_0
    //   423: getfield 639	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	I
    //   426: invokevirtual 761	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   429: aload 4
    //   431: ifnull +15 -> 446
    //   434: aload 10
    //   436: ldc -24
    //   438: aload 4
    //   440: invokevirtual 762	org/json/JSONArray:toString	()Ljava/lang/String;
    //   443: invokevirtual 757	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload 10
    //   448: ldc 8
    //   450: aload_2
    //   451: invokevirtual 546	org/json/JSONObject:toString	()Ljava/lang/String;
    //   454: invokevirtual 757	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload 9
    //   459: aload 10
    //   461: invokeinterface 765 2 0
    //   466: aload 9
    //   468: aload_0
    //   469: getfield 290	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub	Lcom/tencent/mobileqq/music/IQQPlayerCallback$Stub;
    //   472: invokeinterface 768 2 0
    //   477: aload 5
    //   479: ifnull +12 -> 491
    //   482: aload 9
    //   484: aload 5
    //   486: invokeinterface 771 2 0
    //   491: aload_0
    //   492: invokespecial 382	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	()Z
    //   495: ifeq +119 -> 614
    //   498: aload 9
    //   500: bipush 102
    //   502: invokeinterface 774 2 0
    //   507: aload 9
    //   509: aload_0
    //   510: invokespecial 631	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Ljava/lang/String;
    //   513: aload 8
    //   515: iload 12
    //   517: invokeinterface 777 4 0
    //   522: ldc 103
    //   524: astore_3
    //   525: new 408	org/json/JSONObject
    //   528: dup
    //   529: invokespecial 419	org/json/JSONObject:<init>	()V
    //   532: astore_2
    //   533: aload_2
    //   534: ldc 26
    //   536: aload_3
    //   537: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   540: pop
    //   541: aload_1
    //   542: aload_2
    //   543: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   546: goto -385 -> 161
    //   549: new 650	android/content/Intent
    //   552: dup
    //   553: aload_0
    //   554: getfield 684	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   557: ldc_w 779
    //   560: invokespecial 655	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   563: astore 5
    //   565: ldc -78
    //   567: iconst_1
    //   568: anewarray 490	java/lang/Object
    //   571: dup
    //   572: iconst_0
    //   573: aload 10
    //   575: aastore
    //   576: invokestatic 496	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   579: astore 11
    //   581: aload 5
    //   583: ldc 14
    //   585: aload 10
    //   587: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   590: pop
    //   591: aload 5
    //   593: ldc_w 748
    //   596: aload 11
    //   598: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   601: pop
    //   602: aload 5
    //   604: ldc -27
    //   606: iconst_1
    //   607: invokevirtual 782	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   610: pop
    //   611: goto -255 -> 356
    //   614: aload 9
    //   616: bipush 103
    //   618: invokeinterface 774 2 0
    //   623: goto -116 -> 507
    //   626: astore_2
    //   627: aload_2
    //   628: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   631: goto -109 -> 522
    //   634: ldc 122
    //   636: aload_3
    //   637: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   640: ifeq +46 -> 686
    //   643: aload_0
    //   644: aload 9
    //   646: invokeinterface 509 1 0
    //   651: putfield 784	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Int	I
    //   654: aload 9
    //   656: invokeinterface 786 1 0
    //   661: new 408	org/json/JSONObject
    //   664: dup
    //   665: invokespecial 419	org/json/JSONObject:<init>	()V
    //   668: astore_2
    //   669: aload_2
    //   670: ldc 26
    //   672: ldc 103
    //   674: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   677: pop
    //   678: aload_1
    //   679: aload_2
    //   680: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   683: goto -522 -> 161
    //   686: ldc 125
    //   688: aload_3
    //   689: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   692: ifeq +35 -> 727
    //   695: aload 9
    //   697: invokeinterface 788 1 0
    //   702: new 408	org/json/JSONObject
    //   705: dup
    //   706: invokespecial 419	org/json/JSONObject:<init>	()V
    //   709: astore_2
    //   710: aload_2
    //   711: ldc 26
    //   713: ldc 103
    //   715: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   718: pop
    //   719: aload_1
    //   720: aload_2
    //   721: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   724: goto -563 -> 161
    //   727: ldc -128
    //   729: aload_3
    //   730: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   733: ifeq +35 -> 768
    //   736: aload 9
    //   738: invokeinterface 789 1 0
    //   743: new 408	org/json/JSONObject
    //   746: dup
    //   747: invokespecial 419	org/json/JSONObject:<init>	()V
    //   750: astore_2
    //   751: aload_2
    //   752: ldc 26
    //   754: ldc 103
    //   756: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   759: pop
    //   760: aload_1
    //   761: aload_2
    //   762: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   765: goto -604 -> 161
    //   768: ldc -125
    //   770: aload_3
    //   771: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   774: ifeq +35 -> 809
    //   777: aload 9
    //   779: invokeinterface 790 1 0
    //   784: new 408	org/json/JSONObject
    //   787: dup
    //   788: invokespecial 419	org/json/JSONObject:<init>	()V
    //   791: astore_2
    //   792: aload_2
    //   793: ldc 26
    //   795: ldc 103
    //   797: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   800: pop
    //   801: aload_1
    //   802: aload_2
    //   803: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   806: goto -645 -> 161
    //   809: ldc -122
    //   811: aload_3
    //   812: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   815: ifeq +35 -> 850
    //   818: aload 9
    //   820: invokeinterface 792 1 0
    //   825: new 408	org/json/JSONObject
    //   828: dup
    //   829: invokespecial 419	org/json/JSONObject:<init>	()V
    //   832: astore_2
    //   833: aload_2
    //   834: ldc 26
    //   836: ldc 103
    //   838: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   841: pop
    //   842: aload_1
    //   843: aload_2
    //   844: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   847: goto -686 -> 161
    //   850: ldc -119
    //   852: aload_3
    //   853: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   856: istore 23
    //   858: iload 23
    //   860: ifeq +411 -> 1271
    //   863: aconst_null
    //   864: astore_2
    //   865: aload 9
    //   867: invokeinterface 517 1 0
    //   872: astore_3
    //   873: aload_3
    //   874: ifnull +2026 -> 2900
    //   877: aload_3
    //   878: astore_2
    //   879: aload_3
    //   880: ldc 8
    //   882: invokevirtual 795	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   885: ifeq +2015 -> 2900
    //   888: aload_3
    //   889: astore_2
    //   890: new 408	org/json/JSONObject
    //   893: dup
    //   894: aload_3
    //   895: ldc 8
    //   897: invokevirtual 520	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   900: invokespecial 521	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   903: astore 4
    //   905: aload 4
    //   907: astore_2
    //   908: aload_3
    //   909: astore 4
    //   911: aload_2
    //   912: ifnonnull +1983 -> 2895
    //   915: new 408	org/json/JSONObject
    //   918: dup
    //   919: invokespecial 419	org/json/JSONObject:<init>	()V
    //   922: astore_3
    //   923: aload_0
    //   924: invokespecial 507	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   927: astore 8
    //   929: aload 4
    //   931: ifnull +2003 -> 2934
    //   934: aload 4
    //   936: ldc -21
    //   938: iconst_0
    //   939: invokevirtual 525	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   942: istore 12
    //   944: aload 4
    //   946: ifnull +1994 -> 2940
    //   949: aload 4
    //   951: ldc -39
    //   953: invokevirtual 795	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   956: ifeq +1984 -> 2940
    //   959: aload 4
    //   961: ldc -39
    //   963: invokevirtual 796	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   966: lstore 17
    //   968: aload 8
    //   970: ifnull +280 -> 1250
    //   973: aconst_null
    //   974: astore 5
    //   976: aload 5
    //   978: astore_2
    //   979: aload 4
    //   981: ifnull +49 -> 1030
    //   984: aload 5
    //   986: astore_2
    //   987: aload 4
    //   989: ldc -24
    //   991: invokevirtual 795	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   994: ifeq +36 -> 1030
    //   997: aload_0
    //   998: new 399	org/json/JSONArray
    //   1001: dup
    //   1002: aload 4
    //   1004: ldc -24
    //   1006: invokevirtual 520	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1009: invokespecial 797	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1012: invokespecial 799	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lorg/json/JSONArray;)Ljava/util/HashMap;
    //   1015: aload 8
    //   1017: getfield 430	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1020: invokestatic 740	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1023: invokevirtual 802	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1026: checkcast 408	org/json/JSONObject
    //   1029: astore_2
    //   1030: aload_2
    //   1031: ifnonnull +1861 -> 2892
    //   1034: aload_0
    //   1035: aload 8
    //   1037: invokespecial 527	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   1040: astore_2
    //   1041: aload_2
    //   1042: ifnull +60 -> 1102
    //   1045: aload_2
    //   1046: invokevirtual 531	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1049: astore 4
    //   1051: aload 4
    //   1053: invokeinterface 536 1 0
    //   1058: ifeq +44 -> 1102
    //   1061: aload 4
    //   1063: invokeinterface 540 1 0
    //   1068: checkcast 492	java/lang/String
    //   1071: astore 5
    //   1073: aload_3
    //   1074: aload 5
    //   1076: aload_2
    //   1077: aload 5
    //   1079: invokevirtual 543	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1082: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1085: pop
    //   1086: goto -35 -> 1051
    //   1089: astore_3
    //   1090: aload_3
    //   1091: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   1094: aload_2
    //   1095: astore 4
    //   1097: aconst_null
    //   1098: astore_2
    //   1099: goto -188 -> 911
    //   1102: aload_0
    //   1103: invokespecial 511	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()I
    //   1106: i2l
    //   1107: lstore 21
    //   1109: aload 9
    //   1111: invokeinterface 512 1 0
    //   1116: istore 13
    //   1118: aload_0
    //   1119: iload 13
    //   1121: invokespecial 514	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	(I)I
    //   1124: istore 14
    //   1126: iload 13
    //   1128: iconst_3
    //   1129: if_icmpne +96 -> 1225
    //   1132: aload_0
    //   1133: getfield 784	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Int	I
    //   1136: i2l
    //   1137: lstore 19
    //   1139: aload_0
    //   1140: invokespecial 560	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	()Z
    //   1143: ifeq +95 -> 1238
    //   1146: aload_3
    //   1147: ldc 26
    //   1149: ldc 103
    //   1151: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1154: pop
    //   1155: aload_3
    //   1156: ldc 50
    //   1158: lload 19
    //   1160: ldc2_w 172
    //   1163: ldiv
    //   1164: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1167: pop
    //   1168: aload_3
    //   1169: ldc 53
    //   1171: lload 21
    //   1173: ldc2_w 172
    //   1176: ldiv
    //   1177: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1180: pop
    //   1181: aload_3
    //   1182: ldc 23
    //   1184: iload 14
    //   1186: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1189: pop
    //   1190: aload_3
    //   1191: ldc 94
    //   1193: iload 12
    //   1195: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1198: pop
    //   1199: aload_3
    //   1200: ldc 14
    //   1202: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1205: ifne +12 -> 1217
    //   1208: aload_3
    //   1209: ldc 14
    //   1211: lload 17
    //   1213: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1216: pop
    //   1217: aload_1
    //   1218: aload_3
    //   1219: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1222: goto -1061 -> 161
    //   1225: aload 9
    //   1227: invokeinterface 509 1 0
    //   1232: i2l
    //   1233: lstore 19
    //   1235: goto -96 -> 1139
    //   1238: aload_3
    //   1239: ldc 26
    //   1241: ldc 103
    //   1243: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1246: pop
    //   1247: goto -92 -> 1155
    //   1250: aload_3
    //   1251: ldc 26
    //   1253: ldc 106
    //   1255: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1258: pop
    //   1259: aload_3
    //   1260: ldc 94
    //   1262: iload 12
    //   1264: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1267: pop
    //   1268: goto -69 -> 1199
    //   1271: ldc -116
    //   1273: aload_3
    //   1274: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1277: istore 23
    //   1279: iload 23
    //   1281: ifeq +510 -> 1791
    //   1284: aconst_null
    //   1285: astore_2
    //   1286: aload 9
    //   1288: invokeinterface 517 1 0
    //   1293: astore_3
    //   1294: aload_3
    //   1295: ifnull +1592 -> 2887
    //   1298: aload_3
    //   1299: astore_2
    //   1300: aload_3
    //   1301: ldc 8
    //   1303: invokevirtual 795	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1306: ifeq +1581 -> 2887
    //   1309: aload_3
    //   1310: astore_2
    //   1311: new 408	org/json/JSONObject
    //   1314: dup
    //   1315: aload_3
    //   1316: ldc 8
    //   1318: invokevirtual 520	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1321: invokespecial 521	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1324: astore 4
    //   1326: aload 4
    //   1328: astore_2
    //   1329: aload_3
    //   1330: astore 5
    //   1332: aload_2
    //   1333: ifnonnull +1548 -> 2881
    //   1336: new 408	org/json/JSONObject
    //   1339: dup
    //   1340: invokespecial 419	org/json/JSONObject:<init>	()V
    //   1343: astore 4
    //   1345: aload 5
    //   1347: ifnull +1612 -> 2959
    //   1350: aload 5
    //   1352: ldc -21
    //   1354: iconst_0
    //   1355: invokevirtual 525	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1358: istore 15
    //   1360: aload 5
    //   1362: ifnull +1603 -> 2965
    //   1365: aload 5
    //   1367: ldc -39
    //   1369: invokevirtual 795	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1372: ifeq +1593 -> 2965
    //   1375: aload 5
    //   1377: ldc -39
    //   1379: invokevirtual 796	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1382: lstore 17
    //   1384: aconst_null
    //   1385: astore 8
    //   1387: ldc 103
    //   1389: astore_3
    //   1390: aload 5
    //   1392: ifnull +1483 -> 2875
    //   1395: aload 5
    //   1397: ldc -36
    //   1399: invokevirtual 795	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1402: ifeq +1569 -> 2971
    //   1405: aload 5
    //   1407: ldc -36
    //   1409: invokevirtual 520	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1412: astore_2
    //   1413: aload_2
    //   1414: astore_3
    //   1415: aload 5
    //   1417: ldc -24
    //   1419: invokevirtual 795	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1422: ifeq +1453 -> 2875
    //   1425: new 399	org/json/JSONArray
    //   1428: dup
    //   1429: aload 5
    //   1431: ldc -24
    //   1433: invokevirtual 520	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1436: invokespecial 797	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1439: astore 5
    //   1441: aload_2
    //   1442: astore_3
    //   1443: aload 5
    //   1445: astore_2
    //   1446: iconst_0
    //   1447: istore 16
    //   1449: iconst_0
    //   1450: istore 14
    //   1452: iconst_0
    //   1453: istore 12
    //   1455: iconst_0
    //   1456: istore 13
    //   1458: aload_2
    //   1459: ifnonnull +239 -> 1698
    //   1462: new 399	org/json/JSONArray
    //   1465: dup
    //   1466: invokespecial 803	org/json/JSONArray:<init>	()V
    //   1469: astore_2
    //   1470: aload 9
    //   1472: invokeinterface 806 1 0
    //   1477: astore 5
    //   1479: aload_0
    //   1480: invokespecial 507	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1483: astore 8
    //   1485: iload 12
    //   1487: istore 14
    //   1489: aload 5
    //   1491: ifnull +1486 -> 2977
    //   1494: iconst_0
    //   1495: istore 12
    //   1497: iload 13
    //   1499: istore 14
    //   1501: iload 12
    //   1503: aload 5
    //   1505: arraylength
    //   1506: if_icmpge +1471 -> 2977
    //   1509: aload 5
    //   1511: iload 12
    //   1513: aaload
    //   1514: astore 10
    //   1516: iload 13
    //   1518: istore 14
    //   1520: aload 10
    //   1522: ifnull +1424 -> 2946
    //   1525: aload_2
    //   1526: iload 12
    //   1528: aload_0
    //   1529: aload 10
    //   1531: invokespecial 527	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   1534: invokevirtual 809	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1537: pop
    //   1538: iload 13
    //   1540: istore 14
    //   1542: aload 8
    //   1544: ifnull +1402 -> 2946
    //   1547: iload 13
    //   1549: istore 14
    //   1551: aload 10
    //   1553: getfield 430	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1556: aload 8
    //   1558: getfield 430	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1561: lcmp
    //   1562: ifne +1384 -> 2946
    //   1565: iload 12
    //   1567: istore 14
    //   1569: goto +1377 -> 2946
    //   1572: astore_3
    //   1573: aload_3
    //   1574: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   1577: aload_2
    //   1578: astore 5
    //   1580: aconst_null
    //   1581: astore_2
    //   1582: goto -250 -> 1332
    //   1585: aload 4
    //   1587: ldc 20
    //   1589: iload 14
    //   1591: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1594: pop
    //   1595: aload 4
    //   1597: ldc 23
    //   1599: aload_0
    //   1600: aload 9
    //   1602: invokeinterface 512 1 0
    //   1607: invokespecial 514	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	(I)I
    //   1610: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1613: pop
    //   1614: aload 4
    //   1616: ldc 17
    //   1618: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1621: ifne +12 -> 1633
    //   1624: aload 4
    //   1626: ldc 17
    //   1628: aload_3
    //   1629: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1632: pop
    //   1633: aload 4
    //   1635: ldc 11
    //   1637: aload_2
    //   1638: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1641: pop
    //   1642: aload_0
    //   1643: invokespecial 560	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	()Z
    //   1646: ifeq +132 -> 1778
    //   1649: aload 4
    //   1651: ldc 26
    //   1653: ldc 103
    //   1655: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1658: pop
    //   1659: aload 4
    //   1661: ldc 14
    //   1663: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1666: ifne +13 -> 1679
    //   1669: aload 4
    //   1671: ldc 14
    //   1673: lload 17
    //   1675: invokevirtual 433	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1678: pop
    //   1679: aload 4
    //   1681: ldc 94
    //   1683: iload 15
    //   1685: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1688: pop
    //   1689: aload_1
    //   1690: aload 4
    //   1692: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1695: goto -1534 -> 161
    //   1698: aload 9
    //   1700: invokeinterface 806 1 0
    //   1705: astore 5
    //   1707: aload_0
    //   1708: invokespecial 507	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1711: astore 8
    //   1713: aload 5
    //   1715: ifnull +1157 -> 2872
    //   1718: iconst_0
    //   1719: istore 12
    //   1721: iload 16
    //   1723: istore 13
    //   1725: iload 13
    //   1727: istore 14
    //   1729: iload 12
    //   1731: aload 5
    //   1733: arraylength
    //   1734: if_icmpge +1138 -> 2872
    //   1737: aload 5
    //   1739: iload 12
    //   1741: aaload
    //   1742: astore 10
    //   1744: iload 13
    //   1746: istore 14
    //   1748: aload 10
    //   1750: ifnull +1230 -> 2980
    //   1753: iload 13
    //   1755: istore 14
    //   1757: aload 10
    //   1759: getfield 430	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1762: aload 8
    //   1764: getfield 430	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1767: lcmp
    //   1768: ifne +1212 -> 2980
    //   1771: iload 12
    //   1773: istore 14
    //   1775: goto +1205 -> 2980
    //   1778: aload 4
    //   1780: ldc 26
    //   1782: ldc 103
    //   1784: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1787: pop
    //   1788: goto -129 -> 1659
    //   1791: ldc -113
    //   1793: aload_3
    //   1794: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1797: ifeq +74 -> 1871
    //   1800: bipush 103
    //   1802: istore 13
    //   1804: iload 13
    //   1806: istore 12
    //   1808: aload_2
    //   1809: ifnull +24 -> 1833
    //   1812: iload 13
    //   1814: istore 12
    //   1816: aload_2
    //   1817: ldc 56
    //   1819: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1822: ifeq +11 -> 1833
    //   1825: aload_2
    //   1826: ldc 56
    //   1828: invokevirtual 720	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1831: istore 12
    //   1833: aload 9
    //   1835: aload_0
    //   1836: iload 12
    //   1838: invokespecial 811	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(I)I
    //   1841: invokeinterface 774 2 0
    //   1846: new 408	org/json/JSONObject
    //   1849: dup
    //   1850: invokespecial 419	org/json/JSONObject:<init>	()V
    //   1853: astore_2
    //   1854: aload_2
    //   1855: ldc 26
    //   1857: ldc 103
    //   1859: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1862: pop
    //   1863: aload_1
    //   1864: aload_2
    //   1865: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1868: goto -1707 -> 161
    //   1871: ldc -110
    //   1873: aload_3
    //   1874: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1877: ifeq +104 -> 1981
    //   1880: aload_2
    //   1881: ifnull +985 -> 2866
    //   1884: aload_2
    //   1885: ldc 59
    //   1887: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1890: ifeq +976 -> 2866
    //   1893: aload_2
    //   1894: ldc 59
    //   1896: invokevirtual 720	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1899: istore 12
    //   1901: new 408	org/json/JSONObject
    //   1904: dup
    //   1905: invokespecial 419	org/json/JSONObject:<init>	()V
    //   1908: astore_3
    //   1909: aload_0
    //   1910: getfield 684	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1913: astore_2
    //   1914: aload_2
    //   1915: ifnull +945 -> 2860
    //   1918: iload 12
    //   1920: iflt +940 -> 2860
    //   1923: iload 12
    //   1925: bipush 100
    //   1927: if_icmpgt +933 -> 2860
    //   1930: aload_2
    //   1931: ldc_w 813
    //   1934: invokevirtual 816	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1937: checkcast 818	android/media/AudioManager
    //   1940: astore_2
    //   1941: aload_2
    //   1942: ifnull +918 -> 2860
    //   1945: aload_2
    //   1946: iconst_3
    //   1947: aload_2
    //   1948: iconst_3
    //   1949: invokevirtual 821	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   1952: iload 12
    //   1954: imul
    //   1955: bipush 100
    //   1957: idiv
    //   1958: iconst_4
    //   1959: invokevirtual 825	android/media/AudioManager:setStreamVolume	(III)V
    //   1962: ldc 103
    //   1964: astore_2
    //   1965: aload_3
    //   1966: ldc 26
    //   1968: aload_2
    //   1969: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1972: pop
    //   1973: aload_1
    //   1974: aload_3
    //   1975: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1978: goto -1817 -> 161
    //   1981: ldc -104
    //   1983: aload_3
    //   1984: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1987: ifeq +187 -> 2174
    //   1990: aload_2
    //   1991: ifnull +140 -> 2131
    //   1994: aload_2
    //   1995: ldc 62
    //   1997: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2000: ifeq +131 -> 2131
    //   2003: aload_2
    //   2004: ldc 62
    //   2006: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2009: astore_3
    //   2010: aload_2
    //   2011: ldc 97
    //   2013: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2016: ifeq +122 -> 2138
    //   2019: aload_2
    //   2020: ldc 97
    //   2022: invokevirtual 720	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2025: istore 12
    //   2027: aload_3
    //   2028: invokestatic 830	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   2031: astore_2
    //   2032: new 832	java/io/File
    //   2035: dup
    //   2036: new 832	java/io/File
    //   2039: dup
    //   2040: new 476	java/lang/StringBuilder
    //   2043: dup
    //   2044: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   2047: getstatic 837	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   2050: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: getstatic 840	java/io/File:separator	Ljava/lang/String;
    //   2056: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2059: ldc_w 842
    //   2062: invokevirtual 483	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: invokevirtual 486	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2068: invokespecial 843	java/io/File:<init>	(Ljava/lang/String;)V
    //   2071: aload_2
    //   2072: invokespecial 846	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   2075: astore_2
    //   2076: aload_2
    //   2077: ifnull +10 -> 2087
    //   2080: aload_2
    //   2081: invokevirtual 849	java/io/File:exists	()Z
    //   2084: ifne +60 -> 2144
    //   2087: new 851	tgj
    //   2090: dup
    //   2091: aload_0
    //   2092: aload_3
    //   2093: iload 12
    //   2095: aload_2
    //   2096: invokespecial 854	tgj:<init>	(Lcom/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin;Ljava/lang/String;ILjava/io/File;)V
    //   2099: bipush 8
    //   2101: aconst_null
    //   2102: iconst_1
    //   2103: invokestatic 859	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2106: new 408	org/json/JSONObject
    //   2109: dup
    //   2110: invokespecial 419	org/json/JSONObject:<init>	()V
    //   2113: astore_2
    //   2114: aload_2
    //   2115: ldc 26
    //   2117: ldc 103
    //   2119: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2122: pop
    //   2123: aload_1
    //   2124: aload_2
    //   2125: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2128: goto -1967 -> 161
    //   2131: ldc_w 391
    //   2134: astore_3
    //   2135: goto -125 -> 2010
    //   2138: iconst_0
    //   2139: istore 12
    //   2141: goto -114 -> 2027
    //   2144: aload_0
    //   2145: aload_2
    //   2146: invokevirtual 862	java/io/File:getPath	()Ljava/lang/String;
    //   2149: invokestatic 865	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   2152: invokespecial 504	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Landroid/graphics/Bitmap;)V
    //   2155: goto -49 -> 2106
    //   2158: astore_2
    //   2159: aload_2
    //   2160: invokevirtual 362	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2163: goto -57 -> 2106
    //   2166: astore_2
    //   2167: aload_2
    //   2168: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   2171: goto -65 -> 2106
    //   2174: ldc -107
    //   2176: aload_3
    //   2177: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2180: ifeq +103 -> 2283
    //   2183: aload_0
    //   2184: getfield 684	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2187: astore_2
    //   2188: new 408	org/json/JSONObject
    //   2191: dup
    //   2192: invokespecial 419	org/json/JSONObject:<init>	()V
    //   2195: astore_3
    //   2196: aload_2
    //   2197: ifnull +657 -> 2854
    //   2200: aload_2
    //   2201: ldc_w 813
    //   2204: invokevirtual 816	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2207: checkcast 818	android/media/AudioManager
    //   2210: astore_2
    //   2211: aload_2
    //   2212: ifnull +642 -> 2854
    //   2215: aload_2
    //   2216: iconst_3
    //   2217: invokevirtual 821	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   2220: i2f
    //   2221: fstore 6
    //   2223: aload_2
    //   2224: iconst_3
    //   2225: invokevirtual 868	android/media/AudioManager:getStreamVolume	(I)I
    //   2228: i2f
    //   2229: fstore 7
    //   2231: fload 7
    //   2233: f2i
    //   2234: istore 12
    //   2236: fload 6
    //   2238: fconst_0
    //   2239: fcmpl
    //   2240: ifle +15 -> 2255
    //   2243: fload 7
    //   2245: fload 6
    //   2247: fdiv
    //   2248: ldc_w 869
    //   2251: fmul
    //   2252: f2i
    //   2253: istore 12
    //   2255: aload_3
    //   2256: ldc 59
    //   2258: iload 12
    //   2260: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2263: pop
    //   2264: ldc 103
    //   2266: astore_2
    //   2267: aload_3
    //   2268: ldc 26
    //   2270: aload_2
    //   2271: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2274: pop
    //   2275: aload_1
    //   2276: aload_3
    //   2277: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2280: goto -2119 -> 161
    //   2283: ldc -101
    //   2285: aload_3
    //   2286: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2289: ifeq +168 -> 2457
    //   2292: aload_2
    //   2293: ldc 65
    //   2295: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2298: astore 4
    //   2300: aload_2
    //   2301: ldc 68
    //   2303: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2306: astore 5
    //   2308: aload_2
    //   2309: ldc 62
    //   2311: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2314: astore 8
    //   2316: aload_2
    //   2317: ldc 71
    //   2319: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2322: astore 9
    //   2324: aload_2
    //   2325: ldc 74
    //   2327: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2330: astore 10
    //   2332: ldc -81
    //   2334: astore_3
    //   2335: aload_2
    //   2336: ldc 80
    //   2338: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2341: ifeq +10 -> 2351
    //   2344: aload_2
    //   2345: ldc 80
    //   2347: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2350: astore_3
    //   2351: aload_0
    //   2352: getfield 684	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2355: ifnull +77 -> 2432
    //   2358: new 650	android/content/Intent
    //   2361: dup
    //   2362: ldc -69
    //   2364: invokespecial 685	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2367: astore_2
    //   2368: aload_2
    //   2369: ldc -60
    //   2371: aload 4
    //   2373: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2376: pop
    //   2377: aload_2
    //   2378: ldc -57
    //   2380: aload 5
    //   2382: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2385: pop
    //   2386: aload_2
    //   2387: ldc -54
    //   2389: aload 8
    //   2391: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2394: pop
    //   2395: aload_2
    //   2396: ldc -51
    //   2398: aload 9
    //   2400: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2403: pop
    //   2404: aload_2
    //   2405: ldc -48
    //   2407: aload 10
    //   2409: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2412: pop
    //   2413: aload_2
    //   2414: ldc -42
    //   2416: aload_3
    //   2417: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2420: pop
    //   2421: aload_0
    //   2422: getfield 684	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2425: aload_2
    //   2426: ldc_w 691
    //   2429: invokevirtual 697	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2432: new 408	org/json/JSONObject
    //   2435: dup
    //   2436: invokespecial 419	org/json/JSONObject:<init>	()V
    //   2439: astore_2
    //   2440: aload_2
    //   2441: ldc 26
    //   2443: ldc 103
    //   2445: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2448: pop
    //   2449: aload_1
    //   2450: aload_2
    //   2451: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2454: goto -2293 -> 161
    //   2457: ldc -98
    //   2459: aload_3
    //   2460: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2463: ifeq -2302 -> 161
    //   2466: aload_2
    //   2467: ldc 65
    //   2469: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2472: astore 4
    //   2474: aload_2
    //   2475: ldc 68
    //   2477: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2480: astore 5
    //   2482: aload_2
    //   2483: ldc 62
    //   2485: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2488: astore 8
    //   2490: aload_2
    //   2491: ldc 71
    //   2493: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2496: astore 9
    //   2498: aload_2
    //   2499: ldc 77
    //   2501: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2504: ifeq +342 -> 2846
    //   2507: aload_2
    //   2508: ldc 77
    //   2510: invokevirtual 736	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   2513: lstore 17
    //   2515: ldc -81
    //   2517: astore_3
    //   2518: aload_2
    //   2519: ldc 80
    //   2521: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2524: ifeq +10 -> 2534
    //   2527: aload_2
    //   2528: ldc 80
    //   2530: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2533: astore_3
    //   2534: aload_0
    //   2535: getfield 684	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2538: ifnull +77 -> 2615
    //   2541: new 650	android/content/Intent
    //   2544: dup
    //   2545: ldc -72
    //   2547: invokespecial 685	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2550: astore_2
    //   2551: aload_2
    //   2552: ldc -60
    //   2554: aload 4
    //   2556: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2559: pop
    //   2560: aload_2
    //   2561: ldc -57
    //   2563: aload 5
    //   2565: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2568: pop
    //   2569: aload_2
    //   2570: ldc -54
    //   2572: aload 8
    //   2574: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2577: pop
    //   2578: aload_2
    //   2579: ldc -51
    //   2581: aload 9
    //   2583: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2586: pop
    //   2587: aload_2
    //   2588: ldc -45
    //   2590: lload 17
    //   2592: invokevirtual 872	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2595: pop
    //   2596: aload_2
    //   2597: ldc -42
    //   2599: aload_3
    //   2600: invokevirtual 689	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2603: pop
    //   2604: aload_0
    //   2605: getfield 684	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2608: aload_2
    //   2609: ldc_w 691
    //   2612: invokevirtual 697	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2615: new 408	org/json/JSONObject
    //   2618: dup
    //   2619: invokespecial 419	org/json/JSONObject:<init>	()V
    //   2622: astore_2
    //   2623: aload_2
    //   2624: ldc 26
    //   2626: ldc 103
    //   2628: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2631: pop
    //   2632: aload_1
    //   2633: aload_2
    //   2634: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2637: goto -2476 -> 161
    //   2640: ldc 113
    //   2642: aload 4
    //   2644: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2647: ifeq +174 -> 2821
    //   2650: aload 8
    //   2652: iconst_0
    //   2653: invokevirtual 713	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2656: checkcast 492	java/lang/String
    //   2659: astore_2
    //   2660: new 408	org/json/JSONObject
    //   2663: dup
    //   2664: aload_2
    //   2665: invokespecial 521	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2668: astore_3
    //   2669: aconst_null
    //   2670: astore_2
    //   2671: aload_3
    //   2672: ldc -11
    //   2674: invokevirtual 553	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2677: ifeq +10 -> 2687
    //   2680: aload_3
    //   2681: ldc -11
    //   2683: invokevirtual 412	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2686: astore_2
    //   2687: aload_0
    //   2688: getfield 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   2691: invokeinterface 517 1 0
    //   2696: astore_3
    //   2697: aload_3
    //   2698: ifnull +299 -> 2997
    //   2701: aload_3
    //   2702: ldc -21
    //   2704: iconst_0
    //   2705: invokevirtual 525	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2708: istore 12
    //   2710: ldc -92
    //   2712: aload_2
    //   2713: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2716: ifeq +57 -> 2773
    //   2719: aload_0
    //   2720: iconst_1
    //   2721: putfield 556	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_Boolean	Z
    //   2724: new 408	org/json/JSONObject
    //   2727: dup
    //   2728: invokespecial 419	org/json/JSONObject:<init>	()V
    //   2731: astore_2
    //   2732: aload_2
    //   2733: ldc 94
    //   2735: iload 12
    //   2737: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2740: pop
    //   2741: aload_2
    //   2742: ldc 26
    //   2744: ldc 103
    //   2746: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2749: pop
    //   2750: aload_1
    //   2751: aload_2
    //   2752: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2755: aload_0
    //   2756: invokespecial 873	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()V
    //   2759: goto -2598 -> 161
    //   2762: astore_3
    //   2763: aload_3
    //   2764: invokevirtual 374	java/lang/Exception:printStackTrace	()V
    //   2767: iconst_0
    //   2768: istore 12
    //   2770: goto -60 -> 2710
    //   2773: ldc -89
    //   2775: aload_2
    //   2776: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2779: ifeq -2618 -> 161
    //   2782: aload_0
    //   2783: iconst_1
    //   2784: putfield 506	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Boolean	Z
    //   2787: new 408	org/json/JSONObject
    //   2790: dup
    //   2791: invokespecial 419	org/json/JSONObject:<init>	()V
    //   2794: astore_2
    //   2795: aload_2
    //   2796: ldc 94
    //   2798: iload 12
    //   2800: invokevirtual 549	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2803: pop
    //   2804: aload_2
    //   2805: ldc 26
    //   2807: ldc 103
    //   2809: invokevirtual 426	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2812: pop
    //   2813: aload_1
    //   2814: aload_2
    //   2815: invokevirtual 729	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2818: goto -2657 -> 161
    //   2821: ldc 116
    //   2823: aload 4
    //   2825: invokevirtual 635	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2828: ifeq -2667 -> 161
    //   2831: goto -2670 -> 161
    //   2834: aload_0
    //   2835: aload_1
    //   2836: aload_2
    //   2837: aload_3
    //   2838: aload 4
    //   2840: aload 5
    //   2842: invokespecial 875	com/tencent/mobileqq/webview/swift/WebViewPlugin:handleJsRequest	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   2845: ireturn
    //   2846: ldc2_w 85
    //   2849: lstore 17
    //   2851: goto -336 -> 2515
    //   2854: ldc 106
    //   2856: astore_2
    //   2857: goto -590 -> 2267
    //   2860: ldc 106
    //   2862: astore_2
    //   2863: goto -898 -> 1965
    //   2866: iconst_0
    //   2867: istore 12
    //   2869: goto -968 -> 1901
    //   2872: goto -1287 -> 1585
    //   2875: aload 8
    //   2877: astore_2
    //   2878: goto -1432 -> 1446
    //   2881: aload_2
    //   2882: astore 4
    //   2884: goto -1539 -> 1345
    //   2887: aconst_null
    //   2888: astore_2
    //   2889: goto -1560 -> 1329
    //   2892: goto -1851 -> 1041
    //   2895: aload_2
    //   2896: astore_3
    //   2897: goto -1974 -> 923
    //   2900: aconst_null
    //   2901: astore_2
    //   2902: goto -1994 -> 908
    //   2905: aconst_null
    //   2906: astore 4
    //   2908: goto -2585 -> 323
    //   2911: lconst_0
    //   2912: lstore 17
    //   2914: goto -2624 -> 290
    //   2917: ldc 103
    //   2919: astore_3
    //   2920: goto -2647 -> 273
    //   2923: iconst_0
    //   2924: istore 12
    //   2926: goto -2669 -> 257
    //   2929: aconst_null
    //   2930: astore_2
    //   2931: goto -2847 -> 84
    //   2934: iconst_0
    //   2935: istore 12
    //   2937: goto -1993 -> 944
    //   2940: lconst_0
    //   2941: lstore 17
    //   2943: goto -1975 -> 968
    //   2946: iload 12
    //   2948: iconst_1
    //   2949: iadd
    //   2950: istore 12
    //   2952: iload 14
    //   2954: istore 13
    //   2956: goto -1459 -> 1497
    //   2959: iconst_0
    //   2960: istore 15
    //   2962: goto -1602 -> 1360
    //   2965: lconst_0
    //   2966: lstore 17
    //   2968: goto -1584 -> 1384
    //   2971: ldc 103
    //   2973: astore_2
    //   2974: goto -1561 -> 1413
    //   2977: goto -1392 -> 1585
    //   2980: iload 12
    //   2982: iconst_1
    //   2983: iadd
    //   2984: istore 12
    //   2986: iload 14
    //   2988: istore 13
    //   2990: goto -1265 -> 1725
    //   2993: astore_1
    //   2994: goto -2833 -> 161
    //   2997: iconst_0
    //   2998: istore 12
    //   3000: goto -290 -> 2710
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3003	0	this	MusicGeneWebViewPlugin
    //   0	3003	1	paramJsBridgeListener	JsBridgeListener
    //   0	3003	2	paramString1	String
    //   0	3003	3	paramString2	String
    //   0	3003	4	paramString3	String
    //   0	3003	5	paramVarArgs	String[]
    //   2221	25	6	f1	float
    //   2229	15	7	f2	float
    //   12	2864	8	localObject1	Object
    //   207	2375	9	localObject2	Object
    //   328	2080	10	localObject3	Object
    //   579	18	11	str	String
    //   255	2744	12	i1	int
    //   1116	1873	13	i2	int
    //   1124	1863	14	i3	int
    //   1358	1603	15	i4	int
    //   1447	275	16	i5	int
    //   288	2679	17	l1	long
    //   1137	97	19	l2	long
    //   1107	65	21	l3	long
    //   113	1167	23	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   43	84	156	java/lang/Exception
    //   88	107	156	java/lang/Exception
    //   107	115	156	java/lang/Exception
    //   148	153	156	java/lang/Exception
    //   189	200	156	java/lang/Exception
    //   203	209	156	java/lang/Exception
    //   216	225	156	java/lang/Exception
    //   228	235	156	java/lang/Exception
    //   240	257	156	java/lang/Exception
    //   257	273	156	java/lang/Exception
    //   273	290	156	java/lang/Exception
    //   290	306	156	java/lang/Exception
    //   306	323	156	java/lang/Exception
    //   323	356	156	java/lang/Exception
    //   356	392	156	java/lang/Exception
    //   392	429	156	java/lang/Exception
    //   434	446	156	java/lang/Exception
    //   446	457	156	java/lang/Exception
    //   525	546	156	java/lang/Exception
    //   549	611	156	java/lang/Exception
    //   627	631	156	java/lang/Exception
    //   634	683	156	java/lang/Exception
    //   686	724	156	java/lang/Exception
    //   727	765	156	java/lang/Exception
    //   768	806	156	java/lang/Exception
    //   809	847	156	java/lang/Exception
    //   850	858	156	java/lang/Exception
    //   915	923	156	java/lang/Exception
    //   923	929	156	java/lang/Exception
    //   934	944	156	java/lang/Exception
    //   949	968	156	java/lang/Exception
    //   987	1030	156	java/lang/Exception
    //   1034	1041	156	java/lang/Exception
    //   1045	1051	156	java/lang/Exception
    //   1051	1086	156	java/lang/Exception
    //   1090	1094	156	java/lang/Exception
    //   1102	1126	156	java/lang/Exception
    //   1132	1139	156	java/lang/Exception
    //   1139	1155	156	java/lang/Exception
    //   1155	1199	156	java/lang/Exception
    //   1199	1217	156	java/lang/Exception
    //   1217	1222	156	java/lang/Exception
    //   1225	1235	156	java/lang/Exception
    //   1238	1247	156	java/lang/Exception
    //   1250	1268	156	java/lang/Exception
    //   1271	1279	156	java/lang/Exception
    //   1336	1345	156	java/lang/Exception
    //   1350	1360	156	java/lang/Exception
    //   1365	1384	156	java/lang/Exception
    //   1395	1413	156	java/lang/Exception
    //   1415	1441	156	java/lang/Exception
    //   1462	1485	156	java/lang/Exception
    //   1501	1509	156	java/lang/Exception
    //   1525	1538	156	java/lang/Exception
    //   1551	1565	156	java/lang/Exception
    //   1573	1577	156	java/lang/Exception
    //   1585	1633	156	java/lang/Exception
    //   1633	1659	156	java/lang/Exception
    //   1659	1679	156	java/lang/Exception
    //   1679	1695	156	java/lang/Exception
    //   1698	1713	156	java/lang/Exception
    //   1729	1737	156	java/lang/Exception
    //   1757	1771	156	java/lang/Exception
    //   1778	1788	156	java/lang/Exception
    //   1791	1800	156	java/lang/Exception
    //   1816	1833	156	java/lang/Exception
    //   1833	1868	156	java/lang/Exception
    //   1871	1880	156	java/lang/Exception
    //   1884	1901	156	java/lang/Exception
    //   1901	1914	156	java/lang/Exception
    //   1930	1941	156	java/lang/Exception
    //   1945	1962	156	java/lang/Exception
    //   1965	1978	156	java/lang/Exception
    //   1981	1990	156	java/lang/Exception
    //   1994	2010	156	java/lang/Exception
    //   2010	2027	156	java/lang/Exception
    //   2027	2076	156	java/lang/Exception
    //   2080	2087	156	java/lang/Exception
    //   2087	2106	156	java/lang/Exception
    //   2106	2128	156	java/lang/Exception
    //   2159	2163	156	java/lang/Exception
    //   2167	2171	156	java/lang/Exception
    //   2174	2196	156	java/lang/Exception
    //   2200	2211	156	java/lang/Exception
    //   2215	2231	156	java/lang/Exception
    //   2243	2255	156	java/lang/Exception
    //   2255	2264	156	java/lang/Exception
    //   2267	2280	156	java/lang/Exception
    //   2283	2332	156	java/lang/Exception
    //   2335	2351	156	java/lang/Exception
    //   2351	2432	156	java/lang/Exception
    //   2432	2454	156	java/lang/Exception
    //   2457	2515	156	java/lang/Exception
    //   2518	2534	156	java/lang/Exception
    //   2534	2615	156	java/lang/Exception
    //   2615	2637	156	java/lang/Exception
    //   120	146	188	java/lang/Exception
    //   163	185	188	java/lang/Exception
    //   457	477	626	java/lang/Exception
    //   482	491	626	java/lang/Exception
    //   491	507	626	java/lang/Exception
    //   507	522	626	java/lang/Exception
    //   614	623	626	java/lang/Exception
    //   865	873	1089	java/lang/Exception
    //   879	888	1089	java/lang/Exception
    //   890	905	1089	java/lang/Exception
    //   1286	1294	1572	java/lang/Exception
    //   1300	1309	1572	java/lang/Exception
    //   1311	1326	1572	java/lang/Exception
    //   2144	2155	2158	java/lang/OutOfMemoryError
    //   2144	2155	2166	java/lang/Exception
    //   2687	2697	2762	java/lang/Exception
    //   2701	2710	2762	java/lang/Exception
    //   2660	2669	2993	org/json/JSONException
    //   2671	2687	2993	org/json/JSONException
    //   2687	2697	2993	org/json/JSONException
    //   2701	2710	2993	org/json/JSONException
    //   2710	2759	2993	org/json/JSONException
    //   2763	2767	2993	org/json/JSONException
    //   2773	2818	2993	org/json/JSONException
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null) && (a(paramString1))) {
        d();
      }
      return super.handleSchemaRequest(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(x, 1, "MusicGeneWebViewPlugin.handleSchemaRequest exception", localException);
      }
    }
  }
  
  public void onCreate()
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {
      this.jdField_a_of_type_AndroidContentContext = localActivity.getApplicationContext();
    }
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    for (;;)
    {
      try
      {
        b();
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
          if (localObject == null) {}
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i1;
        QLog.e(x, 1, "MusicGeneWebViewPlugin.onCreate exception", localException);
        continue;
      }
      try
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
        if ((i1 == 2) || (i1 == 3)) {}
        try
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
          if ((localObject != null) && (((String)localObject).startsWith("music_gene_"))) {
            this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.c();
          }
        }
        catch (RemoteException localRemoteException2)
        {
          localRemoteException2.printStackTrace();
          continue;
        }
        a(4);
        e();
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentContext = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = null;
        super.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        localRemoteException1.printStackTrace();
        i1 = 4;
      }
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (paramCustomWebView != null) {}
    label123:
    for (;;)
    {
      try
      {
        paramCustomWebView = paramCustomWebView.getUrl();
        if (!TextUtils.isEmpty(paramCustomWebView)) {
          break label123;
        }
        WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
        if ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
          break label123;
        }
        paramCustomWebView = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).getCurrentUrl();
        if (this.jdField_a_of_type_AndroidContentContext == null) {
          break;
        }
        if (a(paramCustomWebView)) {
          d();
        }
        paramCustomWebView = new IntentFilter();
        paramCustomWebView.addAction("BROAD_CAST_CALL_PAGE_SHARE");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramCustomWebView);
        return;
      }
      catch (Exception paramCustomWebView)
      {
        QLog.e(x, 1, "MusicGeneWebViewPlugin.onCreate exception", paramCustomWebView);
        return;
      }
      paramCustomWebView = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\musicgene\MusicGeneWebViewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */