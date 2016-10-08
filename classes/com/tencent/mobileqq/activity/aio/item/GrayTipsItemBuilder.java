package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipDonateHelper;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import njw;
import njx;
import njy;
import njz;
import nka;
import nkb;
import nke;
import nkh;
import nkk;
import nkp;
import nkq;
import nkr;
import nks;
import nkt;
import nku;
import nkv;
import nkw;
import nkx;
import nky;
import nkz;
import nlb;
import nlc;
import nlf;
import nlg;
import nlh;
import nli;
import nlj;
import nlk;
import org.json.JSONObject;

public class GrayTipsItemBuilder
  extends AbstractChatItemBuilder
{
  private static final String c = "GrayTipsItemBuilder";
  private long a;
  String b;
  
  public GrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = BaseApplication.getContext().getString(2131367249);
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    Pattern localPattern = Pattern.compile("<a.*?/a>");
    paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
    int i = 0;
    while (paramCharSequence.find(i))
    {
      Object localObject3 = Pattern.compile(">.*?</a>").matcher(paramCharSequence.group());
      Object localObject1 = null;
      while (((Matcher)localObject3).find())
      {
        localObject2 = ((Matcher)localObject3).group().replaceAll(">|</a>", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("GrayTipsItemBuilder", 2, "标题：" + (String)localObject2);
          localObject1 = localObject2;
        }
      }
      Matcher localMatcher = Pattern.compile("href=.*?>").matcher(paramCharSequence.group());
      Object localObject2 = null;
      while (localMatcher.find())
      {
        localObject3 = localMatcher.group().replaceAll("href=|>", "");
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("GrayTipsItemBuilder", 2, "网址：" + (String)localObject3);
          localObject2 = localObject3;
        }
      }
      if ((localObject1 != null) && (localObject2 != null))
      {
        localSpannableStringBuilder.replace(paramCharSequence.start(), paramCharSequence.end(), (CharSequence)localObject1);
        localSpannableStringBuilder.setSpan(new URLSpan((String)localObject2), paramCharSequence.start(), paramCharSequence.start() + ((String)localObject1).length(), 33);
        i = paramCharSequence.start() + ((String)localObject1).length();
        paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
        paramCharSequence.reset();
      }
    }
    return localSpannableStringBuilder;
  }
  
  private CharSequence a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramBoolean)
    {
      str = "通过" + paramString + "加的新朋友，一起聊聊吧！";
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = "通过".length();; i = "对方通过".length())
    {
      int j = paramString.length();
      paramString = new SpannableString(str);
      paramString.setSpan(new nka(this), i, i + j, 33);
      return paramString;
      str = "对方通过" + paramString + "加你为好友，一起聊聊吧！";
      break;
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramString1.length() < paramInt)
    {
      paramTextView.setText(new SpannableString(paramString1));
      return;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.insert(paramInt, paramString2);
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(new nkk(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    int i = 0;
    int j = 0;
    Object localObject1 = null;
    String str1 = null;
    String str2 = null;
    int m = 0;
    String str3 = null;
    String str4 = null;
    int k = 0;
    String str6 = null;
    long l = 0L;
    do
    {
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(paramString);
        if (!((JSONObject)localObject2).has("sens_msg_id")) {
          continue;
        }
        i = ((JSONObject)localObject2).getInt("sens_msg_id");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (((JSONObject)localObject2).has("sens_msg_attr")) {
        j = ((JSONObject)localObject2).getInt("sens_msg_attr");
      }
      paramString = (String)localObject1;
      if (((JSONObject)localObject2).has("sens_msg_status")) {
        paramString = ((JSONObject)localObject2).getString("sens_msg_status");
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (String str5 = "0";; str5 = paramString)
      {
        if (((JSONObject)localObject2).has("sens_msg_phoe")) {
          str1 = ((JSONObject)localObject2).getString("sens_msg_phoe");
        }
        if (((JSONObject)localObject2).has("sens_msg_senderuin")) {
          str2 = ((JSONObject)localObject2).getString("sens_msg_senderuin");
        }
        if (((JSONObject)localObject2).has("sens_msg_peeruin")) {
          str3 = ((JSONObject)localObject2).getString("sens_msg_peeruin");
        }
        if (((JSONObject)localObject2).has("sens_msg_nickname")) {
          str4 = ((JSONObject)localObject2).getString("sens_msg_nickname");
        }
        if (((JSONObject)localObject2).has("sens_msg_istroop")) {
          k = ((JSONObject)localObject2).getInt("sens_msg_istroop");
        }
        if (((JSONObject)localObject2).has("sens_msg_troopuin")) {
          str6 = ((JSONObject)localObject2).getString("sens_msg_troopuin");
        }
        if (((JSONObject)localObject2).has("sens_msg_uniseq")) {
          l = ((JSONObject)localObject2).getLong("sens_msg_uniseq");
        }
        if (((JSONObject)localObject2).has("sens_msg_sessiontype")) {
          m = ((JSONObject)localObject2).getInt("sens_msg_sessiontype");
        }
        if (((JSONObject)localObject2).has("sens_msg_default_wording")) {}
        for (localObject2 = ((JSONObject)localObject2).getString("sens_msg_default_wording");; localObject2 = null)
        {
          localObject1 = null;
          paramString = null;
          Object localObject3 = (Bundle)AntiFraudConfigFileUtil.a().a("SensMsgTipsCfg", "TailWording", i, j);
          if (localObject3 != null)
          {
            localObject1 = ((Bundle)localObject3).getString("0");
            paramString = ((Bundle)localObject3).getString("1");
          }
          Bundle localBundle = (Bundle)AntiFraudConfigFileUtil.a().a("SensMsgTipsCfg", "Action", i, j);
          Object localObject4 = paramString;
          localObject3 = localObject1;
          if (localBundle != null)
          {
            Iterator localIterator = localBundle.keySet().iterator();
            for (;;)
            {
              localObject4 = paramString;
              localObject3 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (String)localIterator.next();
              localObject4 = localBundle.getBundle((String)localObject3).getString("Name");
              String str7 = "$" + (String)localObject3;
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                localObject3 = localObject1;
                if (((String)localObject1).contains(str7)) {
                  localObject3 = ((String)localObject1).replace(str7, (CharSequence)localObject4);
                }
              }
              localObject1 = localObject3;
              if (paramString != null)
              {
                localObject1 = localObject3;
                if (paramString.contains(str7))
                {
                  paramString = paramString.replace(str7, (CharSequence)localObject4);
                  localObject1 = localObject3;
                }
              }
            }
          }
          paramString = (String)localObject4;
          if (str5.equalsIgnoreCase("0")) {
            paramString = (String)localObject3;
          }
          localObject1 = paramString;
          if (i == 2)
          {
            localObject1 = paramString;
            if (TextUtils.isEmpty(paramString))
            {
              localObject1 = paramString;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = localObject2;
              }
            }
            ThreadManager.a(new nkq(this, str6, k, l, (String)localObject1), 5, null, false);
          }
          paramString = new SpannableString((CharSequence)localObject1);
          if (localBundle != null)
          {
            localObject2 = localBundle.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = localBundle.getBundle((String)((Iterator)localObject2).next());
              str5 = ((Bundle)localObject4).getString("Type");
              localObject3 = ((Bundle)localObject4).getString("Name");
              if ((((String)localObject1).indexOf((String)localObject3) >= 0) && ((!str5.equalsIgnoreCase("makePhoneCall")) || (!TextUtils.isEmpty(str1))))
              {
                localObject4 = new nks(this, str5, str2, i, j, str1, (Bundle)localObject4, str3, k, l, str4, m, str6);
                int i1 = ((String)localObject1).indexOf((String)localObject3);
                int n = i1;
                if (i1 < 0) {
                  n = 0;
                }
                paramString.setSpan(localObject4, n, ((String)localObject3).length() + n, 33);
              }
            }
          }
          paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramTextView.setText(paramString);
          return;
        }
      }
    } while (i > 0);
  }
  
  private void b(MessageRecord paramMessageRecord, TextView paramTextView)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
      }
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131367452);
      j = paramMessageRecord.indexOf(this.jdField_a_of_type_AndroidContentContext.getString(2131367453));
      i = j;
      if (j == 0) {
        i = 19;
      }
      paramMessageRecord = new SpannableString(paramMessageRecord);
      paramMessageRecord.setSpan(new nkt(this), i, i + 4, 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramMessageRecord);
    }
    while (!QLog.isColorLevel())
    {
      int j;
      int i;
      return;
    }
    QLog.i("GrayTipsItemBuilder", 2, "nearby market gray tips msg is not validate");
  }
  
  private void d(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "多人聊天已创建。";; paramString = paramString + "为了方便后续查找，给多人聊天")
    {
      SpannableString localSpannableString = new SpannableString(paramString + "取个名字" + "吧！");
      localSpannableString.setSpan(new nkp(this), paramString.length(), (paramString + "取个名字").length(), 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(localSpannableString);
      return;
    }
  }
  
  private void e(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131367285);
    int i = ((String)localObject).indexOf("QQ电话");
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new nkh(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void f(TextView paramTextView)
  {
    paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131367281));
  }
  
  private void g(TextView paramTextView)
  {
    Object localObject = BaseApplicationImpl.getContext().getString(2131371892) + "\n";
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131371893);
    int j = ((String)localObject).length() + str.indexOf("取消隐藏");
    int i = j;
    if (j < 0) {
      i = 20;
    }
    localObject = new SpannableString(new SpannableString((String)localObject + str));
    ((SpannableString)localObject).setSpan(new nku(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void h(TextView paramTextView) {}
  
  private void i(TextView paramTextView)
  {
    int j = "羊年拜年，给好友发个QQ红包吧。".indexOf("Q");
    int i = j;
    if (j < 0) {
      i = 11;
    }
    SpannableString localSpannableString = new SpannableString("羊年拜年，给好友发个QQ红包吧。");
    localSpannableString.setSpan(new nkv(this), i, j + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    nlg localnlg = (nlg)paramViewHolder;
    Object localObject = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903199, null);
      localnlg.b = ((TextView)paramViewHolder.findViewById(2131297668));
      paramView = localnlg.b.getLayoutParams();
      localObject = paramViewHolder;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject = paramViewHolder;
        if (paramView.rightMargin != BaseChatItemLayout.A)
        {
          paramView.rightMargin = BaseChatItemLayout.A;
          localObject = paramViewHolder;
        }
      }
    }
    localnlg.b.setMovementMethod(null);
    localnlg.b.setTextColor(((View)localObject).getResources().getColorStateList(2131427368));
    String str = paramMessageRecord.msg;
    switch (paramMessageRecord.msgtype)
    {
    default: 
      localnlg.b.setText(str);
      localnlg.b.setGravity(19);
      return (View)localObject;
    case -1002: 
      if ((paramMessageRecord instanceof MessageForSafeGrayTips)) {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
        }
      }
      break;
    }
    for (paramMessageRecord = (MessageForSafeGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      a(paramMessageRecord, localnlg.b);
      localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
      localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
      break;
      if ((str != null) && (str.length() > 0) && (str.charAt(0) == '\026')) {}
      for (paramMessageRecord = str.split("\\|");; paramMessageRecord = null)
      {
        paramViewHolder = str;
        if (paramMessageRecord != null)
        {
          paramViewHolder = str;
          if (paramMessageRecord.length > 0) {
            paramViewHolder = paramMessageRecord[0].trim();
          }
        }
        localnlg.b.setText(paramViewHolder);
        localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        break;
      }
      localnlg.b.setText(str);
      localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
      localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
      break;
      if (paramMessageRecord.istroop == 0)
      {
        f(localnlg.b);
        break;
      }
      if ((paramMessageRecord instanceof MessageForGrayTips)) {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
        }
      }
      for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
      {
        if (paramMessageRecord != null)
        {
          localnlg.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
          localnlg.b.setClickable(true);
          localnlg.b.setFocusable(true);
          localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
          break;
        }
        localnlg.b.setText(str);
        localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        break;
        localnlg.b.setText(a(str, true));
        localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        break;
        localnlg.b.setText(a(str, false));
        localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        break;
        if ((paramMessageRecord instanceof MessageForGrayTips)) {
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
          }
        }
        for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
        {
          if (paramMessageRecord != null)
          {
            localnlg.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
            localnlg.b.setClickable(true);
            localnlg.b.setFocusable(true);
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            break;
          }
          localnlg.b.setText(str);
          localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          break;
          paramMessageRecord = String.format(str, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
          localnlg.b.setText(paramMessageRecord);
          localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          break;
          localnlg.b.setText(a(str));
          localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
          localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          break;
          paramMessageRecord = BaseApplicationImpl.getContext().getString(2131362874) + "\"" + str + "\"";
          localnlg.b.setText(paramMessageRecord);
          break;
          localnlg.b.setText(str);
          break;
          paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
          paramMessageRecord = paramViewHolder.getString("renewal_tail_click_text", null);
          int i = paramViewHolder.getInt("renewal_tail_action", -1);
          int j = paramViewHolder.getInt("renewal_tail_tip_exit", -1);
          paramViewHolder = paramViewHolder.getString("renewal_tail_activity_url", null);
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "MSG_TYPE_RENEWAL_TAIL_TIP, action=" + i + ", msg=" + str + ", clickText=" + paramMessageRecord + ", expireFlag=" + j + ", activityUrl=" + paramViewHolder);
          }
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramMessageRecord)))
          {
            paramMessageRecord = FileManagerUtil.a(str, paramMessageRecord, new njw(this, j, i));
            localnlg.b.setText(paramMessageRecord);
          }
          for (;;)
          {
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            localnlg.b.setHighlightColor(17170445);
            break;
            QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP msg or clickText empty");
          }
          a(localnlg.b);
          break;
          g(localnlg.b);
          break;
          localnlg.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131371894));
          break;
          b(localnlg.b);
          break;
          a(localnlg.b, str);
          break;
          paramMessageRecord = FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131366199), BaseApplicationImpl.getContext().getString(2131366200), new nkr(this));
          localnlg.b.setText(paramMessageRecord);
          localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
          localnlg.b.setHighlightColor(17170445);
          break;
          paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131366207);
          paramMessageRecord = paramViewHolder;
          if (!str.contains(paramViewHolder)) {
            paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131366208);
          }
          paramMessageRecord = FileManagerUtil.a(str, paramMessageRecord, new nkw(this));
          localnlg.b.setText(paramMessageRecord);
          localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
          localnlg.b.setHighlightColor(17170445);
          break;
          paramMessageRecord = FileManagerUtil.a(str, this.jdField_a_of_type_AndroidContentContext.getString(2131367906), new nkx(this));
          localnlg.b.setText(paramMessageRecord);
          localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
          localnlg.b.setHighlightColor(17170445);
          break;
          d(localnlg.b, paramMessageRecord.extStr);
          break;
          paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
          paramViewHolder = paramMessageRecord.getExtInfoFromExtStr("approval_subtype");
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131372434);
          paramLinearLayout = new SpannableString(paramView);
          paramLinearLayout.setSpan(new nky(this, paramViewHolder, paramMessageRecord), 0, paramView.length(), 33);
          localnlg.b.setHighlightColor(17170445);
          localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
          localnlg.b.setText(paramLinearLayout);
          break;
          i = paramMessageRecord.extraflag;
          j = str.indexOf(paramMessageRecord.extStr);
          paramViewHolder = new SpannableString(str);
          paramViewHolder.setSpan(new nkz(this, i), j, paramMessageRecord.extStr.length() + j, 33);
          localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
          localnlg.b.setText(paramViewHolder);
          break;
          b(localnlg.b, paramMessageRecord);
          break;
          e(localnlg.b);
          break;
          paramMessageRecord = str.split("\\|");
          if (paramMessageRecord.length != 5) {
            break;
          }
          a(localnlg.b, paramMessageRecord[0], paramMessageRecord[1], Integer.parseInt(paramMessageRecord[2]), paramMessageRecord[3], paramMessageRecord[4]);
          break;
          c(localnlg.b);
          break;
          i(localnlg.b);
          break;
          paramMessageRecord = paramMessageRecord.msg;
          if (paramMessageRecord == null) {
            break;
          }
          b(localnlg.b, paramMessageRecord);
          break;
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "getItemView msgtype:-5000 istroop:" + paramMessageRecord.istroop + " msg:" + Utils.a(str));
          }
          if (!(paramMessageRecord instanceof MessageForNewGrayTips)) {
            break;
          }
          paramMessageRecord = (MessageForNewGrayTips)paramMessageRecord;
          if ((paramMessageRecord == null) || (paramMessageRecord.msg.length() <= 0)) {
            break;
          }
          paramMessageRecord.buildTextView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localnlg.b);
          break;
          h(localnlg.b);
          break;
          if (!(paramMessageRecord instanceof MessageForIncompatibleGrayTips)) {
            break;
          }
          paramMessageRecord = (MessageForIncompatibleGrayTips)paramMessageRecord;
          paramView = paramMessageRecord.url;
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForIncompatibleGrayTips");
          }
          paramViewHolder = new SpannableString(paramMessageRecord.msg);
          paramView = new nlb(this, paramView);
          paramViewHolder.setSpan(new ForegroundColorSpan(2131427352), paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
          paramViewHolder.setSpan(paramView, paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
          localnlg.b.setText(paramViewHolder);
          localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
          localnlg.b.setHighlightColor(17170445);
          break;
          if ((paramMessageRecord instanceof MessageForGrayTips)) {
            if (QLog.isColorLevel()) {
              QLog.d("GrayTipsItemBuilder", 2, "getItemView MSG_TYPE_CONFIGURABLE_GRAY_TIPS");
            }
          }
          for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
          {
            if (paramMessageRecord != null)
            {
              localnlg.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
              localnlg.b.setClickable(true);
              localnlg.b.setFocusable(true);
              localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
              break;
            }
            localnlg.b.setText(str);
            break;
            d(localnlg.b);
            break;
            c(localnlg.b, str);
            break;
            a(localnlg.b, paramMessageRecord);
            break;
            if ((paramMessageRecord instanceof MessageForNearbyMarketGrayTips))
            {
              paramMessageRecord = ((MessageForNearbyMarketGrayTips)paramMessageRecord).getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
              localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
              localnlg.b.setText(paramMessageRecord);
              break;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("GrayTipsItemBuilder", 2, "nearby market gray tips msg is not validate");
            break;
            if (!(paramMessageRecord instanceof MessageForGrayTips)) {
              break;
            }
            paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
            if ((paramMessageRecord == null) || (paramMessageRecord.msg.length() <= 0)) {
              break;
            }
            paramMessageRecord = FileManagerUtil.a(paramMessageRecord.msg + " 关闭群聊模式 ", " 关闭群聊模式 ", new nlc(this));
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            localnlg.b.setText(paramMessageRecord);
            break;
            if (!(paramMessageRecord instanceof MessageForGrayTips)) {
              break;
            }
            paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
            if ((paramMessageRecord == null) || (paramMessageRecord.msg.length() <= 0)) {
              break;
            }
            paramMessageRecord = FileManagerUtil.a(paramMessageRecord.msg + " 开启群聊模式 ", " 开启群聊模式 ", new nlf(this));
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            localnlg.b.setText(paramMessageRecord);
            break;
            if (!(paramMessageRecord instanceof MessageForGrayTips)) {
              break;
            }
            paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
            if ((paramMessageRecord == null) || (paramMessageRecord.msg.length() <= 0)) {
              break;
            }
            paramMessageRecord = FileManagerUtil.a(paramMessageRecord.msg + " 解除绑定 " + "以退出群聊。", " 解除绑定 ", new njx(this));
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            localnlg.b.setText(paramMessageRecord);
            break;
            b(paramMessageRecord, localnlg.b);
            break;
            if (!(paramMessageRecord instanceof MessageForQQWalletTips)) {
              break;
            }
            ((MessageForQQWalletTips)paramMessageRecord).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localnlg.b);
            break;
            localnlg.b.setText(str);
            localnlg.b.setOnTouchListener(paramOnLongClickAndTouchListener);
            localnlg.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
            break;
            if (!(paramMessageRecord instanceof MessageForGrayTips)) {
              break;
            }
            paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
            localnlg.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
            localnlg.b.setClickable(true);
            localnlg.b.setFocusable(true);
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            break;
            if (!(paramMessageRecord instanceof ShareHotChatGrayTips)) {
              break;
            }
            paramMessageRecord = ((ShareHotChatGrayTips)paramMessageRecord).getHighlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            localnlg.b.setText(paramMessageRecord);
            break;
            if (!(paramMessageRecord instanceof MessageForDeliverGiftTips)) {
              break;
            }
            ((MessageForDeliverGiftTips)paramMessageRecord).buildDeliverGiftTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localnlg.b);
            break;
            a(paramMessageRecord, localnlg.b);
            break;
            paramView = AioVipKeywordHelper.a();
            if (paramMessageRecord.isSend())
            {
              paramViewHolder = paramView.g;
              paramLinearLayout = AioVipKeywordHelper.c;
            }
            for (paramView = paramView.j;; paramView = paramView.i)
            {
              i = str.indexOf(paramViewHolder);
              j = paramViewHolder.length();
              if (i == -1) {
                paramViewHolder = "";
              }
              paramMessageRecord = FileManagerUtil.a(str, paramViewHolder, new njy(this, paramLinearLayout, paramView, paramMessageRecord));
              if (i > -1) {
                paramMessageRecord.setSpan(new UnderlineSpan(), i, j + i, 33);
              }
              localnlg.b.setText(paramMessageRecord);
              if (jdField_b_of_type_Boolean) {
                localnlg.b.setContentDescription(paramMessageRecord);
              }
              localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
              localnlg.b.setHighlightColor(17170445);
              break;
              paramViewHolder = paramView.h;
              paramLinearLayout = AioVipKeywordHelper.d;
            }
            paramMessageRecord = AioVipDonateHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            i = str.indexOf(paramMessageRecord);
            j = paramMessageRecord.length();
            if (i == -1) {}
            paramMessageRecord = FileManagerUtil.a(str, paramMessageRecord, new njz(this));
            if (i > -1) {
              paramMessageRecord.setSpan(new UnderlineSpan(), i, j + i, 33);
            }
            localnlg.b.setText(paramMessageRecord);
            if (jdField_b_of_type_Boolean) {
              localnlg.b.setContentDescription(paramMessageRecord);
            }
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            localnlg.b.setHighlightColor(17170445);
            VasWebviewUtil.reportVipKeywords("", "2", "", "", "", "", "", "", "", "");
            break;
            if (!(paramMessageRecord instanceof MessageForGrayTips)) {
              break;
            }
            paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
            localnlg.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
            localnlg.b.setClickable(true);
            localnlg.b.setFocusable(true);
            localnlg.b.setMovementMethod(LinkMovementMethod.getInstance());
            break;
          }
        }
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new nlg(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131305401) {
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  void a(TextView paramTextView)
  {
    paramTextView.setText(BaseApplicationImpl.getContext().getString(2131371073));
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131371073));
  }
  
  public void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype != 64490) {}
    do
    {
      do
      {
        return;
        long l1 = -1L;
        try
        {
          long l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("sens_msg_uniseq"));
          l1 = l2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            int n;
            int j;
            boolean bool2;
            try
            {
              localObject3 = new bankcode_info.BankcodeCtrlInfo();
              j = k;
              ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(HexUtil.a((String)localObject5));
              i = k;
              j = k;
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.has())
              {
                j = k;
                i = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.get();
              }
              j = i;
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).fromuin_phonenum.has())
              {
                j = i;
                paramMessageRecord = ((bankcode_info.BankcodeCtrlInfo)localObject3).fromuin_phonenum.get();
              }
            }
            catch (Exception localException4)
            {
              MessageRecord localMessageRecord2;
              int i1;
              int i3;
              int i2;
              Object localObject1;
              Object localObject5;
              Object localObject3;
              int m;
              boolean bool1;
              boolean bool3;
              k = 0;
              localMessageRecord1 = null;
              paramMessageRecord = null;
              localObject2 = null;
              int i = j;
              j = k;
              continue;
            }
            try
            {
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_url.has()) {
                localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_url.get();
              }
            }
            catch (Exception localException5)
            {
              j = 0;
              localMessageRecord1 = null;
              localObject6 = null;
              localObject2 = paramMessageRecord;
              paramMessageRecord = (MessageRecord)localObject6;
              continue;
            }
            try
            {
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_md5.has()) {
                localObject2 = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_md5.get();
              }
              m = i1;
            }
            catch (Exception localException6)
            {
              j = 0;
              localObject6 = null;
              localObject2 = paramMessageRecord;
              paramMessageRecord = (MessageRecord)localObject6;
              continue;
              bool2 = false;
              continue;
              String str = "0";
              continue;
              k = j;
              continue;
              k = 0;
              continue;
            }
            try
            {
              localObject5 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_attr");
              m = i1;
              bool1 = TextUtils.isEmpty((CharSequence)localObject5);
              if (bool1) {
                continue;
              }
              try
              {
                k = Integer.parseInt((String)localObject5);
                localObject3 = localObject2;
                j = k;
                localObject2 = localObject1;
                localObject1 = localObject3;
                if (j != 20) {
                  break label1017;
                }
                bool1 = true;
                localObject3 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_need_mask");
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  bool1 = Boolean.parseBoolean((String)localObject3);
                }
                if ((n == 0) && (bool1)) {
                  break label1017;
                }
                localObject3 = "1";
                bool3 = false;
                bool1 = false;
                bool2 = bool3;
                try
                {
                  localObject5 = paramTextView.getTag(2131296470);
                  if (localObject5 != null)
                  {
                    bool2 = bool3;
                    bool1 = ((Boolean)localObject5).booleanValue();
                  }
                  bool2 = bool1;
                  localObject5 = paramTextView.getTag(2131296471);
                  if (localObject5 == null) {
                    break label1011;
                  }
                  bool2 = bool1;
                  bool3 = ((Boolean)localObject5).booleanValue();
                  bool2 = bool3;
                }
                catch (Exception localException7)
                {
                  Object localObject4;
                  localException7.printStackTrace();
                  bool3 = false;
                  bool1 = bool2;
                  bool2 = bool3;
                  continue;
                }
                if ((!bool1) && (((String)localObject3).equalsIgnoreCase("0")))
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord2.senderuin, "Tips_Show", "Mask", i, j, Long.toString(localMessageRecord2.msgUid), Long.toString(localMessageRecord2.uniseq), "", "");
                  paramTextView.setTag(2131296470, Boolean.valueOf(true));
                }
                if ((!bool2) && (((String)localObject3).equalsIgnoreCase("1")))
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord2.senderuin, "Tips_Show", "Show", i, j, Long.toString(localMessageRecord2.msgUid), Long.toString(localMessageRecord2.uniseq), "", "");
                  paramTextView.setTag(2131296471, Boolean.valueOf(true));
                }
                AntiFraudConfigFileUtil.a().a(null, "SensMsgTipsCfg", (String)localObject2, (String)localObject1);
                try
                {
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("sens_msg_id", i);
                  ((JSONObject)localObject1).put("sens_msg_attr", j);
                  ((JSONObject)localObject1).put("sens_msg_status", localObject3);
                  ((JSONObject)localObject1).put("sens_msg_phoe", paramMessageRecord);
                  ((JSONObject)localObject1).put("sens_msg_senderuin", localMessageRecord2.senderuin);
                  ((JSONObject)localObject1).put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  ((JSONObject)localObject1).put("sens_msg_peeruin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  ((JSONObject)localObject1).put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
                  ((JSONObject)localObject1).put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
                  ((JSONObject)localObject1).put("sens_msg_istroop", localMessageRecord2.istroop);
                  ((JSONObject)localObject1).put("sens_msg_uniseq", localMessageRecord2.uniseq);
                  a(((JSONObject)localObject1).toString(), paramTextView);
                  return;
                }
                catch (Exception paramTextView)
                {
                  paramTextView.printStackTrace();
                  return;
                }
                localException1 = localException1;
                localException1.printStackTrace();
              }
              catch (Exception localException2)
              {
                m = i1;
                localException2.printStackTrace();
                k = i2;
                continue;
              }
              localException3.printStackTrace();
            }
            catch (Exception localException3)
            {
              j = m;
              localObject5 = localObject2;
              localObject2 = paramMessageRecord;
              paramMessageRecord = (MessageRecord)localObject5;
            }
            localObject4 = localException1;
            localObject5 = localObject2;
            MessageRecord localMessageRecord1 = paramMessageRecord;
            Object localObject2 = localObject4;
            paramMessageRecord = (MessageRecord)localObject5;
            continue;
            int k = i2;
            m = i1;
            if (((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.has())
            {
              m = i1;
              localObject4 = ((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.get().iterator();
              j = i3;
              k = j;
              m = j;
              if (((Iterator)localObject4).hasNext())
              {
                m = j;
                localObject5 = (bankcode_info.BankcodeElem)((Iterator)localObject4).next();
                m = j;
                if (((bankcode_info.BankcodeElem)localObject5).bankcode_attr.has())
                {
                  m = j;
                  k = ((bankcode_info.BankcodeElem)localObject5).bankcode_attr.get();
                  if (k > j)
                  {
                    j = k;
                    continue;
                  }
                }
                Object localObject6;
                n = 0;
              }
            }
          }
        }
        localMessageRecord2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, l1);
      } while (localMessageRecord2 == null);
      paramMessageRecord = localMessageRecord2.getExtInfoFromExtStr("sens_msg_confirmed");
      if ((TextUtils.isEmpty(paramMessageRecord)) || (!paramMessageRecord.equalsIgnoreCase("1"))) {
        break label1037;
      }
      n = 1;
      k = -1;
      i1 = 0;
      i3 = 0;
      i2 = 0;
      paramMessageRecord = null;
      localObject1 = null;
      localObject2 = null;
      localObject5 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty((CharSequence)localObject5));
    j = k;
  }
  
  void a(TextView paramTextView, String paramString)
  {
    String str1 = null;
    Object localObject;
    String str2;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = paramString.split("\\$");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTipMsg", 2, "splitResult is:" + Arrays.toString((Object[])localObject));
      }
      str2 = "";
      if (localObject.length >= 1)
      {
        if (!localObject[0].startsWith("ver=")) {
          break label195;
        }
        str2 = localObject[0].split("\\=")[1];
      }
      if (!str2.equals("1")) {
        break label203;
      }
      paramString = localObject[0];
      str1 = "语音通话";
    }
    for (;;)
    {
      label117:
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        localObject = str1;
        if (str1 == null) {
          localObject = "";
        }
        int i = paramString.indexOf((String)localObject);
        if ((str2.equals("1")) && (i < 0)) {
          i = paramString.indexOf("QQ电话");
        }
        for (;;)
        {
          if ((localObject == null) || (((String)localObject).trim().length() == 0) || (i < 0))
          {
            paramTextView.setText(paramString);
            return;
            label195:
            str2 = "1";
            break;
            label203:
            if (!str2.equals("2")) {
              break label294;
            }
            if (localObject.length >= 3)
            {
              paramString = localObject[1];
              str1 = localObject[2];
              break label117;
            }
            paramString = localObject[1];
            break label117;
          }
          paramString = new SpannableString(paramString);
          paramString.setSpan(new nke(this), i, ((String)localObject).length() + i, 33);
          paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramTextView.setText(paramString);
          return;
        }
      }
      label294:
      paramString = null;
    }
  }
  
  void a(MessageForSafeGrayTips paramMessageForSafeGrayTips, TextView paramTextView)
  {
    AntiFraudConfigFileUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SensMsgTipsCfg");
    if ((paramMessageForSafeGrayTips == null) || (paramMessageForSafeGrayTips.safeInfo == null)) {
      return;
    }
    int j = 0;
    if (paramMessageForSafeGrayTips.safeInfo.strFromMobile.has()) {}
    for (String str1 = paramMessageForSafeGrayTips.safeInfo.strFromMobile.get();; str1 = null)
    {
      if (paramMessageForSafeGrayTips.safeInfo.strFromName.has()) {}
      for (String str2 = paramMessageForSafeGrayTips.safeInfo.strFromName.get();; str2 = null)
      {
        int i = j;
        if (paramMessageForSafeGrayTips.safeInfo.strMsgTxt.has()) {}
        try
        {
          i = Integer.parseInt(paramMessageForSafeGrayTips.safeInfo.strMsgTxt.get());
          AntiFraudConfigFileUtil.a().a(null, "SensMsgTipsCfg", null, null);
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("sens_msg_id", 2);
            localJSONObject.put("sens_msg_attr", i);
            localJSONObject.put("sens_msg_status", "0");
            localJSONObject.put("sens_msg_phoe", str1);
            localJSONObject.put("sens_msg_fromname", str2);
            localJSONObject.put("sens_msg_senderuin", paramMessageForSafeGrayTips.senderuin);
            localJSONObject.put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            localJSONObject.put("sens_msg_peeruin", paramMessageForSafeGrayTips.senderuin);
            localJSONObject.put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
            localJSONObject.put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localJSONObject.put("sens_msg_istroop", paramMessageForSafeGrayTips.istroop);
            localJSONObject.put("sens_msg_uniseq", paramMessageForSafeGrayTips.uniseq);
            localJSONObject.put("sens_msg_default_wording", this.jdField_b_of_type_JavaLangString);
            a(localJSONObject.toString(), paramTextView);
            return;
          }
          catch (Exception paramMessageForSafeGrayTips)
          {
            paramMessageForSafeGrayTips.printStackTrace();
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = j;
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, TextView paramTextView)
  {
    try
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      paramTextView.setGravity(3);
      return;
    }
    catch (Exception paramMessageRecord) {}
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
  
  void b(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131367633);
    int i = ((String)localObject).indexOf("QQ电话");
    if (i < 0)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new nkb(this), i, "QQ电话".length() + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void b(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramMessageRecord.extStr)) {}
    do
    {
      return;
      paramMessageRecord = paramMessageRecord.extStr.split(":");
    } while (paramMessageRecord.length < 2);
    paramMessageRecord = String.format("你当前所在WiFi：%s，%s人正在热聊，", new Object[] { paramMessageRecord[0], paramMessageRecord[1] });
    SpannableString localSpannableString = new SpannableString(paramMessageRecord + "去看看吧！");
    localSpannableString.setSpan(new nlh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), paramMessageRecord.length(), (paramMessageRecord + "去看看吧！").length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void b(TextView paramTextView, String paramString)
  {
    int j = paramString.indexOf("的") - 1;
    int k = paramString.indexOf("料") + 1;
    int i = j;
    if (j < 0) {
      i = 10;
    }
    paramString = new SpannableString(paramString);
    paramString.setSpan(new nli(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, k, 33);
    paramString.setSpan(new ForegroundColorSpan(-16734752), i, k, 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString);
  }
  
  public void c(TextView paramTextView)
  {
    int j = "想要打字更快，试试搜狗输入法吧。".indexOf("搜");
    int i = j;
    if (j < 0) {
      i = 10;
    }
    SpannableString localSpannableString = new SpannableString("想要打字更快，试试搜狗输入法吧。");
    localSpannableString.setSpan(new nlj(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), i, j + 5, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void c(TextView paramTextView, String paramString)
  {
    paramTextView.setClickable(true);
    paramTextView.setText("" + "" + paramString);
  }
  
  public void d(TextView paramTextView)
  {
    Object localObject = "为TA设置特别消息提示音," + "请点击";
    int i = "为TA设置特别消息提示音,".length();
    int j = "请点击".length();
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new nlk(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), i, j + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\GrayTipsItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */