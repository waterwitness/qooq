import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.qphone.base.util.QLog;

public class vfc
  extends SosoInterface.OnLocationListener
{
  public vfc(NearbyTroopsView paramNearbyTroopsView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {}
    do
    {
      return;
      this.a.jdField_e_of_type_Int = ((int)(paramSosoLbsInfo.a.a * 1000000.0D));
      this.a.f = ((int)(paramSosoLbsInfo.a.b * 1000000.0D));
      this.a.jdField_e_of_type_JavaLangString = paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString;
    } while (this.a.a == null);
    this.a.a.sendEmptyMessage(5);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */