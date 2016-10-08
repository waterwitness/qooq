package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.util.WeakReferenceHandler;

public class NearbyBaseFragment
  extends BaseFragment
  implements Handler.Callback
{
  public static final int k = 1;
  public static int l = 0;
  public Handler a;
  public NearbyAppInterface a;
  boolean j;
  boolean k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NearbyBaseFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void c()
  {
    super.c();
    if (!this.j)
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.k) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      this.j = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppInterface localAppInterface = null;
    super.onAttach(paramActivity);
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramActivity instanceof BaseActivity)) {
        localAppInterface = ((BaseActivity)paramActivity).getAppInterface();
      }
      if ((localAppInterface instanceof NearbyAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)localAppInterface);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((l == this.b) && (!this.j)) {
      this.j = true;
    }
    return paramLayoutInflater;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if ((!paramBoolean) && ((getActivity() instanceof NearbyActivity)) && (((NearbyActivity)getActivity()).jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[this.b].a()))
    {
      if (this.b != 3) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(String.valueOf(NearbyActivity.jdField_a_of_type_ArrayOfJavaLangString[this.b]));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(String.valueOf(100510));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fragment\NearbyBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */