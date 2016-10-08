import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class usi
  implements MediaScannerConnection.MediaScannerConnectionClient
{
  private MediaScannerConnection jdField_a_of_type_AndroidMediaMediaScannerConnection;
  private File jdField_a_of_type_JavaIoFile;
  
  public usi(Context paramContext, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if ((paramFile != null) && (paramFile.exists()) && (!paramFile.isDirectory()))
    {
      this.jdField_a_of_type_JavaIoFile = paramFile;
      this.jdField_a_of_type_AndroidMediaMediaScannerConnection = new MediaScannerConnection(paramContext, this);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaScannerConnection != null) && (!this.jdField_a_of_type_AndroidMediaMediaScannerConnection.isConnected())) {
      this.jdField_a_of_type_AndroidMediaMediaScannerConnection.connect();
    }
  }
  
  public void onMediaScannerConnected()
  {
    this.jdField_a_of_type_AndroidMediaMediaScannerConnection.scanFile(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), null);
  }
  
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaScannerConnection.isConnected()) {
      this.jdField_a_of_type_AndroidMediaMediaScannerConnection.disconnect();
    }
    this.jdField_a_of_type_AndroidMediaMediaScannerConnection = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */