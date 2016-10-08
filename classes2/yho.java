import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;

class yho
  implements Runnable
{
  yho(yhn paramyhn, boolean paramBoolean, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "getCurLocation() result isCooperateCity: " + String.valueOf(this.jdField_a_of_type_Boolean) + " cityName: " + this.jdField_a_of_type_JavaLangString);
    }
    ShowNodeTaskManager.a(this.jdField_a_of_type_Yhn.a, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      ShowNodeTaskManager.a(this.jdField_a_of_type_Yhn.a);
      return;
    }
    this.jdField_a_of_type_Yhn.a.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */