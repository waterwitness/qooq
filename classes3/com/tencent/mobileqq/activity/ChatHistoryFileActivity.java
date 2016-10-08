package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kwj;
import kwk;
import kwl;
import kwm;
import kwn;
import kwo;
import kwp;
import kwq;
import mqq.os.MqqHandler;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "ChatHistoryFIleActivity";
  public static final int b = 1;
  public static final String b = "com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab";
  public static final int c = 2;
  public static final String c = "com.tencent.mobileqq.ChatHistoryFileActivity.back_text";
  public static final int d = 3;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  static final int i = 20;
  static final int j = 1;
  static final int k = 2;
  static final int l = 3;
  static final int m = 1;
  static final int n = 2;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  ChatHistoryFileView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  ChatHistoryStructMsgView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
  public ChatHistoryViewBase a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public QQProgressDialog a;
  public List a;
  public final MqqHandler a;
  public boolean a;
  ImageView b;
  public List b;
  ImageView c;
  public List c;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  String jdField_d_of_type_JavaLangString;
  String e;
  int o;
  private int p;
  
  public ChatHistoryFileActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase = null;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kwn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new kwo(this);
  }
  
  private ChatHistoryViewBase a(int paramInt)
  {
    this.p = paramInt;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView = new ChatHistoryFileView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView.a(paramInt);
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView = new ChatHistoryStructMsgView();
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297425));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297426));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297427));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297428));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130838369);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130838370);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130838369);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localStateListDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a();
      setRightButton(2131367262, this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.b();
    setRightButton(2131370855, this);
    this.jdField_c_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_c_of_type_JavaUtilList.add(paramAIORichMediaInfo);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramFileManagerEntity);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131369480, new kwq(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public void a(Map paramMap, ArrayList paramArrayList)
  {
    String str = " ";
    if (this.o == 0) {}
    for (str = ContactUtils.b(this.app, this.jdField_d_of_type_JavaLangString);; str = this.e) {
      do
      {
        paramMap = ChatActivityFacade.a(this, str, paramArrayList, paramMap);
        if (paramMap != null) {
          break;
        }
        return;
      } while ((this.o != 1) && (this.o != 3000));
    }
    paramMap.mMsg_A_ActionData = null;
    paramArrayList = new Intent();
    paramArrayList.putExtra("forward_type", -3);
    paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
    paramArrayList.putExtra("is_need_show_sources", false);
    ForwardBaseOption.a(this, paramArrayList, 3);
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i2 = this.jdField_a_of_type_JavaUtilList.size() + 0;; i2 = 0)
    {
      int i1 = i2;
      if (this.jdField_b_of_type_JavaUtilList != null) {
        i1 = i2 + this.jdField_b_of_type_JavaUtilList.size();
      }
      i2 = i1;
      if (this.jdField_c_of_type_JavaUtilList != null) {
        i2 = i1 + this.jdField_c_of_type_JavaUtilList.size();
      }
      if (i2 >= 20) {
        bool = true;
      }
      if (bool) {
        FMToastUtil.a(2131362779);
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt, List paramList1, List paramList2, List paramList3)
  {
    int i3 = 0;
    int i1 = 0;
    if (paramList2 != null)
    {
      i1 = 1;
      i3 = 0 + paramList2.size();
    }
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      i1 += 1;
      i3 += paramList1.size();
    }
    for (int i5 = 1;; i5 = 0)
    {
      Object localObject1;
      int i4;
      int i6;
      int i2;
      if (paramList3 != null)
      {
        localObject1 = paramList3.iterator();
        i4 = 0;
        i6 = 0;
        i2 = i1;
        i1 = i6;
        if (((Iterator)localObject1).hasNext())
        {
          i6 = AIOGalleryUtils.a(((AIORichMediaInfo)((Iterator)localObject1).next()).a);
          if ((i4 == 0) && (i6 == 1))
          {
            i4 = 1;
            i2 += 1;
            label132:
            if ((i1 == 0) && (i6 == 2))
            {
              i1 = i2 + 1;
              i2 = 1;
              label152:
              if ((i4 != 0) && (i2 != 0))
              {
                label162:
                i6 = paramList3.size();
                i6 += i3;
                i3 = i2;
                i2 = i6;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i2 == 0)
        {
          FMToastUtil.a(2131362777);
          return false;
          i6 = i2;
          i2 = i1;
          i1 = i6;
          break;
        }
        switch (paramInt)
        {
        }
        for (;;)
        {
          return true;
          if (i1 > 1)
          {
            a(getString(2131362780));
            return false;
          }
          if ((i3 != 0) && (paramList3.size() > 1))
          {
            a(getString(2131362781));
            return false;
          }
          if (paramList2 != null) {
            FileManagerUtil.a(paramList2, this);
          }
          if ((paramList3 != null) && (paramList3.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.h();
            return false;
          }
          if ((paramList1 != null) && (paramList1.size() > 0)) {
            if (paramList1.size() == 1)
            {
              paramList2 = (MessageForStructing)paramList1.get(0);
              if (paramList2.structingMsg != null)
              {
                paramList1 = new Bundle();
                if ((paramList2.structingMsg.source_puin != null) && (!"".equals(paramList2.structingMsg.source_puin))) {
                  paramList1.putString("source_puin", paramList2.structingMsg.source_puin);
                }
                paramList1.putInt("forward_type", -3);
                paramList2.structingMsg.mCommentText = null;
                paramList1.putInt("structmsg_service_id", paramList2.structingMsg.mMsgServiceID);
                paramList1.putByteArray("stuctmsg_bytes", paramList2.structingMsg.getBytes());
                paramList1.putLong("structmsg_uniseq", paramList2.uniseq);
                paramList1.putInt("accostType", paramList2.structingMsg.sourceAccoutType);
                paramList2 = new Intent();
                paramList2.putExtras(paramList1);
                ForwardBaseOption.a(this, paramList2, 3);
              }
            }
            else
            {
              paramList2 = new ArrayList();
              MultiMsgManager.a().b(paramList1);
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367669);
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
              paramList3 = paramList1.iterator();
              while (paramList3.hasNext())
              {
                localObject1 = (ChatMessage)paramList3.next();
                if (!paramList2.contains(((ChatMessage)localObject1).senderuin)) {
                  paramList2.add(((ChatMessage)localObject1).senderuin);
                }
              }
              MultiMsgManager.a().a.clear();
              MultiMsgManager.a().a.addAll(paramList1);
              if (this.o == 1) {
                ((TroopHandler)this.app.a(20)).a(this.jdField_d_of_type_JavaLangString, paramList2, null);
              }
              for (;;)
              {
                paramList1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
                paramList1.arg1 = paramList2.size();
                this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramList1, 30000L);
                break;
                if ((this.o == 0) || (this.o == 3000)) {
                  ((FriendListHandler)this.app.a(1)).a(paramList2);
                }
              }
              if (i1 > 1)
              {
                a(getString(2131362782));
                return false;
              }
              if ((i3 != 0) || (i5 != 0))
              {
                a(getString(2131362783));
                return false;
              }
              if (paramList2 != null)
              {
                paramList1 = this.app.a();
                if (!FileManagerUtil.a()) {
                  break label855;
                }
                FMDialogUtil.a(this, 2131362855, 2131362852, new kwl(this, paramList2, paramList1));
              }
              while ((paramList3 != null) && (paramList3.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.f();
                return false;
                label855:
                paramList2 = paramList2.iterator();
                while (paramList2.hasNext()) {
                  paramList1.b((FileManagerEntity)paramList2.next());
                }
              }
              if (i1 > 1)
              {
                a(getString(2131362785));
                return false;
              }
              if ((i4 != 0) || (i3 != 0) || (i5 != 0))
              {
                a(getString(2131362785));
                return false;
              }
              if ((paramList2 != null) && (paramList2.size() > 0))
              {
                paramList1 = (FileManagerEntity)paramList2.get(0);
                if (paramList2.size() > 1)
                {
                  FMToastUtil.b(FileManagerUtil.d(paramList1.fileName) + "等" + paramList2.size() + "个文件" + getString(2131362814));
                  label1022:
                  paramList1 = this.app.a();
                  paramList2 = paramList2.iterator();
                }
                while (paramList2.hasNext())
                {
                  paramList3 = (FileManagerEntity)paramList2.next();
                  if (FileUtils.b(paramList3.getFilePath()))
                  {
                    paramList1.a(paramList3.getFilePath(), "", this.app.a(), 0, false);
                    continue;
                    FMToastUtil.b(FileManagerUtil.d(paramList1.fileName) + getString(2131362814));
                    break label1022;
                  }
                  paramList1.a(paramList3, String.valueOf(paramList3.peerUin));
                }
                localObject1 = new ArrayList();
                Object localObject2;
                if ((paramList2 != null) && (paramList2.size() > 0))
                {
                  paramList2 = paramList2.iterator();
                  while (paramList2.hasNext())
                  {
                    localObject2 = (FileManagerEntity)paramList2.next();
                    this.app.a().b(((FileManagerEntity)localObject2).nSessionId);
                    localObject2 = this.app.a().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
                    if (localObject2 != null) {
                      ((List)localObject1).add((ChatMessage)localObject2);
                    }
                  }
                }
                if ((paramList3 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
                {
                  paramList2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
                  paramList3 = paramList2.iterator();
                  while (paramList3.hasNext())
                  {
                    localObject2 = (ChatMessage)paramList3.next();
                    if (((ChatMessage)localObject2).msgtype == 63531)
                    {
                      localObject2 = this.app.a().a(((ChatMessage)localObject2).uniseq, ((ChatMessage)localObject2).frienduin, ((ChatMessage)localObject2).istroop);
                      if (localObject2 != null) {
                        this.app.a().b(((FileManagerEntity)localObject2).nSessionId);
                      }
                    }
                  }
                  ((List)localObject1).addAll(paramList2);
                }
                if ((paramList1 != null) && (paramList1.size() > 0)) {
                  ((List)localObject1).addAll(paramList1);
                }
                if (((List)localObject1).size() > 0) {
                  ThreadManager.a(new kwm(this, (List)localObject1), 8, null, true);
                }
              }
            }
          }
        }
        i6 = i1;
        i1 = i2;
        i2 = i6;
        break label152;
        break label132;
        i6 = i1;
        i1 = i2;
        i2 = i6;
        break label162;
        i4 = 0;
        i6 = 0;
        i2 = i3;
        i3 = i6;
      }
    }
  }
  
  public boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    return (this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.contains(paramAIORichMediaInfo));
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilList.contains(paramChatMessage);
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramFileManagerEntity);
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.remove(paramAIORichMediaInfo);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramFileManagerEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (paramInt1 == 1) {
        a();
      }
      Object localObject;
      do
      {
        return;
        localObject = new Intent(this, SendPhotoActivity.class);
        paramIntent = new Bundle(paramIntent.getExtras());
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
        }
        paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
        paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = AIOUtils.a((Intent)localObject, null);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
        paramIntent.putBoolean("send_in_background", false);
        ((Intent)localObject).putExtras(paramIntent);
        startActivity((Intent)localObject);
        break;
        a();
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(paramIntent);
        break;
        localObject = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      } while (localObject == null);
      ((AbsStructMsg)localObject).sourceAccoutType = paramIntent.getIntExtra("accostType", 0);
      String str1 = paramIntent.getStringExtra("uin");
      String str2 = paramIntent.getStringExtra("troop_uin");
      paramInt2 = paramIntent.getIntExtra("uintype", 0);
      if (35 != ((AbsStructMsg)localObject).mMsgServiceID) {
        ShareMsgHelper.a(this.app, str1, str2, paramInt2, (AbsStructMsg)localObject, null);
      } else {
        ThreadManager.a(new kwp(this, str1, str2, paramInt2), 8, null, false);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.o = paramBundle.getIntExtra("uintype", 0);
    this.e = paramBundle.getStringExtra("uinname");
    setContentView(2130903162);
    setTitle(2131367906);
    if (paramBundle.getStringExtra("leftViewText") == null) {
      setLeftViewName(2131369134);
    }
    for (;;)
    {
      TabBarView localTabBarView = (TabBarView)findViewById(2131297421);
      localTabBarView.a(0, "图片/视频");
      localTabBarView.a(1, "文档");
      localTabBarView.a(2, "链接");
      localTabBarView.a(3, "其他");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297424));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297423));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      setRightButton(2131370855, this);
      b();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297422));
      localTabBarView.setOnTabChangeListener(new kwj(this));
      localTabBarView.setSelectedTab(paramBundle.getIntExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab", 0), true);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      return true;
      setLeftViewName(paramBundle);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.e();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a(this.p);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.d();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        QQToast.a(this.app.a(), 2131367672, 0).b(getApplicationContext().getResources().getDimensionPixelSize(2131492908));
        continue;
        paramMessage = this.jdField_a_of_type_JavaUtilList;
        a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.a(paramMessage);
        }
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    finish();
    if (getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false)) {
      overridePendingTransition(0, 2130968812);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i2 = 0;
    switch (paramView.getId())
    {
    default: 
    case 2131297183: 
      do
      {
        return;
        a();
      } while (!this.jdField_a_of_type_Boolean);
      ReportController.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
      return;
    case 2131297425: 
      if (a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
      return;
    case 2131297426: 
      if (a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
      return;
    case 2131297427: 
      if (a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i2 = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    int i1 = i2;
    if (this.jdField_b_of_type_JavaUtilList != null) {
      i1 = i2 + this.jdField_b_of_type_JavaUtilList.size();
    }
    i2 = i1;
    if (this.jdField_c_of_type_JavaUtilList != null) {
      i2 = i1 + this.jdField_c_of_type_JavaUtilList.size();
    }
    if (i2 == 0)
    {
      FMToastUtil.a(2131362777);
      return;
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this, null);
    paramView.a(2131364614);
    paramView.a(getString(2131362753), 3);
    paramView.d(2131367262);
    paramView.a(new kwk(this, paramView));
    paramView.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatHistoryFileActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */