import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hik
  implements TroopMemberApiClient.Callback
{
  public hik(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("state");
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { i + "" });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */