import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;

public class mec
  extends SosoInterface.OnLocationListener
{
  public mec(QQMapActivity paramQQMapActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.c) {
      SosoInterface.b(this);
    }
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null))
    {
      str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("get_location", 2, "onLocationFinish errCode=" + paramInt + " address=" + str);
      }
      if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label227;
      }
      paramSosoLbsInfo = new GeoPoint((int)(paramSosoLbsInfo.a.a * 1000000.0D), (int)(paramSosoLbsInfo.a.jdField_b_of_type_Double * 1000000.0D));
      if (this.a.u)
      {
        this.a.a.setCenter(paramSosoLbsInfo);
        if (!this.a.l) {
          break label186;
        }
        label147:
        this.a.h();
        this.a.u = false;
      }
      this.a.a(paramSosoLbsInfo, str);
    }
    for (;;)
    {
      label186:
      label227:
      try
      {
        this.a.dismissDialog(0);
        return;
      }
      catch (IllegalArgumentException paramSosoLbsInfo) {}
      str = "";
      break;
      this.a.k = str;
      this.a.c.setVisibility(0);
      this.a.d.setVisibility(0);
      this.a.b(paramSosoLbsInfo);
      break label147;
      this.a.x();
      SosoInterface.b(this);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */