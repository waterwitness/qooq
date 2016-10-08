import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class wym
  extends QidianBusinessObserver
{
  public wym(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, HashMap paramHashMap)
  {
    super.a(paramBoolean, paramHashMap);
    this.a.a();
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null) && (paramHashMap.containsKey("corp")) && (paramHashMap.get("corp") != null) && (paramHashMap.containsKey("ConfigGroupInfo")) && (paramHashMap.get("ConfigGroupInfo") != null))
    {
      localQidianExternalInfo = (QidianExternalInfo)paramHashMap.get("external");
      localQidianCorpInfo = (QidianCorpInfo)paramHashMap.get("corp");
      paramHashMap = (QidianProfileUiInfo)paramHashMap.get("ConfigGroupInfo");
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(localQidianExternalInfo.uin)) {
        if ((!localQidianExternalInfo.equals(this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo)) || (!localQidianCorpInfo.equals(QidianProfileCardActivity.a(this.a))) || (!paramHashMap.equals(QidianProfileCardActivity.a(this.a))))
        {
          i = 1;
          if (i == 0) {
            break label229;
          }
          this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = localQidianExternalInfo;
          QidianProfileCardActivity.a(this.a, localQidianCorpInfo);
          QidianProfileCardActivity.a(this.a, paramHashMap);
          this.a.c(1);
          this.a.b();
        }
      }
    }
    label229:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            QidianExternalInfo localQidianExternalInfo;
            QidianCorpInfo localQidianCorpInfo;
            return;
            int i = 0;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not change");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not current uin");
      return;
    }
    QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */