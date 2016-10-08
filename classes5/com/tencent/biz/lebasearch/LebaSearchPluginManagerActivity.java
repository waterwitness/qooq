package com.tencent.biz.lebasearch;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import hja;
import java.util.Iterator;
import java.util.List;

public class LebaSearchPluginManagerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static double a = 0.0D;
  static int jdField_a_of_type_Int = 0;
  public static final String a = "id";
  static double jdField_b_of_type_Double = 0.4D;
  static final int jdField_b_of_type_Int = 56;
  static final int c = 110;
  byte jdField_a_of_type_Byte;
  public float a;
  long jdField_a_of_type_Long = -1L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new hja(this);
  public View a;
  protected Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  protected TextView a;
  public AccountDetailBounceScrollView a;
  public LebaViewItem a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  List jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean = true;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private boolean jdField_b_of_type_Boolean;
  public ImageView c;
  protected TextView c;
  public int d = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 110;
    jdField_a_of_type_Double = 0.5D;
  }
  
  public LebaSearchPluginManagerActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = null;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: ldc 82
    //   4: invokevirtual 86	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   7: putfield 88	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   10: aload_0
    //   11: aload_0
    //   12: ldc 89
    //   14: invokevirtual 86	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   17: putfield 91	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   20: aload_0
    //   21: getfield 91	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   24: invokevirtual 97	android/view/View:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   27: new 99	hiv
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 100	hiv:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   35: invokevirtual 106	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   38: aload_0
    //   39: aload_0
    //   40: ldc 107
    //   42: invokespecial 108	com/tencent/mobileqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   45: checkcast 110	android/widget/LinearLayout
    //   48: putfield 112	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   51: aload_0
    //   52: getfield 91	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   55: invokevirtual 116	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   58: checkcast 118	android/widget/RelativeLayout$LayoutParams
    //   61: aload_0
    //   62: getfield 64	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:d	I
    //   65: i2d
    //   66: getstatic 48	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Double	D
    //   69: dmul
    //   70: d2i
    //   71: putfield 121	android/widget/RelativeLayout$LayoutParams:height	I
    //   74: aload_0
    //   75: getfield 112	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   78: aload_0
    //   79: getfield 64	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:d	I
    //   82: aload_0
    //   83: invokevirtual 125	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:getTitleBarHeight	()I
    //   86: isub
    //   87: i2f
    //   88: ldc 126
    //   90: aload_0
    //   91: getfield 128	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Float	F
    //   94: fmul
    //   95: fsub
    //   96: f2i
    //   97: invokevirtual 132	android/widget/LinearLayout:setMinimumHeight	(I)V
    //   100: aload_0
    //   101: aload_0
    //   102: ldc -123
    //   104: invokevirtual 86	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   107: checkcast 135	android/widget/Button
    //   110: putfield 137	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   113: aload_0
    //   114: getfield 137	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   117: aload_0
    //   118: invokevirtual 141	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   121: aload_0
    //   122: aload_0
    //   123: ldc -114
    //   125: invokevirtual 86	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   128: checkcast 144	android/widget/TextView
    //   131: putfield 146	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   134: aload_0
    //   135: aload_0
    //   136: ldc -109
    //   138: invokevirtual 86	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   141: checkcast 149	android/widget/ImageView
    //   144: putfield 151	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   147: aload_0
    //   148: aload_0
    //   149: ldc -104
    //   151: invokespecial 108	com/tencent/mobileqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   154: checkcast 149	android/widget/ImageView
    //   157: putfield 154	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   160: aload_0
    //   161: getfield 154	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   164: ldc -101
    //   166: invokevirtual 158	android/widget/ImageView:setBackgroundResource	(I)V
    //   169: aload_0
    //   170: aload_0
    //   171: ldc -97
    //   173: invokespecial 108	com/tencent/mobileqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   176: checkcast 149	android/widget/ImageView
    //   179: putfield 161	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   182: aload_0
    //   183: aload_0
    //   184: ldc -94
    //   186: invokevirtual 86	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   189: checkcast 144	android/widget/TextView
    //   192: putfield 164	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   195: aload_0
    //   196: aload_0
    //   197: ldc -91
    //   199: invokevirtual 86	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   202: checkcast 144	android/widget/TextView
    //   205: putfield 167	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   208: aload_0
    //   209: getfield 167	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   212: aload_0
    //   213: ldc -88
    //   215: invokevirtual 172	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:getString	(I)Ljava/lang/String;
    //   218: invokevirtual 176	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   221: aload_0
    //   222: getfield 167	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   225: aload_0
    //   226: invokevirtual 177	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   229: aload_0
    //   230: aload_0
    //   231: ldc -78
    //   233: invokespecial 108	com/tencent/mobileqq/app/BaseActivity:findViewById	(I)Landroid/view/View;
    //   236: checkcast 180	com/tencent/biz/pubaccount/AccountDetailBounceScrollView
    //   239: putfield 182	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView	Lcom/tencent/biz/pubaccount/AccountDetailBounceScrollView;
    //   242: aload_0
    //   243: getfield 68	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Boolean	Z
    //   246: ifne +66 -> 312
    //   249: aload_0
    //   250: getfield 151	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   253: invokevirtual 183	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   256: checkcast 118	android/widget/RelativeLayout$LayoutParams
    //   259: astore_1
    //   260: aload_0
    //   261: getfield 154	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   264: invokevirtual 183	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   267: checkcast 118	android/widget/RelativeLayout$LayoutParams
    //   270: astore_2
    //   271: aload_1
    //   272: ifnull +40 -> 312
    //   275: aload_2
    //   276: ifnull +36 -> 312
    //   279: ldc -72
    //   281: aload_0
    //   282: invokevirtual 188	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:getResources	()Landroid/content/res/Resources;
    //   285: invokestatic 193	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   288: istore 5
    //   290: aload_1
    //   291: aload_1
    //   292: getfield 196	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   295: iload 5
    //   297: iadd
    //   298: putfield 196	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   301: aload_2
    //   302: aload_2
    //   303: getfield 196	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   306: iload 5
    //   308: iadd
    //   309: putfield 196	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   312: aload_0
    //   313: getfield 182	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView	Lcom/tencent/biz/pubaccount/AccountDetailBounceScrollView;
    //   316: new 198	hiw
    //   319: dup
    //   320: aload_0
    //   321: invokespecial 199	hiw:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   324: invokevirtual 203	com/tencent/biz/pubaccount/AccountDetailBounceScrollView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   327: aload_0
    //   328: getfield 182	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView	Lcom/tencent/biz/pubaccount/AccountDetailBounceScrollView;
    //   331: new 205	hiy
    //   334: dup
    //   335: aload_0
    //   336: invokespecial 206	hiy:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   339: invokevirtual 210	com/tencent/biz/pubaccount/AccountDetailBounceScrollView:setOnScrollChangedListener	(Lcom/tencent/mobileqq/widget/BounceScrollView$OnScrollChangedListener;)V
    //   342: aload_0
    //   343: getfield 66	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem	Lcom/tencent/mobileqq/config/struct/LebaViewItem;
    //   346: getfield 215	com/tencent/mobileqq/config/struct/LebaViewItem:jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo	Lcom/tencent/mobileqq/data/ResourcePluginInfo;
    //   349: astore_2
    //   350: aload_2
    //   351: getfield 220	com/tencent/mobileqq/data/ResourcePluginInfo:strNewPluginDesc	Ljava/lang/String;
    //   354: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifne +14 -> 371
    //   360: aload_0
    //   361: getfield 146	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   364: aload_2
    //   365: getfield 220	com/tencent/mobileqq/data/ResourcePluginInfo:strNewPluginDesc	Ljava/lang/String;
    //   368: invokevirtual 176	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   371: aload_0
    //   372: getfield 228	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   375: ifnonnull +176 -> 551
    //   378: aconst_null
    //   379: astore_1
    //   380: aload_2
    //   381: getfield 231	com/tencent/mobileqq/data/ResourcePluginInfo:strNewPluginURL	Ljava/lang/String;
    //   384: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifne +218 -> 605
    //   390: aload_2
    //   391: getfield 231	com/tencent/mobileqq/data/ResourcePluginInfo:strNewPluginURL	Ljava/lang/String;
    //   394: bipush 110
    //   396: bipush 110
    //   398: aload_1
    //   399: aload_1
    //   400: iconst_0
    //   401: invokestatic 237	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   404: astore_3
    //   405: aload_3
    //   406: invokevirtual 240	com/tencent/image/URLDrawable:getStatus	()I
    //   409: iconst_1
    //   410: if_icmpne +160 -> 570
    //   413: aload_3
    //   414: invokestatic 245	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   417: astore_3
    //   418: aload_3
    //   419: bipush 110
    //   421: bipush 110
    //   423: invokestatic 248	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   426: astore 4
    //   428: aload_0
    //   429: getfield 151	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   432: aload 4
    //   434: invokevirtual 252	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   437: aload_3
    //   438: invokevirtual 257	android/graphics/Bitmap:recycle	()V
    //   441: aload_0
    //   442: getfield 164	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   445: aload_2
    //   446: getfield 260	com/tencent/mobileqq/data/ResourcePluginInfo:strResName	Ljava/lang/String;
    //   449: invokevirtual 176	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   452: aload_0
    //   453: ldc_w 261
    //   456: invokevirtual 86	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:findViewById	(I)Landroid/view/View;
    //   459: astore_1
    //   460: aload_0
    //   461: getfield 68	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Boolean	Z
    //   464: ifne +13 -> 477
    //   467: aload_1
    //   468: ldc_w 263
    //   471: invokestatic 269	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   474: invokevirtual 272	android/view/View:setBackgroundColor	(I)V
    //   477: aload_2
    //   478: getfield 275	com/tencent/mobileqq/data/ResourcePluginInfo:pluginBg	Ljava/lang/String;
    //   481: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   484: ifne +62 -> 546
    //   487: new 277	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   494: ldc_w 280
    //   497: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_2
    //   501: getfield 275	com/tencent/mobileqq/data/ResourcePluginInfo:pluginBg	Ljava/lang/String;
    //   504: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 269	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   513: istore 5
    //   515: aload_0
    //   516: getfield 91	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   519: iload 5
    //   521: invokevirtual 272	android/view/View:setBackgroundColor	(I)V
    //   524: aload_0
    //   525: getfield 182	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView	Lcom/tencent/biz/pubaccount/AccountDetailBounceScrollView;
    //   528: iload 5
    //   530: invokevirtual 289	com/tencent/biz/pubaccount/AccountDetailBounceScrollView:setBackgroundColor	(I)V
    //   533: aload_0
    //   534: getfield 68	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_Boolean	Z
    //   537: ifne +9 -> 546
    //   540: aload_1
    //   541: iload 5
    //   543: invokevirtual 272	android/view/View:setBackgroundColor	(I)V
    //   546: aload_0
    //   547: invokespecial 291	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:b	()V
    //   550: return
    //   551: new 293	android/graphics/drawable/BitmapDrawable
    //   554: dup
    //   555: aload_0
    //   556: invokevirtual 188	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:getResources	()Landroid/content/res/Resources;
    //   559: aload_0
    //   560: getfield 228	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   563: invokespecial 296	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   566: astore_1
    //   567: goto -187 -> 380
    //   570: aload_3
    //   571: new 298	hiz
    //   574: dup
    //   575: aload_0
    //   576: invokespecial 299	hiz:<init>	(Lcom/tencent/biz/lebasearch/LebaSearchPluginManagerActivity;)V
    //   579: invokevirtual 303	com/tencent/image/URLDrawable:setURLDrawableListener	(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V
    //   582: aload_0
    //   583: getfield 151	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   586: aload_3
    //   587: invokevirtual 307	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   590: goto -149 -> 441
    //   593: astore_3
    //   594: aload_0
    //   595: getfield 151	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   598: aload_1
    //   599: invokevirtual 307	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   602: goto -161 -> 441
    //   605: aload_0
    //   606: getfield 151	com/tencent/biz/lebasearch/LebaSearchPluginManagerActivity:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   609: aload_1
    //   610: invokevirtual 307	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   613: goto -172 -> 441
    //   616: astore_1
    //   617: goto -71 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	this	LebaSearchPluginManagerActivity
    //   259	351	1	localObject1	Object
    //   616	1	1	localException1	Exception
    //   270	231	2	localObject2	Object
    //   404	183	3	localObject3	Object
    //   593	1	3	localException2	Exception
    //   426	7	4	localBitmap	Bitmap
    //   288	254	5	i	int
    // Exception table:
    //   from	to	target	type
    //   390	441	593	java/lang/Exception
    //   570	590	593	java/lang/Exception
    //   487	546	616	java/lang/Exception
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.a(this.app, this, 1, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName, null, this.jdField_a_of_type_AndroidOsHandler);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = Utils.a(this.app, this, 2, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.pluginSetTips, this.jdField_a_of_type_AndroidOsHandler);
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing());
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private boolean a()
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.d = (getWindowManager().getDefaultDisplay().getHeight() - i);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", 0L);
    this.jdField_a_of_type_JavaUtilList = LebaShowListManager.a().a();
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
      if ((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId == this.jdField_a_of_type_Long)) {
        this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem == null) || (this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
      return false;
    }
    this.jdField_a_of_type_Byte = this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_Byte;
    try
    {
      localObject = BitmapFactory.decodeResource(getResources(), 2130839275);
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.b((Bitmap)localObject, 110, 110);
      ((Bitmap)localObject).recycle();
      if ((Build.BRAND.startsWith("samsung")) || (Build.BRAND.startsWith("Coolpad"))) {}
      for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
      {
        this.jdField_b_of_type_Boolean = Build.BOARD.equals("mx");
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_Byte == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838221);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131365010);
      if (this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_Byte == this.jdField_a_of_type_Byte) {
        break label75;
      }
    }
    label75:
    for (int i = -1;; i = 0)
    {
      setResult(i);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838208);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131365009);
      break;
    }
  }
  
  private void b(int paramInt)
  {
    int j;
    if (paramInt >= 0)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label53;
      }
      j = 460;
    }
    for (int i = 443;; i = (int)(0.29D * this.d))
    {
      paramInt = this.jdField_a_of_type_AndroidViewView.getHeight() - paramInt;
      if (Build.VERSION.SDK_INT >= 11) {
        break label88;
      }
      if (paramInt > i) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label53:
      j = (int)(0.39D * this.d);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    return;
    label88:
    if ((paramInt <= j) && (paramInt >= i))
    {
      float f;
      if (paramInt - i <= 0.01D * this.d) {
        f = 0.05F;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(f);
        return;
        if (paramInt - i <= 0.02D * this.d) {
          f = 0.15F;
        } else if (paramInt - i <= 0.03D * this.d) {
          f = 0.25F;
        } else if (paramInt - i <= 0.04D * this.d) {
          f = 0.35F;
        } else if (paramInt - i <= 0.05D * this.d) {
          f = 0.45F;
        } else if (paramInt - i <= 0.06D * this.d) {
          f = 0.55F;
        } else if (paramInt - i <= 0.07D * this.d) {
          f = 0.65F;
        } else if (paramInt - i <= this.d * 0.08D) {
          f = 0.75F;
        } else if (paramInt - i <= this.d * 0.08D) {
          f = 0.85F;
        } else {
          f = 0.95F;
        }
      }
    }
    if (paramInt < i)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    this.d = (getWindowManager().getDefaultDisplay().getHeight() - i);
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).height = ((int)(this.d * jdField_a_of_type_Double));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight((int)(this.d - getTitleBarHeight() - 56.0F * this.jdField_a_of_type_Float));
    i = this.jdField_a_of_type_AndroidViewView.getHeight() - paramInt;
    localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    double d1 = jdField_a_of_type_Double;
    double d2 = (jdField_b_of_type_Double * d1 - 0.05D) / (d1 - 0.3D);
    double d3 = (i - this.d * 0.3D) / ((d1 - 0.3D) * this.d);
    if (i <= this.d * 0.3D)
    {
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(30.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(30.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.d * 0.1D * 0.5D - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
      localLayoutParams.height = ((int)(32.0F * this.jdField_a_of_type_Float));
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - 1.0F * this.jdField_a_of_type_Float));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      return;
      if (i >= d1 * this.d)
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)(jdField_a_of_type_Int * this.jdField_a_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * jdField_b_of_type_Double - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + 10.0F * this.jdField_a_of_type_Float));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - 5.0F * this.jdField_a_of_type_Float));
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)((30.0D + (jdField_a_of_type_Int - 30) * d3) * this.jdField_a_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)((i - 0.3D * this.d) * d2 + this.d * 0.1D * 0.5D - ((RelativeLayout.LayoutParams)localObject).height / 2 + paramInt));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + (1.0D + 9.0D * d3) * this.jdField_a_of_type_Float));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - (1.0D + 9.0D * d3) * this.jdField_a_of_type_Float / 2.0D));
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    setContentView(2130903631);
    LebaShowListManager.d |= 0x1;
    if (!a())
    {
      finish();
      return false;
    }
    a();
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299503: 
      if (this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_Byte != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        return;
      }
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\lebasearch\LebaSearchPluginManagerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */