package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class MPFileFailedView
  extends RelativeLayout
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MPFileFailedView.MPFileFailedEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent;
  TextView b;
  TextView c;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, MPFileFailedView.MPFileFailedEvent paramMPFileFailedEvent, int paramInt1, int paramInt2)
  {
    int k = 2131362262;
    int m = 2130840428;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = paramMPFileFailedEvent;
    this.c.setVisibility(8);
    int i = 2131362271;
    int n;
    int j;
    switch (paramInt1)
    {
    default: 
      k = 2131362280;
      if (paramInt2 == 1)
      {
        i = 2131362281;
        paramInt2 = 0;
        n = 2131362244;
        j = i;
        i = paramInt2;
        paramInt2 = n;
      }
      break;
    case 2001: 
    case 2003: 
    case 2002: 
    case 2004: 
    case 2107: 
    case 2109: 
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(m);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(k);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.b.setText(j);
        this.b.setVisibility(i);
        this.c.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setText(paramInt2);
        if (7 == paramInt1) {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        return this.jdField_a_of_type_AndroidWidgetLinearLayout;
        k = 2131362265;
        paramInt2 = 2131362269;
        m = 2130840433;
        j = 2131362265;
        i = 8;
        continue;
        k = 2131362270;
        paramInt2 = 2131362269;
        m = 2130840433;
        j = 2131362271;
        i = 0;
        continue;
        k = 2131362260;
        m = 2130840431;
        i = 8;
        paramInt2 = 2131362244;
        j = 2131362271;
        continue;
        k = 2131362280;
        if (paramInt2 == 1) {
          i = 2131362281;
        }
        for (;;)
        {
          n = 0;
          j = i;
          paramInt2 = 2131362244;
          i = n;
          break;
          if (paramInt2 == 0) {
            i = 2131362282;
          }
        }
        k = 2131362260;
        m = 2130840431;
        i = 8;
        paramInt2 = 2131362244;
        j = 2131362271;
        continue;
        i = 8;
        m = 2130840432;
        paramInt2 = 2131362244;
        j = 2131362262;
      }
    case 2110: 
      label157:
      m = 2130840433;
      if (paramInt2 == 1)
      {
        j = 2131362270;
        i = 2131362271;
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      k = j;
      j = i;
      i = paramInt2;
      paramInt2 = 2131362269;
      break label157;
      if (paramInt2 == 0)
      {
        j = 2131362265;
        i = 2131362295;
        paramInt2 = 8;
        continue;
        k = 2131368805;
        i = 8;
        j = 2131368805;
        paramInt2 = 2131362244;
        break label157;
        k = 2131362249;
        i = 8;
        j = 2131362249;
        paramInt2 = 2131362244;
        break label157;
        i = 8;
        m = 2130840432;
        paramInt2 = 2131362244;
        j = 2131362262;
        break label157;
        k = 2131362389;
        i = 8;
        m = 0;
        paramInt2 = 2131362244;
        j = 2131362271;
        break label157;
        if (paramInt2 != 0) {
          break;
        }
        i = 2131362282;
        break;
      }
      j = 2131362276;
      i = 2131362271;
      paramInt2 = 8;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent = null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2130904030, null).findViewById(2131301050));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297585));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297586));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301051));
    this.c = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301052));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301053));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131362269))) {
        break label90;
      }
      this.jdField_a_of_type_Long = localDataLineHandler.a().a(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView$MPFileFailedEvent.a(this.jdField_a_of_type_Long);
      }
      return;
      label90:
      if (localDataLineHandler.a().b()) {
        this.jdField_a_of_type_Long = localDataLineHandler.a().a(1);
      } else {
        this.jdField_a_of_type_Long = localDataLineHandler.a().a(2);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\activity\MPFileFailedView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */