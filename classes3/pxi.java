import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.FaceDownloader;
import com.tencent.mobileqq.app.FaceDownloader.FaceDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class pxi
  extends MqqHandler
{
  public pxi(FaceDownloader paramFaceDownloader, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    while (paramMessage.what != 100) {
      return;
    }
    int i = 0;
    label16:
    if (i < this.a.b.size())
    {
      paramMessage = (pxl)this.a.b.get(i);
      if (paramMessage != null) {
        break label56;
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label56:
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "handle download finish task.faceInfo=" + paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo + ",bitmap=" + paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo != null) && (paramMessage.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.a.a.size() > 0))
      {
        int j = 0;
        while (j < this.a.a.size())
        {
          ((FaceDownloader.FaceDownloadListener)this.a.a.get(j)).a(true, paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
          j += 1;
        }
      }
      this.a.b.remove(i);
      i -= 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */