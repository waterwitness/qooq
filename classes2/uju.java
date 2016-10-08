import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.rn.LBSManager;

public class uju
  extends SosoInterface.OnLocationListener
{
  int jdField_a_of_type_Int;
  Callback jdField_a_of_type_ComFacebookReactBridgeCallback;
  
  public uju(int paramInt, Callback paramCallback)
  {
    super(0, true, false, 60000L, false, false, "LbsMngLocationListener");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComFacebookReactBridgeCallback = paramCallback;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    WritableMap localWritableMap = null;
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = 0.0D;
    double d1 = 0.0D;
    boolean bool;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      d4 = paramSosoLbsInfo.a.jdField_a_of_type_Float;
      d3 = paramSosoLbsInfo.a.b;
      d2 = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      d1 = paramSosoLbsInfo.a.e;
      bool = true;
      paramSosoLbsInfo = localWritableMap;
      if (NearbyUtils.a()) {
        NearbyUtils.a(LBSManager.TAG, String.format("onLocationFinish, [%.6f, %.6f, %.6f, %.6f]", new Object[] { Double.valueOf(d4), Double.valueOf(d3), Double.valueOf(d2), Double.valueOf(d1) }), new Object[0]);
      }
      if (this.jdField_a_of_type_ComFacebookReactBridgeCallback != null)
      {
        if ((!bool) || (0 != 0)) {
          break label292;
        }
        localWritableMap = Arguments.createMap();
        localWritableMap.putDouble("accuracy", d4);
        localWritableMap.putInt("alt", (int)d1);
        localWritableMap.putInt("lat", (int)(d2 * 1000000.0D));
        localWritableMap.putInt("lon", (int)(1000000.0D * d3));
      }
    }
    for (;;)
    {
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
        bool = false;
        paramSosoLbsInfo = "定位失败";
        break;
      case 1: 
        this.jdField_a_of_type_ComFacebookReactBridgeCallback.invoke(new Object[] { paramSosoLbsInfo, localWritableMap });
        return;
      case 2: 
        this.jdField_a_of_type_ComFacebookReactBridgeCallback.invoke(new Object[] { paramSosoLbsInfo, Boolean.valueOf(bool), localWritableMap });
        return;
        label292:
        localWritableMap = null;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */