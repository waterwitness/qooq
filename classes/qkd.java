import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateDiscuss;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qkd
  extends DiscussionObserver
{
  private qkd(UpdateDiscuss paramUpdateDiscuss)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "updateDiscussionList: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(6);
      return;
    }
    UpdateDiscuss.a(this.a).a.edit().putBoolean("isDiscussionlistok", true).commit();
    UpdateDiscuss.b(this.a).a(3, true, Integer.valueOf(3));
    this.a.a(7);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */