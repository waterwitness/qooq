import android.content.Intent;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class gnk
  extends NearbyCardObserver
{
  public gnk(QQServiceForAV paramQQServiceForAV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(", nickname=").append(paramString).append(", gender=").append(paramInt1).append(", age=").append(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "QQServiceForAV.onNearbyCardDownload(), isSuccess: " + paramBoolean + ", card = " + ((StringBuilder)localObject).toString());
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("tencent.video.q2v.getNearByProfile");
    ((Intent)localObject).putExtra("uin", String.valueOf(paramLong));
    ((Intent)localObject).putExtra("nickname", paramString);
    ((Intent)localObject).putExtra("gender", paramInt1);
    ((Intent)localObject).putExtra("age", paramInt2);
    if (this.a.a == null) {
      this.a.a = ((QQAppInterface)this.a.a());
    }
    if (this.a.a != null) {
      this.a.a.a().sendBroadcast((Intent)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */