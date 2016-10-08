import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hrk
  implements Runnable
{
  public hrk(VideoListView paramVideoListView, AccountDetail paramAccountDetail)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoListView", 2, "saveAccountDetailInSubThread() start()");
    }
    try
    {
      VideoListView.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.pubaccount.video.VideoListView", 2, "saveAccountDetailInSubThread() saveAccountDetailToDB ERROR e=" + localException.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */