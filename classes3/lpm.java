import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.vas.ChatBackgroundMarketActivity;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.BizExtraInfo;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.BizRecommendConfig;
import com.tencent.mobileqq.vas.IndividuationConfigInfo.BizRecommendConfigDetail;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lpm
  extends BaseAdapter
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private IndividuationSetActivity jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity;
  private IndividuationConfigInfo.BizExtraInfo jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizExtraInfo;
  private IndividuationConfigInfo.BizRecommendConfig jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizRecommendConfig;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public lpm(IndividuationSetActivity paramIndividuationSetActivity, IndividuationConfigInfo.BizExtraInfo paramBizExtraInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity = paramIndividuationSetActivity;
    this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizExtraInfo = paramBizExtraInfo;
  }
  
  public lpm(IndividuationSetActivity paramIndividuationSetActivity, IndividuationConfigInfo.BizExtraInfo paramBizExtraInfo, IndividuationConfigInfo.BizRecommendConfig paramBizRecommendConfig)
  {
    this(paramIndividuationSetActivity, paramBizExtraInfo);
    this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizRecommendConfig = paramBizRecommendConfig;
    if (paramBizRecommendConfig != null) {
      this.jdField_a_of_type_JavaUtilArrayList = paramBizRecommendConfig.jdField_a_of_type_JavaUtilArrayList;
    }
  }
  
  public IndividuationConfigInfo.BizRecommendConfigDetail a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return (IndividuationConfigInfo.BizRecommendConfigDetail)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity = null;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    IndividuationConfigInfo.BizRecommendConfigDetail localBizRecommendConfigDetail = a(paramInt);
    if ((localBizRecommendConfigDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizExtraInfo == null)) {}
    Object localObject4;
    do
    {
      return paramView;
      paramInt = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizExtraInfo.c;
      if (1 == paramInt)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 2130904545, null);
        }
        localObject2 = (ImageView)paramViewGroup.findViewById(2131303121);
        paramView = (ImageView)paramViewGroup.findViewById(2131303135);
        int i;
        if (4 == this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizExtraInfo.jdField_a_of_type_Int)
        {
          paramInt = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 115.0F);
          i = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 172.5F);
          localObject1 = (RelativeLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).width = paramInt;
          ((RelativeLayout.LayoutParams)localObject1).height = i;
          localObject1 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).width = paramInt;
          ((RelativeLayout.LayoutParams)localObject1).height = i;
        }
        if (5 == this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizExtraInfo.jdField_a_of_type_Int)
        {
          paramInt = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 115.0F);
          i = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 131.0F);
          localObject1 = (RelativeLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).width = paramInt;
          ((RelativeLayout.LayoutParams)localObject1).height = i;
          paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          paramView.width = paramInt;
          paramView.height = i;
        }
        localObject3 = (ImageView)paramViewGroup.findViewById(2131303136);
        localObject4 = (TextView)paramViewGroup.findViewById(2131303123);
        ((ImageView)localObject3).setVisibility(8);
        ((TextView)localObject4).setVisibility(8);
        if (!TextUtils.isEmpty(localBizRecommendConfigDetail.d))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((ImageView)localObject2).getLayoutParams().width;
          localURLDrawableOptions.mRequestHeight = ((ImageView)localObject2).getLayoutParams().height;
          localObject1 = localBizRecommendConfigDetail.f;
          paramView = (View)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramView = "#F2F2F2";
          }
          localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(Color.parseColor(paramView));
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(localBizRecommendConfigDetail.d, localURLDrawableOptions));
        }
        if ("ui-tag-hot".equals(localBizRecommendConfigDetail.c))
        {
          ((ImageView)localObject3).setVisibility(0);
          ((ImageView)localObject3).setImageResource(2130841733);
        }
        while (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizExtraInfo.jdField_a_of_type_Boolean)
        {
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(localBizRecommendConfigDetail.b);
          return paramViewGroup;
          if ("ui-tag-new".equals(localBizRecommendConfigDetail.c))
          {
            ((ImageView)localObject3).setVisibility(0);
            ((ImageView)localObject3).setImageResource(2130841734);
          }
        }
        paramViewGroup.setPadding(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 5.0F), 0, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 5.0F), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 10.0F));
        return paramViewGroup;
      }
    } while (2 != paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, 2130904546, null);
    }
    Object localObject3 = (ImageView)paramViewGroup.findViewById(2131303137);
    paramView = (ImageView)paramViewGroup.findViewById(2131303121);
    Object localObject1 = (ImageView)paramViewGroup.findViewById(2131303136);
    Object localObject2 = (TextView)paramViewGroup.findViewById(2131303123);
    ((ImageView)localObject1).setVisibility(8);
    if (!TextUtils.isEmpty(localBizRecommendConfigDetail.e))
    {
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((ImageView)localObject3).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((ImageView)localObject3).getLayoutParams().height;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = new ColorDrawable(0);
      ((ImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(localBizRecommendConfigDetail.e, (URLDrawable.URLDrawableOptions)localObject4));
    }
    if (!TextUtils.isEmpty(localBizRecommendConfigDetail.d))
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramView.getLayoutParams().height;
      paramView.setImageDrawable(URLDrawable.getDrawable(localBizRecommendConfigDetail.d, (URLDrawable.URLDrawableOptions)localObject3));
    }
    if ("ui-tag-hot".equals(localBizRecommendConfigDetail.c))
    {
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setImageResource(2130841733);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizExtraInfo.jdField_a_of_type_Boolean)
    {
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(localBizRecommendConfigDetail.b);
      return paramViewGroup;
      if ("ui-tag-new".equals(localBizRecommendConfigDetail.c))
      {
        ((ImageView)localObject1).setVisibility(0);
        ((ImageView)localObject1).setImageResource(2130841734);
      }
      else
      {
        ((ImageView)localObject1).setVisibility(8);
      }
    }
    ((TextView)localObject2).setVisibility(8);
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizRecommendConfig.jdField_a_of_type_JavaLangString;
    if (AppSetting.j) {
      paramView.setContentDescription("更多");
    }
    if ("emoji".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_emoji_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)3, false);
      return;
    }
    if ("bubble".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_bubble_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)0, false);
      return;
    }
    if ("font".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_font_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)4, false);
      return;
    }
    if ("theme".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_theme_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)2, false);
      return;
    }
    if ("card".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_card_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)5, false);
      return;
    }
    if ("call".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_funcall_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)7, false);
      return;
    }
    if ("pendant".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_avatar_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)1, false);
      return;
    }
    if ("hongbao".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_redbag_more", 0, 0, "", "", "", "");
      paramView = IndividualRedPacketManager.a(2, this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app) + "&itemid=0";
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("individuation_url_type", 40100);
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, paramView, 134217728L, (Intent)localObject, true, -1);
      return;
    }
    if ("suit".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_suit_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)6, false);
      return;
    }
    if ("ring".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_colorring_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)9, false);
      return;
    }
    if ("background".equals(localObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_chatbg_more", 0, 0, "", "", "", "");
      IndividuationSetActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, (byte)8, false);
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizRecommendConfig.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.startActivity(paramView);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(paramInt);
    if ((this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizRecommendConfig == null) || (paramAdapterView == null) || (TextUtils.isEmpty(paramAdapterView.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo$BizRecommendConfig.jdField_a_of_type_JavaLangString;
      if ("emoji".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_emoji", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        EmojiHomeUiPlugin.openEmojiDetailPage(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app.getAccount(), 4, paramAdapterView.jdField_a_of_type_JavaLangString, false, false);
        return;
      }
      if ("bubble".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_bubble", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
        paramView.putExtra("individuation_url_type", 40302);
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, "bubbleDetail", paramAdapterView.jdField_a_of_type_JavaLangString, "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramView, false, -1);
        return;
      }
      if ("font".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_font", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
        paramView.putExtra("individuation_url_type", 40302);
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, "fontDetail", paramAdapterView.jdField_a_of_type_JavaLangString, "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, paramView, false, -1);
        return;
      }
      if ("theme".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_theme", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        if (!BaseApplicationImpl.jdField_a_of_type_Boolean)
        {
          Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.getString(2131368352), 0).show();
          return;
        }
        if (Utils.b())
        {
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
          paramView.putExtra("individuation_url_type", 40100);
          VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, "themeDetail", paramAdapterView.jdField_a_of_type_JavaLangString, ""), 32L, paramView, true, -1);
          return;
        }
        Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.getString(2131368967), 0).show();
        return;
      }
      if ("card".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_card", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app.a(), "inside.myIndividuation", 0, 2, 1, "id=" + paramAdapterView.jdField_a_of_type_JavaLangString, false, false, "");
        return;
      }
      if ("call".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_funcall", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", false);
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        paramView.putExtra("individuation_url_type", 40100);
        paramAdapterView = IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, "callDetail", paramAdapterView.jdField_a_of_type_JavaLangString, "mvip.gongneng.anroid.individuation.web");
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, paramAdapterView, 524288L, paramView, false, -1);
        return;
      }
      if ("pendant".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_avatar", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, AvatarPendantMarketActivity.class);
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        paramView.putExtra("hide_left_button", false);
        paramView.putExtra("show_right_close_button", false);
        paramView.putExtra("url", IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, "pendantDetail", paramAdapterView.jdField_a_of_type_JavaLangString, "mvip.gexinghua.mobile.faceaddon.client_tab_store"));
        paramView.putExtra("business", 512L);
        paramView.putExtra("individuation_url_type", 40100);
        VasWebviewUtil.insertVasWbPluginToIntent(512L, paramView);
        paramView.putExtra("isShowAd", false);
        this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.startActivity(paramView);
        return;
      }
      if ("hongbao".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_redbag", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        paramView = IndividualRedPacketManager.a(2, this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app);
        if (!TextUtils.isEmpty(paramView))
        {
          String str = paramView.replace("[from]", "2");
          paramView = new StringBuilder();
          paramView.append(str).append("&itemid=").append(paramAdapterView.jdField_a_of_type_JavaLangString);
          paramAdapterView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
          paramAdapterView.putExtra("individuation_url_type", 40100);
          VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, paramView.toString(), 134217728L, paramAdapterView, true, -1);
          return;
        }
        QLog.e("qqBaseActivity", 1, "onItemClick, open redpacket detail, url null");
        return;
      }
      if ("suit".equals(paramView))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
        paramView.putExtra("individuation_url_type", 40100);
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, "suitDetail", paramAdapterView.jdField_a_of_type_JavaLangString, "mvip.gongneng.android.gxsuit"), 32L, paramView, true, -1);
        return;
      }
      if ("ring".equals(paramView))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
        paramView.putExtra("individuation_url_type", 40100);
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, "ringDetail", paramAdapterView.jdField_a_of_type_JavaLangString, "mvip.gongneng.anroid.individuation.web"), 4194304L, paramView, true, -1);
        return;
      }
      if ("background".equals(paramView))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.app, "CliOper", "", "", "Trends_tab", "Clk_background", 0, 0, paramAdapterView.jdField_a_of_type_JavaLangString, "", "", "");
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, ChatBackgroundMarketActivity.class);
        paramView.putExtra("individuation_url_type", 40100);
        paramView.putExtra("url", IndividuationUrlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, "backgroundDetail", paramAdapterView.jdField_a_of_type_JavaLangString, ""));
        this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.startActivity(paramView);
        return;
      }
      paramAdapterView = paramAdapterView.g;
      if (!TextUtils.isEmpty(paramAdapterView))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, QQBrowserActivity.class);
        paramView.putExtra("url", paramAdapterView);
        this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.startActivity(paramView);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "jumpurl = null");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */