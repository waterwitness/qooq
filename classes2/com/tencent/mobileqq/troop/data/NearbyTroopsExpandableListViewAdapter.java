package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupArea;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import java.util.ArrayList;
import vll;

public class NearbyTroopsExpandableListViewAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
  implements View.OnClickListener
{
  public static final int f = 30;
  public int a;
  public long a;
  public Context a;
  protected NearbyTroopsBaseView.INearbyTroopContext a;
  public NearbyTroopsView.UIHandler a;
  public NearbyTroopsView a;
  protected NonMainAppListViewFaceLoader a;
  AbsListView.OnScrollListener a;
  public ArrayList a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  protected int e;
  public boolean e;
  
  public NearbyTroopsExpandableListViewAdapter(Context paramContext, ExpandableListView paramExpandableListView, NearbyTroopsView.UIHandler paramUIHandler, NearbyTroopsView paramNearbyTroopsView, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new vll(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader = new NonMainAppListViewFaceLoader(paramContext, paramExpandableListView, 4);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext = paramINearbyTroopContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView = paramNearbyTroopsView;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = paramUIHandler;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.g;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
    this.d = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.D;
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
      return;
    }
    catch (NumberFormatException paramContext) {}
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {}
    GroupAreaWrapper localGroupAreaWrapper;
    do
    {
      return 0;
      if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() + 1)
      {
        if (this.jdField_c_of_type_Boolean) {}
        for (paramInt = 1;; paramInt = 0) {
          return paramInt;
        }
      }
      localGroupAreaWrapper = (GroupAreaWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    } while (localGroupAreaWrapper == null);
    return localGroupAreaWrapper.getChildCount();
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    paramInt -= 1;
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
    Object localObject1;
    GroupArea localGroupArea;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = (GroupAreaWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      } while ((localObject1 == null) || (((GroupAreaWrapper)localObject1).type != 0) || (((GroupAreaWrapper)localObject1).groupArea == null));
      localGroupArea = ((GroupAreaWrapper)localObject1).groupArea;
      localObject2 = localGroupArea.vGroupInfo;
    } while ((localObject2 == null) || (localGroupArea == null));
    ((GroupAreaWrapper)localObject1).isMoreClick = true;
    long l3 = localGroupArea.dwGroupStartIdx;
    long l4 = ((ArrayList)localObject2).size();
    long l2 = localGroupArea.dwGroupTotalCnt - ((ArrayList)localObject2).size();
    long l1 = l2;
    if (l2 > 30L) {
      l1 = 30L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.obtainMessage();
      ((Message)localObject1).what = 4;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("index", l3 + l4);
      ((Bundle)localObject2).putLong("count", l1);
      ((Bundle)localObject2).putInt("lat", localGroupArea.iLat);
      ((Bundle)localObject2).putInt("lon", localGroupArea.iLon);
      ((Bundle)localObject2).putString("name", localGroupArea.strAreaName);
      ((Message)localObject1).setData((Bundle)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendMessage((Message)localObject1);
    }
    notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.a(paramInt1, paramInt2);
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(FacePreloadBaseAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    b(paramViewHolder, paramBitmap);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.b();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  protected void b(FacePreloadBaseAdapter.ViewHolder paramViewHolder, Bitmap paramBitmap)
  {
    if (paramViewHolder.d == null) {
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.a(paramViewHolder.b, true);
    }
    paramViewHolder.d.setImageBitmap(localBitmap);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        return new Object();
      }
      return null;
    }
    if (paramInt1 > this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    GroupAreaWrapper localGroupAreaWrapper = (GroupAreaWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1);
    if (localGroupAreaWrapper == null) {
      return null;
    }
    return localGroupAreaWrapper.getObject();
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (this.jdField_b_of_type_Boolean))
    {
      paramView = NearbyTroops.c(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.getHeight() - this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getHeight();
      paramInt1 = paramInt2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.d.getVisibility() == 0) {
        paramInt1 = paramInt2 - this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.d.getHeight();
      }
      NearbyTroops.a(paramView, paramInt1, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext);
      return paramView;
    }
    Object localObject;
    if (paramInt1 == this.jdField_a_of_type_JavaUtilArrayList.size() + 1)
    {
      if (paramView != null)
      {
        localObject = paramView;
        if ((paramView.getTag() instanceof NearbyTroops.MoreBtnViewHolder)) {}
      }
      else
      {
        localObject = NearbyTroops.d(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      NearbyTroops.a((View)localObject);
      paramView = (View)localObject;
    }
    while (paramView == null)
    {
      return null;
      localObject = (GroupAreaWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1);
      if (localObject != null) {
        paramView = ((GroupAreaWrapper)localObject).getChildView(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext, this.jdField_a_of_type_AndroidContentContext, this, paramInt1, paramInt2, paramView, paramViewGroup);
      } else {
        paramView = null;
      }
    }
    paramViewGroup = paramView.getTag();
    if ((paramViewGroup instanceof NearbyTroops.CustomViewHolder))
    {
      localObject = (NearbyTroops.CustomViewHolder)paramViewGroup;
      ((NearbyTroops.CustomViewHolder)localObject).jdField_b_of_type_Int = paramInt1;
      ((NearbyTroops.CustomViewHolder)localObject).jdField_a_of_type_Int = paramInt2;
    }
    if ((paramViewGroup instanceof NearbyTroops.MoreBtnViewHolder))
    {
      localObject = (NearbyTroops.MoreBtnViewHolder)paramViewGroup;
      ((NearbyTroops.MoreBtnViewHolder)localObject).jdField_b_of_type_Int = paramInt1;
      ((NearbyTroops.MoreBtnViewHolder)localObject).jdField_a_of_type_Int = paramInt2;
    }
    if ((!(paramViewGroup instanceof NearbyTroops.MoreBtnViewHolder)) || (!((NearbyTroops.MoreBtnViewHolder)paramViewGroup).jdField_a_of_type_Boolean)) {
      paramView.setOnClickListener(this);
    }
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        return 1;
      }
      return 0;
    }
    return a(paramInt);
  }
  
  public Object getGroup(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.jdField_b_of_type_Boolean) {
        localObject = new Object();
      }
    }
    while (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return localObject;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
  }
  
  public int getGroupCount()
  {
    if (this.jdField_b_of_type_Boolean) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 1 + 1;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (Object localObject = (NearbyTroops.GroupViewHolder)paramView.getTag();; localObject = null)
    {
      if ((paramInt == 0) && (this.jdField_b_of_type_Boolean)) {
        if ((localObject == null) || (((NearbyTroops.GroupViewHolder)localObject).jdField_a_of_type_Int != 1)) {
          paramView = NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
        }
      }
      label109:
      do
      {
        do
        {
          do
          {
            return paramView;
            if (paramInt != 0) {
              break label109;
            }
            if (!this.jdField_e_of_type_Boolean) {
              break;
            }
          } while ((localObject != null) && (((NearbyTroops.GroupViewHolder)localObject).jdField_a_of_type_Int == 2));
          return NearbyTroops.b(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
        } while ((localObject != null) && (((NearbyTroops.GroupViewHolder)localObject).jdField_a_of_type_Int == 1));
        return NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
        if (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size() + 1) {
          break;
        }
      } while ((localObject != null) && (((NearbyTroops.GroupViewHolder)localObject).jdField_a_of_type_Int == 1));
      return NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      localObject = (GroupAreaWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
      if (localObject == null) {
        return null;
      }
      return ((GroupAreaWrapper)localObject).getGroupView(this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, paramView, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_e_of_type_Boolean);
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    int i;
    if ((paramView instanceof NearbyTroops.MoreBtnViewHolder))
    {
      paramView = (NearbyTroops.MoreBtnViewHolder)paramView;
      i = paramView.jdField_b_of_type_Int;
      if (i != 0) {}
    }
    label26:
    do
    {
      int j;
      do
      {
        do
        {
          do
          {
            break label26;
            break label26;
            do
            {
              return;
            } while (paramView.jdField_a_of_type_Boolean);
            a(i);
            return;
          } while (!(paramView instanceof NearbyTroops.CustomViewHolder));
          paramView = (NearbyTroops.CustomViewHolder)paramView;
          j = paramView.jdField_b_of_type_Int;
          i = paramView.jdField_a_of_type_Int;
        } while (j == 0);
        j -= 1;
      } while ((j < 0) || (j >= this.jdField_a_of_type_JavaUtilArrayList.size()));
      paramView = (GroupAreaWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(j);
    } while (paramView == null);
    paramView.onClick(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), this.jdField_a_of_type_AndroidContentContext, i, this.d, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.h);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\NearbyTroopsExpandableListViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */