import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class wnu
  extends Handler
{
  public wnu(QQMapView paramQQMapView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint;
    if ((paramMessage != null) && (paramMessage.obj != null) && (this.a.a != null)) {
      localGeoPoint = (GeoPoint)paramMessage.obj;
    }
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 0: 
      this.a.a.a(localGeoPoint);
      return;
    }
    this.a.a.c(localGeoPoint);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */