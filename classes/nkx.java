import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nkx
  implements FileManagerUtil.TipsClickedInterface
{
  public nkx(GrayTipsItemBuilder paramGrayTipsItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView)
  {
    paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ChatHistoryFileActivity.class);
    paramView.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramView.putExtra("uintype", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramView.putExtra("uinname", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    paramView.putExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab", 1);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    FileManagerReporter.a("0X800506C");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */