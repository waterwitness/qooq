import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class oeu
  implements Runnable
{
  public oeu(QQOperateTips paramQQOperateTips)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = QQOperateTips.a(this.a).a().a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (QQOperateTips.a(this.a).jdField_a_of_type_Int != 0) {
          break label322;
        }
        QQOperateTips.a(this.a, ((ChatMessage)localObject2).time);
        QQOperateTips.b(this.a, ((ChatMessage)localObject2).uniseq);
      }
      if (QQOperateTips.a(this.a).a().a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int) <= 0) {
        break label353;
      }
      i = 1;
      label144:
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject2 = (ChatMessage)((List)localObject1).get(i - 1);
        if ((localObject2 == null) || (!((ChatMessage)localObject2).isread)) {}
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + QQOperateTips.a(this.a));
        }
        localObject2 = QQOperateManager.a(QQOperateTips.a(this.a));
        localObject1 = ((QQOperateManager)localObject2).a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int, QQOperateTips.a(this.a), (List)localObject1, true, QQOperateTips.a(this.a));
        if (((QQOperationRequestInfo)localObject1).jdField_a_of_type_Boolean)
        {
          localObject1 = ((QQOperationRequestInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
          ((QQOperateManager)localObject2).a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int, (ArrayList)localObject1, QQOperateTips.a(this.a));
        }
        QQOperateTips.a(this.a, -1);
        return;
        label322:
        if (QQOperateTips.a(this.a).jdField_a_of_type_Int != 3000) {
          break;
        }
        QQOperateTips.a(this.a, ((ChatMessage)localObject2).shmsgseq);
        break;
        label353:
        i = 0;
        break label144;
      }
      QQOperateTips.a(this.a, i - 1);
      i -= 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oeu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */