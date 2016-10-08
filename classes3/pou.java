import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class pou
  implements Runnable
{
  public pou(LebaListViewAdapter paramLebaListViewAdapter, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a.getManager(35)).a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */