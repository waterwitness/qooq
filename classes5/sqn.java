import android.content.ContentValues;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;

public class sqn
  implements Runnable
{
  public sqn(FreshNewsManager paramFreshNewsManager, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("commentCount", Integer.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a.a(FreshNewsInfo.class.getSimpleName(), localContentValues, "feedId=?", new String[] { this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */