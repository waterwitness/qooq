package com.tencent.mobileqq.activity.contact;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.Map;

public class FriendItemLayout
  extends FrameLayout
{
  private static int jdField_a_of_type_Int;
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap(5);
  private BuddyListFriends.BuddyChildTag jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FriendItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FriendItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int j = ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.getLayoutParams()).leftMargin;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.a();
    int i;
    long l;
    if (jdField_a_of_type_JavaUtilMap.containsKey(localObject))
    {
      i = ((Integer)jdField_a_of_type_JavaUtilMap.get(localObject)).intValue();
      this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setFixedWidth(i);
      j += i + jdField_a_of_type_Int;
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = j;
        i = ((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int + j;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.c.getVisibility() != 8)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = i;
        j = i + (((FrameLayout.LayoutParams)localObject).width + jdField_a_of_type_Int);
      }
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams()).leftMargin = j;
      j = getContext().getResources().getDimensionPixelSize(2131493080);
      l = System.currentTimeMillis();
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.f.getVisibility() != 8) {
        i = j + this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.f.getLayoutParams().width;
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.g.getVisibility() != 8) {
        j = i + this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.g.getLayoutParams().width;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.h.getVisibility() != 8) {
        i = j + this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.h.getLayoutParams().width;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8) {
        break label422;
      }
      i += this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width;
    }
    label422:
    for (;;)
    {
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).rightMargin = i;
      QLog.d("FriendReactive", 2, "nickRightMargin time=" + (System.currentTimeMillis() - l));
      return;
      i = (int)this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.a().measureText((CharSequence)localObject, 0, ((CharSequence)localObject).length());
      jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
      break;
    }
  }
  
  public BuddyListFriends.BuddyChildTag a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag = new BuddyListFriends.BuddyChildTag();
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296790));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)findViewById(2131297741));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)findViewById(2131297743));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297744));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.c = ((ImageView)findViewById(2131297745));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)findViewById(2131297746));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.d = ((ImageView)findViewById(2131297734));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.e = ((ImageView)findViewById(2131297742));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.f = ((ImageView)findViewById(2131297736));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.g = ((ImageView)findViewById(2131297737));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.h = ((ImageView)findViewById(2131297738));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297739));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297740));
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(RichStatus.sActionColor, 1);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 1);
    this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setGravity(19);
    if (jdField_a_of_type_Int == 0) {
      jdField_a_of_type_Int = getContext().getResources().getDimensionPixelSize(2131493078);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListFriends$BuddyChildTag;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    a();
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\FriendItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */