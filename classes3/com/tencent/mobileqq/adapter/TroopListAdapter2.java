package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ppf;
import pph;
import ppi;

public class TroopListAdapter2
  extends FacePreloadBaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final int b = 1;
  public Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack a;
  public TroopListAdapter2.OnTroopListClickListener a;
  public QQAppInterface a;
  public TroopManager a;
  protected TroopObserver a;
  public SlideDetectListView a;
  public HashMap a;
  protected List a;
  protected boolean a;
  protected View.OnClickListener b;
  protected List b;
  protected boolean b;
  int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public TroopListAdapter2(Context paramContext, QQAppInterface paramQQAppInterface, TroopListAdapter2.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, int paramInt, boolean paramBoolean, ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack paramIShowExternalTroopDataChangedCallBack)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new pph(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ppi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack = paramIShowExternalTroopDataChangedCallBack;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(51));
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof TroopActivity)))
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ppf(this, (TroopActivity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public static int a(int paramInt)
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
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    this.jdField_b_of_type_JavaUtilList = ((TroopManager)localObject1).a();
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      return;
      Object localObject2 = new ArrayList();
      Object localObject3 = ((TroopManager)localObject1).a();
      if (localObject3 != null)
      {
        Collections.sort((List)localObject3, new TroopListAdapter2.CommonlyUsedTroopCompator());
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((TroopManager)localObject1).a(((CommonlyUsedTroop)((Iterator)localObject3).next()).troopUin);
          if (localObject4 != null) {
            ((List)localObject2).add(localObject4);
          }
        }
        this.g = ((List)localObject2).size();
      }
      Object localObject4 = new ArrayList();
      localObject3 = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject5 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject5).next();
        i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localEntity).troopuin));
        if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
          ((List)localObject3).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        } else {
          ((List)localObject1).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        }
      }
      localObject5 = new TroopListAdapter2.TroopCompator();
      Collections.sort((List)localObject4, (Comparator)localObject5);
      Collections.sort((List)localObject3, (Comparator)localObject5);
      Collections.sort((List)localObject1, (Comparator)localObject5);
      if (!((List)localObject2).isEmpty()) {}
      for (int i = 1; (i != 0) && (!this.jdField_a_of_type_Boolean); i = 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(0, null));
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Entity)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(1, (Entity)localObject5));
        }
      }
      this.d = ((List)localObject4).size();
      if (this.d > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(4, null));
        localObject2 = ((List)localObject4).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(5, ((TroopListAdapter2.TroopListItemWithMask)localObject4).a));
        }
      }
      this.e = ((List)localObject3).size();
      if (this.e > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(6, null));
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(7, ((TroopListAdapter2.TroopListItemWithMask)localObject3).a));
        }
      }
      this.f = ((List)localObject1).size();
      if (this.f > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(2, null));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(3, ((TroopListAdapter2.TroopListItemWithMask)localObject2).a));
        }
      }
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((TroopListAdapter2.TroopListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a;
    }
    return null;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if ((getItem(paramInt) instanceof TroopInfo))
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = ((TroopInfo)getItem(paramInt)).troopuin;
      localFaceInfo.jdField_a_of_type_Int = 4;
    }
    return localFaceInfo;
  }
  
  public List a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_Boolean = true;
    Object localObject3 = (TroopListAdapter2.TroopListItem)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903669, paramViewGroup, false);
      localObject2 = new TroopListAdapter2.TroopListViewItemTag((View)localObject1);
      ((View)localObject1).setTag(localObject2);
      ((Button)((View)localObject1).findViewById(2131299655)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramViewGroup = (ViewGroup)localObject2;
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_Boolean)
      {
        ((TroopListAdapter2.TroopListViewItemTag)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem = ((TroopListAdapter2.TroopListItem)localObject3);
      if ((this.jdField_a_of_type_Boolean) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.i != 0) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.i != 4) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.i != 6) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.i != 2))
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setTag(paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem);
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) || (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(((TroopListAdapter2.TroopListItem)localObject3).a.troopuin))) {
          break label347;
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        label246:
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(((TroopListAdapter2.TroopListItem)localObject3).a.troopuin, paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch);
        }
      }
      if (((TroopListAdapter2.TroopListItem)localObject3).i != 0) {
        break label358;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364254, new Object[] { String.valueOf(this.g) }));
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return paramView;
      paramViewGroup = (TroopListAdapter2.TroopListViewItemTag)paramView.getTag();
      break;
      label347:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break label246;
      label358:
      if (((TroopListAdapter2.TroopListItem)localObject3).i == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364257, new Object[] { String.valueOf(this.f) }));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject3).i == 4)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364255, new Object[] { String.valueOf(this.d) }));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject3).i == 6)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131364256, new Object[] { String.valueOf(this.e) }));
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject2 = ((TroopListAdapter2.TroopListItem)localObject3).a;
        paramViewGroup.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject2).troopuin) != 3)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          label596:
          localObject3 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (TextUtils.isEmpty(((TroopInfo)localObject2).troopname)) {
            break label778;
          }
          localObject1 = ((TroopInfo)localObject2).troopname;
          label620:
          ((TextView)localObject3).setText((CharSequence)localObject1);
          localObject3 = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
          if (((TroopInfo)localObject2).troopmemo == null) {
            break label788;
          }
          localObject1 = ((TroopInfo)localObject2).troopmemo;
          label648:
          ((TextView)localObject3).setText((CharSequence)localObject1);
          paramViewGroup.d.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
          if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
            break label839;
          }
          if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
            break label796;
          }
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130838906);
        }
        for (;;)
        {
          if (((TroopInfo)localObject2).troopCreditLevel != 2L) {
            break label851;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843350);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843345);
          break label596;
          label778:
          localObject1 = ((TroopInfo)localObject2).troopuin;
          break label620;
          label788:
          localObject1 = "";
          break label648;
          label796:
          if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
          {
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130839365);
          }
          else
          {
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            continue;
            label839:
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        label851:
        if (((TroopInfo)localObject2).troopCreditLevel == 1L)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843348);
        }
        else
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramCompoundButton = paramCompoundButton.getTag();
      if ((paramCompoundButton instanceof TroopListAdapter2.TroopListItem))
      {
        paramCompoundButton = (TroopListAdapter2.TroopListItem)paramCompoundButton;
        if ((paramCompoundButton != null) && (paramCompoundButton.a != null))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
          }
          String str = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(paramCompoundButton.a.troopuin);
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(str, paramCompoundButton.a.troopuin, paramBoolean, false);
          if (paramBoolean) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramCompoundButton.a.troopuin, "", "", "");
          }
          while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack.a(paramCompoundButton.a.troopuin, paramBoolean);
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramCompoundButton.a.troopuin, "", "", "");
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\TroopListAdapter2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */