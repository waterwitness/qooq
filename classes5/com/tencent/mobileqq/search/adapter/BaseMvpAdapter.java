package com.tencent.mobileqq.search.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.IView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMvpAdapter
  extends BaseAdapter
{
  private List a;
  
  public BaseMvpAdapter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public IModel a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (IModel)this.a.get(paramInt);
  }
  
  protected abstract IPresenter a(int paramInt);
  
  protected abstract IView a(int paramInt, ViewGroup paramViewGroup);
  
  public void a(List paramList)
  {
    this.a.clear();
    if (paramList != null) {
      this.a.addAll(paramList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    IModel localIModel = a(paramInt);
    IPresenter localIPresenter;
    if (paramView == null)
    {
      paramViewGroup = a(paramInt, paramViewGroup);
      paramView = paramViewGroup.a();
      localIPresenter = a(paramInt);
      paramView.setTag(2131296487, localIPresenter);
      paramView.setTag(2131296488, paramViewGroup);
    }
    for (;;)
    {
      paramView.setTag(2131296489, localIModel);
      if (paramViewGroup.a() != null) {
        paramViewGroup.a().setTag(2131296490, Integer.valueOf(paramInt));
      }
      localIPresenter.a(localIModel, paramViewGroup);
      return paramView;
      paramViewGroup = (IView)paramView.getTag(2131296488);
      localIPresenter = (IPresenter)paramView.getTag(2131296487);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\adapter\BaseMvpAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */