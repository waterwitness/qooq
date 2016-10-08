import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class nnz
  implements View.OnClickListener
{
  public nnz(ReplyTextItemBuilder paramReplyTextItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView))
    {
      Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", paramView);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ((Activity)this.a.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968592, 0);
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "link_msg", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */