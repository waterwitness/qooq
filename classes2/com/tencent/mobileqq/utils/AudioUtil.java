package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import mqq.app.AppRuntime;
import vzu;
import vzv;
import vzw;
import vzy;
import wab;

public class AudioUtil
{
  private static int a;
  public static MediaPlayer a;
  
  public AudioUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    return ((AudioManager)BaseApplicationImpl.a.getSystemService("audio")).getRingerMode();
  }
  
  private static MediaPlayer a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getResources().openRawResourceFd(paramInt);
      if (paramContext == null) {
        return null;
      }
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
      paramContext.close();
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramContext);
      }
    }
    return null;
  }
  
  private static MediaPlayer a(Context paramContext, Uri paramUri)
  {
    try
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext, paramUri);
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramContext);
      }
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      a(paramInt1, paramInt2, paramOnCompletionListener, null);
      return;
    }
    finally
    {
      paramOnCompletionListener = finally;
      throw paramOnCompletionListener;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener, Handler paramHandler)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        boolean bool = jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (paramOnCompletionListener == null) {
          continue;
        }
        if ((paramHandler != null) && (paramHandler.getLooper() != Looper.myLooper())) {
          break label154;
        }
        paramOnCompletionListener.onCompletion(jdField_a_of_type_AndroidMediaMediaPlayer);
        continue;
      }
      finally {}
      return;
      a();
      if (paramInt1 != AppSetting.e)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.a, paramInt1);
        if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          jdField_a_of_type_Int = paramInt2;
          if (jdField_a_of_type_Int != 0) {
            jdField_a_of_type_Int -= 1;
          }
          jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new vzw(paramOnCompletionListener, paramHandler));
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.a, Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      continue;
      label154:
      paramHandler.post(new vzy(paramOnCompletionListener));
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("mediaPlayerStartForMsg", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is playing");
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer exception", localException1);
        continue;
      }
      finally {}
      return;
      try
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer release exception", localException2);
        label167:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.e)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplicationImpl.a, paramInt);
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is null");
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplicationImpl.a, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("mediaPlayerStartForMsg", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new vzu());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  /* Error */
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +28 -> 34
    //   9: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   12: invokevirtual 111	android/media/MediaPlayer:isPlaying	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +7 -> 24
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   27: invokevirtual 104	android/media/MediaPlayer:release	()V
    //   30: aconst_null
    //   31: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   34: iload_0
    //   35: getstatic 118	com/tencent/common/config/AppSetting:e	I
    //   38: if_icmpeq +68 -> 106
    //   41: getstatic 24	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   44: iload_0
    //   45: invokestatic 121	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   48: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   51: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   54: ifnull -34 -> 20
    //   57: aload_3
    //   58: ifnull +63 -> 121
    //   61: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   64: aload_3
    //   65: invokevirtual 132	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   68: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   71: invokevirtual 135	android/media/MediaPlayer:start	()V
    //   74: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   77: iload_1
    //   78: invokevirtual 139	android/media/MediaPlayer:setLooping	(Z)V
    //   81: goto -61 -> 20
    //   84: astore 4
    //   86: aconst_null
    //   87: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   90: goto -56 -> 34
    //   93: astore_3
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_3
    //   98: athrow
    //   99: astore_3
    //   100: aconst_null
    //   101: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   104: aload_3
    //   105: athrow
    //   106: getstatic 24	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   109: getstatic 161	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   112: invokestatic 163	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   115: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   118: goto -67 -> 51
    //   121: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   124: new 226	vzz
    //   127: dup
    //   128: invokespecial 227	vzz:<init>	()V
    //   131: invokevirtual 132	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   134: goto -66 -> 68
    //   137: astore_3
    //   138: goto -118 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramInt	int
    //   0	141	1	paramBoolean1	boolean
    //   0	141	2	paramBoolean2	boolean
    //   0	141	3	paramOnCompletionListener	MediaPlayer.OnCompletionListener
    //   84	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   24	30	84	java/lang/Exception
    //   3	16	93	finally
    //   30	34	93	finally
    //   34	51	93	finally
    //   51	57	93	finally
    //   61	68	93	finally
    //   68	81	93	finally
    //   86	90	93	finally
    //   100	106	93	finally
    //   106	118	93	finally
    //   121	134	93	finally
    //   24	30	99	finally
    //   3	16	137	java/lang/Exception
    //   30	34	137	java/lang/Exception
    //   34	51	137	java/lang/Exception
    //   51	57	137	java/lang/Exception
    //   61	68	137	java/lang/Exception
    //   68	81	137	java/lang/Exception
    //   86	90	137	java/lang/Exception
    //   100	106	137	java/lang/Exception
    //   106	118	137	java/lang/Exception
    //   121	134	137	java/lang/Exception
  }
  
  private static void a(MediaPlayer paramMediaPlayer)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      paramMediaPlayer.setAudioStreamType(3);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MediaPlayerStart", 2, "get QQAppInterface error");
  }
  
  public static void a(Uri paramUri, int paramInt, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        boolean bool = jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        if (!bool) {
          continue;
        }
      }
      catch (Exception paramUri)
      {
        continue;
      }
      finally {}
      return;
      a();
      if (paramUri.getScheme().equals("file"))
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        paramUri = new FileInputStream(new File(paramUri.getPath()));
        jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramUri.getFD());
        jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        paramUri.close();
      }
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        jdField_a_of_type_Int = paramInt;
        if (jdField_a_of_type_Int != 0) {
          jdField_a_of_type_Int -= 1;
        }
        jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new wab(paramOnCompletionListener));
        jdField_a_of_type_AndroidMediaMediaPlayer.start();
        jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
      }
    }
  }
  
  /* Error */
  public static void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +13 -> 21
    //   11: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   14: invokevirtual 104	android/media/MediaPlayer:release	()V
    //   17: aconst_null
    //   18: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: aload_0
    //   22: invokevirtual 249	android/net/Uri:getScheme	()Ljava/lang/String;
    //   25: ldc -5
    //   27: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +129 -> 159
    //   33: new 52	android/media/MediaPlayer
    //   36: dup
    //   37: invokespecial 53	android/media/MediaPlayer:<init>	()V
    //   40: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   43: iload_2
    //   44: ifeq +25 -> 69
    //   47: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +13 -> 63
    //   53: ldc_w 283
    //   56: iconst_2
    //   57: ldc_w 285
    //   60: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   66: invokestatic 56	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   69: new 259	java/io/FileInputStream
    //   72: dup
    //   73: new 261	java/io/File
    //   76: dup
    //   77: aload_0
    //   78: invokevirtual 264	android/net/Uri:getPath	()Ljava/lang/String;
    //   81: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: astore_0
    //   88: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   91: aload_0
    //   92: invokevirtual 273	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   95: invokevirtual 276	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   98: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   101: invokevirtual 79	android/media/MediaPlayer:prepare	()V
    //   104: aload_0
    //   105: invokevirtual 277	java/io/FileInputStream:close	()V
    //   108: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   111: new 287	waa
    //   114: dup
    //   115: invokespecial 288	waa:<init>	()V
    //   118: invokevirtual 132	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   121: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   124: invokevirtual 135	android/media/MediaPlayer:start	()V
    //   127: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   130: iload_1
    //   131: invokevirtual 139	android/media/MediaPlayer:setLooping	(Z)V
    //   134: ldc 2
    //   136: monitorexit
    //   137: return
    //   138: astore_3
    //   139: aconst_null
    //   140: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: goto -122 -> 21
    //   146: astore_0
    //   147: aconst_null
    //   148: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: ldc 2
    //   156: monitorexit
    //   157: aload_0
    //   158: athrow
    //   159: getstatic 24	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   162: aload_0
    //   163: invokestatic 163	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   166: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   169: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   172: ifnull -38 -> 134
    //   175: iload_2
    //   176: ifeq -68 -> 108
    //   179: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +13 -> 195
    //   185: ldc_w 283
    //   188: iconst_2
    //   189: ldc_w 285
    //   192: invokestatic 198	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   198: invokestatic 56	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   201: goto -93 -> 108
    //   204: astore_0
    //   205: goto -71 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramUri	Uri
    //   0	208	1	paramBoolean1	boolean
    //   0	208	2	paramBoolean2	boolean
    //   6	2	3	localMediaPlayer	MediaPlayer
    //   138	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	17	138	java/lang/Exception
    //   11	17	146	finally
    //   3	7	153	finally
    //   17	21	153	finally
    //   21	43	153	finally
    //   47	63	153	finally
    //   63	69	153	finally
    //   69	108	153	finally
    //   108	134	153	finally
    //   139	143	153	finally
    //   147	153	153	finally
    //   159	175	153	finally
    //   179	195	153	finally
    //   195	201	153	finally
    //   3	7	204	java/lang/Exception
    //   17	21	204	java/lang/Exception
    //   21	43	204	java/lang/Exception
    //   47	63	204	java/lang/Exception
    //   63	69	204	java/lang/Exception
    //   69	108	204	java/lang/Exception
    //   108	134	204	java/lang/Exception
    //   139	143	204	java/lang/Exception
    //   147	153	204	java/lang/Exception
    //   159	175	204	java/lang/Exception
    //   179	195	204	java/lang/Exception
    //   195	201	204	java/lang/Exception
  }
  
  /* Error */
  public static void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload 4
    //   10: astore_2
    //   11: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   14: ifnull +62 -> 76
    //   17: aload 4
    //   19: astore_2
    //   20: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: invokevirtual 111	android/media/MediaPlayer:isPlaying	()Z
    //   26: istore 5
    //   28: iload 5
    //   30: ifeq +33 -> 63
    //   33: iconst_0
    //   34: ifeq +11 -> 45
    //   37: new 291	java/lang/NullPointerException
    //   40: dup
    //   41: invokespecial 292	java/lang/NullPointerException:<init>	()V
    //   44: athrow
    //   45: ldc 2
    //   47: monitorexit
    //   48: return
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   54: goto -9 -> 45
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    //   63: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   66: invokevirtual 104	android/media/MediaPlayer:release	()V
    //   69: aload 4
    //   71: astore_2
    //   72: aconst_null
    //   73: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   76: aload 4
    //   78: astore_2
    //   79: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   82: ifnonnull +16 -> 98
    //   85: aload 4
    //   87: astore_2
    //   88: new 52	android/media/MediaPlayer
    //   91: dup
    //   92: invokespecial 53	android/media/MediaPlayer:<init>	()V
    //   95: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   98: aload 4
    //   100: astore_2
    //   101: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   104: invokevirtual 298	android/media/MediaPlayer:reset	()V
    //   107: aload 4
    //   109: astore_2
    //   110: new 259	java/io/FileInputStream
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   118: astore_0
    //   119: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   122: aload_0
    //   123: invokevirtual 273	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   126: invokevirtual 276	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   129: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   132: invokestatic 56	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   135: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   138: invokevirtual 79	android/media/MediaPlayer:prepare	()V
    //   141: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   144: new 301	vzt
    //   147: dup
    //   148: invokespecial 302	vzt:<init>	()V
    //   151: invokevirtual 132	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   154: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   157: invokevirtual 135	android/media/MediaPlayer:start	()V
    //   160: getstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   163: iload_1
    //   164: invokevirtual 139	android/media/MediaPlayer:setLooping	(Z)V
    //   167: aload_0
    //   168: ifnull -123 -> 45
    //   171: aload_0
    //   172: invokevirtual 277	java/io/FileInputStream:close	()V
    //   175: goto -130 -> 45
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   183: goto -138 -> 45
    //   186: astore_2
    //   187: aload 4
    //   189: astore_2
    //   190: aconst_null
    //   191: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   194: goto -118 -> 76
    //   197: astore_2
    //   198: aload_3
    //   199: astore_0
    //   200: aload_2
    //   201: astore_3
    //   202: aload_0
    //   203: astore_2
    //   204: aload_3
    //   205: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   208: aload_0
    //   209: ifnull -164 -> 45
    //   212: aload_0
    //   213: invokevirtual 277	java/io/FileInputStream:close	()V
    //   216: goto -171 -> 45
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   224: goto -179 -> 45
    //   227: astore_0
    //   228: aload 4
    //   230: astore_2
    //   231: aconst_null
    //   232: putstatic 101	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   235: aload 4
    //   237: astore_2
    //   238: aload_0
    //   239: athrow
    //   240: astore_0
    //   241: aload_2
    //   242: ifnull +7 -> 249
    //   245: aload_2
    //   246: invokevirtual 277	java/io/FileInputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_2
    //   252: aload_2
    //   253: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   256: goto -7 -> 249
    //   259: astore_3
    //   260: aload_0
    //   261: astore_2
    //   262: aload_3
    //   263: astore_0
    //   264: goto -23 -> 241
    //   267: astore_3
    //   268: goto -66 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramString	String
    //   0	271	1	paramBoolean	boolean
    //   10	100	2	localObject1	Object
    //   186	1	2	localException1	Exception
    //   189	1	2	localObject2	Object
    //   197	4	2	localException2	Exception
    //   203	43	2	localObject3	Object
    //   251	2	2	localIOException	IOException
    //   261	1	2	str	String
    //   4	201	3	localObject4	Object
    //   259	4	3	localObject5	Object
    //   267	1	3	localException3	Exception
    //   1	235	4	localObject6	Object
    //   26	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   37	45	49	java/io/IOException
    //   37	45	57	finally
    //   50	54	57	finally
    //   171	175	57	finally
    //   179	183	57	finally
    //   212	216	57	finally
    //   220	224	57	finally
    //   245	249	57	finally
    //   249	251	57	finally
    //   252	256	57	finally
    //   171	175	178	java/io/IOException
    //   63	69	186	java/lang/Exception
    //   11	17	197	java/lang/Exception
    //   20	28	197	java/lang/Exception
    //   72	76	197	java/lang/Exception
    //   79	85	197	java/lang/Exception
    //   88	98	197	java/lang/Exception
    //   101	107	197	java/lang/Exception
    //   110	119	197	java/lang/Exception
    //   190	194	197	java/lang/Exception
    //   231	235	197	java/lang/Exception
    //   238	240	197	java/lang/Exception
    //   212	216	219	java/io/IOException
    //   63	69	227	finally
    //   11	17	240	finally
    //   20	28	240	finally
    //   72	76	240	finally
    //   79	85	240	finally
    //   88	98	240	finally
    //   101	107	240	finally
    //   110	119	240	finally
    //   190	194	240	finally
    //   204	208	240	finally
    //   231	235	240	finally
    //   238	240	240	finally
    //   245	249	251	java/io/IOException
    //   119	167	259	finally
    //   119	167	267	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "context is null.");
      }
    }
    do
    {
      return false;
      if (VersionUtils.b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AudioUtil", 2, "Android 2.1 and below can not stop music");
    return false;
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramBoolean) {
      if (paramContext.requestAudioFocus(null, 3, 2) == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "pauseMusic bMute=" + paramBoolean + " result=" + bool);
      }
      return bool;
      bool = false;
      continue;
      try
      {
        int i = paramContext.abandonAudioFocus(null);
        if (i == 1) {
          continue;
        }
        for (;;)
        {
          bool = false;
        }
      }
      catch (NullPointerException paramContext)
      {
        QLog.e("AudioUtil", 1, "caught npe", paramContext);
        bool = false;
      }
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerStart", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("MediaPlayerStart", 2, "media palyer is playing");
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer exception", localException1);
        continue;
      }
      finally {}
      return;
      try
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer release exception", localException2);
        label167:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.e)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.a, paramInt);
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("MediaPlayerStart", 2, "media palyer is null");
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.a, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MediaPlayerStart", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new vzv());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\AudioUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */