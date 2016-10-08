import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridge;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import mqq.os.MqqHandler;

public class wjo
  extends InputStream
{
  int jdField_a_of_type_Int;
  BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  HttpURLConnection jdField_a_of_type_JavaNetHttpURLConnection;
  BufferedInputStream b;
  
  public wjo(SwiftWebViewHttpBridge paramSwiftWebViewHttpBridge, BufferedInputStream paramBufferedInputStream1, BufferedInputStream paramBufferedInputStream2, ByteArrayOutputStream paramByteArrayOutputStream, HttpURLConnection paramHttpURLConnection, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaIoBufferedInputStream = paramBufferedInputStream1;
    this.b = paramBufferedInputStream2;
    if (paramByteArrayOutputStream != null) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = paramByteArrayOutputStream;
      this.jdField_a_of_type_JavaNetHttpURLConnection = paramHttpURLConnection;
      this.jdField_a_of_type_Int = paramInt;
      return;
      paramByteArrayOutputStream = new ByteArrayOutputStream();
    }
  }
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftWebViewHttpBridge", 2, "now close memory stream and socket stream!");
    }
    try
    {
      if (this.jdField_a_of_type_JavaIoBufferedInputStream != null)
      {
        this.jdField_a_of_type_JavaIoBufferedInputStream.close();
        this.jdField_a_of_type_JavaIoBufferedInputStream = null;
      }
      if (this.b != null)
      {
        this.b.close();
        this.b = null;
      }
      if (this.jdField_a_of_type_JavaNetHttpURLConnection != null) {
        this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
      }
      if ((this.jdField_a_of_type_Int == 3) && (this.jdField_a_of_type_JavaIoByteArrayOutputStream != null) && (this.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewHttpBridge", 2, "cachedStream size:" + this.jdField_a_of_type_JavaIoByteArrayOutputStream.size());
        }
        Message localMessage = SwiftWebViewHttpBridge.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge).obtainMessage(7);
        localMessage.arg1 = 1000;
        SwiftWebViewHttpBridge.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge).sendMessage(localMessage);
        ThreadManager.a().postDelayed(new wjp(this), 5000L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int read()
  {
    int i;
    if ((this.jdField_a_of_type_JavaIoBufferedInputStream == null) && (this.b == null))
    {
      i = -1;
      return i;
    }
    if (this.jdField_a_of_type_JavaIoBufferedInputStream != null) {}
    for (int j = this.jdField_a_of_type_JavaIoBufferedInputStream.read();; j = -1)
    {
      i = j;
      if (j != -1) {
        break;
      }
      i = j;
      if (this.b == null) {
        break;
      }
      j = this.b.read();
      i = j;
      if (j == -1) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.f != 3) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_JavaIoByteArrayOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(j);
      return j;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i;
    if ((this.jdField_a_of_type_JavaIoBufferedInputStream == null) && (this.b == null))
    {
      i = -1;
      return i;
    }
    if (this.jdField_a_of_type_JavaIoBufferedInputStream != null)
    {
      i = this.jdField_a_of_type_JavaIoBufferedInputStream.read(paramArrayOfByte);
      j = i;
      if (QLog.isColorLevel()) {
        QLog.i("SwiftWebViewHttpBridge", 2, "now read data from memory buffer second: " + i);
      }
    }
    for (int j = i;; j = -1)
    {
      i = j;
      if (j != -1) {
        break;
      }
      i = j;
      if (this.b == null) {
        break;
      }
      j = this.b.read(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.i("SwiftWebViewHttpBridge", 2, "now read data from socket stream second: " + j);
      }
      i = j;
      if (j == -1) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.f != 3) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_JavaIoByteArrayOutputStream == null) {
        break;
      }
      this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte, 0, j);
      return j;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaIoBufferedInputStream == null) && (this.b == null)) {
      return -1;
    }
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "buffer three, error");
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    int j = 0;
    label65:
    if (j < paramInt2) {}
    for (;;)
    {
      int k;
      try
      {
        if (this.jdField_a_of_type_JavaIoBufferedInputStream == null) {
          break label211;
        }
        i = this.jdField_a_of_type_JavaIoBufferedInputStream.read();
        k = i;
        if (i == -1)
        {
          k = i;
          if (this.b != null)
          {
            i = this.b.read();
            k = i;
            if (i != -1)
            {
              k = i;
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftWebViewHttpBridge.f == 3)
              {
                k = i;
                if (this.jdField_a_of_type_JavaIoByteArrayOutputStream != null)
                {
                  this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(i);
                  k = i;
                }
              }
            }
          }
        }
        if (k == -1)
        {
          if (j == 0) {
            break;
          }
          return j;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        if (j != 0) {
          return j;
        }
        throw paramArrayOfByte;
      }
      paramArrayOfByte[(paramInt1 + j)] = ((byte)k);
      j += 1;
      break label65;
      return paramInt2;
      label211:
      i = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */