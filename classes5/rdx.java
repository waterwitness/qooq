import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

public class rdx
  extends SosoInterface.OnLocationListener
{
  public rdx(DatingHandler paramDatingHandler, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString, int paramInt2, int paramInt3, long paramLong2, int paramInt4, long paramLong3, boolean paramBoolean5)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString);
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("toplist_rank", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
      return;
    }
    appoint_define.GPS localGPS = new appoint_define.GPS();
    localGPS.int32_lon.set((int)(paramSosoLbsInfo.a.b * 1000000.0D));
    localGPS.int32_lat.set((int)(paramSosoLbsInfo.a.a * 1000000.0D));
    localGPS.int32_type.set(0);
    paramSosoLbsInfo = new appoint_define.LBSInfo();
    paramSosoLbsInfo.msg_gps.set(localGPS);
    DatingHandler.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_Long, this.e, this.b, this.jdField_a_of_type_Boolean, null, paramSosoLbsInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */