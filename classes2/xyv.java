import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.c2b.C2BLBSUtil.C2BLBSObserver;

public class xyv
  extends SosoInterface.OnLocationListener
{
  private C2BLBSUtil.C2BLBSObserver a;
  
  public xyv(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, C2BLBSUtil.C2BLBSObserver paramC2BLBSObserver)
  {
    super(paramInt, true, true, 0L, paramBoolean1, paramBoolean2, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramC2BLBSObserver;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      double d1 = paramSosoLbsInfo.a.jdField_e_of_type_Double;
      double d2 = paramSosoLbsInfo.a.a;
      double d3 = paramSosoLbsInfo.a.b;
      String str1;
      if (paramSosoLbsInfo.a.h == null) {
        str1 = "";
      }
      for (;;)
      {
        String str2;
        label58:
        String str3;
        label72:
        String str4;
        label86:
        String str5;
        label100:
        String str6;
        label114:
        String str7;
        label128:
        String str8;
        if (paramSosoLbsInfo.a.g == null)
        {
          str2 = "";
          if (paramSosoLbsInfo.a.j != null) {
            break label204;
          }
          str3 = "";
          if (paramSosoLbsInfo.a.i != null) {
            break label216;
          }
          str4 = "";
          if (paramSosoLbsInfo.a.d != null) {
            break label228;
          }
          str5 = "";
          if (paramSosoLbsInfo.a.f != null) {
            break label240;
          }
          str6 = "";
          if (paramSosoLbsInfo.a.c != null) {
            break label252;
          }
          str7 = "";
          if (paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString != null) {
            break label264;
          }
          str8 = "";
        }
        try
        {
          for (;;)
          {
            this.a.a(0, new LBSInfo(str7, str5, str8, str6, str2, str1, str4, str3, d2, d3, d1, null));
            return;
            str1 = paramSosoLbsInfo.a.h;
            break;
            str2 = paramSosoLbsInfo.a.g;
            break label58;
            label204:
            str3 = paramSosoLbsInfo.a.j;
            break label72;
            label216:
            str4 = paramSosoLbsInfo.a.i;
            break label86;
            label228:
            str5 = paramSosoLbsInfo.a.d;
            break label100;
            label240:
            str6 = paramSosoLbsInfo.a.f;
            break label114;
            label252:
            str7 = paramSosoLbsInfo.a.c;
            break label128;
            label264:
            str8 = paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString;
          }
        }
        catch (Exception localException)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("C2BLBSUtil", 2, String.format("Call observer onUpdateAddress fail, locRes = %s", new Object[] { paramSosoLbsInfo }), localException);
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2BLBSUtil", 2, String.format("onLocationUpdate() error = %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    this.a.a(paramInt, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */