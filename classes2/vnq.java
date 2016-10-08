import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class vnq
  implements Runnable
{
  public vnq(TroopNoticeJsHandler paramTroopNoticeJsHandler, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_JavaLangString);
      int i = 0;
      int j = localJSONArray.length();
      while (i < j)
      {
        String str = localJSONArray.get(i).toString();
        this.jdField_a_of_type_ComTencentMobileqqTroopJspTroopNoticeJsHandler.c(str);
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vnq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */