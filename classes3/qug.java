import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qug
  implements Runnable
{
  public qug(ChatXListView paramChatXListView, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getHeight();
    if (i <= 0) {
      i = ChatXListView.a();
    }
    for (;;)
    {
      ChatXListView.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("ChatXListView", 2, "ChatXListView open_panel_threshold_value = " + ChatXListView.b());
      }
      return;
      i >>= 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */