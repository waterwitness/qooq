import com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class pmw
  extends Thread
{
  private static final int jdField_a_of_type_Int = 5;
  Object jdField_a_of_type_JavaLangObject;
  public String a;
  boolean jdField_a_of_type_Boolean;
  public String b;
  boolean b;
  
  public pmw(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  void a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {}
      }
      try
      {
        VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->wait 5 seconds");
        this.jdField_a_of_type_JavaLangObject.wait(5000L);
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->download task " + this.jdField_b_of_type_JavaLangString + " timeout");
        this.jdField_b_of_type_Boolean = true;
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("status", -2);
        localJSONObject1.put("code", 0);
        localJSONObject1.put("data", localJSONObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->wait() is interrupted");
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->json exception:" + localJSONException.toString());
        }
      }
    }
  }
  
  void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */