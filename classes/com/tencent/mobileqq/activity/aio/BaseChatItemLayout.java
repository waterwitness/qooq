package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.olympic.view.PaddingAbleImgSpan;
import com.tencent.mobileqq.troop.utils.TroopMemberCharmUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import ncq;

public class BaseChatItemLayout
  extends RelativeLayout
{
  public static int A = 0;
  public static final int B;
  public static int C = 0;
  public static int D = 0;
  public static int E = 0;
  public static final float a;
  public static final int a = 0;
  public static CompoundButton.OnCheckedChangeListener a;
  public static BaseChatItemLayout.OnChatMessageCheckedChangeListener a;
  public static final float b;
  public static final int b = 1;
  public static boolean b = false;
  public static final float c;
  public static final int c = 2131296328;
  @Deprecated
  public static final float d;
  public static final int d = 98;
  public static final int e;
  public static final int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o;
  public static final int p;
  public static final int q;
  public static final int r;
  public static final int s;
  public static final int t;
  public static final int u;
  public static final int v;
  public static final int w;
  public static final int x;
  public static final int y;
  public static final int z;
  int F = 0;
  int G;
  View jdField_a_of_type_AndroidViewView;
  public CheckBox a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public TextView a;
  public URLImageView a;
  public boolean a;
  public ImageView b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ImageView c;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  private TextView h;
  private TextView i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    jdField_d_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131492883);
    jdField_b_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131492868);
    jdField_c_of_type_Float = localBaseApplication.getResources().getDimensionPixelSize(2131492883);
    k = localBaseApplication.getResources().getDimensionPixelSize(2131493038);
    l = localBaseApplication.getResources().getDimensionPixelSize(2131493039);
    m = localBaseApplication.getResources().getDimensionPixelSize(2131493040);
    n = localBaseApplication.getResources().getDimensionPixelSize(2131493041);
    o = localBaseApplication.getResources().getDimensionPixelSize(2131493042);
    p = localBaseApplication.getResources().getDimensionPixelSize(2131493045);
    q = localBaseApplication.getResources().getDimensionPixelSize(2131493046);
    r = localBaseApplication.getResources().getDimensionPixelSize(2131493047);
    s = localBaseApplication.getResources().getDimensionPixelSize(2131493048);
    v = localBaseApplication.getResources().getDimensionPixelSize(2131493057);
    u = localBaseApplication.getResources().getDimensionPixelSize(2131493056);
    t = localBaseApplication.getResources().getDimensionPixelSize(2131493044);
    jdField_e_of_type_Int = localDisplayMetrics.widthPixels;
    jdField_f_of_type_Int = localDisplayMetrics.heightPixels;
    jdField_g_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    jdField_h_of_type_Int = (int)(jdField_g_of_type_Int - 98.0F * jdField_d_of_type_Float);
    jdField_i_of_type_Int = jdField_h_of_type_Int - m - n;
    j = jdField_i_of_type_Int - v * 2;
    w = localBaseApplication.getResources().getDimensionPixelSize(2131493052);
    x = localBaseApplication.getResources().getDimensionPixelSize(2131493053);
    y = localBaseApplication.getResources().getDimensionPixelSize(2131493051);
    z = localBaseApplication.getResources().getDimensionPixelSize(2131493060);
    A = localBaseApplication.getResources().getDimensionPixelSize(2131493064);
    B = jdField_e_of_type_Int - w - x - localBaseApplication.getResources().getDimensionPixelSize(2131493085) * 2;
    C = localBaseApplication.getResources().getDimensionPixelSize(2131493061);
    D = localBaseApplication.getResources().getDimensionPixelSize(2131493062);
    E = localBaseApplication.getResources().getDimensionPixelSize(2131493063);
    jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ncq();
  }
  
  public BaseChatItemLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private SpannableStringBuilder a(CharSequence paramCharSequence1, TextView paramTextView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CharSequence paramCharSequence2, ColorStateList paramColorStateList, boolean paramBoolean4)
  {
    if ((paramCharSequence1 == null) || ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3))) {
      return null;
    }
    paramColorStateList = paramTextView.getEllipsize();
    if (paramColorStateList != null)
    {
      if (!paramBoolean1) {
        break label336;
      }
      paramInt = (int)(paramInt - Math.ceil(13.0F * jdField_d_of_type_Float));
    }
    label326:
    label336:
    for (;;)
    {
      int i1 = paramInt;
      if (paramBoolean2) {
        i1 = (int)(paramInt - Math.ceil(15.0F * jdField_d_of_type_Float));
      }
      if (paramBoolean3) {
        i1 = AIOUtils.a(136.0F, getContext().getResources());
      }
      paramInt = i1;
      if (i1 < 0) {
        paramInt = 0;
      }
      paramCharSequence1 = new SpannableStringBuilder(TextUtils.ellipsize(paramCharSequence1, paramTextView.getPaint(), paramInt, paramColorStateList));
      if (paramBoolean1)
      {
        paramTextView = getResources().getDrawable(2130841847);
        paramTextView.setBounds(0, 0, (int)(13.0F * jdField_d_of_type_Float), (int)(13.0F * jdField_d_of_type_Float));
        paramTextView = new ImageSpan(paramTextView, 0);
        paramColorStateList = new SpannableString(" ");
        paramColorStateList.setSpan(paramTextView, 0, 1, 33);
        if ((paramCharSequence1.length() <= 1) || (paramCharSequence1.charAt(paramCharSequence1.length() - 1) != ':')) {
          break label326;
        }
        paramCharSequence1.insert(paramCharSequence1.length() - 1, paramColorStateList);
      }
      for (;;)
      {
        if ((paramBoolean3) && (!TextUtils.isEmpty(paramCharSequence2))) {
          paramCharSequence1.append(paramCharSequence2);
        }
        if (paramBoolean2)
        {
          paramTextView = new PaddingAbleImgSpan(getResources().getDrawable(2130840987), AIOUtils.a(8.0F, getResources()), 0, 0);
          paramCharSequence2 = new SpannableString(" ");
          paramCharSequence2.setSpan(paramTextView, 0, 1, 33);
          paramCharSequence1.append(paramCharSequence2);
        }
        return paramCharSequence1;
        paramCharSequence1 = new SpannableStringBuilder(paramCharSequence1);
        break;
        paramCharSequence1.append(paramColorStateList);
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (this.G != paramInt)
    {
      this.G = paramInt;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(3, this.G);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams()).addRule(3, this.G);
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.G);
      }
      if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(3, this.G);
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.G);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, this.G);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0)))
      {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.G);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setTopId mTopId = " + this.G);
        }
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    A = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131493064);
    if (paramInt1 == 2)
    {
      paramInt1 = Math.max(jdField_e_of_type_Int, jdField_f_of_type_Int) - paramInt2;
      A += paramInt2;
    }
    for (;;)
    {
      if (paramInt1 != jdField_g_of_type_Int)
      {
        jdField_g_of_type_Int = paramInt1;
        jdField_h_of_type_Int = (int)(jdField_g_of_type_Int - 98.0F * jdField_d_of_type_Float);
        jdField_i_of_type_Int = jdField_h_of_type_Int - m - n;
        j = jdField_i_of_type_Int - v * 2;
      }
      return;
      paramInt1 = Math.min(jdField_e_of_type_Int, jdField_f_of_type_Int);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.topMargin = AIOUtils.a(12.5F, getResources());
      localLayoutParams.bottomMargin = AIOUtils.a(10.5F, getResources());
    }
  }
  
  public void a(Resources paramResources)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      int i1 = AIOUtils.a(18.0F, paramResources);
      paramResources = new RelativeLayout.LayoutParams(i1, i1);
      paramResources.addRule(13, -1);
      if (this.jdField_b_of_type_AndroidWidgetImageView.getParent() != this) {
        break label74;
      }
      removeView(this.jdField_b_of_type_AndroidWidgetImageView);
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_b_of_type_AndroidWidgetImageView, paramResources);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.bringToFront();
      return;
      label74:
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramResources);
    }
  }
  
  void a(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      removeView(this.jdField_a_of_type_AndroidViewView);
      addView(paramView);
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewView.setId(2131296328);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i1 = paramView.getContext().getResources().getDimensionPixelSize(2131493058);
      localLayoutParams.leftMargin = i1;
      localLayoutParams.rightMargin = i1;
      if (this.F == 1)
      {
        localLayoutParams.addRule(0, 2131296318);
        localLayoutParams.addRule(1, 0);
      }
    }
    else
    {
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if ((this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label167;
      }
      paramView.addRule(3, 2131296322);
      paramView.topMargin = 0;
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setBubbleView mTopId = R.id.chat_item_nick_name_layout");
      }
    }
    label167:
    do
    {
      return;
      localLayoutParams.addRule(1, 2131296318);
      localLayoutParams.addRule(0, 0);
      break;
      paramView.addRule(3, this.G);
      paramView.topMargin = o;
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setBubbleView mTopId  = " + this.G);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_d_of_type_AndroidWidgetTextView.setId(2131296321);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_d_of_type_AndroidWidgetTextView.setGravity(17);
        paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
        paramQQAppInterface.bottomMargin = D;
        paramQQAppInterface.addRule(6, 2131296322);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296323);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_d_of_type_AndroidWidgetTextView, paramQQAppInterface);
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        paramQQAppInterface.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
        paramQQAppInterface.rightMargin = 0;
        paramQQAppInterface.addRule(1, 2131296320);
        paramQQAppInterface.addRule(0, 0);
        paramQQAppInterface = TroopMemberCharmUtils.a(paramInt, 1);
        if (paramQQAppInterface == null) {
          break label350;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        i1 = AIOUtils.a(16.0F, getContext().getResources());
        paramQQAppInterface.setBounds(0, 0, i1, i1);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables(paramQQAppInterface, null, null, null);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription("魅力等级" + paramInt);
      }
    }
    label350:
    while ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        int i1;
        return;
        if (paramBoolean2)
        {
          paramQQAppInterface.rightMargin = AIOUtils.a(2.0F, getContext().getResources());
          paramQQAppInterface.leftMargin = 0;
          paramQQAppInterface.addRule(0, 2131296323);
          paramQQAppInterface.addRule(1, 0);
        }
        else
        {
          paramQQAppInterface.leftMargin = E;
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131296318);
          paramQQAppInterface.addRule(0, 0);
          continue;
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (paramBoolean1)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_c_of_type_AndroidWidgetTextView.setId(2131296320);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
        this.jdField_c_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).topMargin = C;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = D;
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.G);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296322);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberLevel mTopId = R.id.chat_item_nick_name_layout");
          }
        }
        addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      if (paramBoolean2)
      {
        ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(2.0F, getContext().getResources());
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131296322);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(4, 2131296323);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
        if (paramInt1 != -1)
        {
          localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
          paramQQAppInterface = null;
          if (localTroopManager != null) {
            paramQQAppInterface = localTroopManager.a(paramInt1, paramString);
          }
          localObject = paramQQAppInterface;
          if (paramQQAppInterface == null)
          {
            paramQQAppInterface = TroopUtils.a(getResources(), paramInt1);
            localObject = paramQQAppInterface;
            if (localTroopManager != null)
            {
              localTroopManager.a(paramInt1, paramString, paramQQAppInterface);
              localObject = paramQQAppInterface;
            }
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("等级" + paramString);
      }
    }
    while ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      for (;;)
      {
        Object localObject;
        TroopManager localTroopManager;
        return;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = E;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131296318);
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
      }
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_h_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_h_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_h_of_type_AndroidWidgetTextView.setId(2131296319);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_h_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_h_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
        this.jdField_h_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_h_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_h_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.jdField_h_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493061);
        localLayoutParams.bottomMargin = this.jdField_h_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493062);
        localLayoutParams.addRule(3, this.G);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296322);
        }
        addView(this.jdField_h_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.leftMargin = this.jdField_h_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493063);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(1, 2131296318);
      localLayoutParams.addRule(0, 0);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt);
      this.jdField_h_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, getContext().getResources()), 0, AIOUtils.a(5.0F, getContext().getResources()), 0);
      if (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    }
    while ((this.jdField_h_of_type_AndroidWidgetTextView == null) || (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void a(boolean paramBoolean, CharSequence paramCharSequence, ColorStateList paramColorStateList)
  {
    if (paramBoolean)
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131296324);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(2131493061);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131493062);
        localLayoutParams.leftMargin = AIOUtils.a(12.0F, getContext().getResources());
        localLayoutParams.addRule(3, this.G);
        localLayoutParams.addRule(1, 2131296322);
        addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_e_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_e_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(jdField_i_of_type_Int);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_e_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      if (paramColorStateList != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        i2 = AIOUtils.a(136.0F, getContext().getResources());
        i1 = i2;
        if (this.jdField_d_of_type_AndroidWidgetTextView != null)
        {
          i1 = i2;
          if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
            i1 = AIOUtils.a(122.0F, getContext().getResources());
          }
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setMaxWidth(i1);
        this.jdField_f_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      }
    }
    while ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))
    {
      RelativeLayout.LayoutParams localLayoutParams;
      int i2;
      int i1;
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence1, ColorStateList paramColorStateList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, ColorStateList paramColorStateList2)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new RightLinearLayout(getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(53);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131296322);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(2131493061);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131493062);
        localLayoutParams.addRule(3, this.G);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296322);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
      if (this.jdField_g_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_g_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_g_of_type_AndroidWidgetTextView.setGravity(48);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_g_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_g_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_g_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_g_of_type_AndroidWidgetTextView, new LinearLayout.LayoutParams(-2, -2));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_f_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_f_of_type_AndroidWidgetTextView.setId(2131296323);
        this.jdField_f_of_type_AndroidWidgetTextView.setGravity(48);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_f_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_f_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_f_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_f_of_type_AndroidWidgetTextView.setMaxWidth(jdField_i_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetTextView, new LinearLayout.LayoutParams(-2, -2));
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (paramBoolean2)
      {
        localLayoutParams.rightMargin = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getDimensionPixelSize(2131493063);
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(0, 2131296318);
        localLayoutParams.addRule(1, 0);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296322);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name_layout");
            }
          }
        }
        paramCharSequence2 = a("", this.jdField_g_of_type_AndroidWidgetTextView, jdField_i_of_type_Int, paramBoolean3, paramBoolean4, paramBoolean5, paramCharSequence2, paramColorStateList2, paramBoolean2);
        if (paramCharSequence2 == null) {
          break label736;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setText(paramCharSequence2);
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        label525:
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramCharSequence1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTag(paramCharSequence1);
        if (paramColorStateList1 != null) {
          this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList1);
        }
      }
    }
    label736:
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0))
          {
            localLayoutParams.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
            localLayoutParams.addRule(1, 2131296321);
          }
          for (;;)
          {
            localLayoutParams.rightMargin = 0;
            localLayoutParams.addRule(0, 0);
            break;
            if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0))
            {
              localLayoutParams.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
              localLayoutParams.addRule(1, 2131296320);
            }
            else if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_h_of_type_AndroidWidgetTextView.getVisibility() == 0))
            {
              localLayoutParams.leftMargin = AIOUtils.a(2.0F, getContext().getResources());
              localLayoutParams.addRule(1, 2131296319);
            }
            else
            {
              localLayoutParams.leftMargin = this.jdField_f_of_type_AndroidWidgetTextView.getContext().getResources().getDimensionPixelSize(2131493063);
              localLayoutParams.addRule(1, 2131296318);
            }
          }
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          break label525;
        } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      } while (this.jdField_a_of_type_AndroidViewView == null);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, this.G);
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setNick mTopId = " + this.G);
  }
  
  public boolean a()
  {
    return this.F == 1;
  }
  
  public void addChildrenForAccessibility(ArrayList paramArrayList)
  {
    int i2;
    int i1;
    do
    {
      try
      {
        super.addChildrenForAccessibility(paramArrayList);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        i2 = getChildCount();
        i1 = 0;
      }
    } while (i1 >= i2);
    View localView = getChildAt(i1);
    if (localView.getVisibility() == 0)
    {
      if (!localView.includeForAccessibility()) {
        break label54;
      }
      paramArrayList.add(localView);
    }
    for (;;)
    {
      i1 += 1;
      break;
      label54:
      localView.addChildrenForAccessibility(paramArrayList);
    }
  }
  
  public void b()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      int i1 = AIOUtils.a(16.0F, getContext().getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
      localLayoutParams.addRule(13, -1);
      if (this.jdField_a_of_type_AndroidWidgetProgressBar.getParent() != this) {
        break label80;
      }
      removeView(this.jdField_a_of_type_AndroidWidgetProgressBar);
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.bringToFront();
      return;
      label80:
      this.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(localLayoutParams);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((jdField_b_of_type_Boolean) && (paramMotionEvent.getAction() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "BaseChatItemLayout onInterceptTouchEvent...down ");
      }
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (jdField_b_of_type_Boolean)
    {
      if (paramMotionEvent.getAction() == 0) {
        if (QLog.isDevelopLevel()) {
          QLog.d("MultiMsg", 4, "BaseChatItemLayout onTouchEvent...down ");
        }
      }
      do
      {
        do
        {
          return true;
        } while (paramMotionEvent.getAction() != 1);
        paramMotionEvent = findViewById(2131296332);
      } while ((paramMotionEvent == null) || (!(paramMotionEvent instanceof CheckBox)) || (paramMotionEvent.getVisibility() != 0));
      paramMotionEvent = (CheckBox)paramMotionEvent;
      if (!paramMotionEvent.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramMotionEvent.setChecked(bool);
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckBox(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = jdField_b_of_type_Boolean;
    if (jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
      {
        this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(getContext());
        this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(2130838117);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setId(2131296332);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(AIOUtils.a(25.0F, getContext().getResources()), AIOUtils.a(25.0F, getContext().getResources()));
        paramBaseChatItemLayout.topMargin = z;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.G);
        addView(this.jdField_a_of_type_AndroidWidgetCheckBox, paramBaseChatItemLayout);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramChatMessage);
        if (!bool) {
          break label244;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        if (!MultiMsgManager.a().a(paramChatMessage)) {
          break label235;
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      }
    }
    label235:
    label244:
    while (this.jdField_a_of_type_AndroidWidgetCheckBox == null)
    {
      for (;;)
      {
        return;
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(AIOUtils.a(25.0F, getContext().getResources()), AIOUtils.a(25.0F, getContext().getResources()));
        paramBaseChatItemLayout.topMargin = z;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.G);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams(paramBaseChatItemLayout);
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      return;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_b_of_type_AndroidWidgetImageView.setId(2131296327);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getContext().getString(2131371207));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = AIOUtils.a(16.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131296328);
      if (this.F != 1) {
        break label155;
      }
      localLayoutParams.addRule(0, 2131296328);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(paramObject);
      return;
      label155:
      localLayoutParams.addRule(1, 2131296328);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      setFailedIconResource(2130837637, paramOnClickListener);
    }
    for (;;)
    {
      if ((jdField_b_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
    }
  }
  
  public void setGrayTipsText(boolean paramBoolean, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_b_of_type_AndroidWidgetTextView.setId(2131296317);
        int i1 = AIOUtils.a(12.0F, getContext().getResources());
        int i2 = AIOUtils.a(5.0F, getContext().getResources());
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840531);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        if (paramColorStateList != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i1, i2, i1, i2);
        this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
        this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
        if (paramInt <= 0)
        {
          paramInt = -2;
          paramColorStateList = new RelativeLayout.LayoutParams(paramInt, -2);
          paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131493050);
          paramInt = AIOUtils.a(45.0F, getContext().getResources());
          paramColorStateList.leftMargin = paramInt;
          paramColorStateList.rightMargin = paramInt;
          paramColorStateList.addRule(14);
          paramColorStateList.addRule(3, 2131296316);
          addView(this.jdField_b_of_type_AndroidWidgetTextView, paramColorStateList);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((paramCharSequence != null) && (!paramCharSequence.equals(this.jdField_b_of_type_AndroidWidgetTextView.getTag())))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
          this.jdField_b_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
        }
        a(2131296317);
        label273:
        if ((this.G != 2131296316) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
          break label398;
        }
        paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        paramCharSequence.topMargin = getContext().getResources().getDimensionPixelSize(2131493049);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramCharSequence);
      }
    }
    label398:
    while ((this.G != 2131296317) || (this.jdField_b_of_type_AndroidWidgetTextView == null))
    {
      return;
      paramInt = AIOUtils.a(paramInt, getContext().getResources());
      break;
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label273;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
      for (paramInt = 2131296316;; paramInt = 0)
      {
        a(paramInt);
        break;
      }
    }
    paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    paramCharSequence.topMargin = AIOUtils.a(10.0F, getContext().getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramCharSequence);
  }
  
  public void setHeadIconVisible(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      if (!paramBoolean) {
        break label56;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      setPendantImageVisible(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label56:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void setHeaderIcon(Drawable paramDrawable)
  {
    int i1 = getContext().getResources().getDimensionPixelSize(2131493060);
    int i2 = AIOUtils.a(5.0F, getContext().getResources());
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131296318);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      int i3 = AIOUtils.a(40.0F, getContext().getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i3, i3);
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131296317);
      if (this.F == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i2;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, this.G);
        addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      return;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.topMargin = i1;
      localLayoutParams.addRule(3, 2131296317);
      if (this.F != 1) {
        break label303;
      }
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = i2;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.addRule(3, this.G);
    }
    label303:
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(11, 0);
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
    for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
    {
      localLayoutParams.rightMargin = 0;
      break;
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    int i1;
    if (this.F != paramInt)
    {
      this.F = paramInt;
      if (paramInt != 1) {
        break label422;
      }
      i1 = 1;
      if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        break label603;
      }
    }
    label218:
    label310:
    label422:
    label493:
    label553:
    label570:
    label586:
    label603:
    for (paramInt = this.jdField_a_of_type_AndroidWidgetTextView.getId();; paramInt = 0)
    {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
        paramInt = this.jdField_b_of_type_AndroidWidgetTextView.getId();
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams()).addRule(9);
        }
        RelativeLayout.LayoutParams localLayoutParams;
        int i2;
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0))
        {
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          i2 = AIOUtils.a(5.0F, getContext().getResources());
          if (i1 != 0)
          {
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            localLayoutParams.rightMargin = i2;
            localLayoutParams.leftMargin = 0;
            localLayoutParams.addRule(3, paramInt);
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
            if (this.F != 1) {
              break label493;
            }
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            localLayoutParams.addRule(3, this.G);
          }
          i2 = paramInt;
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
          {
            i2 = paramInt;
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
            {
              ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).addRule(3, paramInt);
              i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getId();
            }
          }
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
            if (i1 == 0) {
              break label553;
            }
            localLayoutParams.addRule(0, 2131296318);
            localLayoutParams.addRule(1, 0);
            localLayoutParams.addRule(3, i2);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setHearIconPosition mTopId = " + i2);
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
            if (i1 == 0) {
              break label570;
            }
            localLayoutParams.addRule(0, 2131296328);
            localLayoutParams.addRule(1, 0);
          }
        }
        for (;;)
        {
          if (this.jdField_b_of_type_AndroidWidgetImageView != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
            if (i1 == 0) {
              break label586;
            }
            localLayoutParams.addRule(0, 2131296328);
            localLayoutParams.addRule(1, 0);
          }
          return;
          i1 = 0;
          break;
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(11, 0);
          if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {}
          for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, getContext().getResources());; localLayoutParams.leftMargin = i2)
          {
            localLayoutParams.rightMargin = 0;
            break;
          }
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(11, 0);
          if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
          {
            localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
            break label218;
          }
          localLayoutParams.leftMargin = 0;
          break label218;
          localLayoutParams.addRule(1, 2131296318);
          localLayoutParams.addRule(0, 0);
          break label310;
          localLayoutParams.addRule(1, 2131296328);
          localLayoutParams.addRule(0, 0);
        }
        localLayoutParams.addRule(1, 2131296328);
        localLayoutParams.addRule(0, 0);
        return;
      }
    }
  }
  
  public void setPendantImage(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131296330);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, getContext().getResources()), AIOUtils.a(59.0F, getContext().getResources()));
      localLayoutParams.addRule(3, 2131296317);
      if (this.F == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = 0;
        localLayoutParams.leftMargin = 0;
      }
      for (;;)
      {
        localLayoutParams.addRule(3, this.G);
        addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
        return;
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(11, 0);
        if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
          localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
        } else {
          localLayoutParams.leftMargin = 0;
        }
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.addRule(3, 2131296317);
    if (this.F == 1)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      localLayoutParams.addRule(3, this.G);
      break;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.jdField_a_of_type_AndroidWidgetCheckBox != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
        localLayoutParams.leftMargin = AIOUtils.a(25.0F, getContext().getResources());
      } else {
        localLayoutParams.leftMargin = 0;
      }
    }
  }
  
  public void setPendantImageVisible(boolean paramBoolean)
  {
    URLImageView localURLImageView;
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localURLImageView.setVisibility(i1);
      return;
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131296326);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838321));
        i1 = AIOUtils.a(16.0F, getContext().getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
        localLayoutParams.bottomMargin = AIOUtils.a(18.0F, getContext().getResources());
        localLayoutParams.addRule(8, 2131296328);
        if (this.F == 1)
        {
          localLayoutParams.rightMargin = AIOUtils.a(4.0F, getContext().getResources());
          localLayoutParams.addRule(0, 2131296328);
          localLayoutParams.addRule(1, 0);
          addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
      for (;;)
      {
        int i1;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.leftMargin = AIOUtils.a(4.0F, getContext().getResources());
        localLayoutParams.addRule(1, 2131296328);
        localLayoutParams.addRule(0, 0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void setTailMessage(boolean paramBoolean, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (this.jdField_i_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_i_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_i_of_type_AndroidWidgetTextView.setId(2131296329);
        this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundResource(2130838750);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_i_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(3, 2131296328);
        localLayoutParams.addRule(5, 2131296328);
        localLayoutParams.addRule(7, 0);
        addView(this.jdField_i_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramCharSequence != this.jdField_i_of_type_AndroidWidgetTextView.getTag()) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      }
      paramCharSequence = (RelativeLayout.LayoutParams)this.jdField_i_of_type_AndroidWidgetTextView.getLayoutParams();
      if (this.F == 1)
      {
        paramCharSequence.leftMargin = n;
        this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      }
    }
    while (this.jdField_i_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramCharSequence.leftMargin = m;
      }
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setTimeStamp(boolean paramBoolean, long paramLong, ColorStateList paramColorStateList, CharSequence paramCharSequence)
  {
    int i1 = 2131296317;
    if ((paramBoolean) && (paramLong > 0L))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296316);
        i1 = AIOUtils.a(14.0F, getContext().getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 11.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, 0, i1, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(2131493049);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131493050);
        localLayoutParams.addRule(14);
        addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetTextView.setTag(Long.valueOf(0L));
      }
      if (paramColorStateList != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)this.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramLong)
      {
        if (paramCharSequence != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        }
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
          break label282;
        }
        i1 = 2131296317;
        a(i1);
      }
    }
    label282:
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramColorStateList = TimeFormatterUtils.a(getContext(), 3, 1000L * paramLong);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramColorStateList);
        continue;
        i1 = 2131296316;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    for (;;)
    {
      a(i1);
      return;
      i1 = 0;
    }
  }
  
  public void setUnread(boolean paramBoolean, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramOnClickListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnClickListener.topMargin = AIOUtils.a(8.0F, getContext().getResources());
      paramOnClickListener.leftMargin = AIOUtils.a(-3.0F, getContext().getResources());
      paramOnClickListener.addRule(6, 2131296328);
      paramOnClickListener.addRule(1, 2131296328);
      addView(this.jdField_c_of_type_AndroidWidgetImageView, paramOnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843322);
    }
    while (this.jdField_c_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\BaseChatItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */