import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public final class swp
  implements Runnable
{
  public swp(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.a.a();
    if (localObject != null) {
      str = ((QQAppInterface)localObject).a();
    }
    localObject = new HashMap();
    if (this.jdField_a_of_type_JavaLangString != null) {
      ((HashMap)localObject).put("activity", this.jdField_a_of_type_JavaLangString);
    }
    if (this.b != null) {
      ((HashMap)localObject).put("detail", this.b);
    }
    ((HashMap)localObject).put("type", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplicationImpl.a()).a(str, "BadTokenHooker", false, 0L, 0L, (HashMap)localObject, "", true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */