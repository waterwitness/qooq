import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class nrd
  implements URLDrawable.DownloadListener
{
  public nrd(TroopGiftMsgItemBuilder paramTroopGiftMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "objicon_fail", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "0", "" + TroopMemberUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */