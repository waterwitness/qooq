package com.tencent.mobileqq.troop.activity;

import NearbyGroup.RspActivity;
import NearbyGroup.RspGetNearbyGroup;
import NearbyGroup.RspHotGrp;
import NearbyGroup.RspTopic;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper.ActivityInfo;
import com.tencent.mobileqq.troop.data.GroupAreaWrapper.TopicInfo;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.nearby_troop_activity.nearby_troop_activity.ActivityDigest;
import tencent.im.cs.nearby_troop_activity.nearby_troop_activity.RspBody;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunMsg;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunRsp;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.QunInfo;
import tencent.im.cs.nearby_troop_hot.nearby_troop_hot.RetInfo;
import tencent.im.cs.nearby_troop_post.nearby_troop_post.RspBody;
import tencent.im.cs.nearby_troop_post.nearby_troop_post.RspNearbyPostInfo;
import tencent.im.group.nearbybanner.nearbybanner.BannerInfo;
import tencent.im.group.nearbybanner.nearbybanner.CreateGroupBanner;
import tencent.im.group.nearbybanner.nearbybanner.RecommGroupBanner;
import tencent.im.group.nearbybanner.nearbybanner.SearchBanner;
import tencent.im.group.nearbybanner.nearbybanner.SetGroupBanner;
import tencent.im.group.nearbybanner.nearbybanner.WebBanner;
import vet;
import vev;
import vew;
import vex;
import vey;
import vez;
import vfa;
import vfb;
import vfc;

public class NearbyTroopsView
  extends NearbyTroopsBaseView
  implements View.OnClickListener, OverScrollViewListener
{
  public static final int A = 7;
  public static final int B = 0;
  public static final int C = 1;
  public static final int H = -1;
  public static final int I = 0;
  protected static final long a = 1000L;
  public static final String a = "NearByTroop";
  public static final String b = "banner_url";
  public static final String c;
  public static final String f = "NearbyTroopsActivity";
  public static final boolean f;
  public static final String g = "near_troop_last_refresh_time";
  public static final String h = "lat";
  public static final int i = 1000;
  public static final String i = "lon";
  public static final int j = 100;
  public static final String j = "from";
  public static final int k = 99;
  public static final String k = "mode";
  public static final String l = "_nearby_troops_5_0.nb";
  public static final int m = 1000;
  public static final String m = "need_to_show_map_entrance";
  public static final int n = 800;
  public static final String n = "is_show_mapentry";
  public static final int o = 2;
  protected static final String o = "http://qun.qq.com/search/mobileqq/nearbyGroupClassify.json";
  public static final int p = 3;
  public static final String p = "http://qun.qq.com/qqweb/m/qun/search/index.html?_wv=1031&_bid=2073";
  public static final int q = 4;
  public static final String q = "location_name";
  public static final int r = 0;
  public static final int s = 1;
  protected static final String s = "nearby_group_classify_last_modify_time";
  public static final int t = 5;
  protected static final String t = "nearby_group_classify_sp";
  public static final int u = 1;
  protected static final String u = "nearby_group_classify_content";
  public static final int v = 2;
  public static final String v = "filter_id";
  public static final int w = 3;
  protected static final String w = "classify_json_data";
  public static final int x = 4;
  protected static final String x = "last_modify";
  public static final int y = 5;
  public static final int z = 6;
  public int D = 0;
  protected int E = 0;
  protected int F = 1;
  public int G = -1;
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public GestureDetector a;
  public View.OnFocusChangeListener a;
  public EditText a;
  public ImageView a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public LBSObserver a;
  public NearbyTroopsView.UIHandler a;
  public NearbyTroopsExpandableListViewAdapter a;
  public NearbyTroopsExpandableListView a;
  public HorizontalScrollLayout a;
  public PullRefreshHeader a;
  public Runnable a;
  public ArrayList a;
  public nearbybanner.BannerInfo a;
  public String[] a;
  public int b;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  protected TextView b;
  public int c;
  View c;
  public RelativeLayout c;
  public boolean c;
  public int d;
  public View d;
  public String d;
  public boolean d;
  public int e;
  protected View e;
  public String e;
  public boolean e;
  public int f;
  public View f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  boolean i = false;
  public boolean j = false;
  public boolean k;
  protected int l;
  public String r;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = AppConstants.bj + "qbiz/troop/banner_data";
    jdField_f_of_type_Boolean = AppSetting.j;
  }
  
  public NearbyTroopsView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_f_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new vet(this);
    this.jdField_a_of_type_JavaLangRunnable = new vev(this);
    this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new vfa(this);
  }
  
  private String a()
  {
    String str = null;
    SharedPreferences localSharedPreferences = a().getSharedPreferences("nearby_group_classify_sp", 0);
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("nearby_group_classify_content", null);
    }
    return str;
  }
  
  private void a(int paramInt, Bitmap paramBitmap)
  {
    if (paramInt != 0) {}
    while ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (!this.jdField_h_of_type_Boolean)) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "exp_banner", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  private void a(ViewGroup paramViewGroup, JSONObject paramJSONObject)
  {
    int i2 = 0;
    if ((paramViewGroup == null) || (paramJSONObject == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("content");
          paramJSONObject = paramJSONObject.optJSONObject("moreItem");
          if (paramJSONObject != null) {
            localJSONArray.put(paramJSONObject);
          }
          if (localJSONArray.length() != 0)
          {
            int i1 = localJSONArray.length();
            int i3 = (int)DeviceInfoUtil.f();
            if (i1 <= 4)
            {
              i1 = i3 / 4;
              paramJSONObject = new LinearLayout.LayoutParams(-1, -2);
              paramJSONObject.setMargins(0, 0, 0, 0);
              paramViewGroup.setLayoutParams(paramJSONObject);
            }
            for (;;)
            {
              this.l = i1;
              paramViewGroup.removeAllViews();
              while (i2 < localJSONArray.length())
              {
                Object localObject = localJSONArray.getJSONObject(i2);
                paramJSONObject = new NearbyTroopsView.ClassifyItem();
                paramJSONObject.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("cid");
                paramJSONObject.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("icon_url");
                paramJSONObject.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("jump_url");
                paramJSONObject.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).getString("wording");
                paramJSONObject.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("order");
                paramJSONObject.jdField_c_of_type_Int = ((JSONObject)localObject).getInt("type");
                if (paramJSONObject.jdField_a_of_type_Int == 99)
                {
                  localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903923, null);
                  a(paramJSONObject, (View)localObject, i1);
                  ((View)localObject).setVisibility(8);
                  paramViewGroup.addView((View)localObject);
                  this.jdField_e_of_type_AndroidViewView = ((View)localObject);
                }
                localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903923, null);
                a(paramJSONObject, (View)localObject, i1);
                paramViewGroup.addView((View)localObject);
                i2 += 1;
              }
              i1 = i3 * 2 / 9;
            }
            paramViewGroup.invalidate();
            return;
          }
        }
        catch (JSONException paramViewGroup) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("NearbyTroopsActivity", 2, "fillClassifyContent==>JSONException");
  }
  
  private void a(NearbyTroopsView.ClassifyItem paramClassifyItem, View paramView, int paramInt)
  {
    if ((paramClassifyItem == null) || (paramView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyTroopsActivity", 2, "fillEachClassifyItem==> item == null || itemView == null");
      }
      return;
    }
    Object localObject2 = null;
    ImageView localImageView = (ImageView)paramView.findViewById(2131300666);
    if (0 == 0) {
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840084);
    }
    String str = paramClassifyItem.jdField_a_of_type_JavaLangString;
    Object localObject3 = paramClassifyItem.jdField_c_of_type_JavaLangString;
    Object localObject1 = localObject3;
    if (localObject3 != null)
    {
      localObject1 = localObject3;
      if (4 < ((String)localObject3).length()) {
        localObject1 = ((String)localObject3).substring(0, 4);
      }
    }
    try
    {
      localObject3 = new URL(str);
      localObject2 = URLDrawable.getDrawable(new URL("third_part", ((URL)localObject3).getAuthority(), ((URL)localObject3).getFile()), (Drawable)localObject2, (Drawable)localObject2);
      if (localObject2 != null) {
        localImageView.setImageDrawable((Drawable)localObject2);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
      }
    }
    localObject2 = (TextView)paramView.findViewById(2131300667);
    ((TextView)localObject2).setText((CharSequence)localObject1);
    if (paramClassifyItem.jdField_a_of_type_Int == this.E)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130840161);
      this.G = paramClassifyItem.jdField_b_of_type_Int;
    }
    paramView.setTag(new NearbyTroopsView.DataTag(this, 5, paramClassifyItem));
    paramView.setOnClickListener(this);
    if (AppSetting.j) {
      paramView.setContentDescription(String.format(a().getString(2131364986), new Object[] { localObject1 }));
    }
    paramView.setLayoutParams(new LinearLayout.LayoutParams(paramInt, -2));
  }
  
  private static String b(Reader paramReader)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i1 = paramReader.read();
      if (i1 == -1) {
        break;
      }
      localStringBuilder.append((char)i1);
    }
    return localStringBuilder.toString();
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        SharedPreferences.Editor localEditor = a().getSharedPreferences("nearby_group_classify_sp", 0).edit();
        localEditor.putString("nearby_group_classify_content", paramString);
        localEditor.commit();
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("NearbyTroopsActivity", 2, "storeClassifyData===>Exception");
  }
  
  private void c(String paramString)
  {
    n();
    ThreadManager.a(new vfb(this, paramString, a().getSharedPreferences("nearby_group_classify_sp", 0).getLong("nearby_group_classify_last_modify_time", 0L)), 5, null, true);
  }
  
  private void n()
  {
    if (this.jdField_d_of_type_Boolean) {}
    while (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_b_of_type_AndroidWidgetImageView.getDrawable();
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
  }
  
  private void o()
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public int a()
  {
    return this.E;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getPreferences().getLong("near_troop_last_refresh_time", 0L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    label341:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramInt2 == -1)
          {
            j();
            return;
            if ((paramInt2 != -1) || (paramIntent == null)) {
              break label341;
            }
            paramIntent = paramIntent.getStringExtra("data");
            if (TextUtils.isEmpty(paramIntent))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Close_more", 0, 0, "", "", "", "");
              if (QLog.isColorLevel()) {
                QLog.d("NearbyTroopsActivity", 2, "onActivityResult, data empty");
              }
            }
            else
            {
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("NearbyTroopsActivity", 2, "onActivityResult, data:" + paramIntent);
                }
                paramIntent = new JSONObject(paramIntent);
                NearbyTroopsView.ClassifyItem localClassifyItem = new NearbyTroopsView.ClassifyItem();
                localClassifyItem.jdField_a_of_type_Int = paramIntent.getInt("cid");
                localClassifyItem.jdField_a_of_type_JavaLangString = paramIntent.getString("icon_url");
                localClassifyItem.jdField_b_of_type_JavaLangString = paramIntent.getString("jump_url");
                localClassifyItem.jdField_c_of_type_JavaLangString = paramIntent.getString("wording");
                localClassifyItem.jdField_c_of_type_Int = paramIntent.getInt("type");
                if (this.jdField_e_of_type_AndroidViewView != null)
                {
                  paramInt1 = this.jdField_e_of_type_AndroidViewView.getVisibility();
                  a(localClassifyItem, this.jdField_e_of_type_AndroidViewView, this.l);
                  this.jdField_e_of_type_AndroidViewView.setVisibility(0);
                  this.jdField_e_of_type_AndroidViewView.performClick();
                  if ((paramInt1 == 8) && (this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.getChildAt(0) != null))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.scrollBy(this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.getChildAt(0).getWidth(), 0);
                    return;
                  }
                }
              }
              catch (Exception paramIntent) {}
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("NearbyTroopsActivity", 2, "onActivityResult-REQUEST_FOR_TROOP_TYPE_SELECT:" + paramIntent.toString());
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Close_more", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("NearbyTroopsActivity", 2, "onActivityResult, !(resultCode == Activity.RESULT_OK && data != null)");
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getPreferences().edit().putLong("near_troop_last_refresh_time", paramLong).commit();
  }
  
  public void a(RspActivity paramRspActivity)
  {
    if (paramRspActivity == null) {}
    for (;;)
    {
      return;
      Object localObject1 = new nearby_troop_activity.RspBody();
      try
      {
        localObject1 = (nearby_troop_activity.RspBody)((nearby_troop_activity.RspBody)localObject1).mergeFrom(paramRspActivity.strRspAct);
        if (((nearby_troop_activity.RspBody)localObject1).has())
        {
          Object localObject2 = ((nearby_troop_activity.RspBody)localObject1).rpt_activity;
          if ((localObject2 != null) && (((PBRepeatMessageField)localObject2).has()))
          {
            localObject2 = ((PBRepeatMessageField)localObject2).get();
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = (nearby_troop_activity.ActivityDigest)((List)localObject2).get(0);
              if (localObject2 != null)
              {
                GroupAreaWrapper.ActivityInfo localActivityInfo = new GroupAreaWrapper.ActivityInfo(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
                localActivityInfo.address = ((nearby_troop_activity.ActivityDigest)localObject2).str_loc_name.get();
                localActivityInfo.desc = ((nearby_troop_activity.RspBody)localObject1).str_wording.get();
                localActivityInfo.distance = ((nearby_troop_activity.ActivityDigest)localObject2).uint32_distance.get();
                localActivityInfo.number = ((int)((nearby_troop_activity.ActivityDigest)localObject2).uint64_enroll.get());
                localActivityInfo.title = ((nearby_troop_activity.ActivityDigest)localObject2).str_name.get();
                localActivityInfo.type = ((nearby_troop_activity.RspBody)localObject1).str_title.get();
                localActivityInfo.image_url = ((nearby_troop_activity.ActivityDigest)localObject2).str_cover_url.get();
                localActivityInfo.title_url = ((nearby_troop_activity.RspBody)localObject1).str_url_list.get();
                localActivityInfo.desc_url = ((nearby_troop_activity.ActivityDigest)localObject2).str_url_info.get();
                localObject1 = new GroupAreaWrapper(localActivityInfo);
                if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramRspActivity.shShowPos)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(paramRspActivity.shShowPos, localObject1);
                  return;
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramRspActivity) {}
    }
  }
  
  public void a(RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    if ((paramRspGetNearbyGroup == null) || (paramRspGetNearbyGroup.stRspHotGrp == null))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    nearby_troop_hot.HotQunMsg localHotQunMsg = new nearby_troop_hot.HotQunMsg();
    try
    {
      localHotQunMsg.mergeFrom(paramRspGetNearbyGroup.stRspHotGrp.strRspHotGrp);
      if ((localHotQunMsg == null) || (!localHotQunMsg.msg_rsp_body.has()))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
        return;
      }
    }
    catch (Exception paramRspGetNearbyGroup)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    if ((localHotQunMsg.msg_rsp_body.ret_info == null) || (!localHotQunMsg.msg_rsp_body.ret_info.has()) || (localHotQunMsg.msg_rsp_body.qun_info == null) || (!localHotQunMsg.msg_rsp_body.qun_info.has()))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    if (((nearby_troop_hot.RetInfo)localHotQunMsg.msg_rsp_body.ret_info.get()).ret_code.get() != 0)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      return;
    }
    paramRspGetNearbyGroup = (nearby_troop_hot.QunInfo)localHotQunMsg.msg_rsp_body.qun_info.get();
    a(paramRspGetNearbyGroup.title.get(), paramRspGetNearbyGroup.desc.get(), paramRspGetNearbyGroup.url.get());
  }
  
  public void a(RspTopic paramRspTopic)
  {
    if (paramRspTopic == null) {}
    for (;;)
    {
      return;
      Object localObject = new nearby_troop_post.RspBody();
      try
      {
        ((nearby_troop_post.RspBody)localObject).mergeFrom(paramRspTopic.strRspTopic);
        if (!((nearby_troop_post.RspBody)localObject).has()) {
          continue;
        }
        localObject = ((nearby_troop_post.RspBody)localObject).msg_subcmd0x1_rsp_nearbypostinfo;
        if ((localObject == null) || (!((nearby_troop_post.RspNearbyPostInfo)localObject).has())) {
          continue;
        }
        GroupAreaWrapper.TopicInfo localTopicInfo = new GroupAreaWrapper.TopicInfo(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
        localTopicInfo.address = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_address.get();
        localTopicInfo.desc = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_desc.get();
        localTopicInfo.distance = ((nearby_troop_post.RspNearbyPostInfo)localObject).uint32_distance.get();
        localTopicInfo.number = ((nearby_troop_post.RspNearbyPostInfo)localObject).uint32_post_replys.get();
        localTopicInfo.title = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_title.get();
        localTopicInfo.type = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_title.get();
        localTopicInfo.image_url = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_picture_url.get();
        localTopicInfo.desc_url = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_post_url.get();
        localTopicInfo.title_url = ((nearby_troop_post.RspNearbyPostInfo)localObject).str_title_url.get();
        localObject = new GroupAreaWrapper(localTopicInfo);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramRspTopic.shShowPos)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramRspTopic.shShowPos, localObject);
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    a(false, paramIntent);
  }
  
  public void a(Intent paramIntent, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    super.a(paramIntent, paramINearbyTroopContext);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) {
      return;
    }
    a(true, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c(this.E);
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    this.jdField_d_of_type_JavaLangString = paramString3;
    if (!this.jdField_g_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    l();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(true));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "hot", "exp", 0, 0, "", "", "", "");
  }
  
  /* Error */
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 927	java/io/ObjectOutputStream
    //   9: dup
    //   10: new 929	java/io/BufferedOutputStream
    //   13: dup
    //   14: aload_0
    //   15: getfield 236	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext	Lcom/tencent/mobileqq/troop/activity/NearbyTroopsBaseView$INearbyTroopContext;
    //   18: invokeinterface 930 1 0
    //   23: ldc 53
    //   25: iconst_0
    //   26: invokevirtual 934	android/app/Activity:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   29: invokespecial 937	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: invokespecial 938	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 4
    //   37: aload 4
    //   39: astore 5
    //   41: aload 4
    //   43: aload_1
    //   44: invokevirtual 941	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   47: aload 4
    //   49: astore 5
    //   51: aload 4
    //   53: iload_2
    //   54: invokevirtual 944	java/io/ObjectOutputStream:writeInt	(I)V
    //   57: aload 4
    //   59: astore 5
    //   61: aload 4
    //   63: iload_3
    //   64: invokevirtual 944	java/io/ObjectOutputStream:writeInt	(I)V
    //   67: aload 4
    //   69: astore 5
    //   71: aload 4
    //   73: invokevirtual 947	java/io/ObjectOutputStream:flush	()V
    //   76: aload 4
    //   78: ifnull +8 -> 86
    //   81: aload 4
    //   83: invokevirtual 950	java/io/ObjectOutputStream:close	()V
    //   86: return
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 951	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: astore_1
    //   94: aconst_null
    //   95: astore 4
    //   97: aload 4
    //   99: astore 5
    //   101: aload_1
    //   102: invokevirtual 952	java/io/FileNotFoundException:printStackTrace	()V
    //   105: aload 4
    //   107: ifnull -21 -> 86
    //   110: aload 4
    //   112: invokevirtual 950	java/io/ObjectOutputStream:close	()V
    //   115: return
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 951	java/io/IOException:printStackTrace	()V
    //   121: return
    //   122: astore 4
    //   124: aload 6
    //   126: astore_1
    //   127: aload_1
    //   128: astore 5
    //   130: aload 4
    //   132: invokevirtual 951	java/io/IOException:printStackTrace	()V
    //   135: aload_1
    //   136: ifnull -50 -> 86
    //   139: aload_1
    //   140: invokevirtual 950	java/io/ObjectOutputStream:close	()V
    //   143: return
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 951	java/io/IOException:printStackTrace	()V
    //   149: return
    //   150: astore_1
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 950	java/io/ObjectOutputStream:close	()V
    //   161: aload_1
    //   162: athrow
    //   163: astore 4
    //   165: aload 4
    //   167: invokevirtual 951	java/io/IOException:printStackTrace	()V
    //   170: goto -9 -> 161
    //   173: astore_1
    //   174: goto -23 -> 151
    //   177: astore 5
    //   179: aload 4
    //   181: astore_1
    //   182: aload 5
    //   184: astore 4
    //   186: goto -59 -> 127
    //   189: astore_1
    //   190: goto -93 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	NearbyTroopsView
    //   0	193	1	paramArrayList	ArrayList
    //   0	193	2	paramInt1	int
    //   0	193	3	paramInt2	int
    //   35	76	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   122	9	4	localIOException1	java.io.IOException
    //   163	17	4	localIOException2	java.io.IOException
    //   184	1	4	localIOException3	java.io.IOException
    //   1	156	5	localObject1	Object
    //   177	6	5	localIOException4	java.io.IOException
    //   4	121	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   81	86	87	java/io/IOException
    //   6	37	93	java/io/FileNotFoundException
    //   110	115	116	java/io/IOException
    //   6	37	122	java/io/IOException
    //   139	143	144	java/io/IOException
    //   6	37	150	finally
    //   130	135	150	finally
    //   156	161	163	java/io/IOException
    //   41	47	173	finally
    //   51	57	173	finally
    //   61	67	173	finally
    //   71	76	173	finally
    //   101	105	173	finally
    //   41	47	177	java/io/IOException
    //   51	57	177	java/io/IOException
    //   61	67	177	java/io/IOException
    //   71	76	177	java/io/IOException
    //   41	47	189	java/io/FileNotFoundException
    //   51	57	189	java/io/FileNotFoundException
    //   61	67	189	java/io/FileNotFoundException
    //   71	76	189	java/io/FileNotFoundException
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView == null)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessageDelayed(3, 800L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      a(System.currentTimeMillis());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131368597));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.H();
  }
  
  public void a(boolean paramBoolean, Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (paramBoolean)
    {
      a(2130903673);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, false));
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903674, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131299676));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView = ((NearbyTroopsExpandableListView)findViewById(2131299674));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131299680));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131299682));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131299683));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131299675));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView = this.jdField_d_of_type_AndroidViewView.findViewById(2131298331);
      ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131300896)).setText(2131364989);
      this.jdField_d_of_type_AndroidViewView.findViewById(2131304828).setBackgroundResource(2130837958);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidViewView.findViewById(2131300895));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_d_of_type_AndroidViewView.findViewById(2131300876).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setContentBackground(2130837958);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOverScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a_(this.jdField_d_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (jdField_f_of_type_Boolean) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription("");
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(Boolean.valueOf(false));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new vex(this));
      if (this.jdField_g_of_type_Int == 10) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b(this.jdField_a_of_type_AndroidContentContext.getString(2131367975));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setLongClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout = ((HorizontalScrollLayout)this.jdField_d_of_type_AndroidViewView.findViewById(2131299678));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131299679));
      this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout.getViewTreeObserver().addOnGlobalLayoutListener(new vey(this));
    }
    String str = paramIntent.getStringExtra("config_res_plugin_item_name");
    paramIntent = str;
    if (this.D == 1)
    {
      paramIntent = str;
      if (!TextUtils.isEmpty(this.r)) {
        paramIntent = this.r;
      }
    }
    if (!TextUtils.isEmpty(paramIntent)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(paramIntent);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter = new NearbyTroopsExpandableListViewAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler, this, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a(54, 54);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setOnGroupClickListener(new vez(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setGroupIndicator(null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(2131367336, -1);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a()) {
      a(true, this.F, this.E, false);
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
    {
      if (!this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessageDelayed(2, 1000L);
      return false;
    }
    if (paramInt2 == 0) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.removeMessages(3);
      if (this.D == 1) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramBoolean1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt1, this.r, paramInt2);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyTroopsActivity.data", 2, "updateTroopList: isFirst=" + paramBoolean1 + ", lat=" + this.jdField_c_of_type_Int + ", lon=" + this.jdField_d_of_type_Int + ", sortType=" + paramInt1 + ", mLocationName=" + this.r + ", iFilterId=" + paramInt2 + ", mMode=" + this.D);
        }
        return true;
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramBoolean1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt1, null, paramInt2);
      }
    }
  }
  
  public boolean a(boolean paramBoolean, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
    if ((this.jdField_a_of_type_AndroidContentContext instanceof NearbyTroopsActivity)) {
      this.jdField_b_of_type_Int = ((NearbyTroopsActivity)this.jdField_a_of_type_AndroidContentContext).r;
    }
    this.i = false;
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler = new NearbyTroopsView.UIHandler(this, this);
    }
    if (paramIntent != null) {}
    for (;;)
    {
      this.D = paramIntent.getIntExtra("mode", 0);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("lat", 0);
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("lon", 0);
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("from", 0);
      this.E = paramIntent.getIntExtra("selectedIndex", 0);
      String str1 = paramIntent.getStringExtra("options");
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        Object localObject = new JSONObject(str1);
        str1 = ((JSONObject)localObject).optString("selectedIndex");
        String str2 = ((JSONObject)localObject).optString("lon");
        String str3 = ((JSONObject)localObject).optString("lat");
        localObject = ((JSONObject)localObject).optString("subSourceId");
        if (!TextUtils.isEmpty(str1)) {
          this.E = Integer.parseInt(str1);
        }
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
        {
          this.jdField_c_of_type_Int = Integer.parseInt(str3);
          this.jdField_d_of_type_Int = Integer.parseInt(str2);
          this.jdField_e_of_type_Boolean = false;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_h_of_type_Int = Integer.parseInt((String)localObject);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        a(paramBoolean, paramIntent);
        if (!paramBoolean) {
          break label354;
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendEmptyMessage(6);
      }
      if (this.E != 0) {
        this.F = 4;
      }
      if (this.D != 1) {
        break;
      }
      this.r = paramIntent.getStringExtra("location_name");
      if (this.r != null) {
        break;
      }
      i();
      return true;
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().getIntent();
    }
    label354:
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.a();
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  public void j() {}
  
  /* Error */
  public void k()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 1194	java/io/ObjectInputStream
    //   5: dup
    //   6: new 1196	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: getfield 356	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   14: ldc 53
    //   16: invokevirtual 1200	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   19: invokespecial 1203	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 1204	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_2
    //   30: aload 4
    //   32: invokevirtual 1208	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   35: checkcast 227	java/util/ArrayList
    //   38: astore_3
    //   39: aload 4
    //   41: astore_2
    //   42: aload 4
    //   44: invokevirtual 1211	java/io/ObjectInputStream:readInt	()I
    //   47: pop
    //   48: aload 4
    //   50: astore_2
    //   51: aload 4
    //   53: invokevirtual 1211	java/io/ObjectInputStream:readInt	()I
    //   56: pop
    //   57: aload_3
    //   58: astore_1
    //   59: aload 4
    //   61: ifnull +10 -> 71
    //   64: aload 4
    //   66: invokevirtual 1212	java/io/ObjectInputStream:close	()V
    //   69: aload_3
    //   70: astore_1
    //   71: aload_1
    //   72: astore_2
    //   73: aload_1
    //   74: ifnonnull +11 -> 85
    //   77: new 227	java/util/ArrayList
    //   80: dup
    //   81: invokespecial 1213	java/util/ArrayList:<init>	()V
    //   84: astore_2
    //   85: aload_2
    //   86: invokevirtual 231	java/util/ArrayList:size	()I
    //   89: ifne +108 -> 197
    //   92: return
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 951	java/io/IOException:printStackTrace	()V
    //   98: aload_3
    //   99: astore_1
    //   100: goto -29 -> 71
    //   103: astore_3
    //   104: aconst_null
    //   105: astore 4
    //   107: aload 4
    //   109: astore_2
    //   110: invokestatic 387	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +42 -> 155
    //   116: aload 4
    //   118: astore_2
    //   119: ldc 31
    //   121: iconst_2
    //   122: new 130	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 1215
    //   132: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 1218	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 610	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aload 4
    //   150: astore_2
    //   151: aload_3
    //   152: invokevirtual 1176	java/lang/Exception:printStackTrace	()V
    //   155: aload 4
    //   157: ifnull +89 -> 246
    //   160: aload 4
    //   162: invokevirtual 1212	java/io/ObjectInputStream:close	()V
    //   165: goto -94 -> 71
    //   168: astore_2
    //   169: aload_2
    //   170: invokevirtual 951	java/io/IOException:printStackTrace	()V
    //   173: goto -102 -> 71
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_2
    //   180: ifnull +7 -> 187
    //   183: aload_2
    //   184: invokevirtual 1212	java/io/ObjectInputStream:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: astore_2
    //   190: aload_2
    //   191: invokevirtual 951	java/io/IOException:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: aload_2
    //   198: iconst_0
    //   199: invokevirtual 1219	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   202: instanceof 763
    //   205: ifeq -113 -> 92
    //   208: aload_0
    //   209: iconst_1
    //   210: putfield 233	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_h_of_type_Boolean	Z
    //   213: aload_0
    //   214: getfield 591	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter	Lcom/tencent/mobileqq/troop/data/NearbyTroopsExpandableListViewAdapter;
    //   217: aload_2
    //   218: invokevirtual 1222	com/tencent/mobileqq/troop/data/NearbyTroopsExpandableListViewAdapter:a	(Ljava/util/ArrayList;)V
    //   221: aload_0
    //   222: getfield 970	com/tencent/mobileqq/troop/activity/NearbyTroopsView:jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView	Lcom/tencent/mobileqq/troop/widget/NearbyTroopsExpandableListView;
    //   225: iconst_1
    //   226: invokevirtual 1110	com/tencent/mobileqq/troop/widget/NearbyTroopsExpandableListView:a	(Z)V
    //   229: return
    //   230: astore_1
    //   231: goto -52 -> 179
    //   234: astore_3
    //   235: goto -128 -> 107
    //   238: astore_2
    //   239: aload_3
    //   240: astore_1
    //   241: aload_2
    //   242: astore_3
    //   243: goto -136 -> 107
    //   246: goto -175 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	NearbyTroopsView
    //   1	73	1	localObject1	Object
    //   93	2	1	localIOException1	java.io.IOException
    //   99	1	1	localObject2	Object
    //   176	12	1	localObject3	Object
    //   230	1	1	localObject4	Object
    //   240	1	1	localObject5	Object
    //   29	122	2	localObject6	Object
    //   168	2	2	localIOException2	java.io.IOException
    //   178	6	2	localObject7	Object
    //   189	29	2	localIOException3	java.io.IOException
    //   238	4	2	localException1	Exception
    //   38	61	3	localArrayList	ArrayList
    //   103	49	3	localException2	Exception
    //   234	6	3	localException3	Exception
    //   242	1	3	localException4	Exception
    //   25	136	4	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   64	69	93	java/io/IOException
    //   2	27	103	java/lang/Exception
    //   160	165	168	java/io/IOException
    //   2	27	176	finally
    //   183	187	189	java/io/IOException
    //   30	39	230	finally
    //   42	48	230	finally
    //   51	57	230	finally
    //   110	116	230	finally
    //   119	148	230	finally
    //   151	155	230	finally
    //   30	39	234	java/lang/Exception
    //   42	48	238	java/lang/Exception
    //   51	57	238	java/lang/Exception
  }
  
  public void l()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (this.k)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838316);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838312);
  }
  
  public void m()
  {
    if ((this.D == 1) && (this.jdField_g_of_type_Int != 23)) {
      a(true, this.F, this.E, true);
    }
    for (;;)
    {
      Object localObject = a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_d_of_type_Boolean = true;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout, (JSONObject)localObject);
        c("http://qun.qq.com/search/mobileqq/nearbyGroupClassify.json");
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(16, new Bundle(), new vew(this));
        return;
        k();
        a(true, this.F, this.E, true);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyTroopsActivity", 2, "initData==>JSONException");
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject3;
    label657:
    do
    {
      do
      {
        return;
        switch (paramView.getId())
        {
        }
        for (;;)
        {
          if (paramView.getId() != 2131299683) {
            break label657;
          }
          TroopCreateEnterActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), 2, 51);
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Clk_banner", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo == null) {
            break;
          }
          Object localObject1;
          switch (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.uint32_jump_type.get())
          {
          default: 
            break;
          case 1: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_web_banner.has())
            {
              localObject1 = (nearbybanner.WebBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_web_banner.get();
              if (((nearbybanner.WebBanner)localObject1).bytes_jump_url.has())
              {
                localObject1 = ((nearbybanner.WebBanner)localObject1).bytes_jump_url.get().toStringUtf8();
                localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                ((Intent)localObject3).putExtra("url", (String)localObject1);
                ((Intent)localObject3).putExtra("hide_left_button", true);
                ((Intent)localObject3).putExtra("show_right_close_button", true);
                ((Intent)localObject3).putExtra("finish_animation_up_down", true);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
              }
            }
            break;
          case 5: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_search_banner.has())
            {
              localObject1 = (nearbybanner.SearchBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_search_banner.get();
              if (((nearbybanner.SearchBanner)localObject1).bytes_search_keyword.has())
              {
                localObject3 = ((nearbybanner.SearchBanner)localObject1).bytes_search_keyword.get().toStringUtf8();
                localObject1 = "http://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&_wv=4194304&keyword=" + URLEncoder.encode((String)localObject3) + "&_bid=165";
                if (QLog.isColorLevel()) {
                  QLog.d("NearbyTroopsActivity", 2, "lastKeywords = " + (String)localObject3 + " jump url is : " + (String)localObject1);
                }
                localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                ((Intent)localObject3).putExtra("url", (String)localObject1);
                ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a());
                ((Intent)localObject3).putExtra("portraitOnly", true);
                ((Intent)localObject3).putExtra("hide_more_button", true);
                ((Intent)localObject3).putExtra("hide_operation_bar", true);
                ((Intent)localObject3).putExtra("isShowAd", false);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
              }
            }
            break;
          case 2: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_create_banner.has())
            {
              localObject1 = (nearbybanner.CreateGroupBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_create_banner.get();
              if (((nearbybanner.CreateGroupBanner)localObject1).uint32_group_type.has())
              {
                ((nearbybanner.CreateGroupBanner)localObject1).uint32_group_type.get();
                TroopQQBrowserHelper.a(this.jdField_a_of_type_AndroidContentContext);
              }
            }
            break;
          case 3: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_recomm_banner.has())
            {
              localObject1 = (nearbybanner.RecommGroupBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_recomm_banner.get();
              if (((nearbybanner.RecommGroupBanner)localObject1).uint64_group_code.has())
              {
                localObject1 = TroopInfoActivity.a(String.valueOf(((nearbybanner.RecommGroupBanner)localObject1).uint64_group_code.get()), 2);
                ChatSettingForTroop.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
              }
            }
            break;
          case 4: 
            if (this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_set_banner.has())
            {
              localObject1 = (nearbybanner.SetGroupBanner)this.jdField_a_of_type_TencentImGroupNearbybannerNearbybanner$BannerInfo.msg_set_banner.get();
              if (((nearbybanner.SetGroupBanner)localObject1).uint64_group_code.has())
              {
                long l1 = ((nearbybanner.SetGroupBanner)localObject1).uint64_group_code.get();
                try
                {
                  localObject1 = TroopInfoActivity.a(Long.toString(l1), 3, 0, 0, 0, null);
                  TroopInfoActivity.a(a(), (Bundle)localObject1, 100);
                }
                catch (Exception localException) {}
              }
            }
            break;
          }
        }
      } while (!(paramView.getTag() instanceof NearbyTroopsView.DataTag));
      localObject2 = (NearbyTroopsView.DataTag)paramView.getTag();
      switch (((NearbyTroopsView.DataTag)localObject2).jdField_a_of_type_Int)
      {
      default: 
        return;
      case 4: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_back", 0, 0, "", "", "", "");
        SosoInterface.a(new vfc(this, 3, true, true, 60000L, false, false, "NearbyTroopsView"));
        return;
      }
    } while (!(((NearbyTroopsView.DataTag)localObject2).jdField_a_of_type_JavaLangObject instanceof NearbyTroopsView.ClassifyItem));
    Object localObject2 = (NearbyTroopsView.ClassifyItem)((NearbyTroopsView.DataTag)localObject2).jdField_a_of_type_JavaLangObject;
    paramView = (TextView)paramView.findViewById(2131300667);
    if (paramView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
      paramView.setBackgroundResource(2130840161);
      this.jdField_b_of_type_AndroidWidgetTextView = paramView;
    }
    if (((NearbyTroopsView.ClassifyItem)localObject2).jdField_c_of_type_Int == 1)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localObject3 = new StringBuilder(((NearbyTroopsView.ClassifyItem)localObject2).jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject3).append("&lat=").append(this.jdField_e_of_type_Int).append("&lon=").append(this.jdField_f_of_type_Int).append("&city=").append(this.jdField_e_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      paramView.putExtra("url", (String)localObject3);
      paramView.putExtra("key_isReadModeEnabled", true);
      PublicAccountUtil.a(paramView, (String)localObject3);
      if (((NearbyTroopsView.ClassifyItem)localObject2).jdField_a_of_type_Int == 99)
      {
        paramView.putExtra("finish_animation_up_down", true);
        paramView.putExtra("hide_left_button", true);
        paramView.putExtra("show_right_close_button", true);
        paramView.putExtra("title", this.jdField_a_of_type_AndroidContentContext.getString(2131367337));
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().startActivityForResult(paramView, 1000);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a().overridePendingTransition(2130968592, 2130968589);
      }
    }
    for (;;)
    {
      this.E = ((NearbyTroopsView.ClassifyItem)localObject2).jdField_a_of_type_Int;
      this.G = ((NearbyTroopsView.ClassifyItem)localObject2).jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c(this.E);
      }
      this.F = 4;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext == null) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), "P_CliOper", "Grp_nearby", "", "grp_tab", "Clk_grpcla", 0, 0, ((NearbyTroopsView.ClassifyItem)localObject2).jdField_a_of_type_Int + "", "", "", "");
      return;
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      continue;
      if (((NearbyTroopsView.ClassifyItem)localObject2).jdField_c_of_type_Int == 2) {
        a(true, 4, ((NearbyTroopsView.ClassifyItem)localObject2).jdField_a_of_type_Int, true);
      }
    }
  }
  
  public void setHasHotTroopRedDot(boolean paramBoolean)
  {
    this.k = paramBoolean;
    l();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\NearbyTroopsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */