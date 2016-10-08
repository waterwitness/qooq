import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.OpenSdkFriendService;
import com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class wrj
  implements Runnable
{
  public wrj(OpenSdkFriendService.CheckAvatarUpdateCallback paramCheckAvatarUpdateCallback, int paramInt, JSONArray paramJSONArray)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int) {
        try
        {
          String str = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i).getString("openid");
          str = QZonePortraitData.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$CheckAvatarUpdateCallback.a.f, str);
          ImageLoader.a().a(str);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */