package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.ArrayList;
import mqq.util.WeakReference;
import nbv;
import nbw;
import nbx;

public class PositionActivatePage
  extends ActivateBasePage
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ActivateFriendGrid.GridCallBack jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack;
  public String a;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  private View.OnClickListener b;
  
  public PositionActivatePage(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack = new nbv(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nbw(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new nbx(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((ActivateFriendActivity)paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371391);
    this.c.setText(2131371393);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131371395);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack);
    this.d.setVisibility(0);
    findViewById(2131301232).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904064, this, false);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301221));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301230));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301231));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131301224));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301234));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301225));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_a_of_type_AndroidViewView.findViewById(2131301223));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, long[] paramArrayOfLong)
  {
    CharSequence localCharSequence = TimeFormatterUtils.a(getContext(), 3, paramLong);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c.setText(paramString);
    if (paramArrayOfLong.length > 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371391);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131371395);
    }
    for (;;)
    {
      paramString = new ArrayList(paramArrayOfLong.length);
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        paramString.add(new ActivateFriendItem(1, paramArrayOfLong[i]));
        i += 1;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371392);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131371396);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(paramQQAppInterface, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\activateFriend\PositionActivatePage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */