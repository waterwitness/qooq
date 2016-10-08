import android.content.Intent;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.OfflineExpire;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public final class hhd
  implements AsyncBack
{
  public hhd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    OfflineExpire.a();
    if (OfflineExpire.b() == 0)
    {
      paramString = new Intent("com.tencent.process.tmdownloader.exit");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("com.tencent.mobileqq:TMAssistantDownloadSDKService");
      paramString.putStringArrayListExtra("procNameList", localArrayList);
      paramString.putExtra("verify", OfflineExpire.a(localArrayList, false));
      if (QLog.isColorLevel()) {
        QLog.d(OfflineExpire.a, 2, "sendBroadcast to close TMAssistant sdk process");
      }
      BaseApplicationImpl.getContext().sendBroadcast(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */