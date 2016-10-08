package com.tencent.mobileqq.troop.data;

import NearbyGroup.GroupArea;
import NearbyGroup.GroupInfo;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import java.io.Serializable;
import java.util.ArrayList;

public class GroupAreaWrapper
  implements Serializable
{
  public static final int ACTIVITY_INFO_WRAPPER_TYPE_NORMAL = 1;
  public static final int GROUP_INFO_WRAPPER_TYPE_NORMAL = 0;
  public static final int TOPIC_INFO_WRAPPER_TYPE_NORMAL = 2;
  public GroupAreaWrapper.ActivityInfo activityArea;
  public GroupArea groupArea;
  public boolean isMoreClick;
  public GroupAreaWrapper.TopicInfo topicArea;
  public int type;
  
  public GroupAreaWrapper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = 0;
  }
  
  public GroupAreaWrapper(GroupArea paramGroupArea)
  {
    this.type = 0;
    this.type = 0;
    this.groupArea = paramGroupArea;
  }
  
  public GroupAreaWrapper(GroupAreaWrapper.ActivityInfo paramActivityInfo)
  {
    this.type = 0;
    this.type = 1;
    this.activityArea = paramActivityInfo;
  }
  
  public GroupAreaWrapper(GroupAreaWrapper.TopicInfo paramTopicInfo)
  {
    this.type = 0;
    this.type = 2;
    this.topicArea = paramTopicInfo;
  }
  
  public int getChildCount()
  {
    int i = 1;
    if (this.type == 0) {
      if ((this.groupArea != null) && (this.groupArea.vGroupInfo != null)) {}
    }
    while ((this.type != 1) && (this.type != 2))
    {
      return 0;
      int j = this.groupArea.vGroupInfo.size();
      if (this.groupArea.dwGroupTotalCnt > this.groupArea.vGroupInfo.size()) {}
      for (;;)
      {
        return j + i;
        i = 0;
      }
    }
    return 1;
  }
  
  public View getChildView(NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext, Context paramContext, NearbyTroopsExpandableListViewAdapter paramNearbyTroopsExpandableListViewAdapter, int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    ArrayList localArrayList;
    if (this.type == 0)
    {
      localArrayList = this.groupArea.vGroupInfo;
      if (localArrayList == null) {
        paramNearbyTroopsExpandableListViewAdapter = null;
      }
    }
    do
    {
      return paramNearbyTroopsExpandableListViewAdapter;
      if (paramInt2 == localArrayList.size())
      {
        if (paramView != null)
        {
          paramINearbyTroopContext = paramView;
          if ((paramView.getTag() instanceof NearbyTroops.MoreBtnViewHolder)) {}
        }
        else
        {
          paramINearbyTroopContext = NearbyTroops.d(paramContext, paramViewGroup);
        }
        NearbyTroops.a(paramINearbyTroopContext, this.isMoreClick, (int)this.groupArea.dwGroupTotalCnt - localArrayList.size());
        return paramINearbyTroopContext;
      }
      if ((paramView != null) && ((paramView.getTag() instanceof NearbyTroops.CustomViewHolder)))
      {
        paramINearbyTroopContext = paramView;
        if (!(paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder)) {}
      }
      else
      {
        paramINearbyTroopContext = NearbyTroops.a(paramContext, paramViewGroup, 1);
      }
      paramView = getGroupInfo(paramInt2);
      if (paramView != null) {
        NearbyTroops.a(paramINearbyTroopContext, paramView, paramContext, false);
      }
      paramNearbyTroopsExpandableListViewAdapter.a((NearbyTroops.CustomViewHolder)paramINearbyTroopContext.getTag(), null);
      return paramINearbyTroopContext;
      if (this.type == 1)
      {
        if (paramView != null)
        {
          paramNearbyTroopsExpandableListViewAdapter = paramView;
          if ((paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder)) {}
        }
        else
        {
          paramNearbyTroopsExpandableListViewAdapter = this.activityArea.createView(paramContext, paramViewGroup);
        }
        this.activityArea.fillView(paramNearbyTroopsExpandableListViewAdapter);
        ReportController.b(paramINearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "ac", "exp", 0, 0, "", "", "", "");
        return paramNearbyTroopsExpandableListViewAdapter;
      }
      paramNearbyTroopsExpandableListViewAdapter = paramView;
    } while (this.type != 2);
    if (paramView != null)
    {
      paramNearbyTroopsExpandableListViewAdapter = paramView;
      if ((paramView.getTag() instanceof NearbyTroops.ActivityAndTopicViewHolder)) {}
    }
    else
    {
      paramNearbyTroopsExpandableListViewAdapter = this.topicArea.createView(paramContext, paramViewGroup);
    }
    this.topicArea.fillView(paramNearbyTroopsExpandableListViewAdapter);
    ReportController.b(paramINearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "post", "exp", 0, 0, "", "", "", "");
    return paramNearbyTroopsExpandableListViewAdapter;
  }
  
  public GroupInfo getGroupInfo(int paramInt)
  {
    if (this.type == 0)
    {
      ArrayList localArrayList = this.groupArea.vGroupInfo;
      if (localArrayList != null) {
        return (GroupInfo)localArrayList.get(paramInt);
      }
    }
    return null;
  }
  
  public View getGroupView(Context paramContext, int paramInt, boolean paramBoolean1, View paramView, ViewGroup paramViewGroup, boolean paramBoolean2)
  {
    NearbyTroops.GroupViewHolder localGroupViewHolder = null;
    if (paramView != null) {
      localGroupViewHolder = (NearbyTroops.GroupViewHolder)paramView.getTag();
    }
    if (this.type == 0)
    {
      if ((localGroupViewHolder == null) || (localGroupViewHolder.a != 3)) {
        paramView = NearbyTroops.a(paramContext, paramViewGroup, paramBoolean2);
      }
      NearbyTroops.a(paramView, this.groupArea.strAreaName, (float)this.groupArea.dwGroupTotalCnt, (float)this.groupArea.dwDistance, paramBoolean1);
    }
    while ((localGroupViewHolder != null) && (localGroupViewHolder.a == 1)) {
      return paramView;
    }
    return NearbyTroops.a(paramContext, paramViewGroup);
  }
  
  public Object getObject()
  {
    if (this.type == 0) {
      return this.groupArea;
    }
    if (this.type == 1) {
      return this.activityArea;
    }
    if (this.type == 2) {
      return this.topicArea;
    }
    return null;
  }
  
  public void onClick(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.type == 0)
    {
      Object localObject = this.groupArea.vGroupInfo;
      if (localObject != null)
      {
        localObject = (GroupInfo)((ArrayList)localObject).get(paramInt1);
        if (localObject != null)
        {
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_list", "Clk_data", 0, 0, String.valueOf(((GroupInfo)localObject).lCode), String.valueOf(paramInt4), "", paramInt5 + "");
          openTroopProfile(paramContext, (GroupInfo)localObject, paramInt3, paramInt5, paramInt4, paramInt6);
        }
      }
    }
  }
  
  public void openTroopProfile(Context paramContext, GroupInfo paramGroupInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramGroupInfo == null) {
      return;
    }
    paramGroupInfo = TroopUtils.a(paramInt1, paramGroupInfo, paramInt4, false);
    paramGroupInfo.putInt("filter_id", paramInt2);
    paramGroupInfo.putInt("exposureSource", paramInt3);
    TroopUtils.a(paramContext, paramGroupInfo, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\GroupAreaWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */