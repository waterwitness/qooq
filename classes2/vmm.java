import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

class vmm
  implements Runnable
{
  vmm(vmk paramvmk, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = TroopFeedParserHelper.a(this.jdField_a_of_type_OrgJsonJSONObject, "" + this.jdField_a_of_type_Vmk.a.jdField_a_of_type_JavaLangLong, this.jdField_a_of_type_Vmk.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    List localList = (List)localObject1[0];
    localObject1 = (List)localObject1[1];
    if ((localList == null) || (localObject1 == null)) {
      return;
    }
    Object localObject2 = localList.toString();
    int i = localList.size() - 1;
    while (i >= 0)
    {
      String str = (String)localList.get(i);
      if (!this.jdField_a_of_type_Vmk.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
        localList.remove(str);
      }
      i -= 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "cgi callback ids, beforeFilter:" + (String)localObject2 + "|afterFilter ids:" + localList.toString());
    }
    this.jdField_a_of_type_Vmk.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    localObject2 = this.jdField_a_of_type_Vmk.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
    ((Message)localObject2).obj = this.jdField_a_of_type_Vmk.a.a(localList, (List)localObject1);
    this.jdField_a_of_type_Vmk.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */