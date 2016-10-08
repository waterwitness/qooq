import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersUI.MVMembersInfo;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class gmc
  implements MultiVideoMembersClickListener
{
  public gmc(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(RandomMultiActivity.jdField_a_of_type_JavaLangString, 2, "MultiVideoMembersClickListener , Uin = " + paramLong + " , videoScr = " + paramInt1 + " , isNeedRequest " + paramBoolean + " , positon = " + paramInt2);
    }
    if (!this.a.c.equalsIgnoreCase(String.valueOf(paramLong)))
    {
      if (this.a.jdField_a_of_type_ComTencentAvUtilsAvAddFriendHelper.a(String.valueOf(paramLong)) == 0) {
        ReportController.b(null, "CliOper", "", "", "0X80053C4", "0X80053C4", 0, 0, "", "", "", "");
      }
      this.a.d = String.valueOf(paramLong);
      if (this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null)
      {
        MultiMembersUI.MVMembersInfo localMVMembersInfo = this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong);
        if (localMVMembersInfo != null) {
          this.a.a(localMVMembersInfo, paramInt2);
        }
      }
    }
    if ((paramInt2 == 17) && (paramBoolean)) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */