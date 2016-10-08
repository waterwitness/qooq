package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ForwardSelectionFriendListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener
{
  public static int a;
  protected float a;
  protected Context a;
  private View.OnClickListener a;
  protected FriendsManager a;
  protected QQAppInterface a;
  protected ImageWorker a;
  protected HashMap a;
  protected List a;
  protected HashMap b = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 1003;
  }
  
  public ForwardSelectionFriendListAdapter(Context paramContext, ExpandableListView paramExpandableListView, QQAppInterface paramQQAppInterface, List paramList, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(this.jdField_a_of_type_Float * 100.0F), (int)(this.jdField_a_of_type_Float * 100.0F));
    a(paramList, false);
  }
  
  private ArrayList a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true));
  }
  
  private ArrayList a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type == 0) && (!Utils.b(localRecentUser.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(localRecentUser.uin))) {
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(localRecentUser.uin));
      }
    }
    return localArrayList;
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public List a(int paramInt)
  {
    paramInt = ((Groups)getGroup(paramInt)).group_id;
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    if (paramList.hasNext())
    {
      Groups localGroups = (Groups)paramList.next();
      if ((localGroups.group_id == b()) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(b())))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b()), a());
      }
      for (;;)
      {
        this.b.put(Integer.valueOf(localGroups.group_id), localGroups.group_name);
        break;
        ArrayList localArrayList = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(String.valueOf(localGroups.group_id));
        if ((localArrayList != null) && (!localArrayList.isEmpty()))
        {
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext()) {
            try
            {
              if (((Friends)localIterator.next()).cSpecialFlag == 1) {
                localIterator.remove();
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localGroups.group_id), localArrayList);
      }
    }
    if (paramBoolean) {
      super.notifyDataSetChanged();
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return a(paramInt1).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904907, paramViewGroup, false);
      paramViewGroup = new ForwardSelectionFriendListAdapter.ViewTag();
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131296790));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297741));
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Friends localFriends = (Friends)getChild(paramInt1, paramInt2);
      String str = ContactUtils.a(localFriends);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramViewGroup.b = localFriends.uin;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localFriends;
      a(paramViewGroup, null);
      if (AppSetting.j) {
        paramView.setContentDescription(str);
      }
      return paramView;
      paramViewGroup = (ForwardSelectionFriendListAdapter.ViewTag)paramView.getTag();
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (a(paramInt) == null) {
      return 0;
    }
    return a(paramInt).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903212, paramViewGroup, false);
      paramViewGroup = new ForwardSelectionFriendListAdapter.GroupViewTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297704));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131297705));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      paramViewGroup.b.setText(String.valueOf(getChildrenCount(paramInt)));
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if (AppSetting.j) {
        paramView.setContentDescription(localGroups.group_name);
      }
      return paramView;
      paramViewGroup = (ForwardSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_JavaUtilList == null;
  }
  
  public void onClick(View paramView)
  {
    paramView = (ForwardSelectionFriendListAdapter.GroupViewTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.d(paramView.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\ForwardSelectionFriendListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */