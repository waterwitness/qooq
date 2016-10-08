package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import pii;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;

public class TroopListAdapter
  extends FacePreloadBaseAdapter
{
  public int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  private ProtoUtils.TroopProtocolObserver jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  protected List a;
  public int b;
  public int c;
  public int d;
  private int e;
  private int f;
  private int g;
  
  public TroopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver = new pii(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.f = paramContext.getResources().getColor(2131428262);
    this.g = Color.parseColor("#808080");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, ArrayList paramArrayList)
  {
    oidb_0x88d.ReqBody localReqBody = new oidb_0x88d.ReqBody();
    localReqBody.uint32_appid.set(AppSetting.jdField_a_of_type_Int);
    Object localObject = paramArrayList.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      String str = (String)((Iterator)localObject).next();
      j = i + 1;
      oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
      localGroupInfo.uint32_app_privilege_flag.set(0);
      oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
      localReqGroupInfo.uint64_group_code.set(Long.parseLong(str));
      localReqGroupInfo.stgroupinfo.set(localGroupInfo);
      localReqBody.stzreqgroupinfo.add(localReqGroupInfo);
      i = j;
    } while (j != 49);
    localObject = new Bundle();
    if (paramArrayList.size() > 50)
    {
      i = 0;
      while (i < 50)
      {
        paramArrayList.remove(0);
        i += 1;
      }
      ((Bundle)localObject).putStringArrayList("TroopList", paramArrayList);
    }
    ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x88d_0", 2189, 0, (Bundle)localObject);
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = ((TroopInfo)getItem(paramInt)).troopuin;
    localFaceInfo.jdField_a_of_type_Int = 4;
    return localFaceInfo;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
    Object localObject2 = new ArrayList();
    Object localObject3 = ((TroopManager)localObject1).a();
    if (localObject3 != null)
    {
      Collections.sort((List)localObject3, new TroopListAdapter.CommonlyUsedTroopCompator(this));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((TroopManager)localObject1).a(((CommonlyUsedTroop)((Iterator)localObject3).next()).troopUin);
        if (localObject4 != null) {
          ((List)localObject2).add(localObject4);
        }
      }
      this.d = ((List)localObject2).size();
    }
    Object localObject4 = new ArrayList();
    localObject3 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject5 = paramArrayList.iterator();
    while (((Iterator)localObject5).hasNext())
    {
      Entity localEntity = (Entity)((Iterator)localObject5).next();
      i = a(paramQQAppInterface.b(((TroopInfo)localEntity).troopuin));
      if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
        ((List)localObject4).add(new TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
        ((List)localObject3).add(new TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      } else {
        ((List)localObject1).add(new TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      }
    }
    localObject5 = new TroopListAdapter.TroopCompator(this);
    Collections.sort((List)localObject4, (Comparator)localObject5);
    Collections.sort((List)localObject3, (Comparator)localObject5);
    Collections.sort((List)localObject1, (Comparator)localObject5);
    if (!((List)localObject2).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 0, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (Entity)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 1, (Entity)localObject5));
      }
    }
    this.jdField_a_of_type_Int = ((List)localObject4).size();
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 4, null));
      localObject2 = ((List)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (TroopListAdapter.TroopListItemWithMask)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 5, ((TroopListAdapter.TroopListItemWithMask)localObject4).a));
      }
    }
    this.b = ((List)localObject3).size();
    if (this.b > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 6, null));
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListAdapter.TroopListItemWithMask)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 7, ((TroopListAdapter.TroopListItemWithMask)localObject3).a));
      }
    }
    this.c = ((List)localObject1).size();
    if (this.c > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopListAdapter.TroopListItemWithMask)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 3, ((TroopListAdapter.TroopListItemWithMask)localObject2).a));
      }
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof SelectMemberActivity))
    {
      this.e = ((SelectMemberActivity)this.jdField_a_of_type_AndroidContentContext).b();
      if (this.e == 3000)
      {
        localObject1 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject1).add(((TroopInfo)paramArrayList.next()).troopuin);
        }
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver, (ArrayList)localObject1);
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopListAdapter.TroopListItem localTroopListItem = (TroopListAdapter.TroopListItem)getItem(paramInt);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (TroopListAdapter.TroopViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    View localView;
    for (;;)
    {
      localView = paramViewGroup.findViewById(2131299653);
      localObject = (TextView)paramViewGroup.findViewById(2131299652);
      if (localTroopListItem.i != 0) {
        break;
      }
      localView.setVisibility(8);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364254, new Object[] { String.valueOf(this.d) }));
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904985, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView = new TroopListAdapter.TroopViewHolder(this);
      paramView.d = ((ImageView)paramViewGroup.findViewById(2131296814));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131304948));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298260));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297122));
      paramViewGroup.setTag(paramView);
    }
    if (localTroopListItem.i == 2)
    {
      localView.setVisibility(8);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364257, new Object[] { String.valueOf(this.c) }));
      return paramViewGroup;
    }
    if (localTroopListItem.i == 4)
    {
      localView.setVisibility(8);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364255, new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
      return paramViewGroup;
    }
    if (localTroopListItem.i == 6)
    {
      localView.setVisibility(8);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364256, new Object[] { String.valueOf(this.b) }));
      return paramViewGroup;
    }
    localView.setVisibility(0);
    ((TextView)localObject).setVisibility(8);
    TroopInfo localTroopInfo = localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    paramView.jdField_b_of_type_JavaLangString = localTroopInfo.troopuin;
    TextView localTextView = paramView.jdField_a_of_type_AndroidWidgetTextView;
    if (localTroopInfo.troopname != null)
    {
      localObject = localTroopInfo.troopname;
      localTextView.setText((CharSequence)localObject);
      paramView.d.setImageBitmap(a(4, localTroopInfo.troopuin));
      paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
      paramView.jdField_a_of_type_Int = localTroopListItem.i;
      if ((this.e != 3000) || (localTroopInfo.isAllowCreateDiscuss()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
        break label533;
      }
      localView.setEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramViewGroup;
      localObject = localTroopInfo.troopcode;
      break;
      label533:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.f);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\TroopListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */