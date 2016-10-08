import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vip.AioVipDonateHelper;

public class njz
  implements FileManagerUtil.TipsClickedInterface
{
  public njz(GrayTipsItemBuilder paramGrayTipsItemBuilder)
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
    paramView.putString(VasH5PayUtil.b, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramView.putString(VasH5PayUtil.j, AioVipDonateHelper.a().c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    VasH5PayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\njz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */