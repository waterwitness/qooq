import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import mqq.app.MobileQQ;

public class sbt
  implements DialogInterface.OnClickListener
{
  public sbt(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseActionBarDataLineFile.a(this.a);
    AppNetConnInfo.unregisterNetEventHandler(BaseActionBarDataLineFile.a(this.a));
    BaseActionBarDataLineFile.b(this.a);
    this.a.a.a().b(BaseActionBarDataLineFile.a(this.a));
    ((DataLineHandler)this.a.a.a().a(8)).a().a();
    Intent localIntent = new Intent(this.a.a.a().getApplication(), LiteActivity.class);
    localIntent.addFlags(67108864);
    this.a.a.a().getApplication().startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */