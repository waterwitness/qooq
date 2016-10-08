import android.widget.ImageView;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class lra
  extends NearbyProxyObserver
{
  public lra(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(2, "NearbyUtils", "onRedTouchClick", new Object[] { paramString });
    }
    if (paramString.equals(Integer.toString(100510)))
    {
      paramString = (RedTouchManager)this.a.a.getManager(35);
      if (paramString.a(String.valueOf(100510)).type.get() == 5)
      {
        paramString.b(String.valueOf(100510));
        if (Leba.a(this.a).getVisibility() != 8) {
          Leba.a(this.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */