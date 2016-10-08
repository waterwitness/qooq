package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import psu;
import psv;
import psw;

public class ApolloLinearLayout
  extends LinearLayout
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public static final String a = "ApolloLinearLayout";
  public static int e;
  int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public BaseChatPie a;
  public SessionInfo a;
  public VasExtensionObserver a;
  public AtomicInteger a;
  private psw jdField_a_of_type_Psw;
  public boolean a;
  int jdField_b_of_type_Int = 4;
  View jdField_b_of_type_AndroidViewView = null;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  public AtomicInteger b;
  private boolean jdField_b_of_type_Boolean;
  int c = 2;
  int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new psv(this);
    super.setOrientation(1);
    this.d = paramInt;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    int j = this.jdField_b_of_type_Int;
    int k = this.c;
    float f = paramContext.getResources().getDisplayMetrics().density;
    int m = (int)((int)((int)((int)((int)(XPanelContainer.c - (XPanelContainer.e * 0.25D + 12.0F * f)) - 14.0F * paramContext.getResources().getDisplayMetrics().scaledDensity * 2.0F) - (12.0F * f + 10.0F * f + 10.0F * f)) - 6.0F * f) - 40.0F * f) / 2;
    e = m;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLinearLayout", 2, "panel height = " + XPanelContainer.c + "imgHeight = " + m + "addHeight=" + XPanelContainer.e);
    }
    paramInt = 0;
    while (paramInt < k)
    {
      paramAttributeSet = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().scaledDensity) + m + (int)(6.0F * f));
      localLayoutParams.leftMargin = ((int)(15.0F * f));
      localLayoutParams.rightMargin = ((int)(15.0F * f));
      paramAttributeSet.setOrientation(0);
      if (paramInt == 0) {
        if (XPanelContainer.e > 0) {
          localLayoutParams.topMargin = ((int)(12.0F * f));
        }
      }
      for (;;)
      {
        int i = 0;
        while (i < j)
        {
          Object localObject = new LinearLayout.LayoutParams(-1, -1);
          ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
          if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
            this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
          }
          View localView = LayoutInflater.from(paramContext).inflate(2130903098, null);
          paramAttributeSet.addView(localView, (ViewGroup.LayoutParams)localObject);
          localObject = new ApolloLinearLayout.ViewHolder();
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297072));
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297074));
          ((ApolloLinearLayout.ViewHolder)localObject).f = ((ImageView)localView.findViewById(2131297071));
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131297073));
          RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          localLayoutParams1.height = m;
          localLayoutParams1.width = m;
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297080));
          ((ApolloLinearLayout.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297075));
          ((ApolloLinearLayout.ViewHolder)localObject).c = ((ImageView)localView.findViewById(2131297078));
          ((ApolloLinearLayout.ViewHolder)localObject).d = ((ImageView)localView.findViewById(2131297081));
          ((ApolloLinearLayout.ViewHolder)localObject).e = ((ImageView)localView.findViewById(2131297077));
          localView.setTag(localObject);
          i += 1;
        }
        localLayoutParams.topMargin = ((int)(12.0F * f));
        continue;
        localLayoutParams.topMargin = ((int)(6.0F * f));
      }
      super.addView(paramAttributeSet, localLayoutParams);
      paramInt += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.e));
  }
  
  private View a(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localLinearLayout.getTop();
      if ((f1 >= 0.0F) && (f1 <= localLinearLayout.getWidth()) && (f2 >= 0.0F) && (f2 < localLinearLayout.getHeight()))
      {
        int j = localLinearLayout.getChildCount() - 1;
        while (j >= 0)
        {
          View localView = localLinearLayout.getChildAt(j);
          float f3 = localLinearLayout.getScrollX() + f1 - localView.getLeft();
          float f4 = localLinearLayout.getScrollY() + f2 - localView.getTop();
          if ((f3 >= 0.0F) && (f3 <= localView.getWidth()) && (f4 >= 0.0F) && (f4 < localView.getHeight())) {
            return localView;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  private boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    paramView = (ViewGroup)localViewGroup.getParent();
    paramRect.offset(localViewGroup.getLeft() - paramView.getScrollX(), localViewGroup.getTop() - paramView.getScrollY());
    return true;
  }
  
  public View a(ApolloActionData paramApolloActionData)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramApolloActionData == null) {}
    int i;
    do
    {
      return (View)localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= super.getChildCount());
    LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
    int j = 0;
    label38:
    if (j < localLinearLayout.getChildCount())
    {
      localObject2 = localLinearLayout.getChildAt(j);
      Object localObject3 = (ApolloLinearLayout.ViewHolder)((View)localObject2).getTag();
      if (localObject3 != null)
      {
        localObject3 = ((ApolloLinearLayout.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo;
        if ((localObject3 != null) && (((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId)) {
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      j += 1;
      break label38;
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < super.getChildCount())
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      int k = localLinearLayout.getChildCount();
      int j = 0;
      while (j < k)
      {
        Object localObject = localLinearLayout.getChildAt(j);
        if (localObject != null)
        {
          localObject = (ApolloLinearLayout.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView != null))
          {
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText("");
            ((ApolloLinearLayout.ViewHolder)localObject).c.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).e.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).d.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = null;
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).f.setVisibility(8);
            if (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
              ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
            }
          }
        }
        j += 1;
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(View paramView)
  {
    Object localObject1 = (ApolloLinearLayout.ViewHolder)paramView.getTag();
    if ((((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLinearLayout", 2, "apollo shop item = " + paramView.getClass());
      }
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf("103100.103200"));
      if (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
          break label181;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "enter_aio_clk", 0, 0, new String[] { "0", "0", "AioMall" });
      }
    }
    label181:
    Object localObject2;
    label942:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "enter_aio_clk", 1, 0, new String[] { "0", "0", "AioMall" });
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "enter_aio_clk", 2, 0, new String[] { "0", "0", "AioMall" });
        return;
        if ((((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_Int == 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloLinearLayout", 2, "apollo fav manager item = " + paramView.getClass());
          }
          paramView = new Intent();
          paramView.putExtra("extra_key_url_append", "&view=customize_action");
          ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView, "aio");
          return;
        }
      } while ((((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null) || (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) || (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status == 0));
      localObject1 = ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo;
      ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = null;
      ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.boy1 = null;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLinearLayout", 2, "click action " + ((ApolloInfo)localObject1).toString());
      }
      if (!ApolloUtil.a(((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloLinearLayout", 2, "action status = done but res don't exist actionid=" + ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
        }
        a(((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", -1, 0, new String[] { "" + ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((ApolloInfo)localObject1).jdField_a_of_type_Int });
        }
      }
      for (;;)
      {
        if ((((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 6) || (((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.limitFree != 0)) {
          break label942;
        }
        localObject2 = (ImageView)paramView.findViewById(2131297058);
        ((RelativeLayout.LayoutParams)((ImageView)localObject2).getLayoutParams()).topMargin = ((int)(e / 2 - 7.0F * super.getResources().getDisplayMetrics().density));
        ((ImageView)localObject2).setVisibility(0);
        paramView.setClickable(false);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        b(((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId));
        return;
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
          if (((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum == 0) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_single_clk", -1, ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), new String[] { "" + ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((ApolloInfo)localObject1).jdField_a_of_type_Int, "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
          } else if (((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 1) {}
        }
      }
    } while ((((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType == 9) && ((((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.limitFree != 1) || (System.currentTimeMillis() <= ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.limitStart) || (System.currentTimeMillis() >= ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.limitEnd)) && (!a(((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData)));
    ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = "";
    ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
        ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramView = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((paramView != null) && (paramView.apolloStatus != 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloLinearLayout", 2, "apolloBaseInfo.apolloStatus:" + paramView.apolloStatus);
          }
          paramView = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
          if (!paramView.getBoolean("is_close_tip_on" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false))
          {
            QQToast.a(BaseApplicationImpl.getContext(), "好友未开通厘米秀，不可见你的形象和动作", 1).a();
            paramView.edit().putBoolean("is_close_tip_on" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true).commit();
          }
        }
      }
    }
    for (;;)
    {
      label1303:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        if ((paramView != null) && (paramView.length() > 99))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131367627, 1);
          return;
          if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
            continue;
          }
          paramView = new ArrayList();
          AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramView);
          if (((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum == 1) {
            if ((paramView.size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)paramView.get(0)).uin) && (((MessageForText.AtTroopMemberInfo)paramView.get(0)).startPos == 0)) {
              localObject2 = com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
            }
          }
        }
      }
    }
    label2011:
    label2054:
    label2422:
    for (;;)
    {
      try
      {
        ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = ((String)localObject2).substring(0, ((MessageForText.AtTroopMemberInfo)paramView.get(0)).textLen);
        if (((MessageForText.AtTroopMemberInfo)paramView.get(0)).textLen >= this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1)
        {
          ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
          ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = (((MessageForText.AtTroopMemberInfo)paramView.get(0)).uin + "");
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          i = 0;
          if (!android.text.TextUtils.isEmpty(((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText)) {
            break label2011;
          }
          j = 2;
          i = j;
          if (android.text.TextUtils.isEmpty(((ApolloInfo)localObject1).jdField_b_of_type_JavaLangString)) {
            break label2422;
          }
          if (((ApolloInfo)localObject1).d != 0) {
            continue;
          }
          i = 6;
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", -1, ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), new String[] { "" + ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((ApolloInfo)localObject1).jdField_a_of_type_Int, "0", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          j = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          String str1 = "" + ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
          String str2 = "655_" + ((ApolloInfo)localObject1).jdField_a_of_type_Int;
          if (!android.text.TextUtils.isEmpty(((ApolloInfo)localObject1).jdField_b_of_type_JavaLangString)) {
            break label2054;
          }
          paramView = "0";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", i, j, new String[] { str1, str2, paramView, ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin });
          break label1303;
        }
        ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = ((String)localObject2).substring(((MessageForText.AtTroopMemberInfo)paramView.get(0)).textLen);
        continue;
      }
      catch (Exception localException)
      {
        int j;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloLinearLayout", 2, "inputText err:" + localException.getMessage());
        }
        ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
        continue;
        i = j;
        if (((ApolloInfo)localObject1).d != 1) {
          break label2422;
        }
      }
      int i = 7;
      continue;
      if (android.text.TextUtils.isEmpty(((ApolloInfo)localObject1).jdField_b_of_type_JavaLangString))
      {
        i = 3;
      }
      else if (((ApolloInfo)localObject1).d == 0)
      {
        i = 4;
      }
      else if (((ApolloInfo)localObject1).d == 1)
      {
        i = 5;
        continue;
        paramView = ((ApolloInfo)localObject1).jdField_b_of_type_JavaLangString;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = ((ApolloInfo)localObject1);
        i = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          i = 11;
        }
        for (;;)
        {
          paramView = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f() == 21) {
            paramView.putExtra("param_troop_send_apollo_msg", true);
          }
          paramView.putExtra("param_is_pop_up_style", true);
          paramView.putExtra("param_troop_send_apollo_msg", true);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramView, 6001);
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", -1, ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), new String[] { "" + ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((ApolloInfo)localObject1).jdField_a_of_type_Int, "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            i = 3;
          }
        }
        if ((((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
          break label1303;
        }
        ((ApolloInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        break label1303;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a((ApolloInfo)localObject1);
        return;
      }
    }
  }
  
  public void a(View paramView, ApolloInfo paramApolloInfo)
  {
    if (paramApolloInfo == null) {}
    do
    {
      return;
      paramApolloInfo = paramApolloInfo.b(super.getContext(), super.getContext().getResources().getDisplayMetrics().density);
    } while (paramApolloInfo == null);
    paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(super.getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(super.getContext());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(super.getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if (paramApolloInfo != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramApolloInfo);
    }
    float f = super.getResources().getDisplayMetrics().density;
    int i = (int)(5.0F * f);
    paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int j = (int)(110.0F * f);
    int k = (int)(110.0F * f);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837551);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(i, i, i, i);
    paramView.bottomMargin = 0;
    paramView.width = ((int)(100.0F * f));
    paramView.height = ((int)(100.0F * f));
    paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    paramView.gravity = 51;
    paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (j - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
    paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - k - (int)(f * 15.0F));
    paramView.width = j;
    paramView.height = k;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
      return;
    }
    paramView = (WindowManager)super.getContext().getSystemService("window");
    i = 24;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = 67108888;
    }
    paramApolloInfo = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
    paramView.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, paramApolloInfo);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    ThreadManager.a(new psu(this, paramApolloActionData), 5, null, false);
  }
  
  public boolean a(ApolloActionData paramApolloActionData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return false;
    }
    Object localObject1 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    HashMap localHashMap = new HashMap();
    new StringBuilder().append(ApolloConstant.M).append("&actionId=").append(paramApolloActionData.actionId).append("&_bid=2282").toString();
    String str;
    Object localObject2;
    if (((ApolloManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()))
    {
      if (((ApolloManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) < paramApolloActionData.vipLevel)
      {
        str = super.getResources().getString(2131372332);
        localObject1 = super.getResources().getString(2131372327);
        localObject2 = super.getResources().getString(2131372329);
        str = String.format(str, new Object[] { Integer.valueOf(paramApolloActionData.vipLevel), paramApolloActionData.actionName });
        localHashMap.put("isSuccess", "fail");
        localHashMap.put("title", localObject1);
        localHashMap.put("content", str);
        localHashMap.put("rightString", localObject2);
        localHashMap.put("url", "moreInfo");
        localHashMap.put("actionId", "" + paramApolloActionData.actionId);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          return false;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "level_alert_show", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramApolloActionData.actionId, "0" });
          }
          paramApolloActionData = ((MqqHandler)localObject1).obtainMessage(45);
          paramApolloActionData.obj = localHashMap;
          paramApolloActionData.sendToTarget();
        }
        return false;
      }
    }
    else
    {
      if ((((ApolloManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) >= paramApolloActionData.vipLevel) || (paramApolloActionData.vipLevel == 1))
      {
        localObject1 = super.getResources().getString(2131372325);
        localObject2 = super.getResources().getString(2131372326);
        if (paramApolloActionData == null) {
          break label920;
        }
        localObject1 = String.format((String)localObject1, new Object[] { paramApolloActionData.actionName });
      }
      label920:
      for (;;)
      {
        str = super.getResources().getString(2131372328);
        Object localObject3 = ApolloConstant.M + "&actionId=" + paramApolloActionData.actionId + "&_bid=2282";
        Object localObject4;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_show", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramApolloActionData.actionId, "0" });
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
        }
        for (;;)
        {
          localHashMap.put("isSuccess", "fail");
          localHashMap.put("title", localObject3);
          localHashMap.put("content", localObject1);
          localHashMap.put("rightString", str);
          localHashMap.put("url", localObject2);
          localHashMap.put("actionId", "" + paramApolloActionData.actionId);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
          {
            return false;
            localObject1 = super.getResources().getString(2131372331);
            localObject3 = super.getResources().getString(2131372326);
            str = super.getResources().getString(2131372328);
            localObject1 = String.format((String)localObject1, new Object[] { Integer.valueOf(paramApolloActionData.vipLevel), paramApolloActionData.actionName });
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
              VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "level_alert_show", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 1, new String[] { "" + paramApolloActionData.actionId, "0" });
            }
            localObject2 = "moreInfo";
          }
          else
          {
            paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
            if (paramApolloActionData != null)
            {
              paramApolloActionData = paramApolloActionData.obtainMessage(45);
              paramApolloActionData.obj = localHashMap;
              paramApolloActionData.sendToTarget();
            }
            return false;
            localObject4 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject4;
          }
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_b_of_type_Boolean))
    {
      ((WindowManager)super.getContext().getSystemService("window")).removeViewImmediate(this.jdField_b_of_type_AndroidWidgetFrameLayout);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloActionData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(paramApolloActionData.actionId, null, null, "actionPanel");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    label565:
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Psw != null)) {
              super.removeCallbacks(this.jdField_a_of_type_Psw);
            }
            if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_Boolean)) {
              a(this.jdField_a_of_type_AndroidViewView);
            }
            if (this.jdField_b_of_type_AndroidViewView != null)
            {
              paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
              if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
              {
                paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
                if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
                  paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
                }
              }
            }
            b();
            this.jdField_a_of_type_AndroidViewView = null;
            return true;
            this.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          } while (this.jdField_a_of_type_AndroidViewView == null);
          if (this.jdField_a_of_type_Psw == null) {
            this.jdField_a_of_type_Psw = new psw(this);
          }
          this.jdField_a_of_type_Psw.a();
          super.postDelayed(this.jdField_a_of_type_Psw, ViewConfiguration.getLongPressTimeout());
          paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.jdField_a_of_type_AndroidViewView.getTag();
        } while ((paramMotionEvent == null) || (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null));
        paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837740);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        return true;
        super.setPressed(false);
        if (this.jdField_a_of_type_Psw != null) {
          super.removeCallbacks(this.jdField_a_of_type_Psw);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
        }
        b();
        this.jdField_a_of_type_AndroidViewView = null;
        return true;
        if ((!this.jdField_a_of_type_Boolean) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label565;
        }
        this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getTag() == null)) {
          break;
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
        }
        paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.jdField_a_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null))
        {
          paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837740);
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        }
      } while ((paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status != 1) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_Int == 1));
      a(this.jdField_a_of_type_AndroidViewView, paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo);
      return true;
      b();
      return true;
    } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidViewView == null) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))));
    this.jdField_a_of_type_AndroidViewView = null;
    return true;
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */