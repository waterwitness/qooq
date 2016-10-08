import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;

public class phg
  implements Runnable
{
  public phg(SelectMemberActivity paramSelectMemberActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MultiAVType", String.valueOf(1));
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.a(), 3000, this.jdField_a_of_type_JavaLangString, true, true, null, localHashMap);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\phg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */