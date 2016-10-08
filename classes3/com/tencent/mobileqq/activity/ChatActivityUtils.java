package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.VideoController;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GVideoUpdateUtil;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.av.utils.UITools;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.game.LauchGameAppListHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.qcall.LightalkShieldHandler;
import com.tencent.mobileqq.qcall.LightalkShieldManager;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.ChatBackgroundMarketActivity;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kso;
import ksp;
import ksq;
import ksr;
import kss;
import kst;
import ksu;
import ksv;
import ksw;
import ksx;
import ksy;
import ksz;
import kta;
import ktb;
import ktc;
import ktd;
import kte;
import ktf;
import ktg;
import kth;
import kti;
import ktj;
import ktk;
import ktl;
import ktm;
import ktn;
import kto;
import ktp;
import ktq;
import ktr;
import kts;
import ktt;
import ktu;
import ktv;
import ktw;
import ktx;
import kty;
import ktz;
import kua;
import kub;
import kuc;
import kud;
import kue;
import kug;
import kuh;
import kui;
import kuj;
import kuk;
import kul;
import kum;
import kun;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityUtils
{
  public static final long a = 55901189L;
  private static ChatActivityUtils.AddFriendSpan jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan;
  static QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private static QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public static QQToastNotifier a;
  public static final String a = "ChatActivityUtils";
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final long b = 2274034950L;
  public static final String b = "http://m.qzone.com";
  public static final long c = 2223703302L;
  public static final String c = "http://mobile.qzone.qq.com";
  public static final long d = 274201605L;
  public static final String d = "http://gamecenter.qq.com";
  public static final long e = 440495416L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static View a(Context paramContext, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = LayoutInflater.from(paramContext).inflate(2130903194, null);
    View localView = paramContext.findViewById(2131297631);
    TextView localTextView = (TextView)paramContext.findViewById(2131297630);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131297632);
    if (paramString != null) {
      localTextView.setText(paramString);
    }
    localImageView.setOnClickListener(paramOnClickListener2);
    localView.setOnClickListener(paramOnClickListener1);
    return paramContext;
  }
  
  public static Toast a(Context paramContext, String paramString)
  {
    Toast localToast = new Toast(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2130903088, null);
    localToast.setView(localView);
    localToast.setGravity(55, 0, paramContext.getResources().getDimensionPixelSize(2131492908));
    localToast.setDuration(1);
    ((TextView)localView.findViewById(2131297032)).setText(paramString);
    localView.setOnClickListener(new kug(localToast));
    return localToast;
  }
  
  private static MessageRecord a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    int i = paramMessageRecord.msgtype;
    MessageRecord localMessageRecord;
    if ((i == 64533) || (i == 64505) || (i == 64504) || (i == 62535)) {
      localMessageRecord = null;
    }
    do
    {
      return localMessageRecord;
      localMessageRecord = paramMessageRecord;
    } while (!((FriendsManager)paramQQAppInterface.getManager(50)).b(paramMessageRecord.frienduin));
    return null;
  }
  
  public static MessageRecord a(List paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.jdField_a_of_type_Int)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int i = paramList.size() - 1;
    label61:
    if (i >= 0)
    {
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if ((paramSessionInfo.isSend()) || (MsgProxyUtils.g(paramSessionInfo.msgtype))) {}
    }
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i -= 1;
      break label61;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramMessageRecord != null)
    {
      localObject1 = paramMessageRecord.senderuin;
      String str = paramMessageRecord.frienduin;
      i = paramMessageRecord.istroop;
      if ((paramMessageRecord.isSend()) || (MessageUtils.a(paramMessageRecord.msgtype))) {
        break label433;
      }
      if (1000 == i)
      {
        paramQQAppInterface = ContactUtils.m(paramQQAppInterface, (String)localObject1);
        localObject1 = String.format(paramContext.getString(2131370064), new Object[] { paramSessionInfo.d, paramQQAppInterface });
        a(paramSessionInfo, paramMessageRecord);
      }
    }
    else
    {
      return (CharSequence)localObject1;
    }
    if (1020 == i)
    {
      paramQQAppInterface = ((HotChatManager)paramQQAppInterface.getManager(59)).c(paramMessageRecord.senderuin);
      if (paramQQAppInterface == null) {
        break label538;
      }
      paramQQAppInterface = paramQQAppInterface.name;
    }
    label433:
    label538:
    for (paramQQAppInterface = String.format(paramContext.getString(2131370065), new Object[] { paramSessionInfo.d, paramQQAppInterface });; paramQQAppInterface = null)
    {
      return paramQQAppInterface;
      if (1004 == i)
      {
        paramQQAppInterface = ContactUtils.b(paramQQAppInterface, (String)localObject1, 3000);
        paramQQAppInterface = String.format(paramContext.getString(2131370066), new Object[] { paramSessionInfo.d, paramQQAppInterface });
        a(paramSessionInfo, paramMessageRecord);
        return paramQQAppInterface;
      }
      if (1001 == i) {
        return String.format(paramContext.getString(2131370067), new Object[] { paramSessionInfo.d });
      }
      if (1006 == i) {
        return String.format(paramContext.getString(2131370068), new Object[] { paramSessionInfo.d });
      }
      if (1009 == i) {
        return String.format(paramContext.getString(2131370070), new Object[] { paramSessionInfo.d });
      }
      if (1005 == i) {
        return String.format(paramContext.getString(2131370071), new Object[] { paramSessionInfo.d });
      }
      if (1021 == i) {
        return String.format(paramContext.getString(2131370072), new Object[] { paramSessionInfo.d });
      }
      if (1022 == i) {
        return String.format(paramContext.getString(2131370073), new Object[] { paramSessionInfo.d });
      }
      if (1023 == i) {
        return String.format(paramContext.getString(2131370074), new Object[] { paramSessionInfo.d });
      }
      localObject1 = localObject2;
      if (1010 != i) {
        break;
      }
      return paramQQAppInterface.a().a(paramSessionInfo.d);
      localObject1 = localObject2;
      if (1006 != i) {
        break;
      }
      paramSessionInfo = String.format(paramContext.getString(2131370069), new Object[] { paramSessionInfo.d });
      paramQQAppInterface = paramContext.getString(2131370075);
      if (jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan == null) {
        jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan = new ChatActivityUtils.AddFriendSpan(paramQQAppInterface, paramContext.getResources().getColor(2131427490));
      }
      i = paramSessionInfo.lastIndexOf(paramQQAppInterface);
      paramContext = new SpannableStringBuilder(paramSessionInfo);
      paramContext.setSpan(jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan, i, paramQQAppInterface.length() + i, 33);
      return paramContext;
    }
  }
  
  public static Integer a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      return null;
    }
    return (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1 + paramString2);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 1000: 
      return "2";
    }
    return "3";
  }
  
  public static final String a(Activity paramActivity)
  {
    return paramActivity.getClass().getName() + "_" + paramActivity.hashCode();
  }
  
  public static String a(Context paramContext)
  {
    String str = paramContext.getString(2131367860);
    switch (paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      return str;
    case 1: 
      return paramContext.getString(2131367861);
    case 2: 
      return paramContext.getString(2131367862);
    }
    return paramContext.getString(2131367863);
  }
  
  public static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
      if (paramQQAppInterface == null) {
        return paramContext.getString(2131370078);
      }
      if (TextUtils.isEmpty(paramQQAppInterface.troopname)) {
        return paramContext.getString(2131370078);
      }
      paramQQAppInterface = String.format(paramContext.getString(2131370079), new Object[] { paramQQAppInterface.troopname });
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return paramContext.getString(2131370078);
  }
  
  public static String a(Context paramContext, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null) {
      localObject1 = localObject2;
    }
    switch (paramMessageRecord.istroop)
    {
    default: 
      localObject1 = localObject2;
    case 1002: 
    case 1003: 
    case 1007: 
    case 1008: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1018: 
    case 1019: 
    case 1000: 
    case 1020: 
      AppRuntime localAppRuntime;
      do
      {
        do
        {
          do
          {
            return (String)localObject1;
            try
            {
              paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
              paramMessageRecord = paramQQAppInterface.a(paramQQAppInterface.c(paramMessageRecord.senderuin));
              if (paramMessageRecord == null)
              {
                paramMessageRecord = paramContext.getString(2131370078);
                paramContext = paramMessageRecord;
              }
              else if (TextUtils.isEmpty(paramMessageRecord.troopname))
              {
                paramMessageRecord = paramContext.getString(2131370078);
                paramContext = paramMessageRecord;
              }
              else
              {
                paramMessageRecord = String.format(paramContext.getString(2131370079), new Object[] { paramMessageRecord.troopname });
                paramContext = paramMessageRecord;
              }
            }
            catch (Exception paramMessageRecord)
            {
              paramMessageRecord.printStackTrace();
              paramContext = paramContext.getString(2131370078);
              localObject1 = paramContext;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ChatActivityUtils", 2, "UIN_TYPE_OPEN_TROOP_MEMBER_STRANGER or UIN_TYPE_GROUP_MEMBER_STRANGER error");
          return paramContext;
          localAppRuntime = BaseApplicationImpl.a.a();
          localObject1 = localObject2;
        } while (localAppRuntime == null);
        localObject1 = localObject2;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localObject1 = (QQAppInterface)BaseApplicationImpl.a().a();
      if (paramQQAppInterface != null)
      {
        localObject1 = (HotChatManager)paramQQAppInterface.getManager(59);
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
        if (TextUtils.isEmpty(((HotChatManager)localObject1).a(paramMessageRecord.senderuin))) {
          break;
        }
      }
      break;
    }
    for (paramContext = paramContext.getString(2131370080);; paramContext = null)
    {
      return paramContext;
      return paramContext.getString(2131370081);
      return paramContext.getString(2131370082);
      return paramContext.getString(2131370083);
      return paramContext.getString(2131370084);
      return paramContext.getString(2131370085);
      return paramContext.getString(2131370086);
      return paramContext.getString(2131370087);
      return paramContext.getString(2131370088);
      return paramContext.getString(2131370089);
    }
    return paramContext;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(164);
    if (paramQQAppInterface.b(paramString, false)) {
      return paramQQAppInterface.a(paramContext, paramString);
    }
    return null;
  }
  
  static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = paramString.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString[i].trim());
        i += 1;
      }
      paramString = a(arrayOfByte, a(paramQQAppInterface.a() + "MasPlay", 32).getBytes("UTF-8"));
      paramQQAppInterface = (QQAppInterface)localObject;
      if (paramString != null) {
        paramQQAppInterface = new String(paramString, "UTF-8").replace("$", "");
      }
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface) {}
    return null;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    if (paramInt == 16) {
      return a(localMessageDigest.digest(paramString.getBytes("utf-8"))).substring(8, 24);
    }
    return a(localMessageDigest.digest(paramString.getBytes("utf-8")));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString2 = paramString2.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString2.length];
      int i = 0;
      while (i < paramString2.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString2[i].trim());
        i += 1;
      }
      paramString2 = a(arrayOfByte, a(paramString1 + "MasPlay", 32).getBytes("UTF-8"));
      paramString1 = (String)localObject;
      if (paramString2 != null) {
        paramString1 = new String(paramString2, "UTF-8").replace("$", "");
      }
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, a(paramString + "MasPlay", 32).getBytes("UTF-8"));
      paramString = (String)localObject;
      if (paramArrayOfByte != null) {
        paramString = new String(paramArrayOfByte, "UTF-8").replace("$", "");
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 16)
    {
      int k = paramArrayOfByte[i];
      int j = k;
      if (k < 0) {
        j = k + 256;
      }
      localStringBuffer.append(jdField_a_of_type_ArrayOfChar[(j >>> 4)]);
      localStringBuffer.append(jdField_a_of_type_ArrayOfChar[(j % 16)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492908));
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131368647);
        }
        jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      catch (Exception paramActivity) {}finally
      {
        if ((jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    int i = 3008;
    int k = 0;
    int j = k;
    FragmentActivity localFragmentActivity;
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    case 1002: 
    case 1003: 
    case 1007: 
    case 1008: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1018: 
    case 1019: 
    case 1020: 
    default: 
      i = 10004;
      j = k;
    case 1005: 
    case 1023: 
      if ((i == 3007) && (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))))
      {
        localFragmentActivity = (FragmentActivity)paramActivity;
        if (LBSHandler.a(localFragmentActivity.getChatFragment().a(), paramSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label361;
        }
        localFragmentActivity.getChatFragment().a().c(localFragmentActivity.getString(2131371566));
      }
      break;
    }
    label361:
    do
    {
      return;
      j = 2;
      i = 3007;
      break;
      i = 3013;
      j = k;
      break;
      i = 3006;
      j = k;
      break;
      i = 3004;
      j = 2;
      break;
      i = 3005;
      j = 2;
      break;
      i = 3003;
      j = 2;
      break;
      i = 3019;
      j = k;
      break;
      i = 3041;
      j = k;
      break;
      if ((i == 3019) && (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))))
      {
        localFragmentActivity = (FragmentActivity)paramActivity;
        if (!DatingUtil.a(localFragmentActivity.getChatFragment().a(), paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localFragmentActivity.getChatFragment().a().c(localFragmentActivity.getString(2131371566));
          return;
        }
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 1006) {
        break label418;
      }
    } while ((paramSessionInfo.jdField_a_of_type_JavaLangString == null) || (paramSessionInfo.jdField_a_of_type_JavaLangString.length() <= 0));
    paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i, j, paramSessionInfo.d, null, null, paramString, null));
    return;
    label418:
    if (paramBoolean)
    {
      paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.jdField_a_of_type_JavaLangString, null, i, j, paramSessionInfo.d, null, AddContactsActivity.class.getName(), paramString, null));
      return;
    }
    paramActivity.startActivityForResult(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i, j, paramSessionInfo.d, null, null, paramString, null), 11);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    
    if (paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      b(paramActivity, 2131368704, 1);
      return;
    }
    b(paramActivity, 2131368703, 1);
  }
  
  public static void a(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131367660));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramContext.getResources().getColor(2131427492), paramContext.getResources().getColor(2131427493)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    DialogUtil.a(paramContext, paramContext.getString(2131367659), localSpannableString, 0, 2131367974, null, null, new kui(paramContext)).show();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(paramContext);
    }
    jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt, paramContext.getResources().getDimensionPixelSize(2131492908), 0, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).b(paramContext.getResources().getDimensionPixelSize(2131492908));
  }
  
  public static void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, ChatBackgroundMarketActivity.class);
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    localIntent.putExtra("url", IndividuationUrlHelper.a(paramContext, "background", ""));
    String str = String.valueOf(33554432L);
    if (WebViewPluginFactory.a.containsKey(str)) {
      localIntent.putExtra("insertPluginsArray", new String[] { str });
    }
    localIntent.putExtra("business", 33554432L);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("chatbg_intent_frinedUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = paramQQAppInterface.a().a(AppShareIDUtil.a(paramLong));
    if ((localObject2 != null) && (QLog.isColorLevel())) {
      QLog.d("gameShareOnClick", 2, "<--gameShareOnClick appShareID.bundleid" + ((AppShareID)localObject2).bundleid);
    }
    if ((localObject2 != null) && (((AppShareID)localObject2).bundleid != null) && (PackageUtil.a(paramContext, ((AppShareID)localObject2).bundleid)))
    {
      long l = AppShareIDUtil.b(paramLong);
      Object localObject1 = paramQQAppInterface.a().a(String.valueOf(l));
      localObject2 = ((AppShareID)localObject2).bundleid;
      if (localObject1 == null)
      {
        localObject1 = null;
        PackageUtil.a(paramContext, (String)localObject2, (String)localObject1);
        if ((paramInt != 62531) && (paramInt != 62532) && ((paramString == null) || (!paramString.startsWith("http://gamecenter.qq.com")))) {
          break label205;
        }
      }
      label205:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Game_center", "Launch_game", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
        }
        return;
        localObject1 = ((OpenID)localObject1).openID;
        break;
      }
    }
    a(paramContext, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "appShareOnClick action:" + paramString + ",appShareId:" + paramLong + "mixType:" + paramInt);
    }
    String str = paramString.trim();
    if ((paramInt == 62531) || (paramInt == 62532) || (str.startsWith("http://gamecenter.qq.com")))
    {
      paramInt = 1;
      if (55901189L != paramLong) {
        break label180;
      }
      paramString = QZoneHelper.UserInfo.a();
      paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      paramString.jdField_b_of_type_JavaLangString = paramQQAppInterface.b();
      QZoneHelper.a((Activity)paramContext, paramString, str, "mqqChat", -1);
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label346;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
      return;
      paramInt = 0;
      break;
      label180:
      if ((!str.startsWith("http://m.qzone.com")) && (str.startsWith("http://mobile.qzone.qq.com"))) {}
      Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      paramString = HtmlOffline.a(str, "from=androidqq");
      if (paramInt != 0)
      {
        localIntent.putExtra("param_force_internal_browser", true);
        paramString = HtmlOffline.a(str, "platformId=qq_m");
      }
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("url", paramString.trim());
      localIntent.putExtra("isAppShare", true);
      localIntent.putExtra("appShareID", paramLong);
      paramString = paramString.toString();
      if (paramString.startsWith("http://browserApp.p.qq.com/"))
      {
        localIntent.putExtra("url", paramString);
        localIntent.setClass(paramContext, PublicAccountBrowser.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
      }
      paramContext.startActivity(localIntent);
    }
    label346:
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, "sha_click", 1, "", "", String.valueOf(AppShareIDUtil.b(paramLong)));
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo)
  {
    if ((paramIntent != null) && (paramSessionInfo != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("phonenum", paramSessionInfo.e);
      paramIntent.putExtra("uinname", paramSessionInfo.d);
    }
  }
  
  public static void a(SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramSessionInfo != null) && (paramIntent != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("uinname", paramSessionInfo.d);
      paramIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("phonenum", paramSessionInfo.e);
    }
  }
  
  private static void a(SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    if ((paramSessionInfo == null) || (paramMessageRecord == null)) {}
    while (paramSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) {
      return;
    }
    paramSessionInfo.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramSessionInfo.jdField_b_of_type_JavaLangString = paramMessageRecord.senderuin;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.e(BaseApplication.getContext())) {
      if (paramInt == 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (paramQQAppInterface == null) {}
      }
    }
    label353:
    label365:
    while ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      long l;
      do
      {
        do
        {
          do
          {
            try
            {
              l = Long.parseLong(paramString1);
              if (l > 0L)
              {
                if (!paramBoolean)
                {
                  paramBoolean = bool;
                  paramQQAppInterface.a(l, paramBoolean);
                }
              }
              else {
                return;
              }
            }
            catch (Exception paramActivity)
            {
              for (;;)
              {
                l = 0L;
                continue;
                paramBoolean = false;
              }
            }
            if (paramInt != 25) {
              break;
            }
          } while (!paramBoolean);
          paramActivity = (LightalkShieldHandler)paramQQAppInterface.a(78);
          if (paramActivity != null) {
            paramActivity.b(10, UinUtils.a(paramString1));
          }
          paramActivity = (LightalkSwitchManager)paramQQAppInterface.getManager(85);
        } while ((paramActivity == null) || (paramActivity.b()));
        paramQQAppInterface = (LightalkSwitchHanlder)paramQQAppInterface.a(52);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.a((byte)0);
      return;
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(15);
      String str = paramString1;
      if (localShieldMsgManger != null)
      {
        str = paramString1;
        if (paramInt == 1006)
        {
          str = paramString1;
          if (paramString1 != null) {}
        }
      }
      for (;;)
      {
        try
        {
          str = ContactUtils.f(paramQQAppInterface, paramString2);
          paramString1 = str;
          l = Long.parseLong(str);
          paramString1 = str;
          paramString2 = new ArrayList();
          paramString1 = str;
          paramString2.add(Long.valueOf(l));
          if (paramBoolean)
          {
            paramString1 = str;
            localShieldMsgManger.b(paramInt, paramString2);
            i = 1;
            if (paramInt == 1001)
            {
              if ((str != null) && (str.length() > 0))
              {
                if (!paramBoolean) {
                  break label353;
                }
                paramQQAppInterface.a().b(str);
              }
              i = 1;
            }
            if ((paramActivity == null) || (paramActivity.isFinishing())) {
              break;
            }
            if (i == 0) {
              break label365;
            }
            a(paramActivity);
            return;
          }
          paramString1 = str;
          localShieldMsgManger.a(paramInt, paramString2);
          continue;
          int i = 0;
        }
        catch (NumberFormatException paramString2)
        {
          str = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.e("ChatActivityUtils", 2, "shieldMsg", paramString2);
            str = paramString1;
          }
        }
        continue;
        paramQQAppInterface.a().a(str);
      }
      if (paramBoolean)
      {
        b(paramActivity, 2131368704, 1);
        return;
      }
      b(paramActivity, 2131368703, 1);
      return;
    }
    b(paramActivity, 2131367256, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    LauchGameAppListHelper.a(paramQQAppInterface, paramActivity, paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, Intent paramIntent, int paramInt2)
  {
    a(paramQQAppInterface, paramActivity, paramSessionInfo, paramInt1, paramIntent, paramInt2, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, Intent paramIntent, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = null;
    String str = null;
    if (paramInt1 == 1)
    {
      str = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      if (!str.equalsIgnoreCase("")) {
        if (paramInt2 == 1)
        {
          localObject1 = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT <= 10) {
            break label133;
          }
        }
      }
      label133:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        ((BaseApplication)localObject1).getSharedPreferences("presend_config_sp", paramInt1).edit().putString("shot_photo_path", str).commit();
        localObject1 = Uri.fromFile(new File(str));
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().remove("camera_photo_path").commit();
        if (localObject1 != null) {
          break;
        }
        return;
      }
      str = ImageUtil.c(paramActivity, (Uri)localObject1);
      if (str == null) {
        break label661;
      }
      ImageUtil.a(paramActivity, str);
      if (!FileUtils.e(str))
      {
        QQToast.a(paramActivity, paramActivity.getString(2131368697), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492908));
        return;
      }
      if (!new File(str).exists())
      {
        QQToast.a(paramActivity, paramActivity.getString(2131368698), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492908));
        return;
      }
    }
    localObject1 = new Intent();
    if (paramQQAppInterface != null)
    {
      Object localObject2 = paramQQAppInterface.getAccount();
      Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).c((String)localObject2);
      ((Intent)localObject1).putExtra("PhotoConst.MY_UIN", (String)localObject2);
      if (localFriends != null) {
        ((Intent)localObject1).putExtra("PhotoConst.MY_NICK", localFriends.name);
      }
      localObject2 = (HotChatManager)paramQQAppInterface.getManager(59);
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("showFlashPic", FlashPicHelper.a(paramSessionInfo.jdField_a_of_type_Int, (HotChatManager)localObject2, paramSessionInfo.jdField_b_of_type_JavaLangString));
      }
    }
    ((Intent)localObject1).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject1).putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject1).putExtra("uinname", paramSessionInfo.d);
    ((Intent)localObject1).putExtra("entrance", paramSessionInfo.c);
    ((Intent)localObject1).putExtra("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
    if ((!SplashActivity.class.isInstance(paramActivity)) && (!ChatActivity.class.isInstance(paramActivity)))
    {
      ((Intent)localObject1).putExtras(paramActivity.getIntent());
      if (paramInt2 != -1)
      {
        if (paramInt2 != 8) {
          break label888;
        }
        if (paramQQAppInterface != null) {
          PlusPanelUtils.a((Intent)localObject1, paramSessionInfo, paramQQAppInterface);
        }
        ((Intent)localObject1).putExtra("callFromFastImage", true);
        ((Intent)localObject1).putExtra("FROM_WHERE", "FromFastImage");
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1037);
      }
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        boolean bool = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
        paramInt1 = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
        ((Intent)localObject1).putExtra("PhotoConst.IS_SINGLE_MODE", bool);
        if (paramInt1 == 1039) {
          ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
        }
        if (paramInt1 == 1040) {
          ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
        }
        PhotoUtils.a(paramIntent, (Intent)localObject1);
      }
      paramQQAppInterface = new ArrayList();
      paramQQAppInterface.add(str);
      ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramQQAppInterface);
      ((Intent)localObject1).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Intent)localObject1).putExtra("PhotoConst.ALLOW_LOCK", paramBoolean);
      ((Intent)localObject1).setClass(paramActivity, PhotoPreviewActivity.class);
      ((Intent)localObject1).addFlags(603979776);
      paramActivity.startActivity((Intent)localObject1);
      return;
      label661:
      QQToast.a(paramActivity, paramActivity.getString(2131368698), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492908));
      return;
      if ((paramActivity instanceof SplashActivity))
      {
        ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject1 = AIOUtils.a((Intent)localObject1, null);
        label717:
        ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        if (paramSessionInfo.jdField_a_of_type_Int != 9501) {
          break label848;
        }
        if (!(paramActivity instanceof SplashActivity)) {
          break label830;
        }
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject1 = AIOUtils.a((Intent)localObject1, null);
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra(AlbumConstants.i, 82);
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject1).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        break;
        if ((paramActivity instanceof ChatActivity)) {
          ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        }
        break label717;
        label830:
        ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      }
      label848:
      ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject1).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      break;
      label888:
      if (paramInt2 == 1)
      {
        if (paramQQAppInterface != null) {
          PlusPanelUtils.a((Intent)localObject1, paramSessionInfo, paramQQAppInterface);
        }
        ((Intent)localObject1).putExtra("FROM_WHERE", "FromCamera");
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
      }
    }
  }
  
  /* Error */
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, String paramString5, Map paramMap, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 11
    //   3: iload_2
    //   4: sipush 1011
    //   7: if_icmpne +930 -> 937
    //   10: ldc_w 1129
    //   13: invokestatic 1132	com/tencent/av/utils/ImageResUtil:a	(Ljava/lang/String;)Z
    //   16: ifne +7 -> 23
    //   19: aload_0
    //   20: invokestatic 1135	com/tencent/av/utils/ImageResUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   23: aload_3
    //   24: astore 11
    //   26: aload 9
    //   28: ifnull +909 -> 937
    //   31: aload 9
    //   33: ldc_w 1137
    //   36: invokeinterface 1140 2 0
    //   41: checkcast 70	java/lang/String
    //   44: astore 11
    //   46: aload 11
    //   48: ifnull +292 -> 340
    //   51: aload 11
    //   53: ldc_w 1142
    //   56: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifne +14 -> 73
    //   62: aload 11
    //   64: ldc_w 1144
    //   67: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +270 -> 340
    //   73: aload 9
    //   75: ldc_w 1146
    //   78: invokeinterface 1140 2 0
    //   83: checkcast 70	java/lang/String
    //   86: astore_3
    //   87: aload 9
    //   89: ldc_w 1148
    //   92: invokeinterface 1140 2 0
    //   97: checkcast 70	java/lang/String
    //   100: astore 4
    //   102: aload 9
    //   104: ldc_w 1150
    //   107: invokeinterface 1140 2 0
    //   112: checkcast 70	java/lang/String
    //   115: astore 5
    //   117: aload 9
    //   119: ldc_w 1152
    //   122: invokeinterface 1140 2 0
    //   127: checkcast 70	java/lang/String
    //   130: astore 7
    //   132: aload 9
    //   134: ldc_w 1154
    //   137: invokeinterface 1140 2 0
    //   142: checkcast 70	java/lang/String
    //   145: astore 8
    //   147: aload 9
    //   149: ldc_w 1156
    //   152: invokeinterface 1140 2 0
    //   157: checkcast 70	java/lang/String
    //   160: astore 12
    //   162: aload 9
    //   164: ldc_w 1158
    //   167: invokeinterface 1140 2 0
    //   172: checkcast 70	java/lang/String
    //   175: astore 13
    //   177: aload 9
    //   179: ldc_w 1160
    //   182: invokeinterface 1140 2 0
    //   187: checkcast 70	java/lang/String
    //   190: astore 14
    //   192: aload 9
    //   194: ldc_w 1162
    //   197: invokeinterface 1140 2 0
    //   202: checkcast 70	java/lang/String
    //   205: astore 9
    //   207: aload 11
    //   209: ldc_w 1142
    //   212: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +110 -> 325
    //   218: new 649	android/content/Intent
    //   221: dup
    //   222: aload_1
    //   223: ldc_w 1164
    //   226: invokespecial 654	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   229: astore_0
    //   230: aload_0
    //   231: ldc_w 1146
    //   234: aload_3
    //   235: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   238: pop
    //   239: aload_0
    //   240: ldc_w 1148
    //   243: aload 4
    //   245: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   248: pop
    //   249: aload_0
    //   250: ldc_w 1150
    //   253: aload 5
    //   255: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   258: pop
    //   259: aload_0
    //   260: ldc_w 1152
    //   263: aload 7
    //   265: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   268: pop
    //   269: aload_0
    //   270: ldc_w 1154
    //   273: aload 8
    //   275: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   278: pop
    //   279: aload_0
    //   280: ldc_w 1156
    //   283: aload 12
    //   285: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   288: pop
    //   289: aload_0
    //   290: ldc_w 1158
    //   293: aload 13
    //   295: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   298: pop
    //   299: aload_0
    //   300: ldc_w 1160
    //   303: aload 14
    //   305: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   308: pop
    //   309: aload_0
    //   310: ldc_w 1162
    //   313: aload 9
    //   315: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   318: pop
    //   319: aload_1
    //   320: aload_0
    //   321: invokevirtual 719	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   324: return
    //   325: new 649	android/content/Intent
    //   328: dup
    //   329: aload_1
    //   330: ldc_w 1166
    //   333: invokespecial 654	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   336: astore_0
    //   337: goto -107 -> 230
    //   340: ldc_w 1168
    //   343: aload 11
    //   345: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: ifeq +534 -> 882
    //   351: aload 9
    //   353: ldc_w 1146
    //   356: invokeinterface 1140 2 0
    //   361: checkcast 70	java/lang/String
    //   364: astore_3
    //   365: aload 9
    //   367: ldc_w 1148
    //   370: invokeinterface 1140 2 0
    //   375: checkcast 70	java/lang/String
    //   378: astore 4
    //   380: aload 9
    //   382: ldc_w 1150
    //   385: invokeinterface 1140 2 0
    //   390: checkcast 70	java/lang/String
    //   393: astore 5
    //   395: aload 9
    //   397: ldc_w 1170
    //   400: invokeinterface 1140 2 0
    //   405: checkcast 70	java/lang/String
    //   408: astore 7
    //   410: aload 9
    //   412: ldc_w 1172
    //   415: invokeinterface 1140 2 0
    //   420: checkcast 70	java/lang/String
    //   423: astore 8
    //   425: aload 9
    //   427: ldc_w 1174
    //   430: invokeinterface 1140 2 0
    //   435: checkcast 70	java/lang/String
    //   438: astore 11
    //   440: aload 9
    //   442: ldc_w 1176
    //   445: invokeinterface 1140 2 0
    //   450: checkcast 70	java/lang/String
    //   453: astore 12
    //   455: aload 9
    //   457: ldc_w 1178
    //   460: invokeinterface 1140 2 0
    //   465: checkcast 70	java/lang/String
    //   468: astore 13
    //   470: new 649	android/content/Intent
    //   473: dup
    //   474: aload_1
    //   475: ldc_w 1180
    //   478: invokespecial 654	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   481: astore_0
    //   482: aload_0
    //   483: ldc_w 1146
    //   486: aload_3
    //   487: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   490: pop
    //   491: aload_0
    //   492: ldc_w 1148
    //   495: aload 4
    //   497: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   500: pop
    //   501: aload_0
    //   502: ldc_w 1150
    //   505: aload 5
    //   507: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   510: pop
    //   511: aload_0
    //   512: ldc_w 1170
    //   515: aload 7
    //   517: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   520: pop
    //   521: aload_0
    //   522: ldc_w 1172
    //   525: aload 8
    //   527: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   530: pop
    //   531: aload_0
    //   532: ldc_w 1174
    //   535: aload 11
    //   537: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   540: pop
    //   541: aload_0
    //   542: ldc_w 1176
    //   545: aload 12
    //   547: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   550: pop
    //   551: aload_0
    //   552: ldc_w 1178
    //   555: aload 13
    //   557: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   560: pop
    //   561: iconst_0
    //   562: istore_2
    //   563: aload 5
    //   565: invokestatic 1183	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   568: istore 17
    //   570: iload 17
    //   572: istore_2
    //   573: iload_2
    //   574: iconst_1
    //   575: if_icmple +301 -> 876
    //   578: aload 9
    //   580: ldc_w 1185
    //   583: invokeinterface 1140 2 0
    //   588: checkcast 70	java/lang/String
    //   591: astore_3
    //   592: aload 9
    //   594: ldc_w 1187
    //   597: invokeinterface 1140 2 0
    //   602: checkcast 70	java/lang/String
    //   605: astore 4
    //   607: aload 9
    //   609: ldc_w 1189
    //   612: invokeinterface 1140 2 0
    //   617: checkcast 70	java/lang/String
    //   620: astore 5
    //   622: aload 9
    //   624: ldc_w 1191
    //   627: invokeinterface 1140 2 0
    //   632: checkcast 70	java/lang/String
    //   635: astore 7
    //   637: aload 9
    //   639: ldc_w 1193
    //   642: invokeinterface 1140 2 0
    //   647: checkcast 70	java/lang/String
    //   650: astore 8
    //   652: aload 9
    //   654: ldc_w 672
    //   657: invokeinterface 1140 2 0
    //   662: checkcast 70	java/lang/String
    //   665: astore 11
    //   667: aload 9
    //   669: ldc_w 1195
    //   672: invokeinterface 1140 2 0
    //   677: checkcast 70	java/lang/String
    //   680: astore 12
    //   682: aload 9
    //   684: ldc_w 1197
    //   687: invokeinterface 1140 2 0
    //   692: checkcast 70	java/lang/String
    //   695: astore 13
    //   697: aload 9
    //   699: ldc_w 1199
    //   702: invokeinterface 1140 2 0
    //   707: checkcast 70	java/lang/String
    //   710: astore 14
    //   712: aload 9
    //   714: ldc_w 1201
    //   717: invokeinterface 1140 2 0
    //   722: checkcast 70	java/lang/String
    //   725: astore 15
    //   727: aload 9
    //   729: ldc_w 1203
    //   732: invokeinterface 1140 2 0
    //   737: checkcast 70	java/lang/String
    //   740: astore 16
    //   742: aload 9
    //   744: ldc_w 1205
    //   747: invokeinterface 1140 2 0
    //   752: checkcast 70	java/lang/String
    //   755: astore 9
    //   757: aload_0
    //   758: ldc_w 1185
    //   761: aload_3
    //   762: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   765: pop
    //   766: aload_0
    //   767: ldc_w 1187
    //   770: aload 4
    //   772: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   775: pop
    //   776: aload_0
    //   777: ldc_w 1189
    //   780: aload 5
    //   782: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   785: pop
    //   786: aload_0
    //   787: ldc_w 1191
    //   790: aload 7
    //   792: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   795: pop
    //   796: aload_0
    //   797: ldc_w 1193
    //   800: aload 8
    //   802: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   805: pop
    //   806: aload_0
    //   807: ldc_w 672
    //   810: aload 11
    //   812: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   815: pop
    //   816: aload_0
    //   817: ldc_w 1195
    //   820: aload 12
    //   822: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   825: pop
    //   826: aload_0
    //   827: ldc_w 1197
    //   830: aload 13
    //   832: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   835: pop
    //   836: aload_0
    //   837: ldc_w 1199
    //   840: aload 14
    //   842: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   845: pop
    //   846: aload_0
    //   847: ldc_w 1201
    //   850: aload 15
    //   852: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   855: pop
    //   856: aload_0
    //   857: ldc_w 1203
    //   860: aload 16
    //   862: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   865: pop
    //   866: aload_0
    //   867: ldc_w 1205
    //   870: aload 9
    //   872: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   875: pop
    //   876: aload_1
    //   877: aload_0
    //   878: invokevirtual 719	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   881: return
    //   882: aload_3
    //   883: astore 11
    //   885: aload 9
    //   887: ifnull +50 -> 937
    //   890: aload 9
    //   892: ldc_w 1207
    //   895: invokeinterface 1140 2 0
    //   900: checkcast 70	java/lang/String
    //   903: astore 12
    //   905: aload_3
    //   906: astore 11
    //   908: aload 12
    //   910: ifnull +27 -> 937
    //   913: aload_3
    //   914: astore 11
    //   916: aload 12
    //   918: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   921: ifne +16 -> 937
    //   924: aload_0
    //   925: aload 12
    //   927: invokestatic 1209	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   930: astore 11
    //   932: aload 11
    //   934: ifnull +249 -> 1183
    //   937: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   940: ifeq +95 -> 1035
    //   943: ldc 15
    //   945: iconst_2
    //   946: new 296	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   953: ldc_w 1211
    //   956: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: iload_2
    //   960: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   963: ldc_w 1213
    //   966: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: aload 11
    //   971: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: ldc_w 1215
    //   977: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: aload 4
    //   982: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: ldc_w 1217
    //   988: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload 5
    //   993: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: ldc_w 1219
    //   999: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: iload 6
    //   1004: invokevirtual 1222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1007: ldc_w 1224
    //   1010: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: aload 7
    //   1015: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: ldc_w 1226
    //   1021: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload 8
    //   1026: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aload_0
    //   1036: invokevirtual 1228	com/tencent/mobileqq/app/QQAppInterface:d	()Z
    //   1039: ifeq +175 -> 1214
    //   1042: aload_0
    //   1043: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1046: invokevirtual 1236	com/tencent/av/gaudio/AVNotifyCenter:h	()I
    //   1049: iconst_1
    //   1050: if_icmpeq +164 -> 1214
    //   1053: aload_0
    //   1054: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1057: invokevirtual 1236	com/tencent/av/gaudio/AVNotifyCenter:h	()I
    //   1060: sipush 3000
    //   1063: if_icmpeq +151 -> 1214
    //   1066: aload_0
    //   1067: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1070: invokevirtual 1238	com/tencent/av/gaudio/AVNotifyCenter:f	()Z
    //   1073: ifeq +141 -> 1214
    //   1076: aload_0
    //   1077: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1080: invokevirtual 1240	com/tencent/av/gaudio/AVNotifyCenter:e	()Z
    //   1083: ifeq +131 -> 1214
    //   1086: aload_0
    //   1087: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1090: invokevirtual 1236	com/tencent/av/gaudio/AVNotifyCenter:h	()I
    //   1093: sipush 1011
    //   1096: if_icmpeq +118 -> 1214
    //   1099: aload_0
    //   1100: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   1103: invokevirtual 1236	com/tencent/av/gaudio/AVNotifyCenter:h	()I
    //   1106: bipush 21
    //   1108: if_icmpeq +106 -> 1214
    //   1111: aload_1
    //   1112: invokestatic 1244	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;)Z
    //   1115: ifeq +84 -> 1199
    //   1118: new 649	android/content/Intent
    //   1121: dup
    //   1122: aload_1
    //   1123: ldc_w 1246
    //   1126: invokespecial 654	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1129: astore_0
    //   1130: aload_0
    //   1131: ldc_w 1247
    //   1134: invokevirtual 1097	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1137: pop
    //   1138: aload_0
    //   1139: ldc_w 1249
    //   1142: iload_2
    //   1143: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1146: pop
    //   1147: aload_0
    //   1148: ldc_w 1251
    //   1151: aload 11
    //   1153: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1156: pop
    //   1157: aload_0
    //   1158: ldc_w 1253
    //   1161: aload 7
    //   1163: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1166: pop
    //   1167: aload_0
    //   1168: ldc_w 1255
    //   1171: iload 6
    //   1173: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1176: pop
    //   1177: aload_1
    //   1178: aload_0
    //   1179: invokevirtual 719	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1182: return
    //   1183: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1186: ifeq -862 -> 324
    //   1189: ldc 15
    //   1191: iconst_2
    //   1192: ldc_w 1257
    //   1195: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1198: return
    //   1199: new 649	android/content/Intent
    //   1202: dup
    //   1203: aload_1
    //   1204: ldc_w 1261
    //   1207: invokespecial 654	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1210: astore_0
    //   1211: goto -81 -> 1130
    //   1214: aload_0
    //   1215: invokestatic 1266	com/tencent/mobileqq/activity/aio/MediaPlayerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/MediaPlayerManager;
    //   1218: astore_3
    //   1219: aload_3
    //   1220: ifnull +8 -> 1228
    //   1223: aload_3
    //   1224: iconst_1
    //   1225: invokevirtual 1269	com/tencent/mobileqq/activity/aio/MediaPlayerManager:a	(Z)V
    //   1228: iload_2
    //   1229: ifne +2329 -> 3558
    //   1232: aload_0
    //   1233: bipush 50
    //   1235: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1238: checkcast 160	com/tencent/mobileqq/app/FriendsManager
    //   1241: aload 11
    //   1243: invokevirtual 1016	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   1246: astore_3
    //   1247: aload_3
    //   1248: ifnull +2310 -> 3558
    //   1251: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1254: ifeq +55 -> 1309
    //   1257: ldc 15
    //   1259: iconst_2
    //   1260: new 296	java/lang/StringBuilder
    //   1263: dup
    //   1264: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1267: ldc_w 1271
    //   1270: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: aload_3
    //   1274: invokestatic 1274	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/data/Friends;)Ljava/lang/String;
    //   1277: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: ldc_w 1276
    //   1283: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: aload_3
    //   1287: getfield 1279	com/tencent/mobileqq/data/Friends:abilityBits	J
    //   1290: invokevirtual 788	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1293: ldc_w 1281
    //   1296: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: iconst_1
    //   1300: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1303: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1306: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1309: aload_3
    //   1310: invokevirtual 1284	com/tencent/mobileqq/data/Friends:getNetWorkType	()I
    //   1313: iconst_2
    //   1314: if_icmpeq +2244 -> 3558
    //   1317: iconst_1
    //   1318: istore 24
    //   1320: iload_2
    //   1321: sipush 1006
    //   1324: if_icmpeq +15 -> 1339
    //   1327: iload_2
    //   1328: bipush 24
    //   1330: if_icmpeq +9 -> 1339
    //   1333: iload_2
    //   1334: bipush 25
    //   1336: if_icmpne +330 -> 1666
    //   1339: aload 11
    //   1341: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1344: ifeq +107 -> 1451
    //   1347: aload 5
    //   1349: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1352: ifeq +99 -> 1451
    //   1355: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1358: ifeq -1034 -> 324
    //   1361: ldc 15
    //   1363: iconst_2
    //   1364: new 296	java/lang/StringBuilder
    //   1367: dup
    //   1368: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1371: ldc_w 1211
    //   1374: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: iload_2
    //   1378: invokevirtual 340	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1381: ldc_w 1213
    //   1384: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: aload 11
    //   1389: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: ldc_w 1215
    //   1395: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: aload 4
    //   1400: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: ldc_w 1217
    //   1406: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: aload 5
    //   1411: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: ldc_w 1219
    //   1417: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: iload 6
    //   1422: invokevirtual 1222	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1425: ldc_w 1224
    //   1428: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: aload 7
    //   1433: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1439: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1442: return
    //   1443: astore_3
    //   1444: aload_3
    //   1445: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   1448: goto -220 -> 1228
    //   1451: aload_0
    //   1452: bipush 10
    //   1454: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1457: checkcast 1286	com/tencent/mobileqq/model/PhoneContactManager
    //   1460: invokeinterface 1289 1 0
    //   1465: astore 15
    //   1467: aload 15
    //   1469: ifnull +2081 -> 3550
    //   1472: aload 15
    //   1474: getfield 1294	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   1477: astore_3
    //   1478: aload 15
    //   1480: getfield 1297	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   1483: astore 13
    //   1485: aload 11
    //   1487: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1490: ifeq +78 -> 1568
    //   1493: aload 5
    //   1495: astore 12
    //   1497: aload 5
    //   1499: astore 14
    //   1501: iload_2
    //   1502: bipush 24
    //   1504: if_icmpeq +9 -> 1513
    //   1507: iload_2
    //   1508: bipush 25
    //   1510: if_icmpne +85 -> 1595
    //   1513: aload 15
    //   1515: ifnull +31 -> 1546
    //   1518: aload 15
    //   1520: getfield 1294	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   1523: ldc_w 425
    //   1526: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1529: ifne +17 -> 1546
    //   1532: aload 15
    //   1534: getfield 1297	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   1537: ldc_w 425
    //   1540: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1543: ifeq +52 -> 1595
    //   1546: aload_1
    //   1547: ldc_w 1298
    //   1550: iconst_0
    //   1551: invokestatic 643	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   1554: aload_1
    //   1555: invokevirtual 125	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1558: ldc 126
    //   1560: invokevirtual 131	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1563: invokevirtual 646	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   1566: pop
    //   1567: return
    //   1568: aload 11
    //   1570: astore 12
    //   1572: aload 5
    //   1574: astore 14
    //   1576: aload 5
    //   1578: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1581: ifeq -80 -> 1501
    //   1584: aload 11
    //   1586: astore 14
    //   1588: aload 11
    //   1590: astore 12
    //   1592: goto -91 -> 1501
    //   1595: aload 13
    //   1597: astore 11
    //   1599: aload 14
    //   1601: astore 5
    //   1603: aload 12
    //   1605: astore 13
    //   1607: aload_3
    //   1608: astore 12
    //   1610: aload 11
    //   1612: astore_3
    //   1613: iload_2
    //   1614: sipush 1000
    //   1617: if_icmpne +1926 -> 3543
    //   1620: aload_0
    //   1621: bipush 51
    //   1623: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1626: checkcast 364	com/tencent/mobileqq/app/TroopManager
    //   1629: astore 11
    //   1631: aload 11
    //   1633: ifnull +1903 -> 3536
    //   1636: aload 11
    //   1638: aload 7
    //   1640: invokevirtual 1300	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1643: astore 11
    //   1645: aload 11
    //   1647: ifnonnull +93 -> 1740
    //   1650: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1653: ifeq -1329 -> 324
    //   1656: ldc 15
    //   1658: iconst_2
    //   1659: ldc_w 1302
    //   1662: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1665: return
    //   1666: aload 5
    //   1668: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1671: ifeq +57 -> 1728
    //   1674: aload_0
    //   1675: bipush 10
    //   1677: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1680: checkcast 1286	com/tencent/mobileqq/model/PhoneContactManager
    //   1683: aload 11
    //   1685: invokeinterface 1305 2 0
    //   1690: astore_3
    //   1691: aload_3
    //   1692: ifnull +21 -> 1713
    //   1695: aload_3
    //   1696: getfield 1308	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1699: astore 5
    //   1701: aconst_null
    //   1702: astore_3
    //   1703: aconst_null
    //   1704: astore 12
    //   1706: aload 11
    //   1708: astore 13
    //   1710: goto -97 -> 1613
    //   1713: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1716: ifeq +12 -> 1728
    //   1719: ldc 15
    //   1721: iconst_2
    //   1722: ldc_w 1310
    //   1725: invokestatic 1313	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1728: aconst_null
    //   1729: astore_3
    //   1730: aconst_null
    //   1731: astore 12
    //   1733: aload 11
    //   1735: astore 13
    //   1737: goto -124 -> 1613
    //   1740: aload 11
    //   1742: astore 14
    //   1744: iload_2
    //   1745: sipush 1011
    //   1748: if_icmpne +1611 -> 3359
    //   1751: aload 9
    //   1753: ldc_w 1315
    //   1756: invokeinterface 1140 2 0
    //   1761: checkcast 70	java/lang/String
    //   1764: astore 11
    //   1766: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1769: ifeq +30 -> 1799
    //   1772: ldc 15
    //   1774: iconst_2
    //   1775: new 296	java/lang/StringBuilder
    //   1778: dup
    //   1779: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1782: ldc_w 1317
    //   1785: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: aload 11
    //   1790: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1796: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1799: aload 11
    //   1801: ldc_w 423
    //   1804: ldc_w 425
    //   1807: invokevirtual 429	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1810: ldc_w 431
    //   1813: invokevirtual 435	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1816: astore 15
    //   1818: aload 15
    //   1820: arraylength
    //   1821: newarray <illegal type>
    //   1823: astore 11
    //   1825: iconst_0
    //   1826: istore 17
    //   1828: iload 17
    //   1830: aload 15
    //   1832: arraylength
    //   1833: if_icmpge +28 -> 1861
    //   1836: aload 11
    //   1838: iload 17
    //   1840: aload 15
    //   1842: iload 17
    //   1844: aaload
    //   1845: invokevirtual 438	java/lang/String:trim	()Ljava/lang/String;
    //   1848: invokestatic 444	java/lang/Byte:parseByte	(Ljava/lang/String;)B
    //   1851: bastore
    //   1852: iload 17
    //   1854: iconst_1
    //   1855: iadd
    //   1856: istore 17
    //   1858: goto -30 -> 1828
    //   1861: new 70	java/lang/String
    //   1864: dup
    //   1865: aload 4
    //   1867: invokestatic 1319	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Ljava/lang/String;)[B
    //   1870: ldc_w 453
    //   1873: invokespecial 463	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1876: astore 15
    //   1878: aload 15
    //   1880: astore 4
    //   1882: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1885: ifeq +34 -> 1919
    //   1888: ldc 15
    //   1890: iconst_2
    //   1891: new 296	java/lang/StringBuilder
    //   1894: dup
    //   1895: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1898: ldc_w 1321
    //   1901: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: aload 15
    //   1906: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1912: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1915: aload 15
    //   1917: astore 4
    //   1919: iconst_1
    //   1920: istore 18
    //   1922: aload_0
    //   1923: invokevirtual 1323	com/tencent/mobileqq/app/QQAppInterface:a	()J
    //   1926: l2i
    //   1927: istore 20
    //   1929: aload_0
    //   1930: aload 13
    //   1932: invokestatic 1324	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   1935: istore 25
    //   1937: aload_0
    //   1938: bipush 50
    //   1940: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1943: checkcast 160	com/tencent/mobileqq/app/FriendsManager
    //   1946: aload 13
    //   1948: invokevirtual 1016	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   1951: astore 15
    //   1953: aload 15
    //   1955: ifnull +1575 -> 3530
    //   1958: aload 15
    //   1960: aload_0
    //   1961: invokestatic 1327	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/data/Friends;Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   1964: istore 19
    //   1966: aload_0
    //   1967: bipush 13
    //   1969: invokevirtual 869	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1972: checkcast 1329	com/tencent/mobileqq/app/SVIPHandler
    //   1975: invokevirtual 1330	com/tencent/mobileqq/app/SVIPHandler:h	()I
    //   1978: istore 17
    //   1980: iload 17
    //   1982: iconst_2
    //   1983: if_icmpne +1391 -> 3374
    //   1986: iconst_0
    //   1987: istore 17
    //   1989: aload_0
    //   1990: aload 13
    //   1992: iconst_3
    //   1993: iconst_1
    //   1994: aconst_null
    //   1995: invokestatic 1335	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;Ljava/lang/String;IZLjava/lang/String;)I
    //   1998: istore 21
    //   2000: iload 21
    //   2002: ifeq +72 -> 2074
    //   2005: iload_2
    //   2006: ifeq +24 -> 2030
    //   2009: iload_2
    //   2010: sipush 1004
    //   2013: if_icmpeq +17 -> 2030
    //   2016: iload_2
    //   2017: sipush 1000
    //   2020: if_icmpeq +10 -> 2030
    //   2023: iload_2
    //   2024: sipush 1003
    //   2027: if_icmpne +47 -> 2074
    //   2030: aload_0
    //   2031: bipush 44
    //   2033: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2036: checkcast 1337	com/tencent/mobileqq/vas/ColorRingManager
    //   2039: astore 15
    //   2041: new 976	java/io/File
    //   2044: dup
    //   2045: iload 21
    //   2047: i2l
    //   2048: iconst_3
    //   2049: invokestatic 1340	com/tencent/mobileqq/vas/ColorRingManager:a	(JI)Ljava/lang/String;
    //   2052: invokespecial 978	java/io/File:<init>	(Ljava/lang/String;)V
    //   2055: invokevirtual 1008	java/io/File:exists	()Z
    //   2058: ifne +16 -> 2074
    //   2061: aload 15
    //   2063: iload 21
    //   2065: iconst_3
    //   2066: iconst_0
    //   2067: iconst_0
    //   2068: ldc_w 1342
    //   2071: invokevirtual 1345	com/tencent/mobileqq/vas/ColorRingManager:a	(IIZILjava/lang/String;)V
    //   2074: aload_0
    //   2075: aload 13
    //   2077: bipush 6
    //   2079: iconst_1
    //   2080: aconst_null
    //   2081: invokestatic 1335	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;Ljava/lang/String;IZLjava/lang/String;)I
    //   2084: istore 22
    //   2086: iload 22
    //   2088: ifeq +60 -> 2148
    //   2091: invokestatic 1347	com/tencent/mobileqq/vipav/VipFunCallManager:a	()I
    //   2094: istore 23
    //   2096: aload_0
    //   2097: iload 22
    //   2099: iload 23
    //   2101: aconst_null
    //   2102: invokestatic 1350	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;IILjava/lang/String;)Ljava/lang/String;
    //   2105: astore 15
    //   2107: aload 15
    //   2109: invokestatic 292	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2112: ifne +36 -> 2148
    //   2115: new 976	java/io/File
    //   2118: dup
    //   2119: aload 15
    //   2121: invokespecial 978	java/io/File:<init>	(Ljava/lang/String;)V
    //   2124: invokevirtual 1008	java/io/File:exists	()Z
    //   2127: ifne +21 -> 2148
    //   2130: aload_0
    //   2131: bipush 83
    //   2133: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2136: checkcast 1332	com/tencent/mobileqq/vipav/VipFunCallManager
    //   2139: iload 22
    //   2141: iload 23
    //   2143: iconst_0
    //   2144: iconst_0
    //   2145: invokevirtual 1353	com/tencent/mobileqq/vipav/VipFunCallManager:a	(IIZI)V
    //   2148: aload_0
    //   2149: iload 22
    //   2151: invokestatic 1356	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;I)V
    //   2154: aload_0
    //   2155: bipush 46
    //   2157: invokevirtual 869	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2160: checkcast 1358	com/tencent/mobileqq/vipav/VipSetFunCallHandler
    //   2163: astore 15
    //   2165: new 1360	android/os/Bundle
    //   2168: dup
    //   2169: invokespecial 1361	android/os/Bundle:<init>	()V
    //   2172: astore 16
    //   2174: aload 16
    //   2176: ldc_w 847
    //   2179: aload 13
    //   2181: invokestatic 877	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2184: invokevirtual 1365	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2187: aload 16
    //   2189: ldc_w 1367
    //   2192: ldc_w 425
    //   2195: invokevirtual 1370	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2198: aload 15
    //   2200: iconst_2
    //   2201: aload 16
    //   2203: invokevirtual 1373	com/tencent/mobileqq/vipav/VipSetFunCallHandler:a	(ILjava/lang/Object;)V
    //   2206: new 649	android/content/Intent
    //   2209: dup
    //   2210: aload_1
    //   2211: ldc_w 1375
    //   2214: invokespecial 654	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2217: astore 15
    //   2219: aload 15
    //   2221: ldc_w 1376
    //   2224: invokevirtual 1097	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2227: pop
    //   2228: aload 15
    //   2230: ldc_w 1247
    //   2233: invokevirtual 1097	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2236: pop
    //   2237: aload 15
    //   2239: ldc_w 1249
    //   2242: iload_2
    //   2243: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2246: pop
    //   2247: aload 15
    //   2249: ldc_w 847
    //   2252: aload 13
    //   2254: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2257: pop
    //   2258: aload 15
    //   2260: ldc_w 1377
    //   2263: aload 4
    //   2265: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2268: pop
    //   2269: aload 15
    //   2271: ldc_w 1379
    //   2274: aload 12
    //   2276: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2279: pop
    //   2280: aload 15
    //   2282: ldc_w 1381
    //   2285: aload_3
    //   2286: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2289: pop
    //   2290: aload 15
    //   2292: ldc_w 1383
    //   2295: aload 5
    //   2297: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2300: pop
    //   2301: aload 15
    //   2303: ldc_w 1385
    //   2306: iconst_0
    //   2307: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2310: pop
    //   2311: aload 15
    //   2313: ldc_w 1255
    //   2316: iload 6
    //   2318: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2321: pop
    //   2322: aload 15
    //   2324: ldc_w 1387
    //   2327: iload 20
    //   2329: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2332: pop
    //   2333: aload 15
    //   2335: ldc_w 1253
    //   2338: aload 14
    //   2340: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2343: pop
    //   2344: aload 15
    //   2346: ldc_w 1389
    //   2349: aload 7
    //   2351: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2354: pop
    //   2355: aload 15
    //   2357: ldc_w 1391
    //   2360: iload 24
    //   2362: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2365: pop
    //   2366: aload 15
    //   2368: ldc_w 1393
    //   2371: iload 25
    //   2373: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2376: pop
    //   2377: aload 15
    //   2379: ldc_w 1395
    //   2382: invokestatic 1400	android/os/SystemClock:elapsedRealtime	()J
    //   2385: invokevirtual 708	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2388: pop
    //   2389: aload 15
    //   2391: ldc_w 1402
    //   2394: iconst_1
    //   2395: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2398: pop
    //   2399: aload 15
    //   2401: ldc_w 1404
    //   2404: iload 21
    //   2406: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2409: pop
    //   2410: aload 15
    //   2412: ldc_w 1406
    //   2415: iload 17
    //   2417: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2420: pop
    //   2421: iload 6
    //   2423: ifeq +998 -> 3421
    //   2426: iconst_1
    //   2427: istore 17
    //   2429: aload 15
    //   2431: ldc_w 1408
    //   2434: iload 17
    //   2436: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2439: pop
    //   2440: aload 11
    //   2442: astore_3
    //   2443: aload 9
    //   2445: ifnull +195 -> 2640
    //   2448: aload 9
    //   2450: ldc_w 1410
    //   2453: invokeinterface 1140 2 0
    //   2458: checkcast 70	java/lang/String
    //   2461: astore 4
    //   2463: aload 9
    //   2465: ldc_w 1412
    //   2468: invokeinterface 1140 2 0
    //   2473: checkcast 70	java/lang/String
    //   2476: astore 5
    //   2478: aload 9
    //   2480: ldc_w 1414
    //   2483: invokeinterface 1140 2 0
    //   2488: checkcast 70	java/lang/String
    //   2491: astore 7
    //   2493: aload 9
    //   2495: ldc_w 1416
    //   2498: invokeinterface 1140 2 0
    //   2503: checkcast 70	java/lang/String
    //   2506: astore 12
    //   2508: aload 11
    //   2510: astore_3
    //   2511: aload 4
    //   2513: ifnull +127 -> 2640
    //   2516: aload 15
    //   2518: ldc_w 1410
    //   2521: aload 4
    //   2523: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2526: pop
    //   2527: aload 15
    //   2529: ldc_w 1412
    //   2532: aload 5
    //   2534: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2537: pop
    //   2538: aload 15
    //   2540: ldc_w 1414
    //   2543: aload 7
    //   2545: invokestatic 1419	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2548: invokevirtual 1422	java/lang/Integer:intValue	()I
    //   2551: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2554: pop
    //   2555: aload 15
    //   2557: ldc_w 1416
    //   2560: aload 12
    //   2562: invokestatic 1419	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2565: invokevirtual 1422	java/lang/Integer:intValue	()I
    //   2568: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2571: pop
    //   2572: aload 9
    //   2574: ldc_w 1315
    //   2577: invokeinterface 1140 2 0
    //   2582: checkcast 70	java/lang/String
    //   2585: astore 4
    //   2587: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2590: ifeq +30 -> 2620
    //   2593: ldc 15
    //   2595: iconst_2
    //   2596: new 296	java/lang/StringBuilder
    //   2599: dup
    //   2600: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   2603: ldc_w 1317
    //   2606: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: aload 4
    //   2611: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2614: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2617: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2620: aload 11
    //   2622: astore_3
    //   2623: aload 4
    //   2625: ifnull +15 -> 2640
    //   2628: aload 4
    //   2630: invokestatic 1425	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   2633: astore_3
    //   2634: ldc 15
    //   2636: aload_3
    //   2637: invokestatic 1428	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;[B)V
    //   2640: aload 15
    //   2642: ldc_w 1315
    //   2645: aload_3
    //   2646: invokevirtual 1431	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   2649: pop
    //   2650: iload_2
    //   2651: sipush 1011
    //   2654: if_icmpne +66 -> 2720
    //   2657: aload 9
    //   2659: ldc_w 1433
    //   2662: invokeinterface 1140 2 0
    //   2667: checkcast 70	java/lang/String
    //   2670: astore_3
    //   2671: aload 9
    //   2673: ldc_w 1435
    //   2676: invokeinterface 1140 2 0
    //   2681: checkcast 70	java/lang/String
    //   2684: astore 4
    //   2686: aload 15
    //   2688: ldc_w 1435
    //   2691: new 296	java/lang/StringBuilder
    //   2694: dup
    //   2695: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   2698: aload 4
    //   2700: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2703: aload_3
    //   2704: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2707: ldc_w 1437
    //   2710: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2713: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2716: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2719: pop
    //   2720: aload_0
    //   2721: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2724: aload 13
    //   2726: invokevirtual 1439	com/tencent/av/gaudio/AVNotifyCenter:d	(Ljava/lang/String;)Z
    //   2729: ifeq +63 -> 2792
    //   2732: aload_0
    //   2733: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2736: aload 13
    //   2738: invokevirtual 1441	com/tencent/av/gaudio/AVNotifyCenter:b	(Ljava/lang/String;)I
    //   2741: iconst_1
    //   2742: if_icmpne +702 -> 3444
    //   2745: aload 15
    //   2747: ldc_w 1255
    //   2750: iconst_1
    //   2751: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2754: pop
    //   2755: iload 6
    //   2757: ifeq +700 -> 3457
    //   2760: iconst_0
    //   2761: istore 6
    //   2763: aload 15
    //   2765: ldc_w 1443
    //   2768: iload 6
    //   2770: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2773: pop
    //   2774: aload 15
    //   2776: ldc_w 1408
    //   2779: aload_0
    //   2780: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2783: aload 13
    //   2785: invokevirtual 1441	com/tencent/av/gaudio/AVNotifyCenter:b	(Ljava/lang/String;)I
    //   2788: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2791: pop
    //   2792: aload 15
    //   2794: ldc_w 1444
    //   2797: aload 8
    //   2799: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2802: pop
    //   2803: aload 15
    //   2805: ldc_w 1446
    //   2808: iload 19
    //   2810: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2813: pop
    //   2814: aload 15
    //   2816: ldc_w 1448
    //   2819: aload_0
    //   2820: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2823: aload 13
    //   2825: invokevirtual 1439	com/tencent/av/gaudio/AVNotifyCenter:d	(Ljava/lang/String;)Z
    //   2828: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2831: pop
    //   2832: aload 15
    //   2834: ldc_w 1450
    //   2837: aload_0
    //   2838: invokevirtual 1231	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2841: aload 13
    //   2843: invokevirtual 1451	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;)J
    //   2846: invokevirtual 708	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2849: pop
    //   2850: aload 15
    //   2852: ldc_w 1453
    //   2855: iload 10
    //   2857: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2860: pop
    //   2861: aload_0
    //   2862: new 1455	com/tencent/av/app/PstnSessionInfo
    //   2865: dup
    //   2866: invokespecial 1456	com/tencent/av/app/PstnSessionInfo:<init>	()V
    //   2869: aload 13
    //   2871: iload_2
    //   2872: invokestatic 1461	com/tencent/av/utils/PstnUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/av/app/PstnSessionInfo;Ljava/lang/String;I)Lcom/tencent/av/app/PstnSessionInfo;
    //   2875: astore_3
    //   2876: aload_3
    //   2877: getfield 1462	com/tencent/av/app/PstnSessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2880: ifnull +638 -> 3518
    //   2883: aload_3
    //   2884: getfield 1464	com/tencent/av/app/PstnSessionInfo:c	Ljava/lang/String;
    //   2887: ifnull +631 -> 3518
    //   2890: aload_0
    //   2891: sipush 142
    //   2894: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2897: checkcast 1466	com/tencent/mobileqq/qcall/PstnManager
    //   2900: astore_3
    //   2901: aload_3
    //   2902: aload_0
    //   2903: invokevirtual 446	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2906: invokevirtual 1469	com/tencent/mobileqq/qcall/PstnManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/qcall/PstnCardInfo;
    //   2909: astore 4
    //   2911: aload 4
    //   2913: ifnull +605 -> 3518
    //   2916: aload_3
    //   2917: invokevirtual 1470	com/tencent/mobileqq/qcall/PstnManager:a	()I
    //   2920: iconst_1
    //   2921: if_icmpne +597 -> 3518
    //   2924: aload_3
    //   2925: invokevirtual 1473	com/tencent/mobileqq/qcall/PstnManager:a	()Lcom/tencent/mobileqq/qcall/PstnSwitchConfig;
    //   2928: getfield 1477	com/tencent/mobileqq/qcall/PstnSwitchConfig:e	I
    //   2931: iconst_1
    //   2932: if_icmpne +586 -> 3518
    //   2935: iconst_1
    //   2936: istore 19
    //   2938: aload 4
    //   2940: ifnull +523 -> 3463
    //   2943: aload 4
    //   2945: getfield 1482	com/tencent/mobileqq/qcall/PstnCardInfo:pstn_c2c_call_time	I
    //   2948: ifle +515 -> 3463
    //   2951: iconst_1
    //   2952: istore 17
    //   2954: aload 15
    //   2956: ldc_w 1484
    //   2959: iload 19
    //   2961: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2964: pop
    //   2965: aload 15
    //   2967: ldc_w 1486
    //   2970: iload 17
    //   2972: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2975: pop
    //   2976: aload 9
    //   2978: ifnull +38 -> 3016
    //   2981: aload 9
    //   2983: ldc_w 1488
    //   2986: invokeinterface 1489 2 0
    //   2991: ifeq +25 -> 3016
    //   2994: aload 15
    //   2996: ldc_w 1488
    //   2999: aload 9
    //   3001: ldc_w 1488
    //   3004: invokeinterface 1140 2 0
    //   3009: checkcast 70	java/lang/String
    //   3012: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3015: pop
    //   3016: aload 9
    //   3018: ifnull +38 -> 3056
    //   3021: aload 9
    //   3023: ldc_w 1491
    //   3026: invokeinterface 1489 2 0
    //   3031: ifeq +25 -> 3056
    //   3034: aload 15
    //   3036: ldc_w 1491
    //   3039: aload 9
    //   3041: ldc_w 1491
    //   3044: invokeinterface 1140 2 0
    //   3049: checkcast 70	java/lang/String
    //   3052: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3055: pop
    //   3056: aload 9
    //   3058: ifnull +38 -> 3096
    //   3061: aload 9
    //   3063: ldc_w 1493
    //   3066: invokeinterface 1489 2 0
    //   3071: ifeq +25 -> 3096
    //   3074: aload 15
    //   3076: ldc_w 1493
    //   3079: aload 9
    //   3081: ldc_w 1493
    //   3084: invokeinterface 1140 2 0
    //   3089: checkcast 70	java/lang/String
    //   3092: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3095: pop
    //   3096: aload 9
    //   3098: ifnull +38 -> 3136
    //   3101: aload 9
    //   3103: ldc_w 1495
    //   3106: invokeinterface 1489 2 0
    //   3111: ifeq +25 -> 3136
    //   3114: aload 15
    //   3116: ldc_w 1495
    //   3119: aload 9
    //   3121: ldc_w 1495
    //   3124: invokeinterface 1140 2 0
    //   3129: checkcast 70	java/lang/String
    //   3132: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3135: pop
    //   3136: aload 9
    //   3138: ifnull +38 -> 3176
    //   3141: aload 9
    //   3143: ldc_w 1497
    //   3146: invokeinterface 1489 2 0
    //   3151: ifeq +25 -> 3176
    //   3154: aload 15
    //   3156: ldc_w 1497
    //   3159: aload 9
    //   3161: ldc_w 1497
    //   3164: invokeinterface 1140 2 0
    //   3169: checkcast 70	java/lang/String
    //   3172: invokevirtual 682	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3175: pop
    //   3176: aload 15
    //   3178: invokevirtual 1501	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   3181: invokevirtual 1506	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   3184: astore_3
    //   3185: aload_1
    //   3186: invokevirtual 327	java/lang/Object:getClass	()Ljava/lang/Class;
    //   3189: invokevirtual 332	java/lang/Class:getName	()Ljava/lang/String;
    //   3192: astore 4
    //   3194: aload_3
    //   3195: ldc_w 1508
    //   3198: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3201: ifeq +290 -> 3491
    //   3204: aload 4
    //   3206: ldc_w 1510
    //   3209: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3212: ifne +32 -> 3244
    //   3215: aload 4
    //   3217: ldc_w 1512
    //   3220: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3223: ifne +21 -> 3244
    //   3226: aload 4
    //   3228: ldc_w 1514
    //   3231: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3234: ifne +10 -> 3244
    //   3237: iload_2
    //   3238: sipush 9500
    //   3241: if_icmpne +250 -> 3491
    //   3244: new 649	android/content/Intent
    //   3247: dup
    //   3248: aload_1
    //   3249: ldc_w 1516
    //   3252: invokespecial 654	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3255: astore_3
    //   3256: aload_3
    //   3257: ldc_w 1518
    //   3260: aload 15
    //   3262: invokevirtual 1521	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   3265: pop
    //   3266: aload_3
    //   3267: ldc_w 1247
    //   3270: invokevirtual 1097	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   3273: pop
    //   3274: aload_1
    //   3275: aload_3
    //   3276: invokevirtual 719	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3279: iload 10
    //   3281: ifeq +23 -> 3304
    //   3284: aload_1
    //   3285: instanceof 521
    //   3288: ifeq +16 -> 3304
    //   3291: aload_1
    //   3292: checkcast 521	android/app/Activity
    //   3295: ldc_w 1522
    //   3298: ldc_w 1523
    //   3301: invokevirtual 1526	android/app/Activity:overridePendingTransition	(II)V
    //   3304: aload_0
    //   3305: invokevirtual 1228	com/tencent/mobileqq/app/QQAppInterface:d	()Z
    //   3308: ifeq -2984 -> 324
    //   3311: iload 18
    //   3313: ifne -2989 -> 324
    //   3316: iload_2
    //   3317: sipush 9500
    //   3320: if_icmpeq -2996 -> 324
    //   3323: aload_1
    //   3324: instanceof 521
    //   3327: ifeq -3003 -> 324
    //   3330: aload_1
    //   3331: checkcast 521	android/app/Activity
    //   3334: ldc_w 1527
    //   3337: iconst_0
    //   3338: invokevirtual 1526	android/app/Activity:overridePendingTransition	(II)V
    //   3341: return
    //   3342: astore_0
    //   3343: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3346: ifeq -3022 -> 324
    //   3349: ldc 15
    //   3351: iconst_2
    //   3352: ldc_w 1529
    //   3355: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3358: return
    //   3359: aload_0
    //   3360: iload_2
    //   3361: aload 13
    //   3363: invokestatic 1534	com/tencent/av/utils/VideoMsgTools:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)[B
    //   3366: astore 11
    //   3368: iconst_0
    //   3369: istore 18
    //   3371: goto -1449 -> 1922
    //   3374: iload 17
    //   3376: iconst_3
    //   3377: if_icmpne +150 -> 3527
    //   3380: iconst_2
    //   3381: istore 17
    //   3383: goto -1394 -> 1989
    //   3386: astore 15
    //   3388: ldc 15
    //   3390: iconst_1
    //   3391: new 296	java/lang/StringBuilder
    //   3394: dup
    //   3395: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   3398: ldc_w 1536
    //   3401: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3404: aload 15
    //   3406: invokevirtual 1539	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3409: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3412: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3415: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3418: goto -1212 -> 2206
    //   3421: iconst_2
    //   3422: istore 17
    //   3424: goto -995 -> 2429
    //   3427: astore_0
    //   3428: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3431: ifeq -3107 -> 324
    //   3434: ldc 15
    //   3436: iconst_2
    //   3437: ldc_w 1529
    //   3440: invokestatic 1259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3443: return
    //   3444: aload 15
    //   3446: ldc_w 1255
    //   3449: iconst_0
    //   3450: invokevirtual 660	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   3453: pop
    //   3454: goto -699 -> 2755
    //   3457: iconst_1
    //   3458: istore 6
    //   3460: goto -697 -> 2763
    //   3463: aload_3
    //   3464: invokevirtual 1541	com/tencent/mobileqq/qcall/PstnManager:b	()I
    //   3467: iconst_1
    //   3468: if_icmpne +17 -> 3485
    //   3471: aload 4
    //   3473: getfield 1544	com/tencent/mobileqq/qcall/PstnCardInfo:pstn_c2c_try_status	I
    //   3476: ifne +9 -> 3485
    //   3479: iconst_2
    //   3480: istore 17
    //   3482: goto -528 -> 2954
    //   3485: iconst_5
    //   3486: istore 17
    //   3488: goto -534 -> 2954
    //   3491: aload_1
    //   3492: aload 15
    //   3494: invokevirtual 719	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3497: goto -218 -> 3279
    //   3500: astore_3
    //   3501: goto -2928 -> 573
    //   3504: astore 15
    //   3506: goto -1587 -> 1919
    //   3509: astore 4
    //   3511: aload 15
    //   3513: astore 4
    //   3515: goto -1596 -> 1919
    //   3518: iconst_5
    //   3519: istore 17
    //   3521: iconst_0
    //   3522: istore 19
    //   3524: goto -570 -> 2954
    //   3527: goto -1538 -> 1989
    //   3530: iconst_m1
    //   3531: istore 19
    //   3533: goto -1567 -> 1966
    //   3536: aload 7
    //   3538: astore 11
    //   3540: goto -1895 -> 1645
    //   3543: aload 7
    //   3545: astore 14
    //   3547: goto -1803 -> 1744
    //   3550: aconst_null
    //   3551: astore 13
    //   3553: aconst_null
    //   3554: astore_3
    //   3555: goto -2070 -> 1485
    //   3558: iconst_0
    //   3559: istore 24
    //   3561: goto -2241 -> 1320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3564	0	paramQQAppInterface	QQAppInterface
    //   0	3564	1	paramContext	Context
    //   0	3564	2	paramInt	int
    //   0	3564	3	paramString1	String
    //   0	3564	4	paramString2	String
    //   0	3564	5	paramString3	String
    //   0	3564	6	paramBoolean1	boolean
    //   0	3564	7	paramString4	String
    //   0	3564	8	paramString5	String
    //   0	3564	9	paramMap	Map
    //   0	3564	10	paramBoolean2	boolean
    //   1	3538	11	localObject1	Object
    //   160	2401	12	localObject2	Object
    //   175	3377	13	localObject3	Object
    //   190	3356	14	localObject4	Object
    //   725	2536	15	localObject5	Object
    //   3386	107	15	localException1	Exception
    //   3504	8	15	localException2	Exception
    //   740	1462	16	localObject6	Object
    //   568	2952	17	i	int
    //   1920	1450	18	j	int
    //   1964	1568	19	k	int
    //   1927	401	20	m	int
    //   1998	407	21	n	int
    //   2084	66	22	i1	int
    //   2094	48	23	i2	int
    //   1318	2242	24	bool1	boolean
    //   1935	437	25	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   1214	1219	1443	java/lang/Exception
    //   1223	1228	1443	java/lang/Exception
    //   1751	1799	3342	java/lang/Exception
    //   1799	1825	3342	java/lang/Exception
    //   1828	1852	3342	java/lang/Exception
    //   2154	2206	3386	java/lang/Exception
    //   2628	2634	3427	java/lang/Exception
    //   563	570	3500	java/lang/NumberFormatException
    //   1861	1878	3504	java/lang/Exception
    //   1882	1915	3509	java/lang/Exception
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "createOrEnterGroupAudio uinType: " + paramInt + ", uin: " + paramString);
    }
    Object localObject1;
    Intent localIntent;
    long l;
    int k;
    int i;
    Object localObject2;
    if (paramString != null)
    {
      localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
      localIntent = new Intent();
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      l = Long.parseLong(paramString);
      k = UITools.a(paramInt);
      i = 0;
      if (k == 2) {
        i = 1;
      }
      localObject1 = null;
      if (paramMap == null) {
        break label1225;
      }
      localObject1 = (String)paramMap.get("MultiAVType");
      if (localObject1 == null) {
        break label1222;
      }
      i = Integer.valueOf((String)localObject1).intValue();
      localObject1 = (String)paramMap.get("jump_from");
      localIntent.putExtra("jump_from", (String)localObject1);
      localObject2 = (String)paramMap.get("Fromwhere");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localIntent.putExtra("Fromwhere", (String)localObject2);
      }
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)paramMap.get("isAVMeeting"))) {
          break label1216;
        }
        bool = Boolean.parseBoolean((String)paramMap.get("isAVMeeting"));
        localIntent.putExtra("isAVMeeting", bool);
      }
      catch (Exception localException2)
      {
        try
        {
          if (TextUtils.isEmpty((CharSequence)paramMap.get("isAVGroupMeeting"))) {
            break label1210;
          }
          bool = Boolean.parseBoolean((String)paramMap.get("isAVGroupMeeting"));
          localIntent.putExtra("isAVGroupMeeting", bool);
        }
        catch (Exception localException2)
        {
          try
          {
            if (TextUtils.isEmpty((CharSequence)paramMap.get("isConferenceFlyTicket"))) {
              break label1204;
            }
            bool = Boolean.parseBoolean((String)paramMap.get("isConferenceFlyTicket"));
            localIntent.putExtra("isConferenceFlyTicket", bool);
            j = i;
            if ((("gvideo".equals(localObject1)) || ("gvideo_h5".equals(localObject1))) && (paramInt == 1))
            {
              i = 1;
              if (paramInt != 3000) {
                break label1069;
              }
              localObject2 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
              if (localObject2 == null) {
                break label1198;
              }
              int m = ((ArrayList)localObject2).size();
              localObject1 = new long[m];
              k = 0;
              if (k >= m) {
                break label667;
              }
              DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((ArrayList)localObject2).get(k);
              if (localDiscussionMemberInfo != null) {
                localObject1[k] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
              }
              k += 1;
              continue;
              localException1 = localException1;
              bool = false;
              continue;
              localException2 = localException2;
              bool = false;
            }
          }
          catch (Exception localException3)
          {
            bool = false;
            continue;
            if (paramQQAppInterface.a().a(k, l) > 0L)
            {
              if ((j != paramQQAppInterface.a().b(l)) && (paramInt == 1))
              {
                localObject1 = paramQQAppInterface.a().a(l, j);
                if ((localObject1 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_b_of_type_Int == j) && (((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int > 0))
                {
                  i = 0;
                  continue;
                }
                continue;
              }
              if (paramQQAppInterface.a().a(k, l))
              {
                i = 2;
                continue;
              }
              i = 1;
              continue;
            }
            k = 0;
            i = k;
            if (j != 2) {
              continue;
            }
            localObject1 = paramQQAppInterface.a().a(l, 2);
            i = k;
            if (localObject1 == null) {
              continue;
            }
            i = k;
            if (((AVNotifyCenter.VideoRoomInfo)localObject1).jdField_a_of_type_Int <= 0) {
              continue;
            }
            i = 1;
            continue;
          }
        }
      }
      for (;;)
      {
        label667:
        localIntent.putExtra("DiscussUinList", (long[])localObject1);
        label1069:
        do
        {
          localIntent.putExtra("sessionType", 3);
          localIntent.putExtra("uin", paramString);
          localIntent.putExtra("uinType", paramInt);
          localIntent.putExtra("Type", i);
          localIntent.putExtra("GroupId", paramString);
          localIntent.putExtra("MultiAVType", j);
          if (j != 2) {
            localIntent.setClass(paramContext, AVActivity.class);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "createOrEnterGroupAudio, uin=" + paramString + ",uinType=" + paramInt + ",Type=" + i + ",GroupId=" + paramString + ",MultiAVType=" + j);
          }
          if (paramMap == null) {
            break label1127;
          }
          localObject1 = (String)paramMap.get("PhoneNumberList");
          if (localObject1 != null) {
            localIntent.putExtra("phoneNumbers", PstnUtils.c((String)localObject1));
          }
          localObject1 = (String)paramMap.get("isVideo");
          if ((VcSystemInfo.h()) && ("true".equalsIgnoreCase((String)localObject1))) {
            localIntent.putExtra("isVideo", true);
          }
          localObject1 = (String)paramMap.get("PstnLevel");
          if (localObject1 != null) {
            localIntent.putExtra("PstnLevel", (String)localObject1);
          }
          localObject1 = (String)paramMap.get("PLACE");
          if (localObject1 != null) {
            localIntent.putExtra("PLACE", (String)localObject1);
          }
          localObject1 = (String)paramMap.get("CREATE_PLACE");
          if (localObject1 != null) {
            localIntent.putExtra("CREATE_PLACE", (String)localObject1);
          }
          localObject1 = (String)paramMap.get("ipPstnEnterType");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1127;
          }
          k = Integer.parseInt((String)localObject1);
          if ((k != 1) || (!paramQQAppInterface.d())) {
            break;
          }
          QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
          return;
        } while (paramInt != 1);
        localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
        if ((localObject1 != null) && (((TroopManager)localObject1).a(paramString) == null)) {}
        for (bool = false;; bool = true)
        {
          localIntent.putExtra("troopmember", bool);
          break;
          localIntent.putExtra("ipPstnEnterType", k);
          label1127:
          a(paramQQAppInterface, localIntent);
          GVideoUpdateUtil.a(paramContext, paramString, j, new kue(i, paramInt, (QCallFacade)paramQQAppInterface.getManager(37), l, localIntent, paramQQAppInterface, l, paramMap, "start_group_audio_time" + paramQQAppInterface.a()));
          return;
        }
        label1198:
        localObject1 = null;
      }
      label1204:
      boolean bool = false;
      continue;
      label1210:
      bool = false;
      continue;
      label1216:
      bool = false;
      continue;
      label1222:
      break;
      label1225:
      int j = i;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int m = 5;
    int k = 1;
    PstnManager localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
    paramQQAppInterface = localPstnManager.a(paramQQAppInterface.a());
    int i;
    int j;
    if ((paramQQAppInterface != null) && (localPstnManager.a() == 1)) {
      if (paramQQAppInterface.pstn_multi_call_time > 0)
      {
        i = 3;
        j = k;
      }
    }
    for (;;)
    {
      paramIntent.putExtra("graySwitch", j);
      paramIntent.putExtra("ltMultiMembership", i);
      paramIntent.putExtra("multiPstnAutoTranTime", localPstnManager.a().g);
      paramIntent.putExtra("multiPstnMissDelayTime", localPstnManager.a().h);
      paramIntent.putExtra("multiPstnMissShowTime", localPstnManager.a().i);
      return;
      i = m;
      j = k;
      if (localPstnManager.c() == 1)
      {
        i = m;
        j = k;
        if (paramQQAppInterface.pstn_multi_try_status == 0)
        {
          i = 4;
          j = k;
          continue;
          j = 0;
          i = m;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, FragmentActivity paramFragmentActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "bubble onDoubleClick().");
    }
    if ((paramFragmentActivity != null) && (paramFragmentActivity.getCurrentFocus() != null)) {}
    Context localContext;
    ChatMessage localChatMessage;
    do
    {
      ((InputMethodManager)paramFragmentActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramFragmentActivity.getCurrentFocus().getWindowToken(), 0);
      for (;;)
      {
        localContext = paramView.getContext();
        if (localContext != null) {
          break;
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "chatActivity current focus is null");
        }
      }
      localChatMessage = AIOUtils.a(paramView);
    } while (localChatMessage == null);
    if ((localChatMessage instanceof MessageForLongMsg)) {
      paramView = ((MessageForLongMsg)localChatMessage).msg;
    }
    label297:
    label351:
    label462:
    label564:
    label640:
    label880:
    label885:
    label888:
    for (;;)
    {
      if (paramView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "bubble onDoubleClick() CharSequence null.");
        return;
        if ((localChatMessage instanceof MessageForText))
        {
          paramView = (MessageForText)localChatMessage;
          if (!(paramView.sb instanceof QQText)) {
            break label885;
          }
        }
      }
      for (paramView = ((QQText)paramView.sb).l;; paramView = null)
      {
        if (localChatMessage.msgtype != 63528) {
          break label888;
        }
        if (localChatMessage.isSend())
        {
          paramView = localContext.getString(2131370363);
          break;
        }
        paramView = localContext.getString(2131370362);
        break;
        if ((localChatMessage instanceof MessageForQQStoryComment))
        {
          paramView = (MessageForQQStoryComment)localChatMessage;
          paramFragmentActivity = paramView.getNickName(paramQQAppInterface);
          paramView = "“" + paramFragmentActivity + "的日迹”\n" + paramView.comment;
          break;
        }
        if (((localChatMessage instanceof MessageForReplyText)) || ((localChatMessage instanceof MessageForLongMsg))) {
          if ((localChatMessage instanceof MessageForReplyText)) {
            paramView = ((MessageForReplyText)localChatMessage).mSourceMsgInfo;
          }
        }
        for (;;)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          String str1;
          if (paramView != null)
          {
            String str2 = TimeFormatterUtils.a(localContext, 3, paramView.mSourceMsgTime * 1000L).toString();
            str1 = "";
            if (TextUtils.isEmpty(paramView.mAnonymousNickName)) {
              break label462;
            }
            paramFragmentActivity = paramView.mAnonymousNickName;
            localStringBuilder.append("“").append(str2).append(" ").append(paramFragmentActivity).append("\r\n");
            if (paramView.mSourceSummaryFlag != 1) {
              break label564;
            }
            localStringBuilder.append(paramView.mSourceMsgText).append("\r\n");
          }
          for (;;)
          {
            MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "doubleClk", localChatMessage.frienduin, localChatMessage);
            localStringBuilder.append(localChatMessage.getSummaryMsg());
            paramView = localStringBuilder.toString();
            break;
            if (!(localChatMessage instanceof MessageForLongMsg)) {
              break label880;
            }
            paramView = ((MessageForLongMsg)localChatMessage).mSourceMsgInfo;
            break label297;
            if (paramView.mSourceMsgSenderUin == 50000000L)
            {
              Object localObject = ReplyTextItemBuilder.a(paramQQAppInterface, localChatMessage.frienduin, localChatMessage.istroop, paramView.mSourceMsgSeq);
              paramFragmentActivity = str1;
              if (localObject == null) {
                break label351;
              }
              localObject = TroopBusinessUtil.a((MessageRecord)localObject);
              paramFragmentActivity = str1;
              if (localObject == null) {
                break label351;
              }
              paramView.mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject).c;
              paramFragmentActivity = str1;
              break label351;
            }
            paramFragmentActivity = ContactUtils.e(paramQQAppInterface, localChatMessage.frienduin, paramView.mSourceMsgSenderUin + "");
            break label351;
            if (paramView.mSourceSummaryFlag == 0)
            {
              paramView = paramQQAppInterface.a().a(localChatMessage.frienduin, 1, paramView.mSourceMsgSeq, 0L);
              if ((paramView != null) && (paramView.size() > 0)) {}
              for (paramView = (MessageRecord)paramView.get(0);; paramView = null)
              {
                if (paramView == null) {
                  break label640;
                }
                localStringBuilder.append(paramView.msg).append("\r\n");
                break;
              }
            }
          }
          if ((localChatMessage instanceof MessageForMixedMsg))
          {
            paramView = ((MessageForMixedMsg)localChatMessage).msg;
            break;
            paramFragmentActivity = new Intent(localContext, TextPreviewActivity.class);
            paramFragmentActivity.putExtra("peeruin", localChatMessage.frienduin);
            paramFragmentActivity.putExtra("uin_type", localChatMessage.istroop);
            paramFragmentActivity.putExtra("content", paramView);
            paramFragmentActivity.putExtra("uniseq", localChatMessage.uniseq);
            paramFragmentActivity.putExtra("bubbleId", localChatMessage.vipBubbleID);
            paramFragmentActivity.putExtra("senderuin", localChatMessage.senderuin);
            if (localChatMessage.isSend()) {
              paramView = localChatMessage.selfuin;
            }
            for (;;)
            {
              paramFragmentActivity.putExtra("real_msg_sender_uin", paramView);
              localContext.startActivity(paramFragmentActivity);
              ((Activity)localContext).overridePendingTransition(2130968594, 0);
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "long_msg", "long_msg_double", 0, 0, "", "", "", "");
              return;
              if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004)) {
                paramView = localChatMessage.frienduin;
              } else {
                paramView = localChatMessage.senderuin;
              }
            }
          }
          paramView = null;
          break;
          paramView = null;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Integer paramInteger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.a()))) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils.troop.notification_center.show_red_dot", 2, "setTroopTipStatus, troopUin:" + paramString + ",status:" + paramInteger);
        }
      } while ((paramInteger.intValue() != -1) && (paramInteger.intValue() != 0));
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString + paramQQAppInterface.a(), paramInteger);
    } while (paramInteger.intValue() != -1);
    paramInteger = (TroopManager)paramQQAppInterface.getManager(51);
    int i;
    if (paramInteger != null)
    {
      paramInteger = paramInteger.a(paramString);
      if (paramInteger != null)
      {
        String str = paramQQAppInterface.a();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramInteger.Administrator))) {
          if ((str.equals(paramInteger.Administrator)) || (paramInteger.Administrator.contains(str))) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {}
      for (paramInteger = "0";; paramInteger = "1")
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "AIOchat", "Exp_dataEntry_new", 0, 0, paramString, paramInteger, "", "");
        return;
        i = 0;
        break;
      }
      i = 0;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Map paramMap)
  {
    if (paramMap != null)
    {
      String str = (String)paramMap.get("business_type");
      if ((str == null) || (!str.equals("1"))) {
        break label110;
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      try
      {
        l = Long.parseLong((String)paramMap.get("group_id"));
        paramMap = new Intent();
        paramMap.setAction("android.intent.action.gameparty.refresh");
        paramMap.putExtra("uin", paramQQAppInterface.a());
        paramMap.putExtra("teamId", l);
        paramQQAppInterface.a().sendBroadcast(paramMap);
        return;
      }
      catch (NumberFormatException paramMap)
      {
        for (;;)
        {
          long l = -1L;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 1005) || (paramInt == 1009) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1020) || (paramInt == 1025) || (paramInt == 1010);
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, "single friend list: " + (String)localObject);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject);
        localObject = new JSONArray();
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((!localJSONObject.has("type")) || (!localJSONObject.has("uin"))) {
            break label212;
          }
          int j = localJSONObject.getInt("type");
          String str = localJSONObject.getString("uin");
          if ((j == paramInt) && (str.equals(MsgProxyUtils.a(paramString)))) {
            break label212;
          }
          ((JSONArray)localObject).put(localJSONObject);
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString("single_way_friend_list", ((JSONArray)localObject).toString());
      boolean bool = paramContext.commit();
      return bool;
      label212:
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt != 0) {
      return false;
    }
    if (((PhoneContactManager)paramQQAppInterface.getManager(10)).a(paramString) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== uinType = " + paramInt);
    }
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(15);
    boolean bool1;
    if (paramInt == 0)
    {
      if (!((FriendsManager)paramQQAppInterface.getManager(50)).e(paramString1)) {
        break label275;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== isMsgShield = " + bool1);
      }
      return bool1;
      if (paramInt == 1001)
      {
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
        if (localShieldMsgManger == null) {
          break label269;
        }
      }
      label269:
      for (bool1 = localShieldMsgManger.a(paramString1);; bool1 = false)
      {
        if (!bool1)
        {
          paramQQAppInterface = paramQQAppInterface.c(paramString1);
          if ((paramQQAppInterface != null) && (paramQQAppInterface.groupid == 64534)) {
            bool1 = bool2;
          }
        }
        for (;;)
        {
          break;
          bool1 = bool3;
          if (paramInt == 1011) {
            break;
          }
          if (paramInt == 25)
          {
            bool1 = ((LightalkShieldManager)paramQQAppInterface.getManager(138)).a(UinUtils.a(paramString1));
            break;
          }
          bool1 = bool3;
          if (localShieldMsgManger == null) {
            break;
          }
          String str = paramString1;
          if (paramInt == 1006)
          {
            str = paramString1;
            if (paramString1 == null) {
              str = ContactUtils.f(paramQQAppInterface, paramString2);
            }
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          bool1 = localShieldMsgManger.a(str);
          break;
        }
      }
      label275:
      bool1 = false;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ArrayList paramArrayList)
  {
    paramArrayList = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramInt == 3000)
    {
      paramString = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
      if (paramString != null)
      {
        int i = paramString.size();
        paramInt = 0;
        while (paramInt < i)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramString.get(paramInt);
          if ((localDiscussionMemberInfo != null) && (!paramQQAppInterface.getAccount().equals(localDiscussionMemberInfo.memberUin)) && (paramArrayList.a(localDiscussionMemberInfo.memberUin) != null)) {
            return true;
          }
          paramInt += 1;
        }
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5)
  {
    return a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, null);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "startVideo uinType: " + paramInt + ", peerUin: " + paramString1 + ", name: " + paramString2 + ", phoneNum: " + paramString3 + ", onlyAudio: " + paramBoolean1 + ", extraUin: " + paramString4 + ", checkShieldMsg: " + paramBoolean2 + ", checkWifi: " + paramBoolean3 + ", from: " + paramString5);
    }
    return b(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, paramMap, true, true, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, Map paramMap, int paramInt2, boolean paramBoolean4)
  {
    if (!NetworkUtil.h(paramContext))
    {
      QQToast.a(paramContext, 0, 2131367481, 0).a();
      return false;
    }
    Object localObject2 = (PhoneContactManager)paramQQAppInterface.getManager(10);
    Object localObject1 = ((PhoneContactManager)localObject2).a();
    String str;
    if (localObject1 != null)
    {
      localObject3 = ((RespondQueryQQBindingStat)localObject1).mobileNo;
      str = ((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo;
      if (((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(paramString3))) || ((!TextUtils.isEmpty(str)) && (str.equals(paramString3))))
      {
        QQToast.a(paramContext, 2131364030, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        return false;
      }
    }
    PstnManager localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
    Object localObject3 = localPstnManager.a(paramQQAppInterface.a());
    int i;
    if ((localObject3 != null) && (((PstnCardInfo)localObject3).pstn_c2c_call_time > 0))
    {
      i = 1;
      if ((!paramBoolean4) || (paramInt1 != 0) || (localPstnManager.a()) || (!PstnUtils.a(paramQQAppInterface, 1)) || (!a(paramQQAppInterface, paramInt1, paramString1)) || (i == 0)) {
        break label372;
      }
      localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131372509);
      localObject2 = paramQQAppInterface.getApplication().getResources().getString(2131372510);
      str = localPstnManager.a("pstn_c2c_trans_wording");
      localObject3 = localPstnManager.a("pstn_c2c_trans_check_wording");
      if (!TextUtils.isEmpty(str)) {
        break label358;
      }
      label277:
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label365;
      }
    }
    for (;;)
    {
      DialogUtil.a(paramContext, 230, "确认呼叫方式", (String)localObject1, (String)localObject2, "取消", "呼叫", null, new kul(localPstnManager, paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramMap, paramInt2), new kum(paramStartVideoListener, paramQQAppInterface)).show();
      return false;
      i = 0;
      break;
      label358:
      localObject1 = str;
      break label277;
      label365:
      localObject2 = localObject3;
    }
    label372:
    if ((paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 1006) || (paramInt1 == 56938) || (paramInt1 == 5) || ((paramInt1 == 0) && (a(paramQQAppInterface, paramInt1, paramString1))))
    {
      paramString4 = new PstnSessionInfo();
      paramString4.jdField_a_of_type_Int = paramInt1;
      if (paramInt1 == 5)
      {
        paramString4.jdField_a_of_type_JavaLangString = paramString1.substring("pstn".length());
        paramString4.jdField_a_of_type_Int = 56938;
        if (!TextUtils.isEmpty(paramString3)) {
          break label552;
        }
        paramString1 = ((PhoneContactManager)localObject2).a(paramString1);
        if (paramString1 == null) {}
      }
      label552:
      for (paramString4.jdField_b_of_type_JavaLangString = paramString1.unifiedCode;; paramString4.jdField_b_of_type_JavaLangString = paramString3)
      {
        paramString4.d = paramString2;
        if (localObject1 != null) {
          paramString4.c = (((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo);
        }
        return a(paramQQAppInterface, paramContext, paramString4, paramInt2, paramStartVideoListener, true);
        paramString4.jdField_a_of_type_JavaLangString = paramString1;
        break;
      }
    }
    if (paramInt1 == 0) {
      return a(paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, "from_internal", paramMap);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityUtils", 2, "startC2CCall| type is wrong.");
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.StartVideoListener paramStartVideoListener, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "startGroupAudio uinType: " + paramInt + ", uin: " + paramString + ", checkWifi: " + paramBoolean1 + ", checkMutex: " + paramBoolean2);
    }
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startGroupAudio Activity isDestroyed!");
      }
      return false;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(paramContext, 2131367256, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
      return true;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
    if (!VcSystemInfo.e())
    {
      if (paramInt == 3000) {
        QQToast.a(paramContext, 2131363495, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      }
      for (;;)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005769", "0X8005769", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576B", "0X800576B", 0, 0, "", "", VcSystemInfo.d(), "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576C", "0X800576C", 0, 0, "", "", VcSystemInfo.e(), "");
        return true;
        if (paramInt == 1) {
          QQToast.a(paramContext, 2131363496, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        }
      }
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576A", "0X800576A", 0, 0, "", "", "", "");
    if (!VcSystemInfo.f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo earlyDown so not ready!");
      }
      QQToast.a(paramContext, 2131363291, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576D", "0X800576D", 0, 0, "", "", "", "");
      return true;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576E", "0X800576E", 0, 0, "", "", "", "");
    if ((paramQQAppInterface.a().a()) && (!paramQQAppInterface.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startGroupAudio phone is calling!");
      }
      paramQQAppInterface = paramContext.getString(2131363529);
      DialogUtil.a(paramContext, 230, paramContext.getString(2131363525), paramQQAppInterface, 2131367262, 2131367263, new kty(paramStartVideoListener), null).show();
      DataReport.a();
      return false;
    }
    if (!VcSystemInfo.h())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startGroupAudio old engine!");
      }
      if (paramInt == 1011)
      {
        paramString = paramContext.getString(2131363729);
        DialogUtil.a(paramContext, 230, paramContext.getString(2131363525), paramString, 2131367262, 2131363540, new ktz(paramStartVideoListener), null).show();
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
        return false;
      }
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) && (paramInt == 3000))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "invalid discussId: " + paramString);
      }
      return false;
    }
    long l1 = Long.valueOf(paramString).longValue();
    int m = UITools.a(paramInt);
    int k = 0;
    int j = 0;
    int i = k;
    Object localObject1;
    if (paramMap != null)
    {
      i = k;
      if (m == 1)
      {
        localObject1 = (String)paramMap.get("MultiAVType");
        i = j;
        if (localObject1 != null) {
          i = Integer.valueOf((String)localObject1).intValue();
        }
        localObject1 = (String)paramMap.get("isVideo");
        if ((localObject1 != null) && (((String)localObject1).equals("true")))
        {
          paramQQAppInterface.a().a(true);
          if (m == 2) {
            i = 1;
          }
          if ((!paramQQAppInterface.a().a(m, l1)) || (m != 1) || (!paramQQAppInterface.a().g()) || (paramInt != 1)) {
            break label1105;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "check mutex of qq call and group call!");
          }
          long l2 = paramQQAppInterface.a().a();
          j = paramQQAppInterface.a().b(l2);
          if (j == i) {
            break label1085;
          }
          if ((j != 10) || (i != 2)) {
            break label1015;
          }
          if (!paramQQAppInterface.a().b()) {
            break label991;
          }
          QQToast.a(paramContext, 2131363470, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        }
      }
    }
    for (;;)
    {
      return true;
      paramQQAppInterface.a().a(false);
      break;
      label991:
      QQToast.a(paramContext, 2131363467, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
    }
    label1015:
    if ((j == 2) && (i == 10))
    {
      if (paramQQAppInterface.a().b()) {
        QQToast.a(paramContext, 2131363469, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      }
      for (;;)
      {
        return true;
        QQToast.a(paramContext, 2131363468, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      }
    }
    label1085:
    if (i == 2) {
      paramContext.sendBroadcast(new Intent("com.tencent.av.EXIT_VIDEO_PROCESS"));
    }
    label1105:
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      if (!paramQQAppInterface.a().a(m, l1, i)) {
        if ((paramBoolean1) && (!NetworkUtil.i(BaseApplication.getContext())) && (!NetworkUtil.g(BaseApplication.getContext())))
        {
          if (VideoController.d(VideoController.d + paramQQAppInterface.a()) > 0)
          {
            a(paramQQAppInterface, paramContext, paramInt, paramString, false, paramBoolean2, paramStartVideoListener, paramMap);
            return true;
            paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
            continue;
          }
          localObject1 = null;
          localObject2 = null;
          if (NetworkUtil.c(BaseApplication.getContext()))
          {
            localObject1 = paramContext.getString(2131363525);
            localObject2 = paramContext.getString(2131363518);
          }
          if (!NetworkUtil.d(BaseApplication.getContext())) {
            break label1886;
          }
          localObject1 = paramContext.getString(2131363525);
          if ((paramMap != null) && (TextUtils.equals((CharSequence)paramMap.get("isVideo"), "true")))
          {
            localObject3 = paramContext.getString(2131363520);
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ChatActivityUtils", 2, "startGAudio title or content is empty");
        }
        return true;
        localObject3 = paramContext.getString(2131363521);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else
      {
        PopupDialog.a(paramContext, 230, (String)localObject2, (String)localObject1, 2131363532, 2131363537, new kua(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramStartVideoListener, paramMap), new kub(paramStartVideoListener));
        return false;
        if ((paramBoolean2) && (paramQQAppInterface.d()))
        {
          j = paramQQAppInterface.a().b();
          k = paramQQAppInterface.a().c();
          if (((k != 1) && (k != 2)) || (((j >= 1) && (j <= 5)) || (paramQQAppInterface.a().g() == 1) || (paramQQAppInterface.a().g() == 2)))
          {
            QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
            return true;
          }
          if (((k != 3) && (k != 4)) || (((j >= 1) && (j <= 5)) || (paramQQAppInterface.a().g() == 3) || (paramQQAppInterface.a().g() == 4)))
          {
            if ((paramQQAppInterface.a().a() == l1) && (m != 1))
            {
              if (QLog.isColorLevel()) {
                QLog.e("ChatActivityUtils", 2, "startGroupAudio-->chatUin==discussid???Why");
              }
              return true;
            }
            if (paramQQAppInterface.a().a() > 0L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatActivityUtils", 2, "startVideo is multi calling!");
              }
              localObject1 = paramContext.getString(2131363466);
              j = TroopMemberUtil.a(paramQQAppInterface, paramQQAppInterface.a(), paramString + "");
              PopupDialog.a(paramContext, 230, null, (String)localObject1, 2131363532, 2131363537, new kuc(paramQQAppInterface, paramContext, m, i, paramInt, paramString, paramBoolean1, paramStartVideoListener, paramMap, j), new kud(paramStartVideoListener, paramString, j));
              ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramString + "", j + "", "", "");
              return false;
            }
          }
          else if (paramQQAppInterface.a().a().jdField_b_of_type_Int != -1)
          {
            QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
            return false;
          }
        }
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005776", "0X8005776", 0, 0, "", "", "", "");
        if (paramStartVideoListener != null) {
          paramStartVideoListener.b();
        }
        a(paramQQAppInterface, paramContext, paramInt, paramString, paramMap);
        if (paramStartVideoListener != null) {
          paramStartVideoListener.c();
        }
        paramQQAppInterface.a().a(l1, i);
        return true;
        label1886:
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, ArrayList paramArrayList, int paramInt2, int paramInt3)
  {
    return b(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramStartVideoListener, paramArrayList, paramInt2, paramInt3, true, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt)
  {
    return a(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt, null, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt, ChatActivityUtils.StartVideoListener paramStartVideoListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      if ("startPstnC2CCall|pstnSession=" + paramPstnSessionInfo != null) {
        break label64;
      }
    }
    label64:
    for (String str1 = "null";; str1 = paramPstnSessionInfo.toString() + ", from=" + paramInt)
    {
      QLog.d("ChatActivityUtils", 2, str1);
      if (NetworkUtil.h(paramContext)) {
        break;
      }
      QQToast.a(paramContext, 0, 2131367481, 0).a();
      return false;
    }
    if (paramQQAppInterface.d())
    {
      i = 1;
      if (paramQQAppInterface.a().a().jdField_b_of_type_Int != -1)
      {
        str1 = paramQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
        if ((TextUtils.isEmpty(paramPstnSessionInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(str1)) || (!str1.equals(paramPstnSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label729;
        }
      }
    }
    label720:
    label729:
    for (int i = 0;; i = 1)
    {
      String str2;
      if (i != 0)
      {
        str1 = (String)PhoneNumberUtil.a(paramPstnSessionInfo.jdField_b_of_type_JavaLangString).get(1);
        str2 = (String)PhoneNumberUtil.a(paramQQAppInterface.a().a().jdField_b_of_type_JavaLangString).get(1);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str1.equals(str2))) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
          return false;
        }
        if ((!TextUtils.isEmpty(paramPstnSessionInfo.c)) && (!TextUtils.isEmpty(paramPstnSessionInfo.jdField_b_of_type_JavaLangString)) && ((paramPstnSessionInfo.c.equals(paramPstnSessionInfo.jdField_b_of_type_JavaLangString)) || (paramPstnSessionInfo.c.contains(paramPstnSessionInfo.jdField_b_of_type_JavaLangString))))
        {
          QQToast.a(paramContext, 2131364030, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
          return false;
        }
        str1 = PstnUtils.b(paramQQAppInterface, 1);
        str2 = PstnUtils.c(paramQQAppInterface, 1);
        String str3 = PstnUtils.d(paramQQAppInterface, 1);
        if (PstnUtils.a(paramQQAppInterface, 1))
        {
          if ((PstnUtils.b(paramQQAppInterface, 1)) && (paramBoolean))
          {
            DialogUtil.a(paramContext, 230, "时长不足", PstnUtils.a(paramQQAppInterface, 1), "购买时长", "继续拨打", new kso(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt, paramStartVideoListener), new ksz(paramQQAppInterface, paramContext, paramStartVideoListener)).show();
            return false;
          }
          if ((paramContext instanceof BaseActivity)) {
            if ((paramInt != 4) && (paramInt != 5))
            {
              paramBoolean = true;
              if (!PstnUtils.a(paramQQAppInterface, (BaseActivity)paramContext, 2002, paramBoolean))
              {
                paramQQAppInterface = new Intent(paramContext, CallbackWaitingActivityExt.class);
                if (paramInt == 7) {
                  paramQQAppInterface.addFlags(268435456);
                }
                paramQQAppInterface.putExtra("pstn_session_info", paramPstnSessionInfo);
                paramContext.startActivity(paramQQAppInterface);
              }
            }
          }
          for (;;)
          {
            if (paramStartVideoListener != null) {
              paramStartVideoListener.c();
            }
            return true;
            paramBoolean = false;
            break;
            if (!PstnUtils.a(paramQQAppInterface, paramContext))
            {
              paramQQAppInterface = new Intent(paramContext, CallbackWaitingActivityExt.class);
              if (paramInt == 7) {
                paramQQAppInterface.addFlags(268435456);
              }
              paramQQAppInterface.putExtra("pstn_session_info", paramPstnSessionInfo);
              paramContext.startActivity(paramQQAppInterface);
            }
          }
        }
        if ((paramInt == 3) || (paramInt == 5)) {
          if ((paramPstnSessionInfo.jdField_a_of_type_Int != 0) || (((PhoneContactManager)paramQQAppInterface.getManager(10)).a(paramPstnSessionInfo.jdField_a_of_type_JavaLangString) == null)) {
            break label720;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            DialogUtil.a(paramContext, str1, str2, str3, new ktk(paramQQAppInterface, paramContext, paramInt), paramContext.getString(2131364006), new ktv(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt)).show();
          }
          for (;;)
          {
            return false;
            DialogUtil.a(paramContext, 230, str1, str2, paramContext.getString(2131363161), str3, new kuh(paramQQAppInterface, paramContext, paramInt), new kuk(paramQQAppInterface, paramInt)).show();
            continue;
            PstnUtils.a(paramQQAppInterface, paramContext, 1, 8);
          }
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((1024 == paramSessionInfo.jdField_a_of_type_Int) && (CrmUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
    return (paramSessionInfo.jdField_a_of_type_Int == 0) && (!paramQQAppInterface.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((FriendsManager)paramQQAppInterface.getManager(50)).b(paramString);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    boolean bool = false;
    Object localObject2 = "";
    PhoneContactManager localPhoneContactManager;
    Object localObject3;
    Object localObject1;
    int i;
    Object localObject4;
    if (paramInt == 3000)
    {
      localPhoneContactManager = (PhoneContactManager)paramQQAppInterface.getManager(10);
      localObject3 = (DiscussionManager)paramQQAppInterface.getManager(52);
      localObject1 = paramQQAppInterface.a();
      localObject3 = ((DiscussionManager)localObject3).a(paramString);
      if (localObject3 != null)
      {
        int j = ((ArrayList)localObject3).size();
        i = 0;
        if (i < j)
        {
          localObject4 = (DiscussionMemberInfo)((ArrayList)localObject3).get(i);
          if (localObject4 != null) {
            if (((String)localObject1).equals(((DiscussionMemberInfo)localObject4).memberUin))
            {
              if (localPhoneContactManager.a() != null) {
                break label769;
              }
              bool = true;
            }
          }
        }
      }
    }
    label254:
    label766:
    label769:
    for (;;)
    {
      i += 1;
      break;
      paramArrayList2.add(new InviteBaseData((DiscussionMemberInfo)localObject4));
      localObject4 = localPhoneContactManager.a(((DiscussionMemberInfo)localObject4).memberUin);
      if (localObject4 != null)
      {
        paramArrayList1.add(((PhoneContact)localObject4).unifiedCode);
        paramArrayList3.add(((PhoneContact)localObject4).mobileNo);
      }
      for (;;)
      {
        break;
        bool = true;
      }
      bool = true;
      continue;
      localObject1 = localObject2;
      if (!paramBoolean)
      {
        localObject3 = PstnUtils.a(paramQQAppInterface, paramString, 3000);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = PstnUtils.a((String)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject2 = ((ArrayList)localObject3).iterator();
            localObject1 = "";
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (AVPhoneUserInfo)((Iterator)localObject2).next();
              if (!a(localPhoneContactManager, ((AVPhoneUserInfo)localObject3).telInfo.mobile, paramArrayList2))
              {
                paramArrayList2.add(new InviteBaseData((AVPhoneUserInfo)localObject3, paramQQAppInterface));
                paramArrayList1.add(((AVPhoneUserInfo)localObject3).telInfo.mobile);
                paramArrayList3.add(((AVPhoneUserInfo)localObject3).telInfo.mobile);
              }
              if (!QLog.isDevelopLevel()) {
                break label766;
              }
              localObject1 = (String)localObject1 + String.format("\n\rAVPhoneUserInfo: %s", new Object[] { localObject3 });
            }
          }
        }
      }
      for (;;)
      {
        break label254;
        bool = true;
        break;
        while (QLog.isDevelopLevel())
        {
          paramQQAppInterface = (String)localObject1 + String.format("\n\rphoneList[%s]", new Object[] { Integer.valueOf(paramArrayList1.size()) });
          paramArrayList1 = paramArrayList1.iterator();
          for (;;)
          {
            if (paramArrayList1.hasNext())
            {
              localObject1 = (String)paramArrayList1.next();
              paramQQAppInterface = paramQQAppInterface + String.format("\n\rphone: %s", new Object[] { localObject1 });
              continue;
              bool = true;
              localObject1 = localObject2;
              break;
            }
          }
          paramQQAppInterface = paramQQAppInterface + String.format("\n\rselectedList[%s]", new Object[] { Integer.valueOf(paramArrayList3.size()) });
          paramArrayList1 = paramArrayList3.iterator();
          while (paramArrayList1.hasNext())
          {
            paramArrayList3 = (String)paramArrayList1.next();
            paramQQAppInterface = paramQQAppInterface + String.format("\n\rselected: %s", new Object[] { paramArrayList3 });
          }
          paramQQAppInterface = paramQQAppInterface + String.format("\n\rinviteList[%s]", new Object[] { Integer.valueOf(paramArrayList2.size()) });
          paramArrayList1 = paramArrayList2.iterator();
          while (paramArrayList1.hasNext())
          {
            paramArrayList2 = (InviteBaseData)paramArrayList1.next();
            paramQQAppInterface = paramQQAppInterface + String.format("\n\rinvite: %s", new Object[] { paramArrayList2 });
          }
          QLog.d("ChatActivityUtils", 4, String.format("checkDiscussMemberNoPhone, onlyMembers[%s], uinType[%s], uin[%s], hasNoPhone[%s], %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool), paramQQAppInterface }));
        }
        return bool;
      }
    }
  }
  
  public static boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramTroopMemberInfo.alias == null) || (paramTroopMemberInfo.alias.length() <= 0))
    {
      bool1 = bool2;
      if (paramTroopMemberInfo.memberuin != null)
      {
        bool1 = bool2;
        if (paramTroopMemberInfo.memberuin.trim().length() > 0)
        {
          bool1 = bool2;
          if (paramTroopMemberInfo.memberuin.trim().equalsIgnoreCase(String.valueOf(0))) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean a(PhoneContactManager paramPhoneContactManager, String paramString, List paramList)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramPhoneContactManager = paramPhoneContactManager.b(paramString);
    if ((paramPhoneContactManager != null) && (!TextUtils.isEmpty(paramPhoneContactManager.uin)) && (!paramPhoneContactManager.uin.equals("0")))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (InviteBaseData)paramString.next();
        if ((paramList.jdField_a_of_type_JavaLangString != null) && (paramList.jdField_a_of_type_JavaLangString.equals(paramPhoneContactManager.uin))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.trim().length() > 0)
      {
        bool1 = bool2;
        if (!paramString.trim().equals(String.valueOf(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    Object localObject;
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = BaseApplication.getContext();
        } while (localObject == null);
        localSharedPreferences = ((Context)localObject).getSharedPreferences("secondHandSharePre", 0);
      } while (localSharedPreferences == null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1).append(paramString2).append(paramString3);
    } while (localSharedPreferences.contains(((StringBuilder)localObject).toString()));
    paramString1 = localSharedPreferences.edit();
    paramString1.putInt(((StringBuilder)localObject).toString(), 0);
    paramString1.commit();
    return true;
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = null;
      return paramString;
    }
    paramString = paramString.toUpperCase();
    int j = paramString.length() / 2;
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static byte[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, paramJSONObject.toString() + "");
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("url"))
        {
          localObject1 = paramJSONObject.getString("url");
          if (!paramJSONObject.has("picture")) {
            break label577;
          }
          str1 = paramJSONObject.getString("picture");
          if (!paramJSONObject.has("title")) {
            break label582;
          }
          str2 = paramJSONObject.getString("title");
          if (!paramJSONObject.has("summary")) {
            break label587;
          }
          str3 = paramJSONObject.getString("summary");
          if (!paramJSONObject.has("brief")) {
            break label593;
          }
          localObject2 = paramJSONObject.getString("brief");
          if (!paramJSONObject.has("layout")) {
            break label599;
          }
          i = paramJSONObject.getInt("layout");
          if (!paramJSONObject.has("source")) {
            break label605;
          }
          str4 = paramJSONObject.getString("source");
          if (i == 6)
          {
            if (!paramJSONObject.has("price")) {
              break label611;
            }
            str5 = paramJSONObject.getString("price");
            if (!paramJSONObject.has("prunit")) {
              break label617;
            }
            str6 = paramJSONObject.getString("prunit");
            if (!paramJSONObject.has("icon")) {
              break label623;
            }
            str7 = paramJSONObject.getString("icon");
            if (!paramJSONObject.has("srcaction")) {
              break label629;
            }
            str8 = paramJSONObject.getString("srcaction");
            if (!paramJSONObject.has("action")) {
              break label635;
            }
            str9 = paramJSONObject.getString("action");
            if (!paramJSONObject.has("a_actionData")) {
              break label641;
            }
            str10 = paramJSONObject.getString("a_actionData");
            if (!paramJSONObject.has("i_actionData")) {
              break label647;
            }
            str11 = paramJSONObject.getString("i_actionData");
            if (!paramJSONObject.has("appid")) {
              break label653;
            }
            paramJSONObject = paramJSONObject.getString("appid");
            localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(41).a((String)localObject2).a(7);
            if (TextUtils.isEmpty(paramJSONObject)) {
              break label660;
            }
            l = Long.parseLong(paramJSONObject);
            paramJSONObject = ((AbsShareMsg.Builder)localObject2).b(l).a(str9, (String)localObject1, null, null, null).a(str4, str7).b(str8, null, null, str10, str11).d((String)localObject1).a();
            localObject1 = StructMsgElementFactory.a(i);
            ((AbsStructMsgItem)localObject1).a(str1, str2, str3, str5, str6, 0);
            paramJSONObject.addItem((AbsStructMsgElement)localObject1);
            return paramJSONObject.getBytes();
          }
          paramJSONObject = paramJSONObject.getString("puin");
          paramJSONObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(1).a((String)localObject2).e((String)localObject1).a(str4, null).b("plugin", null, null, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramJSONObject, "mqqapi://card/show_pslcard?src_type=app&card_type=public_account&version=1&uin=" + paramJSONObject).a();
          localObject1 = StructMsgElementFactory.a(2);
          ((AbsStructMsgItem)localObject1).a(str1, str2, str3);
          paramJSONObject.addItem((AbsStructMsgElement)localObject1);
          paramJSONObject = paramJSONObject.getBytes();
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("ChatActivityUtils", 4, "createSecondHandProductInfoStructMsg---JSONException");
        }
        return null;
      }
      Object localObject1 = null;
      continue;
      label577:
      String str1 = null;
      continue;
      label582:
      String str2 = null;
      continue;
      label587:
      String str3 = null;
      continue;
      label593:
      Object localObject2 = null;
      continue;
      label599:
      int i = 2;
      continue;
      label605:
      String str4 = null;
      continue;
      label611:
      String str5 = null;
      continue;
      label617:
      String str6 = null;
      continue;
      label623:
      String str7 = null;
      continue;
      label629:
      String str8 = null;
      continue;
      label635:
      String str9 = null;
      continue;
      label641:
      String str10 = null;
      continue;
      label647:
      String str11 = null;
      continue;
      label653:
      paramJSONObject = "";
      continue;
      label660:
      long l = -1L;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i;
    try
    {
      localObject = new byte[16];
      i = 0;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    paramArrayOfByte2 = new SecretKeySpec((byte[])localObject, "AES");
    Object localObject = Cipher.getInstance("AES/ECB/NoPadding");
    ((Cipher)localObject).init(2, paramArrayOfByte2);
    paramArrayOfByte1 = ((Cipher)localObject).doFinal(paramArrayOfByte1);
    return paramArrayOfByte1;
    while (i < 16)
    {
      localObject[i] = paramArrayOfByte2[i];
      i += 1;
    }
  }
  
  public static MessageRecord b(List paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.jdField_a_of_type_Int)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int i = paramList.size() - 1;
    label61:
    if (i >= 0)
    {
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if (MsgProxyUtils.g(paramSessionInfo.msgtype)) {}
    }
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i -= 1;
      break label61;
    }
  }
  
  public static String b(int paramInt)
  {
    int i = 999;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return String.valueOf(paramInt);
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 3;
      continue;
      paramInt = 2;
      continue;
      paramInt = 4;
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    int j = 1;
    int k = 0;
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramString2.length();
        if (m >= 16) {
          break label203;
        }
        i = 0;
        str = paramString2;
        if (i < 16 - m)
        {
          paramString2 = paramString2 + "$";
          i += 1;
          continue;
        }
        paramString1 = a(paramString1 + "MasPlay", 32).getBytes("UTF-8");
        paramString2 = new byte[16];
        i = k;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      paramString1 = new SecretKeySpec(paramString2, "AES");
      paramString2 = Cipher.getInstance("AES/ECB/NoPadding");
      paramString2.init(1, paramString1);
      paramString1 = paramString2.doFinal(str.getBytes("utf-8"));
      paramString2 = new StringBuffer();
      if (paramString1.length > 0)
      {
        paramString2.append(paramString1[0]);
        i = j;
        if (i < paramString1.length)
        {
          paramString2.append(",");
          paramString2.append(paramString1[i]);
          i += 1;
          continue;
        }
      }
      paramString1 = paramString2.toString();
      return paramString1;
      label203:
      String str = paramString2;
      if (m > 16)
      {
        return null;
        while (i < 16)
        {
          paramString2[i] = paramString1[i];
          i += 1;
        }
      }
    }
  }
  
  public static void b()
  {
    if ((jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    DialogUtil.a(paramContext, 230, paramContext.getString(2131367661), paramContext.getString(2131367662), new kuj(), null).show();
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    new QQToastNotifier(paramContext).a(paramInt1, paramContext.getResources().getDimensionPixelSize(2131492908), 0, paramInt2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {}
    for (paramQQAppInterface = new Intent(paramActivity, ChatHistoryForC2C.class);; paramQQAppInterface = new Intent(paramActivity, ChatHistory.class))
    {
      paramQQAppInterface.addFlags(536870912);
      paramQQAppInterface.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramQQAppInterface.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramQQAppInterface.putExtra("FriendNick", paramSessionInfo.d);
      paramActivity.startActivityForResult(paramQQAppInterface, 0);
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    long l = paramQQAppInterface.a().a();
    int i = paramQQAppInterface.a().a();
    int j = paramQQAppInterface.a().b(l);
    if ((paramInt1 == 1) || (i == 1))
    {
      if ((j != 2) || (paramInt2 == 2)) {
        break label66;
      }
      paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    }
    label66:
    while ((j == 2) || (paramInt2 != 2)) {
      return;
    }
    paramContext.sendBroadcast(new Intent("com.tencent.av.EXIT_VIDEO_PROCESS"));
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5, Map paramMap, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int i;
    long l;
    int j;
    label804:
    label840:
    Object localObject1;
    Object localObject2;
    if (!paramQQAppInterface.d())
    {
      if (!VcSystemInfo.e())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo device not support!");
        }
        QQToast.a(paramContext, 2131363281, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005756", "0X8005756", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005758", "0X8005758", 0, 0, "", "", VcSystemInfo.d(), "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005759", "0X8005759", 0, 0, "", "", VcSystemInfo.e(), "");
        return true;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005757", "0X8005757", 0, 0, "", "", "", "");
      if (!VcSystemInfo.f())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo earlyDown so not ready!");
        }
        QQToast.a(paramContext, 2131363291, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575A", "0X800575A", 0, 0, "", "", "", "");
        return true;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575B", "0X800575B", 0, 0, "", "", "", "");
      if ((!paramBoolean1) && (!VcSystemInfo.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo sdk not support Video!");
        }
        QQToast.a(paramContext, 2131363283, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575C", "0X800575C", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575D", "0X800575D", 0, 0, "", "", VcSystemInfo.d(), "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575E", "0X800575E", 0, 0, "", "", VcSystemInfo.e(), "");
        return true;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575F", "0X800575F", 0, 0, "", "", "", "");
      if (paramQQAppInterface.a().a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo phone is calling!");
        }
        paramString1 = paramContext.getString(2131363529);
        PopupDialog.a(paramContext, 230, paramContext.getString(2131363525), paramString1, 2131367262, 2131367263, new ktd(paramStartVideoListener, paramBoolean1), null);
        DataReport.a(paramBoolean1);
        if (paramInt == 1024) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_phone_calling_false", 0, 0, "", "", "", "");
        }
        return false;
      }
      if (((paramInt == 1006) && (!a(paramQQAppInterface, paramString1))) || (paramInt == 1024) || (paramInt == 1011))
      {
        new VcSystemInfo();
        VcSystemInfo.a();
        i = VcSystemInfo.f();
        l = VcSystemInfo.c();
        j = Build.VERSION.SDK_INT;
        if ((i < 3) || (l / 1000L < 800L) || (j < 9))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
          }
          if (paramMap != null)
          {
            paramString1 = (String)paramMap.get("chat_type");
            if (paramInt != 1011) {
              break label840;
            }
            paramString2 = paramContext.getString(2131363729);
            PopupDialog.a(paramContext, 230, paramContext.getString(2131363525), paramString2, 2131367262, 2131363540, new kte(paramStartVideoListener), null);
            if (!paramString1.equals("randomc2c")) {
              break label804;
            }
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053B1", "0X80053B1", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            return false;
            paramString1 = "";
            break;
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
          }
          QQToast.a(paramContext, 2131363571, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
          if (paramBoolean1)
          {
            ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
            if (paramInt == 1024) {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_tmp_address_false", 0, 0, "", "", "", "");
            }
          }
          return true;
        }
      }
      if ((paramBoolean1) && (!ConfigSystemImpl.a(paramContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo audio disabled!");
        }
        paramString1 = paramContext.getString(2131363530);
        PopupDialog.a(paramContext, 230, paramContext.getString(2131363525), paramString1, 2131367262, 2131363540, new ktf(paramStartVideoListener), null);
        if (paramBoolean1)
        {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
          if (paramInt == 1024) {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_language_false", 0, 0, "", "", "", "");
          }
        }
        return false;
      }
      if ((paramInt == 1010) && (!paramQQAppInterface.a().a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo don't allow date session!");
        }
        paramQQAppInterface = PopupDialog.a(paramContext, 230, null, paramContext.getString(2131363527), 2131363532, 2131363542, new ktg(paramQQAppInterface, paramBoolean1, paramContext, paramInt, paramString1, paramString2, paramString3, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, paramMap, paramBoolean4, paramBoolean5), new kth(paramBoolean1, paramStartVideoListener));
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setOnCancelListener(new kti(paramBoolean1, paramStartVideoListener));
        }
        return false;
      }
      if ((paramBoolean2) && (a(paramQQAppInterface, paramInt, paramString1, paramString3)) && (paramInt != 1024))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo check shiled msg!");
        }
        if (paramBoolean1) {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
        }
        localObject1 = paramContext.getString(2131363526);
        paramQQAppInterface = PopupDialog.a(paramContext, 230, paramContext.getString(2131363525), (String)localObject1, 2131363532, 2131363542, new ktj(paramQQAppInterface, paramInt, paramString1, paramString3, paramBoolean1, paramContext, paramString2, paramString4, paramStartVideoListener, paramString5, paramMap, paramBoolean4, paramBoolean5), new ktl(paramBoolean1, paramStartVideoListener));
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setOnCancelListener(new ktm(paramBoolean1, paramStartVideoListener));
        }
        return false;
      }
      if (!NetworkUtil.e(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo network not support!");
        }
        QQToast.a(paramContext, 2131367256, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        if (paramBoolean1)
        {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
          if (paramInt == 1024) {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_network_false", 0, 0, "", "", "", "");
          }
        }
        return true;
      }
      paramBoolean2 = NetworkUtil.i(paramContext);
      if ((paramInt == 1024) && (!paramBoolean2) && (NetworkUtil.a(paramContext) == 2))
      {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
        QQToast.a(paramContext, 2131363519, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
        return false;
      }
      if ((!paramBoolean3) || (paramBoolean2) || (NetworkUtil.g(paramContext))) {
        break label3294;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo check wifi!");
      }
      localObject1 = VideoController.d + paramQQAppInterface.a();
      if (paramMap == null) {
        break label3726;
      }
      localObject2 = (String)paramMap.get("chat_type");
      if ((localObject2 != null) && ((((String)localObject2).equals("randomc2c")) || (((String)localObject2).equals("randomgroup")))) {
        localObject1 = VideoController.e + paramQQAppInterface.a();
      }
    }
    label3294:
    label3669:
    label3711:
    label3726:
    for (;;)
    {
      if (VideoController.d((String)localObject1) > 0)
      {
        b(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, false, false, paramStartVideoListener, paramString5, paramMap, paramBoolean4, paramBoolean5, false);
        return true;
        if ("guildgroup".equals(localObject2)) {
          localObject1 = VideoController.f + paramQQAppInterface.a();
        }
      }
      else
      {
        i = NetworkUtil.a(paramContext);
        Object localObject4;
        if (i == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo is 2G!");
          }
          localObject1 = paramContext.getString(2131363525);
          localObject2 = paramContext.getString(2131363518);
          if (!paramBoolean1) {
            break label3711;
          }
          ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
          localObject4 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject4;
        }
        for (;;)
        {
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatActivityUtils", 2, "startVideo title or content is empty");
            }
            return true;
            if ((i == 3) || (i == 4))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatActivityUtils", 2, "startVideo is 3G or 4G!");
              }
              localObject1 = paramContext.getString(2131363525);
              if (paramBoolean1)
              {
                localObject2 = paramContext.getString(2131363521);
                ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
                localObject4 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject4;
                continue;
              }
              localObject4 = paramContext.getString(2131363520);
              localObject2 = localObject1;
              localObject1 = localObject4;
            }
          }
          else
          {
            paramQQAppInterface = PopupDialog.a(paramContext, 230, (String)localObject2, (String)localObject1, 2131363532, 2131363537, new ktn(paramBoolean1, i, paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramString4, paramStartVideoListener, paramString5, paramMap, paramBoolean4, paramBoolean5), new kto(paramBoolean1, i, paramStartVideoListener));
            if (paramQQAppInterface != null) {
              paramQQAppInterface.setOnCancelListener(new ktp(paramBoolean1, i, paramStartVideoListener));
            }
            return false;
            i = paramQQAppInterface.a().g();
            j = paramQQAppInterface.a().b();
            int k = paramQQAppInterface.a().c();
            if (paramMap != null)
            {
              localObject1 = (String)paramMap.get("chat_type");
              if ((localObject1 != null) && ((((String)localObject1).equals("randomgroup")) || (((String)localObject1).equals("randomc2c"))))
              {
                localObject4 = (String)paramMap.get("session_name");
                l = -1L;
                localObject2 = localObject1;
                localObject1 = localObject4;
              }
            }
            for (;;)
            {
              if (((k == 1) || (k == 2)) && (j >= 1) && (j <= 5))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ChatActivityUtils", 2, "startVideo is in Double Random Call!");
                }
                if ((localObject1 == null) || (!((String)localObject2).equals("randomc2c")) || (!((String)localObject1).equals(paramQQAppInterface.a().a())))
                {
                  QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
                  a(paramQQAppInterface, paramMap);
                  return true;
                  if (!"guildgroup".equals(localObject1)) {
                    break label3669;
                  }
                  try
                  {
                    l = Long.parseLong((String)paramMap.get("group_id"));
                    localObject2 = localObject1;
                    localObject1 = null;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    localObject4 = null;
                    localObject3 = localObject1;
                    l = -1L;
                    localObject1 = localObject4;
                  }
                }
              }
              else
              {
                if ((paramBoolean5) && ((k == 3) || (k == 4)) && (j >= 1) && (j <= 5))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ChatActivityUtils", 2, "startVideo is Multi Random calling!");
                  }
                  if (((!TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.equals((CharSequence)localObject1, paramQQAppInterface.a().a()))) || (("guildgroup".equals(localObject3)) && (l > 0L) && (l == paramQQAppInterface.a().b()))) {
                    i = 1;
                  }
                }
                while (i == 0)
                {
                  PopupDialog.a(paramContext, 230, null, paramContext.getString(2131363466), 2131363532, 2131363537, new ktq(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, paramMap, paramBoolean4), new ktr(paramStartVideoListener));
                  a(paramQQAppInterface, paramMap);
                  return false;
                  i = 0;
                  continue;
                  if (i == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ChatActivityUtils", 2, "startVideo is calling!");
                    }
                    if ((paramBoolean1) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().f()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().f()))) || ((paramInt == 1006) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().g()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().g())))))))
                    {
                      if (paramStartVideoListener != null) {
                        paramStartVideoListener.b();
                      }
                      if (paramQQAppInterface.a().b(paramQQAppInterface.a().f()))
                      {
                        paramString1 = new Intent(paramContext, AVActivity.class);
                        paramString1.addFlags(262144);
                        paramString1.addFlags(268435456);
                        paramString1.putExtra("sessionType", 3);
                        paramString1.putExtra("GroupId", paramQQAppInterface.a().f());
                        paramString1.putExtra("isDoubleVideoMeeting", true);
                        paramContext.startActivity(paramString1);
                        if (paramStartVideoListener != null) {
                          paramStartVideoListener.c();
                        }
                      }
                    }
                    for (;;)
                    {
                      return true;
                      a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5, paramMap, false);
                      break;
                      QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
                      a(paramQQAppInterface, paramMap);
                    }
                  }
                  if (i == 2)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ChatActivityUtils", 2, "startVideo is calling!");
                    }
                    if ((!paramBoolean1) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().f()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().f()))) || ((paramInt == 1006) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().g()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().g())))))))
                    {
                      if (paramStartVideoListener != null) {
                        paramStartVideoListener.b();
                      }
                      if (paramQQAppInterface.a().b(paramQQAppInterface.a().f()))
                      {
                        paramString1 = new Intent(paramContext, AVActivity.class);
                        paramString1.addFlags(262144);
                        paramString1.addFlags(268435456);
                        paramString1.putExtra("sessionType", 3);
                        paramString1.putExtra("GroupId", paramQQAppInterface.a().f());
                        paramString1.putExtra("isDoubleVideoMeeting", true);
                        paramContext.startActivity(paramString1);
                        if (paramStartVideoListener != null) {
                          paramStartVideoListener.c();
                        }
                      }
                    }
                    for (;;)
                    {
                      return true;
                      a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5, paramMap, false);
                      break;
                      QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
                      a(paramQQAppInterface, paramMap);
                    }
                  }
                  if ((paramBoolean5) && ((i == 3) || (i == 4)))
                  {
                    if (paramQQAppInterface.a().a() > 0L)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ChatActivityUtils", 2, "startVideo is multi calling!");
                      }
                      PopupDialog.a(paramContext, 230, null, paramContext.getString(2131363466), 2131363532, 2131363537, new kts(paramInt, paramMap, paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, paramBoolean4), new ktt(paramStartVideoListener));
                      a(paramQQAppInterface, paramMap);
                      return false;
                    }
                  }
                  else if (paramQQAppInterface.a().a().jdField_b_of_type_Int != -1)
                  {
                    QQToast.a(paramContext, 2131363475, 1).b(paramContext.getResources().getDimensionPixelSize(2131492908));
                    a(paramQQAppInterface, paramMap);
                    return true;
                  }
                }
              }
              localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
              if ((paramInt == 0) && (!((FriendsManager)localObject1).b(paramString1)))
              {
                if (paramBoolean1) {}
                for (paramInt = 2131363697;; paramInt = 2131363696)
                {
                  paramQQAppInterface = paramContext.getString(paramInt);
                  DialogUtil.a(paramContext, 230, paramContext.getString(2131363525), paramQQAppInterface, 2131367262, 2131363541, new ktu(), null).show();
                  return false;
                }
              }
              if ((paramBoolean4) && (!paramBoolean1) && (paramInt != 1) && (paramInt != 3000) && (paramInt != 9500) && (!paramQQAppInterface.a().d(paramString1)) && (AVNotifyCenter.f(paramQQAppInterface.a())))
              {
                if (AVNotifyCenter.e(paramQQAppInterface.a()))
                {
                  jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramContext, 230, 2130903526, null, paramContext.getString(2131363522), 2131363163, 2131363160, new ktw(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramStartVideoListener, paramString5, paramMap, paramBoolean5), new ktx(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramStartVideoListener, paramString5, paramMap, paramBoolean5));
                  jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
                  ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005014", "0X8005014", 0, 0, "", "", "", "");
                  return false;
                }
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800501B", "0X800501B", 0, 0, "", "", "", "");
              }
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005766", "0X8005766", 0, 0, "", "", "", "");
              if (paramStartVideoListener != null) {
                paramStartVideoListener.b();
              }
              a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5, paramMap, paramBoolean6);
              if (paramStartVideoListener != null) {
                paramStartVideoListener.c();
              }
              return true;
              localObject4 = null;
              localObject3 = localObject1;
              l = -1L;
              localObject1 = localObject4;
              continue;
              localObject1 = null;
              localObject3 = null;
              l = -1L;
            }
          }
          localObject1 = null;
          Object localObject3 = null;
          continue;
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
        }
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, ArrayList paramArrayList, int paramInt2, int paramInt3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (!NetworkUtil.h(paramContext))
    {
      QQToast.a(paramContext, 0, 2131367481, 0).a();
      return false;
    }
    Object localObject2 = PstnUtils.b(paramQQAppInterface, 2);
    String str1 = PstnUtils.c(paramQQAppInterface, 2);
    String str2 = PstnUtils.d(paramQQAppInterface, 2);
    Object localObject3 = (PstnManager)paramQQAppInterface.getManager(142);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("PstnLevel", "LEVEL2");
    ((Map)localObject1).put("PLACE", "CALL_CREATE");
    long l2 = 0L;
    long l1;
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      if (paramQQAppInterface.a().a().containsKey(Long.valueOf(l1)))
      {
        String str3 = (String)paramQQAppInterface.a().a().get(Long.valueOf(l1));
        paramQQAppInterface.a().a().remove(Long.valueOf(l1));
        ((Map)localObject1).put("CREATE_PLACE", str3);
      }
      if ((((PstnManager)localObject3).a() == 0) || (paramInt2 == 0))
      {
        ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
        return a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatActivityUtils", 2, "NumberFormatException uin = " + paramString);
          l1 = l2;
        }
      }
    }
    ArrayList localArrayList;
    if (paramInt2 == 1)
    {
      ((Map)localObject1).put("ipPstnEnterType", String.valueOf(paramInt2));
      localObject3 = new ArrayList();
      localArrayList = new ArrayList();
      if (paramArrayList != null) {
        ((ArrayList)localObject3).addAll(paramArrayList);
      }
      if (PstnUtils.a(paramQQAppInterface, 2)) {
        if (!PstnUtils.a(paramQQAppInterface, paramContext))
        {
          paramArrayList = new ArrayList();
          paramBoolean3 = true;
          if (paramInt3 != 2) {
            break label1381;
          }
          paramBoolean3 = false;
        }
      }
    }
    label771:
    label850:
    label857:
    label864:
    label1381:
    for (paramInt3 = 2131372486;; paramInt3 = 2131372485)
    {
      if (!a(paramQQAppInterface, paramBoolean3, paramInt1, paramString, (ArrayList)localObject3, paramArrayList, localArrayList))
      {
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
          ((Map)localObject1).put("PhoneNumberList", PstnUtils.b((ArrayList)localObject3));
        }
        if ((PstnUtils.b(paramQQAppInterface, 2)) && (paramBoolean5))
        {
          DialogUtil.a(paramContext, 230, "时长不足", PstnUtils.a(paramQQAppInterface, 2), "购买时长", "继续拨打", new kun(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1), new ksp(paramQQAppInterface, paramContext)).show();
          return false;
        }
        a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
      }
      for (;;)
      {
        return false;
        PhoneContactSelectActivity.a(paramContext, paramInt2, localArrayList, paramInt3);
        return true;
        if ((paramInt3 == 6) || (paramInt3 == 3)) {
          DialogUtil.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131363161), str2, new ksq(paramQQAppInterface, paramContext, paramStartVideoListener, paramInt3), new ksr(paramQQAppInterface, paramInt3)).show();
        }
        for (;;)
        {
          return false;
          PstnUtils.a(paramQQAppInterface, paramContext, 2, 12);
        }
        if (PstnUtils.a(paramQQAppInterface, 2))
        {
          localObject2 = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
          if ((localObject2 != null) && (((PhoneContactManagerImp)localObject2).d() >= 6))
          {
            localObject2 = ((PstnManager)localObject3).a(paramQQAppInterface.a());
            int i;
            if ((localObject2 != null) && (((PstnCardInfo)localObject2).pstn_multi_call_time > 0))
            {
              i = 1;
              int j = UITools.a(paramInt1);
              l1 = Long.valueOf(paramString).longValue();
              if ((paramQQAppInterface.a().a(j, l1)) || (((PstnManager)localObject3).e() != 1) || (((PstnManager)localObject3).b()) || ((!a(paramQQAppInterface, paramInt1, paramString, paramArrayList)) && (NetworkUtil.b(paramContext) != 2)) || (i == 0) || (6 == paramInt3) || (!paramBoolean4)) {
                break label864;
              }
              localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131372512);
              localObject2 = paramQQAppInterface.getApplication().getResources().getString(2131372513);
              str2 = ((PstnManager)localObject3).a("pstn_multi_trans_wording");
              str1 = ((PstnManager)localObject3).a("pstn_multi_trans_check_wording");
              if (!TextUtils.isEmpty(str2)) {
                break label850;
              }
              if (!TextUtils.isEmpty(str1)) {
                break label857;
              }
            }
            for (;;)
            {
              DialogUtil.a(paramContext, 230, "确认呼叫方式", (String)localObject1, (String)localObject2, "取消", "呼叫", null, new kss((PstnManager)localObject3, paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramStartVideoListener, paramArrayList, paramInt2, paramInt3, paramBoolean5), new kst(paramStartVideoListener, paramQQAppInterface)).show();
              return false;
              i = 0;
              break;
              localObject1 = str2;
              break label771;
              localObject2 = str1;
            }
            if ((PstnUtils.b(paramQQAppInterface, 2)) && (paramBoolean5))
            {
              DialogUtil.a(paramContext, 230, "时长不足", PstnUtils.a(paramQQAppInterface, 2), "购买时长", "继续拨打", new ksu(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramStartVideoListener, paramArrayList, paramInt2, paramInt3, paramBoolean4), new ksv(paramQQAppInterface, paramContext)).show();
              return false;
            }
            if (paramInt2 == 4) {
              ((Map)localObject1).put("ipPstnEnterType", String.valueOf(4));
            }
            for (;;)
            {
              if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
                ((Map)localObject1).put("PhoneNumberList", PstnUtils.b(paramArrayList));
              }
              a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
              break;
              ((Map)localObject1).put("ipPstnEnterType", String.valueOf(2));
            }
          }
          if ((paramInt2 == 3) && ((paramArrayList == null) || (paramArrayList.size() == 0)))
          {
            ((Map)localObject1).put("PstnLevel", "LEVEL2");
            ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
            a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
          }
          else
          {
            PstnUtils.a(paramQQAppInterface, paramContext);
          }
        }
        else if ((paramInt3 == 3) || (paramInt3 == 6))
        {
          localObject3 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
          if ((localObject3 != null) && (((List)localObject3).size() == 1) && (((DiscussionMemberInfo)((List)localObject3).get(0)).memberUin.equals(paramQQAppInterface.a())))
          {
            DialogUtil.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131363161), str2, new ksw(paramQQAppInterface, paramContext, paramStartVideoListener, paramInt3), new ksx(paramQQAppInterface, paramInt3)).show();
          }
          else if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            DialogUtil.a(paramContext, (String)localObject2, str1, str2, new ksy(paramQQAppInterface, paramContext, paramStartVideoListener, paramInt3), paramContext.getString(2131364007), new kta((Map)localObject1, paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, paramInt3)).show();
          }
          else
          {
            ((Map)localObject1).put("PstnLevel", "LEVEL2");
            ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
            a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
          }
        }
        else
        {
          DialogUtil.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131363161), str2, new ktb(paramQQAppInterface, paramContext, paramStartVideoListener), new ktc()).show();
        }
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 3000) || (i == 1006) || (i == 1021) || (i == 1010) || (i == 1001) || (i == 1025);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatActivityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */