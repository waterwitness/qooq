package com.tencent.mobileqq.freshnews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FreshNewsBaseFragment
  extends Fragment
{
  public NearbyAppInterface a;
  
  public FreshNewsBaseFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NearbyAppInterface paramNearbyAppInterface)
  {
    this.a = paramNearbyAppInterface;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.a == null)
    {
      paramLayoutInflater = null;
      paramBundle = getActivity();
      if (paramBundle != null) {
        paramLayoutInflater = ((BaseActivity)paramBundle).getAppInterface();
      }
      if ((paramBundle != null) && ((paramLayoutInflater instanceof NearbyAppInterface))) {
        this.a = ((NearbyAppInterface)paramLayoutInflater);
      }
    }
    if (this.a == null)
    {
      QLog.d("FreshNewsBaseFragment", 1, "mApp still null after reget");
      throw new RuntimeException("app is null........");
    }
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */