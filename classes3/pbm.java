import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class pbm
  implements Runnable
{
  pbm(pbl parampbl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!FileUtils.d(this.a.jdField_a_of_type_Pbk.a.m)) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "delete origin final mp4 failed!" + this.a.jdField_a_of_type_Pbk.a.m);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Pbk.a.m = this.a.jdField_a_of_type_JavaLangString;
      return;
      QLog.d("PTV.NewFlowCameraActivity", 2, "delete origin final mp4 success!" + this.a.jdField_a_of_type_Pbk.a.m);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */