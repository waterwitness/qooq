import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.OpenSdkFriendService;
import com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback;
import java.util.ArrayList;

public class wrk
  implements Runnable
{
  public wrk(OpenSdkFriendService.GetFriendListCallback paramGetFriendListCallback, ArrayList paramArrayList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ("action_invite".equals(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendListCallback.a.i))
    {
      this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendListCallback.a.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$GetFriendListCallback.a.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */