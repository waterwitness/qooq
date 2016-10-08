import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class nqt
  implements View.OnClickListener
{
  public nqt(ThumbItemBuilder paramThumbItemBuilder, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("individuation_url_type", 40303);
    String str = IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, "call", "mvip.gongneng.anroid.individuation.web");
    str = str + "&funcallId=" + this.jdField_a_of_type_Int;
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_AndroidContentContext, str, 524288L, paramView, true, -1);
    int i = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).h();
    if (i == 2) {
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004A25", "0X8004A25", 0, 0, "" + i, "", "", "");
      return;
      if (i == 3) {
        i = 2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */