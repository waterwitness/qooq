package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopRankColorConfig;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.mobileqq.widget.PatchedTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kvw;
import kvy;
import kwa;
import kwb;
import kwc;
import kwe;
import kwf;
import kwg;
import kwi;
import localpb.richMsg.RichMsg.PttRec;
import mqq.os.MqqHandler;

public class ChatHistory$ChatHistoryAdapter
  extends CursorAdapter
{
  public static final int b = 3;
  public static final int c = 2;
  public static final int d = 1;
  public static final int e = 0;
  public static final int f = 2;
  public static final int g = 1;
  public static final int h = 0;
  public int a;
  public Context a;
  private LayoutInflater a;
  private int i;
  private int j;
  
  public ChatHistory$ChatHistoryAdapter(ChatHistory paramChatHistory, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = 1000;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramChatHistory.jdField_a_of_type_Float < 1.0F)
    {
      paramChatHistory.g = ((int)(100.0F * paramChatHistory.jdField_a_of_type_Float));
      paramChatHistory.f = ((int)(paramChatHistory.jdField_a_of_type_Float * 34.0F));
      paramChatHistory.h = ((int)(paramChatHistory.jdField_a_of_type_Float * 14.0F));
    }
    for (paramChatHistory.i = ((int)(paramChatHistory.jdField_a_of_type_Float * 15.0F));; paramChatHistory.i = ((int)(paramChatHistory.jdField_a_of_type_Float * 15.0F)))
    {
      paramChatHistory = paramContext.getResources().getDisplayMetrics();
      this.j = Math.min(paramChatHistory.widthPixels, paramChatHistory.heightPixels);
      return;
      paramChatHistory.g = ((int)(120.0F * paramChatHistory.jdField_a_of_type_Float));
      paramChatHistory.f = ((int)(paramChatHistory.jdField_a_of_type_Float * 34.0F));
      paramChatHistory.h = ((int)(paramChatHistory.jdField_a_of_type_Float * 14.0F));
    }
  }
  
  private int a(int paramInt)
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
    int k;
    if (paramInt >= 60) {
      k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g;
    }
    do
    {
      do
      {
        return k;
        if ((paramInt > 45) && (paramInt < 60)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 15 / 16 + (paramInt - 45) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        if ((paramInt > 30) && (paramInt <= 45)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 13 / 16 + (paramInt - 30) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 2 / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        if ((paramInt > 15) && (paramInt <= 30)) {
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 9 / 16 + (paramInt - 15) * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * 4 / 15 / 16 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
        }
        k = m;
      } while (paramInt <= 0);
      k = m;
    } while (paramInt > 15);
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.g * paramInt * 9 / 16 / 15 + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.f;
  }
  
  private String a(long paramLong)
  {
    Time localTime1 = new Time();
    Time localTime2 = new Time();
    localTime1.set(paramLong);
    localTime2.setToNow();
    if (localTime1.year != localTime2.year) {
      return localTime1.format("%Y-%m-%d %H:%M:%S");
    }
    if (localTime1.yearDay != localTime2.yearDay) {
      return localTime1.format("%m-%d %H:%M:%S");
    }
    return localTime1.format("%H:%M:%S");
  }
  
  private void a(ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2)
  {
    if (paramMarkFaceMessage == null)
    {
      a(paramImageView1, 0, null);
      return;
    }
    paramMarkFaceMessage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(13)).a(paramMarkFaceMessage);
    paramImageView2.setTag(paramMarkFaceMessage);
    int k;
    int m;
    if (paramMarkFaceMessage != null)
    {
      String str = EmoticonUtils.t.replace("[epId]", paramMarkFaceMessage.a.epId);
      k = PngFrameUtil.a(paramMarkFaceMessage.a.magicValue);
      if ((FileUtils.a(str)) && (k == 1))
      {
        k = 3;
        if (!paramMarkFaceMessage.a()) {
          break label184;
        }
        paramImageView2.setVisibility(0);
        paramImageView2.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130841713));
        m = k;
      }
    }
    for (;;)
    {
      paramImageView1.setMinimumHeight((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float * 100.0F));
      paramImageView1.setMinimumWidth((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float * 100.0F));
      a(paramImageView1, m, paramMarkFaceMessage);
      return;
      if (paramMarkFaceMessage.b())
      {
        k = 2;
        break;
      }
      if (paramMarkFaceMessage.c())
      {
        k = 1;
        break;
        label184:
        m = k;
        if (k != 1) {
          continue;
        }
        paramImageView2.setVisibility(0);
        paramImageView2.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130837547));
        m = k;
        continue;
      }
      k = 0;
      break;
      m = 0;
    }
  }
  
  private void a(ImageViewParameter paramImageViewParameter)
  {
    Object localObject = PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    int k = paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.msgtype;
    localObject = paramImageViewParameter.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.action;
    paramImageViewParameter.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new kwf(this, k, paramImageViewParameter, (String)localObject));
  }
  
  public void a()
  {
    super.changeCursor(null);
  }
  
  public void a(ImageView paramImageView, int paramInt, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if (paramPicEmoticonInfo == null) {
      paramImageView.setImageResource(2130837545);
    }
    do
    {
      do
      {
        return;
        if (paramInt != 2) {
          break label221;
        }
        if (paramPicEmoticonInfo.a()) {
          break;
        }
        paramPicEmoticonInfo = paramPicEmoticonInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float);
      } while (paramPicEmoticonInfo == null);
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
      paramImageView.setOnClickListener(null);
      return;
    } while (paramPicEmoticonInfo.a("fromAIO", true) == null);
    paramImageView.setOnClickListener(new kwe(this, paramPicEmoticonInfo));
    Object localObject = (View)paramImageView.getParent();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, paramImageView.getTag())))
    {
      paramImageView = EmoticonUtils.k.replace("[epId]", paramPicEmoticonInfo.a.epId).replace("[eId]", paramPicEmoticonInfo.a.eId);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a((View)localObject, paramImageView);
      if (localObject == null) {
        break label342;
      }
    }
    label221:
    label342:
    for (paramImageView = (ImageView)((View)localObject).findViewById(2131297662);; paramImageView = null)
    {
      ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramImageView);
      return;
      if (localObject != null) {}
      for (localObject = (ImageView)((View)localObject).findViewById(2131297662);; localObject = null)
      {
        ChatHistory.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, (ImageView)localObject);
        ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramImageView, paramPicEmoticonInfo);
        return;
        if (paramInt == 1)
        {
          paramPicEmoticonInfo = paramPicEmoticonInfo.a();
          if (paramPicEmoticonInfo == null) {
            break;
          }
          paramImageView.setImageDrawable(paramPicEmoticonInfo);
          return;
        }
        if (paramInt == 3)
        {
          localObject = new MarketFaceItemBuilder.Holder();
          paramImageView.setOnClickListener(null);
          ((MarketFaceItemBuilder.Holder)localObject).e = paramImageView;
          ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramPicEmoticonInfo;
          paramImageView = (PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(82);
          ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_Long = paramPicEmoticonInfo.a.getId();
          paramImageView.a(paramPicEmoticonInfo.a.magicValue, (MarketFaceItemBuilder.Holder)localObject, paramPicEmoticonInfo.a.getId(), false, false, null);
          return;
        }
        if (paramInt != 0) {
          break;
        }
        paramImageView.setImageResource(2130837545);
        return;
      }
    }
  }
  
  public void a(MixedMsgLinearLayout paramMixedMsgLinearLayout, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForMixedMsg.parse();
    int m = paramMessageForMixedMsg.msgElemList.size();
    int k = 0;
    while (k < m)
    {
      localObject1 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(k);
      if (((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).time == 0L)) {
        MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localObject1, paramMessageForMixedMsg);
      }
      k += 1;
    }
    paramMixedMsgLinearLayout.a(paramMessageForMixedMsg.msgElemList);
    Object localObject1 = new MixedImageOnclickListener();
    ((MixedImageOnclickListener)localObject1).a = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory);
    m = paramMessageForMixedMsg.msgElemList.size();
    k = 0;
    if (k < m)
    {
      Object localObject2 = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(k);
      View localView = paramMixedMsgLinearLayout.getChildAt(k);
      Object localObject3;
      if ((localObject2 instanceof MessageForText))
      {
        localObject3 = (AnimationTextView)localView;
        ((AnimationTextView)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getColor(2131428297));
        ((AnimationTextView)localObject3).setTextSize(0, AIOUtils.a(16.0F, paramMixedMsgLinearLayout.getContext().getResources()));
        if (TextUtils.isEmpty(((MessageForText)localObject2).sb2)) {
          ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb);
        }
      }
      for (;;)
      {
        localView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
        k += 1;
        break;
        ((AnimationTextView)localObject3).setText(((MessageForText)localObject2).sb2);
        continue;
        if ((localObject2 instanceof MessageForPic))
        {
          localObject2 = (MessageForPic)localObject2;
          localObject3 = (ChatThumbView)localView;
          URLDrawable localURLDrawable = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject2, (ChatThumbView)localObject3);
          ((ChatThumbView)localObject3).setTag(2131296342, localObject2);
          ((ChatThumbView)localObject3).setImageDrawable(localURLDrawable);
          ((ChatThumbView)localObject3).setOnClickListener((View.OnClickListener)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("ChatHistory", 2, "mixed type not support yet." + localObject2.getClass().getSimpleName());
        }
      }
    }
    paramMixedMsgLinearLayout.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
    paramMixedMsgLinearLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    String str1;
    switch (paramInt1)
    {
    default: 
      str1 = "ORDER BY time asc , longMsgIndex asc";
    }
    for (;;)
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      paramString = MessageRecord.getOldTableName(paramString, paramInt1);
      str1 = "( msgtype " + MsgProxyUtils.b() + " and isValid=1 ) " + str1 + " limit " + paramInt2 + "," + String.valueOf(8);
      ThreadManager.b().post(new kwg(this, str2, paramString, str1));
      return;
      str1 = "ORDER BY shmsgseq";
      continue;
      str1 = "ORDER BY shmsgseq";
    }
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    kwi localkwi = (kwi)paramView.getTag();
    if (localkwi == null)
    {
      localkwi = new kwi(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, null);
      paramView.setTag(localkwi);
    }
    for (;;)
    {
      Object localObject1 = MessageRecord.getTableName(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int);
      localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).a(MessageRecord.class, (String)localObject1, paramCursor));
      if (localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        if (QLog.isColorLevel()) {
          QLog.w("ChatHistory", 2, "bindView message is null !!");
        }
      }
      label101:
      TextView localTextView1;
      PatchedTextView localPatchedTextView;
      ImageView localImageView1;
      int n;
      label677:
      label728:
      label758:
      label1322:
      label1435:
      label1557:
      label1578:
      label1584:
      label1726:
      label1784:
      label3053:
      label3059:
      label3161:
      label4478:
      label4492:
      label4946:
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().a(localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          long l3 = paramCursor.getLong(0);
          localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.setId(l3);
          LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131297654);
          TextView localTextView3 = (TextView)paramView.findViewById(2131297655);
          localTextView1 = (TextView)paramView.findViewById(2131297656);
          TextView localTextView4 = (TextView)paramView.findViewById(2131297657);
          localPatchedTextView = (PatchedTextView)paramView.findViewById(2131297659);
          localImageView1 = (ImageView)paramView.findViewById(2131297660);
          MixedMsgLinearLayout localMixedMsgLinearLayout = (MixedMsgLinearLayout)paramView.findViewById(2131297665);
          TextView localTextView2 = (TextView)paramView.findViewById(2131297658);
          localLinearLayout.setVisibility(0);
          localPatchedTextView.setVisibility(0);
          localTextView2.setVisibility(8);
          ChatThumbView localChatThumbView = (ChatThumbView)paramView.findViewById(2131297661);
          localChatThumbView.jdField_a_of_type_Boolean = false;
          ImageView localImageView3 = (ImageView)paramView.findViewById(2131297663);
          Button localButton = (Button)paramView.findViewById(2131297664);
          ImageView localImageView2 = (ImageView)paramView.findViewById(2131297662);
          localImageView2.setVisibility(8);
          localTextView3.setVisibility(8);
          localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
          String str1 = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
          String str2 = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
          k = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
          int m = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
          n = paramCursor.getInt(paramCursor.getColumnIndex("time"));
          int i1;
          Object localObject3;
          Object localObject6;
          Object localObject5;
          String str3;
          if ((paramCursor.getColumnIndex("versionCode") < 0) || (paramCursor.getInt(paramCursor.getColumnIndex("versionCode")) <= 0))
          {
            localObject1 = paramCursor.getString(paramCursor.getColumnIndex("msg"));
            i1 = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
            localObject1 = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, k, i1, (String)localObject1, m).msg;
            localObject3 = TroopBusinessUtil.a(localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            localObject6 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getManager(51);
            localObject5 = ((TroopManager)localObject6).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_d_of_type_JavaLangString);
            if ((localObject5 != null) && (((TroopInfo)localObject5).cGroupRankSysFlag == 1) && (((TroopInfo)localObject5).cGroupRankUserFlag == 1) && (localObject3 == null))
            {
              str3 = localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("uniqueTitle");
              TroopMemberInfo localTroopMemberInfo = ((TroopManager)localObject6).a(str1, str2);
              localObject6 = ((TroopManager)localObject6).a((TroopInfo)localObject5, localTroopMemberInfo, paramContext);
              k = 0;
              if (localTroopMemberInfo != null) {
                k = localTroopMemberInfo.level;
              }
              if ((((TroopInfo)localObject5).troopowneruin == null) || (!((TroopInfo)localObject5).troopowneruin.equals(str2))) {
                break label1322;
              }
              localTextView3.setVisibility(0);
              localTextView3.setText(2131367352);
              TroopRankColorConfig.a(localTextView3, 0, 0);
            }
            if (localObject3 == null) {
              break label1435;
            }
            localTextView1.setText(((TroopBusinessUtil.TroopBusinessMessage)localObject3).c);
            localTextView3.setVisibility(0);
            localTextView3.setText(((TroopBusinessUtil.TroopBusinessMessage)localObject3).jdField_d_of_type_JavaLangString);
            localTextView3.setBackgroundDrawable(TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources(), ((TroopBusinessUtil.TroopBusinessMessage)localObject3).jdField_d_of_type_Int));
            if ((localObject3 == null) || (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, false, null))) {
              break label1557;
            }
            localTextView1.setTextColor(((TroopBusinessUtil.TroopBusinessMessage)localObject3).b);
            localTextView4.setText(a(n * 1000L));
            n = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
            if (n != 32768) {
              break label1578;
            }
          }
          for (k = 1;; k = 0)
          {
            if (k != 0) {
              localPatchedTextView.setMaxWidth((int)(paramContext.getResources().getDisplayMetrics().widthPixels - 70.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Float));
            }
            localChatThumbView.setVisibility(8);
            localPatchedTextView.setVisibility(8);
            localImageView1.setVisibility(8);
            localImageView3.setVisibility(8);
            localButton.setVisibility(8);
            localMixedMsgLinearLayout.setVisibility(8);
            localPatchedTextView.setOnTouchListener(null);
            localPatchedTextView.setOnLongClickListener(null);
            localPatchedTextView.setOnClickListener(null);
            localButton.setOnClickListener(null);
            i1 = paramCursor.getInt(getCursor().getColumnIndex("msgtype"));
            if (i1 != 63529) {
              break label1584;
            }
            localChatThumbView.setVisibility(0);
            localPatchedTextView.setVisibility(8);
            localImageView1.setVisibility(8);
            localImageView3.setVisibility(8);
            localButton.setVisibility(8);
            localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
            localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
            paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            localChatThumbView.setTag(str1 + l3);
            localImageView2.setTag(null);
            try
            {
              a(localChatThumbView, (MarkFaceMessage)MessagePkgUtils.a(paramView), localImageView2);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              a(localChatThumbView, null, localImageView2);
              return;
            }
            if (((localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForFoldMsg)) || ((localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForUniteGrayTip)))
            {
              localObject1 = localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg;
              break;
            }
            try
            {
              localObject5 = new String(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")), "UTF-8");
              for (;;)
              {
                try
                {
                  localObject1 = new StringBuilder((String)localObject5);
                  localObject3 = localObject1;
                  if ((localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForText))
                  {
                    localObject3 = localObject1;
                    if (localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 3000)
                    {
                      str3 = localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("disc_at_info_list");
                      bool = TextUtils.isEmpty(str3);
                      localObject3 = localObject1;
                      if (bool) {}
                    }
                  }
                  try
                  {
                    localObject3 = BaseApplicationImpl.a.a();
                    if (!QQAppInterface.class.isInstance(localObject3)) {
                      continue;
                    }
                    localObject3 = AtTroopMemberSpan.a((QQAppInterface)localObject3, (StringBuilder)localObject1, str3, str1);
                    localObject1 = localObject3;
                    localObject3 = localObject1;
                  }
                  catch (Exception localException2)
                  {
                    QLog.e("ChatHistory", 1, "replaceAtMsgByMarkName", localException2);
                    localObject4 = localObject1;
                    continue;
                  }
                  localObject1 = ((StringBuilder)localObject3).toString();
                }
                catch (Exception localException1)
                {
                  localObject4 = localObject5;
                  localObject5 = localException1;
                  localObject2 = localObject4;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ChatHistory", 2, "We get error AppRuntime");
                }
              }
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                boolean bool;
                Object localObject4;
                long l2;
                long l1;
                Object localObject2 = "";
              }
            }
            QLog.e("ChatHistory", 1, "cursor Error", (Throwable)localObject5);
            break;
            if ((((TroopInfo)localObject5).Administrator != null) && (((TroopInfo)localObject5).Administrator.contains(str2)))
            {
              localTextView3.setVisibility(0);
              localTextView3.setText(2131367351);
              TroopRankColorConfig.a(localTextView3, 1, 0);
              break label677;
            }
            if (!TextUtils.isEmpty(str3))
            {
              localTextView3.setVisibility(0);
              localTextView3.setText(str3);
              TroopRankColorConfig.a(localTextView3, 2, 0);
              break label677;
            }
            if ((localObject6 == null) || (((String)localObject6).length() <= 0)) {
              break label677;
            }
            localTextView3.setVisibility(0);
            localTextView3.setText((CharSequence)localObject6);
            TroopRankColorConfig.a(localTextView3, 3, k);
            break label677;
            if (AnonymousChatHelper.a(localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
            {
              localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getString(2131364731) + AnonymousChatHelper.a(localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).b);
              localTextView3.setVisibility(8);
              break label728;
            }
            if (TroopBindPublicAccountMgr.a(localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
            {
              localTextView1.setText(PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, BaseApplicationImpl.getContext()));
              break label728;
            }
            ThreadManager.a(new kvw(this, m, str2, localTextView1), 8, null, true);
            break label728;
            localTextView1.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getColor(2131428268));
            break label758;
          }
          if (i1 == 63497)
          {
            paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
            paramContext = new MessageForApollo();
            paramContext.msgData = paramView;
            paramContext.parse();
            localPatchedTextView.setVisibility(0);
            if (!TextUtils.isEmpty(paramContext.msg))
            {
              localPatchedTextView.setText(paramContext.msg);
              return;
            }
            localPatchedTextView.setText("[动作消息]");
            return;
          }
          if (i1 == 63526)
          {
            localChatThumbView.setVisibility(8);
            localPatchedTextView.setVisibility(0);
            localImageView1.setVisibility(8);
            localImageView3.setVisibility(8);
            localButton.setVisibility(8);
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
            if ((localObject2 == null) || (((String)localObject2).length() <= 0) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b(((String)localObject2).toString()))) {
              break label4946;
            }
            paramContext = localObject2.split("\026")[1].split("\\|");
            paramCursor = paramContext[0];
            if (paramContext.length >= 2) {
              break label4478;
            }
            k = 1;
            if (paramContext.length >= 5) {
              localkwi = paramContext[4];
            }
            if (paramContext.length >= 6) {
              TransfileUtile.a(((String)localObject2).toString());
            }
            l2 = 0L;
            l1 = l2;
            if (paramContext != null)
            {
              l1 = l2;
              if (paramContext.length > 1) {
                if (paramContext[1] != null) {
                  break label4492;
                }
              }
            }
          }
          for (paramContext = "0";; paramContext = paramContext[1])
          {
            l1 = Long.parseLong(paramContext);
            Uri.parse(paramCursor);
            switch (k)
            {
            default: 
              return;
            case 0: 
              localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131369279));
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
              return;
              if ((i1 == 63525) || (i1 == 63485))
              {
                paramView = StructMsgFactory.a(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")));
                paramContext = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramView);
                if (TextUtils.isEmpty(paramContext)) {
                  break label101;
                }
                paramView = paramContext;
                if (TroopBindPublicAccountMgr.a(localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
                {
                  paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().getString(2131365255), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, BaseApplicationImpl.getContext()) });
                  paramView = paramView + paramContext;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 62530)
              {
                paramView = MessageForPubAccount.getMsgSummary(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, true);
                if (TextUtils.isEmpty(paramView)) {
                  break label101;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 60527)
              {
                paramView = BitAppMsgFactory.a(paramCursor.getBlob(paramCursor.getColumnIndex("msgData")));
                paramView = ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramView);
                if (TextUtils.isEmpty(paramView)) {
                  break label101;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 60528)
              {
                paramView = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new ArkAppMessage();
                paramContext.fromBytes(paramView);
                paramView = paramContext.promptText;
                if (TextUtils.isEmpty(paramView)) {
                  break label101;
                }
                localPatchedTextView.setText(paramView);
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if ((i1 == 63536) || (i1 == 45536) || (i1 == 62532) || (i1 == 62531) || (i1 == 62536) || (i1 == 62535))
              {
                if ((localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
                {
                  if (FlashPicHelper.a(localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
                  {
                    localPatchedTextView.setVisibility(0);
                    localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131369797));
                    localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                    localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                    return;
                  }
                  paramView = (MessageForPic)localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                  paramView.parse();
                  paramContext = new ImageViewParameter();
                  localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                  localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                  paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramView;
                  paramContext.jdField_a_of_type_ComTencentImageURLImageView = localChatThumbView;
                  if (QLog.isColorLevel()) {
                    QLog.d("history", 2, "bindView pic.path:" + paramView.path + ",pic.uuid:" + paramView.uuid);
                  }
                  if ((paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null) || (paramContext.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.path == null)) {
                    break label101;
                  }
                  a(paramContext);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break label101;
                }
                QLog.d("history", 2, "holy shit,not messageforpicuniseq:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ",dbid:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getId() + "istroop:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop + ",msgtype:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
                return;
              }
              if (i1 == 63534)
              {
                localObject4 = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramContext = new RichMsg.PttRec();
                try
                {
                  paramContext.mergeFrom((byte[])localObject4);
                  k = 1;
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    k = 0;
                    localException3.printStackTrace();
                    continue;
                    bool = false;
                    continue;
                    k = 0;
                  }
                  localButton.setText(String.valueOf(k) + "\"");
                  localButton.setPadding(n, 0, a(k), 0);
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo == null) {
                    break label3161;
                  }
                }
                if (k == 0) {
                  break label1726;
                }
                if ((localkwi != null) && (localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt)))
                {
                  if (((MessageForPtt)localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceChangeFlag == 1)
                  {
                    bool = true;
                    localkwi.jdField_a_of_type_Boolean = bool;
                  }
                }
                else
                {
                  bool = localkwi.jdField_a_of_type_Boolean;
                  if (!paramContext.voiceType.has()) {
                    break label3053;
                  }
                  k = paramContext.voiceType.get();
                  paramCursor = MessageForPtt.getLocalFilePath(k, paramContext.localPath.get());
                  l1 = paramContext.size.get();
                  n = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
                  k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
                  localButton.setTag(paramCursor + str1 + l3);
                  localButton.setVisibility(0);
                  localButton.setText("");
                  localButton.setText(null);
                  localButton.setCompoundDrawables(null, null, null, null);
                  localButton.setPadding(n, 0, k, 0);
                  localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                  localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                  m = paramContext.voiceLength.get();
                  k = m;
                  if (m <= 0) {
                    k = QQRecorder.a(paramCursor);
                  }
                  if ((paramCursor.startsWith(AppConstants.bj)) && (k > 0)) {
                    break label3059;
                  }
                  localButton.setCompoundDrawables(null, null, null, null);
                  localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131368683) + "]");
                  localButton.setOnClickListener(null);
                  return;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, localButton.getTag()))
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(paramView, paramCursor);
                  localButton.setOnClickListener(new kvy(this, k, paramCursor));
                  return;
                }
                if (bool) {}
                for (paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843048);; paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843047))
                {
                  paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
                  localButton.setCompoundDrawables(paramView, null, null, null);
                  if (l1 > 0L) {
                    break;
                  }
                  localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131368684) + "]");
                  break;
                }
              }
              if (i1 == 64501)
              {
                localMixedMsgLinearLayout.setVisibility(0);
                a(localMixedMsgLinearLayout, (MessageForMixedMsg)localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                return;
              }
              if (i1 == 63519)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(MsgUtils.a(null));
                return;
              }
              if (i1 == 63516)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnClickListener(new kwa(this, str1));
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                if (MsgUtils.a(m))
                {
                  localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().getString(2131367606, new Object[] { ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory).jdField_d_of_type_JavaLangString }));
                  return;
                }
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().getString(2131367605));
                return;
              }
              if (i1 == 62528)
              {
                localPatchedTextView.setText(BaseApplicationImpl.getContext().getString(2131362874) + "\"" + (String)localObject2 + "\"");
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 63514)
              {
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131371515));
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 60534)
              {
                if ((localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForIncompatibleGrayTips)))
                {
                  paramView = (MessageForIncompatibleGrayTips)localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                  paramView.parse();
                  localPatchedTextView.setText(paramView.msg);
                  localPatchedTextView.setVisibility(0);
                  paramCursor = paramView.url;
                  paramContext = new SpannableString(paramView.msg);
                  paramCursor = new kwb(this, paramCursor, str1);
                  paramContext.setSpan(new ForegroundColorSpan(2131427352), paramView.linkStart, paramView.linkEnd, 33);
                  paramContext.setSpan(paramCursor, paramView.linkStart, paramView.linkEnd, 33);
                  localPatchedTextView.setText(paramContext);
                  localPatchedTextView.setMovementMethod(LinkMovementMethod.getInstance());
                  localPatchedTextView.setHighlightColor(17170445);
                  localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                  localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                  return;
                }
                if (!QLog.isColorLevel()) {
                  break label101;
                }
                QLog.d("history", 2, "holy shit,not MessageForIncompatibleGrayTipsuniseq:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + ",dbid:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getId() + "istroop:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop + ",msgtype:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype);
                return;
              }
              if (i1 == 63511)
              {
                paramView = new MessageForQQWalletMsg();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getMsgSummary());
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 63500)
              {
                paramView = new MessageForTroopFee();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getSummaryMsg());
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 63501)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(".troop.send_gift", 2, "ChatHistory decode MessageForDeliverGiftTips. seq:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq + "msgtype:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype + "msg:" + localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg);
                }
                paramView = (MessageForDeliverGiftTips)localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                localLinearLayout.setVisibility(8);
                localPatchedTextView.setVisibility(8);
                localTextView2.setVisibility(0);
                localTextView2.setClickable(true);
                localTextView2.setFocusable(true);
                localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
                localTextView2.setVisibility(0);
                localTextView2.setText(paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, this.jdField_a_of_type_AndroidContentContext));
                return;
              }
              if (i1 == 63498)
              {
                paramView = new MessageForTroopGift();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.summary);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 63488)
              {
                paramView = new MessageForTroopReward();
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.getSummaryMsg());
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 == 63492)
              {
                paramView = (MessageForTroopTopic)localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
                paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
                paramView.parse();
                localPatchedTextView.setVisibility(0);
                localPatchedTextView.setText(paramView.msg);
                localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
                return;
              }
              if (i1 != 60526) {
                break label1726;
              }
              paramView = (MessageForDingdongSchedule)localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
              paramView.msgData = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramView.parse();
              localPatchedTextView.setVisibility(0);
              localPatchedTextView.setText(paramView.msg);
              localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
              localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
              return;
              k = Integer.valueOf(paramContext[2]).intValue();
              break label1784;
            }
          }
          localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
          localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
          return;
          k = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.h;
          m = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.i;
          localButton.setTag(paramCursor + str1 + l3);
          localButton.setVisibility(0);
          localButton.setText("");
          localButton.setText(null);
          localButton.setCompoundDrawables(null, null, null, null);
          localButton.setPadding(k, 0, m, 0);
          localButton.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
          localButton.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
          m = QQRecorder.a(paramCursor);
          if ((!paramCursor.startsWith(AppConstants.bj)) || (m <= 0))
          {
            localButton.setCompoundDrawables(null, null, null, null);
            localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131368683) + "]");
            localButton.setOnClickListener(null);
            return;
          }
          localButton.setText(String.valueOf(m) + "\"");
          localButton.setPadding(k, 0, a(m), 0);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(0, localButton.getTag()))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$PlayingPttHistoryInfo.a(paramView, paramCursor);
          }
          for (;;)
          {
            localButton.setOnClickListener(new kwc(this, m, paramCursor));
            return;
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843047);
            paramView.setBounds(0, 0, paramView.getMinimumWidth(), paramView.getMinimumHeight());
            localButton.setCompoundDrawables(paramView, null, null, null);
            if (l1 <= 0L) {
              localButton.setText("[" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131368684) + "]");
            }
          }
          localChatThumbView.setVisibility(0);
          localChatThumbView.setOnClickListener(null);
          localChatThumbView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
          localChatThumbView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
          localChatThumbView.setImageResource(2130838118);
          return;
          k = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
          localPatchedTextView.setVisibility(0);
          if (!MessageUtils.a(i1))
          {
            localPatchedTextView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
            localPatchedTextView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Kwh);
          }
          if (!String.valueOf(AppConstants.aq).equals(str1)) {
            break;
          }
          paramView = SystemMsg.decode(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, (String)localObject2, str2, k);
        } while (paramView == null);
        localPatchedTextView.setText(paramView.message);
      } while (n != 32769);
      localTextView1.setText(paramView.troopCode);
      return;
      if (63528 == k)
      {
        localPatchedTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131370361));
        return;
      }
      if (64534 == k)
      {
        localPatchedTextView.setText(localkwi.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("sens_msg_original_text"));
        return;
      }
      int k = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
      if ((localImageView1 != null) && (k == 32768)) {
        localImageView1.setVisibility(0);
      }
      localPatchedTextView.setText(new QQText((CharSequence)localObject2, 13, 32, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_Int));
      return;
    }
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      if (getCursor() != null) {
        getCursor().deactivate();
      }
      super.changeCursor(paramCursor);
      notifyDataSetChanged();
    }
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903197, paramViewGroup, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatHistory$ChatHistoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */