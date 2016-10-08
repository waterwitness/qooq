import android.os.Handler;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hox
  implements Runnable
{
  public hox(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((System.currentTimeMillis() - MultiVideoPlayActivity.a(this.a) > 5000L) && (this.a.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a())) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.p();
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 5000L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */