import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class hok
  implements View.OnClickListener
{
  public hok(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "mShareActionSheet cancle button OnClick");
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.k();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */