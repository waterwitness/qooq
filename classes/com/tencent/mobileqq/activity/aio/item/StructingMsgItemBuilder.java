package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.util.PAReportUtil.AdverInfo;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgClickHandler;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgTimeReport;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout10.ViewHolder;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.ViewHolder;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.XListView;
import cooperation.comic.VipComicReportUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nph;
import npi;
import npj;
import npl;
import npm;
import npn;
import npp;
import npr;
import nps;
import npt;
import npu;
import npv;
import npw;
import npx;
import npy;
import npz;
import nqa;
import nqb;
import nqc;
import nqd;
import nqe;
import nqg;
import nqh;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StructingMsgItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, MediaPlayerManager.Callback
{
  public static final String b = "isShowCommentLayout";
  private static final String c = "StructingMsgItemBuilder";
  public static int h;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private StructMsgTimeReport jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport;
  public AbsListView.RecyclerListener a;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private final float b;
  private volatile boolean d;
  private volatile boolean e;
  private volatile boolean f;
  
  public StructingMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new npn(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener = new npz(this);
    if (((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) {
      ((FragmentActivity)paramContext).getChatFragment().a().a(this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener);
    }
    this.b = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport = new StructMsgTimeReport();
  }
  
  private StructMsgForGeneralShare a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForStructing)) {
      paramChatMessage = null;
    }
    StructMsgForGeneralShare localStructMsgForGeneralShare;
    do
    {
      return paramChatMessage;
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if (!(paramChatMessage.structingMsg instanceof StructMsgForGeneralShare)) {
        break;
      }
      localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramChatMessage.structingMsg;
      paramChatMessage = localStructMsgForGeneralShare;
    } while (localStructMsgForGeneralShare.getProgress() >= 0);
    return null;
  }
  
  public static String a()
  {
    return String.valueOf(h);
  }
  
  private void a(long paramLong)
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
    {
      VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
      VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if ((localVipGiftDownloadInfo != null) && (localBaseActivity.isResume()) && (localVipGiftDownloadInfo.b.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localVipGiftDownloadInfo.d == 2L) && (paramLong == localVipGiftDownloadInfo.a)) {
        localVipGiftManager.a(localVipGiftDownloadInfo, localBaseActivity);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2130903496, null);
    ((ImageView)localView.findViewById(2131296844)).setImageResource(2130838452);
    ((TextView)localView.findViewById(2131298715)).setText("退订成功");
    localDialog.setContentView(localView);
    localDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new npt(this, localDialog), 1500L);
    this.e = false;
  }
  
  private void a(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    String str = paramChatMessage.frienduin;
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = localAbsStructMsg.adverKey;
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject1).get(i);
        Object localObject2 = new PopupMenuDialog.MenuItem();
        ((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_Int = i;
        ((PopupMenuDialog.MenuItem)localObject2).b = 0;
        if (localJSONObject.has("show_name")) {}
        for (((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");; ((PopupMenuDialog.MenuItem)localObject2).jdField_a_of_type_JavaLangString = "")
        {
          localArrayList1.add(localObject2);
          localObject2 = new PAReportUtil.AdverInfo();
          ((PAReportUtil.AdverInfo)localObject2).jdField_a_of_type_JavaLangString = str;
          ((PAReportUtil.AdverInfo)localObject2).c = localJSONObject.optString("index");
          ((PAReportUtil.AdverInfo)localObject2).d = localJSONObject.optString("index_name");
          ((PAReportUtil.AdverInfo)localObject2).b = localJSONObject.optString("index_type");
          ((PAReportUtil.AdverInfo)localObject2).e = String.valueOf(HttpUtil.a());
          localArrayList2.add(localObject2);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(paramActivity, localArrayList1, new npj(this, paramActivity, paramChatMessage, localAbsStructMsg, str, localArrayList2), new npl(this), AIOUtils.a(100.0F, paramActivity.getResources()));
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    int i = paramView.getWidth() * 7 / 2;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, 0 - i, 0);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setOnDismissListener(new npm(this));
  }
  
  private void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    new StructMsgClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView).a(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForStructing paramMessageForStructing)
  {
    int i = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).getProgress();
    if ((paramMessageForStructing.extraflag == 32772) && (i >= 0) && (i < 100))
    {
      TroopQZoneUploadAlbumHandler localTroopQZoneUploadAlbumHandler = (TroopQZoneUploadAlbumHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
      localTroopQZoneUploadAlbumHandler.a(MessageUtils.a(paramMessageForStructing.msgUid), paramMessageForStructing.frienduin, paramMessageForStructing.uniseq);
      localTroopQZoneUploadAlbumHandler.a(paramBaseChatItemLayout, new npw(this, paramMessageForStructing, paramBaseChatItemLayout));
    }
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramBaseChatItemLayout.setHeadIconVisible(false);
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130843537);
      int i = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      int j = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, j);
      return;
    }
    paramBaseChatItemLayout.setHeadIconVisible(true);
  }
  
  private void a(StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean1, AbsStructMsg paramAbsStructMsg, Resources paramResources, boolean paramBoolean2)
  {
    RelativeLayout localRelativeLayout = paramStructingMsgViewHolder.b;
    if (localRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramStructingMsgViewHolder.b = localRelativeLayout;
      localRelativeLayout.setId(2131296331);
      paramBaseChatItemLayout.addView(localRelativeLayout);
    }
    for (;;)
    {
      Object localObject2 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(2.0F, paramResources);
      if (paramBoolean2)
      {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(0.0F, paramResources);
        ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131296328);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131296328);
        if (!paramBoolean1) {
          break label312;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131296318);
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = localRelativeLayout.getChildAt(0);
        paramResources = (Resources)localObject1;
        if (localObject1 != null)
        {
          paramResources = (Resources)localObject1;
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            localObject2 = paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
            paramResources = (Resources)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getTag(2131296312);
              if (QLog.isColorLevel()) {
                QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + localObject2);
              }
              if (localObject2 != null)
              {
                paramResources = (Resources)localObject1;
                if (localObject2.getClass() == paramAbsStructMsg.getClass()) {}
              }
              else
              {
                paramResources = null;
              }
            }
          }
        }
        localRelativeLayout.removeAllViews();
        paramAbsStructMsg = paramAbsStructMsg.getSourceView(this.jdField_a_of_type_AndroidContentContext, paramResources);
        if (paramAbsStructMsg == null) {
          break label334;
        }
        localRelativeLayout.addView(paramAbsStructMsg);
        return;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(10.0F, paramResources);
        break;
        label312:
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131296318);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131296328);
      }
      label334:
      paramBaseChatItemLayout.removeView(localRelativeLayout);
      paramStructingMsgViewHolder.b = null;
      return;
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder)
  {
    if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject;
    int i;
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      localObject = (BaseTransProcessor)paramIHttpCommunicatorListener;
      i = (int)((BaseTransProcessor)localObject).c();
      if ((i != 1004) || (!((BaseTransProcessor)localObject).b()) || (!((BaseTransProcessor)localObject).c())) {
        break label412;
      }
      i = 1006;
    }
    label412:
    for (;;)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131296312);
      ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131296312);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131296312);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131296312);
      if ((paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296393) == null) && (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)) {
        paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
      }
      switch (i)
      {
      default: 
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        return;
      case 1000: 
      case 1001: 
      case 1002: 
      case 1006: 
      case 4001: 
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
        {
          MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
          localMessageProgressTextView.setTextColor(-1);
          localMessageProgressTextView.setTextSize(2, 15.0F);
          localMessageProgressTextView.setGravity(17);
          localMessageProgressTextView.setId(2131296393);
          localMessageProgressTextView.setBackgroundDrawable(new AIOSendMask(2130706432, this.b * 12.0F));
          if (paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            paramStructingMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localMessageProgressTextView, (ViewGroup.LayoutParams)localObject);
          }
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor((BaseTransProcessor)paramIHttpCommunicatorListener);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        switch (i)
        {
        }
        for (;;)
        {
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.c();
          return;
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
          return;
          paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
        }
        if (paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null) {
          break;
        }
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        paramStructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(4);
        return;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        return false;
        paramQQAppInterface = (TroopTopicMgr)paramQQAppInterface.getManager(97);
      } while ((paramQQAppInterface.a) || (paramChatMessage.istroop != 1));
      localObject = (MessageForStructing)paramChatMessage;
    } while (!(((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg));
    Object localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
    if ((localObject instanceof StructMsgForAudioShare)) {}
    label178:
    while ((!paramQQAppInterface.a(((AbsShareMsg)localObject).mSourceAppid)) && (!paramQQAppInterface.a(((AbsShareMsg)localObject).mMsgUrl)) && (!paramQQAppInterface.b(Long.parseLong(paramChatMessage.senderuin))))
    {
      return true;
      if ((!(localObject instanceof StructMsgForGeneralShare)) || (!"web".equals(((AbsShareMsg)localObject).mMsgAction)) || (TextUtils.isEmpty(((AbsShareMsg)localObject).mMsgUrl)) || (TextUtils.isEmpty(((AbsShareMsg)localObject).mSourceName))) {
        break;
      }
      int i = 0;
      if (i < ((AbsShareMsg)localObject).getItemCount()) {
        if (!(((AbsShareMsg)localObject).getItemByIndex(i) instanceof StructMsgItemLayout2)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label178;
        }
        return false;
        i += 1;
        break;
      }
    }
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return 19 == paramAbsStructMsg.mMsgServiceID;
  }
  
  private void b(Activity paramActivity)
  {
    Dialog localDialog = new Dialog(paramActivity);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    View localView = LayoutInflater.from(paramActivity).inflate(2130903496, null);
    ((ImageView)localView.findViewById(2131296844)).setImageResource(2130838442);
    ((TextView)localView.findViewById(2131298715)).setText("退订失败");
    localDialog.setContentView(localView);
    localDialog.show();
    new Handler(paramActivity.getMainLooper()).postDelayed(new npu(this, localDialog), 1500L);
    this.e = false;
  }
  
  private void b(Activity paramActivity, View paramView, ChatMessage paramChatMessage)
  {
    ArrayList localArrayList = new ArrayList();
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    Object localObject = localAbsStructMsg.adverKey;
    for (;;)
    {
      try
      {
        localObject = new JSONArray((String)localObject);
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
        PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
        if (localJSONObject.has("index"))
        {
          localMenuItem.jdField_a_of_type_Int = localJSONObject.getInt("index");
          localMenuItem.b = 0;
          if (localJSONObject.has("show_name"))
          {
            localMenuItem.jdField_a_of_type_JavaLangString = localJSONObject.getString("show_name");
            localArrayList.add(localMenuItem);
            i += 1;
          }
        }
        else
        {
          localMenuItem.jdField_a_of_type_Int = i;
          continue;
        }
        localMenuItem.jdField_a_of_type_JavaLangString = "";
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(paramActivity, localArrayList, new npp(this, paramChatMessage, paramActivity, localAbsStructMsg), new npr(this), AIOUtils.a(100.0F, paramActivity.getResources()));
    int i = paramView.getWidth() * -5 / 7;
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, i, 0);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    paramActivity = new int[2];
    paramView.getLocationOnScreen(paramActivity);
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAtLocation(paramView, 0, paramActivity[0], paramActivity[1] + paramView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setOnDismissListener(new nps(this));
  }
  
  private void b(View paramView, ChatMessage paramChatMessage)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131300742);
    TextView localTextView2 = (TextView)paramView.findViewById(2131300743);
    TextView localTextView5 = (TextView)paramView.findViewById(2131300746);
    TextView localTextView3 = (TextView)paramView.findViewById(2131300744);
    TextView localTextView4 = (TextView)paramView.findViewById(2131300747);
    if (localTextView1 == null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = (StructingMsgItemBuilder.ShareInfoHolder)localTextView2.getTag();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new StructingMsgItemBuilder.ShareInfoHolder(this);
      }
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).b = localTextView3;
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = localTextView2;
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).d = localTextView4;
      ((StructingMsgItemBuilder.ShareInfoHolder)localObject1).c = localTextView5;
      localTextView2.setTag(localObject1);
      localTextView3.setTag(localObject1);
      localTextView5.setTag(localObject1);
      localTextView4.setTag(localObject1);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView5.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView4.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
    } while (paramView == null);
    Object localObject1 = paramView.a(paramChatMessage);
    if (localObject1 != null) {
      if (((TroopTopicDetailInfo)localObject1).mLikeNum > 0)
      {
        localTextView3.setText(((TroopTopicDetailInfo)localObject1).mLikeNum + "");
        localTextView3.setVisibility(0);
        if (!((TroopTopicDetailInfo)localObject1).mIsZan) {
          break label389;
        }
        localObject2 = localTextView2.getContext().getResources().getDrawable(2130840209);
        ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
        localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
        localTextView2.setOnClickListener(null);
        localTextView3.setOnClickListener(null);
        label311:
        if (((TroopTopicDetailInfo)localObject1).mCommentNum <= 0) {
          break label453;
        }
        localTextView4.setText(((TroopTopicDetailInfo)localObject1).mCommentNum + "");
        localTextView4.setVisibility(0);
        label352:
        if (((TroopTopicDetailInfo)localObject1).mCommentNum != 0) {
          break label471;
        }
        localTextView1.setVisibility(4);
      }
    }
    for (;;)
    {
      paramView.a(paramChatMessage);
      return;
      localTextView3.setText("");
      localTextView3.setVisibility(8);
      break;
      label389:
      localObject2 = localTextView2.getContext().getResources().getDrawable(2130840208);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
      localTextView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView3.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break label311;
      label453:
      localTextView4.setText("");
      localTextView4.setVisibility(8);
      break label352;
      label471:
      localTextView1.setVisibility(0);
      localTextView1.setTag(localObject1);
      continue;
      paramView.a(paramChatMessage, true);
      localObject1 = localTextView2.getContext().getResources().getDrawable(2130840208);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      localTextView2.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localTextView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localTextView3.setText("");
      localTextView3.setVisibility(8);
      localTextView4.setText("");
      localTextView4.setVisibility(8);
      localTextView1.setVisibility(4);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForStructing)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.hasFlag(4))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuilder", 4, "getBubbleType:hasHead不显示头像");
      }
    }
    do
    {
      return 0;
      if ((paramChatMessage == null) || (paramChatMessage.structingMsg == null) || (!PAVideoStructMsgUtil.a(paramChatMessage.structingMsg))) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("StructingMsgItemBuilder", 4, "getBubbleType(): isPAVideoMsg, BUBBLE_TYPE_NONE");
    return 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("StructingMsgItemBuilder", 4, "getBubbleType:hasHead显示头像");
    }
    if ((paramChatMessage != null) && (paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 52)) {
      return 1;
    }
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport.a();
    int i;
    Object localObject1;
    AbsStructMsg localAbsStructMsg;
    Object localObject2;
    if (paramView == null)
    {
      i = 1;
      localObject1 = (MessageForStructing)paramChatMessage;
      localAbsStructMsg = null;
      if (localObject1 != null) {
        localAbsStructMsg = ((MessageForStructing)localObject1).structingMsg;
      }
      if (!(localObject1 instanceof MessageForTroopTopic)) {
        break label251;
      }
      localObject2 = (MessageForTroopTopic)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemBuilder getView. structMr instanceof MessageForTroopTopic");
      }
      if (!((MessageForTroopTopic)localObject2).isExpand) {
        break label900;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemBuilder getView. messageForTroopTopic.isExpand = true");
      }
      localAbsStructMsg = ((MessageForTroopTopic)localObject2).detailTopicContent;
    }
    label251:
    label285:
    label891:
    label897:
    label900:
    for (;;)
    {
      ((TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97)).a((MessageRecord)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "exp_talk", 0, 0, "" + ((MessageForTroopTopic)localObject2).frienduin, "", "", "");
      for (;;)
      {
        if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (!((StructMsgForGeneralShare)localAbsStructMsg).havaPayInfoInit))
        {
          localObject2 = paramChatMessage.getExtInfoFromExtStr("pa_pay_message");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals("1"))) {
            ((StructMsgForGeneralShare)localAbsStructMsg).initPay(this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
          }
        }
        if (localAbsStructMsg != null) {
          break label285;
        }
        return paramView;
        i = 2;
        break;
        if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
          StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (MessageForStructing)localObject1, "exp");
        }
      }
      localAbsStructMsg.message = ((MessageRecord)localObject1);
      paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
      int j;
      if (localAbsStructMsg.mMsgServiceID == 76)
      {
        paramInt2 = AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        j = AIOUtils.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramView.setPadding(0, 0, 0, 0);
        paramViewGroup = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
        paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
        ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt2, j, paramInt2, j);
      }
      paramViewGroup = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView.getTag();
      localObject2 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      boolean bool;
      if ((localAbsStructMsg instanceof AbsShareMsg))
      {
        paramInt2 = ((AbsShareMsg)localAbsStructMsg).mContentLayout;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (localAbsStructMsg.hasFlag(4))) {
          localAbsStructMsg.addFlag(1);
        }
        paramOnLongClickAndTouchListener = this.jdField_a_of_type_AndroidContentContext.getResources();
        bool = localAbsStructMsg.hasFlag(4);
        if ((!(localAbsStructMsg instanceof AbsShareMsg)) || (!((AbsShareMsg)localAbsStructMsg).mMsgException)) {
          break label897;
        }
        bool = true;
      }
      for (;;)
      {
        if (((localObject1 instanceof MessageForTroopTopic)) || (localAbsStructMsg.mMsgServiceID == 76)) {
          bool = true;
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("StructingMsgItemBuilder", 4, "getView:position:" + paramInt1 + "hasHead" + bool);
          }
          a(paramViewGroup, (BaseChatItemLayout)localObject2, bool);
          a(paramViewGroup, (BaseChatItemLayout)localObject2, ((MessageForStructing)localObject1).isSend(), localAbsStructMsg, paramOnLongClickAndTouchListener, bool);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) || ((localObject1 instanceof MessageForTroopTopic)) || (((MessageForStructing)localObject1).structingMsg.mMsgServiceID == 76))
          {
            paramInt1 = paramOnLongClickAndTouchListener.getDimensionPixelSize(2131493085);
            j = paramOnLongClickAndTouchListener.getDimensionPixelSize(2131493085);
            if ((!BaseChatItemLayout.b) || (!bool)) {
              break label891;
            }
            paramInt1 = AIOUtils.a(30.0F, paramOnLongClickAndTouchListener);
            if (((BaseChatItemLayout)localObject2).a != null)
            {
              localObject1 = (RelativeLayout.LayoutParams)((BaseChatItemLayout)localObject2).a.getLayoutParams();
              if (localObject1 != null) {
                ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(5.0F, paramOnLongClickAndTouchListener);
              }
            }
          }
          for (;;)
          {
            paramOnLongClickAndTouchListener = (RelativeLayout.LayoutParams)((RelativeLayout)((BaseChatItemLayout)paramView).a()).getLayoutParams();
            if (paramOnLongClickAndTouchListener != null) {
              paramOnLongClickAndTouchListener.setMargins(paramInt1, 0, j, 0);
            }
            paramView.requestLayout();
            if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage) && (localAbsStructMsg.hasFlag(16))) {
              ThreadManager.a(new nqb(this, paramViewGroup), 2, null, false);
            }
            paramOnLongClickAndTouchListener = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
            if (paramOnLongClickAndTouchListener.b(paramChatMessage))
            {
              paramOnLongClickAndTouchListener.a(paramChatMessage.uniseq);
              paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
              paramChatMessage = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968736);
              paramChatMessage.setAnimationListener(new nqc(this, paramViewGroup));
              paramViewGroup.jdField_a_of_type_AndroidViewView.postDelayed(new nqd(this, paramViewGroup, paramChatMessage), 300L);
            }
            this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgTimeReport.a(paramInt2, i);
            return paramView;
            paramInt2 = -1;
            break;
          }
        }
      }
    }
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Bundle localBundle = new Bundle();
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    localBundle.putBoolean("isShowCommentLayout", bool);
    if (((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))) {}
    for (Object localObject2 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();; localObject2 = null)
    {
      Object localObject1;
      int i;
      if (paramView == null)
      {
        paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getResources();
        paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setId(2131296328);
        paramView.setMinimumHeight(AIOUtils.a(44.0F, paramViewHolder));
        paramView.setClickable(true);
        paramView.setPadding(paramViewHolder.getDimensionPixelSize(2131493040), paramViewHolder.getDimensionPixelSize(2131493038), paramViewHolder.getDimensionPixelSize(2131493041), paramViewHolder.getDimensionPixelSize(2131493039));
        paramView.setBackgroundResource(2130837561);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        i = paramViewHolder.getDimensionPixelSize(2131493085);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(i, 0, i, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131296790);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (MessageForStructing.class.isInstance(paramChatMessage)) {
          break label228;
        }
      }
      label228:
      MessageForStructing localMessageForStructing;
      Object localObject3;
      do
      {
        return paramView;
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).removeAllViews();
        }
        break;
        localMessageForStructing = (MessageForStructing)paramChatMessage;
        paramViewHolder = localMessageForStructing.structingMsg;
        localObject1 = paramViewHolder;
        if (localMessageForStructing != null)
        {
          localObject1 = paramViewHolder;
          if ((localMessageForStructing instanceof MessageForTroopTopic))
          {
            localObject3 = (MessageForTroopTopic)localMessageForStructing;
            localObject1 = paramViewHolder;
            if (((MessageForTroopTopic)localObject3).isExpand)
            {
              if (QLog.isColorLevel()) {
                QLog.d(".troop.troop_topic", 2, "StructingMsgItemBuilder getBubbleView. messageForTroopTopic.isExpand = true");
              }
              localObject1 = ((MessageForTroopTopic)localObject3).detailTopicContent;
            }
          }
        }
        if (localObject1 != null) {
          break label379;
        }
      } while (!QLog.isColorLevel());
      paramViewHolder = new StringBuilder().append("structMsg is null,msgdata:");
      if (localMessageForStructing == null) {
        paramChatMessage = "null";
      }
      for (;;)
      {
        QLog.d("structMsg", 2, paramChatMessage);
        return paramView;
        if (localMessageForStructing.msgData == null) {
          paramChatMessage = "null";
        } else {
          paramChatMessage = Integer.valueOf(localMessageForStructing.msgData.length);
        }
      }
      label379:
      Object localObject4;
      Object localObject5;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
      {
        if ((localObject1 instanceof StructMsgForGeneralShare))
        {
          paramViewHolder = (StructMsgForGeneralShare)localObject1;
          localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
        localBundle.putBoolean("isPublicAccount", true);
        paramViewHolder = paramChatMessage.getExtInfoFromExtStr("msg_template_id");
        if ((paramViewHolder != null) && (!paramViewHolder.equals("")))
        {
          if (!TextUtils.isEmpty(paramViewHolder)) {
            ((AbsStructMsg)localObject1).templateIDForPortal = paramViewHolder;
          }
          if ((localObject1 instanceof AbsShareMsg))
          {
            localObject3 = ((AbsShareMsg)localObject1).getStructMsgItemLists();
            if (localObject3 != null)
            {
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
                if (!TextUtils.isEmpty(paramViewHolder)) {
                  ((AbsStructMsgElement)localObject4).l = paramViewHolder;
                }
                if ((localObject4 instanceof AbsStructMsgItem))
                {
                  localObject4 = (AbsStructMsgItem)localObject4;
                  if (((AbsStructMsgItem)localObject4).a != null)
                  {
                    localObject4 = ((AbsStructMsgItem)localObject4).a.iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (AbsStructMsgElement)((Iterator)localObject4).next();
                      if (!TextUtils.isEmpty(paramViewHolder)) {
                        ((AbsStructMsgElement)localObject5).l = paramViewHolder;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      ((AbsStructMsg)localObject1).uniseq = localMessageForStructing.uniseq;
      ((AbsStructMsg)localObject1).uin = localMessageForStructing.frienduin;
      ((AbsStructMsg)localObject1).uinType = localMessageForStructing.istroop;
      ((AbsStructMsg)localObject1).currentAccountUin = localMessageForStructing.selfuin;
      ((AbsStructMsg)localObject1).messageVersion = localMessageForStructing.versionCode;
      localBundle.putBoolean("isSend", localMessageForStructing.isSend());
      if (((AbsStructMsg)localObject1).uinType == 1008)
      {
        ((AbsStructMsg)localObject1).sourceAccoutType = AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
        label707:
        localBundle.putInt("accostType", ((AbsStructMsg)localObject1).sourceAccoutType);
        if (StructMsgForImageShare.class.isInstance(localObject1))
        {
          paramViewHolder = (StructMsgForImageShare)localObject1;
          paramViewHolder.mIsSend = localMessageForStructing.issend;
          paramViewHolder.mUniseq = localMessageForStructing.uniseq;
          paramViewHolder.mMsgType = localMessageForStructing.msgtype;
        }
        paramBaseChatItemLayout.setAddStatesFromChildren(false);
        paramViewHolder = paramBaseChatItemLayout.getTag();
        if (paramViewHolder == null) {
          break label2338;
        }
      }
      label1025:
      label1057:
      label1137:
      label1152:
      label1683:
      label1834:
      label1864:
      label1928:
      label1998:
      label2028:
      label2074:
      label2338:
      for (paramViewHolder = (StructingMsgItemBuilder.StructingMsgViewHolder)paramViewHolder;; paramViewHolder = null)
      {
        if (paramViewHolder == null) {}
        for (localObject3 = new StructingMsgItemBuilder.StructingMsgViewHolder();; localObject3 = paramViewHolder)
        {
          ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
          paramViewHolder = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout;
          localObject4 = paramViewHolder;
          if (paramViewHolder == null)
          {
            localObject4 = (RelativeLayout)paramView;
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
          }
          if ((localMessageForStructing != null) && ((localMessageForStructing instanceof MessageForTroopTopic)))
          {
            i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            paramBaseChatItemLayout.setPadding(i, 0, i, 0);
            paramViewHolder = (RelativeLayout.LayoutParams)((RelativeLayout)localObject4).getLayoutParams();
            paramViewHolder.setMargins(0, 0, 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            ((RelativeLayout)localObject4).setLayoutParams(paramViewHolder);
            ((RelativeLayout)localObject4).setPadding(0, 0, 0, 0);
          }
          paramView.setTag(localObject3);
          if ((localObject1 instanceof StructMsgForGeneralShare))
          {
            if (((AbsStructMsg)localObject1).mSType != null) {
              localBundle.putString("sType", ((AbsStructMsg)localObject1).mSType);
            }
            if (!StructLongMessageDownloadProcessor.b(paramChatMessage)) {}
          }
          try
          {
            localBundle.putInt("longMsgHolderType", Integer.parseInt(localMessageForStructing.getExtInfoFromExtStr("longMsg_State")));
            localObject5 = ((StructMsgForGeneralShare)localObject1).getLayoutStr();
            paramViewHolder = null;
            if (localObject2 != null) {
              paramViewHolder = ((StructingMsgItemBuilder.ViewCache)localObject2).a((String)localObject5, (ViewGroup)paramView);
            }
            if (paramViewHolder != null)
            {
              paramViewHolder = ((AbsStructMsg)localObject1).getView(this.jdField_a_of_type_AndroidContentContext, paramViewHolder, paramOnLongClickAndTouchListener, localBundle);
              localObject2 = paramViewHolder.findViewById(2131300560);
              if (localObject2 != null)
              {
                if (!bool) {
                  break label1683;
                }
                b((View)localObject2, paramChatMessage);
                ((View)localObject2).setVisibility(0);
              }
              paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
              paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
              if (!(localObject1 instanceof AbsShareMsg)) {
                break label1928;
              }
              paramOnLongClickAndTouchListener = (AbsShareMsg)localObject1;
              localObject2 = paramOnLongClickAndTouchListener.getOnClickListener();
              paramView.setOnClickListener(new nqg(this, paramOnLongClickAndTouchListener, localMessageForStructing, paramChatMessage.time, (View.OnClickListener)localObject2));
              if (!StructMsgForImageShare.class.isInstance(localObject1)) {
                break label1834;
              }
              FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseChatItemLayout, this);
              if (((AbsStructMsg)localObject1).mMsgServiceID != 70) {
                break label1864;
              }
              paramView.setOnClickListener(null);
              if (((AbsStructMsg)localObject1).mMsgServiceID == 76)
              {
                paramView.setOnClickListener(null);
                paramView.setOnLongClickListener(null);
                paramView.setOnTouchListener(null);
              }
              if (((AbsStructMsg)localObject1).mMsgServiceID != 81) {}
            }
            try
            {
              for (;;)
              {
                ((RelativeLayout)localObject4).addView(paramViewHolder);
                if (((AbsStructMsg)localObject1).mMsgServiceID == 38)
                {
                  paramViewHolder = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
                  if (paramViewHolder != null)
                  {
                    if (!paramViewHolder.b(paramChatMessage.time)) {
                      break label1998;
                    }
                    paramViewHolder = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
                    paramViewHolder.setId(2131296326);
                    paramViewHolder.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838321));
                    i = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                    new RelativeLayout.LayoutParams(-2, -2);
                    paramBaseChatItemLayout = new RelativeLayout.LayoutParams(i, i);
                    paramBaseChatItemLayout.addRule(13, 2131296328);
                    ((RelativeLayout)localObject4).addView(paramViewHolder, paramBaseChatItemLayout);
                    e();
                  }
                }
                if (!localMessageForStructing.isSendFromLocal()) {
                  break label2028;
                }
                paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForStructing.frienduin, localMessageForStructing.uniseq);
                ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
                a(paramViewHolder, (StructingMsgItemBuilder.StructingMsgViewHolder)localObject3);
                if (((AbsStructMsg)localObject1).adverSign != 1) {
                  break label2074;
                }
                paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                paramBaseChatItemLayout = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                paramBaseChatItemLayout.setImageResource(2130838757);
                paramViewHolder.setBackgroundColor(0);
                paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                paramOnLongClickAndTouchListener.addRule(11);
                paramOnLongClickAndTouchListener.addRule(10);
                paramViewHolder.setLayoutParams(paramOnLongClickAndTouchListener);
                paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
                paramOnLongClickAndTouchListener.addRule(11);
                paramOnLongClickAndTouchListener.addRule(10);
                paramOnLongClickAndTouchListener.setMargins(0, 12, 12, 0);
                paramBaseChatItemLayout.setLayoutParams(paramOnLongClickAndTouchListener);
                paramViewHolder.addView(paramBaseChatItemLayout);
                if ((paramView instanceof RelativeLayout)) {
                  ((RelativeLayout)paramView).addView(paramViewHolder);
                }
                paramOnLongClickAndTouchListener = localMessageForStructing.frienduin;
                l = ((AbsStructMsg)localObject1).msgId;
                if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                  paramViewHolder.setOnClickListener(new nqh(this, paramBaseChatItemLayout, paramChatMessage, paramOnLongClickAndTouchListener, l));
                }
                if ((this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) || (!this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing())) {
                  break;
                }
                this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
                return paramView;
                paramViewHolder = localMessageForStructing.getExtInfoFromExtStr("accostType");
                if ((paramViewHolder == null) || (paramViewHolder.equals(""))) {
                  break label707;
                }
                try
                {
                  ((AbsStructMsg)localObject1).sourceAccoutType = Integer.parseInt(paramViewHolder);
                }
                catch (Exception paramViewHolder) {}
                break label707;
                paramViewHolder = ((AbsStructMsg)localObject1).getView(this.jdField_a_of_type_AndroidContentContext, null, paramOnLongClickAndTouchListener, localBundle);
                if (localObject2 != null) {
                  ((StructingMsgItemBuilder.ViewCache)localObject2).a((String)localObject5, paramViewHolder, (ViewGroup)paramView);
                }
                break label1025;
                ((View)localObject2).setVisibility(8);
                break label1057;
                if (((RelativeLayout)localObject4).getChildCount() > 0)
                {
                  paramViewHolder = ((RelativeLayout)localObject4).getChildAt(0);
                  if (paramViewHolder != null)
                  {
                    paramViewHolder = paramViewHolder.getTag(2131296312);
                    if (QLog.isColorLevel()) {
                      QLog.d("structMsg", 2, "bindviwfor structmsg tag:" + paramViewHolder);
                    }
                    if ((paramViewHolder == null) || (paramViewHolder.getClass() == localObject1.getClass())) {}
                  }
                }
                ((RelativeLayout)localObject4).removeAllViews();
                paramViewHolder = ((AbsStructMsg)localObject1).getView(this.jdField_a_of_type_AndroidContentContext, null, paramOnLongClickAndTouchListener, localBundle);
                localObject2 = paramViewHolder.findViewById(2131300560);
                if (localObject2 != null)
                {
                  if (bool)
                  {
                    b((View)localObject2, paramChatMessage);
                    ((View)localObject2).setVisibility(0);
                    break label1057;
                  }
                  ((View)localObject2).setVisibility(8);
                }
                break label1057;
                if ((!StructMsgForGeneralShare.class.isInstance(localObject1)) || (!a((AbsStructMsg)localObject1))) {
                  break label1137;
                }
                a(paramBaseChatItemLayout, localMessageForStructing);
                break label1137;
                if (PAVideoStructMsgUtil.a((AbsStructMsg)localObject1))
                {
                  paramView.setOnClickListener(null);
                  break label1152;
                }
                if (((AbsStructMsg)localObject1).mMsgServiceID != 78) {
                  break label1152;
                }
                paramBaseChatItemLayout = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
                if (!(paramBaseChatItemLayout instanceof PublicAccountChatPie)) {
                  break label1152;
                }
                paramView.setOnClickListener(((PublicAccountChatPie)paramBaseChatItemLayout).a());
                break label1152;
                if (((AbsStructMsg)localObject1).mMsgServiceID == 3) {
                  if (a()) {
                    paramView.setClickable(false);
                  } else {
                    paramView.setClickable(true);
                  }
                }
              }
            }
            catch (IllegalStateException paramBaseChatItemLayout)
            {
              for (;;)
              {
                long l;
                paramBaseChatItemLayout = paramViewHolder.getParent();
                if ((paramBaseChatItemLayout != null) && ((paramBaseChatItemLayout instanceof ViewGroup))) {
                  ((ViewGroup)paramBaseChatItemLayout).removeAllViews();
                }
                ((RelativeLayout)localObject4).addView(paramViewHolder);
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                {
                  paramViewHolder = paramViewHolder.a();
                  if (paramViewHolder != null)
                  {
                    a(paramViewHolder.a);
                    continue;
                    if ((localObject1 instanceof StructMsgForImageShare))
                    {
                      paramViewHolder = ((StructMsgForImageShare)localObject1).getFirstImageElement();
                      if ((paramViewHolder != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
                      {
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
                        continue;
                        if (((AbsStructMsg)localObject1).adverSign == 2)
                        {
                          paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
                          paramBaseChatItemLayout = new TextView(this.jdField_a_of_type_AndroidContentContext);
                          paramBaseChatItemLayout.setBackgroundResource(2130838902);
                          paramBaseChatItemLayout.setGravity(17);
                          i = ((AbsStructMsg)localObject1).adverSign;
                          paramBaseChatItemLayout.setText("退订");
                          paramBaseChatItemLayout.setTextColor(-1);
                          paramBaseChatItemLayout.setTextSize(13.0F);
                          paramViewHolder.setBackgroundColor(0);
                          paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                          paramOnLongClickAndTouchListener.addRule(11);
                          paramOnLongClickAndTouchListener.addRule(10);
                          paramViewHolder.setLayoutParams(paramOnLongClickAndTouchListener);
                          paramOnLongClickAndTouchListener = new RelativeLayout.LayoutParams(-2, -2);
                          paramOnLongClickAndTouchListener.addRule(11);
                          paramOnLongClickAndTouchListener.addRule(10);
                          paramBaseChatItemLayout.setLayoutParams(paramOnLongClickAndTouchListener);
                          paramViewHolder.addView(paramBaseChatItemLayout);
                          if ((paramView instanceof RelativeLayout)) {
                            ((RelativeLayout)paramView).addView(paramViewHolder);
                          }
                          paramOnLongClickAndTouchListener = localMessageForStructing.frienduin;
                          l = ((AbsStructMsg)localObject1).msgId;
                          paramOnLongClickAndTouchListener = localMessageForStructing.getExtInfoFromExtStr("msg_template_id");
                          i = localMessageForStructing.istroop;
                          if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                            paramViewHolder.setOnClickListener(new npi(this, paramBaseChatItemLayout, paramChatMessage, paramOnLongClickAndTouchListener));
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          catch (Exception paramViewHolder)
          {
            for (;;) {}
          }
        }
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new StructingMsgItemBuilder.StructingMsgViewHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (MsgUtils.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    AbsShareMsg localAbsShareMsg;
    for (;;)
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof AbsShareMsg))) {
        break label187;
      }
      localAbsShareMsg = (AbsShareMsg)paramChatMessage;
      if (localAbsShareMsg.mMsgServiceID != 35) {
        break;
      }
      localStringBuilder.delete(0, localStringBuilder.length());
      localStringBuilder.append(paramChatMessage.mMsgBrief);
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      localStringBuilder.append("按钮");
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
    if (TextUtils.isEmpty(localAbsShareMsg.getTalkBackStr()))
    {
      if ((localAbsShareMsg.mContentTitle != null) && (localAbsShareMsg.mContentTitle.trim().length() > 0)) {
        localStringBuilder.append(localAbsShareMsg.mContentTitle);
      }
      if ((localAbsShareMsg.mContentSummary != null) && (localAbsShareMsg.mContentSummary.trim().length() > 0)) {
        localStringBuilder.append(localAbsShareMsg.mContentSummary);
      }
      localStringBuilder.append("按钮");
    }
    for (;;)
    {
      label187:
      return localStringBuilder.toString();
      localStringBuilder.append(localAbsShareMsg.getTalkBackStr());
      localStringBuilder.append("按钮");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject5 = AIOGallerySceneWithBusiness.a(paramChatMessage);
    Object localObject1;
    if (paramInt == 2131296309) {
      if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
      {
        paramContext = (MessageForStructing)paramChatMessage;
        if ((paramContext.structingMsg != null) && ((paramContext.structingMsg instanceof StructMsgForImageShare)))
        {
          paramContext = (StructMsgForImageShare)paramContext.structingMsg;
          paramChatMessage = paramContext.getFirstImageElement();
          if (paramChatMessage != null)
          {
            paramChatMessage = paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
            localObject1 = URLDrawable.getDrawable(URLDrawableHelper.a(paramChatMessage, 1), -1, -1, null, null, false);
            ((URLDrawable)localObject1).setTag(paramChatMessage);
            AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramChatMessage.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908), paramContext);
          }
        }
        if (AIOGallerySceneWithBusiness.a((String)localObject5)) {
          VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "1", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
        }
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label436:
    label757:
    label773:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt != 2131297425) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("forward", 2, "structingMsgItem forward");
              }
            } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
            localObject1 = (MessageForStructing)paramChatMessage;
          } while (((MessageForStructing)localObject1).structingMsg == null);
          if (!(((MessageForStructing)localObject1).structingMsg instanceof StructMsgForImageShare)) {
            break label773;
          }
          paramContext = (StructMsgForImageShare)((MessageForStructing)localObject1).structingMsg;
          localObject2 = paramContext.getFirstImageElement();
          if (localObject2 == null) {
            break label757;
          }
          if (((StructMsgItemImage)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
            ((StructMsgItemImage)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramContext;
          }
          paramContext = ((StructMsgItemImage)localObject2).a();
          localObject3 = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext, paramContext);
          if (!new File(paramContext.path).exists()) {
            break;
          }
          ((StructMsgItemImage)localObject2).o = paramContext.path;
          if (!TextUtils.isEmpty(((StructMsgItemImage)localObject2).o)) {
            break label436;
          }
        } while (!QLog.isColorLevel());
        QLog.d("StructingMsgItemBuilder", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
        return;
        paramChatMessage = null;
        localObject4 = ((URLDrawable)localObject3).getURL().toString();
        if (AbsDownloader.a((String)localObject4))
        {
          localObject4 = AbsDownloader.a((String)localObject4);
          paramContext = paramChatMessage;
          if (localObject4 != null)
          {
            paramContext = paramChatMessage;
            if (((File)localObject4).exists()) {
              paramContext = ((File)localObject4).getAbsolutePath();
            }
          }
        }
        for (;;)
        {
          ((StructMsgItemImage)localObject2).o = paramContext;
          break;
          localObject4 = AbsDownloader.a(URLDrawableHelper.a(paramContext, 65537).toString());
          paramContext = paramChatMessage;
          if (localObject4 != null)
          {
            paramContext = paramChatMessage;
            if (((File)localObject4).exists()) {
              paramContext = ((File)localObject4).getAbsolutePath();
            }
          }
        }
        if (!AbsDownloader.a(((URLDrawable)localObject3).getURL().toString())) {
          ((URLDrawable)localObject3).startDownload();
        }
        for (;;)
        {
          paramContext = new Bundle();
          if ((((MessageForStructing)localObject1).structingMsg.source_puin != null) && (!"".equals(((MessageForStructing)localObject1).structingMsg.source_puin))) {
            paramContext.putString("source_puin", ((MessageForStructing)localObject1).structingMsg.source_puin);
          }
          paramContext.putInt("forward_type", -3);
          ((MessageForStructing)localObject1).structingMsg.mCommentText = null;
          paramContext.putInt("structmsg_service_id", ((MessageForStructing)localObject1).structingMsg.mMsgServiceID);
          paramContext.putByteArray("stuctmsg_bytes", ((MessageForStructing)localObject1).structingMsg.getBytes());
          paramContext.putLong("structmsg_uniseq", ((MessageForStructing)localObject1).uniseq);
          paramContext.putInt("accostType", ((MessageForStructing)localObject1).structingMsg.sourceAccoutType);
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
          paramContext = ((MessageForStructing)localObject1).structingMsg.mMsgUrl;
          paramChatMessage = ((MessageForStructing)localObject1).senderuin;
          localObject1 = Long.toString(((MessageForStructing)localObject1).structingMsg.msgId);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, paramChatMessage, paramContext, (String)localObject1, "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          if (!AIOGallerySceneWithBusiness.a((String)localObject5)) {
            break;
          }
          VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "2", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StructingMsgItemBuilder", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
          return;
          if ((((MessageForStructing)localObject1).structingMsg != null) && (((MessageForStructing)localObject1).structingMsg.mMsgServiceID == 35))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
            if (!MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForStructing)localObject1).uniseq))
            {
              paramInt = paramContext.getResources().getDimensionPixelSize(2131492908);
              QQToast.a(paramContext, "含有未下载的内容，请查看后再转发", 0).b(paramInt);
              return;
            }
            if (MultiMsgManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForStructing)localObject1).uniseq)) {
              DialogUtil.a(paramContext, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", "取消", "继续", new nph(this, (MessageForStructing)localObject1), new npv(this)).show();
            }
          }
          else if ((((MessageForStructing)localObject1).structingMsg != null) && (((MessageForStructing)localObject1).structingMsg.mMsgServiceID == 81))
          {
            StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (MessageForStructing)localObject1, "forward");
          }
        }
        if (paramInt != 2131305401) {
          break;
        }
        ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (AIOGallerySceneWithBusiness.a((String)localObject5)) {
          VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "5", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
        }
      } while ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing)));
      paramContext = (MessageForStructing)paramChatMessage;
    } while ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81));
    StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "delete");
    return;
    long l2;
    long l1;
    if (paramInt == 2131305411)
    {
      super.b(paramChatMessage);
      if (AIOGallerySceneWithBusiness.a((String)localObject5)) {
        VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "6", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        paramContext = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        l2 = 0L;
        l1 = l2;
        if (paramChatMessage == null) {
          break label3009;
        }
        l1 = l2;
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break label3009;
        }
        localObject1 = (MessageForStructing)paramChatMessage;
        l1 = l2;
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label3009;
        }
        l1 = l2;
        if (!(((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg)) {
          break label3009;
        }
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        l2 = ((AbsShareMsg)localObject1).msgId;
        l1 = l2;
        if (!(localObject1 instanceof StructMsgForGeneralShare)) {
          break label3009;
        }
        localObject1 = (StructMsgForGeneralShare)localObject1;
        paramInt = StructMsgForGeneralShare.clickedItemIndex;
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F7", "0X80064F7", 0, 0, paramContext, String.valueOf(l2), String.valueOf(paramInt), "");
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
        break;
      }
      paramContext = (MessageForStructing)paramChatMessage;
      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
        break;
      }
      StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "more");
      return;
      AbsShareMsg localAbsShareMsg;
      if (paramInt == 2131299841)
      {
        if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
          break;
        }
        paramContext = (MessageForStructing)paramChatMessage;
        if (paramContext.structingMsg == null) {
          break;
        }
        localAbsShareMsg = (AbsShareMsg)paramContext.structingMsg;
        if ((localAbsShareMsg instanceof StructMsgForImageShare))
        {
          paramInt = 0;
          if (AIOGallerySceneWithBusiness.a((String)localObject5))
          {
            localObject1 = localAbsShareMsg.mMsgActionData.substring(localAbsShareMsg.mMsgActionData.indexOf("|") + 1).split("\\|");
            if ((localObject1.length < 8) || ((!localObject1[7].equals("link")) && (!localObject1[7].equals("scrawl_link")))) {
              break label3002;
            }
            paramInt = 1;
            if ((!localObject1[7].equals("scrawl_link")) || (localObject1.length <= 8)) {
              break label2997;
            }
            paramContext = localObject1[8];
          }
        }
      }
      for (;;)
      {
        if ((paramInt == 0) && (!TextUtils.isEmpty(localAbsShareMsg.mMsg_A_ActionData)))
        {
          localObject1 = localAbsShareMsg.mMsg_A_ActionData.split("\\|");
          if ((localObject1.length >= 8) && (localObject1[7].equals("link"))) {
            paramInt = 1;
          }
        }
        for (;;)
        {
          label1583:
          if (paramInt != 0)
          {
            localObject2 = ((StructMsgForImageShare)localAbsShareMsg).getFirstImageElement();
            if (localObject2 == null) {
              break label2988;
            }
            if (((StructMsgItemImage)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
              ((StructMsgItemImage)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)localAbsShareMsg);
            }
            localObject4 = AIOGalleryUtils.a(((StructMsgItemImage)localObject2).a());
            localObject3 = ((AIOImageData)localObject4).a(4);
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = ((AIOImageData)localObject4).a(2);
            }
            if (localObject2 == null) {
              break label2988;
            }
          }
          label2247:
          label2494:
          label2594:
          label2974:
          label2988:
          for (localObject2 = ((File)localObject2).getAbsolutePath();; localObject2 = null)
          {
            Object localObject6 = localObject1[3] + "第" + localObject1[5] + "页";
            localObject4 = "http://imgcache.qq.com/club/client/comic/release/html/read_share.html?_bid=354&ADTAG=comic.plugin.read&_wv=5123&id=" + localObject1[0] + "&name=" + URLEncoder.encode(localObject1[1]) + "&sectionID=" + localObject1[2] + "&sectionName=" + URLEncoder.encode(localObject1[3]) + "&pageID=" + localObject1[4] + "&page=" + localObject1[5] + "&type=" + localObject1[6];
            localObject3 = localObject4;
            if (!TextUtils.isEmpty(paramContext)) {
              localObject3 = (String)localObject4 + "&scrawl_link=" + URLEncoder.encode(paramContext);
            }
            new QfavBuilder(6).a("nLinkType", 0).b("sTitle", localObject1[1]).b("sUrl", (String)localObject3).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localAbsShareMsg.mSourceName).b("sBrief", (String)localObject6).b("sPath", (String)localObject2).b("sResUrl", localAbsShareMsg.mSourceUrl).a("lCategory", 1L).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 2);
            VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "3", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
            if (paramInt != 0) {
              break;
            }
            paramContext = QfavUtil.a((StructMsgForImageShare)localAbsShareMsg);
            if (paramContext == null) {
              break;
            }
            QfavBuilder.a(paramContext.q, localAbsShareMsg.uinType, paramContext.p, paramContext.c, paramContext.o, paramContext.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
            return;
            paramInt = 0;
            break label1583;
            int i;
            if (!TextUtils.isEmpty(localAbsShareMsg.mMsgActionData))
            {
              String[] arrayOfString1 = localAbsShareMsg.mMsgActionData.split("&");
              i = arrayOfString1.length;
              localObject3 = null;
              localObject2 = null;
              localObject1 = null;
              paramContext = null;
              paramInt = 0;
              if (paramInt < i)
              {
                String[] arrayOfString2 = arrayOfString1[paramInt].split("=");
                localObject4 = localObject3;
                localObject5 = localObject2;
                localObject6 = localObject1;
                Object localObject7 = paramContext;
                if (arrayOfString2.length > 1)
                {
                  if (!arrayOfString2[0].trim().equals("lat")) {
                    break label2247;
                  }
                  localObject7 = arrayOfString2[1];
                  localObject6 = localObject1;
                  localObject5 = localObject2;
                  localObject4 = localObject3;
                }
                for (;;)
                {
                  paramInt += 1;
                  localObject3 = localObject4;
                  localObject2 = localObject5;
                  localObject1 = localObject6;
                  paramContext = (Context)localObject7;
                  break;
                  if (arrayOfString2[0].trim().equals("lon"))
                  {
                    localObject6 = arrayOfString2[1];
                    localObject4 = localObject3;
                    localObject5 = localObject2;
                    localObject7 = paramContext;
                  }
                  else if (arrayOfString2[0].trim().equals("loc"))
                  {
                    localObject5 = arrayOfString2[1];
                    localObject4 = localObject3;
                    localObject6 = localObject1;
                    localObject7 = paramContext;
                  }
                  else
                  {
                    localObject4 = localObject3;
                    localObject5 = localObject2;
                    localObject6 = localObject1;
                    localObject7 = paramContext;
                    if (arrayOfString2[0].trim().equals("title"))
                    {
                      localObject4 = arrayOfString2[1];
                      localObject5 = localObject2;
                      localObject6 = localObject1;
                      localObject7 = paramContext;
                    }
                  }
                }
              }
              if ((localAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
              {
                QfavBuilder.a(Float.valueOf(paramContext).floatValue(), Float.valueOf((String)localObject1).floatValue(), (String)localObject3, (String)localObject2, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
                return;
              }
            }
            localObject2 = QfavUtil.a(localAbsShareMsg.getXmlBytes());
            paramContext = localAbsShareMsg.mContentCover;
            if ((localAbsShareMsg instanceof StructMsgForAudioShare))
            {
              i = 10;
              paramInt = 2;
            }
            for (;;)
            {
              QfavBuilder.a(paramInt, localAbsShareMsg.mContentTitle, localAbsShareMsg.mMsgUrl, localAbsShareMsg.mSourceName, localAbsShareMsg.mContentSummary, paramContext, localAbsShareMsg.mContentSrc, (byte[])localObject2, false, 0L).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
              return;
              if (((localAbsShareMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg))
              {
                localObject3 = (StructMsgForGeneralShare)localAbsShareMsg;
                paramInt = 0;
                if (paramInt < ((StructMsgForGeneralShare)localObject3).getItemCount())
                {
                  localObject1 = ((StructMsgForGeneralShare)localObject3).getItemByIndex(paramInt);
                  if ((localObject1 instanceof StructMsgItemLayout5))
                  {
                    localObject4 = ((StructMsgItemLayout5)localObject1).a.iterator();
                    do
                    {
                      localObject1 = paramContext;
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      localObject1 = (AbsStructMsgElement)((Iterator)localObject4).next();
                    } while (!(localObject1 instanceof StructMsgItemVideo));
                    localObject4 = (StructMsgItemVideo)localObject1;
                    paramContext = ((StructMsgItemVideo)localObject4).s;
                    localObject1 = paramContext;
                    if (!((StructMsgItemVideo)localObject4).a()) {
                      break label2974;
                    }
                    VideoReporter.a("0X8006601", ((StructMsgForGeneralShare)localAbsShareMsg).uinType, VideoReporter.a(((StructMsgItemVideo)localObject4).n, ((StructMsgForGeneralShare)localObject3).mSourceName), ((StructMsgItemVideo)localObject4).cY, "");
                  }
                  for (;;)
                  {
                    i = 2;
                    paramInt = 0;
                    break label2494;
                    paramInt += 1;
                    break label2594;
                    if (paramInt == 2131305407)
                    {
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext == null) || (paramContext.structingMsg == null) || (!"web".equals(paramContext.structingMsg.mMsgAction)) || (paramContext.structingMsg.mMsgUrl == null)) {
                        break;
                      }
                      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext.structingMsg.mMsgUrl);
                      return;
                    }
                    if (paramInt == 2131305410)
                    {
                      b(paramChatMessage);
                      return;
                    }
                    if (paramInt == 2131305412)
                    {
                      ThreadManager.a(new nqa(this, paramChatMessage, paramContext), 8, null, false);
                      return;
                    }
                    if (paramInt == 2131296353)
                    {
                      super.a(paramChatMessage);
                      if (AIOGallerySceneWithBusiness.a((String)localObject5)) {
                        VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3009", "2", "40053", AIOGallerySceneWithBusiness.b((String)localObject5), new String[] { "4", "", AIOGallerySceneWithBusiness.a((String)localObject5) });
                      }
                      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
                        break;
                      }
                      paramContext = (MessageForStructing)paramChatMessage;
                      if ((paramContext.structingMsg == null) || (paramContext.structingMsg.mMsgServiceID != 81)) {
                        break;
                      }
                      StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramContext, "withdraw");
                      return;
                    }
                    super.a(paramInt, paramContext, paramChatMessage);
                    return;
                    paramContext = (Context)localObject1;
                  }
                }
              }
              i = 2;
              paramInt = 0;
            }
          }
        }
        label2997:
        paramContext = null;
        continue;
        label3002:
        paramContext = null;
        paramInt = 0;
      }
      label3009:
      paramInt = 0;
      l2 = l1;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    Object localObject1;
    Context localContext;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = AIOUtils.a(paramView);
      } while (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject1));
      localContext = this.jdField_a_of_type_AndroidContentContext;
      localObject1 = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject2 = a((ChatMessage)localObject1);
      if (localObject2 != null)
      {
        a(paramView, (StructMsgForGeneralShare)localObject2);
        return;
      }
      paramView = localContext.getString(2131367889);
      localObject2 = localContext.getString(2131367890);
    } while (!((ChatMessage)localObject1).isSendFromLocal());
    DialogUtil.a(localContext, 230, paramView, (String)localObject2, new npx(this, (ChatMessage)localObject1, localContext), new npy(this)).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    super.a(paramView, paramChatMessage);
    int i;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
      if ((PAVideoStructMsgUtil.a(localMessageForStructing.structingMsg)) && (!localMessageForStructing.structingMsg.hasFlag(4)))
      {
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493059);
        if (!paramChatMessage.isSend()) {
          break label77;
        }
        paramView.setPadding(BaseChatItemLayout.n, BaseChatItemLayout.k, i, BaseChatItemLayout.l);
      }
    }
    return;
    label77:
    paramView.setPadding(i, BaseChatItemLayout.k, BaseChatItemLayout.n, BaseChatItemLayout.l);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (!BaseChatItemLayout.class.isInstance(paramView)) {}
    label10:
    ChatMessage localChatMessage;
    do
    {
      do
      {
        do
        {
          break label10;
          do
          {
            return;
          } while ((paramFileMsg.e != 1) && (paramFileMsg.e != 131075));
          paramView = AIOUtils.a(paramView);
        } while (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView));
        paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView;
      } while ((!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(paramView)) || (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
      localChatMessage = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localChatMessage.uniseq == paramFileMsg.c) && (localChatMessage.isSendFromLocal()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("structMsg", 2, "handleMessage status = " + paramInt1 + ", retCode = " + paramInt2 + ", message.uniseq = " + localChatMessage.uniseq + ", file.uniseq = " + paramFileMsg.c);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localChatMessage.frienduin, localChatMessage.uniseq), paramView);
        if (paramInt1 == 1005) {
          a();
        }
      }
    } while ((localChatMessage.uniseq != paramFileMsg.c) || (paramInt1 != 2003) || (!(((MessageForStructing)localChatMessage).structingMsg instanceof StructMsgForImageShare)));
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    paramFileMsg = new Bundle();
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((MessageForStructing)localChatMessage).structingMsg.getView(this.jdField_a_of_type_AndroidContentContext, null, null, paramFileMsg));
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = AIOUtils.a(paramView);
    if ((paramXListView instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {}
    for (paramXListView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof StructMsgItemLayout10.ViewHolder))
          {
            paramView = (StructMsgItemLayout10.ViewHolder)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof StructMsgItemPAAudio.ViewHolder))
            {
              paramView = (ImageView)((StructMsgItemPAAudio.ViewHolder)paramView.jdField_a_of_type_AndroidViewView.getTag()).c;
              paramView.clearAnimation();
              paramView.setBackgroundResource(2130838942);
            }
          }
          paramInt += 1;
        }
      }
      return;
    }
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, long paramLong, String paramString13)
  {
    String str1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
    String str2 = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramString1 + "&version=1";
    paramString1 = new Intent();
    paramString1.setClass(paramContext, ForwardRecentActivity.class);
    paramString1.putExtra("key_flag_from_plugin", true);
    paramString1.putExtra("strurt_msgid", String.valueOf(paramLong));
    paramString1.putExtra("struct_uin", paramString13);
    paramString1.putExtra("forward_type", 1001);
    paramString1.putExtra("image_url_remote", paramString4);
    paramString1.putExtra("title", paramString2);
    paramString1.putExtra("desc", paramString3);
    paramString1.putExtra("pluginName", "public_account");
    paramString1.putExtra("detail_url", paramString6);
    paramString1.putExtra("app_name", paramString5);
    if (("replyMsg".equals(paramString8)) || ("replyCmd".equals(paramString8))) {}
    for (;;)
    {
      paramString1.putExtra("req_type", 1);
      paramString1.putExtra("req_share_id", -1);
      paramString1.putExtra("brief_key", paramString12);
      paramString1.putExtra("struct_share_key_source_icon", paramString7);
      paramString1.putExtra("struct_share_key_source_action", "plugin");
      paramString1.putExtra("struct_share_key_source_action_data", str1);
      paramString1.putExtra("struct_share_key_source_a_action_data", str1);
      paramString1.putExtra("struct_share_key_source_i_action_data", str2);
      paramString1.putExtra("forward _key_nojump", true);
      paramString2 = StructMsgFactory.a(paramString1.getExtras());
      if (paramString2 == null) {
        break;
      }
      paramString1.putExtra("stuctmsg_bytes", paramString2.getBytes());
      paramString1.putExtra("k_struct_forward", true);
      paramContext.startActivity(paramString1);
      return true;
      paramString1.putExtra("struct_share_key_content_action", paramString8);
      paramString1.putExtra("struct_share_key_content_action_DATA", paramString9);
      paramString1.putExtra("struct_share_key_content_a_action_DATA", paramString10);
      paramString1.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    }
    return false;
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {
      return false;
    }
    Object localObject = (MessageForStructing)paramChatMessage;
    if ((((MessageForStructing)localObject).structingMsg != null) && (StructMsgForImageShare.class.isInstance(((MessageForStructing)localObject).structingMsg)) && (paramChatMessage.isSendFromLocal()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (StructMsgForImageShare)((MessageForStructing)localObject).structingMsg;
        if (localObject != null)
        {
          localObject = ((StructMsgForImageShare)localObject).getFirstImageElement();
          if ((localObject != null) && (((StructMsgItemImage)localObject).d <= 0L))
          {
            paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
            if ((paramChatMessage instanceof BaseTransProcessor))
            {
              if (((BaseTransProcessor)paramChatMessage).c() == 1005L) {}
              for (boolean bool = true;; bool = false) {
                return bool;
              }
            }
            return true;
          }
        }
      }
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = AIOUtils.a(paramView);
    if ((paramXListView instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {}
    for (paramXListView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramXListView;; paramXListView = null)
    {
      if (paramXListView != null)
      {
        paramXListView = (ViewGroup)paramXListView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int i = paramXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          if ((paramXListView.getChildAt(paramInt).getTag() instanceof StructMsgItemLayout10.ViewHolder))
          {
            paramView = (StructMsgItemLayout10.ViewHolder)paramXListView.getChildAt(paramInt).getTag();
            if ((paramView.jdField_a_of_type_AndroidViewView.getTag() instanceof StructMsgItemPAAudio.ViewHolder)) {
              return FileUtils.b(((StructMsgItemPAAudio.ViewHolder)paramView.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          paramInt += 1;
        }
      }
      return false;
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    Object localObject = AIOUtils.a(paramView);
    if ((localObject instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) {}
    for (localObject = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = (ViewGroup)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        int j = ((ViewGroup)localObject).getChildCount();
        int i = 0;
        while (i < j)
        {
          if (((((ViewGroup)localObject).getChildAt(i).getTag() instanceof StructMsgItemLayout10.ViewHolder)) && (a(paramXListView, paramInt, paramView, paramChatMessage)))
          {
            StructMsgItemLayout10.ViewHolder localViewHolder = (StructMsgItemLayout10.ViewHolder)((ViewGroup)localObject).getChildAt(i).getTag();
            if ((localViewHolder.jdField_a_of_type_AndroidViewView.getTag() instanceof StructMsgItemPAAudio.ViewHolder)) {
              paramAudioPlayer.a(((StructMsgItemPAAudio.ViewHolder)localViewHolder.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_JavaLangString);
            }
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
    if (localAbsStructMsg != null)
    {
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)localAbsStructMsg).mMsgException))
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        }
        return localQQCustomMenu.a();
      }
      if (localAbsStructMsg.mMsgServiceID == 61)
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return localQQCustomMenu.a();
      }
      if (localAbsStructMsg.mMsgServiceID == 70)
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        return localQQCustomMenu.a();
      }
      if ((localAbsStructMsg instanceof StructMsgForHypertext))
      {
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        return localQQCustomMenu.a();
      }
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        paramView = ((StructMsgForImageShare)localAbsStructMsg).getFirstImageElement();
        if (paramView == null) {
          break label941;
        }
      }
    }
    label279:
    label285:
    label904:
    label941:
    for (paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;; paramView = null)
    {
      int i;
      if ((paramView != null) && (URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext, paramView, 65537)))
      {
        i = 1;
        if ((paramView == null) || (paramView.imageType != 2000)) {
          break label279;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          break label285;
        }
        return localQQCustomMenu.a();
        i = 0;
        break;
      }
      localQQCustomMenu.a(2131296309, this.jdField_a_of_type_AndroidContentContext.getString(2131370095));
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localAbsStructMsg.fwFlag != 1)
      {
        if (localAbsStructMsg.hasFlag(8)) {
          localQQCustomMenu.a(2131305407, paramView.getString(2131371168));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
          if (!localAbsStructMsg.hasFlag(32))
          {
            localQQCustomMenu.a(2131305412, paramView.getString(2131369281));
            if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing)) {
              a(localMessageForStructing, localQQCustomMenu);
            }
            if ((!localAbsStructMsg.hasFlag(2)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (!TextUtils.isEmpty(localAbsStructMsg.mMsgUrl))) && (localAbsStructMsg.mMsgServiceID != 81)) {
              break label904;
            }
          }
        }
      }
      for (;;)
      {
        if ((localMessageForStructing.isSend()) && (localMessageForStructing.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForStructing)))
        {
          j = 1;
          i = j;
          if (localMessageForStructing.istroop == 1)
          {
            i = j;
            if (localAbsStructMsg != null) {
              if ((localAbsStructMsg.mMsgServiceID != 23) && (localAbsStructMsg.mMsgServiceID != 19) && (localAbsStructMsg.mMsgServiceID != 60) && (!"群问问".equals(localAbsStructMsg.getSourceName())))
              {
                i = j;
                if (localAbsStructMsg.mMsgUrl != null)
                {
                  i = j;
                  if (!localAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity")) {}
                }
              }
              else
              {
                i = 0;
              }
            }
          }
          if (((1008 != localMessageForStructing.istroop) || (!AppConstants.ae.equals(localMessageForStructing.frienduin))) && ((localAbsStructMsg.mMsgUrl == null) || (!localAbsStructMsg.mMsgUrl.startsWith("http://ti.qq.com/remind/view.html"))))
          {
            j = i;
            if (localAbsStructMsg.mMsgUrl != null)
            {
              j = i;
              if (!localAbsStructMsg.mMsgUrl.startsWith("https://mqq.tenpay.com")) {}
            }
          }
          else
          {
            j = 0;
          }
          i = j;
          if (localAbsStructMsg != null)
          {
            i = j;
            if (localAbsStructMsg.mMsgServiceID == 49) {
              i = 0;
            }
          }
          if (i != 0) {
            a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForStructing);
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) || (localQQCustomMenu.a() == 0)) {
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID != 49)) {
          super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
        }
        if ((localAbsStructMsg != null) && (localAbsStructMsg.mMsgServiceID == 81)) {
          StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForStructing, "press");
        }
        return localQQCustomMenu.a();
        if (localAbsStructMsg.hasFlag(1)) {
          break;
        }
        localQQCustomMenu.a(2131297425, paramView.getString(2131369281));
        break;
        if (!localAbsStructMsg.hasFlag(1))
        {
          localQQCustomMenu.a(2131297425, paramView.getString(2131369281));
          break;
        }
        if (localAbsStructMsg.mMsgServiceID != 35) {
          break;
        }
        localQQCustomMenu.a(2131297425, paramView.getString(2131369281));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
        break;
        localQQCustomMenu.a(2131299841, paramView.getString(2131365886));
        continue;
        if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForStructing)) {
          a(localMessageForStructing, localQQCustomMenu);
        }
      }
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    AbsStructMsg localAbsStructMsg = ((MessageForStructing)paramChatMessage).structingMsg;
    if ((localAbsStructMsg != null) && (StructMsgForImageShare.class.isInstance(localAbsStructMsg)))
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage != null) && (BaseTransProcessor.class.isInstance(paramChatMessage)))
      {
        a(paramBaseChatItemLayout, ((BaseTransProcessor)paramChatMessage).a(), 0, 0);
        return;
      }
      paramBaseChatItemLayout.setProgressVisable(false);
      return;
    }
    super.c(paramChatMessage, paramBaseChatItemLayout);
  }
  
  protected void e()
  {
    long l1 = 1L;
    VipGiftManager localVipGiftManager = (VipGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
    VipGiftDownloadInfo localVipGiftDownloadInfo = localVipGiftManager.a();
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.d == 0L) && (localVipGiftDownloadInfo.a != 0L)) {
      localVipGiftManager.a(localVipGiftDownloadInfo.a);
    }
    long l2;
    if ((localVipGiftDownloadInfo != null) && (localVipGiftDownloadInfo.d == 1L))
    {
      l2 = localVipGiftManager.h - (NetConnInfoCenter.getServerTimeMillis() - localVipGiftDownloadInfo.e);
      if (l2 > 0L) {
        break label115;
      }
    }
    for (;;)
    {
      new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper()).postDelayed(new nqe(this, localVipGiftDownloadInfo, localVipGiftManager), l1);
      return;
      label115:
      l1 = l2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\StructingMsgItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */