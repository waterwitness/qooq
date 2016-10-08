package com.tencent.mobileqq.music;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.MusicCacheManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;
import mqq.os.MqqHandler;
import tfs;
import tft;
import tfu;
import tfv;
import tfw;
import tfx;
import tfy;
import tfz;
import tga;
import tgb;
import tgc;

public class QQPlayerService
  extends Service
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Constants.PlayMode, Constants.PlayState
{
  public static long a = 0L;
  private static Intent jdField_a_of_type_AndroidContentIntent;
  private static MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  private static SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  public static final String a = "QQPlayerService";
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private static SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  public static long b = 0L;
  public static final String b = "musicplayer.action";
  private static WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  public static final String c = "musicplayer.isDelFileOnDonwloadThreadOver";
  public static final String d = "qqplayer_exit_action";
  private static boolean d = Utils.a();
  public static final String e = "musicplayer.song";
  private static String f;
  private static final String g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/qqmusic/";
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 4;
  public static final int m = 5;
  public static final int n = 6;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 5;
  public static final int t = 6;
  private static int u = 0;
  private static int v = 0;
  private static int w = 0;
  private static int y = 0;
  private static final int z = 4000;
  public float a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private volatile Looper jdField_a_of_type_AndroidOsLooper;
  private RemoteCallbackList jdField_a_of_type_AndroidOsRemoteCallbackList;
  private IQQPlayerService.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService$Stub = new tfz(this);
  private Object jdField_a_of_type_JavaLangObject;
  public tga a;
  private tgb jdField_a_of_type_Tgb;
  private volatile tgc jdField_a_of_type_Tgc;
  public boolean a;
  private volatile boolean jdField_b_of_type_Boolean;
  public long c;
  private volatile boolean c;
  private int x;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    u = 0;
    v = 103;
    w = -1;
  }
  
  public QQPlayerService()
  {
    this.jdField_c_of_type_Long = 500L;
    this.jdField_a_of_type_Float = 0.3F;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static int a()
  {
    return u;
  }
  
  public static Intent a()
  {
    return jdField_a_of_type_AndroidContentIntent;
  }
  
  public static Bundle a()
  {
    return jdField_a_of_type_AndroidOsBundle;
  }
  
  public static QQPlayerService.QQPlayerCallback a()
  {
    if (jdField_b_of_type_JavaLangRefWeakReference != null) {
      return (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public static SongInfo a()
  {
    return jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  }
  
  public static String a()
  {
    return f;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknow action";
    case 2: 
      return "start";
    case 3: 
      return "stop";
    case 4: 
      return "loopProgress";
    case 6: 
      return "pause";
    }
    return "resume";
  }
  
  public static String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "generateToken unknown callerType");
      }
      return null;
    case 1: 
      return "aio_" + paramString;
    case 2: 
      return "fav_" + paramString;
    case 3: 
      return "music_gene_" + paramString;
    case 4: 
      return "qzone_" + paramString;
    case 5: 
      return "troopbar_" + paramString;
    }
    return "music_pendant_" + paramString;
  }
  
  private static String a(String paramString)
  {
    if (paramString != null) {
      return MD5.toMD5(paramString);
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    v = paramInt;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "pausePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 6);
    paramContext.startService(localIntent);
  }
  
  private static void a(Context paramContext, SongInfo paramSongInfo)
  {
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 2);
    localIntent.putExtra("musicplayer.song", paramSongInfo);
    paramContext.startService(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, SongInfo paramSongInfo)
  {
    try
    {
      a(100);
      a(paramContext, paramString, new SongInfo[] { paramSongInfo });
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo)
  {
    a(paramContext, paramString, paramArrayOfSongInfo, 0);
  }
  
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if (paramArrayOfSongInfo != null) {}
    try
    {
      if (paramArrayOfSongInfo.length == 0) {
        throw new IllegalArgumentException("SongList shouldn't be null or empty!");
      }
    }
    finally
    {
      throw paramContext;
      if ((paramString == null) || (paramString.equals(""))) {
        throw new IllegalArgumentException("callerToken shouldn't be null or empty!");
      }
      if ((paramInt < 0) || (paramInt > paramArrayOfSongInfo.length - 1)) {
        throw new IllegalArgumentException("startIndex is out of range of SongList! Please check!");
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "startPlayMusic,songLists num=" + paramArrayOfSongInfo.length + ", startIndex=" + paramInt + " ,playMode=" + v);
      }
      f = paramString;
      jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = paramArrayOfSongInfo;
      if (jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        u = 0;
        paramString = (QQPlayerService.QQPlayerCallback)jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramString == null) {
          break label190;
        }
        paramString.onPlayStateChanged(0);
      }
      label190:
      while (!QLog.isColorLevel())
      {
        w = paramInt;
        a(paramContext, jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w]);
        return;
      }
    }
  }
  
  public static void a(Intent paramIntent)
  {
    jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public static void a(Bundle paramBundle)
  {
    jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public static void a(QQPlayerService.QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null)
    {
      f = paramQQPlayerCallback.getToken();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "setCallback: sToken=" + f);
      }
      jdField_a_of_type_JavaLangRefWeakReference = jdField_b_of_type_JavaLangRefWeakReference;
      jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQPlayerCallback);
    }
  }
  
  private void a(SongInfo paramSongInfo)
  {
    int i1 = 0;
    if (paramSongInfo == null) {
      try
      {
        throw new IllegalArgumentException("newSong shouldn't be null!");
      }
      finally {}
    }
    y = 0;
    jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    e();
    QQPlayerService.QQPlayerCallback localQQPlayerCallback;
    if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      localQQPlayerCallback = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:newSong=" + paramSongInfo.b + ",local callback=" + localQQPlayerCallback);
      }
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break label203;
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new tfv(this, localQQPlayerCallback, paramSongInfo));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsRemoteCallbackList == null) {
        break label240;
      }
      int i2 = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      label173:
      if (i1 < i2) {
        try
        {
          ((IQQPlayerCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i1)).a(paramSongInfo);
          i1 += 1;
          break label173;
          label203:
          localQQPlayerCallback.onPlaySongChanged(paramSongInfo);
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
    label240:
  }
  
  public static void a(String paramString)
  {
    ComponentName localComponentName = ComponentName.unflattenFromString(paramString);
    if ((localComponentName == null) && (QLog.isColorLevel())) {
      QLog.e("QQPlayerService", 2, "setPlayBarIntent : ComponentName unflattenFromString failure, componentString=" + paramString);
    }
    paramString = new Intent();
    paramString.setComponent(localComponentName);
    jdField_a_of_type_AndroidContentIntent = paramString;
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlaying : sPlayState " + b(u));
    }
    return (u == 2) || (u == 1);
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playPrev");
    }
    SongInfo localSongInfo = c();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    c(paramContext);
    return false;
  }
  
  public static boolean a(QQPlayerService.QQPlayerCallback paramQQPlayerCallback)
  {
    if (((u != 2) && (u != 1)) || (paramQQPlayerCallback == null)) {
      return false;
    }
    if (jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      QQPlayerService.QQPlayerCallback localQQPlayerCallback = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((localQQPlayerCallback != null) && (localQQPlayerCallback == paramQQPlayerCallback)) {
        return true;
      }
    }
    paramQQPlayerCallback = paramQQPlayerCallback.getToken();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlayingMySong:callback.getToken()=" + paramQQPlayerCallback + ",sToken=" + f);
    }
    if (f != null) {
      return f.equals(paramQQPlayerCallback);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if ((u != 2) && (u != 1)) {}
    while (f == null) {
      return false;
    }
    return f.equals(paramString);
  }
  
  public static SongInfo[] a()
  {
    return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  }
  
  public static int b()
  {
    return v;
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " Unknow playState ";
    case 0: 
      return " IDLE ";
    case 1: 
      return " BUFFERING ";
    case 2: 
      return " PLAYING ";
    case 3: 
      return " PAUSE ";
    case 4: 
      return " STOP ";
    case 5: 
      return " ERROR_INTERNAL ";
    case 7: 
      return " ERROR_SERVER ";
    }
    return " NETWORK_INTERRUPT ";
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQPlayerService");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsLooper = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
    this.jdField_a_of_type_Tgc = new tgc(this, this.jdField_a_of_type_AndroidOsLooper);
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 7) && (paramInt != 5) && (paramInt != 6)) {
      try
      {
        throw new IllegalArgumentException("playState value " + paramInt + " is illegal.");
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:" + b(u) + " =====> " + b(paramInt));
    }
    u = paramInt;
    if ((u == 2) || (u == 1)) {
      e();
    }
    for (;;)
    {
      QQPlayerService.QQPlayerCallback localQQPlayerCallback;
      label275:
      int i1;
      if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        localQQPlayerCallback = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:playState=" + b(paramInt) + ",local callback=" + localQQPlayerCallback);
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new tfw(this, localQQPlayerCallback, paramInt));
          if (this.jdField_a_of_type_AndroidOsRemoteCallbackList == null) {
            break label400;
          }
          int i2 = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
          i1 = 0;
          label293:
          if (i1 >= i2) {
            break label386;
          }
        }
      }
      try
      {
        ((IQQPlayerCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i1)).a(paramInt);
        i1 += 1;
        break label293;
        f();
        continue;
        localQQPlayerCallback.onPlayStateChanged(u);
        break label275;
        if ((jdField_b_of_type_JavaLangRefWeakReference != null) || (!QLog.isColorLevel())) {
          break label275;
        }
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify: sCallback = null! ");
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
          }
        }
      }
    }
    label386:
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null) {
      this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
    }
    label400:
    if (u == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "PLAY_STATE_ERROR_INTERNAL ======> post runnable to retry play media");
      }
      if (this.jdField_a_of_type_Tgc != null) {
        this.jdField_a_of_type_Tgc.postDelayed(new tfx(this), 4000L);
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "resumePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 5);
    paramContext.startService(localIntent);
  }
  
  private void b(Intent paramIntent)
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (paramIntent == null) {}
    int i1;
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            i1 = paramIntent.getIntExtra("musicplayer.action", 0);
            if (!QLog.isColorLevel()) {
              break label910;
            }
            QLog.d("QQPlayerService", 2, "action->" + a(i1));
          }
          catch (Throwable paramIntent) {}
          paramIntent = (SongInfo)paramIntent.getParcelableExtra("musicplayer.song");
          if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.jdField_a_of_type_JavaLangString))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQPlayerService", 2, "mediaPlayStart, url is null");
        return;
      } while (!QLog.isColorLevel());
      QLog.e("QQPlayerService", 2, "onHandleIntent error" + paramIntent.getMessage(), paramIntent);
      return;
      if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_c_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramIntent;
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
      b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
      return;
    } while ((u != 2) && ((u != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer == null)));
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    this.jdField_c_of_type_Boolean = true;
    b(3);
    return;
    if ((u == 3) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.jdField_c_of_type_Boolean = false;
      i1 = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject, 3, 1);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder().append("requestAudioFocus,result:");
        if (i1 != 1) {
          break label949;
        }
      }
    }
    label784:
    label787:
    label910:
    label949:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQPlayerService", 2, bool);
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      b(2);
      return;
      if ((u == 6) || (u == 7))
      {
        if (!NetworkUtil.h(getApplicationContext())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "resume from network interrupt, start play " + jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b);
        }
        this.jdField_c_of_type_Boolean = false;
        b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
        return;
      }
      if (u != 5) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
      return;
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_c_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Tga != null) && (this.jdField_a_of_type_Tga.isAlive()) && (!this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean = true;
      }
      b(4);
      if ((f != null) && (f.startsWith("qzone_")) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
      {
        this.jdField_c_of_type_Boolean = true;
        w = 0;
        jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
      }
      stopSelf();
      return;
      try
      {
        paramIntent = this.jdField_a_of_type_Tga;
        if ((paramIntent == null) || (jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!paramIntent.isAlive()) || (!paramIntent.jdField_c_of_type_Boolean) || (paramIntent.jdField_a_of_type_Boolean) || (!paramIntent.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_Boolean) || (y == 0)) {
          break label784;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, current playing song isDownloading...");
        }
        if ((!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) || (this.jdField_b_of_type_Boolean)) {
          break label787;
        }
        i1 = e();
        if (i1 / y * paramIntent.b + paramIntent.b * this.jdField_a_of_type_Float >= y)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data is ok, just return;");
          }
          return;
        }
      }
      finally {}
      float f1 = i1;
      if (f1 / y * paramIntent.b + paramIntent.b * this.jdField_a_of_type_Float > paramIntent.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS,no more data to play, need pause!");
        }
        this.x = i1;
        this.jdField_b_of_type_Boolean = true;
        jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        b(1);
      }
      for (;;)
      {
        a();
        return;
        if ((!this.jdField_b_of_type_Boolean) || (u != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
          break;
        }
        if (this.x / y * paramIntent.b + paramIntent.b * this.jdField_a_of_type_Float <= paramIntent.jdField_a_of_type_Int)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data buffering is enough");
          }
          this.x = 0;
          this.jdField_b_of_type_Boolean = false;
          if (!this.jdField_c_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, user no Pause,so play!");
            }
            jdField_a_of_type_AndroidMediaMediaPlayer.start();
            b(2);
          }
        }
      }
      return;
      if (i1 == 0) {
        break;
      }
      switch (i1)
      {
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    boolean bool1 = NetworkUtil.h(getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart,isNetworkAvailable = " + bool1 + ",url : " + paramString);
    }
    if (d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart, || play song in compatible mode ||");
      }
      if (!bool1)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        b(6);
      }
    }
    Object localObject2;
    int[] arrayOfInt;
    do
    {
      for (;;)
      {
        return;
        try
        {
          jdField_a_of_type_AndroidMediaMediaPlayer.reset();
          jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
          b(1);
          jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          b(2);
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          return;
        }
        catch (IllegalArgumentException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalArgumentException => ", paramString);
            }
          }
        }
        catch (SecurityException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode SecurityException => ", paramString);
            }
          }
        }
        catch (IllegalStateException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalStateException => ", paramString);
            }
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IOException => ", paramString);
            }
            jdField_a_of_type_AndroidMediaMediaPlayer.reset();
            b(6);
          }
        }
        localObject2 = a(paramString);
        Object localObject1 = new File(g + "/" + (String)localObject2);
        if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L)) {
          break label1157;
        }
        arrayOfInt = new int[2];
        boolean bool2 = MusicCacheManager.a((String)localObject2, arrayOfInt);
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject1).getAbsolutePath() + ",isCacheComplete:" + bool2 + ",result[0]:" + arrayOfInt[0] + ",result[1]:" + arrayOfInt[1]);
        }
        if (!bool2) {
          break label989;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache is complete");
        }
        jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        try
        {
          MusicCacheManager.a((File)localObject1);
          jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(((File)localObject1).getAbsolutePath());
          jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          b(2);
          if (b())
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download ============");
            }
            paramString = e().jdField_a_of_type_JavaLangString;
            if ((this.jdField_a_of_type_Tga != null) && (this.jdField_a_of_type_Tga.isAlive()) && (!this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: downloadThread is  running.... ");
              }
              if (paramString.equals(this.jdField_a_of_type_Tga.jdField_a_of_type_JavaLangString))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QQPlayerService", 2, "mediaPlayStart: download url equals nextUrl,so no need play and return.");
                }
                this.jdField_a_of_type_Tga.d = false;
                return;
              }
            }
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart:" + paramString.getMessage(), paramString);
            }
            try
            {
              ((File)localObject1).delete();
            }
            catch (Exception paramString) {}
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart,delete file on error:" + paramString.getMessage(), paramString);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: download url not equals nextUrl,so no need stop.");
          }
          this.jdField_a_of_type_Tga.d = false;
          this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Tga = null;
          localObject1 = a(paramString);
          localObject2 = new File(g + "/" + (String)localObject1);
          if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
          {
            arrayOfInt = new int[2];
            bool1 = MusicCacheManager.a((String)localObject1, arrayOfInt);
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject2).getAbsolutePath() + ",isNextCacheComplete:" + bool1 + ",nextResult[0]:" + arrayOfInt[0] + ",nextResult[1]:" + arrayOfInt[1]);
            }
            if (bool1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache is complete.return");
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache not complete");
              }
              this.jdField_a_of_type_Tga = new tga(this, paramString, (String)localObject1, arrayOfInt[0], arrayOfInt[1]);
              this.jdField_a_of_type_Tga.d = false;
              this.jdField_a_of_type_Tga.start();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache no exists");
            }
            this.jdField_a_of_type_Tga = new tga(this, paramString, (String)localObject1, 0, 0);
            this.jdField_a_of_type_Tga.d = false;
            this.jdField_a_of_type_Tga.start();
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no need pre download =================");
      }
    } while ((this.jdField_a_of_type_Tga == null) || (!this.jdField_a_of_type_Tga.isAlive()) || (this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean));
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: download thread running,so no need play");
    }
    this.jdField_a_of_type_Tga.d = false;
    return;
    label989:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      b(6);
      return;
    }
    if ((this.jdField_a_of_type_Tga != null) && (this.jdField_a_of_type_Tga.isAlive()) && (!this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean))
    {
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_Tga.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_Tga.d = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_Tga.d = false;
      this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Tga = null;
    }
    this.jdField_a_of_type_Tga = new tga(this, paramString, (String)localObject2, arrayOfInt[0], arrayOfInt[1]);
    this.jdField_a_of_type_Tga.start();
    return;
    label1157:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      b(6);
      return;
    }
    if ((this.jdField_a_of_type_Tga != null) && (this.jdField_a_of_type_Tga.isAlive()) && (!this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean))
    {
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_Tga.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_Tga.d = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_Tga.d = false;
      this.jdField_a_of_type_Tga.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Tga = null;
    }
    this.jdField_a_of_type_Tga = new tga(this, paramString, (String)localObject2, 0, 0);
    this.jdField_a_of_type_Tga.start();
  }
  
  private boolean b()
  {
    return (NetworkUtil.i(getApplicationContext())) && (e() != null);
  }
  
  public static boolean b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playNext");
    }
    SongInfo localSongInfo = d();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    c(paramContext);
    return false;
  }
  
  public static boolean b(String paramString)
  {
    paramString = a(paramString);
    paramString = new File(g + "/" + paramString);
    return (paramString.exists()) && (paramString.length() > 102400L);
  }
  
  public static int c()
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo != null) {
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
    }
    return 0;
  }
  
  private static SongInfo c()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0))
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("QQPlayerService", 2, "pickPreviousSong : sSongList shouldn't be null or empty!");
            localObject1 = localObject4;
          }
          return (SongInfo)localObject1;
        }
        int i1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "pickPreviousSong : songNum=" + i1 + ",sPlayMode=" + v + ",currentSongIndex=" + w);
        }
        Object localObject1 = localObject4;
        switch (v)
        {
        case 100: 
        case 101: 
          if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
            localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
          } else {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
          }
          break;
        case 102: 
          localObject1 = localObject4;
          if (w >= 1)
          {
            localObject1 = localObject4;
            if (w <= i1 - 1)
            {
              w -= 1;
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
            }
          }
          break;
        case 103: 
          localObject1 = localObject4;
          if (w >= 0)
          {
            localObject1 = localObject4;
            if (w <= i1 - 1)
            {
              w -= 1;
              if (w < 0) {
                w = i1 - 1;
              }
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
            }
          }
          break;
        case 105: 
          int i2 = w;
          w = new Random().nextInt(i1);
          if ((w == i2) && (i1 >= 1))
          {
            w += 1;
            w %= i1;
          }
          if ((w >= 0) && (w <= i1 - 1))
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
          }
          else
          {
            localObject1 = localObject4;
            if (i1 > 0) {
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
            }
          }
          break;
        case 104: 
        default: 
          Object localObject3 = localObject4;
        }
      }
      finally {}
    }
  }
  
  private void c()
  {
    jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
  }
  
  public static void c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "stopPlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 3);
    paramContext.startService(localIntent);
  }
  
  public static int d()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = "";
        if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
          str = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b;
        }
        QLog.d("QQPlayerService", 2, "getDuration(): title= " + str + " ,sPlayState = " + b(u) + " duration = " + y);
      }
      int i1 = y;
      return i1;
    }
    finally {}
  }
  
  private static SongInfo d()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0))
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("QQPlayerService", 2, "pickNextSong : sSongList shouldn't be null or empty!");
            localObject1 = localObject4;
          }
          return (SongInfo)localObject1;
        }
        int i1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "pickNextSong : songNum=" + i1 + ",sPlayMode=" + v + ",currentSongIndex=" + w);
        }
        Object localObject1 = localObject4;
        switch (v)
        {
        case 100: 
        case 101: 
          if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
            localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
          } else {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
          }
          break;
        case 102: 
          localObject1 = localObject4;
          if (w >= 0)
          {
            localObject1 = localObject4;
            if (w <= i1 - 2)
            {
              w += 1;
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
            }
          }
          break;
        case 103: 
          localObject1 = localObject4;
          if (w >= 0)
          {
            localObject1 = localObject4;
            if (w <= i1 - 1)
            {
              w += 1;
              if (w > i1 - 1) {
                w = 0;
              }
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
            }
          }
          break;
        case 105: 
          w = new Random().nextInt(i1);
          if ((w >= 0) && (w <= i1 - 1))
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
          }
          else
          {
            localObject1 = localObject4;
            if (i1 > 0) {
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
            }
          }
          break;
        case 104: 
        default: 
          Object localObject3 = localObject4;
        }
      }
      finally {}
    }
  }
  
  private static void d()
  {
    if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static int e()
  {
    int i2 = -1;
    int i1 = i2;
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        i1 = i2;
        if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          i1 = jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "getCurrentSongPosition(): sPlayState = " + b(u) + " position = " + i1);
      }
      return i1;
    }
    finally {}
  }
  
  private static SongInfo e()
  {
    int i1 = 0;
    if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0)) {
      return null;
    }
    int i3 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
    switch (v)
    {
    default: 
      return null;
    case 100: 
      return null;
    case 101: 
      if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
        return jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      }
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
    case 102: 
      if ((w >= 0) && (w <= i3 - 2)) {
        return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
      }
      return null;
    }
    int i2;
    if ((w >= 0) && (w <= i3 - 1))
    {
      i2 = w + 1;
      if (i2 <= i3 - 1) {
        break label137;
      }
    }
    for (;;)
    {
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[i1];
      return null;
      label137:
      i1 = i2;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "showMsgTabBar =======>");
    }
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).a(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134010));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("QQPlayerService", 2, "showMsgTabBar app = null!");
  }
  
  public static int f()
  {
    int i1 = -1;
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        i1 = jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "getCurrentPlayPosition(): sPlayState = " + b(u) + " position = " + i1);
      }
      return i1;
    }
    finally {}
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "dismissMsgTabBar <=======");
    }
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).a(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134011));
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "dismissMsgTabBar: send msg MSG_MUSIC_PLAYER_HIDE ~~~~");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("QQPlayerService", 2, "dismissMsgTabBar app = null!");
  }
  
  public static int g()
  {
    return w;
  }
  
  private void g()
  {
    ThreadManager.a().post(new tfy(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "loopProgress : loopProgressDelayTime=" + this.jdField_c_of_type_Long);
    }
    Message localMessage = this.jdField_a_of_type_Tgc.obtainMessage();
    Intent localIntent = new Intent();
    localIntent.putExtra("musicplayer.action", 4);
    localMessage.obj = localIntent;
    this.jdField_a_of_type_Tgc.sendMessageDelayed(localMessage, this.jdField_c_of_type_Long);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onBind");
    }
    return this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService$Stub;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if ((QLog.isColorLevel()) && (d) && (paramInt < 100)) {
      QLog.d("QQPlayerService", 2, "onBufferingUpdate : " + paramInt + "% buffered");
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCompletion");
    }
    if ((!b(getApplicationContext())) && (VersionUtils.b())) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCreate");
    }
    if (VersionUtils.b()) {
      this.jdField_a_of_type_JavaLangObject = new tfs(this);
    }
    b();
    this.jdField_a_of_type_Tgc.post(new tft(this));
    this.jdField_a_of_type_Tgb = new tgb(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("qqplayer_exit_action");
    try
    {
      registerReceiver(this.jdField_a_of_type_Tgb, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQPlayerService", 2, "onCreate registerReceiver exception ");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onDestroy");
    }
    this.jdField_a_of_type_AndroidOsLooper.quit();
    this.jdField_a_of_type_Tgc = null;
    f = null;
    y = 0;
    w = 0;
    jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
    jdField_a_of_type_AndroidContentIntent = null;
    jdField_a_of_type_AndroidOsBundle = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    ThreadManager.b().post(new tfu(this));
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      this.jdField_a_of_type_AndroidOsRemoteCallbackList.kill();
      this.jdField_a_of_type_AndroidOsRemoteCallbackList = null;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      for (;;)
      {
        unregisterReceiver(this.jdField_a_of_type_Tgb);
        g();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "Android 2.1 and below can not stop music");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onDestroy unregisterReceiver exception ");
        }
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQPlayerService", 2, "onError,what:" + paramInt1 + ",extra:" + paramInt2);
    }
    if (paramInt1 == 100)
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      c();
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    d();
    try
    {
      b(5);
      return true;
    }
    catch (NullPointerException paramMediaPlayer)
    {
      for (;;) {}
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    y = jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onPrepared:sDuration" + y);
    }
    if ((this.jdField_a_of_type_Tga != null) && (this.jdField_a_of_type_Tga.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Tga.jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) && (this.jdField_a_of_type_Tga.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString)))
    {
      if (y != 0) {
        this.jdField_c_of_type_Long = ((y * 0.01D));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "onPrepared:loopProgressDelayTime:" + this.jdField_c_of_type_Long);
      }
      a();
    }
    if (!VersionUtils.b()) {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "onPrepared Android 2.1 and below can not stop music");
      }
    }
    int i1;
    do
    {
      return;
      i1 = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject, 3, 1);
    } while (!QLog.isColorLevel());
    paramMediaPlayer = new StringBuilder().append("requestAudioFocus,result:");
    if (i1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQPlayerService", 2, bool);
      return;
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onStart");
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onStartCommand");
    }
    Message localMessage = this.jdField_a_of_type_Tgc.obtainMessage();
    localMessage.obj = paramIntent;
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive()) || (this.jdField_a_of_type_AndroidOsLooper != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidOsLooper.quit();
      b();
      this.jdField_a_of_type_Tgc.sendMessage(localMessage);
      return 2;
    }
    catch (Throwable paramIntent)
    {
      for (;;) {}
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\music\QQPlayerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */