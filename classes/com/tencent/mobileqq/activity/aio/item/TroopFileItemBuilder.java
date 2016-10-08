package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.troop.TroopFileProxyActivity;
import cooperation.troop.TroopProxyActivity;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import nqy;
import nqz;
import nra;
import nrb;
import nrc;

public class TroopFileItemBuilder
  extends BaseBubbleBuilder
{
  public static final String b;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  static int h;
  static int i = h * 9 / 16;
  public static int j = 100;
  public View.OnClickListener a;
  public Handler b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = TroopFileItemBuilder.class.getSimpleName();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    int k = localBaseApplication.getResources().getDimensionPixelSize(2131493058);
    h = (int)(localDisplayMetrics.widthPixels - DisplayUtils.a(localBaseApplication, 40.0F) * 2.0F - BaseChatItemLayout.w - BaseChatItemLayout.x - k * 2 - DisplayUtils.a(localBaseApplication, 10.0F));
    if (h > 640) {
      h = 640;
    }
  }
  
  public TroopFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nqz(this);
  }
  
  static Drawable a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return new BitmapDrawableWithMargin(BaseApplicationImpl.a().getResources(), null, paramInt2, paramInt3, -921103);
    }
    Object localObject;
    if (paramInt1 == 1) {
      localObject = URLDrawableHelper.a;
    }
    for (;;)
    {
      if ((localObject instanceof SkinnableBitmapDrawable))
      {
        localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
        return new BitmapDrawableWithMargin(BaseApplicationImpl.a().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        if (paramInt1 == 2) {
          localObject = URLDrawableHelper.b;
        }
      }
      else
      {
        if ((localObject instanceof BitmapDrawable))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          return new BitmapDrawableWithMargin(BaseApplicationImpl.a().getResources(), (Bitmap)localObject, paramInt2, paramInt3, -921103);
        }
        return null;
      }
      localObject = null;
    }
  }
  
  public static Drawable a(Context paramContext, TroopFileStatusInfo paramTroopFileStatusInfo, MessageForTroopFile paramMessageForTroopFile, int[] paramArrayOfInt)
  {
    String str = paramTroopFileStatusInfo.d;
    if (paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString != null) {}
    int k;
    int n;
    float f1;
    for (paramMessageForTroopFile = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;; paramMessageForTroopFile = str)
    {
      k = PeakUtils.a(paramMessageForTroopFile);
      paramMessageForTroopFile = paramContext.getResources();
      n = paramMessageForTroopFile.getDisplayMetrics().densityDpi;
      f1 = 12.0F * (n / 160.0F);
      if ((k != 3) && (k != 2000)) {
        break label591;
      }
      paramContext = (Drawable)BaseApplicationImpl.a.get(str);
      if ((paramContext == null) || (!(paramContext instanceof GifDrawable))) {
        break;
      }
      return paramContext;
    }
    if (paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString != null)
    {
      paramTroopFileStatusInfo = new File(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
      try
      {
        paramContext = NativeGifImage.getImageSize(paramTroopFileStatusInfo, false);
        arrayOfInt = a(paramContext.right, paramContext.bottom);
        paramContext.right = (arrayOfInt[0] / (n / 160));
        paramContext.bottom = (arrayOfInt[1] / (n / 160));
        try
        {
          paramTroopFileStatusInfo = NativeGifFactory.getNativeGifObject(paramTroopFileStatusInfo, false, false, paramContext.width(), paramContext.height(), 12.0F);
          if (paramTroopFileStatusInfo == null) {
            break label249;
          }
          paramContext = new GifDrawable(paramTroopFileStatusInfo, paramMessageForTroopFile);
          BaseApplicationImpl.a.put(str, paramContext);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          f1 = 12.0F;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          int[] arrayOfInt;
        }
      }
      paramContext.printStackTrace();
    }
    label249:
    label588:
    label591:
    for (;;)
    {
      paramTroopFileStatusInfo = new File(str);
      paramContext = null;
      if (BaseApplicationImpl.a.get(str) != null)
      {
        return (Drawable)BaseApplicationImpl.a.get(str);
        paramContext = a(1, paramContext.width(), paramContext.height());
        return paramContext;
      }
      if (!paramTroopFileStatusInfo.exists()) {
        break;
      }
      paramContext = new BitmapFactory.Options();
      paramContext.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramTroopFileStatusInfo.getAbsolutePath(), paramContext);
      int m = paramContext.outWidth;
      k = paramContext.outHeight;
      int i1 = URLDrawableHelper.a(paramTroopFileStatusInfo.getAbsolutePath());
      if ((i1 == 90) || (i1 == 270))
      {
        m = paramContext.outHeight;
        k = paramContext.outWidth;
      }
      arrayOfInt = a(m, k);
      k = arrayOfInt[0];
      m = arrayOfInt[1];
      if (paramArrayOfInt != null)
      {
        paramArrayOfInt[0] = k;
        paramArrayOfInt[1] = m;
      }
      try
      {
        paramContext.inJustDecodeBounds = false;
        paramContext = BitmapFactory.decodeFile(paramTroopFileStatusInfo.getAbsolutePath(), paramContext);
        paramContext.setDensity(n);
        if (((paramContext.getWidth() == k) && (paramContext.getHeight() == m)) || (paramContext.getWidth() == 0) || (paramContext.getHeight() == 0)) {
          break label588;
        }
        paramTroopFileStatusInfo = new Matrix();
        paramTroopFileStatusInfo.setScale(k / paramContext.getWidth(), m / paramContext.getHeight());
        paramTroopFileStatusInfo = Bitmap.createBitmap(paramContext, 0, 0, paramContext.getWidth(), paramContext.getHeight(), paramTroopFileStatusInfo, false);
        paramTroopFileStatusInfo.setDensity(n);
        paramContext.recycle();
        paramContext = paramTroopFileStatusInfo;
        paramTroopFileStatusInfo = new BitmapDrawable(paramMessageForTroopFile, ImageUtil.b(paramContext, f1, k, m));
        paramContext.recycle();
        BaseApplicationImpl.a.put(str, paramTroopFileStatusInfo);
        return paramTroopFileStatusInfo;
      }
      catch (OutOfMemoryError paramMessageForTroopFile)
      {
        paramTroopFileStatusInfo = a(1, k, m);
        paramContext = paramTroopFileStatusInfo;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(jdField_b_of_type_JavaLangString, 2, "getThumbDrawable, OOM", paramMessageForTroopFile);
        return paramTroopFileStatusInfo;
      }
      catch (Exception paramMessageForTroopFile)
      {
        paramTroopFileStatusInfo = a(1, k, m);
        paramContext = paramTroopFileStatusInfo;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_b_of_type_JavaLangString, 2, "getThumbDrawable, exp", paramMessageForTroopFile);
      return paramTroopFileStatusInfo;
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2)
  {
    int m;
    int k;
    if (paramInt1 <= 383)
    {
      m = paramInt1;
      k = paramInt2;
      if (paramInt2 <= 383) {}
    }
    else
    {
      m = paramInt1;
      k = paramInt2;
      if (paramInt1 != 0)
      {
        m = paramInt1;
        k = paramInt2;
        if (paramInt2 != 0) {
          if (paramInt1 <= paramInt2) {
            break label99;
          }
        }
      }
    }
    int[] arrayOfInt;
    label99:
    for (float f1 = 'ſ' / paramInt1;; f1 = 'ſ' / paramInt2)
    {
      m = (int)(paramInt1 * f1);
      k = (int)(f1 * paramInt2);
      arrayOfInt = new int[2];
      if ((m != 0) && (k != 0)) {
        break;
      }
      arrayOfInt[0] = i;
      arrayOfInt[1] = i;
      return arrayOfInt;
    }
    if ((m < i) || (k < i)) {
      if (m < k)
      {
        f1 = i / m;
        m = i;
        k = (int)(f1 * k + 0.5F);
        paramInt1 = k;
        paramInt2 = m;
        if (k > h)
        {
          paramInt1 = h;
          paramInt2 = m;
        }
      }
    }
    for (;;)
    {
      arrayOfInt[0] = paramInt2;
      arrayOfInt[1] = paramInt1;
      return arrayOfInt;
      paramInt2 = (int)(i / k * m + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > h) {
        paramInt1 = h;
      }
      k = i;
      paramInt2 = paramInt1;
      paramInt1 = k;
      continue;
      if ((m < h) && (k < h))
      {
        paramInt2 = m;
        paramInt1 = k;
      }
      else
      {
        if (m > k)
        {
          f1 = h / m;
          label278:
          if (m <= k) {
            break label396;
          }
        }
        label396:
        for (float f2 = i / k;; f2 = i / m)
        {
          f1 = Math.max(f1, f2);
          paramInt1 = (int)(m * f1 + 0.5F);
          k = (int)(f1 * k + 0.5F);
          paramInt2 = paramInt1;
          if (paramInt1 < i) {
            paramInt2 = i;
          }
          paramInt1 = paramInt2;
          if (paramInt2 > h) {
            paramInt1 = h;
          }
          paramInt2 = k;
          if (k < i) {
            paramInt2 = i;
          }
          if (paramInt2 <= h) {
            break label408;
          }
          k = h;
          paramInt2 = paramInt1;
          paramInt1 = k;
          break;
          f1 = h / k;
          break label278;
        }
        label408:
        k = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = k;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    if (!b(paramChatMessage)) {
      return a(paramView, paramChatMessage);
    }
    return b(paramView, paramChatMessage);
  }
  
  public View a(Context paramContext, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramContext).inflate(2130905058, null);
    }
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localView;
  }
  
  public View a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    nrc localnrc = (nrc)paramViewGroup.getTag();
    localnrc.jdField_b_of_type_AndroidViewView.setVisibility(0);
    localnrc.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = localnrc.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    ((ViewGroup.LayoutParams)localObject).height = -2;
    localnrc.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (localnrc.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      localnrc.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localnrc.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131296331);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      if (!paramChatMessage.isSend()) {
        break label436;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131296318);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131296328);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131296328);
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.addView(localnrc.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
      localObject = null;
      if (localnrc.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
        localObject = localnrc.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      }
      localObject = a(this.jdField_a_of_type_AndroidContentContext, (View)localObject);
      localnrc.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131305148));
      localnrc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131305147));
      localnrc.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      localnrc.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject, localLayoutParams);
      a(localnrc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, localnrc);
      localnrc.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.h;
      if (jdField_b_of_type_Boolean) {}
      try
      {
        localnrc.jdField_b_of_type_JavaLangStringBuilder.append(localnrc.jdField_a_of_type_AndroidWidgetTextView.getText()).append(" ");
        localnrc.jdField_b_of_type_JavaLangStringBuilder.append(localnrc.jdField_b_of_type_AndroidWidgetTextView.getText());
        localnrc.jdField_b_of_type_JavaLangStringBuilder.append(localnrc.jdField_c_of_type_AndroidWidgetTextView.getText());
        localnrc.jdField_b_of_type_JavaLangStringBuilder.append("按钮");
        paramViewGroup.setContentDescription(localnrc.jdField_b_of_type_JavaLangStringBuilder.toString());
        return paramViewGroup;
      }
      catch (Exception paramChatMessage) {}
      paramViewGroup.removeView(localnrc.jdField_a_of_type_AndroidWidgetLinearLayout);
      break;
      label436:
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131296318);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
    }
    return paramViewGroup;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (nrc)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903170, null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296388));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296389));
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131296390));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramChatMessage.findViewById(2131296386));
      paramViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramChatMessage.findViewById(2131296391));
      paramViewHolder.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramChatMessage.findViewById(2131297478));
      paramViewHolder.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramChatMessage.findViewById(2131297479));
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramChatMessage.findViewById(2131297476);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131297477);
      paramViewHolder.jdField_c_of_type_AndroidViewView.setMinimumWidth(i);
      paramViewHolder.jdField_c_of_type_AndroidViewView.setMinimumHeight(i);
      paramViewHolder.jdField_d_of_type_AndroidViewView = paramChatMessage.findViewById(2131300576);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramChatMessage.findViewById(2131300577));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
      paramViewHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131300578));
      paramViewHolder.jdField_e_of_type_AndroidViewView = paramChatMessage.findViewById(2131297480);
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131297481));
      paramViewHolder.f = ((TextView)paramChatMessage.findViewById(2131297482));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle = ((ProgressCircle)paramChatMessage.findViewById(2131297484));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.jdField_a_of_type_Boolean = false;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.c = 3;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.jdField_b_of_type_Boolean = true;
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.jdField_a_of_type_Int = -1;
      ((RelativeLayout.LayoutParams)paramViewHolder.jdField_d_of_type_AndroidViewView.getLayoutParams()).addRule(12);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramChatMessage.findViewById(2131297483));
      paramView = new AIOSendMask(2130706432, this.a_ * 12.0F);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(paramView);
    }
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new nrc(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出文件";
    }
    return "发来文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    Object localObject2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      do
      {
        do
        {
          int k;
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
                    do
                    {
                      do
                      {
                        return;
                        localObject1 = (MessageForTroopFile)paramChatMessage;
                        localObject1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject1);
                      } while (localObject1 == null);
                      k = NetworkUtil.a((Activity)paramContext);
                      localObject3 = new TroopFileItemOperation(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramContext);
                      switch (paramInt)
                      {
                      case 2131305412: 
                      case 2131305413: 
                      case 2131305414: 
                      case 2131305415: 
                      case 2131305416: 
                      case 2131305417: 
                      case 2131305418: 
                      case 2131305419: 
                      case 2131305420: 
                      case 2131305421: 
                      case 2131305422: 
                      case 2131305423: 
                      case 2131305424: 
                      case 2131305425: 
                      case 2131305426: 
                      case 2131305427: 
                      case 2131305429: 
                      default: 
                        super.a(paramInt, paramContext, paramChatMessage);
                        return;
                      case 2131305430: 
                        if (k == 0)
                        {
                          TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131364197));
                          return;
                        }
                        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_pause_download", 0, 0, "", paramChatMessage.frienduin, "", "");
                      }
                    } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 8);
                    ((TroopFileTransferManager)localObject2).f(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                    return;
                    if (k == 0)
                    {
                      TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131364197));
                      return;
                    }
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", paramChatMessage.frienduin, "", "");
                  } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 0) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 1));
                  ((TroopFileTransferManager)localObject2).c(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                  return;
                } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 9);
                ((TroopFileItemOperation)localObject3).b(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
                return;
              } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 2);
              ((TroopFileItemOperation)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
              return;
            } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 8) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 9) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 10));
            ((TroopFileTransferManager)localObject2).f(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
            a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long, (Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
            return;
            if (k == 0)
            {
              TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131364197));
              return;
            }
          } while ((((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 1) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 0) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 2) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 3));
          ((TroopFileTransferManager)localObject2).c(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
          a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long, (Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID, paramChatMessage);
          return;
          if (k == 0)
          {
            TroopFileError.a(paramContext, this.jdField_a_of_type_AndroidContentContext.getString(2131364197));
            return;
          }
          paramContext = new Bundle();
          paramContext.putInt("forward_type", 0);
          localObject2 = FileManagerUtil.a((TroopFileStatusInfo)localObject1);
          ((FileManagerEntity)localObject2).status = 2;
          ((FileManagerEntity)localObject2).nOpType = 24;
          localObject3 = new ForwardFileInfo();
          ((ForwardFileInfo)localObject3).b(((FileManagerEntity)localObject2).nSessionId);
          ((ForwardFileInfo)localObject3).b(10006);
          if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).getFilePath())) {
            ((ForwardFileInfo)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
          }
          ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).g);
          ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long);
          ((ForwardFileInfo)localObject3).a(Long.parseLong(paramChatMessage.frienduin));
          if (((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
            ((ForwardFileInfo)localObject3).e(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
          }
          ((ForwardFileInfo)localObject3).d(1);
          ((ForwardFileInfo)localObject3).a(1);
          paramContext.putParcelable("fileinfo", (Parcelable)localObject3);
          paramContext.putBoolean("not_forward", true);
          paramChatMessage = new Intent();
          paramChatMessage.putExtras(paramContext);
          paramChatMessage.putExtra("forward_text", ((TroopFileStatusInfo)localObject1).g);
          paramChatMessage.putExtra("forward_from_troop_file", true);
          paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
          paramChatMessage.putExtra("forward _key_nojump", true);
          ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
          return;
          TroopFileUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          return;
          FileManagerUtil.a((Activity)paramContext, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
          return;
        } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 3);
        ((TroopFileItemOperation)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
        return;
      } while (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 10);
      ((TroopFileItemOperation)localObject3).b(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down__start_download", 0, 0, "", paramChatMessage.frienduin, "", "");
    } while ((localObject1 != null) && (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int != 7));
    ((TroopFileItemOperation)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_e_of_type_JavaLangString, ((TroopFileStatusInfo)localObject1).g, ((TroopFileStatusInfo)localObject1).jdField_b_of_type_Long, ((TroopFileStatusInfo)localObject1).jdField_e_of_type_Int);
    return;
    TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    return;
    paramContext = FileManagerUtil.a((TroopFileStatusInfo)localObject1);
    Object localObject1 = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopFileStatusInfo)localObject1).jdField_a_of_type_Long).a(paramContext.strTroopFilePath);
    if (localObject1 != null)
    {
      paramContext.lastTime = ((TroopFileInfo)localObject1).c;
      paramContext.selfUin = String.valueOf(((TroopFileInfo)localObject1).jdField_b_of_type_Long);
    }
    new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage, false);
    return;
    super.b(paramChatMessage);
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new nra(this, paramLong, paramUUID, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131364180), this.jdField_a_of_type_AndroidContentContext.getString(2131364225), 2131364145, 2131364146, paramUUID, paramUUID).show();
  }
  
  public void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new nrb(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131364179), this.jdField_a_of_type_AndroidContentContext.getString(2131364226), 2131364143, 2131364144, paramUUID, paramUUID).show();
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    a((View)paramView.getParent(), true);
  }
  
  void a(View paramView, boolean paramBoolean)
  {
    Context localContext = paramView.getContext();
    Activity localActivity = (Activity)localContext;
    Intent localIntent = new Intent();
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)localChatMessage;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, localChatMessage.frienduin + "", "", "", "");
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(localChatMessage.frienduin));
    boolean bool = b(localChatMessage);
    if (localTroopFileStatusInfo.jdField_b_of_type_Boolean)
    {
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131364741, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      }
      do
      {
        return;
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID == null) {
          break;
        }
        paramView = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      } while (paramView == null);
      localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 383);
      paramView.ThumbnailDownloading_Middle_Fail = false;
      paramView.ThumbnailFileTimeMS_Middle = 0L;
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(paramView.getInfo(Long.parseLong(localChatMessage.frienduin)));
      return;
      localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_e_of_type_Int, 383);
      return;
    }
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
    case 3: 
      if ((paramBoolean) || (!bool))
      {
        localIntent.putExtra(TroopProxyActivity.jdField_a_of_type_JavaLangString, localChatMessage.frienduin);
        TroopFileProxyActivity.b(localActivity, localIntent);
        return;
      }
    case 1: 
    case 2: 
      if (!bool)
      {
        localIntent.putExtra(TroopProxyActivity.jdField_a_of_type_JavaLangString, localChatMessage.frienduin);
        TroopFileProxyActivity.b(localActivity, localIntent);
        return;
      }
      paramView = paramView.findViewById(2131297478);
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext, paramView, localMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
      paramView = paramView.findViewById(2131297478);
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext, paramView, localMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      if (!bool)
      {
        new TroopFileItemOperation(Long.valueOf(localMessageForTroopFile.frienduin).longValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localActivity).a(localTroopFileStatusInfo, localMessageForTroopFile.senderuin, localMessageForTroopFile.lastTime, 3);
        return;
      }
      paramView = paramView.findViewById(2131297478);
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localContext, paramView, localMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    TroopFileError.a(localActivity, String.format(localActivity.getString(2131364217), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.g) }));
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, ChatMessage paramChatMessage, nrc paramnrc)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    localMessageForTroopFile.doParse();
    if (!localMessageForTroopFile.bReported)
    {
      localMessageForTroopFile.bReported = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_appear_AIO", 0, 0, "", paramChatMessage.frienduin, "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 4, "Build TroopFileItem");
      }
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 4, "get fileStatusInfo fail ");
      }
      return;
    }
    paramnrc.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    paramnrc.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
    paramnrc.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopFileStatusInfo.g);
    boolean bool2 = false;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    Object localObject = "";
    boolean bool1;
    int n;
    int m;
    int k;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      bool1 = bool2;
      n = i1;
      m = i2;
      k = i3;
      label244:
      if (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
      {
        i1 = 1;
        label264:
        if (n == 0) {
          break label1028;
        }
        paramnrc.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(m);
        paramnrc.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label286:
        if (k == 0) {
          break label1040;
        }
        paramnrc.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramnrc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        label308:
        paramnrc.jdField_b_of_type_AndroidWidgetTextView.setText(FileUtil.a(localTroopFileStatusInfo.jdField_b_of_type_Long));
        paramBaseChatItemLayout.setFailedIconVisable(bool1, this);
        paramBaseChatItemLayout = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
        if (localTroopFileStatusInfo.jdField_b_of_type_JavaLangString != null) {
          break label1078;
        }
        FileManagerUtil.a(paramnrc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.g);
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID == null) {
          break label1052;
        }
        paramBaseChatItemLayout.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 128);
        label386:
        if (i1 == 0) {
          break label1142;
        }
        paramnrc.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (paramnrc.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
          paramnrc.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(0);
        }
        paramnrc.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramnrc.jdField_d_of_type_AndroidWidgetTextView.setText("群文件");
      }
      break;
    }
    while (FontSettingManager.a() > 17.0F)
    {
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramnrc.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramnrc.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label1154;
      }
      paramnrc.jdField_b_of_type_AndroidWidgetTextView.setGravity(5);
      paramBaseChatItemLayout.addRule(3, 2131296388);
      paramBaseChatItemLayout.addRule(2, 2131296390);
      paramBaseChatItemLayout.addRule(7, 2131296388);
      return;
      n = 1;
      m = 0;
      localObject = "上传中";
      k = 1;
      bool1 = bool2;
      break label244;
      String str = "未下载";
      localObject = str;
      k = i3;
      m = i2;
      n = i1;
      bool1 = bool2;
      if (localMessageForTroopFile.msgtype != 63519) {
        break label244;
      }
      if (localMessageForTroopFile.extraflag != 32772)
      {
        localObject = str;
        k = i3;
        m = i2;
        n = i1;
        bool1 = bool2;
        if (localMessageForTroopFile.extraflag != 32768) {
          break label244;
        }
      }
      localObject = str;
      k = i3;
      m = i2;
      n = i1;
      bool1 = bool2;
      if (!localMessageForTroopFile.isSendFromLocal()) {
        break label244;
      }
      localObject = str;
      k = i3;
      m = i2;
      n = i1;
      bool1 = bool2;
      if (!TextUtils.isEmpty(localMessageForTroopFile.FromUin)) {
        break label244;
      }
      localObject = str;
      k = i3;
      m = i2;
      n = i1;
      bool1 = bool2;
      if (!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString)) {
        break label244;
      }
      c(paramChatMessage);
      localObject = str;
      k = i3;
      m = i2;
      n = i1;
      bool1 = bool2;
      break label244;
      localObject = "未下载";
      c(paramChatMessage);
      k = i3;
      m = i2;
      n = i1;
      bool1 = bool2;
      break label244;
      localObject = "上传中";
      k = 1;
      n = 1;
      m = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break label244;
      localObject = "下载中";
      n = 1;
      m = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      k = i3;
      bool1 = bool2;
      break label244;
      k = 1;
      localObject = "已暂停";
      n = 1;
      m = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break label244;
      k = 1;
      localObject = "已暂停";
      n = 1;
      m = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
      bool1 = bool2;
      break label244;
      localObject = "已上传";
      k = 1;
      m = i2;
      n = i1;
      bool1 = bool2;
      break label244;
      localObject = "已下载";
      k = 1;
      m = i2;
      n = i1;
      bool1 = bool2;
      break label244;
      localObject = "失败";
      bool1 = true;
      k = i3;
      m = i2;
      n = i1;
      break label244;
      localObject = "失败";
      bool1 = true;
      k = i3;
      m = i2;
      n = i1;
      break label244;
      localObject = "已取消";
      k = i3;
      m = i2;
      n = i1;
      bool1 = bool2;
      break label244;
      localObject = "转发中";
      k = 1;
      m = i2;
      n = i1;
      bool1 = bool2;
      break label244;
      i1 = 0;
      break label264;
      label1028:
      paramnrc.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break label286;
      label1040:
      paramnrc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label308;
      label1052:
      paramBaseChatItemLayout.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_e_of_type_Int, 128);
      break label386;
      label1078:
      if ((TextUtils.isEmpty(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)) || (!FileUtils.a(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString)))
      {
        FileManagerUtil.a(paramnrc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.g);
        break label386;
      }
      FileManagerUtil.a(paramnrc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localTroopFileStatusInfo.g);
      paramnrc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localTroopFileStatusInfo.jdField_b_of_type_JavaLangString);
      break label386;
      label1142:
      paramnrc.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1154:
    paramnrc.jdField_b_of_type_AndroidWidgetTextView.setGravity(3);
    paramBaseChatItemLayout.addRule(3, -1);
    paramBaseChatItemLayout.addRule(2, -1);
    paramBaseChatItemLayout.addRule(12);
    paramBaseChatItemLayout.addRule(5, 2131296388);
  }
  
  void a(nrc paramnrc, int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, long paramLong)
  {
    int m = paramInt - (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F) * 2;
    String str;
    if (paramLong > 1048576L) {
      str = String.format("%.2fM", new Object[] { Float.valueOf((float)paramLong / 1048576.0F) });
    }
    Object localObject;
    TextPaint localTextPaint2;
    TextPaint localTextPaint1;
    float f2;
    float f1;
    for (;;)
    {
      paramnrc.jdField_e_of_type_AndroidWidgetTextView.setText(str);
      localObject = paramnrc.jdField_d_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = paramInt;
      paramnrc.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextPaint2 = paramnrc.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getPaint();
      localTextPaint1 = paramnrc.jdField_e_of_type_AndroidWidgetTextView.getPaint();
      f2 = localTextPaint1.measureText(str) + DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      localObject = paramTroopFileStatusInfo.g;
      f1 = localTextPaint2.measureText((String)localObject);
      paramInt = (int)Math.ceil(f1 / m);
      if (f1 - (int)localTextPaint2.measureText("哈") < m) {
        paramInt = 1;
      }
      if (paramInt != 1) {
        break;
      }
      for (;;)
      {
        k = paramInt;
        paramTroopFileStatusInfo = (TroopFileStatusInfo)localObject;
        if (f1 <= m - f2) {
          break;
        }
        k = paramInt;
        paramTroopFileStatusInfo = (TroopFileStatusInfo)localObject;
        if (((String)localObject).length() <= 2) {
          break;
        }
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2) + "…";
        f1 = localTextPaint2.measureText((String)localObject);
      }
      if (paramLong > 1024L) {
        str = String.format("%.2fK", new Object[] { Float.valueOf((float)paramLong / 1024.0F) });
      } else {
        str = String.format("%d字节", new Object[] { Long.valueOf(paramLong) });
      }
    }
    int k = paramInt;
    paramTroopFileStatusInfo = (TroopFileStatusInfo)localObject;
    if (paramInt >= 2) {}
    for (;;)
    {
      k = paramInt;
      paramTroopFileStatusInfo = (TroopFileStatusInfo)localObject;
      if (f1 > m * 2 - f2)
      {
        k = paramInt;
        paramTroopFileStatusInfo = (TroopFileStatusInfo)localObject;
        if (((String)localObject).length() > 2)
        {
          paramTroopFileStatusInfo = ((String)localObject).substring(0, ((String)localObject).length() - 2) + "…";
          f1 = localTextPaint2.measureText(paramTroopFileStatusInfo);
          paramInt = (int)Math.ceil(f1 / m);
          if (paramInt != 1) {
            break label600;
          }
          localObject = paramTroopFileStatusInfo;
          for (;;)
          {
            k = paramInt;
            paramTroopFileStatusInfo = (TroopFileStatusInfo)localObject;
            if (f1 <= m - f2) {
              break;
            }
            k = paramInt;
            paramTroopFileStatusInfo = (TroopFileStatusInfo)localObject;
            if (((String)localObject).length() <= 2) {
              break;
            }
            localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2) + "…";
            f1 = localTextPaint2.measureText((String)localObject);
          }
        }
      }
      paramnrc.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(paramTroopFileStatusInfo);
      paramTroopFileStatusInfo = (RelativeLayout.LayoutParams)paramnrc.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
      if (k == 1)
      {
        paramTroopFileStatusInfo.width = ((int)(m - localTextPaint1.measureText(str)));
        paramnrc.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramTroopFileStatusInfo);
      }
      for (;;)
      {
        paramnrc.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getViewTreeObserver().addOnGlobalLayoutListener(new nqy(this, paramnrc, paramTroopFileStatusInfo, m, localTextPaint1, str));
        return;
        if (k == 2)
        {
          paramTroopFileStatusInfo.width = -2;
          paramnrc.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramTroopFileStatusInfo);
        }
      }
      label600:
      localObject = paramTroopFileStatusInfo;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    paramView = (MessageForTroopFile)localChatMessage;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (localTroopFileStatusInfo == null)
    {
      localQQCustomMenu.a(2131305441, this.jdField_a_of_type_AndroidContentContext.getString(2131364172));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
      return localQQCustomMenu.a();
    }
    Boolean localBoolean = Boolean.valueOf(false);
    paramView = localBoolean;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      paramView = localBoolean;
    case 4: 
    case 5: 
    case 12: 
      if (paramView.booleanValue()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      return localQQCustomMenu.a();
      localQQCustomMenu.a(2131305431, this.jdField_a_of_type_AndroidContentContext.getString(2131364163));
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131305433, this.jdField_a_of_type_AndroidContentContext.getString(2131364164));
      localQQCustomMenu.a(2131305435, this.jdField_a_of_type_AndroidContentContext.getString(2131364166));
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131305439, this.jdField_a_of_type_AndroidContentContext.getString(2131364170));
      localQQCustomMenu.a(2131305435, this.jdField_a_of_type_AndroidContentContext.getString(2131364166));
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = Boolean.valueOf(true);
      break;
      localQQCustomMenu.a(2131305430, this.jdField_a_of_type_AndroidContentContext.getString(2131364163));
      localQQCustomMenu.a(2131305436, this.jdField_a_of_type_AndroidContentContext.getString(2131364167));
      a(localChatMessage, localQQCustomMenu);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131305442, this.jdField_a_of_type_AndroidContentContext.getString(2131364173));
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131305437, this.jdField_a_of_type_AndroidContentContext.getString(2131364168));
      }
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131305432, this.jdField_a_of_type_AndroidContentContext.getString(2131364164));
      localQQCustomMenu.a(2131305434, this.jdField_a_of_type_AndroidContentContext.getString(2131364165));
      localQQCustomMenu.a(2131305436, this.jdField_a_of_type_AndroidContentContext.getString(2131364167));
      a(localChatMessage, localQQCustomMenu);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131305442, this.jdField_a_of_type_AndroidContentContext.getString(2131364173));
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131305437, this.jdField_a_of_type_AndroidContentContext.getString(2131364168));
      }
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131305440, this.jdField_a_of_type_AndroidContentContext.getString(2131364171));
      localQQCustomMenu.a(2131305434, this.jdField_a_of_type_AndroidContentContext.getString(2131364165));
      a(localChatMessage, localQQCustomMenu);
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131305436, this.jdField_a_of_type_AndroidContentContext.getString(2131364167));
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131305442, this.jdField_a_of_type_AndroidContentContext.getString(2131364173));
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131305437, this.jdField_a_of_type_AndroidContentContext.getString(2131364168));
      }
      if (AIOUtils.a(2) == 1) {
        localQQCustomMenu.a(2131305428, this.jdField_a_of_type_AndroidContentContext.getString(2131362204));
      }
      a(localChatMessage, localQQCustomMenu);
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = Boolean.valueOf(true);
      break;
      if (!FileUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))
      {
        TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(localChatMessage.frienduin)).b();
        paramView = localBoolean;
        break;
      }
      if ((!TextUtils.isEmpty(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (FileUtils.e(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) {
        localQQCustomMenu.a(2131305438, this.jdField_a_of_type_AndroidContentContext.getString(2131364169));
      }
      localQQCustomMenu.a(2131305436, this.jdField_a_of_type_AndroidContentContext.getString(2131364167));
      a(localChatMessage, localQQCustomMenu);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131305442, this.jdField_a_of_type_AndroidContentContext.getString(2131364173));
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131305437, this.jdField_a_of_type_AndroidContentContext.getString(2131364168));
      }
      if (AIOUtils.a(2) == 1) {
        localQQCustomMenu.a(2131305428, this.jdField_a_of_type_AndroidContentContext.getString(2131362204));
      }
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = localBoolean;
      break;
      localQQCustomMenu.a(2131305441, this.jdField_a_of_type_AndroidContentContext.getString(2131364172));
      localQQCustomMenu.a(2131305436, this.jdField_a_of_type_AndroidContentContext.getString(2131364167));
      a(localChatMessage, localQQCustomMenu);
      if (AIOUtils.a(5) == 1) {
        localQQCustomMenu.a(2131305442, this.jdField_a_of_type_AndroidContentContext.getString(2131364173));
      }
      if (AIOUtils.a(3) == 1) {
        localQQCustomMenu.a(2131305437, this.jdField_a_of_type_AndroidContentContext.getString(2131364168));
      }
      localQQCustomMenu.a(2131305411, this.jdField_a_of_type_AndroidContentContext.getString(2131368039));
      paramView = localBoolean;
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", localChatMessage.frienduin, "", "");
    }
  }
  
  public View b(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    nrc localnrc = (nrc)paramViewGroup.getTag();
    localnrc.jdField_b_of_type_AndroidViewView.setVisibility(8);
    localnrc.jdField_c_of_type_AndroidViewView.setVisibility(0);
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    localMessageForTroopFile.doParse();
    if (!localMessageForTroopFile.bReported)
    {
      localMessageForTroopFile.bReported = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_appear_AIO", 0, 0, "", paramChatMessage.frienduin, "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 4, "Build TroopFileItem");
      }
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 4, "get fileStatusInfo fail ");
      }
      return paramViewGroup;
    }
    Object localObject1 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
    Object localObject2 = a(localMessageForTroopFile.width, localMessageForTroopFile.height);
    int k = localObject2[0];
    int m = localObject2[1];
    int i1 = 0;
    long l = NetConnInfoCenter.getServerTime();
    int n = i1;
    if (localMessageForTroopFile.lastTime != 0L)
    {
      n = i1;
      if (localMessageForTroopFile.lastTime <= l) {
        n = 1;
      }
    }
    boolean bool1 = false;
    boolean bool2 = false;
    if (n == 0)
    {
      bool1 = bool2;
      if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null)
      {
        localObject2 = (TroopFileTransferManager.Item)((TroopFileTransferManager)localObject1).b.get(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        bool1 = bool2;
        if (localObject2 != null) {
          bool1 = ((TroopFileTransferManager.Item)localObject2).ThumbnailDownloading_Middle;
        }
      }
      if (localTroopFileStatusInfo.d == null) {
        if (localTroopFileStatusInfo.jdField_b_of_type_Boolean)
        {
          localnrc.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localnrc.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(a(2, k, m));
        }
      }
    }
    label319:
    label412:
    label523:
    label537:
    label573:
    label596:
    label618:
    label1307:
    label1319:
    label1331:
    label1343:
    label1355:
    label1367:
    label1379:
    for (;;)
    {
      int i2;
      int i3;
      int i4;
      switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
      {
      default: 
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        if (m != 0)
        {
          localnrc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
          localnrc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i4);
          localnrc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.c();
          localObject1 = localnrc.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getDrawable();
          if (localObject1 != null)
          {
            m = ((Drawable)localObject1).getIntrinsicWidth();
            int i5 = ((Drawable)localObject1).getIntrinsicHeight();
            k = m;
            if (m != 0)
            {
              k = m;
              if (i5 != 0)
              {
                localObject1 = localnrc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject1).width = m;
                ((ViewGroup.LayoutParams)localObject1).height = i5;
                localnrc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                k = m;
              }
            }
          }
          if (i3 == 0) {
            break label1307;
          }
          localnrc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          if (i2 == 0) {
            break label1343;
          }
          localnrc.jdField_e_of_type_AndroidViewView.setVisibility(0);
          if (TextUtils.isEmpty(paramChatMessage)) {
            break label1319;
          }
          localnrc.f.setVisibility(0);
          localnrc.f.setText(paramChatMessage);
          if (i1 == -1) {
            break label1331;
          }
          localnrc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localnrc.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i1);
          if (n == 0) {
            break label1355;
          }
          localnrc.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.setVisibility(0);
          localnrc.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.setProgress(i4);
          if (!bool1) {
            break label1367;
          }
          localnrc.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        a(localnrc, k, localTroopFileStatusInfo, localMessageForTroopFile.fileSize);
        paramChatMessage = localnrc.jdField_a_of_type_AndroidViewView.getLayoutParams();
        paramChatMessage.width = -2;
        paramChatMessage.height = -2;
        localnrc.jdField_a_of_type_AndroidViewView.setLayoutParams(paramChatMessage);
        if (localnrc.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
          break;
        }
        localnrc.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return paramViewGroup;
        localnrc.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(a(1, k, m));
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
          ((TroopFileTransferManager)localObject1).a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, 383);
        }
        for (;;)
        {
          bool1 = true;
          break;
          ((TroopFileTransferManager)localObject1).a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_e_of_type_Int, 383);
        }
        if ((TextUtils.isEmpty(localTroopFileStatusInfo.d)) || (!FileUtils.a(localTroopFileStatusInfo.d)))
        {
          localnrc.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(a(1, k, m));
          if (!QLog.isColorLevel()) {
            break label1379;
          }
          QLog.d(jdField_b_of_type_JavaLangString, 2, "ThumbnailFile_Middle = " + localTroopFileStatusInfo.d);
          break label319;
        }
        localnrc.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(a(1, k, m));
        localObject1 = a(this.jdField_a_of_type_AndroidContentContext, localTroopFileStatusInfo, (MessageForTroopFile)paramChatMessage, new int[] { 0, 0 });
        if (localObject1 == null) {
          break label1379;
        }
        k = ((Drawable)localObject1).getIntrinsicWidth();
        m = ((Drawable)localObject1).getIntrinsicHeight();
        localnrc.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable((Drawable)localObject1);
        break label319;
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        break label412;
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        break label412;
        c(paramChatMessage);
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        break label412;
        n = 0;
        i4 = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 1;
        m = 0;
        break label412;
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        break label412;
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        break label412;
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        break label412;
        i4 = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        n = 1;
        m = 0;
        break label412;
        i4 = TroopFileUtils.a(localTroopFileStatusInfo.c, localTroopFileStatusInfo.jdField_b_of_type_Long);
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        m = 1;
        n = 0;
        break label412;
        n = 0;
        i4 = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 1;
        m = 0;
        break label412;
        n = 0;
        i4 = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 1;
        m = 0;
        break label412;
        localnrc.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(a(2, k, m));
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        break label412;
        n = 0;
        m = 0;
        i1 = -1;
        paramChatMessage = null;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        break label412;
        i2 = 1;
        paramChatMessage = "图片已过期";
        localnrc.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageDrawable(a(0, k, m));
        i3 = 0;
        m = 0;
        i4 = 0;
        i1 = 2130840187;
        n = 0;
        break label412;
        localnrc.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
        break label523;
        localnrc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        break label537;
        localnrc.f.setVisibility(8);
        break label573;
        localnrc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label596;
        localnrc.jdField_e_of_type_AndroidViewView.setVisibility(8);
        break label596;
        localnrc.jdField_a_of_type_ComTencentMobileqqWidgetProgressCircle.setVisibility(8);
        break label618;
        localnrc.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    }
  }
  
  boolean b(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    if ((paramChatMessage.width == 0) || (paramChatMessage.height == 0)) {}
    while ((FileManagerUtil.a(paramChatMessage.fileName) != 0) || (paramChatMessage.fileSize >= 10485760L)) {
      return false;
    }
    return true;
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(paramView, false);
    AIOUtils.l = true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\TroopFileItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */