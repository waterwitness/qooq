import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.Window;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hol
  implements DialogInterface.OnDismissListener
{
  public hol(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=" + MultiVideoPlayActivity.b(this.a));
    }
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null) && (!MultiVideoPlayActivity.b(this.a))) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.k();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.getWindow().setFlags(1024, 1024);
      MultiVideoPlayActivity.a(this.a, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */