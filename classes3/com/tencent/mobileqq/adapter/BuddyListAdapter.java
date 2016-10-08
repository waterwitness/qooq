package com.tencent.mobileqq.adapter;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.adapter.contacts.BuddyItemBuilder;
import com.tencent.mobileqq.adapter.contacts.BuddyListFriends.BuddyChildTag;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.BuddyListCallback;
import com.tencent.mobileqq.adapter.contacts.BuddyListItem.ViewTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupExpandListener;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import pod;
import poe;
import pog;
import poh;
import poi;
import poj;
import pok;

public class BuddyListAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, View.OnLongClickListener, BuddyListItem.BuddyListCallback, PhoneContactManager.IPhoneContactListener, SwipPinnedHeaderExpandableListView.SwipListListener
{
  private static final String jdField_a_of_type_JavaLangString = "BuddyListAdapter";
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new pod();
  private static final pok jdField_a_of_type_Pok;
  private static final String jdField_b_of_type_JavaLangString = "sp_key_last_expanded";
  private static final int jdField_c_of_type_Int = 0;
  private static final String jdField_c_of_type_JavaLangString = "_";
  private static final int jdField_d_of_type_Int = 1;
  private static final int jdField_e_of_type_Int = 2;
  private static final boolean jdField_e_of_type_Boolean = true;
  public int a;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SimpleTextView jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
  public final BaseActivity a;
  private final FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private OlympicTorchManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager;
  private final StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  ExpandableListView.OnGroupExpandListener jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupExpandListener = new poi(this);
  public ArrayList a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new poh(this);
  private SimpleTextView jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private final boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private final int f;
  private int g = -1;
  private int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Pok = new pok(null);
  }
  
  public BuddyListAdapter(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SwipPinnedHeaderExpandableListView paramSwipPinnedHeaderExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseActivity, paramQQAppInterface, paramSwipPinnedHeaderExpandableListView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(166));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    paramSwipPinnedHeaderExpandableListView.setDragEnable(true);
    paramSwipPinnedHeaderExpandableListView.setOnGroupExpandListener(this.jdField_a_of_type_ComTencentWidgetExpandableListView$OnGroupExpandListener);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    this.f = ((int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 12.0F));
    notifyDataSetChanged();
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      return;
    }
  }
  
  private void a(SparseArray paramSparseArray)
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject3 = ((TroopManager)localObject1).a();
    Object localObject2 = (List)((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a().clone();
    ArrayList localArrayList = new ArrayList(((List)localObject3).size() + ((List)localObject2).size());
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      TroopInfo localTroopInfo = ((TroopManager)localObject1).a(((CommonlyUsedTroop)((Iterator)localObject3).next()).troopUin);
      if (localTroopInfo != null) {
        localArrayList.add(BuddyItemBuilder.a(3, localTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
      }
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Entity)((Iterator)localObject1).next();
      localObject3 = (DiscussionInfo)localObject2;
      if (((DiscussionInfo)localObject3).hasCollect)
      {
        localArrayList.add(BuddyItemBuilder.a(2, (Entity)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
        ContactSorter.a((DiscussionInfo)localObject2);
      }
    }
    if (localArrayList.size() > 0)
    {
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      paramSparseArray.put(1005, localArrayList);
    }
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag, Groups paramGroups, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (!paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    Object localObject2 = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
    Object localObject1 = localObject2;
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    int i;
    Object localObject3;
    label234:
    label241:
    label265:
    boolean bool;
    if (AppSetting.j)
    {
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder(24);
        ((StringBuilder)localObject1).append(paramGroups.group_name + " 分组");
      }
    }
    else
    {
      paramGroupTag.jdField_a_of_type_Int = paramInt1;
      paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramGroups.group_name);
      if (paramGroups.group_id != 1002) {
        break label873;
      }
      localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      if ((i < 6) && ((i != 4) || (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()))) {
        break label629;
      }
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c() != 1) {
        break label392;
      }
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      localObject3 = "未匹配";
      localObject2 = localObject3;
      if (localRespondQueryQQBindingStat != null)
      {
        localObject2 = localObject3;
        if (localRespondQueryQQBindingStat.isStopFindMatch) {
          localObject2 = "未启用";
        }
      }
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText((CharSequence)localObject2);
      paramInt1 = paramInt2;
      if (AppSetting.j)
      {
        ((StringBuilder)localObject1).append((String)localObject2);
        paramInt1 = paramInt2;
      }
      paramGroupTag.jdField_b_of_type_Int = 1002;
      paramInt2 = paramInt1;
      if (paramInt1 == 0)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(paramGroupTag.jdField_a_of_type_Int)) {
          break label1109;
        }
        paramInt2 = 2;
      }
      localObject2 = paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox;
      if (paramInt2 != 2) {
        break label1115;
      }
      bool = true;
      label280:
      ((CheckBox)localObject2).setChecked(bool);
      if (AppSetting.j)
      {
        if (!paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label1121;
        }
        ((StringBuilder)localObject1).append(" 已展开");
        label312:
        paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setContentDescription(((StringBuilder)localObject1).toString());
        AccessibilityUtil.a(paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox, false);
      }
      if ((paramGroups.group_id != 1002) || (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d() != this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())) {
        break label1142;
      }
      if (!paramBoolean) {
        break label1133;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
    }
    label392:
    label629:
    label873:
    label1095:
    label1109:
    label1115:
    label1121:
    label1133:
    label1142:
    do
    {
      return;
      ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
      localObject1 = localObject2;
      break;
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramGroups.group_id);
      int j = getChildrenCount(paramInt1);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e & 0x8) != 8L)
      {
        localObject3 = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
        if (this.c) {}
        for (localObject2 = "%d / %d";; localObject2 = "%d/%d")
        {
          ((SimpleTextView)localObject3).setText(String.format((String)localObject2, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          paramInt1 = paramInt2;
          if (!AppSetting.j) {
            break;
          }
          ((StringBuilder)localObject1).append("在线" + i + "人，共" + j + "人");
          paramInt1 = paramInt2;
          break;
        }
      }
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(j + "");
      paramInt1 = paramInt2;
      if (!AppSetting.j) {
        break label234;
      }
      ((StringBuilder)localObject1).append("共" + j + "人");
      paramInt1 = paramInt2;
      break label234;
      if (i == 5)
      {
        paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(this.h + "%");
        paramInt1 = paramInt2;
        if (!AppSetting.j) {
          break label234;
        }
        ((StringBuilder)localObject1).append("正在加载联系人");
        paramInt1 = paramInt2;
        break label234;
      }
      if (((i == 3) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().lastUsedFlag == 3L)) || (i == 4))
      {
        localObject3 = "未匹配";
        localObject2 = localObject3;
        if (localRespondQueryQQBindingStat != null)
        {
          localObject2 = localObject3;
          if (localRespondQueryQQBindingStat.isStopFindMatch) {
            localObject2 = "未启用";
          }
        }
        paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText((CharSequence)localObject2);
        if (AppSetting.j) {
          ((StringBuilder)localObject1).append((String)localObject2);
        }
        paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        paramInt1 = 1;
        break label234;
      }
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramInt2 = 1;
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("未启用");
      paramInt1 = paramInt2;
      if (!AppSetting.j) {
        break label234;
      }
      ((StringBuilder)localObject1).append("未启用");
      paramInt1 = paramInt2;
      break label234;
      paramGroupTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramGroups.group_id);
      paramInt1 = getChildrenCount(paramInt1);
      if (paramGroups.group_id == 1005)
      {
        paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(paramInt1 + "");
        if (!AppSetting.j) {
          break label1095;
        }
        ((StringBuilder)localObject1).append("共" + paramInt1 + "个常用群聊");
        paramInt1 = paramInt2;
        break label241;
      }
      localObject3 = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
      if (this.c) {}
      for (localObject2 = "%d / %d";; localObject2 = "%d/%d")
      {
        ((SimpleTextView)localObject3).setText(String.format((String)localObject2, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) }));
        if (AppSetting.j) {
          ((StringBuilder)localObject1).append("在线" + i + "人，共" + paramInt1 + "人");
        }
        paramInt1 = paramInt2;
        break;
      }
      paramInt2 = 1;
      break label265;
      bool = false;
      break label280;
      ((StringBuilder)localObject1).append(" 已折叠");
      break label312;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView == paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView = null;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView != paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = null;
  }
  
  private void a(ArrayList paramArrayList, SparseArray paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    paramArrayList.add(String.valueOf("特别关心和常用群聊"));
    Object localObject1 = new Groups();
    ((Groups)localObject1).group_id = 1004;
    ((Groups)localObject1).group_name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131371016);
    ((Groups)localObject1).group_friend_count = 1;
    ((Groups)localObject1).group_online_friend_count = 1;
    ((Groups)localObject1).seqid = 0;
    ((Groups)localObject1).sqqOnLine_count = 0;
    paramArrayList.add(localObject1);
    localObject1 = new Groups();
    ((Groups)localObject1).group_id = 1005;
    ((Groups)localObject1).group_name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131369559);
    ((Groups)localObject1).group_friend_count = 1;
    ((Groups)localObject1).group_online_friend_count = 1;
    ((Groups)localObject1).seqid = 0;
    ((Groups)localObject1).sqqOnLine_count = 0;
    paramArrayList.add(localObject1);
    a(paramSparseArray);
    paramArrayList.add(String.valueOf("QQ好友"));
    ArrayList localArrayList1 = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject2 = null;
    Object localObject3;
    if (localFriendsManager != null)
    {
      localObject1 = localFriendsManager.b();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label839;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("group list is ");
        if (localObject1 != null) {
          break label602;
        }
        localObject2 = "null";
        label237:
        QLog.d("BuddyListAdapter", 2, (String)localObject2);
      }
      if (localObject1 != null) {
        break label839;
      }
      localObject1 = new ArrayList();
    }
    label279:
    label340:
    label376:
    label602:
    label836:
    label839:
    for (;;)
    {
      localObject2 = ((List)localObject1).iterator();
      int i = 0;
      ArrayList localArrayList2;
      int k;
      int j;
      Object localObject4;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Groups)((Iterator)localObject2).next();
        paramArrayList.add(localObject3);
        localObject1 = localFriendsManager.a(String.valueOf(((Groups)localObject3).group_id));
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          localArrayList2 = new ArrayList(((List)localObject1).size());
          localObject1 = ((List)localObject1).iterator();
          k = 0;
          j = i;
          i = k;
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Entity)((Iterator)localObject1).next();
            Object localObject5 = (Friends)localObject4;
            int m = ContactUtils.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(((Friends)localObject5).uin);
            k = j;
            if (localObject5 != null)
            {
              k = j;
              if (((SpecialCareInfo)localObject5).globalSwitch != 0)
              {
                localArrayList1.add(BuddyItemBuilder.a(4, (Entity)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
                k = j;
                if (m != 0)
                {
                  k = j;
                  if (m != 6) {
                    k = j + 1;
                  }
                }
              }
            }
            j = k;
            if (((Friends)localObject4).gathtertype != 1)
            {
              if ((m == 0) || (m == 6)) {
                break label836;
              }
              i += 1;
            }
          }
        }
      }
      for (;;)
      {
        localObject4 = BuddyItemBuilder.a(0, (Entity)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((BuddyListItem)localObject4).a(this);
        localArrayList2.add(localObject4);
        j = k;
        break label376;
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BuddyListAdapter", 2, "FriendManager is null");
        localObject1 = localObject2;
        break;
        localObject2 = "empty";
        break label237;
        localObject1 = new ArrayList((Collection)localObject1);
        break label340;
        a(localArrayList2);
        paramSparseIntArray.put(((Groups)localObject3).group_id, i);
        paramSparseArray.put(((Groups)localObject3).group_id, localArrayList2);
        i = j;
        break label279;
        a(localArrayList1);
        paramSparseIntArray.put(1004, i);
        paramSparseArray.put(1004, localArrayList1);
        paramArrayList.add(String.valueOf("我的手机"));
        localObject1 = new Groups();
        ((Groups)localObject1).group_id = 1002;
        ((Groups)localObject1).group_name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370356);
        ((Groups)localObject1).group_friend_count = 1;
        ((Groups)localObject1).group_online_friend_count = 1;
        ((Groups)localObject1).seqid = 0;
        ((Groups)localObject1).sqqOnLine_count = 0;
        paramArrayList.add(localObject1);
        this.g = (paramArrayList.size() - 1);
        c(paramSparseArray, paramSparseIntArray);
        localObject1 = new Groups();
        ((Groups)localObject1).group_id = 1001;
        ((Groups)localObject1).group_name = "我的设备";
        ((Groups)localObject1).group_friend_count = 1;
        ((Groups)localObject1).group_online_friend_count = 1;
        ((Groups)localObject1).seqid = 0;
        ((Groups)localObject1).sqqOnLine_count = 0;
        paramArrayList.add(localObject1);
        b(paramSparseArray, paramSparseIntArray);
        return;
      }
    }
  }
  
  private void a(List paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Pok);
      return;
    }
    catch (Exception paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BuddyListAdapter", 2, "", paramList);
    }
  }
  
  private boolean a(String paramString)
  {
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    int i;
    if (paramString.equals(AppConstants.aj)) {
      i = localRegisterProxySvcPackHandler.a();
    }
    for (;;)
    {
      if ((i == 1) || (i == 2))
      {
        return true;
        if (paramString.equals(AppConstants.ak)) {
          i = localRegisterProxySvcPackHandler.e();
        }
      }
      else
      {
        return false;
      }
      i = 0;
    }
  }
  
  private void b(SparseArray paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    ArrayList localArrayList = new ArrayList();
    Friends localFriends = new Friends();
    localFriends.uin = AppConstants.aj;
    localFriends.remark = "我的电脑";
    localFriends.name = "我的电脑";
    if (a(AppConstants.aj))
    {
      i = 10;
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localFriends.memberLevel = 0;
      localFriends.isMqqOnLine = false;
      localFriends.sqqOnLineState = 0;
      localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
      if (localFriends.status == 0) {
        break label654;
      }
    }
    label199:
    label268:
    label638:
    label644:
    label654:
    for (int i = 1;; i = 0)
    {
      int j;
      if ((a(AppConstants.ak)) || (this.jdField_a_of_type_Boolean))
      {
        localFriends = new Friends();
        localFriends.uin = AppConstants.ak;
        localFriends.remark = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362119);
        localFriends.name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362119);
        if (a(AppConstants.ak))
        {
          j = 10;
          localFriends.status = ((byte)j);
          localFriends.groupid = 1001;
          localFriends.memberLevel = 0;
          localFriends.isMqqOnLine = false;
          localFriends.sqqOnLineState = 0;
          localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
          if (localFriends.status == 0) {
            break label644;
          }
          j = i + 1;
          i = j;
          if (!this.jdField_b_of_type_Boolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
            this.jdField_b_of_type_Boolean = true;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("BuddyListAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
              i = j;
            }
          }
        }
      }
      for (;;)
      {
        j = i;
        if (((PrinterStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(74)).a())
        {
          localFriends = new Friends();
          localFriends.uin = AppConstants.al;
          localFriends.remark = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362166);
          localFriends.name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362166);
          if (!a(AppConstants.ak)) {
            break label638;
          }
        }
        for (j = 10;; j = 0)
        {
          localFriends.status = ((byte)j);
          localFriends.groupid = 1001;
          localFriends.memberLevel = 0;
          localFriends.isMqqOnLine = false;
          localFriends.sqqOnLineState = 0;
          localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
          j = i;
          if (localFriends.status != 0) {
            j = i + 1;
          }
          localFriends = new Friends();
          localFriends.uin = AppConstants.ai;
          localFriends.remark = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362164);
          localFriends.name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362164);
          localFriends.status = 10;
          localFriends.groupid = 1001;
          localFriends.memberLevel = 0;
          localFriends.isMqqOnLine = false;
          localFriends.sqqOnLineState = 0;
          localArrayList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
          paramSparseArray.put(1001, localArrayList);
          paramSparseIntArray.put(1001, j + 1);
          a(paramSparseArray, paramSparseIntArray);
          return;
          i = 0;
          break;
          j = 0;
          break label199;
        }
        j = i;
        break label268;
      }
    }
  }
  
  private void c(SparseArray paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b()) || (i == 5))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      if (localObject != null)
      {
        ArrayList localArrayList = new ArrayList(((List)localObject).size());
        localObject = ((List)localObject).iterator();
        int j;
        for (i = 0; ((Iterator)localObject).hasNext(); i = j)
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject).next();
          j = i;
          if (!localPhoneContact.isHiden)
          {
            int k = ContactUtils.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
            j = i;
            if (k != 0)
            {
              j = i;
              if (k != 6) {
                j = i + 1;
              }
            }
            localArrayList.add(BuddyItemBuilder.a(1, localPhoneContact, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
          }
        }
        paramSparseIntArray.put(1002, i);
        paramSparseArray.put(1002, localArrayList);
      }
      return;
    }
    paramSparseIntArray.put(1002, 0);
  }
  
  private void g()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof BuddyListFriends.BuddyChildTag)))
      {
        localObject = (BuddyListFriends.BuddyChildTag)localObject;
        if ((TextUtils.isEmpty(((BuddyListFriends.BuddyChildTag)localObject).jdField_b_of_type_ComTencentWidgetSingleLineTextView.a().toString())) && ((((BuddyListFriends.BuddyChildTag)localObject).a instanceof Friends))) {
          a((Friends)((BuddyListFriends.BuddyChildTag)localObject).a, (BuddyListFriends.BuddyChildTag)localObject);
        }
      }
      i += 1;
    }
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("sp_key_last_expanded", "sp_key_last_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    if (((String)localObject).equalsIgnoreCase("sp_key_last_expanded"))
    {
      i = 1;
      if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        if (getGroupType(i) != 0) {
          break label208;
        }
        localObject = (Groups)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (((Groups)localObject).group_id == 1001) {
          break label208;
        }
        localHashSet.add(Integer.valueOf(((Groups)localObject).group_id));
      }
    }
    label208:
    while (TextUtils.isEmpty((CharSequence)localObject)) {
      for (;;)
      {
        i = 0;
        while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          if ((getGroupType(i) == 0) && (localHashSet.contains(Integer.valueOf(((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(i)).group_id)))) {
            this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
          }
          i += 1;
        }
        i += 1;
      }
    }
    localObject = ((String)localObject).split("_");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        i += 1;
        continue;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
  
  private void i()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = getGroupCount();
    int i = 0;
    while (i < j)
    {
      if (getGroupType(i) == 0)
      {
        Groups localGroups = (Groups)getGroup(i);
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(i))
        {
          localStringBuffer.append(localGroups.group_id);
          localStringBuffer.append("_");
        }
      }
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("sp_key_last_expanded", localStringBuffer.toString()).commit();
  }
  
  public int a()
  {
    return 2130903213;
  }
  
  String a(Friends paramFriends, BuddyListFriends.BuddyChildTag paramBuddyChildTag)
  {
    String str = null;
    int m = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null)) {
      return null;
    }
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramFriends.uin);
    int i;
    boolean bool;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      i = 1;
      if (localExtensionInfo == null) {
        break label412;
      }
      if (this.jdField_b_of_type_Int == 0) {
        break label244;
      }
      bool = true;
    }
    label69:
    label98:
    label116:
    label244:
    label256:
    label262:
    label269:
    label412:
    for (Object localObject = localExtensionInfo.getRichStatus(bool);; localObject = null)
    {
      int j;
      int k;
      if ((localObject != null) && (localObject != RichStatus.getEmptyStatus()) && (!((RichStatus)localObject).isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(((RichStatus)localObject).actionText))) {
          break label256;
        }
        k = 1;
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label269;
        }
        paramFriends = new String(localExtensionInfo.feedContent);
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = paramBuddyChildTag.c;
        if (!localExtensionInfo.feedHasPhoto) {
          break label262;
        }
      }
      for (i = m;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        localObject = str;
        if (localExtensionInfo == null)
        {
          paramBuddyChildTag.c.setVisibility(8);
          paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramFriends);
        return paramFriends;
        i = 0;
        break;
        bool = false;
        break label69;
        j = 0;
        break label98;
        k = 0;
        break label116;
      }
      if (k != 0)
      {
        ((RichStatus)localObject).enableSummaryCached = paramFriends.isFriend();
        paramFriends = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((RichStatus)localObject).actionId, 200);
        paramFriends = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), paramFriends);
        i = this.f;
        paramFriends.setBounds(0, 0, Math.round(paramFriends.getIntrinsicWidth() * 1.0F / paramFriends.getIntrinsicHeight() * i), i);
        paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramFriends, null);
      }
      for (;;)
      {
        str = ((RichStatus)localObject).getActionAndData();
        paramFriends = ((RichStatus)localObject).getPlainText();
        paramBuddyChildTag.c.setVisibility(8);
        paramBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = str;
        break;
        if (j == 0)
        {
          localObject = RichStatus.getEmptyStatus();
          paramBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
    }
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuddyListAdapter", 2, "onResumeGroup " + paramInt);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.b("MCard")) {}
    List localList;
    do
    {
      do
      {
        return;
        paramInt = (int)getGroupId(paramInt);
      } while ((paramInt >= 1000) && (paramInt != 1004));
      localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    } while ((localList == null) || (localList.size() == 0));
    ThreadManager.a(new poj(this, paramInt, localList), 5, null, true);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "onUIBitsChanged uibits=" + paramLong);
    }
    notifyDataSetChanged();
  }
  
  public void a(SparseArray paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    paramSparseArray = (List)paramSparseArray.get(1001);
    int i = paramSparseIntArray.get(1001);
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    HashMap localHashMap = new HashMap();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    DeviceInfo localDeviceInfo;
    Friends localFriends;
    int j;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localDeviceInfo = (DeviceInfo)localIterator.next();
        if (localDeviceInfo.isAdmin == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("smartdevice::baseim.server_list", 2, "share device[" + localDeviceInfo.name + "] is not binded");
          }
        }
        else
        {
          localFriends = new Friends();
          localFriends.uin = AppConstants.aG;
          if (localDeviceInfo.userStatus == 10)
          {
            j = 1;
            label191:
            if (localDeviceInfo.productId != 1000000344) {
              break label594;
            }
            j = 1;
          }
        }
      }
    }
    label214:
    label247:
    label409:
    label530:
    label594:
    for (;;)
    {
      int k;
      byte b1;
      Object localObject;
      if (j != 0)
      {
        k = 10;
        b1 = (byte)k;
        localObject = (String)localHashMap.get(Integer.valueOf(localDeviceInfo.productId));
        if (!"1".equals(localObject)) {
          break label409;
        }
        if (DeviceHeadMgr.a().a(String.valueOf(localDeviceInfo.din))) {
          b1 = 12;
        }
        localFriends.remark = SmartDeviceUtil.a(localDeviceInfo);
        localFriends.name = String.valueOf(localDeviceInfo.din);
        localFriends.signature = localDeviceInfo.serialNum;
        localFriends.status = b1;
        localFriends.groupid = 1001;
        localFriends.memberLevel = 0;
        localFriends.isMqqOnLine = false;
        localFriends.sqqOnLineState = 0;
        localFriends.alias = localDeviceInfo.type;
        localFriends.iTermType = localDeviceInfo.productId;
        if (j == 0) {
          break label530;
        }
        localArrayList1.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
        i += 1;
      }
      for (;;)
      {
        paramSparseIntArray.put(1001, i);
        break;
        j = 0;
        break label191;
        k = 0;
        break label214;
        if ("2".equals(localObject))
        {
          b1 = 11;
          break label247;
        }
        localObject = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
        if ((localObject != null) && ((((ProductInfo)localObject).deviceType == 13) || (((ProductInfo)localObject).deviceType == 14) || ((((ProductInfo)localObject).deviceType == 17) && (((ProductInfo)localObject).uConnectType == 1))))
        {
          localHashMap.put(Integer.valueOf(localDeviceInfo.productId), "2");
          b1 = 11;
          break label247;
        }
        if (localObject != null) {
          localHashMap.put(Integer.valueOf(localDeviceInfo.productId), "1");
        }
        break label247;
        localArrayList2.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
      }
      if (localArrayList1.size() > 0) {
        paramSparseArray.addAll(localArrayList1);
      }
      if (localArrayList2.size() > 0) {
        paramSparseArray.addAll(localArrayList2);
      }
      return;
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Groups localGroups = (Groups)getGroup(paramInt);
    BuddyListAdapter.GroupTag localGroupTag;
    if (!(paramView.getTag() instanceof BuddyListAdapter.GroupTag))
    {
      localGroupTag = new BuddyListAdapter.GroupTag();
      localGroupTag.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131297702));
      localGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131297704));
      localGroupTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131297706));
      localGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131297705));
      localGroupTag.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297703));
      paramView.setTag(localGroupTag);
    }
    for (paramView = localGroupTag;; paramView = (BuddyListAdapter.GroupTag)paramView.getTag())
    {
      a(paramView, localGroups, paramInt, true, 0);
      return;
    }
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      g();
      DropFrameMonitor.a().a("list_g_contacts", false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
      }
      return;
      DropFrameMonitor.a().a("list_g_contacts");
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.b(paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "onRecommendCountChanged count=" + paramInt + ",beAdded=" + paramBoolean);
    }
    if (paramBoolean) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        Object localObject = this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
        if ((!(localObject instanceof Groups)) || (((Groups)localObject).group_id != 1002)) {
          break label113;
        }
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(paramInt)) {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.d(paramInt);
        }
      }
      notifyDataSetChanged();
      return;
      label113:
      paramInt += 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(1001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      Friends localFriends = (Friends)((BuddyListItem)((Iterator)localObject).next()).a;
      if (((localFriends.uin.equals(AppConstants.aj)) || (localFriends.uin.equals(AppConstants.al))) && ((paramString.equals(AppConstants.aj)) || (paramString.equals(AppConstants.al))))
      {
        if (paramBoolean)
        {
          j = 10;
          label120:
          localFriends.status = ((byte)j);
        }
      }
      else
      {
        if (localFriends.uin.equals(paramString))
        {
          if (!paramBoolean) {
            break label179;
          }
          j = 10;
          label148:
          localFriends.status = ((byte)j);
        }
        if (localFriends.status == 0) {
          break label198;
        }
        i += 1;
      }
    }
    label179:
    label198:
    for (;;)
    {
      break;
      j = 0;
      break label120;
      j = 0;
      break label148;
      this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1001, i);
      return;
    }
  }
  
  public boolean a(View paramView)
  {
    if ((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag))
    {
      paramView = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      if (((paramView.a instanceof Friends)) && (((Friends)paramView.a).uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
        return false;
      }
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(1001);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < localList.size()) {
      if (!((Friends)((BuddyListItem)localList.get(i)).a).uin.equals(AppConstants.al)) {}
    }
    for (;;)
    {
      if (((PrinterStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(74)).a()) {
        if (i == -1)
        {
          Friends localFriends = new Friends();
          localFriends.uin = AppConstants.al;
          localFriends.remark = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362166);
          localFriends.name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362166);
          if (!a(AppConstants.aj)) {
            break label217;
          }
          i = 10;
          label147:
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localFriends.memberLevel = 0;
          localFriends.isMqqOnLine = false;
          localFriends.sqqOnLineState = 0;
          localList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
        }
      }
      for (;;)
      {
        a(a(AppConstants.aj), AppConstants.aj);
        return;
        i += 1;
        break;
        label217:
        i = 0;
        break label147;
        if (i != -1) {
          localList.remove(i);
        }
      }
      i = -1;
    }
  }
  
  public void b(int paramInt)
  {
    notifyDataSetChanged();
  }
  
  public void c()
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(1001);
    this.jdField_a_of_type_Boolean = true;
    if ((localList == null) || (localList.size() == 0)) {}
    label134:
    label287:
    label295:
    for (;;)
    {
      return;
      int i = 0;
      if (i < localList.size()) {
        if (!((Friends)((BuddyListItem)localList.get(i)).a).uin.equals(AppConstants.ak)) {}
      }
      for (;;)
      {
        if (i != -1) {
          break label295;
        }
        Friends localFriends = new Friends();
        localFriends.uin = AppConstants.ak;
        localFriends.remark = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362119);
        localFriends.name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362119);
        if (a(AppConstants.ak))
        {
          i = 10;
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localFriends.memberLevel = 0;
          localFriends.isMqqOnLine = false;
          localFriends.sqqOnLineState = 0;
          localList.add(BuddyItemBuilder.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
          if (localFriends.status == 0) {
            break label287;
          }
        }
        for (i = 1;; i = 0)
        {
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1001, i);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
          this.jdField_b_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
          }
          ((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).c(1);
          return;
          i += 1;
          break;
          i = 0;
          break label134;
        }
        i = -1;
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(this.h + "%");
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(this.h + "%");
    }
  }
  
  public void d()
  {
    i();
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "onUpdateContactList, " + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
    i();
    super.e();
  }
  
  public void f() {}
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      Groups localGroups = (Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1);
      return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id)).get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    long l2 = 0L;
    if ((localObject instanceof Friends)) {
      localObject = (Friends)localObject;
    }
    do
    {
      long l1;
      do
      {
        try
        {
          l1 = Long.parseLong(((Friends)localObject).uin);
          return l1;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
            }
            l1 = 0L;
          }
        }
        if ((localThrowable1 instanceof PublicAccountInfo)) {
          return ((PublicAccountInfo)localThrowable1).uin;
        }
        l1 = l2;
      } while (!(localThrowable1 instanceof PhoneContact));
      PhoneContact localPhoneContact = (PhoneContact)localThrowable1;
      try
      {
        l1 = Long.parseLong(localPhoneContact.mobileNo);
        return l1;
      }
      catch (Throwable localThrowable2)
      {
        l1 = l2;
      }
    } while (!QLog.isColorLevel());
    QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
    return 0L;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      if (((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
        return 1;
      }
      return 0;
    }
    return 99;
  }
  
  public int getChildTypeCount()
  {
    return 6;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.a("getChildView");
    paramView = ((BuddyListItem)getChild(paramInt1, paramInt2)).a(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramView != null)
    {
      a((BuddyListItem.ViewTag)paramView.getTag(), null);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    TraceUtils.a();
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (getGroupType(paramInt) == 1) {
      return 0;
    }
    paramInt = ((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).group_id;
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localList == null) {}
    for (paramInt = 0;; paramInt = localList.size()) {
      return paramInt;
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    if (getGroupType(paramInt) == 0) {
      return ((Groups)getGroup(paramInt)).group_id;
    }
    return 1000L;
  }
  
  public int getGroupType(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList.get(paramInt) instanceof String)) {
      return 1;
    }
    return 0;
  }
  
  public int getGroupTypeCount()
  {
    return 2;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    if (getGroupType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903210, paramViewGroup, false);
        paramViewGroup = (SingleLineTextView)paramView.findViewById(2131297700);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = (String)getGroup(paramInt);
        paramViewGroup.setText("");
        return paramView;
        paramViewGroup = (SingleLineTextView)paramView.getTag();
      }
    }
    Object localObject = (Groups)getGroup(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130903213, paramViewGroup, false);
      paramView.setBackgroundResource(2130838310);
      paramViewGroup = new BuddyListAdapter.GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131297704));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131297702));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundResource(2130838371);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131297705));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297703));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131297706));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      if (paramBoolean) {
        i = 2;
      }
      a(paramViewGroup, (Groups)localObject, paramInt, false, i);
      return paramView;
      paramViewGroup = (BuddyListAdapter.GroupTag)paramView.getTag();
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
  
  public void notifyDataSetChanged()
  {
    ThreadManager.a(new poe(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    paramView = (BuddyListAdapter.GroupTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.d(paramView.jdField_a_of_type_Int);
      if ((getGroupId(paramView.jdField_a_of_type_Int) != 1001L) || (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.e(paramView.jdField_a_of_type_Int))) {
        break label242;
      }
      paramView = new Intent();
      paramView.setAction("SmartDevice_clickOnDeviceList");
      BaseApplicationImpl.a().sendBroadcast(paramView);
    }
    label242:
    label513:
    label552:
    label736:
    label870:
    do
    {
      int i;
      do
      {
        do
        {
          return;
          if (getGroupId(paramView.jdField_a_of_type_Int) == 1002L)
          {
            i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
            if ((i == 1) || (i == 2) || (i == 3)) {
              break;
            }
            this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
            i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
            if (i == 0) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80058DF", "0X80058DF", 0, 0, "" + i, "", "", "");
            this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g();
            break;
          }
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
          ((QzoneContactsFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(90)).a();
          break;
          if (getGroupId(paramView.jdField_a_of_type_Int) != 1002L) {
            break label870;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
          if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "onClick phone contact state=" + i);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A1", "0X80068A1", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b())
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a() <= 0) {
              break label513;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A5", "0X80068A5", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            if ((!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b()) && (i != 5)) {
              break label552;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c() == 1)
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, GuideBindPhoneActivity.class);
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053DD", "0X80053DD", 0, 0, "", "", "", "");
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("BuddyListAdapter", 2, "onClick banner state=" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c());
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A4", "0X80068A4", 0, 0, "", "", "", "");
          }
          if ((i == 1) || (i == 2))
          {
            ContactUtils.a(5);
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, BindNumberActivity.class);
            paramView.putExtra("key_from_Tab", true);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053DB", "0X80053DB", 0, 0, "", "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A2", "0X80068A2", 0, 0, "", "", "", "");
            return;
          }
          if (i != 3) {
            break label736;
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().lastUsedFlag != 3L));
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PhoneMatchActivity.class);
        paramView.putExtra("key_from_Tab", true);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        return;
      } while (i != 4);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A3", "0X80068A3", 0, 0, "", "", "", "");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c())
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PhoneLaunchActivity.class);
        paramView.putExtra("needAlert", true);
        paramView.putExtra("fromStopAndMatch", true);
        paramView.putExtra("leftViewText", "返回");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new pog(this));
      QQToast.a(BaseApplicationImpl.a, "特征码匹配中。", 0).a();
      return;
      if (getGroupId(paramView.jdField_a_of_type_Int) == 1004L)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6C", "0X8006A6C", 0, 0, "", "", "", "");
        return;
      }
    } while (getGroupId(paramView.jdField_a_of_type_Int) != 1005L);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006FFD", "0X8006FFD", 0, 0, "", "", "", "");
  }
  
  public boolean onLongClick(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131369741));
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof BuddyListAdapter.GroupTag))) {
      BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_b_of_type_AndroidViewView$OnClickListener, null);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\BuddyListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */