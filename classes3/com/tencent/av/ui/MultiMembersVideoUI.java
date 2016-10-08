package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gve;
import gvf;
import gvg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiMembersVideoUI
  extends RelativeLayout
  implements MultiMembersUI
{
  static final String jdField_a_of_type_JavaLangString = "MultiMembersVideoUI";
  public int a;
  public long a;
  public LayoutInflater a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  View jdField_a_of_type_AndroidViewView;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  GridView jdField_a_of_type_AndroidWidgetGridView;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  public VideoController a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  public MultiVideoMembersClickListener a;
  gvg jdField_a_of_type_Gvg;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList a;
  public boolean a;
  int b;
  public boolean b;
  
  public MultiMembersVideoUI(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetGridView = null;
    this.jdField_a_of_type_Gvg = null;
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new gve(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new gvf(this);
  }
  
  public MultiMembersVideoUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetGridView = null;
    this.jdField_a_of_type_Gvg = null;
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new gve(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new gvf(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    paramContext = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramContext.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903587, null);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299186));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299184));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
    this.jdField_a_of_type_AndroidWidgetGridView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_Gvg = new gvg(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Gvg);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    super.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  int a()
  {
    long l = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollX();
    if (this.jdField_b_of_type_Int > 0) {
      return (int)l / this.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  int a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void a()
  {
    boolean bool2 = false;
    int i = a();
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      int k = Math.min(i + 4, this.jdField_a_of_type_JavaUtilArrayList.size());
      int j = i;
      for (;;)
      {
        boolean bool1 = bool2;
        if (j < k)
        {
          if (!((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).d) {
            bool1 = true;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMembersVideoUI", 2, "refreshHeadbitmap-->minIndex=" + i + ",maxIndex=" + k + ",needRefresh=" + bool1);
          }
          if (bool1) {
            this.jdField_a_of_type_Gvg.notifyDataSetChanged();
          }
          return;
        }
        j += 1;
      }
    }
  }
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",isMicOff=" + paramBoolean);
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
              do
              {
                return;
                localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
                localMVMembersInfo.jdField_b_of_type_Int = paramInt1;
                localMVMembersInfo.jdField_c_of_type_Int = paramInt2;
              } while (localMVMembersInfo.e == paramBoolean);
              localMVMembersInfo.e = paramBoolean;
              if (this.jdField_a_of_type_AndroidWidgetGridView.getChildCount() > i) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("MultiMembersVideoUI", 2, "notifyDataSetChanged-->member not in holder-->index=" + i + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
            return;
            localObject = this.jdField_a_of_type_AndroidWidgetGridView.getChildAt(i);
          } while (localObject == null);
          if (((View)localObject).getTag() != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("MultiMembersVideoUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isMicOff=" + paramBoolean);
        return;
        localObject = (MultiMembersUI.Holder)((View)localObject).getTag();
      } while (localObject == null);
      if (!paramBoolean) {
        break;
      }
      if (((MultiMembersUI.Holder)localObject).a.getVisibility() == 0) {
        ((MultiMembersUI.Holder)localObject).a.setVisibility(8);
      }
    } while (((MultiMembersUI.Holder)localObject).d.getVisibility() == 0);
    ((MultiMembersUI.Holder)localObject).d.setVisibility(0);
    return;
    if (((MultiMembersUI.Holder)localObject).d.getVisibility() == 0) {
      ((MultiMembersUI.Holder)localObject).d.setVisibility(8);
    }
    if (localMVMembersInfo.jdField_a_of_type_Boolean)
    {
      ((MultiMembersUI.Holder)localObject).a.setVisibility(0);
      return;
    }
    ((MultiMembersUI.Holder)localObject).a.setVisibility(8);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = a(paramLong);
    if (i == -1) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "notifyDataSetChanged-->this member not in infoList.uin=" + paramLong + ",bSpeak=" + paramBoolean);
      }
    }
    Object localObject;
    label382:
    label412:
    do
    {
      MultiMembersUI.MVMembersInfo localMVMembersInfo;
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
                localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
              } while (localMVMembersInfo.jdField_a_of_type_Boolean == paramBoolean);
              localMVMembersInfo.jdField_a_of_type_Boolean = paramBoolean;
              if (this.jdField_a_of_type_AndroidWidgetGridView.getChildCount() > i) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("MultiMembersVideoUI", 2, "notifyDataSetChanged-->member not in holder-->index=" + i + ",uin=" + paramLong + ",isSpeak=" + paramBoolean);
            return;
            localObject = this.jdField_a_of_type_AndroidWidgetGridView.getChildAt(i);
          } while (localObject == null);
          if (((View)localObject).getTag() != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("MultiMembersVideoUI", 2, "notifyDataSetChanged-->can not get tag from uin-->index=" + i + ",uin=" + paramLong + ",isSpeak=" + paramBoolean);
        return;
        localObject = (MultiMembersUI.Holder)((View)localObject).getTag();
      } while (localObject == null);
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().F != 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 10))
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {}
      }
      else
      {
        if (!localMVMembersInfo.e) {
          break label382;
        }
        if (((MultiMembersUI.Holder)localObject).d.getVisibility() != 0) {
          ((MultiMembersUI.Holder)localObject).d.setVisibility(0);
        }
        if (((MultiMembersUI.Holder)localObject).a.getVisibility() == 0) {
          ((MultiMembersUI.Holder)localObject).a.setVisibility(8);
        }
        localMVMembersInfo.jdField_a_of_type_Boolean = false;
        bool = false;
      }
      for (;;)
      {
        if ((!bool) || (!((MultiMembersUI.Holder)localObject).jdField_b_of_type_Boolean)) {
          break label412;
        }
        if (((MultiMembersUI.Holder)localObject).a.getVisibility() == 0) {
          break;
        }
        ((MultiMembersUI.Holder)localObject).a.setVisibility(0);
        return;
        bool = paramBoolean;
        if (((MultiMembersUI.Holder)localObject).d.getVisibility() == 0)
        {
          ((MultiMembersUI.Holder)localObject).d.setVisibility(8);
          bool = paramBoolean;
        }
      }
    } while (((MultiMembersUI.Holder)localObject).a.getVisibility() != 0);
    ((MultiMembersUI.Holder)localObject).a.setVisibility(8);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      c();
      b();
    }
  }
  
  void b()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) && (i > 18)) {
      i = this.jdField_b_of_type_Int * 18;
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
      localLayoutParams.width = i;
      this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Gvg.notifyDataSetChanged();
      return;
      i *= this.jdField_b_of_type_Int;
    }
  }
  
  void b(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersVideoUI", 2, "refreshDataSource");
    }
    if (paramArrayList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMembersVideoUI", 2, "refreshDataSource-->friends list is null");
      }
    }
    for (;;)
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
        localMVMembersInfo.jdField_c_of_type_Int = localGAudioFriends.d;
        localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = localGAudioFriends.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        localMVMembersInfo.e = localGAudioFriends.g;
        this.jdField_a_of_type_JavaUtilArrayList.add(localMVMembersInfo);
        i += 1;
      }
    }
  }
  
  void c()
  {
    int j = 0;
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int k = UITools.a(((BaseActivity)localObject).getApplicationContext());
    this.jdField_b_of_type_Int = ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131493911);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      if (i <= 4)
      {
        i = (k - this.jdField_b_of_type_Int * i) / 2;
        if (i >= 0) {
          break label215;
        }
        i = j;
      }
    }
    label215:
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      this.jdField_b_of_type_Int = ((int)(k / 4.5D));
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
      i = 0;
      break;
      if (i <= 6)
      {
        i = ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131493913);
        this.jdField_b_of_type_Int = ((k - i * 2) / 6);
        this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
        break;
      }
      this.jdField_b_of_type_Int = ((int)(k / 6.5D));
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
      i = 0;
      break;
    }
  }
  
  public void setOnItemClickListener(MultiVideoMembersClickListener paramMultiVideoMembersClickListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = paramMultiVideoMembersClickListener;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiMembersVideoUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */