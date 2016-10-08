package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
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
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.FilePicMesProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.imgInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.net.URL;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import njh;
import njj;
import njl;
import njm;
import njn;
import njo;

public class FilePicItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  FileManagerEntity a;
  public float b;
  public Handler b;
  public float c;
  public float d;
  public int h;
  public int i;
  int j;
  int k;
  
  public FilePicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Float = 0.5625F;
    this.c = 1.7777778F;
    this.d = 1.3333334F;
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  }
  
  public static void a(Context paramContext, View paramView, MessageForFile paramMessageForFile, SessionInfo paramSessionInfo)
  {
    paramView = AnimationUtils.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)))
    {
      int m = ((FragmentActivity)paramContext).getChatFragment().a().f();
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", m);
      if (m == 1)
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
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForFile.isMultiMsg);
      localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramView = paramMessageForFile.selfuin;
      if (!paramMessageForFile.isMultiMsg) {
        break label322;
      }
    }
    label322:
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Object localObject = paramView;
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject = localAppRuntime.getAccount();
        }
        paramView = (View)localObject;
        localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
        localBundle.putString("uin", paramMessageForFile.frienduin);
      }
      catch (Exception localException)
      {
        try
        {
          paramSessionInfo = (QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramView);
          PeakUtils.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForFile.frienduin, paramMessageForFile.istroop, paramMessageForFile), AIOGalleryUtils.a(paramMessageForFile, paramSessionInfo), -1);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "PicItemBuilder.enterImagePreview()");
          }
          return;
          localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
          break;
          localException = localException;
        }
        catch (AccountNotMatchException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  private void a(njo paramnjo)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    float f = this.a_;
    Object localObject = new AIOFilePicMask(Color.parseColor("#D8DAE0"), 255, f * 8.0F);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground((Drawable)localObject);
    }
    for (;;)
    {
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(2131372694);
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130842963, 0, 0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localFrameLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramnjo.d, paramnjo.e);
      ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).addView(localFrameLayout, (ViewGroup.LayoutParams)localObject);
      paramnjo.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
      return;
      localFrameLayout.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  private void a(njo paramnjo, FileManagerEntity paramFileManagerEntity)
  {
    int n = 1;
    if (paramFileManagerEntity != null) {}
    int m;
    label66:
    Object localObject;
    switch (paramFileManagerEntity.status)
    {
    default: 
      m = 0;
      n = 0;
      if (n != 0) {
        if (paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView == null)
        {
          paramFileManagerEntity = new FilePicMesProgressTextView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
          paramFileManagerEntity.setTextColor(-1);
          paramFileManagerEntity.setTextSize(2, 15.0F);
          paramFileManagerEntity.setGravity(17);
          localObject = new AIOSendMask(2130706432, this.a_ * 12.0F);
          if (Build.VERSION.SDK_INT >= 16)
          {
            paramFileManagerEntity.setBackground((Drawable)localObject);
            label146:
            n = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
            paramFileManagerEntity.setTextSize(2, 15.0F);
            if (jdField_a_of_type_Boolean) {
              paramFileManagerEntity.setDisplayInTextView(false, n, -1);
            }
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131299762);
            ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131299762);
            ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131299762);
            ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131299762);
            ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).addView(paramFileManagerEntity, (ViewGroup.LayoutParams)localObject);
            paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView = paramFileManagerEntity;
          }
        }
        else
        {
          paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView.setVisibility(0);
        }
      }
      break;
    }
    for (;;)
    {
      if ((m != 0) && (paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView != null))
      {
        ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).removeView(paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView);
        paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView.b();
        paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView = null;
      }
      return;
      m = 0;
      n = 0;
      break label66;
      m = 0;
      break label66;
      if (9 != paramFileManagerEntity.nOpType) {
        break;
      }
      m = 0;
      break label66;
      m = 1;
      n = 0;
      break label66;
      paramFileManagerEntity.setBackgroundDrawable((Drawable)localObject);
      break label146;
      if (paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView != null)
      {
        ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).removeView(paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView);
        paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView.b();
        paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView = null;
      }
    }
  }
  
  private void a(njo paramnjo, FileManagerEntity paramFileManagerEntity, MessageForFile paramMessageForFile)
  {
    int m = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int n = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i1 = AIOUtils.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i2 = AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramnjo.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramnjo.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).removeView(paramnjo.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    paramMessageForFile = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    paramMessageForFile.setId(2131296384);
    float f = this.a_;
    Object localObject = new AIOFilePicMask(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427409), 102, f * 8.0F);
    TextPaint localTextPaint;
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramMessageForFile.setBackground((Drawable)localObject);
      paramnjo.jdField_a_of_type_AndroidWidgetRelativeLayout = paramMessageForFile;
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setId(2131296388);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).setMaxLines(2);
      ((TextView)localObject).setTextSize(1, 16.0F);
      ((TextView)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131427407));
      localTextPaint = ((TextView)localObject).getPaint();
      if ((paramFileManagerEntity.getCloudType() != 3) && (paramFileManagerEntity.getCloudType() != 5)) {
        break label402;
      }
      ((TextView)localObject).setText(FilePicURLDrawlableHelper.b(paramFileManagerEntity.fileName));
    }
    for (f = localTextPaint.measureText(FilePicURLDrawlableHelper.b(paramFileManagerEntity.fileName));; f = localTextPaint.measureText(FilePicURLDrawlableHelper.b(paramFileManagerEntity.strSrcName)))
    {
      paramnjo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
      if (f + n * 2 >= paramnjo.d) {
        break label431;
      }
      paramFileManagerEntity = new RelativeLayout.LayoutParams(-2, -2);
      paramFileManagerEntity.addRule(9, 2131296384);
      paramFileManagerEntity.setMargins(n, 0, n, 0);
      ((TextView)localObject).setSingleLine();
      paramMessageForFile.addView((View)localObject, paramFileManagerEntity);
      paramMessageForFile.setPadding(0, m, 0, m);
      paramFileManagerEntity = new RelativeLayout.LayoutParams(paramnjo.d, i1);
      paramFileManagerEntity.addRule(12);
      ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).addView(paramMessageForFile, paramFileManagerEntity);
      return;
      paramMessageForFile.setBackgroundDrawable((Drawable)localObject);
      break;
      label402:
      ((TextView)localObject).setText(FilePicURLDrawlableHelper.b(paramFileManagerEntity.strSrcName));
    }
    label431:
    if (a(paramnjo.d, paramnjo.e))
    {
      paramFileManagerEntity = new RelativeLayout.LayoutParams(-2, -2);
      paramFileManagerEntity.addRule(9, 2131296384);
      paramFileManagerEntity.setMargins(n, 0, n, 0);
      ((TextView)localObject).setSingleLine();
      f = paramnjo.d - n * 2;
      localTextPaint.setTextSize(((TextView)localObject).getTextSize());
      ((TextView)localObject).setText((String)TextUtils.ellipsize(((TextView)localObject).getText(), (TextPaint)localTextPaint, f, TextUtils.TruncateAt.END));
      paramMessageForFile.addView((View)localObject, paramFileManagerEntity);
      paramMessageForFile.setPadding(0, m, 0, m);
      paramFileManagerEntity = new RelativeLayout.LayoutParams(paramnjo.d, i1);
      paramFileManagerEntity.addRule(12);
      ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).addView(paramMessageForFile, paramFileManagerEntity);
      return;
    }
    if (FilePicURLDrawlableHelper.a(((TextView)localObject).getText().toString()))
    {
      paramFileManagerEntity = new RelativeLayout.LayoutParams(-2, -2);
      paramFileManagerEntity.addRule(9, 2131296384);
      paramFileManagerEntity.addRule(10, 2131296384);
      ((TextView)localObject).setSingleLine();
      f = paramnjo.d - n * 2;
      localTextPaint.setTextSize(((TextView)localObject).getTextSize());
      ((TextView)localObject).setText((String)TextUtils.ellipsize(((TextView)localObject).getText(), (TextPaint)localTextPaint, f, TextUtils.TruncateAt.END));
      paramFileManagerEntity.setMargins(n, 0, n, 0);
      paramMessageForFile.addView((View)localObject, paramFileManagerEntity);
      paramMessageForFile.setPadding(0, m, 0, m);
      paramFileManagerEntity = new RelativeLayout.LayoutParams(paramnjo.d, i1);
      paramFileManagerEntity.addRule(12);
      ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).addView(paramMessageForFile, paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity = new RelativeLayout.LayoutParams(-2, -2);
    paramFileManagerEntity.addRule(9, 2131296384);
    paramFileManagerEntity.addRule(10, 2131296384);
    f = paramnjo.d * 2 - n * 4;
    localTextPaint.setTextSize(((TextView)localObject).getTextSize());
    ((TextView)localObject).setText((String)TextUtils.ellipsize(((TextView)localObject).getText(), (TextPaint)localTextPaint, f, TextUtils.TruncateAt.END));
    ((TextView)localObject).setMaxLines(2);
    paramFileManagerEntity.setMargins(n, 0, n, 0);
    paramMessageForFile.addView((View)localObject, paramFileManagerEntity);
    paramMessageForFile.setPadding(0, n, 0, n);
    paramFileManagerEntity = new RelativeLayout.LayoutParams(paramnjo.d, i2);
    paramFileManagerEntity.addRule(12);
    ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).addView(paramMessageForFile, paramFileManagerEntity);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 >= (int)(paramInt2 * this.d);
  }
  
  private boolean a(njo paramnjo, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    int m;
    if ((paramnjo.jdField_a_of_type_Boolean) && ((paramFileManagerEntity.status == -1) || (paramFileManagerEntity.status == 1) || (paramFileManagerEntity.status == 0) || (paramFileManagerEntity.status == 13)))
    {
      m = 1;
      if (paramFileManagerEntity.status != 16) {
        break label76;
      }
    }
    label76:
    for (int n = 1;; n = 0)
    {
      if ((m != 0) || (n != 0)) {
        bool = true;
      }
      return bool;
      m = 0;
      break;
    }
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = true;
    if (paramFileManagerEntity == null) {
      return false;
    }
    boolean bool1 = bool2;
    switch (paramFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    case 4: 
    case 9: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if (paramFileManagerEntity.status != 0) {
        break;
      }
      bool1 = bool2;
      continue;
      if (13 != paramFileManagerEntity.nOpType) {
        break;
      }
      bool1 = bool2;
      continue;
      if (10 == paramFileManagerEntity.nOpType)
      {
        bool1 = false;
      }
      else
      {
        bool1 = false;
        continue;
        if (13 != paramFileManagerEntity.nOpType) {
          break;
        }
        bool1 = bool2;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    paramViewHolder = (njo)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131299762);
      paramView.setAdjustViewBounds(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      paramChatMessage.addView(paramView, localLayoutParams);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramView;
    }
    paramView = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView;
    this.j = BaseChatItemLayout.i;
    this.k = ((int)(BaseChatItemLayout.i * this.jdField_b_of_type_Float));
    this.i = this.j;
    this.h = this.k;
    paramView.setMinimumWidth(this.k);
    paramView.setMinimumHeight(this.k);
    paramView.setMaxWidth(this.j);
    paramView.setMaxHeight(this.j);
    paramView = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramView != null) {
      paramView.a(paramChatMessage, this);
    }
    paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    paramViewHolder.jdField_a_of_type_AndroidViewView = paramChatMessage;
    a(paramBaseChatItemLayout, localMessageForFile, paramViewHolder, paramView, false);
    return paramChatMessage;
  }
  
  public URLDrawable a(FileManagerEntity paramFileManagerEntity, MessageForFile paramMessageForFile, Context paramContext, URL paramURL, njo paramnjo)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    paramMessageForFile = null;
    if (paramURL != null) {
      paramMessageForFile = paramURL.toString();
    }
    FilePicURLDrawlableHelper.imgInfo localimgInfo = FilePicURLDrawlableHelper.a(paramFileManagerEntity);
    int n;
    int m;
    if ((localimgInfo.jdField_a_of_type_Int > 0) && (localimgInfo.b > 0))
    {
      n = localimgInfo.jdField_a_of_type_Int;
      m = localimgInfo.b;
      if ((paramMessageForFile == null) || (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramMessageForFile) == null)) {
        break label118;
      }
      paramFileManagerEntity = URLDrawableHelper.a(paramURL, 0, 0, null, null, true, 0.0F);
      paramnjo.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      paramnjo.d = n;
      paramnjo.e = m;
      return paramFileManagerEntity;
      n = this.h;
      m = this.i;
      break;
      label118:
      if (paramURL != null)
      {
        paramFileManagerEntity = URLDrawableHelper.a(paramURL, n, m, new EmptyDrawable(n, m), URLDrawableHelper.b, true, 0.0F);
        paramFileManagerEntity.setAutoDownload(true);
        paramnjo.jdField_a_of_type_Boolean = true;
      }
      else
      {
        paramMessageForFile = null;
        paramURL = paramContext.getResources();
        paramContext = URLDrawable.URLDrawableOptions.obtain();
        paramContext.mRequestWidth = n;
        paramContext.mRequestHeight = m;
        paramContext.mLoadingDrawable = URLDrawableHelper.a;
        paramContext.mFailedDrawable = URLDrawableHelper.b;
        paramContext.mPlayGifImage = false;
        paramContext.mGifRoundCorner = 12.0F;
        if ((URLDrawableHelper.a instanceof SkinnableBitmapDrawable))
        {
          paramMessageForFile = new BitmapDrawableWithMargin(paramURL, ((SkinnableBitmapDrawable)URLDrawableHelper.a).getBitmap(), n, m, -921103);
          if (paramMessageForFile != null) {
            paramContext.mLoadingDrawable = paramMessageForFile;
          }
          if (FileUtil.b(paramFileManagerEntity.getFilePath())) {
            ThreadManager.b(new njh(this, paramFileManagerEntity));
          }
          if ((NetworkUtil.b(BaseApplicationImpl.getContext()) != 1) || (!FilePicURLDrawlableHelper.b(paramFileManagerEntity))) {
            break label390;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, 7);
        }
        for (;;)
        {
          paramnjo.jdField_a_of_type_Boolean = false;
          paramMessageForFile = AppConstants.bh;
          paramMessageForFile = AsyncImageView.b(paramMessageForFile, n, m, new File(paramMessageForFile), false, false, true);
          if (paramMessageForFile != null) {
            break label406;
          }
          return null;
          if (!(URLDrawableHelper.a instanceof BitmapDrawable)) {
            break;
          }
          paramMessageForFile = new BitmapDrawableWithMargin(paramURL, ((BitmapDrawable)URLDrawableHelper.a).getBitmap(), n, m, -921103);
          break;
          label390:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity, 5);
        }
        label406:
        paramMessageForFile = URLDrawable.getDrawable(paramMessageForFile, paramContext);
        paramMessageForFile.setProgressDrawable(new PhotoProgressDrawable(URLDrawableHelper.a(), 0, false));
        if (FilePicURLDrawlableHelper.a(paramFileManagerEntity))
        {
          paramMessageForFile.setAutoDownload(true);
          paramFileManagerEntity = paramMessageForFile;
        }
        else
        {
          paramMessageForFile.setAutoDownload(false);
          paramFileManagerEntity = paramMessageForFile;
        }
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new njo(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public String a(String paramString, float paramFloat, int paramInt)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0))
    {
      str = "";
      return str;
    }
    Paint localPaint = new Paint();
    Rect localRect = new Rect();
    localPaint.setTextSize(paramFloat);
    localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    for (int m = localRect.width();; m = localRect.width())
    {
      str = paramString;
      if (m <= paramInt) {
        break;
      }
      paramString = paramString.substring(0, paramString.length() * 3 / 4);
      paramString = paramString + "..";
      localPaint.setTextSize(paramFloat);
      localPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
      return;
      long l1 = MessageCache.a();
      long l2 = paramChatMessage.time;
      if ((paramChatMessage.msgtype == 63531) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
      {
        FMToastUtil.a("该文件发送超过7天，撤回失败。");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
        return;
      }
      a(paramChatMessage);
      FileManagerReporter.a("0X8005E4B");
      continue;
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity.nSessionId);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
      continue;
      super.b(paramChatMessage);
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, paramContext);
      continue;
      paramContext = new FileManagerReporter.fileAssistantReportData();
      paramContext.b = "file_forward";
      paramContext.jdField_a_of_type_Int = 9;
      paramContext.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
      paramContext.c = FileUtil.a(localFileManagerEntity.fileName);
      paramContext.d = FileManagerUtil.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramContext);
      paramContext = new Bundle();
      paramContext.putInt("forward_type", 0);
      paramContext.putBoolean("not_forward", true);
      paramContext.putParcelable("fileinfo", ForwardFileOption.a(localFileManagerEntity, paramChatMessage));
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("forward_text", "已选择" + FileManagerUtil.d(localFileManagerEntity.fileName) + "。");
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      paramChatMessage.putExtra("forward _key_nojump", true);
      paramChatMessage.putExtra("isPic", true);
      paramChatMessage.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
      continue;
      FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, paramContext);
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644D", "0X800644D", 0, 0, "6", "", "", "");
      FileManagerReporter.a("0X8005080");
      if (!NetworkUtil.e(paramContext))
      {
        FMToastUtil.a(2131362941);
        return;
      }
      if (FileManagerUtil.a()) {
        FMDialogUtil.a(paramContext, 2131362855, 2131362854, new njm(this, localFileManagerEntity));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        break;
        if (localFileManagerEntity.getCloudType() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity);
      }
      FileManagerReporter.a("0X8005081");
      if (localFileManagerEntity.getCloudType() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        continue;
        FileManagerReporter.a("0X8005082");
        if (!NetworkUtil.e(paramContext))
        {
          FMToastUtil.a(2131362941);
          return;
        }
        if (FileManagerUtil.a()) {
          if (localFileManagerEntity.nOpType == 0)
          {
            paramInt = 2131362851;
            label850:
            FMDialogUtil.a(paramContext, 2131362855, paramInt, new njn(this, localFileManagerEntity));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          break;
          paramInt = 2131362852;
          break label850;
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity.nSessionId);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        a();
        continue;
        new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, paramChatMessage, false);
      }
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    njo localnjo = (njo)AIOUtils.a(paramView);
    MessageForFile localMessageForFile = (MessageForFile)localnjo.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    BaseChatItemLayout localBaseChatItemLayout = localnjo.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
    if (paramView.getCloudType() == 5)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.getString(2131367889);
    this.jdField_a_of_type_AndroidContentContext.getString(2131367890);
    String str;
    switch (paramView.nOpType)
    {
    case 6: 
    case 7: 
    default: 
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131362736);
    }
    for (paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362734); localMessageForFile.isSendFromLocal(); paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362735))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      localActionSheet.c(str);
      localActionSheet.d(this.jdField_a_of_type_AndroidContentContext.getString(2131367262));
      localActionSheet.a(paramView);
      localActionSheet.a(new njj(this, localMessageForFile, localBaseChatItemLayout, localnjo, localActionSheet));
      localActionSheet.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131362737);
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131362737));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131367262));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131362735));
    paramView.a(new njl(this, localMessageForFile, localBaseChatItemLayout, localnjo, paramView));
    paramView.show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (njo)AIOUtils.a(paramView);
    MessageForFile localMessageForFile = (MessageForFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    BaseChatItemLayout localBaseChatItemLayout = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (localMessageForFile.uniseq != paramFileMsg.c) {
      return;
    }
    if (paramInt1 == 5000)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131368007, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "transferListener FileMsg.TRANSFILE_TYPE_FILE uniseq " + localMessageForFile.uniseq + " itemStatus " + localMessageForFile.status);
    }
    a(localBaseChatItemLayout, localMessageForFile, paramView, FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile), false);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, njo paramnjo, FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    FileManagerUtil.c(paramFileManagerEntity);
    FileManagerUtil.b(paramFileManagerEntity);
    paramMessageForFile.fileName = paramFileManagerEntity.fileName;
    paramMessageForFile.fileSize = paramFileManagerEntity.fileSize;
    paramMessageForFile.status = paramFileManagerEntity.status;
    paramMessageForFile.urlAtServer = paramFileManagerEntity.strServerPath;
    paramMessageForFile.url = paramFileManagerEntity.getFilePath();
    paramMessageForFile.fileSizeString = FileUtil.a(paramFileManagerEntity.fileSize);
    if (paramnjo.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      paramnjo.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).removeView(paramnjo.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
    Object localObject;
    if (paramFileManagerEntity.status == 16)
    {
      localObject = FilePicURLDrawlableHelper.a(paramFileManagerEntity);
      if ((((FilePicURLDrawlableHelper.imgInfo)localObject).jdField_a_of_type_Int > 0) && (((FilePicURLDrawlableHelper.imgInfo)localObject).b > 0))
      {
        paramnjo.d = ((FilePicURLDrawlableHelper.imgInfo)localObject).jdField_a_of_type_Int;
        paramnjo.e = ((FilePicURLDrawlableHelper.imgInfo)localObject).b;
        label152:
        paramnjo.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(null);
        paramnjo.jdField_a_of_type_ComTencentImageURLDrawable = null;
        a(paramnjo);
        label170:
        if (!a(paramnjo, paramFileManagerEntity)) {
          break label346;
        }
        a(paramnjo, paramFileManagerEntity, paramMessageForFile);
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.setFailedIconVisable(b(paramFileManagerEntity), this);
      if (paramMessageForFile.isSendFromLocal()) {
        break label370;
      }
      if (paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView == null) {
        break;
      }
      paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView.setVisibility(8);
      paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView.clearAnimation();
      paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView.setProcessor(null);
      ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).removeView(paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView);
      paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView.b();
      paramnjo.jdField_a_of_type_ComTencentMobileqqCustomviewsFilePicMesProgressTextView = null;
      return;
      paramnjo.d = this.h;
      paramnjo.e = this.i;
      break label152;
      localObject = FilePicURLDrawlableHelper.b(paramFileManagerEntity);
      URLDrawable localURLDrawable = a(paramFileManagerEntity, paramMessageForFile, this.jdField_a_of_type_AndroidContentContext, (URL)localObject, paramnjo);
      if ((paramnjo.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramnjo.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(localObject))) {
        break label170;
      }
      paramnjo.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(localURLDrawable);
      paramnjo.jdField_a_of_type_ComTencentImageURLDrawable = localURLDrawable;
      break label170;
      label346:
      if (paramnjo.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout)paramnjo.jdField_a_of_type_AndroidViewView).removeView(paramnjo.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
    label370:
    a(paramnjo, paramFileManagerEntity);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFileManagerEntity != null) {
      if (paramFileManagerEntity.nOpType != 24)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.nOpType != 25) {}
      }
      else if (paramFileManagerEntity.status != 2)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.status != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForFile)AIOUtils.a(paramView);
    FileManagerEntity localFileManagerEntity1 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (localFileManagerEntity1.getCloudType() == 5) {
      return a(localFileManagerEntity1);
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView.isSendFromLocal()) && (localFileManagerEntity1.status == 2)) {
      localQQCustomMenu.a(2131305403, this.jdField_a_of_type_AndroidContentContext.getString(2131367893));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity1.status);
      }
      return localQQCustomMenu.a();
      if (!FilePicURLDrawlableHelper.a(localFileManagerEntity1))
      {
        a(paramView, localQQCustomMenu);
        if ((localFileManagerEntity1.getCloudType() != 0) && (!a(localFileManagerEntity1)))
        {
          localQQCustomMenu.a(2131305422, this.jdField_a_of_type_AndroidContentContext.getString(2131362748));
          localQQCustomMenu.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131362750));
        }
        if ((AIOUtils.a(2) == 1) && (DataLineHandler.a(localFileManagerEntity1))) {
          localQQCustomMenu.a(2131305428, this.jdField_a_of_type_AndroidContentContext.getString(2131362204));
        }
        if ((AIOUtils.a(3) == 1) && (localFileManagerEntity1.getCloudType() != 0) && (!a(localFileManagerEntity1)) && (localFileManagerEntity1.getCloudType() != 2))
        {
          FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity1.nRelatedSessionId);
          if ((localFileManagerEntity2 != null) && (localFileManagerEntity2.status == 1) && ((localFileManagerEntity2.nOpType == 20) || (localFileManagerEntity2.nOpType == 4) || (localFileManagerEntity2.nOpType == 6)))
          {
            ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            return localQQCustomMenu.a();
          }
          localFileManagerEntity1.nRelatedSessionId = 0L;
          localQQCustomMenu.a(2131305421, this.jdField_a_of_type_AndroidContentContext.getString(2131362752));
        }
      }
      if ((paramView.isSend()) && ((localFileManagerEntity1.status == 1) || (localFileManagerEntity1.status == -1) || ((localFileManagerEntity1.status == 3) && (localFileManagerEntity1.nOpType == 1)))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  QQCustomMenuItem[] a(FileManagerEntity paramFileManagerEntity)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((!paramFileManagerEntity.bSend) && (paramFileManagerEntity.status != 1))
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return localQQCustomMenu.a();
    }
    localQQCustomMenu.a(2131305422, this.jdField_a_of_type_AndroidContentContext.getString(2131362748));
    if (AIOUtils.a(2) == 1) {
      localQQCustomMenu.a(2131305428, this.jdField_a_of_type_AndroidContentContext.getString(2131362204));
    }
    if ((AIOUtils.a(3) == 1) && (paramFileManagerEntity.getCloudType() != 2))
    {
      paramFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nRelatedSessionId);
      if ((paramFileManagerEntity == null) || (paramFileManagerEntity.status != 1)) {
        localQQCustomMenu.a(2131305421, this.jdField_a_of_type_AndroidContentContext.getString(2131362752));
      }
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.l = true;
    if (super.a()) {}
    MessageForFile localMessageForFile;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        URLDrawable localURLDrawable;
        do
        {
          return;
          if (paramView.getId() != 2131296328) {
            break;
          }
          paramView = (njo)AIOUtils.a(paramView);
          localMessageForFile = (MessageForFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localURLDrawable = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
          localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
        } while (localFileManagerEntity.status == 16);
        if ((localMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 3))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
          return;
        }
        switch (localURLDrawable.getStatus())
        {
        default: 
          return;
        case 0: 
        case 2: 
          if ((Utils.b()) && (Utils.b() < 20971520L))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, "手机存储空间已满，请清理后重新进入QQ。", 0).a();
            return;
          }
          break;
        }
      } while (!FileUtils.a(this.jdField_a_of_type_AndroidContentContext));
      if (FileUtils.b(localFileManagerEntity.strMiddleThumPath))
      {
        a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForFile, paramView, localFileManagerEntity, false);
        return;
      }
    } while (!FilePicURLDrawlableHelper.a(localFileManagerEntity));
    return;
    a(this.jdField_a_of_type_AndroidContentContext, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView, localMessageForFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    return;
    super.onClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\FilePicItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */