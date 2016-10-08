import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class wey
  implements Runnable
{
  public wey(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    label346:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray1 = new JSONArray();
        JSONArray localJSONArray2 = new JSONObject(this.jdField_a_of_type_JavaLangString).getJSONArray("imgList");
        String str;
        Object localObject3;
        synchronized (HealthBusinessPlugin.jdField_a_of_type_JavaUtilHashMap)
        {
          if (i < localJSONArray2.length())
          {
            str = localJSONArray2.getString(i);
            if (TextUtils.isEmpty(str)) {
              break label346;
            }
            if ((str.startsWith("http")) || (str.equals("error")))
            {
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("imageID", "null");
              ((JSONObject)localObject3).put("data", str);
              localJSONArray1.put(localObject3);
            }
          }
        }
        JSONObject localJSONObject2;
        i += 1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HealthBusinessPlugin", 2, localException, new Object[0]);
        }
        return;
        if (HealthBusinessPlugin.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
        {
          localJSONArray1.put(HealthBusinessPlugin.jdField_a_of_type_JavaUtilHashMap.get(str));
        }
        else
        {
          localObject3 = MediaApiPlugin.a(str, 0);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("imageID", str);
          localJSONObject2.put("data", localObject3);
          HealthBusinessPlugin.jdField_a_of_type_JavaUtilHashMap.put(str, localJSONObject2);
          localJSONArray1.put(localJSONObject2);
          break label346;
          ((JSONObject)localObject2).put("imgList", localJSONArray1);
          HealthBusinessPlugin.a(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin, this.b, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
      }
      finally
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
          this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */