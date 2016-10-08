import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class rgz
  extends TransProcessorHandler
{
  public rgz(FavroamingManager paramFavroamingManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.f != 9)) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 1002: 
      default: 
        return;
      case 1001: 
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingManager", 2, "start uploadFace favEmoticon");
        }
        break;
      }
    } while (FavroamingManager.access$200().incrementAndGet() < FavroamingManager.access$300());
    FavroamingManager.access$400(this.a);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "finish uploadFace favEmoticon resId=" + localFileMsg.i);
    }
    ThreadManager.a(new rha(this, localFileMsg), 5, null, false);
    return;
    QLog.i("FavroamingManager", 1, "upload fav error:" + localFileMsg.i);
    if (this.a.mApp != null) {}
    for (int i = NetworkUtil.b(this.a.mApp.getApplication());; i = -1)
    {
      VasReportUtils.a("emotionType", "emotionActionFav", "4", "", "", i + "", localFileMsg.i, "", "", "");
      return;
      QLog.i("FavroamingManager", 1, "upload fav cancel:" + localFileMsg.i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */