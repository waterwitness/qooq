package com.tencent.proxyinner.entry;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.proxyinner.report.DataReport;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultLoadingUI
{
  private static final String TAG = "TXProxy|DefaultLoadingUI";
  private Activity mActivity;
  ImageView mBackBtn;
  RelativeLayout mContentLayout;
  private RelativeLayout mErrorLayout;
  ImageView mErrorLogo;
  private int mErrorTextId;
  private Event mEvent = null;
  private int mLayoutID = 1;
  private RelativeLayout mLoadingLayout;
  ImageView mLoadingLogo;
  private ProgressBar mProgressBar;
  private TextView mTipsView;
  private RelativeLayout mTitlebarLayout;
  private ProgressBar mloadingCtrl;
  
  private final int dp2px(float paramFloat)
  {
    if (this.mActivity == null) {
      return 0;
    }
    return (int)(paramFloat * this.mActivity.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static URL getResource(Activity paramActivity, String paramString)
  {
    paramActivity = paramActivity.getApplicationInfo().sourceDir;
    try
    {
      paramActivity = new URL("jar:file:" + paramActivity + "!/" + "res/raw/" + paramString);
      return paramActivity;
    }
    catch (MalformedURLException paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return null;
  }
  
  public void addListener(Event paramEvent)
  {
    this.mEvent = paramEvent;
  }
  
  /* Error */
  public void initErrorUI(RelativeLayout paramRelativeLayout)
  {
    // Byte code:
    //   0: new 120	android/widget/TextView
    //   3: dup
    //   4: aload_0
    //   5: getfield 49	com/tencent/proxyinner/entry/DefaultLoadingUI:mActivity	Landroid/app/Activity;
    //   8: invokespecial 123	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   11: astore_2
    //   12: new 125	android/widget/RelativeLayout$LayoutParams
    //   15: dup
    //   16: bipush -2
    //   18: bipush -2
    //   20: invokespecial 128	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   23: astore_3
    //   24: aload_3
    //   25: bipush 13
    //   27: invokevirtual 132	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 42	com/tencent/proxyinner/entry/DefaultLoadingUI:mLayoutID	I
    //   35: putfield 134	com/tencent/proxyinner/entry/DefaultLoadingUI:mErrorTextId	I
    //   38: aload_0
    //   39: getfield 42	com/tencent/proxyinner/entry/DefaultLoadingUI:mLayoutID	I
    //   42: istore 5
    //   44: aload_0
    //   45: iload 5
    //   47: iconst_1
    //   48: iadd
    //   49: putfield 42	com/tencent/proxyinner/entry/DefaultLoadingUI:mLayoutID	I
    //   52: aload_2
    //   53: iload 5
    //   55: invokevirtual 137	android/widget/TextView:setId	(I)V
    //   58: aload_2
    //   59: ldc -117
    //   61: invokevirtual 143	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   64: aload_2
    //   65: iconst_2
    //   66: ldc -112
    //   68: invokevirtual 148	android/widget/TextView:setTextSize	(IF)V
    //   71: aload_2
    //   72: iconst_m1
    //   73: invokevirtual 151	android/widget/TextView:setTextColor	(I)V
    //   76: aload_2
    //   77: iconst_0
    //   78: invokevirtual 155	android/widget/TextView:setIncludeFontPadding	(Z)V
    //   81: aload_1
    //   82: aload_2
    //   83: aload_3
    //   84: invokevirtual 161	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   87: aload_0
    //   88: new 163	android/widget/ImageView
    //   91: dup
    //   92: aload_0
    //   93: getfield 49	com/tencent/proxyinner/entry/DefaultLoadingUI:mActivity	Landroid/app/Activity;
    //   96: invokespecial 164	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   99: putfield 166	com/tencent/proxyinner/entry/DefaultLoadingUI:mErrorLogo	Landroid/widget/ImageView;
    //   102: aload_0
    //   103: getfield 166	com/tencent/proxyinner/entry/DefaultLoadingUI:mErrorLogo	Landroid/widget/ImageView;
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 42	com/tencent/proxyinner/entry/DefaultLoadingUI:mLayoutID	I
    //   111: istore 5
    //   113: aload_0
    //   114: iload 5
    //   116: iconst_1
    //   117: iadd
    //   118: putfield 42	com/tencent/proxyinner/entry/DefaultLoadingUI:mLayoutID	I
    //   121: aload_3
    //   122: iload 5
    //   124: invokevirtual 167	android/widget/ImageView:setId	(I)V
    //   127: aload_0
    //   128: getfield 49	com/tencent/proxyinner/entry/DefaultLoadingUI:mActivity	Landroid/app/Activity;
    //   131: invokevirtual 59	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   134: ldc -87
    //   136: ldc -85
    //   138: ldc -83
    //   140: invokevirtual 177	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   143: istore 5
    //   145: aload_0
    //   146: getfield 166	com/tencent/proxyinner/entry/DefaultLoadingUI:mErrorLogo	Landroid/widget/ImageView;
    //   149: aload_0
    //   150: getfield 49	com/tencent/proxyinner/entry/DefaultLoadingUI:mActivity	Landroid/app/Activity;
    //   153: invokevirtual 59	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   156: iload 5
    //   158: invokevirtual 181	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   161: invokevirtual 185	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   164: iconst_0
    //   165: ifeq +11 -> 176
    //   168: new 187	java/lang/NullPointerException
    //   171: dup
    //   172: invokespecial 188	java/lang/NullPointerException:<init>	()V
    //   175: athrow
    //   176: new 125	android/widget/RelativeLayout$LayoutParams
    //   179: dup
    //   180: aload_0
    //   181: ldc -67
    //   183: invokespecial 191	com/tencent/proxyinner/entry/DefaultLoadingUI:dp2px	(F)I
    //   186: aload_0
    //   187: ldc -64
    //   189: invokespecial 191	com/tencent/proxyinner/entry/DefaultLoadingUI:dp2px	(F)I
    //   192: invokespecial 128	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   195: astore_3
    //   196: aload_3
    //   197: iconst_0
    //   198: iconst_0
    //   199: iconst_0
    //   200: aload_0
    //   201: ldc -63
    //   203: invokespecial 191	com/tencent/proxyinner/entry/DefaultLoadingUI:dp2px	(F)I
    //   206: invokevirtual 197	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   209: aload_3
    //   210: iconst_2
    //   211: aload_2
    //   212: invokevirtual 201	android/widget/TextView:getId	()I
    //   215: invokevirtual 203	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   218: aload_3
    //   219: bipush 14
    //   221: invokevirtual 132	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   224: aload_1
    //   225: aload_0
    //   226: getfield 166	com/tencent/proxyinner/entry/DefaultLoadingUI:mErrorLogo	Landroid/widget/ImageView;
    //   229: aload_3
    //   230: invokevirtual 161	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   233: new 205	android/widget/Button
    //   236: dup
    //   237: aload_0
    //   238: getfield 49	com/tencent/proxyinner/entry/DefaultLoadingUI:mActivity	Landroid/app/Activity;
    //   241: invokespecial 206	android/widget/Button:<init>	(Landroid/content/Context;)V
    //   244: astore_3
    //   245: aload_0
    //   246: getfield 42	com/tencent/proxyinner/entry/DefaultLoadingUI:mLayoutID	I
    //   249: istore 5
    //   251: aload_0
    //   252: iload 5
    //   254: iconst_1
    //   255: iadd
    //   256: putfield 42	com/tencent/proxyinner/entry/DefaultLoadingUI:mLayoutID	I
    //   259: aload_3
    //   260: iload 5
    //   262: invokevirtual 207	android/widget/Button:setId	(I)V
    //   265: aload_3
    //   266: ldc -47
    //   268: invokevirtual 210	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   271: aload_2
    //   272: iconst_1
    //   273: ldc -45
    //   275: invokevirtual 148	android/widget/TextView:setTextSize	(IF)V
    //   278: aload_3
    //   279: iconst_m1
    //   280: invokevirtual 212	android/widget/Button:setTextColor	(I)V
    //   283: new 214	android/graphics/drawable/StateListDrawable
    //   286: dup
    //   287: invokespecial 215	android/graphics/drawable/StateListDrawable:<init>	()V
    //   290: astore_2
    //   291: new 217	android/graphics/drawable/ColorDrawable
    //   294: dup
    //   295: ldc -37
    //   297: invokestatic 225	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   300: invokespecial 227	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   303: astore 4
    //   305: aload_2
    //   306: iconst_1
    //   307: newarray <illegal type>
    //   309: dup
    //   310: iconst_0
    //   311: iconst_0
    //   312: iastore
    //   313: aload 4
    //   315: invokevirtual 231	android/graphics/drawable/StateListDrawable:addState	([ILandroid/graphics/drawable/Drawable;)V
    //   318: new 217	android/graphics/drawable/ColorDrawable
    //   321: dup
    //   322: ldc -23
    //   324: invokestatic 225	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   327: invokespecial 227	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   330: astore 4
    //   332: aload_2
    //   333: iconst_1
    //   334: newarray <illegal type>
    //   336: dup
    //   337: iconst_0
    //   338: ldc -22
    //   340: iastore
    //   341: aload 4
    //   343: invokevirtual 231	android/graphics/drawable/StateListDrawable:addState	([ILandroid/graphics/drawable/Drawable;)V
    //   346: aload_3
    //   347: aload_2
    //   348: invokevirtual 237	android/widget/Button:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   351: new 125	android/widget/RelativeLayout$LayoutParams
    //   354: dup
    //   355: aload_0
    //   356: ldc -18
    //   358: invokespecial 191	com/tencent/proxyinner/entry/DefaultLoadingUI:dp2px	(F)I
    //   361: aload_0
    //   362: ldc -17
    //   364: invokespecial 191	com/tencent/proxyinner/entry/DefaultLoadingUI:dp2px	(F)I
    //   367: invokespecial 128	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   370: astore_2
    //   371: aload_2
    //   372: iconst_0
    //   373: iconst_0
    //   374: iconst_0
    //   375: aload_0
    //   376: ldc -16
    //   378: invokespecial 191	com/tencent/proxyinner/entry/DefaultLoadingUI:dp2px	(F)I
    //   381: invokevirtual 197	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   384: aload_2
    //   385: bipush 12
    //   387: invokevirtual 132	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   390: aload_2
    //   391: bipush 14
    //   393: invokevirtual 132	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   396: aload_1
    //   397: aload_3
    //   398: aload_2
    //   399: invokevirtual 161	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   402: aload_3
    //   403: new 8	com/tencent/proxyinner/entry/DefaultLoadingUI$2
    //   406: dup
    //   407: aload_0
    //   408: invokespecial 243	com/tencent/proxyinner/entry/DefaultLoadingUI$2:<init>	(Lcom/tencent/proxyinner/entry/DefaultLoadingUI;)V
    //   411: invokevirtual 247	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   414: return
    //   415: astore_3
    //   416: aload_3
    //   417: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   420: goto -244 -> 176
    //   423: astore_3
    //   424: iconst_0
    //   425: ifeq -249 -> 176
    //   428: new 187	java/lang/NullPointerException
    //   431: dup
    //   432: invokespecial 188	java/lang/NullPointerException:<init>	()V
    //   435: athrow
    //   436: astore_3
    //   437: aload_3
    //   438: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   441: goto -265 -> 176
    //   444: astore_1
    //   445: iconst_0
    //   446: ifeq +11 -> 457
    //   449: new 187	java/lang/NullPointerException
    //   452: dup
    //   453: invokespecial 188	java/lang/NullPointerException:<init>	()V
    //   456: athrow
    //   457: aload_1
    //   458: athrow
    //   459: astore_2
    //   460: aload_2
    //   461: invokevirtual 248	java/io/IOException:printStackTrace	()V
    //   464: goto -7 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	DefaultLoadingUI
    //   0	467	1	paramRelativeLayout	RelativeLayout
    //   11	388	2	localObject1	Object
    //   459	2	2	localIOException1	java.io.IOException
    //   23	380	3	localObject2	Object
    //   415	2	3	localIOException2	java.io.IOException
    //   423	1	3	localException	Exception
    //   436	2	3	localIOException3	java.io.IOException
    //   303	39	4	localColorDrawable	ColorDrawable
    //   42	219	5	i	int
    // Exception table:
    //   from	to	target	type
    //   168	176	415	java/io/IOException
    //   127	164	423	java/lang/Exception
    //   428	436	436	java/io/IOException
    //   127	164	444	finally
    //   449	457	459	java/io/IOException
  }
  
  public void initLoadingUI(RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mActivity);
    Object localObject1 = new RelativeLayout.LayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = 100;
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 40, 0, 0);
    int i = this.mLayoutID;
    this.mLayoutID = (i + 1);
    localRelativeLayout.setId(i);
    paramRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ViewGroup.MarginLayoutParams(45, 45);
    ((ViewGroup.MarginLayoutParams)localObject1).setMargins(0, 0, 0, 0);
    localObject1 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5);
    this.mloadingCtrl = new ProgressBar(this.mActivity, null, 16842873);
    Object localObject2 = this.mloadingCtrl;
    i = this.mLayoutID;
    this.mLayoutID = (i + 1);
    ((ProgressBar)localObject2).setId(i);
    this.mloadingCtrl.setIndeterminate(true);
    this.mloadingCtrl.setMax(10);
    this.mloadingCtrl.setVisibility(0);
    localRelativeLayout.addView(this.mloadingCtrl, (ViewGroup.LayoutParams)localObject1);
    this.mTipsView = new TextView(this.mActivity);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.mloadingCtrl.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    localObject2 = this.mTipsView;
    i = this.mLayoutID;
    this.mLayoutID = (i + 1);
    ((TextView)localObject2).setId(i);
    this.mTipsView.setTextSize(2, 13.0F);
    this.mTipsView.setTextColor(-1);
    this.mTipsView.setIncludeFontPadding(false);
    this.mTipsView.setVisibility(8);
    localRelativeLayout.addView(this.mTipsView, (ViewGroup.LayoutParams)localObject1);
    this.mProgressBar = new ProgressBar(this.mActivity, null, 16842872);
    localObject1 = this.mProgressBar;
    i = this.mLayoutID;
    this.mLayoutID = (i + 1);
    ((ProgressBar)localObject1).setId(i);
    this.mProgressBar.setMax(100);
    this.mProgressBar.setProgress(0);
    localObject1 = new ColorDrawable(Color.parseColor("#555460"));
    localObject2 = new ClipDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { -65536, 65280 }), 3, 1);
    this.mProgressBar.setProgressDrawable((Drawable)localObject2);
    this.mProgressBar.setBackgroundDrawable((Drawable)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(dp2px(200.0F), dp2px(2.0F));
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, dp2px(15.0F), 0, 0);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, localRelativeLayout.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    this.mProgressBar.setVisibility(8);
    paramRelativeLayout.addView(this.mProgressBar, (ViewGroup.LayoutParams)localObject1);
  }
  
  public void initTitleBarUI(RelativeLayout paramRelativeLayout, String paramString)
  {
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    TextView localTextView = new TextView(this.mActivity);
    int i = this.mLayoutID;
    this.mLayoutID = (i + 1);
    localTextView.setId(i);
    localTextView.setText(paramString);
    localTextView.setTextSize(2, 19.0F);
    localTextView.setTextColor(-1);
    localTextView.setIncludeFontPadding(false);
    localTextView.setVisibility(0);
    paramRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject1);
    paramString = new RelativeLayout.LayoutParams(dp2px(24.0F), dp2px(36.0F));
    paramString.addRule(5);
    paramString.addRule(15);
    paramString.leftMargin = dp2px(15.0F);
    this.mBackBtn = new ImageView(this.mActivity);
    localObject1 = this.mBackBtn;
    i = this.mLayoutID;
    this.mLayoutID = (i + 1);
    ((ImageView)localObject1).setId(i);
    this.mBackBtn.setScaleType(ImageView.ScaleType.FIT_CENTER);
    try
    {
      i = this.mActivity.getResources().getIdentifier("btn_back_normal", "drawable", this.mActivity.getPackageName());
      this.mBackBtn.setImageDrawable(this.mActivity.getResources().getDrawable(i));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.mBackBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DefaultLoadingUI.this.mActivity.onBackPressed();
        }
      });
      this.mBackBtn.setVisibility(0);
      paramRelativeLayout.addView(this.mBackBtn, paramString);
    }
  }
  
  public void initUI(Activity paramActivity, String paramString)
  {
    try
    {
      this.mActivity = paramActivity;
      paramActivity = new LinearLayout(this.mActivity);
      paramActivity.setOrientation(1);
      paramString = new LinearLayout.LayoutParams(-1, -1);
      paramActivity.setBackgroundResource(this.mActivity.getResources().getIdentifier("qb_od_loading", "drawable", this.mActivity.getPackageName()));
      this.mActivity.setContentView(paramActivity, paramString);
      this.mTitlebarLayout = new RelativeLayout(this.mActivity);
      paramString = new LinearLayout.LayoutParams(dp2px(50.0F), dp2px(50.0F));
      paramActivity.addView(this.mTitlebarLayout, paramString);
      this.mContentLayout = new RelativeLayout(this.mActivity);
      paramString = new LinearLayout.LayoutParams(-1, -1);
      paramActivity.addView(this.mContentLayout, paramString);
      this.mLoadingLayout = new RelativeLayout(this.mActivity);
      paramActivity = new LinearLayout.LayoutParams(-1, -1);
      this.mContentLayout.addView(this.mLoadingLayout, paramActivity);
      initLoadingUI(this.mLoadingLayout);
      this.mLoadingLayout.setVisibility(8);
      this.mErrorLayout = new RelativeLayout(this.mActivity);
      paramActivity = new LinearLayout.LayoutParams(-1, -1);
      this.mContentLayout.addView(this.mErrorLayout, paramActivity);
      initErrorUI(this.mErrorLayout);
      this.mErrorLayout.setVisibility(8);
      showLoadingUI();
      return;
    }
    catch (OutOfMemoryError paramActivity)
    {
      paramActivity.printStackTrace();
      DataReport.getInstance().reportException("oom");
    }
  }
  
  public void showErrorUI(String paramString)
  {
    TextView localTextView = (TextView)this.mActivity.findViewById(this.mErrorTextId);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    this.mLoadingLayout.setVisibility(8);
    this.mErrorLayout.setVisibility(0);
  }
  
  public void showLoadingUI()
  {
    this.mLoadingLayout.setVisibility(0);
    this.mErrorLayout.setVisibility(8);
  }
  
  public void unInitUI() {}
  
  public void updateProgress(int paramInt)
  {
    if (this.mProgressBar.getVisibility() == 8) {
      this.mProgressBar.setVisibility(0);
    }
    this.mProgressBar.setProgress(paramInt);
  }
  
  public void updateTips(String paramString, boolean paramBoolean)
  {
    if (this.mTipsView.getVisibility() == 8) {
      this.mTipsView.setVisibility(0);
    }
    if (paramBoolean) {
      this.mloadingCtrl.setVisibility(0);
    }
    for (;;)
    {
      this.mTipsView.setText(paramString);
      return;
      this.mloadingCtrl.setVisibility(8);
    }
  }
  
  public static abstract interface Event
  {
    public abstract void onRetry();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\entry\DefaultLoadingUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */