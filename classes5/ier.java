import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ier
  implements Runnable
{
  public ier(TroopBarAssistantManager paramTroopBarAssistantManager, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = new JSONArray();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      JSONObject localJSONObject = new JSONObject();
      String str = (String)((Iterator)localObject2).next();
      if ((str != null) && (this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null)) {
        try
        {
          localJSONObject.put(str, this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
          ((JSONArray)localObject1).put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    localObject1 = ((JSONArray)localObject1).toString();
    if (ReadInJoyHelper.b()) {
      QLog.i(TroopBarAssistantManager.jdField_a_of_type_JavaLangString, 2, "saveNewMsgSet, save newMsgStr into sp:" + (String)localObject1);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
    ((SharedPreferences.Editor)localObject2).putString("troopbar_assist_new_unread_list", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */