import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import java.util.List;
import org.json.JSONObject;

class vml
  implements Runnable
{
  vml(vmk paramvmk, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = TroopFeedParserHelper.a(this.jdField_a_of_type_OrgJsonJSONObject, "" + this.jdField_a_of_type_Vmk.a.jdField_a_of_type_JavaLangLong, this.jdField_a_of_type_Vmk.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    List localList = (List)localObject[0];
    localObject = (List)localObject[1];
    ((List)localObject).addAll(this.jdField_a_of_type_Vmk.a.jdField_a_of_type_JavaUtilList);
    Message localMessage = this.jdField_a_of_type_Vmk.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.obj = this.jdField_a_of_type_Vmk.a.a(localList, (List)localObject);
    this.jdField_a_of_type_Vmk.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */