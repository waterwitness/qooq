package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.IDragViewProvider;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.IRecentImgv;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XListView;
import cooperation.huangye.HYEntranceManager;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import owt;
import owu;
import owv;

public class RecentAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener, DragFrameLayout.IDragViewProvider, DragFrameLayout.OnDragModeChangedListener, FaceDecoder.DecodeTaskCompletionListener, SwipListView.SwipListListener
{
  protected static final int a = 1;
  public static final int b = 99;
  private long jdField_a_of_type_Long;
  protected Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new owv(this);
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener;
  protected RecentBaseData a;
  protected RecentFaceDecoder a;
  protected RecentItemBuilderFactory a;
  protected DragFrameLayout a;
  public QQAppInterface a;
  protected BubblePopupWindow a;
  protected XListView a;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  protected final List a;
  protected List b;
  public int c = -1;
  private int d;
  private int e;
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt)
  {
    this(paramContext, paramQQAppInterface, paramXListView, paramOnRecentUserOpsListener, paramInt, false);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory = new RecentItemBuilderFactory(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, paramBoolean);
    if (paramInt == 0) {
      this.d = 0;
    }
    for (;;)
    {
      this.e = paramInt;
      return;
      if (paramInt == 1) {
        this.d = 5;
      } else if (paramInt == 4) {
        this.d = 7;
      } else if (paramInt == 9) {
        this.d = 11;
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (4 == this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a())
    {
      if (paramInt == 1) {
        break label118;
      }
      if ((HYEntranceManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.jdField_a_of_type_JavaUtilList.contains(RecentItemBuilderFactory.d))) {
        this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.d);
      }
      if (!this.jdField_a_of_type_JavaUtilList.contains(RecentItemBuilderFactory.b)) {
        this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.b);
      }
      if (!this.jdField_a_of_type_JavaUtilList.contains(RecentItemBuilderFactory.e)) {
        this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.e);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      label118:
      if (!this.jdField_a_of_type_JavaUtilList.contains(RecentItemBuilderFactory.f)) {
        this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.f);
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList.get(0);
      if ((localObject != null) && (localObject.equals(RecentItemBuilderFactory.a))) {
        this.jdField_a_of_type_JavaUtilList.remove(localObject);
      }
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public List a()
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      return this.b;
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      PstnManager localPstnManager = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
      if (localPstnManager != null)
      {
        b(localPstnManager.a());
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("RecentAdapter", 2, "refreshHeaderView|PstnManager is null..");
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("RecentAdapter", 2, "refreshHeaderView|NUllPointerException." + localNullPointerException.getMessage());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentAdapter", 2, "refreshHeaderView|Exception." + localException.getMessage());
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setExtraFlag:" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      break label14;
    }
    label14:
    while ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + paramString, paramBitmap);
    }
    long l = System.currentTimeMillis();
    boolean bool1;
    label93:
    Object localObject1;
    if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L))
    {
      bool1 = true;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("RecentAdapter.onDecodeTaskCompleted type=").append(paramInt2).append(", uin=").append(paramString).append(", remainingTasks=").append(paramInt1).append(", isdecodeFaceTimeout=").append(bool1).append(", avatar == null ? | ");
        if (paramBitmap != null) {
          break label233;
        }
      }
    }
    label233:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("RecentAdapter", 2, bool2 + ",style | " + this.e);
      if ((paramInt1 > 0) && (!bool1)) {
        break;
      }
      synchronized (this.jdField_a_of_type_JavaUtilHashtable)
      {
        if (this.jdField_a_of_type_JavaUtilHashtable.size() != 0) {
          break label239;
        }
        return;
      }
      bool1 = false;
      break label93;
    }
    label239:
    if (paramInt1 == 0) {}
    View localView;
    RecentBaseData localRecentBaseData;
    for (this.jdField_a_of_type_Long = 0L;; this.jdField_a_of_type_Long = l)
    {
      bool1 = false;
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 >= k) {
        break label804;
      }
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {
        break;
      }
      break label864;
    }
    int j = localRecentBaseData.a();
    int i = j;
    if (a() == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecentAdapter", 2, "====RecentAdapter onDecodeTaskCompleted === type: " + paramInt2 + ",uin: " + paramString + ",recentUserType: " + j);
      }
    }
    else
    {
      label378:
      i = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, localRecentBaseData.a()).first).intValue();
      if (i != Integer.MIN_VALUE)
      {
        if ((localRecentBaseData instanceof RecentSayHelloBoxItem))
        {
          paramBitmap = ((RecentSayHelloBoxItem)localRecentBaseData).jdField_a_of_type_JavaUtilList;
          if ((paramBitmap == null) || (paramBitmap.size() <= 0)) {
            break label899;
          }
          paramBitmap = new LinkedList(paramBitmap).iterator();
          while (paramBitmap.hasNext())
          {
            localObject1 = (MessageRecord)paramBitmap.next();
            Object localObject2 = i + ":" + ((MessageRecord)localObject1).senderuin;
            localObject2 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject2);
            if (localObject2 != null) {
              a(localView, localRecentBaseData, (MessageRecord)localObject1, new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject2));
            }
          }
        }
        paramBitmap = i + ":" + localRecentBaseData.a();
        paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramBitmap);
        if (paramBitmap != null)
        {
          if (i == 103)
          {
            l = System.currentTimeMillis();
            localObject1 = BaseApplication.getContext().getResources().getDrawable(2130838594);
            if ((localObject1 instanceof SkinnableBitmapDrawable)) {
              ((SkinnableBitmapDrawable)localObject1).setGravity(81);
            }
            if ((localObject1 instanceof BitmapDrawable)) {
              ((BitmapDrawable)localObject1).setGravity(81);
            }
            ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
            localObject1 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), paramBitmap), localObject1 });
            paramBitmap = (Bitmap)localObject1;
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - l));
            }
          }
          for (paramBitmap = (Bitmap)localObject1;; paramBitmap = new BitmapDrawable(BaseApplication.getContext().getResources(), paramBitmap))
          {
            a(localView, localRecentBaseData, paramBitmap);
            bool1 = true;
            break;
          }
          label804:
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool1);
          }
          this.jdField_a_of_type_JavaUtilHashtable.clear();
          return;
        }
      }
    }
    label864:
    label899:
    for (;;)
    {
      paramInt1 += 1;
      break;
      if (paramInt2 == 1001)
      {
        i = 3002;
        break label378;
      }
      i = j;
      if (paramInt2 != 101) {
        break label378;
      }
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
      this.c = i;
      return;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    a(paramView, paramRecentBaseData, null);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramRecentBaseData.a();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).b())) {
        break label85;
      }
      i = 3002;
    }
    label85:
    for (;;)
    {
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(i, paramRecentBaseData.a());
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramRecentBaseData);
      if (paramDrawable == null) {
        break;
      }
      paramDrawable.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
      return;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null)) {}
    Drawable localDrawable;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "updateSayHelloBoxItem|uin:" + paramMessageRecord.senderuin);
      }
      localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramMessageRecord.istroop, paramMessageRecord.senderuin);
      }
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramRecentBaseData);
    } while ((paramDrawable == null) || (!(paramDrawable instanceof SayHelloBoxItemBuilder)));
    ((SayHelloBoxItemBuilder)paramDrawable).a(paramView, paramRecentBaseData, paramMessageRecord, localDrawable);
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramRecentBaseData == null)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label24:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {
        break label60;
      }
    }
    label60:
    while (!localRecentBaseData.equals(paramRecentBaseData))
    {
      i += 1;
      break label24;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramRecentBaseData, paramString);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramRecentBaseData);
      e();
      notifyDataSetChanged();
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i;
    if (Utils.a(paramString1, localResources.getString(RecentItemBaseBuilder.a[0])))
    {
      i = paramRecentBaseData.a();
      if (i == 7220) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CE", "0X80067CE", 0, 0, "", "", "", ReadInJoyUtils.c());
      }
    }
    do
    {
      try
      {
        paramString1 = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
        paramString1.c();
        paramString1.b();
        a(paramRecentBaseData, paramString2);
        switch (i)
        {
        default: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString2, "", "");
        case 7220: 
          if ((i == 7120) || (i == 7210) || (i == 1008)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.a(), "", "", "");
          }
          return;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.d("Q.recent", 1, "clean kandian error" + paramString1);
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString2, "");
          if ((paramRecentBaseData instanceof RecentItemEcShop)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsghelper", "Clk_DelshopItem", 0, 0, paramRecentBaseData.a(), "", paramRecentBaseData.b, "");
          }
          paramString1 = paramRecentBaseData.a();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString1, "0X80064C9", "0X80064C9", 0, 0, "" + paramRecentBaseData.H, "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString2, "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006353", "0X8006353", 0, 0, "", "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.H, "", "", "");
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.H, "", "", "");
        }
      }
      if (Utils.a(paramString1, localResources.getString(RecentItemBaseBuilder.a[3])))
      {
        switch (paramRecentBaseData.a())
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramString1, paramRecentBaseData, paramString2);
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CD", "0X80067CD", 0, 0, "", "", "", "");
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramString1, paramRecentBaseData, paramString2);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      b(null);
      this.b = null;
    }
  }
  
  public void a(RecentUser paramRecentUser, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRecentUser.uin, 1008);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((MessageRecord)localObject2).getExtInfoFromExtStr("gdt_msgClick");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "0";
        localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("pa_msgId");
        paramStringBuilder1.append((String)localObject2 + ",");
      }
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      paramStringBuilder1 = str;
      if (((JSONObject)localObject1).has("ad_id")) {
        paramStringBuilder1 = ((JSONObject)localObject1).getString("ad_id");
      }
    }
    catch (Exception paramStringBuilder1)
    {
      for (;;)
      {
        paramStringBuilder1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.recent", 2, " parse ad_id error");
          paramStringBuilder1 = str;
        }
      }
    }
    paramStringBuilder2.append(paramStringBuilder1 + ",");
    paramStringBuilder3.append(paramRecentUser.uin + ",");
  }
  
  protected void a(String paramString)
  {
    ReportController.b(null, "dc00899", "Grp_video", "", "notice", "call", 0, 0, paramString, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString), "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label27:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (localRecentBaseData.a() == paramInt)) {
        break label74;
      }
    }
    label74:
    while (!Utils.a(localRecentBaseData.a(), paramString))
    {
      i += 1;
      break label27;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 1;
    label27:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (Utils.a(paramString, localRecentBaseData.a()))) {
        break label77;
      }
    }
    label77:
    int k;
    do
    {
      i += 1;
      break label27;
      break;
      k = localRecentBaseData.a();
      if ((paramBoolean) && (k == 1))
      {
        a(localView, localRecentBaseData);
        return;
      }
    } while ((paramBoolean) || ((k != 0) && (k != 1000) && (k != 1020) && (k != 1003) && (k != 1025) && (k != 1005) && (k != 1004) && (k != 1008) && (k != 1001) && (k != 1009) && (k != 1023) && (k != 1024) && (k != 7000) && (k != 7100) && (k != 1010)));
    a(localView, localRecentBaseData);
  }
  
  public void a(List paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "setRecommendFriendList list: " + paramList);
    }
    if (this.b == null) {
      this.b = new ArrayList(4);
    }
    this.b.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      this.b.add(localObject);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.b()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.b();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label77:
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localRecentBaseData = a(this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i));
      if (localRecentBaseData != null) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label77;
      break;
      label107:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(localRecentBaseData.a(), localRecentBaseData.a(), false);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    int i;
    Object localObject1;
    Object localObject2;
    MessageHandler localMessageHandler;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    if (paramBoolean)
    {
      if (this.e == 0) {
        i = 1;
      }
      for (;;)
      {
        if (paramInt == 2)
        {
          if (i != 0)
          {
            paramDragFrameLayout = this.jdField_a_of_type_JavaUtilList.iterator();
            for (;;)
            {
              if (paramDragFrameLayout.hasNext())
              {
                localObject1 = paramDragFrameLayout.next();
                if (((localObject1 instanceof RecentBaseData)) && ((localObject1 instanceof RecentUserBaseData)))
                {
                  localObject1 = (RecentUserBaseData)localObject1;
                  if (((RecentUserBaseData)localObject1).H > 0)
                  {
                    localObject2 = ((RecentUserBaseData)localObject1).a();
                    RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject1, (RecentUser)localObject2, true);
                    continue;
                    i = 0;
                    break;
                  }
                }
              }
            }
          }
          paramDragFrameLayout = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
          if ((paramDragFrameLayout != null) && (paramDragFrameLayout.b))
          {
            paramDragFrameLayout.b = false;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            paramDragFrameLayout = (DragFrameLayout)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramDragFrameLayout = "noLogin";
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("ecshop_sp" + paramDragFrameLayout, 0).edit().putBoolean("folder_reddot", false).commit();
          }
          localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
          if (localMessageHandler != null) {
            localMessageHandler.e(false);
          }
          paramDragFrameLayout = null;
          localObject1 = null;
          localObject2 = null;
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext())
          {
            localObject5 = localIterator.next();
            if ((!(localObject5 instanceof RecentBaseData)) || (!(localObject5 instanceof RecentUserBaseData))) {
              break label1940;
            }
            localObject3 = (RecentUserBaseData)localObject5;
            if (((RecentUserBaseData)localObject3).H <= 0) {
              break label1940;
            }
            localObject4 = ((RecentUserBaseData)localObject3).a();
            ((RecentUserBaseData)localObject3).c();
            if (((RecentUser)localObject4).type != 1008) {
              break label1927;
            }
            if (paramDragFrameLayout != null) {
              break label1914;
            }
            localObject1 = new StringBuilder();
            paramDragFrameLayout = new StringBuilder();
            localObject2 = new StringBuilder();
            label360:
            a((RecentUser)localObject4, (StringBuilder)localObject1, paramDragFrameLayout, (StringBuilder)localObject2);
            label371:
            if ((localObject5 instanceof RecentItemTroopMsgData))
            {
              paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentUser)localObject4).uin);
              if ((paramInt == 2) || (paramInt == 4))
              {
                RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject4, true, false);
                localObject5 = localObject2;
                localObject4 = localObject1;
                localObject3 = paramDragFrameLayout;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject3;
      paramDragFrameLayout = (DragFrameLayout)localObject4;
      localObject2 = localObject5;
      break;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localMessageHandler == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
        localObject3 = paramDragFrameLayout;
        localObject4 = localObject1;
        localObject5 = localObject2;
        break;
      }
      if ((localObject5 instanceof RecentItemTroopBarAssitant))
      {
        TroopBarAssistantManager.a().k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        SubscriptRecommendController.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
      }
      if ((localObject5 instanceof RecentItemServiceAccountFolderData))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByTabRed");
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
      }
      if ((localObject5 instanceof SendBlessRecentItemData))
      {
        ((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137)).b(true);
        localObject3 = paramDragFrameLayout;
        localObject4 = localObject1;
        localObject5 = localObject2;
      }
      else
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          RecentUtil.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
        if (this.e == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
          if (!TextUtils.isEmpty(paramDragFrameLayout)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", String.valueOf(localObject2), "0X8005C37", "0X8005C37", 0, 1, 0, String.valueOf(paramDragFrameLayout), String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", String.valueOf(localObject1));
          }
        }
        label1233:
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      int j;
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                            paramDragFrameLayout = paramDragFrameLayout.a();
                          } while (paramDragFrameLayout == null);
                          paramDragFrameLayout = (Integer)paramDragFrameLayout.getTag();
                        } while (paramDragFrameLayout == null);
                        j = paramDragFrameLayout.intValue();
                        paramDragFrameLayout = getItem(j);
                        if (QLog.isColorLevel()) {
                          QLog.d("Drag", 2, "onChange:" + paramDragFrameLayout);
                        }
                      } while (!(paramDragFrameLayout instanceof RecentBaseData));
                      localObject1 = (RecentBaseData)paramDragFrameLayout;
                      if ((i != 0) && ((paramDragFrameLayout instanceof RecentUserBaseData)))
                      {
                        localObject2 = ((RecentUserBaseData)paramDragFrameLayout).a();
                        RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject1, (RecentUser)localObject2, false);
                      }
                      if ((paramDragFrameLayout instanceof RecentItemTroopBarAssitant))
                      {
                        paramDragFrameLayout = (RecentItemTroopBarAssitant)paramDragFrameLayout;
                        paramDragFrameLayout.c();
                        TroopBarAssistantManager.a().k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                        return;
                      }
                      if ((paramDragFrameLayout instanceof RecentItemServiceAccountFolderData))
                      {
                        paramDragFrameLayout = (RecentItemServiceAccountFolderData)paramDragFrameLayout;
                        i = paramDragFrameLayout.H;
                        if (!PublicAccountConfigUtil.b)
                        {
                          paramDragFrameLayout.c();
                          ServiceAccountFolderManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0);
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByFolderRed, red dot switch:" + PublicAccountConfigUtil.b);
                        }
                        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                        if (PublicAccountConfigUtil.b)
                        {
                          paramInt = 1;
                          if (!paramDragFrameLayout.a()) {
                            break label1233;
                          }
                        }
                        for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
                        {
                          ReportController.b((QQAppInterface)localObject1, "dc00899", "Pb_account_lifeservice", "", "0X800687A", "0X800687A", paramInt, 0, paramDragFrameLayout, i + "", j + 1 + "", ServiceAccountFolderManager.a().b() + "");
                          return;
                          paramInt = 0;
                          break;
                        }
                      }
                      if (!(paramDragFrameLayout instanceof RecentItemEcShopAssitant)) {
                        break;
                      }
                      paramDragFrameLayout = (RecentItemEcShopAssitant)paramDragFrameLayout;
                      paramDragFrameLayout.c();
                      RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                      paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
                    } while (paramDragFrameLayout == null);
                    localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
                  } while (localObject1 == null);
                  ((EcShopAssistantManager)localObject1).a(paramDragFrameLayout.time);
                  return;
                  if (!(paramDragFrameLayout instanceof RecentUserBaseData)) {
                    break;
                  }
                  localObject1 = (RecentUserBaseData)paramDragFrameLayout;
                  localObject2 = ((RecentUserBaseData)localObject1).a();
                  if (((RecentUser)localObject2).type == 1008) {
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + ((RecentUser)localObject2).uin, "0X80064CA", "0X80064CA", 0, 0, "" + ((RecentUserBaseData)localObject1).H, "", "", "");
                  }
                  ((RecentUserBaseData)localObject1).c();
                  RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2, true, false);
                  if (this.e == 0) {
                    RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2);
                  }
                } while (!(paramDragFrameLayout instanceof SendBlessRecentItemData));
                ((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137)).b(true);
                return;
                if (!(paramDragFrameLayout instanceof RecentTroopAssistantItem)) {
                  break;
                }
                paramDragFrameLayout = (RecentTroopAssistantItem)paramDragFrameLayout;
                paramDragFrameLayout.c();
                RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1);
              } while (paramDragFrameLayout == null);
              TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.time);
              return;
              if (!(paramDragFrameLayout instanceof RecentItemEcShop)) {
                break;
              }
              paramDragFrameLayout = (RecentItemEcShop)paramDragFrameLayout;
              ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.a(), "0X80064D3", "0X80064D3", 0, 0, "" + paramDragFrameLayout.H, "", "", "");
              paramDragFrameLayout.c();
              RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
              paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
            } while (paramDragFrameLayout == null);
            localObject1 = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(87);
          } while (localObject1 == null);
          ((EcShopAssistantManager)localObject1).a(paramDragFrameLayout.time);
          return;
          if ((paramDragFrameLayout instanceof RecentMsgBoxItem))
          {
            paramDragFrameLayout = (RecentMsgBoxItem)paramDragFrameLayout;
            paramDragFrameLayout.c();
            if (MsgProxyUtils.c(paramDragFrameLayout.a()))
            {
              ThreadManager.a(new owu(this, paramDragFrameLayout.a(), paramDragFrameLayout.a()), 8, null, false);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005298", "0X8005298", 0, 0, "", "", "", "");
              return;
            }
            RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
            return;
          }
        } while (!(paramDragFrameLayout instanceof RecentSayHelloListItem));
        paramDragFrameLayout = (RecentSayHelloListItem)paramDragFrameLayout;
        paramDragFrameLayout.c();
        RecentUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
        return;
        label1914:
        localObject3 = paramDragFrameLayout;
        paramDragFrameLayout = (DragFrameLayout)localObject1;
        localObject1 = localObject3;
        break label360;
        label1927:
        localObject3 = paramDragFrameLayout;
        paramDragFrameLayout = (DragFrameLayout)localObject1;
        localObject1 = localObject3;
        break label371;
        label1940:
        localObject3 = localObject1;
        localObject4 = paramDragFrameLayout;
        localObject5 = localObject2;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView);
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131298785);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.a() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void b(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramRecentBaseData.a() == 8) && (paramRecentBaseData.L == 25))
    {
      localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if ((localObject == null) || (paramRecentBaseData.g == null)) {
        break label104;
      }
    }
    label104:
    for (Object localObject = ((PhoneContactManager)localObject).c(paramRecentBaseData.g);; localObject = null)
    {
      if (localObject != null) {
        paramRecentBaseData.b = ((PhoneContact)localObject).name;
      }
      do
      {
        return;
        localObject = ((QCallCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(139)).a(paramRecentBaseData.a());
      } while (localObject == null);
      paramRecentBaseData.b = ((QCallCardInfo)localObject).nickname;
      return;
    }
  }
  
  public void b(List paramList)
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    d();
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView))
    {
      localObject3 = (SwipListView)this.jdField_a_of_type_ComTencentWidgetXListView;
      localObject1 = localObject2;
      if (this.c >= 0)
      {
        localObject1 = localObject2;
        if (this.c < this.jdField_a_of_type_JavaUtilList.size()) {
          localObject1 = this.jdField_a_of_type_JavaUtilList.get(this.c);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "setDataList findsel, [" + this.c + "," + localObject1 + "]");
      }
      this.c = -1;
      localObject2 = localObject1;
    }
    for (Object localObject1 = localObject3;; localObject1 = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a();
      localObject3 = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
      if (localObject3 != null) {}
      for (int i = ((PstnManager)localObject3).a();; i = 0)
      {
        label256:
        boolean bool;
        label368:
        label374:
        int j;
        if (4 == k)
        {
          if (i != 1)
          {
            if (HYEntranceManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.d);
            }
            this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.b);
            this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.e);
          }
        }
        else
        {
          if (paramList != null)
          {
            try
            {
              localObject3 = paramList.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject3).next();
                if (localRecentBaseData == null) {
                  break label577;
                }
                if ((localRecentBaseData instanceof RecentItemChatMsgData))
                {
                  RecentUser localRecentUser = ((RecentItemChatMsgData)localRecentBaseData).a;
                  if ((localRecentUser != null) && (localRecentUser.type == 1008) && (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin))) {}
                }
                else
                {
                  this.jdField_a_of_type_JavaUtilList.add(localRecentBaseData);
                }
              }
              if (localObject1 == null) {
                break label374;
              }
            }
            catch (Exception localException) {}
            if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
              break label595;
            }
            bool = false;
            ((SwipListView)localObject1).setDragEnable(bool);
            if ((localObject2 instanceof RecentBaseData))
            {
              localObject2 = (RecentBaseData)localObject2;
              j = Math.max(((SwipListView)localObject1).s(), 0);
              int m = Math.min(((SwipListView)localObject1).t() + 1, this.jdField_a_of_type_JavaUtilList.size());
              label416:
              if (j < m)
              {
                if (!((RecentBaseData)localObject2).equals(this.jdField_a_of_type_JavaUtilList.get(j))) {
                  break label601;
                }
                this.c = j;
                if (QLog.isDevelopLevel()) {
                  QLog.i("Q.recent", 4, "setDataList getsel, [" + j + "," + this.jdField_a_of_type_JavaUtilList.get(j) + "]");
                }
              }
            }
          }
          if ((paramList == null) || (paramList.size() <= 0)) {
            break label626;
          }
          switch (k)
          {
          }
        }
        label577:
        label595:
        label601:
        label626:
        while (4 != k) {
          for (;;)
          {
            if ((localObject1 != null) && (this.c == -1)) {
              ((SwipListView)localObject1).N();
            }
            notifyDataSetChanged();
            return;
            this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.f);
            break;
            if (!QLog.isColorLevel()) {
              break label256;
            }
            QLog.i("Q.recent", 2, "setDataList, [item is null]");
            break label256;
            bool = true;
            break label368;
            j += 1;
            break label416;
            this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.a);
          }
        }
        if (i == 0) {
          this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.c);
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004F84", "0X8004F84", 0, 0, "", "", "", "");
          break;
          this.jdField_a_of_type_JavaUtilList.add(RecentItemBuilderFactory.g);
        }
      }
      localObject2 = null;
    }
  }
  
  public boolean b()
  {
    return (c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.b();
    }
  }
  
  protected boolean c()
  {
    return (this.d == 3) || (this.d == 8);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.b(paramBoolean);
      return;
    }
  }
  
  public int getCount()
  {
    if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        return Integer.valueOf(this.d);
      }
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        Object localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    RecentItemBaseBuilder localRecentItemBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
    if ((localObject instanceof RecentBaseData))
    {
      localObject = (RecentBaseData)localObject;
      b((RecentBaseData)localObject);
      return localRecentItemBaseBuilder.a(paramInt, localObject, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
    }
    if ((localObject instanceof Integer)) {
      return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
    }
    if ((localObject instanceof String)) {
      return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
    }
    if ((localObject instanceof Long))
    {
      paramView = localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
      if (((Long)localObject == RecentItemBuilderFactory.c) || ((Long)localObject == RecentItemBuilderFactory.g)) {
        return ((RecentCallHoldItemBuilder)localRecentItemBaseBuilder).a(paramView, this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    else
    {
      return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.b();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
    }
    label380:
    label424:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
              {
                localObject = paramView.getTag(-1);
                paramView = paramView.getTag(-2);
                if ((!(localObject instanceof Integer)) || (!(paramView instanceof Integer)))
                {
                  if (!QLog.isDevelopLevel()) {
                    continue;
                  }
                  QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
                  return;
                }
                i = ((Integer)localObject).intValue();
                int j = ((Integer)paramView).intValue();
                try
                {
                  paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
                  localObject = getItem(i);
                  if (QLog.isDevelopLevel()) {
                    QLog.i("Q.recent", 4, "onClick|obj = " + localObject + ", " + paramView);
                  }
                  if ((paramView != null) && ((localObject instanceof RecentBaseData)))
                  {
                    a((RecentBaseData)localObject, paramView, "2");
                    return;
                  }
                }
                catch (Exception paramView)
                {
                  for (;;)
                  {
                    if (QLog.isDevelopLevel()) {
                      QLog.i("Q.recent", 4, paramView.toString());
                    }
                    paramView = null;
                  }
                }
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null) {
              break label424;
            }
            localObject = paramView.getTag(-1);
            if ((localObject instanceof Integer)) {
              break;
            }
          } while (!QLog.isDevelopLevel());
          QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
          return;
          int i = ((Integer)localObject).intValue();
          localObject = getItem(i);
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onClick|obj = " + localObject);
          }
          if (!(localObject instanceof RecentBaseData)) {
            break;
          }
          if (((paramView instanceof IRecentImgv)) && ((localObject instanceof RecentItemEcShop))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localObject);
          }
          for (;;)
          {
            if (!(localObject instanceof RecentItemTroopMsgData)) {
              break label380;
            }
            paramView = (RecentItemTroopMsgData)localObject;
            if ((paramView == null) || (!paramView.b)) {
              break;
            }
            a(paramView.a());
            return;
            RecentBaseData localRecentBaseData = (RecentBaseData)localObject;
            localRecentBaseData.O = i;
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localRecentBaseData, localRecentBaseData.b, true);
          }
        } while (!(localObject instanceof RecentTroopAssistantItem));
        paramView = (RecentTroopAssistantItem)localObject;
      } while ((paramView == null) || (!paramView.b));
      a(paramView.a());
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localObject);
      return;
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(); ((i == 0) || (i == 4)) && (FrameHelperActivity.a()); i = 0) {
      return false;
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
      }
      return false;
    }
    Object localObject1 = paramView.getTag(-1);
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
      }
      return false;
    }
    int j = ((Integer)localObject1).intValue();
    localObject1 = getItem(j);
    if ((localObject1 instanceof RecentBaseData)) {}
    for (localObject1 = (RecentBaseData)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick item is null, pos = " + j);
        }
        return false;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject1);
      if (((RecentBaseData)localObject1).a() == 1)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentBaseData)localObject1).a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, ((RecentBaseData)localObject1).a(), String.valueOf(i - 1), "", "");
      }
      if ("9970".equals(((RecentBaseData)localObject1).a())) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Press_Shopfolderlong", 0, 0, "", "", "", "");
      }
      paramView.setSelected(true);
      if (localObject2 != null) {}
      for (localObject1 = ((RecentItemBaseBuilder)localObject2).a((RecentBaseData)localObject1, this.jdField_a_of_type_AndroidContentContext);; localObject1 = null)
      {
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = new QQCustomMenu();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            ((QQCustomMenu)localObject2).a(j, (String)((List)localObject1).get(i));
            i += 1;
          }
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (QQCustomMenu)localObject2, this.jdField_a_of_type_AndroidViewView$OnClickListener, new owt(this, paramView));
          return true;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + localObject2);
        }
        return false;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */