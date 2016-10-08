package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import vlm;
import vln;
import vlp;
import vlq;
import vlr;

public class TroopAioMsgNavigateBar
  extends TroopAioAgent
  implements View.OnClickListener, Animation.AnimationListener
{
  public static long a = 0L;
  public static final String a;
  static final int h = 101;
  protected static final int i = 15;
  protected static final int j = 18;
  protected float a;
  public Handler a;
  protected Animation a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public Object a;
  public List a;
  public AtomicBoolean a;
  protected long b;
  View jdField_b_of_type_AndroidViewView;
  protected Animation b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public String b;
  public boolean b;
  public long c;
  View c;
  protected Animation c;
  public String c;
  protected boolean c;
  public int d;
  public long d;
  public String d;
  boolean d;
  public int e;
  String e;
  public boolean e;
  protected int f;
  protected boolean f;
  protected int g;
  public boolean g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopAioMsgNavigateBar.class.getSimpleName();
    jdField_a_of_type_Long = 2147483647L;
  }
  
  public TroopAioMsgNavigateBar()
  {
    this.jdField_b_of_type_Long = jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidOsHandler = new vlm(this, Looper.getMainLooper());
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void a(String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300534));
    }
    Object localObject2;
    if ((this.jdField_e_of_type_Int != 1) && (this.jdField_e_of_type_Int != 17) && (!TextUtils.isEmpty(paramString)))
    {
      if ((!paramString.equals(this.jdField_e_of_type_JavaLangString)) && (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0))
      {
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      int k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
      localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).height = k;
      ((LinearLayout.LayoutParams)localObject1).width = k;
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if ((localObject2 != null) && (((HotChatManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localObject1 != null) && (!((FriendsManager)localObject1).b(paramString)))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true));
        localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
        label241:
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
        return;
      }
      if (this.jdField_e_of_type_Int == 14)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewView.getTag();
        if (!(localObject1 instanceof TroopAioAgent.Message)) {
          break label454;
        }
        long l = ((TroopAioAgent.Message)localObject1).jdField_a_of_type_Long;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l, 0L);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(0);
          label336:
          if ((localObject1 == null) || (!AnonymousChatHelper.a((MessageRecord)localObject1))) {
            break label454;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839798);
        }
      }
    }
    label454:
    for (Object localObject1 = URLDrawable.getDrawable(AnonymousChatHelper.a(AnonymousChatHelper.a((MessageRecord)localObject1).b), (Drawable)localObject2, (Drawable)localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      break;
      localObject1 = null;
      break label336;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString));
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
      break label241;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 10;
  }
  
  private void b(int paramInt)
  {
    TroopInfoManager localTroopInfoManager;
    if (this.jdField_a_of_type_Boolean)
    {
      localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (localTroopInfoManager != null) {
        break label25;
      }
    }
    label25:
    label171:
    label254:
    for (;;)
    {
      return;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Int);
        if (paramInt != 0) {
          break label171;
        }
        this.jdField_e_of_type_Int = -1;
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewAnimationAnimation == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0)) {
          break label254;
        }
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break;
        }
        localTroopInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, this.jdField_e_of_type_Int);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          this.jdField_e_of_type_Int = localTroopInfoManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        } else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          this.jdField_e_of_type_Int = localTroopInfoManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        }
      }
    }
  }
  
  private void i()
  {
    this.jdField_f_of_type_Boolean = false;
    if ((this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) && (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewAnimationAnimation != null))
    {
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_e_of_type_Int != 1) {
        break label115;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    label115:
    do
    {
      return;
      if (this.jdField_e_of_type_Int == 15)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
      if (this.jdField_e_of_type_Int == 10)
      {
        if (((TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
      if (this.jdField_e_of_type_Int == 8)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
    } while ((this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 14) || (this.jdField_e_of_type_Int != 12));
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "", "2000", "2013", "0", false);
  }
  
  private void j()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new vlp(this));
      return;
    }
    i();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (localTroopInfoManager != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          return localTroopInfoManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
          return localTroopInfoManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        }
      }
    }
    return -1;
  }
  
  public int a(int... paramVarArgs)
  {
    int k = 0;
    if (paramVarArgs == null) {
      return 0;
    }
    int i1 = 0;
    int m = 0;
    if (k < paramVarArgs.length)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(paramVarArgs[k]);
      int n = i1;
      int i2 = m;
      if (localView != null)
      {
        if (localView.getVisibility() == 0) {
          break label73;
        }
        i2 = m;
        n = i1;
      }
      for (;;)
      {
        k += 1;
        i1 = n;
        m = i2;
        break;
        label73:
        int i3 = localView.getBottom();
        n = i1;
        i2 = m;
        if (i3 >= m)
        {
          n = paramVarArgs[k];
          i2 = i3;
        }
      }
    }
    return i1;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float += paramFloat;
    if ((this.jdField_a_of_type_Float < 0 - this.jdField_f_of_type_Int / 2) && (this.jdField_e_of_type_Int == 1)) {
      h();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new vlr(this, paramInt));
      return;
    }
    b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      break label4;
    }
    label4:
    label192:
    for (;;)
    {
      return;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        int k = 0;
        if (paramInt2 > 0) {
          if (paramInt2 > this.jdField_a_of_type_AndroidViewView.getMeasuredHeight()) {
            k = paramInt2 - this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + 18;
          }
        }
        for (localLayoutParams.topMargin = k;; localLayoutParams.topMargin = 18)
        {
          if (localLayoutParams.topMargin < 18) {
            break label192;
          }
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) != -1) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_c_of_type_AndroidViewView);
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyViewChange, tipsType:" + paramInt1 + "|" + "aioTopViewHeight:" + paramInt2 + "|" + "fixedHeight:" + k);
          return;
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView == null) {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903875, null);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      int k = a(new int[] { 2131297418, 2131296553, 2131296535 });
      if (k > 0) {
        localLayoutParams.addRule(3, k);
      }
      localLayoutParams.addRule(11);
      localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 41.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131300533);
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(17170445);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setTag(paramObject);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300535));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    a(paramString2);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300536));
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843458);
      if ((paramInt == 1) || (paramInt == 17))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#abc7e4"));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843479);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ff8444"));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843484);
      continue;
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843459);
      if ((paramInt == 1) || ((paramInt == 17) && (!TroopGiftUtil.a(paramObject))))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843478);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ff8444"));
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130843484);
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) || (paramViewGroup == null)) {
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    int k;
    if (paramBoolean)
    {
      k = a(new int[] { 2131296416, 2131297418, 2131296553, 2131296535 });
      if (k > 0) {
        paramViewGroup.addRule(3, k);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return;
      k = a(new int[] { 2131297418, 2131296553, 2131296535 });
      if (k > 0) {
        paramViewGroup.addRule(3, k);
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (!c())) {}
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int k = 0;
    Object localObject;
    while (k < paramList.size())
    {
      localObject = (ChatMessage)paramList.get(k);
      if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(((ChatMessage)localObject).shmsgseq))) {
        this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(((ChatMessage)localObject).shmsgseq));
      }
      k += 1;
    }
    k = this.jdField_a_of_type_JavaUtilList.size();
    if (k != 0)
    {
      paramList = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
      if ((paramList != null) && (paramList.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131372046));
        return;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (k > 99) {}
      for (paramList = "99+";; paramList = Integer.valueOf(k))
      {
        ((TextView)localObject).setText(localResources.getString(2131369585, new Object[] { paramList }));
        return;
      }
    }
    this.jdField_f_of_type_Boolean = false;
    h();
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8);
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString + ".troop.special_msg", 2, "onInit==>mUnreadCount:" + this.jdField_d_of_type_Int + "|mTroopLastReadSeq:" + this.jdField_b_of_type_Long);
    }
    Object localObject;
    if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label371;
      }
      ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_b_of_type_Long, "", 0);
    }
    for (;;)
    {
      localObject = new DisplayMetrics();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_f_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493228));
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_c_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      return;
      label371:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 1, this.jdField_b_of_type_Long, "", 0);
      }
    }
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_b_of_type_Long == jdField_a_of_type_Long) || (this.jdField_c_of_type_Boolean) || (paramList == null) || (paramList.size() == 0)) {}
    label286:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (MsgProxyUtils.a((MessageRecord)localObject2));
      }
      for (long l = ((ChatMessage)localObject2).shmsgseq;; l = 0L)
      {
        if ((l > this.jdField_b_of_type_Long) || (this.jdField_b_of_type_Long == 0L) || (l == 0L)) {
          break label286;
        }
        this.jdField_c_of_type_Boolean = true;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = (MessageForTroopUnreadTips)MessageRecordFactory.a(61527);
        ((MessageForTroopUnreadTips)localObject1).init((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, "", MessageCache.a(), 61527, 1, 0L);
        ((MessageForTroopUnreadTips)localObject1).shmsgseq = this.jdField_b_of_type_Long;
        Object localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localObject1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ArrayList)localObject3, (String)localObject2, false, false);
        localObject2 = new ArrayList();
        localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject2).add((ChatMessage)((Iterator)localObject3).next());
        }
        MsgProxyUtils.a((List)localObject2, (MessageRecord)localObject1, true);
        paramList.clear();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramList.add((ChatMessage)((Iterator)localObject1).next());
        }
        break;
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2;
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0))
    {
      bool2 = false;
      return bool2;
    }
    Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      this.jdField_e_of_type_Int = ((TroopInfoManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((this.jdField_e_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {
        break label282;
      }
      if ((this.jdField_d_of_type_Int < 15) || (this.jdField_d_of_type_Int > 200)) {
        break label382;
      }
      bool1 = true;
    }
    for (;;)
    {
      label109:
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      String str = jdField_a_of_type_JavaLangString + ".troop.special_msg";
      StringBuilder localStringBuilder = new StringBuilder().append("navigateType:").append(this.jdField_e_of_type_Int).append("|isNeedToShow:").append(bool1);
      if (c()) {}
      for (localObject = ", |mMulNativigateSeqList size:" + this.jdField_a_of_type_JavaUtilList.size();; localObject = "")
      {
        QLog.d(str, 2, (String)localObject);
        return bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) {
          break;
        }
        this.jdField_e_of_type_Int = ((TroopInfoManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000);
        break;
        label282:
        if ((this.jdField_e_of_type_Int != 15) && (this.jdField_e_of_type_Int != 8) && (this.jdField_e_of_type_Int != 10) && (this.jdField_e_of_type_Int != 4) && (this.jdField_e_of_type_Int != 17) && (this.jdField_e_of_type_Int != 11) && (this.jdField_e_of_type_Int != 14) && (this.jdField_e_of_type_Int != 13) && (this.jdField_e_of_type_Int != 12) && (this.jdField_e_of_type_Int != 3)) {
          break label382;
        }
        bool1 = true;
        break label109;
      }
      label382:
      bool1 = false;
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    }
    Object localObject = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        localObject = (ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.jdField_c_of_type_AndroidViewView);
        }
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        ((TroopInfoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&" + 3000, 0);
      }
    }
  }
  
  public boolean c()
  {
    return (this.jdField_e_of_type_Int == 10) && (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
    {
      Object localObject = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
      if (localObject != null)
      {
        long l2 = ((TroopAioAgent.Message)localObject).jdField_a_of_type_Long;
        long l1 = l2;
        if (((TroopAioAgent.Message)localObject).jdField_b_of_type_Long != 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((TroopAioAgent.Message)localObject).jdField_b_of_type_Long);
          l1 = l2;
          if (localObject != null) {
            l1 = ((MessageRecord)localObject).shmsgseq;
          }
        }
        if (l1 > 0L)
        {
          int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
          localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(k);
          if ((localObject != null) && (((ChatMessage)localObject).shmsgseq <= l1)) {
            h();
          }
        }
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Int == 1)) {
      h();
    }
  }
  
  public void f()
  {
    ThreadManager.a(new vln(this), 8, null, true);
  }
  
  public void g()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangObject, this.jdField_d_of_type_JavaLangString);
      j();
      return;
    }
    if ((this.jdField_e_of_type_Int == 15) || (this.jdField_e_of_type_Int == 8) || (this.jdField_e_of_type_Int == 10) || (this.jdField_e_of_type_Int == 4) || (this.jdField_e_of_type_Int == 13) || (this.jdField_e_of_type_Int == 11) || (this.jdField_e_of_type_Int == 3)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        setChanged();
        notifyObservers(TroopAioAgent.Message.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Long, this.jdField_d_of_type_Int));
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString + ".troop.special_msg", 2, "notifyUi==>navigateType:" + this.jdField_e_of_type_Int + "|navigateSeq:" + this.jdField_c_of_type_Long);
        }
      }
    }
    for (;;)
    {
      h();
      return;
      if ((this.jdField_e_of_type_Int == 14) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        setChanged();
        MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
        if (localMessageRecord != null) {
          notifyObservers(TroopAioAgent.Message.a(this.jdField_e_of_type_Int, localMessageRecord.shmsgseq, this.jdField_d_of_type_Int));
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString + ".troop.special_msg", 2, "notifyUi==>navigateType:" + this.jdField_e_of_type_Int + "|navigateSeq:" + this.jdField_c_of_type_Long);
        }
      }
    }
  }
  
  public void h()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new vlq(this));
      return;
    }
    b(-1);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_c_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_b_of_type_AndroidViewView == null) || (paramAnimation == null)) {}
    do
    {
      do
      {
        return;
      } while (!paramAnimation.equals(this.jdField_b_of_type_AndroidViewAnimationAnimation));
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    } while ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)));
    setChanged();
    notifyObservers(this.jdField_b_of_type_AndroidViewView.getTag());
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
    this.jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if (this.jdField_e_of_type_Int == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_Oneclk_read", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    for (;;)
    {
      h();
      return;
      if (this.jdField_e_of_type_Int != 15) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atme", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    if (this.jdField_e_of_type_Int == 10)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        break label972;
      }
      if (this.jdField_e_of_type_Boolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
      if (!(this.jdField_b_of_type_AndroidViewView.getTag() instanceof TroopAioAgent.Message)) {
        break label972;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      TroopAioAgent.Message localMessage = (TroopAioAgent.Message)this.jdField_b_of_type_AndroidViewView.getTag();
      k = this.jdField_a_of_type_JavaUtilList.size();
      localMessage.jdField_a_of_type_Long = ((Long)this.jdField_a_of_type_JavaUtilList.remove(0)).longValue();
      int m = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString + ".troop.special_msg.special_attention", 2, "sizeAfterClick:" + m + ", mArrowImageRotated:" + this.jdField_d_of_type_Boolean);
      }
      if (m != 0)
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
          this.jdField_d_of_type_Boolean = true;
        }
        paramView = null;
        if (this.jdField_b_of_type_AndroidWidgetImageView != null)
        {
          long l = ((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
          paramView = (View)localObject;
          if (localObject != null)
          {
            a(((MessageRecord)localObject).senderuin);
            paramView = (View)localObject;
          }
        }
        if (MessageForQQWalletMsg.isRedPacketMsg(paramView))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131372046));
          localMessage.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        if ((k == 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break label659;
        }
        setChanged();
        notifyObservers(localMessage);
        return;
      }
      localMessage.jdField_a_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (m > 99) {}
      for (paramView = "99+";; paramView = Integer.valueOf(m))
      {
        ((TextView)localObject).setText(localResources.getString(2131369585, new Object[] { paramView }));
        break;
      }
      label659:
      if (!localMessage.jdField_a_of_type_Boolean) {
        break label972;
      }
    }
    label972:
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      break;
      if (this.jdField_e_of_type_Int == 8)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_topmsgcue_atall", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 17)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_topmsgcue", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 13)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "", "");
        break;
      }
      if (this.jdField_e_of_type_Int == 14)
      {
        MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
        break;
      }
      if (this.jdField_e_of_type_Int != 12) {
        break;
      }
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "", "2000", "2014", "0", false);
      break;
      h();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopAioMsgNavigateBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */