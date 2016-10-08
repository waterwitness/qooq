import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.apollo.store.ApolloBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class prd
  implements Runnable
{
  public prd(ApolloBaseActivity paramApolloBaseActivity, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ReportController.b(null, "P_CliOper", "WebStatusReport", "", "", this.jdField_a_of_type_JavaLangString, 0, 1, ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity), this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.c, Build.VERSION.RELEASE, String.valueOf(ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity) - ApolloBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity)), String.valueOf(System.currentTimeMillis() - ApolloBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity)));
    Object localObject1 = (HashMap)ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity).getAll();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBaseActivity", 2, "mClickTime->" + ApolloBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity) + " mCurrentStepTime - mClickTime->" + (ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity) - ApolloBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity)) + " mCurrentStep->" + ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity));
    }
    Object localObject2;
    if (this.jdField_a_of_type_Int != 1)
    {
      if (localObject1 != null)
      {
        localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.a);
        if (((HashMap)localObject1).containsKey(localObject2)) {
          ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity).edit().remove((String)localObject2).commit();
        }
      }
      return;
    }
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((((Map.Entry)localObject2).getValue() instanceof String))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBaseActivity_report", 2, "current url:" + String.valueOf(((Map.Entry)localObject2).getValue()) + "\n current key:" + (String)((Map.Entry)localObject2).getKey());
        }
        if (!((String)((Map.Entry)localObject2).getKey()).equalsIgnoreCase(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.a)))
        {
          localObject2 = String.valueOf(((Map.Entry)localObject2).getValue());
          ReportController.b(null, "P_CliOper", "WebStatusReport", "", "hard code unknown", this.jdField_a_of_type_JavaLangString, 0, 1, 100, (String)localObject2, Build.VERSION.RELEASE, "100", "200");
        }
      }
    }
    ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity).edit().clear().commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */