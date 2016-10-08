package com.tencent.mobileqq.activity.qqcard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class QQCardExpandableAdapter
  extends BaseExpandableListAdapter
{
  private final int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private CardItemBuilderFactory jdField_a_of_type_ComTencentMobileqqActivityQqcardCardItemBuilderFactory;
  private QQCardExpandableAdapter.OnAddCardListener jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter$OnAddCardListener;
  private QQCardGroup jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardGroup;
  private final String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private final int jdField_b_of_type_Int;
  private QQCardGroup jdField_b_of_type_ComTencentMobileqqActivityQqcardQQCardGroup;
  private final int c;
  
  public QQCardExpandableAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "QQCard.QQCardExpandableAdapter";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.c = 2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardCardItemBuilderFactory = new CardItemBuilderFactory(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardGroup = new QQCardGroup(0, "即将过期(%d张)");
    this.jdField_b_of_type_ComTencentMobileqqActivityQqcardQQCardGroup = new QQCardGroup(1, "其它卡券(%d张)");
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardGroup.jdField_a_of_type_Int), new ArrayList());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqActivityQqcardQQCardGroup.jdField_a_of_type_Int), new ArrayList());
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private QQCardItem a(List paramList, String paramString1, String paramString2, int paramInt)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      QQCardItem localQQCardItem = (QQCardItem)paramList.get(i);
      if ((localQQCardItem.cardId.equals(paramString1)) && (localQQCardItem.code.equals(paramString2)) && (localQQCardItem.field == paramInt)) {
        return localQQCardItem;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(boolean paramBoolean, List paramList)
  {
    List localList1 = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
    List localList2 = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
    if (paramBoolean)
    {
      localList1.clear();
      localList2.clear();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardExpandableAdapter", 2, "classifyQQCard curTimestamp=" + l);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCardItem localQQCardItem = (QQCardItem)paramList.next();
      if (QQCardManager.a(l, localQQCardItem.expireTime) < 7) {
        localList1.add(localQQCardItem);
      } else {
        localList2.add(localQQCardItem);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardGroup.jdField_b_of_type_Int = localList1.size();
    this.jdField_b_of_type_ComTencentMobileqqActivityQqcardQQCardGroup.jdField_b_of_type_Int = localList2.size();
  }
  
  private boolean a(int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardGroup.jdField_b_of_type_Int > 0) || (localList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramInt == 0) {
        return bool;
      }
      if (paramInt == 1)
      {
        localList = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
        if ((this.jdField_b_of_type_ComTencentMobileqqActivityQqcardQQCardGroup.jdField_b_of_type_Int <= 0) && (localList.size() <= 0)) {
          break label101;
        }
      }
      label101:
      for (paramInt = 1;; paramInt = 0)
      {
        return (bool) && (paramInt != 0);
        return false;
      }
    }
  }
  
  private boolean a(List paramList, QQCardItem paramQQCardItem)
  {
    if (TextUtils.isEmpty(paramQQCardItem.nextCardId))
    {
      paramList.add(paramQQCardItem);
      return true;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      QQCardItem localQQCardItem = (QQCardItem)paramList.get(i);
      if (paramQQCardItem.nextCardId.equals(localQQCardItem.getUID()))
      {
        paramList.add(i, paramQQCardItem);
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public QQCardGroup a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardGroup;
    }
    if (paramInt == 1) {
      return this.jdField_b_of_type_ComTencentMobileqqActivityQqcardQQCardGroup;
    }
    return null;
  }
  
  public QQCardItem a(int paramInt1, int paramInt2)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localList != null) {
      return (QQCardItem)localList.get(paramInt2);
    }
    return null;
  }
  
  public List a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardExpandableAdapter", 2, "list == null, or list size <= 0");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardExpandableAdapter", 2, "handleChange, before size = " + localArrayList.size());
    }
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      QQCardItem localQQCardItem1 = (QQCardItem)paramList.get(i);
      QQCardItem localQQCardItem2 = a(localArrayList, localQQCardItem1.cardId, localQQCardItem1.code, localQQCardItem1.field);
      boolean bool;
      if (localQQCardItem2 == null) {
        if (localQQCardItem1.isValid == 1)
        {
          bool = a(localArrayList, localQQCardItem1);
          if (QLog.isColorLevel()) {
            QLog.d("QQCard.QQCardExpandableAdapter", 2, "addNewCard, result=" + bool);
          }
          if (!bool) {
            return null;
          }
          localQQCardItem1.isNew = true;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter$OnAddCardListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter$OnAddCardListener.b();
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localQQCardItem1.isValid == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQCard.QQCardExpandableAdapter", 2, "handleChange, delete card " + localQQCardItem1.getUID());
          }
          localArrayList.remove(localQQCardItem2);
        }
        else if (localQQCardItem2.nextCardId.equals(localQQCardItem1.nextCardId))
        {
          localQQCardItem2.copy(localQQCardItem1);
        }
        else
        {
          localArrayList.remove(localQQCardItem2);
          bool = a(localArrayList, localQQCardItem1);
          if (QLog.isColorLevel()) {
            QLog.d("QQCard.QQCardExpandableAdapter", 2, "change card position, result=" + bool);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(true, this.jdField_a_of_type_JavaUtilList);
    notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardExpandableAdapter", 2, "handleChange, after size=" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      ((QQCardItem)this.jdField_a_of_type_JavaUtilList.get(i)).isNew = false;
      i += 1;
    }
  }
  
  public void a(QQCardExpandableAdapter.OnAddCardListener paramOnAddCardListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter$OnAddCardListener = paramOnAddCardListener;
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      a(true, this.jdField_a_of_type_JavaUtilList);
      notifyDataSetChanged();
    }
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    QQCardItem localQQCardItem = a(paramInt1, paramInt2);
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqcardCardItemBuilderFactory.a(localQQCardItem);
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    QQCardItem localQQCardItem = a(paramInt1, paramInt2);
    BaseCardItemBuilder localBaseCardItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityQqcardCardItemBuilderFactory.a(localQQCardItem);
    if (localBaseCardItemBuilder == null) {
      paramView = this.jdField_a_of_type_AndroidViewView;
    }
    do
    {
      return paramView;
      paramViewGroup = localBaseCardItemBuilder.a(localQQCardItem, paramView, paramViewGroup);
      paramView = paramViewGroup;
    } while (!localQQCardItem.isNew);
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardExpandableAdapter", 2, "getChildView do anim...");
    }
    localQQCardItem.isNew = false;
    paramViewGroup.startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968770));
    return paramViewGroup;
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return 2;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    QQCardGroup localQQCardGroup = a(paramInt);
    if ((localQQCardGroup != null) && (a(paramInt))) {
      if ((paramView == null) || (paramView == this.jdField_a_of_type_AndroidViewView))
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904568, null);
        paramViewGroup = new QQCardExpandableAdapter.GroupViewHolder();
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303218));
        paramView.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(localQQCardGroup.jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(localQQCardGroup.jdField_b_of_type_Int) }));
      }
    }
    for (;;)
    {
      paramView.setClickable(true);
      return paramView;
      paramViewGroup = (QQCardExpandableAdapter.GroupViewHolder)paramView.getTag();
      break;
      paramView = this.jdField_a_of_type_AndroidViewView;
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
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardExpandableAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */