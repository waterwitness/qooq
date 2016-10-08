package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import oyu;

public class RecentItemChatMsgData
  extends RecentUserBaseData
{
  private static MessageForRichState a;
  private boolean c;
  private boolean d;
  
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Boolean = android.text.TextUtils.equals(paramRecentUser.uin, AppConstants.aZ);
    if (this.jdField_d_of_type_Boolean) {
      this.G = 2;
    }
  }
  
  private boolean a(FriendsManager paramFriendsManager, String paramString)
  {
    if ((paramFriendsManager == null) || (android.text.TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramFriendsManager = paramFriendsManager.a(paramString);
      } while ((paramFriendsManager == null) || (!paramFriendsManager.isFriend()));
      bool1 = paramFriendsManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramFriendsManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.jdField_c_of_type_Boolean = false;
    Object localObject5 = paramQQAppInterface.a();
    if (localObject5 != null) {}
    for (Object localObject2 = ((QQMessageFacade)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localObject2 = null)
    {
      Object localObject1 = paramQQAppInterface.a();
      MsgSummary localMsgSummary;
      if ((localObject1 != null) && (localObject2 != null))
      {
        this.H = ((ConversationFacade)localObject1).a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
        if (("2909288299".equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (this.H > 0))
        {
          localObject1 = ((QQMessageFacade.Message)localObject2).getExtInfoFromExtStr("news_has_report");
          if ((android.text.TextUtils.isEmpty((CharSequence)localObject1)) || (!"1".equals(localObject1)))
          {
            ((QQMessageFacade.Message)localObject2).saveExtInfoToExtStr("news_has_report", "1");
            ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007054", "0X8007054", 0, 0, "", "", "", "");
          }
        }
        localMsgSummary = a();
        localObject1 = null;
      }
      label407:
      label703:
      label786:
      label885:
      label923:
      label929:
      label1053:
      label1059:
      label1279:
      label1394:
      label1637:
      label1848:
      label1856:
      Object localObject4;
      switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
      {
      default: 
      case 9501: 
      case 1008: 
        for (;;)
        {
          a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          if ((localMsgSummary.a) && (this.jdField_c_of_type_Boolean))
          {
            localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
            this.jdField_c_of_type_JavaLangCharSequence = "";
          }
          a(paramQQAppInterface, paramContext, localMsgSummary);
          if (AppSetting.j)
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
            if (this.H != 0) {
              break label3762;
            }
            if (this.jdField_c_of_type_JavaLangCharSequence != null) {
              paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
            }
            paramQQAppInterface.append(com.tencent.mobileqq.text.TextUtils.c(this.jdField_b_of_type_JavaLangCharSequence.toString())).append(",").append(this.jdField_c_of_type_JavaLangString);
            this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
          }
          d();
          return;
          this.H = 0;
          break;
          if (localObject2 != null)
          {
            localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((QQMessageFacade.Message)localObject2).msg;
            this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
            this.I = 0;
            localObject1 = ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(Long.parseLong(((QQMessageFacade.Message)localObject2).frienduin));
            if (localObject1 != null) {
              this.jdField_b_of_type_JavaLangString = SmartDeviceUtil.a((DeviceInfo)localObject1);
            }
            if ((localMsgSummary.jdField_b_of_type_JavaLangCharSequence == null) || (localMsgSummary.jdField_b_of_type_JavaLangCharSequence.length() == 0)) {
              localMsgSummary.jdField_b_of_type_JavaLangCharSequence = this.jdField_b_of_type_JavaLangString;
            }
            this.K = 1;
            if (((QQMessageFacade.Message)localObject2).msgtype == 61036)
            {
              localObject1 = new MessageForDeviceFile();
              ((MessageForDeviceFile)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
              ((MessageForDeviceFile)localObject1).parse();
              if (((MessageForDeviceFile)localObject1).msgStatus == 1) {
                localMsgSummary.f = 2;
              } else if (((MessageForDeviceFile)localObject1).msgStatus == 2) {
                localMsgSummary.f = 1;
              }
            }
            else if (((QQMessageFacade.Message)localObject2).msgtype == 61035)
            {
              localObject1 = new MessageForDevPtt();
              ((MessageForDevPtt)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
              ((MessageForDevPtt)localObject1).parse();
              if (((MessageForDevPtt)localObject1).fileSize == -1L)
              {
                localMsgSummary.f = 2;
                if (!"device_groupchat".equals(((QQMessageFacade.Message)localObject2).extStr)) {
                  continue;
                }
                if (!((QQMessageFacade.Message)localObject2).isSend()) {
                  break label786;
                }
              }
              for (((QQMessageFacade.Message)localObject2).nickName = paramQQAppInterface.a().getString(2131367355);; ((QQMessageFacade.Message)localObject2).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin, true))
              {
                MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, ((QQMessageFacade.Message)localObject2).nickName, true, false);
                break;
                if (((MessageForDevPtt)localObject1).fileSize != -3L) {
                  break label703;
                }
                localMsgSummary.f = 1;
                break label703;
              }
            }
            else
            {
              int i;
              if (((QQMessageFacade.Message)localObject2).msgtype == 61033)
              {
                localObject1 = new MessageForDevShortVideo();
                ((MessageForDevShortVideo)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
                ((MessageForDevShortVideo)localObject1).parse();
                if (((MessageForDevShortVideo)localObject1).videoFileStatus == 1005)
                {
                  localMsgSummary.f = 2;
                }
                else if (((MessageForDevShortVideo)localObject1).videoFileStatus == 1002)
                {
                  localObject1 = ((DeviceMsgHandle)paramQQAppInterface.a(49)).a();
                  if (localObject1 != null)
                  {
                    i = 1;
                    if (((DeviceAVFileMsgObserver)localObject1).a(((QQMessageFacade.Message)localObject2).uniseq)) {
                      break label923;
                    }
                  }
                  for (int j = 1;; j = 0)
                  {
                    if ((i & j) == 0) {
                      break label929;
                    }
                    localMsgSummary.f = 2;
                    break;
                    i = 0;
                    break label885;
                  }
                  localMsgSummary.f = 1;
                }
              }
              else
              {
                Object localObject3;
                if (((QQMessageFacade.Message)localObject2).msgtype == 61027)
                {
                  localObject1 = new MessageForDevLittleVideo();
                  ((MessageForDevLittleVideo)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
                  ((MessageForDevLittleVideo)localObject1).parse();
                  if (((MessageForDevLittleVideo)localObject1).videoFileStatus == 1005)
                  {
                    localMsgSummary.f = 2;
                  }
                  else if (((MessageForDevLittleVideo)localObject1).videoFileStatus == 1002)
                  {
                    localObject3 = ((DeviceMsgHandle)paramQQAppInterface.a(49)).a();
                    if (!DeviceMsgChatPie.b((MessageRecord)localObject1)) {
                      if (localObject3 == null) {
                        break label1053;
                      }
                    }
                    for (i = 1;; i = 0)
                    {
                      if ((i & ((DeviceAVFileMsgObserver)localObject3).a(((QQMessageFacade.Message)localObject2).uniseq)) == 0) {
                        break label1059;
                      }
                      localMsgSummary.f = 1;
                      break;
                    }
                    localMsgSummary.f = 2;
                  }
                }
                else if (((QQMessageFacade.Message)localObject2).msgtype == 61028)
                {
                  if ("device_groupchat".equals(((QQMessageFacade.Message)localObject2).extStr))
                  {
                    if (((QQMessageFacade.Message)localObject2).isSend()) {}
                    for (((QQMessageFacade.Message)localObject2).nickName = paramQQAppInterface.a().getString(2131367355);; ((QQMessageFacade.Message)localObject2).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin, true))
                    {
                      MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, ((QQMessageFacade.Message)localObject2).nickName, true, false);
                      break;
                    }
                  }
                  MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, null, true, false);
                  continue;
                  if (localObject2 != null)
                  {
                    i = ((QQMessageFacade.Message)localObject2).msgtype;
                    if ((i == 62530) || (i == 60532)) {
                      break label1856;
                    }
                    a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
                    if ((i == 63511) && (this.H > 0) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
                    {
                      this.J = -881592;
                      this.jdField_c_of_type_JavaLangCharSequence = ((QQMessageFacade.Message)localObject2).msg;
                      localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
                    }
                  }
                  else
                  {
                    localObject1 = null;
                    localObject3 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
                    if (localObject3 != null) {
                      localObject1 = ((PublicAccountDataManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
                    }
                    if ((localObject1 == null) && (localObject3 != null))
                    {
                      localObject3 = ((PublicAccountDataManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
                      if (localObject3 != null) {
                        this.jdField_b_of_type_JavaLangString = ((AccountDetail)localObject3).name;
                      }
                      if (this.jdField_d_of_type_Boolean) {
                        this.jdField_b_of_type_JavaLangString = PublicAccountConfigUtil.b(paramQQAppInterface, paramQQAppInterface.a());
                      }
                    }
                    if (localObject1 == null) {
                      break label2034;
                    }
                    this.jdField_b_of_type_JavaLangString = ((PublicAccountInfo)localObject1).name;
                    if (((PublicAccountInfo)localObject1).certifiedGrade <= 0L) {
                      break label2026;
                    }
                    this.I = 2130838906;
                    if ((localObject2 == null) || (((QQMessageFacade.Message)localObject2).getMessageText() == null)) {
                      break label2042;
                    }
                  }
                  for (this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject2).time; (!this.jdField_d_of_type_Boolean) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)); this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime)
                  {
                    i = paramQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
                    if (this.H <= 0) {
                      break;
                    }
                    if ((this.H != 1) || (i <= 0)) {
                      break label2056;
                    }
                    this.G = 2;
                    break;
                    this.jdField_c_of_type_JavaLangCharSequence = "";
                    this.J = 0;
                    if (!this.jdField_d_of_type_Boolean) {
                      break label1279;
                    }
                    localObject1 = ((QQMessageFacade)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
                    if ((localObject1 == null) || (!(localObject1 instanceof MessageForStructing))) {
                      break label1279;
                    }
                    localObject1 = (MessageForStructing)localObject1;
                    if (((MessageForStructing)localObject1).structingMsg == null) {
                      ((MessageForStructing)localObject1).parse();
                    }
                    if ((this.H > 0) && (((MessageForStructing)localObject1).structingMsg != null) && (!android.text.TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mOrangeWord)))
                    {
                      if (((MessageForStructing)localObject1).structingMsg.mOrangeWord.length() >= 8)
                      {
                        this.jdField_c_of_type_JavaLangCharSequence = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord.substring(0, 8) + "]");
                        this.J = paramContext.getResources().getColor(2131428324);
                      }
                    }
                    else
                    {
                      if ((((MessageForStructing)localObject1).extInt != 1) || (((MessageForStructing)localObject1).extLong != 1)) {
                        break label1279;
                      }
                      ((MessageForStructing)localObject1).extLong = 0;
                      ThreadManager.a(new oyu(this, paramQQAppInterface, (MessageForStructing)localObject1), 8, null, false);
                      if ((((MessageForStructing)localObject1).structingMsg == null) || (android.text.TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mMsgActionData))) {
                        break label1848;
                      }
                      localObject3 = PublicAccountUtil.a(((MessageForStructing)localObject1).structingMsg.mMsgActionData);
                      if (localObject3 == null) {
                        break label1848;
                      }
                    }
                    for (;;)
                    {
                      try
                      {
                        l = Long.parseLong(((JSONObject)localObject3).getString("id"));
                        if (l != -1L) {
                          ReportController.b(null, "CliOper", "", "", "0X80066F3", "0X80066F3", 0, 0, String.valueOf(this.O + 1), "", String.valueOf(l), "");
                        }
                        if (((MessageForStructing)localObject1).structingMsg == null) {
                          break;
                        }
                        PublicAccountUtil.a(paramQQAppInterface, (MessageForStructing)localObject1, 7);
                      }
                      catch (Exception localException)
                      {
                        localException.printStackTrace();
                      }
                      this.jdField_c_of_type_JavaLangCharSequence = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord + "]");
                      break label1637;
                      long l = -1L;
                    }
                    localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
                    localObject4 = XMLMessageUtils.a((MessageRecord)localObject2);
                    if ((localObject4 == null) || (((PAMessage)localObject4).items == null) || (((PAMessage)localObject4).items.size() == 0))
                    {
                      a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
                      break label1279;
                    }
                    localObject1 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
                    if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList != null)) {
                      localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
                    }
                    for (;;)
                    {
                      localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
                      break;
                    }
                    this.I = 0;
                    break label1394;
                    this.I = 0;
                    break label1394;
                  }
                  if (i > 0)
                  {
                    this.H -= 1;
                    this.G = 1;
                  }
                }
              }
            }
          }
        }
      case 1006: 
        label2026:
        label2034:
        label2042:
        label2056:
        localObject4 = ContactUtils.f(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
        if (localObject1 == null) {
          break;
        }
      }
      for (localObject1 = ((PhoneContactManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
      {
        if (localObject1 != null) {
          this.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).name;
        }
        for (;;)
        {
          a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((localObject2 == null) || ((((QQMessageFacade.Message)localObject2).getMessageText() == null) && ((((QQMessageFacade.Message)localObject2).msgtype != 63525) || (((QQMessageFacade.Message)localObject2).msgData == null)) && ((((QQMessageFacade.Message)localObject2).msgtype != 60527) || (((QQMessageFacade.Message)localObject2).msgData == null)))) {
            break label2245;
          }
          this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
          break;
          if (localObject4 != null) {
            this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, (String)localObject4, true);
          } else {
            this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
          }
        }
        label2245:
        this.jdField_b_of_type_Long = 0L;
        break;
        localObject1 = (CircleManager)paramQQAppInterface.getManager(34);
        localObject4 = ((CircleManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if ((localObject1 != null) && (localObject4 != null)) {}
        for (this.jdField_b_of_type_JavaLangString = ((CircleManager)localObject1).a((CircleBuddy)localObject4);; this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true))
        {
          a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((localObject2 == null) || ((((QQMessageFacade.Message)localObject2).getMessageText() == null) && ((((QQMessageFacade.Message)localObject2).msgtype != 63525) || (((QQMessageFacade.Message)localObject2).msgData == null)) && ((((QQMessageFacade.Message)localObject2).msgtype != 60527) || (((QQMessageFacade.Message)localObject2).msgData == null)))) {
            break label2394;
          }
          this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
          break;
        }
        label2394:
        this.jdField_b_of_type_Long = 0L;
        break;
        boolean bool = QvipSpecialCareManager.a(paramQQAppInterface.a() + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if ((this.H > 0) && (bool))
        {
          this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131371035);
          this.J = paramContext.getResources().getColor(2131428324);
          label2471:
          if (0 == 0) {
            localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
          }
          if (!a((FriendsManager)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            break label3010;
          }
          this.G = 4;
          label2505:
          if ((localObject2 == null) || ((((QQMessageFacade.Message)localObject2).getMessageText() == null) && (((QQMessageFacade.Message)localObject2).msgData == null) && ((((QQMessageFacade.Message)localObject2).msgtype != 63525) || (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0)) && ((((QQMessageFacade.Message)localObject2).msgtype != 60527) || (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0)))) {
            break label3034;
          }
          this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
          if ((((QQMessageFacade.Message)localObject2).msgtype == 63525) && (paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.a(), 0).getLong("uid" + ((QQMessageFacade.Message)localObject2).frienduin, 0L) == ((QQMessageFacade.Message)localObject2).msgUid))
          {
            localObject1 = ((QQMessageFacade)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
            if ((localObject1 != null) && ((localObject1 instanceof MessageForStructing)))
            {
              localObject4 = (MessageForStructing)localObject1;
              if (((MessageForStructing)localObject4).structingMsg == null) {
                ((MessageForStructing)localObject4).parse();
              }
              if ((((MessageForStructing)localObject4).structingMsg != null) && (((MessageForStructing)localObject4).structingMsg.mMsgServiceID == 76))
              {
                localObject4 = ((MessageForStructing)localObject4).structingMsg.mMsgBrief;
                localObject5 = paramContext.getString(2131365312);
                if ((((MessageRecord)localObject1).isread) || (android.text.TextUtils.isEmpty((CharSequence)localObject4)) || (!((String)localObject4).startsWith((String)localObject5))) {
                  break label3018;
                }
                this.jdField_c_of_type_JavaLangCharSequence = ((CharSequence)localObject5);
                ((QQMessageFacade.Message)localObject2).msg = ((String)localObject4).substring(((String)localObject5).length());
                label2794:
                this.J = paramContext.getResources().getColor(2131428337);
              }
            }
          }
          label2808:
          a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msgtype == 64502))
          {
            if (jdField_a_of_type_ComTencentMobileqqDataMessageForRichState == null) {
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = new MessageForRichState();
            }
            jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.msg = ((QQMessageFacade.Message)localObject2).msg;
            jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.mIsParsed = false;
            jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.parse();
            if (paramQQAppInterface.a().e(((QQMessageFacade.Message)localObject2).frienduin) >= jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time) {
              break label3042;
            }
            this.jdField_c_of_type_JavaLangCharSequence = "[新签名]";
            this.J = paramContext.getResources().getColor(2131428324);
            label2924:
            this.jdField_c_of_type_Boolean = true;
          }
          if (!AppConstants.as.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
            break label3066;
          }
          this.jdField_b_of_type_JavaLangString = paramContext.getString(2131369138);
        }
        for (;;)
        {
          if ((localObject2 == null) || (((QQMessageFacade.Message)localObject2).msgtype != 63496)) {
            break label3283;
          }
          localObject1 = new MessageForApproval();
          ((MessageForApproval)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((MessageForApproval)localObject1).getFullTitle();
          break;
          this.jdField_c_of_type_JavaLangCharSequence = "";
          break label2471;
          label3010:
          this.G = 1;
          break label2505;
          label3018:
          this.jdField_c_of_type_JavaLangCharSequence = "";
          ((QQMessageFacade.Message)localObject2).msg = ((String)localObject4);
          break label2794;
          label3034:
          this.jdField_b_of_type_Long = 0L;
          break label2808;
          label3042:
          this.jdField_c_of_type_JavaLangCharSequence = "[签名]";
          this.J = paramContext.getResources().getColor(2131428302);
          break label2924;
          label3066:
          if (AppConstants.ao.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_b_of_type_JavaLangString = paramContext.getString(2131369180);
            if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msg != null)) {
              localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((QQMessageFacade.Message)localObject2).msg;
            }
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1000)
          {
            localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
            if (localObject1 != null)
            {
              localObject1 = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
              this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, true, null);
            }
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1004)
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
            if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {
              this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
            }
          }
          else
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
          }
        }
        label3283:
        if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msgtype == 63495))
        {
          localObject1 = paramContext.getString(2131372433);
          localObject2 = paramContext.getString(2131372434);
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((String)localObject1 + " " + (String)localObject2);
          break;
        }
        if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msgtype == 63511))
        {
          if (this.H <= 0) {
            break label3463;
          }
          this.J = -881592;
          if (!bool) {
            break label3451;
          }
          this.jdField_c_of_type_JavaLangCharSequence += ((QQMessageFacade.Message)localObject2).msg;
          label3413:
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
        }
        while (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1024)
        {
          this.I = CrmUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          break;
          label3451:
          this.jdField_c_of_type_JavaLangCharSequence = ((QQMessageFacade.Message)localObject2).msg;
          break label3413;
          label3463:
          this.jdField_c_of_type_JavaLangCharSequence = "";
        }
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131364617);
        localObject4 = "";
        localObject1 = null;
        if (localObject5 != null) {
          localObject1 = ((QQMessageFacade)localObject5).b(AppConstants.an, 4000);
        }
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
          if (((MessageRecord)localObject1).msg != null) {
            if (((MessageRecord)localObject1).msgtype == 64503)
            {
              localObject1 = ((MessageRecord)localObject1).msg;
              localObject1 = "好友推荐，" + (String)localObject1;
            }
          }
        }
        for (;;)
        {
          localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
          if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).getMessageText() != null))
          {
            this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
            break;
            if (((MessageRecord)localObject1).msgtype == 64506)
            {
              if ((PhoneContactManager)paramQQAppInterface.getManager(10) != null) {}
              localObject1 = "好友推荐，" + "";
              continue;
            }
            if (((MessageRecord)localObject1).msgtype == 64497)
            {
              localObject1 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
              if (localObject1 == null) {
                break label3837;
              }
              localObject1 = paramContext.getResources().getString(2131364620) + ((RecommendTroopManagerImp)localObject1).a();
              continue;
            }
            if (((MessageRecord)localObject1).msgtype != 64496) {
              break label3831;
            }
            localObject5 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
            localObject1 = localObject4;
            if (localObject5 != null) {
              localObject1 = ((RecommendTroopManagerImp)localObject5).a();
            }
            continue;
          }
          this.jdField_b_of_type_Long = 0L;
          break;
          label3762:
          if (this.H == 1)
          {
            paramQQAppInterface.append("有一条未读");
            break label407;
          }
          if (this.H == 2)
          {
            paramQQAppInterface.append("有两条未读");
            break label407;
          }
          if (this.H <= 0) {
            break label407;
          }
          paramQQAppInterface.append("有").append(this.H).append("条未读,");
          break label407;
          label3831:
          localObject1 = "";
          continue;
          label3837:
          localObject1 = "";
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemChatMsgData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */