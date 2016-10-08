import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;

public class nxc
  implements DialogInterface.OnClickListener
{
  public nxc(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    FileUtils.d(this.a.ap);
    this.a.ap = "";
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nxc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */