package com.tencent.biz;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.DPBiz;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.proto.lbsshare.LBSShare.Shop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import hej;
import hek;
import hel;
import hem;
import hen;
import heo;
import hep;
import heq;
import her;
import hes;
import het;
import heu;
import hev;
import hew;
import hex;
import hey;
import hez;
import hfa;
import hfb;
import hfc;
import hfd;
import hfe;
import hff;
import hfh;
import hfi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiMapActivity
  extends QQMapActivity
  implements View.OnClickListener
{
  protected float a;
  protected int a;
  public GestureDetector a;
  public View.OnClickListener a;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  protected View a;
  public final ViewTreeObserver.OnPreDrawListener a;
  public EditText a;
  protected ImageButton a;
  public ImageView a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected AuthorizeConfig a;
  protected PoiMapActivity.PoiMapNameTask a;
  PoiMapActivity.SearchResultAdapter jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter;
  public PoiMapActivity.ShopListAdapter a;
  protected AbsListView.OnScrollListener a;
  protected XListView a;
  public final String a;
  public List a;
  public boolean a;
  public PoiMapActivity.PoiTab[] a;
  public String[] a;
  protected int b;
  public View b;
  public ImageView b;
  public LinearLayout b;
  protected TextView b;
  XListView b;
  public String b;
  public boolean b;
  public String[] b;
  protected int c;
  protected View c;
  public String c;
  public boolean c;
  protected int d;
  public View d;
  protected String d;
  protected boolean d;
  protected int e;
  protected View e;
  public String e;
  public boolean e;
  protected int f;
  protected View f;
  public String f;
  protected boolean f;
  protected int g;
  View g;
  public boolean g;
  public int h;
  protected View h;
  protected boolean h;
  public int i;
  public View i;
  public boolean i;
  public int j;
  public boolean j;
  public int k;
  protected boolean k;
  public int l;
  protected final int m;
  protected final int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  protected int t;
  protected int u;
  public int v;
  public int w;
  
  public PoiMapActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "PoiMapActivity";
    this.jdField_b_of_type_Boolean = true;
    this.m = 10;
    this.n = 20;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_h_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new hfd(this);
    this.jdField_a_of_type_AndroidViewView$OnKeyListener = new hen(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new heo(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new heq(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new her(this);
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "全部", "写字楼", "小区", "商家" };
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramBoolean)
      {
        localLayoutParams.topMargin += paramInt;
        this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
        if (!paramBoolean) {
          break label129;
        }
        localLayoutParams.topMargin += paramInt;
        label72:
        this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
      if (this.jdField_e_of_type_AndroidViewView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
        if (!paramBoolean) {
          break label137;
        }
      }
    }
    label129:
    label137:
    for (localLayoutParams.topMargin += paramInt;; localLayoutParams.topMargin = (this.jdField_u_of_type_Int + paramInt - this.t))
    {
      this.jdField_e_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = paramInt;
      break;
      localLayoutParams.topMargin = paramInt;
      break label72;
    }
  }
  
  private void b(PoiMapActivity.POI paramPOI)
  {
    if (this.jdField_e_of_type_AndroidViewView == null) {}
    for (;;)
    {
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewView.findViewById(2131302704).setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(null);
      ImageView localImageView = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302704);
      localImageView.setVisibility(8);
      if ((paramPOI != null) && ((!TextUtils.isEmpty(paramPOI.g)) || (!TextUtils.isEmpty(paramPOI.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramPOI.jdField_e_of_type_JavaLangString))))
      {
        ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302705)).setText(paramPOI.jdField_a_of_type_JavaLangString);
        ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302707)).setText(paramPOI.jdField_a_of_type_Int + "");
        Object localObject1 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302708);
        String str;
        if (!TextUtils.isEmpty(paramPOI.g))
        {
          ((TextView)localObject1).setText(super.getString(2131371137));
          localObject1 = paramPOI.g;
          str = "click_mall";
        }
        while (localObject1 != null)
        {
          Object localObject3 = "";
          Uri localUri = Uri.parse((String)localObject1);
          Object localObject2 = localObject3;
          if (localUri != null)
          {
            localObject2 = localObject3;
            if (localUri.isHierarchical()) {
              localObject2 = localUri.getQueryParameter("shop_id");
            }
          }
          if (((String)localObject1).equals(paramPOI.g)) {
            a("share_locate", "view_mall", paramPOI.jdField_c_of_type_JavaLangString, (String)localObject2, "0", "");
          }
          if (!TextUtils.isEmpty(paramPOI.i))
          {
            localObject3 = getResources().getDrawable(2130839495);
            int i1 = getResources().getDimensionPixelSize(2131493272);
            int i2 = getResources().getDimensionPixelSize(2131493273);
            localObject3 = URLDrawable.getDrawable(paramPOI.i, i1, i2, null, (Drawable)localObject3);
            if (localObject3 != null)
            {
              localImageView.setImageDrawable((Drawable)localObject3);
              localImageView.setVisibility(0);
            }
          }
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(new hej(this, (String)localObject1, str, paramPOI, (String)localObject2));
          return;
          if (!TextUtils.isEmpty(paramPOI.jdField_d_of_type_JavaLangString))
          {
            ((TextView)localObject1).setText(super.getString(2131371138));
            localObject1 = paramPOI.jdField_d_of_type_JavaLangString;
            str = "click_share_tuan";
          }
          else if (!TextUtils.isEmpty(paramPOI.jdField_e_of_type_JavaLangString))
          {
            ((TextView)localObject1).setText(super.getString(2131371139));
            localObject1 = paramPOI.jdField_e_of_type_JavaLangString;
            str = "click_quan";
          }
          else
          {
            str = null;
            localObject1 = null;
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131302689));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131298720);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131302691);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131302712);
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    Object localObject = super.findViewById(2131302700);
    ((View)localObject).setContentDescription(getString(2131364975));
    ((View)localObject).setVisibility(0);
    ((View)localObject).setOnClickListener(this);
    if (this.jdField_l_of_type_Boolean)
    {
      a("rec_locate", "pageview_all", "", "", "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_j_of_type_AndroidViewView.findViewById(2131298389).setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.findViewById(2131298390).setVisibility(0);
      ((View)localObject).setVisibility(8);
      if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_p_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getUiSettings().setLogoPosition(2);
      if (!"group_activity".equals(this.jdField_u_of_type_JavaLangString))
      {
        i();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setOnTouchListener(new heu(this));
      }
    }
    for (;;)
    {
      this.jdField_g_of_type_AndroidViewView = super.findViewById(2131297123);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302694));
      super.findViewById(2131300876).setVisibility(8);
      localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131300895);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      g();
      if (!"group_activity".equals(this.jdField_u_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new hfb(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setOnTouchListener(new hfc(this));
        this.jdField_i_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131302692);
        this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab == null) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length)) {
      return;
    }
    this.jdField_l_of_type_Int = paramInt;
    int i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i1 = 0;
    label30:
    if (i1 < i2)
    {
      if (i1 != paramInt) {
        break label67;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(true);
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].b(true);
    }
    for (;;)
    {
      i1 += 1;
      break label30;
      break;
      label67:
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareShop");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("coordinate", 0);
    localIntent.putExtra("begin", paramInt3);
    localIntent.putExtra("count", paramInt4);
    super.sendBroadcast(localIntent);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareSearch");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("category", paramString2);
    localIntent.putExtra("page", paramInt3);
    localIntent.putExtra("count", paramInt4);
    localIntent.putExtra("coordinate", 1);
    if ((paramInt3 == 0) && (TextUtils.isEmpty(paramString1))) {
      if (TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra("requireMyLbs", 1);
      }
    }
    for (;;)
    {
      super.sendBroadcast(localIntent);
      return;
      localIntent.putExtra("requireMyLbs", 0);
    }
  }
  
  public void a(PoiMapActivity.POI paramPOI)
  {
    this.jdField_q_of_type_JavaLangString = paramPOI.jdField_b_of_type_JavaLangString;
    this.jdField_p_of_type_JavaLangString = paramPOI.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_h_of_type_Int = paramPOI.jdField_b_of_type_Int;
    this.jdField_i_of_type_Int = paramPOI.jdField_c_of_type_Int;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_k_of_type_Int = this.jdField_i_of_type_Int;
    this.jdField_r_of_type_JavaLangString = paramPOI.jdField_f_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_Boolean = true;
    int i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(false);
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(-1, false);
      }
    }
    a(0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(new GeoPoint(paramPOI.jdField_b_of_type_Int, paramPOI.jdField_c_of_type_Int));
  }
  
  protected void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp)
  {
    if (paramGetShopsByIdsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetShareShopDetail null");
      }
    }
    int i1;
    label121:
    label147:
    label173:
    label199:
    label225:
    label251:
    label277:
    label304:
    label332:
    label383:
    label389:
    label395:
    label401:
    label407:
    label413:
    label419:
    label425:
    label431:
    do
    {
      do
      {
        return;
        i1 = paramGetShopsByIdsResp.ec.get();
        if (i1 != 0) {
          break;
        }
      } while (!paramGetShopsByIdsResp.shops.has());
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramGetShopsByIdsResp.shops.get().iterator();
      if (localIterator.hasNext())
      {
        LBSShare.DPBiz localDPBiz = (LBSShare.DPBiz)localIterator.next();
        PoiMapActivity.SingleShops localSingleShops = new PoiMapActivity.SingleShops(this);
        localSingleShops.jdField_a_of_type_Int = 1;
        if (localDPBiz.id.has())
        {
          paramGetShopsByIdsResp = localDPBiz.id.get();
          localSingleShops.h = paramGetShopsByIdsResp;
          if (!localDPBiz.name.has()) {
            break label383;
          }
          paramGetShopsByIdsResp = localDPBiz.name.get();
          localSingleShops.jdField_e_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.logo.has()) {
            break label389;
          }
          paramGetShopsByIdsResp = localDPBiz.logo.get();
          localSingleShops.jdField_f_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.url.has()) {
            break label395;
          }
          paramGetShopsByIdsResp = localDPBiz.url.get();
          localSingleShops.g = paramGetShopsByIdsResp;
          if (!localDPBiz.avg_price.has()) {
            break label401;
          }
          paramGetShopsByIdsResp = localDPBiz.avg_price.get();
          localSingleShops.jdField_b_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.biz_zone.has()) {
            break label407;
          }
          paramGetShopsByIdsResp = localDPBiz.biz_zone.get();
          localSingleShops.jdField_c_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.category.has()) {
            break label413;
          }
          paramGetShopsByIdsResp = localDPBiz.category.get();
          localSingleShops.jdField_a_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (!localDPBiz.has_quan.has()) {
            break label419;
          }
          i1 = localDPBiz.has_quan.get();
          localSingleShops.jdField_c_of_type_Int = i1;
          if (!localDPBiz.has_tuan.has()) {
            break label425;
          }
          i1 = localDPBiz.has_tuan.get();
          localSingleShops.jdField_b_of_type_Int = i1;
          if (!localDPBiz.rate.has()) {
            break label431;
          }
        }
        for (i1 = localDPBiz.rate.get();; i1 = 0)
        {
          localSingleShops.jdField_d_of_type_Int = i1;
          localArrayList.add(localSingleShops);
          break;
          paramGetShopsByIdsResp = "";
          break label121;
          paramGetShopsByIdsResp = "";
          break label147;
          paramGetShopsByIdsResp = "";
          break label173;
          paramGetShopsByIdsResp = "";
          break label199;
          paramGetShopsByIdsResp = "";
          break label225;
          paramGetShopsByIdsResp = "";
          break label251;
          paramGetShopsByIdsResp = "";
          break label277;
          i1 = 0;
          break label304;
          i1 = 0;
          break label332;
        }
      }
      a(localArrayList);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("PoiMapActivity", 2, "onGetShareShopDetail error:" + i1);
  }
  
  protected void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle)
  {
    if (paramLocationResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch null");
      }
      return;
    }
    int i6 = paramLocationResp.ec.get();
    boolean bool1;
    String str1;
    int i3;
    int i4;
    int i5;
    String str2;
    int i1;
    ArrayList localArrayList;
    if (paramLocationResp.is_foreign.get() == 1)
    {
      bool1 = true;
      this.jdField_j_of_type_Boolean = bool1;
      str1 = paramBundle.getString("keyword");
      i3 = paramBundle.getInt("latitude");
      i4 = paramBundle.getInt("longitude");
      i5 = paramBundle.getInt("page");
      str2 = paramBundle.getString("category");
      this.jdField_e_of_type_JavaLangString = paramBundle.getString("imei");
      this.jdField_f_of_type_JavaLangString = paramLocationResp.search_id.get();
      bool1 = false;
      if (i6 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch error:" + i6);
        }
        QQToast.a(this, super.getString(2131371160), 0).a();
      }
      i1 = 0;
      i2 = 0;
      paramBundle = null;
      if (i6 != 0) {
        break label1591;
      }
      localArrayList = new ArrayList();
      if (!this.jdField_j_of_type_Boolean) {
        break label923;
      }
      paramBundle = new GeoPoint(i3, i4);
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask != null) {
        break label779;
      }
    }
    for (;;)
    {
      Object localObject;
      LBSShare.POI localPOI1;
      PoiMapActivity.POI localPOI;
      try
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = new PoiMapActivity.PoiMapNameTask(this);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a(paramBundle);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
        paramBundle = new PoiMapActivity.POI(this);
        paramBundle.jdField_a_of_type_JavaLangString = super.getResources().getString(2131371167);
        paramBundle.jdField_b_of_type_JavaLangString = "";
        this.jdField_q_of_type_JavaLangString = paramBundle.jdField_b_of_type_JavaLangString;
        paramBundle.jdField_b_of_type_Int = i3;
        paramBundle.jdField_c_of_type_Int = i4;
        paramBundle.jdField_d_of_type_JavaLangString = "";
        localArrayList.add(paramBundle);
        i1 = 1;
        if (!paramLocationResp.poilist.has()) {
          break label1509;
        }
        paramBundle = paramLocationResp.poilist.get();
        if (paramBundle.size() <= 0) {
          break label1231;
        }
        i1 = 1;
        bool1 = true;
        localObject = paramBundle.iterator();
        i2 = i1;
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break label1516;
        }
        localPOI1 = (LBSShare.POI)((Iterator)localObject).next();
        localPOI = new PoiMapActivity.POI(this);
        if (!localPOI1.name.has()) {
          break label1240;
        }
        paramBundle = localPOI1.name.get();
        localPOI.jdField_a_of_type_JavaLangString = paramBundle;
        if (!localPOI1.addr.has()) {
          break label1246;
        }
        paramBundle = localPOI1.addr.get();
        localPOI.jdField_b_of_type_JavaLangString = paramBundle;
        if (!localPOI1.lat.has()) {
          break label1252;
        }
        i2 = localPOI1.lat.get();
        localPOI.jdField_b_of_type_Int = i2;
        if (!localPOI1.lng.has()) {
          break label1258;
        }
        i2 = localPOI1.lng.get();
        localPOI.jdField_c_of_type_Int = i2;
        if (!localPOI1.id.has()) {
          break label1264;
        }
        paramBundle = localPOI1.id.get();
        localPOI.jdField_c_of_type_JavaLangString = paramBundle;
        if (!"group_activity".equals(this.jdField_u_of_type_JavaLangString)) {
          break label1270;
        }
        localPOI.jdField_d_of_type_JavaLangString = "";
        localPOI.jdField_e_of_type_JavaLangString = "";
        localPOI.jdField_a_of_type_Int = 0;
        localPOI.g = "";
        localPOI.h = "";
        localPOI.i = "";
        localPOI.jdField_f_of_type_JavaLangString = "";
        if (!TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) {
          a("share_locate", "view_share_tuan", "", "", "", "");
        }
        if ((TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(localPOI.jdField_e_of_type_JavaLangString))) {
          a("share_locate", "view_quan", "", "", "", "");
        }
        if ((!this.jdField_d_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (!this.jdField_d_of_type_JavaLangString.equals(localPOI.jdField_c_of_type_JavaLangString))) {
          break label1499;
        }
        if (!localArrayList.isEmpty())
        {
          paramBundle = (PoiMapActivity.POI)localArrayList.get(0);
          if ((this.jdField_p_of_type_JavaLangString.equals(paramBundle.jdField_a_of_type_JavaLangString)) && (this.jdField_q_of_type_JavaLangString.equals(paramBundle.jdField_b_of_type_JavaLangString))) {
            localArrayList.remove(0);
          }
        }
        localArrayList.add(0, localPOI);
        continue;
        bool1 = false;
      }
      catch (RejectedExecutionException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
        continue;
      }
      label779:
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a = paramBundle;
      if (PlatformUtil.version() >= 11)
      {
        localObject = ((ThreadPoolExecutor)PoiMapActivity.PoiMapNameTask.THREAD_POOL_EXECUTOR).getQueue();
        if ((localObject != null) && (((BlockingQueue)localObject).size() > 0)) {
          ((BlockingQueue)localObject).removeAll((Collection)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.getStatus() != AsyncTask.Status.FINISHED)
      {
        if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.isCancelled()) {
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.cancel(true);
        }
      }
      else
      {
        try
        {
          localObject = new PoiMapActivity.PoiMapNameTask(this);
          ((PoiMapActivity.PoiMapNameTask)localObject).a(paramBundle);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = ((PoiMapActivity.PoiMapNameTask)localObject);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
        }
        catch (RejectedExecutionException paramBundle) {}
        if (QLog.isColorLevel())
        {
          QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
          continue;
          label923:
          i1 = i2;
          if (paramLocationResp.mylbs.has())
          {
            localObject = (LBSShare.POI)paramLocationResp.mylbs.get();
            localPOI = new PoiMapActivity.POI(this);
            if (((LBSShare.POI)localObject).name.has())
            {
              paramBundle = ((LBSShare.POI)localObject).name.get();
              label979:
              localPOI.jdField_a_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).shop_url.has()) {
                break label1180;
              }
              paramBundle = ((LBSShare.POI)localObject).shop_url.get();
              label1005:
              localPOI.jdField_d_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).addr.has()) {
                break label1186;
              }
              paramBundle = ((LBSShare.POI)localObject).addr.get();
              label1031:
              localPOI.jdField_b_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).lat.has()) {
                break label1192;
              }
              i1 = ((LBSShare.POI)localObject).lat.get();
              label1058:
              localPOI.jdField_b_of_type_Int = i1;
              if (!((LBSShare.POI)localObject).lng.has()) {
                break label1198;
              }
              i1 = ((LBSShare.POI)localObject).lng.get();
              label1086:
              localPOI.jdField_c_of_type_Int = i1;
              if ((!this.jdField_d_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString))) {
                break label1204;
              }
              localPOI.jdField_a_of_type_JavaLangString = this.jdField_p_of_type_JavaLangString;
              localPOI.jdField_d_of_type_JavaLangString = "";
              localPOI.jdField_b_of_type_JavaLangString = this.jdField_q_of_type_JavaLangString;
              localPOI.jdField_b_of_type_Int = this.jdField_h_of_type_Int;
              localPOI.jdField_c_of_type_Int = this.jdField_i_of_type_Int;
            }
            for (;;)
            {
              localArrayList.add(localPOI);
              i1 = 1;
              break;
              paramBundle = super.getResources().getString(2131371167);
              break label979;
              label1180:
              paramBundle = "";
              break label1005;
              label1186:
              paramBundle = "";
              break label1031;
              label1192:
              i1 = 0;
              break label1058;
              label1198:
              i1 = 0;
              break label1086;
              label1204:
              localPOI.jdField_a_of_type_JavaLangString = super.getResources().getString(2131371167);
              this.jdField_q_of_type_JavaLangString = localPOI.jdField_b_of_type_JavaLangString;
            }
            label1231:
            i1 = 0;
            bool1 = false;
            continue;
            label1240:
            paramBundle = "";
            continue;
            label1246:
            paramBundle = "";
            continue;
            label1252:
            i2 = 0;
            continue;
            label1258:
            i2 = 0;
            continue;
            label1264:
            paramBundle = "";
            continue;
            label1270:
            if (localPOI1.shop_url.has())
            {
              paramBundle = localPOI1.shop_url.get();
              label1290:
              localPOI.jdField_d_of_type_JavaLangString = paramBundle;
              if (!localPOI1.shop_url_quan.has()) {
                break label1463;
              }
              paramBundle = localPOI1.shop_url_quan.get();
              label1316:
              localPOI.jdField_e_of_type_JavaLangString = paramBundle;
              if (!localPOI1.shop_count.has()) {
                break label1469;
              }
              i2 = localPOI1.shop_count.get();
              label1343:
              localPOI.jdField_a_of_type_Int = i2;
              if (!localPOI1.shangquan_url.has()) {
                break label1475;
              }
              paramBundle = localPOI1.shangquan_url.get();
              label1370:
              localPOI.g = paramBundle;
              if (!localPOI1.shangquan_wording.has()) {
                break label1481;
              }
              paramBundle = localPOI1.shangquan_wording.get();
              label1396:
              localPOI.h = paramBundle;
              if (!localPOI1.POI_preview_url.has()) {
                break label1487;
              }
              paramBundle = localPOI1.POI_preview_url.get();
              label1422:
              localPOI.i = paramBundle;
              if (!localPOI1.dpid.has()) {
                break label1493;
              }
            }
            label1463:
            label1469:
            label1475:
            label1481:
            label1487:
            label1493:
            for (paramBundle = localPOI1.dpid.get();; paramBundle = "")
            {
              localPOI.jdField_f_of_type_JavaLangString = paramBundle;
              break;
              paramBundle = "";
              break label1290;
              paramBundle = "";
              break label1316;
              i2 = 0;
              break label1343;
              paramBundle = "";
              break label1370;
              paramBundle = "";
              break label1396;
              paramBundle = "";
              break label1422;
            }
            label1499:
            localArrayList.add(localPOI);
          }
        }
      }
    }
    label1509:
    boolean bool2 = false;
    int i2 = i1;
    label1516:
    if (paramLocationResp.next.has())
    {
      i1 = paramLocationResp.next.get();
      paramLocationResp = localArrayList;
      bool1 = bool2;
    }
    for (;;)
    {
      if (i2 == 0) {}
      for (bool2 = true;; bool2 = false)
      {
        runOnUiThread(new hep(this, bool1, str2, str1, paramLocationResp, i1, i3, i4, i5, bool2));
        return;
        i1 = 0;
        break;
      }
      label1591:
      i2 = 0;
      paramLocationResp = paramBundle;
    }
  }
  
  protected void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle)
  {
    if (paramNearByShopsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareShop null");
      }
    }
    int i1;
    label82:
    label115:
    label171:
    label197:
    label223:
    label249:
    label275:
    label301:
    label327:
    label353:
    label380:
    label431:
    label437:
    label443:
    label449:
    label455:
    label461:
    label467:
    label473:
    label479:
    label485:
    label491:
    label497:
    do
    {
      return;
      i1 = paramNearByShopsResp.ec.get();
      if (i1 == 0)
      {
        int i4 = paramBundle.getInt("begin", 0);
        int i2;
        LBSShare.Shop localShop;
        PoiMapActivity.GeneralShops localGeneralShops;
        if (paramNearByShopsResp.next_begin.has())
        {
          i1 = paramNearByShopsResp.next_begin.get();
          if (!paramNearByShopsResp.total.has()) {
            break label431;
          }
          i2 = paramNearByShopsResp.total.get();
          paramBundle = null;
          if (!paramNearByShopsResp.poilist.has()) {
            break label497;
          }
          paramBundle = new ArrayList();
          Iterator localIterator = paramNearByShopsResp.poilist.get().iterator();
          if (!localIterator.hasNext()) {
            break label497;
          }
          localShop = (LBSShare.Shop)localIterator.next();
          localGeneralShops = new PoiMapActivity.GeneralShops(this);
          localGeneralShops.jdField_a_of_type_Int = 1;
          if (!localShop.id.has()) {
            break label437;
          }
          paramNearByShopsResp = localShop.id.get();
          localGeneralShops.h = paramNearByShopsResp;
          if (!localShop.name.has()) {
            break label443;
          }
          paramNearByShopsResp = localShop.name.get();
          localGeneralShops.jdField_e_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.logo.has()) {
            break label449;
          }
          paramNearByShopsResp = localShop.logo.get();
          localGeneralShops.jdField_f_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.url.has()) {
            break label455;
          }
          paramNearByShopsResp = localShop.url.get();
          localGeneralShops.g = paramNearByShopsResp;
          if (!localShop.detail.has()) {
            break label461;
          }
          paramNearByShopsResp = localShop.detail.get();
          localGeneralShops.jdField_a_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.discount.has()) {
            break label467;
          }
          paramNearByShopsResp = localShop.discount.get();
          localGeneralShops.jdField_b_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.price.has()) {
            break label473;
          }
          paramNearByShopsResp = localShop.price.get();
          localGeneralShops.jdField_c_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.soldnum.has()) {
            break label479;
          }
          paramNearByShopsResp = localShop.soldnum.get();
          localGeneralShops.jdField_d_of_type_JavaLangString = paramNearByShopsResp;
          if (!localShop.has_tuan.has()) {
            break label485;
          }
          i3 = localShop.has_tuan.get();
          localGeneralShops.jdField_b_of_type_Int = i3;
          if (!localShop.has_quan.has()) {
            break label491;
          }
        }
        for (int i3 = localShop.has_quan.get();; i3 = 0)
        {
          localGeneralShops.jdField_c_of_type_Int = i3;
          paramBundle.add(localGeneralShops);
          break label115;
          i1 = 0;
          break;
          i2 = 0;
          break label82;
          paramNearByShopsResp = "";
          break label171;
          paramNearByShopsResp = "";
          break label197;
          paramNearByShopsResp = "";
          break label223;
          paramNearByShopsResp = "";
          break label249;
          paramNearByShopsResp = "";
          break label275;
          paramNearByShopsResp = "";
          break label301;
          paramNearByShopsResp = "";
          break label327;
          paramNearByShopsResp = "";
          break label353;
          i3 = 0;
          break label380;
        }
        a(paramBundle, i2, i4, i1);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PoiMapActivity", 2, "onGetLbsShareShop error:" + i1);
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    super.a(paramGeoPoint);
    if (!this.jdField_l_of_type_Boolean) {
      a("share_locate", "drag_location", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131371134));
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_o_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, paramString, "", 0, 20);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void a(String paramString, List paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_e_of_type_Boolean = paramBoolean;
      this.jdField_g_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label216;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131368078));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
      if (this.jdField_o_of_type_Int == 0) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        if (this.jdField_l_of_type_Boolean)
        {
          a("share_locate", "click_sch", paramString, "0", "", "");
          break;
        }
        a("share_locate", "click_sch", paramString, "0", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        break;
      }
      if (this.jdField_l_of_type_Boolean)
      {
        a("share_locate", "click_sch", paramString, "1", "", "");
        break;
      }
      a("share_locate", "click_sch", paramString, "1", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      break;
      label216:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, true, 0, 0, false);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.jdField_d_of_type_Int = 1;
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131371299));
    this.jdField_q_of_type_Int = super.getResources().getDimensionPixelSize(2131493276);
    j();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayList == null) {
      return;
    }
    boolean bool;
    if ((paramInt3 > 0) && (paramInt3 < paramInt1)) {
      bool = true;
    }
    for (;;)
    {
      if (paramInt2 == 0)
      {
        if ((paramInt1 <= 0) || (this.jdField_d_of_type_AndroidViewView == null)) {
          break;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131371133, new Object[] { String.valueOf(paramInt1) }));
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, true, paramInt2, paramInt3, bool);
        if (paramInt1 < 3)
        {
          this.jdField_q_of_type_Int = (super.getResources().getDimensionPixelSize(2131493276) * paramInt1);
          return;
          bool = false;
        }
        else
        {
          this.jdField_q_of_type_Int = this.jdField_p_of_type_Int;
          return;
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(paramArrayList, false, paramInt2, paramInt3, bool);
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((this.jdField_h_of_type_Int != paramInt1) && (this.jdField_i_of_type_Int != paramInt2)) {}
    label142:
    label159:
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          break label159;
        }
        if (this.jdField_b_of_type_ArrayOfJavaLangString[paramInt1].equals(paramString))
        {
          paramString = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[paramInt1];
          if (paramInt3 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramString.a(paramArrayList, bool, paramInt4, paramBoolean);
            if ((paramInt1 != 0) || (!this.jdField_h_of_type_Boolean)) {
              break;
            }
            if ((paramArrayList == null) || (paramArrayList.size() <= 1)) {
              break label142;
            }
            this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, true);
            if (this.jdField_l_of_type_Boolean) {
              break;
            }
            a("share_locate", "pageview_all", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
            return;
          }
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, true);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  protected boolean a()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_i_of_type_Boolean = false;
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    int i1 = this.jdField_g_of_type_AndroidViewView.getHeight();
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130904937);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    hfe localhfe = new hfe(this, (TranslateAnimation)localObject1, localDialog, i1, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(localhfe);
    ((TranslateAnimation)localObject2).setAnimationListener(localhfe);
    localDialog.setOnDismissListener(new hff(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.jdField_h_of_type_AndroidViewView = localDialog.findViewById(2131296895);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131300895));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new PoiMapActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131300880));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new hfh(this));
    localObject1 = (Button)localDialog.findViewById(2131300876);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new hfi(this, localDialog));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131297767));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131297765));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new hek(this, localDialog));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131298733));
    this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundDrawable(super.getResources().getDrawable(2130837958));
    this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter = new PoiMapActivity.SearchResultAdapter(this, this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new hel(this, localInputMethodManager));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(new hem(this, localDialog));
    if (1 == HttpUtil.a()) {}
    for (this.jdField_f_of_type_Boolean = true;; this.jdField_f_of_type_Boolean = false)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  protected void b(GeoPoint paramGeoPoint)
  {
    int i1 = paramGeoPoint.getLatitudeE6();
    int i2 = paramGeoPoint.getLongitudeE6();
    super.b(paramGeoPoint);
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "lat=" + i1 + ", lon=" + i2);
    }
    this.jdField_p_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = i1;
    this.jdField_i_of_type_Int = i2;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_k_of_type_Int = this.jdField_i_of_type_Int;
    this.jdField_d_of_type_Boolean = false;
    i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(false);
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(-1, false);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
        continue;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(-1, true);
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.jdField_l_of_type_Int].b(true);
  }
  
  protected void b(String paramString)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getShareShopDetail");
    localIntent.putExtra("shop_id", paramString);
    super.sendBroadcast(localIntent);
  }
  
  protected void c()
  {
    if (this.jdField_l_of_type_Boolean)
    {
      a("rec_locate", "click_rec_return", "", "", "", "");
      return;
    }
    a("share_locate", "click_rec_return", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
  }
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    String str2 = String.valueOf(((GeoPoint)localObject).getLatitudeE6() / 1000000.0D);
    String str3 = String.valueOf(((GeoPoint)localObject).getLongitudeE6() / 1000000.0D);
    String str4 = str2 + "," + str3 + "," + this.jdField_f_of_type_JavaLangString + "," + this.jdField_e_of_type_JavaLangString;
    String str5;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = "0";
      str5 = this.jdField_l_of_type_Int + 1 + "";
      if (!this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.jdField_l_of_type_Int].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean) {
        break label285;
      }
    }
    label285:
    for (String str1 = "2";; str1 = "1")
    {
      a("share_locate", "click_send", str4, (String)localObject, str5, str1);
      if (this.jdField_j_of_type_Boolean)
      {
        a("rec_locate", "send_googlestation", "", "", "", "");
        a("rec_locate", "send_foursquare", "", "", "", "");
      }
      if (getIntent().getIntExtra("uintype", 0) == 1008)
      {
        localObject = new Intent("com.tencent.biz.pubaccount.locationResultAction");
        ((Intent)localObject).putExtra("latitude", str2);
        ((Intent)localObject).putExtra("longitude", str3);
        ((Intent)localObject).putExtra("name", this.jdField_q_of_type_JavaLangString);
        sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      }
      return;
      localObject = this.jdField_b_of_type_JavaLangString;
      break;
    }
  }
  
  protected void e()
  {
    a("rec_locate", "click_view", "", "", "", "");
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("poi_category", "");
    Object localObject1;
    String[] arrayOfString;
    int i1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = null;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          try
          {
            int i2;
            localObject3 = ((JSONArray)localObject1).getJSONObject(i1);
            str = ((JSONObject)localObject3).getString("name");
            localObject3 = ((JSONObject)localObject3).getString("id");
            localObject2[i1] = str;
            arrayOfString[i1] = localObject3;
            i1 += 1;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            i1 = 1;
          }
          localJSONException2 = localJSONException2;
          localJSONException2.printStackTrace();
        }
      }
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i2 = ((JSONArray)localObject1).length();
        localObject2 = new String[i2];
        arrayOfString = new String[i2];
        i1 = 0;
        if (i1 >= i2) {
          break label198;
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      String str;
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = localJSONException2;
        this.jdField_b_of_type_ArrayOfJavaLangString = arrayOfString;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabName:" + this.jdField_a_of_type_ArrayOfJavaLangString.toString());
      }
      return;
      label198:
      i1 = 0;
    }
  }
  
  public void g()
  {
    this.jdField_s_of_type_Int = super.getResources().getDimensionPixelSize(2131493265);
    this.v = super.getResources().getDimensionPixelSize(2131493267);
    this.w = super.getResources().getDimensionPixelSize(2131493263);
    this.t = super.getResources().getDimensionPixelSize(2131493270);
    this.jdField_u_of_type_Int = super.getResources().getDimensionPixelSize(2131493271);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131302695));
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131302703);
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(this.jdField_d_of_type_Int);
    this.jdField_e_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_s_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.jdField_o_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.jdField_o_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (FrameLayout)super.findViewById(2131302696);
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab = new PoiMapActivity.PoiTab[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.weight = 1.0F;
    int i2 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      PoiMapActivity.PoiTab localPoiTab = new PoiMapActivity.PoiTab(this, this, this.jdField_a_of_type_ArrayOfJavaLangString[i1], i1);
      if (i1 == 0)
      {
        localPoiTab.a(true);
        localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Int = 0;
      }
      if (i1 == i2 - 1) {
        localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.a();
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1] = localPoiTab;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView, localLayoutParams1);
      ((FrameLayout)localObject).addView(localPoiTab.jdField_a_of_type_ComTencentWidgetXListView, localLayoutParams2);
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
  }
  
  protected void h()
  {
    super.h();
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  protected void i()
  {
    this.jdField_p_of_type_Int = super.getResources().getDimensionPixelSize(2131493274);
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131302717);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131302718);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302720));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302719));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131302721));
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(this.jdField_c_of_type_Int);
    this.jdField_f_of_type_AndroidViewView.setBackgroundDrawable(null);
    this.jdField_f_of_type_AndroidViewView.setBackgroundResource(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter = new PoiMapActivity.ShopListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new hes(this));
    if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a(this.jdField_r_of_type_JavaLangString);
      a("rec_locate", "view_shangjia", this.jdField_r_of_type_JavaLangString, "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new het(this));
      return;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$ShopListAdapter.a();
      a("rec_locate", "view_near_food", "", "", "", "");
    }
  }
  
  protected void j()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_q_of_type_Int);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new hev(this));
    this.jdField_d_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  public void k()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_q_of_type_Int);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new hew(this));
    this.jdField_d_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
  }
  
  public void l()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_s_of_type_Int <= 0) || (this.jdField_r_of_type_Int <= 0)) {
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(this.jdField_r_of_type_Int + this.jdField_s_of_type_Int), Integer.valueOf(this.jdField_r_of_type_Int), new hex(this));
    localValueAnimation.setDuration(300L);
    localValueAnimation.setFillAfter(true);
    localValueAnimation.setAnimationListener(new hey(this));
    this.jdField_o_of_type_AndroidViewView.startAnimation(localValueAnimation);
  }
  
  public void m()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_s_of_type_Int <= 0) || (this.jdField_r_of_type_Int <= 0)) {
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(this.jdField_r_of_type_Int), Integer.valueOf(this.jdField_r_of_type_Int + this.jdField_s_of_type_Int), new hez(this));
    localValueAnimation.setDuration(300L);
    localValueAnimation.setFillAfter(true);
    localValueAnimation.setAnimationListener(new hfa(this));
    this.jdField_o_of_type_AndroidViewView.startAnimation(localValueAnimation);
  }
  
  protected void n()
  {
    super.n();
    String str = "{" + "\"id\":\"" + this.jdField_b_of_type_JavaLangString + "\"," + "\"title\":\"" + this.jdField_p_of_type_JavaLangString + "\"," + "\"address\":\"" + this.jdField_q_of_type_JavaLangString + "\"," + "\"location\":{" + "\"lat\":\"" + this.jdField_j_of_type_Int * 1.0F / 1000000.0D + "\"," + "\"lon\":\"" + this.jdField_k_of_type_Int * 1.0F / 1000000.0D + "\"" + "}" + "}";
    Intent localIntent = new Intent();
    localIntent.putExtra("result", str);
    setResult(-1, localIntent);
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(true);
      if (this.jdField_l_of_type_Boolean)
      {
        a("rec_locate", "click_locate_rec", "", "", "", "");
        return;
      }
      a("share_locate", "click_locate_share", "", "", "", "");
      return;
      if (this.jdField_a_of_type_Boolean) {
        k();
      }
      for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
      {
        a("rec_locate", "click_near_food", "", "", "", "");
        return;
        j();
      }
    } while (this.jdField_b_of_type_Boolean);
    l();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.jdField_a_of_type_Int = super.getResources().getColor(2131428302);
      this.jdField_b_of_type_Int = super.getResources().getColor(2131428262);
      this.jdField_c_of_type_Int = super.getResources().getColor(2131427579);
      this.jdField_d_of_type_Int = 2130843196;
      this.jdField_e_of_type_Int = 2130838312;
    }
    for (this.jdField_f_of_type_Int = 2130840244;; this.jdField_f_of_type_Int = 2130840245)
    {
      this.jdField_g_of_type_Int = Color.rgb(0, 121, 255);
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      this.jdField_k_of_type_Boolean = getIntent().getBooleanExtra("is_need_destroy_broadcast", true);
      f();
      a();
      return;
      this.jdField_a_of_type_Int = super.getResources().getColor(2131428304);
      this.jdField_b_of_type_Int = super.getResources().getColor(2131428266);
      this.jdField_c_of_type_Int = super.getResources().getColor(2131427576);
      this.jdField_d_of_type_Int = 2130843196;
      this.jdField_e_of_type_Int = 2130838312;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\PoiMapActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */