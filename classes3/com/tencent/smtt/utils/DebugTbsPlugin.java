package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class DebugTbsPlugin
{
  private static final String DEBUGVIEW_CLASS_NAME = "com.tencent.tbs.debug.plugin.DebugView";
  public static final String DEBUG_PLUGIN_APK = "DebugPlugin.apk";
  public static final String DEBUG_PLUGIN_TBS = "DebugPlugin.tbs";
  private static final String DEBUG_TBS_PLUGIN_PATH = "http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs";
  private static final String LOGTAG = "debugtbs";
  public static final String SCHEME_DEBUG_TBS = "http://debugtbs.qq.com";
  private static final String TBS_DEBUG_FOLDER_NAME = "debugtbs";
  private static final String TBS_PLUGIN_APK_SIG = "308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d";
  private static Looper downloadThreadLooper = null;
  private static DexClassLoader mDexLoader = null;
  private static DebugTbsPlugin mInstance = null;
  public String mDebugPluginPath = "";
  
  private DebugTbsPlugin(Context paramContext)
  {
    this.mDebugPluginPath = (paramContext.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin");
  }
  
  @SuppressLint({"NewApi"})
  public static void downloadDebugTbsPlugin(String paramString, final DebugDownloadStatusListener paramDebugDownloadStatusListener)
  {
    new Thread()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore_1
        //   5: aconst_null
        //   6: astore_2
        //   7: aconst_null
        //   8: astore 5
        //   10: new 27	java/net/URL
        //   13: dup
        //   14: ldc 29
        //   16: invokespecial 32	java/net/URL:<init>	(Ljava/lang/String;)V
        //   19: invokevirtual 36	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   22: checkcast 38	java/net/HttpURLConnection
        //   25: astore_3
        //   26: aload_3
        //   27: invokevirtual 42	java/net/HttpURLConnection:getContentLength	()I
        //   30: istore 8
        //   32: aload_3
        //   33: sipush 5000
        //   36: invokevirtual 46	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   39: aload_3
        //   40: invokevirtual 49	java/net/HttpURLConnection:connect	()V
        //   43: aload_3
        //   44: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   47: astore_3
        //   48: aload 5
        //   50: astore 4
        //   52: aload_2
        //   53: astore_1
        //   54: aload_3
        //   55: astore_2
        //   56: new 55	java/io/File
        //   59: dup
        //   60: aload_0
        //   61: getfield 16	com/tencent/smtt/utils/DebugTbsPlugin$2:val$path	Ljava/lang/String;
        //   64: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
        //   67: invokestatic 62	com/tencent/smtt/utils/FileUtil:openOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
        //   70: astore 5
        //   72: aload 5
        //   74: astore 4
        //   76: aload 5
        //   78: astore_1
        //   79: aload_3
        //   80: astore_2
        //   81: sipush 1024
        //   84: newarray <illegal type>
        //   86: astore 6
        //   88: iconst_0
        //   89: istore 7
        //   91: aload 5
        //   93: astore 4
        //   95: aload 5
        //   97: astore_1
        //   98: aload_3
        //   99: astore_2
        //   100: aload_3
        //   101: aload 6
        //   103: invokevirtual 68	java/io/InputStream:read	([B)I
        //   106: istore 9
        //   108: iload 9
        //   110: ifle +109 -> 219
        //   113: iload 7
        //   115: iload 9
        //   117: iadd
        //   118: istore 7
        //   120: aload 5
        //   122: astore 4
        //   124: aload 5
        //   126: astore_1
        //   127: aload_3
        //   128: astore_2
        //   129: aload 5
        //   131: aload 6
        //   133: iconst_0
        //   134: iload 9
        //   136: invokevirtual 74	java/io/OutputStream:write	([BII)V
        //   139: aload 5
        //   141: astore 4
        //   143: aload 5
        //   145: astore_1
        //   146: aload_3
        //   147: astore_2
        //   148: iload 7
        //   150: bipush 100
        //   152: imul
        //   153: iload 8
        //   155: idiv
        //   156: istore 9
        //   158: aload 5
        //   160: astore 4
        //   162: aload 5
        //   164: astore_1
        //   165: aload_3
        //   166: astore_2
        //   167: aload_0
        //   168: getfield 18	com/tencent/smtt/utils/DebugTbsPlugin$2:val$listener	Lcom/tencent/smtt/utils/DebugTbsPlugin$DebugDownloadStatusListener;
        //   171: iload 9
        //   173: invokeinterface 79 2 0
        //   178: goto -87 -> 91
        //   181: astore 5
        //   183: aload 4
        //   185: astore_1
        //   186: aload_3
        //   187: astore_2
        //   188: aload 5
        //   190: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   193: aload 4
        //   195: astore_1
        //   196: aload_3
        //   197: astore_2
        //   198: aload_0
        //   199: getfield 18	com/tencent/smtt/utils/DebugTbsPlugin$2:val$listener	Lcom/tencent/smtt/utils/DebugTbsPlugin$DebugDownloadStatusListener;
        //   202: aload 5
        //   204: invokeinterface 86 2 0
        //   209: aload_3
        //   210: invokevirtual 89	java/io/InputStream:close	()V
        //   213: aload 4
        //   215: invokevirtual 90	java/io/OutputStream:close	()V
        //   218: return
        //   219: aload 5
        //   221: astore 4
        //   223: aload 5
        //   225: astore_1
        //   226: aload_3
        //   227: astore_2
        //   228: aload_0
        //   229: getfield 18	com/tencent/smtt/utils/DebugTbsPlugin$2:val$listener	Lcom/tencent/smtt/utils/DebugTbsPlugin$DebugDownloadStatusListener;
        //   232: invokeinterface 93 1 0
        //   237: aload_3
        //   238: invokevirtual 89	java/io/InputStream:close	()V
        //   241: aload 5
        //   243: invokevirtual 90	java/io/OutputStream:close	()V
        //   246: return
        //   247: astore_1
        //   248: aload_1
        //   249: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   252: return
        //   253: astore_3
        //   254: aconst_null
        //   255: astore_2
        //   256: aload_2
        //   257: invokevirtual 89	java/io/InputStream:close	()V
        //   260: aload_1
        //   261: invokevirtual 90	java/io/OutputStream:close	()V
        //   264: aload_3
        //   265: athrow
        //   266: astore_2
        //   267: aload_2
        //   268: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   271: goto -11 -> 260
        //   274: astore_1
        //   275: aload_1
        //   276: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   279: goto -15 -> 264
        //   282: astore_1
        //   283: aload_1
        //   284: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   287: goto -74 -> 213
        //   290: astore_1
        //   291: goto -43 -> 248
        //   294: astore_1
        //   295: aload_1
        //   296: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   299: goto -58 -> 241
        //   302: astore_3
        //   303: goto -47 -> 256
        //   306: astore 5
        //   308: aconst_null
        //   309: astore_3
        //   310: goto -127 -> 183
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	313	0	this	2
        //   4	222	1	localObject1	Object
        //   247	14	1	localException1	Exception
        //   274	2	1	localException2	Exception
        //   282	2	1	localException3	Exception
        //   290	1	1	localException4	Exception
        //   294	2	1	localException5	Exception
        //   6	251	2	localObject2	Object
        //   266	2	2	localException6	Exception
        //   25	213	3	localObject3	Object
        //   253	12	3	localObject4	Object
        //   302	1	3	localObject5	Object
        //   309	1	3	localObject6	Object
        //   1	221	4	localObject7	Object
        //   8	155	5	localFileOutputStream	java.io.FileOutputStream
        //   181	61	5	localException7	Exception
        //   306	1	5	localException8	Exception
        //   86	46	6	arrayOfByte	byte[]
        //   89	64	7	i	int
        //   30	126	8	j	int
        //   106	66	9	k	int
        // Exception table:
        //   from	to	target	type
        //   56	72	181	java/lang/Exception
        //   81	88	181	java/lang/Exception
        //   100	108	181	java/lang/Exception
        //   129	139	181	java/lang/Exception
        //   148	158	181	java/lang/Exception
        //   167	178	181	java/lang/Exception
        //   228	237	181	java/lang/Exception
        //   241	246	247	java/lang/Exception
        //   10	48	253	finally
        //   256	260	266	java/lang/Exception
        //   260	264	274	java/lang/Exception
        //   209	213	282	java/lang/Exception
        //   213	218	290	java/lang/Exception
        //   237	241	294	java/lang/Exception
        //   56	72	302	finally
        //   81	88	302	finally
        //   100	108	302	finally
        //   129	139	302	finally
        //   148	158	302	finally
        //   167	178	302	finally
        //   188	193	302	finally
        //   198	209	302	finally
        //   228	237	302	finally
        //   10	48	306	java/lang/Exception
      }
    }.start();
  }
  
  public static DebugTbsPlugin getInstance(Context paramContext)
  {
    if (mInstance == null) {
      mInstance = new DebugTbsPlugin(paramContext);
    }
    return mInstance;
  }
  
  public void downloadPlugin(final String paramString, final WebView paramWebView, final Context paramContext)
  {
    final RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    final TextView localTextView = new TextView(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localTextView.setText("加载中，请稍后...");
    localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    paramWebView.addView(localRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.mDebugPluginPath + File.separator + "DebugPlugin.tbs";
    FileUtil.delete(new File((String)localObject));
    downloadDebugTbsPlugin((String)localObject, new DebugDownloadStatusListener()
    {
      public void onDownloadFailure(Throwable paramAnonymousThrowable)
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(DebugTbsPlugin.1.this.val$context, "下载失败，请检查网络", 0).show();
          }
        });
      }
      
      public void onDownloadProgress(final int paramAnonymousInt)
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            DebugTbsPlugin.1.this.val$tvDownloadProgress.setText("已下载" + paramAnonymousInt + "%");
          }
        });
      }
      
      public void onDownloadSuccess()
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(DebugTbsPlugin.1.this.val$context, "下载成功", 0).show();
            DebugTbsPlugin.1.this.val$layout.setVisibility(4);
            DebugTbsPlugin.this.showPluginView(DebugTbsPlugin.1.this.val$url, DebugTbsPlugin.1.this.val$webview, DebugTbsPlugin.1.this.val$context, DebugTbsPlugin.downloadThreadLooper);
          }
        });
      }
    });
  }
  
  @SuppressLint({"NewApi"})
  public void showPluginView(String paramString, WebView paramWebView, Context paramContext, Looper paramLooper)
  {
    TbsLog.i("debugtbs", "showPluginView -- url: " + paramString + "; webview: " + paramWebView + "; context: " + paramContext);
    Object localObject1 = this.mDebugPluginPath + File.separator + "DebugPlugin.tbs";
    Object localObject2 = this.mDebugPluginPath + File.separator + "DebugPlugin.apk";
    Object localObject3 = new File((String)localObject1);
    localObject1 = new File((String)localObject2);
    downloadThreadLooper = paramLooper;
    if (((File)localObject3).exists())
    {
      ((File)localObject1).delete();
      ((File)localObject3).renameTo((File)localObject1);
    }
    if (!((File)localObject1).exists())
    {
      TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
      downloadPlugin(paramString, paramWebView, paramContext);
      return;
    }
    try
    {
      localObject4 = AppUtil.getSignatureFromApk(paramContext, new File((String)localObject2));
      if (!"308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(localObject4))
      {
        TbsLog.e("debugtbs", "verifyPlugin apk: " + (String)localObject2 + " signature failed - sig: " + (String)localObject4);
        Toast.makeText(paramContext, "插件校验失败，请重试", 0).show();
        ((File)localObject3).delete();
        ((File)localObject1).delete();
        return;
      }
    }
    catch (Exception paramString)
    {
      FileUtil.delete((File)localObject1);
      paramString.printStackTrace();
      return;
    }
    localObject3 = this.mDebugPluginPath + File.separator + "opt";
    Object localObject4 = new File((String)localObject3);
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdirs();
    }
    if (mDexLoader == null) {
      mDexLoader = new DexClassLoader((String)localObject2, (String)localObject3, null, paramContext.getClassLoader());
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("url", paramString);
    ((Map)localObject2).put("tbs_version", "" + WebView.getTbsSDKVersion(paramContext));
    ((Map)localObject2).put("tbs_core_version", "" + WebView.getTbsCoreVersion(paramContext));
    if (downloadThreadLooper != null) {
      ((Map)localObject2).put("looper", paramLooper);
    }
    paramString = mDexLoader.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[] { Context.class, Map.class }).newInstance(new Object[] { paramContext, localObject2 });
    if ((paramString instanceof FrameLayout))
    {
      paramString = (FrameLayout)paramString;
      paramWebView.addView(paramString, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("debugtbs", "show " + paramString + " successful in " + paramWebView);
      return;
    }
    TbsLog.e("debugtbs", "get debugview failure: " + paramString);
  }
  
  public static abstract interface DebugDownloadStatusListener
  {
    public abstract void onDownloadFailure(Throwable paramThrowable);
    
    public abstract void onDownloadProgress(int paramInt);
    
    public abstract void onDownloadSuccess();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\DebugTbsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */