import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView.AutoLocationCallback;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.Overlay;

public class vse
  extends Handler
{
  public vse(AutoLocationMapView paramAutoLocationMapView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint = (GeoPoint)paramMessage.obj;
    this.a.clearAllOverlays();
    if (paramMessage.arg1 == 0)
    {
      Object localObject = this.a.getController();
      ((MapController)localObject).setCenter(localGeoPoint);
      ((MapController)localObject).setZoom(this.a.getMaxZoomLevel());
      localObject = new vsg(BitmapManager.a(this.a.getContext().getResources(), 2130839404), localGeoPoint);
      this.a.addOverlay((Overlay)localObject);
    }
    if (this.a.a != null) {
      this.a.a.a(paramMessage.arg1, localGeoPoint);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */