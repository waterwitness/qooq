import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import java.util.ArrayList;

public class mpz
  implements Runnable
{
  public mpz(TroopClassChoiceActivity.GetClassChoiceCallBack paramGetClassChoiceCallBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_JavaLangString)) {
      this.a.a.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this.a.a).a();
    }
    for (;;)
    {
      TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
      return;
      this.a.a.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this.a.a).a(this.a.a.jdField_a_of_type_JavaLangString);
      if ((this.a.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        GroupCatalogBean localGroupCatalogBean = (GroupCatalogBean)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) {
          this.a.a.setTitle(localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */