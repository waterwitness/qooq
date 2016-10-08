package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import lio;
import lip;
import liq;
import lir;
import lis;
import mqq.os.MqqHandler;

public class FavEmosmManageActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final int a = 0;
  public static final String a = "FavEmosmManageActivity";
  public static final int b = 4;
  public static final String b = "extra_key_from_web";
  public static final int c = 4;
  public static final String c = "extra_key_pkgids";
  public static final int d = 4;
  public static final String d = "extra_key_md5s";
  public static final int e = 0;
  public static final String e = "extra_key_faile_count";
  public static final int f = 1;
  public static final String f = "extra_key_paths";
  public static final int g = 205;
  public static final String g = "pre_key_is_show_guide";
  public static final int h = 206;
  public static final String h = "extra_key_over_num";
  public static final int i = 207;
  public static final String i = "com.tencent.mobileqq.action.update.emotiom";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FavEmoRoamingObserver jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver;
  public FavroamingDBManager a;
  private SyncListener jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  public ArrayList a;
  public List a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  lis jdField_a_of_type_Lis;
  boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public List b;
  boolean jdField_b_of_type_Boolean;
  private TextView c;
  private int j;
  private int k;
  private int l;
  private int m;
  
  public FavEmosmManageActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.m = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lio(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener = new lip(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver = new liq(this);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        paramList.addAll(this.jdField_a_of_type_JavaUtilList);
      }
      int i1 = paramList.size();
      int n = 0;
      while (n < paramList.size())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Byte.valueOf((byte)0));
        n += 1;
      }
      this.jdField_a_of_type_Lis = new lis(this, paramList);
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(this.jdField_a_of_type_Lis);
      if (i1 - 1 - FavEmoConstant.a > 0) {
        this.m = 1;
      }
      e();
    } while ((!this.jdField_a_of_type_Boolean) || (this.l <= 0));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.m = 1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    paramList = String.format(getString(2131372167), new Object[] { Integer.valueOf(this.l) });
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramList);
    this.c.setVisibility(8);
  }
  
  private void b()
  {
    Object localObject = getResources();
    int n = ((Resources)localObject).getDisplayMetrics().widthPixels;
    int i1 = AIOUtils.a(0.0F, (Resources)localObject);
    int i2 = AIOUtils.a(4.0F, (Resources)localObject);
    int i3 = AIOUtils.a(4.0F, (Resources)localObject);
    this.j = ((n - i1 * 2 - i2 * 3) / 4);
    this.k = this.j;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131372164);
    this.rightViewText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298178));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298179));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298182));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298180));
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)super.findViewById(2131298183));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.j);
    this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(i2);
    this.jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(i3);
    this.jdField_a_of_type_ComTencentWidgetGridView.setPadding(i1, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingTop(), i1, this.jdField_a_of_type_ComTencentWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGridView.setMaximumVelocity((int)(2500.0F * getResources().getDisplayMetrics().density));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298177));
    this.c = ((TextView)super.findViewById(2131298181));
    boolean bool = super.getIntent().getBooleanExtra("extra_key_from_web", false);
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean)
    {
      this.l = super.getIntent().getIntExtra("extra_key_over_num", 0);
      localObject = super.getIntent().getStringArrayListExtra("extra_key_pkgids");
      ArrayList localArrayList1 = super.getIntent().getStringArrayListExtra("extra_key_paths");
      ArrayList localArrayList2 = super.getIntent().getStringArrayListExtra("extra_key_md5s");
      i1 = super.getIntent().getIntExtra("extra_key_faile_count", 0);
      if ((localObject != null) && (localArrayList1 != null) && (localArrayList2 != null))
      {
        n = Math.min(((List)localObject).size(), localArrayList1.size());
        i2 = Math.min(localArrayList2.size(), n);
        n = 0;
        while (n < i2)
        {
          FavoriteEmoticonInfo localFavoriteEmoticonInfo = new FavoriteEmoticonInfo();
          localFavoriteEmoticonInfo.l = ((String)((List)localObject).get(n));
          localFavoriteEmoticonInfo.m = ((String)localArrayList1.get(n));
          localFavoriteEmoticonInfo.a = ((String)localArrayList2.get(n));
          this.jdField_a_of_type_JavaUtilList.add(localFavoriteEmoticonInfo);
          n += 1;
        }
      }
      this.rightViewText.setText(2131369134);
      if (this.leftView != null) {
        this.leftView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      if (i1 > 0) {
        QQToast.a(this, i1 + "个下载失败", 0).a();
      }
    }
  }
  
  private void b(List paramList)
  {
    if ((this.jdField_a_of_type_Lis == null) || (paramList == null) || (paramList.size() < 1)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramList.size() > 0)
    {
      int n = 0;
      while (n < paramList.size())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Byte.valueOf((byte)0));
        n += 1;
      }
    }
    this.jdField_a_of_type_Lis.a(paramList);
    this.jdField_a_of_type_Lis.notifyDataSetChanged();
    e();
  }
  
  private void c()
  {
    List localList2 = ((FavroamingDBManager)this.app.getManager(148)).a(200);
    Object localObject1 = localList2;
    if (localList2 != null) {
      localList1 = localList2;
    }
    try
    {
      Collections.reverse(localList2);
      localObject1 = localList2;
      localList1 = localList2;
      if (localList2.size() > FavEmoConstant.b)
      {
        localList1 = localList2;
        int n = localList2.size() - FavEmoConstant.b;
        localList1 = localList2;
        localList2 = localList2.subList(n, localList2.size());
        localObject1 = localList2;
        localList1 = localList2;
        if (QLog.isColorLevel())
        {
          localList1 = localList2;
          QLog.d("FavEmoRoamingHandler", 2, "fav emoticon overflow size" + n);
          localObject1 = localList2;
        }
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 2, localUnsupportedOperationException.getMessage());
        }
        Object localObject2 = localList1;
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      if (((List)localObject1).size() >= FavEmoConstant.a) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
      }
      if (((List)localObject1).size() >= FavEmoConstant.b) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
      }
      ((List)localObject1).add(0, new EmoticonInfo());
      a((List)localObject1);
      return;
    }
  }
  
  private void d()
  {
    int n = 0;
    if (n < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (((Byte)this.jdField_a_of_type_JavaUtilArrayList.get(n)).byteValue() != 1) {}
    }
    for (n = 0;; n = 1)
    {
      Object localObject1;
      if (n != 0)
      {
        this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
        localObject1 = (FavEmoRoamingHandler)this.app.a(72);
        if (localObject1 != null)
        {
          ((FavEmoRoamingHandler)localObject1).a(this.jdField_b_of_type_JavaUtilList, false);
          if (QLog.isColorLevel()) {
            QLog.d("FavEmoRoamingHandler", 2, "-------start delfav---------delResid=" + this.jdField_b_of_type_JavaUtilList.toString());
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8005CF2", "0X8005CF2", 0, 0, this.jdField_b_of_type_JavaUtilList.size() + "", "", "", "");
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        localObject1 = this.app.a(ChatActivity.class);
        if (localObject1 != null) {
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
        }
        return;
        n += 1;
        break;
      }
      Object localObject2;
      int i2;
      int i1;
      label282:
      Object localObject3;
      if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject2 = this.jdField_a_of_type_Lis.jdField_a_of_type_JavaUtilList;
        i2 = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), ((List)localObject2).size());
        localObject1 = new ArrayList();
        i1 = 0;
        n = 0;
        if (i1 < i2)
        {
          localObject3 = (Byte)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (localObject3 == null) {
            break label839;
          }
          if (((Byte)localObject3).byteValue() != 0) {}
        }
      }
      label839:
      for (;;)
      {
        i1 += 1;
        break label282;
        localObject3 = (EmoticonInfo)((List)localObject2).get(i1);
        if (localObject3 != null)
        {
          ((List)localObject1).add(localObject3);
          n += 1;
          continue;
          localObject2 = (FavroamingDBManager)this.app.getManager(148);
          localObject3 = ((FavroamingDBManager)localObject2).a();
          if (localObject3 != null)
          {
            int i3 = 0;
            for (i1 = 1;; i1 = i2)
            {
              i2 = i1;
              if (i3 >= ((List)localObject3).size()) {
                break;
              }
              int i4 = ((CustomEmotionData)((List)localObject3).get(i3)).emoId;
              i2 = i1;
              if (i1 < i4) {
                i2 = i4;
              }
              i3 += 1;
            }
          }
          i2 = 1;
          localObject3 = new ArrayList();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            FavoriteEmoticonInfo localFavoriteEmoticonInfo = (FavoriteEmoticonInfo)localIterator.next();
            if (!((List)localObject1).contains(localFavoriteEmoticonInfo))
            {
              CustomEmotionData localCustomEmotionData = new CustomEmotionData();
              localCustomEmotionData.uin = this.app.a();
              localCustomEmotionData.url = localFavoriteEmoticonInfo.m;
              localCustomEmotionData.eId = localFavoriteEmoticonInfo.l;
              localCustomEmotionData.md5 = localFavoriteEmoticonInfo.a;
              i2 += 1;
              localCustomEmotionData.emoId = i2;
              localCustomEmotionData.emoPath = (AppConstants.bs + FunnyPicHelper.a(localFavoriteEmoticonInfo.m));
              ((FavroamingDBManager)localObject2).c(localCustomEmotionData);
              ((List)localObject3).add(localCustomEmotionData);
            }
          }
          localObject1 = (FavroamingManager)this.app.getManager(102);
          if ((localObject1 != null) && (!((List)localObject3).isEmpty())) {
            ((FavroamingManager)localObject1).syncUpload((List)localObject3);
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8005C79", "0X8005C79", 0, 0, String.valueOf(n), "", "", "");
          this.jdField_a_of_type_Boolean = false;
          localObject1 = this.app.a(ChatActivity.class);
          if (localObject1 != null) {
            ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
          }
          QQToast.a(this, "趣图已添加至收藏面板", 0).a();
          localObject1 = (VipComicMqqManager)this.app.getManager(140);
          n = 0;
          if (n < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((Byte)this.jdField_a_of_type_JavaUtilArrayList.get(n)).byteValue() == 0) {}
            do
            {
              n += 1;
              break;
              localObject2 = this.jdField_a_of_type_Lis.getItem(n);
            } while (localObject2 == null);
            ThreadManager.a(new lir(this, localObject2, (VipComicMqqManager)localObject1, n), 5, null, false);
            return;
          }
          localObject1 = this.app.a(ChatActivity.class);
          if (localObject1 == null) {
            break;
          }
          ((MqqHandler)localObject1).obtainMessage(10).sendToTarget();
          return;
        }
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Lis == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return;
    }
    if (this.jdField_a_of_type_Lis.getCount() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#00a5e0"));
      if (this.jdField_a_of_type_Lis.jdField_a_of_type_JavaUtilList == null) {
        break label524;
      }
    }
    label524:
    for (int n = this.jdField_a_of_type_Lis.jdField_a_of_type_JavaUtilList.size();; n = 0)
    {
      int i1 = n - 1 - FavEmoConstant.a;
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      n = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          n = ((Byte)((Iterator)localObject).next()).byteValue() + n;
          continue;
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#cccccc"));
          break;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (n >= this.l)
        {
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      if ((n > 0) && (n >= i1)) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      }
      while (i1 > 0) {
        if (1 == this.m)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.c.setVisibility(0);
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            this.rightViewText.setText(2131372165);
          }
          localObject = String.format(getString(2131372281), new Object[] { Integer.valueOf(FavEmoConstant.a) });
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          ReportController.b(this.app, "CliOper", "", "", "0X8005CF1", "0X8005CF1", 0, 0, i1 + "", "", "", "");
          localObject = String.format(getString(2131372278), new Object[] { Integer.valueOf(i1) });
          this.c.setText((CharSequence)localObject);
          localObject = "删除(" + n + ")";
          this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
          this.m = 1;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          return;
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetButton.setText("删除(0)");
          return;
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(8);
      localObject = String.format(getString(2131372166), new Object[] { Integer.valueOf(n) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131372163));
      return;
    }
  }
  
  public void a()
  {
    List localList = ((FavroamingDBManager)this.app.getManager(148)).a(200);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    try
    {
      Collections.reverse((List)localObject);
      ((List)localObject).add(0, new EmoticonInfo());
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(206, localObject).sendToTarget();
      }
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 2, localUnsupportedOperationException.getMessage());
        }
      }
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.m == 0) {
      if (paramInt == 0)
      {
        paramAdapterView = new Intent(this, QQBrowserActivity.class);
        paramAdapterView.putExtra("finish_animation_up_down", true);
        paramAdapterView.putExtra("hide_left_button", true);
        paramAdapterView.putExtra("show_right_close_button", true);
        paramAdapterView.putExtra("isFromCustom", true);
        VasWebviewUtil.openQQBrowserWithoutAD(this, IndividuationUrlHelper.a("funnyPic"), -1L, paramAdapterView, false, -1);
        super.overridePendingTransition(2130968585, 0);
        ReportController.b(this.app, "CliOper", "", "", "0X8005C77", "0X8005C77", 0, 0, "", "", "", "");
      }
    }
    while (paramInt == 0) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt))
    {
      if (((Byte)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).byteValue() != 0) {
        break label184;
      }
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, Byte.valueOf((byte)1));
    }
    for (;;)
    {
      this.jdField_a_of_type_Lis.notifyDataSetChanged();
      e();
      return;
      label184:
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, Byte.valueOf((byte)0));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903336);
    super.setTitle(2131372168);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager = ((FavroamingDBManager)this.app.getManager(148));
    ((FavroamingManager)this.app.getManager(102)).addSyncListener(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    b();
    c();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.update.emotiom");
      getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_b_of_type_Boolean) {
      getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    ((FavroamingManager)this.app.getManager(102)).removeSyncListener(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver != null) {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingObserver);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 207)
    {
      n = ((Integer)paramMessage.obj).intValue();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > n)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(n);
      }
      if (this.jdField_a_of_type_Lis != null) {}
    }
    while ((paramMessage.what != 206) || (this.jdField_a_of_type_Lis == null))
    {
      int n;
      return false;
      this.jdField_a_of_type_Lis.a(n);
      this.jdField_a_of_type_Lis.notifyDataSetChanged();
      e();
      d();
      return false;
    }
    b((List)paramMessage.obj);
    return false;
  }
  
  protected boolean onBackEvent()
  {
    ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D4", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_b_of_type_Boolean)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
            super.onBackEvent();
            return;
          }
        } while (this.jdField_a_of_type_Lis == null);
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.rightViewText.setText(2131372164);
          this.m = 0;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          n = 0;
          while (n < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            this.jdField_a_of_type_JavaUtilArrayList.set(n, Byte.valueOf((byte)0));
            n += 1;
          }
          this.jdField_a_of_type_Lis.notifyDataSetChanged();
          e();
          ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
          return;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.rightViewText.setText(2131372165);
        this.m = 1;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_Lis.notifyDataSetChanged();
        ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
        return;
      } while (this.jdField_a_of_type_Lis == null);
      int n = 1;
      while (n < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_JavaUtilArrayList.set(n, Byte.valueOf((byte)1));
        n += 1;
      }
      this.jdField_a_of_type_Lis.notifyDataSetChanged();
      e();
      ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
      return;
    } while (this.jdField_a_of_type_Lis == null);
    d();
    ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D7", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\FavEmosmManageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */