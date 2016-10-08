package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicContants;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nmx;
import nmy;
import nmz;

public class PicItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  public static long a = 0L;
  private static final String b = "PicItemBuilder";
  public static float c;
  static long c;
  public static float d;
  static long d;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static int h;
  public static int i;
  protected final float b;
  public long b;
  protected final boolean d;
  boolean h;
  boolean i = true;
  boolean j = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_h_of_type_Int = 100;
    jdField_a_of_type_Long = 1000L;
    c = 0.3F;
    jdField_d_of_type_Float = 1.0F;
    URLDrawableHelper.a();
    jdField_d_of_type_Long = 1000L;
  }
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, false);
  }
  
  public PicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_h_of_type_Boolean = false;
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public static Bitmap a()
  {
    Drawable localDrawable = URLDrawableHelper.c;
    if (localDrawable != null)
    {
      if ((localDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return a(paramContext, paramMessageForPic, null, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView)
  {
    return a(paramContext, paramMessageForPic, paramChatThumbView, null);
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt)
  {
    boolean bool2 = PeakUtils.a(paramMessageForPic.imageType);
    Object localObject1;
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000)) {
      if (!e)
      {
        localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name());
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 3)
          {
            f = localObject1[0].equals("1");
            g = localObject1[1].equals("1");
          }
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      int i3;
      try
      {
        jdField_h_of_type_Int = Integer.parseInt(localObject1[2]);
        if (jdField_h_of_type_Int < 0) {
          jdField_h_of_type_Int = 100;
        }
        com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = jdField_h_of_type_Int;
        e = true;
        if (!f) {
          break label1380;
        }
        localObject1 = URLDrawableHelper.a(paramMessageForPic, 1, null);
        localObject2 = AbsDownloader.a(((URL)localObject1).toString());
        if (localObject2 == null) {
          break label1380;
        }
        try
        {
          localObject2 = NativeGifImage.getImageSize((File)localObject2, false);
          bool1 = true;
        }
        catch (IOException localIOException)
        {
          localObject2 = null;
          bool1 = false;
          localResources = null;
          continue;
          localObject4 = AbsDownloader.a((String)localObject4);
          if (localObject4 == null) {
            break label814;
          }
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = URLDrawableHelper.a(paramMessageForPic, 65537, null);
        }
        localObject4 = ((URL)localObject3).toString();
        localObject1 = paramContext.getResources();
        i3 = ((Resources)localObject1).getDisplayMetrics().densityDpi;
        if (paramChatThumbView != null) {
          paramChatThumbView.jdField_a_of_type_Boolean = false;
        }
        if (BaseApplicationImpl.a.get(localObject4) != null)
        {
          paramChatThumbView = URLDrawableHelper.a((URL)localObject3, 0, 0, null, null, true, 12.0F * (i3 / 160));
          paramContext = paramChatThumbView;
          if (paramArrayOfInt != null)
          {
            paramArrayOfInt[0] = paramChatThumbView.getIntrinsicWidth();
            paramArrayOfInt[1] = paramChatThumbView.getIntrinsicHeight();
            paramContext = paramChatThumbView;
          }
          paramContext.setTag(paramMessageForPic);
          return paramContext;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        jdField_h_of_type_Int = 100;
        continue;
      }
      int m;
      int k;
      label337:
      int i1;
      int n;
      float f1;
      float f2;
      if (localObject2 != null)
      {
        m = ((Rect)localObject2).width();
        k = ((Rect)localObject2).height();
        i1 = URLDrawableHelper.c(bool2);
        n = URLDrawableHelper.d(bool2);
        f1 = i3 / 160 * 12.0F;
        if ((m >= n) && (k >= n)) {
          break label677;
        }
        if (m >= k) {
          break label631;
        }
        f2 = n / m;
        m = (int)(k * f2 + 0.5F);
        k = m;
        if (m > i1) {
          k = i1;
        }
        m = n;
        f1 = f2 * f1;
        label431:
        m = (m * i3 + 80) / 160;
        k = (k * i3 + 80) / 160;
        if (localObject2 == null) {
          break label1377;
        }
        if (((Rect)localObject2).width() >= m) {
          break label786;
        }
        f1 *= ((Rect)localObject2).width() / m;
      }
      label631:
      label677:
      label710:
      label774:
      label786:
      label814:
      label824:
      label909:
      label1046:
      label1103:
      label1110:
      label1156:
      label1197:
      label1261:
      label1273:
      label1328:
      label1369:
      label1377:
      for (;;)
      {
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt[0] = m;
          paramArrayOfInt[1] = k;
        }
        paramArrayOfInt = URLDrawableHelper.a((URL)localObject3, m, k, new EmptyDrawable(m, k), URLDrawableHelper.b, true, f1);
        paramArrayOfInt.setIgnorePause(true);
        paramArrayOfInt.setFadeInImage(true);
        paramContext = paramArrayOfInt;
        if (paramChatThumbView == null) {
          break;
        }
        paramChatThumbView.jdField_a_of_type_Boolean = true;
        paramContext = paramArrayOfInt;
        break;
        paramContext = new BitmapFactory.Options();
        paramContext.inJustDecodeBounds = true;
        ImageUtil.a(((File)localObject4).getAbsolutePath(), paramContext);
        m = paramContext.outWidth;
        k = paramContext.outHeight;
        n = URLDrawableHelper.a(((File)localObject4).getAbsolutePath());
        if ((n != 90) && (n != 270)) {
          break label337;
        }
        m = paramContext.outHeight;
        k = paramContext.outWidth;
        break label337;
        f2 = n / k;
        k = (int)(m * f2 + 0.5F);
        if (k > i1) {
          k = i1;
        }
        for (;;)
        {
          m = k;
          k = n;
          break;
        }
        if ((m < i1) && (k < i1)) {
          break label431;
        }
        if (m > k)
        {
          f2 = i1 / m;
          if (m <= k) {
            break label774;
          }
        }
        for (float f3 = n / k;; f3 = n / m)
        {
          f2 = Math.max(f2, f3);
          m = (int)(m * f2 + 0.5F);
          k = (int)(k * f2 + 0.5F);
          break;
          f2 = i1 / k;
          break label710;
        }
        if (((Rect)localObject2).height() < k)
        {
          f1 *= ((Rect)localObject2).height() / k;
          continue;
          int i2;
          if (!URLDrawableHelper.a(paramContext))
          {
            n = 1;
            k = URLDrawableHelper.c(bool2);
            m = URLDrawableHelper.d(bool2);
            i1 = paramMessageForPic.thumbWidth;
            i2 = paramMessageForPic.thumbHeight;
            if ((i1 <= 0) || (i2 <= 0)) {
              break label1273;
            }
            if ((i1 >= m) && (i2 >= m)) {
              break label1156;
            }
            if (i1 >= i2) {
              break label1110;
            }
            f1 = m / i1;
            i1 = (int)(i2 * f1 + 0.5F);
            if (i1 <= k) {
              break label1103;
            }
            f1 = i3 / 160.0F;
            m = (int)(m * f1 + 0.5F);
            k = (int)(k * f1 + 0.5F);
            paramContext = null;
            paramChatThumbView = URLDrawable.URLDrawableOptions.obtain();
            paramChatThumbView.mRequestWidth = m;
            paramChatThumbView.mRequestHeight = k;
            paramChatThumbView.mLoadingDrawable = URLDrawableHelper.a;
            paramChatThumbView.mFailedDrawable = URLDrawableHelper.b;
            paramChatThumbView.mPlayGifImage = bool1;
            paramChatThumbView.mGifRoundCorner = 12.0F;
            paramChatThumbView.mImgType = paramMessageForPic.imageType;
            if (paramArrayOfInt != null)
            {
              paramArrayOfInt[0] = m;
              paramArrayOfInt[1] = k;
            }
            if (!(URLDrawableHelper.a instanceof SkinnableBitmapDrawable)) {
              break label1328;
            }
            paramContext = new BitmapDrawableWithMargin(localResources, ((SkinnableBitmapDrawable)URLDrawableHelper.a).getBitmap(), m, k, -921103);
            if (paramContext != null) {
              paramChatThumbView.mLoadingDrawable = paramContext;
            }
            paramContext = URLDrawable.getDrawable((URL)localObject3, paramChatThumbView);
            if ((!PicContants.jdField_b_of_type_Boolean) && (n == 0)) {
              break label1369;
            }
            paramContext.setAutoDownload(true);
          }
          for (;;)
          {
            paramContext.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.a(), 0, false));
            break;
            n = 0;
            break label824;
            k = i1;
            break label909;
            i1 = (int)(m / i2 * i1 + 0.5F);
            if (i1 > k) {}
            for (;;)
            {
              i1 = k;
              k = m;
              m = i1;
              break;
              k = i1;
            }
            if ((i1 < k) && (i2 < k))
            {
              k = i2;
              m = i1;
              break label909;
            }
            if (i1 > i2)
            {
              f1 = k / i1;
              if (i1 <= i2) {
                break label1261;
              }
            }
            for (f2 = m / i2;; f2 = m / i1)
            {
              f1 = Math.max(f1, f2);
              m = (int)(i1 * f1 + 0.5F);
              k = (int)(f1 * i2 + 0.5F);
              break;
              f1 = k / i2;
              break label1197;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PicItemBuilder", 2, "MessageForPic without width/height of thumb, width = " + i1 + ", height = " + i2);
            }
            m = 99;
            k = 99;
            break label909;
            if (!(URLDrawableHelper.a instanceof BitmapDrawable)) {
              break label1046;
            }
            paramContext = new BitmapDrawableWithMargin(localResources, ((BitmapDrawable)URLDrawableHelper.a).getBitmap(), m, k, -921103);
            break label1046;
            paramContext.setAutoDownload(false);
          }
        }
      }
      label1380:
      Object localObject2 = null;
      boolean bool1 = false;
      Resources localResources = null;
    }
  }
  
  public static void a(Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    a(null, paramContext, paramView, paramChatMessage, paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo)
  {
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)))
    {
      int k = ((FragmentActivity)paramContext).getChatFragment().a().f();
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", k);
      if (k == 1)
      {
        paramView = (InputMethodManager)paramContext.getSystemService("input_method");
        if (paramView != null) {
          paramView.toggleSoftInput(1, 0);
        }
      }
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
      localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      str = paramChatMessage.selfuin;
      paramView = str;
      if (!paramChatMessage.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramView = str;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramView = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = str;
      }
    }
    localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("uin", paramChatMessage.frienduin);
    if ((paramChatMessage instanceof MessageForPic)) {
      PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), AIOGalleryUtils.a((MessageForPic)paramChatMessage), -1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PicItemBuilder", 2, "PicItemBuilder.enterImagePreview()");
      }
      return;
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break;
      if ((paramChatMessage instanceof MessageForTroopFile)) {
        PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage), AIOGalleryUtils.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1);
      }
    }
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2)
  {
    a(paramMessageForPic, paramString1, paramString2, null);
  }
  
  public static void a(MessageForPic paramMessageForPic, String paramString1, String paramString2, Throwable paramThrowable)
  {
    RichMediaUtil.a(paramMessageForPic.istroop, paramMessageForPic.isSendFromLocal(), 65537, String.valueOf(paramMessageForPic.uniseq), "PicItemBuilder." + paramString1, paramString2, paramThrowable);
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, PicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_AndroidViewView == null) {}
    int k;
    do
    {
      return;
      if (!(paramIHttpCommunicatorListener instanceof BaseTransProcessor)) {
        break;
      }
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      k = (int)paramIHttpCommunicatorListener.c();
      switch (k)
      {
      default: 
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
          ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
        }
        if (k == 1003) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        return;
      case 1006: 
        if ((paramIHttpCommunicatorListener.b()) && (!this.jdField_h_of_type_Boolean))
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
          {
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
            ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
            paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
      }
    } while (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.c = true;
    return;
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView == null)
    {
      MessageProgressTextView localMessageProgressTextView = new MessageProgressTextView(this.jdField_a_of_type_AndroidContentContext);
      localMessageProgressTextView.setTextColor(-1);
      int m = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
      localMessageProgressTextView.setTextSize(2, 15.0F);
      localMessageProgressTextView.setGravity(17);
      if (jdField_a_of_type_Boolean) {
        localMessageProgressTextView.setDisplayInTextView(false, m, -1);
      }
      localMessageProgressTextView.setBackgroundDrawable(new AIOSendMask(2130706432, this.jdField_b_of_type_Float * 12.0F));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131299762);
      localLayoutParams.addRule(8, 2131299762);
      localLayoutParams.addRule(5, 2131299762);
      localLayoutParams.addRule(7, 2131299762);
      ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).addView(localMessageProgressTextView, localLayoutParams);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = localMessageProgressTextView;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(paramIHttpCommunicatorListener);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
    if ((paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null) && ((1001 == k) || (1002 == k))) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.c = false;
    }
    if (k != 1002)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(true);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(0);
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
    paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.c();
    return;
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
      ((RelativeLayout)paramHolder.jdField_a_of_type_AndroidViewView).removeView(paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
      paramHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, URL paramURL)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    boolean bool2 = GeneralConfigUtils.a();
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isbigThumb false");
      }
      return false;
    }
    paramContext = AbsDownloader.d(paramURL.toString());
    if ((paramContext != null) && (paramContext.endsWith("_big400"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("t_gif", 2, "needShowGifTag isgif=" + paramBoolean1 + "isthumb=" + paramBoolean2 + "w=" + paramInt1 + "h=" + paramInt2 + "==100*density=" + 100.0F * f1 + "isbugThumb=" + bool2 + "isthumb400=" + bool1);
      }
      if ((!paramBoolean1) || (!paramBoolean2) || (paramInt1 < 100.0F * f1) || (paramInt2 < f1 * 100.0F) || (!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
  }
  
  private void b(MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.a(paramMessageForPic.path);
    localBuilder.d(5);
    localBuilder.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localBuilder.c(TranDbRecord.PicDbRecord.f);
    }
    for (;;)
    {
      localBuilder.e(paramMessageForPic.senderuin);
      localBuilder.c(paramMessageForPic.selfuin);
      localBuilder.e(paramMessageForPic.istroop);
      localBuilder.j = paramMessageForPic.extLong;
      localBuilder.i = paramMessageForPic.extStr;
      PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
      localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
      localRetryInfo.b = paramMessageForPic.shmsgseq;
      localRetryInfo.jdField_a_of_type_Long = paramMessageForPic.msgseq;
      localBuilder.a(localRetryInfo);
      paramMessageForPic = PicBusiManager.a(4, 5);
      paramMessageForPic.a(localBuilder.a());
      PicBusiManager.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localBuilder.c(TranDbRecord.PicDbRecord.e);
    }
  }
  
  private void c(MessageForPic paramMessageForPic)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof BaseUploadProcessor)))
    {
      ((BaseUploadProcessor)localObject1).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new PicFowardInfo();
    Object localObject2 = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject2).d(1009);
    ((PicUploadInfo.Builder)localObject2).a(paramMessageForPic.path);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.istroop);
    ((PicUploadInfo.Builder)localObject2).c(paramMessageForPic.selfuin);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.senderuin);
    ((PicUploadInfo.Builder)localObject2).d(paramMessageForPic.frienduin);
    ((PicUploadInfo.Builder)localObject2).j = paramMessageForPic.extLong;
    ((PicUploadInfo.Builder)localObject2).i = paramMessageForPic.extStr;
    ((PicUploadInfo.Builder)localObject2).c(TranDbRecord.PicDbRecord.g);
    ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = ((PicUploadInfo.Builder)localObject2).a();
    if ((!FileUtils.b(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof PicFowardDbRecordData)))
    {
      localObject2 = (PicFowardDbRecordData)paramMessageForPic.picExtraObject;
      PicDownloadInfo.Builder localBuilder = new PicDownloadInfo.Builder();
      localBuilder.a(1009);
      localBuilder.a(paramMessageForPic.selfuin);
      localBuilder.b(((PicFowardDbRecordData)localObject2).jdField_a_of_type_JavaLangString);
      localBuilder.b(((PicFowardDbRecordData)localObject2).jdField_a_of_type_Int);
      localBuilder.d(((PicFowardDbRecordData)localObject2).b);
      localBuilder.a(((PicFowardDbRecordData)localObject2).jdField_a_of_type_Long);
      localBuilder.e(paramMessageForPic.md5);
      localBuilder.f(paramMessageForPic.issend);
      ((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = localBuilder.a();
    }
    paramMessageForPic = PicBusiManager.a(3, 1009);
    paramMessageForPic.a((PicFowardInfo)localObject1);
    PicBusiManager.a(paramMessageForPic, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (MessageForPic)paramChatMessage;
    boolean bool = PeakUtils.a(paramBaseChatItemLayout.imageType);
    try
    {
      paramChatMessage = (PicItemBuilder.Holder)paramViewHolder;
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
        paramView.setId(2131299762);
        paramView.setAdjustViewBounds(true);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject);
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramView;
        paramViewHolder.setOnClickListener(this);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      }
      paramView = paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
      int k = URLDrawableHelper.a(bool);
      int m = URLDrawableHelper.b(bool);
      paramView.setMaxWidth(k);
      paramView.setMaxHeight(k);
      paramView.setMinimumWidth(m);
      paramView.setMinimumHeight(m);
      if (jdField_b_of_type_Boolean) {
        paramView.setContentDescription("图片");
      }
      paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramView != null) {
        paramView.a(paramViewHolder, this);
      }
      if (paramBaseChatItemLayout.isSendFromLocal()) {
        break label696;
      }
      if (paramChatMessage.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView != null)
      {
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.clearAnimation();
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProcessor(null);
        ((RelativeLayout)paramChatMessage.jdField_a_of_type_AndroidViewView).removeView(paramChatMessage.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView);
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = null;
      }
      paramOnLongClickAndTouchListener = URLDrawableHelper.a(paramBaseChatItemLayout, 65537);
      localObject = new int[2];
      Object tmp260_258 = localObject;
      tmp260_258[0] = 0;
      Object tmp264_260 = tmp260_258;
      tmp264_260[1] = 0;
      tmp264_260;
      if ((paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramOnLongClickAndTouchListener)))
      {
        if (paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          QLog.d("tdrawable", 2, "holder.d=" + paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + paramOnLongClickAndTouchListener);
        }
        paramView = a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, (int[])localObject);
        paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramView);
        paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout, 2);
        if (paramView == null) {
          QLog.d("tdrawable", 2, "d==null");
        }
        if (paramView == null) {
          break label676;
        }
        paramView = paramView.getURL().getProtocol();
        if (QLog.isColorLevel()) {
          QLog.d("big_thumb", 2, "getview protocol=" + paramView + "isDynamic=" + tmp264_260 + "thumbWidth=" + paramBaseChatItemLayout.thumbWidth + "thumbHeight=" + paramBaseChatItemLayout.thumbHeight);
        }
        long l1 = System.currentTimeMillis();
        if (!a(this.jdField_a_of_type_AndroidContentContext, tmp264_260, paramView.equals("chatthumb"), localObject[0], localObject[1], paramOnLongClickAndTouchListener)) {
          break label666;
        }
        paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkDrawable(a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(0);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("big_thumb", 2, "getview setGifTag  costTime= " + (l2 - l1));
        }
        return paramViewHolder;
      }
    }
    catch (Exception paramChatMessage)
    {
      for (;;)
      {
        Object localObject;
        QLog.e("PicItemBuilder", 2, "picitem holer Exception e= " + paramChatMessage);
        paramChatMessage = null;
        continue;
        paramView = paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable;
        localObject[0] = paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.getWidth();
        localObject[1] = paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.getHeight();
      }
      label666:
      paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
      return paramViewHolder;
    }
    label676:
    paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
    QLog.d("tdrawable", 2, "not isDynamic tag gone");
    return paramViewHolder;
    label696:
    if (paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
    }
    paramView = URLDrawableHelper.a(paramBaseChatItemLayout, 65537);
    if ((paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
    {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
      paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramView);
      paramChatMessage.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq);
    paramChatMessage.jdField_a_of_type_AndroidViewView = paramViewHolder;
    a(paramView, paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PicItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出图片";
    }
    return "发来图片";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject;
    String str;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForPic)))
    {
      localObject = (MessageForPic)paramChatMessage;
      if (paramInt != 2131297425) {
        break label862;
      }
      paramContext = new Bundle();
      paramContext.putInt("forward_type", 1);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtra("forward_image_width", ((MessageForPic)localObject).width);
      paramChatMessage.putExtra("forward_image_height", ((MessageForPic)localObject).height);
      paramChatMessage.putExtra("forward_file_size", ((MessageForPic)localObject).size);
      paramChatMessage.putExtra("forward_image_type", ((MessageForPic)localObject).imageType);
      paramChatMessage.putExtra("forward_filepath", ((MessageForPic)localObject).path);
      str = ((MessageForPic)localObject).frienduin + ((MessageForPic)localObject).uniseq + ((MessageForPic)localObject).istroop;
      paramChatMessage.putExtra("BUSI_TYPE", 1009);
      paramChatMessage.putExtra("forward_download_image_task_key", str);
      paramChatMessage.putExtra("forward_download_image_org_uin", ((MessageForPic)localObject).frienduin);
      paramChatMessage.putExtra("forward_download_image_org_uin_type", ((MessageForPic)localObject).istroop);
      paramChatMessage.putExtra("forward_download_image_server_path", ((MessageForPic)localObject).uuid);
      paramChatMessage.putExtra("forward_download_image_item_id", ((MessageForPic)localObject).uniseq);
      paramChatMessage.putExtra("forward_photo_isSend", ((MessageForPic)localObject).issend);
      paramChatMessage.putExtra("forward_photo_md5", ((MessageForPic)localObject).md5);
      paramChatMessage.putExtra("forward_photo_group_fileid", ((MessageForPic)localObject).groupFileID);
      paramChatMessage.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", ((MessageForPic)localObject).fileSizeFlag);
      paramChatMessage.putExtras(paramContext);
      if ((!ActionMsgUtil.a(((MessageForPic)localObject).msgtype)) && (((MessageForPic)localObject).msgtype != 62535) && (((MessageForPic)localObject).msgtype != 35534) && (((MessageForPic)localObject).msgtype != 35533)) {
        break label754;
      }
      paramInt = 1;
      if (paramInt != 0) {
        break label759;
      }
      paramInt = 65537;
      label347:
      paramContext = URLDrawableHelper.a((PicUiInterface)localObject, paramInt);
      paramChatMessage.putExtra("forward_urldrawable", true);
      paramChatMessage.putExtra("forward_urldrawable_thumb_url", paramContext.toString());
      paramChatMessage.putExtra("FORWARD_URL_KEY", ((MessageForPic)localObject).localUUID);
      paramContext = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject);
      paramChatMessage.putExtra("forward_urldrawable_big_url", paramContext.getURL().toString());
      paramChatMessage.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      paramChatMessage.putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      paramChatMessage.putExtra("PhotoConst.MY_NICK", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b());
      if ((((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment() != null)) {
        paramChatMessage.putExtra("isBack2Root", ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().jdField_h_of_type_Boolean);
      }
      paramChatMessage.putExtra("is_anonymous", AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) {
        break label764;
      }
      paramChatMessage.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      paramChatMessage = AIOUtils.a(paramChatMessage, null);
      label566:
      paramChatMessage.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramChatMessage.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      paramChatMessage.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramChatMessage.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      paramChatMessage.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1009);
      paramChatMessage.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      paramChatMessage.addFlags(603979776);
      paramChatMessage.putExtra("FORWARD_MSG_FOR_PIC", (Parcelable)localObject);
      if (!new File(((MessageForPic)localObject).path).exists()) {
        break label781;
      }
      paramChatMessage.putExtra("forward_extra", ((MessageForPic)localObject).path);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      paramChatMessage.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "3", "", "", "");
    }
    label754:
    label759:
    label764:
    label781:
    label862:
    label1439:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramInt = 0;
            break;
            paramInt = 1;
            break label347;
            paramChatMessage.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
            break label566;
            str = null;
            paramContext = paramContext.getURL().toString();
            if (AbsDownloader.a(paramContext)) {
              paramContext = AbsDownloader.a(paramContext).getAbsolutePath();
            }
            for (;;)
            {
              paramChatMessage.putExtra("forward_extra", paramContext);
              break;
              localObject = AbsDownloader.a(URLDrawableHelper.a((PicUiInterface)localObject, 65537).toString());
              paramContext = str;
              if (localObject != null)
              {
                paramContext = str;
                if (((File)localObject).exists()) {
                  paramContext = ((File)localObject).getAbsolutePath();
                }
              }
            }
            if (paramInt == 2131296309)
            {
              paramContext = URLDrawableHelper.a(URLDrawableHelper.a((PicUiInterface)localObject, 1), -1, -1, null, null, false);
              paramContext.setTag(localObject);
              AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, ((MessageForPic)localObject).frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908), null);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
              return;
            }
            if (paramInt == 2131305401)
            {
              ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "3", "", "", "");
              return;
            }
            if (paramInt == 2131305411)
            {
              super.b(paramChatMessage);
              return;
            }
            if (paramInt == 2131305405)
            {
              a((MessageForPic)localObject);
              return;
            }
            if (paramInt == 2131299841)
            {
              QfavBuilder.a((Entity)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
              return;
            }
            if (paramInt == 2131305403)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              a();
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409A", "0X800409A", 0, 0, "", "", "", "");
              return;
            }
            if (paramInt == 2131305404)
            {
              paramContext = new nmx(this);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramContext);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800409B", "0X800409B", 0, 0, "", "", "", "");
              return;
            }
            if (paramInt == 2131305410)
            {
              super.b(paramChatMessage);
              return;
            }
            if (paramInt == 2131296353)
            {
              super.a(paramChatMessage);
              return;
            }
            if (paramInt != 2131305419) {
              break label1491;
            }
          } while (paramChatMessage.istroop != 1);
          paramContext = ((MessageForPic)localObject).getPicDownloadInfo();
          PicBusiManager.a(6, 1536, 1).a((MessageForPic)localObject, paramContext);
          paramContext = AbsDownloader.d(URLDrawableHelper.a((PicUiInterface)localObject, 1, null).toString().toString());
          if (!FileUtils.a(paramContext)) {
            break label1439;
          }
          paramChatMessage = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
        } while ((paramChatMessage == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
        paramChatMessage.a(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (ChatMessage)localObject, paramContext, 4);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_talk", "", "pub_talk", "Clk_bubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "2", "", "");
      } while (!QLog.isColorLevel());
      QLog.d("PicItemBuilder", 2, "image has downloaded!");
      return;
      paramContext = AIOGalleryUtils.a((MessageForPic)localObject);
    } while (paramContext == null);
    paramChatMessage = new WeakReference(new nmy(this, paramContext, (MessageForPic)localObject));
    TroopTopicMgr.a((MessageForPic)localObject, paramContext.f, paramContext.k, 2, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    return;
    label1491:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForPic)((PicItemBuilder.Holder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (!paramView.isSendFromLocal());
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(2131367889, 5);
    localActionSheet.d(2131367262);
    localActionSheet.a(new nmz(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (PicItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView == null) {
      QLog.e("PicItemBuilder", 2, "handleMessage(): holder is null");
    }
    label183:
    label449:
    label451:
    label471:
    for (;;)
    {
      return;
      MessageForPic localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
      {
        QLog.e("PicItemBuilder", 2, "handleMessage(): holder.mMessage is null");
        return;
      }
      if ((paramInt1 == 2003) && (paramFileMsg.e == 65537))
      {
        boolean bool = PeakUtils.a(localMessageForPic.imageType);
        int k = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.getWidth();
        int m = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.getHeight();
        String str = paramView.jdField_a_of_type_ComTencentImageURLDrawable.getURL().getProtocol();
        URL localURL = URLDrawableHelper.a(localMessageForPic, 65537);
        if (a(this.jdField_a_of_type_AndroidContentContext, bool, str.equals("chatthumb"), k, m, localURL))
        {
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkDrawable(a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(0);
        }
      }
      else
      {
        if (((paramFileMsg.e != 1) && (paramFileMsg.e != 131075)) || (paramInt1 == 2002) || (paramInt1 == 2001)) {
          break label449;
        }
        if ((paramInt1 != 1001) && (paramInt1 != 1000) && (paramInt1 != 4001) && (paramInt1 != 1002) && (paramInt1 != 1004) && (paramInt1 != 1005)) {
          break label451;
        }
      }
      for (this.i = false;; this.i = true) {
        do
        {
          if (localMessageForPic.uniseq != paramFileMsg.c) {
            break label471;
          }
          a(localMessageForPic, "transf.in", "status:" + paramInt1 + ",retCode" + paramInt2 + "message.uniseq：" + localMessageForPic.uniseq + ",file.uniseq:" + paramFileMsg.c);
          if (localMessageForPic.isSendFromLocal())
          {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq), paramView);
            if (paramInt1 == 1005) {
              a();
            }
          }
          if (paramInt1 != 2003) {
            break;
          }
          paramFileMsg = a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramFileMsg);
          paramView.jdField_a_of_type_ComTencentImageURLDrawable = paramFileMsg;
          if (paramView.jdField_a_of_type_ComTencentImageURLDrawable == null) {
            break;
          }
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          return;
          paramView.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          break label183;
          break;
        } while ((paramInt1 != 1007) && (paramInt1 != 1003));
      }
    }
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    if (FileUtils.b(paramMessageForPic.path)) {
      b(paramMessageForPic);
    }
    for (;;)
    {
      a();
      return;
      if (paramMessageForPic.picExtraFlag == TranDbRecord.PicDbRecord.g) {
        c(paramMessageForPic);
      }
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = true;
    if (paramChatMessage.isMultiMsg) {}
    while (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    if (paramChatMessage.size <= 0L)
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramChatMessage instanceof BaseTransProcessor))
      {
        long l = ((BaseTransProcessor)paramChatMessage).c();
        if ((l == 1005L) || ((l == 1006L) && (!this.jdField_h_of_type_Boolean)) || (l == 1004L)) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      return true;
    }
    if (paramChatMessage.extraflag == 32768) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    Object localObject = (PicItemBuilder.Holder)AIOUtils.a(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((PicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    boolean bool = URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext, localMessageForPic, 65537);
    paramView = new QQCustomMenu();
    this.jdField_h_of_type_Boolean = true;
    if (!localMessageForPic.isSendFromLocal())
    {
      if (((PicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
      {
        if (AIOUtils.a(1) == 1) {
          paramView.a(2131296309, this.jdField_a_of_type_AndroidContentContext.getString(2131370095));
        }
        if (bool)
        {
          paramView.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
          if ((localMessageForPic.istroop == 1) && (AIOUtils.a(4) == 1)) {
            paramView.a(2131305419, this.jdField_a_of_type_AndroidContentContext.getString(2131365195));
          }
        }
        a(localMessageForPic, paramView);
        if (AIOUtils.a(5) == 1) {
          paramView.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131365886));
        }
        if (localMessageForPic.isSend()) {
          a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
        }
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
      }
      return paramView.a();
    }
    if (localMessageForPic.size > 0L)
    {
      if (AIOUtils.a(1) == 1) {
        paramView.a(2131296309, this.jdField_a_of_type_AndroidContentContext.getString(2131370095));
      }
      if (bool)
      {
        paramView.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
        if ((localMessageForPic.istroop == 1) && (AIOUtils.a(4) == 1)) {
          paramView.a(2131305419, this.jdField_a_of_type_AndroidContentContext.getString(2131365195));
        }
      }
      if (AIOUtils.a(5) == 1) {
        paramView.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131365886));
      }
      if ((localMessageForPic.isSend()) && (localMessageForPic.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForPic))) {
        a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPic);
      }
      ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return paramView.a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq);
      if ((localObject instanceof BaseTransProcessor))
      {
        localObject = (BaseTransProcessor)localObject;
        long l = ((BaseTransProcessor)localObject).c();
        if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (((BaseTransProcessor)localObject).d() == 1003L))
        {
          if (AIOUtils.a(1) == 1) {
            paramView.a(2131296309, this.jdField_a_of_type_AndroidContentContext.getString(2131370095));
          }
          if (bool) {
            paramView.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
          }
          if (AIOUtils.a(5) == 1) {
            paramView.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131365886));
          }
          ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
        }
        else
        {
          paramView.a(2131305403, this.jdField_a_of_type_AndroidContentContext.getString(2131367893));
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            paramView.a(2131305404, this.jdField_a_of_type_AndroidContentContext.getString(2131367894));
          }
          this.j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        if (AIOUtils.a(1) == 1) {
          paramView.a(2131296309, this.jdField_a_of_type_AndroidContentContext.getString(2131370095));
        }
        if (bool) {
          paramView.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
        }
        if (AIOUtils.a(5) == 1) {
          paramView.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131365886));
        }
        ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  public void c()
  {
    super.c();
    if (this.j)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.j = false;
    }
    this.jdField_h_of_type_Boolean = false;
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.l = true;
    if (super.a()) {}
    MessageForPic localMessageForPic;
    do
    {
      do
      {
        return;
        if (paramView.getId() != 2131296328) {
          break label281;
        }
        paramView = (PicItemBuilder.Holder)AIOUtils.a(paramView);
        localMessageForPic = (MessageForPic)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
        if (localMessageForPic.isSendFromLocal()) {
          break;
        }
        switch (((URLDrawable)localObject).getStatus())
        {
        default: 
          return;
        }
      } while (((URLDrawable)localObject).isDownloadStarted());
      ((URLDrawable)localObject).startDownload();
      return;
      if ((Utils.b()) && (Utils.b() < 20971520L))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "手机存储空间已满，请清理后重新进入QQ。", 0).a();
        return;
      }
    } while (!FileUtils.a(this.jdField_a_of_type_AndroidContentContext));
    ((URLDrawable)localObject).restartDownload();
    return;
    Object localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      ((TroopHandler)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    return;
    if (((URLDrawable)localObject).getStatus() == 2)
    {
      if ((Utils.b()) && (Utils.b() < 20971520L))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "手机存储空间已满，请清理后重试。", 0).a();
        return;
      }
      if (FileUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    a(this.jdField_a_of_type_AndroidContentContext, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, localMessageForPic, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    return;
    label281:
    super.onClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\PicItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */