import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class qff
  extends LBSObserver
{
  public qff(QQMapActivityProxy paramQQMapActivityProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivityProxy", 2, "mLbsObserver, onGetStreetViewUrl: isSuccess=" + paramBoolean + ", hashCode=" + hashCode());
    }
    if ((paramBoolean) && (paramArrayOfByte != null)) {
      QQMapActivityProxy.a(this.a).sendBroadcast(new Intent().setAction("com.tencent.mobileqq.onGetStreetViewUrl").putExtra("streetViewUrl", new String(paramArrayOfByte)));
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("mLbsObserver, onGetLbsShareSearch: isSuccess=").append(paramBoolean).append(", isDataNull=");
      if (paramArrayOfObject != null) {
        break label65;
      }
    }
    label65:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQMapActivityProxy", 2, paramBoolean + ", hashCode=" + hashCode());
      if (paramArrayOfObject != null) {
        break;
      }
      return;
    }
    Object localObject = (ToServiceMsg)paramArrayOfObject[0];
    paramArrayOfObject = (byte[])paramArrayOfObject[1];
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.onGetLbsShareSearch");
    localIntent.putExtra("data", paramArrayOfObject);
    localIntent.putExtra("req", ((ToServiceMsg)localObject).extraData.getBundle("req"));
    QQMapActivityProxy.a(this.a).sendBroadcast(localIntent);
  }
  
  protected void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("mLbsObserver, onGetLbsShareShop: isSuccess=").append(paramBoolean).append(", isDataNull=");
      if (paramArrayOfObject != null) {
        break label65;
      }
    }
    label65:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQMapActivityProxy", 2, paramBoolean + ", hashCode=" + hashCode());
      if (paramArrayOfObject != null) {
        break;
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.onGetLbsShareShop");
    ((Intent)localObject).putExtra("data", (byte[])paramArrayOfObject[1]);
    ((Intent)localObject).putExtra("req", ((ToServiceMsg)paramArrayOfObject[0]).extraData.getBundle("req"));
    QQMapActivityProxy.a(this.a).sendBroadcast((Intent)localObject);
  }
  
  protected void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("mLbsObserver, onGetShareShopDetail: isSuccess=").append(paramBoolean).append(", isDataNull=");
      if (paramArrayOfObject != null) {
        break label65;
      }
    }
    label65:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("QQMapActivityProxy", 2, paramBoolean + ", hashCode=" + hashCode());
      if (paramArrayOfObject != null) {
        break;
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.onGetShareShopDetail");
    ((Intent)localObject).putExtra("data", (byte[])paramArrayOfObject[1]);
    ((Intent)localObject).putExtra("req", ((ToServiceMsg)paramArrayOfObject[0]).extraData.getBundle("req"));
    QQMapActivityProxy.a(this.a).sendBroadcast((Intent)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */