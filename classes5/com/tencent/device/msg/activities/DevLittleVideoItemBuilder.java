package com.tencent.device.msg.activities;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewCallback;
import com.tencent.device.file.DeviceAVFileMsgObserver.DevMsgViewData;
import com.tencent.device.msg.data.DeviceMsgHandle;
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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.ChatVideoView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.EncodeTask;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import jzu;
import jzv;
import jzw;
import jzx;
import jzy;
import mqq.app.MobileQQ;

public class DevLittleVideoItemBuilder
  extends ShortVideoRealItemBuilder
  implements DeviceAVFileMsgObserver.DevMsgViewCallback
{
  private static final String aq = "DevLittleVideoItemBuilder";
  
  public DevLittleVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, MessageForShortVideo paramMessageForShortVideo, ImageView paramImageView, SessionInfo paramSessionInfo)
  {
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramMessageForShortVideo;
    Object localObject3 = paramMessageForShortVideo.videoFileName;
    Object localObject1 = paramMessageForShortVideo.mThumbFilePath;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      localObject2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localObject1 = localObject2;
      if (!FileUtils.b((String)localObject3))
      {
        localObject3 = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        localObject1 = localObject2;
      }
    }
    for (Object localObject2 = localObject3;; localObject2 = localObject3)
    {
      if (!ShortVideoUtils.a())
      {
        paramImageView = new Bundle();
        paramImageView.putInt("uintype", paramMessageForShortVideo.istroop);
        paramImageView.putString("from_uin", ShortVideoUtils.c(paramMessageForShortVideo));
        paramImageView.putInt("from_uin_type", paramSessionInfo.jdField_a_of_type_Int);
        paramImageView.putInt("from_busi_type", paramMessageForShortVideo.busiType);
        paramImageView.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
        paramImageView.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
        paramImageView.putString("file_name", paramMessageForShortVideo.videoFileName);
        paramImageView.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
        paramImageView.putString("file_send_path", (String)localObject2);
        paramImageView.putString("thumbfile_send_path", (String)localObject1);
        paramImageView.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
        paramImageView.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
        paramImageView.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
        paramImageView.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
        paramImageView.putString("file_source", paramMessageForShortVideo.fileSource);
        paramImageView.putString("file_uuid", paramMessageForShortVideo.uuid);
        paramImageView.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
        paramImageView.putInt("video_play_caller", 0);
        paramImageView.putLong("message_click_start", System.currentTimeMillis());
        paramMessageForShortVideo = new Intent(paramContext, ShortVideoPlayActivity.class);
        paramMessageForShortVideo.putExtras(paramImageView);
        paramContext.startActivity(paramMessageForShortVideo);
        return;
      }
      paramImageView = AnimationUtils.a(paramImageView);
      paramMessageForShortVideo = new Bundle();
      paramMessageForShortVideo.putParcelable("KEY_THUMBNAL_BOUND", paramImageView);
      if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity))) {
        paramMessageForShortVideo.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().f());
      }
      paramMessageForShortVideo.putBoolean("extra.IS_FROM_MULTI_MSG", false);
      paramImageView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramImageView.hasNext())
      {
        localObject3 = (ActivityManager.RunningAppProcessInfo)paramImageView.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith("mobileqq")) {
          paramMessageForShortVideo.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject3).pid);
        }
      }
      paramMessageForShortVideo.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      paramMessageForShortVideo.putString("uin", localMessageForDevLittleVideo.frienduin);
      paramImageView = new AIODevLittleVideoData();
      paramImageView.a = ((String)localObject1);
      paramImageView.b = ((String)localObject2);
      PeakUtils.a(paramContext, paramMessageForShortVideo, new AIOImageProviderService(localMessageForDevLittleVideo.selfuin, localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo), paramImageView, -1);
      return;
    }
  }
  
  private void a(ShortVideoRealItemBuilder.ChatVideoView paramChatVideoView, String paramString)
  {
    if (paramChatVideoView.a(paramString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramChatVideoView.setURLDrawable(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
    }
    do
    {
      return;
      paramString = paramChatVideoView.jdField_b_of_type_ComTencentImageURLDrawable;
    } while ((paramString == null) || (paramString.getStatus() != 1));
    paramChatVideoView.setURLDrawable(paramString);
  }
  
  private void a(ShortVideoRealItemBuilder.ChatVideoView paramChatVideoView, String paramString, int paramInt1, int paramInt2)
  {
    if (paramChatVideoView.a(paramString))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (paramInt1 > 0)
      {
        if (paramInt2 <= 0) {
          break label148;
        }
        label26:
        paramInt1 = AIOUtils.a(paramInt1, (Resources)localObject);
        paramInt2 = AIOUtils.a(paramInt2, (Resources)localObject);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
        localVideoDrawableParams.mPlayVideoFrame = true;
        localVideoDrawableParams.mVideoRoundCorner = 0;
        localVideoDrawableParams.mRequestedFPS = ShortVideoUtils.ShortVideoPlayConfig.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localVideoDrawableParams;
        paramString = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
        if (paramString.getStatus() != 1) {
          break label155;
        }
        paramChatVideoView.setURLDrawable(paramString);
      }
    }
    label148:
    label155:
    do
    {
      return;
      paramInt1 = 100;
      break;
      paramInt2 = 100;
      break label26;
      paramChatVideoView.setVideoDrawable(paramString);
      return;
      paramString = paramChatVideoView.jdField_b_of_type_ComTencentImageURLDrawable;
    } while ((paramString == null) || (paramString.getStatus() != 1));
    paramChatVideoView.setURLDrawable(paramString);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    View localView = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(localView, this);
    paramBaseChatItemLayout = null;
    paramView = (RelativeLayout)localView;
    int i = 0;
    paramOnLongClickAndTouchListener = null;
    if (i < paramView.getChildCount())
    {
      paramViewHolder = paramView.getChildAt(i);
      if ((paramViewHolder instanceof ShortVideoRealItemBuilder.ChatVideoView)) {
        paramOnLongClickAndTouchListener = (ShortVideoRealItemBuilder.ChatVideoView)paramViewHolder;
      }
      if (!(paramViewHolder instanceof LinearLayout)) {
        break label927;
      }
    }
    label182:
    label590:
    label924:
    label927:
    for (paramViewHolder = (LinearLayout)paramViewHolder;; paramViewHolder = paramBaseChatItemLayout)
    {
      i += 1;
      paramBaseChatItemLayout = paramViewHolder;
      break;
      Object localObject;
      BaseBubbleBuilder.ViewHolder localViewHolder;
      if (paramBaseChatItemLayout != null)
      {
        i = 0;
        paramViewHolder = null;
        paramView = null;
        localObject = paramView;
        localViewHolder = paramViewHolder;
        if (i >= paramBaseChatItemLayout.getChildCount()) {
          break label182;
        }
        localObject = paramBaseChatItemLayout.getChildAt(i);
        if (!(localObject instanceof ImageView)) {
          break label924;
        }
        paramView = (ImageView)localObject;
      }
      for (;;)
      {
        if ((localObject instanceof TextView)) {
          paramViewHolder = (TextView)localObject;
        }
        for (;;)
        {
          i += 1;
          break;
          localViewHolder = null;
          localObject = null;
          if ((paramOnLongClickAndTouchListener == null) || (localObject == null) || (localViewHolder == null)) {
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "DevLittleVideoItemBuilder:getBubbleView: enter invalid logic");
            }
          }
          do
          {
            do
            {
              do
              {
                return localView;
                paramView = new ShortVideoRealItemBuilder.Holder(this);
                paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView = paramOnLongClickAndTouchListener;
                paramView.jdField_a_of_type_AndroidWidgetTextView = localViewHolder;
                paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
                paramBaseChatItemLayout = (MessageForDevLittleVideo)paramChatMessage;
                paramOnLongClickAndTouchListener.jdField_b_of_type_Boolean = paramBaseChatItemLayout.isSend();
                if (!paramBaseChatItemLayout.isSendFromLocal()) {
                  break label590;
                }
                if ((paramBaseChatItemLayout.md5 != null) && (paramBaseChatItemLayout.md5.length() != 0)) {
                  break;
                }
                paramChatMessage = paramBaseChatItemLayout.mThumbFilePath;
                if (FileUtils.b(paramChatMessage))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: 占坑");
                  }
                  a(paramOnLongClickAndTouchListener, paramChatMessage);
                  a(paramBaseChatItemLayout, paramView, paramBaseChatItemLayout.videoFileProgress, false);
                  Utils.executeAsyncTaskOnSerialExcuter(new ShortVideoRealItemBuilder.EncodeTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout), new Void[] { (Void)null });
                  return localView;
                }
                paramOnLongClickAndTouchListener.setImageDrawable(URLDrawableHelper.b);
                ((ImageView)localObject).setVisibility(4);
              } while (!QLog.isColorLevel());
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView:You must get thumb before send video.");
              return localView;
              localObject = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
              paramViewHolder = paramBaseChatItemLayout.videoFileName;
              paramChatMessage = paramViewHolder;
              if (!FileUtils.b(paramViewHolder)) {
                paramChatMessage = ShortVideoUtils.a(paramBaseChatItemLayout, "mp4");
              }
              if (paramBaseChatItemLayout.videoFileStatus == 1003)
              {
                if ((ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean) && (ShortVideoUtils.a()) && (FileUtils.b(paramChatMessage)))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video send finished)");
                  }
                  a(paramOnLongClickAndTouchListener, paramChatMessage, paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
                  return localView;
                }
                if (QLog.isColorLevel()) {
                  QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video send finished)");
                }
                a(paramOnLongClickAndTouchListener, (String)localObject);
                return localView;
              }
              if (QLog.isColorLevel()) {
                QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb (video not send finished)");
              }
              a(paramOnLongClickAndTouchListener, (String)localObject);
            } while (paramBaseChatItemLayout.videoFileStatus != 1002);
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showProgress (video sending)");
            }
            a(paramBaseChatItemLayout, paramView, paramBaseChatItemLayout.videoFileProgress, false);
            return localView;
            paramChatMessage = paramBaseChatItemLayout.videoFileName;
            paramViewHolder = paramBaseChatItemLayout.mThumbFilePath;
            if (FileUtils.b(paramChatMessage))
            {
              if ((ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean) && (ShortVideoUtils.a()))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video recv finished)");
                }
                a(paramOnLongClickAndTouchListener, paramChatMessage, paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
                return localView;
              }
              if (FileUtils.b(paramViewHolder))
              {
                if (QLog.isColorLevel()) {
                  QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video recv finished)");
                }
                a(paramOnLongClickAndTouchListener, paramViewHolder);
                return localView;
              }
              c(paramBaseChatItemLayout);
              return localView;
            }
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showLoading(video not recv finished)");
            }
            paramOnLongClickAndTouchListener.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideo(video not recv finished)");
            }
            if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
            {
              paramOnLongClickAndTouchListener.setImageDrawable(URLDrawableHelper.b);
              paramBaseChatItemLayout.videoFileStatus = 2005;
              paramBaseChatItemLayout.videoFileProgress = 0;
              paramBaseChatItemLayout.serial();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.istroop, paramBaseChatItemLayout.uniseq, paramBaseChatItemLayout.msgData);
              return localView;
            }
          } while (paramBaseChatItemLayout.videoFileStatus != 2001);
          paramBaseChatItemLayout.videoFileStatus = 2002;
          paramBaseChatItemLayout.videoFileProgress = 0;
          paramBaseChatItemLayout.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.istroop, paramBaseChatItemLayout.uniseq, paramBaseChatItemLayout.msgData);
          a(paramBaseChatItemLayout, paramView, paramBaseChatItemLayout.videoFileProgress, false);
          if (!FileUtils.b(paramViewHolder))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideoThumb(video not recv finished)");
            }
            c(paramBaseChatItemLayout);
          }
          b(paramBaseChatItemLayout);
          return localView;
        }
      }
    }
  }
  
  protected void a(View paramView)
  {
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForDevLittleVideo.isSendFromLocal())
    {
      localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.a(2131367889, 5);
      localActionSheet.d(2131367262);
      localActionSheet.a(new jzu(this, localMessageForDevLittleVideo, paramView, localActionSheet));
      localActionSheet.show();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(2131367887, 5);
    localActionSheet.d(2131367262);
    localActionSheet.a(new jzv(this, localMessageForDevLittleVideo, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewData paramDevMsgViewData)
  {
    paramView = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq != paramDevMsgViewData.jdField_a_of_type_Long) {}
    MessageForDevLittleVideo localMessageForDevLittleVideo;
    ShortVideoRealItemBuilder.ChatVideoView localChatVideoView;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("DevLittleVideoItemBuilder", 2, "updateView msg.uniseq:" + paramDevMsgViewData.jdField_a_of_type_Long + " ===> fileStatus:" + ShortVideoUtils.b(paramDevMsgViewData.jdField_a_of_type_Int));
          }
          localChatVideoView = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView;
          i = (int)(paramDevMsgViewData.jdField_a_of_type_Float * 100.0F);
          switch (paramDevMsgViewData.jdField_a_of_type_Int)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_START progress " + localMessageForDevLittleVideo.videoFileProgress);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
        }
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        a(paramView);
      } while (!ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean);
      paramDevMsgViewData = localMessageForDevLittleVideo.videoFileName;
      paramView = paramDevMsgViewData;
      if (!FileUtils.b(paramDevMsgViewData)) {
        paramView = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
      }
    } while ((!ShortVideoUtils.a()) || (!FileUtils.b(paramView)));
    a(localChatVideoView, paramView, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    a();
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_PROCESS " + i);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    a(localMessageForDevLittleVideo, paramView, i, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
    }
    paramDevMsgViewData = localMessageForDevLittleVideo.videoFileName;
    String str = localMessageForDevLittleVideo.mThumbFilePath;
    if ((ShortVideoUtils.ShortVideoPlayConfig.jdField_b_of_type_Boolean) && (ShortVideoUtils.a()) && (FileUtils.b(paramDevMsgViewData)))
    {
      a(localChatVideoView, paramDevMsgViewData, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    }
    for (;;)
    {
      a(paramView);
      return;
      if (FileUtils.b(str))
      {
        a(localChatVideoView, str);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      else
      {
        localChatVideoView.setImageDrawable(URLDrawableHelper.b);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        a();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_PROCESS " + i);
    }
    a(localMessageForDevLittleVideo, paramView, i, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    localChatVideoView.setImageDrawable(URLDrawableHelper.b);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    a();
  }
  
  public void a(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new jzw(this, paramMessageForDevLittleVideo));
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramChatMessage = (MessageForDevLittleVideo)paramChatMessage;
    return (paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.videoFileStatus == 2005);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return paramView.a();
  }
  
  public void b(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new jzx(this, paramMessageForDevLittleVideo));
  }
  
  public void c(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new jzy(this, paramMessageForDevLittleVideo));
  }
  
  public void onClick(View paramView)
  {
    ShortVideoRealItemBuilder.Holder localHolder = (ShortVideoRealItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131296350) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131363475, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    if (paramView.getId() == 2131296328)
    {
      String str2 = localMessageForDevLittleVideo.videoFileName;
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      String str1 = str2;
      if (localMessageForDevLittleVideo.isSendFromLocal())
      {
        String str3 = ShortVideoUtils.a(localMessageForDevLittleVideo.thumbMD5, "jpg");
        paramView = str3;
        str1 = str2;
        if (!FileUtils.b(str2))
        {
          str1 = ShortVideoUtils.a(localMessageForDevLittleVideo, "mp4");
          paramView = str3;
        }
      }
      if (!FileUtils.b(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideo ");
        }
        b(localMessageForDevLittleVideo);
        return;
      }
      if (!FileUtils.b(paramView))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideoThumb ");
        }
        c(localMessageForDevLittleVideo);
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_AndroidContentContext, localMessageForDevLittleVideo, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$ChatVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\msg\activities\DevLittleVideoItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */