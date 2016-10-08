import android.app.Application;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.player.IPttPlayerListener;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;

public class tym
  extends Thread
{
  private int jdField_a_of_type_Int;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private SilkCodecWrapper jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  
  public tym(SilkPlayer paramSilkPlayer, Application paramApplication)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = RecordParams.a(SilkPlayer.a(paramSilkPlayer));
    this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(paramApplication, false);
    this.jdField_a_of_type_Int = RecordParams.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "SilkPlayerThread sampleRate=" + this.jdField_b_of_type_Int + ", oneFrameSize=" + this.jdField_a_of_type_Int + ", currenttime:" + System.currentTimeMillis());
    }
  }
  
  public void run()
  {
    byte[] arrayOfByte = new byte[2];
    Process.setThreadPriority(-19);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(this.jdField_b_of_type_Int, 0, 1);
        SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer).b();
        i = AudioTrack.getMinBufferSize(RecordParams.a(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer)), 4, 2);
        this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer), RecordParams.a(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer)), 4, 2, i, 1);
        if (QLog.isColorLevel()) {
          QLog.d("SilkPlayer", 2, "start play silk mStreamType=" + SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) + ", rate=" + RecordParams.a(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer)) + ", playBufferSize = " + i + ", currenttime:" + System.currentTimeMillis());
        }
        this.jdField_a_of_type_AndroidMediaAudioTrack.play();
        if (SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) != -1) {
          if (SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) == this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.a())
          {
            i = SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer);
            j = SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer);
            SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, -1);
            k = i;
            i = j;
            localFileInputStream = new FileInputStream(SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer));
            if (k != 0) {
              continue;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        int j;
        int k;
        FileInputStream localFileInputStream;
        localObject1 = null;
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
      }
      try
      {
        localFileInputStream.skip(10L);
        i += 10;
      }
      catch (Exception localException1)
      {
        i = 0;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk play exception " + localException1.getMessage());
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.b();
        continue;
        k = RecordParams.a(localException1);
        if (k > 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.b();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk decode error: error frame size=" + k);
        i = 0;
        continue;
        if (SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) != -1) {
          continue;
        }
        j = localFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, k);
        i += k;
        if (j != -1) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.b();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk decode error: failed to read frameSize=" + k);
        i = 0;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, k, this.jdField_b_of_type_ArrayOfByte.length) != 0) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.b();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk decode jni error");
        i = 0;
        continue;
        j = i;
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
        j = i;
        try
        {
          SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, j);
          SilkPlayer.e(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer);
          i = j;
          if (SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) == -1) {
            continue;
          }
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.a() < SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer)) {
            continue;
          }
          SilkPlayer.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, -1);
          i = j;
          continue;
        }
        finally {}
        j = i + k;
        localFileInputStream.skip(k);
        continue;
      }
      if ((!this.jdField_a_of_type_Boolean) || (localFileInputStream == null)) {
        continue;
      }
      j = localFileInputStream.read(arrayOfByte, 0, 2);
      i += 2;
      if (j != -1) {
        continue;
      }
      try
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SilkPlayer", 2, "silk decode completed mCurrentPlayFrame=" + SilkPlayer.d(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer) + ", mCurrentFileOffset" + SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer));
        i = 1;
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidMediaAudioTrack != null)
        {
          this.jdField_a_of_type_AndroidMediaAudioTrack.release();
          this.jdField_a_of_type_AndroidMediaAudioTrack = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper.b();
        if (i != 0) {
          this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer.h();
        }
        if (localFileInputStream == null) {}
      }
      catch (Exception localException3)
      {
        long l;
        Object localObject1;
        i = 1;
        continue;
      }
      try
      {
        localFileInputStream.close();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
      SilkPlayer.b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, 0);
      SilkPlayer.c(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer, 0);
      k = 0;
      i = 0;
      continue;
      l = k;
      localFileInputStream.skip(l);
    }
  }
  
  public void start()
  {
    this.jdField_a_of_type_Boolean = true;
    super.start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */