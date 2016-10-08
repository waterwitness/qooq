import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import java.util.HashMap;
import org.json.JSONObject;

public class wug
  implements Runnable
{
  public wug(HttpCgiAsyncTask paramHttpCgiAsyncTask, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a != null)
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get("ResultType")).intValue() == 1) {
        this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a.a((JSONObject)this.jdField_a_of_type_JavaUtilHashMap.get("ResultValue"));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a.a((Exception)this.jdField_a_of_type_JavaUtilHashMap.get("ResultValue"));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */