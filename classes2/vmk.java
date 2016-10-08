import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class vmk
  implements HttpWebCgiAsyncTask.Callback
{
  public vmk(TroopFeedsDataManager paramTroopFeedsDataManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("retcode") == 0) {
          break label653;
        }
        i = paramJSONObject.optInt("ec");
        if (i == 0) {
          break label653;
        }
        i = 0;
        if (i == 0)
        {
          if ((paramInt == 1000) || (paramInt == 1002))
          {
            TroopFeedsDataManager.e(this.a);
            this.a.notifyObservers(Integer.valueOf(103));
            if (paramInt == 1002) {
              this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager", 2, "cgi end(failed): " + System.currentTimeMillis());
          }
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle = paramBundle;
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "cgi end(suc): " + System.currentTimeMillis());
        }
        if (paramInt == 1000)
        {
          ThreadManager.b().post(new vml(this, paramJSONObject));
          return;
        }
      }
      finally {}
      if (paramInt == 1002)
      {
        ThreadManager.b().post(new vmm(this, paramJSONObject));
        return;
      }
      if (paramInt == 1003)
      {
        TroopFeedsDataManager.f(this.a);
        paramBundle = paramJSONObject.optJSONArray("inst");
        if ((paramBundle != null) && (paramBundle.length() > 0))
        {
          this.a.jdField_a_of_type_OrgJsonJSONObject = paramBundle.optJSONObject(0);
          this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
        }
        this.a.notifyObservers(Integer.valueOf(106));
        return;
      }
      Object localObject;
      if (paramInt == 1004)
      {
        localObject = paramJSONObject.optJSONArray("feeds");
        paramBundle = paramJSONObject.optJSONArray("inst");
        if ((localObject != null) && (((JSONArray)localObject).length() == 1))
        {
          paramBundle = ((JSONArray)localObject).optJSONObject(0);
          this.a.b = paramBundle;
          this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
          paramInt = 1;
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label651;
        }
        TroopFeedsDataManager.g(this.a);
        this.a.notifyObservers(Integer.valueOf(1007));
        return;
        if ((localObject != null) && (((JSONArray)localObject).length() == 2))
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(0);
          localObject = ((JSONArray)localObject).optJSONObject(1);
          long l1 = localJSONObject.optLong("pubt");
          long l2 = ((JSONObject)localObject).optLong("pubt");
          if (l1 >= l2)
          {
            this.a.b = localJSONObject;
            this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
          }
          for (;;)
          {
            if ((paramBundle != null) && (paramBundle.length() > 0))
            {
              paramBundle = paramBundle.optJSONObject(0);
              if (paramBundle.optLong("pubt") > l1)
              {
                this.a.b = paramBundle;
                this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
              }
            }
            paramInt = 1;
            break;
            this.a.b = ((JSONObject)localObject);
            this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
            l1 = l2;
          }
          if ((paramInt != 1005) && (paramInt != 1006)) {
            break;
          }
          paramJSONObject = TroopFeedParserHelper.a(paramJSONObject, "" + this.a.jdField_a_of_type_JavaLangLong, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          paramBundle = (List)paramJSONObject[0];
          paramJSONObject = (List)paramJSONObject[1];
          this.a.jdField_a_of_type_JavaUtilList = paramJSONObject;
          TroopFeedsDataManager.h(this.a);
          if (paramInt == 1005)
          {
            this.a.notifyObservers(Integer.valueOf(1008));
            return;
          }
          this.a.notifyObservers(Integer.valueOf(1009));
          return;
        }
        paramInt = 0;
      }
      label651:
      continue;
      label653:
      int i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */