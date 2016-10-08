import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class syy
  extends Handler
{
  syy(syx paramsyx, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16711687: 
      this.a.b(0);
      return;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      syx.a(this.a).c();
      AudioUtil.b(2131165201, false);
      AudioUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false);
      return;
    case 1: 
      this.a.b(1);
      return;
    case 16711689: 
      localObject = (JSONObject)paramMessage.obj;
      paramMessage = ((JSONObject)localObject).optString("msg", "");
      localObject = ((JSONObject)localObject).optString("path", "");
      this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':0,'recordID':'" + (String)localObject + "','result':" + paramMessage + "}" });
      return;
    }
    Object localObject = (JSONObject)paramMessage.obj;
    paramMessage = ((JSONObject)localObject).optString("msg", "");
    localObject = ((JSONObject)localObject).optString("path", "");
    this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':1,'recordID':'" + (String)localObject + "','msg':'" + paramMessage + "'}" });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */