package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyChannelRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfoNew;
import com.tencent.biz.pubaccount.readinjoy.struct.ChildChannelInfo;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import ici;
import java.util.Iterator;
import java.util.List;

public class ReadinjoyTagsContainer
  extends ViewGroup
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  public View a;
  ChannelInfoNew jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfoNew = null;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  public View b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ReadinjoyTagsContainer.class.getSimpleName();
  }
  
  public ReadinjoyTagsContainer(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    a();
  }
  
  public ReadinjoyTagsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    a();
  }
  
  public ReadinjoyTagsContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    a();
  }
  
  private void a()
  {
    setPadding(ViewUtils.a(8.0F), 0, ViewUtils.a(8.0F), 0);
    setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130904904, this, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131304699);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296792)).setTextSize(0, 14.0F * FontSettingManager.a.density);
    setVisibility(8);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1184275);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  private void a(View paramView, TextView paramTextView, ChannelInfoNew paramChannelInfoNew)
  {
    paramTextView = new GradientDrawable();
    paramTextView.setShape(0);
    paramTextView.setCornerRadius(ViewUtils.a(17.0F));
    paramTextView.setColor(-1);
    paramTextView.setStroke(1, paramChannelInfoNew.d);
    paramChannelInfoNew = new GradientDrawable();
    paramChannelInfoNew.setShape(0);
    paramChannelInfoNew.setCornerRadius(ViewUtils.a(17.0F));
    paramChannelInfoNew.setColor(-2697514);
    paramChannelInfoNew.setStroke(1, -2697514);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramChannelInfoNew);
    localStateListDrawable.addState(StateSet.WILD_CARD, paramTextView);
    paramView.setBackgroundDrawable(localStateListDrawable);
  }
  
  public void a(ChannelInfoNew paramChannelInfoNew)
  {
    String str = paramChannelInfoNew.jdField_a_of_type_JavaLangString;
    if ((str != null) && (TextUtils.isEmpty(str.trim()))) {
      return;
    }
    View localView1 = LayoutInflater.from(getContext()).inflate(2130903761, this, false);
    localView1.setOnClickListener(this);
    ImageView localImageView = (ImageView)localView1.findViewById(2131296790);
    View localView2 = localView1.findViewById(2131297886);
    TextView localTextView = (TextView)localView1.findViewById(2131299980);
    localTextView.setText(str);
    localTextView.setTextSize(0, 14.0F * FontSettingManager.a.density);
    localTextView.setSingleLine();
    localTextView.setTextColor(-8947849);
    if (paramChannelInfoNew.g == 1)
    {
      i = 1;
      if (i == 0) {
        break label218;
      }
      localImageView.setVisibility(0);
      localView2.setPadding(0, ViewUtils.a(4.0F), ViewUtils.a(15.0F), ViewUtils.a(4.0F));
      label146:
      if (paramChannelInfoNew.f != 1) {
        break label253;
      }
    }
    label218:
    label253:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localTextView.setTypeface(localTextView.getTypeface(), 1);
      }
      localTextView.setTextColor(paramChannelInfoNew.e);
      localView1.setTag(paramChannelInfoNew);
      this.jdField_b_of_type_Int += 1;
      super.addView(localView1);
      a(localView2, localTextView, paramChannelInfoNew);
      return;
      i = 0;
      break;
      localView2.setPadding(ViewUtils.a(15.0F), ViewUtils.a(5.0F), ViewUtils.a(15.0F), ViewUtils.a(6.0F));
      localImageView.setVisibility(8);
      break label146;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      paramView = new Intent();
      paramView.putExtra("last_key_words", "");
      paramView.putExtra("from_key", 5);
      paramView.putExtra(ClassificationSearchActivity.c, ClassificationSearchActivity.jdField_a_of_type_Int);
      paramView.setClass(getContext(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a((Activity)getContext(), paramView, null);
      ReportController.b(null, "CliOper", "", "", "0X80067D3", "0X80067D3", 0, 0, "", "", "", ReadInJoyUtils.c());
      return;
    }
    paramView = (ChannelInfoNew)paramView.getTag();
    ReadInJoyActivityHelper.a(getContext(), paramView.jdField_a_of_type_Int, paramView.jdField_a_of_type_JavaLangString, paramView.jdField_b_of_type_Int, 0);
    ReportController.b(null, "dc00899", "qq_kandian", "", "0X8006F44", "0X8006F44", 0, 0, "", "", "", ReadInJoyUtils.a(paramView.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    if (getVisibility() != 8) {
      paramCanvas.drawLine(0.0F, j, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onLayout block " + this.jdField_a_of_type_Boolean + " child:" + getChildCount());
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int k = getPaddingTop();
    int j = getPaddingLeft();
    paramInt2 = getPaddingRight();
    int m = ViewUtils.a(8.0F);
    int i;
    label120:
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      paramInt4 = paramInt3 - paramInt1 - this.jdField_a_of_type_AndroidViewView.getMeasuredWidth() - j - paramInt2;
      paramInt3 = -1;
      i = 0;
      paramInt2 = paramInt4 - 0;
      paramInt1 = 0;
      if (paramInt1 >= this.jdField_b_of_type_Int) {
        break label435;
      }
      localObject = getChildAt(paramInt1);
      i = ((View)localObject).getMeasuredWidth() + m + i;
      if (i <= paramInt4) {
        break label377;
      }
      paramInt1 -= 1;
      paramInt2 = paramInt4 - (i - ((View)localObject).getMeasuredWidth() - m);
    }
    for (;;)
    {
      label174:
      if (this.jdField_a_of_type_Int == 0)
      {
        if (paramInt2 != 0)
        {
          paramInt2 = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + paramInt2, 1073741824);
          paramInt3 = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_AndroidViewView.getMeasuredHeight(), 1073741824);
          localObject = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = -1;
          this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_AndroidViewView.measure(paramInt2, paramInt3);
        }
        this.jdField_a_of_type_AndroidViewView.layout(j, k, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth() + j, this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + k);
      }
      for (paramInt2 = this.jdField_a_of_type_AndroidViewView.getRight() + m;; paramInt2 = j)
      {
        this.jdField_a_of_type_Boolean = true;
        paramInt4 = 0;
        paramInt3 = paramInt2;
        paramInt2 = paramInt4;
        while (paramInt2 <= paramInt1)
        {
          localObject = getChildAt(paramInt2);
          ((View)localObject).layout(paramInt3, k, ((View)localObject).getMeasuredWidth() + paramInt3, ((View)localObject).getMeasuredHeight() + k);
          paramInt3 = paramInt3 + ((View)localObject).getMeasuredWidth() + m;
          paramInt2 += 1;
        }
        paramInt4 = paramInt3 - paramInt1 - j - paramInt2;
        break;
        label377:
        if (i == paramInt4)
        {
          paramInt2 = 0;
          break label174;
        }
        paramInt2 = paramInt4 - i;
        paramInt3 = paramInt1;
        paramInt1 += 1;
        break label120;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      ThreadManager.a(new ici(this, paramInt1), null, false);
      return;
      label435:
      paramInt1 = paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = -2;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    super.measureChildren(paramInt1, paramInt2);
    if (getVisibility() == 0) {}
    for (paramInt1 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + getPaddingTop() + getPaddingBottom();; paramInt1 = 0)
    {
      super.setMeasuredDimension(i, paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onMeasure w:" + getMeasuredWidth() + " h:" + getMeasuredHeight());
      }
      return;
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfoNew = ReadInJoyChannelRecommendManager.a().a(this.jdField_a_of_type_Int);
    setTagInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfoNew);
  }
  
  public void setTagInfo(ChannelInfoNew paramChannelInfoNew)
  {
    if (paramChannelInfoNew == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "set tag info null");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfoNew = paramChannelInfoNew;
      this.jdField_b_of_type_Int = 0;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfoNew != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfoNew.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfoNew.a().size() != 0)) {
        break label164;
      }
      if (this.jdField_a_of_type_Int != 0) {
        break label151;
      }
      removeAllViews();
      setVisibility(0);
      addView(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      Object localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("set tag info,sub tags ");
      if (paramChannelInfoNew.a() == null) {}
      for (int i = 0;; i = paramChannelInfoNew.a().size())
      {
        QLog.d((String)localObject, 2, i);
        break;
      }
      label151:
      removeAllViews();
      setVisibility(8);
      continue;
      label164:
      removeAllViews();
      setVisibility(0);
      paramChannelInfoNew = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfoNew.a().iterator();
      while (paramChannelInfoNew.hasNext())
      {
        localObject = (ChildChannelInfo)paramChannelInfoNew.next();
        localObject = ReadInJoyChannelRecommendManager.a().a(((ChildChannelInfo)localObject).jdField_a_of_type_Int);
        if (localObject != null) {
          a((ChannelInfoNew)localObject);
        }
      }
      addView(this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadinjoyTagsContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */