package com.tencent.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import xtw;

public class KandianPopupWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "KandianPopupWindow";
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianPopupWindow.OnUninterestConfirmListener jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private Button[] jdField_a_of_type_ArrayOfAndroidWidgetButton;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private int c;
  private int d;
  private int e;
  
  public KandianPopupWindow(Activity paramActivity)
  {
    super(paramActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  private void a()
  {
    this.c = ((int)DeviceInfoUtil.j());
    this.d = ((int)DeviceInfoUtil.k());
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2130903748, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299915));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299931));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299917);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299918));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299929));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299916));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299930));
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.jdField_a_of_type_AndroidViewView.findViewById(2131299919);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.jdField_a_of_type_AndroidViewView.findViewById(2131299922);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = this.jdField_a_of_type_AndroidViewView.findViewById(2131299925);
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton = new Button[6];
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[0] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299920));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[0].setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[1] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299921));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[1].setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[2] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299923));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[2].setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[3] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299924));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[3].setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[4] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299926));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[4].setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[5] = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299927));
    this.jdField_a_of_type_ArrayOfAndroidWidgetButton[5].setOnClickListener(this);
    setHeight(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setOnDismissListener(new xtw(this));
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
  }
  
  private void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131362992));
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  private void c()
  {
    b();
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i >= this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      i = this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length;
      j = 0;
      label29:
      if (j >= i) {
        break label121;
      }
      if (!TextUtils.isEmpty(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).b)) {
        break label85;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
      j += 1;
      break label29;
      break;
      label85:
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(0);
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setText(((DislikeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).b);
    }
    label121:
    int j = i;
    if (j < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if ((j == i) && (i % 2 == 1)) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(4);
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setSelected(false);
        j += 1;
        break;
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[j].setVisibility(8);
      }
    }
    i = 1;
    if (i < this.jdField_a_of_type_ArrayOfAndroidWidgetButton.length)
    {
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].getVisibility() == 8) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[(i / 2)].setVisibility(8);
      }
      for (;;)
      {
        i += 2;
        break;
        this.jdField_a_of_type_ArrayOfAndroidViewView[(i / 2)].setVisibility(0);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public void a(View paramView, KandianPopupWindow.OnUninterestConfirmListener paramOnUninterestConfirmListener)
  {
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener = paramOnUninterestConfirmListener;
    a(0.8F);
    paramOnUninterestConfirmListener = new int[2];
    paramView.getLocationOnScreen(paramOnUninterestConfirmListener);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "DeviceInfoUtil.getWidth() = " + this.c + ", DeviceInfoUtil.getHeight() = " + this.d);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "popupWidth = " + this.jdField_a_of_type_Int + ", popupHeight = " + this.jdField_b_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "x = " + paramOnUninterestConfirmListener[0] + ", y = " + paramOnUninterestConfirmListener[1]);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "parent.getWidth() = " + paramView.getWidth() + ", parent.getHeight() = " + paramView.getHeight());
      }
      int j = this.d;
      int k = paramOnUninterestConfirmListener[1];
      int m = paramView.getHeight();
      int i = paramOnUninterestConfirmListener[1];
      i = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493838);
      int n = this.jdField_a_of_type_Int - paramOnUninterestConfirmListener[0] - paramView.getWidth() / 2 + i;
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "marginRight = " + n);
      }
      if (j - (k + m) > this.jdField_b_of_type_Int)
      {
        if (n > this.jdField_a_of_type_Int * 0.1D) {
          setAnimationStyle(2131559160);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, n, 0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          j = paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 + AIOUtils.a(9.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          showAtLocation(paramView, 0, i, j);
          if (QLog.isColorLevel()) {
            QLog.d("KandianPopupWindow", 2, "show x = " + i + ", show y = " + j);
          }
          return;
          setAnimationStyle(2131559159);
        }
      }
      if (n > this.jdField_a_of_type_Int * 0.1D) {
        setAnimationStyle(2131559158);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, n, 0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        j = paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 - AIOUtils.a(9.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - this.jdField_b_of_type_Int;
        showAtLocation(paramView, 0, i, j);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("KandianPopupWindow", 2, "show x = " + i + ", show y = " + j);
        return;
        setAnimationStyle(2131559157);
      }
    }
    setAnimationStyle(2131559161);
    showAtLocation(paramView, 0, paramOnUninterestConfirmListener[0] + paramView.getWidth() / 2 - AIOUtils.a(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493837), paramOnUninterestConfirmListener[1] + paramView.getHeight() / 2 - this.jdField_b_of_type_Int / 2);
  }
  
  public boolean a(int paramInt, ArrayList paramArrayList)
  {
    if (paramInt == -1) {
      return false;
    }
    this.e = paramInt;
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    while ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_Int = ((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493837));
      setWidth(this.jdField_a_of_type_Int);
      d();
      return true;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_Int = ((int)(this.c - this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131493838) * 2.0F));
    setWidth(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      c();
      break;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    case 2131299922: 
    case 2131299925: 
    case 2131299928: 
    case 2131299930: 
    default: 
      i = -1;
      label70:
      if (i != -1)
      {
        if (!this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].isSelected()) {
          break label211;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(false);
        this.jdField_b_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      break;
    }
    for (;;)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() != 0) {
        break label240;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131362992));
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      return;
      i = 0;
      break label70;
      i = 1;
      break label70;
      i = 2;
      break label70;
      i = 3;
      break label70;
      i = 4;
      break label70;
      i = 5;
      break label70;
      if (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener != null) {
        this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener.a(paramView, this.e, this.jdField_b_of_type_JavaUtilArrayList, null);
      }
      dismiss();
      break;
      label211:
      this.jdField_a_of_type_ArrayOfAndroidWidgetButton[i].setSelected(true);
      this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
    }
    label240:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131362993), new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\KandianPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */