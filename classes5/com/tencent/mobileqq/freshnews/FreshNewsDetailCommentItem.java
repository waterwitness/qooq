package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.CustomImgView;
import spk;
import spl;

public class FreshNewsDetailCommentItem
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "FreshNewsDetailCommentItem";
  private int jdField_a_of_type_Int;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private DatingCommentTextView jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView;
  private FreshNewsComment jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment;
  private FreshNewsDetailCommentItem.IFreshNewsDetailCommentItemCallback jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentItem$IFreshNewsDetailCommentItemCallback;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  public boolean a;
  private TextView b;
  
  public FreshNewsDetailCommentItem(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FreshNewsDetailActivity)) {}
    for (this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((FreshNewsDetailActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a;; this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)
    {
      a(paramContext);
      return;
    }
  }
  
  public FreshNewsDetailCommentItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FreshNewsDetailActivity)) {}
    for (this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((FreshNewsDetailActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a;; this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)
    {
      a(paramContext);
      return;
    }
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130904164, this);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)paramContext.findViewById(2131297019));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131301656));
    this.b = ((TextView)paramContext.findViewById(2131296829));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView = ((DatingCommentTextView)paramContext.findViewById(2131301657));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131301658);
    paramContext = getResources().getDrawable(2130840650);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(paramContext);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    setOnClickListener(this);
    setOnLongClickListener(new spk(this));
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface))
    {
      setBackgroundResource(2130840684);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131427637);
    }
    for (;;)
    {
      int i = Color.parseColor("#d5d5d5");
      this.jdField_a_of_type_AndroidContentResColorStateList = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { i, 0 });
      return;
      setBackgroundResource(2130840682);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130843282);
    }
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_Long);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(new BitmapDrawable(paramBitmap));
  }
  
  public void a(BaseActivity paramBaseActivity, FaceDecoder paramFaceDecoder, FreshNewsDetailCommentItem.IFreshNewsDetailCommentItemCallback paramIFreshNewsDetailCommentItemCallback, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentItem$IFreshNewsDetailCommentItemCallback = paramIFreshNewsDetailCommentItemCallback;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
  }
  
  public void a(FreshNewsComment paramFreshNewsComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment = paramFreshNewsComment;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.e);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_JavaLangString))
    {
      this.b.setText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.c);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.c;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.b;
      localObject3 = new StringBuilder();
      if ((localObject1 == null) || (TextUtils.isEmpty(((FreshNewsStranger)localObject1).jdField_a_of_type_JavaLangString))) {
        break label298;
      }
      ((StringBuilder)localObject3).append(String.format("回复 %s : ", new Object[] { ((FreshNewsStranger)localObject1).jdField_a_of_type_JavaLangString }));
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject2 = new QQText((CharSequence)localObject3, 3, 16);
      int j = ((FreshNewsStranger)localObject1).jdField_a_of_type_JavaLangString.length();
      localObject3 = new spl(this);
      if (!this.jdField_a_of_type_Boolean) {
        break label283;
      }
      i = Color.parseColor("#7699bb");
      label180:
      ((QQText)localObject2).setSpan(new DatingCommentTextView.TouchableSpan((View.OnClickListener)localObject3, ColorStateList.valueOf(i), this.jdField_a_of_type_AndroidContentResColorStateList), 3, 3 + j, 33);
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setTag(localObject1);
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText((CharSequence)localObject2);
    }
    for (;;)
    {
      if (!paramFreshNewsComment.jdField_a_of_type_Boolean) {
        break label340;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      localObject1 = new QQText(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsStranger.jdField_a_of_type_JavaLangString, 3, 16);
      this.b.setText((CharSequence)localObject1);
      break;
      label283:
      i = getResources().getColor(2131427634);
      break label180;
      label298:
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = new QQText(((StringBuilder)localObject3).toString(), 3, 16);
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setMovementMethod(null);
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView.setText((CharSequence)localObject1);
    }
    label340:
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentItem$IFreshNewsDetailCommentItemCallback.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment);
      return;
    case 2131296829: 
    case 2131297019: 
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentItem$IFreshNewsDetailCommentItemCallback.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailCommentItem$IFreshNewsDetailCommentItemCallback.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsComment);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsDetailCommentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */