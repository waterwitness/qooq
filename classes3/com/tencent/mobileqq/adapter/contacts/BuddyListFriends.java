package com.tencent.mobileqq.adapter.contacts;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.FriendItemLayout;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

public class BuddyListFriends
  extends BuddyListItem
{
  public static final int a = 1;
  public static final int[] a;
  public static final int b = 0;
  static final int[] b = { 2130838384, 2130838384 };
  public static final int c = 1;
  static final int[] c = { 2131301511, 2131301511 };
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  OlympicTorchManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 2131367581, 2131367580 };
  }
  
  public BuddyListFriends(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(166));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a();
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)paramEntity);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c();
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(this.jdField_a_of_type_AndroidContentContext);
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0))
    {
      this.h &= 0xFFFFFFFE;
      return;
    }
    this.h |= 0x1;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    BuddyListFriends.BuddyChildTag localBuddyChildTag;
    View localView;
    int k;
    int m;
    int n;
    int i;
    long l;
    label376:
    label394:
    label415:
    label453:
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && (!((BuddyListFriends.BuddyChildTag)paramView.getTag()).jdField_a_of_type_Boolean)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903218, null);
      localBuddyChildTag = ((FriendItemLayout)paramView).a();
      localView = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, localBuddyChildTag, -1);
      localBuddyChildTag.jdField_a_of_type_Boolean = true;
      localView.setTag(localBuddyChildTag);
      a();
      localBuddyChildTag.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
      localBuddyChildTag.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      a(localBuddyChildTag);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, false);
      int j = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, paramView, 0, this.jdField_a_of_type_Boolean);
      k = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, paramView, this.jdField_a_of_type_Boolean);
      m = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, paramView, this.jdField_a_of_type_Boolean);
      n = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, paramView, this.jdField_a_of_type_Boolean);
      a(localBuddyChildTag, j, k, m, n);
      localBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
      i = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.detalStatusFlag, this.jdField_a_of_type_ComTencentMobileqqDataFriends.iTermType);
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      switch (i)
      {
      case 5: 
      case 6: 
      default: 
        l = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getLastLoginType();
        if (((((PhoneContactManagerImp)localObject).e & 0x2) == 2L) && (l == 1L))
        {
          paramViewGroup = "请留言";
          paramView = paramViewGroup;
          if (paramViewGroup == null) {
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131370230);
          }
          localBuddyChildTag.jdField_b_of_type_Boolean = false;
          if ((i != 0) && (i != 6)) {
            break label997;
          }
          i = 1;
          if ((((PhoneContactManagerImp)localObject).e & 1L) != 1L)
          {
            paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840575);
            localObject = localBuddyChildTag.jdField_a_of_type_AndroidWidgetImageView;
            if (i == 0) {
              break label1003;
            }
            ((ImageView)localObject).setImageDrawable(paramViewGroup);
            if (i == 0) {
              break label1009;
            }
            bool = true;
            label468:
            localBuddyChildTag.jdField_b_of_type_Boolean = bool;
          }
          localBuddyChildTag.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramView + "]");
          a(localBuddyChildTag);
          localBuddyChildTag.d.setVisibility(8);
          if ((i != 0) || ((!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1015;
          }
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131428331));
          label586:
          if (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label1036;
          }
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841101);
          label630:
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
          localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
          localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          a(localView, paramInt1 << 16 | paramInt2, localBuddyChildTag, paramOnClickListener);
          if (AppSetting.j)
          {
            paramViewGroup = localBuddyChildTag.jdField_a_of_type_JavaLangStringBuilder;
            if (paramViewGroup != null) {
              break label1096;
            }
            paramViewGroup = new StringBuilder(24);
            label703:
            paramViewGroup.append((String)localObject).append(".").append(paramView).append(".");
            if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
              paramViewGroup.append("QQ会员").append(".");
            }
            if (!TextUtils.isEmpty(null)) {
              paramViewGroup.append(null).append(".");
            }
            if (n != 1) {
              break label1111;
            }
            paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131372675, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.f) }));
            label827:
            if (m != 1) {
              break label1153;
            }
            paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131372673, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d) }));
            label866:
            if (j <= 0) {
              break label1195;
            }
            paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131372677, new Object[] { Integer.valueOf(j) }));
          }
        }
        break;
      }
    }
    for (;;)
    {
      localView.setContentDescription(paramViewGroup);
      return localView;
      localBuddyChildTag = (BuddyListFriends.BuddyChildTag)paramView.getTag();
      localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      localView = paramView;
      break;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131370233);
      break label394;
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131370234);
      break label394;
      paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.netTypeIconId);
      break label394;
      paramViewGroup = paramView.a(l);
      break label376;
      label997:
      i = 0;
      break label415;
      label1003:
      paramViewGroup = null;
      break label453;
      label1009:
      bool = false;
      break label468;
      label1015:
      localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131428267));
      break label586;
      label1036:
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))
      {
        localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
        localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130841107);
        break label630;
      }
      localBuddyChildTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      break label630;
      label1096:
      paramViewGroup.delete(0, paramViewGroup.length());
      break label703;
      label1111:
      if (n != 2) {
        break label827;
      }
      paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131372676, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.g) }));
      break label827;
      label1153:
      if (m != 2) {
        break label866;
      }
      paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131372674, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e) }));
      break label866;
      label1195:
      if (k == 1) {
        paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131372671, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b) }));
      } else if (k == 2) {
        paramViewGroup.append(this.jdField_a_of_type_AndroidContentContext.getString(2131372672, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c) }));
      }
    }
  }
  
  public String a(BuddyListItem.ViewTag paramViewTag)
  {
    int m = 0;
    BuddyListFriends.BuddyChildTag localBuddyChildTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    int i;
    int j;
    label66:
    boolean bool;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      i = 1;
      if (localExtensionInfo == null) {
        break label428;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListItem$BuddyListCallback == null) {
        break label422;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqAdapterContactsBuddyListItem$BuddyListCallback.b();
      if (j == 0) {
        break label248;
      }
      bool = true;
    }
    label74:
    label103:
    label121:
    label248:
    label260:
    label266:
    label273:
    label422:
    label428:
    for (paramViewTag = localExtensionInfo.getRichStatus(bool);; paramViewTag = null)
    {
      int k;
      Object localObject;
      if ((paramViewTag != null) && (paramViewTag != RichStatus.getEmptyStatus()) && (!paramViewTag.isEmpty()))
      {
        j = 1;
        if ((j == 0) || (TextUtils.isEmpty(paramViewTag.actionText))) {
          break label260;
        }
        k = 1;
        if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
          break label273;
        }
        paramViewTag = new String(localExtensionInfo.feedContent);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = localBuddyChildTag.c;
        if (!localExtensionInfo.feedHasPhoto) {
          break label266;
        }
      }
      for (i = m;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        localObject = null;
        if (localExtensionInfo == null)
        {
          localBuddyChildTag.c.setVisibility(8);
          localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramViewTag);
        return paramViewTag;
        i = 0;
        break;
        bool = false;
        break label74;
        j = 0;
        break label103;
        k = 0;
        break label121;
      }
      if (k != 0)
      {
        paramViewTag.enableSummaryCached = this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend();
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramViewTag.actionId, 200);
        localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
        i = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
      }
      for (;;)
      {
        localObject = paramViewTag.getActionAndData();
        paramViewTag = paramViewTag.getPlainText();
        localBuddyChildTag.c.setVisibility(8);
        localBuddyChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        if (j == 0)
        {
          paramViewTag = RichStatus.getEmptyStatus();
          localBuddyChildTag.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        }
      }
      j = 0;
      break label66;
    }
  }
  
  protected void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramInt = 1;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    label91:
    for (;;)
    {
      return;
      if ((paramArrayOfSwipRightMenuItem.length < 0) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isFriend())) {
        if ((this.h & 0x1) == 1)
        {
          paramArrayOfSwipRightMenuItem[0].b = 0;
          paramArrayOfSwipRightMenuItem[0].a = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfSwipRightMenuItem.length) {
          break label91;
        }
        paramArrayOfSwipRightMenuItem[paramInt].b = -1;
        paramArrayOfSwipRightMenuItem[paramInt].a = -1;
        paramInt += 1;
        continue;
        paramArrayOfSwipRightMenuItem[0].b = 1;
        break;
        paramInt = 0;
      }
    }
  }
  
  public void a(BuddyListItem.ViewTag paramViewTag)
  {
    paramViewTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.b("MCard");
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager.b(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
      OlympicUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8006EFF", 0, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
    }
    if (paramViewTag.e.getVisibility() == 0)
    {
      bool2 = true;
      if (bool1 != bool2)
      {
        paramViewTag = paramViewTag.e;
        if (!bool1) {
          break label100;
        }
      }
    }
    label100:
    for (int i = 0;; i = 8)
    {
      paramViewTag.setVisibility(i);
      return;
      bool2 = false;
      break;
    }
  }
  
  public void a(BuddyListItem.ViewTag paramViewTag, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = System.currentTimeMillis();
    paramViewTag = (BuddyListFriends.BuddyChildTag)paramViewTag;
    if (paramInt4 == 1)
    {
      paramViewTag.f.setVisibility(0);
      paramViewTag.f.setImageResource(2130843191);
      if (paramInt3 != 1) {
        break label172;
      }
      paramViewTag.g.setVisibility(0);
      paramViewTag.g.setImageResource(2130843192);
      label58:
      if (paramInt2 != 1) {
        break label211;
      }
      paramViewTag.h.setVisibility(0);
      paramViewTag.h.setImageResource(2130843190);
      label81:
      if (paramInt2 != 0) {
        break label249;
      }
      paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "setReactiveIconShow time=" + (System.currentTimeMillis() - l));
      }
      return;
      if (paramInt4 == 2)
      {
        paramViewTag.f.setVisibility(0);
        paramViewTag.f.setImageResource(2130843185);
        break;
      }
      paramViewTag.f.setVisibility(8);
      break;
      label172:
      if (paramInt3 == 2)
      {
        paramViewTag.g.setVisibility(0);
        paramViewTag.g.setImageResource(2130843186);
        break label58;
      }
      paramViewTag.g.setVisibility(8);
      break label58;
      label211:
      if (paramInt2 == 2)
      {
        paramViewTag.h.setVisibility(0);
        paramViewTag.h.setImageResource(2130843184);
        break label81;
      }
      paramViewTag.h.setVisibility(8);
      break label81;
      label249:
      if (paramInt1 <= 0)
      {
        paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 > 999) {
          paramInt2 = 999;
        }
        paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewTag.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt2 + "天");
      }
    }
  }
  
  protected int[] a()
  {
    return c;
  }
  
  protected int[] b()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  protected int[] c()
  {
    return b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\contacts\BuddyListFriends.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */