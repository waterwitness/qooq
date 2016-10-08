package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwFrame;
import com.tencent.mobileqq.utils.NoiseSuppression;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;
import uqt;

public class AudioCapture
  extends Observable
{
  public static final int a = -1;
  public static final int b = -2;
  public static final int c = -3;
  public static int d = 0;
  public static boolean d = false;
  public static int e = 0;
  public static final int f = 0;
  public static final int g = 5;
  public static final int h = 5;
  private static final int p = 128;
  public long a;
  Context jdField_a_of_type_AndroidContentContext;
  public AudioRecord a;
  private NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression;
  public Object a;
  public AtomicReference a;
  public volatile boolean a;
  public byte[] a;
  public long b;
  boolean b;
  public byte[] b;
  boolean c = false;
  public volatile boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  public int i;
  public int j;
  public int k = 0;
  public int l = 0;
  int m = 0;
  int n = 0;
  public volatile int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_d_of_type_Int = 160768;
    jdField_e_of_type_Int = 4;
    jdField_d_of_type_Boolean = true;
  }
  
  public AudioCapture(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.i = 0;
    this.j = 0;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    if (!jdField_d_of_type_Boolean) {
      return 0;
    }
    int i2 = paramInt % NoiseSuppression.f;
    while (i1 < paramInt - i2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(paramArrayOfByte, i1, NoiseSuppression.f);
      }
      i1 += NoiseSuppression.f;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioNoiseSuppression[QQ]: remainder=" + i2);
    }
    return i2;
  }
  
  public void a()
  {
    this.m = 0;
    this.n = 0;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "checkAudioPrivilage: result=" + paramInt + " mAudioCanUsed=" + this.jdField_e_of_type_Boolean);
    }
    if (paramInt == -3)
    {
      this.jdField_e_of_type_Boolean = false;
      this.o = -1;
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_OPERATION]: result=" + paramInt);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "checkAudioPrivilage: result=" + paramInt + " mAudioCanUsed=" + this.jdField_e_of_type_Boolean);
      }
      return;
      if (paramInt != 0) {
        break;
      }
      if (this.i < 5)
      {
        this.i += 1;
      }
      else
      {
        this.jdField_e_of_type_Boolean = false;
        this.o = -2;
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA_LENGTH]: result=" + paramInt + " mAudioInvalidCount=" + this.i);
        }
      }
    }
    this.i = 0;
    if (paramInt > 128) {}
    for (int i1 = 128;; i1 = paramInt)
    {
      boolean bool;
      if (!this.g)
      {
        bool = CameraCompatibleList.a(CameraCompatibleList.p);
        if ((!bool) || (this.j >= 5)) {
          break label430;
        }
        this.h = PreviewContext.checkIsDisablePrivilage(this.jdField_a_of_type_ArrayOfByte, i1);
        label270:
        this.j += 1;
        if (this.h) {
          break label438;
        }
        this.g = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=" + paramInt + " mDisableAudioPrivilage=" + this.h + " blackPhone=" + bool + " mAudioInvalidData=" + this.j);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AudioCapture", 2, "checkAudioPrivilage: limit=" + i1 + " mAudioCanUsed=" + this.jdField_e_of_type_Boolean);
        QLog.d("AudioCapture", 2, "checkAudioPrivilage: mDisableAudioPrivilage=" + this.h);
        break;
        label430:
        this.h = false;
        break label270;
        label438:
        if ((this.h) && (this.j >= 5))
        {
          this.g = true;
          this.jdField_e_of_type_Boolean = false;
          this.o = -3;
        }
      }
    }
  }
  
  public void a(AudioCapture.OnAudioRecordListener paramOnAudioRecordListener)
  {
    a(paramOnAudioRecordListener, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    AVIOStruct localAVIOStruct = new AVIOStruct();
    int i1;
    if (paramBoolean) {
      i1 = this.m;
    }
    for (;;)
    {
      localAVIOStruct.pBlockIndex = i1;
      i1 = this.n;
      this.n = (i1 + 1);
      localAVIOStruct.pFrameIndex = i1;
      localAVIOStruct.aBitrate = CodecParam.n;
      localAVIOStruct.pCodec = CodecParam.c;
      localAVIOStruct.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
      localAVIOStruct.aChannel = CodecParam.o;
      localAVIOStruct.aFormat = CodecParam.p;
      localAVIOStruct.aSampleRate = CodecParam.C;
      if ((paramArrayOfByte != null) && (paramInt1 > 0))
      {
        byte[] arrayOfByte = new byte[paramInt1];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt1);
        paramArrayOfByte = (SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
        if (paramArrayOfByte != null)
        {
          SVHwEncoder.HwFrame localHwFrame = new SVHwEncoder.HwFrame();
          localHwFrame.jdField_a_of_type_ArrayOfByte = arrayOfByte;
          localHwFrame.jdField_a_of_type_Int = 0;
          localHwFrame.jdField_b_of_type_Int = arrayOfByte.length;
          localHwFrame.jdField_a_of_type_Long = System.currentTimeMillis();
          localHwFrame.jdField_a_of_type_Boolean = false;
          localHwFrame.jdField_b_of_type_Boolean = false;
          paramArrayOfByte.a(localHwFrame, false);
        }
        RecordManager.a().a().handleAudio(arrayOfByte, localAVIOStruct, (int)paramLong);
        a(paramInt2, new Object[] { Integer.valueOf(0) });
      }
      return;
      i1 = this.m;
      this.m = (i1 + 1);
    }
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = NoiseSuppression.a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(CodecParam.C);
      }
      this.jdField_a_of_type_Boolean = true;
      this.g = false;
      this.h = false;
      new uqt(this).start();
      return true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
      }
    }
  }
  
  public void b()
  {
    this.k = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.l = 0;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.f = false;
    this.i = 0;
    this.j = 0;
    this.h = false;
  }
  
  public void b(AudioCapture.OnAudioRecordListener paramOnAudioRecordListener)
  {
    a(paramOnAudioRecordListener);
  }
  
  public boolean b()
  {
    boolean bool = true;
    for (;;)
    {
      int i1;
      try
      {
        if (this.f)
        {
          bool = this.f;
          return bool;
        }
        this.k = AudioRecord.getMinBufferSize(CodecParam.C, CodecParam.o, CodecParam.p);
        if ((this.k == -2) || (this.k == -1))
        {
          if (RecordManager.a().a().a(this, 3, "init audio failed")) {
            break label188;
          }
          a(3, new Object[] { "init audio failed" });
          break label188;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[this.k];
        i1 = jdField_d_of_type_Int / jdField_e_of_type_Int;
        if (this.k <= i1)
        {
          i1 = jdField_d_of_type_Int;
          this.l = i1;
          this.jdField_b_of_type_ArrayOfByte = new byte[this.l];
          this.f = true;
          a(3, new Object[] { Boolean.valueOf(true), Integer.valueOf(0) });
          continue;
        }
        i1 = this.k;
      }
      finally {}
      int i2 = jdField_e_of_type_Int;
      i1 *= i2;
      continue;
      label188:
      bool = false;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if (!this.jdField_b_of_type_Boolean) {}
    while (!QLog.isColorLevel())
    {
      try
      {
        b();
        this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, CodecParam.C, CodecParam.o, CodecParam.p, this.k);
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 0)
        {
          a(5, new Object[] { "打开麦克风失败" });
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a(5, new Object[] { "打开麦克风失败" });
        return;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[startMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.jdField_b_of_type_Boolean) && (!this.c)) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
        this.c = true;
        a(6, new Object[] { Boolean.valueOf(true) });
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "AudioCapture[startMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.c = false;
        localIllegalStateException.printStackTrace();
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        a(6, new Object[] { "打开麦克风失败" });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[stopMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.jdField_b_of_type_Boolean) && (this.c))
    {
      this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
      this.c = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[stopMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[releaseMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioRecord != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioRecord.release();
      this.jdField_a_of_type_AndroidMediaAudioRecord = null;
      this.jdField_b_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[releaseMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[destory]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.c + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      e();
      f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
      this.m = 0;
      this.n = 0;
      return;
    }
  }
  
  public void h()
  {
    if (!Lock.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      a(1, new Object[] { Integer.valueOf(0) });
      return;
    }
  }
  
  public void i()
  {
    if (Lock.jdField_a_of_type_Boolean) {
      return;
    }
    a(2, new Object[] { Integer.valueOf(0) });
  }
  
  void j()
  {
    Object localObject = Build.MODEL;
    String str = Build.PRODUCT;
    str = Build.MANUFACTURER;
    int i1;
    if ((((String)localObject).contains("SAMSUNG")) || (((String)localObject).contains("SPH-")) || (((String)localObject).contains("SGH-")) || (((String)localObject).contains("GT-")))
    {
      i1 = 1;
      if ((!str.contains("motorola")) && (!((String)localObject).contains("Milestone")) && (!((String)localObject).contains("XT882"))) {
        break label123;
      }
    }
    label123:
    for (int i2 = 1;; i2 = 0)
    {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        localObject = (AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
        if (i1 == 0) {
          break label129;
        }
        ((AudioManager)localObject).setMode(2);
      }
      return;
      i1 = 0;
      break;
    }
    label129:
    if (i2 != 0)
    {
      ((AudioManager)localObject).setMode(0);
      return;
    }
    ((AudioManager)localObject).setMode(2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\AudioCapture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */