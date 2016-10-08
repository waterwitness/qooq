import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUploadingManager;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class vqm
  extends BizTroopObserver
{
  public vqm(TroopFileUploadingManager paramTroopFileUploadingManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    if ((((TroopFileStatusInfo)paramObject).jdField_a_of_type_Boolean) && (((TroopFileStatusInfo)paramObject).b == 1)) {}
    for (;;)
    {
      return;
      if (((TroopFileStatusInfo)paramObject).b == 12)
      {
        long l = ((TroopFileStatusInfo)paramObject).jdField_a_of_type_Long;
        Iterator localIterator = this.a.a.a().a(String.valueOf(l), 1).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ChatMessage)localIterator.next();
          if ((((ChatMessage)localObject).msgtype == 63519) && ((((ChatMessage)localObject).extraflag == 32772) || (((ChatMessage)localObject).extraflag == 32768)) && (((ChatMessage)localObject).isSendFromLocal()))
          {
            localObject = (MessageForTroopFile)localObject;
            if ((((MessageForTroopFile)localObject).uuid != null) && (((MessageForTroopFile)localObject).uuid.equals(((TroopFileStatusInfo)paramObject).jdField_a_of_type_JavaUtilUUID.toString()))) {
              this.a.a.a().b(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
            } else if ((!TextUtils.isEmpty(((MessageForTroopFile)localObject).url)) && (!TextUtils.isEmpty(((TroopFileStatusInfo)paramObject).e)) && (((MessageForTroopFile)localObject).url.equals(((TroopFileStatusInfo)paramObject).e))) {
              this.a.a.a().b(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */