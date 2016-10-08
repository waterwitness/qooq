package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.Iterator;
import java.util.List;

public class ApolloPanelAdapter
  extends PagerAdapter
{
  public static final String a = "ApolloPanelAdapter";
  Context jdField_a_of_type_AndroidContentContext;
  public BaseChatPie a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin;
  private List jdField_a_of_type_JavaUtilList;
  
  public ApolloPanelAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject == null) || (paramViewGroup == null)) {}
    do
    {
      do
      {
        return;
        if (!(paramObject instanceof ApolloLinearLayout)) {
          break;
        }
        ApolloLinearLayout localApolloLinearLayout = (ApolloLinearLayout)paramObject;
        localApolloLinearLayout.a();
        paramViewGroup.removeView(localApolloLinearLayout);
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin == null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a((View)paramObject);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanelAdapter", 2, "add to reusePool view position = " + paramInt);
    return;
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int j;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      j = 0;
    }
    Iterator localIterator;
    int i;
    do
    {
      return j;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      j = i;
    } while (!localIterator.hasNext());
    ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)localIterator.next();
    if ((localApolloViewBinder != null) && ((localApolloViewBinder instanceof ApolloViewBinder))) {
      i += localApolloViewBinder.a();
    }
    for (;;)
    {
      break;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    int j = 0;
    ApolloViewBinder localApolloViewBinder;
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      localApolloViewBinder = (ApolloViewBinder)((Iterator)localObject1).next();
      i = j;
      if (localApolloViewBinder != null)
      {
        i = j;
        if ((localApolloViewBinder instanceof ApolloViewBinder))
        {
          int k = localApolloViewBinder.a();
          j += k;
          i = j;
          if (paramInt + 1 <= j)
          {
            i = k - (j - paramInt);
            if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin == null) || (localApolloViewBinder.k != 0)) {
              break label366;
            }
            Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
            localObject1 = localObject2;
            if (!(localObject2 instanceof ApolloLinearLayout)) {
              localObject1 = null;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanelAdapter", 2, "reuse view position =" + paramInt);
            }
            label157:
            if (localObject1 == null) {
              break label363;
            }
            localObject2 = ((View)localObject1).getTag();
            if ((localObject2 == null) || (!(localObject2 instanceof Integer)) || (((Integer)((View)localObject1).getTag()).intValue() == XPanelContainer.e)) {
              break label363;
            }
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
            localObject1 = null;
            label205:
            if (localObject1 == null)
            {
              localObject2 = localApolloViewBinder.a(i);
              localObject1 = localObject2;
              if ((localObject2 instanceof ApolloLinearLayout))
              {
                ((ApolloLinearLayout)localObject2).setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
                ((ApolloLinearLayout)localObject2).setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanelAdapter", 2, "instantiateItem position = " + paramInt);
      }
      if ((localObject1 != null) && (((View)localObject1).getParent() != paramViewGroup) && (paramInt < getCount()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanelAdapter", 2, "addView position = " + paramInt);
        }
        paramViewGroup.addView((View)localObject1);
      }
      return localObject1;
      localApolloViewBinder.a((View)localObject1, i);
      continue;
      j = i;
      break;
      label363:
      break label205;
      label366:
      localObject1 = null;
      break label157;
      localObject1 = null;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloPanelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */