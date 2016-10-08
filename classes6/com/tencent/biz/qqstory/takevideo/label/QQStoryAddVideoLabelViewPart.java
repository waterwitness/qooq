package com.tencent.biz.qqstory.takevideo.label;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XEditTextEx;
import com.tribe.async.dispatch.IEventReceiver;
import iyf;

public class QQStoryAddVideoLabelViewPart
  implements IEventReceiver
{
  protected static final int a = 30;
  public static final String a = "Q.qqstory.record.label.QQStoryAddVideoLabelView";
  public View.OnClickListener a;
  public final View a;
  protected ImageButton a;
  public TextView a;
  protected QQStoryAddVideoLabelViewPart.OnTextChangeListener a;
  protected XEditTextEx a;
  protected String b;
  
  public QQStoryAddVideoLabelViewPart(View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(paramView);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131297956));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302961));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)paramView.findViewById(2131302963));
    paramView = new SpannableString("其他人可以通过话题发现你的视频");
    paramView.setSpan(new AbsoluteSizeSpan(14, true), 0, paramView.length(), 33);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(paramView);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(new QQStoryAddVideoLabelViewPart.EditTextWatcher(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new iyf(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility();
  }
  
  public XEditTextEx a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(QQStoryAddVideoLabelViewPart.OnTextChangeListener paramOnTextChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart$OnTextChangeListener = paramOnTextChangeListener;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\label\QQStoryAddVideoLabelViewPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */