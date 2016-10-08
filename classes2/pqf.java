import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class pqf
  implements ApolloResDownloader.OnApolloDownLoadListener
{
  public pqf(ApolloManager paramApolloManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      paramArrayOfInt = new ArrayList(1);
      paramArrayOfInt.add(paramString);
      ((VasExtensionHandler)this.a.a.a(71)).a(2, true, paramArrayOfInt);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "apollo dress download ok notifyUI uin: " + paramString.substring(0, 4));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloManager", 2, "apollo dress download failed " + paramString.substring(0, 4));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */