import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class hon
  implements DialogInterface.OnShowListener
{
  public hon(MultiVideoPlayActivity paramMultiVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "mShareActionSheet onShow()");
    }
    this.a.a.getWindow().clearFlags(8);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */