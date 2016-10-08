import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil;
import cooperation.qqhotspot.hotspotnode.HotSpotNodeUtil.LocationCallBack;

public final class yhf
  extends SosoInterface.OnLocationListener
{
  public yhf(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, HotSpotNodeUtil.LocationCallBack paramLocationCallBack)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      try
      {
        QLog.d("HotSpotNodeUtil", 2, "onLocationFinish lat:" + paramSosoLbsInfo.a.a + " lon:" + paramSosoLbsInfo.a.b + " city:" + paramSosoLbsInfo.a.e);
        if (HotSpotNodeUtil.a(paramSosoLbsInfo.a.c, paramSosoLbsInfo.a.d, paramSosoLbsInfo.a.e)) {
          if (this.a != null) {
            this.a.a(true, paramSosoLbsInfo.a.e);
          }
        }
        for (;;)
        {
          HotSpotNodeUtil.a(System.currentTimeMillis());
          HotSpotNodeUtil.a(paramSosoLbsInfo);
          return;
          if (this.a != null) {
            this.a.a(false, paramSosoLbsInfo.a.e);
          }
        }
        this.a.a(false, null);
      }
      catch (Exception paramSosoLbsInfo)
      {
        paramSosoLbsInfo.printStackTrace();
        QLog.d("HotSpotNodeUtil", 2, "onLocationFinish exception:" + paramSosoLbsInfo);
        if (this.a == null) {
          return;
        }
      }
      return;
    }
    QLog.d("HotSpotNodeUtil", 2, "onLocationFinish failed:" + paramInt);
    if (this.a != null) {
      this.a.a(false, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */