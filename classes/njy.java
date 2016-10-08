import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasH5PayUtil;

public class njy
  implements FileManagerUtil.TipsClickedInterface
{
  public njy(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(VasH5PayUtil.f, "QQ会员");
    paramView.putString(VasH5PayUtil.g, "LTMCLUB");
    paramView.putString(VasH5PayUtil.e, "1450000515");
    paramView.putInt(VasH5PayUtil.c, 3);
    paramView.putString(VasH5PayUtil.d, this.jdField_a_of_type_JavaLangString);
    paramView.putString(VasH5PayUtil.j, this.b);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) {
      paramView.putString(VasH5PayUtil.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (;;)
    {
      VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, paramView);
      return;
      paramView.putString(VasH5PayUtil.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\njy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */