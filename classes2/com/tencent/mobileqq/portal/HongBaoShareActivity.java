package com.tencent.mobileqq.portal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import ttx;
import tty;
import ttz;
import tub;

public class HongBaoShareActivity
  extends BaseActivity
  implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final String a = "all_counts";
  public static final String b = "max_counts";
  private static final int c = 1;
  public static final String c = "s_url";
  private static final int jdField_d_of_type_Int = 2;
  private static final String jdField_d_of_type_JavaLangString = "PortalManagerHongBaoShareActivity";
  private static final int jdField_e_of_type_Int = 3;
  private static final int jdField_f_of_type_Int = 4;
  private static final String jdField_f_of_type_JavaLangString = "QQ红包开抢啦！亿万红包等你来刷。";
  private static final String g = "http://newyear.qq.com/redEnvelopeRank/release/images/share.jpg?_bid=2257&max_age=31536000";
  private static final String h = "QQ团队";
  private static final String i = "http://url.cn/JS8oE7";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public WeakReference a;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ElasticHorScrView jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView;
  private String jdField_e_of_type_JavaLangString;
  
  public HongBaoShareActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = Resources.getSystem().getDisplayMetrics().density;
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Bitmap localBitmap = null; localBitmap == null; localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      ThreadManager.a(new ttz(this, paramString4, paramInt, paramString1, paramString2, paramString3), 5, null, false);
      return;
    }
    a(paramInt, paramString1, paramString2, paramString3, paramString4, localBitmap);
  }
  
  protected View a()
  {
    View localView = getLayoutInflater().inflate(2130903348, null);
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131298208));
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131298211));
    GridView localGridView2 = (GridView)localView.findViewById(2131298209);
    GridView localGridView1 = (GridView)localView.findViewById(2131298212);
    Object localObject1 = (TextView)localView.findViewById(2131296891);
    ((TextView)localObject1).setText(2131367262);
    ((TextView)localObject1).setOnClickListener(new ttx(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    localGridView2.setSmoothScrollbarEnabled(false);
    localGridView1.setSmoothScrollbarEnabled(false);
    Object localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label364;
      }
    }
    label364:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int j = ((List)localObject1).size();
      localGridView2.setNumColumns(j);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((j - 1) * 10 + j * 75 + 3) * this.jdField_a_of_type_Float));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      j = localLayoutParams.width;
      int k = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)((k * 75 + (k - 1) * 10 + 3) * this.jdField_a_of_type_Float));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(k);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new tty(this, j, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      View localView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView, null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(paramInt).append(" , ");
      if (paramBitmap != null)
      {
        bool = true;
        QLog.d("PortalManagerHongBaoShareActivity", 2, bool);
      }
    }
    else
    {
      if (paramInt != 2) {
        break label171;
      }
      localObject = new Bundle();
      paramBitmap = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramBitmap = paramString3;
      }
      ((Bundle)localObject).putString("title", paramBitmap);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString3;
      }
      ((Bundle)localObject).putString("desc", paramString1);
      ((Bundle)localObject).putString("detail_url", paramString3);
      paramString1 = new ArrayList(1);
      paramString1.add(paramString4);
      ((Bundle)localObject).putStringArrayList("image_url", paramString1);
      ((Bundle)localObject).putLong("req_share_id", 0L);
      QZoneShareManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, (Bundle)localObject, null);
    }
    label171:
    label398:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (paramInt != 1) {
          break label398;
        }
        paramBitmap = new Intent();
        paramBitmap.setClass(this, ForwardRecentActivity.class);
        paramBitmap.putExtra("isFromShare", true);
        paramBitmap.putExtra("key_flag_from_plugin", true);
        paramBitmap.putExtra("forward_type", 1001);
        paramBitmap.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
        paramBitmap.putExtra("app_name", "QQ团队");
        paramBitmap.putExtra("detail_url", paramString3);
        paramBitmap.putExtra("title", paramString1);
        paramBitmap.putExtra("desc", paramString2);
        paramBitmap.putExtra("image_url_remote", paramString4);
        paramBitmap.putExtra("req_type", 1);
        paramBitmap.putExtra("pluginName", "web_share");
        paramBitmap.putExtra("brief_key", getString(2131364569, new Object[] { paramString1 }));
        paramBitmap.putExtra("struct_share_key_content_action", "web");
        paramBitmap.putExtra("pubUin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
        paramString1 = StructMsgFactory.a(paramBitmap.getExtras());
      } while (paramString1 == null);
      paramBitmap.putExtra("stuctmsg_bytes", paramString1.getBytes());
      startActivity(paramBitmap);
      return;
    } while ((paramInt != 3) && (paramInt != 4));
    int j;
    if (!WXShareHelper.a().a()) {
      j = 2131369529;
    }
    for (;;)
    {
      if (j != -1)
      {
        QRUtils.a(0, j);
        return;
        if (!WXShareHelper.a().b()) {
          j = 2131369530;
        }
      }
      else
      {
        paramString4 = String.valueOf(System.currentTimeMillis());
        localObject = new tub(this, paramString4);
        WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
        localObject = WXShareHelper.a();
        if (paramInt == 3) {}
        for (paramInt = 0;; paramInt = 1)
        {
          ((WXShareHelper)localObject).a(paramString4, paramString1, paramBitmap, paramString2, paramString3, paramInt);
          return;
        }
      }
      j = -1;
    }
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    QfavBuilder.a(paramString).c(str).a(this, str, 2, null);
  }
  
  protected List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364561);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838114;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 2;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364567);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838115;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 3;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364577);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838116;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 9;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364578);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838112;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 10;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = getString(2131364576);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.u = 2130840304;
    localActionSheetItem.v = 6;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = getString(2131364563);
    localActionSheetItem.u = 2130838111;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 1;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    overridePendingTransition(0, 0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = getAppInterface();
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("all_counts", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("max_counts", 0);
    this.e = paramBundle.getStringExtra("s_url");
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0))
    {
      finish();
      return false;
    }
    try
    {
      setContentView(2130904189);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301769));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301770));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301771));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301773));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301774));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301775));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramBundle = Typeface.createFromAsset(getAssets(), "fonts/icomoon.ttf");
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramBundle);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(Integer.toString(this.jdField_a_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("最高连刷" + this.jdField_b_of_type_Int + "次");
      paramBundle = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.0F);
      paramBundle.setDuration(400L);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(paramBundle);
      ReportController.b(this.app, "CliOper", "", "", "0X800633F", "0X800633F", 0, 0, "", "", "", "");
      return true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
    return false;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301771: 
      ReportController.b(this.app, "CliOper", "", "", "0X800633B", "0X800633B", 0, 0, "", "", "", "");
      finish();
      overridePendingTransition(0, 0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a();
    ReportController.b(this.app, "CliOper", "", "", "0X800633C", "0X800633C", 0, 0, "", "", "", "");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    paramInt = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.v;
    paramAdapterView = "我已成功刷了" + this.jdField_a_of_type_Int + "次，谁敢来挑战！";
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      if (paramInt == -1) {
        break;
      }
      ((PortalManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(78)).j();
      ReportController.b(this.app, "CliOper", "", "", "0X800633D", "0X800633D", 0, 0, "" + paramInt, "", "", "");
      return;
      a(1, "QQ红包开抢啦！亿万红包等你来刷。", paramAdapterView, this.e, "http://newyear.qq.com/redEnvelopeRank/release/images/share.jpg?_bid=2257&max_age=31536000", null);
      paramInt = 1;
      continue;
      a(2, "QQ红包开抢啦！亿万红包等你来刷。", paramAdapterView, this.e, "http://newyear.qq.com/redEnvelopeRank/release/images/share.jpg?_bid=2257&max_age=31536000", null);
      paramInt = 2;
      continue;
      a(3, "QQ红包开抢啦！亿万红包等你来刷。", paramAdapterView, this.e, "http://newyear.qq.com/redEnvelopeRank/release/images/share.jpg?_bid=2257&max_age=31536000");
      paramInt = 3;
      continue;
      a(4, "QQ红包开抢啦！亿万红包等你来刷。", paramAdapterView, this.e, "http://newyear.qq.com/redEnvelopeRank/release/images/share.jpg?_bid=2257&max_age=31536000");
      paramInt = 4;
      continue;
      a(this.e);
      QRUtils.a(2, 2131365895);
      paramInt = -1;
      continue;
      ((ClipboardManager)getSystemService("clipboard")).setText(this.e);
      QRUtils.a(2, 2131364463);
      paramInt = -1;
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\HongBaoShareActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */