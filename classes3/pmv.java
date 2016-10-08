import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class pmv
  implements MediaPlayer.OnCompletionListener
{
  public pmv(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    int i = VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin).a(this.jdField_a_of_type_JavaLangString);
    VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->media:" + this.jdField_a_of_type_JavaLangString + " play completed, soundId:" + i);
    try
    {
      paramMediaPlayer = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", i);
      paramMediaPlayer.put("code", 0);
      paramMediaPlayer.put("data", localJSONObject);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin.callJs(this.b, new String[] { paramMediaPlayer.toString() });
      return;
    }
    catch (JSONException paramMediaPlayer)
    {
      VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->json exception:" + paramMediaPlayer.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */