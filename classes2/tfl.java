import android.content.Intent;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class tfl
  implements Runnable
{
  public tfl(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int j = 0;
    int i = 0;
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ChatMessage)((Iterator)localObject1).next();
      if (((ChatMessage)localObject2).msgtype == 63536)
      {
        localObject2 = (MessageForPic)localObject2;
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("FORWARD_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        ((Intent)localObject3).putExtra("SENDER_TROOP_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        ((Intent)localObject3).putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject3).putExtra("FORWARD_SELF_UIN", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        ((Intent)localObject3).putExtra("forward_image_width", ((MessageForPic)localObject2).width);
        ((Intent)localObject3).putExtra("forward_image_height", ((MessageForPic)localObject2).height);
        ((Intent)localObject3).putExtra("forward_file_size", ((MessageForPic)localObject2).size);
        ((Intent)localObject3).putExtra("forward_image_type", ((MessageForPic)localObject2).imageType);
        ((Intent)localObject3).putExtra("forward_filepath", ((MessageForPic)localObject2).path);
        String str = ((MessageForPic)localObject2).frienduin + ((MessageForPic)localObject2).uniseq + ((MessageForPic)localObject2).istroop;
        ((Intent)localObject3).putExtra("BUSI_TYPE", 1009);
        ((Intent)localObject3).putExtra("forward_download_image_task_key", str);
        ((Intent)localObject3).putExtra("forward_download_image_org_uin", ((MessageForPic)localObject2).frienduin);
        ((Intent)localObject3).putExtra("forward_download_image_org_uin_type", ((MessageForPic)localObject2).istroop);
        ((Intent)localObject3).putExtra("forward_download_image_server_path", ((MessageForPic)localObject2).uuid);
        ((Intent)localObject3).putExtra("forward_download_image_item_id", ((MessageForPic)localObject2).uniseq);
        ((Intent)localObject3).putExtra("forward_photo_isSend", ((MessageForPic)localObject2).issend);
        ((Intent)localObject3).putExtra("forward_photo_md5", ((MessageForPic)localObject2).md5);
        ((Intent)localObject3).putExtra("forward_photo_group_fileid", ((MessageForPic)localObject2).groupFileID);
        ((Intent)localObject3).putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", ((MessageForPic)localObject2).fileSizeFlag);
        localObject2 = PicBusiManager.a(1009, (Intent)localObject3);
        localObject3 = PicBusiManager.a(3, 1009);
        ((PicReq)localObject3).a((PicFowardInfo)localObject2);
        PicBusiManager.a((PicReq)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        i += 1;
        label348:
        if (j >= MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager)) {
          break label830;
        }
      }
    }
    label818:
    label830:
    for (;;)
    {
      try
      {
        Thread.sleep(MultiMsgManager.b(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager));
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "sendMultuMsgFromLocal delay  i = " + j + " mDelayTime = " + MultiMsgManager.b(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager));
        }
        j += 1;
        break;
        if (((ChatMessage)localObject2).msgtype == 63525)
        {
          ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForStructing)localObject2).structingMsg, null);
          break label348;
        }
        if (((ChatMessage)localObject2).msgtype == 60527)
        {
          ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForBitApp)localObject2).bitAppMsg, null);
          break label348;
        }
        localObject2 = ((ChatMessage)localObject2).msg;
        localObject3 = new ChatActivityFacade.SendMsgParams();
        ((ChatActivityFacade.SendMsgParams)localObject3).f = true;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2, null, (ChatActivityFacade.SendMsgParams)localObject3);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "sendMultuMsgFromLocal sendMsg cost = " + (System.currentTimeMillis() - l));
      }
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      localObject1 = (ChatMessage)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (localObject1 != null) {}
      for (j = ((ChatMessage)localObject1).istroop;; j = 0)
      {
        if (j == 0) {
          j = 1;
        }
        for (;;)
        {
          if (k == 0) {
            k = 1;
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004876", "0X8004876", 0, 0, j + "", k + "", "" + this.jdField_a_of_type_JavaUtilArrayList.size(), "" + i + "");
            return;
            if (j == 3000)
            {
              j = 2;
              break;
            }
            if (j != 1) {
              break label818;
            }
            j = 3;
            break;
            if (k == 3000) {
              k = 2;
            } else if (k == 1) {
              k = 3;
            } else {
              k = 4;
            }
          }
          j = 4;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */