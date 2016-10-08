import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import java.util.Iterator;
import java.util.List;

public final class ksg
  implements Runnable
{
  public ksg(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, NewestFeedInfo paramNewestFeedInfo, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { 63521 });
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          }
        }
      }
      localObject = MessageRecordFactory.a(63521);
      long l = this.jdField_a_of_type_NS_MOBILE_AIONewestFeedNewestFeedInfo.uTime;
      ((MessageRecord)localObject).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(this.jdField_a_of_type_NS_MOBILE_AIONewestFeedNewestFeedInfo.uHostUin), String.valueOf(this.jdField_a_of_type_NS_MOBILE_AIONewestFeedNewestFeedInfo.uHostUin), this.jdField_a_of_type_JavaLangString, l, 63521, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
      ((MessageRecord)localObject).isread = true;
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ksg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */