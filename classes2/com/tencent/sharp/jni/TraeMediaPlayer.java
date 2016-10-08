package com.tencent.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 100;
  private Context jdField_a_of_type_AndroidContentContext;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private TraeMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  int e;
  private int f;
  private int g;
  private int h;
  
  public TraeMediaPlayer(Context paramContext, TraeMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 0;
    this.g = -1;
    this.e = 0;
    this.jdField_a_of_type_Boolean = false;
    this.h = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener = paramOnCompletionListener;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!this.jdField_a_of_type_Boolean) || (this.f == 2)) {
      return;
    }
    for (;;)
    {
      int i;
      int n;
      try
      {
        localAudioManager = (AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
        j = localAudioManager.getStreamVolume(this.f);
        i = localAudioManager.getStreamMaxVolume(this.f);
        int k = localAudioManager.getStreamVolume(2);
        int m = localAudioManager.getStreamMaxVolume(2);
        n = (int)(k * 1.0D / m * i);
        if (!QLog.isColorLevel()) {
          break label182;
        }
        QLog.e("TRAE", 2, "TraeMediaPlay volumeDo currV:" + j + " maxV:" + i + " currRV:" + k + " maxRV:" + m + " setV:" + n);
      }
      catch (Exception localException)
      {
        AudioManager localAudioManager;
        int j;
        return;
      }
      localAudioManager.setStreamVolume(this.f, i, 0);
      this.h = j;
      return;
      label182:
      while (n + 1 < i)
      {
        i = n + 1;
        break;
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!this.jdField_a_of_type_Boolean) || (this.f == 2) || (this.h == -1)) {
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this.h);
      }
      ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).setStreamVolume(this.f, this.h, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "TraeMediaPlay stopRing ");
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        this.jdField_a_of_type_JavaUtilTimerTask = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.g = -1;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  /* Error */
  public boolean a(int paramInt1, int paramInt2, android.net.Uri paramUri, String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +132 -> 135
    //   6: new 85	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   13: ldc -99
    //   15: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_1
    //   19: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc -97
    //   24: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc -95
    //   33: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc -90
    //   42: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload 4
    //   47: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc -88
    //   52: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: astore 11
    //   57: iload 5
    //   59: ifeq +150 -> 209
    //   62: ldc -86
    //   64: astore 10
    //   66: aload 11
    //   68: aload 10
    //   70: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc -84
    //   75: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload 6
    //   80: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc -82
    //   85: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore 11
    //   90: iload 7
    //   92: ifeq +124 -> 216
    //   95: ldc -86
    //   97: astore 10
    //   99: ldc 83
    //   101: iconst_2
    //   102: aload 11
    //   104: aload 10
    //   106: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc -80
    //   111: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload 8
    //   116: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   119: ldc -75
    //   121: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 9
    //   126: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: iload 5
    //   137: ifne +92 -> 229
    //   140: iload 6
    //   142: ifgt +87 -> 229
    //   145: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +59 -> 207
    //   151: new 85	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   158: ldc -73
    //   160: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_1
    //   164: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc -88
    //   169: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: astore 4
    //   174: iload 5
    //   176: ifeq +47 -> 223
    //   179: ldc -86
    //   181: astore_3
    //   182: ldc 83
    //   184: iconst_2
    //   185: aload 4
    //   187: aload_3
    //   188: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc -84
    //   193: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 6
    //   198: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: iconst_0
    //   208: ireturn
    //   209: ldc -71
    //   211: astore 10
    //   213: goto -147 -> 66
    //   216: ldc -71
    //   218: astore 10
    //   220: goto -121 -> 99
    //   223: ldc -71
    //   225: astore_3
    //   226: goto -44 -> 182
    //   229: aload_0
    //   230: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   233: ifnull +31 -> 264
    //   236: aload_0
    //   237: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   240: invokevirtual 126	android/media/MediaPlayer:isPlaying	()Z
    //   243: istore 12
    //   245: iload 12
    //   247: ifeq +5 -> 252
    //   250: iconst_0
    //   251: ireturn
    //   252: aload_0
    //   253: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   256: invokevirtual 144	android/media/MediaPlayer:release	()V
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   264: aload_0
    //   265: getfield 134	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   268: ifnull +20 -> 288
    //   271: aload_0
    //   272: getfield 134	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   275: invokevirtual 139	java/util/Timer:cancel	()V
    //   278: aload_0
    //   279: aconst_null
    //   280: putfield 134	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 141	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   288: aload_0
    //   289: getfield 49	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   292: ldc 60
    //   294: invokevirtual 66	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   297: checkcast 68	android/media/AudioManager
    //   300: astore 10
    //   302: aload_0
    //   303: new 123	android/media/MediaPlayer
    //   306: dup
    //   307: invokespecial 186	android/media/MediaPlayer:<init>	()V
    //   310: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   313: aload_0
    //   314: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   317: ifnonnull +196 -> 513
    //   320: aload_0
    //   321: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   324: invokevirtual 144	android/media/MediaPlayer:release	()V
    //   327: aload_0
    //   328: aconst_null
    //   329: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   332: iconst_0
    //   333: ireturn
    //   334: astore 10
    //   336: aload_0
    //   337: aconst_null
    //   338: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   341: goto -77 -> 264
    //   344: astore_3
    //   345: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +43 -> 391
    //   351: ldc 83
    //   353: iconst_2
    //   354: new 85	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   361: ldc -68
    //   363: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_3
    //   367: invokevirtual 191	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   370: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc -63
    //   375: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_3
    //   379: invokevirtual 196	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   382: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_0
    //   392: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   395: invokevirtual 144	android/media/MediaPlayer:release	()V
    //   398: aload_0
    //   399: aconst_null
    //   400: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   403: iconst_0
    //   404: ireturn
    //   405: astore_3
    //   406: aload_0
    //   407: aconst_null
    //   408: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   411: aload_3
    //   412: athrow
    //   413: astore_3
    //   414: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq -26 -> 391
    //   420: ldc 83
    //   422: iconst_2
    //   423: new 85	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   430: ldc -58
    //   432: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_3
    //   436: invokevirtual 199	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   439: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc -63
    //   444: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_3
    //   448: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   451: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: goto -69 -> 391
    //   463: astore_3
    //   464: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq -76 -> 391
    //   470: ldc 83
    //   472: iconst_2
    //   473: new 85	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   480: ldc -54
    //   482: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_3
    //   486: invokevirtual 203	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   489: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc -63
    //   494: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_3
    //   498: invokevirtual 204	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   501: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: goto -119 -> 391
    //   513: aload_0
    //   514: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   517: aload_0
    //   518: invokevirtual 208	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   521: aload_0
    //   522: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   525: aload_0
    //   526: invokevirtual 212	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   529: iload_1
    //   530: tableswitch	default:+712->1242, 0:+78->608, 1:+246->776, 2:+343->873
    //   556: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq +28 -> 587
    //   562: ldc 83
    //   564: iconst_2
    //   565: new 85	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   572: ldc -42
    //   574: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload_1
    //   578: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   587: aload_0
    //   588: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   591: invokevirtual 144	android/media/MediaPlayer:release	()V
    //   594: aload_0
    //   595: aconst_null
    //   596: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   599: aload_0
    //   600: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   603: ifnonnull +315 -> 918
    //   606: iconst_0
    //   607: ireturn
    //   608: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   611: ifeq +28 -> 639
    //   614: ldc 83
    //   616: iconst_2
    //   617: new 85	java/lang/StringBuilder
    //   620: dup
    //   621: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   624: ldc -40
    //   626: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: iload_2
    //   630: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: aload_0
    //   640: getfield 49	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   643: invokevirtual 220	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   646: iload_2
    //   647: invokevirtual 226	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   650: astore_3
    //   651: aload_3
    //   652: ifnonnull +48 -> 700
    //   655: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +28 -> 686
    //   661: ldc 83
    //   663: iconst_2
    //   664: new 85	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   671: ldc -28
    //   673: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: iload_2
    //   677: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: aload_0
    //   687: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   690: invokevirtual 144	android/media/MediaPlayer:release	()V
    //   693: aload_0
    //   694: aconst_null
    //   695: putfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   698: iconst_0
    //   699: ireturn
    //   700: aload_0
    //   701: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   704: aload_3
    //   705: invokevirtual 234	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   708: aload_3
    //   709: invokevirtual 238	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   712: aload_3
    //   713: invokevirtual 241	android/content/res/AssetFileDescriptor:getLength	()J
    //   716: invokevirtual 245	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   719: aload_3
    //   720: invokevirtual 248	android/content/res/AssetFileDescriptor:close	()V
    //   723: goto -124 -> 599
    //   726: astore_3
    //   727: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq -339 -> 391
    //   733: ldc 83
    //   735: iconst_2
    //   736: new 85	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   743: ldc -6
    //   745: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload_3
    //   749: invokevirtual 251	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   752: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: ldc -63
    //   757: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: aload_3
    //   761: invokevirtual 252	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   764: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: goto -382 -> 391
    //   776: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +28 -> 807
    //   782: ldc 83
    //   784: iconst_2
    //   785: new 85	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   792: ldc -2
    //   794: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: aload_3
    //   798: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: aload_0
    //   808: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   811: aload_0
    //   812: getfield 49	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   815: aload_3
    //   816: invokevirtual 257	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   819: goto -220 -> 599
    //   822: astore_3
    //   823: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   826: ifeq -435 -> 391
    //   829: ldc 83
    //   831: iconst_2
    //   832: new 85	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   839: ldc_w 259
    //   842: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload_3
    //   846: invokevirtual 260	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   849: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: ldc -63
    //   854: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_3
    //   858: invokevirtual 261	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   861: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   870: goto -479 -> 391
    //   873: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   876: ifeq +30 -> 906
    //   879: ldc 83
    //   881: iconst_2
    //   882: new 85	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   889: ldc_w 263
    //   892: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: aload 4
    //   897: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   906: aload_0
    //   907: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   910: aload 4
    //   912: invokevirtual 266	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   915: goto -316 -> 599
    //   918: aload_0
    //   919: iload 7
    //   921: putfield 45	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Boolean	Z
    //   924: iconst_0
    //   925: istore_1
    //   926: aload_0
    //   927: getfield 45	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Boolean	Z
    //   930: ifeq +211 -> 1141
    //   933: aload_0
    //   934: iconst_2
    //   935: putfield 39	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   938: iconst_1
    //   939: istore_1
    //   940: aload_0
    //   941: iload 8
    //   943: putfield 146	com/tencent/sharp/jni/TraeMediaPlayer:b	Z
    //   946: aload_0
    //   947: getfield 146	com/tencent/sharp/jni/TraeMediaPlayer:b	Z
    //   950: ifeq +9 -> 959
    //   953: aload_0
    //   954: iload 9
    //   956: putfield 39	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   959: aload_0
    //   960: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   963: aload_0
    //   964: getfield 39	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   967: invokevirtual 270	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   970: aload_0
    //   971: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   974: invokevirtual 273	android/media/MediaPlayer:prepare	()V
    //   977: aload_0
    //   978: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   981: iload 5
    //   983: invokevirtual 277	android/media/MediaPlayer:setLooping	(Z)V
    //   986: aload_0
    //   987: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   990: invokevirtual 280	android/media/MediaPlayer:start	()V
    //   993: aload_0
    //   994: iload 5
    //   996: putfield 282	com/tencent/sharp/jni/TraeMediaPlayer:c	Z
    //   999: aload_0
    //   1000: getfield 282	com/tencent/sharp/jni/TraeMediaPlayer:c	Z
    //   1003: iconst_1
    //   1004: if_icmpne +209 -> 1213
    //   1007: aload_0
    //   1008: iconst_1
    //   1009: putfield 43	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   1012: aload_0
    //   1013: iconst_m1
    //   1014: putfield 41	com/tencent/sharp/jni/TraeMediaPlayer:g	I
    //   1017: aload_0
    //   1018: aload_0
    //   1019: getfield 43	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   1022: iconst_1
    //   1023: isub
    //   1024: putfield 43	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   1027: aload_0
    //   1028: getfield 146	com/tencent/sharp/jni/TraeMediaPlayer:b	Z
    //   1031: ifne +9 -> 1040
    //   1034: aload 10
    //   1036: iload_1
    //   1037: invokevirtual 285	android/media/AudioManager:setMode	(I)V
    //   1040: aload_0
    //   1041: getfield 41	com/tencent/sharp/jni/TraeMediaPlayer:g	I
    //   1044: ifle +46 -> 1090
    //   1047: aload_0
    //   1048: new 136	java/util/Timer
    //   1051: dup
    //   1052: invokespecial 286	java/util/Timer:<init>	()V
    //   1055: putfield 134	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   1058: aload_0
    //   1059: new 288	xri
    //   1062: dup
    //   1063: aload_0
    //   1064: invokespecial 291	xri:<init>	(Lcom/tencent/sharp/jni/TraeMediaPlayer;)V
    //   1067: putfield 141	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   1070: aload_0
    //   1071: getfield 134	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   1074: aload_0
    //   1075: getfield 141	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   1078: aload_0
    //   1079: getfield 41	com/tencent/sharp/jni/TraeMediaPlayer:g	I
    //   1082: sipush 1000
    //   1085: iadd
    //   1086: i2l
    //   1087: invokevirtual 295	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1090: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1093: ifeq +152 -> 1245
    //   1096: ldc 83
    //   1098: iconst_2
    //   1099: new 85	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 297
    //   1109: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload_0
    //   1113: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   1116: invokevirtual 300	android/media/MediaPlayer:getDuration	()I
    //   1119: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1122: ldc -88
    //   1124: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: iload 5
    //   1129: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1132: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1135: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1138: goto +107 -> 1245
    //   1141: getstatic 306	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1144: ldc_w 308
    //   1147: invokevirtual 314	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1150: ifeq +45 -> 1195
    //   1153: getstatic 317	android/os/Build:MODEL	Ljava/lang/String;
    //   1156: ldc_w 319
    //   1159: invokevirtual 314	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1162: ifeq +33 -> 1195
    //   1165: iload 8
    //   1167: ifne +28 -> 1195
    //   1170: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1173: ifeq +12 -> 1185
    //   1176: ldc 83
    //   1178: iconst_2
    //   1179: ldc_w 321
    //   1182: invokestatic 324	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1185: aload_0
    //   1186: iconst_2
    //   1187: putfield 39	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   1190: iconst_2
    //   1191: istore_1
    //   1192: goto -252 -> 940
    //   1195: aload_0
    //   1196: iconst_0
    //   1197: putfield 39	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   1200: getstatic 329	android/os/Build$VERSION:SDK_INT	I
    //   1203: bipush 11
    //   1205: if_icmplt -265 -> 940
    //   1208: iconst_3
    //   1209: istore_1
    //   1210: goto -270 -> 940
    //   1213: aload_0
    //   1214: iload 6
    //   1216: putfield 43	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   1219: aload_0
    //   1220: aload_0
    //   1221: getfield 43	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   1224: aload_0
    //   1225: getfield 55	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   1228: invokevirtual 300	android/media/MediaPlayer:getDuration	()I
    //   1231: imul
    //   1232: putfield 41	com/tencent/sharp/jni/TraeMediaPlayer:g	I
    //   1235: goto -218 -> 1017
    //   1238: astore_3
    //   1239: goto -841 -> 398
    //   1242: goto -686 -> 556
    //   1245: iconst_1
    //   1246: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1247	0	this	TraeMediaPlayer
    //   0	1247	1	paramInt1	int
    //   0	1247	2	paramInt2	int
    //   0	1247	3	paramUri	android.net.Uri
    //   0	1247	4	paramString	String
    //   0	1247	5	paramBoolean1	boolean
    //   0	1247	6	paramInt3	int
    //   0	1247	7	paramBoolean2	boolean
    //   0	1247	8	paramBoolean3	boolean
    //   0	1247	9	paramInt4	int
    //   64	237	10	localObject	Object
    //   334	701	10	localException	Exception
    //   55	48	11	localStringBuilder	StringBuilder
    //   243	3	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   252	259	334	java/lang/Exception
    //   229	245	344	java/lang/IllegalStateException
    //   259	264	344	java/lang/IllegalStateException
    //   264	288	344	java/lang/IllegalStateException
    //   288	332	344	java/lang/IllegalStateException
    //   336	341	344	java/lang/IllegalStateException
    //   406	413	344	java/lang/IllegalStateException
    //   513	529	344	java/lang/IllegalStateException
    //   556	587	344	java/lang/IllegalStateException
    //   587	599	344	java/lang/IllegalStateException
    //   599	606	344	java/lang/IllegalStateException
    //   608	639	344	java/lang/IllegalStateException
    //   639	651	344	java/lang/IllegalStateException
    //   655	686	344	java/lang/IllegalStateException
    //   686	698	344	java/lang/IllegalStateException
    //   700	723	344	java/lang/IllegalStateException
    //   776	807	344	java/lang/IllegalStateException
    //   807	819	344	java/lang/IllegalStateException
    //   873	906	344	java/lang/IllegalStateException
    //   906	915	344	java/lang/IllegalStateException
    //   918	924	344	java/lang/IllegalStateException
    //   926	938	344	java/lang/IllegalStateException
    //   940	959	344	java/lang/IllegalStateException
    //   959	1017	344	java/lang/IllegalStateException
    //   1017	1040	344	java/lang/IllegalStateException
    //   1040	1090	344	java/lang/IllegalStateException
    //   1090	1138	344	java/lang/IllegalStateException
    //   1141	1165	344	java/lang/IllegalStateException
    //   1170	1185	344	java/lang/IllegalStateException
    //   1185	1190	344	java/lang/IllegalStateException
    //   1195	1200	344	java/lang/IllegalStateException
    //   1200	1208	344	java/lang/IllegalStateException
    //   1213	1235	344	java/lang/IllegalStateException
    //   252	259	405	finally
    //   229	245	413	java/io/IOException
    //   259	264	413	java/io/IOException
    //   264	288	413	java/io/IOException
    //   288	332	413	java/io/IOException
    //   336	341	413	java/io/IOException
    //   406	413	413	java/io/IOException
    //   513	529	413	java/io/IOException
    //   556	587	413	java/io/IOException
    //   587	599	413	java/io/IOException
    //   599	606	413	java/io/IOException
    //   608	639	413	java/io/IOException
    //   639	651	413	java/io/IOException
    //   655	686	413	java/io/IOException
    //   686	698	413	java/io/IOException
    //   700	723	413	java/io/IOException
    //   776	807	413	java/io/IOException
    //   807	819	413	java/io/IOException
    //   873	906	413	java/io/IOException
    //   906	915	413	java/io/IOException
    //   918	924	413	java/io/IOException
    //   926	938	413	java/io/IOException
    //   940	959	413	java/io/IOException
    //   959	1017	413	java/io/IOException
    //   1017	1040	413	java/io/IOException
    //   1040	1090	413	java/io/IOException
    //   1090	1138	413	java/io/IOException
    //   1141	1165	413	java/io/IOException
    //   1170	1185	413	java/io/IOException
    //   1185	1190	413	java/io/IOException
    //   1195	1200	413	java/io/IOException
    //   1200	1208	413	java/io/IOException
    //   1213	1235	413	java/io/IOException
    //   229	245	463	java/lang/Exception
    //   259	264	463	java/lang/Exception
    //   264	288	463	java/lang/Exception
    //   288	332	463	java/lang/Exception
    //   336	341	463	java/lang/Exception
    //   345	391	463	java/lang/Exception
    //   406	413	463	java/lang/Exception
    //   414	460	463	java/lang/Exception
    //   513	529	463	java/lang/Exception
    //   556	587	463	java/lang/Exception
    //   587	599	463	java/lang/Exception
    //   599	606	463	java/lang/Exception
    //   608	639	463	java/lang/Exception
    //   639	651	463	java/lang/Exception
    //   655	686	463	java/lang/Exception
    //   686	698	463	java/lang/Exception
    //   700	723	463	java/lang/Exception
    //   727	773	463	java/lang/Exception
    //   776	807	463	java/lang/Exception
    //   807	819	463	java/lang/Exception
    //   823	870	463	java/lang/Exception
    //   873	906	463	java/lang/Exception
    //   906	915	463	java/lang/Exception
    //   918	924	463	java/lang/Exception
    //   926	938	463	java/lang/Exception
    //   940	959	463	java/lang/Exception
    //   959	1017	463	java/lang/Exception
    //   1017	1040	463	java/lang/Exception
    //   1040	1090	463	java/lang/Exception
    //   1090	1138	463	java/lang/Exception
    //   1141	1165	463	java/lang/Exception
    //   1170	1185	463	java/lang/Exception
    //   1185	1190	463	java/lang/Exception
    //   1195	1200	463	java/lang/Exception
    //   1200	1208	463	java/lang/Exception
    //   1213	1235	463	java/lang/Exception
    //   229	245	726	java/lang/IllegalArgumentException
    //   259	264	726	java/lang/IllegalArgumentException
    //   264	288	726	java/lang/IllegalArgumentException
    //   288	332	726	java/lang/IllegalArgumentException
    //   336	341	726	java/lang/IllegalArgumentException
    //   406	413	726	java/lang/IllegalArgumentException
    //   513	529	726	java/lang/IllegalArgumentException
    //   556	587	726	java/lang/IllegalArgumentException
    //   587	599	726	java/lang/IllegalArgumentException
    //   599	606	726	java/lang/IllegalArgumentException
    //   608	639	726	java/lang/IllegalArgumentException
    //   639	651	726	java/lang/IllegalArgumentException
    //   655	686	726	java/lang/IllegalArgumentException
    //   686	698	726	java/lang/IllegalArgumentException
    //   700	723	726	java/lang/IllegalArgumentException
    //   776	807	726	java/lang/IllegalArgumentException
    //   807	819	726	java/lang/IllegalArgumentException
    //   873	906	726	java/lang/IllegalArgumentException
    //   906	915	726	java/lang/IllegalArgumentException
    //   918	924	726	java/lang/IllegalArgumentException
    //   926	938	726	java/lang/IllegalArgumentException
    //   940	959	726	java/lang/IllegalArgumentException
    //   959	1017	726	java/lang/IllegalArgumentException
    //   1017	1040	726	java/lang/IllegalArgumentException
    //   1040	1090	726	java/lang/IllegalArgumentException
    //   1090	1138	726	java/lang/IllegalArgumentException
    //   1141	1165	726	java/lang/IllegalArgumentException
    //   1170	1185	726	java/lang/IllegalArgumentException
    //   1185	1190	726	java/lang/IllegalArgumentException
    //   1195	1200	726	java/lang/IllegalArgumentException
    //   1200	1208	726	java/lang/IllegalArgumentException
    //   1213	1235	726	java/lang/IllegalArgumentException
    //   229	245	822	java/lang/SecurityException
    //   259	264	822	java/lang/SecurityException
    //   264	288	822	java/lang/SecurityException
    //   288	332	822	java/lang/SecurityException
    //   336	341	822	java/lang/SecurityException
    //   406	413	822	java/lang/SecurityException
    //   513	529	822	java/lang/SecurityException
    //   556	587	822	java/lang/SecurityException
    //   587	599	822	java/lang/SecurityException
    //   599	606	822	java/lang/SecurityException
    //   608	639	822	java/lang/SecurityException
    //   639	651	822	java/lang/SecurityException
    //   655	686	822	java/lang/SecurityException
    //   686	698	822	java/lang/SecurityException
    //   700	723	822	java/lang/SecurityException
    //   776	807	822	java/lang/SecurityException
    //   807	819	822	java/lang/SecurityException
    //   873	906	822	java/lang/SecurityException
    //   906	915	822	java/lang/SecurityException
    //   918	924	822	java/lang/SecurityException
    //   926	938	822	java/lang/SecurityException
    //   940	959	822	java/lang/SecurityException
    //   959	1017	822	java/lang/SecurityException
    //   1017	1040	822	java/lang/SecurityException
    //   1040	1090	822	java/lang/SecurityException
    //   1090	1138	822	java/lang/SecurityException
    //   1141	1165	822	java/lang/SecurityException
    //   1170	1185	822	java/lang/SecurityException
    //   1185	1190	822	java/lang/SecurityException
    //   1195	1200	822	java/lang/SecurityException
    //   1200	1208	822	java/lang/SecurityException
    //   1213	1235	822	java/lang/SecurityException
    //   391	398	1238	java/lang/Exception
  }
  
  public int b()
  {
    return this.g;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener + " loopCount:" + this.e + " _loop:" + this.c);
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "loop play,continue...");
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (this.e > 0) {
          continue;
        }
        c();
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener != null) {
          this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener.a();
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception paramMediaPlayer)
      {
        continue;
      }
      return;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.e -= 1;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener != null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener.a();
      }
      AudioDeviceInterface.LogTraceExit();
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\sharp\jni\TraeMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */