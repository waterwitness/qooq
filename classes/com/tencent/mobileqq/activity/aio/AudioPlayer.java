package com.tencent.mobileqq.activity.aio;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.player.IPttPlayer;
import com.tencent.mobileqq.ptt.player.IPttPlayerListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import nch;
import nci;
import ncj;

public class AudioPlayer
  implements IPttPlayerListener, Runnable
{
  private static final float jdField_a_of_type_Float = 0.1F;
  public static int a = 0;
  private static final long jdField_a_of_type_Long = 200L;
  public static final String a = "AudioPlayer";
  private static final List jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(1796) });
  public static boolean a = false;
  public static final int b = -1;
  public static boolean b = false;
  public static final int c = -2;
  public static final int d = 0;
  public static final int e = 1;
  private static boolean jdField_f_of_type_Boolean = false;
  private static int h = 0;
  private static final int i = 1000;
  private Application jdField_a_of_type_AndroidAppApplication;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new nch(this);
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener;
  private IPttPlayer jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer;
  private volatile AudioHelper.AudioPlayerParameter jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  private String b;
  private boolean c;
  private boolean d;
  private boolean e = true;
  private volatile int jdField_f_of_type_Int = jdField_a_of_type_Int;
  private volatile int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = 64537;
    h = -1;
  }
  
  public AudioPlayer(Context paramContext, AudioPlayer.AudioPlayerListener paramAudioPlayerListener)
  {
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = paramAudioPlayerListener;
  }
  
  private AudioHelper.AudioPlayerParameter a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = AudioHelper.a();
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) && (jdField_a_of_type_Boolean)) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[4];
    }
    if (this.c) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2];
    }
    if (this.d) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3];
    }
    AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
    if (this.e) {}
    for (int j = 0;; j = 1) {
      return arrayOfAudioPlayerParameter[j];
    }
  }
  
  private void a(AudioManager paramAudioManager)
  {
    paramAudioManager.setBluetoothScoOn(true);
  }
  
  public static boolean a(AudioManager paramAudioManager)
  {
    if (!jdField_a_of_type_Boolean) {}
    BluetoothAdapter localBluetoothAdapter;
    do
    {
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 14);
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    } while ((localBluetoothAdapter == null) || (!localBluetoothAdapter.isEnabled()) || (localBluetoothAdapter.getProfileConnectionState(1) != 2) || (localBluetoothAdapter.getProfileConnectionState(2) == 2) || (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(h))) || (jdField_f_of_type_Boolean) || (paramAudioManager.isBluetoothScoOn()) || (!paramAudioManager.isBluetoothScoAvailableOffCall()));
    return true;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      b(this.jdField_b_of_type_JavaLangString, paramInt);
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "tryStartBlueToothSco " + paramString);
    }
    f();
    paramString = new ncj(this, paramString, paramInt);
    this.jdField_a_of_type_AndroidAppApplication.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = paramString;
    this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
  }
  
  /* Error */
  private boolean b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 13
    //   3: iconst_m1
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: iload_2
    //   8: istore 9
    //   10: iload_2
    //   11: ifge +6 -> 17
    //   14: iconst_0
    //   15: istore 9
    //   17: invokestatic 238	java/lang/System:currentTimeMillis	()J
    //   20: lstore 10
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 185	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   27: aload_0
    //   28: invokestatic 243	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: getstatic 54	com/tencent/mobileqq/activity/aio/AudioPlayer:h	I
    //   35: iconst_m1
    //   36: if_icmpne +19 -> 55
    //   39: aload_0
    //   40: aload_1
    //   41: iload 9
    //   43: invokevirtual 245	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Ljava/lang/String;I)V
    //   46: iload 13
    //   48: istore 12
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 12
    //   54: ireturn
    //   55: aload_0
    //   56: getfield 104	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   59: invokestatic 247	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   62: ifeq +22 -> 84
    //   65: aload_0
    //   66: aload_1
    //   67: iload 9
    //   69: invokespecial 249	com/tencent/mobileqq/activity/aio/AudioPlayer:b	(Ljava/lang/String;I)V
    //   72: iload 13
    //   74: istore 12
    //   76: goto -26 -> 50
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: invokestatic 254	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   88: ifne +63 -> 151
    //   91: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +29 -> 123
    //   97: ldc 19
    //   99: iconst_2
    //   100: new 193	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 256
    //   110: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_1
    //   114: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_0
    //   124: invokevirtual 258	com/tencent/mobileqq/activity/aio/AudioPlayer:c	()V
    //   127: aload_0
    //   128: getfield 106	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   131: ifnull +14 -> 145
    //   134: aload_0
    //   135: getfield 106	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   138: aload_0
    //   139: iconst_m1
    //   140: invokeinterface 262 3 0
    //   145: iconst_0
    //   146: istore 12
    //   148: goto -98 -> 50
    //   151: aload_0
    //   152: invokespecial 264	com/tencent/mobileqq/activity/aio/AudioPlayer:e	()V
    //   155: new 266	java/io/FileInputStream
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   163: astore 7
    //   165: aload 7
    //   167: astore 6
    //   169: aload 7
    //   171: invokestatic 272	com/tencent/mobileqq/utils/RecordParams:a	(Ljava/io/InputStream;)B
    //   174: istore 4
    //   176: aload 7
    //   178: astore 6
    //   180: iload 4
    //   182: istore_3
    //   183: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +47 -> 233
    //   189: aload 7
    //   191: astore 6
    //   193: iload 4
    //   195: istore_3
    //   196: ldc 19
    //   198: iconst_2
    //   199: new 193	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 274
    //   209: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_1
    //   213: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 276
    //   219: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 4
    //   224: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: iload 4
    //   235: istore 5
    //   237: aload 7
    //   239: ifnull +12 -> 251
    //   242: aload 7
    //   244: invokevirtual 284	java/io/InputStream:close	()V
    //   247: iload 4
    //   249: istore 5
    //   251: iload 5
    //   253: iflt +240 -> 493
    //   256: aload_0
    //   257: new 286	com/tencent/mobileqq/ptt/player/SilkPlayer
    //   260: dup
    //   261: invokespecial 287	com/tencent/mobileqq/ptt/player/SilkPlayer:<init>	()V
    //   264: putfield 117	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   267: aload_0
    //   268: getfield 117	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   271: aload_1
    //   272: invokeinterface 291 2 0
    //   277: aload_0
    //   278: getfield 117	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   281: iload 9
    //   283: invokeinterface 292 2 0
    //   288: aload_0
    //   289: getfield 117	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   292: iconst_m1
    //   293: iload 5
    //   295: invokeinterface 295 3 0
    //   300: aload_0
    //   301: getfield 117	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   304: aload_0
    //   305: invokeinterface 298 2 0
    //   310: aload_0
    //   311: getfield 117	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   314: invokeinterface 300 1 0
    //   319: iload 13
    //   321: istore 12
    //   323: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -276 -> 50
    //   329: ldc_w 302
    //   332: iconst_2
    //   333: new 193	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 304
    //   343: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokestatic 238	java/lang/System:currentTimeMillis	()J
    //   349: lload 10
    //   351: lsub
    //   352: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: iload 13
    //   363: istore 12
    //   365: goto -315 -> 50
    //   368: astore 8
    //   370: aconst_null
    //   371: astore 7
    //   373: aload 7
    //   375: astore 6
    //   377: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +37 -> 417
    //   383: aload 7
    //   385: astore 6
    //   387: ldc 19
    //   389: iconst_2
    //   390: new 193	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 309
    //   400: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload 8
    //   405: invokevirtual 312	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   408: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: iload_3
    //   418: istore 5
    //   420: aload 7
    //   422: ifnull -171 -> 251
    //   425: aload 7
    //   427: invokevirtual 284	java/io/InputStream:close	()V
    //   430: iload_3
    //   431: istore 5
    //   433: goto -182 -> 251
    //   436: astore 6
    //   438: iload_3
    //   439: istore 5
    //   441: goto -190 -> 251
    //   444: astore_1
    //   445: aconst_null
    //   446: astore 6
    //   448: aload 6
    //   450: ifnull +8 -> 458
    //   453: aload 6
    //   455: invokevirtual 284	java/io/InputStream:close	()V
    //   458: aload_1
    //   459: athrow
    //   460: astore_1
    //   461: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq +13 -> 477
    //   467: ldc 19
    //   469: iconst_2
    //   470: ldc_w 314
    //   473: aload_1
    //   474: invokestatic 317	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   477: aload_0
    //   478: aload_0
    //   479: getfield 117	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   482: iconst_0
    //   483: iconst_0
    //   484: invokevirtual 320	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Lcom/tencent/mobileqq/ptt/player/IPttPlayer;II)V
    //   487: iconst_0
    //   488: istore 12
    //   490: goto -440 -> 50
    //   493: aload_0
    //   494: new 322	com/tencent/mobileqq/ptt/player/AmrPlayer
    //   497: dup
    //   498: invokespecial 323	com/tencent/mobileqq/ptt/player/AmrPlayer:<init>	()V
    //   501: putfield 117	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   504: goto -237 -> 267
    //   507: astore 6
    //   509: iload 4
    //   511: istore 5
    //   513: goto -262 -> 251
    //   516: astore 6
    //   518: goto -60 -> 458
    //   521: astore_1
    //   522: goto -74 -> 448
    //   525: astore 8
    //   527: goto -154 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	AudioPlayer
    //   0	530	1	paramString	String
    //   0	530	2	paramInt	int
    //   4	435	3	b1	byte
    //   174	336	4	b2	byte
    //   235	277	5	b3	byte
    //   167	219	6	localFileInputStream1	java.io.FileInputStream
    //   436	1	6	localException1	Exception
    //   446	8	6	localObject	Object
    //   507	1	6	localException2	Exception
    //   516	1	6	localException3	Exception
    //   163	263	7	localFileInputStream2	java.io.FileInputStream
    //   368	36	8	localException4	Exception
    //   525	1	8	localException5	Exception
    //   8	274	9	j	int
    //   20	330	10	l	long
    //   48	441	12	bool1	boolean
    //   1	361	13	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   17	46	79	finally
    //   55	72	79	finally
    //   84	123	79	finally
    //   123	145	79	finally
    //   151	155	79	finally
    //   242	247	79	finally
    //   256	267	79	finally
    //   267	319	79	finally
    //   323	361	79	finally
    //   425	430	79	finally
    //   453	458	79	finally
    //   458	460	79	finally
    //   461	477	79	finally
    //   477	487	79	finally
    //   493	504	79	finally
    //   155	165	368	java/lang/Exception
    //   425	430	436	java/lang/Exception
    //   155	165	444	finally
    //   151	155	460	java/lang/Exception
    //   256	267	460	java/lang/Exception
    //   267	319	460	java/lang/Exception
    //   458	460	460	java/lang/Exception
    //   493	504	460	java/lang/Exception
    //   242	247	507	java/lang/Exception
    //   453	458	516	java/lang/Exception
    //   169	176	521	finally
    //   183	189	521	finally
    //   196	233	521	finally
    //   377	383	521	finally
    //   387	417	521	finally
    //   169	176	525	java/lang/Exception
    //   183	189	525	java/lang/Exception
    //   196	233	525	java/lang/Exception
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a()) {
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = null;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.b();
  }
  
  public void a()
  {
    f();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(IPttPlayer paramIPttPlayer, int paramInt1, int paramInt2)
  {
    f();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this, -2);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      h = 0;
      b(paramString, paramInt);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      h = 0;
      b(paramString, paramInt);
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      h = 0;
      b(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) != 2)
    {
      h = 0;
      b(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      h = 0;
      b(paramString, paramInt);
      return;
    }
    paramString = new nci(this, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (a()) {
      b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a() - MediaPlayerManager.jdField_a_of_type_Int);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a());
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, 0);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return b(paramString, paramInt);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false, 0);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!this.c) && (!this.d) && ((paramBoolean1 != this.e) || (paramBoolean2)))
    {
      this.e = paramBoolean1;
      if (a()) {
        b(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = a();
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_a_of_type_Boolean);
    if (this.jdField_f_of_type_Int != jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b = this.jdField_f_of_type_Int;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.b(this, this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b);
    }
    AudioUtil.a(this.jdField_a_of_type_AndroidAppApplication, true);
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b);
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.g();
    int j = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b);
    int k = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b);
    if (j / k < 0.1F)
    {
      this.g = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.c(this, this.g);
      }
      return;
      this.g = 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (a()) {
      b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a() - MediaPlayerManager.jdField_a_of_type_Int);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a()) {
          this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.d();
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.e();
        this.jdField_b_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = null;
        this.jdField_f_of_type_Int = jdField_a_of_type_Int;
        ThreadManager.a(this, 8, null, false);
      }
      return;
    }
    finally {}
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 0;; j = -1)
    {
      h = j;
      jdField_f_of_type_Boolean = false;
      return;
    }
  }
  
  public boolean c()
  {
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(h))) {
      return false;
    }
    return this.d;
  }
  
  public void d()
  {
    if ((jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()))
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      jdField_b_of_type_Boolean = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = -1;; j = 0)
    {
      h = j;
      jdField_f_of_type_Boolean = false;
      return;
    }
  }
  
  public void run()
  {
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
    AudioUtil.a(this.jdField_a_of_type_AndroidAppApplication, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\AudioPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */