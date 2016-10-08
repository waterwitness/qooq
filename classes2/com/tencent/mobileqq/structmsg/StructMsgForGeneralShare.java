package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout18;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5Adapter;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6Adapter;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout8;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout9;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLongMsgHolder;
import com.tencent.mobileqq.structmsg.view.StructMsgItemMore;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import uuy;
import uvg;
import uvh;
import uvi;
import uvj;
import uvk;
import uvn;

public class StructMsgForGeneralShare
  extends AbsShareMsg
{
  public static final String LOGO_URL_POSTFIX = ".png";
  public static final String LOGO_URL_PREFIX = "http://combo.b.qq.com/mp/api/logo/";
  private static View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new uvk();
  private static String jdField_a_of_type_JavaLangString;
  public static int clickedItemIndex;
  public static String eventId;
  public static String eventType;
  public static String remindBrief;
  public static String tips;
  public String author;
  public long bid;
  public long commentNum;
  public boolean havaPayInfoInit = false;
  public boolean isFull;
  public boolean isLike;
  public long likeNum;
  WeakReference mContext = new WeakReference(null);
  WeakReference mExpandView = new WeakReference(null);
  public List mHadPaidList = new ArrayList();
  public boolean mIsPAVideoStructMsg;
  public String mPARedPacket = "";
  public String mVipDonateStr = "";
  public String mWarningTips = "";
  public long pVersion;
  public String pid;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "structmsg.StructMsgForGeneralShare";
    eventId = "";
    remindBrief = "";
    eventType = "";
    tips = "";
  }
  
  StructMsgForGeneralShare()
  {
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
  }
  
  StructMsgForGeneralShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentLayout = 2;
    this.mMsgServiceID = paramBundle.getInt("req_type", 1);
    this.mNeedRound = paramBundle.getString("icon_need_round");
    String str1;
    String str3;
    boolean bool;
    AbsStructMsgItem localAbsStructMsgItem1;
    if (this.mSourceName != null)
    {
      if (this.mSourceName.equalsIgnoreCase("订阅号")) {
        this.mMsgServiceID = 54;
      }
    }
    else
    {
      this.mCreateTime = paramBundle.getString("req_create_time");
      String str2 = paramBundle.getString("source_puin");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
      this.source_puin = str1;
      this.mSourceUrl = paramBundle.getString("source_url");
      str1 = paramBundle.getString("detail_url");
      str2 = paramBundle.getString("category");
      str3 = paramBundle.getString("video_url");
      bool = paramBundle.getBoolean("video_url_load", false);
      int i = paramBundle.getInt("layout_item", 2);
      if (!TextUtils.isEmpty(str3)) {
        i = 5;
      }
      localAbsStructMsgItem1 = StructMsgElementFactory.a(i);
      if (TextUtils.isEmpty(str2)) {
        break label347;
      }
      AbsStructMsgItem localAbsStructMsgItem2 = StructMsgElementFactory.a(0);
      localAbsStructMsgItem2.d(1);
      localAbsStructMsgItem2.b(str2);
      addItem(localAbsStructMsgItem2);
      if (!TextUtils.isEmpty(str3)) {
        break label314;
      }
      localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, this.mContentSummary, 1);
    }
    for (;;)
    {
      addItem(localAbsStructMsgItem1);
      if (this.mMsgAction == null) {
        this.mMsgAction = "web";
      }
      return;
      if (!this.mSourceName.equalsIgnoreCase("看点")) {
        break;
      }
      this.mMsgServiceID = 53;
      break;
      label314:
      a(localAbsStructMsgItem1, bool, str1, this.mContentCover, str3, this.mContentTitle, this.mContentSummary, paramBundle);
      localAbsStructMsgItem1.k = 1;
      continue;
      label347:
      if (TextUtils.isEmpty(str3))
      {
        localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, this.mContentSummary, 0, this.mNeedRound);
      }
      else
      {
        a(localAbsStructMsgItem1, bool, str1, this.mContentCover, str3, this.mContentTitle, this.mContentSummary, paramBundle);
        localAbsStructMsgItem1.k = 0;
      }
    }
  }
  
  StructMsgForGeneralShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mWarningTips = paramStructMsgNode.a("warningTipsContent");
    this.mPARedPacket = paramStructMsgNode.a("paRedPacket");
    this.mVipDonateStr = paramStructMsgNode.a("vipDonate");
    this.pid = paramStructMsgNode.a("pid");
    String str2 = paramStructMsgNode.a("bid");
    String str1 = str2;
    if (str2 == null) {
      str1 = "0";
    }
    this.bid = Long.valueOf(str1).longValue();
    str2 = paramStructMsgNode.a("pVersion");
    str1 = str2;
    if (str2 == null) {
      str1 = "0";
    }
    this.pVersion = Long.valueOf(str1).longValue();
    str1 = paramStructMsgNode.a("isFull");
    if ((str1 != null) && (Boolean.valueOf(str1).booleanValue()))
    {
      bool1 = true;
      this.isFull = bool1;
      str2 = paramStructMsgNode.a("likeNum");
      str1 = str2;
      if (str2 == null) {
        str1 = "0";
      }
      this.likeNum = Long.valueOf(str1).longValue();
      str2 = paramStructMsgNode.a("commentNum");
      str1 = str2;
      if (str2 == null) {
        str1 = "0";
      }
      this.commentNum = Long.valueOf(str1).longValue();
      str1 = paramStructMsgNode.a("isLike");
      if ((str1 == null) || (!Boolean.valueOf(str1).booleanValue())) {
        break label336;
      }
    }
    label336:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isLike = bool1;
      this.author = paramStructMsgNode.a("author");
      eventId = paramStructMsgNode.a("eventId");
      remindBrief = paramStructMsgNode.a("remindBrief");
      eventType = paramStructMsgNode.a("eventType");
      tips = paramStructMsgNode.a("tips");
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(Context paramContext, int paramInt, View paramView)
  {
    if (paramView == null) {}
    AbsStructMsgElement localAbsStructMsgElement;
    do
    {
      do
      {
        return;
        if ((paramInt <= 2) && (paramInt - 1 >= 0))
        {
          i = AIOUtils.a(12.0F, paramContext.getResources());
          j = paramView.getPaddingBottom();
          int k = paramView.getPaddingLeft();
          int m = paramView.getPaddingRight();
          localAbsStructMsgElement = getItemByIndex(paramInt - 1);
          if (((localAbsStructMsgElement instanceof StructMsgItemLayoutDefault)) && (((StructMsgItemLayoutDefault)localAbsStructMsgElement).a.size() == 1) && ((((StructMsgItemLayoutDefault)localAbsStructMsgElement).a.get(0) instanceof StructMsgItemHr)) && (paramInt - 2 >= 0) && ((getItemByIndex(paramInt - 2) instanceof StructMsgItemLayout5)) && (StructMsgItemLayout5Adapter.a((AbsStructMsgItem)getItemByIndex(paramInt - 2), paramInt - 2)))
          {
            paramView.setPadding(k, i, m, j);
            return;
          }
          if (((localAbsStructMsgElement instanceof StructMsgItemLayout5)) && (StructMsgItemLayout5Adapter.a((AbsStructMsgItem)localAbsStructMsgElement, paramInt - 1)))
          {
            paramView.setPadding(k, i, m, j);
            return;
          }
        }
      } while (paramInt != getItemCount() - 1);
      localAbsStructMsgElement = getItemByIndex(0);
    } while ((!(localAbsStructMsgElement instanceof StructMsgItemLayout5)) || (!StructMsgItemLayout5Adapter.a((AbsStructMsgItem)localAbsStructMsgElement, 0)));
    paramInt = AIOUtils.a(12.0F, paramContext.getResources());
    int i = paramView.getPaddingLeft();
    int j = paramView.getPaddingRight();
    paramView.setPadding(i, paramView.getPaddingTop(), j, paramInt);
  }
  
  private void a(AbsStructMsgItem paramAbsStructMsgItem, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("VINFO");
    String str2 = paramBundle.getString("TINFO");
    int i = paramBundle.getInt("PREVIEW_VIDEO_TIME", 0);
    int j = paramBundle.getInt("PREVIEW_VIDEO_WIDTH", 0);
    int k = paramBundle.getInt("PREVIEW_VIDEO_HEIGHT", 0);
    int m = paramBundle.getInt("FULL_VIDEO_TIME", 0);
    String str3 = paramBundle.getString("ACCOUNT_UIN");
    String str4 = paramBundle.getString("ACCOUNT_NAME");
    String str5 = paramBundle.getString("ARTICLE_ID");
    int n = paramBundle.getInt("TYPE", 0);
    if (PAVideoStructMsgUtil.a(n)) {}
    for (paramString2 = new StructMsgItemVideo(paramString2, n, str1, str2, paramString5, i, j, k, m, str3, str4, str5);; paramString2 = new StructMsgItemVideo(paramString2, paramString3, paramBoolean))
    {
      paramString2.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
      paramString2.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl = paramString1;
      paramAbsStructMsgItem.a(paramString2);
      paramAbsStructMsgItem.a(new StructMsgItemTitle(paramString4));
      return;
    }
  }
  
  public static String getCoverForChatHistory(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof StructMsgItemCover)) {
      return ((StructMsgItemCover)paramAbsStructMsgElement).o;
    }
    return null;
  }
  
  static String getResponseRedirectLocation(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setInstanceFollowRedirects(false);
      paramString.setRequestMethod("GET");
      paramString.setConnectTimeout(3000);
      paramString.connect();
      paramString = paramString.getHeaderField("location");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getResponseRedirectLocation  location = " + paramString);
      }
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getResponseRedirectLocation  MalformedURLException ", paramString);
        }
        paramString = null;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getResponseRedirectLocation  IOException ", paramString);
        }
        paramString = null;
      }
    }
  }
  
  public static String getTitleForChatHistory(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement instanceof AbsStructMsgTextElement)) {
      return ((AbsStructMsgTextElement)paramAbsStructMsgElement).u;
    }
    return null;
  }
  
  static boolean handleNearbyPublicAccountMsg(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    bool2 = false;
    bool1 = bool2;
    String str1;
    String str2;
    if (paramStructMsgForGeneralShare.mMsgBrief.contains("找校友"))
    {
      str1 = getResponseRedirectLocation(paramStructMsgForGeneralShare.mMsgUrl);
      bool1 = bool2;
      if (str1 != null)
      {
        bool1 = bool2;
        if (str1.contains("find_school_mate_guide"))
        {
          int i = str1.indexOf("find_school_mate_guide");
          bool1 = bool2;
          if (i > 0) {
            str2 = str1.substring(i + "find_school_mate_guide".length() + 1);
          }
        }
      }
    }
    try
    {
      str2 = URLDecoder.decode(str2, "UTF-8");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleNearbyPublicAccountMsg find shoolmate msg clicked, url =  " + str1 + ",schema = " + str2);
      }
      paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramContext, str2);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.b();
        bool1 = true;
      }
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleNearbyPublicAccountMsg  result = " + bool1 + ",msg.mMsgBrief = " + paramStructMsgForGeneralShare.mMsgBrief);
    }
    return bool1;
  }
  
  public static void onClickEvent(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, View paramView, StructMsgForGeneralShare.GeneralClickHandler paramGeneralClickHandler)
  {
    Object localObject1 = paramView.getTag();
    label101:
    boolean bool1;
    if ((localObject1 != null) && ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)))
    {
      localObject1 = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).a;
      paramStructMsgForGeneralShare.uniseq = ((ChatMessage)localObject1).uniseq;
      paramStructMsgForGeneralShare.uin = ((ChatMessage)localObject1).frienduin;
      paramStructMsgForGeneralShare.uinType = ((ChatMessage)localObject1).istroop;
      paramStructMsgForGeneralShare.currentAccountUin = ((ChatMessage)localObject1).selfuin;
      paramStructMsgForGeneralShare.messageVersion = ((ChatMessage)localObject1).versionCode;
      if (!"web".equals(paramStructMsgForGeneralShare.mMsgAction)) {
        break label1441;
      }
      if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgActionData)) {
        break label379;
      }
      paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData;
      if ((TextUtils.isEmpty(paramView)) || (!paramView.startsWith("mqqapi://dating/"))) {
        break label387;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handle dating jump .msg.mMsgUrl = " + paramStructMsgForGeneralShare.mMsgUrl);
      }
      paramView = new Intent(paramContext, QQBrowserActivity.class);
      paramView.putExtra("url", paramStructMsgForGeneralShare.mMsgUrl);
      paramContext.startActivity(paramView);
      bool1 = true;
    }
    int i;
    label379:
    label387:
    boolean bool2;
    for (;;)
    {
      i = 0;
      if (bool1) {
        i = 1;
      }
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
      paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
      do
      {
        return;
      } while ((localObject1 == null) || (!(localObject1 instanceof ChatHistoryStructAdapter.HistoryStructItemHolder)));
      localObject1 = (ChatMessage)((ChatHistoryStructAdapter.HistoryStructItemHolder)localObject1).a;
      break;
      paramView = paramStructMsgForGeneralShare.mMsgActionData;
      break label101;
      if ((!TextUtils.isEmpty(paramView)) && ((paramStructMsgForGeneralShare.mMsgServiceID == 65) || (paramStructMsgForGeneralShare.mMsgServiceID == 69)))
      {
        paramGeneralClickHandler = new Intent(paramContext, NearbyTransitActivity.class);
        paramGeneralClickHandler.putExtra("action", 1);
        paramGeneralClickHandler.putExtra("hotnamecode", paramView);
        paramGeneralClickHandler.putExtra("enter_time", System.currentTimeMillis());
        paramContext.startActivity(paramGeneralClickHandler);
        bool1 = true;
      }
      else
      {
        if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("story:")))
        {
          paramContext = JumpParser.a(paramQQAppInterface, paramContext, paramView.substring("story:".length()));
          if (paramContext != null) {
            paramContext.b();
          }
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString + "Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "handle now jump actionData = " + paramView);
            bool1 = bool2;
            break;
            paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          }
        }
        if (paramStructMsgForGeneralShare.mMsgServiceID != 60) {
          break label618;
        }
        paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
        bool1 = false;
      }
    }
    label618:
    Object localObject2;
    String[] arrayOfString;
    if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) && ((paramStructMsgForGeneralShare.mMsgUrl.startsWith("http://now.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://now.qq.com"))))
    {
      localObject1 = (NowProxy)paramQQAppInterface.getManager(181);
      localObject2 = paramStructMsgForGeneralShare.mMsgUrl.substring(paramStructMsgForGeneralShare.mMsgUrl.indexOf("?") + 1).split("&");
      i = 2;
      int j = 0;
      paramView = "0";
      while (j < localObject2.length)
      {
        arrayOfString = localObject2[j].split("=");
        if (arrayOfString.length != 2)
        {
          label730:
          j += 1;
        }
        else
        {
          if (!"roomid".equals(arrayOfString[0])) {
            break label2334;
          }
          paramView = arrayOfString[1];
        }
      }
    }
    label936:
    label1170:
    label1194:
    label1250:
    label1441:
    label2171:
    label2193:
    label2206:
    label2311:
    label2331:
    label2334:
    label2337:
    for (;;)
    {
      try
      {
        if (!"bid".equals(arrayOfString[0])) {
          break label2337;
        }
        int k = Integer.parseInt(arrayOfString[1]);
        i = k;
      }
      catch (NumberFormatException localNumberFormatException) {}
      break label730;
      try
      {
        long l = Long.parseLong(paramView);
        paramView = new NowFromData();
        paramView.jdField_a_of_type_JavaLangString = "now_share";
        paramView.jdField_b_of_type_JavaLangString = "shareobj";
        if ((0L != l) && (((NowProxy)localObject1).a(null, l, paramView, SharedPreUtils.a(paramContext, paramQQAppInterface.a(), i), null))) {
          break label936;
        }
        bool2 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
      }
      catch (NumberFormatException paramContext)
      {
        for (;;)
        {
          paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          bool2 = false;
        }
      }
      bool1 = bool2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString + "Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "handle now jump .msg.mMsgUrl = " + paramStructMsgForGeneralShare.mMsgUrl);
      bool1 = bool2;
      break;
      if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("apollo:")))
      {
        paramView = paramStructMsgForGeneralShare.mMsgUrl.split("\\?");
        if ((paramView.length == 2) && (ApolloManager.a(paramContext)))
        {
          paramView = paramView[1];
          paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqapi://cmshow/apollo_action?" + paramView)));
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
      }
      if (((ChatMessage)localObject1).istroop == 1)
      {
        paramView = (TroopInfoManager)paramQQAppInterface.getManager(36);
        if ((paramView != null) && (paramView.b(paramStructMsgForGeneralShare.mMsgUrl)) && (paramView.b()) && (!MultiForwardActivity.class.isInstance(paramContext)))
        {
          bool1 = paramGeneralClickHandler.a("playVideo", paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
          break;
        }
        bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
        break;
      }
      if (paramStructMsgForGeneralShare.hasFlag(16))
      {
        paramContext = paramStructMsgForGeneralShare.mMsgUrl;
        if (paramContext == null) {
          break label2331;
        }
        paramView = new StringBuilder().append(paramContext);
        if (paramContext.indexOf('?') != -1)
        {
          paramContext = "&";
          paramContext = paramView.append(paramContext).append("f_hbType=");
          if (((ChatMessage)localObject1).istroop != 1) {
            break label1250;
          }
          i = 1;
          paramContext = i + "&f_hbUin=" + ((ChatMessage)localObject1).frienduin;
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PortalManager", 4, paramContext);
        }
        bool1 = paramGeneralClickHandler.a(paramContext);
        break;
        paramContext = "?";
        break label1170;
        i = 2;
        break label1194;
        if ((paramStructMsgForGeneralShare.mMsgServiceID == 53) || (paramStructMsgForGeneralShare.mMsgServiceID == 54))
        {
          try
          {
            if (!paramGeneralClickHandler.c("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&url=" + URLEncoder.encode(paramStructMsgForGeneralShare.mMsgUrl) + "&from=" + paramStructMsgForGeneralShare.mMsgServiceID, null))
            {
              bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
              break;
            }
            bool1 = true;
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "ReadInJoyShareMsg click error, url =  " + paramStructMsgForGeneralShare.mMsgUrl);
            }
            paramContext.printStackTrace();
            bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          }
          break;
        }
        if (paramStructMsgForGeneralShare.uin.equals("3242766078")) {}
        for (bool2 = handleNearbyPublicAccountMsg(paramQQAppInterface, paramContext, paramStructMsgForGeneralShare);; bool2 = false)
        {
          bool1 = bool2;
          if (bool2) {
            break;
          }
          bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgUrl);
          break;
          if ("plugin".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            if (paramQQAppInterface != null) {}
            for (bool1 = paramGeneralClickHandler.c(paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);; bool1 = false)
            {
              i = 0;
              if (bool1) {
                i = 1;
              }
              ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
              paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
              ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
              return;
            }
          }
          if ("viewMultiMsg".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            paramGeneralClickHandler = (FragmentActivity)paramContext;
            if (paramGeneralClickHandler.getChatFragment() != null)
            {
              i = paramGeneralClickHandler.getChatFragment().a().b();
              paramView = paramGeneralClickHandler.getChatFragment().a().a();
              paramGeneralClickHandler = paramGeneralClickHandler.getChatFragment().a().c();
              localObject1 = new Intent(paramContext, MultiForwardActivity.class);
              ((Intent)localObject1).putExtra("chat_subType", 3);
              ((Intent)localObject1).putExtra("uin", paramView);
              ((Intent)localObject1).putExtra("uintype", i);
              ((Intent)localObject1).putExtra("troop_code", paramGeneralClickHandler);
              ((Intent)localObject1).putExtra("multi_url", paramStructMsgForGeneralShare.mResid);
              ((Intent)localObject1).putExtra("multi_uniseq", paramStructMsgForGeneralShare.uniseq);
              ((Intent)localObject1).putExtra("multi_source", paramStructMsgForGeneralShare.mSourceName);
              paramContext.startActivity((Intent)localObject1);
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            i = 0;
            if (bool1) {
              i = 1;
            }
            ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
            paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(paramStructMsgForGeneralShare.mMsgUrl));
            ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
            return;
            if (!"viewFlower".equals(paramStructMsgForGeneralShare.mMsgAction)) {
              break;
            }
            paramGeneralClickHandler.a(paramView, paramStructMsgForGeneralShare.uin);
          }
          if ("shareBusinessCard".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            if (paramStructMsgForGeneralShare.mMsg_A_ActionData == null) {
              break label2311;
            }
            paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData.split(";");
            if ((paramView == null) || (paramView.length != 3)) {
              break label2311;
            }
            localObject1 = paramView[0].substring("url=".length());
            paramGeneralClickHandler = paramView[1].substring("name=".length());
          }
          for (paramView = paramView[2].substring("phone=".length());; paramView = "")
          {
            Object localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = (BusinessCardManager)paramQQAppInterface.getManager(111);
              if (localObject2 != null)
              {
                localObject3 = ((BusinessCardManager)localObject2).c((String)localObject1);
                localObject2 = new Intent(paramContext, BusinessCardEditActivity.class);
                if (localObject3 == null) {
                  break label2206;
                }
                ((Intent)localObject2).putExtra("cur_card_id", ((BusinessCard)localObject3).cardId);
                if (((BusinessCard)localObject3).cardType != 1) {
                  break label2193;
                }
                ((Intent)localObject2).putExtra("mode_type", 3);
                ((Intent)localObject2).putExtra("is_edit_mode", false);
              }
            }
            for (;;)
            {
              paramContext.startActivity((Intent)localObject2);
              bool1 = false;
              break;
              ((Intent)localObject2).putExtra("mode_type", 0);
              break label2171;
              localObject3 = new CardOCRInfo();
              ((CardOCRInfo)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject1);
              ((CardOCRInfo)localObject3).jdField_a_of_type_JavaLangString = paramGeneralClickHandler;
              ((CardOCRInfo)localObject3).jdField_b_of_type_JavaUtilList.add(paramView);
              ((Intent)localObject2).putExtra("mode_type", 4);
              ((Intent)localObject2).putExtra("finish_immedia", true);
              ((Intent)localObject2).putExtra("is_edit_mode", true);
              ((Intent)localObject2).putExtra("cur_ocr_info", (Parcelable)localObject3);
            }
            bool1 = paramGeneralClickHandler.a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
            break;
            localObject1 = "";
            paramGeneralClickHandler = "";
          }
        }
      }
    }
  }
  
  public boolean LayoutEquals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (StructMsgForGeneralShare)paramObject;
    return getLayoutStr().equals(((StructMsgForGeneralShare)paramObject).getLayoutStr());
  }
  
  public String getLayoutStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.mStructMsgItemLists != null)
    {
      Iterator localIterator = this.mStructMsgItemLists.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((AbsStructMsgElement)localIterator.next()).a());
      }
    }
    localStringBuffer.append(this.mFlag & 0x4);
    return localStringBuffer.toString();
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public int getProgress()
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      return ((StructMsgItemProgress)localAbsStructMsgElement).b();
    }
    return -1;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    int j = 1;
    int i = 1;
    this.mContext = new WeakReference(paramContext);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("hasHeadIcon", hasFlag(4));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getView(): convertView=" + paramView + ", args = " + localBundle.toString());
    }
    int k = localBundle.getInt("longMsgHolderType", -1);
    if ((k == 1) || (k == 2) || (k == 3))
    {
      paramView = StructMsgItemLongMsgHolder.a(paramContext, paramView, paramOnLongClickAndTouchListener, localBundle);
      paramView.setId(2131296312);
      paramView.setTag(2131296312, this);
      if ((!localBundle.getBoolean("isSubscript", false)) && (hasFlag(4)))
      {
        paramView.setBackgroundResource(2130837656);
        return paramView;
      }
      paramView.setBackgroundDrawable(null);
      return paramView;
    }
    if (localBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {}
    for (k = 1; this.mMsgException; k = 0)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "struct msg has version exception! uin : " + this.uin + " msgVersion : " + this.messageVersion + " version : " + this.mVersion + " msgUniseq" + this.uniseq);
      paramContext = getVersionExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, localBundle);
      paramContext.setId(2131296312);
      paramContext.setTag(2131296312, this);
      return paramContext;
    }
    if (paramView == null)
    {
      paramView = super.getView(paramContext, null, paramOnLongClickAndTouchListener, localBundle);
      if (paramView == null) {
        return null;
      }
      paramBundle = null;
      if ((paramView instanceof ViewGroup)) {
        paramBundle = (ViewGroup)paramView;
      }
      if (paramBundle == null) {
        return null;
      }
      if (this.mStructMsgItemLists == null) {
        break label2269;
      }
    }
    label495:
    label626:
    label1084:
    label1102:
    label1183:
    label1403:
    label1571:
    label1699:
    label2136:
    label2154:
    label2193:
    label2257:
    label2266:
    label2269:
    for (int m = getItemCount();; m = 0)
    {
      int n;
      Object localObject1;
      if (m > 0)
      {
        n = 0;
        j = i;
        if (n < m)
        {
          localObject1 = getItemByIndex(n);
          ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLongClickAndTouchListener);
          symbol2CharactorForSmallEmoji((AbsStructMsgElement)localObject1);
          if ((this.uin != null) && (!this.uin.equalsIgnoreCase(((AbsStructMsgElement)localObject1).n))) {
            ((AbsStructMsgElement)localObject1).n = this.uin;
          }
          if (((AbsStructMsgElement)localObject1).a() == 0)
          {
            if (n == 0) {
              ((AbsStructMsgElement)localObject1).b(1);
            }
            if (n == m - 1) {
              ((AbsStructMsgElement)localObject1).b(2);
            }
          }
          if ((localObject1 instanceof StructMsgItemLayout8)) {
            paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, localBundle);
          }
        }
      }
      for (;;)
      {
        Object localObject2;
        if ((n + 2 < m) && (paramView != null))
        {
          localObject2 = getItemByIndex(n + 2);
          if ((((AbsStructMsgItem)localObject2).a.size() != 0) && ((((localObject2 instanceof StructMsgItemLayoutDefault)) && ((((StructMsgItemLayoutDefault)localObject2).a.get(0) instanceof StructMsgItemMore))) || (((localObject2 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject2).a.get(0) instanceof StructMsgItemButton)))))
          {
            localObject2 = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
            if (localObject2 != null)
            {
              if (!(localObject1 instanceof StructMsgItemLayoutDefault)) {
                break label1102;
              }
              if (k == 0) {
                break label1084;
              }
              ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = AIOUtils.a(11.0F, paramContext.getResources());
              paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
          }
        }
        if ((n + 1 < m) && (paramView != null) && (k != 0) && (((AbsStructMsgItem)localObject1).a.size() == 1) && ((((AbsStructMsgItem)localObject1).a.get(0) instanceof StructMsgItemHr)))
        {
          localObject2 = getItemByIndex(n + 1);
          if ((((AbsStructMsgItem)localObject2).a.size() != 0) && ((localObject2 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject2).a.get(0) instanceof StructMsgItemButton)))
          {
            paramView.setPadding(2, paramView.getPaddingTop(), 2, paramView.getPaddingBottom());
            if ((paramView instanceof LinearLayout))
            {
              localObject2 = (LinearLayout.LayoutParams)((LinearLayout)paramView).getChildAt(0).getLayoutParams();
              if (localObject2 != null)
              {
                ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
                ((LinearLayout.LayoutParams)localObject2).rightMargin = 0;
              }
            }
          }
        }
        if (paramView != null)
        {
          if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject1).c))
          {
            paramView.setTag(localObject1);
            paramView.setClickable(true);
            paramView.setOnClickListener((View.OnClickListener)localObject1);
            paramView.setOnLongClickListener(new uvg(this, paramOnLongClickAndTouchListener));
            paramView.setOnTouchListener(new uvh(this, paramOnLongClickAndTouchListener));
            clickedItemIndex = 0;
          }
          paramBundle.addView(paramView);
        }
        for (;;)
        {
          n += 1;
          break;
          if ((localObject1 instanceof StructMsgItemLayout9))
          {
            paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, localBundle);
            break label495;
          }
          if ((localObject1 instanceof StructMsgItemLayout12))
          {
            paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, localBundle);
            i = 0;
            break label495;
          }
          if ((localObject1 instanceof StructMsgItemLayout5))
          {
            if (k != 0)
            {
              paramView = new StructMsgItemLayout5Adapter((AbsStructMsgItem)localObject1, paramContext, n).a(paramContext, null, localBundle);
              break label495;
            }
            paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, localBundle);
            break label495;
          }
          if ((localObject1 instanceof StructMsgItemLayout6))
          {
            if (k != 0)
            {
              paramView = new StructMsgItemLayout6Adapter((AbsStructMsgItem)localObject1, paramContext, n).a(paramContext, null, localBundle);
              break label495;
            }
            paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, localBundle);
            break label495;
          }
          if ((localObject1 instanceof StructMsgItemLayout4))
          {
            paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, localBundle);
            if (k == 0) {
              break label2266;
            }
            a(paramContext, n, paramView);
            break label495;
          }
          if ((localObject1 instanceof StructMsgItemLayout18))
          {
            paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, localBundle);
            i = 0;
            break label495;
          }
          paramView = ((AbsStructMsgElement)localObject1).a(paramContext, null, localBundle);
          break label495;
          ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = AIOUtils.a(16.0F, paramContext.getResources());
          break label626;
          if ((!(localObject1 instanceof StructMsgItemLayout6)) || (StructMsgItemLayout6Adapter.a((AbsStructMsgItem)localObject1, n))) {
            break label626;
          }
          ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = AIOUtils.a(7.5F, paramContext.getResources());
          break label626;
          if (QLog.isDevelopLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 4, "Create item view failure by #StructMsgItemViewFactory");
          }
        }
        paramContext = paramBundle.getLayoutParams();
        if (paramContext == null)
        {
          paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.i, -2);
          if (hasFlag(4))
          {
            paramContext.width = -1;
            paramBundle.setBackgroundResource(2130837656);
          }
          if (this.mMsgServiceID != 70) {
            break label1403;
          }
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_topic", 2, "StructMsgForGeneralShare getView mMsgServiceID == STRUCT_TYPE_TROOP_TOPIC.");
          }
          paramContext.width = -1;
          paramBundle.setBackgroundResource(2130837656);
        }
        for (;;)
        {
          if ((k != 0) && (hasFlag(4)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
            }
            paramBundle.setBackgroundResource(2130837662);
          }
          paramBundle.setLayoutParams(paramContext);
          paramContext = paramBundle;
          if ((localBundle != null) && (localBundle.getBoolean("v_crap_ctn", false))) {
            paramContext.getLayoutParams().width = -2;
          }
          if ((localBundle != null) && (localBundle.getBoolean("is_public_account_video_msg", false)))
          {
            this.mIsPAVideoStructMsg = true;
            paramContext.setBackgroundDrawable(null);
            if (!hasFlag(4)) {
              paramContext.getLayoutParams().width = -2;
            }
          }
          paramContext.setId(2131296312);
          paramContext.setTag(2131296312, this);
          paramView = paramContext;
          if (j != 0) {
            break;
          }
          paramContext.setBackgroundDrawable(null);
          return paramContext;
          paramContext.width = BaseChatItemLayout.i;
          paramContext.height = -2;
          break label1183;
          if (this.mMsgServiceID == 76)
          {
            paramContext.width = -1;
            paramBundle.setBackgroundDrawable(null);
          }
        }
        m = getItemCount();
        if (m > 0)
        {
          localObject1 = (ViewGroup)paramView;
          j = 0;
          i = 1;
          if (j < m)
          {
            localObject2 = getItemByIndex(j);
            ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLongClickAndTouchListener);
            if ((this.uin != null) && (!this.uin.equalsIgnoreCase(((AbsStructMsgElement)localObject2).n))) {
              ((AbsStructMsgElement)localObject2).n = this.uin;
            }
            if (((AbsStructMsgElement)localObject2).a() == 0)
            {
              if (j == 0) {
                ((AbsStructMsgElement)localObject2).b(1);
              }
              if (j == m - 1) {
                ((AbsStructMsgElement)localObject2).b(2);
              }
            }
            paramBundle = ((ViewGroup)localObject1).getChildAt(j);
            Object localObject3;
            if ((localObject2 instanceof StructMsgItemLayout8))
            {
              paramBundle = ((AbsStructMsgElement)localObject2).a(paramContext, paramBundle, localBundle);
              if (j + 2 < m)
              {
                localObject3 = getItemByIndex(j + 2);
                if ((((AbsStructMsgItem)localObject3).a.size() != 0) && ((((localObject3 instanceof StructMsgItemLayoutDefault)) && ((((StructMsgItemLayoutDefault)localObject3).a.get(0) instanceof StructMsgItemMore))) || (((localObject3 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject3).a.get(0) instanceof StructMsgItemButton)))))
                {
                  localObject3 = (ViewGroup.MarginLayoutParams)paramBundle.getLayoutParams();
                  if (localObject3 != null)
                  {
                    if (!(localObject2 instanceof StructMsgItemLayoutDefault)) {
                      break label2154;
                    }
                    if (k == 0) {
                      break label2136;
                    }
                    ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = AIOUtils.a(11.0F, paramContext.getResources());
                    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                  }
                }
              }
              if ((j + 1 < m) && (paramBundle != null) && (((AbsStructMsgItem)localObject2).a.size() == 1) && ((((AbsStructMsgItem)localObject2).a.get(0) instanceof StructMsgItemHr)))
              {
                localObject3 = getItemByIndex(j + 1);
                if ((((AbsStructMsgItem)localObject3).a.size() != 0) && ((localObject3 instanceof StructMsgItemLayout3)) && ((((StructMsgItemLayout3)localObject3).a.get(0) instanceof StructMsgItemButton))) {
                  paramBundle.setPadding(2, paramBundle.getPaddingTop(), 2, paramBundle.getPaddingBottom());
                }
              }
              if (paramBundle == null) {
                break label2193;
              }
              if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject2).c))
              {
                paramBundle.setTag(localObject2);
                paramBundle.setClickable(true);
                paramBundle.setOnClickListener((View.OnClickListener)localObject2);
                paramBundle.setOnLongClickListener(new uvi(this, paramOnLongClickAndTouchListener));
                paramBundle.setOnTouchListener(new uvj(this, paramOnLongClickAndTouchListener));
                clickedItemIndex = 0;
              }
            }
            for (;;)
            {
              j += 1;
              break;
              if ((localObject2 instanceof StructMsgItemLayout9))
              {
                paramBundle = ((AbsStructMsgElement)localObject2).a(paramContext, paramBundle, localBundle);
                break label1571;
              }
              if ((localObject2 instanceof StructMsgItemLayout12))
              {
                paramBundle = ((AbsStructMsgElement)localObject2).a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1571;
              }
              if ((localObject2 instanceof StructMsgItemLayout5))
              {
                if (k != 0)
                {
                  paramBundle = new StructMsgItemLayout5Adapter((AbsStructMsgItem)localObject2, paramContext, j).a(paramContext, paramBundle, localBundle);
                  break label1571;
                }
                paramBundle = ((AbsStructMsgElement)localObject2).a(paramContext, paramBundle, localBundle);
                break label1571;
              }
              if ((localObject2 instanceof StructMsgItemLayout6))
              {
                if (k != 0)
                {
                  paramBundle = new StructMsgItemLayout6Adapter((AbsStructMsgItem)localObject2, paramContext, j).a(paramContext, paramBundle, localBundle);
                  break label1571;
                }
                paramBundle = ((AbsStructMsgElement)localObject2).a(paramContext, paramBundle, localBundle);
                break label1571;
              }
              if ((localObject2 instanceof StructMsgItemLayout4))
              {
                paramBundle = ((AbsStructMsgElement)localObject2).a(paramContext, paramBundle, localBundle);
                if (k == 0) {
                  break label2257;
                }
                a(paramContext, j, paramBundle);
                break label1571;
              }
              if ((localObject2 instanceof StructMsgItemLayout18))
              {
                paramBundle = ((AbsStructMsgElement)localObject2).a(paramContext, paramBundle, localBundle);
                i = 0;
                break label1571;
              }
              paramBundle = ((AbsStructMsgElement)localObject2).a(paramContext, paramBundle, localBundle);
              break label1571;
              ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = AIOUtils.a(16.0F, paramContext.getResources());
              break label1699;
              if ((!(localObject2 instanceof StructMsgItemLayout6)) || (StructMsgItemLayout6Adapter.a((AbsStructMsgItem)localObject2, j))) {
                break label1699;
              }
              ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = AIOUtils.a(7.5F, paramContext.getResources());
              break label1699;
              if (QLog.isDevelopLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 4, "Create item view failure by #StructMsgItemViewFactory");
              }
            }
          }
        }
        for (;;)
        {
          if ((k != 0) && (hasFlag(4)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
            }
            paramView.setBackgroundResource(2130837662);
          }
          paramContext = paramView;
          j = i;
          break;
          break label1571;
          i = 1;
        }
      }
    }
  }
  
  public void initPay(Context paramContext, MessageRecord paramMessageRecord)
  {
    if (paramContext == null) {
      return;
    }
    this.havaPayInfoInit = true;
    Object localObject1 = paramMessageRecord.getExtInfoFromExtStr("pay_packages");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).split(",");
        if ((localObject1 != null) && (localObject1.length > 0)) {
          this.mHadPaidList = new ArrayList(Arrays.asList((Object[])localObject1));
        }
        if ((!SplashActivity.class.isInstance(paramContext)) && (!ChatActivity.class.isInstance(paramContext))) {
          break label345;
        }
        paramContext = ((FragmentActivity)paramContext).getChatFragment().a();
        if ((paramContext == null) || (!(paramContext instanceof PublicAccountChatPie)) || (!paramMessageRecord.frienduin.equals(paramContext.a()))) {
          break label345;
        }
        bool1 = ((PublicAccountChatPie)paramContext).x();
        if (this.mStructMsgItemLists == null) {
          break;
        }
        paramContext = this.mStructMsgItemLists.iterator();
        if (!paramContext.hasNext()) {
          break;
        }
        paramMessageRecord = (AbsStructMsgElement)paramContext.next();
        if (!(paramMessageRecord instanceof StructMsgItemLayout3)) {
          continue;
        }
        paramMessageRecord = ((StructMsgItemLayout3)paramMessageRecord).a.iterator();
        if (paramMessageRecord.hasNext())
        {
          localObject1 = (AbsStructMsgElement)paramMessageRecord.next();
          if (!(localObject1 instanceof StructMsgItemButton)) {
            continue;
          }
          localObject2 = (StructMsgItemButton)localObject1;
          if (!((StructMsgItemButton)localObject2).a()) {
            continue;
          }
          if ((!((StructMsgItemButton)localObject2).b()) && (bool1)) {
            break label278;
          }
          StructMsgItemButton.a((StructMsgItemButton)localObject1, false);
          continue;
        }
        continue;
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      catch (Exception paramContext) {}
      QLog.d(jdField_a_of_type_JavaLangString, 4, "initPay error " + paramContext.getMessage());
      return;
      label278:
      Object localObject2 = ((StructMsgItemButton)localObject2).cP;
      Iterator localIterator = this.mHadPaidList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((String)localIterator.next()).equals(localObject2));
      for (boolean bool2 = false;; bool2 = true)
      {
        StructMsgItemButton.a((StructMsgItemButton)localObject1, bool2);
        break;
      }
      label345:
      boolean bool1 = false;
    }
  }
  
  public boolean isPayMessage()
  {
    if (this.mStructMsgItemLists != null)
    {
      Iterator localIterator = this.mStructMsgItemLists.iterator();
      boolean bool = false;
      if (localIterator.hasNext())
      {
        localObject = (AbsStructMsgElement)localIterator.next();
        if (!(localObject instanceof StructMsgItemLayout3)) {
          break label107;
        }
        if (!bool) {}
      }
      else
      {
        return bool;
      }
      Object localObject = ((StructMsgItemLayout3)localObject).a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
        if ((localAbsStructMsgElement instanceof StructMsgItemButton)) {
          if (((StructMsgItemButton)localAbsStructMsgElement).a()) {
            bool = true;
          }
        }
      }
      label107:
      for (;;)
      {
        break;
      }
    }
    return false;
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    boolean bool = false;
    if (paramStructMsgNode == null) {
      bool = true;
    }
    Object localObject;
    do
    {
      return bool;
      if ("item".equals(paramStructMsgNode.jdField_b_of_type_JavaLangString)) {}
      for (localObject = paramStructMsgNode.a("layout");; localObject = StructMsgElementFactory.a(paramStructMsgNode.jdField_b_of_type_JavaLangString))
      {
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject)) {}
          for (int i = Integer.parseInt((String)localObject);; i = 0)
          {
            localObject = StructMsgElementFactory.a(i);
            if (localObject != null) {
              break;
            }
            return true;
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
        }
        catch (NumberFormatException paramStructMsgNode) {}
        QLog.d(jdField_a_of_type_JavaLangString, 4, "Item layout value is " + 0);
        return false;
      }
      ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
    } while (!((AbsStructMsgElement)localObject).a(paramStructMsgNode));
    addItem((AbsStructMsgElement)localObject);
    return true;
  }
  
  protected void parseMsgAttrubutes(StructMsgNode paramStructMsgNode)
  {
    super.parseMsgAttrubutes(paramStructMsgNode);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    label336:
    int j;
    try
    {
      k = paramObjectInput.readInt();
      this.mVersion = k;
      if (k != 1) {
        break label336;
      }
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      this.mContentLayout = paramObjectInput.readInt();
      this.mContentCover = paramObjectInput.readUTF();
      this.mContentTitle = paramObjectInput.readUTF();
      this.mContentSummary = paramObjectInput.readUTF();
      localObject1 = StructMsgElementFactory.a(this.mContentLayout);
      ((AbsStructMsgItem)localObject1).a(new StructMsgItemCover(this.mContentCover));
      ((AbsStructMsgItem)localObject1).a(new StructMsgItemTitle(this.mContentTitle));
      ((AbsStructMsgItem)localObject1).a(new StructMsgItemSummary(this.mContentSummary));
      addItem((AbsStructMsgElement)localObject1);
      this.mSourceAppid = paramObjectInput.readLong();
      this.mSourceIcon = paramObjectInput.readUTF();
      this.mSourceName = paramObjectInput.readUTF();
      this.mSourceUrl = paramObjectInput.readUTF();
      this.mSourceAction = paramObjectInput.readUTF();
      this.mSourceActionData = paramObjectInput.readUTF();
      this.mSource_A_ActionData = paramObjectInput.readUTF();
      this.mSource_I_ActionData = paramObjectInput.readUTF();
      this.fwFlag = paramObjectInput.readInt();
    }
    catch (IOException paramObjectInput)
    {
      int k;
      Object localObject1;
      int m;
      int i;
      while ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error")))
      {
        this.mMsgException = true;
        return;
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        this.mFlag = paramObjectInput.readInt();
        this.mResid = paramObjectInput.readUTF();
        this.mFileName = paramObjectInput.readUTF();
        this.mFileSize = paramObjectInput.readLong();
        this.mCommentText = paramObjectInput.readUTF();
        if (k >= 3)
        {
          this.mCompatibleText = paramObjectInput.readUTF();
          this.msgId = paramObjectInput.readLong();
          this.mPromotionType = paramObjectInput.readInt();
          this.mPromotionMsg = paramObjectInput.readUTF();
          this.mPromotionMenus = paramObjectInput.readUTF();
          this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
          i = 0;
          while (i < this.mStructMsgItemLists.size())
          {
            localObject1 = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
            ((AbsStructMsgElement)localObject1).jdField_a_of_type_Long = this.msgId;
            ((AbsStructMsgElement)localObject1).h = this.mPromotionType;
            i += 1;
          }
          if (k >= 4)
          {
            this.dynamicMsgMergeKey = paramObjectInput.readUTF();
            this.dynamicMsgMergeIndex = paramObjectInput.readInt();
            if (k >= 5)
            {
              this.source_puin = paramObjectInput.readUTF();
              if (k >= 6)
              {
                this.mSType = paramObjectInput.readUTF();
                if (k >= 7)
                {
                  this.adverSign = paramObjectInput.readInt();
                  this.adverKey = paramObjectInput.readUTF();
                  this.index = paramObjectInput.readUTF();
                  this.index_name = paramObjectInput.readUTF();
                  this.index_type = paramObjectInput.readUTF();
                  this.bid = paramObjectInput.readLong();
                  this.pid = paramObjectInput.readUTF();
                  this.pVersion = paramObjectInput.readLong();
                  this.isFull = paramObjectInput.readBoolean();
                  this.likeNum = paramObjectInput.readLong();
                  this.commentNum = paramObjectInput.readLong();
                  this.isLike = paramObjectInput.readBoolean();
                  this.author = paramObjectInput.readUTF();
                  if (k >= 8)
                  {
                    this.mArticleIds = paramObjectInput.readUTF();
                    this.mOrangeWord = paramObjectInput.readUTF();
                    this.mAlgorithmIds = paramObjectInput.readUTF();
                    this.mStrategyIds = paramObjectInput.readUTF();
                    if (k >= 9)
                    {
                      this.mExtraData = paramObjectInput.readUTF();
                      this.mCreateTime = paramObjectInput.readUTF();
                      this.mTagName = paramObjectInput.readUTF();
                      if (k >= 10)
                      {
                        eventId = paramObjectInput.readUTF();
                        remindBrief = paramObjectInput.readUTF();
                        eventType = paramObjectInput.readUTF();
                        if (k >= 11)
                        {
                          tips = paramObjectInput.readUTF();
                          if (k >= 12)
                          {
                            this.mInnerUniqIds = paramObjectInput.readUTF();
                            if (k >= 13)
                            {
                              this.mSourceThirdName = paramObjectInput.readUTF();
                              this.mQQStoryExtra = paramObjectInput.readUTF();
                              this.mNeedRound = paramObjectInput.readUTF();
                              continue;
                              this.mMsgException = true;
                              continue;
                              if (!this.mSourceName.equalsIgnoreCase("看点")) {
                                break;
                              }
                              this.mMsgServiceID = 53;
                              return;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
      this.mHasSource = true;
    }
    if (this.mSourceName != null) {
      if (this.mSourceName.equalsIgnoreCase("订阅号"))
      {
        this.mMsgServiceID = 54;
        return;
        if (k >= 2)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          m = paramObjectInput.readInt();
          j = 0;
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (j < m)
      {
        localObject1 = paramObjectInput.readUTF();
        if ("item".equals(localObject1)) {
          localObject1 = StructMsgElementFactory.a(paramObjectInput.readInt());
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label1285;
          }
          ((AbsStructMsgElement)localObject1).n = this.uin;
          ((AbsStructMsgElement)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this;
          ((AbsStructMsgElement)localObject1).a(paramObjectInput);
          Object localObject2 = (AbsStructMsgItem)localObject1;
          if ((((AbsStructMsgItem)localObject2).a.size() == 1) && (((AbsStructMsgElement)((AbsStructMsgItem)localObject2).a.get(0)).jdField_a_of_type_JavaLangString.equals("hr"))) {
            break;
          }
          ((AbsStructMsgElement)localObject1).m = String.valueOf(i);
          i += 1;
          addItem((AbsStructMsgElement)localObject1);
          break label1289;
          localObject2 = StructMsgElementFactory.a((String)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (AbsStructMsgItem.class.isInstance(localObject2))
            {
              paramObjectInput.readInt();
              localObject1 = localObject2;
            }
          }
        }
      }
      label1285:
      return;
      label1289:
      j += 1;
    }
  }
  
  public void savePayInfo(Context paramContext, String paramString)
  {
    try
    {
      this.mHadPaidList.add(paramString);
      paramString = ((FragmentActivity)paramContext).getChatFragment().a();
      String str = TextUtils.join(",", this.mHadPaidList);
      if (this.message != null)
      {
        if (paramString == null) {
          return;
        }
        this.message.saveExtInfoToExtStr("pay_packages", str);
        if ((paramContext instanceof FragmentActivity)) {
          ((FragmentActivity)paramContext).getChatFragment().a().a.notifyDataSetChanged();
        }
        ThreadManager.a(new uvn(this, paramString), 5, null, false);
        return;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "savePayInfo error " + paramContext.getMessage());
      }
    }
  }
  
  @Deprecated
  public void setProgress(int paramInt)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      ((StructMsgItemProgress)localAbsStructMsgElement).d(paramInt);
    }
  }
  
  @Deprecated
  public void setSummary(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("summary");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemSummary))) {
      ((StructMsgItemSummary)localAbsStructMsgElement).a(paramString);
    }
  }
  
  @Deprecated
  public void setTitle(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("title");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemTitle))) {
      ((StructMsgItemTitle)localAbsStructMsgElement).a(paramString);
    }
  }
  
  public void symbol2CharactorForSmallEmoji(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ((paramAbsStructMsgElement == null) || (!(paramAbsStructMsgElement instanceof StructMsgItemLayout2))) {}
    label38:
    label169:
    label265:
    label450:
    label455:
    label458:
    label460:
    label461:
    for (;;)
    {
      return;
      paramAbsStructMsgElement = ((StructMsgItemLayout2)paramAbsStructMsgElement).a;
      if ((paramAbsStructMsgElement != null) && (paramAbsStructMsgElement.size() != 0))
      {
        Object localObject1 = paramAbsStructMsgElement.iterator();
        paramAbsStructMsgElement = null;
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
          if (!(localObject2 instanceof StructMsgItemSummary)) {
            break label460;
          }
          paramAbsStructMsgElement = (StructMsgItemSummary)localObject2;
        }
        for (;;)
        {
          break label38;
          if (paramAbsStructMsgElement == null) {
            break label461;
          }
          localObject2 = paramAbsStructMsgElement.b();
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (this.mContext == null) || (this.mContext.get() == null) || (!(this.mContext.get() instanceof BaseActivity))) {
            break;
          }
          localObject1 = ((FragmentActivity)this.mContext.get()).getChatFragment();
          if (localObject1 != null) {
            localObject1 = ((ChatFragment)localObject1).a();
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label458;
            }
            EmoticonManager localEmoticonManager = (EmoticonManager)((QQAppInterface)localObject1).getManager(13);
            StringBuilder localStringBuilder = new StringBuilder((String)localObject2);
            int i = 0;
            int j;
            if (i < localStringBuilder.length())
            {
              j = i;
              if ('ÿ' == localStringBuilder.charAt(i))
              {
                j = i;
                if (i + 3 < localStringBuilder.length())
                {
                  localObject1 = new char[4];
                  localObject1[0] = localStringBuilder.charAt(i + 3);
                  localObject1[1] = localStringBuilder.charAt(i + 2);
                  localObject1[2] = localStringBuilder.charAt(i + 1);
                  localObject1[3] = localStringBuilder.charAt(i);
                  j = 0;
                  if (j < 4)
                  {
                    if (localObject1[j] == 'ú') {
                      localObject1[j] = 10;
                    }
                    for (;;)
                    {
                      j += 1;
                      break label265;
                      localObject1 = BaseApplicationImpl.a().a();
                      if ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface))) {
                        break label455;
                      }
                      localObject1 = (QQAppInterface)localObject1;
                      break;
                      if (localObject1[j] == 'þ') {
                        localObject1[j] = 13;
                      } else if (localObject1[j] == 'ý') {
                        localObject1[j] = 20;
                      }
                    }
                  }
                  localObject1 = EmosmUtils.a((char[])localObject1);
                  localObject2 = "[小表情]";
                  if (localEmoticonManager == null) {
                    break label450;
                  }
                }
              }
            }
            for (localObject1 = localEmoticonManager.a(Integer.toString(localObject1[0]), Integer.toString(localObject1[1]));; localObject1 = null)
            {
              if (localObject1 != null) {
                localObject2 = ((Emoticon)localObject1).character;
              }
              localStringBuilder.replace(i, i + 3, (String)localObject2);
              j = i + ((String)localObject2).length();
              i = j + 1;
              break label169;
              if (TextUtils.isEmpty(localStringBuilder)) {
                break;
              }
              paramAbsStructMsgElement.a(localStringBuilder.toString());
              return;
            }
            localObject1 = null;
          }
          break;
        }
      }
    }
  }
  
  protected void toContentXml(uuy paramuuy)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramuuy);
    }
  }
  
  public void unInitPay()
  {
    this.havaPayInfoInit = false;
    this.mHadPaidList = new ArrayList();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgActionData != null) {
        break label180;
      }
      localObject = "";
      label57:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_A_ActionData != null) {
        break label188;
      }
      localObject = "";
      label74:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_I_ActionData != null) {
        break label196;
      }
      localObject = "";
      label91:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgUrl != null) {
        break label204;
      }
      localObject = "";
      label108:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgBrief != null) {
        break label212;
      }
    }
    label180:
    label188:
    label196:
    label204:
    label212:
    for (Object localObject = "";; localObject = this.mMsgBrief)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(getItemCount());
      localObject = iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.mMsgAction;
      break;
      localObject = this.mMsgActionData;
      break label57;
      localObject = this.mMsg_A_ActionData;
      break label74;
      localObject = this.mMsg_I_ActionData;
      break label91;
      localObject = this.mMsgUrl;
      break label108;
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceName != null) {
        break label1004;
      }
      localObject = "";
      label257:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label1012;
      }
      localObject = "";
      label274:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label1020;
      }
      localObject = "";
      label291:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label1028;
      }
      localObject = "";
      label308:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label1036;
      }
      localObject = "";
      label325:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label1044;
      }
      localObject = "";
      label342:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      if (this.mResid != null) {
        break label1052;
      }
      localObject = "";
      label379:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mFileName != null) {
        break label1060;
      }
      localObject = "";
      label396:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mFileSize);
      if (this.mCommentText != null) {
        break label1068;
      }
      localObject = "";
      label423:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label1076;
      }
      localObject = "";
      label440:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label1084;
      }
      localObject = "";
      label477:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label1092;
      }
      localObject = "";
      label494:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.dynamicMsgMergeKey != null) {
        break label1100;
      }
      localObject = "";
      label521:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.dynamicMsgMergeIndex);
      if (this.source_puin != null) {
        break label1108;
      }
      localObject = "";
      label548:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSType != null) {
        break label1116;
      }
      localObject = "";
      label565:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label1124;
      }
      localObject = "";
      label592:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index != null) {
        break label1132;
      }
      localObject = "";
      label609:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_name != null) {
        break label1140;
      }
      localObject = "";
      label626:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_type != null) {
        break label1148;
      }
      localObject = "";
      label643:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.bid);
      if (this.pid != null) {
        break label1156;
      }
      localObject = "";
      label670:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.pVersion);
      paramObjectOutput.writeBoolean(this.isFull);
      paramObjectOutput.writeLong(this.likeNum);
      paramObjectOutput.writeLong(this.commentNum);
      paramObjectOutput.writeBoolean(this.isLike);
      if (this.author != null) {
        break label1164;
      }
      localObject = "";
      label737:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mArticleIds != null) {
        break label1172;
      }
      localObject = "";
      label754:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mOrangeWord != null) {
        break label1180;
      }
      localObject = "";
      label771:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mAlgorithmIds != null) {
        break label1188;
      }
      localObject = "";
      label788:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mStrategyIds != null) {
        break label1196;
      }
      localObject = "";
      label805:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mExtraData != null) {
        break label1204;
      }
      localObject = "";
      label822:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCreateTime != null) {
        break label1212;
      }
      localObject = "";
      label839:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mTagName != null) {
        break label1220;
      }
      localObject = "";
      label856:
      paramObjectOutput.writeUTF((String)localObject);
      if (eventId != null) {
        break label1228;
      }
      localObject = "";
      label872:
      paramObjectOutput.writeUTF((String)localObject);
      if (remindBrief != null) {
        break label1235;
      }
      localObject = "";
      label888:
      paramObjectOutput.writeUTF((String)localObject);
      if (eventType != null) {
        break label1242;
      }
      localObject = "";
      label904:
      paramObjectOutput.writeUTF((String)localObject);
      if (tips != null) {
        break label1249;
      }
      localObject = "";
      label920:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mInnerUniqIds != null) {
        break label1256;
      }
      localObject = "";
      label937:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceThirdName != null) {
        break label1264;
      }
      localObject = "";
      label954:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mQQStoryExtra != null) {
        break label1272;
      }
      localObject = "";
      label971:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mNeedRound != null) {
        break label1280;
      }
    }
    label1004:
    label1012:
    label1020:
    label1028:
    label1036:
    label1044:
    label1052:
    label1060:
    label1068:
    label1076:
    label1084:
    label1092:
    label1100:
    label1108:
    label1116:
    label1124:
    label1132:
    label1140:
    label1148:
    label1156:
    label1164:
    label1172:
    label1180:
    label1188:
    label1196:
    label1204:
    label1212:
    label1220:
    label1228:
    label1235:
    label1242:
    label1249:
    label1256:
    label1264:
    label1272:
    label1280:
    for (localObject = "";; localObject = this.mNeedRound)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label257;
      localObject = this.mSourceUrl;
      break label274;
      localObject = this.mSourceAction;
      break label291;
      localObject = this.mSourceActionData;
      break label308;
      localObject = this.mSource_A_ActionData;
      break label325;
      localObject = this.mSource_I_ActionData;
      break label342;
      localObject = this.mResid;
      break label379;
      localObject = this.mFileName;
      break label396;
      localObject = this.mCommentText;
      break label423;
      localObject = this.mCompatibleText;
      break label440;
      localObject = this.mPromotionMsg;
      break label477;
      localObject = this.mPromotionMenus;
      break label494;
      localObject = this.dynamicMsgMergeKey;
      break label521;
      localObject = this.source_puin;
      break label548;
      localObject = this.mSType;
      break label565;
      localObject = this.adverKey;
      break label592;
      localObject = this.index;
      break label609;
      localObject = this.index_name;
      break label626;
      localObject = this.index_type;
      break label643;
      localObject = this.pid;
      break label670;
      localObject = this.author;
      break label737;
      localObject = this.mArticleIds;
      break label754;
      localObject = this.mOrangeWord;
      break label771;
      localObject = this.mAlgorithmIds;
      break label788;
      localObject = this.mStrategyIds;
      break label805;
      localObject = this.mExtraData;
      break label822;
      localObject = this.mCreateTime;
      break label839;
      localObject = this.mTagName;
      break label856;
      localObject = eventId;
      break label872;
      localObject = remindBrief;
      break label888;
      localObject = eventType;
      break label904;
      localObject = tips;
      break label920;
      localObject = this.mInnerUniqIds;
      break label937;
      localObject = this.mSourceThirdName;
      break label954;
      localObject = this.mQQStoryExtra;
      break label971;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgForGeneralShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */