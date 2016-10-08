import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ugp
  implements Runnable
{
  public ugp(DCShortVideo paramDCShortVideo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ugv localugv = new ugv();
    localugv.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localugv.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localugv.b = this.b;
    localugv.c = this.c;
    localugv.d = this.d;
    localugv.e = this.e;
    localugv.g = this.f;
    localugv.h = this.g;
    localugv.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    ugy localugy = new ugy("actStreamingVideoPlay", localugv.a("actStreamingVideoPlay"));
    DataReport.a().a(localugy);
    if (QLog.isColorLevel()) {
      QLog.d(DCShortVideo.a, 2, "reportProgressivePlayData():" + localugv.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */