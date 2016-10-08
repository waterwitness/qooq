package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
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
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import njb;
import njc;
import njd;
import njf;
import njg;

public class FileItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  private static final String b;
  FileManagerEntity a;
  public Handler b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = FileItemBuilder.class.getSimpleName();
  }
  
  public FileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt, -1L);
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("chaosli", 2, "getFileTransStatus processor.getFileStatus() " + i);
      }
      return i;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong4, paramString1, paramInt);
    if (paramString2 != null)
    {
      if ((paramString2.cloudType == 1) && (FileManagerUtil.a(paramString2))) {
        paramString2.status = 16;
      }
      return paramString2.status;
    }
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString1 = (TransFileInfo)paramString2.a(TransFileInfo.class, new String[] { String.valueOf(paramLong3), String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1 });
    paramString2.a();
    if (paramString1 == null) {
      return 0;
    }
    paramString1.status = FileManagerUtil.d(paramString1.status);
    if (paramString1.status == 2) {
      paramString1.status = 0;
    }
    return paramString1.status;
  }
  
  private long a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString2 = (TransFileInfo)paramString1.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString2 });
    paramString1.a();
    if (paramString2 != null) {
      return paramString2.transferedSize;
    }
    return 0L;
  }
  
  private RelativeLayout a(njg paramnjg)
  {
    int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131296328);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131296384);
    ((RelativeLayout)localObject2).setBackgroundResource(2130840342);
    ((RelativeLayout)localObject2).setPadding(AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramnjg.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131296328);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131296385);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, j);
    localLayoutParams.addRule(10, 2131296384);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext, j, j);
    ((AsyncImageView)localObject2).setId(2131296386);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131296385);
    localLayoutParams.addRule(15, 2131296385);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramnjg.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131296388);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428272));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131296386);
    localLayoutParams.addRule(11, 2131296385);
    localLayoutParams.addRule(10, 2131296385);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramnjg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131296390);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131296385);
    localLayoutParams.addRule(12, 2131296385);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramnjg.c = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131296389);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if ((FontSettingManager.a() > 17.0F) || (localDisplayMetrics.widthPixels <= 500))
    {
      localLayoutParams.addRule(11, 2131296385);
      localLayoutParams.addRule(2, 2131296390);
    }
    for (;;)
    {
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramnjg.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      return localRelativeLayout;
      localLayoutParams.addRule(5, 2131296388);
      localLayoutParams.addRule(12, 2131296385);
    }
  }
  
  private String a(long paramLong1, long paramLong2, String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString });
    localEntityManager.a();
    if (paramString != null) {
      return paramString.fileName;
    }
    return "";
  }
  
  private String a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 == null) && (paramString2 != null))
    {
      paramString2 = a(paramLong1, paramLong2, paramString2);
      if (paramString2 != null)
      {
        i = paramString2.lastIndexOf(".");
        if (i >= 0) {}
      }
    }
    do
    {
      return paramString2;
      return paramString2.substring(0, i);
      if (paramString1 == null) {
        return null;
      }
      i = paramString1.lastIndexOf(File.separator);
      paramString2 = paramString1;
    } while (i < 0);
    String str = "";
    paramString2 = str;
    if (i > 0)
    {
      paramString2 = str;
      if (i + 1 < paramString1.length()) {
        paramString2 = paramString1.substring(i + 1);
      }
    }
    return paramString2;
  }
  
  private String a(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      str1 = str2;
      if (j > 0)
      {
        str1 = str2;
        if (j > i)
        {
          str1 = str2;
          if (j + 1 < paramString.length()) {
            str1 = paramString.substring(j + 1);
          }
        }
      }
    }
    return str1;
  }
  
  private void a(Intent paramIntent, String paramString, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    paramString = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
      if ((localChatMessage.msgtype == 63531) || (localChatMessage.msgtype == 63522)) {
        paramString.add(String.valueOf(localChatMessage.uniseq));
      }
    }
    paramIntent.putStringArrayListExtra("Aio_Uinseq_ImageList", paramString);
  }
  
  private void a(MessageForFile paramMessageForFile)
  {
    long l2 = 0L;
    for (;;)
    {
      try
      {
        if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 0)) {
          continue;
        }
        localObject1 = paramMessageForFile.tempMsg[0].substring(1);
        paramMessageForFile.url = ((String)localObject1);
        if (paramMessageForFile.url.length() == 0)
        {
          paramMessageForFile.url = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.frienduin);
          if ((paramMessageForFile.tempMsg != null) && (paramMessageForFile.tempMsg.length > 1)) {
            paramMessageForFile.tempMsg[1] = String.valueOf(a(paramMessageForFile.msgseq, paramMessageForFile.time, "", paramMessageForFile.frienduin));
          }
        }
        paramMessageForFile.fileName = a(paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.url, paramMessageForFile.frienduin);
        paramMessageForFile.fileType = a(paramMessageForFile.url);
        if ((paramMessageForFile.tempMsg == null) || (paramMessageForFile.tempMsg.length <= 1) || (paramMessageForFile.tempMsg[1] == null) || (Long.valueOf(paramMessageForFile.tempMsg[1]).longValue() <= 0L)) {
          continue;
        }
        paramMessageForFile.fileSize = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
      }
      catch (Exception localException)
      {
        Object localObject1;
        QLog.e(jdField_b_of_type_JavaLangString, 1, localException.toString());
        continue;
        long l1 = 0L;
        continue;
        if (paramMessageForFile.tempMsg == null) {
          continue;
        }
        if (paramMessageForFile.tempMsg.length <= 1) {
          continue;
        }
        l1 = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
        paramMessageForFile.fileSize = l1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_b_of_type_JavaLangString, 2, "--------->>bindView 2 filePath:" + paramMessageForFile.url + "fileMsgLength:" + paramMessageForFile.tempMsg.length + ", fileSize:" + paramMessageForFile.fileSize);
        continue;
        l1 = 0L;
        continue;
        Object localObject2 = null;
        continue;
      }
      paramMessageForFile.fileSizeString = FileUtil.a(paramMessageForFile.fileSize);
      if (paramMessageForFile.tempMsg != null)
      {
        if (paramMessageForFile.tempMsg.length <= 4) {
          continue;
        }
        localObject1 = paramMessageForFile.tempMsg[4];
        paramMessageForFile.urlAtServer = ((String)localObject1);
      }
      paramMessageForFile.status = a(paramMessageForFile.frienduin, paramMessageForFile.url, paramMessageForFile.isSendFromLocal(), paramMessageForFile.fileSize, paramMessageForFile.msgseq, paramMessageForFile.time, paramMessageForFile.uniseq, paramMessageForFile.istroop);
      return;
      localObject1 = "";
      continue;
      if (!paramMessageForFile.isSendFromLocal()) {
        continue;
      }
      localObject1 = new File(paramMessageForFile.url);
      if (!((File)localObject1).exists()) {
        continue;
      }
      l1 = ((File)localObject1).length();
      paramMessageForFile.fileSize = l1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "--------->>bindView 1 filePath:" + paramMessageForFile.url + ",fileExists:" + ((File)localObject1).exists() + ", fileSize:" + ((File)localObject1).length());
      }
      if ((paramMessageForFile.fileSize == 0L) && (paramMessageForFile.tempMsg != null))
      {
        l1 = l2;
        if (paramMessageForFile.tempMsg.length > 1) {
          l1 = Long.valueOf(paramMessageForFile.tempMsg[1]).longValue();
        }
        paramMessageForFile.fileSize = l1;
      }
    }
  }
  
  private void a(njg paramnjg, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramnjg.c.setVisibility(8);
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131362770);
      switch (paramFileManagerEntity.status)
      {
      case 2: 
      case 14: 
      case 15: 
      default: 
        paramnjg.c.setVisibility(4);
        return;
      case 0: 
        paramnjg.c.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 5))
          {
            paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362868));
            return;
          }
          paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362872));
          return;
        }
        paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362873));
        return;
      case 16: 
        paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362870));
        return;
      case -1: 
        paramnjg.c.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362868));
          return;
        }
        paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362869));
        return;
      case 1: 
        paramnjg.c.setVisibility(0);
        if (paramMessageForFile.isSend())
        {
          paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362868));
          return;
        }
        if (paramFileManagerEntity.getCloudType() == 0)
        {
          paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362881));
          return;
        }
        paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362866));
        return;
      case 3: 
        paramnjg.c.setVisibility(0);
        if (!paramMessageForFile.isSend()) {
          break label638;
        }
        if ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 5))
        {
          paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362868));
          return;
        }
        break;
      }
    } while (3 != paramFileManagerEntity.getCloudType());
    paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362867));
    return;
    label638:
    paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362867));
    return;
    paramnjg.c.setVisibility(0);
    paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362869));
    return;
    paramnjg.c.setVisibility(0);
    paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362869));
    return;
    paramnjg.c.setVisibility(0);
    paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362870));
    return;
    paramnjg.c.setVisibility(0);
    paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362870));
    return;
    paramnjg.c.setVisibility(0);
    paramnjg.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362869));
  }
  
  private void a(njg paramnjg, FileManagerEntity paramFileManagerEntity)
  {
    int j = 1;
    int i;
    if (paramFileManagerEntity != null)
    {
      i = j;
      switch (paramFileManagerEntity.status)
      {
      }
    }
    label241:
    do
    {
      for (i = 0;; i = j)
      {
        if (i == 0) {
          break label241;
        }
        if (paramnjg.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131296391);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837559));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131296385);
          localLayoutParams.addRule(12, 2131296384);
          localLayoutParams.setMargins(0, AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramnjg.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramnjg.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramnjg.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramFileManagerEntity.fProgress * 100.0F));
        paramnjg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
        if (9 != paramFileManagerEntity.nOpType) {
          break;
        }
      }
    } while (paramnjg.jdField_a_of_type_AndroidWidgetProgressBar == null);
    paramnjg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {
      return false;
    }
    switch (paramFileManagerEntity.status)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 9: 
    case 12: 
    case 13: 
    case 15: 
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (paramFileManagerEntity.status != 0) {
        break;
      }
      continue;
      if (13 != paramFileManagerEntity.nOpType) {
        break;
      }
      continue;
      if (10 == paramFileManagerEntity.nOpType)
      {
        bool = false;
      }
      else
      {
        bool = false;
        continue;
        if (13 != paramFileManagerEntity.nOpType) {
          break;
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForFile)AIOUtils.a(paramView);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "TransfileUtile.TYPE_FILE uniseq " + ((MessageForFile)localObject2).uniseq + " itemStatus" + ((MessageForFile)localObject2).status);
    }
    Object localObject1 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject2);
    paramView = new FileManagerReporter.fileAssistantReportData();
    paramView.jdField_b_of_type_JavaLangString = "file_viewer_in";
    paramView.jdField_a_of_type_Int = 9;
    paramView.c = FileUtil.a(((FileManagerEntity)localObject1).fileName);
    paramView.d = FileManagerUtil.a(((FileManagerEntity)localObject1).getCloudType(), ((FileManagerEntity)localObject1).peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
    FileManagerReporter.a("0X8004AE3");
    if ((((FileManagerEntity)localObject1).TroopUin != 0L) && (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strTroopFileID)) && (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strTroopFilePath)))
    {
      paramView = new ForwardFileInfo();
      paramView.b(((FileManagerEntity)localObject1).nSessionId);
      paramView.d(4);
      paramView.b(10006);
      paramView.a(((FileManagerEntity)localObject1).getFilePath());
      paramView.d(((FileManagerEntity)localObject1).fileName);
      paramView.d(((FileManagerEntity)localObject1).fileSize);
      paramView.a(((FileManagerEntity)localObject1).TroopUin);
      localObject1 = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localObject2 = new Intent((Context)localObject1, TroopFileDetailBrowserActivity.class);
      ((Intent)localObject2).putExtra("fileinfo", paramView);
      ((Intent)localObject2).putExtra("removemementity", true);
      ((Intent)localObject2).putExtra("forward_from_troop_file", true);
      ((Intent)localObject2).putExtra("not_forward", true);
      ((Activity)localObject1).startActivityForResult((Intent)localObject2, 102);
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(10004);
    if (((MessageForFile)localObject2).isSend()) {}
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      localForwardFileInfo.d(((FileManagerEntity)localObject1).getCloudType());
      localForwardFileInfo.a(Long.valueOf(paramView.replace("+", "")).longValue());
      localForwardFileInfo.c(((MessageForFile)localObject2).uniseq);
      localForwardFileInfo.b(((FileManagerEntity)localObject1).nSessionId);
      localForwardFileInfo.d(((MessageForFile)localObject2).fileName);
      localForwardFileInfo.d(((MessageForFile)localObject2).fileSize);
      localForwardFileInfo.b(((FileManagerEntity)localObject1).Uuid);
      localForwardFileInfo.a(((FileManagerEntity)localObject1).getFilePath());
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
      paramView.putExtra("fileinfo", localForwardFileInfo);
      int i = FileManagerUtil.a(((FileManagerEntity)localObject1).fileName);
      if ((i == 0) || (i == 1)) {
        a(paramView, ((MessageForFile)localObject2).frienduin, ((MessageForFile)localObject2).istroop);
      }
      paramView.putExtra("selfSet_leftViewText", "返回");
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 102);
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (njg)paramChatMessage.getTag();
    paramView.jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.h;
    if (jdField_b_of_type_Boolean) {}
    try
    {
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append(paramView.c.getText());
      paramView.jdField_b_of_type_JavaLangStringBuilder.append("按钮");
      paramChatMessage.setContentDescription(paramView.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramChatMessage;
    }
    catch (Exception paramView) {}
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    njg localnjg = (njg)paramViewHolder;
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((njg)paramViewHolder);
    }
    a(localMessageForFile);
    a(paramBaseChatItemLayout, localMessageForFile, localnjg, localMessageForFile.status);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new njg(this);
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
      paramContext.jdField_b_of_type_JavaLangString = "file_forward";
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
      paramChatMessage.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
        FMDialogUtil.a(paramContext, 2131362855, 2131362854, new njb(this, localFileManagerEntity));
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
            label835:
            FMDialogUtil.a(paramContext, 2131362855, paramInt, new njc(this, localFileManagerEntity));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          break;
          paramInt = 2131362852;
          break label835;
          if (localFileManagerEntity.getCloudType() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity.nSessionId);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        }
        new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, paramChatMessage, false);
      }
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    njg localnjg = (njg)AIOUtils.a(paramView);
    MessageForFile localMessageForFile = (MessageForFile)localnjg.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    BaseChatItemLayout localBaseChatItemLayout = localnjg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
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
      localActionSheet.a(new njd(this, localMessageForFile, localBaseChatItemLayout, localnjg, localActionSheet));
      localActionSheet.show();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131362737);
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    paramView.c(this.jdField_a_of_type_AndroidContentContext.getString(2131362737));
    paramView.d(this.jdField_a_of_type_AndroidContentContext.getString(2131367262));
    paramView.a(this.jdField_a_of_type_AndroidContentContext.getString(2131362735));
    paramView.a(new njf(this, localMessageForFile, localBaseChatItemLayout, localnjg, paramView));
    paramView.show();
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (njg)AIOUtils.a(paramView);
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
      QLog.d(jdField_b_of_type_JavaLangString, 2, "transferListener FileMsg.TRANSFILE_TYPE_FILE uniseq " + localMessageForFile.uniseq + " itemStatus " + localMessageForFile.status);
    }
    a(localBaseChatItemLayout, localMessageForFile, paramView, paramInt1);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForFile paramMessageForFile, njg paramnjg, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForFile);
    FileManagerUtil.b(localFileManagerEntity);
    paramMessageForFile.fileName = localFileManagerEntity.fileName;
    paramMessageForFile.fileSize = localFileManagerEntity.fileSize;
    paramMessageForFile.status = localFileManagerEntity.status;
    paramMessageForFile.urlAtServer = localFileManagerEntity.strServerPath;
    paramMessageForFile.url = localFileManagerEntity.getFilePath();
    paramMessageForFile.fileSizeString = FileUtil.a(localFileManagerEntity.fileSize);
    if ((localFileManagerEntity.getCloudType() == 3) || (localFileManagerEntity.getCloudType() == 5))
    {
      paramnjg.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileManagerEntity.fileName));
      if ((localFileManagerEntity == null) || (15 != localFileManagerEntity.status) || (9 != localFileManagerEntity.nOpType)) {
        break label175;
      }
      paramnjg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362837));
    }
    for (;;)
    {
      if (5 != localFileManagerEntity.getCloudType()) {
        break label205;
      }
      return;
      paramnjg.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localFileManagerEntity.strSrcName));
      break;
      label175:
      paramnjg.jdField_b_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramMessageForFile.fileSize, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    }
    label205:
    a(paramnjg, localFileManagerEntity);
    a(paramnjg, paramMessageForFile, localFileManagerEntity);
    paramBaseChatItemLayout.setFailedIconVisable(b(localFileManagerEntity), this);
    paramMessageForFile.status = paramInt;
    if (localFileManagerEntity == null)
    {
      FileManagerUtil.a(paramnjg.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForFile.fileName);
      return;
    }
    FileManagerUtil.a(paramnjg.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileManagerEntity);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return (paramFileManagerEntity != null) && ((paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25)) && ((paramFileManagerEntity.status == 2) || (paramFileManagerEntity.status == 0));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = (MessageForFile)AIOUtils.a(paramView);
    FileManagerEntity localFileManagerEntity1 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (localFileManagerEntity1.getCloudType() == 5) {
      return a(localFileManagerEntity1);
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (16 != localFileManagerEntity1.status)
    {
      if ((localFileManagerEntity1.nOpType == -1) && (localFileManagerEntity1.status == -1)) {
        localQQCustomMenu.a(2131305425, this.jdField_a_of_type_AndroidContentContext.getString(2131362934));
      }
      if (((localFileManagerEntity1.nOpType == 0) || (localFileManagerEntity1.nOpType == 11)) && (localFileManagerEntity1.getCloudType() == 1) && (localFileManagerEntity1.status == 1)) {
        localQQCustomMenu.a(2131305425, this.jdField_a_of_type_AndroidContentContext.getString(2131362934));
      }
      if ((localFileManagerEntity1.nOpType == 11) && (localFileManagerEntity1.getCloudType() == 1) && (localFileManagerEntity1.status == 13)) {
        localQQCustomMenu.a(2131305425, this.jdField_a_of_type_AndroidContentContext.getString(2131362934));
      }
      if (((localFileManagerEntity1.nOpType == 7) || (localFileManagerEntity1.nOpType == 28) || (localFileManagerEntity1.nOpType == 21) || (localFileManagerEntity1.nOpType == 22) || (localFileManagerEntity1.nOpType == 3) || (localFileManagerEntity1.nOpType == 24) || (localFileManagerEntity1.nOpType == 25)) && (localFileManagerEntity1.status == 1)) {
        localQQCustomMenu.a(2131305425, this.jdField_a_of_type_AndroidContentContext.getString(2131362934));
      }
      if (localFileManagerEntity1.nOpType == 1) {
        switch (localFileManagerEntity1.status)
        {
        }
      }
      for (;;)
      {
        a(paramView, localQQCustomMenu);
        if ((localFileManagerEntity1.getCloudType() != 0) && (!a(localFileManagerEntity1)))
        {
          localQQCustomMenu.a(2131305422, this.jdField_a_of_type_AndroidContentContext.getString(2131362748));
          if (AIOUtils.a(5) == 1) {
            localQQCustomMenu.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131362750));
          }
        }
        if ((AIOUtils.a(2) == 1) && (DataLineHandler.a(localFileManagerEntity1))) {
          localQQCustomMenu.a(2131305428, this.jdField_a_of_type_AndroidContentContext.getString(2131362204));
        }
        if ((localFileManagerEntity1.getCloudType() == 0) || (a(localFileManagerEntity1)) || (AIOUtils.a(3) != 1) || (localFileManagerEntity1.getCloudType() == 2)) {
          break label619;
        }
        FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity1.nRelatedSessionId);
        if ((localFileManagerEntity2 == null) || (localFileManagerEntity2.status != 1) || ((localFileManagerEntity2.nOpType != 20) && (localFileManagerEntity2.nOpType != 4) && (localFileManagerEntity2.nOpType != 6))) {
          break;
        }
        ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return localQQCustomMenu.a();
        localQQCustomMenu.a(2131305425, this.jdField_a_of_type_AndroidContentContext.getString(2131362934));
        continue;
        localQQCustomMenu.a(2131305426, this.jdField_a_of_type_AndroidContentContext.getString(2131362932));
        continue;
        localQQCustomMenu.a(2131305427, this.jdField_a_of_type_AndroidContentContext.getString(2131362801));
      }
      localFileManagerEntity1.nRelatedSessionId = 0L;
      localQQCustomMenu.a(2131305421, this.jdField_a_of_type_AndroidContentContext.getString(2131362752));
    }
    label619:
    if (QLog.isColorLevel()) {
      QLog.i("msgrevoke", 2, "FileMenuitem entity.status:" + localFileManagerEntity1.status);
    }
    if ((paramView.isSend()) && ((localFileManagerEntity1.status == 1) || (localFileManagerEntity1.status == -1) || ((localFileManagerEntity1.status == 3) && (localFileManagerEntity1.nOpType == 1)))) {
      a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
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
    if (super.a()) {
      return;
    }
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131296317: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\FileItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */