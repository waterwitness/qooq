package cooperation.qzone;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppRuntime;

public class QZoneHelper$UserInfo
{
  private static UserInfo a;
  public String a;
  public String b;
  
  private QZoneHelper$UserInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static UserInfo a()
  {
    if (jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo == null) {
      jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo = new UserInfo();
    }
    jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo.jdField_a_of_type_JavaLangString = BaseApplicationImpl.a().a().getAccount();
    jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo.b = null;
    return jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneHelper$UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */