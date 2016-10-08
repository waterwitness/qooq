import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ugo
  implements Runnable
{
  public ugo(DCShortVideo paramDCShortVideo, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ugw localugw = new ugw();
    localugw.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localugw.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ugy localugy = new ugy("RealShortVideo.Record", localugw.a("RealShortVideo.Record"));
    DataReport.a().a(localugy);
    if (QLog.isDevelopLevel()) {
      QLog.d(DCShortVideo.a, 4, "cameraID=" + localugw.jdField_a_of_type_Int + ",hasMultiSegments=" + localugw.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */