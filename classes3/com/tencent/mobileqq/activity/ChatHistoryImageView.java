package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.AIOImageProviderListener;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.ContentHolder;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kxr;
import kxs;
import kxt;
import kxu;
import kxv;
import kxw;
import kxx;

public class ChatHistoryImageView
  extends ChatHistoryViewBase
  implements DialogInterface.OnCancelListener, Handler.Callback, AIOImageProviderService.AIOImageProviderListener, INetEventHandler, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, GestureSelectGridView.OnSelectListener
{
  static final int jdField_a_of_type_Int = 1;
  static final long jdField_a_of_type_Long = 60000L;
  static final String jdField_a_of_type_JavaLangString = "ChatHistoryImageView";
  static final int jdField_b_of_type_Int = 2;
  static final int g = 100;
  static final int h = 101;
  static final int i = 102;
  static final int j = 1;
  static final int k = 2;
  static final int l = 3;
  static final int m = 4;
  static final int n = 1;
  static final int o = 2;
  private static final int p = 28;
  public Activity a;
  public Dialog a;
  View jdField_a_of_type_AndroidViewView;
  public AIOImageListModel a;
  public AIOImageProviderService a;
  public AIOPhotoListAdapter a;
  public AIORichMediaData a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public WeakReferenceHandler a;
  GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  public ArrayList a;
  public kxx a;
  boolean jdField_a_of_type_Boolean;
  public View b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean;
  int f;
  private int q;
  
  public ChatHistoryImageView()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Int = Integer.MIN_VALUE;
    this.f = Integer.MAX_VALUE;
  }
  
  public Rect a()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.e();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(i2 - i1);
    if (localView != null)
    {
      Rect localRect = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      i1 = localView.getWidth();
      i2 = localView.getHeight();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Point localPoint = new Point();
      if ((i1 > 0) && (i2 > 0))
      {
        localPoint.set(-localView.getScrollX(), -localView.getScrollY());
        if (localViewGroup != null) {
          localViewGroup.getChildVisibleRect(localView, localRect, localPoint);
        }
      }
      return localRect;
    }
    return null;
  }
  
  public View a()
  {
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f, localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.k);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(localAIORichMediaInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int i2;
    int i1;
    if (paramInt2 < paramInt1)
    {
      i2 = paramInt1;
      i1 = paramInt2;
      if (this.f > paramInt2)
      {
        this.f = paramInt2;
        i1 = paramInt2;
        i2 = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = i1;
      for (;;)
      {
        if (paramInt1 > i2) {
          break label173;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
        if (AIORichMediaInfo.class.isInstance(localObject)) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.jdField_e_of_type_Int < paramInt2) {
        this.jdField_e_of_type_Int = paramInt2;
      }
      i2 = paramInt2;
      i1 = paramInt1;
    }
    Object localObject = (AIORichMediaInfo)localObject;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a((AIORichMediaInfo)localObject, bool);
      break;
    }
    label173:
    paramInt1 = i2 + 1;
    if (paramInt1 <= this.jdField_e_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
      if (!AIORichMediaInfo.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((AIORichMediaInfo)localObject, this.jdField_d_of_type_Boolean);
      }
    }
    paramInt1 = this.f;
    if (paramInt1 < i1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
      if (!AIORichMediaInfo.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((AIORichMediaInfo)localObject, this.jdField_d_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[showDialog] type = " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    kxs localkxs = new kxs(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Exception paramString) {}
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131369480, localkxs);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131367262, localkxs);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131364482, new kxt(this));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131367262, localkxs);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131364482, new kxu(this));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131367262, new kxv(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131364482, new kxw(this));
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[onImageDownload] id=" + paramLong + ",subId=" + paramInt1);
    }
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 == 1)
    {
      paramInt1 = localAIOImageListModel.a(paramLong, paramInt1, paramInt2, ???, true);
      if (paramInt2 != 2) {
        break label230;
      }
      if (paramInt1 >= 0)
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
        if (AIORichMediaInfo.class.isInstance(???)) {
          break label106;
        }
      }
    }
    label106:
    label230:
    label295:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ??? = "I:E";
            break;
            ??? = (AIORichMediaInfo)???;
            ???.jdField_a_of_type_Int = 0;
            ???.jdField_a_of_type_Boolean = false;
            paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
            paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
            if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2));
            }
          } while ((this.jdField_a_of_type_Kxx == null) || (this.jdField_a_of_type_Kxx.a == null));
          synchronized (this.jdField_a_of_type_Kxx.a)
          {
            this.jdField_a_of_type_Kxx.a.notifyAll();
            return;
          }
          if (paramInt2 != 1) {
            break label295;
          }
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
        } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
        ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, ???);
        return;
      } while (paramInt2 != 16);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s();
      paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
    } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
    ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, ???);
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent = (AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE");
    if (paramIntent != null) {
      a(paramIntent, true);
    }
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = ((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130904011, null);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300984));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    int i1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493037);
    int i2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493034);
    int i3 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493035);
    this.jdField_c_of_type_Int = ((ViewUtils.a() - i1 * 2 - i2 * 3) / 4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setGravity(3);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(i2);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(i3);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(i1, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), i1, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300985);
    if (AppSetting.j) {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131362778));
    }
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Int, null, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = new AIOImageListModel();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter = new AIOPhotoListAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(true);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService;
    if (this.jdField_a_of_type_Boolean) {}
    for (i1 = 2;; i1 = 0)
    {
      paramIntent.a(i1);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this);
      AccessibilityUtil.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
      return;
    }
  }
  
  public void a(AIORichMediaData paramAIORichMediaData, boolean paramBoolean)
  {
    int i3 = 0;
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.f())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(i1);
      if (!AIORichMediaInfo.class.isInstance(localObject)) {}
      do
      {
        i1 += 1;
        break;
        localObject = (AIORichMediaInfo)localObject;
      } while ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f != paramAIORichMediaData.f) || (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.k != paramAIORichMediaData.k));
    }
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[setSelectionTo] index=" + i1 + ", fist=" + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s() + ", last=" + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.t());
        }
        if ((i1 < this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s()) || (i1 > this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.t())) {}
      }
      else
      {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i1);
        return;
      }
      i1 -= 12;
      if (i1 < 0) {
        i1 = i3;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i1);
        return;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.t();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.f();
      if (((paramInt >= i1 - 28) || (paramInt == i1)) && (this.q != i1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.q);
        }
        this.q = i1;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(0);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    if (!AIORichMediaInfo.class.isInstance(paramAdapterView)) {}
    label80:
    label84:
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramAdapterView = (AIORichMediaInfo)paramAdapterView;
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
          if (paramAdapterView.b() == 1)
          {
            paramInt = 1;
            if (paramInt != 0) {
              break label80;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            if ((!a(paramAdapterView, bool)) || (a(paramView, paramAdapterView))) {
              break label84;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
            return;
            paramInt = 0;
            break;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.e(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.t());
        if (!AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          break;
        }
        paramView = (AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (paramView.jdField_d_of_type_Int != 0) {
          break label407;
        }
        paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.f);
      } while (paramAdapterView == null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
      {
        QQToast.a(BaseApplication.getContext(), 0, 2131371537, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
        return;
      }
      ShortVideoUtils.a(paramAdapterView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_d_of_type_Int, this.jdField_b_of_type_JavaLangString);
      return;
      if (!AIOFileVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break;
      }
      paramView = ((AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a;
    } while (paramView == null);
    paramAdapterView = new ForwardFileInfo();
    paramAdapterView.b(10004);
    Object localObject = paramView.peerUin;
    paramAdapterView.d(paramView.getCloudType());
    paramAdapterView.a(Long.valueOf(((String)localObject).replace("+", "")).longValue());
    paramAdapterView.c(paramView.uniseq);
    paramAdapterView.b(paramView.nSessionId);
    paramAdapterView.d(paramView.fileName);
    paramAdapterView.d(paramView.fileSize);
    paramAdapterView.b(paramView.Uuid);
    paramAdapterView.a(paramView.getFilePath());
    paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, FileBrowserActivity.class);
    paramView.putExtra("fileinfo", paramAdapterView);
    paramView.putExtra("selfSet_leftViewText", "返回");
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramView, 102);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130968620, 2130968621);
    return;
    label407:
    paramView = new Bundle();
    localObject = a();
    if (localObject != null) {
      paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    }
    if (this.jdField_d_of_type_Int == 3000) {
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
      paramView.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramView.putBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", true);
      paramView.putString("uin", this.jdField_b_of_type_JavaLangString);
      paramView.putInt("forward_source_uin_type", this.jdField_d_of_type_Int);
      PeakUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, 2);
      return;
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new kxr(this, paramArrayOfAIORichMediaData, paramInt));
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  boolean a(View paramView, GalleryImage paramGalleryImage)
  {
    Object localObject = (AIOPhotoListAdapter.ContentHolder)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((AIOPhotoListAdapter.ContentHolder)localObject).a;
      localObject = ((AIOPhotoListAdapter.ContentHolder)localObject).b;
      switch (paramGalleryImage.b())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130841002);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130841000);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    int i1 = paramAIORichMediaInfo.b();
    if (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean))) {}
    do
    {
      return false;
      if (!paramBoolean) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a());
    paramAIORichMediaInfo.a(1);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAIORichMediaInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramAIORichMediaInfo);
    for (;;)
    {
      return true;
      paramAIORichMediaInfo.a(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramAIORichMediaInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramAIORichMediaInfo);
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((GalleryImage)localIterator.next()).a(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    }
  }
  
  public void b(int paramInt)
  {
    boolean bool2 = false;
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    } while (!AIORichMediaInfo.class.isInstance(localObject));
    Object localObject = (AIORichMediaInfo)localObject;
    if (((AIORichMediaInfo)localObject).b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_d_of_type_Boolean = bool1;
      bool1 = bool2;
      if (!this.jdField_d_of_type_Boolean) {
        bool1 = true;
      }
      if (a((AIORichMediaInfo)localObject, bool1))
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      }
      this.jdField_e_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryImageView", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131558973);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903453);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298665);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTextView.setText(str);
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Exception localException) {}
      str = localTextView.getResources().getText(2131370858) + str;
      continue;
      str = localTextView.getResources().getText(2131370859) + str;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a();
    if (this.jdField_c_of_type_Boolean) {
      AppNetConnInfo.unregisterNetEventHandler(this);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[download] size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    AIORichMediaInfo localAIORichMediaInfo;
    if (((Iterator)localObject).hasNext())
    {
      localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject).next();
      if (!AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label351;
      }
      if (((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(2) == null) {
        i1 += 1;
      }
    }
    label351:
    for (;;)
    {
      break;
      if ((AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
      {
        continue;
        if (i1 == 0)
        {
          b(2, 0);
          localObject = new kxx(this, this.jdField_a_of_type_JavaUtilArrayList, false, true);
          this.jdField_a_of_type_Kxx = ((kxx)localObject);
          ThreadManager.a((Runnable)localObject, 5, null, true);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
          return;
          if (!this.jdField_c_of_type_Boolean)
          {
            this.jdField_c_of_type_Boolean = true;
            AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this);
          }
          i1 = NetworkUtil.b(BaseApplication.getContext());
          if (i1 == -1)
          {
            a(1, "无网络," + String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131370865), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }) + "。");
            return;
          }
          if (i1 != 1) {
            break;
          }
          b(1, 0);
          localObject = new kxx(this, this.jdField_a_of_type_JavaUtilArrayList, true, true);
          this.jdField_a_of_type_Kxx = ((kxx)localObject);
          ThreadManager.a((Runnable)localObject, 5, null, true);
        }
        a(2, this.jdField_a_of_type_AndroidAppActivity.getString(2131362786));
        return;
      }
    }
  }
  
  public void g()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (!this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectEnd");
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Int = Integer.MIN_VALUE;
    this.f = Integer.MAX_VALUE;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          if ((AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
          {
            i();
            return;
          }
          if (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f, ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.k, this.jdField_d_of_type_Int);
        } while (localObject == null);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
        return;
      } while (!AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f, ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.k, this.jdField_d_of_type_Int);
    } while (localObject == null);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 100: 
    case 101: 
      do
      {
        return bool;
        b(paramMessage.arg1, paramMessage.arg2);
        return true;
      } while (this.jdField_a_of_type_AndroidAppDialog == null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return true;
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131362787, 0).a();
    return true;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[forward]");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    AIORichMediaInfo localAIORichMediaInfo;
    if (localIterator.hasNext())
    {
      localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      if ((AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) == null)) {
        i1 += 1;
      }
    }
    for (;;)
    {
      break;
      if ((AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
      {
        i1 += 1;
        continue;
        if (i1 == 0)
        {
          j();
          return;
        }
        if (i1 != this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryImageView", 2, "[forwardAllImage] hasForwardImg = false");
          }
          a(3, "含有未下载的图片不能转发。");
          return;
        }
        FMToastUtil.a("未下载的图片不能转发");
        return;
      }
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null))
    {
      localObject1 = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + "张图片");
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
            } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
            } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      }
    }
    while (!QLog.isColorLevel())
    {
      AIORichMediaInfo localAIORichMediaInfo;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      Object localObject2 = (AIOFilePicData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).a(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + "张图片");
      }
      ((Bundle)localObject1).putBoolean("sendMultiple", true);
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
        if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
        } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
          } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
          } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
          }
        }
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      return;
    }
    QLog.d("ChatHistoryImageView", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidAppDialog = null;
    if (this.jdField_a_of_type_Kxx != null) {
      this.jdField_a_of_type_Kxx.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if ((AppNetConnInfo.isMobileConn()) && (this.jdField_a_of_type_Kxx != null) && (this.jdField_a_of_type_Kxx.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Kxx.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Kxx.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[onNetChangeEvent] show dialog");
      }
      this.jdField_a_of_type_Kxx.a(true);
      a(4, this.jdField_a_of_type_AndroidAppActivity.getString(2131362786));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatHistoryImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */