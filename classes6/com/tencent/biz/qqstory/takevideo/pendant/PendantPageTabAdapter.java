package com.tencent.biz.qqstory.takevideo.pendant;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantType;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iyk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PendantPageTabAdapter
  extends BaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "PendantPageTabAdapter";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet;
  
  public PendantPageTabAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(iyk paramiyk, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        iyk.a(paramiyk).setAlpha(1.0F);
        return;
      }
      iyk.a(paramiyk).clearColorFilter();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      iyk.a(paramiyk).setAlpha(0.5F);
      return;
    }
    iyk.a(paramiyk).setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
  }
  
  public NewStoryPendantType a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (NewStoryPendantType)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    SLog.a("PendantPageTabAdapter", "updateSelection position=%d", Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      if (localIterator.hasNext())
      {
        iyk localiyk = (iyk)localIterator.next();
        if (iyk.a(localiyk) == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          a(localiyk, bool);
          break;
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    SLog.a("PendantPageTabAdapter", "updateTypeList : %d", Integer.valueOf(paramList.size()));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_JavaUtilSet.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NewStoryPendantType localNewStoryPendantType;
    Uri localUri;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904465, paramViewGroup, false);
      paramViewGroup = new iyk(null);
      iyk.a(paramViewGroup, paramView);
      iyk.a(paramViewGroup, (ImageView)paramView.findViewById(2131296303));
      paramView.setTag(paramViewGroup);
      this.jdField_a_of_type_JavaUtilSet.add(paramViewGroup);
      localNewStoryPendantType = a(paramInt);
      if (localNewStoryPendantType == null) {
        break label236;
      }
      if (!TextUtils.equals(iyk.a(paramViewGroup), localNewStoryPendantType.b))
      {
        localUri = Uri.parse(localNewStoryPendantType.b);
        if (!"android.resource".equalsIgnoreCase(localUri.getScheme())) {
          break label196;
        }
      }
    }
    for (;;)
    {
      try
      {
        iyk.a(paramViewGroup).setImageResource(Integer.parseInt(localUri.getPath()));
        iyk.a(paramViewGroup, paramInt);
        iyk.a(paramViewGroup, localNewStoryPendantType.b);
        if (this.jdField_a_of_type_Int != paramInt) {
          break label266;
        }
        bool = true;
        a(paramViewGroup, bool);
        return paramView;
        paramViewGroup = (iyk)paramView.getTag();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        iyk.a(paramViewGroup).setImageDrawable(new ColorDrawable(0));
        continue;
      }
      label196:
      UIUtils.a(iyk.a(paramViewGroup), localNewStoryPendantType.b, UIUtils.a(iyk.a(paramViewGroup).getContext(), 29.0F), UIUtils.a(iyk.a(paramViewGroup).getContext(), 29.0F), null);
      continue;
      label236:
      iyk.a(paramViewGroup).setImageDrawable(new ColorDrawable(0));
      iyk.a(paramViewGroup, paramInt);
      iyk.a(paramViewGroup, null);
      continue;
      label266:
      boolean bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\pendant\PendantPageTabAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */