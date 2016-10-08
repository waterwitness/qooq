import android.text.TextUtils;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class gcy
  extends DiscussionObserver
{
  public gcy(AVMeetingActivity paramAVMeetingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.a.a(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVMeetingActivity", 2, "onCreateDiscussion, isSuccess:" + paramBoolean + ", roomId:" + paramLong + ",discussName:" + str);
    }
    if ((this.a.c) && (this.a.a != null)) {
      this.a.a.dismiss();
    }
    ((DiscussionHandler)this.a.app.a(6)).a(paramLong, str);
    if (!paramBoolean)
    {
      this.a.finish();
      return;
    }
    this.a.b = String.valueOf(paramLong);
    this.a.a(this.a.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */