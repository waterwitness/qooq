package com.tencent.av.random.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SparkDot;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gky;
import gkz;
import gla;

public class DialogVideoLayerUI
{
  public static final int a = 0;
  public static final int b = 1;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  public RandomDoubleActivity a;
  SparkDot jdField_a_of_type_ComTencentAvUtilsSparkDot;
  String jdField_a_of_type_JavaLangString;
  public int c;
  
  public DialogVideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, RandomDoubleActivity paramRandomDoubleActivity, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "DialogVideoLayerUI";
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvRandomUiRandomDoubleActivity = paramRandomDoubleActivity;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot = ((SparkDot)this.jdField_a_of_type_AndroidViewView.findViewById(2131299414));
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot.g = 1719633035;
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot.f = -8420213;
    this.jdField_a_of_type_ComTencentAvUtilsSparkDot.setDotCount(3);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new gky(this));
  }
  
  public void a(int paramInt)
  {
    if ((this.c == paramInt) && (a())) {
      return;
    }
    this.c = paramInt;
    a(true);
    TextView localTextView;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131299415).setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131299412).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297843).setBackgroundResource(2130838268);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297852).setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297844).setVisibility(0);
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297840);
      localTextView.setText(2131363828);
      UITools.a(localTextView, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363828));
      localTextView.setVisibility(8);
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299415);
      localTextView.setVisibility(0);
      localTextView.setText(2131363829);
      UITools.a(localTextView, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363829));
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297843);
      localTextView.setText(2131363534);
      UITools.a(localTextView, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363535));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297843).setOnClickListener(new gkz(this));
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297844).setOnClickListener(new gla(this));
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131299415).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131299412).setVisibility(0);
        this.jdField_a_of_type_ComTencentAvUtilsSparkDot.c();
        this.jdField_a_of_type_AndroidViewView.findViewById(2131297843).setBackgroundResource(2130838283);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131297852).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131297844).setVisibility(8);
        localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297840);
        localTextView.setVisibility(0);
        localTextView.setText(2131363830);
        UITools.a(localTextView, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363830));
        localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297843);
        localTextView.setText(2131363532);
        UITools.a(localTextView, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363839));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentAvUtilsSparkDot.b();
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility() == 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\random\ui\DialogVideoLayerUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */