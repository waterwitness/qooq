import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class vsf
  extends SosoInterface.OnLocationListener
{
  public vsf(AutoLocationMapView paramAutoLocationMapView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationMapView", 2, "onLocationFinish() errCode=" + paramInt);
    }
    Message localMessage = this.a.a.obtainMessage(1);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = new GeoPoint((int)(paramSosoLbsInfo.a.a * 1000000.0D), (int)(paramSosoLbsInfo.a.b * 1000000.0D));
      localMessage.arg1 = 0;
      localMessage.obj = paramSosoLbsInfo;
    }
    for (;;)
    {
      localMessage.sendToTarget();
      return;
      localMessage.arg2 = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */