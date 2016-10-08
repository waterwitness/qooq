import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.bitapp.preDownload.RNPreDownloadData;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.bitapp.preDownload.RNPreDownloadHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class hdy
  implements DialogInterface.OnClickListener
{
  public hdy(RNPreDownloadHandler paramRNPreDownloadHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RNPreDownloadFacade", 4, "User click ok button");
    }
    ((RNPreDownloadData)this.a.a()).isIngoreNet = true;
    RNPreDownloadFacade.a(this.a, false);
    RNPreDownloadFacade.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */