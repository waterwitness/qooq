import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gjf
  implements DialogInterface.OnClickListener
{
  public gjf(GuildMultiActivity paramGuildMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.a, 2, "showEnterRoomFailDialog: exitMultiRoom");
    }
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */