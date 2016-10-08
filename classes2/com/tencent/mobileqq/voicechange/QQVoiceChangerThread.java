package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.processor.IPttProcessor;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.ptt.processor.IPttProcessorListener;
import com.tencent.mobileqq.ptt.processor.PttAgcAndNsProcessor;
import com.tencent.mobileqq.ptt.processor.PttCompositeProcessor;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class QQVoiceChangerThread
  extends Thread
  implements IPttProcessorListener
{
  public static final String a = "QQVoiceChanger";
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private PttCompositeProcessor jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor;
  IVoiceChangeListener jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener;
  VoiceChangeBasicParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams;
  VoiceChangeModeParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  public QQVoiceChangerThread(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, VoiceChangeModeParams paramVoiceChangeModeParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfByte = new byte['π'];
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_JavaLangString = paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = paramVoiceChangeBasicParams;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams = paramVoiceChangeModeParams;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = paramIVoiceChangeListener;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "new QQVoiceChangerThread filePath=" + this.jdField_c_of_type_JavaLangString + " sampleRate=" + paramVoiceChangeBasicParams.jdField_b_of_type_Int + " bitRate=" + paramVoiceChangeBasicParams.d + " voiceType=" + paramVoiceChangeBasicParams.e + " changeType=" + paramVoiceChangeBasicParams.f);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)AudioHelper.a(this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte, paramInt, 1.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.a(i, this.jdField_c_of_type_Int * 100 / this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidMediaAudioTrack.write(paramArrayOfByte, 0, paramInt);
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str)) {}
    for (this.jdField_c_of_type_JavaLangString = str;; this.jdField_c_of_type_JavaLangString = VoiceTuneUtil.a(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.jdField_c_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("QQVoiceChanger", 2, "open:" + this.jdField_c_of_type_JavaLangString + " a=" + this.jdField_a_of_type_JavaIoFileInputStream.available());
      }
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioTrack != null) {
      this.jdField_a_of_type_AndroidMediaAudioTrack.release();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a();
    }
    if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
      this.jdField_a_of_type_JavaIoFileInputStream.close();
    }
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
      this.jdField_a_of_type_JavaIoFileOutputStream.close();
    }
    if (this.jdField_b_of_type_Boolean) {
      VoiceTuneUtil.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "clean up requestToCancel=" + this.jdField_b_of_type_Boolean);
    }
  }
  
  protected void a()
  {
    int i = AudioTrack.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, 4, 2, i, 1);
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
  }
  
  protected void a(int paramInt)
  {
    File localFile = new File(VoiceTuneUtil.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, paramInt));
    localFile.createNewFile();
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
  }
  
  public void a(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if (((paramIPttProcessor instanceof SilkCodecWrapper)) || ((paramIPttProcessor instanceof AmrInputStreamWrapper)))
    {
      this.jdField_a_of_type_Int += (int)QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, 4, 2, paramProcessData.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_Boolean) {
        a(paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int);
      }
    }
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaIoFileInputStream.available();
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "start progress totalSize=" + this.jdField_b_of_type_Int + " filePath=" + this.jdField_c_of_type_JavaLangString + "pcmFilePath=" + this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    }
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j;
      if (this.jdField_a_of_type_Boolean)
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.e)
        {
          j = k;
          if (k == 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e != 0) {
              break label270;
            }
            this.jdField_a_of_type_JavaIoFileInputStream.skip("#!AMR\n".length());
          }
        }
      }
      for (;;)
      {
        j = 1;
        try
        {
          k = this.jdField_a_of_type_JavaIoFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, 960);
          if (k != -1) {
            break;
          }
          this.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.f();
          }
          PttInfoCollector.a(4, this.jdField_a_of_type_Int);
          VoiceChangeManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e);
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "finishedCompress playedTime=" + this.jdField_a_of_type_Int);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("QQVoiceChanger", 2, "read failed" + localIOException.getStackTrace());
            }
          }
          this.jdField_c_of_type_Int += k;
          localProcessData = this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(this.jdField_a_of_type_ArrayOfByte, 0, k);
          PttInfoCollector.b();
          k = j;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.h();
        }
        return;
        label270:
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e == 1) {
          this.jdField_a_of_type_JavaIoFileInputStream.skip(10L);
        }
      }
      IPttProcessor.ProcessData localProcessData;
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        k = j;
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.c)
        {
          int m = i;
          if (i == 0)
          {
            byte[] arrayOfByte = RecordParams.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int);
            this.jdField_a_of_type_JavaIoFileOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
            this.jdField_a_of_type_JavaIoFileOutputStream.flush();
            m = 1;
          }
          k = j;
          i = m;
          if (localProcessData != null)
          {
            this.jdField_a_of_type_JavaIoFileOutputStream.write(localProcessData.jdField_a_of_type_ArrayOfByte, 0, localProcessData.jdField_a_of_type_Int);
            this.jdField_a_of_type_JavaIoFileOutputStream.flush();
            k = j;
            i = m;
          }
        }
      }
    }
  }
  
  public void b(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData) {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = null;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToSend isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      VoiceTuneUtil.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToCancel isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(-19);
    this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor = new PttCompositeProcessor();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f == 0) {
          this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.d = false;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.d) {
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new VoiceChange(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f, this.jdField_b_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new PttAgcAndNsProcessor(this.jdField_a_of_type_AndroidContentContext));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams.c)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e == 0) {
            this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext));
          }
        }
        else
        {
          e();
          a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f);
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.d, this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e);
          this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(this);
          a();
          b();
        }
      }
      catch (IOException localIOException1)
      {
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.g();
        }
        try
        {
          f();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeListener.g();
        localException.printStackTrace();
        try
        {
          f();
          return;
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
          return;
        }
      }
      finally {}
      try
      {
        f();
        return;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPttProcessorPttCompositeProcessor.a(new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext));
    }
    try
    {
      f();
      throw ((Throwable)localObject);
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        localIOException5.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\voicechange\QQVoiceChangerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */