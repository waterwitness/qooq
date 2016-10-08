package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleConfig.Chartlet;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;
import nfg;
import nfh;
import nfi;
import nfj;
import nfm;

public class XBubbleAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  public static final String c;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private BaseBubbleBuilder.ViewHolder jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder;
  public VipPngPlayAnimationDrawable a;
  private boolean jdField_a_of_type_Boolean = true;
  public View b;
  public VipPngPlayAnimationDrawable b;
  public BubbleInfo.CommonAttrs b;
  public boolean b;
  protected int c;
  public BubbleInfo.CommonAttrs c;
  protected int d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = XBubbleAnimation.class.getSimpleName();
  }
  
  public XBubbleAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      paramInt2 = 0;
      return new int[] { paramInt2, paramInt1 };
    case 0: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 1: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 2: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left)
      {
        paramInt3 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F - paramInt3 / 2.0F);
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 3: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 4: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 5: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 6: 
      if (paramBoolean) {}
      for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
      {
        paramInt3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    }
    if (paramBoolean) {}
    for (paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.left;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.right)
    {
      paramInt3 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.height() / 2.0F - paramInt3 / 2.0F);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      break;
    }
  }
  
  private boolean b(Object[] paramArrayOfObject)
  {
    int j = ((Integer)paramArrayOfObject[0]).intValue();
    long l = ((Long)paramArrayOfObject[1]).longValue();
    if (paramArrayOfObject.length != 3) {}
    Object localObject;
    do
    {
      return false;
      this.d = AIOUtils.a(l, this.jdField_a_of_type_ComTencentWidgetListView.a());
      localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.d));
      if ((localObject == null) || (!(localObject instanceof BaseBubbleBuilder.ViewHolder))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject);
      if ((l == this.jdField_a_of_type_Long) && (this.jdField_c_of_type_Int == j)) {
        break label492;
      }
      paramArrayOfObject = (Pair)paramArrayOfObject[2];
    } while ((paramArrayOfObject == null) || (paramArrayOfObject.first == null) || (((BubbleInfo.CommonAttrs)paramArrayOfObject.first).jdField_a_of_type_ArrayOfJavaLangString == null));
    e();
    this.jdField_a_of_type_Long = l;
    this.jdField_c_of_type_Int = j;
    this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramArrayOfObject.first);
    this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = ((BubbleInfo.CommonAttrs)paramArrayOfObject.second);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.e);
    int i;
    label211:
    label346:
    boolean bool;
    if (j != 0)
    {
      paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
      if (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_Boolean)
      {
        i = 1;
        paramArrayOfObject.l = i;
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView = new nfj(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      this.jdField_b_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.getIntrinsicWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.getIntrinsicHeight());
      if ((this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.e);
        if (j != 0)
        {
          paramArrayOfObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
          if (!this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_Boolean) {
            break label481;
          }
          i = 1;
          paramArrayOfObject.l = i;
        }
        this.jdField_a_of_type_AndroidViewView = new nfm(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
        this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.getIntrinsicWidth(), this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.getIntrinsicHeight());
      }
      bool = a();
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      return bool;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_c_of_type_JavaLangString, 2, "list view item's tag can not cast to ViewHolder, object:" + localObject);
      break;
      i = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.d;
      break label211;
      label481:
      i = this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.d;
      break label346;
      label492:
      bool = false;
    }
  }
  
  protected void a(int paramInt)
  {
    int j = 0;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(paramInt);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d) && (this.jdField_b_of_type_AndroidViewView.getBottom() > 0)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramInt);
        if (!this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.d)
        {
          paramInt = j;
          if (this.jdField_a_of_type_AndroidViewView.getBottom() > 0) {
            break label78;
          }
        }
      }
      for (paramInt = 1;; paramInt = i)
      {
        label78:
        if (paramInt != 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new nfh(this));
        }
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean1) {}
    Drawable localDrawable;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Boolean = paramBoolean1;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder == null);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
    } while (!(localDrawable instanceof VipBubbleDrawable));
    BubbleConfig.Chartlet localChartlet;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
    {
      localChartlet = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a;
      label62:
      if ((localChartlet != null) && (((this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.d)) || ((this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.d))))
      {
        if (!paramBoolean1) {
          break label174;
        }
        ((VipBubbleDrawable)localDrawable).d(true);
      }
    }
    for (;;)
    {
      if (paramBoolean2) {
        ((VipBubbleDrawable)localDrawable).a(paramBoolean1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_c_of_type_JavaLangString, 2, "background alpha changed:" + String.valueOf(paramBoolean1));
      return;
      localChartlet = null;
      break label62;
      label174:
      ((VipBubbleDrawable)localDrawable).d(false);
    }
  }
  
  protected boolean a()
  {
    if ((this.jdField_b_of_type_AndroidViewView == null) && (this.jdField_a_of_type_AndroidViewView == null)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = null;
    Object localObject = AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, this.d));
    boolean bool1;
    label354:
    label392:
    boolean bool2;
    label432:
    label438:
    int i;
    int n;
    int k;
    int j;
    int m;
    if ((localObject != null) && ((localObject instanceof BaseBubbleBuilder.ViewHolder)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = ((BaseBubbleBuilder.ViewHolder)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null)) {
        e();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder == null) || (this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null)) {
        break label1399;
      }
      this.jdField_a_of_type_AndroidGraphicsRect.top = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.left = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getBottom() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
      this.jdField_a_of_type_AndroidGraphicsRect.right = (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_AndroidViewView.getRight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getLeft());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView bubbleRect top=" + this.jdField_a_of_type_AndroidGraphicsRect.top + ",left=" + this.jdField_a_of_type_AndroidGraphicsRect.left + ",bottom=" + this.jdField_a_of_type_AndroidGraphicsRect.bottom + ",right=" + this.jdField_a_of_type_AndroidGraphicsRect.right + ",listView height=" + this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
        break label1160;
      }
      bool1 = true;
      if ((this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig == null) || (this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.e)) {
        break label1166;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = false;
      if (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null)
      {
        if (!this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_JavaLangString.equals(this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_b_of_type_JavaLangString)) {
          break label1184;
        }
        localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
        if (bool1) {
          break label1178;
        }
        bool2 = true;
        ((VipPngPlayAnimationDrawable)localObject).c = bool2;
      }
      localObject = a(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
      i = localObject[1];
      n = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top + i;
      if (bool1) {
        break label1196;
      }
      i = localObject[0];
      i = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left + i;
      k = i;
      if (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null) {
        break label1426;
      }
      localObject = a(this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
      j = localObject[0] - this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right;
      m = localObject[1] + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
      k = i;
      i = m;
    }
    for (;;)
    {
      label604:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mView master_x=" + k + ",master_y=" + n + ",mAttrsFirst.mRect.right=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right + ",mAttrsFirst.mRect.bottom=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom + ",listview.Width=" + this.jdField_a_of_type_ComTencentWidgetListView.getWidth() + ",listview.Height=" + this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
      }
      if ((k >= -this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right) && (k <= this.jdField_a_of_type_ComTencentWidgetListView.getWidth()) && (n >= -this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom))
      {
        k -= this.jdField_b_of_type_AndroidViewView.getLeft();
        m = n - this.jdField_b_of_type_AndroidViewView.getTop();
        if ((k != 0) || (m != 0))
        {
          this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(k);
          this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(m);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mView.offsetLeftAndRight " + k + ",mView.offsetTopAndBottom " + m);
          }
        }
      }
      label860:
      for (bool1 = true;; bool1 = false)
      {
        if ((this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs != null) && (this.jdField_a_of_type_AndroidViewView != null) && (bool1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mLinkView x=" + j + ",y=" + i + ",mRect.right=" + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right + ",mRect.bottom=" + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom + ",listview.Width=" + this.jdField_a_of_type_ComTencentWidgetListView.getWidth() + ",listview.Height=" + this.jdField_a_of_type_ComTencentWidgetListView.getHeight());
          }
          if ((j < -this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right) || (j > this.jdField_a_of_type_ComTencentWidgetListView.getWidth()) || (i < -this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom)) {
            break;
          }
          j -= this.jdField_a_of_type_AndroidViewView.getLeft();
          i -= this.jdField_a_of_type_AndroidViewView.getTop();
          if ((j != 0) || (i != 0))
          {
            this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(j);
            this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mLinkView.offsetLeftAndRight " + j + ",mLinkView.offsetTopAndBottom " + i);
            }
          }
          for (;;)
          {
            return true;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e(jdField_c_of_type_JavaLangString, 2, "list view item's tag can not cast to ViewHolder, object:" + localObject);
            break;
            label1160:
            bool1 = false;
            break label354;
            label1166:
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = bool1;
            break label392;
            label1178:
            bool2 = false;
            break label432;
            label1184:
            this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c = bool1;
            break label438;
            label1196:
            m = localObject[0] - this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right;
            k = m;
            if (this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs == null) {
              break label1426;
            }
            localObject = a(this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.f, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.bottom, bool1);
            j = localObject[0] + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.left;
            i = localObject[1] + this.jdField_c_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs.jdField_a_of_type_AndroidGraphicsRect.top;
            k = m;
            break label604;
            if (!QLog.isColorLevel()) {
              break label860;
            }
            QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mView dx=" + k + ",dy=" + m);
            break label860;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_c_of_type_JavaLangString, 2, "bindView mLinkView dx=" + j + ",dy=" + i);
            }
          }
          label1399:
          this.jdField_a_of_type_AndroidOsHandler.post(new nfg(this));
          return false;
        }
        return bool1;
      }
      label1426:
      i = 0;
      j = 0;
    }
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
    }
    if ((paramBoolean) && (this.jdField_b_of_type_Boolean))
    {
      a();
      return true;
    }
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    ThreadManager.c().postDelayed(new nfi(this, paramVarArgs), 100L);
    return true;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a();
    }
  }
  
  public void d()
  {
    e();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "now stop current animation!");
    }
    this.jdField_b_of_type_Boolean = false;
    c();
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\anim\XBubbleAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */