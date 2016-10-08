import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nvh
  implements DialogInterface.OnClickListener
{
  public nvh(PhotoListPanel paramPhotoListPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListPanel", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */