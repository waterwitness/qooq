import android.content.SharedPreferences;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ConcurrentHashMap;

public class heb
  implements Runnable
{
  public heb(AuthorizeConfig paramAuthorizeConfig)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastUpdate", 0L);
    if (l != AuthorizeConfig.jdField_b_of_type_Long)
    {
      AuthorizeConfig.jdField_b_of_type_Long = l;
      this.a.jdField_a_of_type_OrgJsonJSONObject = null;
      this.a.e = null;
      this.a.c = null;
      this.a.d = null;
      this.a.jdField_b_of_type_OrgJsonJSONObject = null;
      this.a.jdField_b_of_type_OrgJsonJSONArray = null;
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\heb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */