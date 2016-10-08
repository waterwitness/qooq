import android.media.AudioRecord;
import android.os.Process;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import com.tencent.qphone.base.util.QLog;

public class uqt
  extends Thread
{
  public uqt(AudioCapture paramAudioCapture)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b();
    int i = 0;
    if (this.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      int j;
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        try
        {
          this.a.jdField_a_of_type_JavaLangObject.wait();
          if (!this.a.jdField_a_of_type_Boolean) {
            break;
          }
          this.a.jdField_a_of_type_Long = System.currentTimeMillis();
          this.a.jdField_b_of_type_Long = System.currentTimeMillis();
          Process.setThreadPriority(-19);
          k = 1;
          j = i;
          i = k;
          label86:
          if (!Lock.jdField_a_of_type_Boolean) {
            break label551;
          }
          if ((this.a.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.a.jdField_a_of_type_ArrayOfByte == null) || (this.a.jdField_b_of_type_ArrayOfByte == null)) {
            continue;
          }
          this.a.jdField_b_of_type_Long = System.currentTimeMillis();
          if (this.a.k < this.a.l) {
            break label261;
          }
          if ((this.a.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.a.jdField_a_of_type_ArrayOfByte == null)) {
            break label682;
          }
          k = this.a.jdField_a_of_type_AndroidMediaAudioRecord.read(this.a.jdField_a_of_type_ArrayOfByte, 0, this.a.l);
          this.a.a(k);
          if (i != 0)
          {
            i = 0;
            continue;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.a.a(this.a.jdField_a_of_type_ArrayOfByte, k, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, true, 4);
      continue;
      label261:
      if ((this.a.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.a.jdField_a_of_type_ArrayOfByte != null)) {}
      for (int k = this.a.jdField_a_of_type_AndroidMediaAudioRecord.read(this.a.jdField_a_of_type_ArrayOfByte, 0, this.a.k);; k = 0)
      {
        this.a.a(k);
        if (k <= 0) {
          break label86;
        }
        if (i != 0)
        {
          i = 0;
          break label86;
        }
        if (j + k > this.a.l)
        {
          System.arraycopy(this.a.jdField_a_of_type_ArrayOfByte, 0, this.a.jdField_b_of_type_ArrayOfByte, j, this.a.l - j);
          int m = AudioCapture.a(this.a, this.a.jdField_b_of_type_ArrayOfByte, this.a.l);
          int n = this.a.l - m;
          this.a.a(this.a.jdField_b_of_type_ArrayOfByte, n, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, true, 4);
          if (m > 0) {
            System.arraycopy(this.a.jdField_b_of_type_ArrayOfByte, n, this.a.jdField_b_of_type_ArrayOfByte, 0, m);
          }
          j = this.a.l - j;
          k -= j;
          System.arraycopy(this.a.jdField_a_of_type_ArrayOfByte, j, this.a.jdField_b_of_type_ArrayOfByte, m, k);
          j = m + k;
        }
        for (;;)
        {
          break;
          System.arraycopy(this.a.jdField_a_of_type_ArrayOfByte, 0, this.a.jdField_b_of_type_ArrayOfByte, j, k);
          j += k;
        }
        label551:
        i = AudioCapture.a(this.a, this.a.jdField_b_of_type_ArrayOfByte, j);
        j -= i;
        this.a.a(this.a.jdField_b_of_type_ArrayOfByte, j, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, false, 9);
        if (i > 0)
        {
          System.arraycopy(this.a.jdField_b_of_type_ArrayOfByte, j, this.a.jdField_b_of_type_ArrayOfByte, 0, i);
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "AudioNoiseSuppression[QQ]: leftLen=" + i);
        }
        i = 0;
        break;
        this.a.b();
        return;
      }
      label682:
      k = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */