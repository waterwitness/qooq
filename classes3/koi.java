import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class koi
  implements Runnable
{
  koi(kog paramkog, RichStatus.SigZanInfo paramSigZanInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_Kog.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Kog.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Kog.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, RichStatItemBuilder.a);
    Object localObject;
    Message localMessage;
    if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForRichState)))
    {
      localObject = new HashMap();
      ((Map)localObject).put("chatMessage", localMessageRecord);
      ((Map)localObject).put("sigZanInfo", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus$SigZanInfo);
      this.jdField_a_of_type_Kog.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(267387138);
      localMessage = this.jdField_a_of_type_Kog.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(267387138);
      localMessage.obj = localObject;
    }
    try
    {
      localObject = new JSONObject(localMessageRecord.msg);
      ((JSONObject)localObject).put("count", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus$SigZanInfo.b);
      ((JSONObject)localObject).put("zanfalg", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus$SigZanInfo.c);
      this.jdField_a_of_type_Kog.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Kog.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Kog.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageRecord.uniseq, ((JSONObject)localObject).toString());
      this.jdField_a_of_type_Kog.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\koi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */