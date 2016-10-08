package com.tencent.smtt.sdk.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.smtt.sdk.ValueCallback;
import java.util.HashMap;
import java.util.Map;

public class TBSActivityPicker
  extends Dialog
{
  public static final int PROPERTY_ADAPTER = 6;
  public static final int PROPERTY_BUTTONS = 3;
  public static final int PROPERTY_CANCEL = 4;
  public static final int PROPERTY_DRAWABLE = 10;
  public static final int PROPERTY_INTENT = 5;
  public static final int PROPERTY_INTENT_SENDING_CALLBACK = 7;
  public static final int PROPERTY_MESSAGE = 2;
  public static final int PROPERTY_MESSAGE_ALIGN = 8;
  public static final int PROPERTY_ONKEY = 9;
  public static final int PROPERTY_TITLE = 1;
  static final String QQ_PACKAGE = "com.tencent.mobileqq";
  static final String SHARE_PREFERENCES_NAME = "tbs_file_open_dialog_config";
  static final String WECHAT_PACKAGE = "com.tencent.mm";
  private static float sDensity = -1.0F;
  private BrowserListAdapter mAdapter;
  private Button mButtonAlways;
  private Button mButtonOnce;
  private Map<Integer, DialogButton> mButtons = new HashMap();
  private Context mContext;
  private String mDialogTitle;
  private Intent mIntent;
  private ValueCallback<String> mIntentCallback;
  private ListView mList;
  protected Map<Integer, Object> mProperties;
  private TextView mTitle;
  private SharedPreferences preferfences = null;
  
  public TBSActivityPicker(Context paramContext, String paramString, Intent paramIntent, ValueCallback<String> paramValueCallback)
  {
    super(paramContext, 16973835);
    initDensity(paramContext.getApplicationContext());
    this.mDialogTitle = paramString;
    this.mIntent = paramIntent;
    this.mIntentCallback = paramValueCallback;
    this.preferfences = paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0);
  }
  
  private View createWXLayout(Context paramContext)
  {
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    Object localObject1 = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).dimAmount = 0.5F;
    getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    localObject1 = new FrameLayout(paramContext);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    Object localObject2 = new FrameLayout.LayoutParams(dip2px(280.0F), -1);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOrientation(1);
    this.mTitle = new TextView(paramContext);
    localObject2 = new LinearLayout.LayoutParams(-2, dip2px(65.0F));
    ((LinearLayout.LayoutParams)localObject2).weight = 0.0F;
    this.mTitle.setGravity(16);
    this.mTitle.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.mTitle.setPadding(dip2px(18.0F), 0, 0, 0);
    this.mTitle.setTextColor(Color.rgb(69, 192, 26));
    this.mTitle.setTextSize(1, 18.0F);
    localObject2 = this.mDialogTitle;
    this.mTitle.setText((CharSequence)localObject2);
    localLinearLayout.addView(this.mTitle);
    localObject2 = new ImageView(paramContext);
    Object localObject3 = new LinearLayout.LayoutParams(-1, 1);
    ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setBackgroundColor(Color.argb(61, 0, 0, 0));
    localLinearLayout.addView((View)localObject2);
    this.mList = new ListView(paramContext);
    localObject2 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    this.mList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.mList.setDivider(new ColorDrawable(Color.argb(41, 0, 0, 0)));
    this.mList.setDividerHeight(1);
    localLinearLayout.addView(this.mList);
    localObject2 = new ImageView(paramContext);
    localObject3 = new LinearLayout.LayoutParams(-1, 1);
    ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((ImageView)localObject2).setBackgroundColor(Color.argb(61, 0, 0, 0));
    localLinearLayout.addView((View)localObject2);
    localObject2 = new LinearLayout(paramContext);
    localObject3 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).setOrientation(0);
    ((LinearLayout)localObject2).setContentDescription("x5_tbs_activity_picker_btn_container");
    this.mButtonAlways = new Button(paramContext);
    localObject3 = new LinearLayout.LayoutParams(-1, dip2px(49.0F));
    ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
    this.mButtonAlways.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject3 = new StateListDrawable();
    Object localObject4 = new ColorDrawable(Color.argb(41, 0, 0, 0));
    ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject4);
    localObject4 = new ColorDrawable(0);
    ((StateListDrawable)localObject3).addState(new int[] { -16842919 }, (Drawable)localObject4);
    this.mButtonAlways.setBackgroundDrawable((Drawable)localObject3);
    this.mButtonAlways.setText(TBSResources.getString("x5_tbs_wechat_activity_picker_label_always"));
    this.mButtonAlways.setTextColor(Color.rgb(29, 29, 29));
    this.mButtonAlways.setTextSize(1, 17.0F);
    ((LinearLayout)localObject2).addView(this.mButtonAlways);
    localObject3 = new ImageView(paramContext);
    localObject4 = new LinearLayout.LayoutParams(1, -1);
    ((LinearLayout.LayoutParams)localObject4).weight = 0.0F;
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((ImageView)localObject3).setBackgroundColor(Color.rgb(217, 217, 217));
    ((LinearLayout)localObject2).addView((View)localObject3);
    this.mButtonOnce = new Button(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, dip2px(49.0F));
    paramContext.weight = 1.0F;
    this.mButtonOnce.setLayoutParams(paramContext);
    paramContext = new StateListDrawable();
    localObject3 = new ColorDrawable(Color.argb(41, 0, 0, 0));
    paramContext.addState(new int[] { 16842919 }, (Drawable)localObject3);
    localObject3 = new ColorDrawable(0);
    paramContext.addState(new int[] { -16842919 }, (Drawable)localObject3);
    this.mButtonOnce.setBackgroundDrawable(paramContext);
    this.mButtonOnce.setText(TBSResources.getString("x5_tbs_wechat_activity_picker_label_once"));
    this.mButtonOnce.setTextColor(Color.rgb(29, 29, 29));
    this.mButtonOnce.setTextSize(1, 17.0F);
    ((LinearLayout)localObject2).addView(this.mButtonOnce);
    localLinearLayout.addView((View)localObject2);
    ((FrameLayout)localObject1).addView(localLinearLayout);
    return (View)localObject1;
  }
  
  private void initDensity(Context paramContext)
  {
    if (sDensity < 0.0F)
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      sDensity = localDisplayMetrics.density;
    }
  }
  
  private void resetListView()
  {
    BrowsingActivityInfo localBrowsingActivityInfo = null;
    if (this.mAdapter != null) {
      localBrowsingActivityInfo = this.mAdapter.getCheckedActivityInfo();
    }
    this.mAdapter = new BrowserListAdapter(getContext(), this.mIntent, new BrowsingActivityInfo(getContext(), TBSResources.getDrawable("application_icon"), "QQ浏览器", "com.tencent.mtt"), localBrowsingActivityInfo, this, this.mList);
    this.mList.setAdapter(this.mAdapter);
  }
  
  public int dip2px(float paramFloat)
  {
    return (int)(sDensity * paramFloat + 0.5F);
  }
  
  void enableButtons(boolean paramBoolean)
  {
    if (this.mButtonOnce != null) {
      this.mButtonOnce.setEnabled(paramBoolean);
    }
    if (this.mButtonAlways != null) {
      this.mButtonAlways.setEnabled(paramBoolean);
    }
  }
  
  public String getTBSPickedDefaultBrowser()
  {
    String str = null;
    if (this.preferfences != null) {
      str = this.preferfences.getString("key_tbs_picked_default_browser", null);
    }
    return str;
  }
  
  public void initUI()
  {
    setContentView(createWXLayout(getContext()));
    resetListView();
    this.mButtonAlways.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Object localObject = TBSActivityPicker.this.mAdapter.getCheckedActivityInfo();
        if (((BrowsingActivityInfo)localObject).getResolveInfo() == null) {
          return;
        }
        paramAnonymousView = TBSActivityPicker.this.mIntent;
        Context localContext = TBSActivityPicker.this.getContext();
        localObject = ((BrowsingActivityInfo)localObject).getResolveInfo().activityInfo.packageName;
        paramAnonymousView.setPackage((String)localObject);
        localContext.startActivity(paramAnonymousView);
        if (TBSActivityPicker.this.mIntentCallback != null) {
          TBSActivityPicker.this.mIntentCallback.onReceiveValue("always");
        }
        TBSActivityPicker.this.setTBSPickedDefaultBrowser((String)localObject);
        TBSActivityPicker.this.dismiss();
      }
    });
    this.mButtonOnce.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = TBSActivityPicker.this.mAdapter.getCheckedActivityInfo();
        if (paramAnonymousView.getResolveInfo() == null) {
          return;
        }
        Intent localIntent = TBSActivityPicker.this.mIntent;
        Context localContext = TBSActivityPicker.this.getContext();
        localIntent.setPackage(paramAnonymousView.getResolveInfo().activityInfo.packageName);
        localContext.startActivity(localIntent);
        if (TBSActivityPicker.this.mIntentCallback != null) {
          TBSActivityPicker.this.mIntentCallback.onReceiveValue("once");
        }
        TBSActivityPicker.this.dismiss();
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    initUI();
  }
  
  protected void setButton(Button paramButton, final DialogButton paramDialogButton)
  {
    paramButton.setText(paramDialogButton.label);
    paramButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramDialogButton.diListener != null) {
          paramDialogButton.diListener.onClick(TBSActivityPicker.this, paramDialogButton.which);
        }
        if ((paramDialogButton.which == -1) || (paramDialogButton.which == -3) || (paramDialogButton.which == -2)) {
          TBSActivityPicker.this.dismiss();
        }
      }
    });
  }
  
  public void setProperties(Map<Integer, Object> paramMap)
  {
    this.mProperties = paramMap;
  }
  
  public void setTBSPickedDefaultBrowser(String paramString)
  {
    if (this.preferfences != null) {
      this.preferfences.edit().putString("key_tbs_picked_default_browser", paramString).commit();
    }
  }
  
  public static class DialogButton
  {
    public DialogInterface.OnClickListener diListener;
    public String label;
    public int which;
    
    DialogButton(int paramInt, String paramString)
    {
      this(paramInt, paramString, null);
    }
    
    public DialogButton(int paramInt, String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.which = paramInt;
      this.label = paramString;
      this.diListener = paramOnClickListener;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\ui\dialog\TBSActivityPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */