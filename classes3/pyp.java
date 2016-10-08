import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.widget.ActionSheet;

public final class pyp
  implements AdapterView.OnItemClickListener
{
  public pyp(ActionSheet paramActionSheet, int paramInt, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramAdapterView = "";
    if (1 == this.jdField_a_of_type_Int)
    {
      paramAdapterView = "0X8005D50";
      if (!TextUtils.isEmpty(paramAdapterView)) {}
      switch ((int)paramLong)
      {
      case 4: 
      case 5: 
      default: 
        label72:
        if ((paramLong != 2L) && (paramLong != 3L)) {
          break label325;
        }
        paramInt = -1;
        if (!WXShareHelper.a().a()) {
          paramInt = 2131369529;
        }
        break;
      }
    }
    for (;;)
    {
      if (paramInt == -1) {
        break label325;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492908));
      return;
      if (2 == this.jdField_a_of_type_Int)
      {
        paramAdapterView = "0X8005D51";
        break;
      }
      if (3 != this.jdField_a_of_type_Int) {
        break;
      }
      paramAdapterView = "";
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "1", "", "", "");
      break label72;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "2", "", "", "");
      break label72;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "3", "", "", "");
      break label72;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "4", "", "", "");
      break label72;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramAdapterView, paramAdapterView, 0, 0, "5", "", "", "");
      break label72;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131369530;
      }
    }
    label325:
    paramAdapterView = "邀请加入QQ热聊：" + this.jdField_a_of_type_JavaLangString;
    switch ((int)paramLong)
    {
    default: 
      return;
    case 0: 
      paramAdapterView = "我在[" + this.jdField_a_of_type_JavaLangString + "]热聊";
      boolean bool = HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, false);
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, paramAdapterView, this.c, this.d, this.e, this.f, bool);
      return;
    case 1: 
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, paramAdapterView, this.c, this.d, this.f);
      return;
    case 2: 
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, paramAdapterView, "立即加入，一起热聊！\nQQ热聊有上百个热门话题，与同兴趣的人一起群聊。", this.b, this.d, this.g);
      return;
    case 3: 
      HotChatHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, paramAdapterView, this.c, this.b, this.d, this.g);
      return;
    }
    HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.d);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */