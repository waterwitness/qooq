import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryViewBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class kwj
  implements TabBarView.OnTabChangeListener
{
  public kwj(ChatHistoryFileActivity paramChatHistoryFileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    ChatHistoryViewBase localChatHistoryViewBase = null;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.c();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a());
      }
      if (localChatHistoryViewBase == null) {
        break;
      }
      localChatHistoryViewBase.a(ChatHistoryFileActivity.a(this.a));
      localChatHistoryViewBase.d();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase = localChatHistoryViewBase;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a = this.a;
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a(), 0, new ViewGroup.LayoutParams(-1, -1));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label310;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a();
      return;
      localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 0);
      continue;
      localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 1);
      ReportController.b(this.a.app, "dc00898", "", "", "0X8007126", "0X8007126", 0, 0, "", "", "", "");
      continue;
      localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 2);
      ReportController.b(this.a.app, "dc00898", "", "", "0X8007127", "0X8007127", 0, 0, "", "", "", "");
      continue;
      localChatHistoryViewBase = ChatHistoryFileActivity.a(this.a, 3);
      ReportController.b(this.a.app, "dc00898", "", "", "0X8007128", "0X8007128", 0, 0, "", "", "", "");
    }
    label310:
    this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */