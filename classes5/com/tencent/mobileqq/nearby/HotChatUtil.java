package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotchat.HCSeatInfo;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotchat.PttShowRoomMng.PendingCmd;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.service.message.MessageCacheItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class HotChatUtil
{
  public static final int a = 0;
  public static final String a = "PttShow";
  public static final int b = 1;
  public static final String b = "SEL_MEMBER_UIN";
  public static final int c = 2;
  public static final String c = "HC_MEMBER_ACTION";
  public static final String d = "HC_MEMBER_SEATID";
  
  public HotChatUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static PopupWindow a(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "showPttRoomTip", new Object[0]);
    }
    if ((paramView == null) || (paramView.getContext() == null)) {
      return null;
    }
    Object localObject2 = paramView.getContext();
    Object localObject1 = ((Context)localObject2).getResources();
    Object localObject3 = ((Resources)localObject1).getDisplayMetrics();
    int i1 = Math.min(((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
    int i2 = (int)(((DisplayMetrics)localObject3).density * 10.0F);
    int k = ((Resources)localObject1).getDimensionPixelSize(2131493638);
    int m = ((Resources)localObject1).getDimensionPixelSize(2131493644);
    int n = ((Resources)localObject1).getDimensionPixelSize(2131493645);
    int j = ((Resources)localObject1).getDimensionPixelSize(2131493648);
    int i = ((Resources)localObject1).getDimensionPixelSize(2131493649);
    if (i2 * 2 + j > i1)
    {
      float f = j;
      j = i1 - i2 * 2;
      f = j / f;
      i = (int)(i * f);
    }
    for (;;)
    {
      localObject1 = new int[2];
      i1 = paramView.getWidth();
      i2 = paramView.getHeight();
      paramView.getLocationInWindow((int[])localObject1);
      i2 = -(i2 + (i + n) + k);
      localObject2 = (LinearLayout)LayoutInflater.from((Context)localObject2).inflate(2130904232, null);
      Object localObject4 = ((LinearLayout)localObject2).findViewById(2131299844);
      localObject3 = ((LinearLayout)localObject2).findViewById(2131301035);
      localObject4 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).width = j;
      ((LinearLayout.LayoutParams)localObject4).height = i;
      localObject3 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).width = m;
      ((LinearLayout.LayoutParams)localObject3).height = n;
      ((LinearLayout.LayoutParams)localObject3).leftMargin = (localObject1[0] + (i1 - m) / 2 - k);
      localObject1 = new PopupWindow((View)localObject2, j, i + n);
      ((PopupWindow)localObject1).setBackgroundDrawable(new ColorDrawable(0));
      ((PopupWindow)localObject1).setOutsideTouchable(true);
      ((PopupWindow)localObject1).showAsDropDown(paramView, 0, i2);
      return (PopupWindow)localObject1;
    }
  }
  
  public static PopupWindow a(View paramView, View.OnClickListener paramOnClickListener)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "showPttRoomGuide", new Object[0]);
    }
    if ((paramView == null) || (paramView.getContext() == null)) {
      return null;
    }
    Object localObject1 = paramView.getContext();
    Object localObject2 = ((Context)localObject1).getResources();
    Object localObject3 = ((Resources)localObject2).getDisplayMetrics();
    int i2 = Math.min(((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
    int i3 = Math.max(((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
    int i4 = (int)(((DisplayMetrics)localObject3).density * 10.0F);
    int i7 = (int)(((DisplayMetrics)localObject3).density * 7.5D);
    int i = ((Resources)localObject2).getDimensionPixelSize(2131493650);
    int i1 = ((Resources)localObject2).getDimensionPixelSize(2131493651);
    int i8 = ((Resources)localObject2).getDimensionPixelSize(2131493638);
    int n = ((Resources)localObject2).getDimensionPixelSize(2131493642);
    int m = ((Resources)localObject2).getDimensionPixelSize(2131493646);
    int k = ((Resources)localObject2).getDimensionPixelSize(2131493647);
    int i5 = ((Resources)localObject2).getDimensionPixelSize(2131493644);
    int i6 = ((Resources)localObject2).getDimensionPixelSize(2131493645);
    int j = (int)(((DisplayMetrics)localObject3).density * 67.5D);
    float f1 = 1.0F;
    float f2 = i;
    float f3 = i8 + (i1 + n) + i6;
    if ((f2 > i2 - i7 * 2) || (f3 > i3 - i4 * 2))
    {
      f1 = Math.min((i2 - i7 * 2) / f2, (i3 - i4 * 2) / f3);
      i = (int)(i * f1);
      i1 = (int)(i1 * f1);
      n = (int)(n * f1);
      m = (int)(m * f1);
      k = (int)(k * f1);
      j = (int)(j * f1);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "showPttRoomGuide", new Object[] { Float.valueOf(((DisplayMetrics)localObject3).density), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f1), Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
      }
      localObject3 = new int[2];
      paramView.getLocationInWindow((int[])localObject3);
      i7 = localObject3[1];
      i8 = ((Resources)localObject2).getDimensionPixelSize(2131492908);
      int i9 = ((Resources)localObject2).getDimensionPixelSize(2131493623);
      int i10 = ((Resources)localObject2).getDimensionPixelSize(2131493624);
      localObject1 = (LinearLayout)LayoutInflater.from((Context)localObject1).inflate(2130904251, null);
      ((LinearLayout)localObject1).setPadding(0, i7 + i8 + i9 - i10, 0, 0);
      localObject2 = (ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).findViewById(2131301399).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).width = i;
      ((ViewGroup.MarginLayoutParams)localObject2).height = i1;
      localObject2 = (ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).findViewById(2131301035).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).width = i5;
      ((ViewGroup.MarginLayoutParams)localObject2).height = i6;
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ((n - i5) / 2 + j);
      localObject2 = (ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).findViewById(2131302074).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).width = n;
      ((ViewGroup.MarginLayoutParams)localObject2).height = n;
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
      localObject2 = (ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).findViewById(2131299844).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).width = m;
      ((ViewGroup.MarginLayoutParams)localObject2).height = k;
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i4;
      localObject2 = new PopupWindow((View)localObject1, i2, i3);
      ((LinearLayout)localObject1).setTag(Long.valueOf(System.nanoTime()));
      ((LinearLayout)localObject1).setOnClickListener(paramOnClickListener);
      ((PopupWindow)localObject2).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E1000000")));
      ((PopupWindow)localObject2).setOutsideTouchable(false);
      ((PopupWindow)localObject2).showAtLocation(paramView, 51, 0, 0);
      return (PopupWindow)localObject2;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return "加入热聊失败，请稍后再试。";
    case 2: 
      return "该热聊不存在，换个热聊试试吧。";
    case 4: 
      return "由于你发表了不恰当信息，暂时无法加入热聊。";
    case 5: 
      return "该热聊已经满员，换个热聊试试吧。";
    }
    return "你已被移出本热聊房间，无法加入。";
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 0L) {
      return "0";
    }
    if (paramLong <= 999999L) {
      return String.valueOf(paramLong);
    }
    if (paramLong <= 99999999L) {
      return String.format("%.1f万", new Object[] { Double.valueOf(paramLong / 10000.0D) });
    }
    return String.format("%.3f亿", new Object[] { Double.valueOf(paramLong / 1.0E8D) });
  }
  
  public static List a(HotChatInfo paramHotChatInfo, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "localCompatDeal", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong1) });
    }
    if (paramHotChatInfo == null) {
      return null;
    }
    paramHotChatInfo = paramHotChatInfo.getHCSeatInfoList();
    if (paramHotChatInfo == null) {
      return null;
    }
    HCSeatInfo localHCSeatInfo;
    if ((paramInt1 == 1) || (paramInt1 == 3))
    {
      if (paramInt1 == 1) {}
      for (long l = paramLong2;; l = paramLong1)
      {
        localIterator = paramHotChatInfo.iterator();
        while (localIterator.hasNext())
        {
          localHCSeatInfo = (HCSeatInfo)localIterator.next();
          if ((localHCSeatInfo != null) && (localHCSeatInfo.guestUin == l))
          {
            localHCSeatInfo.guestUin = 0L;
            localHCSeatInfo.seatFlag = 0;
          }
        }
      }
    }
    Iterator localIterator = paramHotChatInfo.iterator();
    while (localIterator.hasNext())
    {
      localHCSeatInfo = (HCSeatInfo)localIterator.next();
      if ((localHCSeatInfo != null) && (localHCSeatInfo.seatID == paramInt2)) {
        switch (paramInt1)
        {
        default: 
          break;
        case 1: 
          localHCSeatInfo.guestUin = paramLong2;
          break;
        case 2: 
          localHCSeatInfo.guestUin = 0L;
          break;
        case 3: 
          localHCSeatInfo.guestUin = paramLong1;
          break;
        case 4: 
          localHCSeatInfo.guestUin = 0L;
          localHCSeatInfo.seatFlag = 0;
          break;
        case 5: 
          localHCSeatInfo.seatFlag = paramInt3;
        }
      }
    }
    return paramHotChatInfo;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramQQAppInterface == null) || (paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return;
    }
    boolean bool = paramString2.equals(paramQQAppInterface.a());
    FriendsManager localFriendsManager;
    int i;
    if (!bool)
    {
      localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
      if ((localFriendsManager != null) && (localFriendsManager.b(paramString2))) {
        i = 1;
      }
    }
    for (;;)
    {
      Object localObject = paramQQAppInterface.a(false);
      localFriendsManager = null;
      paramQQAppInterface = localFriendsManager;
      if (localObject != null)
      {
        localObject = ((HotChatManager)localObject).a(paramString1);
        paramQQAppInterface = localFriendsManager;
        if (localObject != null) {
          paramQQAppInterface = ((HotChatInfo)localObject).troopCode;
        }
      }
      if ((bool) || (i == 0))
      {
        paramString2 = new ProfileActivity.AllInOne(paramString2, 42);
        paramString2.g = 33;
        paramString2.d = paramString1;
        paramString2.c = paramQQAppInterface;
        paramQQAppInterface = new Intent(paramContext, NearbyPeopleProfileActivity.class);
        paramQQAppInterface.putExtra("AllInOne", paramString2);
        if (bool) {}
        for (i = 2;; i = 3)
        {
          paramQQAppInterface.putExtra("param_mode", i);
          paramContext.startActivity(paramQQAppInterface);
          return;
          i = 0;
          break;
        }
      }
      paramString2 = new ProfileActivity.AllInOne(paramString2, 20);
      paramString2.a = 20;
      paramString2.d = paramString1;
      paramString2.c = paramQQAppInterface;
      paramString2.g = 4;
      ProfileActivity.b(paramContext, paramString2);
      return;
      i = 0;
    }
  }
  
  public static void a(Context paramContext, HotChatInfo paramHotChatInfo, HotChatManager paramHotChatManager, long paramLong)
  {
    if ((paramContext == null) || (paramHotChatInfo == null) || (paramHotChatManager == null)) {}
    for (;;)
    {
      return;
      PttShowRoomMng localPttShowRoomMng = paramHotChatManager.a(false);
      if (localPttShowRoomMng != null)
      {
        Object localObject = null;
        int i = paramHotChatInfo.getUserType(paramLong);
        if (i == 2)
        {
          PttShowRoomMng.PendingCmd localPendingCmd = localPttShowRoomMng.a(paramHotChatInfo.troopUin, 3);
          localPttShowRoomMng.a(paramHotChatInfo.troopUin, 4);
          paramHotChatManager = (HotChatManager)localObject;
          if (localPendingCmd != null) {
            paramHotChatManager = "你已经被房主邀请为嘉宾。";
          }
        }
        while (paramHotChatManager != null)
        {
          i = paramContext.getResources().getDimensionPixelSize(2131492908);
          QQToast.a(paramContext, paramHotChatManager, 0).b(i);
          return;
          paramHotChatManager = (HotChatManager)localObject;
          if (i == 0)
          {
            localPttShowRoomMng.a(paramHotChatInfo.troopUin, 3);
            paramHotChatManager = (HotChatManager)localObject;
            if (localPttShowRoomMng.a(paramHotChatInfo.troopUin, 4) != null) {
              paramHotChatManager = "你已经被房主取消嘉宾身份。";
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (a(paramQQAppInterface, paramString, true))
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "setReadedForHCTopic", paramString });
      }
      paramQQAppInterface.a().a(paramString, 1026, true, true);
    }
  }
  
  public static void a(MessageCacheItem paramMessageCacheItem, long paramLong, String paramString, int paramInt)
  {
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        paramMessageCacheItem.a(0, paramString, paramLong, 1);
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "addLocalMaxMsgSeq", String.format("needUpdateLocal:%b\tfrom:%d\t msgSeq:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), Long.valueOf(paramLong) }) });
      }
      return;
      long l = paramMessageCacheItem.a(0, paramString);
      if (1L + l == paramLong)
      {
        bool = true;
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        NearbyUtils.a("PttShow", new Object[] { "addLocalMaxMsgSeq", String.format("not continuous seq local:%d\tmsgseq:%d\tfrom:%d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong), Integer.valueOf(paramInt) }) });
        bool = false;
        continue;
        bool = true;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramRecentUser == null) || (paramRecentUser.type != 1) || (TextUtils.isEmpty(paramRecentUser.uin))) {
      bool = false;
    }
    do
    {
      return bool;
      if ((paramRecentUser.lFlag & 1L) == 0L)
      {
        paramQQAppInterface = paramQQAppInterface.a(false);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramRecentUser.uin))) {
          paramRecentUser.lFlag |= 1L;
        }
      }
    } while ((paramRecentUser.lFlag & 1L) == 1L);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null) || (paramString.length() == 0)) {}
    label57:
    label60:
    for (;;)
    {
      return false;
      HotChatManager localHotChatManager = paramQQAppInterface.a(false);
      if (localHotChatManager == null)
      {
        paramString = null;
        if (paramString == null) {
          break label57;
        }
      }
      for (int i = paramString.getUserType(paramQQAppInterface.getLongAccountUin());; i = 0)
      {
        if (i == 0) {
          break label60;
        }
        return true;
        paramString = localHotChatManager.a(paramString);
        break;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      if (paramBoolean) {
        break;
      }
      paramBoolean = true;
      paramQQAppInterface = paramQQAppInterface.a(paramBoolean);
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(paramString);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isPttShowRoom())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      paramBoolean = false;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\HotChatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */