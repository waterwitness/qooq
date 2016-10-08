import android.content.ContentValues;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;

public class sqo
  implements Runnable
{
  public sqo(FreshNewsManager paramFreshNewsManager, boolean paramBoolean, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jdField_a_of_type_Boolean) {
      localContentValues.put("praiseFlag", Integer.valueOf(1));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a.a(FreshNewsInfo.class.getSimpleName(), localContentValues, "feedId=?", new String[] { this.jdField_a_of_type_JavaLangString });
      return;
      localContentValues.put("praiseFlag", Integer.valueOf(0));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */