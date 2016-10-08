import com.tencent.mobileqq.app.FaceObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.util.NearByFaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class vyu
  extends FaceObserver
{
  public vyu(NearByFaceDrawable paramNearByFaceDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onUpdateStrangerHead.faceInfo=" + paramFaceInfo + ", isSuccess=" + paramBoolean);
    }
    if ((this.a.b) || (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (paramFaceInfo == null)) {}
    while ((paramFaceInfo.b != this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.b) || (!this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a.equals(paramFaceInfo.a))) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppFaceObserver != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppFaceObserver);
    }
    if (paramBoolean)
    {
      paramFaceInfo = this.a.b();
      if (paramFaceInfo != null)
      {
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramFaceInfo);
        return;
      }
      this.a.a();
      return;
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */