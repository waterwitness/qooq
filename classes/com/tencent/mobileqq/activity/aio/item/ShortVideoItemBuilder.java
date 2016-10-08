package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.prediction.PredictionReporter;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ProgressPieView;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;
import noq;
import nor;
import nos;
import not;
import nou;

public class ShortVideoItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, ShortVideoConstants
{
  public static AtomicLong a;
  static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "ShortVideoItemBuilder";
  static long c = 0L;
  public static final int h = 10;
  long jdField_a_of_type_Long;
  private Runnable jdField_a_of_type_JavaLangRunnable = new not(this);
  boolean d;
  boolean e = false;
  public int i = 0;
  int j = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    URLDrawableHelper.b();
    c = 1000L;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public ShortVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    return new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramViewGroup != null) {
      paramViewGroup.a(paramView, this);
    }
    if (jdField_b_of_type_Boolean) {}
    try
    {
      paramViewGroup = (ShortVideoItemBuilder.Holder)paramView.getTag();
      paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
      paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (ShortVideoItemBuilder.Holder)paramViewHolder;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramBaseChatItemLayout = (MessageForShortVideo)paramChatMessage;
    boolean bool = paramBaseChatItemLayout.isSend();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131299762);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      paramChatMessage.addView(paramView);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      localProgressBar.setIndeterminate(true);
      localProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842960));
      k = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = new RelativeLayout.LayoutParams(k, k);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramChatMessage.addView(localProgressBar, (ViewGroup.LayoutParams)localObject2);
      Object localObject4 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject4).setOrientation(1);
      ((LinearLayout)localObject4).setGravity(17);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramChatMessage.addView((View)localObject4, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new ProgressPieView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject3 = new LinearLayout.LayoutParams(k, k);
      ((ProgressPieView)localObject2).setProgressColor(-15550475);
      ((ProgressPieView)localObject2).setProgressStrokeWidth(3);
      ((ProgressPieView)localObject2).setStrokeColor(-1);
      ((ProgressPieView)localObject2).setId(2131296350);
      ((ProgressPieView)localObject2).setShowImage(true);
      ((ProgressPieView)localObject2).setOnClickListener(this);
      ((ProgressPieView)localObject2).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((ProgressPieView)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
      ((ProgressPieView)localObject2).setTextColor(-1);
      ((ProgressPieView)localObject2).setBackgroundColor(0);
      ((ProgressPieView)localObject2).setDrawImageFillView(true);
      ((ProgressPieView)localObject2).setShowStroke(false);
      ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject5 = new LinearLayout.LayoutParams(-2, -2);
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(2, 12.0F);
      ((TextView)localObject3).setId(2131296351);
      ((TextView)localObject3).setVisibility(4);
      ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject5);
      localObject4 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject4).setBackgroundResource(2130838139);
      localObject5 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(55.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject5).addRule(5, 2131299762);
      ((RelativeLayout.LayoutParams)localObject5).addRule(7, 2131299762);
      ((RelativeLayout.LayoutParams)localObject5).addRule(8, 2131299762);
      paramChatMessage.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 12.0F);
      ((TextView)localObject5).setTextColor(-1);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = AIOUtils.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = AIOUtils.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).addRule(9);
      ((RelativeLayout.LayoutParams)localObject6).addRule(12);
      ((RelativeLayout)localObject4).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      localObject6 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject6).setTextSize(1, 12.0F);
      ((TextView)localObject6).setTextColor(-1);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = AIOUtils.a(7.0F, (Resources)localObject1);
      localLayoutParams.bottomMargin = AIOUtils.a(7.0F, (Resources)localObject1);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(12);
      ((RelativeLayout)localObject4).addView((View)localObject6, localLayoutParams);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramView;
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject5);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject6);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetProgressPieView = ((ProgressPieView)localObject2);
      paramViewHolder.c = ((TextView)localObject3);
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.jdField_b_of_type_Boolean != bool)
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.jdField_b_of_type_Boolean = bool;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    PredictionReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout);
    paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int m;
    if (bool)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = AIOUtils.a(10.0F, (Resources)localObject1);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramBaseChatItemLayout.videoFileTime * 1000));
      paramOnLongClickAndTouchListener = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
      paramView = paramViewHolder.jdField_a_of_type_ComTencentWidgetProgressPieView;
      localObject1 = ShortVideoUtils.a(paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
      k = localObject1[0];
      m = localObject1[1];
      localObject1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject1 != null) {
        break label1042;
      }
      localObject1 = new RelativeLayout.LayoutParams(k, m);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      label873:
      if (ShortVideoBusiManager.jdField_a_of_type_Boolean)
      {
        ShortVideoBusiManager.jdField_a_of_type_Long = System.currentTimeMillis();
        ShortVideoBusiManager.jdField_a_of_type_Boolean = false;
      }
      localObject1 = a(k, m);
      a(paramViewHolder);
      if (paramBaseChatItemLayout.md5 != null) {
        break label1150;
      }
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        if (FileUtils.b(paramOnLongClickAndTouchListener))
        {
          paramOnLongClickAndTouchListener = ShortVideoUtils.a(paramOnLongClickAndTouchListener);
          if ((paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramOnLongClickAndTouchListener)))
          {
            paramOnLongClickAndTouchListener = URLDrawable.getDrawable(paramOnLongClickAndTouchListener, k, m, (Drawable)localObject1, (Drawable)localObject1);
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramOnLongClickAndTouchListener);
            paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramOnLongClickAndTouchListener;
          }
          if (paramBaseChatItemLayout.videoFileStatus != 1005) {
            break label1088;
          }
          paramView.setImageResource(2130842959);
          a(paramViewHolder, false);
        }
      }
    }
    label1020:
    label1042:
    label1088:
    label1150:
    label1640:
    label1879:
    do
    {
      do
      {
        do
        {
          return paramChatMessage;
          paramView.leftMargin = AIOUtils.a(10.0F, (Resources)localObject1);
          paramView.rightMargin = 0;
          break;
          if ((((ViewGroup.LayoutParams)localObject1).width == k) && (((ViewGroup.LayoutParams)localObject1).height == m)) {
            break label873;
          }
          ((ViewGroup.LayoutParams)localObject1).width = k;
          ((ViewGroup.LayoutParams)localObject1).height = m;
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break label873;
          a(paramViewHolder, true);
        } while (paramBaseChatItemLayout.videoFileStatus == 998);
        Utils.executeAsyncTaskOnSerialExcuter(new nou(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBaseChatItemLayout), new Void[0]);
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task..");
      return paramChatMessage;
      a(paramViewHolder, false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.videoFileSize));
      if (FileUtils.b(paramOnLongClickAndTouchListener))
      {
        paramOnLongClickAndTouchListener = ShortVideoUtils.a(paramOnLongClickAndTouchListener);
        if ((paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramOnLongClickAndTouchListener)))
        {
          paramOnLongClickAndTouchListener = URLDrawable.getDrawable(paramOnLongClickAndTouchListener, k, m, (Drawable)localObject1, (Drawable)localObject1);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramOnLongClickAndTouchListener);
          paramViewHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramOnLongClickAndTouchListener;
        }
      }
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView ，video no exits: sendFromLocal=" + paramBaseChatItemLayout.isSendFromLocal() + "===>  fileType:" + ShortVideoUtils.a(paramBaseChatItemLayout.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.b(paramBaseChatItemLayout.videoFileStatus) + "===> videoFileProgress:" + paramBaseChatItemLayout.videoFileProgress + ", uniseq:" + paramBaseChatItemLayout.uniseq);
          }
          paramOnLongClickAndTouchListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq);
          if ((paramBaseChatItemLayout.fileType != 6) && (paramBaseChatItemLayout.fileType != 17) && (paramBaseChatItemLayout.fileType != 9) && (paramBaseChatItemLayout.fileType != 19) && (paramBaseChatItemLayout.fileType != 20)) {
            break;
          }
          switch (paramBaseChatItemLayout.videoFileStatus)
          {
          default: 
            return paramChatMessage;
          case 1001: 
            if (paramOnLongClickAndTouchListener != null) {
              break label1879;
            }
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            a(paramViewHolder);
            if (!QLog.isColorLevel()) {
              break label1020;
            }
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
            return paramChatMessage;
            if (((paramBaseChatItemLayout.fileType != 7) && (paramBaseChatItemLayout.fileType != 18) && (paramBaseChatItemLayout.fileType != 16)) || (paramBaseChatItemLayout.videoFileStatus != 5002)) {
              break label1640;
            }
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject1);
            a(paramViewHolder, 2131367235);
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramBaseChatItemLayout.uniseq);
            }
            break;
          }
        }
      } while (paramBaseChatItemLayout.extraflag == 32768);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramBaseChatItemLayout.uniseq);
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject1);
      paramOnLongClickAndTouchListener = ShortVideoBusiManager.a(2, this.i);
      localObject1 = paramBaseChatItemLayout.getDownloadInfo(paramOnLongClickAndTouchListener.g);
      ((ShortVideoDownloadInfo)localObject1).i = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
      if ((paramBaseChatItemLayout.istroop == 0) || (paramBaseChatItemLayout.istroop == 1008)) {
        ((ShortVideoDownloadInfo)localObject1).g = 1002;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideoThumb downloadVideo fileType=" + ((ShortVideoDownloadInfo)localObject1).g + ", uniseq:" + paramBaseChatItemLayout.uniseq);
        }
        paramOnLongClickAndTouchListener.a((ShortVideoDownloadInfo)localObject1);
        paramOnLongClickAndTouchListener.a(paramBaseChatItemLayout);
        ShortVideoBusiManager.a(paramOnLongClickAndTouchListener, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
        if (paramBaseChatItemLayout.istroop == 3000) {
          ((ShortVideoDownloadInfo)localObject1).g = 1006;
        } else if (paramBaseChatItemLayout.istroop == 1) {
          ((ShortVideoDownloadInfo)localObject1).g = 1004;
        }
      }
      a(paramViewHolder, ShortVideoUtils.a(paramBaseChatItemLayout.videoFileProgress, 10), false);
      return paramChatMessage;
      a(paramViewHolder);
      paramView.setImageResource(2130842962);
      return paramChatMessage;
      if (paramOnLongClickAndTouchListener != null) {
        break label1968;
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      a(paramViewHolder);
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
    return paramChatMessage;
    label1968:
    int k = paramBaseChatItemLayout.videoFileProgress;
    if ((paramOnLongClickAndTouchListener instanceof ShortVideoUploadProcessor))
    {
      paramView = (ShortVideoUploadProcessor)paramOnLongClickAndTouchListener;
      if (paramView.a() != 0L) {
        k = (int)(100L * paramView.b() / paramView.a());
      }
    }
    for (;;)
    {
      a(paramViewHolder, ShortVideoUtils.a(k, 10), false);
      return paramChatMessage;
      a(paramViewHolder);
      return paramChatMessage;
      a(paramViewHolder);
      return paramChatMessage;
      a(paramViewHolder);
      return paramChatMessage;
      a(paramViewHolder, 2131367235);
      return paramChatMessage;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出视频";
    }
    return "发来视频";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      this.j = paramInt;
      if (paramInt != 2131305401) {
        break label42;
      }
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    for (;;)
    {
      return;
      label42:
      if (paramInt == 2131305411)
      {
        super.b(paramChatMessage);
        return;
      }
      if (paramInt == 2131297425)
      {
        c(localMessageForShortVideo);
        return;
      }
      if (paramInt == 2131296353)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + localMessageForShortVideo.toLogString());
        }
        if (localMessageForShortVideo.md5 == null)
        {
          ShortVideoTrimmer.a.set(false);
          paramContext = ShortVideoTrimmer.a();
          if (paramContext != null) {
            paramContext.destroy();
          }
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(localMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
          return;
        }
        paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
        if ((paramContext == null) || ((!ShortVideoUploadProcessor.class.isInstance(paramContext)) && (!ShortVideoForwardProcessor.class.isInstance(paramContext)))) {
          break label409;
        }
        boolean bool = ((BaseTransProcessor)paramContext).c();
        paramInt = localMessageForShortVideo.videoFileStatus;
        if ((!bool) && (paramInt != 1002) && (paramInt != 1001)) {
          break label409;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
        ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
        }
      }
      label409:
      for (paramInt = 0; paramInt != 0; paramInt = 1)
      {
        super.a(localMessageForShortVideo);
        return;
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.a(2131367889, 5);
      localActionSheet.d(2131367262);
      localActionSheet.a(new nos(this, localMessageForShortVideo, paramView, localActionSheet));
      localActionSheet.show();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493058);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.n, BaseChatItemLayout.k, k, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(k, BaseChatItemLayout.k, BaseChatItemLayout.n, BaseChatItemLayout.l);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject1 = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = paramView.jdField_a_of_type_ComTencentWidgetProgressPieView;
    if (((MessageForShortVideo)localObject1).uniseq != paramFileMsg.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + ((MessageForShortVideo)localObject1).uniseq + ",fileType:" + ShortVideoUtils.a(paramFileMsg.e) + " ===> fileStatus:" + ShortVideoUtils.b(paramFileMsg.Z));
    }
    paramInt2 = 0;
    if ((paramFileMsg.e == 6) || (paramFileMsg.e == 17) || (paramFileMsg.e == 9) || (paramFileMsg.e == 20)) {
      switch (paramFileMsg.Z)
      {
      default: 
        return;
      case 1001: 
        if (paramFileMsg.jdField_a_of_type_Long == 0L) {
          break;
        }
      }
    }
    for (paramInt1 = (int)(100L * paramFileMsg.f / paramFileMsg.jdField_a_of_type_Long);; paramInt1 = 0)
    {
      a(paramView, ShortVideoUtils.a(paramInt1, 10), true);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      return;
      a(paramView);
      return;
      a(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
      a(paramView);
      ((ProgressPieView)localObject2).setImageResource(2130842962);
      return;
      a(paramView);
      return;
      if (!((MessageForShortVideo)localObject1).isSendFromLocal()) {
        break;
      }
      if (paramFileMsg.jdField_a_of_type_Long != 0L) {
        paramInt1 = (int)(100L * paramFileMsg.f / paramFileMsg.jdField_a_of_type_Long);
      }
      for (;;)
      {
        a(paramView, ShortVideoUtils.a(paramInt1, 10), true);
        return;
        paramInt1 = paramInt2;
        if (QLog.isColorLevel())
        {
          QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
          paramInt1 = paramInt2;
        }
      }
      a(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      return;
      a(paramView);
      paramView = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
      if (FileUtils.b(paramView)) {
        break;
      }
      paramFileMsg = ShortVideoBusiManager.a(2, this.i);
      localObject2 = ((MessageForShortVideo)localObject1).getDownloadInfo(paramFileMsg.g);
      ((ShortVideoDownloadInfo)localObject2).i = paramView;
      if ((((MessageForShortVideo)localObject1).istroop == 0) || (((MessageForShortVideo)localObject1).istroop == 1008)) {
        ((ShortVideoDownloadInfo)localObject2).g = 1002;
      }
      for (;;)
      {
        paramFileMsg.a((ShortVideoDownloadInfo)localObject2);
        paramFileMsg.a((MessageForShortVideo)localObject1);
        ShortVideoBusiManager.a(paramFileMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        if (((MessageForShortVideo)localObject1).istroop == 3000) {
          ((ShortVideoDownloadInfo)localObject2).g = 1006;
        } else if (((MessageForShortVideo)localObject1).istroop == 1) {
          ((ShortVideoDownloadInfo)localObject2).g = 1004;
        }
      }
      a(paramView);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371526, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return;
      a(paramView);
      if (((MessageForShortVideo)localObject1).uiOperatorFlag == 2)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371538, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371527, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return;
      a(paramView, 2131367235);
      if (((MessageForShortVideo)localObject1).uiOperatorFlag == 2)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371539, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371528, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return;
      a(paramView);
      return;
      a(paramView);
      return;
      if ((paramFileMsg.e != 7) && (paramFileMsg.e != 18) && (paramFileMsg.e != 16)) {
        break;
      }
      switch (paramFileMsg.Z)
      {
      case 2001: 
      case 2002: 
      default: 
        return;
      }
      paramFileMsg = ShortVideoUtils.a(ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg"));
      localObject1 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbWidth, ((MessageForShortVideo)localObject1).thumbHeight);
      localObject1 = a(localObject1[0], localObject1[1]);
      if ((paramView.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramView.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramFileMsg))) {
        break;
      }
      try
      {
        paramFileMsg = URLDrawable.getDrawable(paramFileMsg, (Drawable)localObject1, (Drawable)localObject1);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramFileMsg);
        paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
  }
  
  protected void a(ShortVideoItemBuilder.Holder paramHolder)
  {
    ProgressPieView localProgressPieView = paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView;
    localProgressPieView.setProgress(0);
    localProgressPieView.setShowText(false);
    localProgressPieView.setShowImage(true);
    localProgressPieView.b();
    localProgressPieView.setImageResource(2130842959);
    localProgressPieView.setBackgroundColor(0);
    paramHolder.c.setVisibility(8);
  }
  
  void a(ShortVideoItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(0);
    paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.setShowImage(true);
    paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.setShowText(false);
    paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.setImageResource(2130842963);
    paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.setBackgroundColor(0);
    paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.b();
    paramHolder.c.setVisibility(0);
    paramHolder.c.setText(paramInt);
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    ProgressPieView localProgressPieView = paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView;
    if (paramInt < 100) {
      if ((paramBoolean) && (localProgressPieView.a() != 0))
      {
        localProgressPieView.a(paramInt);
        localProgressPieView.setShowText(true);
        localProgressPieView.setShowImage(false);
        localProgressPieView.setBackgroundColor(1426063360);
        localProgressPieView.setText(String.valueOf(paramInt) + "%");
      }
    }
    for (;;)
    {
      paramHolder.c.setVisibility(8);
      return;
      localProgressPieView.setProgress(paramInt);
      break;
      a(paramHolder);
    }
  }
  
  public void a(ShortVideoItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if (paramHolder == null) {
      return;
    }
    if (paramBoolean)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.setVisibility(8);
    }
    for (;;)
    {
      paramHolder.c.setVisibility(8);
      return;
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.setVisibility(0);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131371537, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2002, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", paramMessageForShortVideo.istroop);
    localBundle.putString("from_uin", ShortVideoUtils.c(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putString("thumbfile_send_path", (String)localObject);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putInt("video_play_caller", 0);
    localBundle.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ShortVideoPlayActivity.class);
    ((Intent)localObject).putExtras(localBundle);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 13002);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968620, 2130968621);
    ThreadManager.a().post(this.jdField_a_of_type_JavaLangRunnable);
    PredictionReporter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b(str1))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131371517, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      a(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.b(str2))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131371518, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      a(paramHolder);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    paramHolder = ShortVideoBusiManager.a(1, this.i);
    paramHolder.a(ShortVideoBusiManager.a(this.i, paramMessageForShortVideo, paramHolder));
    ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      if (paramChatMessage.videoFileStatus != 1005) {
        break label35;
      }
      bool1 = true;
    }
    label35:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramChatMessage.md5 == null);
    int k;
    if (paramChatMessage.uiOperatorFlag == 2) {
      if ((paramChatMessage.videoFileStatus == 5002) || (paramChatMessage.videoFileStatus == 5001)) {
        k = 1;
      }
    }
    for (;;)
    {
      label76:
      if ((paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.extraflag == 32768)) {}
      for (int m = 1;; m = 0)
      {
        int n = m;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq) == null)
        {
          n = m;
          if (paramChatMessage.videoFileProgress != 100)
          {
            n = m;
            if (paramChatMessage.videoFileStatus != 1003)
            {
              n = m;
              if (paramChatMessage.videoFileStatus != 1004) {
                n = 1;
              }
            }
          }
        }
        if (k == 0)
        {
          bool1 = bool2;
          if (n == 0) {
            break;
          }
        }
        return true;
        k = 0;
        break label76;
      }
      k = 0;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    boolean bool3 = false;
    ShortVideoItemBuilder.Holder localHolder = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    int k;
    boolean bool1;
    label189:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramView = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (FileUtils.b(paramView))
      {
        paramView = "";
        k = 1;
        if (k == 0) {
          break label497;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label484;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((localHolder.jdField_a_of_type_ComTencentWidgetProgressPieView == null) || (localHolder.jdField_a_of_type_ComTencentWidgetProgressPieView.a() <= 0)) {
          break label491;
        }
        bool1 = true;
        bool2 = bool3;
        if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b != null)
        {
          bool2 = bool3;
          if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label444;
        }
        localQQCustomMenu.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
        paramView = paramView + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label444:
    label484:
    label491:
    label497:
    for (;;)
    {
      a(localMessageForShortVideo, localQQCustomMenu);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramView);
      }
      if ((localMessageForShortVideo != null) && (localMessageForShortVideo.isSend()) && ((localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null) || (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getVisibility() != 0))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      this.e = true;
      return localQQCustomMenu.a();
      paramView = "thumbFilePath=" + paramView + " , not exits.";
      k = 0;
      break;
      paramView = " msg == null or md5 is empty.";
      k = 0;
      break;
      paramView = paramView + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramView = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label189;
    }
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!FileUtils.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131371518, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        a(paramHolder);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramHolder = ShortVideoBusiManager.a(4, this.i);
        paramHolder.a(ShortVideoBusiManager.a(this.i, paramMessageForShortVideo, paramHolder));
        ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoItemBuilder", 2, "ShortVideoItemBuilder:reForwardVideo() path is empty");
  }
  
  public void c()
  {
    super.c();
    this.j = -1;
    this.e = false;
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", ShortVideoUtils.c(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    String str2 = ShortVideoUtils.b(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  public void d(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((ShortVideoBusiManager.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - ShortVideoBusiManager.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + ShortVideoBusiManager.jdField_a_of_type_Long);
      }
      if ((!bool2) || (bool1) || ((FileUtils.a(str)) && (paramMessageForShortVideo.videoFileStatus != 2002) && (paramMessageForShortVideo.videoFileStatus != 1002))) {
        break;
      }
      paramMessageForShortVideo = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131371550), 2131367259, 2131367258, new noq(this, paramMessageForShortVideo), new nor(this));
      try
      {
        paramMessageForShortVideo.show();
        return;
      }
      catch (Throwable paramMessageForShortVideo)
      {
        return;
      }
    }
    a(paramMessageForShortVideo);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    AIOUtils.l = true;
    long l = System.currentTimeMillis();
    if ((l - jdField_b_of_type_Long < c) && (l > jdField_b_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
    }
    for (;;)
    {
      return;
      jdField_b_of_type_Long = l;
      if ((paramView.getId() == 2131296328) || (paramView.getId() == 2131296350))
      {
        paramView = (ShortVideoItemBuilder.Holder)AIOUtils.a(paramView);
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        int k = localMessageForShortVideo.videoFileStatus;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType: " + ShortVideoUtils.a(localMessageForShortVideo.fileType) + ", fileStatus:" + ShortVideoUtils.b(k));
        }
        StringBuilder localStringBuilder = new StringBuilder("");
        localStringBuilder.append("......click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq);
        Object localObject = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
        boolean bool;
        if (!localMessageForShortVideo.isSendFromLocal())
        {
          localStringBuilder.append(" sendFromLocal:false ");
          if (!FileUtils.b((String)localObject))
          {
            localStringBuilder.append(" videoPathExists:false ");
            if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
            {
              localStringBuilder.append(" fileType:video, =" + ShortVideoUtils.a(localMessageForShortVideo.fileType));
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
              if (localObject != null) {
                if (ShortVideoDownloadProcessor.class.isInstance(localObject))
                {
                  bool = ((ShortVideoDownloadProcessor)localObject).c();
                  localStringBuilder.append(" processor:Download, pause:" + bool + " ");
                  if (bool)
                  {
                    a(paramView);
                    d(localMessageForShortVideo);
                    localStringBuilder.append("pause, result:download ");
                  }
                }
              }
            }
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
          return;
          if (k == 2005)
          {
            a(paramView);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371526, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
            localStringBuilder.append(" result:toast recv_error ");
          }
          else if ((k == 2002) || (k == 2000) || (k == 2008) || (k == 2001))
          {
            a(paramView);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            localStringBuilder.append("status:process or r p s, result: pauseRecving ");
          }
          else if (k == 5001)
          {
            a(paramView);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371527, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
            localStringBuilder.append(" result: toast file_unsafe ");
          }
          else if (k == 5002)
          {
            a(paramView, 2131367235);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371528, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
            localStringBuilder.append(" result: toast file_expired ");
          }
          else
          {
            a(paramView);
            d(localMessageForShortVideo);
            localStringBuilder.append(" status:other, result: download ");
            continue;
            localStringBuilder.append("fileType:video,videoPathExits:false,processor:not download, result:none");
            continue;
            a(paramView);
            d(localMessageForShortVideo);
            localStringBuilder.append(" processor:null, result:download ");
            continue;
            if (k == 5002)
            {
              a(paramView, 2131367235);
              localStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
            }
            else
            {
              a(paramView);
              d(localMessageForShortVideo);
              localStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
              continue;
              a(paramView);
              d(localMessageForShortVideo);
              localStringBuilder.append("videoPathExists:true, result:play ");
              continue;
              localStringBuilder.append(" sendFromLocal:true ");
              if (FileUtils.b(localMessageForShortVideo.videoFileName))
              {
                localStringBuilder.append(" localUploadPath Exists:true ");
                if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
                {
                  localStringBuilder.append(" fileType:video ");
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                  if (localObject != null)
                  {
                    if ((ShortVideoUploadProcessor.class.isInstance(localObject)) || (ShortVideoForwardProcessor.class.isInstance(localObject)))
                    {
                      bool = ((BaseTransProcessor)localObject).c();
                      localStringBuilder.append(" processor:up or forward, pause:" + bool);
                      if (bool)
                      {
                        a(paramView, 10, false);
                        if (localMessageForShortVideo.uiOperatorFlag == 2)
                        {
                          b(localMessageForShortVideo, paramView);
                          localStringBuilder.append(" uiOper:forward, result:reforward ");
                        }
                        else if (localMessageForShortVideo.uiOperatorFlag == 1)
                        {
                          a(localMessageForShortVideo, paramView);
                          localStringBuilder.append(" uiOper:upload, result:upload ");
                        }
                      }
                      else if (k == 1005)
                      {
                        a(paramView);
                        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                        localStringBuilder.append(" status:send_error, result:show send error ");
                      }
                      else if ((k == 1002) || (k == 1001))
                      {
                        d(localMessageForShortVideo);
                        localStringBuilder.append(" status:process or start, result:pauseSending ");
                      }
                      else
                      {
                        a(paramView);
                        d(localMessageForShortVideo);
                        localStringBuilder.append(" status:other, result:play ");
                      }
                    }
                    else if (ShortVideoDownloadProcessor.class.isInstance(localObject))
                    {
                      localStringBuilder.append(" processor:not up of forward, result: none");
                    }
                  }
                  else if ((k == 1004) && (localMessageForShortVideo.extraflag == 32772))
                  {
                    a(paramView, 10, false);
                    a(localMessageForShortVideo, paramView);
                    localStringBuilder.append(" processor:null, but send_cancel && msg_sending, result:upload ");
                  }
                  else
                  {
                    a(paramView);
                    d(localMessageForShortVideo);
                    localStringBuilder.append(" processor:null, result:play ");
                  }
                }
                else
                {
                  a(paramView);
                  d(localMessageForShortVideo);
                  localStringBuilder.append(" fileType:not video, result: play ");
                }
              }
              else
              {
                localStringBuilder.append(" localUploadPath Exists:false ");
                if (!FileUtils.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))
                {
                  localStringBuilder.append(" downloadPath Exists:false ");
                  if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
                  {
                    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                    if (localObject != null)
                    {
                      if (ShortVideoDownloadProcessor.class.isInstance(localObject))
                      {
                        bool = ((ShortVideoDownloadProcessor)localObject).c();
                        localStringBuilder.append(" processor:download, pause:" + bool);
                        if (bool)
                        {
                          a(paramView);
                          d(localMessageForShortVideo);
                          localStringBuilder.append(" pause:true, result:download ");
                        }
                        else if (k == 2005)
                        {
                          a(paramView);
                          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371526, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
                          localStringBuilder.append(" status:recv_error, result:toast recv_error ");
                        }
                        else if ((k == 2002) || (k == 2000) || (k == 2008) || (k == 2001))
                        {
                          a(paramView);
                        }
                        else if (k == 5001)
                        {
                          a(paramView);
                          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371527, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
                          localStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
                        }
                        else if (k == 5002)
                        {
                          a(paramView, 2131367235);
                          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371528, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
                          localStringBuilder.append(" status:file_expired, result:toast expired ");
                        }
                        else
                        {
                          a(paramView);
                          d(localMessageForShortVideo);
                          localStringBuilder.append(" status:other, result:download ");
                        }
                      }
                      else if (ShortVideoUploadProcessor.class.isInstance(localObject))
                      {
                        a(paramView);
                        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371517, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
                        localStringBuilder.append(" processor:upload, result:show upload error and show toast");
                      }
                      else if (ShortVideoForwardProcessor.class.isInstance(localObject))
                      {
                        bool = ((ShortVideoForwardProcessor)localObject).c();
                        localStringBuilder.append(" processor:forward, pause:" + bool);
                        if (bool)
                        {
                          a(paramView, 10, false);
                          b(localMessageForShortVideo, paramView);
                          localStringBuilder.append(" pause:true, result:reforward ");
                        }
                        else if (k == 5001)
                        {
                          a(paramView);
                          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371538, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
                          localStringBuilder.append(" status:unsafe, result:toast unsafe ");
                        }
                        else if (k == 5002)
                        {
                          a(paramView, 2131367235);
                          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371539, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
                          localStringBuilder.append(" status:expired, result:toast expired ");
                        }
                        else if (k == 1005)
                        {
                          a(paramView);
                          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                          localStringBuilder.append(" status:send_error, result:show send_error ");
                        }
                        else if ((k == 1002) || (k == 1001))
                        {
                          d(localMessageForShortVideo);
                        }
                        else
                        {
                          a(paramView);
                          d(localMessageForShortVideo);
                          localStringBuilder.append(" status:other, result:plau ");
                        }
                      }
                      else
                      {
                        localStringBuilder.append(" processor:not down or forward or up, result:none ");
                      }
                    }
                    else
                    {
                      a(paramView);
                      localStringBuilder.append(" processor:null, result:download ");
                      d(localMessageForShortVideo);
                    }
                  }
                  else
                  {
                    a(paramView);
                    d(localMessageForShortVideo);
                    localStringBuilder.append(" fileType:not video, result:download ");
                  }
                }
                else
                {
                  a(paramView);
                  d(localMessageForShortVideo);
                  localStringBuilder.append(" downloadPath Exists:true，result:play ");
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ShortVideoItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */