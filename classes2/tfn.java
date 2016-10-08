import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.MultiMsgPicsUploadAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PicRec;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

public class tfn
  extends UiCallBack.MultiMsgPicsUploadAdapter
{
  public tfn(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt, HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private boolean a(MessageForPic paramMessageForPic, PicResult paramPicResult)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    String str = "";
    if (paramPicResult.a != null) {
      if ((paramPicResult.a instanceof im_msg_body.NotOnlineImage))
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramPicResult.a);
        if (paramPicResult.b)
        {
          if (!localElem.not_online_image.res_id.has()) {
            break label271;
          }
          str = localElem.not_online_image.res_id.get().toStringUtf8();
        }
      }
    }
    for (;;)
    {
      paramMessageForPic.uuid = str;
      paramMessageForPic.path = str;
      paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
      paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
      paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
      paramMessageForPic.md5 = FileUtils.b(MultiMsgManager.c);
      paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, " pic resp uuid = " + str + " picMsgMD5 = " + paramMessageForPic.md5 + " hasCode = " + paramMessageForPic.hashCode());
      }
      int i = 1;
      label223:
      boolean bool;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "updateMessageForPic success");
        }
        localRichText.elems.add(localElem);
        if (paramPicResult.d == 0) {
          bool = true;
        }
      }
      for (;;)
      {
        paramMessageForPic.richText = localRichText;
        return bool;
        label271:
        if (!localElem.not_online_image.download_path.has()) {
          break label484;
        }
        str = localElem.not_online_image.download_path.get().toStringUtf8();
        break;
        if ((paramPicResult.a instanceof im_msg_body.CustomFace))
        {
          localElem.custom_face.set((im_msg_body.CustomFace)paramPicResult.a);
          if (paramPicResult.b)
          {
            if (localElem.custom_face.str_file_path.has()) {
              str = localElem.custom_face.str_file_path.get();
            }
            paramMessageForPic.path = str;
            paramMessageForPic.uuid = str;
            paramMessageForPic.md5 = FileUtils.b(MultiMsgManager.c);
            paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
          }
          i = 1;
          break label223;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "WTF, picResult.mExtraObj is " + paramPicResult.a.getClass().getSimpleName());
        }
        i = 0;
        break label223;
        if (QLog.isColorLevel())
        {
          QLog.e("MultiMsg", 2, "[requestUploadPics] Bad picture element");
          bool = false;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("MultiMsg", 2, "updateMessageForPic failed, add empty element");
          }
        }
        bool = false;
      }
      label484:
      str = "";
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    int j = 0;
    int i = 0;
    boolean bool1 = true;
    int m = 0;
    Object localObject1;
    if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(m);
      if ((i >= paramArrayList.size()) || (!((PicResult)paramArrayList.get(i)).b)) {
        break label929;
      }
      j = 1;
    }
    label203:
    label378:
    label453:
    label920:
    label923:
    label926:
    label929:
    for (;;)
    {
      if ((localObject1 instanceof MessageForPic))
      {
        if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
          QLog.e("MultiMsg", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
        }
        localObject1 = (MessageForPic)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + m + "], resultIndex[" + i + "]");
        }
        if (!a((MessageForPic)localObject1, (PicResult)paramArrayList.get(i))) {
          bool1 = false;
        }
        i += 1;
        m += 1;
        break;
      }
      int n;
      int k;
      boolean bool2;
      Object localObject2;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localObject1;
        if (((MessageForMixedMsg)localObject1).msgElemList != null)
        {
          n = 0;
          k = i;
          bool2 = bool1;
          if (n >= ((MessageForMixedMsg)localObject1).msgElemList.size()) {
            break label378;
          }
          localObject2 = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(n);
          if (!(localObject2 instanceof MessageForPic)) {
            break label926;
          }
          if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
            QLog.e("MultiMsg", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
          }
          localObject2 = (MessageForPic)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + m + "], subMsgIndex[" + n + ", resultIndex[" + i + "]");
          }
          if (!a((MessageForPic)localObject2, (PicResult)paramArrayList.get(i))) {
            bool1 = false;
          }
          i += 1;
        }
      }
      for (;;)
      {
        n += 1;
        break label203;
        bool2 = bool1;
        k = i;
        i = k;
        bool1 = bool2;
        break;
        if (((MessageRecord)localObject1).msgtype == 64500) {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
        }
        for (;;)
        {
          Object localObject3;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if (!(localObject2 instanceof MessageForMixedMsg)) {
              continue;
            }
            localObject2 = (MessageForMixedMsg)localObject2;
            if (((MessageForMixedMsg)localObject2).msgElemList == null) {
              continue;
            }
            k = 0;
            if (k >= ((MessageForMixedMsg)localObject2).msgElemList.size()) {
              break label923;
            }
            localObject3 = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(k);
            if (!(localObject3 instanceof MessageForPic)) {
              break label920;
            }
            if ((i >= paramArrayList.size()) && (QLog.isColorLevel())) {
              QLog.e("MultiMsg", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
            }
            localObject3 = (MessageForPic)localObject3;
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + m + "], subMsgIndex[" + k + ", resultIndex[" + i + "]");
            }
            if (!a((MessageForPic)localObject3, (PicResult)paramArrayList.get(i))) {
              bool1 = false;
            }
            i += 1;
          }
          for (;;)
          {
            k += 1;
            break label453;
            break;
            if ((localObject1 instanceof MessageForStructing))
            {
              localObject2 = ((MessageForStructing)localObject1).structingMsg;
              if ((localObject2 != null) && ((localObject2 instanceof StructMsgForImageShare)))
              {
                localObject3 = ((StructMsgForImageShare)localObject2).getFirstImageElement();
                if ((localObject3 != null) && (((StructMsgItemImage)localObject3).a != null))
                {
                  MessageForPic localMessageForPic = ((StructMsgItemImage)localObject3).a;
                  if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + m + "], resultIndex[" + i + "]");
                  }
                  if (!a(localMessageForPic, (PicResult)paramArrayList.get(i))) {
                    bool1 = false;
                  }
                  for (;;)
                  {
                    i += 1;
                    break;
                    ((StructMsgItemImage)localObject3).p = localMessageForPic.uuid;
                    ((StructMsgItemImage)localObject3).q = localMessageForPic.md5;
                    ((StructMsgItemImage)localObject3).o = localMessageForPic.path;
                    ((MessageRecord)localObject1).msgData = ((AbsStructMsg)localObject2).getBytes();
                  }
                  if (j != 0)
                  {
                    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isReMultiMsg) {
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800662B", "0X800662B", 0, 1, 0, "", "", "", "");
                    }
                    if (QLog.isColorLevel()) {
                      QLog.e("MultiMsg", 2, "requestUploadPics isPicMsgModify");
                    }
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_JavaUtilArrayList, null);
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isReMultiMsg) {
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800662A", "0X800662A", 0, 1, 0, "", "", "", "");
                  }
                  return bool1;
                }
              }
            }
            break;
          }
        }
      }
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "onForwardMultiMsgPicsUpload success[" + paramArrayList.size() + "]");
      }
      bool2 = a(paramArrayList);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiMsg", 2, "updateMsgRecords done, goto onPackAndSendMsg");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_JavaUtilArrayList, bool1);
      return;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("MultiMsg", 2, "onForwardMultiMsgPicsUpload failed");
        bool1 = bool2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */