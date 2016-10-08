import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class tfm
  implements Runnable
{
  public tfm(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager.a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (ArrayList)localObject1, null);
    if (localArrayList1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag = 32768;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      localObject1 = this.jdField_a_of_type_JavaLangString;
      i = this.jdField_a_of_type_Int;
      long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a(MessageHandler.c(this.jdField_a_of_type_Int), false, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (MessageRecord)localIterator.next();
      if ((localObject3 instanceof MessageForPic))
      {
        localObject3 = PicBusiManager.a(7, (MessageForPic)localObject3, this.jdField_a_of_type_Int, (String)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (localObject3 != null) {
          localArrayList2.add(localObject3);
        } else if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
        }
      }
      else if ((localObject3 instanceof MessageForMixedMsg))
      {
        localObject3 = PicBusiManager.a(7, (MessageForMixedMsg)localObject3, this.jdField_a_of_type_Int, (String)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (localObject3 != null) {
          localArrayList2.addAll((Collection)localObject3);
        } else if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
        }
      }
      else
      {
        Object localObject4;
        if (((MessageRecord)localObject3).msgtype == 64500)
        {
          localObject3 = ((MessageForLongMsg)localObject3).longMsgFragmentList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject3).next();
            if ((localObject4 instanceof MessageForMixedMsg))
            {
              localObject4 = PicBusiManager.a(7, (MessageForMixedMsg)localObject4, this.jdField_a_of_type_Int, (String)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              if (localObject4 != null) {
                localArrayList2.addAll((Collection)localObject4);
              }
            }
          }
        }
        else if ((localObject3 instanceof MessageForStructing))
        {
          localObject3 = ((MessageForStructing)localObject3).structingMsg;
          if ((localObject3 != null) && ((localObject3 instanceof StructMsgForImageShare)))
          {
            localObject4 = ((StructMsgForImageShare)localObject3).getFirstImageElement();
            if (localObject4 != null)
            {
              if (((StructMsgItemImage)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null)
              {
                if (((StructMsgItemImage)localObject4).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                  ((StructMsgItemImage)localObject4).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localObject3);
                }
                ((StructMsgItemImage)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((StructMsgItemImage)localObject4).a();
              }
              localObject3 = PicBusiManager.a(7, ((StructMsgItemImage)localObject4).jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_Int, (String)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              if (localObject3 != null) {
                localArrayList2.add(localObject3);
              } else if (QLog.isColorLevel()) {
                QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
              }
            }
          }
        }
      }
    }
    localObject2 = (ChatMessage)((ArrayList)localObject1).get(0);
    if (localObject2 != null) {}
    for (int i = ((ChatMessage)localObject2).istroop;; i = 0)
    {
      if (i == 0) {
        i = 1;
      }
      for (;;)
      {
        int j;
        if (this.jdField_a_of_type_Int == 0) {
          j = 1;
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004660", "0X8004660", 0, 0, i + "", j + "", "" + ((ArrayList)localObject1).size(), "" + localArrayList2.size());
          if (localArrayList2.size() > 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList2.size() + "], goto requestUploadPics");
            }
            MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localArrayList1, localArrayList2);
            return;
            if (i == 3000)
            {
              i = 2;
              break;
            }
            if (i != 1) {
              break label943;
            }
            i = 3;
            break;
            if (this.jdField_a_of_type_Int == 3000)
            {
              j = 2;
              continue;
            }
            if (this.jdField_a_of_type_Int != 1) {
              break label937;
            }
            j = 3;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "[requestSendMultiMsg]There's not any picture messages, goto onPackAndSendMsg");
          }
          MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localArrayList1, true);
          return;
          label937:
          j = 4;
        }
        label943:
        i = 4;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */