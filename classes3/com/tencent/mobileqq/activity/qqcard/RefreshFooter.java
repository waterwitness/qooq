package com.tencent.mobileqq.activity.qqcard;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class RefreshFooter
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 1;
  public static final int c = 2;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Resources jdField_a_of_type_AndroidContentResResources;
  public View a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RefreshFooter.RefreshListener jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter$RefreshListener;
  int d = 0;
  private int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = RefreshFooter.class.getSimpleName();
  }
  
  public RefreshFooter(Activity paramActivity, RefreshFooter.RefreshListener paramRefreshListener, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter$RefreshListener = paramRefreshListener;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    if (paramViewGroup != null) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303237));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131297005));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      return;
      paramViewGroup = LayoutInflater.from(paramActivity).inflate(2130904576, null);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onStatus, status=" + paramInt);
    }
    this.d = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131366572));
      return;
    case 1: 
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131366573));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 == paramInt3) && (paramInt3 > paramInt2) && (this.e != 0) && (this.d == 0))
    {
      this.jdField_a_of_type_AndroidViewView.performClick();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onScroll, performClick");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter$RefreshListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter$RefreshListener.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\RefreshFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */