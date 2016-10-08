package com.tencent.sharp.jni;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import xqt;

public class AudioDeviceInterface
{
  private static boolean _dumpEnable;
  private static boolean _logEnable = true;
  private int _RecordSamplerate = 8000;
  private TraeAudioSession _as;
  private AudioManager _audioManager;
  private AudioRecord _audioRecord;
  private boolean _audioRecordChanged;
  private boolean _audioRouteChanged;
  private int _audioSource = 0;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack;
  private int _bufferedPlaySamples;
  private int _bufferedRecSamples;
  private String _connectedDev = "DEVICE_NONE";
  private Context _context;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying;
  private boolean _isRecording;
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition;
  private int _playSamplerate = 8000;
  private File _play_dump;
  private FileOutputStream _play_out;
  private boolean _preDone;
  private Condition _precon = this._prelock.newCondition();
  private ReentrantLock _prelock = new ReentrantLock();
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private File _rec_dump;
  private FileOutputStream _rec_out;
  private int _sessionId;
  private int _streamType = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private int switchState;
  private boolean usingJava = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AudioDeviceInterface()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(960);
      this._recBuffer = ByteBuffer.allocateDirect(960);
      this._tempBufPlay = new byte['π'];
      this._tempBufRec = new byte['π'];
      int i = Build.VERSION.SDK_INT;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:" + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
      }
      if ((i > 0) || (QLog.isColorLevel())) {
        QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException.getMessage());
        }
      }
    }
  }
  
  private int GetPlayoutVolume()
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null) {
      i = this._audioManager.getStreamVolume(0);
    }
    return i;
  }
  
  private int InitPlayback(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback entry: sampleRate " + paramInt);
    }
    if ((this._isPlaying) || (this._audioTrack != null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
      }
      return -1;
    }
    if (this._audioManager == null) {}
    for (;;)
    {
      int i;
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        this._playSamplerate = paramInt;
        int k = AudioTrack.getMinBufferSize(paramInt, 4, 2);
        int m = paramInt * 20 * 1 * 2 / 1000;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitPlayback: minPlayBufSize:" + k + " 20msFz:" + m);
        }
        this._bufferedPlaySamples = 0;
        if (this._audioTrack != null)
        {
          this._audioTrack.release();
          this._audioTrack = null;
        }
        int[] arrayOfInt = new int[4];
        int[] tmp202_201 = arrayOfInt;
        tmp202_201[0] = 0;
        int[] tmp206_202 = tmp202_201;
        tmp206_202[1] = 0;
        int[] tmp210_206 = tmp206_202;
        tmp210_206[2] = 3;
        int[] tmp214_210 = tmp210_206;
        tmp214_210[3] = 1;
        tmp214_210;
        this._streamType = TraeAudioManager.b(this._audioStreamTypePolicy);
        if (!this._audioRouteChanged)
        {
          arrayOfInt[0] = this._streamType;
          i = 0;
          paramInt = k;
          if ((i >= arrayOfInt.length) || (this._audioTrack != null)) {
            break;
          }
          this._streamType = arrayOfInt[i];
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + k + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
          }
          int j = 1;
          if (j > 2) {
            break label624;
          }
          paramInt = k * j;
          if ((paramInt >= m * 4) || (j >= 2)) {
            break label465;
          }
          j += 1;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label422;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException1.getMessage());
        }
        return -1;
      }
      QLog.w("TRAE", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
      label422:
      if ((this._audioManager.getMode() == 0) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {}
      for (this._streamType = 3;; this._streamType = 0)
      {
        this._audioRouteChanged = false;
        break;
      }
      try
      {
        label465:
        this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, 4, 2, paramInt, 1);
        if (this._audioTrack.getState() == 1) {
          break label624;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + paramInt + " sr:" + this._playSamplerate);
        }
        this._audioTrack.release();
        this._audioTrack = null;
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException2.getMessage() + " _audioTrack:" + this._audioTrack);
        }
        if (this._audioTrack != null) {
          this._audioTrack.release();
        }
        this._audioTrack = null;
      }
      continue;
      label624:
      i += 1;
    }
    if (this._audioTrack == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitPlayback fail!!!");
      }
      return -1;
    }
    if ((this._as != null) && (this._audioManager != null)) {
      this._as.b(this._audioManager.getMode(), this._streamType);
    }
    this._playPosition = this._audioTrack.getPlaybackHeadPosition();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + paramInt);
    }
    AudioManager localAudioManager = this._audioManager;
    if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET")) {}
    for (paramInt = 6;; paramInt = this._audioTrack.getStreamType())
    {
      TraeAudioManager.a(localAudioManager, paramInt);
      return 0;
    }
  }
  
  private int InitRecording(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording entry:" + paramInt);
    }
    if ((this._isRecording) || (this._audioRecord != null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
      }
      return -1;
    }
    if (this._audioManager == null) {}
    int i;
    for (;;)
    {
      int j;
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        this._RecordSamplerate = paramInt;
        int m = AudioRecord.getMinBufferSize(paramInt, 16, 2);
        int n = paramInt * 20 * 1 * 2 / 1000;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording: min rec buf size is " + m + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + n);
        }
        this._bufferedRecSamples = (paramInt * 5 / 200);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "  rough rec delay set to " + this._bufferedRecSamples);
        }
        if (this._audioRecord != null)
        {
          this._audioRecord.release();
          this._audioRecord = null;
        }
        int[] arrayOfInt = new int[4];
        int[] tmp274_273 = arrayOfInt;
        tmp274_273[0] = 0;
        int[] tmp278_274 = tmp274_273;
        tmp278_274[1] = 1;
        int[] tmp282_278 = tmp278_274;
        tmp282_278[2] = 5;
        int[] tmp286_282 = tmp282_278;
        tmp286_282[3] = 0;
        tmp286_282;
        arrayOfInt[0] = TraeAudioManager.a(this._audioSourcePolicy);
        if (!this._audioRecordChanged)
        {
          j = 0;
          i = m;
          if ((j >= arrayOfInt.length) || (this._audioRecord != null)) {
            break;
          }
          this._audioSource = arrayOfInt[j];
          int k = 1;
          if (k > 2) {
            break label646;
          }
          i = m * k;
          if ((i >= n * 4) || (k >= 2)) {
            break label478;
          }
          k += 1;
          continue;
        }
        if (this._audioManager.getMode() != 0) {
          break label467;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException1.getMessage());
        }
        return -1;
      }
      if (this._connectedDev.equals("DEVICE_SPEAKERPHONE")) {
        localException1[0] = TraeAudioManager.a(0);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording _audioRecordChanged as[0]:" + localException1[0]);
        }
        this._audioRecordChanged = false;
        break;
        label467:
        localException1[0] = TraeAudioManager.a(7);
      }
      try
      {
        label478:
        this._audioRecord = new AudioRecord(this._audioSource, paramInt, 16, 2, i);
        if (this._audioRecord.getState() == 1) {
          break label646;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + i + " sr:" + paramInt + " as:" + this._audioSource);
        }
        this._audioRecord.release();
        this._audioRecord = null;
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException2.getMessage() + " _audioRecord:" + this._audioRecord);
        }
        if (this._audioRecord != null) {
          this._audioRecord.release();
        }
        this._audioRecord = null;
      }
      continue;
      label646:
      j += 1;
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitRecording fail!!!");
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt + " recBufSize:" + i);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording exit");
    }
    return this._bufferedRecSamples;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy);
    }
    return 0;
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    if (!_logEnable) {}
    do
    {
      return;
      paramString = getTraceInfo() + " entry:" + paramString;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, paramString);
  }
  
  public static final void LogTraceExit()
  {
    if (!_logEnable) {}
    String str;
    do
    {
      return;
      str = getTraceInfo() + " exit";
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, str);
  }
  
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!TraeAudioManager.a(this._modePolicy)) {
          return -1;
        }
        if ((this._audioRouteChanged) || (paramBoolean))
        {
          if ((this._audioManager == null) && (this._context != null)) {
            this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
          }
          if (this._audioManager == null) {
            return 0;
          }
          if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
            continue;
          }
          this._audioStreamTypePolicy = 3;
          this._audioRouteChanged = false;
          this._audioRecordChanged = false;
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 2, "PlayAudio Exception: " + localException.getMessage());
        continue;
      }
      finally {}
      return this._audioStreamTypePolicy;
      this._audioStreamTypePolicy = 0;
    }
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 201	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   4: ifne +74 -> 78
    //   7: iconst_1
    //   8: istore 4
    //   10: aload_0
    //   11: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   14: ifnonnull +70 -> 84
    //   17: iconst_1
    //   18: istore 5
    //   20: iload 4
    //   22: iload 5
    //   24: ior
    //   25: ifeq +65 -> 90
    //   28: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +45 -> 76
    //   34: ldc -117
    //   36: iconst_2
    //   37: new 141	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 391
    //   47: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 201	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   54: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: ldc_w 393
    //   60: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   67: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: iconst_m1
    //   77: ireturn
    //   78: iconst_0
    //   79: istore 4
    //   81: goto -71 -> 10
    //   84: iconst_0
    //   85: istore 5
    //   87: goto -67 -> 20
    //   90: aload_0
    //   91: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   94: invokevirtual 396	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   97: aload_0
    //   98: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   101: astore_2
    //   102: aload_2
    //   103: ifnonnull +13 -> 116
    //   106: aload_0
    //   107: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   110: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   113: bipush -2
    //   115: ireturn
    //   116: aload_0
    //   117: getfield 96	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   120: istore 11
    //   122: iload 11
    //   124: iconst_1
    //   125: if_icmpne +13 -> 138
    //   128: bipush -19
    //   130: invokestatic 405	android/os/Process:setThreadPriority	(I)V
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 96	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   138: getstatic 407	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   141: ifeq +25 -> 166
    //   144: aload_0
    //   145: getfield 409	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   148: astore_2
    //   149: aload_2
    //   150: ifnull +16 -> 166
    //   153: aload_0
    //   154: getfield 409	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   157: aload_0
    //   158: getfield 124	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   161: iconst_0
    //   162: iconst_0
    //   163: invokevirtual 415	java/io/FileOutputStream:write	([BII)V
    //   166: aload_0
    //   167: getfield 233	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   170: ifne +492 -> 662
    //   173: iconst_0
    //   174: istore 4
    //   176: aload_0
    //   177: getfield 120	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   180: aload_0
    //   181: getfield 124	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   184: invokevirtual 419	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   187: pop
    //   188: iload 4
    //   190: ifeq +921 -> 1111
    //   193: aload_0
    //   194: getfield 120	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   197: invokevirtual 423	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   200: pop
    //   201: invokestatic 429	android/os/SystemClock:elapsedRealtime	()J
    //   204: lstore 9
    //   206: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +48 -> 257
    //   212: ldc -117
    //   214: iconst_2
    //   215: new 141	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 431
    //   225: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: getfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   232: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: ldc_w 433
    //   238: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_0
    //   242: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   245: invokevirtual 301	android/media/AudioTrack:getStreamType	()I
    //   248: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload_0
    //   258: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   261: invokevirtual 436	android/media/AudioTrack:getPlayState	()I
    //   264: istore 4
    //   266: iload 4
    //   268: iconst_3
    //   269: if_icmpne +120 -> 389
    //   272: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +12 -> 287
    //   278: ldc -117
    //   280: iconst_2
    //   281: ldc_w 438
    //   284: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_0
    //   288: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   291: invokevirtual 441	android/media/AudioTrack:stop	()V
    //   294: aload_0
    //   295: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   298: invokevirtual 444	android/media/AudioTrack:flush	()V
    //   301: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +35 -> 339
    //   307: ldc -117
    //   309: iconst_2
    //   310: new 141	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 446
    //   320: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_0
    //   324: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   327: invokevirtual 436	android/media/AudioTrack:getPlayState	()I
    //   330: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload_0
    //   340: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   343: invokevirtual 226	android/media/AudioTrack:release	()V
    //   346: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +35 -> 384
    //   352: ldc -117
    //   354: iconst_2
    //   355: new 141	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 448
    //   365: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_0
    //   369: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   372: invokevirtual 436	android/media/AudioTrack:getPlayState	()I
    //   375: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   389: aload_0
    //   390: getfield 77	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   393: iconst_4
    //   394: iconst_2
    //   395: invokestatic 217	android/media/AudioTrack:getMinBufferSize	(III)I
    //   398: istore 6
    //   400: iconst_4
    //   401: newarray <illegal type>
    //   403: astore_2
    //   404: aload_2
    //   405: dup
    //   406: iconst_0
    //   407: iconst_0
    //   408: iastore
    //   409: dup
    //   410: iconst_1
    //   411: iconst_0
    //   412: iastore
    //   413: dup
    //   414: iconst_2
    //   415: iconst_3
    //   416: iastore
    //   417: dup
    //   418: iconst_3
    //   419: iconst_1
    //   420: iastore
    //   421: pop
    //   422: aload_2
    //   423: iconst_0
    //   424: aload_0
    //   425: getfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   428: iastore
    //   429: aload_0
    //   430: getfield 77	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   433: bipush 20
    //   435: imul
    //   436: iconst_1
    //   437: imul
    //   438: iconst_2
    //   439: imul
    //   440: sipush 1000
    //   443: idiv
    //   444: istore 7
    //   446: iconst_0
    //   447: istore 4
    //   449: iload 4
    //   451: aload_2
    //   452: arraylength
    //   453: if_icmpge +524 -> 977
    //   456: aload_0
    //   457: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   460: ifnonnull +517 -> 977
    //   463: aload_0
    //   464: aload_2
    //   465: iload 4
    //   467: iaload
    //   468: putfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   471: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +44 -> 518
    //   477: ldc -117
    //   479: iconst_2
    //   480: new 141	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   487: ldc -21
    //   489: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: iload 6
    //   494: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: ldc -19
    //   499: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_0
    //   503: getfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   506: invokestatic 240	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   509: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: iconst_1
    //   519: istore 5
    //   521: iload 5
    //   523: iconst_2
    //   524: if_icmpgt +811 -> 1335
    //   527: iload 6
    //   529: iload 5
    //   531: imul
    //   532: istore 8
    //   534: iload 8
    //   536: iload 7
    //   538: iconst_4
    //   539: imul
    //   540: if_icmpge +241 -> 781
    //   543: iload 5
    //   545: iconst_2
    //   546: if_icmpge +235 -> 781
    //   549: iload 5
    //   551: iconst_1
    //   552: iadd
    //   553: istore 5
    //   555: goto -34 -> 521
    //   558: astore_2
    //   559: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq -429 -> 133
    //   565: ldc -117
    //   567: iconst_2
    //   568: new 141	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 450
    //   578: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload_2
    //   582: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   585: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: goto -461 -> 133
    //   597: astore_2
    //   598: iconst_0
    //   599: istore_1
    //   600: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   603: ifeq +32 -> 635
    //   606: ldc -117
    //   608: iconst_2
    //   609: new 141	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   616: ldc_w 384
    //   619: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload_2
    //   623: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   626: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: aload_0
    //   636: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   639: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   642: iload_1
    //   643: ireturn
    //   644: astore_2
    //   645: aload_2
    //   646: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   649: goto -483 -> 166
    //   652: astore_2
    //   653: aload_0
    //   654: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   657: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   660: aload_2
    //   661: athrow
    //   662: aload_0
    //   663: getfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   666: ifnonnull +26 -> 692
    //   669: aload_0
    //   670: getfield 182	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   673: ifnull +19 -> 692
    //   676: aload_0
    //   677: aload_0
    //   678: getfield 182	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   681: ldc -72
    //   683: invokevirtual 190	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   686: checkcast 192	android/media/AudioManager
    //   689: putfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   692: aload_0
    //   693: getfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   696: invokevirtual 247	android/media/AudioManager:getMode	()I
    //   699: ifne +45 -> 744
    //   702: aload_0
    //   703: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   706: ldc -7
    //   708: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   711: ifeq +33 -> 744
    //   714: aload_0
    //   715: iconst_3
    //   716: putfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   719: aload_0
    //   720: getfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   723: aload_0
    //   724: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   727: invokevirtual 301	android/media/AudioTrack:getStreamType	()I
    //   730: if_icmpne +22 -> 752
    //   733: iconst_0
    //   734: istore 4
    //   736: aload_0
    //   737: iconst_0
    //   738: putfield 233	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   741: goto -565 -> 176
    //   744: aload_0
    //   745: iconst_0
    //   746: putfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   749: goto -30 -> 719
    //   752: iconst_1
    //   753: istore 4
    //   755: goto -19 -> 736
    //   758: astore_2
    //   759: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   762: ifeq -373 -> 389
    //   765: ldc -117
    //   767: iconst_2
    //   768: ldc_w 455
    //   771: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: goto -385 -> 389
    //   777: astore_2
    //   778: goto -178 -> 600
    //   781: aload_0
    //   782: new 213	android/media/AudioTrack
    //   785: dup
    //   786: aload_0
    //   787: getfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   790: aload_0
    //   791: getfield 77	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   794: iconst_4
    //   795: iconst_2
    //   796: iload 8
    //   798: iconst_1
    //   799: invokespecial 258	android/media/AudioTrack:<init>	(IIIIII)V
    //   802: putfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   805: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   808: ifeq +32 -> 840
    //   811: ldc -117
    //   813: iconst_2
    //   814: new 141	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 267
    //   824: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: aload_0
    //   828: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   831: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   840: aload_0
    //   841: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   844: invokevirtual 261	android/media/AudioTrack:getState	()I
    //   847: iconst_1
    //   848: if_icmpeq +487 -> 1335
    //   851: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   854: ifeq +43 -> 897
    //   857: ldc -117
    //   859: iconst_2
    //   860: new 141	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   867: ldc_w 263
    //   870: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: iload 8
    //   875: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   878: ldc_w 265
    //   881: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: aload_0
    //   885: getfield 77	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   888: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   891: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: aload_0
    //   898: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   901: invokevirtual 226	android/media/AudioTrack:release	()V
    //   904: aload_0
    //   905: aconst_null
    //   906: putfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   909: goto -360 -> 549
    //   912: astore_3
    //   913: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   916: ifeq +39 -> 955
    //   919: ldc -117
    //   921: iconst_2
    //   922: new 141	java/lang/StringBuilder
    //   925: dup
    //   926: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   929: aload_3
    //   930: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   933: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: ldc_w 267
    //   939: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: aload_0
    //   943: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   946: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   949: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   955: aload_0
    //   956: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   959: ifnull +10 -> 969
    //   962: aload_0
    //   963: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   966: invokevirtual 226	android/media/AudioTrack:release	()V
    //   969: aload_0
    //   970: aconst_null
    //   971: putfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   974: goto -425 -> 549
    //   977: aload_0
    //   978: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   981: astore_2
    //   982: aload_2
    //   983: ifnull +57 -> 1040
    //   986: aload_0
    //   987: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   990: invokevirtual 458	android/media/AudioTrack:play	()V
    //   993: aload_0
    //   994: getfield 274	com/tencent/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   997: aload_0
    //   998: getfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1001: invokevirtual 247	android/media/AudioManager:getMode	()I
    //   1004: aload_0
    //   1005: getfield 75	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   1008: invokevirtual 279	com/tencent/sharp/jni/TraeAudioSession:b	(II)I
    //   1011: pop
    //   1012: aload_0
    //   1013: getfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1016: astore_2
    //   1017: aload_0
    //   1018: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1021: ldc_w 294
    //   1024: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1027: ifeq +72 -> 1099
    //   1030: bipush 6
    //   1032: istore 4
    //   1034: aload_2
    //   1035: iload 4
    //   1037: invokestatic 298	com/tencent/sharp/jni/TraeAudioManager:a	(Landroid/media/AudioManager;I)V
    //   1040: iload_1
    //   1041: istore 4
    //   1043: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1046: ifeq +43 -> 1089
    //   1049: ldc -117
    //   1051: iconst_2
    //   1052: new 141	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1059: ldc_w 460
    //   1062: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: invokestatic 429	android/os/SystemClock:elapsedRealtime	()J
    //   1068: lload 9
    //   1070: lsub
    //   1071: invokevirtual 463	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1074: ldc_w 465
    //   1077: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1083: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1086: iload_1
    //   1087: istore 4
    //   1089: aload_0
    //   1090: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1093: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1096: iload 4
    //   1098: ireturn
    //   1099: aload_0
    //   1100: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1103: invokevirtual 301	android/media/AudioTrack:getStreamType	()I
    //   1106: istore 4
    //   1108: goto -74 -> 1034
    //   1111: aload_0
    //   1112: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1115: aload_0
    //   1116: getfield 124	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1119: iconst_0
    //   1120: iload_1
    //   1121: invokevirtual 468	android/media/AudioTrack:write	([BII)I
    //   1124: istore 4
    //   1126: aload_0
    //   1127: getfield 120	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1130: invokevirtual 423	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1133: pop
    //   1134: iload 4
    //   1136: ifge +61 -> 1197
    //   1139: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1142: ifeq +46 -> 1188
    //   1145: ldc -117
    //   1147: iconst_2
    //   1148: new 141	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1155: ldc_w 470
    //   1158: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: iload 4
    //   1163: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1166: ldc_w 472
    //   1169: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: iload_1
    //   1173: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1176: ldc_w 474
    //   1179: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1188: aload_0
    //   1189: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1192: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1195: iconst_m1
    //   1196: ireturn
    //   1197: iload 4
    //   1199: iload_1
    //   1200: if_icmpeq +52 -> 1252
    //   1203: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1206: ifeq +46 -> 1252
    //   1209: ldc -117
    //   1211: iconst_2
    //   1212: new 141	java/lang/StringBuilder
    //   1215: dup
    //   1216: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1219: ldc_w 476
    //   1222: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: iload 4
    //   1227: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1230: ldc_w 472
    //   1233: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: iload_1
    //   1237: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1240: ldc_w 474
    //   1243: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1249: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1252: aload_0
    //   1253: aload_0
    //   1254: getfield 223	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1257: iload 4
    //   1259: iconst_1
    //   1260: ishr
    //   1261: iadd
    //   1262: putfield 223	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1265: aload_0
    //   1266: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1269: invokevirtual 282	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1272: istore_1
    //   1273: iload_1
    //   1274: aload_0
    //   1275: getfield 284	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1278: if_icmpge +8 -> 1286
    //   1281: aload_0
    //   1282: iconst_0
    //   1283: putfield 284	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1286: aload_0
    //   1287: aload_0
    //   1288: getfield 223	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1291: iload_1
    //   1292: aload_0
    //   1293: getfield 284	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1296: isub
    //   1297: isub
    //   1298: putfield 223	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1301: aload_0
    //   1302: iload_1
    //   1303: putfield 284	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1306: aload_0
    //   1307: getfield 306	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   1310: ifne +22 -> 1332
    //   1313: aload_0
    //   1314: getfield 223	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1317: istore_1
    //   1318: goto -229 -> 1089
    //   1321: astore_2
    //   1322: iload 4
    //   1324: istore_1
    //   1325: goto -725 -> 600
    //   1328: astore_2
    //   1329: goto -289 -> 1040
    //   1332: goto -243 -> 1089
    //   1335: iload 4
    //   1337: iconst_1
    //   1338: iadd
    //   1339: istore 4
    //   1341: goto -892 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1344	0	this	AudioDeviceInterface
    //   0	1344	1	paramInt	int
    //   101	364	2	localObject1	Object
    //   558	24	2	localException1	Exception
    //   597	26	2	localException2	Exception
    //   644	2	2	localIOException	IOException
    //   652	9	2	localObject2	Object
    //   758	1	2	localIllegalStateException	IllegalStateException
    //   777	1	2	localException3	Exception
    //   981	54	2	localObject3	Object
    //   1321	1	2	localException4	Exception
    //   1328	1	2	localException5	Exception
    //   912	18	3	localException6	Exception
    //   8	1332	4	i	int
    //   18	536	5	j	int
    //   398	134	6	k	int
    //   444	96	7	m	int
    //   532	342	8	n	int
    //   204	865	9	l	long
    //   120	6	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   128	133	558	java/lang/Exception
    //   97	102	597	java/lang/Exception
    //   116	122	597	java/lang/Exception
    //   133	138	597	java/lang/Exception
    //   138	149	597	java/lang/Exception
    //   153	166	597	java/lang/Exception
    //   166	173	597	java/lang/Exception
    //   176	188	597	java/lang/Exception
    //   559	594	597	java/lang/Exception
    //   645	649	597	java/lang/Exception
    //   662	692	597	java/lang/Exception
    //   692	719	597	java/lang/Exception
    //   719	733	597	java/lang/Exception
    //   736	741	597	java/lang/Exception
    //   744	749	597	java/lang/Exception
    //   1111	1126	597	java/lang/Exception
    //   153	166	644	java/io/IOException
    //   97	102	652	finally
    //   116	122	652	finally
    //   128	133	652	finally
    //   133	138	652	finally
    //   138	149	652	finally
    //   153	166	652	finally
    //   166	173	652	finally
    //   176	188	652	finally
    //   193	257	652	finally
    //   257	266	652	finally
    //   272	287	652	finally
    //   287	339	652	finally
    //   339	384	652	finally
    //   384	389	652	finally
    //   389	446	652	finally
    //   449	518	652	finally
    //   559	594	652	finally
    //   600	635	652	finally
    //   645	649	652	finally
    //   662	692	652	finally
    //   692	719	652	finally
    //   719	733	652	finally
    //   736	741	652	finally
    //   744	749	652	finally
    //   759	774	652	finally
    //   781	805	652	finally
    //   805	840	652	finally
    //   840	897	652	finally
    //   897	909	652	finally
    //   913	955	652	finally
    //   955	969	652	finally
    //   969	974	652	finally
    //   977	982	652	finally
    //   986	1030	652	finally
    //   1034	1040	652	finally
    //   1043	1086	652	finally
    //   1099	1108	652	finally
    //   1111	1126	652	finally
    //   1126	1134	652	finally
    //   1139	1188	652	finally
    //   1203	1252	652	finally
    //   1252	1286	652	finally
    //   1286	1318	652	finally
    //   272	287	758	java/lang/IllegalStateException
    //   287	339	758	java/lang/IllegalStateException
    //   339	384	758	java/lang/IllegalStateException
    //   384	389	758	java/lang/IllegalStateException
    //   193	257	777	java/lang/Exception
    //   257	266	777	java/lang/Exception
    //   272	287	777	java/lang/Exception
    //   287	339	777	java/lang/Exception
    //   339	384	777	java/lang/Exception
    //   384	389	777	java/lang/Exception
    //   389	446	777	java/lang/Exception
    //   449	518	777	java/lang/Exception
    //   759	774	777	java/lang/Exception
    //   805	840	777	java/lang/Exception
    //   840	897	777	java/lang/Exception
    //   897	909	777	java/lang/Exception
    //   913	955	777	java/lang/Exception
    //   955	969	777	java/lang/Exception
    //   969	974	777	java/lang/Exception
    //   977	982	777	java/lang/Exception
    //   1043	1086	777	java/lang/Exception
    //   781	805	912	java/lang/Exception
    //   1126	1134	1321	java/lang/Exception
    //   1139	1188	1321	java/lang/Exception
    //   1203	1252	1321	java/lang/Exception
    //   1252	1286	1321	java/lang/Exception
    //   1286	1318	1321	java/lang/Exception
    //   986	1030	1328	java/lang/Exception
    //   1034	1040	1328	java/lang/Exception
    //   1099	1108	1328	java/lang/Exception
  }
  
  private int RecordAudio(int paramInt)
  {
    if (!this._isRecording)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "RecordAudio: _isRecording " + this._isRecording);
      }
      return -1;
    }
    this._recLock.lock();
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        localObject1 = this._audioRecord;
        if (localObject1 == null) {
          return -2;
        }
        boolean bool = this._doRecInit;
        if (bool != true) {}
      }
      catch (Exception localException2)
      {
        Object localObject1;
        i = 0;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 2, "RecordAudio Exception: " + localException2.getMessage());
        return i;
        if ((this._audioManager != null) || (this._context == null)) {
          continue;
        }
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        AudioManager localAudioManager = this._audioManager;
        if (localAudioManager != null) {
          continue;
        }
        return -1;
        if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          break label547;
        }
        this._audioSource = TraeAudioManager.a(0);
        if (this._audioSource != this._audioRecord.getAudioSource()) {
          break label1067;
        }
        i = 0;
        this._audioRecordChanged = false;
        continue;
      }
      finally
      {
        this._recLock.unlock();
      }
      try
      {
        Process.setThreadPriority(-19);
        this._doRecInit = false;
        if (!this._audioRecordChanged)
        {
          i = 0;
          if (i == 0) {
            break label820;
          }
          this._recBuffer.rewind();
          paramInt = this._audioRecord.getRecordingState();
          if (paramInt != 3) {}
        }
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording stop... state:" + this._audioRecord.getRecordingState());
          }
          this._audioRecord.stop();
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "StopRecording releaseing... state:" + this._audioRecord.getRecordingState());
          }
          this._audioRecord.release();
          this._audioRecord = null;
          j = AudioRecord.getMinBufferSize(this._RecordSamplerate, 16, 2);
          localObject1 = new int[4];
          Object tmp240_239 = localObject1;
          tmp240_239[0] = 0;
          Object tmp244_240 = tmp240_239;
          tmp244_240[1] = 1;
          Object tmp248_244 = tmp244_240;
          tmp248_244[2] = 5;
          Object tmp252_248 = tmp248_244;
          tmp252_248[3] = 0;
          tmp252_248;
          localObject1[0] = TraeAudioManager.a(this._audioSource);
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "ReInitRecording: " + localObject1[0]);
          }
          k = this._RecordSamplerate * 20 * 1 * 2 / 1000;
          paramInt = 0;
          if ((paramInt >= localObject1.length) || (this._audioRecord != null)) {
            break label762;
          }
          this._audioSource = localObject1[paramInt];
          i = 1;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          if (!QLog.isColorLevel()) {
            break label575;
          }
          QLog.e("TRAE", 2, "StopRecording  err");
          localIllegalStateException1.printStackTrace();
          this._recLock.unlock();
          return -1;
        }
        localException1 = localException1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TRAE", 2, "Set rec thread priority failed: " + localException1.getMessage());
        continue;
      }
      label547:
      this._audioSource = TraeAudioManager.a(7);
      continue;
      label575:
      label588:
      int m;
      try
      {
        this._audioRecord = new AudioRecord(this._audioSource, this._RecordSamplerate, 16, 2, m);
        if (this._audioRecord.getState() == 1) {
          break label1073;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + m + " sr:" + this._RecordSamplerate + " as:" + this._audioSource);
        }
        this._audioRecord.release();
        this._audioRecord = null;
      }
      catch (Exception localException4)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException4.getMessage() + " _audioRecord:" + this._audioRecord);
        }
        if (this._audioRecord != null) {
          this._audioRecord.release();
        }
        this._audioRecord = null;
      }
      label762:
      AudioRecord localAudioRecord = this._audioRecord;
      if (localAudioRecord != null) {}
      for (;;)
      {
        try
        {
          this._audioRecord.startRecording();
          j = 0;
          this._recLock.unlock();
          return j;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "StartRecording fail");
          }
          localIllegalStateException2.printStackTrace();
          this._recLock.unlock();
          return -1;
        }
        label820:
        this._recBuffer.rewind();
        i = this._audioRecord.read(this._tempBufRec, 0, paramInt);
        if (i < 0) {}
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "Could not read data from sc (read = " + i + ", length = " + paramInt + ")");
          }
          this._recLock.unlock();
          return -1;
        }
        catch (Exception localException3) {}
        this._recBuffer.put(this._tempBufRec, 0, i);
        if (_dumpEnable)
        {
          FileOutputStream localFileOutputStream = this._rec_out;
          if (localFileOutputStream == null) {}
        }
        try
        {
          this._rec_out.write(this._tempBufRec, 0, i);
          j = i;
          if (i != paramInt)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "Could not read all data from sc (read = " + i + ", length = " + paramInt + ")");
            }
            this._recLock.unlock();
            return -1;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      continue;
      for (;;)
      {
        if (i <= 2)
        {
          m = j * i;
          if ((m >= k * 4) || (i >= 2)) {
            break label588;
          }
          i += 1;
          continue;
          label1067:
          i = 1;
          break;
        }
      }
      label1073:
      paramInt += 1;
    }
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 201	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   6: ifeq +20 -> 26
    //   9: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc -117
    //   17: iconst_2
    //   18: ldc_w 527
    //   21: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   30: ifnonnull +40 -> 70
    //   33: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -12 -> 24
    //   39: ldc -117
    //   41: iconst_2
    //   42: new 141	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 529
    //   52: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   59: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iconst_m1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   74: invokevirtual 458	android/media/AudioTrack:play	()V
    //   77: getstatic 407	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   80: ifeq +52 -> 132
    //   83: aload_0
    //   84: getfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   94: invokevirtual 247	android/media/AudioManager:getMode	()I
    //   97: istore_2
    //   98: aload_0
    //   99: new 531	java/io/File
    //   102: dup
    //   103: aload_0
    //   104: ldc_w 533
    //   107: iload_2
    //   108: invokespecial 537	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   111: invokespecial 539	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: putfield 541	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   117: aload_0
    //   118: new 411	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: getfield 541	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   126: invokespecial 544	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: putfield 409	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 201	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   137: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc -117
    //   145: iconst_2
    //   146: ldc_w 546
    //   149: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_1
    //   155: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc -117
    //   163: iconst_2
    //   164: ldc_w 548
    //   167: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_1
    //   171: invokevirtual 499	java/lang/IllegalStateException:printStackTrace	()V
    //   174: iconst_m1
    //   175: ireturn
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 549	java/io/FileNotFoundException:printStackTrace	()V
    //   181: goto -49 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	AudioDeviceInterface
    //   154	17	1	localIllegalStateException	IllegalStateException
    //   176	2	1	localFileNotFoundException	java.io.FileNotFoundException
    //   1	107	2	i	int
    // Exception table:
    //   from	to	target	type
    //   70	77	154	java/lang/IllegalStateException
    //   117	132	176	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc -117
    //   10: iconst_2
    //   11: ldc_w 552
    //   14: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 306	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   21: ifeq +40 -> 61
    //   24: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +32 -> 59
    //   30: ldc -117
    //   32: iconst_2
    //   33: new 141	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 554
    //   43: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 306	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   50: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_m1
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   65: ifnonnull +40 -> 105
    //   68: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -12 -> 59
    //   74: ldc -117
    //   76: iconst_2
    //   77: new 141	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 556
    //   87: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   94: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iconst_m1
    //   104: ireturn
    //   105: aload_0
    //   106: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   109: invokevirtual 502	android/media/AudioRecord:startRecording	()V
    //   112: getstatic 407	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   115: ifeq +52 -> 167
    //   118: aload_0
    //   119: getfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   122: ifnull +11 -> 133
    //   125: aload_0
    //   126: getfield 180	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   129: invokevirtual 247	android/media/AudioManager:getMode	()I
    //   132: istore_2
    //   133: aload_0
    //   134: new 531	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: ldc_w 558
    //   142: iload_2
    //   143: invokespecial 537	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   146: invokespecial 539	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: putfield 560	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   152: aload_0
    //   153: new 411	java/io/FileOutputStream
    //   156: dup
    //   157: aload_0
    //   158: getfield 560	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   161: invokespecial 544	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: putfield 515	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield 306	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   172: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc -117
    //   180: iconst_2
    //   181: ldc_w 562
    //   184: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_1
    //   190: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc -117
    //   198: iconst_2
    //   199: ldc_w 504
    //   202: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_1
    //   206: invokevirtual 499	java/lang/IllegalStateException:printStackTrace	()V
    //   209: iconst_m1
    //   210: ireturn
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 549	java/io/FileNotFoundException:printStackTrace	()V
    //   216: goto -49 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	AudioDeviceInterface
    //   189	17	1	localIllegalStateException	IllegalStateException
    //   211	2	1	localFileNotFoundException	java.io.FileNotFoundException
    //   1	142	2	i	int
    // Exception table:
    //   from	to	target	type
    //   105	112	189	java/lang/IllegalStateException
    //   152	167	211	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StopPlayback()
  {
    // Byte code:
    //   0: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc -117
    //   8: iconst_2
    //   9: new 141	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 565
    //   19: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 201	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   26: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   39: ifnonnull +53 -> 92
    //   42: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +45 -> 90
    //   48: ldc -117
    //   50: iconst_2
    //   51: new 141	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 567
    //   61: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 201	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   68: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: ldc_w 393
    //   74: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   81: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_m1
    //   91: ireturn
    //   92: aload_0
    //   93: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 396	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   99: aload_0
    //   100: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   103: invokevirtual 436	android/media/AudioTrack:getPlayState	()I
    //   106: istore_2
    //   107: iload_2
    //   108: iconst_3
    //   109: if_icmpne +70 -> 179
    //   112: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc -117
    //   120: iconst_2
    //   121: ldc_w 438
    //   124: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   131: invokevirtual 441	android/media/AudioTrack:stop	()V
    //   134: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +35 -> 172
    //   140: ldc -117
    //   142: iconst_2
    //   143: new 141	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 446
    //   153: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   160: invokevirtual 436	android/media/AudioTrack:getPlayState	()I
    //   163: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   176: invokevirtual 444	android/media/AudioTrack:flush	()V
    //   179: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +35 -> 217
    //   185: ldc -117
    //   187: iconst_2
    //   188: new 141	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 448
    //   198: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   205: invokevirtual 436	android/media/AudioTrack:getPlayState	()I
    //   208: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: getfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   221: invokevirtual 226	android/media/AudioTrack:release	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 203	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 201	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   234: aload_0
    //   235: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   238: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   241: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: ldc -117
    //   249: iconst_2
    //   250: ldc_w 569
    //   253: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_1
    //   259: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc -117
    //   267: iconst_2
    //   268: ldc_w 455
    //   271: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_1
    //   275: invokevirtual 499	java/lang/IllegalStateException:printStackTrace	()V
    //   278: aload_0
    //   279: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   282: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   285: iconst_m1
    //   286: ireturn
    //   287: astore_1
    //   288: aload_0
    //   289: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   292: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   295: aload_1
    //   296: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	AudioDeviceInterface
    //   258	17	1	localIllegalStateException	IllegalStateException
    //   287	9	1	localObject	Object
    //   106	4	2	i	int
    // Exception table:
    //   from	to	target	type
    //   112	127	258	java/lang/IllegalStateException
    //   127	134	258	java/lang/IllegalStateException
    //   99	107	287	finally
    //   112	127	287	finally
    //   127	134	287	finally
    //   134	172	287	finally
    //   172	179	287	finally
    //   179	217	287	finally
    //   217	234	287	finally
    //   259	274	287	finally
    //   274	278	287	finally
  }
  
  /* Error */
  private int StopRecording()
  {
    // Byte code:
    //   0: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc -117
    //   8: iconst_2
    //   9: ldc_w 572
    //   12: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   19: ifnonnull +40 -> 59
    //   22: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc -117
    //   30: iconst_2
    //   31: new 141	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 574
    //   41: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   48: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: ireturn
    //   59: aload_0
    //   60: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 396	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   70: invokevirtual 482	android/media/AudioRecord:getRecordingState	()I
    //   73: istore_2
    //   74: iload_2
    //   75: iconst_3
    //   76: if_icmpne +48 -> 124
    //   79: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +35 -> 117
    //   85: ldc -117
    //   87: iconst_2
    //   88: new 141	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 484
    //   98: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   105: invokevirtual 482	android/media/AudioRecord:getRecordingState	()I
    //   108: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   121: invokevirtual 485	android/media/AudioRecord:stop	()V
    //   124: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +35 -> 162
    //   130: ldc -117
    //   132: iconst_2
    //   133: new 141	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 487
    //   143: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   150: invokevirtual 482	android/media/AudioRecord:getRecordingState	()I
    //   153: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: getfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   166: invokevirtual 330	android/media/AudioRecord:release	()V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 308	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 306	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   179: aload_0
    //   180: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   183: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   186: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc -117
    //   194: iconst_2
    //   195: ldc_w 576
    //   198: invokestatic 159	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_1
    //   204: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +12 -> 219
    //   210: ldc -117
    //   212: iconst_2
    //   213: ldc_w 498
    //   216: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_1
    //   220: invokevirtual 499	java/lang/IllegalStateException:printStackTrace	()V
    //   223: aload_0
    //   224: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   227: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   230: iconst_m1
    //   231: ireturn
    //   232: astore_1
    //   233: aload_0
    //   234: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   237: invokevirtual 399	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	AudioDeviceInterface
    //   203	17	1	localIllegalStateException	IllegalStateException
    //   232	9	1	localObject	Object
    //   73	4	2	i	int
    // Exception table:
    //   from	to	target	type
    //   79	117	203	java/lang/IllegalStateException
    //   117	124	203	java/lang/IllegalStateException
    //   66	74	232	finally
    //   79	117	232	finally
    //   117	124	232	finally
    //   124	162	232	finally
    //   162	179	232	finally
    //   204	219	232	finally
    //   219	223	232	finally
  }
  
  private int getAudioSessionId(AudioRecord paramAudioRecord)
  {
    return 0;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
    }
    paramString = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.a(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + paramInt + "-" + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump:" + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump replace:" + paramString.replace(" ", "_"));
    }
    return paramString.replace(" ", "_");
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
      if (bool != true) {
        break label146;
      }
    }
    label146:
    for (String str = "Y";; str = "N")
    {
      QLog.w("TRAE", 2, str);
      if ((Build.VERSION.SDK_INT >= 17) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      return 0;
    }
  }
  
  private int getLowlatencySamplerate()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
    }
    label146:
    label153:
    do
    {
      return 0;
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
        if (bool != true) {
          break label146;
        }
      }
      for (String str = "Y";; str = "N")
      {
        QLog.w("TRAE", 2, str);
        if (Build.VERSION.SDK_INT >= 17) {
          break label153;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        return 0;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
    return 0;
  }
  
  public static String getTraceInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = arrayOfStackTraceElement.length;
    localStringBuffer.append("").append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuffer.toString();
  }
  
  private void initTRAEAudioManager()
  {
    if (this._context != null)
    {
      TraeAudioManager.a(this._context);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService");
      }
    }
  }
  
  private void onOutputChanage(String paramString)
  {
    setAudioRouteSwitchState(paramString);
    if (!TraeAudioManager.a(this._modePolicy)) {
      return;
    }
    this._connectedDev = paramString;
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" onOutputChanage:").append(paramString);
      if (this._audioManager != null) {
        break label210;
      }
      localObject = " am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label240;
      }
      localObject = "_audioTrack==null";
      label86:
      QLog.w("TRAE", 2, (String)localObject);
    }
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append(" curr mode:").append(paramString);
          if (this._audioManager != null) {
            continue;
          }
          paramString = "am==null";
          QLog.w("TRAE", 2, paramString);
        }
        if ((this._connectedDev.equals("DEVICE_SPEAKERPHONE")) && (this._audioManager != null)) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        label210:
        label240:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TRAE", 2, paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      this._audioRecordChanged = true;
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label86;
      paramString = " mode:" + this._audioManager.getMode();
    }
  }
  
  private void setAudioRouteSwitchState(String paramString)
  {
    if (paramString.equals("DEVICE_EARPHONE"))
    {
      this.switchState = 1;
      return;
    }
    if (paramString.equals("DEVICE_SPEAKERPHONE"))
    {
      this.switchState = 2;
      return;
    }
    if (paramString.equals("DEVICE_WIREDHEADSET"))
    {
      this.switchState = 3;
      return;
    }
    if (paramString.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      this.switchState = 4;
      return;
    }
    this.switchState = 0;
  }
  
  private int sigHowling(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "java onHowling flg:" + paramInt);
    }
    if (this._as == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHowling too early" + paramInt);
      }
      return -1;
    }
    return 0;
  }
  
  private void uninitTRAEAudioManager()
  {
    if (this._context != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
      }
      TraeAudioManager.f();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.h();
      this._as.a();
      this._as = null;
    }
    LogTraceExit();
    return 0;
  }
  
  public int call_preprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    this._streamType = TraeAudioManager.b(this._audioStreamTypePolicy);
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new xqt(this));
    }
    this._preDone = false;
    if (this._as != null) {
      this._prelock.lock();
    }
    int i;
    int j;
    label208:
    for (;;)
    {
      try
      {
        this._as.f();
        this._as.a(this._modePolicy, this._streamType);
        i = 7;
        j = i - 1;
        if (i <= 0) {}
      }
      finally
      {
        this._prelock.unlock();
      }
      try
      {
        if (!this._preDone)
        {
          this._precon.await(1L, TimeUnit.SECONDS);
          if (!QLog.isColorLevel()) {
            break label208;
          }
          QLog.e("TRAE", 2, "call_preprocess waiting...  as:" + this._as);
          i = j;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "call_preprocess done!");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
        i = j;
      }
      this._prelock.unlock();
      LogTraceExit();
      return 0;
    }
  }
  
  public int getAudioRouteSwitchState()
  {
    return this.switchState;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public void setJavaInterface(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.usingJava = false;; this.usingJava = true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "setJavaInterface flg:" + paramInt);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\sharp\jni\AudioDeviceInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */