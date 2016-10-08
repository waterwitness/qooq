package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ppj;

public class TroopListAdapterOfContactsMode
  extends FacePreloadBaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "TroopListAdapterOfContactsMode";
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private TroopListAdapterOfContactsMode.OnTroopListClickListener jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode$OnTroopListClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private List b;
  private List c;
  private List d;
  
  public TroopListAdapterOfContactsMode(Context paramContext, QQAppInterface paramQQAppInterface, TroopListAdapterOfContactsMode.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ppj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(51));
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
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return ((TroopListAdapterOfContactsMode.TroopListItem)this.b.get(paramInt)).a;
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
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.b.clear();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject1 == null) {}
    do
    {
      Object localObject3;
      do
      {
        do
        {
          return;
          this.c = ((TroopManager)localObject1).b();
          this.d = ((TroopManager)localObject1).c();
          if (this.c != null) {
            this.jdField_a_of_type_JavaUtilList.addAll(this.c);
          }
          if (this.d != null) {
            this.jdField_a_of_type_JavaUtilList.addAll(this.d);
          }
          if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("TroopListAdapterOfContactsMode", 2, "已经开通的和需要开通的通讯录列表为空");
        return;
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        Object localObject4;
        if (this.c != null)
        {
          localObject3 = this.c.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Entity)((Iterator)localObject3).next();
            ((List)localObject2).add(new TroopListAdapterOfContactsMode.TroopListItemWithMask(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject4).troopuin)), (Entity)localObject4));
          }
        }
        if (this.d != null)
        {
          localObject3 = this.d.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Entity)((Iterator)localObject3).next();
            ((List)localObject1).add(new TroopListAdapterOfContactsMode.TroopListItemWithMask(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject4).troopuin)), (Entity)localObject4));
          }
        }
        localObject3 = new TroopListAdapterOfContactsMode.TroopCompator();
        Collections.sort((List)localObject2, (Comparator)localObject3);
        Collections.sort((List)localObject1, (Comparator)localObject3);
        if (((List)localObject2).size() > 0)
        {
          this.b.add(new TroopListAdapterOfContactsMode.TroopListItem(0, null));
          localObject3 = ((List)localObject2).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (TroopListAdapterOfContactsMode.TroopListItemWithMask)((Iterator)localObject3).next();
            this.b.add(new TroopListAdapterOfContactsMode.TroopListItem(2, ((TroopListAdapterOfContactsMode.TroopListItemWithMask)localObject4).a));
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopListAdapterOfContactsMode", 2, "开启通讯录模式的群的个数" + ((List)localObject2).size());
          }
        }
      } while (((List)localObject1).size() <= 0);
      this.b.add(new TroopListAdapterOfContactsMode.TroopListItem(1, null));
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListAdapterOfContactsMode.TroopListItemWithMask)((Iterator)localObject2).next();
        this.b.add(new TroopListAdapterOfContactsMode.TroopListItem(3, ((TroopListAdapterOfContactsMode.TroopListItemWithMask)localObject3).a));
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopListAdapterOfContactsMode", 2, "还没有开通通讯录模式的群" + ((List)localObject1).size());
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
  }
  
  public List b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
  }
  
  public List c()
  {
    return this.d;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = (TroopListAdapterOfContactsMode.TroopListItem)getItem(paramInt);
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130905064, paramViewGroup, false);
      paramViewGroup = new TroopListAdapterOfContactsMode.TroopListViewItemTag(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode$TroopListItem = ((TroopListAdapterOfContactsMode.TroopListItem)localObject);
      if (((TroopListAdapterOfContactsMode.TroopListItem)localObject).e != 0) {
        break label168;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setPadding(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingLeft(), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingRight(), paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131367955);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131367955));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return paramView;
      paramViewGroup = (TroopListAdapterOfContactsMode.TroopListViewItemTag)paramView.getTag();
      break;
      label168:
      if (((TroopListAdapterOfContactsMode.TroopListItem)localObject).e == 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if ((this.c == null) || (this.c.size() <= 0))
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setPadding(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingLeft(), 0, paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingRight(), paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131367956);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131367956));
        }
        else
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setPadding(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingLeft(), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 59.0F), paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingRight(), paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaddingBottom());
          paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131367956);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131367956));
        }
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
        label461:
        TroopInfo localTroopInfo;
        if (((TroopListAdapterOfContactsMode.TroopListItem)localObject).e == 2)
        {
          paramView.setClickable(true);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapterOfContactsMode$TroopListItem.a.troopuin)))
          {
            paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839370);
            localTroopInfo = ((TroopListAdapterOfContactsMode.TroopListItem)localObject).a;
            paramViewGroup.jdField_b_of_type_JavaLangString = localTroopInfo.troopuin;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localTroopInfo.troopuin) == 3) {
              break label771;
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            label501:
            TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
            if (TextUtils.isEmpty(localTroopInfo.troopname)) {
              break label792;
            }
            localObject = localTroopInfo.troopname;
            label525:
            localTextView.setText((CharSequence)localObject);
            localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
            if (TextUtils.isEmpty(localTroopInfo.troopname)) {
              break label802;
            }
            localObject = localTroopInfo.troopname;
            label556:
            localTextView.setContentDescription((CharSequence)localObject);
            paramViewGroup.d.setImageBitmap(a(4, localTroopInfo.troopuin));
            if ((localTroopInfo.dwGroupFlagExt & 0x800) == 0L) {
              break label855;
            }
            if (localTroopInfo.dwAuthGroupType != 2L) {
              break label812;
            }
            paramViewGroup.c.setVisibility(0);
            paramViewGroup.c.setBackgroundResource(2130838906);
          }
        }
        for (;;)
        {
          if (localTroopInfo.troopCreditLevel != 2L) {
            break label867;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843350);
          break;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838312);
          break label461;
          if (((TroopListAdapterOfContactsMode.TroopListItem)localObject).e != 3) {
            break label461;
          }
          paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838312);
          paramView.setClickable(true);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131367957);
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131367957));
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(((TroopListAdapterOfContactsMode.TroopListItem)localObject).a);
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          break label461;
          label771:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843345);
          break label501;
          label792:
          localObject = localTroopInfo.troopuin;
          break label525;
          label802:
          localObject = localTroopInfo.troopuin;
          break label556;
          label812:
          if (localTroopInfo.dwAuthGroupType == 1L)
          {
            paramViewGroup.c.setVisibility(0);
            paramViewGroup.c.setBackgroundResource(2130839365);
          }
          else
          {
            paramViewGroup.c.setVisibility(8);
            continue;
            label855:
            paramViewGroup.c.setVisibility(8);
          }
        }
        label867:
        if (localTroopInfo.troopCreditLevel == 1L)
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
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\TroopListAdapterOfContactsMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */