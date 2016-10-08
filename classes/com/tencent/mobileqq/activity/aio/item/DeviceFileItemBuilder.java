package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nin;
import nio;
import nip;

public class DeviceFileItemBuilder
  extends BaseBubbleBuilder
  implements MessageForDeviceFile.DeviceFileItemCallback
{
  boolean d;
  
  public DeviceFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = false;
  }
  
  private RelativeLayout a(nip paramnip)
  {
    int i = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131296328);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131296384);
    ((RelativeLayout)localObject2).setBackgroundResource(2130840342);
    ((RelativeLayout)localObject2).setPadding(AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramnip.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131296328);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131296385);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131296384);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext, k, k);
    ((AsyncImageView)localObject2).setId(2131296386);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131296385);
    localLayoutParams.addRule(15, 2131296385);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramnip.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131296334);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131296385);
    localLayoutParams.addRule(15, 2131296385);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramnip.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131296388);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(2131428272);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131296386);
    localLayoutParams.addRule(11, 2131296385);
    localLayoutParams.addRule(10, 2131296385);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramnip.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
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
    localLayoutParams.addRule(5, 2131296388);
    localLayoutParams.addRule(6, 2131296390);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramnip.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131296390);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131296385);
    localLayoutParams.addRule(12, 2131296385);
    localLayoutParams.addRule(1, 2131296389);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramnip.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, nip paramnip)
  {
    paramnip.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessageForDeviceFile.srcFileName);
    paramnip.b.setText(FileUtil.a(paramMessageForDeviceFile.fileSize));
    FileManagerUtil.a(paramnip.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, FileManagerUtil.a(paramMessageForDeviceFile.filePath));
    paramnip.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(DeviceMsgHandle.c) == 0)) {
      this.d = true;
    }
    b(paramnip, paramMessageForDeviceFile);
    a(paramnip, paramMessageForDeviceFile);
    paramBaseChatItemLayout.setFailedIconVisable(a(paramMessageForDeviceFile), this);
  }
  
  private void a(nip paramnip, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      paramnip.c.setVisibility(8);
    }
    String str;
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
                                do
                                {
                                  do
                                  {
                                    return;
                                    str = this.jdField_a_of_type_AndroidContentContext.getString(2131362770);
                                    switch (paramMessageForDeviceFile.nFileStatus)
                                    {
                                    case 0: 
                                    case 11: 
                                    default: 
                                      return;
                                    case -1: 
                                      if (paramMessageForDeviceFile.isSend())
                                      {
                                        paramnip.c.setVisibility(8);
                                        return;
                                      }
                                      paramnip.c.setVisibility(0);
                                      paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362869));
                                      return;
                                    case 1: 
                                    case 2: 
                                    case 3: 
                                      if (this.d)
                                      {
                                        paramnip.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131368761));
                                          return;
                                        }
                                        paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371975));
                                        return;
                                      }
                                      paramnip.c.setVisibility(4);
                                      return;
                                    case 4: 
                                      if (paramMessageForDeviceFile.isSend())
                                      {
                                        paramnip.c.setVisibility(4);
                                        return;
                                      }
                                      paramnip.c.setVisibility(0);
                                      paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362222));
                                      return;
                                    case 6: 
                                      paramnip.c.setVisibility(0);
                                      if (paramMessageForDeviceFile.isSend())
                                      {
                                        paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362872));
                                        return;
                                      }
                                      if (this.d)
                                      {
                                        paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371978));
                                        return;
                                      }
                                      paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362873));
                                      return;
                                    case 5: 
                                      paramnip.c.setVisibility(0);
                                      if (paramMessageForDeviceFile.isSend())
                                      {
                                        if (this.d)
                                        {
                                          paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371976));
                                          return;
                                        }
                                        paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362868));
                                        return;
                                      }
                                      if (this.d)
                                      {
                                        paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371979));
                                        return;
                                      }
                                      paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131362866));
                                      return;
                                    case 9: 
                                      paramnip.c.setVisibility(0);
                                    }
                                  } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                                  paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371983));
                                  return;
                                  paramnip.c.setVisibility(0);
                                } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                                paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371984));
                                return;
                                paramnip.c.setVisibility(0);
                              } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                              paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371986));
                              return;
                              paramnip.c.setVisibility(0);
                            } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                            paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371981));
                            return;
                            paramnip.c.setVisibility(0);
                          } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                          paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误01)");
                          return;
                          paramnip.c.setVisibility(0);
                        } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                        paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误02)");
                        return;
                        paramnip.c.setVisibility(0);
                      } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                      paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误03)");
                      return;
                      paramnip.c.setVisibility(0);
                    } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                    paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误04)");
                    return;
                    paramnip.c.setVisibility(0);
                  } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                  paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误05)");
                  return;
                  paramnip.c.setVisibility(0);
                } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
                paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误06)");
                return;
                paramnip.c.setVisibility(0);
              } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
              paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误07)");
              return;
              paramnip.c.setVisibility(0);
            } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
            paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误08)");
            return;
            paramnip.c.setVisibility(0);
          } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
          paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + "\r\n(错误09)");
          return;
          paramnip.c.setVisibility(0);
        } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
        paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371980) + this.jdField_a_of_type_AndroidContentContext.getString(2131371981));
        return;
        paramnip.c.setVisibility(0);
      } while ((paramMessageForDeviceFile.isSend()) || (!this.d));
      paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371982));
      return;
      paramnip.c.setVisibility(0);
    } while (!this.d);
    paramnip.c.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131371977));
  }
  
  private boolean a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      return false;
    }
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  private void b(nip paramnip, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramnip.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131296391);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837559));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131296385);
          localLayoutParams.addRule(12, 2131296384);
          localLayoutParams.setMargins(0, AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramnip.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramnip.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramnip.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramnip.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramnip.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramnip.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)AIOUtils.a(paramView);
    paramView = FileManagerUtil.a((MessageForDeviceFile)localObject2);
    Object localObject1 = new ForwardFileInfo();
    if ((this.d) && (paramView.nFileType != 0)) {
      ((ForwardFileInfo)localObject1).b(10000);
    }
    Intent localIntent;
    for (;;)
    {
      ((ForwardFileInfo)localObject1).d(8);
      ((ForwardFileInfo)localObject1).b(paramView.nSessionId);
      ((ForwardFileInfo)localObject1).d(paramView.fileName);
      ((ForwardFileInfo)localObject1).c(paramView.uniseq);
      ((ForwardFileInfo)localObject1).d(paramView.fileSize);
      ((ForwardFileInfo)localObject1).a(paramView.getFilePath());
      ((ForwardFileInfo)localObject1).b(paramView.Uuid);
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject1);
      localObject1 = new ArrayList();
      if ((paramView.nFileType != 0) && (paramView.nFileType != 1)) {
        break;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if (((ChatMessage)localObject3).msgtype == 61036)
        {
          localObject3 = (MessageForDeviceFile)localObject3;
          if (FileManagerUtil.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(FileManagerUtil.a((MessageForDeviceFile)localObject3).nSessionId));
          }
        }
      }
      ((ForwardFileInfo)localObject1).b(10009);
    }
    localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 102);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    ((nip)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.h;
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    nip localnip = (nip)paramViewHolder;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((nip)paramViewHolder);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localnip);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnClickListener(this);
    localnip.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new nip(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "发送了文件";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131305401) {
        break label36;
      }
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131305411)
      {
        super.b(paramChatMessage);
        return;
      }
    } while (paramInt != 2131297425);
    paramChatMessage = new Bundle();
    paramChatMessage.putInt("forward_type", 0);
    paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramContext.filePath);
    localIntent.putExtra("BUSI_TYPE", 1009);
    localIntent.putExtra("forward_download_image_org_uin", paramContext.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramContext.istroop);
    localIntent.putExtra("forward_photo_isSend", paramContext.issend);
    localIntent.putExtras(paramChatMessage);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((nip)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        localActionSheet.a(2131367889, 5);
        localActionSheet.d(2131367262);
        localActionSheet.a(new nin(this, paramView, localActionSheet));
        localActionSheet.show();
        return;
      }
    } while (this.d);
    ActionSheet localActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
    localActionSheet.a(2131362427);
    localActionSheet.c(2131362428);
    localActionSheet.d(2131367262);
    localActionSheet.a(new nio(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(View paramView, MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramView = (nip)AIOUtils.a(paramView);
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "error get holder in updateview");
      }
    }
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (localMessageForDeviceFile.uniseq != paramMessageForDeviceFile.uniseq);
    localMessageForDeviceFile.msgStatus = paramMessageForDeviceFile.msgStatus;
    localMessageForDeviceFile.nFileStatus = paramMessageForDeviceFile.nFileStatus;
    localMessageForDeviceFile.progress = paramMessageForDeviceFile.progress;
    localMessageForDeviceFile.msg = paramMessageForDeviceFile.msg;
    a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForDeviceFile, paramView);
  }
  
  public void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(2131362941);
      return;
    }
    if (FileUtils.b(paramMessageForDeviceFile.filePath)) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.a();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((nip)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localQQCustomMenu.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
    }
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
    {
      FMToastUtil.a(2131362941);
      return;
    }
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.l = true;
    if (super.a()) {}
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)AIOUtils.a(paramView);
    } while ((paramView.getId() == 2131296318) && (localMessageForDeviceFile != null) && (localMessageForDeviceFile.uint32_src_uin_type == 1));
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131296317: 
    case 2131296334: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\DeviceFileItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */