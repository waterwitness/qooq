import com.tencent.biz.bmqq.app.BmqqBusinessObserver;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;

public class wyn
  extends BmqqBusinessObserver
{
  public wyn(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    this.a.a();
    if ((paramBoolean) && (paramBmqqUserSimpleInfo != null)) {
      if (paramBmqqUserSimpleInfo.mBmqqUin.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)) {
        if (!paramBmqqUserSimpleInfo.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo))
        {
          i = 1;
          if (i == 0) {
            break label80;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = paramBmqqUserSimpleInfo;
          this.a.c(0);
        }
      }
    }
    label80:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            int i = 0;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not change");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not current uin");
      return;
    }
    QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver fail");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */