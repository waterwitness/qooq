package com.tencent.mobileqq.dating;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import rfg;
import rfh;
import rfi;
import rfj;
import rfk;

public abstract class DismissAnimationAdapter
  extends BaseAdapter
{
  public DismissAnimationAdapter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(AdapterView paramAdapterView, View paramView)
  {
    int j = paramAdapterView.a(paramView);
    int i = j;
    if ((paramAdapterView instanceof ListView)) {
      i = j - ((ListView)paramAdapterView).m();
    }
    return i;
  }
  
  private Animator.AnimatorListener a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.getHeight();
    return new rfi(this, localLayoutParams, paramView);
  }
  
  private Animator.AnimatorListener a(View paramView, int paramInt)
  {
    return new rfk(this, paramView, paramView.getLayoutParams());
  }
  
  private ValueAnimator a(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    int i = paramView.getHeight();
    localObject = new rfh(this, (ViewGroup.LayoutParams)localObject, paramView, i);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, 0 });
    localValueAnimator.addListener(a(paramView));
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject);
    return localValueAnimator;
  }
  
  private List a(AdapterView paramAdapterView, Collection paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramAdapterView.getChildCount())
    {
      View localView = paramAdapterView.getChildAt(i);
      if (paramCollection.contains(Integer.valueOf(a(paramAdapterView, localView)))) {
        localArrayList.add(localView);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a() {}
  
  protected void a(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      a();
      return;
    }
    if ((paramView == null) || (paramInt <= 0))
    {
      a();
      return;
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      a();
      return;
    }
    localObject = new rfj(this, (ViewGroup.LayoutParams)localObject, paramView, paramInt);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, paramInt });
    localValueAnimator.addListener(a(paramView, paramInt));
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject);
    localValueAnimator.setDuration(400L);
    localValueAnimator.start();
  }
  
  protected void a(ListView paramListView, List paramList)
  {
    if (Build.VERSION.SDK_INT < 11) {
      a(paramList);
    }
    while ((paramListView == null) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    Collections.reverse(paramList);
    Object localObject = a(paramListView, paramList);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramListView = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramListView.add(a((View)((Iterator)localObject).next()));
      }
      paramList = new rfg(this, paramList);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).addListener(paramList);
      ((AnimatorSet)localObject).playTogether(paramListView);
      ((AnimatorSet)localObject).start();
      return;
    }
    a(paramList);
  }
  
  public void a(List paramList) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DismissAnimationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */