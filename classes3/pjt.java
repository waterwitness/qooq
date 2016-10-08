import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class pjt
  extends MqqHandler
{
  public pjt(ShortVideoPlayActivity paramShortVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QQToast.a(this.a, 2131371520, 0).a();
          return;
          String str = this.a.getString(2131371521);
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.a.a, 2, str + paramMessage, 0).a();
          ImageUtil.a(this.a, paramMessage);
          return;
          paramMessage = DialogUtil.a(this.a.a, 232, this.a.a.getResources().getString(2131371546), this.a.a.getResources().getString(2131371547), 2131371548, 2131368782, new pju(this), new pjv(this));
          ShortVideoPlayActivity.a(this.a, paramMessage);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "...wifi => mobile...");
          }
          if ((this.a.j != 1) && (this.a.j != 2)) {
            break;
          }
        } while (!this.a.b());
        this.a.k();
        this.a.s();
        return;
      } while (this.a.j != 0);
      if ((!ShortVideoPlayActivity.a(this.a)) || (!ShortVideoPlayActivity.b(this.a))) {
        break;
      }
    } while (!this.a.b());
    this.a.k();
    this.a.h = false;
    this.a.s();
    return;
    ShortVideoPlayActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pjt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */