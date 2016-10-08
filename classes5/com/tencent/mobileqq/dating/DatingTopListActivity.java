package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RankEventMsg;
import com.tencent.mobileqq.data.RankTitleConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import reb;
import red;
import ree;
import ref;
import reg;
import reh;
import rei;
import rek;
import rel;
import ren;
import reo;
import rep;
import rer;
import res;
import ret;
import reu;
import rev;
import rew;
import rey;
import rez;
import rfa;
import rfb;
import rfc;

public class DatingTopListActivity
  extends DatingBaseActivity
  implements Handler.Callback, View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, TabBarView.OnTabChangeListener, AbsListView.OnScrollListener, ActionSheet.OnDismissListener, OverScrollViewListener
{
  private static final int A = 1;
  public static final int c = 180000;
  public static final String c = "DatingTopListActivity";
  public static final int d = 1001;
  public static final String d = "from_where";
  public static final int e = 1002;
  public static final int f = 1003;
  private static final int jdField_h_of_type_Int = 20;
  private static final int i = 0;
  private static final int j = 1;
  private static final int jdField_k_of_type_Int = 0;
  private static final int jdField_l_of_type_Int = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static final int o = 4;
  private static final int p = 5;
  private static final int q = 6;
  private static final int r = 7;
  private static final int s = 8;
  private static int y = 1;
  private static final int z = 0;
  long jdField_a_of_type_Long = -1L;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new rew(this);
  private View jdField_a_of_type_AndroidViewView;
  private RankEventMsg jdField_a_of_type_ComTencentMobileqqDataRankEventMsg;
  private DatingHandler jdField_a_of_type_ComTencentMobileqqDatingDatingHandler;
  DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new reb(this);
  private GodListConfig jdField_a_of_type_ComTencentMobileqqDatingGodListConfig;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new ree(this);
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  private List jdField_a_of_type_JavaUtilList;
  private Set jdField_a_of_type_JavaUtilSet;
  private rey jdField_a_of_type_Rey;
  private rfc jdField_a_of_type_Rfc;
  private long jdField_b_of_type_Long;
  public Dialog b;
  private GodListConfig jdField_b_of_type_ComTencentMobileqqDatingGodListConfig;
  public volatile boolean d;
  boolean e = false;
  private boolean f;
  public int g;
  private boolean g;
  private boolean jdField_h_of_type_Boolean;
  private boolean jdField_k_of_type_Boolean;
  private boolean jdField_l_of_type_Boolean;
  private int t = 0;
  private int u;
  private int v = 0;
  private int w = 0;
  private int x;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DatingTopListActivity()
  {
    this.jdField_g_of_type_Int = -1;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    int i3 = i1 * 15 / 16;
    int i4 = i2 * 16 / 15;
    if (i2 > i3)
    {
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, (i2 - i3) / 2, i1, i3, null, false);
      paramBitmap.recycle();
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap;
    } while (i1 <= i4);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, (i1 - i4) / 2, 0, i4, i2, null, false);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  private String a(int paramInt)
  {
    if (paramInt >= 10000)
    {
      double d1 = paramInt / 10000.0D;
      paramInt = String.valueOf(d1).split("\\.")[0].length();
      NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
      localNumberFormat.setMaximumFractionDigits(4 - paramInt);
      return localNumberFormat.format(d1) + "万";
    }
    return String.valueOf(paramInt);
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())) {}
    for (Object localObject1 = (RankTitleConfig)this.jdField_a_of_type_JavaUtilList.get(paramInt1);; localObject1 = null)
    {
      if (localObject1 != null) {
        if (paramInt2 == 0)
        {
          if (TextUtils.isEmpty(((RankTitleConfig)localObject1).firstTitle)) {
            break label200;
          }
          localObject1 = ((RankTitleConfig)localObject1).firstTitle;
        }
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (paramInt2 != 0) {
            break label164;
          }
          localObject2 = getString(2131371574);
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.nearby_bank", 4, "getRankListTitle|typeList:" + paramInt1 + ",title:" + (String)localObject2 + ",level:" + paramInt2);
          }
          return (String)localObject2;
          if ((paramInt2 != 1) || (TextUtils.isEmpty(((RankTitleConfig)localObject1).secondTitle))) {
            break label200;
          }
          localObject1 = ((RankTitleConfig)localObject1).secondTitle;
          break;
          label164:
          if (paramInt1 == 0)
          {
            localObject2 = getString(2131371577);
          }
          else
          {
            localObject2 = localObject1;
            if (paramInt1 == 1) {
              localObject2 = getString(2131371578);
            }
          }
        }
        label200:
        localObject1 = null;
      }
    }
  }
  
  private List a(int paramInt)
  {
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  private void a(int paramInt, List paramList)
  {
    a(paramList, paramInt, true);
    this.jdField_a_of_type_Rfc.a(paramList);
    this.jdField_a_of_type_Rfc.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      if ((paramList != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig != null))
      {
        this.jdField_a_of_type_Rey.b(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig.hasMore)
        {
          this.jdField_a_of_type_Rey.b();
          return;
        }
        this.jdField_a_of_type_Rey.c();
        return;
      }
      this.jdField_a_of_type_Rey.b(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, false);
    if ((paramList != null) && (this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig != null))
    {
      this.jdField_a_of_type_Rey.b(true);
      if (this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig.hasMore)
      {
        this.jdField_a_of_type_Rey.b();
        return;
      }
      this.jdField_a_of_type_Rey.c();
      return;
    }
    this.jdField_a_of_type_Rey.b(false);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent(paramActivity, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_WINDOW", DatingTopListActivity.class.getName());
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1001);
    localIntent.putExtra("rich_accost_sig", paramArrayOfByte);
    localIntent.putExtra("uinname", paramString2);
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, DatingTopListActivity.class);
    localIntent.putExtra("action_toplist_tinyid", paramLong);
    localIntent.putExtra("action_toplist_typelist", paramInt1);
    localIntent.putExtra("abp_flag", paramBoolean1);
    localIntent.putExtra("is_from_web", paramBoolean2);
    if (paramBoolean1) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("from_where", paramInt2);
    paramContext.startActivity(localIntent);
  }
  
  private void a(GodEntity paramGodEntity)
  {
    if ((paramGodEntity == null) || (paramGodEntity.tinyId <= 0L)) {}
    do
    {
      return;
      localObject = paramGodEntity.uin;
    } while (TextUtils.isEmpty((CharSequence)localObject));
    boolean bool = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b((String)localObject);
    if (((String)localObject).equals(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()))
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, 0);
      ((ProfileActivity.AllInOne)localObject).h = paramGodEntity.nickName;
      ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_Int = paramGodEntity.age;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Byte = ((byte)paramGodEntity.gender);
      ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_Byte = ((byte)paramGodEntity.marriage);
      ((ProfileActivity.AllInOne)localObject).c = paramGodEntity.profession;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_ArrayOfByte = paramGodEntity.declaration.getBytes();
      ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 21;
      localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", (Parcelable)localObject);
      localIntent.putExtra("param_mode", 2);
      localIntent.putExtra("param_tiny_id", paramGodEntity.tinyId);
      startActivity(localIntent);
      return;
    }
    if (bool)
    {
      localObject = new ProfileActivity.AllInOne((String)localObject, 40);
      ((ProfileActivity.AllInOne)localObject).h = paramGodEntity.nickName;
      ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_Int = paramGodEntity.age;
      ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Byte = ((byte)paramGodEntity.gender);
      ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
      return;
    }
    Object localObject = new ProfileActivity.AllInOne((String)localObject, 41);
    ((ProfileActivity.AllInOne)localObject).h = paramGodEntity.nickName;
    ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_Int = paramGodEntity.age;
    ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_Byte = ((byte)paramGodEntity.gender);
    ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_Byte = ((byte)paramGodEntity.marriage);
    ((ProfileActivity.AllInOne)localObject).c = paramGodEntity.profession;
    ((ProfileActivity.AllInOne)localObject).jdField_a_of_type_ArrayOfByte = paramGodEntity.declaration.getBytes();
    ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_ArrayOfByte = HexUtil.a(paramGodEntity.chatsig);
    ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 21;
    Intent localIntent = new Intent(this, NearbyPeopleProfileActivity.class);
    localIntent.putExtra("AllInOne", (Parcelable)localObject);
    localIntent.putExtra("param_mode", 3);
    localIntent.putExtra("param_tiny_id", paramGodEntity.tinyId);
    startActivity(localIntent);
  }
  
  private void a(GodListConfig paramGodListConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingTopListActivity", 4, "loadDataFromServer，mSpecifiedTinyID:" + this.jdField_a_of_type_Long + ",isNeedJumpToSelfPos" + this.f + ",isPull:" + paramBoolean2);
    }
    if ((paramGodListConfig != null) && (System.currentTimeMillis() - paramGodListConfig.lastUpdateTime < 180000L) && (this.jdField_a_of_type_Long <= 0L) && (!this.f) && (!paramBoolean2) && (!paramBoolean3))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    long l1 = this.jdField_a_of_type_Long;
    paramBoolean2 = this.f;
    this.jdField_a_of_type_Long = -1L;
    this.f = false;
    if (!NetworkUtil.e(this))
    {
      runOnUiThread(new rer(this));
      return;
    }
    ThreadManager.c(new res(this, paramGodListConfig, paramBoolean1, l1, paramBoolean2));
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
    Object localObject4;
    rfb localrfb;
    if (((Iterator)localObject1).hasNext())
    {
      localObject4 = (ImageView)((Iterator)localObject1).next();
      localrfb = (rfb)((ImageView)localObject4).getTag();
      if (localrfb.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.tinyId == paramLong)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DatingTopListActivity", 2, "find view, update");
        }
        localrfb.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.url = paramString;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(NearbyImgDownloader.a(localrfb.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.url), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = URLDrawable.getDrawable(localrfb.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.url, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        ((URLDrawable)localObject3).setDownloadListener(new ImgDownloadListener(this, "actTopListPicDownload"));
        ((URLDrawable)localObject3).setDecodeHandler(URLDrawableDecodeHandler.f);
        runOnUiThread(new ref(this, localrfb, (URLDrawable)localObject3));
        i1 = 1;
        this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
        if (i1 == 0)
        {
          localObject1 = this.jdField_a_of_type_JavaUtilHashMap.values();
          if (localObject1 != null)
          {
            localObject1 = ((Collection)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = ((List)((Iterator)localObject1).next()).iterator();
              if (!((Iterator)localObject3).hasNext()) {
                continue;
              }
              localObject4 = (GodEntity)((Iterator)localObject3).next();
              if (((GodEntity)localObject4).tinyId != paramLong) {
                continue;
              }
              ((GodEntity)localObject4).url = paramString;
              continue;
            }
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isDevelopLevel()) {
          localMalformedURLException.printStackTrace();
        }
        Object localObject2 = null;
        continue;
      }
      return;
      int i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  private void a(List paramList, int paramInt, boolean paramBoolean)
  {
    Integer localInteger = Integer.valueOf(paramInt);
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(localInteger);
    if (paramBoolean)
    {
      if ((localList != null) && (localList.size() > 0)) {
        localList.clear();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localInteger, paramList);
      return;
    }
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(localInteger, localObject);
    }
    ((List)localObject).addAll(paramList);
  }
  
  private void a(List paramList1, List paramList2, long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject1;
    int i1;
    label85:
    GodListConfig localGodListConfig;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("DatingTopListActivity loadDataFromServerFinish requestTinyId = ").append(paramLong).append("; changed = ").append(paramBoolean).append("; specifiedPos = ").append(paramInt).append("; cfgs.size = ");
      if (paramList1 == null)
      {
        localObject1 = "null";
        QLog.i("DatingTopListActivity", 2, localObject1);
      }
    }
    else
    {
      if (paramList1 == null) {
        return;
      }
      i1 = 0;
      if (i1 >= paramList1.size()) {
        return;
      }
      localGodListConfig = (GodListConfig)paramList1.get(i1);
      if ((this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig == null) || (localGodListConfig.listType != this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig.listType)) {
        break label302;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DatingTopListActivity", 2, "DatingTopListActivity loadDataFromServerFinish CITY godsList.size() = " + paramList2.size());
      }
      if (paramList2.size() > 0) {
        break label271;
      }
      localObject1 = null;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("DatingTopListActivity loadDataFromServerFinish CITY gods.size() = ");
        if (localObject1 != null) {
          break label287;
        }
        localObject2 = "null";
        QLog.i("DatingTopListActivity", 2, localObject2);
      }
      runOnUiThread(new ret(this, localGodListConfig, paramBoolean, (List)localObject1, paramLong, paramInt));
    }
    label271:
    label287:
    label302:
    while ((this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig == null) || (localGodListConfig.listType != this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig.listType)) {
      for (;;)
      {
        i1 += 1;
        break label85;
        localObject1 = Integer.valueOf(paramList1.size());
        break;
        localObject1 = (List)paramList2.get(i1);
        continue;
        localObject2 = Integer.valueOf(((List)localObject1).size());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DatingTopListActivity", 2, "DatingTopListActivity loadDataFromServerFinish NEW godsList.size() = " + paramList2.size());
    }
    if (paramList2.size() <= 0)
    {
      localObject1 = null;
      label373:
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("DatingTopListActivity loadDataFromServerFinish NEW gods.size() = ");
        if (localObject1 != null) {
          break label460;
        }
      }
    }
    label460:
    for (Object localObject2 = "null";; localObject2 = Integer.valueOf(((List)localObject1).size()))
    {
      QLog.i("DatingTopListActivity", 2, localObject2);
      runOnUiThread(new reu(this, localGodListConfig, paramBoolean, (List)localObject1, paramLong, paramInt));
      break;
      localObject1 = (List)paramList2.get(i1);
      break label373;
    }
  }
  
  private boolean a(XListView paramXListView, String paramString, boolean paramBoolean)
  {
    int i2 = paramXListView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = paramXListView.getChildAt(i1).getTag();
      if (!(localObject instanceof rfb)) {
        return false;
      }
      localObject = (rfb)localObject;
      if (((rfb)localObject).jdField_a_of_type_ComTencentMobileqqDatingGodEntity.uin.equals(paramString))
      {
        if (paramBoolean)
        {
          paramXListView = ((rfb)localObject).jdField_a_of_type_ComTencentMobileqqDatingGodEntity;
          paramXListView.praiseCount += 1;
          ((rfb)localObject).jdField_a_of_type_ComTencentMobileqqDatingGodEntity.praiseflag = 1;
          ((rfb)localObject).b.setCompoundDrawablesWithIntrinsicBounds(2130841172, 0, 0, 0);
        }
        for (;;)
        {
          paramXListView = a(((rfb)localObject).jdField_a_of_type_ComTencentMobileqqDatingGodEntity.praiseCount);
          ((rfb)localObject).b.setText(paramXListView);
          return true;
          paramXListView = ((rfb)localObject).jdField_a_of_type_ComTencentMobileqqDatingGodEntity;
          paramXListView.praiseCount -= 1;
          ((rfb)localObject).jdField_a_of_type_ComTencentMobileqqDatingGodEntity.praiseflag = 0;
          ((rfb)localObject).b.setCompoundDrawablesWithIntrinsicBounds(2130841171, 0, 0, 0);
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.c(new red(this, paramBoolean));
  }
  
  private void e()
  {
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130838587);
    this.rightViewImg.setOnClickListener(this);
    this.rightViewImg.setContentDescription("更多");
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131298513));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getString(2131371582));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(getString(2131371583));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131302314));
    View localView = getLayoutInflater().inflate(2130904140, null, false);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Rey = new rey(localView, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_Rey.b(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903499, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837958);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(localView, null, false);
    this.jdField_a_of_type_Rfc = new rfc(this, 20);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Rfc);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(localView);
  }
  
  private void f()
  {
    ThreadManager.c(new reo(this));
  }
  
  private void g()
  {
    Object localObject3 = (DatingManager)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
    Object localObject2 = ((DatingManager)localObject3).a(this.jdField_g_of_type_Int);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GodListConfig();
      ((GodListConfig)localObject1).listType = this.jdField_g_of_type_Int;
    }
    if (this.jdField_g_of_type_Int == 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig = ((GodListConfig)localObject1);
      this.t = 1;
    }
    for (;;)
    {
      localObject2 = ((DatingManager)localObject3).b(((GodListConfig)localObject1).listType);
      localObject3 = new Message();
      ((Message)localObject3).what = 0;
      ((Message)localObject3).obj = localObject2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
      a((GodListConfig)localObject1, true, false, false);
      int i1 = getSharedPreferences("dating_pref" + this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0).getInt("toplist_show_banner_times", 1);
      if ((i1 >= 1) && (i1 <= 3) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8, 0, 0).sendToTarget();
      }
      return;
      if (this.jdField_g_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig = ((GodListConfig)localObject1);
        this.t = 0;
      }
    }
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!isFinishing())) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg.notifytype;
    Object localObject;
    label204:
    Bitmap localBitmap;
    if ((i1 >= 1) && (i1 <= 5))
    {
      this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131559131);
      this.jdField_b_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131427358)));
      if ((this.jdField_g_of_type_Int != 0) && (this.jdField_g_of_type_Int != 2)) {
        break label361;
      }
      localObject = "男";
      if ((i1 != 1) && (i1 != 3) && (i1 != 4)) {
        break label430;
      }
      this.jdField_b_of_type_AndroidAppDialog.setContentView(2130904322);
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302320)).setText(getString(2131372103, new Object[] { localObject }));
      localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302317);
      if (i1 != 1) {
        break label368;
      }
      ((TextView)localObject).setTextSize(1, 15.0F);
      ((TextView)localObject).setText(getString(2131372104));
      localObject = (ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296790);
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 200);
      if (localBitmap != null) {
        break label422;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 200, true, false);
      ((ImageView)localObject).setImageDrawable((BitmapDrawable)ImageUtil.a());
      label272:
      ((ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302316)).setOnClickListener(this);
      ((Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302321)).setOnClickListener(this);
      localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302322);
      if (!this.k) {
        break label552;
      }
      ((TextView)localObject).setVisibility(8);
    }
    for (;;)
    {
      ((TextView)localObject).setOnClickListener(this);
      this.jdField_b_of_type_AndroidAppDialog.setCancelable(false);
      if (!isFinishing()) {
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
      label361:
      localObject = "女";
      break;
      label368:
      if (i1 == 3)
      {
        ((TextView)localObject).setTextSize(1, 12.5F);
        ((TextView)localObject).setText(getString(2131371600));
        break label204;
      }
      if (i1 != 4) {
        break label204;
      }
      ((TextView)localObject).setTextSize(1, 12.5F);
      ((TextView)localObject).setText(getString(2131371601));
      break label204;
      label422:
      ((ImageView)localObject).setImageBitmap(localBitmap);
      break label272;
      label430:
      if ((i1 != 2) && (i1 != 5)) {
        break label272;
      }
      this.jdField_b_of_type_AndroidAppDialog.setContentView(2130904323);
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302320)).setText(getString(2131372103, new Object[] { localObject }));
      localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302323);
      if (i1 == 2)
      {
        ((TextView)localObject).setText(getString(2131371599));
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new rep(this), 2000L);
        break label272;
      }
      if (i1 != 5) {
        break label272;
      }
      ((TextView)localObject).setText(getString(2131371602));
      break label272;
      label552:
      ((TextView)localObject).setVisibility(0);
    }
  }
  
  private void i()
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    if (Friends.isValidUin(str))
    {
      str = String.format("http://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(0), str });
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", str);
      startActivity(localIntent);
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
        b(true);
      }
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    if (!this.k) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131371581);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131371586);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void k()
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(getApplicationContext(), "当前网络不可用，请检查你的网络设置。", 0).b(getTitleBarHeight());
      return;
    }
    b("0X800527C");
    boolean bool = this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0).getBoolean("toplist_sp_typelist_set_refuse_rank", false);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131371586));
    }
    int i1;
    if (bool)
    {
      i1 = 2131371589;
      label117:
      if (this.w != 2) {
        break label237;
      }
    }
    label237:
    for (String str = "女";; str = "男")
    {
      str = getString(i1, new Object[] { str });
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(str);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131371587, new reg(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131371588, new reh(this));
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) || (isFinishing())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      i1 = 2131371590;
      break label117;
    }
  }
  
  private void l()
  {
    this.jdField_g_of_type_Int = getIntent().getIntExtra("action_toplist_typelist", -1);
    if ((this.jdField_g_of_type_Int == 0) || (this.jdField_g_of_type_Int == 1))
    {
      this.jdField_a_of_type_Long = getIntent().getLongExtra("action_toplist_tinyid", -1L);
      if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg != null))
      {
        this.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataRankEventMsg.listtype;
        if ((this.jdField_g_of_type_Int != 0) && (this.jdField_g_of_type_Int != 1)) {
          this.jdField_g_of_type_Int = -1;
        }
      }
      if (this.jdField_g_of_type_Int < 0) {
        switch (this.w)
        {
        }
      }
    }
    for (this.jdField_g_of_type_Int = 1;; this.jdField_g_of_type_Int = 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      if (QLog.isColorLevel()) {
        QLog.i("DatingTopListActivity", 2, "initData mTypeList = " + this.jdField_g_of_type_Int + ",mSpecifiedTinyID:" + this.jdField_a_of_type_Long + ",mCurGender:" + this.w);
      }
      return;
      this.jdField_g_of_type_Int = -1;
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DatingTopListActivity", 2, "DatingTopListActivity onTabSelected:" + paramInt1 + "  " + paramInt2);
    }
    this.v = 0;
    this.t = paramInt2;
    DatingManager localDatingManager = (DatingManager)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
    if (paramInt2 == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig.visiblePos = this.jdField_a_of_type_ComTencentWidgetXListView.s();
      }
      this.jdField_g_of_type_Int = 0;
      if (this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig = localDatingManager.a(this.jdField_g_of_type_Int);
        if (this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig == null)
        {
          this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig = new GodListConfig();
          this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig.listType = this.jdField_g_of_type_Int;
        }
        ThreadManager.c(new rei(this, localDatingManager));
        return;
      }
      runOnUiThread(new rek(this));
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig != null) {
      this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig.visiblePos = this.jdField_a_of_type_ComTencentWidgetXListView.s();
    }
    this.jdField_g_of_type_Int = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig = localDatingManager.a(this.jdField_g_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig = new GodListConfig();
        this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig.listType = this.jdField_g_of_type_Int;
      }
      ThreadManager.c(new rel(this, localDatingManager));
      return;
    }
    runOnUiThread(new ren(this));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a())) && (this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      if ((paramBitmap != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())) {}
    }
    for (;;)
    {
      return;
      Object localObject = (ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131296790);
      if (localObject != null) {
        ((ImageView)localObject).setImageBitmap(paramBitmap);
      }
      if ((this.v == 0) && (paramBitmap != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()))
      {
        paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
          if ((localObject instanceof rez))
          {
            localObject = (rez)localObject;
            if (paramString.equals(String.valueOf(((rez)localObject).jdField_a_of_type_ComTencentMobileqqDatingGodEntity.tinyId)))
            {
              ((rez)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
              return;
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.v = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt = 0;
      while (paramInt < i1)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && ((paramAbsListView instanceof rez)))
        {
          paramAbsListView = (rez)paramAbsListView;
          Drawable localDrawable = DatingUtil.b(paramAbsListView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.tinyId + "", this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 202);
          paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (this.t == 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDatingGodListConfig, true, true, false);
      return true;
    }
    a(this.jdField_b_of_type_ComTencentMobileqqDatingGodListConfig, true, true, false);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  void c(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0) {}
    while (paramInt1 != 8) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = DatingUtil.a;
    }
    DatingUtil.a(this, localIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904321);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler = ((DatingHandler)this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(2));
    this.u = getResources().getDisplayMetrics().widthPixels;
    addObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-13947339);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    e();
    f();
    ViewExposeUtil.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getClass(), hashCode(), "0X80057C3", 0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    ViewExposeUtil.ViewExposeUnit localViewExposeUnit = ViewExposeUtil.a(getClass(), hashCode());
    if (localViewExposeUnit != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", localViewExposeUnit.jdField_a_of_type_JavaLangString, localViewExposeUnit.jdField_a_of_type_JavaLangString, localViewExposeUnit.jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - localViewExposeUnit.jdField_b_of_type_Long), "", "", "");
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    }
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
        return true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        paramMessage = (List)paramMessage.obj;
        a(this.jdField_g_of_type_Int, paramMessage);
        return true;
        h();
        return true;
        if (this.jdField_g_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
          setTitle(a(this.jdField_g_of_type_Int, 1));
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
        setTitle(a(this.jdField_g_of_type_Int, 0));
        int i1 = this.jdField_g_of_type_Int ^ 0x1;
        if (this.t == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, a(this.jdField_g_of_type_Int, 1));
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, a(i1, 1));
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, a(this.jdField_g_of_type_Int, 1));
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, a(i1, 1));
        return true;
        this.jdField_a_of_type_ComTencentWidgetXListView.H();
        stopTitleProgress();
        return true;
        paramMessage = DialogUtil.a(this, 230);
        paramMessage.setTitle(null);
        paramMessage.setMessage("对方设置了不允许附近的人点赞，向对方打个招呼吧~");
        paramMessage.setPositiveButton(2131370504, new rev(this));
      } while (isFinishing());
      paramMessage.show();
      return true;
      super.startTitleProgress();
      return true;
      c(getString(2131371605));
      return true;
      d();
      return true;
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = findViewById(2131302313);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      }
      if ((paramMessage.arg1 == 0) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        b(false);
        return true;
      }
    } while ((paramMessage.arg1 != 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131297392) {
      j();
    }
    label666:
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
                  return;
                  if (i1 == 2131302313)
                  {
                    i();
                    b("0X800552C");
                    return;
                  }
                  if ((i1 != 2131302316) && (i1 != 2131302321)) {
                    break;
                  }
                } while ((this.jdField_b_of_type_AndroidAppDialog == null) || (isFinishing()));
                this.jdField_b_of_type_AndroidAppDialog.dismiss();
                return;
                if (i1 != 2131302322) {
                  break;
                }
              } while (this.k);
              i();
            } while ((this.jdField_b_of_type_AndroidAppDialog == null) || (isFinishing()));
            this.jdField_b_of_type_AndroidAppDialog.dismiss();
            return;
            paramView = paramView.getTag();
          } while (paramView == null);
          if (!(paramView instanceof rfb)) {
            break;
          }
          paramView = (rfb)paramView;
          switch (i1)
          {
          default: 
            return;
          case 2131302303: 
            if ((!TextUtils.isEmpty(paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.uin)) && (paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.uin.equals(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a())))
            {
              paramView = new Intent(this, VisitorsActivity.class);
              new Bundle().putLong("toUin", Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()).longValue());
              startActivity(paramView);
            }
            for (;;)
            {
              b("0X8005280");
              return;
              if (paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.praiseflag == 0)
              {
                localObject = paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity;
                ((GodEntity)localObject).praiseCount += 1;
                paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.praiseflag = 1;
                localObject = a(paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.praiseCount);
                paramView.b.setText((CharSequence)localObject);
                paramView.b.setCompoundDrawablesWithIntrinsicBounds(2130841172, 0, 0, 0);
                this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler.a(paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity);
              }
              else if (paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.praiseflag == 2)
              {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
              }
            }
          case 2131302305: 
            if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().equals(paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.uin))
            {
              a(2, 2131371593, 0);
              return;
            }
            if ((this.d) || (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long < 500L))
            {
              DatingUtil.c("DatingTopListActivity", new Object[] { "HAVE CLICK SAY HELLO, WAIT RSP, return" });
              return;
            }
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler == null);
        this.d = true;
        this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingHandler.a(Long.parseLong(paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.uin), 32, HexUtil.a(paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.chatsig));
      } while (this.jdField_a_of_type_AndroidOsHandler == null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1000L);
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().equals(paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.uin))
      {
        a(2, 2131371594, 0);
        return;
      }
      Object localObject = paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.uin;
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity.chatsig;
      if (!TextUtils.isEmpty(paramView))
      {
        if (!Friends.isValidUin((String)localObject)) {
          break label666;
        }
        paramView = String.format("http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { NearbyURLSafeUtil.a((String)localObject), paramView.toLowerCase(), Integer.valueOf(1), "rank.s", "" });
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("portraitOnly", true);
        ((Intent)localObject).putExtra("url", paramView);
        startActivity((Intent)localObject);
        b("0X80052BE");
      }
      for (;;)
      {
        DatingBaseActivity.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "0X8005282");
        return;
        QQToast.a(this, 2131369645, 0).b(getTitleBarHeight());
      }
      a(paramView.jdField_a_of_type_ComTencentMobileqqDatingGodEntity);
      return;
      if ((paramView instanceof rez))
      {
        a(((rez)paramView).jdField_a_of_type_ComTencentMobileqqDatingGodEntity);
        return;
      }
    } while (!(paramView instanceof rfa));
    i();
    b("0X800527F");
  }
  
  public void onDismiss() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingTopListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */