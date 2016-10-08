package com.tencent.mobileqq.hotchat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.BadTokenException;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.OnVListUpdateListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.CustomImgView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ssv;
import ssw;
import ssx;
import ssy;

public class HCTopicSeatsView
  extends LinearLayout
  implements Handler.Callback
{
  public static final int a = 1;
  public static final String a = "HCTopicSeatsView";
  public static final int b = 2;
  static final String jdField_b_of_type_JavaLangString = "操作失败，请检查网络连接。";
  public static final int c = 4;
  static final String c = "正在操作，请稍候...";
  static final int d = 6;
  protected static final int h = 0;
  protected static final int i = 1;
  protected static final int j = 2;
  protected static final int k = 4;
  protected static final int l = 5;
  protected static final int m = 6;
  protected static final int n = 7;
  protected static final int o = 0;
  protected static final int p = 1;
  protected static final int q = 2;
  protected static final int r = 3;
  protected static final int s = 4;
  long jdField_a_of_type_Long;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Handler a;
  protected View.OnClickListener a;
  public PopupWindow a;
  public HotChatHandler a;
  private HotChatManager.OnVListUpdateListener jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener = new ssy(this);
  public HotChatManager a;
  public QQAppInterface a;
  QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  int[] jdField_a_of_type_ArrayOfInt = new int[2];
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  public String d;
  public int e;
  int f;
  int g;
  
  public HCTopicSeatsView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HCTopicSeatsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ssv(this);
    this.b = new ssw(this);
    e();
  }
  
  public int a(HCSeatInfo paramHCSeatInfo, List paramList)
  {
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      switch (this.e)
      {
      default: 
        if (paramHCSeatInfo.guestUin != 0L)
        {
          paramList.add(HCTopicSeatsView.MenuItem.a(0, paramHCSeatInfo));
          a("0X8006582");
          return 0;
        }
        break;
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        localException.printStackTrace();
        l1 = 0L;
      }
      if ((paramHCSeatInfo.guestUin != 0L) && (paramHCSeatInfo.guestUin == l1))
      {
        paramList.add(HCTopicSeatsView.MenuItem.a(0, paramHCSeatInfo));
        return 0;
      }
      if (paramHCSeatInfo.guestUin != 0L)
      {
        paramList.add(HCTopicSeatsView.MenuItem.a(0, paramHCSeatInfo));
        paramList.add(HCTopicSeatsView.MenuItem.a(1, paramHCSeatInfo));
        a("0X8006582");
        return 0;
      }
      HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.d);
      if ((localHotChatInfo != null) && (localHotChatInfo.userCreate == 1)) {
        paramList.add(HCTopicSeatsView.MenuItem.a(2, paramHCSeatInfo));
      }
      if (paramHCSeatInfo.seatFlag == 1)
      {
        paramHCSeatInfo = HCTopicSeatsView.MenuItem.a(4, paramHCSeatInfo);
        a("0X800657C");
      }
      for (;;)
      {
        paramList.add(paramHCSeatInfo);
        return 0;
        paramHCSeatInfo = HCTopicSeatsView.MenuItem.a(3, paramHCSeatInfo);
        a("0X800657B");
      }
      if ((paramHCSeatInfo.guestUin != 0L) && (paramHCSeatInfo.guestUin == l1))
      {
        paramList.add(HCTopicSeatsView.MenuItem.a(0, paramHCSeatInfo));
        paramList.add(HCTopicSeatsView.MenuItem.a(1, paramHCSeatInfo));
        a("0X8006582");
        return 0;
      }
      if (paramHCSeatInfo.guestUin != 0L)
      {
        paramList.add(HCTopicSeatsView.MenuItem.a(0, paramHCSeatInfo));
        a("0X8006582");
        return 0;
      }
      if (paramHCSeatInfo.seatFlag == 0)
      {
        a("0X800657B");
        return 1;
      }
      if (paramHCSeatInfo.seatFlag == 1)
      {
        a(0, "该座位已被房主关闭。");
        a("0X800657C");
        return -1;
        if (paramHCSeatInfo.seatFlag == 1)
        {
          a(0, "该座位已被房主关闭。");
          a("0X800657C");
          return -1;
        }
        a("0X800657B");
        return 1;
      }
    }
    return 0;
  }
  
  public int a(Object paramObject)
  {
    long l1;
    try
    {
      if ((paramObject instanceof Long)) {
        l1 = ((Long)paramObject).longValue();
      } else if ((paramObject instanceof String)) {
        l1 = Long.parseLong((String)paramObject);
      }
    }
    catch (Throwable paramObject)
    {
      ((Throwable)paramObject).printStackTrace();
      l1 = 0L;
    }
    do
    {
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramObject = (HCSeatInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((paramObject == null) || (((HCSeatInfo)paramObject).guestUin != l1)) {}
      }
      for (;;)
      {
        return i1;
        i1 += 1;
        break;
        i1 = -1;
      }
      l1 = 0L;
    } while (l1 != 0L);
    return -1;
  }
  
  protected View a(List paramList, int paramInt1, int paramInt2)
  {
    Object localObject1 = new LinearLayout(getContext());
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundResource(2130840933);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    Object localObject2 = getContext().getResources();
    int i4 = paramList.size();
    int i1 = 0;
    if (i1 < i4)
    {
      HCTopicSeatsView.MenuItem localMenuItem = (HCTopicSeatsView.MenuItem)paramList.get(i1);
      label83:
      label95:
      View localView;
      if (i1 == 0)
      {
        i2 = 1;
        if (i1 != i4 - 1) {
          break label302;
        }
        i3 = 1;
        localView = localLayoutInflater.inflate(2130904238, null, false);
        if ((i2 == 0) || (i3 == 0)) {
          break label308;
        }
        localView.setBackgroundResource(2130840939);
      }
      for (;;)
      {
        Object localObject3 = (ImageView)localView.findViewById(2131301928);
        Object localObject4 = (TextView)localView.findViewById(2131301929);
        ((ImageView)localObject3).setImageResource(localMenuItem.a);
        ((TextView)localObject4).setText(localMenuItem.b);
        localView.setTag(localMenuItem);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (i2 == 0)
        {
          localObject3 = new LinearLayout.LayoutParams(-1, 1);
          localObject4 = new View(getContext());
          ((View)localObject4).setBackgroundColor(((Resources)localObject2).getColor(2131428208));
          ((LinearLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
        }
        ((LinearLayout)localObject1).addView(localView, new LinearLayout.LayoutParams(((Resources)localObject2).getDimensionPixelSize(2131493634), ((Resources)localObject2).getDimensionPixelSize(2131493633)));
        if (AppSetting.j) {
          localView.setContentDescription(getResources().getString(localMenuItem.b));
        }
        i1 += 1;
        break;
        i2 = 0;
        break label83;
        label302:
        i3 = 0;
        break label95;
        label308:
        if (i2 != 0) {
          localView.setBackgroundResource(2130838398);
        } else if (i3 != 0) {
          localView.setBackgroundResource(2130838396);
        } else {
          localView.setBackgroundResource(2130838397);
        }
      }
    }
    paramList = new LinearLayout(getContext());
    paramList.setOrientation(1);
    paramList.addView((View)localObject1, new LinearLayout.LayoutParams(((Resources)localObject2).getDimensionPixelSize(2131493634), -2));
    int i2 = ((Resources)localObject2).getDimensionPixelSize(2131493636);
    int i3 = ((Resources)localObject2).getDimensionPixelSize(2131493637);
    if (i2 != 0)
    {
      i1 = i3;
      if (i3 != 0) {}
    }
    else
    {
      i1 = 19;
      i2 = 37;
    }
    localObject1 = new LinearLayout.LayoutParams(i2, i1);
    localObject2 = new ImageView(getContext());
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    switch (paramInt1)
    {
    }
    while (paramInt1 < 4)
    {
      paramList.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      return paramList;
      ((LinearLayout.LayoutParams)localObject1).leftMargin = paramInt2;
      ((LinearLayout.LayoutParams)localObject1).gravity = 3;
      ((ImageView)localObject2).setImageResource(2130840959);
      continue;
      ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      ((ImageView)localObject2).setImageResource(2130840959);
      continue;
      ((LinearLayout.LayoutParams)localObject1).rightMargin = paramInt2;
      ((LinearLayout.LayoutParams)localObject1).gravity = 5;
      ((ImageView)localObject2).setImageResource(2130840959);
      continue;
      ((LinearLayout.LayoutParams)localObject1).leftMargin = paramInt2;
      ((LinearLayout.LayoutParams)localObject1).gravity = 3;
      ((ImageView)localObject2).setImageResource(2130840960);
      continue;
      ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      ((ImageView)localObject2).setImageResource(2130840960);
      continue;
      ((LinearLayout.LayoutParams)localObject1).rightMargin = paramInt2;
      ((LinearLayout.LayoutParams)localObject1).gravity = 5;
      ((ImageView)localObject2).setImageResource(2130840960);
    }
    paramList.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
    return paramList;
  }
  
  public PopupWindow a(View paramView, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramView == null)) {
      return null;
    }
    Resources localResources = getResources();
    paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    int i2 = this.jdField_a_of_type_ArrayOfInt[0];
    int i1 = this.jdField_a_of_type_ArrayOfInt[1];
    int i3 = localResources.getDimensionPixelSize(2131492908);
    int i4 = localResources.getDimensionPixelSize(2131493638);
    int i8 = paramView.getWidth();
    int i9 = paramView.getHeight();
    int i5 = localResources.getDimensionPixelSize(2131493634);
    int i6 = localResources.getDimensionPixelSize(2131493633);
    int i10 = localResources.getDimensionPixelSize(2131493637);
    int i7 = localResources.getDimensionPixelSize(2131493636);
    i6 = i6 * paramList.size() + i10;
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("HCTopicSeatsView", new Object[] { "showPopupMenu", String.format("aX=%d, aY=%d, titleBarH=%d, popMargin=%d, aW=%d, aH=%d, width=%d, tH=%d, tW=%d, heigh=%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i5), Integer.valueOf(i10), Integer.valueOf(i7), Integer.valueOf(i6) }) });
    }
    if (i1 > i3 + i6 + i4)
    {
      i4 = -(i6 + i4 + i9);
      i1 = 1;
    }
    for (;;)
    {
      if (i8 > i5)
      {
        i3 = (i8 - i5) / 2;
        i2 = 0;
        if (i1 == 1)
        {
          i1 = 2;
          label302:
          if (QLog.isColorLevel()) {
            NearbyUtils.a("HCTopicSeatsView", new Object[] { "showPopupMenu", String.format("xoff=%d, yoff=%d, triangleMargin=%d, flag=%d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i1) }) });
          }
          paramList = new PopupWindow(a(paramList, i1, i2), i5, i6);
          paramList.setBackgroundDrawable(new ColorDrawable(0));
          paramList.setOutsideTouchable(true);
        }
      }
      try
      {
        paramList.showAsDropDown(paramView, i3, i4);
        return paramList;
      }
      catch (WindowManager.BadTokenException paramView)
      {
        paramView.printStackTrace();
        return null;
        i1 = 4;
        continue;
        i1 = 5;
        break label302;
        i9 = localResources.getDimensionPixelSize(2131493639);
        i3 = (i5 - i8) / 2;
        i10 = (i8 - i7) / 2;
        if (i2 - i9 < i3)
        {
          i3 = -(i2 - i9);
          i2 = i2 - i9 + i10;
          if (i1 == 1)
          {
            i1 = 1;
            break label302;
          }
          i1 = 4;
          break label302;
        }
        paramView.getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
        if (i2 + i5 + i9 - this.jdField_a_of_type_AndroidGraphicsRect.right > i3)
        {
          i3 = -(i2 + i5 + i9 - this.jdField_a_of_type_AndroidGraphicsRect.right);
          if (i1 == 1) {}
          for (i1 = 3;; i1 = 6)
          {
            i10 = this.jdField_a_of_type_AndroidGraphicsRect.right;
            i8 /= 2;
            i7 /= 2;
            i2 = i10 - i2 - i8 - i9 - i7;
            break;
          }
        }
        i3 = -i3;
        i2 = 0;
        if (i1 == 1)
        {
          i1 = 2;
          break label302;
        }
        i1 = 5;
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void a(int paramInt)
  {
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.d);
    if (QLog.isColorLevel()) {
      if (localHotChatInfo != null) {
        break label50;
      }
    }
    label50:
    for (Object localObject = "null";; localObject = localHotChatInfo.troopUin)
    {
      NearbyUtils.a("HCTopicSeatsView", new Object[] { "inviteGuest ", localObject });
      if (localHotChatInfo != null) {
        break;
      }
      return;
    }
    localObject = (Activity)getContext();
    Intent localIntent = new Intent((Context)localObject, HotChatMemberListActivity.class);
    localIntent.putExtra("troop_uin", localHotChatInfo.troopUin);
    localIntent.putExtra("troop_code", localHotChatInfo.troopCode);
    localIntent.putStringArrayListExtra("troop_admin", (ArrayList)localHotChatInfo.adminUins);
    localIntent.putExtra("troop_owner", localHotChatInfo.ownerUin);
    if ((localHotChatInfo.adminLevel == 1) || (localHotChatInfo.adminLevel == 2)) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("troop_manage", bool);
      localIntent.putExtra("HC_MEMBER_ACTION", 1);
      localIntent.putExtra("HC_MEMBER_SEATID", paramInt);
      ((Activity)localObject).startActivityForResult(localIntent, 13004);
      ((Activity)localObject).overridePendingTransition(2130968592, 2130968589);
      return;
    }
  }
  
  public void a(int paramInt, double paramDouble)
  {
    paramInt = AudioPanel.a(paramInt);
    this.g = (paramInt / 1250);
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("HCTopicSeatsView", "updateRecordingParams", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.g), Double.valueOf(paramDouble) });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    d();
    int i1 = getResources().getDimensionPixelSize(2131492908);
    QQToast.a(getContext(), paramInt, paramString, 0).b(i1);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    Activity localActivity = null;
    if ((getContext() instanceof Activity)) {
      localActivity = (Activity)getContext();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) && (localActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(localActivity);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (localActivity != null) && (!localActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true);
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatHandler = ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35));
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    b();
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HCTopicSeatsView", new Object[] { "init", this.d });
    }
  }
  
  void a(HCSeatInfo paramHCSeatInfo, View paramView)
  {
    if ((paramView == null) || (paramHCSeatInfo == null))
    {
      if ((paramView != null) && (paramView.getVisibility() != 8)) {
        paramView.setVisibility(8);
      }
      return;
    }
    if (paramView.getVisibility() != 0) {
      paramView.setVisibility(0);
    }
    Context localContext = getContext();
    CustomImgView localCustomImgView = (CustomImgView)paramView.findViewById(2131302074);
    Object localObject = (TextView)paramView.findViewById(2131297124);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131302082);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131302083);
    localCustomImgView.setBackgroundDrawable(localContext.getResources().getDrawable(2130840650));
    if (paramHCSeatInfo.guestUin != 0L)
    {
      boolean bool1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(String.valueOf(paramHCSeatInfo.guestUin));
      paramView = String.valueOf(paramHCSeatInfo.guestUin);
      long l2;
      if ((bool1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramView)))
      {
        paramView = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView);
        if (paramView != null) {
          localCustomImgView.setImageDrawable(paramView);
        }
        if (localObject != null) {
          l2 = 0L;
        }
      }
      else
      {
        try
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.d);
          l1 = l2;
          if (paramView != null) {
            l1 = Long.parseLong(paramView.ownerUin);
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            label305:
            label357:
            label384:
            boolean bool2;
            label448:
            label458:
            paramView.printStackTrace();
            long l1 = l2;
            continue;
            ((TextView)localObject).setVisibility(8);
          }
        }
        if (paramHCSeatInfo.guestUin == l1)
        {
          ((TextView)localObject).setVisibility(0);
          if (AppSetting.j)
          {
            paramView = null;
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(false);
            if (localObject != null) {
              paramView = ((PttShowRoomMng)localObject).a(String.valueOf(paramHCSeatInfo.guestUin));
            }
            localObject = paramView;
            if (TextUtils.isEmpty(paramView)) {
              localObject = "用户";
            }
            localCustomImgView.setContentDescription(String.format("%s，房主", new Object[] { localObject }));
          }
          if (paramHCSeatInfo.guestUin != this.jdField_a_of_type_Long) {
            break label610;
          }
          localImageView1.setVisibility(0);
          i1 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(true).a(String.valueOf(paramHCSeatInfo.guestUin));
          if (i1 != 1) {
            break label599;
          }
          localImageView1.setBackgroundResource(2130840908);
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("PttShow", "updateSeatView_gender", new Object[] { Integer.valueOf(i1) });
          }
          bool2 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(String.valueOf(paramHCSeatInfo.guestUin), this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener);
          if (QLog.isColorLevel()) {
            QLog.i("HCTopicSeatsView", 2, "updateSeatView, uin V:" + bool2);
          }
          if (localImageView2.getVisibility() != 0) {
            break label619;
          }
          bool1 = true;
          if (bool2 == bool1) {
            break label625;
          }
          i1 = 1;
          if (i1 != 0) {
            if (!bool2) {
              break label631;
            }
          }
        }
      }
      label599:
      label610:
      label619:
      label625:
      label631:
      for (int i1 = 0;; i1 = 8)
      {
        localImageView2.setVisibility(i1);
        localCustomImgView.setTag(paramHCSeatInfo);
        localCustomImgView.setOnClickListener(this.b);
        return;
        paramView = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramView, true);
        break;
        if (!AppSetting.j) {
          break label305;
        }
        paramView = null;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(false);
        if (localObject != null) {
          paramView = ((PttShowRoomMng)localObject).a(String.valueOf(paramHCSeatInfo.guestUin));
        }
        localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = "用户";
        }
        localCustomImgView.setContentDescription(String.format("%s，嘉宾", new Object[] { localObject }));
        break label305;
        localImageView1.setBackgroundResource(2130840909);
        break label357;
        localImageView1.setVisibility(4);
        break label384;
        bool1 = false;
        break label448;
        i1 = 0;
        break label458;
      }
    }
    if ((paramHCSeatInfo.seatFlag == 1) || (a(paramHCSeatInfo.seatID)))
    {
      localCustomImgView.setImageDrawable(localContext.getResources().getDrawable(2130840920));
      if (AppSetting.j) {
        localCustomImgView.setContentDescription("嘉宾席，关闭状态");
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localImageView1.setVisibility(4);
      localImageView2.setVisibility(8);
      break;
      localCustomImgView.setImageDrawable(localContext.getResources().getDrawable(2130840921));
      if (AppSetting.j) {
        localCustomImgView.setContentDescription("嘉宾席，打开状态");
      }
    }
  }
  
  public void a(String paramString)
  {
    ThreadManager.a(new ssx(this, paramString), 5, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HCTopicSeatsView", new Object[] { "inviteGuestResult", Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString });
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(1, paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (!paramString1.equalsIgnoreCase(this.d))) {
      return;
    }
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      paramInt2 = 1;
    }
    while (paramBoolean2)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HCTopicSeatsView", new Object[] { "onUpdatePttHotChatSeatsInfo pushMsg", Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
      switch (paramInt1)
      {
      default: 
        return;
      case 1: 
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return;
        paramInt2 = 0;
        break;
      case 2: 
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return;
      case 3: 
        paramString1 = Message.obtain();
        paramString1.what = 0;
        if (paramInt2 != 0)
        {
          paramString1.obj = "你已被房主邀请成为嘉宾。";
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(false);
          if (paramString2 != null) {
            paramString2.a(this.d, paramInt1);
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
        return;
      case 4: 
        paramString1 = Message.obtain();
        paramString1.what = 0;
        if ((this.e != 1) && (paramInt2 != 0) && (this.e == 2))
        {
          paramString1.obj = "你已被房主取消嘉宾身份。";
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(false);
          if (paramString2 != null) {
            paramString2.a(this.d, paramInt1);
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
        return;
      case 5: 
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return;
      }
    }
    d();
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HCTopicSeatsView", new Object[] { "onUpdatePttHotChatSeatsInfo", Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString3 });
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    if (paramString3 != null)
    {
      paramString1 = paramString3;
      if (paramString3.length() != 0) {}
    }
    else
    {
      paramString1 = "操作失败，请重试。";
    }
    paramString2 = Message.obtain();
    paramString2.what = 1;
    paramString2.arg2 = paramInt1;
    paramString2.obj = paramString1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString2);
  }
  
  public boolean a()
  {
    return b();
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = true;
    if (this.e == 1) {
      return false;
    }
    PttShowRoomMng localPttShowRoomMng = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(false);
    long l1;
    if (localPttShowRoomMng == null)
    {
      l1 = 0L;
      if (l1 <= 0L) {
        break label79;
      }
      bool1 = bool2;
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(4)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, l1);
      }
    }
    label79:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      l1 = localPttShowRoomMng.a(this.d, paramInt);
      break;
    }
  }
  
  public void b()
  {
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.d);
    Object localObject2;
    if (localHotChatInfo != null)
    {
      Object localObject1 = null;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        localObject1 = (HCSeatInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new HCSeatInfo();
      }
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(localHotChatInfo.ownerUin);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1;
          localException.printStackTrace();
        }
        i2 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i2 < 1) {
          break label412;
        }
      }
      if (l1 != ((HCSeatInfo)localObject2).guestUin) {
        ((HCSeatInfo)localObject2).guestUin = l1;
      }
      localObject1 = localHotChatInfo.getHCSeatInfoList();
      this.e = localHotChatInfo.getUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        localObject1 = ((List)localObject1).iterator();
        for (i1 = 0;; i1 = ((HCSeatInfo)localObject2).seatID) {
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (HCSeatInfo)((Iterator)localObject1).next();
              if ((localObject2 != null) && (((HCSeatInfo)localObject2).seatID > 0)) {
                if (((HCSeatInfo)localObject2).seatID >= i1) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
                }
              }
            }
          }
        }
      }
    }
    label412:
    for (;;)
    {
      break;
      for (;;)
      {
        int i2;
        if ((this.jdField_a_of_type_JavaUtilArrayList.get(i2) != null) && (((HCSeatInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2)).seatID <= ((HCSeatInfo)localObject2).seatID))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(i2, localObject2);
          break;
        }
        i2 -= 1;
      }
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "updateSeats hotchat get seat is empty", new Object[] { this.d });
      }
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          localStringBuilder.append(((HCSeatInfo)((Iterator)localObject2).next()).toString());
        }
        NearbyUtils.a("PttShow", "updateSeats", new Object[] { localStringBuilder.toString() });
      }
      c();
      do
      {
        return;
      } while (!QLog.isDevelopLevel());
      NearbyUtils.a("PttShow", "updateSeats hotchat is null", new Object[] { this.d });
      return;
    }
  }
  
  protected void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length))
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        a((HCSeatInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt]);
      }
    }
    else {
      return;
    }
    a(null, this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt]);
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    int i2 = 0;
    int i1 = i2;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())
      {
        localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView();
        if ((localObject == null) || (!(((View)localObject).getTag() instanceof HCSeatInfo))) {
          break label282;
        }
        localObject = (HCSeatInfo)((View)localObject).getTag();
        if (QLog.isColorLevel()) {
          NearbyUtils.a("HCTopicSeatsView", new Object[] { "updateSeatsView_pop_seat", localObject });
        }
      }
    }
    for (;;)
    {
      i1 = i2;
      if (localObject != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        HCSeatInfo localHCSeatInfo;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localHCSeatInfo = (HCSeatInfo)localIterator.next();
        } while ((localHCSeatInfo == null) || (localHCSeatInfo.seatID != ((HCSeatInfo)localObject).seatID) || (localHCSeatInfo.guestUin != ((HCSeatInfo)localObject).guestUin) || (localHCSeatInfo.seatFlag != ((HCSeatInfo)localObject).seatFlag));
      }
      for (boolean bool = true;; bool = false)
      {
        if (!bool) {
          b();
        }
        i1 = i2;
        if (QLog.isColorLevel())
        {
          NearbyUtils.a("HCTopicSeatsView", new Object[] { "updateSeatsView", Boolean.valueOf(bool) });
          i1 = i2;
        }
        if (i1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
        {
          if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
            a((HCSeatInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1), this.jdField_a_of_type_ArrayOfAndroidViewView[i1]);
          }
          for (;;)
          {
            i1 += 1;
            break;
            a(null, this.jdField_a_of_type_ArrayOfAndroidViewView[i1]);
          }
        }
        return;
      }
      label282:
      localObject = null;
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  void e()
  {
    setOrientation(0);
    setGravity(17);
    Object localObject1 = getResources();
    Object localObject2 = ((Resources)localObject1).getDisplayMetrics();
    int i1 = ((Resources)localObject1).getDimensionPixelSize(2131493625);
    int i4 = (Math.min(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels) - i1) / 6;
    int i5 = ((Resources)localObject1).getDimensionPixelSize(2131493624);
    int i3 = ((Resources)localObject1).getDimensionPixelSize(2131493641);
    int i6 = ((Resources)localObject1).getDimensionPixelSize(2131493640);
    i1 = ((Resources)localObject1).getDimensionPixelSize(2131493642);
    int i2 = ((Resources)localObject1).getDimensionPixelSize(2131493643);
    if (i4 >= i6 * 2 + i1 + i3 * 2)
    {
      i3 = (i4 - i1 - i6 * 2) / 2;
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "initView", new Object[] { Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i1) });
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[6];
      LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
      i6 = i1 + i6 * 2;
      Object localObject3 = new TextView(getContext());
      Object localObject4 = new LinearLayout.LayoutParams(((Resources)localObject1).getDimensionPixelSize(2131493626), ((Resources)localObject1).getDimensionPixelSize(2131493628));
      ((LinearLayout.LayoutParams)localObject4).rightMargin = ((Resources)localObject1).getDimensionPixelSize(2131493627);
      ((TextView)localObject3).setBackgroundResource(2130840822);
      ((TextView)localObject3).getBackground().setAlpha(178);
      ((TextView)localObject3).setText("嘉宾");
      ((TextView)localObject3).setPadding(0, 0, (int)(((DisplayMetrics)localObject2).density + 0.5D), 0);
      ((TextView)localObject3).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject3).setTextSize(2, 14.0F);
      ((TextView)localObject3).setGravity(17);
      addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      i3 = 0;
      label342:
      if (i3 >= 6) {
        break label538;
      }
      localObject1 = (RelativeLayout)localLayoutInflater.inflate(2130904257, null);
      localObject3 = (CustomImgView)((RelativeLayout)localObject1).findViewById(2131302074);
      localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131297124);
      localObject4 = ((ImageView)((RelativeLayout)localObject1).findViewById(2131302082)).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject4).width = i6;
      ((ViewGroup.LayoutParams)localObject4).height = i6;
      localObject3 = ((CustomImgView)localObject3).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).width = i1;
      ((ViewGroup.LayoutParams)localObject3).height = i1;
      if (i3 != 0) {
        break label529;
      }
      localObject2 = ((TextView)localObject2).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i1;
      ((ViewGroup.LayoutParams)localObject2).height = i2;
    }
    for (;;)
    {
      addView((View)localObject1, new LinearLayout.LayoutParams(i4, i5));
      this.jdField_a_of_type_ArrayOfAndroidViewView[i3] = localObject1;
      i3 += 1;
      break label342;
      float f1 = i1;
      i1 = i4 - i6 * 2 - i3 * 2;
      f1 = i1 / f1;
      i2 = (int)(i2 * f1);
      break;
      label529:
      ((RelativeLayout)localObject1).removeView((View)localObject2);
    }
    label538:
    c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          b(paramMessage.arg1);
          b(paramMessage.arg2);
          return true;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
          b();
        } while (!(paramMessage.obj instanceof String));
        a(0, (String)paramMessage.obj);
        return true;
      } while (!(paramMessage.obj instanceof String));
      a(0, (String)paramMessage.obj);
      return true;
      c();
      return true;
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "MSG_CANCEL_SEAT_UPDATE", new Object[0]);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      c();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(false);
    } while ((paramMessage == null) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    long l1 = 0L;
    label210:
    long l2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        HCSeatInfo localHCSeatInfo = (HCSeatInfo)localIterator.next();
        if (localHCSeatInfo != null)
        {
          l2 = paramMessage.a(this.d, localHCSeatInfo.seatID);
          if (l1 == 0L) {
            l1 = l2;
          }
        }
      }
    }
    for (;;)
    {
      break label210;
      if ((l2 > 0L) && (l2 < l1))
      {
        l1 = l2;
        continue;
        if (l1 <= 0L) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, l1);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        NearbyUtils.a("PttShow", "MSG_CANCEL_SEAT_UPDATE", new Object[] { Long.valueOf(l1) });
        return true;
      }
    }
  }
  
  public void setCurSpeakingGuest(String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      int i1;
      int i2;
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        i1 = a(Long.valueOf(this.jdField_a_of_type_Long));
        i2 = a(Long.valueOf(l1));
        this.jdField_a_of_type_Long = l1;
        if ((i1 >= 0) || (i2 >= 0)) {
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 5, i1, i2).sendToTarget();
        }
      } while (!QLog.isDevelopLevel());
      NearbyUtils.a("HCTopicSeatsView", String.format("setCurSpeakingGuest preIndex:%d newIndex:%d uin:%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), paramString }), new Object[0]);
    }
    if (this.jdField_a_of_type_Long == l1) {
      return;
    }
  }
  
  public void setFlag(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    }
    int i1;
    label155:
    label157:
    do
    {
      do
      {
        for (;;)
        {
          return;
          i1 = this.f;
          if (paramBoolean) {
            i1 |= paramInt;
          }
          for (;;)
          {
            if (i1 == this.f) {
              break label155;
            }
            if (QLog.isDevelopLevel()) {
              NearbyUtils.a("HCTopicSeatsView", "setFlag", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.f), Integer.valueOf(i1) });
            }
            this.f = i1;
            if (paramInt != 1) {
              break label157;
            }
            i1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
            if (i1 < 0) {
              break;
            }
            Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 7, i1, -1, Integer.valueOf(paramInt)).sendToTarget();
            return;
            i1 &= (paramInt ^ 0xFFFFFFFF);
          }
        }
        if (paramInt == 4)
        {
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 5, 0, -1).sendToTarget();
          return;
        }
      } while (paramInt != 2);
      i1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    } while (i1 < 0);
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 5, i1, -1, Integer.valueOf(paramInt)).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\HCTopicSeatsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */