package com.tencent.mobileqq.activity;

import AccostSvc.EventItem;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import VIP.AIOSendReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.TextPaint;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.common.util.SubString;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.VIPAioSendHandler;
import com.tencent.mobileqq.app.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgHelper;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import krx;
import kry;
import ksb;
import ksd;
import kse;
import ksf;
import ksg;
import ksh;
import ksi;
import ksk;
import ksl;
import ksm;
import ksn;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityFacade
{
  public static final int a = 3478;
  public static long a = 0L;
  public static Toast a;
  public static ChatMessage a;
  public static ActionSheet a;
  private static final String jdField_a_of_type_JavaLangString;
  public static List a;
  private static ksn jdField_a_of_type_Ksn = new ksn();
  private static final short jdField_a_of_type_Short = 100;
  public static final boolean a = true;
  public static final int b = 0;
  public static ActionSheet b;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ChatActivityFacade.class.getSimpleName();
    jdField_a_of_type_Long = -1L;
  }
  
  public static int a(List paramList, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (a((RecentEmotionData)paramList.get(i), paramInt1, paramInt2, paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static long a(long paramLong, Time paramTime)
  {
    paramTime.set(paramLong);
    int i = paramTime.year;
    int j = paramTime.month;
    paramTime.set(0, 0, 0, paramTime.monthDay, j, i);
    return paramTime.toMillis(false);
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.richTime;
      }
    }
    return 0L;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList paramArrayList)
  {
    paramArrayList = StructMsgHelper.a(paramArrayList);
    String str = paramQQAppInterface.a();
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l = i;
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l, paramArrayList);
    paramSessionInfo.msgUid = MessageUtils.a(paramInt);
    if (!MessageHandlerUtils.a(paramQQAppInterface, paramSessionInfo, false)) {
      paramQQAppInterface.a().b(paramSessionInfo, paramSessionInfo.selfuin);
    }
    return paramSessionInfo.uniseq;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramSessionInfo != null)
    {
      l1 = l2;
      if (paramMessageForPic != null)
      {
        paramSessionInfo = MessageRecordFactory.a(paramMessageForPic);
        ((SVIPHandler)paramQQAppInterface.a(13)).a(paramSessionInfo);
        paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
        l1 = paramSessionInfo.uniseq;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)a(paramQQAppInterface, paramString, paramSessionInfo, -3, 0);
    long l = 0L;
    if (localMessageForPtt != null) {
      l = localMessageForPtt.uniseq;
    }
    if (l != -1L)
    {
      int i = QQRecorder.a(localMessageForPtt);
      int j = RecordParams.a(paramString);
      a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, l, true, i * 1000, j, true, 0, 0, true);
    }
    return l;
  }
  
  /* Error */
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    // Byte code:
    //   0: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: ldc -47
    //   8: iconst_2
    //   9: new 211	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   16: ldc -42
    //   18: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   24: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc -27
    //   29: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: getfield 230	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   36: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_2
    //   46: ifnull +603 -> 649
    //   49: aload_2
    //   50: iconst_1
    //   51: aload 9
    //   53: invokestatic 242	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;ZLjava/util/ArrayList;)Ljava/lang/String;
    //   56: astore 11
    //   58: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +30 -> 91
    //   64: ldc -47
    //   66: iconst_2
    //   67: new 211	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   74: ldc -12
    //   76: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   82: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 10
    //   93: getfield 247	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: ifnull +330 -> 426
    //   99: aload_0
    //   100: invokestatic 252	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   103: ifeq +323 -> 426
    //   106: new 254	com/tencent/mobileqq/data/MessageForFoldMsg
    //   109: dup
    //   110: invokespecial 255	com/tencent/mobileqq/data/MessageForFoldMsg:<init>	()V
    //   113: astore_2
    //   114: aload_2
    //   115: checkcast 254	com/tencent/mobileqq/data/MessageForFoldMsg
    //   118: iconst_0
    //   119: aload 10
    //   121: getfield 247	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   124: aload 10
    //   126: getfield 257	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_Long	J
    //   129: iconst_1
    //   130: invokevirtual 261	com/tencent/mobileqq/data/MessageForFoldMsg:init	(ZLjava/lang/String;JZ)V
    //   133: aload_0
    //   134: aload_2
    //   135: aload_1
    //   136: getfield 110	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   139: aload_1
    //   140: getfield 263	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   143: aload_1
    //   144: getfield 101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   147: invokestatic 266	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   150: aload_2
    //   151: aload 11
    //   153: putfield 271	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   156: aload_2
    //   157: iload 8
    //   159: invokestatic 140	com/tencent/mobileqq/service/message/MessageUtils:a	(I)J
    //   162: putfield 272	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   165: aload_2
    //   166: iload 5
    //   168: putfield 275	com/tencent/mobileqq/data/ChatMessage:longMsgCount	I
    //   171: aload_2
    //   172: iload 6
    //   174: putfield 278	com/tencent/mobileqq/data/ChatMessage:longMsgIndex	I
    //   177: aload_2
    //   178: iload 7
    //   180: putfield 281	com/tencent/mobileqq/data/ChatMessage:longMsgId	I
    //   183: aload_2
    //   184: iconst_1
    //   185: putfield 284	com/tencent/mobileqq/data/ChatMessage:mAnimFlag	Z
    //   188: aload_2
    //   189: instanceof 286
    //   192: ifeq +346 -> 538
    //   195: aload_2
    //   196: checkcast 286	com/tencent/mobileqq/data/MessageForReplyText
    //   199: astore 11
    //   201: aload 11
    //   203: aload_1
    //   204: getfield 230	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   207: putfield 289	com/tencent/mobileqq/data/MessageForReplyText:msgVia	I
    //   210: aload 9
    //   212: ifnull +10 -> 222
    //   215: aload 11
    //   217: aload 9
    //   219: putfield 293	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   222: aload 11
    //   224: ldc_w 295
    //   227: aload 10
    //   229: getfield 298	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   232: invokestatic 303	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   235: invokestatic 308	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   238: invokevirtual 312	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 11
    //   243: aload 10
    //   245: getfield 298	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   248: putfield 315	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   251: aload 11
    //   253: aload 11
    //   255: getfield 318	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   258: iconst_1
    //   259: ior
    //   260: putfield 318	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   263: aload_2
    //   264: getfield 321	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   267: iconst_1
    //   268: if_icmpne +307 -> 575
    //   271: invokestatic 326	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   274: aload_2
    //   275: invokevirtual 327	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   278: aload 10
    //   280: getfield 329	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_b_of_type_Boolean	Z
    //   283: ifeq +7 -> 290
    //   286: aload_2
    //   287: invokestatic 332	com/tencent/mobileqq/dating/DatingUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   290: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   293: ifeq +58 -> 351
    //   296: ldc -47
    //   298: iconst_2
    //   299: new 211	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 334
    //   309: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_2
    //   313: getfield 337	com/tencent/mobileqq/data/ChatMessage:time	J
    //   316: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: ldc_w 339
    //   322: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_2
    //   326: getfield 342	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   329: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 344
    //   335: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_2
    //   339: getfield 272	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   342: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   345: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 10
    //   353: getfield 346	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:e	Z
    //   356: istore 4
    //   358: aload 10
    //   360: getfield 348	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:f	Z
    //   363: ifeq +258 -> 621
    //   366: iload 4
    //   368: ifeq +226 -> 594
    //   371: aload_0
    //   372: sipush 165
    //   375: invokevirtual 107	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   378: checkcast 350	com/tencent/mobileqq/multimsg/LongTextMsgManager
    //   381: aload_0
    //   382: aload_2
    //   383: iconst_0
    //   384: invokevirtual 353	com/tencent/mobileqq/multimsg/LongTextMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   387: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +31 -> 421
    //   393: ldc -47
    //   395: iconst_2
    //   396: new 211	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 355
    //   406: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   412: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   415: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload_2
    //   422: getfield 356	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   425: lreturn
    //   426: aload 10
    //   428: getfield 346	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:e	Z
    //   431: ifeq +23 -> 454
    //   434: aload_0
    //   435: invokestatic 357	com/tencent/mobileqq/multimsg/LongTextMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   438: ifeq +16 -> 454
    //   441: sipush 64485
    //   444: invokestatic 360	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   447: checkcast 268	com/tencent/mobileqq/data/ChatMessage
    //   450: astore_2
    //   451: goto -318 -> 133
    //   454: aload 10
    //   456: getfield 298	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   459: ifnull +183 -> 642
    //   462: sipush 64487
    //   465: istore_3
    //   466: iload_3
    //   467: invokestatic 360	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   470: checkcast 268	com/tencent/mobileqq/data/ChatMessage
    //   473: astore_2
    //   474: iload_3
    //   475: sipush 64536
    //   478: if_icmpne +18 -> 496
    //   481: aload 9
    //   483: ifnull +13 -> 496
    //   486: aload_1
    //   487: getfield 101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   490: aload 9
    //   492: aload_2
    //   493: invokestatic 365	com/tencent/mobileqq/troop/text/AtTroopMemberSpan:a	(ILjava/util/ArrayList;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   496: goto -363 -> 133
    //   499: astore_1
    //   500: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -240 -> 263
    //   506: ldc -47
    //   508: iconst_2
    //   509: new 211	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 367
    //   519: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload_1
    //   523: invokevirtual 370	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   526: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: goto -272 -> 263
    //   538: aload_2
    //   539: checkcast 372	com/tencent/mobileqq/data/MessageForText
    //   542: astore 11
    //   544: aload 11
    //   546: aload_1
    //   547: getfield 230	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   550: putfield 373	com/tencent/mobileqq/data/MessageForText:msgVia	I
    //   553: aload 9
    //   555: ifnull +10 -> 565
    //   558: aload 11
    //   560: aload 9
    //   562: putfield 374	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   565: aload 11
    //   567: aload 10
    //   569: invokevirtual 378	com/tencent/mobileqq/data/MessageForText:setSendMsgParams	(Lcom/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams;)V
    //   572: goto -309 -> 263
    //   575: invokestatic 326	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   578: getfield 380	com/tencent/biz/anonymous/AnonymousChatHelper:jdField_a_of_type_Boolean	Z
    //   581: ifeq -303 -> 278
    //   584: invokestatic 326	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   587: iconst_0
    //   588: putfield 380	com/tencent/biz/anonymous/AnonymousChatHelper:jdField_a_of_type_Boolean	Z
    //   591: goto -313 -> 278
    //   594: aload_0
    //   595: invokevirtual 153	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   598: aload_2
    //   599: aconst_null
    //   600: invokevirtual 383	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/MessageObserver;)V
    //   603: goto -216 -> 387
    //   606: astore_0
    //   607: getstatic 44	com/tencent/mobileqq/activity/ChatActivityFacade:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   610: iconst_1
    //   611: ldc_w 385
    //   614: aload_0
    //   615: invokestatic 388	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   618: goto -231 -> 387
    //   621: new 390	ksj
    //   624: dup
    //   625: iload 4
    //   627: aload_0
    //   628: aload_2
    //   629: invokespecial 393	ksj:<init>	(ZLcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   632: bipush 10
    //   634: aconst_null
    //   635: iconst_0
    //   636: invokestatic 398	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   639: goto -252 -> 387
    //   642: sipush 64536
    //   645: istore_3
    //   646: goto -180 -> 466
    //   649: ldc_w 400
    //   652: astore 11
    //   654: goto -596 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	paramQQAppInterface	QQAppInterface
    //   0	657	1	paramSessionInfo	SessionInfo
    //   0	657	2	paramString	String
    //   0	657	3	paramInt1	int
    //   0	657	4	paramBoolean	boolean
    //   0	657	5	paramByte1	byte
    //   0	657	6	paramByte2	byte
    //   0	657	7	paramShort	short
    //   0	657	8	paramInt2	int
    //   0	657	9	paramArrayList	ArrayList
    //   0	657	10	paramSendMsgParams	ChatActivityFacade.SendMsgParams
    //   56	597	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   222	263	499	java/lang/Exception
    //   371	387	606	java/lang/Exception
    //   594	603	606	java/lang/Exception
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = TransfileUtile.a(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = MessageRecordFactory.a(45536);
      paramString3.selfuin = paramQQAppInterface.a();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.a();
      paramString3.msg = paramString1;
      paramString3.msgtype = 45536;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((SVIPHandler)paramQQAppInterface.a(13)).a(paramString3);
      paramQQAppInterface.a().a(paramString3, paramQQAppInterface.a());
      return paramString3.uniseq;
    }
    return 0L;
  }
  
  private static ChatMessage a(ChatAdapter1 paramChatAdapter1)
  {
    paramChatAdapter1 = paramChatAdapter1.a();
    if ((paramChatAdapter1 == null) || (paramChatAdapter1.isEmpty())) {
      return null;
    }
    return (ChatMessage)paramChatAdapter1.get(paramChatAdapter1.size() - 1);
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramSessionInfo != null)
      {
        int j = paramSessionInfo.jdField_a_of_type_Int;
        int i = j;
        if (j == 1)
        {
          i = j;
          if (HotChatUtil.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, true))
          {
            j = 1026;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.i("PttShow", 2, "createPttMessage UIN_TYPE_HOTCHAT_TOPIC");
              i = j;
            }
          }
        }
        localObject1 = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i);
        ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(paramInt2, paramString);
        ((MessageForPtt)localObject1).fileSize = paramInt1;
        ((MessageForPtt)localObject1).itemType = 2;
        if ((!SttManager.a(i)) || (!SttManager.a(paramQQAppInterface))) {
          break label196;
        }
      }
    }
    label196:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((MessageForPtt)localObject1).sttAbility = paramInt1;
      ((MessageForPtt)localObject1).voiceType = paramInt2;
      ((MessageForPtt)localObject1).longPttVipFlag = MessageUtils.a(paramQQAppInterface, paramQQAppInterface.a());
      AnonymousChatHelper.a().a((MessageRecord)localObject1);
      ((MessageForPtt)localObject1).serial();
      ((SVIPHandler)paramQQAppInterface.a(13)).a((MessageRecord)localObject1);
      return (MessageForPtt)localObject1;
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int))
    {
      paramQQAppInterface = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!MsgUtils.b(paramSessionInfo.issend)) {
            return paramSessionInfo;
          }
          i -= 1;
        }
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSessionInfo != null)
    {
      localObject1 = localObject2;
      if (paramMessageForPtt != null)
      {
        localObject1 = MessageRecordFactory.a(paramMessageForPtt);
        ((SVIPHandler)paramQQAppInterface.a(13)).a((MessageRecord)localObject1);
        paramQQAppInterface.a().a((MessageRecord)localObject1, paramQQAppInterface.a());
      }
    }
    return (MessageRecord)localObject1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2)
  {
    if (paramSessionInfo == null) {}
    while (paramString1 == null) {
      return null;
    }
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo.path = paramString1;
    paramSessionInfo.size = 0L;
    paramSessionInfo.type = 1;
    paramSessionInfo.isRead = true;
    paramSessionInfo.serial();
    ((SVIPHandler)paramQQAppInterface.a(13)).a(paramSessionInfo);
    paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
    return paramSessionInfo;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    paramString = a(paramQQAppInterface, paramString, paramSessionInfo, paramInt1, paramInt2);
    if (paramString != null)
    {
      paramString.msgVia = paramSessionInfo.c;
      paramQQAppInterface.a().a(paramString, paramQQAppInterface.a());
    }
    while (!QLog.isColorLevel()) {
      return paramString;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "createPttMessage null");
    return paramString;
  }
  
  public static AbsShareMsg a(Context paramContext, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder;
    if ((paramMessageRecord instanceof MessageForMixedMsg))
    {
      localStringBuilder = new StringBuilder();
      if (android.text.TextUtils.isEmpty(paramString)) {
        break label359;
      }
      str = paramString;
      if (paramString.length() <= 12) {}
    }
    label359:
    for (String str = paramString.substring(0, 11) + "...";; str = "  ")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(":  ");
      localStringBuilder.append(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramMessageRecord));
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.i * 0.8F), 2, 30, localStringBuilder.toString()).toString();
      localArrayList.add(new StructMsgItemTitle(paramMessageRecord));
      paramString = paramMessageRecord;
      if (paramMessageRecord.length() > 30) {
        paramString = paramMessageRecord.substring(0, 30);
      }
      paramMessageRecord = paramContext.getString(2131367904);
      paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a(paramString).a(3).a("viewMultiMsg", "", null, null, null).a(paramMessageRecord, null).d(paramContext.getResources().getString(2131368042)).a();
      paramMessageRecord = new StructMsgItemLayout1(localArrayList);
      paramMessageRecord.a(new StructMsgItemHr());
      paramMessageRecord.a(new StructMsgItemSummary("点击查看完整消息"));
      paramContext.addItem(paramMessageRecord);
      return paramContext;
      paramString = (MessageForLongTextMsg)paramMessageRecord;
      if (paramString.sb != null) {}
      for (paramString = paramString.sb.toString();; paramString = paramString.msg)
      {
        str = paramString;
        if (com.tencent.mobileqq.text.TextUtils.a(paramString)) {
          str = com.tencent.mobileqq.text.TextUtils.b(paramString);
        }
        int i = 60;
        if (AnonymousChatHelper.a(paramMessageRecord)) {
          i = 50;
        }
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.i * 0.8F), 2, i, str).toString();
        break;
      }
    }
  }
  
  public static AbsShareMsg a(Context paramContext, String paramString, List paramList, Map paramMap)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    label44:
    StringBuilder localStringBuilder;
    Object localObject2;
    Object localObject1;
    if (paramList.size() >= 3)
    {
      i = 3;
      j = 0;
      if (j >= i) {
        break label576;
      }
      paramString = "  ";
      localStringBuilder = new StringBuilder();
      localObject2 = (ChatMessage)paramList.get(j);
      localObject1 = (String)paramMap.get(((ChatMessage)localObject2).senderuin);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (((String)localObject1).length() <= 12) {
          break label212;
        }
        paramString = ((String)localObject1).substring(0, 11) + "...";
      }
      label139:
      if (!(localObject2 instanceof MessageForPic)) {
        break label218;
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(":  ");
      localStringBuilder.append("[图片]");
      localArrayList.add(new StructMsgItemTitle(localStringBuilder.toString()));
    }
    for (;;)
    {
      j += 1;
      break label44;
      i = paramList.size();
      break;
      label212:
      paramString = (String)localObject1;
      break label139;
      label218:
      if ((localObject2 instanceof MessageForText))
      {
        localObject1 = (MessageForText)localObject2;
        if (((MessageForText)localObject1).sb != null) {}
        for (localObject1 = ((MessageForText)localObject1).sb.toString();; localObject1 = ((MessageForText)localObject1).msg)
        {
          localObject2 = localObject1;
          if (com.tencent.mobileqq.text.TextUtils.a((String)localObject1)) {
            localObject2 = com.tencent.mobileqq.text.TextUtils.b((String)localObject1);
          }
          localStringBuilder.append(paramString);
          localStringBuilder.append(":  ");
          localStringBuilder.append((String)localObject2);
          localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.i * 0.8F), 2, 30, localStringBuilder.toString()).toString()));
          break;
        }
      }
      if ((localObject2 instanceof MessageForQQStoryComment))
      {
        localObject1 = (MessageForQQStoryComment)localObject2;
        localStringBuilder.append(paramString);
        localStringBuilder.append(":  ");
        localStringBuilder.append(((MessageForQQStoryComment)localObject1).comment);
        localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.i * 0.8F), 2, 30, localStringBuilder.toString()).toString()));
      }
      if (((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForLongMsg)))
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append(":  ");
        localStringBuilder.append(MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject2));
        localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.i * 0.8F), 2, 30, localStringBuilder.toString()).toString()));
      }
      else if ((localObject2 instanceof MessageForStructing))
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append(":  ");
        localStringBuilder.append("[结构化消息]");
        localArrayList.add(new StructMsgItemTitle(localStringBuilder.toString()));
      }
    }
    label576:
    paramString = paramContext.getString(2131367904);
    paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(35).a("[转发多条消息]").a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).d(paramContext.getResources().getString(2131368042)).a();
    paramString = new StructMsgItemLayout1(localArrayList);
    paramString.a(new StructMsgItemHr());
    paramString.a(new StructMsgItemSummary(String.format("查看%s条转发消息", new Object[] { Integer.valueOf(paramList.size()) })));
    paramContext.addItem(paramString);
    return paramContext;
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramContext = paramContext.getResources();
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramContext.getDisplayMetrics().density;
    int k = paramCharSequence.length();
    int i = 0;
    int j = i;
    if (i < k)
    {
      if (Layout.getDesiredWidth(paramCharSequence, 0, i + 1, localTextPaint) > paramInt1 * paramInt2) {
        j = i - 1;
      }
    }
    else if (j >= k)
    {
      paramContext = paramCharSequence;
      if (j <= paramInt3) {}
    }
    else
    {
      if (j <= paramInt3) {
        break label143;
      }
    }
    for (;;)
    {
      paramContext = paramCharSequence.subSequence(0, paramInt3).toString() + "…";
      return paramContext;
      i += 1;
      break;
      label143:
      paramInt3 = j;
    }
  }
  
  private static String a(String paramString, ArrayList paramArrayList)
  {
    int i = 0;
    int j = 0;
    while ((i < paramString.length()) && (paramString.codePointAt(i) == 0))
    {
      j += 1;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow, at info starts with char 0");
      }
      i += 1;
    }
    Object localObject = paramString;
    if (j > 0)
    {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject = (MessageForText.AtTroopMemberInfo)paramArrayList.next();
          ((MessageForText.AtTroopMemberInfo)localObject).startPos = ((short)(((MessageForText.AtTroopMemberInfo)localObject).startPos - j));
        } while (((MessageForText.AtTroopMemberInfo)localObject).startPos >= 0);
        if (QLog.isColorLevel()) {
          QLog.e("SendMsgBtn", 2, " createTextMessageToshow error, at info starts with char 0");
        }
        localObject = null;
      }
    }
    else {
      return (String)localObject;
    }
    return paramString.substring(j);
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    paramNewestFeedInfo.strTitle = paramNewestFeedInfo.strTitle.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    paramNewestFeedInfo.strSummary = paramNewestFeedInfo.strSummary.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    paramNewestFeedInfo.strContent = paramNewestFeedInfo.strContent.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "[表情]");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramNewestFeedInfo.uAppid);
      localJSONObject.put("title", paramNewestFeedInfo.strTitle);
      localJSONObject.put("actionUrl", paramNewestFeedInfo.strJmpUrl);
      localJSONObject.put("content", paramNewestFeedInfo.strContent);
      localJSONObject.put("coverImageUrl", paramNewestFeedInfo.strImgUrl);
      localJSONObject.put("fromuin", paramNewestFeedInfo.uHostUin);
      localJSONObject.put("imageCount", paramNewestFeedInfo.uImgCount);
      localJSONObject.put("lbsinfo", paramNewestFeedInfo.strLBSInfo);
      localJSONObject.put("summery", paramNewestFeedInfo.strSummary);
      localJSONObject.put("time", paramNewestFeedInfo.uTime);
      return localJSONObject;
    }
    catch (JSONException paramNewestFeedInfo) {}
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "go to dismissActionSheet()!");
    }
    if ((jdField_a_of_type_ComTencentWidgetActionSheet != null) && (jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {}
    try
    {
      jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      jdField_a_of_type_ComTencentWidgetActionSheet = null;
      if ((b == null) || (!b.isShowing())) {}
    }
    catch (Exception localException1)
    {
      try
      {
        b.dismiss();
        b = null;
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    paramString3 = SubString.a(paramString4, 45, "UTF-8", "...");
    paramString4 = SubString.a(paramString5, 90, "UTF-8", "...");
    paramString5 = "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString4 + ")";
    if (!paramContext.getResources().getString(2131365033).equals(paramString3)) {}
    for (paramContext = paramContext.getResources().getString(2131369799) + " " + paramString3;; paramContext = paramContext.getResources().getString(2131369799))
    {
      paramString1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString1 + "&lon=" + paramString2 + "&title=" + paramString3 + "&loc=" + paramString4 + "&dpid=" + paramString6;
      paramContext = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(32).a(paramContext).d(paramString5).a("plugin", paramString1, paramString1, paramString1, paramString1).a();
      paramString1 = StructMsgElementFactory.a(2);
      paramString1.a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString3, paramString4);
      paramContext.addItem(paramString1);
      a(paramQQAppInterface, paramSessionInfo, paramContext);
      return;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    b(paramQQAppInterface, paramChatMessage);
    if ((((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) && (((FragmentActivity)paramContext).getChatFragment() != null) && (((FragmentActivity)paramContext).getChatFragment().a() != null))
    {
      ((FragmentActivity)paramContext).getChatFragment().a().a(paramChatMessage);
      return;
    }
    paramQQAppInterface.a().a(paramChatMessage, false);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, List paramList)
  {
    paramQQAppInterface = new ksb(paramContext, paramList, paramQQAppInterface);
    paramList = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramList.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramList.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBaseChatPie != null)
    {
      if (paramQQAppInterface != null) {
        break label27;
      }
      i = 1;
      if (paramSessionInfo != null) {
        break label33;
      }
      label18:
      if ((j | i) == 0) {
        break label39;
      }
    }
    label27:
    label33:
    label39:
    label271:
    label396:
    for (;;)
    {
      return;
      i = 0;
      break;
      j = 0;
      break label18;
      if ((paramBaseChatPie instanceof FriendChatPie)) {}
      for (paramBaseChatPie = (FriendChatPie)paramBaseChatPie;; paramBaseChatPie = null)
      {
        if (paramBaseChatPie == null) {
          break label396;
        }
        AioVipDonateHelper localAioVipDonateHelper = AioVipDonateHelper.a();
        i = paramSessionInfo.jdField_a_of_type_Int;
        boolean bool1 = localAioVipDonateHelper.a(paramQQAppInterface);
        boolean bool2 = localAioVipDonateHelper.b(paramQQAppInterface);
        boolean bool3 = localAioVipDonateHelper.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        if ((i != 0) || (!bool1) || (!bool2) || (!bool3)) {
          break;
        }
        Object localObject = paramQQAppInterface.a().getSharedPreferences(AioVipDonateHelper.jdField_a_of_type_JavaLangString, 0);
        if (!paramBoolean)
        {
          long l1 = localAioVipDonateHelper.a(paramQQAppInterface);
          long l2 = ((SharedPreferences)localObject).getLong(AioVipDonateHelper.jdField_b_of_type_JavaLangString + paramSessionInfo.jdField_a_of_type_JavaLangString, 0L);
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 > l1)) {
            break label271;
          }
        }
        VIPAioSendHandler localVIPAioSendHandler;
        do
        {
          localObject = localAioVipDonateHelper.a(paramQQAppInterface);
          if ((!localAioVipDonateHelper.c(paramQQAppInterface)) || (android.text.TextUtils.isEmpty((CharSequence)localObject)) || (!paramBaseChatPie.J)) {
            break;
          }
          localAioVipDonateHelper.a(paramQQAppInterface, 0);
          MsgProxyUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 61514);
          paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_Int, 61514, (String)localObject);
          return;
          localVIPAioSendHandler = (VIPAioSendHandler)paramQQAppInterface.a(86);
        } while (localVIPAioSendHandler == null);
        paramBaseChatPie = new AIOSendReq();
        paramBaseChatPie.iSend = 0;
        paramBaseChatPie.sAid = "";
        paramBaseChatPie.sUin = paramQQAppInterface.a();
        paramBaseChatPie.sFriendUin = paramSessionInfo.jdField_a_of_type_JavaLangString;
        localVIPAioSendHandler.a(paramBaseChatPie);
        paramBaseChatPie = ((SharedPreferences)localObject).edit();
        paramBaseChatPie.putLong(AioVipDonateHelper.jdField_b_of_type_JavaLangString + paramSessionInfo.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
        if (Build.VERSION.SDK_INT <= 8)
        {
          paramBaseChatPie.commit();
          return;
        }
        paramBaseChatPie.apply();
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong)) && (!paramBoolean1) && (StreamDataManager.a(paramString2) >= 1))
    {
      StreamDataManager.a(paramString2, paramQQAppInterface, paramString1, paramLong, paramInt2, paramInt3);
      return;
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    localTransferRequest.c = paramString1;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_b_of_type_Int = 2;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.i = paramString2;
    localTransferRequest.e = 1002;
    localTransferRequest.l = paramBoolean3;
    localTransferRequest.n = paramInt5;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().a(paramString1, paramInt1, paramLong);
    if ((paramInt1 == 1026) && (QLog.isColorLevel()))
    {
      paramString2 = new StringBuilder().append("uploadPtt,");
      if (localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label250;
      }
    }
    label250:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)))
      {
        paramString1 = (MessageForPtt)localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.a(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
      }
      paramQQAppInterface.a().a(localTransferRequest);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    if (!FileUtil.b(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_bank", 2, "AIO---sendShowLovePic,file not exist or empty");
      }
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80052A6", "0X80052A6", 0, 0, "", "", "", "");
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "AIO---sendShowLovePic");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramQQAppInterface = new Intent();
    if ((paramActivity instanceof SplashActivity))
    {
      paramQQAppInterface.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      paramQQAppInterface = AIOUtils.a(paramQQAppInterface, null);
    }
    for (;;)
    {
      paramQQAppInterface.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramQQAppInterface.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      paramQQAppInterface.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramQQAppInterface.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1036);
      paramQQAppInterface.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
      paramQQAppInterface.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramQQAppInterface.putExtra("uinname", paramSessionInfo.d);
      paramQQAppInterface.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      PhotoUtils.a(paramActivity, paramQQAppInterface, localArrayList, 0, true);
      return;
      paramQQAppInterface.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l = i;
    String str = paramQQAppInterface.a();
    paramSessionInfo = MessageRecordFactory.a(str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l);
    paramQQAppInterface.a().a(paramSessionInfo, null);
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) {
      ((FragmentActivity)paramContext).getChatFragment().a().a(paramSessionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "create new shake message,shmsgseq is:" + paramSessionInfo.shmsgseq + ",msgUid is:" + paramSessionInfo.msgUid + ",time is:" + System.currentTimeMillis());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo)
  {
    if (!paramIntent.getBooleanExtra("not_forward", false)) {}
    do
    {
      return;
      paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), paramSessionInfo.jdField_a_of_type_Int, paramForwardFileInfo.a());
    } while (!paramIntent.getBooleanExtra("not_forward", false));
    paramIntent.removeExtra("not_forward");
    paramIntent.getExtras().remove("not_forward");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "forwardForFile");
    }
    if ((paramForwardFileInfo != null) && (paramForwardFileInfo.b() == 10006) && (android.text.TextUtils.isEmpty(paramForwardFileInfo.a()))) {
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo);
    }
    for (;;)
    {
      return;
      if (paramIntent.getBooleanExtra("isFromShare", false))
      {
        if (!paramIntent.getBooleanExtra("sendMultiple", false))
        {
          if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_a_of_type_JavaLangString);
            return;
          }
          paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
        }
      }
      else if (paramIntent.getBooleanExtra("not_forward", false))
      {
        if ((paramQQAppInterface.a().b(paramForwardFileInfo.b()) == null) && (QLog.isColorLevel())) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "there has a Bug!,sissionId[" + paramForwardFileInfo.b() + "]");
        }
        switch (paramForwardFileInfo.b())
        {
        }
        while ((!paramBoolean) && (paramIntent.getBooleanExtra("not_forward", false)))
        {
          paramIntent.removeExtra("not_forward");
          paramIntent.getExtras().remove("not_forward");
          return;
          if ((FileManagerUtil.a()) && (paramForwardFileInfo.d() != 3))
          {
            FMDialogUtil.a(paramContext, 2131362855, 2131362851, new ksl(paramSessionInfo, paramQQAppInterface, paramForwardFileInfo));
          }
          else if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
          }
          else
          {
            paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
            continue;
            if (paramSessionInfo.jdField_a_of_type_Int == 1)
            {
              paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
              continue;
              if (paramSessionInfo.jdField_a_of_type_Int == 1)
              {
                if (FileUtil.b(paramForwardFileInfo.a()))
                {
                  paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                }
                else
                {
                  paramForwardFileInfo.b();
                  paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                  if ((paramContext != null) && (paramContext.peerType == 3000))
                  {
                    paramContext = paramQQAppInterface.a().a(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext.peerType, false);
                    paramQQAppInterface.a().a(paramContext, 27);
                  }
                  else
                  {
                    paramQQAppInterface.a().b(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                  }
                }
              }
              else
              {
                paramString = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                paramContext = paramQQAppInterface.a();
                if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                  paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
                }
                if ((paramString != null) && (paramString.peerType == 3000))
                {
                  paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
                  if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1006) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 1006)) {
                    paramQQAppInterface.a().a(paramContext, 21);
                  } else if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
                    paramQQAppInterface.a().a(paramContext, 22);
                  }
                }
                else
                {
                  paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
                  if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
                    paramContext.nOpType = 28;
                  }
                  paramQQAppInterface.a().a(paramContext);
                  continue;
                  paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                  paramQQAppInterface.a().b(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
                  continue;
                  if ((FileManagerUtil.a()) && (paramForwardFileInfo.d() == 3)) {
                    FMDialogUtil.a(paramContext, 2131362855, 2131362851, new ksm(paramForwardFileInfo, paramQQAppInterface, paramSessionInfo));
                  } else if (paramSessionInfo.jdField_a_of_type_Int == 1)
                  {
                    if (FileUtil.b(paramForwardFileInfo.a()))
                    {
                      paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                    }
                    else
                    {
                      paramString = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                      paramContext = paramQQAppInterface.a();
                      if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                        paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
                      }
                      if ((paramString != null) && (paramString.peerType == 3000))
                      {
                        paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString.peerType, false);
                        paramQQAppInterface.a().a(paramContext, 27);
                      }
                      else
                      {
                        paramQQAppInterface.a().b(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                      }
                    }
                  }
                  else {
                    paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ApolloInfo paramApolloInfo)
  {
    if ((paramQQAppInterface == null) || (paramApolloInfo == null) || (paramApolloInfo.a == null) || (android.text.TextUtils.isEmpty(paramApolloInfo.a.actionName)) || ((paramApolloInfo.a.personNum > 0) && (android.text.TextUtils.isEmpty(paramApolloInfo.a.peerUin)))) {
      return;
    }
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(50);
    ApolloManager localApolloManager = (ApolloManager)paramQQAppInterface.getManager(152);
    paramContext = (VasExtensionHandler)paramQQAppInterface.a(71);
    ApolloBaseInfo localApolloBaseInfo;
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (paramApolloInfo.a.personNum > 0) && (!paramApolloInfo.a.peerUin.equals(paramQQAppInterface.a())))
    {
      localApolloBaseInfo = localApolloManager.b(paramApolloInfo.a.peerUin);
      if (localApolloBaseInfo == null) {
        paramContext.b(paramApolloInfo.a.peerUin);
      }
    }
    else
    {
      label150:
      localObject = new ApolloMessage();
      ((ApolloMessage)localObject).id = paramApolloInfo.a.actionId;
      ((ApolloMessage)localObject).name = paramApolloInfo.a.actionName.getBytes();
      if ((!android.text.TextUtils.isEmpty(paramApolloInfo.a.atNickName)) && ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))) {
        ((ApolloMessage)localObject).text = paramApolloInfo.a.atNickName.getBytes();
      }
    }
    for (;;)
    {
      try
      {
        if (!android.text.TextUtils.isEmpty(paramApolloInfo.a.inputText))
        {
          if (0 != 0) {
            break label709;
          }
          paramContext = new JSONObject();
          paramContext.put("inputText", paramApolloInfo.a.inputText);
          if (paramContext != null) {
            ((ApolloMessage)localObject).extStr = paramContext.toString();
          }
          paramContext = localApolloManager.b(paramQQAppInterface.a());
          ((ApolloMessage)localObject).sender_ts = Utils.a(paramContext.apolloServerTS);
          ((ApolloMessage)localObject).sender_status = paramContext.apolloStatus;
          int i = 41;
          if (paramApolloInfo.a.personNum > 0)
          {
            ((ApolloMessage)localObject).peer_uin = Long.valueOf(paramApolloInfo.a.peerUin).longValue();
            paramContext = localApolloManager.b(paramApolloInfo.a.peerUin);
            ((ApolloMessage)localObject).peer_ts = Utils.a(paramContext.apolloServerTS);
            ((ApolloMessage)localObject).peer_status = paramContext.apolloStatus;
            i = 127;
          }
          int j = i;
          if (paramApolloInfo.d == 1) {
            j = i | 0x80;
          }
          ((ApolloMessage)localObject).flag = j;
          paramContext = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, (ApolloMessage)localObject);
          paramContext.inputText = paramApolloInfo.a.inputText;
          if (android.text.TextUtils.isEmpty(paramContext.inputText)) {
            paramContext.inputText = paramApolloInfo.jdField_b_of_type_JavaLangString;
          }
          paramQQAppInterface.a().a(paramContext, null);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "send apollo message msg: " + paramApolloInfo.toString());
          return;
          if ((!((FriendsManager)localObject).b(paramApolloInfo.a.peerUin)) && (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime > 600L))
          {
            paramContext.b(paramApolloInfo.a.peerUin);
            break label150;
          }
          if ((((FriendsManager)localObject).b(paramApolloInfo.a.peerUin)) && (localApolloBaseInfo.apolloUpdateTime == 0L))
          {
            paramContext.b(paramApolloInfo.a.peerUin);
            break label150;
          }
          if (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS) {
            break label150;
          }
          localObject = new ArrayList(1);
          ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(paramApolloInfo.a.peerUin)));
          paramContext.a((ArrayList)localObject, "TROOP_AIO");
          break label150;
        }
        if (android.text.TextUtils.isEmpty(paramApolloInfo.jdField_b_of_type_JavaLangString)) {
          break label704;
        }
        if (0 == 0)
        {
          paramContext = new JSONObject();
          paramContext.put("inputText", paramApolloInfo.jdField_b_of_type_JavaLangString);
          continue;
        }
        paramContext = null;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramQQAppInterface, new Object[0]);
        return;
      }
      continue;
      label704:
      paramContext = null;
      continue;
      label709:
      paramContext = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e(jdField_a_of_type_JavaLangString, 1, "sendEmosmMsg emoticon is null:");
    }
    label185:
    label230:
    label237:
    Object localObject1;
    label332:
    label360:
    label513:
    label700:
    do
    {
      return;
      if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
      {
        Toast.makeText(paramContext, paramContext.getString(2131370285), 0).show();
        a(paramQQAppInterface, paramEmoticon);
        VasReportUtils.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(paramContext) + "", "", "", "", "");
        paramContext = jdField_a_of_type_JavaLangString;
        paramSessionInfo = new StringBuilder().append("sendEmosmMsg emoticon Encrypt Key is null.name:");
        if (paramEmoticon.name != null)
        {
          paramQQAppInterface = paramEmoticon.name;
          paramSessionInfo = paramSessionInfo.append(paramQQAppInterface).append(", epid_eid:");
          if (paramEmoticon.epId == null) {
            break label230;
          }
          paramQQAppInterface = paramEmoticon.epId;
          paramSessionInfo = paramSessionInfo.append(paramQQAppInterface).append("_");
          if (paramEmoticon.eId == null) {
            break label237;
          }
        }
        for (paramQQAppInterface = paramEmoticon.eId;; paramQQAppInterface = "~")
        {
          QLog.e(paramContext, 1, paramQQAppInterface);
          return;
          paramQQAppInterface = "~";
          break;
          paramQQAppInterface = "~";
          break label185;
        }
      }
      Object localObject2 = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("sendEmosmMsg ePackage == null name:");
        if (paramEmoticon.name == null) {
          break;
        }
        localObject1 = paramEmoticon.name;
        localStringBuilder = localStringBuilder.append((String)localObject1).append(", epid_eid:");
        if (paramEmoticon.epId == null) {
          break label815;
        }
        localObject1 = paramEmoticon.epId;
        localStringBuilder = localStringBuilder.append((String)localObject1).append("_");
        if (paramEmoticon.eId == null) {
          break label823;
        }
        localObject1 = paramEmoticon.eId;
        QLog.e((String)localObject2, 1, (String)localObject1);
        if (!(paramEmoticon instanceof EmoticonKeyword)) {
          break label831;
        }
        localObject1 = new EmoticonPackage();
        ((EmoticonPackage)localObject1).epId = paramEmoticon.epId;
        ((EmoticonPackage)localObject1).status = 0;
      }
      paramContext = new MarkFaceMessage();
      paramContext.cSubType = ((EmoticonPackage)localObject1).type;
      paramContext.sbufID = EmosmUtils.a(paramEmoticon.eId, paramEmoticon.jobType);
      paramContext.dwTabID = Integer.valueOf(paramEmoticon.epId).intValue();
      paramContext.sbfKey = paramEmoticon.encryptKey.getBytes();
      paramContext.imageWidth = paramEmoticon.width;
      paramContext.imageHeight = paramEmoticon.height;
      paramContext.faceName = paramEmoticon.name;
      if (paramEmoticon.isSound) {
        paramContext.mediaType = 1;
      }
      if (paramEmoticon.jobType != 1) {
        break label887;
      }
      paramContext.mediaType = 2;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "sendEmosmMsg epid = :" + paramEmoticon.epId + ",eid = :" + paramEmoticon.eId + ";type = " + ((EmoticonPackage)localObject1).type + ";jobtype = " + paramEmoticon.jobType + ";mfm.mediatype = " + paramContext.mediaType);
      }
      if ((1 == ((EmoticonPackage)localObject1).type) || (4 == ((EmoticonPackage)localObject1).type)) {
        paramContext.cSubType = 3;
      }
      if ((paramEmoticon.jobType == 2) && (paramEmoticon.magicValue != null)) {
        paramContext.mobileparam = paramEmoticon.magicValue.getBytes();
      }
      paramContext = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramContext);
      paramContext.sendFaceName = paramEmoticon.name;
      paramContext.msgVia = paramSessionInfo.c;
      if (paramContext.istroop != 1) {
        break label903;
      }
      AnonymousChatHelper.a().a(paramContext);
      paramQQAppInterface.a().a(paramContext, null);
      a(paramQQAppInterface, paramEmoticon);
    } while (!(paramEmoticon instanceof EmoticonKeyword));
    paramContext = jdField_a_of_type_JavaLangString;
    paramSessionInfo = new StringBuilder().append("sendEmosmMsg ok, keyword:, epid_eid:");
    if (paramEmoticon.epId != null)
    {
      paramQQAppInterface = paramEmoticon.epId;
      label752:
      paramSessionInfo = paramSessionInfo.append(paramQQAppInterface).append("_");
      if (paramEmoticon.eId == null) {
        break label929;
      }
      paramQQAppInterface = paramEmoticon.eId;
      label776:
      paramSessionInfo = paramSessionInfo.append(paramQQAppInterface);
      if (!(paramEmoticon instanceof EmoticonKeywordForCloud)) {
        break label936;
      }
    }
    label815:
    label823:
    label831:
    label887:
    label903:
    label929:
    label936:
    for (paramQQAppInterface = "-cloud";; paramQQAppInterface = "-local")
    {
      QLog.d(paramContext, 2, paramQQAppInterface);
      return;
      localObject1 = "~";
      break;
      localObject1 = "~";
      break label332;
      localObject1 = "~";
      break label360;
      VasReportUtils.a("emotionType", "emotionActionSend", "3", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(paramContext) + "", "", "", "", "");
      return;
      if (paramEmoticon.jobType != 4) {
        break label513;
      }
      paramContext.mediaType = 3;
      break label513;
      if (!AnonymousChatHelper.a().jdField_a_of_type_Boolean) {
        break label700;
      }
      AnonymousChatHelper.a().jdField_a_of_type_Boolean = false;
      break label700;
      paramQQAppInterface = "~";
      break label752;
      paramQQAppInterface = "~";
      break label776;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null, true);
      a(paramQQAppInterface, paramEmoticon);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "reSendEmosmMessage : mr is null.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    localSendMsgParams.jdField_a_of_type_Boolean = false;
    localSendMsgParams.jdField_b_of_type_Boolean = true;
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, localSendMsgParams);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "AIO---sendShowLoveMessage");
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80052A5", "0X80052A5", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendIMEEXpression");
    if (!FileUtils.b(paramString))
    {
      ChatActivityUtils.a(paramContext, 2131368726, 0);
      ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
      return;
    }
    paramContext = new PicUploadInfo.Builder();
    paramContext.a(paramString);
    paramContext.d(paramInt);
    paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.c(TranDbRecord.PicDbRecord.e);
    paramContext.e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    paramContext.c(paramQQAppInterface.a());
    paramContext.e(paramSessionInfo.jdField_a_of_type_Int);
    PicReq localPicReq = PicBusiManager.a(2, paramInt);
    localPicReq.a(paramContext.a());
    PicBusiManager.a(localPicReq, paramQQAppInterface);
    ThreadManager.a(new ksh(paramString, paramSessionInfo, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131367256, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131368656, 0);
      return;
    }
    if (paramSessionInfo.isSendFromLocal()) {
      paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramSessionInfo.frienduin, paramSessionInfo.uniseq));
    }
    paramContext = StructMsgFactory.a(paramSessionInfo.msgData);
    paramQQAppInterface.a().b(paramString, paramInt, paramLong);
    if ((paramContext instanceof StructMsgForImageShare))
    {
      StructMsgForImageShare.resendAndUploadImageShare(paramQQAppInterface, paramSessionInfo, (StructMsgForImageShare)paramContext);
      return;
    }
    paramContext = MessageRecordFactory.a(paramSessionInfo);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(47)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) && ((paramContext instanceof BaseActivity)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.a(), 2131364717, 0).b(paramContext.getTitleBarHeight());
      return;
    }
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      long l = paramContext.msgseq;
      if (paramContext.isSendFromLocal()) {
        paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramContext.frienduin, paramContext.uniseq));
      }
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    if ((paramContext != null) && (paramContext.msgtype == 64485))
    {
      paramSessionInfo = (LongTextMsgManager)paramQQAppInterface.getManager(165);
      paramContext.extStr = null;
      paramSessionInfo.a(paramQQAppInterface, paramContext, true);
      return;
    }
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4)
  {
    if (FileUtils.b(paramString1)) {
      ForwardSendPicUtil.a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_JavaLangString, false, paramContext);
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramString2, paramString3, paramLong, paramInt);
        paramContext = paramQQAppInterface.a().a(paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download1,uniseq:" + l1 + ",filePath:" + paramString1 + ",forwardImageOrgServerpath:" + paramString2 + ",forwardImageOrgItemId:" + paramLong + ",processor:" + paramContext);
        }
      } while ((paramContext == null) || (!(paramContext instanceof BaseTransProcessor)));
      paramContext = (BaseTransProcessor)paramContext;
      l2 = paramContext.c();
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download2,msgId:" + l1 + ",filePath:" + paramString1 + ",get download process status:" + l2);
      }
    } while ((l2 != 2000L) && (l2 != 2001L) && (l2 != 2002L));
    paramQQAppInterface.a().a(l1, paramString4, paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, paramString3, paramLong, paramInt);
    paramContext.a().t = paramString4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, paramArrayList, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "sendCustomEmotion url == null");
      if (paramBoolean) {
        VasReportUtils.a("emotionType", "emotionActionSend", "5", "", "", "", "", "", "", "");
      }
    }
    do
    {
      return;
      ImageUtil.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
      if (!FileUtils.b(paramString))
      {
        ChatActivityUtils.a(paramContext, 2131368726, 0);
        if (paramBoolean) {
          VasReportUtils.a("emotionType", "emotionActionSend", "6", "", "", "", "", "", "", "");
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "sendCustomEmotion file not exist or problme: URL = " + paramString);
        return;
      }
      paramContext = new PicUploadInfo.Builder();
      paramContext.a(paramString);
      paramContext.d(1006);
      paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramContext.c(TranDbRecord.PicDbRecord.e);
      paramContext.e(paramSessionInfo.jdField_b_of_type_JavaLangString);
      paramContext.c(paramQQAppInterface.a());
      paramContext.e(paramSessionInfo.jdField_a_of_type_Int);
      PicReq localPicReq = PicBusiManager.a(2, 1006);
      localPicReq.a(paramContext.a());
      PicBusiManager.a(localPicReq, paramQQAppInterface);
    } while (!paramBoolean);
    try
    {
      int i = paramSessionInfo.jdField_a_of_type_Int;
      StatisticConstants.a(new String[] { paramString }, i, false, false, -1, paramQQAppInterface);
      new ksi(paramQQAppInterface, paramString).execute(new Void[0]);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        String str = (String)paramList.next();
        int i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(MsgProxyUtils.a(str))))
          {
            localObject2 = paramQQAppInterface.a().b(str, 0);
            ChatActivityUtils.a(paramContext, str, 0);
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              if (localMessageRecord.msgtype != 63517) {
                continue;
              }
              paramQQAppInterface.a().b(str, localMessageRecord.istroop, localMessageRecord.uniseq);
              continue;
            }
          }
          i += 1;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l2 = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", new Object[] { paramSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(paramSessionInfo.jdField_a_of_type_Int), Long.valueOf(l2) }));
    }
    if ((l2 == -1L) || (l2 == paramSessionInfo.jdField_a_of_type_Long)) {}
    label550:
    label556:
    for (;;)
    {
      return;
      paramSessionInfo.jdField_a_of_type_Long = l2;
      String str = "c2c_processor";
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      Object localObject;
      if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        str = "troop_processor";
        localObject = new msg_svc.PbGroupReadedReportReq();
        ((msg_svc.PbGroupReadedReportReq)localObject).group_code.set(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue());
        ((msg_svc.PbGroupReadedReportReq)localObject).last_read_seq.set(l2);
        localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject);
        paramSessionInfo = str;
      }
      for (;;)
      {
        paramQQAppInterface.a().a(paramSessionInfo).a(localPbMsgReadedReportReq);
        return;
        if (paramSessionInfo.jdField_a_of_type_Int == 1026)
        {
          str = "hctopic_processor";
          localObject = new msg_svc.PbGroupReadedReportReq();
          ((msg_svc.PbGroupReadedReportReq)localObject).group_code.set(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue());
          ((msg_svc.PbGroupReadedReportReq)localObject).last_read_seq.set(l2);
          localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject);
          paramSessionInfo = str;
        }
        else
        {
          if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
            break;
          }
          str = "disc_processor";
          localObject = new msg_svc.PbDiscussReadedReportReq();
          ((msg_svc.PbDiscussReadedReportReq)localObject).conf_uin.set(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue());
          ((msg_svc.PbDiscussReadedReportReq)localObject).last_read_seq.set(l2);
          localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject);
          paramSessionInfo = str;
        }
      }
      if ((MsgProxyUtils.c(paramSessionInfo.jdField_a_of_type_Int)) && (l2 != 0L))
      {
        long l1;
        if (paramSessionInfo.jdField_a_of_type_Int == 1006)
        {
          if (paramSessionInfo.f == null) {
            break label550;
          }
          l1 = Long.valueOf(paramSessionInfo.f).longValue();
        }
        for (;;)
        {
          if (l1 == -1L) {
            break label556;
          }
          localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l1);
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)l2);
          if (paramSessionInfo.jdField_a_of_type_Int == 1024)
          {
            paramSessionInfo = paramQQAppInterface.a().d(paramSessionInfo.jdField_a_of_type_JavaLangString);
            if (paramSessionInfo != null)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + HexUtil.a(paramSessionInfo) + ",length:" + paramSessionInfo.length);
              }
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).crm_sig.set(ByteStringMicro.copyFrom(paramSessionInfo));
            }
          }
          paramSessionInfo = new msg_svc.PbC2CReadedReportReq();
          paramSessionInfo.pair_info.add((MessageMicro)localObject);
          localObject = paramQQAppInterface.a().a().a();
          if (localObject != null) {
            paramSessionInfo.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
          }
          localPbMsgReadedReportReq.c2c_read_report.set(paramSessionInfo);
          paramSessionInfo = str;
          break;
          l1 = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          continue;
          l1 = -1L;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (paramIntent == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } while ((localArrayList == null) || (localArrayList.isEmpty()));
    try
    {
      int i = Integer.valueOf(paramIntent.getStringExtra("key_upload_client_key")).intValue();
      long l = a(paramQQAppInterface, paramSessionInfo, i, localArrayList);
      ((TroopQZoneUploadAlbumHandler)paramQQAppInterface.a(28)).a(i, paramSessionInfo.jdField_a_of_type_JavaLangString, l);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.b().post(new ksf(paramQQAppInterface, paramSessionInfo));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatAdapter1 paramChatAdapter1, long paramLong)
  {
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(50);
    localObject = (HotChatManager)paramQQAppInterface.getManager(59);
    if ((paramSessionInfo.jdField_a_of_type_Int != 1) || (((HotChatManager)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString))) {}
    label157:
    for (;;)
    {
      return;
      int i = 0;
      if (i < paramChatAdapter1.getCount())
      {
        localObject = (ChatMessage)paramChatAdapter1.getItem(i);
        if ((localObject == null) || (MsgProxyUtils.a((MessageRecord)localObject))) {}
      }
      for (long l = ((ChatMessage)localObject).shmsgseq;; l = 0L)
      {
        if (l <= 1L + paramLong) {
          break label157;
        }
        paramChatAdapter1 = paramQQAppInterface.a();
        localObject = (MessageForTroopUnreadTips)MessageRecordFactory.a(61527);
        ((MessageForTroopUnreadTips)localObject).init(paramChatAdapter1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramChatAdapter1, "", MessageCache.a(), 61527, 1, 0L);
        paramQQAppInterface.a().a((MessageRecord)localObject, paramChatAdapter1);
        return;
        i += 1;
        break;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForFunnyFace paramMessageForFunnyFace)
  {
    paramQQAppInterface.a().b(paramMessageForFunnyFace.frienduin, paramMessageForFunnyFace.msgtype, paramMessageForFunnyFace.uniseq);
    paramSessionInfo = MessageRecordFactory.a(paramMessageForFunnyFace);
    paramQQAppInterface.a().a(paramSessionInfo, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    }
    for (String str1 = paramQQAppInterface.a();; str1 = paramSessionInfo.jdField_b_of_type_JavaLangString)
    {
      String str2 = paramQQAppInterface.a();
      String str3 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      int i = paramSessionInfo.jdField_a_of_type_Int;
      int j = MobileQQService.c;
      MobileQQService.c = j + 1;
      paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      paramQQAppInterface.a().a(paramSessionInfo, null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramSessionInfo, paramString, 1010, false, (byte)1, (byte)0, (short)0, Math.abs(new Random().nextInt()), null, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramLong != -1L)
    {
      int j = paramSessionInfo.jdField_a_of_type_Int;
      int i = j;
      if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        i = j;
        if (HotChatUtil.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, true))
        {
          j = 1026;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("PttShow", 2, "updatePttRecordMessage UIN_TYPE_HOTCHAT_TOPIC");
            i = j;
          }
        }
      }
      Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong, ((MessageForPtt)localObject).msgData);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2)
  {
    if (paramSessionInfo == null) {}
    while (paramString1 == null) {
      return;
    }
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramSessionInfo.path = paramString1;
    paramSessionInfo.size = 0L;
    paramSessionInfo.type = 1;
    paramSessionInfo.isRead = true;
    paramSessionInfo.serial();
    ((SVIPHandler)paramQQAppInterface.a(13)).a(paramSessionInfo);
    paramQQAppInterface.a().a(paramSessionInfo, paramQQAppInterface.a());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    if ((paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    a(paramQQAppInterface, paramSessionInfo, "我在这里，点击查看：http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "insertRenewalTailTipMsgIfNeeded app == null");
    }
    int i;
    do
    {
      do
      {
        return;
        i = paramSessionInfo.jdField_a_of_type_Int;
      } while ((i != 0) && (i != 1) && (i != 3000) && (i != 1001) && (i != 1006) && (i != 1004) && (i != 1000) && (i != 3));
      localObject1 = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
      if (!paramBoolean)
      {
        long l = ((SharedPreferences)localObject1).getLong("last_pull_individual_expire_info_time", 0L);
        if (System.currentTimeMillis() - l > 86400000L) {
          break;
        }
      }
      i = ((SharedPreferences)localObject1).getInt("renewal_tail_tip_exit", 0);
    } while (i == 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("renewal_tail_tip", "");
    Object localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putInt("renewal_tail_tip_exit", 0);
    if (Build.VERSION.SDK_INT <= 8) {
      ((SharedPreferences.Editor)localObject1).commit();
    }
    for (;;)
    {
      MsgProxyUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 61516);
      paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_Int, 61516, (String)localObject2);
      ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_show", 0, 0, "" + i, "", "", "");
      return;
      localObject2 = (VasExtensionHandler)paramQQAppInterface.a(71);
      if (localObject2 == null) {
        break;
      }
      ((VasExtensionHandler)localObject2).a(1);
      if (Build.VERSION.SDK_INT <= 8)
      {
        ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).commit();
        return;
      }
      ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).apply();
      return;
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = StructMsgFactory.a(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        str = paramQQAppInterface.a();
        i = MobileQQService.c;
        MobileQQService.c = i + 1;
        l = i;
        paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l, paramArrayOfByte);
        paramQQAppInterface.a().a(paramSessionInfo, null);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      long l;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("structMsg", 2, "forward structMsg msgobj is null");
      return;
    }
    QLog.d("structMsg", 2, "forward structMsg data is null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func tryFetchEmosmKey, app:" + paramQQAppInterface + ",e:" + paramEmoticon);
    }
    if ((paramQQAppInterface == null) || (paramEmoticon == null) || (android.text.TextUtils.isEmpty(paramEmoticon.epId)) || (android.text.TextUtils.isEmpty(paramEmoticon.eId)) || (!android.text.TextUtils.isEmpty(paramEmoticon.encryptKey))) {
      return;
    }
    EmojiManager localEmojiManager = (EmojiManager)paramQQAppInterface.getManager(42);
    ThreadManager.a(new ksd(paramEmoticon, (EmoticonManager)paramQQAppInterface.getManager(13), localEmojiManager), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " decodeToSaveEmoIndex start currenttime:" + System.currentTimeMillis());
    }
    if (paramCharSequence == null) {
      return;
    }
    Object localObject1;
    ArrayList localArrayList;
    int j;
    int i;
    label107:
    Object localObject3;
    int k;
    if ((paramCharSequence instanceof QQText))
    {
      localObject1 = (QQText)paramCharSequence;
      paramCharSequence.length();
      paramCharSequence = paramQQAppInterface.a().createEntityManager();
      localArrayList = new ArrayList();
      localObject2 = (QQText.EmotcationSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), QQText.EmotcationSpan.class);
      localObject1 = new ArrayList();
      j = localObject2.length;
      i = 0;
      if (i >= j) {
        break label474;
      }
      localObject3 = localObject2[i];
      k = ((QQText.EmotcationSpan)localObject3).a();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "index:" + k + ",type:" + ((QQText.EmotcationSpan)localObject3).c);
      }
      switch (((QQText.EmotcationSpan)localObject3).c)
      {
      }
    }
    for (;;)
    {
      i += 1;
      break label107;
      localObject1 = new QQText(paramCharSequence.toString(), 3);
      break;
      localObject3 = "4," + k;
      if (!((ArrayList)localObject1).contains(localObject3))
      {
        Object localObject4 = new RecentEmotionData();
        a((RecentEmotionData)localObject4, paramQQAppInterface.a(), 0, 4, k, null);
        localArrayList.add(localObject4);
        ((ArrayList)localObject1).add(localObject3);
        continue;
        localObject4 = "6," + ((QQText.SmallEmojiSpan)localObject3).g;
        if (!((ArrayList)localObject1).contains(localObject4))
        {
          RecentEmotionData localRecentEmotionData = new RecentEmotionData();
          a(localRecentEmotionData, paramQQAppInterface.a(), 0, 6, k, Integer.toString(((QQText.SmallEmojiSpan)localObject3).g));
          localArrayList.add(localRecentEmotionData);
          ((ArrayList)localObject1).add(localObject4);
          continue;
          localObject3 = "0," + k;
          if (!((ArrayList)localObject1).contains(localObject3))
          {
            localObject4 = new RecentEmotionData();
            a((RecentEmotionData)localObject4, paramQQAppInterface.a(), 0, 0, k, null);
            localArrayList.add(localObject4);
            ((ArrayList)localObject1).add(localObject3);
          }
        }
      }
    }
    label474:
    Object localObject2 = paramCharSequence.a();
    for (;;)
    {
      try
      {
        ((EntityTransaction)localObject2).a();
        paramQQAppInterface = paramCharSequence.a(RecentEmotionData.class, false, null, null, null, null, null, null);
        if (paramQQAppInterface != null) {
          break label982;
        }
        paramQQAppInterface = new ArrayList();
        k = 0;
        i = 0;
        if (paramQQAppInterface.size() > 0)
        {
          j = 0;
          k = i;
          if (j < paramQQAppInterface.size())
          {
            localObject3 = (RecentEmotionData)paramQQAppInterface.get(j);
            if (((ArrayList)localObject1).contains(((RecentEmotionData)localObject3).type + "," + ((RecentEmotionData)localObject3).emoIndex))
            {
              paramCharSequence.b((Entity)localObject3);
              paramQQAppInterface.remove(localObject3);
              j -= 1;
              break label985;
            }
            if (((RecentEmotionData)localObject3).emoId <= i) {
              break label979;
            }
            i = ((RecentEmotionData)localObject3).emoId;
            break label985;
          }
        }
        i = 0;
        localObject1 = new ArrayList();
        j = 0;
        if (j < 100)
        {
          int m = localArrayList.size() - 1 - j;
          if (m >= 0)
          {
            ((List)localObject1).add((RecentEmotionData)localArrayList.get(m));
            i += 1;
            break label994;
          }
        }
        else
        {
          j = paramQQAppInterface.size() + i - 100;
          if (j > 0)
          {
            i = 0;
            if (i < paramQQAppInterface.size())
            {
              if (i >= j) {
                break label1003;
              }
              paramCharSequence.b((RecentEmotionData)paramQQAppInterface.get(i));
              break label1003;
            }
          }
          i = ((List)localObject1).size() - 1;
          if (i >= 0)
          {
            paramQQAppInterface = (RecentEmotionData)((List)localObject1).get(i);
            k += 1;
            paramQQAppInterface.emoId = k;
            paramCharSequence.a(paramQQAppInterface);
            i -= 1;
            continue;
          }
          ((EntityTransaction)localObject2).c();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "add Recent Emoticon error", paramQQAppInterface);
        }
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " decodeToSaveEmoIndex end currenttime:" + System.currentTimeMillis());
        }
        ((EntityTransaction)localObject2).b();
        paramCharSequence.a();
      }
      break label994;
      label979:
      break label985;
      label982:
      continue;
      label985:
      j += 1;
      continue;
      label994:
      j += 1;
      continue;
      label1003:
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    if (a((List)localObject, 3, 0, paramString) < 0) {
      b(paramQQAppInterface, localEntityManager, 3, 0, paramString, (List)localObject);
    }
    localEntityManager.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramString = new krx(paramMessageForPtt, paramQQAppInterface, paramString, paramInt1, paramInt2);
    if (paramBoolean)
    {
      paramString.run();
      return;
    }
    paramQQAppInterface.a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList)
  {
    paramQQAppInterface.a().a().a(paramString, paramArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    Object localObject = "";
    if (paramString != null) {
      localObject = MessageUtils.a(paramString, true, null);
    }
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l1 = i;
    i = Math.abs(new Random().nextInt());
    int j = (int)MessageCache.a();
    String str = paramQQAppInterface.a();
    long l2 = MessageUtils.a(i);
    paramString = (ChatMessage)MessageRecordFactory.a(64536);
    paramString.init(str, "", str, (String)localObject, j, 64536, 0, l1);
    paramString.isread = true;
    paramString.msgUid = l2;
    paramString.shmsgseq = MessageUtils.a(l1, 0);
    paramString.issend = 1;
    localObject = (SVIPHandler)paramQQAppInterface.a(13);
    i = ((SVIPHandler)localObject).g();
    paramString.vipBubbleID = SVIPHandler.a(((SVIPHandler)localObject).e(), i);
    paramString.vipBubbleDiyTextId = i;
    ((MessageForText)paramString).msgVia = 0;
    paramQQAppInterface.a().a(paramQQAppInterface, paramString, paramArrayList, paramHongbaoParams);
  }
  
  public static void a(RecentEmotionData paramRecentEmotionData, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    paramRecentEmotionData.uin = paramString1;
    paramRecentEmotionData.emoId = paramInt1;
    paramRecentEmotionData.type = paramInt2;
    paramRecentEmotionData.emoIndex = paramInt3;
    paramRecentEmotionData.emoPath = paramString2;
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt)
  {
    if ((!AppSetting.o) && (paramInt == 0)) {
      return;
    }
    paramQQCustomMenu.a(2131305401, paramContext.getString(2131367892));
  }
  
  public static void a(List paramList)
  {
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (!((ChatMessage)paramList.get(0)).isLongMsg()) {
        break label120;
      }
      Iterator localIterator = paramList.iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)localIterator.next();
      } while ((localChatMessage.shmsgseq != jdField_a_of_type_ComTencentMobileqqDataChatMessage.shmsgseq) || (localChatMessage.msgUid != jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgUid));
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (((i != 0) || (paramList.contains(jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && (jdField_a_of_type_ComTencentWidgetActionSheet != null)) {
        jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForLongMsg paramMessageForLongMsg)
  {
    paramContext = paramMessageForLongMsg.longMsgFragmentList;
    if ((paramContext == null) || (paramContext.isEmpty())) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramMessageForLongMsg = (MessageRecord)paramContext.next();
      if (paramMessageForLongMsg.extraflag == 32768)
      {
        if (paramMessageForLongMsg.isSendFromLocal()) {
          paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
        }
        paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForLongMsg.uniseq);
        if (paramMessageForLongMsg.msgtype == 64536)
        {
          paramMessageForLongMsg = MessageRecordFactory.a(paramMessageForLongMsg);
          paramQQAppInterface.a().a(paramMessageForLongMsg, null, true);
        }
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    paramQQAppInterface.a().a(paramSessionInfo, null);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    ThreadManager.a(new kse(paramQQAppInterface, paramEmoticon), 8, null, true);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static boolean a(RecentEmotionData paramRecentEmotionData, int paramInt1, int paramInt2, String paramString)
  {
    if (paramRecentEmotionData == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (paramRecentEmotionData.type != paramInt1);
        if ((paramInt1 == 3) && (paramString != null) && (paramString.equalsIgnoreCase(paramRecentEmotionData.emoPath))) {
          return true;
        }
      } while (paramRecentEmotionData.emoIndex != paramInt2);
      if ((paramRecentEmotionData.emoPath == null) && (paramString == null)) {
        return true;
      }
    } while ((paramRecentEmotionData.emoPath == null) || (paramString == null) || (!paramRecentEmotionData.emoPath.equalsIgnoreCase(paramString)));
    return true;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramSendMsgParams == null) || (paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramContext = a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramSendMsgParams);
      ThreadManager.a(new ksk(paramSendMsgParams, paramQQAppInterface, paramSessionInfo, paramString), 8, null, true);
      paramQQAppInterface = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramContext;
  }
  
  /* Error */
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList paramArrayList, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    // Byte code:
    //   0: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc -47
    //   8: iconst_2
    //   9: new 211	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 2353
    //   19: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   25: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_2
    //   35: aload_3
    //   36: invokestatic 2355	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Ljava/lang/String;Ljava/util/ArrayList;)Ljava/lang/String;
    //   39: astore 12
    //   41: aload 12
    //   43: ifnonnull +5 -> 48
    //   46: aconst_null
    //   47: areturn
    //   48: new 524	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 525	java/util/ArrayList:<init>	()V
    //   55: astore 10
    //   57: iconst_0
    //   58: istore 18
    //   60: iconst_0
    //   61: istore 15
    //   63: iconst_0
    //   64: istore 8
    //   66: iconst_0
    //   67: istore 7
    //   69: new 2085	java/util/Random
    //   72: dup
    //   73: invokespecial 2086	java/util/Random:<init>	()V
    //   76: astore 11
    //   78: aload_0
    //   79: invokestatic 357	com/tencent/mobileqq/multimsg/LongTextMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   82: ifeq +381 -> 463
    //   85: aload 4
    //   87: getfield 298	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   90: ifnonnull +373 -> 463
    //   93: aload_0
    //   94: aload_1
    //   95: getfield 101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   98: aload_1
    //   99: getfield 110	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokestatic 2358	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)Z
    //   105: ifeq +358 -> 463
    //   108: aload 12
    //   110: ldc_w 2360
    //   113: invokevirtual 2362	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   116: arraylength
    //   117: sipush 560
    //   120: if_icmple +343 -> 463
    //   123: new 524	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 525	java/util/ArrayList:<init>	()V
    //   130: astore_2
    //   131: iload 8
    //   133: istore 6
    //   135: iload 18
    //   137: istore 17
    //   139: aload_2
    //   140: astore 9
    //   142: aload_2
    //   143: aload 12
    //   145: invokevirtual 1155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: iload 8
    //   151: istore 6
    //   153: iload 18
    //   155: istore 17
    //   157: aload_2
    //   158: astore 9
    //   160: aload 10
    //   162: aload_3
    //   163: invokevirtual 1155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: iload 8
    //   169: istore 6
    //   171: iload 18
    //   173: istore 17
    //   175: aload_2
    //   176: astore 9
    //   178: aload 4
    //   180: iconst_1
    //   181: putfield 346	com/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams:e	Z
    //   184: iload 7
    //   186: istore 5
    //   188: iload 15
    //   190: istore 16
    //   192: aload_2
    //   193: astore_3
    //   194: iload 8
    //   196: istore 6
    //   198: iload 18
    //   200: istore 17
    //   202: aload_2
    //   203: astore 9
    //   205: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +84 -> 292
    //   211: iload 8
    //   213: istore 6
    //   215: iload 18
    //   217: istore 17
    //   219: aload_2
    //   220: astore 9
    //   222: ldc -47
    //   224: iconst_2
    //   225: new 211	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 2364
    //   235: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 10
    //   240: invokevirtual 2365	java/util/ArrayList:size	()I
    //   243: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: ldc_w 2367
    //   249: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 12
    //   254: ldc_w 2360
    //   257: invokevirtual 2362	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   260: arraylength
    //   261: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: ldc_w 2369
    //   267: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   273: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   276: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_2
    //   283: astore_3
    //   284: iload 15
    //   286: istore 16
    //   288: iload 7
    //   290: istore 5
    //   292: aload_3
    //   293: astore_2
    //   294: iload 16
    //   296: istore 15
    //   298: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +31 -> 332
    //   304: ldc -47
    //   306: iconst_2
    //   307: new 211	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 2371
    //   317: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   323: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   326: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload 11
    //   334: invokevirtual 2089	java/util/Random:nextInt	()I
    //   337: invokestatic 2094	java/lang/Math:abs	(I)I
    //   340: istore 14
    //   342: aload_2
    //   343: invokevirtual 2365	java/util/ArrayList:size	()I
    //   346: newarray <illegal type>
    //   348: astore 9
    //   350: iconst_0
    //   351: istore 13
    //   353: iload 13
    //   355: aload_2
    //   356: invokevirtual 2365	java/util/ArrayList:size	()I
    //   359: if_icmpge +434 -> 793
    //   362: aload_2
    //   363: iload 13
    //   365: invokevirtual 2372	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   368: checkcast 529	java/lang/String
    //   371: astore 12
    //   373: aload 10
    //   375: invokevirtual 2365	java/util/ArrayList:size	()I
    //   378: iload 13
    //   380: if_icmple +408 -> 788
    //   383: aload 10
    //   385: iload 13
    //   387: invokevirtual 2372	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   390: checkcast 524	java/util/ArrayList
    //   393: astore_3
    //   394: aload_1
    //   395: getfield 101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   398: sipush 3000
    //   401: if_icmpeq +11 -> 412
    //   404: aload_1
    //   405: getfield 101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   408: iconst_1
    //   409: if_icmpne +13 -> 422
    //   412: aload 11
    //   414: invokevirtual 2089	java/util/Random:nextInt	()I
    //   417: invokestatic 2094	java/lang/Math:abs	(I)I
    //   420: istore 14
    //   422: aload 9
    //   424: iload 13
    //   426: aload_0
    //   427: aload_1
    //   428: aload 12
    //   430: sipush 64536
    //   433: iload 15
    //   435: aload_2
    //   436: invokevirtual 2365	java/util/ArrayList:size	()I
    //   439: i2b
    //   440: iload 13
    //   442: i2b
    //   443: iload 5
    //   445: iload 14
    //   447: aload_3
    //   448: aload 4
    //   450: invokestatic 2096	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;IZBBSILjava/util/ArrayList;Lcom/tencent/mobileqq/activity/ChatActivityFacade$SendMsgParams;)J
    //   453: lastore
    //   454: iload 13
    //   456: iconst_1
    //   457: iadd
    //   458: istore 13
    //   460: goto -107 -> 353
    //   463: aload 12
    //   465: sipush 560
    //   468: bipush 20
    //   470: aload_3
    //   471: aload 10
    //   473: invokestatic 2375	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;IILjava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   476: astore_2
    //   477: iload 8
    //   479: istore 6
    //   481: iload 18
    //   483: istore 17
    //   485: aload_2
    //   486: astore 9
    //   488: aload_2
    //   489: invokevirtual 2365	java/util/ArrayList:size	()I
    //   492: iconst_1
    //   493: if_icmple +264 -> 757
    //   496: iconst_1
    //   497: istore 15
    //   499: iload 8
    //   501: istore 6
    //   503: iload 15
    //   505: istore 17
    //   507: aload_2
    //   508: astore 9
    //   510: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +80 -> 593
    //   516: iload 8
    //   518: istore 6
    //   520: iload 15
    //   522: istore 17
    //   524: aload_2
    //   525: astore 9
    //   527: ldc -47
    //   529: iconst_2
    //   530: new 211	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 2364
    //   540: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 10
    //   545: invokevirtual 2365	java/util/ArrayList:size	()I
    //   548: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: ldc_w 2377
    //   554: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_2
    //   558: invokevirtual 2365	java/util/ArrayList:size	()I
    //   561: invokevirtual 233	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: ldc_w 2379
    //   567: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: iload 15
    //   572: invokevirtual 2382	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   575: ldc_w 2369
    //   578: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   584: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   587: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: iload 7
    //   595: istore 5
    //   597: iload 15
    //   599: istore 16
    //   601: aload_2
    //   602: astore_3
    //   603: iload 15
    //   605: ifeq -313 -> 292
    //   608: iload 8
    //   610: istore 6
    //   612: iload 15
    //   614: istore 17
    //   616: aload_2
    //   617: astore 9
    //   619: getstatic 130	com/tencent/mobileqq/service/MobileQQService:c	I
    //   622: istore 13
    //   624: iload 8
    //   626: istore 6
    //   628: iload 15
    //   630: istore 17
    //   632: aload_2
    //   633: astore 9
    //   635: iload 13
    //   637: iconst_1
    //   638: iadd
    //   639: putstatic 130	com/tencent/mobileqq/service/MobileQQService:c	I
    //   642: iload 13
    //   644: i2b
    //   645: i2s
    //   646: istore 5
    //   648: iconst_0
    //   649: istore 13
    //   651: aload_0
    //   652: invokevirtual 1977	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   655: aload_0
    //   656: invokevirtual 1084	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   659: aload_1
    //   660: getfield 101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   663: iload 5
    //   665: invokevirtual 2385	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;II)Z
    //   668: ifeq +178 -> 846
    //   671: iload 13
    //   673: bipush 10
    //   675: if_icmple +88 -> 763
    //   678: aload_0
    //   679: invokevirtual 1977	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   682: aload_0
    //   683: invokevirtual 1084	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   686: aload_1
    //   687: getfield 101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   690: invokevirtual 2387	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;I)I
    //   693: istore 13
    //   695: iload 13
    //   697: i2b
    //   698: i2s
    //   699: istore 5
    //   701: iload 5
    //   703: istore 6
    //   705: iload 15
    //   707: istore 17
    //   709: aload_2
    //   710: astore 9
    //   712: aload_0
    //   713: invokevirtual 1977	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   716: aload_0
    //   717: invokevirtual 1084	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   720: aload_1
    //   721: getfield 101	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   724: iload 5
    //   726: invokevirtual 2390	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;II)V
    //   729: iload 15
    //   731: istore 16
    //   733: aload_2
    //   734: astore_3
    //   735: goto -443 -> 292
    //   738: astore_3
    //   739: iload 6
    //   741: istore 5
    //   743: iload 17
    //   745: istore 15
    //   747: aload 9
    //   749: astore_2
    //   750: aload_3
    //   751: invokevirtual 2391	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   754: goto -456 -> 298
    //   757: iconst_0
    //   758: istore 15
    //   760: goto -261 -> 499
    //   763: aload 11
    //   765: invokevirtual 2089	java/util/Random:nextInt	()I
    //   768: invokestatic 2094	java/lang/Math:abs	(I)I
    //   771: istore 14
    //   773: iload 14
    //   775: i2b
    //   776: i2s
    //   777: istore 5
    //   779: iload 13
    //   781: iconst_1
    //   782: iadd
    //   783: istore 13
    //   785: goto -134 -> 651
    //   788: aconst_null
    //   789: astore_3
    //   790: goto -396 -> 394
    //   793: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   796: ifeq +31 -> 827
    //   799: ldc -47
    //   801: iconst_2
    //   802: new 211	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   809: ldc_w 2393
    //   812: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   818: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   821: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   827: aload 9
    //   829: areturn
    //   830: astore_3
    //   831: iconst_0
    //   832: istore 5
    //   834: iconst_0
    //   835: istore 15
    //   837: aconst_null
    //   838: astore_2
    //   839: goto -89 -> 750
    //   842: astore_3
    //   843: goto -93 -> 750
    //   846: goto -145 -> 701
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	849	0	paramQQAppInterface	QQAppInterface
    //   0	849	1	paramSessionInfo	SessionInfo
    //   0	849	2	paramString	String
    //   0	849	3	paramArrayList	ArrayList
    //   0	849	4	paramSendMsgParams	ChatActivityFacade.SendMsgParams
    //   186	647	5	s1	short
    //   133	607	6	s2	short
    //   67	527	7	s3	short
    //   64	561	8	s4	short
    //   140	688	9	localObject	Object
    //   55	489	10	localArrayList	ArrayList
    //   76	688	11	localRandom	Random
    //   39	425	12	str	String
    //   351	433	13	i	int
    //   340	434	14	j	int
    //   61	775	15	bool1	boolean
    //   190	542	16	bool2	boolean
    //   137	607	17	bool3	boolean
    //   58	424	18	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   142	149	738	java/io/UnsupportedEncodingException
    //   160	167	738	java/io/UnsupportedEncodingException
    //   178	184	738	java/io/UnsupportedEncodingException
    //   205	211	738	java/io/UnsupportedEncodingException
    //   222	282	738	java/io/UnsupportedEncodingException
    //   488	496	738	java/io/UnsupportedEncodingException
    //   510	516	738	java/io/UnsupportedEncodingException
    //   527	593	738	java/io/UnsupportedEncodingException
    //   619	624	738	java/io/UnsupportedEncodingException
    //   635	642	738	java/io/UnsupportedEncodingException
    //   712	729	738	java/io/UnsupportedEncodingException
    //   78	131	830	java/io/UnsupportedEncodingException
    //   463	477	830	java/io/UnsupportedEncodingException
    //   651	671	842	java/io/UnsupportedEncodingException
    //   678	695	842	java/io/UnsupportedEncodingException
    //   763	773	842	java/io/UnsupportedEncodingException
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = new kry(paramContext, paramChatMessage, paramQQAppInterface);
    paramChatMessage = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramChatMessage.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramChatMessage.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (!PokeItemHelper.a(paramQQAppInterface, paramSessionInfo)) {
      if (jdField_a_of_type_AndroidWidgetToast == null) {
        QQToast.a(paramContext, 2131372549, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      }
    }
    do
    {
      return;
      jdField_a_of_type_AndroidWidgetToast.cancel();
      jdField_a_of_type_AndroidWidgetToast.show();
      return;
      paramContext = new MessageForPoke();
      paramContext.msgtype = 60524;
      paramContext.isPlayed = false;
      MessageRecordFactory.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      paramContext.initMsg(paramQQAppInterface);
      paramQQAppInterface.a().a(paramContext, null);
    } while (!QLog.isColorLevel());
    QLog.d("PokeMsg", 2, "sendPokeMsg");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = MessageRecordFactory.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, new ChatActivityFacade.SendMsgParams());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    ExtensionInfo localExtensionInfo;
    RichStatus localRichStatus;
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      localExtensionInfo = ((FriendsManager)paramQQAppInterface.getManager(50)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (localExtensionInfo == null) {
        break label812;
      }
      localRichStatus = localExtensionInfo.getRichStatus();
      if (localExtensionInfo.richTime != 0L) {
        break label59;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOSign", 2, "richTime is 0,do not insert this sign msg");
      }
    }
    return;
    label59:
    if (QLog.isColorLevel()) {
      QLog.d("AIOSign", 2, "richTime is:" + localExtensionInfo.richTime);
    }
    long l = NetConnInfoCenter.getServerTime() - localExtensionInfo.richTime;
    Object localObject1;
    if ((l <= 1296000L) && (l >= 0L)) {
      localObject1 = new JSONObject();
    }
    for (;;)
    {
      int i;
      try
      {
        ((JSONObject)localObject1).put("ver", "1.0");
        ((JSONObject)localObject1).put("time", String.valueOf(localExtensionInfo.richTime));
        if ((localRichStatus.actionText != null) && (localRichStatus.actionText.trim().length() > 0))
        {
          ((JSONObject)localObject1).put("aid", String.valueOf(localRichStatus.actionId));
          ((JSONObject)localObject1).put("actiontext", localRichStatus.actionText);
        }
        if ((localRichStatus.dataText != null) && (localRichStatus.dataText.trim().length() > 0))
        {
          ((JSONObject)localObject1).put("did", String.valueOf(localRichStatus.dataId));
          ((JSONObject)localObject1).put("datatext", localRichStatus.dataText);
        }
        ((JSONObject)localObject1).put("loctextpos", String.valueOf(localRichStatus.locationPosition));
        if ((localRichStatus.plainText != null) && (localRichStatus.plainText.size() > 0))
        {
          int j = localRichStatus.plainText.size();
          localObject2 = new JSONArray();
          i = 0;
          if (i < j)
          {
            String str = (String)localRichStatus.plainText.get(i);
            if (str == null) {
              break label849;
            }
            ((JSONArray)localObject2).put(str);
            break label849;
          }
          if (((JSONArray)localObject2).length() > 0) {
            ((JSONObject)localObject1).put("plaintext", localObject2);
          }
        }
        if ((localRichStatus.locationText != null) && (localRichStatus.locationText.trim().length() > 0)) {
          ((JSONObject)localObject1).put("loctext", localRichStatus.locationText);
        }
        if (((JSONObject)localObject1).length() > 3) {
          break label523;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sign is empty,rs.actionText is:" + localRichStatus.actionText + ",rs.dataText is:" + localRichStatus.dataText + ",rs.plainText is:" + localRichStatus.plainText + ",rs.locationText is:" + localRichStatus.locationText);
        return;
      }
      catch (JSONException paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "insertSignMsgIfNeeded failed,error msg is:" + paramQQAppInterface.getMessage(), paramQQAppInterface);
      return;
      label523:
      localObject1 = ((JSONObject)localObject1).toString();
      Object localObject2 = MessageRecordFactory.a(64502);
      ((MessageRecord)localObject2).init(paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, localExtensionInfo.richTime, 64502, paramSessionInfo.jdField_a_of_type_Int, localExtensionInfo.richTime);
      ((MessageRecord)localObject2).isread = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "----------addFriendFeedMsg  friendUin: " + paramSessionInfo.jdField_a_of_type_JavaLangString + " msgTime: " + ((MessageRecord)localObject2).time);
      }
      if (!MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject2, false)) {
        paramQQAppInterface.a().a((MessageRecord)localObject2, ((MessageRecord)localObject2).selfuin);
      }
      paramQQAppInterface.a().e(paramSessionInfo.jdField_a_of_type_JavaLangString, localExtensionInfo.richTime);
      if ((localRichStatus.actionText != null) && (localRichStatus.actionText.trim().length() > 0)) {}
      for (paramSessionInfo = String.valueOf(localRichStatus.actionId);; paramSessionInfo = "normalsign")
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Rich_status", "card_exposure_aio", 0, 0, "", "", paramSessionInfo, "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, "", "", "", "");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOSign", 2, "intervalTime is:" + l / 86400000L + ",do not insert this sign msg");
      return;
      label812:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AIOSign", 2, "f is null,insert sign msg failed,curFriendUin is:" + paramSessionInfo.jdField_a_of_type_JavaLangString);
      return;
      label849:
      i += 1;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIONewestFeedRsp paramAIONewestFeedRsp)
  {
    if ((paramAIONewestFeedRsp.uOpuin != Long.valueOf(paramQQAppInterface.a()).longValue()) || (paramAIONewestFeedRsp.uFeedInfos == null) || (paramAIONewestFeedRsp.uFeedInfos.isEmpty())) {}
    do
    {
      do
      {
        return;
        paramAIONewestFeedRsp = (NewestFeedInfo)paramAIONewestFeedRsp.uFeedInfos.get(0);
      } while (paramAIONewestFeedRsp == null);
      localObject = a(paramAIONewestFeedRsp);
    } while (localObject == null);
    Object localObject = ((JSONObject)localObject).toString();
    ThreadManager.b().post(new ksg(paramQQAppInterface, paramSessionInfo, paramAIONewestFeedRsp, (String)localObject));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localFileManagerEntity = paramQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.getCloudType() != 0) {
          break label141;
        }
        paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        paramQQAppInterface.a().b(localFileManagerEntity);
        if ((localFileManagerEntity.bDelInAio) && (localFileManagerEntity.bDelInFM) && (localFileManagerEntity.getCloudType() == 0)) {
          paramQQAppInterface.a().d(localFileManagerEntity.nSessionId);
        }
      }
    }
    label141:
    do
    {
      return;
      paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      break;
      if ((paramChatMessage instanceof MessageForDevShortVideo))
      {
        ((DeviceFileHandler)paramQQAppInterface.a(50)).a(0, ((MessageForDevShortVideo)paramChatMessage).fileSessionId, false);
        return;
      }
    } while (!(paramChatMessage instanceof MessageForDevPtt));
    ((DeviceFileHandler)paramQQAppInterface.a(50)).a(0, ((MessageForDevPtt)paramChatMessage).fileSessionId, false);
  }
  
  public static void b(List paramList)
  {
    if ((jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (paramList.size() > 0) && (jdField_a_of_type_JavaUtilList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage1 = (ChatMessage)paramList.next();
        if (jdField_a_of_type_JavaUtilList.contains(localChatMessage1))
        {
          jdField_a_of_type_JavaUtilList.remove(localChatMessage1);
        }
        else if (localChatMessage1.isLongMsg())
        {
          Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
            if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
              localIterator.remove();
            }
          }
        }
      }
      if ((jdField_a_of_type_JavaUtilList.size() == 0) && (b != null)) {
        b.dismiss();
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { 64502 });
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramSessionInfo = (MessageRecord)paramQQAppInterface.next();
        if (NetConnInfoCenter.getServerTime() - paramSessionInfo.time < 604800L) {
          return false;
        }
      }
    }
    return true;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, int paramInt1, int paramInt2, String paramString, List paramList)
  {
    int i = 0;
    if (paramList.size() == 0)
    {
      localRecentEmotionData = new RecentEmotionData();
      a(localRecentEmotionData, paramQQAppInterface.a(), 0, paramInt1, paramInt2, paramString);
      paramEntityManager.a(localRecentEmotionData);
      paramList.add(localRecentEmotionData);
      return true;
    }
    int j = paramList.size();
    if (j == 100)
    {
      while (i < j - 1)
      {
        paramQQAppInterface = (RecentEmotionData)paramList.get(i);
        paramQQAppInterface.type = ((RecentEmotionData)paramList.get(i + 1)).type;
        paramQQAppInterface.emoIndex = ((RecentEmotionData)paramList.get(i + 1)).emoIndex;
        paramQQAppInterface.emoPath = ((RecentEmotionData)paramList.get(i + 1)).emoPath;
        paramEntityManager.a(paramQQAppInterface);
        i += 1;
      }
      paramQQAppInterface = (RecentEmotionData)paramList.get(j - 1);
      a(paramQQAppInterface, paramQQAppInterface.uin, paramQQAppInterface.emoId, paramInt1, paramInt2, paramString);
      paramEntityManager.a(paramQQAppInterface);
      paramList.add(paramQQAppInterface);
      return true;
    }
    RecentEmotionData localRecentEmotionData = new RecentEmotionData();
    a(localRecentEmotionData, paramQQAppInterface.a(), j, paramInt1, paramInt2, paramString);
    paramEntityManager.b(localRecentEmotionData);
    paramList.add(localRecentEmotionData);
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = MessageRecordFactory.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "resendApolloMessage : mr is null.");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(61531);
    long l = MessageCache.a();
    localMessageRecord.init(paramQQAppInterface.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131368000), l, 61531, paramSessionInfo.jdField_a_of_type_Int, l);
    localMessageRecord.isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1 = new EventItem(18, null);
    ((EventItem)localObject1).eventType = 538052865;
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((EventItem)localObject1).writeTo((JceOutputStream)localObject2);
    localObject1 = new String(((JceOutputStream)localObject2).toByteArray());
    localObject2 = paramQQAppInterface.a();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramQQAppInterface = paramQQAppInterface.b();
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatActivityFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */