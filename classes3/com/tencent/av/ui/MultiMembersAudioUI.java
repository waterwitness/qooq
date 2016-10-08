package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gvc;
import gvd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiMembersAudioUI
  extends LinearLayout
  implements MultiMembersUI
{
  static final int jdField_a_of_type_Int = 8;
  static final String jdField_a_of_type_JavaLangString = "MultiMembersAudioUI";
  public long a;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public View.OnClickListener a;
  public VideoController a;
  public VideoAppInterface a;
  MultiMembersAudioIndicator jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator;
  public MultiVideoMembersClickListener a;
  gvd jdField_a_of_type_Gvd;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList a;
  boolean jdField_a_of_type_Boolean;
  final int[] jdField_a_of_type_ArrayOfInt;
  public int b;
  public boolean b;
  public int c;
  
  public MultiMembersAudioUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131299330, 2131299331, 2131299332, 2131299333, 2131299335, 2131299336, 2131299337, 2131299338 };
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new gvc(this);
    super.setOrientation(1);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    paramContext = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramContext.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = new ViewPager(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, a(170.0F));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setFocusable(false);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setFocusableInTouchMode(false);
    this.jdField_a_of_type_Gvd = new gvd(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Gvd);
    super.addView(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator = new MultiMembersAudioIndicator(super.getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    super.addView(this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator);
  }
  
  int a(float paramFloat)
  {
    return (int)(super.getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1 - 1) {
      return -1;
    }
    switch (paramInt1)
    {
    default: 
      return -1;
    case 1: 
      return this.jdField_a_of_type_ArrayOfInt[0];
    case 2: 
      return this.jdField_a_of_type_ArrayOfInt[paramInt2];
    case 3: 
      return this.jdField_a_of_type_ArrayOfInt[paramInt2];
    case 4: 
      if (paramInt2 < 2) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 2)];
    case 5: 
      if (paramInt2 < 3) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 1)];
    case 6: 
      if (paramInt2 < 3) {
        return this.jdField_a_of_type_ArrayOfInt[paramInt2];
      }
      return this.jdField_a_of_type_ArrayOfInt[(paramInt2 + 1)];
    }
    return this.jdField_a_of_type_ArrayOfInt[paramInt2];
  }
  
  public int a(long paramLong)
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_c_of_type_Int) {
        break label52;
      }
      j = i;
      if (((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
        break;
      }
      i += 1;
    }
    label52:
    return -1;
  }
  
  View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while ((paramInt < 0) || (paramInt >= this.jdField_c_of_type_Int) || (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == null) || (this.jdField_a_of_type_Gvd == null)) {
      return null;
    }
    int j = (paramInt + 1) / 8;
    if ((paramInt + 1) % 8 == 0) {}
    for (int i = 0;; i = 1)
    {
      j = i + j - 1;
      i = 8;
      if (j == this.jdField_a_of_type_Gvd.getCount() - 1) {
        i = this.jdField_c_of_type_Int - j * 8;
      }
      try
      {
        localView = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.findViewWithTag("MemberPagerAdapter_" + j);
        if (localView == null) {
          break label189;
        }
        localView = localView.findViewById(a(i, paramInt + 1 - j * 8 - 1));
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          View localView;
          MultiMembersUI.Holder localHolder;
          boolean bool;
          label171:
          Object localObject = null;
          continue;
          localObject = null;
        }
      }
      try
      {
        localHolder = (MultiMembersUI.Holder)localView.getTag();
        if (localHolder == null) {
          break;
        }
        bool = localHolder.jdField_c_of_type_Boolean;
        if (bool) {
          break;
        }
      }
      catch (Exception localException2)
      {
        break label171;
      }
      return localView;
    }
  }
  
  public MultiMembersUI.Holder a(View paramView)
  {
    MultiMembersUI.Holder localHolder = new MultiMembersUI.Holder();
    localHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299159));
    localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299161));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().F == 7) {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299162));
    localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299328));
    localHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299160));
    localHolder.d = ((ImageView)paramView.findViewById(2131299163));
    return localHolder;
  }
  
  public MultiMembersUI.MVMembersInfo a(long paramLong)
  {
    int i = a(paramLong);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin = " + paramLong);
      }
      return null;
    }
    return (MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
  }
  
  public void a()
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_c_of_type_Int)
      {
        if (!((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_d_of_type_Boolean) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.jdField_a_of_type_Gvd.notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersAudioUI", 2, "refreshAddFriendState--> uin = " + paramLong + ",status = " + paramInt);
    }
    int i = a(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "refreshAddFriendState-->this member not in infoList.uin=" + paramLong + ",status=" + paramInt);
      }
    }
    for (;;)
    {
      return;
      Object localObject = (MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (((MultiMembersUI.MVMembersInfo)localObject).jdField_d_of_type_Int != paramInt)
      {
        ((MultiMembersUI.MVMembersInfo)localObject).jdField_d_of_type_Int = paramInt;
        localObject = a(i);
        if (localObject != null) {
          if (((View)localObject).getTag() == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MultiMembersAudioUI", 2, "refreshAddFriendState-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",status=" + paramInt);
            }
          }
          else
          {
            MultiMembersUI.Holder localHolder = (MultiMembersUI.Holder)((View)localObject).getTag();
            if (localHolder != null)
            {
              if (localHolder.jdField_b_of_type_AndroidWidgetImageView == null) {
                localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131299328));
              }
              localHolder.jdField_b_of_type_Int = paramInt;
              switch (paramInt)
              {
              }
              while (paramInt != 0)
              {
                localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
                return;
                localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838974);
                continue;
                localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838978);
                continue;
                localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838976);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt1 = a(paramLong);
    if (paramInt1 == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",isMicOff=" + paramBoolean);
      }
    }
    MultiMembersUI.MVMembersInfo localMVMembersInfo;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
            } while (localMVMembersInfo.e == paramBoolean);
            localMVMembersInfo.e = paramBoolean;
            localObject = a(paramInt1);
          } while (localObject == null);
          if (((View)localObject).getTag() != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + paramInt1 + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
        return;
        localObject = (MultiMembersUI.Holder)((View)localObject).getTag();
      } while (localObject == null);
      if (!paramBoolean) {
        break;
      }
      if (((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
        ((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    } while (((MultiMembersUI.Holder)localObject).d.getVisibility() == 0);
    ((MultiMembersUI.Holder)localObject).d.setVisibility(0);
    return;
    if (((MultiMembersUI.Holder)localObject).d.getVisibility() == 0) {
      ((MultiMembersUI.Holder)localObject).d.setVisibility(8);
    }
    if (localMVMembersInfo.jdField_a_of_type_Boolean)
    {
      ((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    ((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersAudioUI", 2, "initMVMLayout relationUin: " + paramLong + ", relationType: " + paramInt + ", bEnterPage: " + paramBoolean);
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",bSpeak=" + paramBoolean);
      }
    }
    label312:
    label386:
    label480:
    for (;;)
    {
      return;
      MultiMembersUI.MVMembersInfo localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localMVMembersInfo.jdField_a_of_type_Boolean != paramBoolean)
      {
        localMVMembersInfo.jdField_a_of_type_Boolean = paramBoolean;
        Object localObject = a(i);
        if (localObject != null) {
          if (((View)localObject).getTag() == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MultiMembersAudioUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isSpeak=" + paramBoolean);
            }
          }
          else
          {
            localObject = (MultiMembersUI.Holder)((View)localObject).getTag();
            if (localObject != null)
            {
              boolean bool;
              if ((this.jdField_a_of_type_ComTencentAvVideoController.a().F != 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 10))
              {
                bool = paramBoolean;
                if (this.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {}
              }
              else
              {
                if (!localMVMembersInfo.e) {
                  break label386;
                }
                if (((MultiMembersUI.Holder)localObject).d.getVisibility() != 0) {
                  ((MultiMembersUI.Holder)localObject).d.setVisibility(0);
                }
                if (((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
                  ((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                }
                localMVMembersInfo.jdField_a_of_type_Boolean = false;
                bool = false;
              }
              if ((bool) && (((MultiMembersUI.Holder)localObject).jdField_b_of_type_Boolean))
              {
                if (((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
                  ((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                }
                if (this.jdField_b_of_type_Int != 7) {
                  continue;
                }
                ((MultiMembersUI.Holder)localObject).jdField_b_of_type_Int = localMVMembersInfo.jdField_d_of_type_Int;
                switch (((MultiMembersUI.Holder)localObject).jdField_b_of_type_Int)
                {
                }
              }
              for (;;)
              {
                if (((MultiMembersUI.Holder)localObject).jdField_b_of_type_Int == 0) {
                  break label480;
                }
                ((MultiMembersUI.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
                return;
                bool = paramBoolean;
                if (((MultiMembersUI.Holder)localObject).d.getVisibility() != 0) {
                  break;
                }
                ((MultiMembersUI.Holder)localObject).d.setVisibility(8);
                bool = paramBoolean;
                break;
                if (((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
                  break label312;
                }
                ((MultiMembersUI.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                break label312;
                ((MultiMembersUI.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838974);
                continue;
                ((MultiMembersUI.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838978);
                continue;
                ((MultiMembersUI.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838976);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    View localView1;
    View localView2;
    View localView3;
    View localView4;
    View localView5;
    View localView6;
    View localView7;
    View localView8;
    View localView9;
    do
    {
      return;
      localView1 = paramView.findViewById(2131299329);
      localView2 = paramView.findViewById(2131299334);
      localView3 = paramView.findViewById(2131299330);
      localView4 = paramView.findViewById(2131299331);
      localView5 = paramView.findViewById(2131299332);
      localView6 = paramView.findViewById(2131299333);
      localView7 = paramView.findViewById(2131299335);
      localView8 = paramView.findViewById(2131299336);
      localView9 = paramView.findViewById(2131299337);
      paramView = paramView.findViewById(2131299338);
    } while ((localView1 == null) || (localView2 == null) || (localView3 == null) || (localView4 == null) || (localView5 == null) || (localView6 == null) || (localView7 == null) || (localView8 == null) || (localView9 == null) || (paramView == null));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
    switch (paramInt)
    {
    default: 
      localView1.setVisibility(8);
      localView2.setVisibility(8);
      return;
    case 1: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(8);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(8);
      return;
    case 2: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(8);
      return;
    case 3: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(8);
      return;
    case 4: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(8);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15, 0);
      localLayoutParams.addRule(10);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(0);
      localView7.setVisibility(0);
      localView8.setVisibility(0);
      localView9.setVisibility(8);
      paramView.setVisibility(8);
      return;
    case 5: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15, 0);
      localLayoutParams.addRule(10);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(0);
      localView7.setVisibility(0);
      localView8.setVisibility(0);
      localView9.setVisibility(8);
      paramView.setVisibility(8);
      return;
    case 6: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(8);
      localLayoutParams.addRule(15, 0);
      localLayoutParams.addRule(10);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(0);
      localView7.setVisibility(0);
      localView8.setVisibility(0);
      localView9.setVisibility(0);
      paramView.setVisibility(8);
      return;
    case 7: 
      localView1.setVisibility(0);
      localView3.setVisibility(0);
      localView4.setVisibility(0);
      localView5.setVisibility(0);
      localView6.setVisibility(0);
      localLayoutParams.addRule(15, 0);
      localLayoutParams.addRule(10);
      localView1.setLayoutParams(localLayoutParams);
      localView2.setVisibility(0);
      localView7.setVisibility(0);
      localView8.setVisibility(0);
      localView9.setVisibility(0);
      paramView.setVisibility(8);
      return;
    }
    localView1.setVisibility(0);
    localView3.setVisibility(0);
    localView4.setVisibility(0);
    localView5.setVisibility(0);
    localView6.setVisibility(0);
    localLayoutParams.addRule(15, 0);
    localLayoutParams.addRule(10);
    localView1.setLayoutParams(localLayoutParams);
    localView2.setVisibility(0);
    localView7.setVisibility(0);
    localView8.setVisibility(0);
    localView9.setVisibility(0);
    paramView.setVisibility(0);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioIndicator.a();
      this.jdField_a_of_type_Gvd.notifyDataSetChanged();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong)
        {
          ((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean a(long paramLong, String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        break label34;
      }
      bool2 = bool1;
    }
    label34:
    do
    {
      return bool2;
      if ((paramString != null) && (!paramString.equals("null(我)")) && (!paramString.isEmpty())) {
        break;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("MultiMembersAudioUI", 2, "setMemberName self nickname is null");
    return false;
    int i = 0;
    for (;;)
    {
      bool1 = bool3;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long != paramLong) {
          break label240;
        }
        ((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString = paramString;
        if (!paramString.equals(String.valueOf(paramLong))) {
          break label221;
        }
      }
      label221:
      for (((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_d_of_type_Boolean = false;; ((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_d_of_type_Boolean = true)
      {
        bool1 = true;
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiMembersAudioUI", 2, "setMemberName name : " + paramString + ", uin : " + paramLong + ", success : " + bool1);
        return bool1;
      }
      label240:
      i += 1;
    }
  }
  
  void b(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersAudioUI", 2, "refreshDataSource");
    }
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMembersAudioUI", 2, "refreshDataSource-->friends list is null");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)paramArrayList.get(i);
        MultiMembersUI.MVMembersInfo localMVMembersInfo = new MultiMembersUI.MVMembersInfo();
        localMVMembersInfo.jdField_a_of_type_Long = localGAudioFriends.jdField_a_of_type_Long;
        localMVMembersInfo.jdField_a_of_type_Int = localGAudioFriends.jdField_a_of_type_Int;
        localMVMembersInfo.jdField_b_of_type_Boolean = localGAudioFriends.jdField_b_of_type_Boolean;
        localMVMembersInfo.jdField_a_of_type_Boolean = localGAudioFriends.jdField_a_of_type_Boolean;
        localMVMembersInfo.jdField_c_of_type_Boolean = localGAudioFriends.jdField_c_of_type_Boolean;
        localMVMembersInfo.jdField_b_of_type_Int = localGAudioFriends.jdField_c_of_type_Int;
        localMVMembersInfo.jdField_c_of_type_Int = localGAudioFriends.jdField_d_of_type_Int;
        localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = localGAudioFriends.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        localMVMembersInfo.e = localGAudioFriends.g;
        localMVMembersInfo.jdField_d_of_type_Int = localGAudioFriends.h;
        this.jdField_a_of_type_JavaUtilArrayList.add(localMVMembersInfo);
        i += 1;
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    } while (((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 2)) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 18));
    this.jdField_c_of_type_Int = 18;
  }
  
  public void setOnItemClickListener(MultiVideoMembersClickListener paramMultiVideoMembersClickListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = paramMultiVideoMembersClickListener;
  }
  
  public void setRandomMultiIsMask(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersAudioUI", 2, "setRandomMultiIsMask isMask: " + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTwoLineState(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiMembersAudioUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */