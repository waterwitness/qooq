import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class tfp
  implements Runnable
{
  public tfp(MultiMsgManager paramMultiMsgManager, QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    int j;
    int k;
    StringBuilder localStringBuilder;
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)localObject).structingMsg.mMsgAction)))
    {
      localObject = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
      if (localObject != null)
      {
        j = ((List)localObject).size();
        k = MultiMsgManager.a().a((Collection)localObject);
        localObject = new HashMap();
        localStringBuilder = new StringBuilder();
        if (!this.jdField_a_of_type_Boolean) {
          break label217;
        }
      }
    }
    label217:
    for (int i = 0;; i = 1)
    {
      ((HashMap)localObject).put("result", i + "");
      ((HashMap)localObject).put("msgCount", j + "");
      ((HashMap)localObject).put("picCount", k + "");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "multiMsgSend", this.jdField_a_of_type_Boolean, 30000L, 0L, (HashMap)localObject, "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */