package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.AnimationTopGestureLayout;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PanelIconLinearLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static Boolean a;
  public static int b;
  public int a;
  public Context a;
  public SharedPreferences a;
  private AnimationTopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout;
  private PanelIconLinearLayout.PanelIconCallback jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ArrayList a;
  private int c = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  }
  
  public PanelIconLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 100;
    setOrientation(0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setBackgroundResource(2130843028);
    b = AIOUtils.a(40.0F, paramContext.getResources());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = BaseApplicationImpl.a().getSharedPreferences("faceu_reddot_click_sp", 4).getBoolean("faceu_reddot_click_sp", false);
    if (QLog.isColorLevel()) {
      QLog.d("faceGuide", 2, "getPtvNeedRed hasClicked =" + bool);
    }
    if (!bool)
    {
      if (ShortVideoGuideUtil.c(paramQQAppInterface)) {
        break label76;
      }
      if (QLog.isColorLevel()) {
        QLog.d("faceGuide", 2, "getPtvNeedRed isloaded false");
      }
    }
    return false;
    label76:
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = PokeItemHelper.a(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = paramSharedPreferences.getBoolean("sp_aio_panel_poke_clicked", false);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(PokeItemHelper.jdField_a_of_type_JavaLangString, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
        }
        return bool2;
        bool2 = false;
      }
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentSharedPreferences);
    removeAllViews();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      RedDotImageView localRedDotImageView = new RedDotImageView(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.gravity = 16;
      localRedDotImageView.setTag(Integer.valueOf(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0]));
      localRedDotImageView.setImageResource(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[2]);
      if (AppSetting.j) {
        localRedDotImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[1]));
      }
      if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i)).length >= 4) {
        localRedDotImageView.setId(((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[3]);
      }
      localRedDotImageView.setOnClickListener(this);
      localRedDotImageView.setSelected(false);
      if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 21)
      {
        if (bool)
        {
          localRedDotImageView.setReddotXOffsetDp(15);
          localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130843322));
          localRedDotImageView.a(true);
        }
      }
      else
      {
        label233:
        if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 6)
        {
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          if (!jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break label396;
          }
          localRedDotImageView.setReddotXOffsetDp(15);
          localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130843322));
          localRedDotImageView.a(true);
        }
        label298:
        if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == 2)
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("103100.103300");
          if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() != 1)) {
            break label411;
          }
          localRedDotImageView.setReddotXOffsetDp(15);
          localRedDotImageView.setRedDotDrawable(getResources().getDrawable(2130843322));
          localRedDotImageView.a(true);
        }
      }
      for (;;)
      {
        addView(localRedDotImageView, localLayoutParams);
        i += 1;
        break;
        localRedDotImageView.a(false);
        break label233;
        label396:
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        localRedDotImageView.a(false);
        break label298;
        label411:
        jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        localRedDotImageView.a(false);
      }
    }
  }
  
  public void a(RelativeLayout paramRelativeLayout, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = 0;
    View localView;
    if (i < getChildCount())
    {
      localView = getChildAt(i);
      if (!localView.getTag().equals(Integer.valueOf(21))) {
        break label221;
      }
      if (PokeItemHelper.a(paramQQAppInterface, paramSessionInfo)) {}
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout = new AnimationTopGestureLayout(paramContext);
      Object localObject = new ViewGroup.LayoutParams(-2, -2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.setMinimumHeight(500);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.setMinimumWidth(300);
      localObject = new int[2];
      localView.getLocationOnScreen((int[])localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.measure(0, 0);
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.getMeasuredWidth();
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.getMeasuredHeight();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(8, 2131297409);
      localLayoutParams.leftMargin = (localObject[0] + localView.getWidth() / 2 - j / 2);
      paramRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.a(localView, 2, 50, 5000, 0, j, k);
    }
    for (;;)
    {
      label221:
      i += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAnimationTopGestureLayout.b();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a(), 0);
    int i = paramSessionInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("PanelIcon", 2, "loadData curType=" + i);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ShortVideoUtils.jdField_a_of_type_Boolean = ShortVideoUtils.b();
    if (i == 3000)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.i);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
      if (AIOPanelUtiles.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.m);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break label1532;
      }
      setCustomHeight(0);
    }
    for (;;)
    {
      a();
      this.c = i;
      return;
      if (i == 1)
      {
        paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(59);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramQQAppInterface = paramQQAppInterface.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.p);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.q);
          if (paramQQAppInterface.isPttShowRoom()) {
            this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.r);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
          break;
        }
        a(AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
        break;
      }
      if ((i == 1022) || (i == 1023) || (i == 1009) || (i == 1024))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.l);
        break;
      }
      if ((i == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if (BmqqSegmentUtil.c(paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.i);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        int j = PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        if (QLog.isColorLevel()) {
          QLog.d(PokeItemHelper.jdField_a_of_type_JavaLangString, 2, "loadData getPokeMsgFoldSwitch=" + j);
        }
        if ((j == 1) || (j == 2)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.u);
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
          if (AIOPanelUtiles.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.m);
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
          if (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PanelIcon", 2, "loadData curType=" + i + "isSingleWayFriend");
          }
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
          break;
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.i);
        }
      }
      if (i == 7100)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.l);
        break;
      }
      if ((i == 1000) || (i == 1004) || (i == 1006))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
        break;
      }
      if (i == 1020)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.l);
        break;
      }
      if (i == 1008) {
        break;
      }
      if (i == 1005)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.l);
        break;
      }
      if (i == 1003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.l);
        break;
      }
      if ((i == 1001) || (i == 1010))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
        break;
      }
      if (i == 1021)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
        break;
      }
      if (i == 6000)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.s);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.t);
        break;
      }
      if (i == 6003)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.s);
        break;
      }
      if (i == 1025)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
        break;
      }
      if (i == 9501)
      {
        if ((paramBaseChatPie == null) || (!(paramBaseChatPie instanceof DeviceMsgChatPie))) {
          break;
        }
        if (((DeviceMsgChatPie)paramBaseChatPie).z()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
        }
        if (((DeviceMsgChatPie)paramBaseChatPie).y())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
        }
        if (((DeviceMsgChatPie)paramBaseChatPie).v())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.o);
          this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.n);
        }
        if (!((DeviceMsgChatPie)paramBaseChatPie).x()) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.s);
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
      break;
      label1532:
      setCustomHeight(b);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    a(paramBoolean);
    a();
    if (paramSessionInfo != null)
    {
      this.c = paramSessionInfo.jdField_a_of_type_Int;
      return;
    }
    this.c = 1;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.b);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.f);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.d);
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.k);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.i);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.g);
    if (AIOPanelUtiles.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.m);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.c);
    this.jdField_a_of_type_JavaUtilArrayList.add(AIOPanelUtiles.j);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback.a(paramView.getTag());
      try
      {
        if (((Integer)paramView.getTag()).intValue() == 2)
        {
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b("103100.103300");
          if ((paramView instanceof RedDotImageView)) {
            ((RedDotImageView)paramView).a(false);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F48", 0, 0, "", "", "", "");
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("PanelIconLinearLayout", 1, "PanelIconLinearLayout.onClick e=" + paramView.getMessage());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_Int);
  }
  
  public void setAllAlpha(float paramFloat)
  {
    int i = 0;
    if (i < getChildCount())
    {
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).setAlpha(paramFloat);
      }
      for (;;)
      {
        i += 1;
        break;
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillAfter(true);
        getChildAt(i).startAnimation(localAlphaAnimation);
      }
    }
  }
  
  public void setAllEnable(boolean paramBoolean)
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void setAllUnSelected()
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setSelected(false);
      i += 1;
    }
  }
  
  public void setChildAlpha(int paramInt, float paramFloat)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localView.setAlpha(paramFloat);
      }
    }
    else {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    localView.startAnimation(localAlphaAnimation);
  }
  
  public void setChildContentDescription(int paramInt, String paramString)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if ((localView != null) && (AppSetting.j)) {
      localView.setContentDescription(paramString);
    }
  }
  
  public void setChildImageSource(int paramInt1, int paramInt2)
  {
    ImageView localImageView = (ImageView)findViewWithTag(Integer.valueOf(paramInt1));
    if (localImageView != null) {
      localImageView.setImageResource(paramInt2);
    }
  }
  
  public void setChildVisible(int paramInt1, int paramInt2)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt1));
    if (localView != null) {
      localView.setVisibility(paramInt2);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    requestLayout();
  }
  
  public void setEnable(int paramInt, boolean paramBoolean)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null) {
      localView.setEnabled(paramBoolean);
    }
  }
  
  public void setPanelIconListener(PanelIconLinearLayout.PanelIconCallback paramPanelIconCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback = paramPanelIconCallback;
  }
  
  public void setSelected(int paramInt)
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getTag().equals(Integer.valueOf(paramInt))) {
        localView.setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        localView.setSelected(false);
      }
    }
  }
  
  public void setShowRed(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getTag().equals(Integer.valueOf(paramInt)))
        {
          ((RedDotImageView)localView).setReddotXOffsetDp(15);
          ((RedDotImageView)localView).setRedDotDrawable(getResources().getDrawable(2130843322));
          ((RedDotImageView)localView).a(paramBoolean);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void setUnSelected(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getTag().equals(Integer.valueOf(paramInt))) {
          localView.setSelected(false);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\panel\PanelIconLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */