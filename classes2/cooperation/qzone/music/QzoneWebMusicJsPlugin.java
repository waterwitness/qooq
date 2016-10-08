package cooperation.qzone.music;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import ymt;
import ymu;
import ymv;
import ymw;
import ymx;
import ymy;
import ymz;
import yna;
import ynb;
import ync;
import ynd;
import yne;
import ynf;
import yng;
import ynh;
import ynj;
import ynk;
import ynl;

public class QzoneWebMusicJsPlugin
  extends WebViewPlugin
  implements WebEventListener
{
  public static final String CONFIG_MOBINET_TIPS = "qzbg_music_mobinet_tips";
  public static final String EVENT_BUFFERING = "buffering";
  public static final String EVENT_BUTTON_CLICK = "buttonclick";
  public static final String EVENT_CANCEL = "cancel";
  public static final String EVENT_ERROR = "error";
  public static final String EVENT_FINISH = "finish";
  public static final String EVENT_GET_NETWORKE_TYPE = "networktype";
  public static final String EVENT_GET_PLAY_MODE = "playmode";
  public static final String EVENT_GET_SONGINFO = "songinfo";
  public static final String EVENT_PAUSED = "paused";
  public static final String EVENT_PLAYING = "playing";
  public static final String EVENT_STOP = "stop";
  public static final String EVENT_UNKOWN = "unknow";
  public static final String MUSIC_METHOD_NAMESPACE = "QzMusic";
  public static final String WEB_APP_MUSIC_EVENT = "WEBAPP_MUSIC";
  private String TAG;
  private boolean isAutoPlay;
  public boolean isFlowWarningVisible;
  private boolean isRandom;
  private boolean isShowing;
  private boolean isUseRemoteMusicManager;
  private boolean isWebPageListening;
  
  public QzoneWebMusicJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.TAG = QzoneWebMusicJsPlugin.class.getSimpleName();
    this.mPluginNameSpace = "QzMusic";
  }
  
  private void callNetWorkInterface(String paramString)
  {
    if (!this.isDestroy) {
      this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"networktype\",data:{type:\"isUnicomNetwork\",value:" + paramString + "}})}catch(e){}");
    }
  }
  
  private void callWebPageInterface(String paramString)
  {
    if ((this.isWebPageListening) && (!this.isDestroy)) {
      this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + paramString + "\"}})}catch(e){}");
    }
  }
  
  private void callWebPageInterface(String paramString, Bundle paramBundle)
  {
    JSONObject localJSONObject;
    if (this.isWebPageListening) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("uin", getCurrentHostUin());
      if (paramBundle != null)
      {
        SongInfo localSongInfo = (SongInfo)paramBundle.getParcelable("param.song");
        if (localSongInfo != null)
        {
          localJSONObject.put("name", localSongInfo.jdField_b_of_type_JavaLangString);
          localJSONObject.put("singer", localSongInfo.g);
          localJSONObject.put("songId", localSongInfo.jdField_a_of_type_Long);
          localJSONObject.put("singerId", localSongInfo.jdField_b_of_type_Long);
          localJSONObject.put("type", localSongInfo.jdField_a_of_type_Int);
          localJSONObject.put("cover", localSongInfo.d);
          localJSONObject.put("playUrl", localSongInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("detailUrl", localSongInfo.e);
        }
        localJSONObject.put("state", getStateString(paramBundle.getInt("param.state", -1)));
        localJSONObject.put("total", paramBundle.getInt("param.duration"));
        localJSONObject.put("curr", paramBundle.getInt("param.currentTime"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        bool = false;
        continue;
        bool = false;
      }
    }
    if (paramBundle != null) {}
    try
    {
      if (paramBundle.getInt("param.playModeRandom", 0) != 1) {
        break label316;
      }
      bool = true;
      this.isRandom = bool;
      if (paramBundle.getInt("param.playModeAuto", 0) != 1) {
        break label322;
      }
      bool = true;
      this.isAutoPlay = bool;
      localJSONObject.put("randomMode", this.isRandom);
      localJSONObject.put("autoModeWithWifi", this.isAutoPlay);
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        boolean bool;
        paramBundle.printStackTrace();
      }
    }
    if (!this.isDestroy) {
      this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + paramString + "\",value:" + localJSONObject.toString() + "}})}catch(e){}");
    }
  }
  
  private static SongInfo convertSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.jdField_b_of_type_JavaLangString = getString(paramJSONObject, "name");
    localSongInfo.g = getString(paramJSONObject, "singer");
    localSongInfo.jdField_a_of_type_Long = getLong(paramJSONObject, "songId");
    localSongInfo.jdField_a_of_type_JavaLangString = getString(paramJSONObject, "playUrl");
    localSongInfo.jdField_a_of_type_Int = getInt(paramJSONObject, "type");
    localSongInfo.d = getString(paramJSONObject, "cover");
    localSongInfo.jdField_b_of_type_Long = getLong(paramJSONObject, "singerId");
    localSongInfo.f = getString(paramJSONObject, "album");
    localSongInfo.e = getString(paramJSONObject, "detailUrl");
    return localSongInfo;
  }
  
  private void doSetPlayMode(int paramInt1, int paramInt2)
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new ynb(this, paramInt1, paramInt2));
  }
  
  private long getCurrentHostUin()
  {
    try
    {
      String str = Uri.parse(this.mRuntime.a().getUrl()).getQueryParameter("guestuin");
      if (str == null) {
        return this.mRuntime.a().getLongAccountUin();
      }
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "illegal guestuin");
      }
    }
    return 10000L;
  }
  
  private static int getInt(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getInt " + paramJSONObject.getMessage());
    }
    return 0;
  }
  
  private static long getLong(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      long l = paramJSONObject.getLong(paramString);
      return l;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getLong " + paramJSONObject.getMessage());
    }
    return 0L;
  }
  
  private String getStateString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknow";
    case 1: 
      return "buffering";
    case 2: 
      return "playing";
    case 3: 
      return "paused";
    case 4: 
    case 6: 
      return "stop";
    }
    return "error";
  }
  
  private static String getString(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("QzoneWebMusicJsPlugin", 2, "getString " + paramJSONObject.getMessage());
    }
    return null;
  }
  
  private boolean needPlayTips()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (NetworkState.b())
    {
      bool1 = bool2;
      if (!LocalMultiProcConfig.a("qzbg_music_mobinet_tips", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean needSetAutoPlayTips()
  {
    return BaseApplication.getContext().getSharedPreferences("share", 0).getBoolean("qzone_bg_music_auto_play_warn_flag", true);
  }
  
  private static final void showAutoPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = DialogUtil.a(paramContext, 230, "", "打开后，wifi环境下访问自己和好友的空间将自动播放背景音乐", "取消", "知道了", paramOnClickListener2, paramOnClickListener1);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
  }
  
  private static final void showPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DialogUtil.a(paramContext, 230, "流量提示", "你正处于非WiFi环境，继续播放将会消耗流量，运营商可能会收取费用，是否继续\n", "继续", "取消", paramOnClickListener2, paramOnClickListener1).show();
  }
  
  public void getPlayMode()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new ymx(this));
  }
  
  public void getPlayingSongInfo()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new ymv(this));
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMusic")) {}
    do
    {
      return false;
      if ((paramString3.equals("playMusic")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
      {
        paramJsBridgeListener = this.mRuntime.a();
        if ((paramJsBridgeListener != null) && (needPlayTips()))
        {
          showPlayTips(paramJsBridgeListener, new ymt(this, paramVarArgs), new yne(this));
          this.isFlowWarningVisible = true;
        }
        for (;;)
        {
          return true;
          playMusic(paramVarArgs[0]);
        }
      }
      if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
      {
        paramJsBridgeListener = this.mRuntime.a();
        if ((paramJsBridgeListener != null) && (needPlayTips()))
        {
          showPlayTips(paramJsBridgeListener, new ynf(this, paramVarArgs), new yng(this));
          this.isFlowWarningVisible = true;
        }
        for (;;)
        {
          return true;
          playMusicList(paramVarArgs[0]);
        }
      }
      if (paramString3.equals("resumePlay"))
      {
        resumePlay();
        return true;
      }
      if (paramString3.equals("pausePlay"))
      {
        pausePlay();
        return true;
      }
      if ((paramString3.equals("listenMusicState")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        listenMusicState(paramVarArgs[0]);
        return true;
      }
      if (paramString3.equals("musicListChange"))
      {
        musicListChange();
        return true;
      }
      if ((paramString3.equals("setPlayMode")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        setPlayMode(paramVarArgs[0]);
        return true;
      }
      if ((paramString3.equals("setRightButton")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        setRightButton(paramVarArgs[0]);
        return true;
      }
      if (paramString3.equals("getPlayingSongInfo"))
      {
        getPlayingSongInfo();
        return true;
      }
      if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        playMusicList(paramVarArgs[0]);
        return true;
      }
      if (paramString3.equals("getPlayMode"))
      {
        getPlayMode();
        return true;
      }
    } while (!paramString3.equals("getNetworkType"));
    if (NetworkState.e()) {
      callNetWorkInterface("true");
    }
    for (;;)
    {
      return true;
      callNetWorkInterface("false");
    }
  }
  
  public void listenMusicState(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("isOpen");
      if (i == 1)
      {
        this.isWebPageListening = true;
        RemoteHandleManager.a().a(this);
        this.isUseRemoteMusicManager = true;
        return;
      }
      if (i == 0)
      {
        this.isWebPageListening = false;
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void musicListChange()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new ymu(this));
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.isWebPageListening) {
      RemoteHandleManager.a().a(this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.a().b(this);
    if (this.isUseRemoteMusicManager) {
      RemoteHandleManager.a().a();
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("data");
          if (paramBundle != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.TAG, 2, "call js function,bundle is empty");
        return;
        String str = getStateString(paramBundle.getInt("param.state", -1));
        if (!paramString.equals("cmd.notifyStateCallback")) {
          break;
        }
        callWebPageInterface(str, paramBundle);
        bool = paramBundle.getBoolean("param.needPlayTips");
        paramString = this.mRuntime.a();
      } while ((paramString == null) || (paramString.isFinishing()) || (this.isShowing) || (!bool) || (!needPlayTips()));
      pausePlay();
      showPlayTips(paramString, new ync(this), new ynd(this));
      this.isShowing = true;
      return;
      if (paramString.equals("cmd.getPlayMode"))
      {
        callWebPageInterface("playmode", paramBundle);
        return;
      }
    } while (!paramString.equals("cmd.getPlayingSong"));
    callWebPageInterface("songinfo", paramBundle);
  }
  
  public void pausePlay()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new ynk(this));
  }
  
  public void playMusic(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(convertSongInfo(new JSONObject(paramString)));
      if (localArrayList.size() > 0)
      {
        this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new ynh(this, localArrayList));
        return;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.TAG, 2, "song info error");
    }
  }
  
  /* Error */
  public void playMusicList(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 567	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 568	java/util/ArrayList:<init>	()V
    //   10: astore_2
    //   11: new 147	org/json/JSONObject
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 499	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: ldc_w 587
    //   24: invokevirtual 327	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   27: istore_3
    //   28: aload_1
    //   29: ldc_w 589
    //   32: invokevirtual 593	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   35: astore_1
    //   36: iload_3
    //   37: istore 5
    //   39: iload 4
    //   41: aload_1
    //   42: invokevirtual 598	org/json/JSONArray:length	()I
    //   45: if_icmpge +36 -> 81
    //   48: aload_2
    //   49: aload_1
    //   50: iload 4
    //   52: invokevirtual 602	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   55: invokestatic 570	cooperation/qzone/music/QzoneWebMusicJsPlugin:convertSongInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/music/SongInfo;
    //   58: invokevirtual 573	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   61: pop
    //   62: iload 4
    //   64: iconst_1
    //   65: iadd
    //   66: istore 4
    //   68: goto -32 -> 36
    //   71: astore_1
    //   72: iconst_0
    //   73: istore_3
    //   74: aload_1
    //   75: invokevirtual 583	org/json/JSONException:printStackTrace	()V
    //   78: iload_3
    //   79: istore 5
    //   81: aload_2
    //   82: invokevirtual 577	java/util/ArrayList:size	()I
    //   85: ifle +31 -> 116
    //   88: aload_0
    //   89: getfield 111	cooperation/qzone/music/QzoneWebMusicJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   92: invokevirtual 274	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   95: ldc 2
    //   97: invokevirtual 279	com/tencent/common/app/AppInterface:a	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   100: new 604	yni
    //   103: dup
    //   104: aload_0
    //   105: iload 5
    //   107: aload_2
    //   108: invokespecial 607	yni:<init>	(Lcooperation/qzone/music/QzoneWebMusicJsPlugin;ILjava/util/ArrayList;)V
    //   111: invokevirtual 289	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   114: pop
    //   115: return
    //   116: invokestatic 319	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq -4 -> 115
    //   122: aload_0
    //   123: getfield 77	cooperation/qzone/music/QzoneWebMusicJsPlugin:TAG	Ljava/lang/String;
    //   126: iconst_2
    //   127: ldc_w 609
    //   130: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: return
    //   134: astore_1
    //   135: goto -61 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	QzoneWebMusicJsPlugin
    //   0	138	1	paramString	String
    //   10	98	2	localArrayList	ArrayList
    //   27	52	3	i	int
    //   1	66	4	j	int
    //   37	69	5	k	int
    // Exception table:
    //   from	to	target	type
    //   11	28	71	org/json/JSONException
    //   28	36	134	org/json/JSONException
    //   39	62	134	org/json/JSONException
  }
  
  public void resumePlay()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new ynj(this));
  }
  
  public void setPlayMode(String paramString)
  {
    int j = 0;
    int k;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        bool = paramString.getBoolean("randomMode");
        if (bool) {
          i = 1;
        }
      }
      catch (JSONException paramString)
      {
        boolean bool;
        i = 0;
      }
      try
      {
        bool = paramString.getBoolean("autoModeWithWifi");
        k = i;
        if (bool)
        {
          j = 1;
          k = i;
        }
        bool = needSetAutoPlayTips();
        if ((j != 1) || (this.isAutoPlay) || (!bool)) {
          break;
        }
        showAutoPlayTips(this.mRuntime.a(), new ymy(this), new ymz(this, k, j), new yna(this));
        return;
      }
      catch (JSONException paramString)
      {
        for (;;) {}
      }
      int i = 0;
      continue;
      paramString.printStackTrace();
      k = i;
    }
    doSetPlayMode(k, j);
  }
  
  public void setRightButton(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("text");
      String str = ((JSONObject)localObject).getString("color");
      boolean bool = ((JSONObject)localObject).getBoolean("visible");
      if ((this.mRuntime.a() instanceof QQBrowserActivity))
      {
        localObject = (TextView)this.mRuntime.a().findViewById(2131297183);
        if (bool) {}
        try
        {
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextColor(Color.parseColor("#" + str));
          ((TextView)localObject).setText(paramString);
          ((TextView)localObject).setOnClickListener(new ymw(this));
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            break label144;
          }
          QLog.e(this.TAG, 2, "set right textview error");
          paramString.printStackTrace();
          return;
        }
        ((TextView)localObject).setVisibility(8);
        return;
      }
    }
    catch (Exception paramString)
    {
      label144:
      paramString.printStackTrace();
    }
  }
  
  public void stopPlay()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new ynl(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\music\QzoneWebMusicJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */