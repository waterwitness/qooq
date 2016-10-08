package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.StateListDrawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.utils.OpenCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import psx;
import psz;
import pta;
import ptb;
import ptc;
import ptd;
import pte;
import ptf;
import ptg;
import pth;
import pti;
import ptk;
import ptl;
import ptm;

public class ApolloPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener, OpenCallback
{
  public static int a = 0;
  public static final String a = "ApolloPanel";
  public DialogInterface.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public BaseChatPie a;
  public SessionInfo a;
  IResDownloadListener jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener;
  public ApolloMainViewBinder a;
  public ApolloPanelAdapter a;
  public ApolloRecentViewBinder a;
  public ApolloTabAdapter a;
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public QQViewPager a;
  public HorizontalListView a;
  public List a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  int b;
  public List b;
  public List c;
  
  public ApolloPanel(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener = new psx(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ptb(this);
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener = new psx(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ptb(this);
  }
  
  public int a(int paramInt)
  {
    int m = 0;
    int k = m;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      k = m;
      if (paramInt > 0)
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      k = m;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        j += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
        if (paramInt < j) {
          k = ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a() - (j - paramInt);
        }
      }
      else
      {
        return k;
      }
      i += 1;
    }
  }
  
  public ApolloViewBinder a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return null;
    }
    switch (paramInt)
    {
    case 1: 
    default: 
      return new ApolloMainViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    case 0: 
      return new ApolloMainViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    return new ApolloFavViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(1, "actionPanel");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "actionpanel onOpen");
      }
    }
  }
  
  public void a(int paramInt)
  {
    int i = b(paramInt);
    if (this.jdField_a_of_type_JavaUtilList.size() > i)
    {
      i = ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
      if (i > 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(i, false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.onPageSelected(a(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "mRadioGroup is visible count = " + i);
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a();
      if (((List)localObject).size() > paramInt)
      {
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        if (((ApolloActionPackage)localObject).isUpdate)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "clear tab red packageId=" + ((ApolloActionPackage)localObject).packageId + " tabIndex = " + paramInt);
          }
          ((ApolloTabAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          ((ApolloActionPackage)localObject).isUpdate = false;
          ThreadManager.a(new ptd(this, (ApolloActionPackage)localObject), 5, null, true);
        }
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131296961));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)super.findViewById(2131296962));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296968));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296967));
    paramBaseChatPie = new StateListDrawable();
    paramSessionInfo = super.getContext().getResources().getDrawable(2130837752);
    paramBaseChatPie.addState(new int[] { 16842919 }, paramSessionInfo);
    paramSessionInfo = super.getContext().getResources().getDrawable(2130837751);
    paramBaseChatPie.addState(new int[] { -16842919 }, paramSessionInfo);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBaseChatPie);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131296963));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131296969));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter = new ApolloTabAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    super.findViewById(2131296964).setBackgroundColor(super.getContext().getResources().getColor(2131428137));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(super.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout).a(5).a();
      paramBaseChatPie = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("103100.103200");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramBaseChatPie);
      paramBaseChatPie = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.e();
      }
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      if (paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (ApolloManager.b)
      {
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 128, "frist Open Panel");
        ApolloManager.b = false;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "fristOpenPanel get actionList");
        }
      }
    }
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.getLayoutParams()).bottomMargin = ((int)(50.0F * super.getResources().getDisplayMetrics().density));
    setBackgroundColor(super.getResources().getColor(2131428139));
    e();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "init panel done");
    }
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    if ((paramApolloInfo == null) || (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null)) {
      break label11;
    }
    label11:
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localApolloViewBinder.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        if (localApolloViewBinder.l != 2) {
          break label200;
        }
        if (localApolloViewBinder.k != 0)
        {
          localApolloViewBinder.a(0);
          ApolloInfo localApolloInfo = new ApolloInfo();
          localApolloInfo.jdField_b_of_type_Int = 2;
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionName = super.getResources().getString(2131372321);
          localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
          localApolloViewBinder.jdField_a_of_type_JavaUtilList.add(0, localApolloInfo);
        }
        localApolloViewBinder.jdField_a_of_type_JavaUtilList.add(1, paramApolloInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "add action to fav action " + paramApolloInfo.toString());
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter == null) {
        break;
      }
      a(jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      return;
      label200:
      i += 1;
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    long l1 = System.currentTimeMillis();
    if (paramApolloActionData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "updateItemStatus action= " + paramApolloActionData.actionId + " action name =" + paramApolloActionData.actionName);
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "something=null ");
    return;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildCount()) {
          continue;
        }
        localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(i);
        if (!(localViewGroup instanceof ApolloLinearLayout)) {
          break label379;
        }
        if (((ApolloLinearLayout)localViewGroup).a(paramApolloActionData) != null) {
          break label388;
        }
      }
      catch (Exception paramApolloActionData)
      {
        ViewGroup localViewGroup;
        LinearLayout localLinearLayout;
        int k;
        ApolloLinearLayout.ViewHolder localViewHolder;
        ApolloInfo localApolloInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloPanel", 2, "updateItemStatus error:" + paramApolloActionData.toString());
        l2 = System.currentTimeMillis();
      }
      if (j < localViewGroup.getChildCount())
      {
        localLinearLayout = (LinearLayout)localViewGroup.getChildAt(j);
        k = 0;
        if (k < localLinearLayout.getChildCount())
        {
          localViewHolder = (ApolloLinearLayout.ViewHolder)localLinearLayout.getChildAt(k).getTag();
          if (localViewHolder != null)
          {
            localApolloInfo = localViewHolder.a;
            if ((localApolloInfo != null) && (localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class).post(new ptc(this, localViewHolder));
            }
          }
          k += 1;
          continue;
        }
        j += 1;
        continue;
        long l2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "updateItemStatus cost time = " + (l2 - l1));
        return;
      }
      label379:
      i += 1;
      continue;
      label388:
      int j = 0;
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "showAidDialog title=" + paramString1 + " content=" + paramString2 + "rightString=" + paramString3 + " url=" + paramString4);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    l();
    if ("moreInfo".equals(paramString4)) {}
    for (paramString4 = new psz(this, paramString6);; paramString4 = new pta(this, paramString4, paramString5, paramString6))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, paramString1, paramString2, super.getResources().getString(2131370884), paramString3, paramString4, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ThreadManager.a(new pte(this, paramBoolean, paramString), 5, null, true);
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new pth(this, paramList));
    }
  }
  
  public void a(Map paramMap)
  {
    if (paramMap == null) {}
    String str;
    do
    {
      return;
      str = (String)paramMap.get("isSuccess");
      if ("success".equals(str))
      {
        b(Integer.parseInt((String)paramMap.get("offset")));
        return;
      }
    } while (!"fail".equals(str));
    a((String)paramMap.get("title"), (String)paramMap.get("content"), (String)paramMap.get("rightString"), (String)paramMap.get("url"), (String)paramMap.get("isActionBack"), (String)paramMap.get("actionId"));
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      Pair localPair;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder != null) {
                this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.c();
              }
            } while (!paramBoolean);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "actionpanel onOpen response");
            }
          } while (paramObject == null);
          localPair = (Pair)paramObject;
          paramObject = (String)((Pair)paramObject).first;
        } while ((TextUtils.isEmpty((CharSequence)paramObject)) || (!((String)paramObject).equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f())));
        if (2 == ((Integer)localPair.second).intValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
          return;
        }
      } while (1 != ((Integer)localPair.second).intValue());
      ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(false, "panel open apollo");
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
  }
  
  public int b(int paramInt)
  {
    int m = 0;
    int k = m;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      k = m;
      if (paramInt > 0)
      {
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      k = m;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        j += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
        if (paramInt < j) {
          k = i;
        }
      }
      else
      {
        return k;
      }
      i += 1;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, "aio");
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "auth_finish");
    }
    post(new ptm(this, paramInt));
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label102:
    label277:
    label285:
    label388:
    label390:
    label433:
    label538:
    label704:
    do
    {
      ApolloDaoManager localApolloDaoManager;
      List localList2;
      do
      {
        do
        {
          return;
          new ArrayList();
          localArrayList1 = new ArrayList();
          localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        } while (localApolloDaoManager == null);
        localList2 = localApolloDaoManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (localList2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloPanel", 2, "packageList is null.");
      return;
      localArrayList2 = new ArrayList();
      int i = 0;
      if (i < localList2.size())
      {
        ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localList2.get(i);
        ApolloViewBinder localApolloViewBinder = a(localApolloActionPackage.type);
        if (localApolloViewBinder == null) {}
        for (;;)
        {
          i += 1;
          break label102;
          localApolloViewBinder.m = localApolloActionPackage.packageId;
          ArrayList localArrayList3 = new ArrayList();
          Object localObject1;
          List localList1;
          Object localObject2;
          int j;
          if (localApolloActionPackage.type == 2)
          {
            localObject1 = localApolloDaoManager.e();
            localList1 = localApolloDaoManager.d();
            if ((localList1 != null) && (localList1.size() > 0))
            {
              localApolloViewBinder.a(0);
              localApolloInfo = new ApolloInfo();
              localApolloInfo.jdField_b_of_type_Int = 2;
              localObject2 = new ApolloActionData();
              ((ApolloActionData)localObject2).actionName = super.getResources().getString(2131372321);
              localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)localObject2);
              localArrayList3.add(localApolloInfo);
              localApolloInfo = null;
              localObject2 = localObject1;
              localObject1 = localApolloInfo;
              if (localObject2 == null) {
                break label388;
              }
              j = 0;
              if (j >= ((List)localObject2).size()) {
                break label704;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
                break label390;
              }
              if (((ApolloActionData)((List)localObject2).get(j)).sessionType != 2) {
                break label433;
              }
            }
          }
          for (;;)
          {
            j += 1;
            break label285;
            localApolloViewBinder.a(4);
            localObject2 = localObject1;
            localObject1 = null;
            break label277;
            localObject2 = localApolloDaoManager.c(localApolloActionPackage.packageId);
            localObject1 = localApolloDaoManager.d(localApolloActionPackage.packageId);
            localApolloViewBinder.a(0);
            localList1 = null;
            break label277;
            break;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) || (((ApolloActionData)((List)localObject2).get(j)).sessionType != 1)) {
              if ((localApolloActionPackage.type == 3) || (localApolloActionPackage.type == 2) || (((ApolloActionData)((List)localObject2).get(j)).feeType != 7))
              {
                if (((ApolloActionData)((List)localObject2).get(j)).isShow != 0) {
                  break label538;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, "action is hide id = " + ((ApolloActionData)((List)localObject2).get(j)).actionId);
                }
              }
            }
          }
          ApolloInfo localApolloInfo = localApolloViewBinder.a(paramString);
          localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(j));
          localApolloInfo.jdField_a_of_type_Int = localApolloActionPackage.packageId;
          if (localApolloActionPackage.type == 2) {
            if ((localList1 != null) && (localList1.size() > j)) {
              localApolloInfo.jdField_b_of_type_JavaLangString = ((ApolloFavActionData)localList1.get(j)).text;
            }
          }
          for (localApolloInfo.d = ((ApolloFavActionData)localList1.get(j)).textType;; localApolloInfo.d = ((ApolloActionPackageData)((List)localObject1).get(j)).textType)
          {
            do
            {
              localArrayList3.add(localApolloInfo);
              break;
            } while ((localObject1 == null) || (((List)localObject1).size() <= j));
            localApolloInfo.jdField_b_of_type_JavaLangString = ((ApolloActionPackageData)((List)localObject1).get(j)).text;
          }
          if (0 != 0) {
            throw new NullPointerException();
          }
          if ((localArrayList3.size() > 0) || (((ApolloActionPackage)localList2.get(i)).type == 2))
          {
            localApolloViewBinder.a(localArrayList3);
            localArrayList2.add(localApolloViewBinder);
            localArrayList1.add(localList2.get(i));
          }
        }
      }
    } while ((localArrayList2 == null) || (localArrayList2.size() <= 0));
    a(localArrayList1);
    b(localArrayList2);
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new pti(this, paramList));
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while (!paramBoolean) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if (localApolloManager != null)
      {
        localApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
        localApolloManager.a();
      }
    }
  }
  
  public void c(int paramInt)
  {
    int i;
    ApolloManager localApolloManager;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a(paramInt).packageId;
      int j = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a(paramInt).type;
      if ((this.c != null) && (!this.c.contains(Integer.valueOf(i))) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if (j != 2) {
          break label148;
        }
        localApolloManager.a(i, true);
      }
    }
    for (;;)
    {
      this.c.add(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "check panelactionRes packageId =" + i);
      }
      return;
      label148:
      if (localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) == 1) {
        localApolloManager.a(i, false);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    } while ((localQQAppInterface == null) || (localObject == null));
    int i;
    if (((ApolloManager)localQQAppInterface.getManager(152)).b(localQQAppInterface.f()) == 0)
    {
      i = 0;
      if (((SessionInfo)localObject).jdField_a_of_type_Int != 0) {
        break label94;
      }
    }
    label94:
    for (Object localObject = "0";; localObject = "1")
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", i, 0, new String[] { localObject });
      return;
      i = 1;
      break;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      StartupTracker.a("apollo_panel_open", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "dispatchdraw is called");
      }
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      QLog.e("ApolloPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "Thread id =" + Thread.currentThread().getId());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
    ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    localApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
    int j = localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
    int i;
    if (j == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder = new ApolloMainViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(1);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(true);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder);
      i = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      if ((j != 1) || (i == 0)) {
        break;
      }
      b(str);
      return;
      if (j == 1)
      {
        if (!FileUtil.a(ApolloUtil.c))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder = new ApolloMainViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(3);
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(this);
          localApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder);
          i = 0;
        }
      }
      else if (j == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder = new ApolloMainViewBinder(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(1);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder.a(this);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder);
      }
      i = 1;
    }
  }
  
  public void f()
  {
    ThreadManager.a(new ptf(this), 5, null, false);
  }
  
  public void g()
  {
    ThreadManager.a(new ptg(this), 5, null, false);
  }
  
  public void h()
  {
    int j = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      break label20;
      break label20;
    }
    label20:
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localApolloViewBinder.l != 2) {
          break label338;
        }
        List localList = localApolloViewBinder.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() == 0)) {
          break;
        }
        if ((localList.size() == 1) && (localApolloViewBinder.k != 4)) {
          localApolloViewBinder.a(4);
        }
        Object localObject1 = (ApolloInfo)localList.get(0);
        localList.clear();
        localList.add(localObject1);
        Object localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        localObject1 = ((ApolloDaoManager)localObject2).e();
        localObject2 = ((ApolloDaoManager)localObject2).d();
        if ((localObject1 == null) || (localObject2 == null)) {
          break;
        }
        while (j < ((List)localObject1).size())
        {
          ApolloInfo localApolloInfo = localApolloViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
          localApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject1).get(j));
          localApolloInfo.jdField_a_of_type_Int = localApolloViewBinder.m;
          if ((localObject2 != null) && (((List)localObject2).size() > i))
          {
            localApolloInfo.jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject2).get(j)).text;
            localApolloInfo.d = ((ApolloFavActionData)((List)localObject2).get(j)).textType;
          }
          localList.add(localApolloInfo);
          j += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "del action to fav action ");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter == null) {
        break;
      }
      a(jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      return;
      label338:
      i += 1;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
        i += 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if (localApolloManager != null) {
        localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsIResDownloadListener);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloRecentViewBinder = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMainViewBinder = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
  
  public void j()
  {
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ptk(this));
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new ptl(this));
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "click tab shop");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio");
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf("103100.103200"));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      super.getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        super.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "onClick tab postion=" + paramInt);
      }
      setTabSelect(paramInt);
      int i = 0;
      int j = 0;
      while (i < paramInt)
      {
        j += ((ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(i)).a();
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j, false);
      a(j);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onPageScrollStateChange postion=" + paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "pager position = " + paramInt);
    }
    if ((this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt - 1))) || (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "change tab index = " + paramInt);
      }
      setTabSelect(b(paramInt));
      a(paramInt);
    }
    jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.onPageSelected(a(paramInt));
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "recent_show", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
    }
  }
  
  public void setTabSelect(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "tabSelect index = " + paramInt);
    }
    QQAppInterface localQQAppInterface;
    int j;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setSelected(false);
      }
      Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt);
      if (localObject != null)
      {
        ((View)localObject).setSelected(true);
        this.jdField_a_of_type_AndroidViewView = ((View)localObject);
        a(paramInt, (View)localObject);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          localObject = (ApolloActionPackage)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a().get(paramInt);
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          j = ((ApolloActionPackage)localObject).packageId;
          localStringBuilder = new StringBuilder().append("");
          if (!((ApolloActionPackage)localObject).isUpdate) {
            break label257;
          }
        }
      }
    }
    label257:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_tab", j, 0, new String[] { i, "" + ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) });
      c(paramInt);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */