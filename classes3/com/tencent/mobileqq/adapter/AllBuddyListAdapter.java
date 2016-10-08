package com.tencent.mobileqq.adapter;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.contact.FriendItemLayout;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pnz;

public class AllBuddyListAdapter
  extends FacePreloadBaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Comparator jdField_a_of_type_JavaUtilComparator;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  private char[] jdField_a_of_type_ArrayOfChar;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int b;
  private int c;
  
  public AllBuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilComparator = new pnz(this);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.b = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.c = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    c();
  }
  
  private ColorStateList a(int paramInt)
  {
    ColorStateList localColorStateList2 = (ColorStateList)BuddyListItem.a.get(Integer.valueOf(paramInt));
    ColorStateList localColorStateList1 = localColorStateList2;
    if (localColorStateList2 == null)
    {
      localColorStateList1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(paramInt);
      BuddyListItem.a.put(Integer.valueOf(paramInt), localColorStateList1);
    }
    return localColorStateList1;
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Friends localFriends;
    label111:
    String str2;
    String str1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903218, paramViewGroup, false);
      paramViewGroup = ((FriendItemLayout)paramView).a();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
      paramViewGroup.d.setVisibility(8);
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localFriends = (Friends)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangObject = localFriends;
      if (localFriends.groupid == 1001) {
        break label289;
      }
      paramViewGroup.jdField_a_of_type_JavaLangString = localFriends.uin;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localFriends.uin));
      str2 = ContactUtils.a(localFriends);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str2);
      str1 = a(paramViewGroup, localFriends.uin);
      if ((!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
        break label312;
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(2131428331));
      label185:
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label329;
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(this.c);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843363);
    }
    for (;;)
    {
      if (AppSetting.j)
      {
        paramViewGroup = new StringBuilder(str2);
        if (!TextUtils.isEmpty(str1)) {
          paramViewGroup.append("，个性签名 ，").append(str1);
        }
        paramViewGroup.append("， 进入聊天界面 按钮");
        paramView.setContentDescription(paramViewGroup);
      }
      return paramView;
      paramViewGroup = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break;
      label289:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapManager.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130840319));
      break label111;
      label312:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(2131428262));
      break label185;
      label329:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(this.c);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843496);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
    }
  }
  
  private String a(BuddyListFriends.BuddyChildTag paramBuddyChildTag, String paramString)
  {
    int m = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
    int i;
    boolean bool;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((ExtensionInfo)localObject2).feedContent)))
    {
      i = 1;
      if (localObject2 == null) {
        break label363;
      }
      if (this.jdField_a_of_type_Int == 0) {
        break label191;
      }
      bool = true;
    }
    label47:
    label76:
    label94:
    label191:
    label203:
    label209:
    label216:
    label363:
    for (Object localObject1 = ((ExtensionInfo)localObject2).getRichStatus(bool);; localObject1 = null)
    {
      int j;
      int k;
      if ((localObject1 != null) && (localObject1 != RichStatus.getEmptyStatus()) && (!((RichStatus)localObject1).isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(((RichStatus)localObject1).actionText))) {
          break label203;
        }
        k = 1;
        if ((i == 0) || ((((ExtensionInfo)localObject2).feedTime <= ((ExtensionInfo)localObject2).richTime) && (j != 0))) {
          break label216;
        }
        paramString = ((ExtensionInfo)localObject2).feedContent;
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject1 = paramBuddyChildTag.c;
        if (!((ExtensionInfo)localObject2).feedHasPhoto) {
          break label209;
        }
      }
      for (i = m;; i = 8)
      {
        ((ImageView)localObject1).setVisibility(i);
        localObject1 = null;
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramString);
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject1, 1);
        return paramString;
        i = 0;
        break;
        bool = false;
        break label47;
        j = 0;
        break label76;
        k = 0;
        break label94;
      }
      if (k != 0)
      {
        ((RichStatus)localObject1).enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString);
        paramString = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject1).actionId, 200);
        paramString = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramString);
        i = this.b;
        paramString.setBounds(0, 0, Math.round(paramString.getIntrinsicWidth() * 1.0F / paramString.getIntrinsicHeight() * i), i);
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramString, null);
      }
      for (;;)
      {
        localObject2 = ((RichStatus)localObject1).getActionAndData();
        paramString = ((RichStatus)localObject1).getPlainText();
        paramBuddyChildTag.c.setVisibility(8);
        paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject1 = localObject2;
        break;
        if (j == 0)
        {
          localObject1 = RichStatus.getEmptyStatus();
          paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Object localObject2 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).e();
    try
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext()) {
        if (((Friends)localIterator.next()).cSpecialFlag == 1) {
          localIterator.remove();
        }
      }
      String str;
      char c1;
      label165:
      label258:
      int i;
      int j;
      int k;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((ArrayList)localObject1).addAll((Collection)localObject2);
      }
      Collections.sort((List)localObject1, this.jdField_a_of_type_JavaUtilComparator);
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Entity)((Iterator)localObject1).next();
        str = ChnToSpell.a(ContactUtils.a((Friends)localObject2).trim(), 2);
        if (str.length() > 0)
        {
          c1 = str.charAt(0);
          if (StringUtil.c(c1)) {
            break label258;
          }
        }
        for (c1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".charAt("ABCDEFGHIJKLMNOPQRSTUVWXYZ#".length() - 1);; c1 = Character.toUpperCase(c1))
        {
          if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(c1)) == null) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Character.valueOf(c1), new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(c1))).add(localObject2);
          break;
          c1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".charAt("ABCDEFGHIJKLMNOPQRSTUVWXYZ#".length() - 1);
          break label165;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet();
      this.jdField_a_of_type_ArrayOfInt = new int[((Set)localObject1).size() + 1];
      this.jdField_a_of_type_ArrayOfChar = new char[((Set)localObject1).size()];
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      i = 1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfInt;
        j = localObject2[i];
        k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
        localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + j);
        i += 1;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        this.jdField_a_of_type_ArrayOfChar[i] = ((Character)((Iterator)localObject1).next()).charValue();
        i += 1;
      }
    }
  }
  
  public int a(char paramChar)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfChar.length) {
      if (paramChar != this.jdField_a_of_type_ArrayOfChar[i]) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      i = -1;
    }
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = ((Friends)getItem(paramInt)).uin;
    return localFaceInfo;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      DropFrameMonitor.a().a("list_a_contacts", false);
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        BuddyListFriends.BuddyChildTag localBuddyChildTag = (BuddyListFriends.BuddyChildTag)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
        if ((localBuddyChildTag != null) && (localBuddyChildTag.jdField_a_of_type_JavaLangString != null) && (localBuddyChildTag.jdField_a_of_type_JavaLangString.length() > 0)) {
          a(localBuddyChildTag, localBuddyChildTag.jdField_a_of_type_JavaLangString);
        }
        i += 1;
      }
    }
    DropFrameMonitor.a().a("list_a_contacts");
    super.a(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return (Entity)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(this.jdField_a_of_type_ArrayOfChar[i]))).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i]);
    }
    i = -(i + 1) - 1;
    return (Entity)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Character.valueOf(this.jdField_a_of_type_ArrayOfChar[i]))).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i]);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public void notifyDataSetChanged()
  {
    c();
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\AllBuddyListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */