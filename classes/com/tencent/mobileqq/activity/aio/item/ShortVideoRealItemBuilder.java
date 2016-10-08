package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import npc;
import npd;
import npe;

public class ShortVideoRealItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, ShortVideoConstants
{
  protected static ColorDrawable a;
  static final String jdField_b_of_type_JavaLangString = "ShortVideoRealItemBuilder";
  public static boolean d;
  private static boolean e;
  public static int h;
  public static int i;
  static int j;
  static int k;
  static int l;
  static int m;
  static int n;
  private Handler jdField_b_of_type_AndroidOsHandler;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    URLDrawableHelper.b();
    d = true;
    jdField_h_of_type_Int = 720;
    i = 540;
    Resources localResources = BaseApplicationImpl.a.getResources();
    l = BaseChatItemLayout.i;
    l = Math.min(AIOUtils.a(320.0F, localResources), l);
    m = AIOUtils.a(100.0F, localResources);
    n = AIOUtils.a(100.0F, localResources);
    j = AIOUtils.a(CodecParam.l, localResources);
    k = AIOUtils.a(CodecParam.m, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new EmptyDrawable(-10065297, j, k);
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.b = new Handler(Looper.getMainLooper());
    ShortVideoUtils.a(paramQQAppInterface);
    ShortVideoUtils.ShortVideoPlayConfig.a();
    e();
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(this.jdField_a_of_type_AndroidContentContext);
    localProgressPieDrawable.a(AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.e(false);
    localProgressPieDrawable.i(-1);
    localProgressPieDrawable.h(0);
    localProgressPieDrawable.g(-15550475);
    localProgressPieDrawable.n(3);
    localProgressPieDrawable.f = true;
    localProgressPieDrawable.r = 2;
    localProgressPieDrawable.a(new npe(this));
    return localProgressPieDrawable;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, ImageView paramImageView, SessionInfo paramSessionInfo)
  {
    if (!ShortVideoUtils.a())
    {
      paramImageView = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("uintype", paramMessageForShortVideo.istroop);
      paramQQAppInterface.putString("from_uin", ShortVideoUtils.c(paramMessageForShortVideo));
      paramQQAppInterface.putInt("from_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      paramQQAppInterface.putString("from_session_uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramQQAppInterface.putInt("from_busi_type", paramMessageForShortVideo.busiType);
      paramQQAppInterface.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
      paramQQAppInterface.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
      paramQQAppInterface.putString("file_name", paramMessageForShortVideo.videoFileName);
      paramQQAppInterface.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
      paramQQAppInterface.putString("file_send_path", (String)localObject);
      paramQQAppInterface.putString("thumbfile_send_path", paramImageView);
      paramQQAppInterface.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
      paramQQAppInterface.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
      paramQQAppInterface.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
      paramQQAppInterface.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
      paramQQAppInterface.putString("file_source", paramMessageForShortVideo.fileSource);
      paramQQAppInterface.putString("file_uuid", paramMessageForShortVideo.uuid);
      paramQQAppInterface.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
      paramQQAppInterface.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
      paramQQAppInterface.putInt("file_width", paramMessageForShortVideo.fileWidth);
      paramQQAppInterface.putInt("file_height", paramMessageForShortVideo.fileHeight);
      paramQQAppInterface.putInt("video_play_caller", 0);
      paramQQAppInterface.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
      paramQQAppInterface.putLong("message_click_start", System.currentTimeMillis());
      paramMessageForShortVideo = new Intent(paramContext, ShortVideoPlayActivity.class);
      paramMessageForShortVideo.putExtras(paramQQAppInterface);
      paramContext.startActivity(paramMessageForShortVideo);
      return;
    }
    if (MediaPlayerManager.a(paramQQAppInterface).b()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramImageView = AnimationUtils.a(paramImageView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramImageView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity))) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().f());
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000)) {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
      paramImageView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramImageView.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramImageView.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).processName.endsWith("mobileqq")) {
          localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject).pid);
        }
      }
      localObject = paramMessageForShortVideo.selfuin;
      paramImageView = (ImageView)localObject;
      if (paramMessageForShortVideo.isMultiMsg) {}
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramImageView = (ImageView)localObject;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramImageView = localAppRuntime.getAccount();
        }
      }
      catch (Exception paramImageView)
      {
        for (;;)
        {
          paramImageView = (ImageView)localObject;
        }
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramImageView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), AIOGalleryUtils.a(paramMessageForShortVideo), -1);
      if (paramMessageForShortVideo.isSend()) {
        break;
      }
      new DCShortVideo(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
      return;
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramMessageRecord = "ShortVideoRealItemBuilder" + "[" + paramMessageRecord.uniseq + "]";
      QLog.i("ShortVideoRealItemBuilder", 2, paramMessageRecord + ":content " + paramString);
    }
  }
  
  private void e()
  {
    int i2 = 720;
    int i3 = 540;
    Object localObject;
    int i1;
    if (!e)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.ShortVideoHDConfig.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), shortVideoHDConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            d = localObject[0].equals("1");
          }
          i1 = i2;
          if (TextUtils.isEmpty(localObject[1])) {}
        }
      }
    }
    try
    {
      i1 = Integer.parseInt(localObject[1]);
      i2 = i3;
      if (!TextUtils.isEmpty(localObject[2])) {}
      try
      {
        i2 = Integer.parseInt(localObject[2]);
        jdField_h_of_type_Int = Math.max(i1, i2);
        i = Math.min(i1, i2);
        e = true;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), sReadHDConfig=" + e + ", sHDEnable:" + d + ", sHDMaxLength:" + jdField_h_of_type_Int + ", sHDMinLength:" + i);
        }
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i2 = i3;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramView != null) {
      paramView.a(paramChatMessage, this);
    }
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (ShortVideoRealItemBuilder.Holder)paramViewHolder;
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject1 = ((Context)localObject2).getResources();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout((Context)localObject2);
      paramView = new ShortVideoRealItemBuilder.ChatVideoView((Context)localObject2);
      paramView.setId(2131299762);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(15.0F);
      if ((paramChatMessage instanceof MessageForDevLittleVideo))
      {
        paramView.setAdjustViewBounds(true);
        paramView.setMinimumWidth(m);
        paramView.setMinimumHeight(n);
        paramView.setMaxWidth(l);
      }
      paramViewHolder.addView(paramView);
      ImageView localImageView = new ImageView((Context)localObject2);
      localImageView.setImageResource(2130837565);
      localImageView.setVisibility(8);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131299762);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131299762);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.a(10.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.a(10.0F, (Resources)localObject1);
      paramViewHolder.addView(localImageView, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new LinearLayout((Context)localObject2);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(13);
      paramViewHolder.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new ImageView((Context)localObject2);
      ((LinearLayout)localObject3).addView((View)localObject4, new LinearLayout.LayoutParams(-2, -2));
      localObject2 = new TextView((Context)localObject2);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131296351);
      ((LinearLayout)localObject3).addView((View)localObject2, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      paramBaseChatItemLayout.b = localImageView;
    }
    if ((paramChatMessage instanceof MessageForDevLittleVideo)) {}
    label503:
    int i1;
    int i2;
    for (;;)
    {
      return paramViewHolder;
      paramOnLongClickAndTouchListener = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView;
      paramView = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView;
      localObject2 = (MessageForShortVideo)paramChatMessage;
      paramChatMessage = ((MessageForShortVideo)localObject2).mProgressPie;
      paramView.setImageDrawable(paramChatMessage);
      if ((paramChatMessage != null) && ((((MessageForShortVideo)localObject2).fileType == 6) || (((MessageForShortVideo)localObject2).fileType == 17) || (((MessageForShortVideo)localObject2).fileType == 9) || (((MessageForShortVideo)localObject2).fileType == 20)))
      {
        if ((((MessageForShortVideo)localObject2).videoFileStatus == 1003) || (((MessageForShortVideo)localObject2).videoFileStatus == 2003))
        {
          if (paramChatMessage.a() < 100) {
            paramChatMessage.e(100);
          }
          paramView.setVisibility(4);
        }
      }
      else
      {
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramOnLongClickAndTouchListener.jdField_b_of_type_Boolean = ((MessageForShortVideo)localObject2).isSend();
        paramChatMessage = ShortVideoUtils.a(((MessageForShortVideo)localObject2).thumbWidth, ((MessageForShortVideo)localObject2).thumbHeight);
        i1 = paramChatMessage[0];
        i2 = paramChatMessage[1];
        paramChatMessage = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.getLayoutParams();
        if (paramChatMessage != null) {
          break label774;
        }
        paramChatMessage = new RelativeLayout.LayoutParams(i1, i2);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.setLayoutParams(paramChatMessage);
        label581:
        i1 = Math.max(((MessageForShortVideo)localObject2).thumbWidth, ((MessageForShortVideo)localObject2).thumbHeight);
        i2 = Math.min(((MessageForShortVideo)localObject2).thumbWidth, ((MessageForShortVideo)localObject2).thumbHeight);
        if ((!d) || (i1 < jdField_h_of_type_Int) || (i2 < i)) {
          break label831;
        }
        paramChatMessage = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams();
        if (!paramOnLongClickAndTouchListener.jdField_b_of_type_Boolean) {
          break label816;
        }
        paramChatMessage.rightMargin = AIOUtils.a(18.0F, (Resources)localObject1);
        label665:
        paramBaseChatItemLayout.b.setVisibility(0);
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(((MessageForShortVideo)localObject2).md5)) && (((MessageForShortVideo)localObject2).videoFileStatus != 1005) && (((MessageForShortVideo)localObject2).extraflag != 32768))
        {
          if (!((MessageForShortVideo)localObject2).isSendFromLocal()) {
            break;
          }
          paramView = ((MessageForShortVideo)localObject2).mThumbFilePath;
          paramChatMessage = paramView;
          if (!FileUtils.b(paramView))
          {
            if (TextUtils.isEmpty(((MessageForShortVideo)localObject2).thumbMD5))
            {
              paramOnLongClickAndTouchListener.setImageDrawable(URLDrawableHelper.b);
              a(paramBaseChatItemLayout);
              a((MessageRecord)localObject2, "getBubbleView():You must get thumb before send video.");
              return paramViewHolder;
              paramView.setVisibility(0);
              break label503;
              label774:
              if ((paramChatMessage.width == i1) && (paramChatMessage.height == i2)) {
                break label581;
              }
              paramChatMessage.width = i1;
              paramChatMessage.height = i2;
              paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView.setLayoutParams(paramChatMessage);
              break label581;
              label816:
              paramChatMessage.rightMargin = AIOUtils.a(8.0F, (Resources)localObject1);
              break label665;
              label831:
              paramBaseChatItemLayout.b.setVisibility(8);
              continue;
            }
            paramChatMessage = ShortVideoUtils.a(((MessageForShortVideo)localObject2).thumbMD5, "jpg");
          }
          if (!paramOnLongClickAndTouchListener.a(paramChatMessage)) {
            break;
          }
          a((MessageRecord)localObject2, "getBubbleView: 占坑");
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramView.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramOnLongClickAndTouchListener.setURLDrawable(URLDrawable.getDrawable(new File(paramChatMessage), paramView));
          if (((MessageForShortVideo)localObject2).mShowProgressTask == null) {
            ((MessageForShortVideo)localObject2).mShowProgressTask = new npc(this, (MessageForShortVideo)localObject2, paramBaseChatItemLayout);
          }
          this.b.removeCallbacks(((MessageForShortVideo)localObject2).mShowProgressTask);
          this.b.postDelayed(((MessageForShortVideo)localObject2).mShowProgressTask, 600L);
          a((MessageRecord)localObject2, "getBubbleView,judge mr status. mr = " + localObject2);
          if ((((MessageForShortVideo)localObject2).mPreUpload) || (!TextUtils.isEmpty(((MessageForShortVideo)localObject2).mLocalMd5))) {
            break;
          }
          Utils.executeAsyncTaskOnSerialExcuter(new ShortVideoRealItemBuilder.EncodeTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (MessageForShortVideo)localObject2), new Void[] { (Void)null });
          return paramViewHolder;
        }
      }
      paramChatMessage = ShortVideoUtils.a(((MessageForShortVideo)localObject2).thumbMD5, "jpg");
      paramView = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
      if ((FileUtils.b(paramChatMessage)) && (FileUtils.b(paramView))) {
        a(paramBaseChatItemLayout);
      }
      if ((!ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean) || (!ShortVideoUtils.a()) || (!FileUtils.b(paramView)) || ((((MessageForShortVideo)localObject2).isSendFromLocal()) && (((MessageForShortVideo)localObject2).videoFileStatus != 1003) && (((MessageForShortVideo)localObject2).videoFileStatus != 2003))) {
        break;
      }
      if (!((MessageForShortVideo)localObject2).isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
      }
      if (paramOnLongClickAndTouchListener.a(paramView))
      {
        a((MessageRecord)localObject2, "getBubbleView: 刷视频 " + paramView);
        paramBaseChatItemLayout = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramBaseChatItemLayout.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        if (!paramOnLongClickAndTouchListener.a(paramChatMessage)) {
          paramBaseChatItemLayout.mLoadingDrawable = paramOnLongClickAndTouchListener.jdField_b_of_type_ComTencentImageURLDrawable;
        }
        localObject1 = new VideoDrawable.VideoDrawableParams();
        ((VideoDrawable.VideoDrawableParams)localObject1).mPlayVideoFrame = true;
        ((VideoDrawable.VideoDrawableParams)localObject1).mPlayAudioFrame = false;
        ((VideoDrawable.VideoDrawableParams)localObject1).mVideoRoundCorner = 0;
        ((VideoDrawable.VideoDrawableParams)localObject1).mRequestedFPS = ShortVideoUtils.ShortVideoPlayConfig.jdField_a_of_type_Int;
        paramBaseChatItemLayout.mExtraInfo = localObject1;
        paramOnLongClickAndTouchListener.setURLDrawable(URLDrawable.getDrawable(new File(paramView), paramBaseChatItemLayout));
      }
      while (!FileUtils.b(paramChatMessage))
      {
        a((MessageForShortVideo)localObject2);
        a((MessageRecord)localObject2, "getBubbleView: Video file exist and status finish. Thumb not exist.");
        return paramViewHolder;
        a((MessageRecord)localObject2, "getBubbleView: 刷视频用缓存 " + paramView);
        paramView = paramOnLongClickAndTouchListener.jdField_b_of_type_ComTencentImageURLDrawable;
        if ((paramView != null) && (paramView.getStatus() == 1)) {
          paramOnLongClickAndTouchListener.setURLDrawable(paramView);
        }
      }
    }
    if (FileUtils.b(paramChatMessage))
    {
      if (paramOnLongClickAndTouchListener.a(paramChatMessage))
      {
        a((MessageRecord)localObject2, "getBubbleView: 刷缩略图 " + paramChatMessage);
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramOnLongClickAndTouchListener.setURLDrawable(URLDrawable.getDrawable(new File(paramChatMessage), (URLDrawable.URLDrawableOptions)localObject1));
      }
      while (FileUtils.b(paramView))
      {
        i1 = 0;
        if ((((MessageForShortVideo)localObject2).videoFileStatus == 1005) || (((MessageForShortVideo)localObject2).extraflag == 32768)) {
          i1 = 1;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForShortVideo)localObject2).frienduin, ((MessageForShortVideo)localObject2).uniseq);
        i2 = i1;
        if (((MessageForShortVideo)localObject2).isSendFromLocal())
        {
          i2 = i1;
          if (((MessageForShortVideo)localObject2).videoFileProgress < 100)
          {
            i2 = i1;
            if (((MessageForShortVideo)localObject2).videoFileStatus != 1003)
            {
              i2 = i1;
              if (((MessageForShortVideo)localObject2).videoFileStatus != 1004)
              {
                i2 = i1;
                if (paramChatMessage == null) {
                  i2 = 1;
                }
              }
            }
          }
        }
        if (i2 != 0)
        {
          a((MessageForShortVideo)localObject2, paramBaseChatItemLayout, 2131367237);
          return paramViewHolder;
          a((MessageRecord)localObject2, "getBubbleView: 刷缩略图用缓存 " + paramChatMessage);
          paramChatMessage = paramOnLongClickAndTouchListener.jdField_b_of_type_ComTencentImageURLDrawable;
          if ((paramChatMessage != null) && (paramChatMessage.getStatus() == 1)) {
            paramOnLongClickAndTouchListener.setURLDrawable(paramChatMessage);
          }
        }
        else
        {
          if ((!ShortVideoUtils.a()) || (!ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean))
          {
            c((MessageForShortVideo)localObject2, paramBaseChatItemLayout);
            return paramViewHolder;
          }
          a((MessageForShortVideo)localObject2, paramBaseChatItemLayout, ((MessageForShortVideo)localObject2).videoFileProgress, false);
          return paramViewHolder;
        }
      }
      if (((MessageForShortVideo)localObject2).videoFileStatus == 5002)
      {
        a((MessageRecord)localObject2, "getBubbleView():短视频已过期不启动下载流程 1");
        a((MessageForShortVideo)localObject2, paramBaseChatItemLayout, 2131367235);
        return paramViewHolder;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForShortVideo)localObject2, true))
      {
        a((MessageForShortVideo)localObject2, true);
        return paramViewHolder;
      }
      if ((((MessageForShortVideo)localObject2).videoFileStatus == 2001) || (((MessageForShortVideo)localObject2).videoFileStatus == 2002) || (((MessageForShortVideo)localObject2).videoFileStatus == 2000))
      {
        a((MessageForShortVideo)localObject2, paramBaseChatItemLayout, ((MessageForShortVideo)localObject2).videoFileProgress, false);
        return paramViewHolder;
      }
      if ((((MessageForShortVideo)localObject2).videoFileStatus == 1003) || (((MessageForShortVideo)localObject2).videoFileStatus == 2003)) {
        ((MessageForShortVideo)localObject2).videoFileStatus = 0;
      }
      c((MessageForShortVideo)localObject2, paramBaseChatItemLayout);
      return paramViewHolder;
    }
    if (((MessageForShortVideo)localObject2).videoFileStatus == 5002)
    {
      a((MessageRecord)localObject2, "getBubbleView():短视频已过期不启动下载流程 2");
      paramOnLongClickAndTouchListener.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      a((MessageForShortVideo)localObject2, paramBaseChatItemLayout, 2131367235);
      return paramViewHolder;
    }
    a((MessageRecord)localObject2, "getBubbleView: 下占位图");
    paramOnLongClickAndTouchListener.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a((MessageForShortVideo)localObject2);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ShortVideoRealItemBuilder.Holder(this);
  }
  
  public ProgressPieDrawable a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.mProgressPie != null) {
      return paramMessageForShortVideo.mProgressPie;
    }
    ProgressPieDrawable localProgressPieDrawable = a();
    paramMessageForShortVideo.mProgressPie = localProgressPieDrawable;
    return localProgressPieDrawable;
  }
  
  public ProgressPieDrawable a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    paramMessageForShortVideo = a(paramMessageForShortVideo);
    if (paramMessageForShortVideo == null) {
      return paramMessageForShortVideo;
    }
    paramMessageForShortVideo.e(paramMessageForShortVideo.a(paramInt));
    return paramMessageForShortVideo;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "视频消息";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt == 2131305401) {
        ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
      }
    }
    else
    {
      return;
    }
    if (paramInt == 2131305411)
    {
      super.b(paramChatMessage);
      return;
    }
    if (paramInt == 2131297425)
    {
      paramInt = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
      if (paramInt == 3) {
        paramContext = "1";
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
        b(localMessageForShortVideo);
        return;
        if (paramInt == 2) {
          paramContext = "2";
        } else if (paramInt == 0) {
          paramContext = "3";
        } else {
          paramContext = "4";
        }
      }
    }
    if (paramInt == 2131299841)
    {
      QfavBuilder.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      return;
    }
    if (paramInt == 2131296353)
    {
      super.a(localMessageForShortVideo);
      return;
    }
    if (paramInt == 2131305402)
    {
      paramContext = new StringBuilder();
      paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(2131367889, 5);
    localActionSheet.d(2131367262);
    localActionSheet.a(new npd(this, localMessageForShortVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493059);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.n, BaseChatItemLayout.k, i1, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(i1, BaseChatItemLayout.k, BaseChatItemLayout.n, BaseChatItemLayout.l);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    Object localObject1 = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    Object localObject2 = (MessageForShortVideo)((ShortVideoRealItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((MessageForShortVideo)localObject2).uniseq != paramFileMsg.c) {}
    Object localObject3;
    label74:
    label322:
    label719:
    label813:
    label1078:
    label1134:
    label1199:
    label1454:
    label1477:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = ((ShortVideoRealItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView;
            this.b.removeCallbacks(((MessageForShortVideo)localObject2).mShowProgressTask);
            localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
            if (((MessageForShortVideo)localObject2).thumbWidth > 0)
            {
              paramInt1 = ((MessageForShortVideo)localObject2).thumbWidth;
              if (((MessageForShortVideo)localObject2).thumbHeight <= 0) {
                break label322;
              }
            }
            for (paramInt2 = ((MessageForShortVideo)localObject2).thumbHeight;; paramInt2 = 100)
            {
              paramInt1 = AIOUtils.a(paramInt1, (Resources)localObject3);
              paramInt2 = AIOUtils.a(paramInt2, (Resources)localObject3);
              if ((paramFileMsg.e != 6) && (paramFileMsg.e != 17) && (paramFileMsg.e != 9) && (paramFileMsg.e != 20)) {
                break label1199;
              }
              switch (paramFileMsg.Z)
              {
              default: 
                return;
              case 1001: 
                a((MessageRecord)localObject2, "VIDEO STATUS_SEND_START progress " + ((MessageForShortVideo)localObject2).videoFileProgress);
                a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, ((MessageForShortVideo)localObject2).videoFileProgress, true);
                ((ShortVideoRealItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                return;
                paramInt1 = 100;
                break label74;
              }
            }
            a((MessageRecord)localObject2, "VIDEO STATUS_UPLOAD_FINISHED progress " + ((MessageForShortVideo)localObject2).videoFileProgress);
            return;
            a((MessageRecord)localObject2, "VIDEO STATUS_SEND_FINISHED");
            a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, 100, true);
            return;
            a((MessageRecord)localObject2, "VIDEO STATUS_SEND_ERROR");
            a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, 2131367237);
            ((ShortVideoRealItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            return;
            a((MessageRecord)localObject2, "VIDEO STATUS_SEND_CANCEL");
            a((ShortVideoRealItemBuilder.Holder)localObject1);
            return;
            paramInt1 = ((MessageForShortVideo)localObject2).videoFileProgress;
            a((MessageRecord)localObject2, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
            a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, paramInt1, true);
            return;
            a((MessageRecord)localObject2, "VIDEO STATUS_RECV_START");
            a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, ((MessageForShortVideo)localObject2).videoFileProgress, true);
            return;
            a((MessageRecord)localObject2, "VIDEO STATUS_RECV_FINISHED");
            if (ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean)
            {
              paramFileMsg = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
              if (paramView.a(paramFileMsg))
              {
                a((MessageRecord)localObject2, "handleMessage: 刷视频 " + paramFileMsg);
                if ((ShortVideoUtils.a()) && (FileUtils.b(paramFileMsg)))
                {
                  localObject3 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt1;
                  ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt2;
                  ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                  ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                  localObject4 = new VideoDrawable.VideoDrawableParams();
                  ((VideoDrawable.VideoDrawableParams)localObject4).mPlayVideoFrame = true;
                  ((VideoDrawable.VideoDrawableParams)localObject4).mVideoRoundCorner = 0;
                  ((VideoDrawable.VideoDrawableParams)localObject4).mRequestedFPS = ShortVideoUtils.ShortVideoPlayConfig.jdField_a_of_type_Int;
                  ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = localObject4;
                  paramFileMsg = URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject3);
                  if (paramFileMsg.getStatus() != 1) {
                    break label719;
                  }
                  paramView.setURLDrawable(paramFileMsg);
                }
              }
              for (;;)
              {
                if (!((MessageForShortVideo)localObject2).isSend()) {
                  new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
                }
                a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, 100, true);
                return;
                paramView.setVideoDrawable(paramFileMsg);
              }
            }
            paramFileMsg = ShortVideoUtils.a(((MessageForShortVideo)localObject2).thumbMD5, "jpg");
            if (FileUtils.b(paramFileMsg))
            {
              if (!paramView.a(paramFileMsg)) {
                break label813;
              }
              localObject3 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt1;
              ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt2;
              ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              paramView.setURLDrawable(URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject3));
            }
            for (;;)
            {
              c((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1);
              return;
              paramFileMsg = paramView.jdField_b_of_type_ComTencentImageURLDrawable;
              if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1)) {
                paramView.setURLDrawable(paramFileMsg);
              }
            }
            a((MessageRecord)localObject2, "VIDEO STATUS_FILE_UNSAFE");
            a((ShortVideoRealItemBuilder.Holder)localObject1);
            if (((MessageForShortVideo)localObject2).uiOperatorFlag == 2)
            {
              ((ShortVideoRealItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371538, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
              return;
            }
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371527, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
            return;
            if (paramFileMsg.Z == 2005)
            {
              a((MessageRecord)localObject2, "VIDEO STATUS_RECV_ERROR");
              localObject3 = ShortVideoUtils.a(((MessageForShortVideo)localObject2).thumbMD5, "jpg");
              if (FileUtils.b((String)localObject3))
              {
                if (!paramView.a((String)localObject3)) {
                  break label1078;
                }
                a((MessageRecord)localObject2, "STATUS_FILE_EXPIRED: 刷缩略图 " + (String)localObject3);
                localObject4 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                paramView.setURLDrawable(URLDrawable.getDrawable(new File((String)localObject3), (URLDrawable.URLDrawableOptions)localObject4));
              }
            }
            for (;;)
            {
              if (paramFileMsg.Z != 2005) {
                break label1134;
              }
              a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, 2131367236);
              return;
              a((MessageRecord)localObject2, "VIDEO STATUS_FILE_EXPIRED");
              break;
              a((MessageRecord)localObject2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + (String)localObject3);
              localObject3 = paramView.jdField_b_of_type_ComTencentImageURLDrawable;
              if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1)) {
                paramView.setURLDrawable((URLDrawable)localObject3);
              }
            }
            a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, 2131367235);
            return;
            a((MessageRecord)localObject2, "VIDEO STATUS_RECV_CANCEL");
            return;
            paramInt1 = ((MessageForShortVideo)localObject2).videoFileProgress;
            a((MessageRecord)localObject2, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
            a((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1, paramInt1, true);
            return;
          } while ((paramFileMsg.e != 7) && (paramFileMsg.e != 18) && (paramFileMsg.e != 16));
          switch (paramFileMsg.Z)
          {
          default: 
            return;
          case 2001: 
            a((MessageRecord)localObject2, "THUMB STATUS_RECV_START");
            return;
          case 2003: 
            a((MessageRecord)localObject2, "THUMB STATUS_RECV_FINISHED");
            localObject3 = ShortVideoUtils.a(((MessageForShortVideo)localObject2).thumbMD5, "jpg");
            paramFileMsg = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
            if ((!FileUtils.b(paramFileMsg)) || (!ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean)) {
              break label1477;
            }
            if (!paramView.a(paramFileMsg)) {
              break label1454;
            }
            a((MessageRecord)localObject2, "STATUS_RECV_FINISHED: 刷缩略图视频存在 " + (String)localObject3);
          }
        } while (!ShortVideoUtils.a());
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localObject2 = new VideoDrawable.VideoDrawableParams();
        ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame = true;
        ((VideoDrawable.VideoDrawableParams)localObject2).mVideoRoundCorner = 0;
        ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = ShortVideoUtils.ShortVideoPlayConfig.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
        paramView.setURLDrawable(URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject1));
        return;
        paramFileMsg = paramView.jdField_b_of_type_ComTencentImageURLDrawable;
      } while ((paramFileMsg == null) || (paramFileMsg.getStatus() != 1));
      paramView.setURLDrawable(paramFileMsg);
      return;
      if (!FileUtils.b((String)localObject3)) {
        break;
      }
    } while (!paramView.a((String)localObject3));
    a((MessageRecord)localObject2, "STATUS_RECV_FINISHED: 刷缩略图 " + (String)localObject3);
    Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = paramInt1;
    ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = paramInt2;
    ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramView.setURLDrawable(URLDrawable.getDrawable(new File((String)localObject3), (URLDrawable.URLDrawableOptions)localObject4));
    if (!FileUtils.b(paramFileMsg))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForShortVideo)localObject2, true))
      {
        a((MessageForShortVideo)localObject2, true);
        return;
      }
      c((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1);
      return;
    }
    if (ShortVideoUtils.a())
    {
      a((ShortVideoRealItemBuilder.Holder)localObject1);
      return;
    }
    c((MessageForShortVideo)localObject2, (ShortVideoRealItemBuilder.Holder)localObject1);
    return;
    paramView.setImageDrawable(URLDrawableHelper.b);
    return;
    a((MessageRecord)localObject2, "THUMB STATUS_FILE_EXPIRED");
    a((MessageRecord)localObject2, "THUMB STATUS_RECV_ERROR");
    paramFileMsg = ShortVideoUtils.a((MessageForShortVideo)localObject2, "mp4");
    if (FileUtils.b(paramFileMsg)) {
      if (paramView.a(paramFileMsg))
      {
        a((MessageRecord)localObject2, "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + paramFileMsg);
        if (ShortVideoUtils.a())
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localObject3 = new VideoDrawable.VideoDrawableParams();
          ((VideoDrawable.VideoDrawableParams)localObject3).mPlayVideoFrame = true;
          ((VideoDrawable.VideoDrawableParams)localObject3).mVideoRoundCorner = 0;
          ((VideoDrawable.VideoDrawableParams)localObject3).mRequestedFPS = ShortVideoUtils.ShortVideoPlayConfig.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject3;
          paramView.setURLDrawable(URLDrawable.getDrawable(new File(paramFileMsg), (URLDrawable.URLDrawableOptions)localObject2));
        }
      }
    }
    for (;;)
    {
      a((ShortVideoRealItemBuilder.Holder)localObject1);
      return;
      paramFileMsg = paramView.jdField_b_of_type_ComTencentImageURLDrawable;
      if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1))
      {
        paramView.setURLDrawable(paramFileMsg);
        continue;
        paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  protected void a(ShortVideoRealItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set ProgressPieDrawable visible");
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.g);
    localShortVideoDownloadInfo.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
    localShortVideoDownloadInfo.jdField_h_of_type_Int = 2;
    localShortVideoDownloadInfo.k = 2;
    localShortVideoReq.a(localShortVideoDownloadInfo);
    localShortVideoReq.a(paramMessageForShortVideo);
    ShortVideoBusiManager.a(localShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131371517, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!FileUtils.b(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131371518, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    localObject = ShortVideoBusiManager.a(1, 2);
    ((ShortVideoReq)localObject).a(ShortVideoBusiManager.a(2, paramMessageForShortVideo, (ShortVideoReq)localObject));
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramHolder, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessageForShortVideo = a(paramMessageForShortVideo);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForShortVideo);
    paramMessageForShortVideo.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842963));
    paramMessageForShortVideo.e(0);
    paramMessageForShortVideo.f(true);
    paramMessageForShortVideo.b();
    paramMessageForShortVideo.h(0);
    paramMessageForShortVideo.d(false);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set ProgressPieDrawable visible,ppd = " + paramMessageForShortVideo);
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean)
  {
    paramMessageForShortVideo = a(paramMessageForShortVideo);
    paramMessageForShortVideo.b();
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramInt = ShortVideoUtils.a(paramInt, 10);
    if (paramBoolean) {
      paramMessageForShortVideo.d(paramInt);
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForShortVideo);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] set ProgressPieDrawable visible,p = " + paramInt + " current:" + paramMessageForShortVideo.a());
      }
      paramMessageForShortVideo.d(true);
      paramMessageForShortVideo.f(false);
      paramMessageForShortVideo.h(1426063360);
      paramMessageForShortVideo.a(String.valueOf(paramInt) + "%");
      return;
      paramMessageForShortVideo.e(paramInt);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    int i2 = 1;
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, "downloadVideo():短视频已过期不启动下载流程");
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label104;
      }
    }
    label104:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label110;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131368967, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return;
      i1 = 0;
      break;
    }
    label110:
    localObject = ShortVideoBusiManager.a(2, 2);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(((ShortVideoReq)localObject).g);
    localShortVideoDownloadInfo.jdField_h_of_type_JavaLangString = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
    i1 = i2;
    if (paramBoolean) {
      i1 = 2;
    }
    localShortVideoDownloadInfo.jdField_h_of_type_Int = i1;
    localShortVideoDownloadInfo.k = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localShortVideoDownloadInfo.g + ", uniseq:" + paramMessageForShortVideo.uniseq);
    }
    ((ShortVideoReq)localObject).a(localShortVideoDownloadInfo);
    ((ShortVideoReq)localObject).a(paramMessageForShortVideo);
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    do
    {
      do
      {
        return false;
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof BaseTransProcessor))
      {
        if (((BaseTransProcessor)paramBaseChatItemLayout).c() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003));
    return true;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str2;
    if ((!TextUtils.isEmpty(localMessageForShortVideo.md5)) && ((!localMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(localMessageForShortVideo.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      str2 = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if (FileUtils.b(str1)) {
        if ((paramView.jdField_a_of_type_AndroidWidgetImageView.getDrawable() != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null) || (paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getVisibility() != 0))) {
          break label221;
        }
      }
    }
    label221:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        localQQCustomMenu.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
        a(localMessageForShortVideo, localQQCustomMenu);
        if (FileUtils.b(str2)) {
          localQQCustomMenu.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131365886));
        }
      }
      if ((localMessageForShortVideo.isSend()) && (i1 == 0)) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
    }
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      a(paramMessageForShortVideo, "Forward menu clicked, md5 is empty.");
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
      QLog.d("ShortVideoRealItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
      localBundle.putString("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
    }
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
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    if (!FileUtils.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131371518, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      paramHolder = ShortVideoBusiManager.a(4, 2);
      paramHolder.a(ShortVideoBusiManager.a(2, paramMessageForShortVideo, paramHolder));
      ShortVideoBusiManager.a(paramHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  public void c()
  {
    super.c();
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessageForShortVideo = a(paramMessageForShortVideo);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageForShortVideo);
    paramMessageForShortVideo.setVisible(true, true);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showPauseProgress] set ProgressPieDrawable visible,ppd = " + paramMessageForShortVideo);
    }
    paramMessageForShortVideo.e(0);
    paramMessageForShortVideo.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841015));
    paramMessageForShortVideo.b();
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramMessageForShortVideo.d(false);
    paramMessageForShortVideo.f(true);
    paramMessageForShortVideo.h(0);
  }
  
  public void onClick(View paramView)
  {
    ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131296350) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131363475, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        return;
      }
      if (paramView.getId() != 2131296328) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    FlowCameraMqqAction.b("", "0X8006A1C");
    String str = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))
    {
      a(localMessageForShortVideo, false);
      a(localMessageForShortVideo, localHolder, localMessageForShortVideo.videoFileProgress, false);
      if (!localMessageForShortVideo.isSend()) {
        new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if (FileUtils.b(str))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ShortVideoRealItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */