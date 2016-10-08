import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqfav.ipc.FavoritesRemoteCommand.IRemoteCommandHandler;

public class rzl
  implements FavoritesRemoteCommand.IRemoteCommandHandler
{
  public rzl(QfavFilePreviewController paramQfavFilePreviewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(int paramInt, Bundle paramBundle)
  {
    new Handler(Looper.getMainLooper()).post(new rzm(this, paramBundle));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */