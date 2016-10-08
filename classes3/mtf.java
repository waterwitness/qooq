import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PersonalCardUrlInfo;
import com.tencent.qphone.base.util.QLog;

public class mtf
  implements Runnable
{
  public mtf(TroopMemberCardActivity paramTroopMemberCardActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "gotoQQVipWebPage, checkClickTime: false");
      }
      return;
    }
    String str1 = "";
    String str2 = "0";
    if (ClubContentJsonTask.a != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.o != 0) {
        break label135;
      }
    }
    label135:
    for (str1 = ClubContentJsonTask.a.jdField_a_of_type_JavaLangString;; str1 = ClubContentJsonTask.a.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.o != 0) {
        str2 = this.jdField_a_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      str1 = String.format("http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&qq=%s&aid=%s&_wv=5123", new Object[] { str2, "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun" }) + "&adtag=" + "qun";
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.runOnUiThread(new mtg(this, str1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(str1);
    if (str1.contains("?")) {
      localStringBuilder.append("&platform=1");
    }
    for (;;)
    {
      localStringBuilder.append("&qq=" + str2);
      localStringBuilder.append("&adtag=" + "qun");
      localStringBuilder.append("&aid=" + "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun");
      str1 = localStringBuilder.toString();
      break;
      localStringBuilder.append("?platform=1");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */