import android.media.AudioManager;
import android.media.AudioRecord;
import android.util.Log;
import com.tencent.av.utils.QQRecorder;
import com.tencent.av.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class hbo
  extends Thread
{
  public volatile boolean a;
  
  public hbo(QQRecorder paramQQRecorder, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    paramQQRecorder.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "RecordThread Start : " + this);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
          this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_JavaLangString);
        }
        arrayOfByte2 = new byte[QQRecorder.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder)];
        File localFile = new File(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_JavaLangString);
        if (localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "RecordThread-->RUN-->File is Exists");
          }
          localFile.delete();
        }
        try
        {
          localFile.createNewFile();
          localFileOutputStream = new FileOutputStream(localFile);
          if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioRecord != null)
          {
            this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
            if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
              this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a();
            }
            long l2 = System.currentTimeMillis();
            localFile = null;
            j = 0;
            l1 = 0L;
            k = 0;
            if (!this.jdField_a_of_type_Boolean) {
              continue;
            }
            i = j;
            if (System.currentTimeMillis() - l2 > 1000L)
            {
              i = j;
              if (j == 0)
              {
                j = 1;
                if (l1 != 0L)
                {
                  i = j;
                  if (k != 0) {}
                }
                else
                {
                  if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null)
                  {
                    QQRecorder.OnQQRecorderListener localOnQQRecorderListener = this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener;
                    if (l1 != 0L) {
                      continue;
                    }
                    i = 0;
                    localOnQQRecorderListener.a(i);
                  }
                  i = j;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("QQRecorder", 2, "record abnormal: data size = " + l1 + ", max volume = " + k);
                    i = j;
                  }
                }
              }
            }
            j = 0;
            if (localFile != null)
            {
              j = localFile.length;
              System.arraycopy(localFile, 0, arrayOfByte2, 0, j);
            }
            m = this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioRecord.read(arrayOfByte2, j, QQRecorder.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder) - j);
            if (QQRecorder.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder) - j != m) {
              QLog.d("QQRecorder", 2, " Recording --> Request Size = " + (QQRecorder.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder) - j) + " ,Really Size = " + m);
            }
            if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
              this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.b();
            }
            if (m > 0) {
              continue;
            }
            Thread.sleep(10L);
            j = i;
            continue;
          }
          if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener == null) {
            continue;
          }
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQRecorder", 2, "RecordThread-->Create New File Failed. Exception = " + localIOException.getMessage());
          }
          if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
            this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_JavaLangString, 2);
          }
          return;
        }
        this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_JavaLangString, 4);
        localFileOutputStream.close();
        return;
      }
      catch (Throwable localThrowable)
      {
        byte[] arrayOfByte2;
        FileOutputStream localFileOutputStream;
        int j;
        long l1;
        int k;
        int i;
        int m;
        byte[] arrayOfByte1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QQRecorder", 2, "record Exception: " + Log.getStackTraceString(localThrowable), localThrowable);
        if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_JavaLangString, localThrowable.getMessage());
        return;
      }
      finally
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioRecord == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioRecord.release();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QQRecorder", 2, "RecordThread end: " + this);
        this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_Hbo = null;
        this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_JavaLangString = null;
      }
      i = 1;
    }
    arrayOfByte1 = null;
    l1 += m;
    j += m;
    m = j % 160;
    if (m != 0)
    {
      arrayOfByte1 = new byte[m];
      System.arraycopy(arrayOfByte2, j - m, arrayOfByte1, 0, m);
      j -= m;
    }
    for (;;)
    {
      k = Math.max(k, (int)AudioHelper.a(this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidContentContext, arrayOfByte2, j, 1.0F));
      localFileOutputStream.write(arrayOfByte2, 0, j);
      j = i;
      break;
      localFileOutputStream.flush();
      localFileOutputStream.close();
      if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_ComTencentAvUtilsQQRecorder$OnQQRecorderListener.c();
      }
      if ((this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.i != -1)) {
        this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_AndroidMediaAudioRecord.release();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "RecordThread end: " + this);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_Hbo = null;
      this.jdField_a_of_type_ComTencentAvUtilsQQRecorder.jdField_a_of_type_JavaLangString = null;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */