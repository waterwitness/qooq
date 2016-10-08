import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.List;

public class ufb
  implements Runnable
{
  public ufb(RedTouchManager paramRedTouchManager, BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List paramList)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RedTouchManager.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ufb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */