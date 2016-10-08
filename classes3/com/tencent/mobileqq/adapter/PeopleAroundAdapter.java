package com.tencent.mobileqq.adapter;

import AvatarInfo.QQHeadInfo;
import EncounterSvc.RespEncounterInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.dating.NewVoteAnimHelper.NewVoteHolder;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearpeople.EncounterHolder;
import com.tencent.mobileqq.nearpeople.EncounterHolder.EncounterHolderOpt;
import com.tencent.mobileqq.struct.AdData;
import com.tencent.mobileqq.struct.AdGroup;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BorderTextView;
import com.tencent.widget.ListView;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.observer.BusinessObserver;
import pow;
import poz;

public class PeopleAroundAdapter
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 3;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 74;
  public static int h;
  protected float a;
  protected ColorStateList a;
  public BitmapDrawable a;
  protected LayoutInflater a;
  public View.OnClickListener a;
  public View a;
  public AppInterface a;
  protected BaseActivity a;
  public NewVoteAnimHelper a;
  protected FaceDecoder a;
  protected IIconDecoder a;
  protected ListView a;
  protected StringBuilder a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  private Map jdField_a_of_type_JavaUtilMap;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver;
  public boolean a;
  protected ColorStateList b;
  protected StringBuilder b;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private List jdField_b_of_type_JavaUtilList;
  public boolean b;
  protected StringBuilder c;
  protected boolean c;
  protected StringBuilder d;
  private boolean d;
  protected StringBuilder e;
  protected int i;
  protected int j;
  public int k;
  int l;
  protected int m;
  
  public PeopleAroundAdapter(BaseActivity paramBaseActivity, FaceDecoder paramFaceDecoder, IIconDecoder paramIIconDecoder, boolean paramBoolean, View.OnClickListener paramOnClickListener, ListView paramListView)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.k = 0;
    this.c = new StringBuilder();
    this.jdField_d_of_type_JavaLangStringBuilder = new StringBuilder();
    this.e = new StringBuilder();
    this.l = 5;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new poz(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramBaseActivity.getAppInterface();
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("layout_inflater"));
    this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder = paramIIconDecoder;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().widthPixels;
    if (this.i > 480) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density;
      this.j = (this.i - (int)Math.ceil(205.0F * this.jdField_a_of_type_Float));
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
      ThreadManager.a(new pow(this), 5, null, true);
      this.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
      return;
    }
  }
  
  private int a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof NearbyActivity))
    {
      localObject = (NearbyFragment)((NearbyActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(0);
      if (localObject == null) {
        break label69;
      }
      localObject = ((NearbyFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
    }
    for (;;)
    {
      if (localObject != null)
      {
        return ((NearPeopleFilterActivity.NearPeopleFilters)localObject).l;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof VipMapRoamActivity)) {
          localObject = ((VipMapRoamActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters;
        }
      }
      else
      {
        return 0;
      }
      label69:
      localObject = null;
    }
  }
  
  /* Error */
  private void a(int paramInt, PeopleAroundAdapter.AdViewHolder paramAdViewHolder, AdData paramAdData)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_3
    //   2: putfield 187	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   5: aload_2
    //   6: getfield 190	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   9: invokevirtual 196	com/tencent/image/URLImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   12: checkcast 198	android/widget/RelativeLayout$LayoutParams
    //   15: astore 6
    //   17: aload_3
    //   18: getfield 204	com/tencent/mobileqq/struct/AdData:img_url	Ljava/lang/String;
    //   21: invokestatic 209	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;)Ljava/net/URL;
    //   24: astore 4
    //   26: invokestatic 215	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   29: astore 5
    //   31: aload_3
    //   32: getfield 218	com/tencent/mobileqq/struct/AdData:typeUI	I
    //   35: iconst_2
    //   36: if_icmpeq +45 -> 81
    //   39: aload_3
    //   40: getfield 221	com/tencent/mobileqq/struct/AdData:picType	I
    //   43: ifne +38 -> 81
    //   46: aload_0
    //   47: getfield 223	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable	Landroid/graphics/drawable/BitmapDrawable;
    //   50: ifnonnull +13 -> 63
    //   53: aload_0
    //   54: invokestatic 228	com/tencent/mobileqq/utils/ImageUtil:a	()Landroid/graphics/drawable/Drawable;
    //   57: checkcast 230	android/graphics/drawable/BitmapDrawable
    //   60: putfield 223	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable	Landroid/graphics/drawable/BitmapDrawable;
    //   63: aload 5
    //   65: aload_0
    //   66: getfield 223	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable	Landroid/graphics/drawable/BitmapDrawable;
    //   69: putfield 234	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   72: aload 5
    //   74: aload_0
    //   75: getfield 223	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable	Landroid/graphics/drawable/BitmapDrawable;
    //   78: putfield 237	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   81: aload 4
    //   83: aload 5
    //   85: invokestatic 243	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   88: astore 4
    //   90: aload 4
    //   92: astore 5
    //   94: aload 4
    //   96: ifnonnull +12 -> 108
    //   99: aload_3
    //   100: getfield 204	com/tencent/mobileqq/struct/AdData:img_url	Ljava/lang/String;
    //   103: invokestatic 248	com/tencent/mobileqq/transfile/URLDrawableHelper:a	(Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   106: astore 5
    //   108: aload 5
    //   110: new 250	com/tencent/mobileqq/nearby/ImgDownloadListener
    //   113: dup
    //   114: aload_0
    //   115: getfield 82	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   118: ldc -4
    //   120: invokespecial 255	com/tencent/mobileqq/nearby/ImgDownloadListener:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   123: invokevirtual 259	com/tencent/image/URLDrawable:setDownloadListener	(Lcom/tencent/image/URLDrawable$DownloadListener;)V
    //   126: aload_3
    //   127: getfield 218	com/tencent/mobileqq/struct/AdData:typeUI	I
    //   130: iconst_2
    //   131: if_icmpne +543 -> 674
    //   134: aload 5
    //   136: invokevirtual 262	com/tencent/image/URLDrawable:getStatus	()I
    //   139: iconst_1
    //   140: if_icmpne +524 -> 664
    //   143: aload 6
    //   145: aload_0
    //   146: getfield 125	com/tencent/mobileqq/adapter/PeopleAroundAdapter:i	I
    //   149: aload_0
    //   150: getfield 82	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   153: ldc_w 263
    //   156: invokestatic 268	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   159: isub
    //   160: aload 5
    //   162: invokevirtual 271	com/tencent/image/URLDrawable:getIntrinsicHeight	()I
    //   165: imul
    //   166: i2f
    //   167: fconst_1
    //   168: fmul
    //   169: aload 5
    //   171: invokevirtual 274	com/tencent/image/URLDrawable:getIntrinsicWidth	()I
    //   174: i2f
    //   175: fdiv
    //   176: f2i
    //   177: putfield 277	android/widget/RelativeLayout$LayoutParams:height	I
    //   180: aload 6
    //   182: iconst_m1
    //   183: putfield 280	android/widget/RelativeLayout$LayoutParams:width	I
    //   186: iconst_4
    //   187: istore 8
    //   189: aload_2
    //   190: getfield 190	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   193: aload 6
    //   195: invokevirtual 284	com/tencent/image/URLImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   198: aload_2
    //   199: getfield 190	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   202: aload 5
    //   204: invokevirtual 288	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   207: aload_0
    //   208: aload_3
    //   209: getfield 291	com/tencent/mobileqq/struct/AdData:title	Ljava/lang/String;
    //   212: invokespecial 294	com/tencent/mobileqq/adapter/PeopleAroundAdapter:a	(Ljava/lang/String;)Z
    //   215: ifne +742 -> 957
    //   218: aload_3
    //   219: getfield 297	com/tencent/mobileqq/struct/AdData:hasAvatarAnimation	Ljava/lang/String;
    //   222: ifnull +735 -> 957
    //   225: aload_3
    //   226: getfield 297	com/tencent/mobileqq/struct/AdData:hasAvatarAnimation	Ljava/lang/String;
    //   229: ldc_w 299
    //   232: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   235: ifeq +722 -> 957
    //   238: aload_3
    //   239: getfield 308	com/tencent/mobileqq/struct/AdData:avatarBgGif	Ljava/lang/String;
    //   242: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +712 -> 957
    //   248: aload_3
    //   249: getfield 308	com/tencent/mobileqq/struct/AdData:avatarBgGif	Ljava/lang/String;
    //   252: invokestatic 209	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;)Ljava/net/URL;
    //   255: astore 4
    //   257: invokestatic 215	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   260: astore 5
    //   262: aload 5
    //   264: iconst_1
    //   265: putfield 317	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   268: aload 4
    //   270: aload 5
    //   272: invokestatic 243	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   275: astore 4
    //   277: aload 4
    //   279: ldc_w 319
    //   282: ldc_w 299
    //   285: invokevirtual 323	com/tencent/image/URLDrawable:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 4
    //   290: astore 5
    //   292: aload 4
    //   294: invokevirtual 326	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   297: instanceof 328
    //   300: ifeq +21 -> 321
    //   303: aload 4
    //   305: invokevirtual 326	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   308: checkcast 328	com/tencent/image/GifDrawable
    //   311: invokevirtual 332	com/tencent/image/GifDrawable:getImage	()Lcom/tencent/image/AbstractGifImage;
    //   314: invokevirtual 337	com/tencent/image/AbstractGifImage:reset	()V
    //   317: aload 4
    //   319: astore 5
    //   321: aload 5
    //   323: ifnull +20 -> 343
    //   326: aload_2
    //   327: getfield 339	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_c_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   330: aload 5
    //   332: invokevirtual 288	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   335: aload_2
    //   336: getfield 339	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_c_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   339: iconst_0
    //   340: invokevirtual 343	com/tencent/image/URLImageView:setVisibility	(I)V
    //   343: aload_0
    //   344: getfield 82	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   347: ldc_w 344
    //   350: invokestatic 350	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
    //   353: astore 4
    //   355: aload_2
    //   356: getfield 190	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   359: aload 4
    //   361: invokevirtual 354	com/tencent/image/URLImageView:setAnimation	(Landroid/view/animation/Animation;)V
    //   364: aload 4
    //   366: invokevirtual 359	android/view/animation/Animation:start	()V
    //   369: aload_0
    //   370: getfield 108	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   373: aload_3
    //   374: getfield 291	com/tencent/mobileqq/struct/AdData:title	Ljava/lang/String;
    //   377: invokeinterface 364 2 0
    //   382: pop
    //   383: aload_2
    //   384: getfield 367	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetBorderTextView	Lcom/tencent/widget/BorderTextView;
    //   387: invokevirtual 372	com/tencent/widget/BorderTextView:getVisibility	()I
    //   390: iload 8
    //   392: if_icmpeq +12 -> 404
    //   395: aload_2
    //   396: getfield 367	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetBorderTextView	Lcom/tencent/widget/BorderTextView;
    //   399: iload 8
    //   401: invokevirtual 373	com/tencent/widget/BorderTextView:setVisibility	(I)V
    //   404: aload_2
    //   405: getfield 376	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   408: invokevirtual 379	com/tencent/widget/SingleLineTextView:getVisibility	()I
    //   411: iload 8
    //   413: if_icmpeq +12 -> 425
    //   416: aload_2
    //   417: getfield 376	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   420: iload 8
    //   422: invokevirtual 380	com/tencent/widget/SingleLineTextView:setVisibility	(I)V
    //   425: aload_2
    //   426: getfield 382	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_c_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   429: invokevirtual 379	com/tencent/widget/SingleLineTextView:getVisibility	()I
    //   432: iload 8
    //   434: if_icmpeq +12 -> 446
    //   437: aload_2
    //   438: getfield 382	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_c_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   441: iload 8
    //   443: invokevirtual 380	com/tencent/widget/SingleLineTextView:setVisibility	(I)V
    //   446: aload_2
    //   447: getfield 384	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_d_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   450: invokevirtual 379	com/tencent/widget/SingleLineTextView:getVisibility	()I
    //   453: iload 8
    //   455: if_icmpeq +12 -> 467
    //   458: aload_2
    //   459: getfield 384	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_d_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   462: iload 8
    //   464: invokevirtual 380	com/tencent/widget/SingleLineTextView:setVisibility	(I)V
    //   467: aload_2
    //   468: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   471: invokevirtual 379	com/tencent/widget/SingleLineTextView:getVisibility	()I
    //   474: iload 8
    //   476: if_icmpeq +12 -> 488
    //   479: aload_2
    //   480: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   483: iload 8
    //   485: invokevirtual 380	com/tencent/widget/SingleLineTextView:setVisibility	(I)V
    //   488: aload_3
    //   489: getfield 389	com/tencent/mobileqq/struct/AdData:nowBoardcastGif	Ljava/lang/String;
    //   492: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   495: ifne +524 -> 1019
    //   498: aload_3
    //   499: getfield 389	com/tencent/mobileqq/struct/AdData:nowBoardcastGif	Ljava/lang/String;
    //   502: invokestatic 209	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;)Ljava/net/URL;
    //   505: astore 4
    //   507: invokestatic 215	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   510: astore 5
    //   512: aload 5
    //   514: iconst_1
    //   515: putfield 317	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   518: aload 4
    //   520: aload 5
    //   522: invokestatic 243	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   525: astore 4
    //   527: aload 4
    //   529: ifnull +100 -> 629
    //   532: aload_2
    //   533: getfield 367	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetBorderTextView	Lcom/tencent/widget/BorderTextView;
    //   536: bipush 8
    //   538: invokevirtual 373	com/tencent/widget/BorderTextView:setVisibility	(I)V
    //   541: aload_2
    //   542: getfield 391	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   545: aload 4
    //   547: invokevirtual 288	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   550: aload_2
    //   551: getfield 391	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   554: iconst_0
    //   555: invokevirtual 343	com/tencent/image/URLImageView:setVisibility	(I)V
    //   558: aload_2
    //   559: getfield 393	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_e_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   562: ldc_w 395
    //   565: invokevirtual 399	com/tencent/widget/SingleLineTextView:setText	(Ljava/lang/CharSequence;)V
    //   568: aload_2
    //   569: getfield 393	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_e_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   572: iconst_0
    //   573: invokevirtual 380	com/tencent/widget/SingleLineTextView:setVisibility	(I)V
    //   576: aload_2
    //   577: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   580: invokevirtual 400	com/tencent/widget/SingleLineTextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   583: checkcast 198	android/widget/RelativeLayout$LayoutParams
    //   586: astore 4
    //   588: aload 4
    //   590: iconst_0
    //   591: ldc_w 401
    //   594: invokestatic 406	com/tencent/mobileqq/utils/ViewUtils:b	(F)I
    //   597: ldc_w 407
    //   600: invokestatic 406	com/tencent/mobileqq/utils/ViewUtils:b	(F)I
    //   603: iconst_0
    //   604: invokevirtual 411	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   607: aload_2
    //   608: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   611: aload 4
    //   613: invokevirtual 412	com/tencent/widget/SingleLineTextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   616: aload_2
    //   617: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   620: ldc_w 414
    //   623: invokestatic 420	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   626: invokevirtual 423	com/tencent/widget/SingleLineTextView:setTextColor	(I)V
    //   629: new 425	poy
    //   632: dup
    //   633: aload_0
    //   634: iload_1
    //   635: aload_3
    //   636: invokespecial 428	poy:<init>	(Lcom/tencent/mobileqq/adapter/PeopleAroundAdapter;ILcom/tencent/mobileqq/struct/AdData;)V
    //   639: aconst_null
    //   640: iconst_1
    //   641: invokestatic 431	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   644: return
    //   645: astore 4
    //   647: invokestatic 437	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   650: ifeq +8 -> 658
    //   653: aload 4
    //   655: invokevirtual 440	java/net/MalformedURLException:printStackTrace	()V
    //   658: aconst_null
    //   659: astore 4
    //   661: goto -571 -> 90
    //   664: aload 6
    //   666: bipush -2
    //   668: putfield 277	android/widget/RelativeLayout$LayoutParams:height	I
    //   671: goto -491 -> 180
    //   674: aload_2
    //   675: getfield 376	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   678: aload_3
    //   679: getfield 291	com/tencent/mobileqq/struct/AdData:title	Ljava/lang/String;
    //   682: invokevirtual 399	com/tencent/widget/SingleLineTextView:setText	(Ljava/lang/CharSequence;)V
    //   685: aload_2
    //   686: getfield 382	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_c_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   689: aload_3
    //   690: getfield 443	com/tencent/mobileqq/struct/AdData:content	Ljava/lang/String;
    //   693: invokevirtual 399	com/tencent/widget/SingleLineTextView:setText	(Ljava/lang/CharSequence;)V
    //   696: aload_3
    //   697: getfield 446	com/tencent/mobileqq/struct/AdData:contentColor	Ljava/lang/String;
    //   700: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   703: ifne +17 -> 720
    //   706: aload_2
    //   707: getfield 382	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_c_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   710: aload_3
    //   711: getfield 446	com/tencent/mobileqq/struct/AdData:contentColor	Ljava/lang/String;
    //   714: invokestatic 420	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   717: invokevirtual 423	com/tencent/widget/SingleLineTextView:setTextColor	(I)V
    //   720: aload_2
    //   721: getfield 384	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_d_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   724: aload_3
    //   725: getfield 449	com/tencent/mobileqq/struct/AdData:content2	Ljava/lang/String;
    //   728: invokevirtual 399	com/tencent/widget/SingleLineTextView:setText	(Ljava/lang/CharSequence;)V
    //   731: aload_2
    //   732: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   735: astore 7
    //   737: aload_3
    //   738: getfield 452	com/tencent/mobileqq/struct/AdData:distance	Ljava/lang/String;
    //   741: ifnull +158 -> 899
    //   744: aload_3
    //   745: getfield 452	com/tencent/mobileqq/struct/AdData:distance	Ljava/lang/String;
    //   748: astore 4
    //   750: aload 7
    //   752: aload 4
    //   754: invokevirtual 399	com/tencent/widget/SingleLineTextView:setText	(Ljava/lang/CharSequence;)V
    //   757: aload_2
    //   758: getfield 367	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetBorderTextView	Lcom/tencent/widget/BorderTextView;
    //   761: aload_3
    //   762: getfield 455	com/tencent/mobileqq/struct/AdData:bgColor	I
    //   765: invokevirtual 456	com/tencent/widget/BorderTextView:setTextColor	(I)V
    //   768: aload_2
    //   769: getfield 367	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetBorderTextView	Lcom/tencent/widget/BorderTextView;
    //   772: aload_3
    //   773: getfield 455	com/tencent/mobileqq/struct/AdData:bgColor	I
    //   776: invokevirtual 459	com/tencent/widget/BorderTextView:setBorderColor	(I)V
    //   779: aload_2
    //   780: getfield 367	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentWidgetBorderTextView	Lcom/tencent/widget/BorderTextView;
    //   783: aload_3
    //   784: getfield 462	com/tencent/mobileqq/struct/AdData:wording	Ljava/lang/String;
    //   787: invokevirtual 463	com/tencent/widget/BorderTextView:setText	(Ljava/lang/CharSequence;)V
    //   790: aload_3
    //   791: getfield 466	com/tencent/mobileqq/struct/AdData:ad_source	I
    //   794: ifne +31 -> 825
    //   797: aload_3
    //   798: getfield 469	com/tencent/mobileqq/struct/AdData:hasShow	Z
    //   801: ifne +24 -> 825
    //   804: aload_3
    //   805: iconst_1
    //   806: putfield 469	com/tencent/mobileqq/struct/AdData:hasShow	Z
    //   809: new 471	pox
    //   812: dup
    //   813: aload_0
    //   814: aload_3
    //   815: iload_1
    //   816: invokespecial 474	pox:<init>	(Lcom/tencent/mobileqq/adapter/PeopleAroundAdapter;Lcom/tencent/mobileqq/struct/AdData;I)V
    //   819: iconst_2
    //   820: aconst_null
    //   821: iconst_0
    //   822: invokestatic 156	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   825: aload 6
    //   827: aload_0
    //   828: getfield 82	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   831: ldc_w 475
    //   834: invokestatic 268	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   837: putfield 280	android/widget/RelativeLayout$LayoutParams:width	I
    //   840: aload 6
    //   842: aload 6
    //   844: getfield 280	android/widget/RelativeLayout$LayoutParams:width	I
    //   847: putfield 277	android/widget/RelativeLayout$LayoutParams:height	I
    //   850: aload_3
    //   851: getfield 221	com/tencent/mobileqq/struct/AdData:picType	I
    //   854: ifne +29 -> 883
    //   857: aload 5
    //   859: aload 6
    //   861: getfield 280	android/widget/RelativeLayout$LayoutParams:width	I
    //   864: aload 6
    //   866: getfield 277	android/widget/RelativeLayout$LayoutParams:height	I
    //   869: invokestatic 480	com/tencent/mobileqq/urldrawable/URLDrawableDecodeHandler:a	(II)[I
    //   872: invokevirtual 484	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   875: aload 5
    //   877: getstatic 487	com/tencent/mobileqq/urldrawable/URLDrawableDecodeHandler:h	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   880: invokevirtual 491	com/tencent/image/URLDrawable:setDecodeHandler	(Lcom/tencent/image/DownloadParams$DecodeHandler;)V
    //   883: iconst_0
    //   884: istore 8
    //   886: goto -697 -> 189
    //   889: astore 4
    //   891: aload 4
    //   893: invokevirtual 492	java/lang/Exception:printStackTrace	()V
    //   896: goto -176 -> 720
    //   899: ldc_w 494
    //   902: astore 4
    //   904: goto -154 -> 750
    //   907: astore 6
    //   909: aconst_null
    //   910: astore 4
    //   912: aload 4
    //   914: astore 5
    //   916: invokestatic 497	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   919: ifeq -598 -> 321
    //   922: ldc_w 499
    //   925: iconst_2
    //   926: new 57	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   933: ldc_w 501
    //   936: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload 6
    //   941: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: invokestatic 515	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   950: aload 4
    //   952: astore 5
    //   954: goto -633 -> 321
    //   957: aload_2
    //   958: getfield 339	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_c_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   961: bipush 8
    //   963: invokevirtual 343	com/tencent/image/URLImageView:setVisibility	(I)V
    //   966: aload_2
    //   967: getfield 190	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   970: aconst_null
    //   971: invokevirtual 354	com/tencent/image/URLImageView:setAnimation	(Landroid/view/animation/Animation;)V
    //   974: goto -591 -> 383
    //   977: astore 4
    //   979: invokestatic 497	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   982: ifeq +31 -> 1013
    //   985: ldc_w 499
    //   988: iconst_2
    //   989: new 57	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   996: ldc_w 501
    //   999: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload 4
    //   1004: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: invokestatic 515	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1013: aconst_null
    //   1014: astore 4
    //   1016: goto -489 -> 527
    //   1019: aload_2
    //   1020: getfield 391	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   1023: bipush 8
    //   1025: invokevirtual 343	com/tencent/image/URLImageView:setVisibility	(I)V
    //   1028: aload_2
    //   1029: getfield 393	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_e_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   1032: bipush 8
    //   1034: invokevirtual 380	com/tencent/widget/SingleLineTextView:setVisibility	(I)V
    //   1037: aload_2
    //   1038: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   1041: invokevirtual 400	com/tencent/widget/SingleLineTextView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1044: checkcast 198	android/widget/RelativeLayout$LayoutParams
    //   1047: astore 4
    //   1049: aload 4
    //   1051: iconst_0
    //   1052: ldc_w 516
    //   1055: invokestatic 406	com/tencent/mobileqq/utils/ViewUtils:b	(F)I
    //   1058: ldc_w 517
    //   1061: invokestatic 406	com/tencent/mobileqq/utils/ViewUtils:b	(F)I
    //   1064: iconst_0
    //   1065: invokevirtual 411	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   1068: aload_2
    //   1069: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   1072: aload 4
    //   1074: invokevirtual 412	com/tencent/widget/SingleLineTextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1077: aload_2
    //   1078: getfield 386	com/tencent/mobileqq/adapter/PeopleAroundAdapter$AdViewHolder:jdField_b_of_type_ComTencentWidgetSingleLineTextView	Lcom/tencent/widget/SingleLineTextView;
    //   1081: ldc_w 519
    //   1084: invokestatic 420	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1087: invokevirtual 423	com/tencent/widget/SingleLineTextView:setTextColor	(I)V
    //   1090: goto -461 -> 629
    //   1093: astore 6
    //   1095: goto -183 -> 912
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1098	0	this	PeopleAroundAdapter
    //   0	1098	1	paramInt	int
    //   0	1098	2	paramAdViewHolder	PeopleAroundAdapter.AdViewHolder
    //   0	1098	3	paramAdData	AdData
    //   24	588	4	localObject1	Object
    //   645	9	4	localMalformedURLException1	java.net.MalformedURLException
    //   659	94	4	str1	String
    //   889	3	4	localException	Exception
    //   902	49	4	str2	String
    //   977	26	4	localMalformedURLException2	java.net.MalformedURLException
    //   1014	59	4	localLayoutParams1	RelativeLayout.LayoutParams
    //   29	924	5	localObject2	Object
    //   15	850	6	localLayoutParams2	RelativeLayout.LayoutParams
    //   907	33	6	localMalformedURLException3	java.net.MalformedURLException
    //   1093	1	6	localMalformedURLException4	java.net.MalformedURLException
    //   735	16	7	localSingleLineTextView	SingleLineTextView
    //   187	698	8	n	int
    // Exception table:
    //   from	to	target	type
    //   17	63	645	java/net/MalformedURLException
    //   63	81	645	java/net/MalformedURLException
    //   81	90	645	java/net/MalformedURLException
    //   706	720	889	java/lang/Exception
    //   248	277	907	java/net/MalformedURLException
    //   498	527	977	java/net/MalformedURLException
    //   277	288	1093	java/net/MalformedURLException
    //   292	317	1093	java/net/MalformedURLException
  }
  
  private void a(PeopleAroundAdapter.ViewHolder paramViewHolder, RespEncounterInfo paramRespEncounterInfo)
  {
    paramRespEncounterInfo = paramViewHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView;
    EncounterHolder.EncounterHolderOpt localEncounterHolderOpt = (EncounterHolder.EncounterHolderOpt)paramViewHolder.jdField_a_of_type_JavaLangObject;
    paramViewHolder.jdField_c_of_type_Int = localEncounterHolderOpt.jdField_a_of_type_Int;
    int n;
    if (!TextUtils.isEmpty(localEncounterHolderOpt.jdField_a_of_type_JavaLangString))
    {
      n = 1;
      a(paramRespEncounterInfo, localEncounterHolderOpt.jdField_a_of_type_Int);
    }
    while ((!TextUtils.isEmpty(localEncounterHolderOpt.jdField_a_of_type_AndroidTextSpannableString)) || (n != 0))
    {
      paramRespEncounterInfo.setText(localEncounterHolderOpt.jdField_a_of_type_AndroidTextSpannableString);
      paramRespEncounterInfo.setVisibility(0);
      return;
      paramRespEncounterInfo.setCompoundDrawables(null, null);
      n = 0;
    }
    paramRespEncounterInfo.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilList.size() < 1) {
      return false;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof NearbyActivity))
    {
      NearbyFragment localNearbyFragment = (NearbyFragment)((NearbyActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(0);
      if ((localNearbyFragment != null) && (localNearbyFragment.jdField_a_of_type_JavaUtilArrayList != null) && (localNearbyFragment.jdField_a_of_type_JavaUtilArrayList.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  void a(int paramInt)
  {
    if (!(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof NearbyActivity)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (NearbyFragment)((NearbyActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a(0);
      } while ((localObject == null) || (((NearbyFragment)localObject).w == 2));
      localObject = (NearbyReportManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(218);
    } while (localObject == null);
    RespEncounterInfo localRespEncounterInfo = ((EncounterHolder.EncounterHolderOpt)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqNearpeopleEncounterHolder.encounter;
    ((NearbyReportManager)localObject).a(localRespEncounterInfo.tiny_id, paramInt, localRespEncounterInfo.ruleId);
  }
  
  protected void a(int paramInt, PeopleAroundAdapter.ViewHolder paramViewHolder, Object paramObject)
  {
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setVisibility(0);
    paramViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
    paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    EncounterHolder localEncounterHolder = ((EncounterHolder.EncounterHolderOpt)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqNearpeopleEncounterHolder;
    RespEncounterInfo localRespEncounterInfo = localEncounterHolder.encounter;
    label129:
    label146:
    label182:
    int n;
    label375:
    Object localObject;
    if (localRespEncounterInfo.tiny_id > 0L)
    {
      paramViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(localRespEncounterInfo.tiny_id);
      paramViewHolder.jdField_a_of_type_Int = 32;
      if (TextUtils.isEmpty(localRespEncounterInfo.strNick)) {
        break label1443;
      }
      paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRespEncounterInfo.strNick.trim());
      if (AppSetting.j) {
        this.jdField_b_of_type_JavaLangStringBuilder.append(localRespEncounterInfo.strNick.trim());
      }
      if (localRespEncounterInfo.authFlag != 1) {
        break label1456;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (localRespEncounterInfo.god_flag != 1) {
        break label1481;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (localRespEncounterInfo.cSex != 1) {
        break label1468;
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841138);
      if (getItemViewType(paramInt) != 0) {
        break label1493;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0);
      }
      paramViewHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(2130838705, 0);
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.c = false;
      n = 0;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface)) {
        n = ((NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).b();
      }
      if (n == 1) {
        this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.c = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a(localRespEncounterInfo.iVoteNum, localRespEncounterInfo.iVoteIncrement, paramViewHolder.jdField_a_of_type_AndroidViewView, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView, paramViewHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView, null);
      if (AppSetting.j)
      {
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("收到").append(localRespEncounterInfo.iVoteNum).append("个赞");
        if (localRespEncounterInfo.iVoteIncrement > 0) {
          this.jdField_b_of_type_JavaLangStringBuilder.append(" 新增").append(localRespEncounterInfo.iVoteIncrement).append("个赞");
        }
      }
      n = this.j;
      paramObject = (VipOpenInfo)localRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      localObject = (VipOpenInfo)localRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if ((paramObject == null) || (!((VipOpenInfo)paramObject).bOpen)) {
        break label1585;
      }
      n -= (int)Math.ceil(33.5F * this.jdField_a_of_type_Float);
    }
    label453:
    label572:
    label665:
    label700:
    label764:
    label795:
    label902:
    label925:
    label970:
    label994:
    label1007:
    label1156:
    label1188:
    label1443:
    label1456:
    label1468:
    label1481:
    label1493:
    label1585:
    label1717:
    label1765:
    label1816:
    label1851:
    label1863:
    label1875:
    label1949:
    label1976:
    label2006:
    label2049:
    label2059:
    for (;;)
    {
      int i1 = n;
      if (localRespEncounterInfo.authFlag == 1) {
        i1 = n - (int)Math.ceil(20.0F * this.jdField_a_of_type_Float);
      }
      n = i1;
      if (localRespEncounterInfo.watch_color != 0) {
        n = i1 - (int)Math.ceil(16.0F * this.jdField_a_of_type_Float);
      }
      paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setMaxWidth(n);
      n = 0;
      if (localEncounterHolder.secondLine.length() > 0) {
        n = 1;
      }
      if (AppSetting.j) {}
      switch (localRespEncounterInfo.cSex)
      {
      default: 
        if ((localRespEncounterInfo.cAge > 0) && (AppSetting.j)) {
          this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(localRespEncounterInfo.cAge).append("岁");
        }
        paramObject = "";
        if (localEncounterHolder.showCommon)
        {
          i1 = n + 1;
          paramViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_Boolean)
          {
            paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localEncounterHolder.commonComplete);
            paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localEncounterHolder.commonId));
            n = i1;
            if (AppSetting.j)
            {
              paramObject = localEncounterHolder.commonComplete;
              n = i1;
            }
            if (AppSetting.j)
            {
              if (localRespEncounterInfo.constellation != 0)
              {
                localObject = ProfileCardUtil.a(localRespEncounterInfo.constellation);
                if (AppSetting.j) {
                  this.jdField_b_of_type_JavaLangStringBuilder.append(",").append((String)localObject);
                }
              }
              if ((localRespEncounterInfo.profession_id > 0) && (localRespEncounterInfo.profession_id < 14)) {
                break label1717;
              }
            }
            if (TextUtils.isEmpty(localEncounterHolder.secondLine)) {
              break label1765;
            }
            paramViewHolder.jdField_e_of_type_ComTencentWidgetSingleLineTextView.setText(localEncounterHolder.secondLine);
            paramViewHolder.jdField_e_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
            if (localRespEncounterInfo.charm_shown != 1) {
              break label1816;
            }
            if (paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.getVisibility() != 0) {
              paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            i1 = ((Integer)paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.getTag()).intValue();
            if (localRespEncounterInfo.charm_level != i1) {
              paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localRespEncounterInfo.charm_level));
            }
            switch (localRespEncounterInfo.charm_level)
            {
            default: 
              paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840884);
              if (AppSetting.j) {
                this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("拥有魅力勋章");
              }
              if ((AppSetting.j) && (!TextUtils.isEmpty((CharSequence)paramObject))) {
                this.jdField_b_of_type_JavaLangStringBuilder.append(",").append((String)paramObject);
              }
              if (localRespEncounterInfo.watch_color == 0)
              {
                paramViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
                if (localRespEncounterInfo.nFaceNum < 6) {
                  break label1851;
                }
                n += 1;
                paramViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
                if (n <= 0) {
                  break label1863;
                }
                paramViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                a(localRespEncounterInfo.vipBaseInfo, paramViewHolder.jdField_c_of_type_AndroidWidgetImageView, paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView);
                n = a();
                paramObject = localEncounterHolder.thirdLine;
                localObject = (RelativeLayout.LayoutParams)paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
                if (n <= 0) {
                  break label1875;
                }
                String str = NearPeopleFilterActivity.NearPeopleFilters.b[n];
                paramViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setVisibility(0);
                paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                if (!paramViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.a().equals(str))
                {
                  paramViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setBackgroundResource(NearPeopleFilterActivity.NearPeopleFilters.a[n]);
                  paramViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setText(str);
                }
                if (!paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.a().equals(paramObject)) {
                  paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)paramObject);
                }
                ((RelativeLayout.LayoutParams)localObject).addRule(1, paramViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.getId());
                ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
                if (!localEncounterHolder.showDeclaration) {
                  break label1949;
                }
                paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
                paramViewHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
                a(paramViewHolder, localRespEncounterInfo);
                paramViewHolder.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setTag(Boolean.valueOf(false));
                a(localEncounterHolder, paramViewHolder.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView);
                if (AppSetting.j)
                {
                  if (!localEncounterHolder.showDeclaration) {
                    break label1976;
                  }
                  this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("交友宣言").append(paramViewHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.a()).append(" ");
                }
              }
              break;
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (getItemViewType(paramInt) != 0) {
          this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(localRespEncounterInfo.strDescription);
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_b_of_type_JavaLangStringBuilder.toString());
        if (QLog.isColorLevel()) {
          NearbyUtils.a("PeopleAroundAdapter", "talckback", new Object[] { this.jdField_b_of_type_JavaLangStringBuilder.toString() });
        }
        if ((localRespEncounterInfo.host_flag != 1) || (localRespEncounterInfo.host_online_flag != 1)) {
          break label2049;
        }
        paramViewHolder.jdField_a_of_type_ComTencentWidgetBorderTextView.setVisibility(0);
        if (localRespEncounterInfo.tiny_id > 0L)
        {
          if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof NearbyAppInterface)) {
            break label2006;
          }
          ((NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).c("P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "list_pv", 0, 0, String.valueOf(localRespEncounterInfo.tiny_id), String.valueOf(paramInt), "yes", "android");
        }
        return;
        if (localRespEncounterInfo.lEctID <= 0L) {
          break;
        }
        paramViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(localRespEncounterInfo.lEctID);
        break;
        paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        break label129;
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label146;
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841137);
        break label182;
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label182;
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.a(paramViewHolder.jdField_a_of_type_AndroidViewView, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView, paramViewHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView, null)))
        {
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.c();
          this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.a.a();
        }
        paramViewHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setText(localRespEncounterInfo.strDescription);
        paramViewHolder.jdField_c_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        paramViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label375;
        if ((localObject == null) || (!((VipOpenInfo)localObject).bOpen)) {
          break label2059;
        }
        n -= (int)Math.ceil(28.5F * this.jdField_a_of_type_Float);
        break label453;
        if (!AppSetting.j) {
          break label572;
        }
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(",男");
        break label572;
        if (!AppSetting.j) {
          break label572;
        }
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("女");
        break label572;
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localEncounterHolder.commonSuffix);
        break label665;
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(0));
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break label700;
        localObject = com.tencent.mobileqq.util.NearbyProfileUtil.e[localRespEncounterInfo.profession_id];
        if (!AppSetting.j) {
          break label764;
        }
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append("职业").append(" ").append((String)localObject);
        break label764;
        paramViewHolder.jdField_e_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label795;
        paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840889);
        break label902;
        paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840890);
        break label902;
        paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130840891);
        break label902;
        if (paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.getVisibility() == 8) {
          break label925;
        }
        paramViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        break label925;
        paramViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        break label970;
        paramViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break label994;
        paramViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label1007;
        paramViewHolder.jdField_a_of_type_ComTencentWidgetSimpleTextView.setVisibility(8);
        paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(2130840932, 0);
        paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(5.0F * this.jdField_a_of_type_Float));
        if (!paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.a().equals(paramObject)) {
          paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)paramObject);
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        break label1156;
        if (((String)paramObject).length() <= 0) {
          break label1188;
        }
        paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        paramViewHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label1188;
        this.jdField_b_of_type_JavaLangStringBuilder.append(",").append(paramViewHolder.jdField_d_of_type_ComTencentWidgetSingleLineTextView.a()).append(" ");
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.a("P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "list_pv", 0, 0, String.valueOf(localRespEncounterInfo.tiny_id), String.valueOf(paramInt), "yes", "android");
      return;
      paramViewHolder.jdField_a_of_type_ComTencentWidgetBorderTextView.setVisibility(8);
      return;
    }
  }
  
  public void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, SingleLineTextView paramSingleLineTextView)
  {
    Integer localInteger = (Integer)paramImageView.getTag();
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    for (;;)
    {
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
      {
        VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
        if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
        {
          if (paramImageView.getVisibility() != 0) {
            paramImageView.setVisibility(0);
          }
          if (localInteger.intValue() != 2) {
            paramImageView.setImageResource(2130843363);
          }
          if (localInteger.intValue() == 0) {
            a(paramSingleLineTextView, true);
          }
          paramImageView.setTag(Integer.valueOf(2));
        }
      }
      do
      {
        return;
        paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
        if ((paramVipBaseInfo != null) && (paramVipBaseInfo.bOpen))
        {
          if (paramImageView.getVisibility() != 0) {
            paramImageView.setVisibility(0);
          }
          if (localInteger.intValue() != 1) {
            paramImageView.setImageResource(2130843496);
          }
          if (localInteger.intValue() == 0) {
            a(paramSingleLineTextView, true);
          }
          paramImageView.setTag(Integer.valueOf(1));
          return;
        }
        paramImageView.setTag(Integer.valueOf(0));
        if (paramImageView.getVisibility() != 8) {
          paramImageView.setVisibility(8);
        }
      } while (localInteger.intValue() == 0);
      a(paramSingleLineTextView, false);
      return;
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewView = paramView;
    }
  }
  
  /* Error */
  public void a(EncounterHolder paramEncounterHolder, DynamicAvatarView paramDynamicAvatarView)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 588	com/tencent/mobileqq/nearpeople/EncounterHolder:encounter	LEncounterSvc/RespEncounterInfo;
    //   4: astore 5
    //   6: aload_1
    //   7: getfield 965	com/tencent/mobileqq/nearpeople/EncounterHolder:dynamicAvatarInfo	Lcom/tencent/mobileqq/data/DynamicAvatar;
    //   10: astore_3
    //   11: aload_2
    //   12: invokevirtual 966	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:getTag	()Ljava/lang/Object;
    //   15: checkcast 856	java/lang/Boolean
    //   18: invokevirtual 969	java/lang/Boolean:booleanValue	()Z
    //   21: ifeq +4 -> 25
    //   24: return
    //   25: lconst_0
    //   26: lstore 7
    //   28: sipush 200
    //   31: istore 6
    //   33: aload 5
    //   35: getfield 594	EncounterSvc/RespEncounterInfo:tiny_id	J
    //   38: lconst_0
    //   39: lcmp
    //   40: ifle +274 -> 314
    //   43: aload 5
    //   45: getfield 594	EncounterSvc/RespEncounterInfo:tiny_id	J
    //   48: lstore 7
    //   50: sipush 202
    //   53: istore 6
    //   55: lload 7
    //   57: lconst_0
    //   58: lcmp
    //   59: ifeq +441 -> 500
    //   62: lload 7
    //   64: invokestatic 625	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: astore 4
    //   69: aload_0
    //   70: getfield 104	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   73: bipush 32
    //   75: aload 4
    //   77: iload 6
    //   79: iconst_3
    //   80: invokevirtual 974	com/tencent/mobileqq/util/FaceDecoder:a	(ILjava/lang/String;IB)Landroid/graphics/Bitmap;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnonnull +316 -> 401
    //   88: aload_0
    //   89: getfield 104	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   92: invokevirtual 976	com/tencent/mobileqq/util/FaceDecoder:b	()Z
    //   95: ifne +252 -> 347
    //   98: invokestatic 497	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +48 -> 149
    //   104: ldc_w 978
    //   107: iconst_2
    //   108: new 57	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 980
    //   118: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 5
    //   123: getfield 630	EncounterSvc/RespEncounterInfo:strNick	Ljava/lang/String;
    //   126: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 982
    //   132: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 5
    //   137: getfield 594	EncounterSvc/RespEncounterInfo:tiny_id	J
    //   140: invokevirtual 985	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 987	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload 5
    //   151: getfield 991	EncounterSvc/RespEncounterInfo:vDateFaceInfo	[B
    //   154: ifnull +353 -> 507
    //   157: aload 5
    //   159: getfield 991	EncounterSvc/RespEncounterInfo:vDateFaceInfo	[B
    //   162: arraylength
    //   163: ifle +344 -> 507
    //   166: new 993	com/tencent/avatarinfo/MultiHeadUrl$RspHeadInfo
    //   169: dup
    //   170: invokespecial 994	com/tencent/avatarinfo/MultiHeadUrl$RspHeadInfo:<init>	()V
    //   173: astore_1
    //   174: aload_1
    //   175: aload 5
    //   177: getfield 991	EncounterSvc/RespEncounterInfo:vDateFaceInfo	[B
    //   180: invokevirtual 998	com/tencent/avatarinfo/MultiHeadUrl$RspHeadInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   183: pop
    //   184: new 1000	AvatarInfo/QQHeadInfo
    //   187: dup
    //   188: aload_1
    //   189: invokespecial 1003	AvatarInfo/QQHeadInfo:<init>	(Lcom/tencent/avatarinfo/MultiHeadUrl$RspHeadInfo;)V
    //   192: astore_1
    //   193: aload_0
    //   194: getfield 104	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder	Lcom/tencent/mobileqq/util/FaceDecoder;
    //   197: aload 4
    //   199: iload 6
    //   201: iconst_1
    //   202: bipush 32
    //   204: iconst_0
    //   205: iconst_1
    //   206: iconst_3
    //   207: aload_1
    //   208: invokevirtual 1006	com/tencent/mobileqq/util/FaceDecoder:a	(Ljava/lang/String;IZIZBILAvatarInfo/QQHeadInfo;)Z
    //   211: pop
    //   212: aload_0
    //   213: getfield 223	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable	Landroid/graphics/drawable/BitmapDrawable;
    //   216: ifnonnull +13 -> 229
    //   219: aload_0
    //   220: invokestatic 228	com/tencent/mobileqq/utils/ImageUtil:a	()Landroid/graphics/drawable/Drawable;
    //   223: checkcast 230	android/graphics/drawable/BitmapDrawable
    //   226: putfield 223	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable	Landroid/graphics/drawable/BitmapDrawable;
    //   229: aload_3
    //   230: ifnull +282 -> 512
    //   233: aload_3
    //   234: getfield 1011	com/tencent/mobileqq/data/DynamicAvatar:nearbyStaticUrl	Ljava/lang/String;
    //   237: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   240: ifeq +272 -> 512
    //   243: iconst_1
    //   244: istore 9
    //   246: iconst_0
    //   247: istore 10
    //   249: aload_0
    //   250: aload 4
    //   252: invokespecial 1013	com/tencent/mobileqq/adapter/PeopleAroundAdapter:b	(Ljava/lang/String;)Z
    //   255: ifeq +22 -> 277
    //   258: invokestatic 497	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +240 -> 501
    //   264: ldc_w 1015
    //   267: iconst_2
    //   268: ldc_w 1017
    //   271: invokestatic 1019	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: goto +227 -> 501
    //   277: aload_2
    //   278: aload_0
    //   279: getfield 90	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   282: aload_0
    //   283: getfield 223	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable	Landroid/graphics/drawable/BitmapDrawable;
    //   286: bipush 32
    //   288: iload 6
    //   290: aload 4
    //   292: sipush 200
    //   295: iconst_0
    //   296: aload_3
    //   297: iload 9
    //   299: iconst_1
    //   300: iconst_1
    //   301: iload 10
    //   303: iconst_2
    //   304: invokevirtual 1023	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:setFaceDrawable	(Lcom/tencent/common/app/AppInterface;Landroid/graphics/drawable/Drawable;IILjava/lang/String;IZLcom/tencent/mobileqq/data/DynamicAvatar;ZZZZI)V
    //   307: return
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 1024	java/lang/Throwable:printStackTrace	()V
    //   313: return
    //   314: aload 5
    //   316: getfield 916	EncounterSvc/RespEncounterInfo:lEctID	J
    //   319: lconst_0
    //   320: lcmp
    //   321: ifle -266 -> 55
    //   324: aload 5
    //   326: getfield 916	EncounterSvc/RespEncounterInfo:lEctID	J
    //   329: lstore 7
    //   331: sipush 200
    //   334: istore 6
    //   336: goto -281 -> 55
    //   339: astore_1
    //   340: aload_1
    //   341: invokevirtual 1024	java/lang/Throwable:printStackTrace	()V
    //   344: goto +163 -> 507
    //   347: invokestatic 497	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq -138 -> 212
    //   353: ldc_w 978
    //   356: iconst_2
    //   357: new 57	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 1026
    //   367: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 5
    //   372: getfield 630	EncounterSvc/RespEncounterInfo:strNick	Ljava/lang/String;
    //   375: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: ldc_w 982
    //   381: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 5
    //   386: getfield 594	EncounterSvc/RespEncounterInfo:tiny_id	J
    //   389: invokevirtual 985	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   392: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 987	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: goto -186 -> 212
    //   401: new 230	android/graphics/drawable/BitmapDrawable
    //   404: dup
    //   405: aload_1
    //   406: invokespecial 1029	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   409: astore_1
    //   410: aload_3
    //   411: ifnull +83 -> 494
    //   414: aload_3
    //   415: getfield 1011	com/tencent/mobileqq/data/DynamicAvatar:nearbyStaticUrl	Ljava/lang/String;
    //   418: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   421: ifeq +73 -> 494
    //   424: iconst_1
    //   425: istore 9
    //   427: iconst_0
    //   428: istore 10
    //   430: aload_0
    //   431: aload 4
    //   433: invokespecial 1013	com/tencent/mobileqq/adapter/PeopleAroundAdapter:b	(Ljava/lang/String;)Z
    //   436: ifeq +22 -> 458
    //   439: invokestatic 497	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +76 -> 518
    //   445: ldc_w 1015
    //   448: iconst_2
    //   449: ldc_w 1017
    //   452: invokestatic 1019	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto +63 -> 518
    //   458: aload_2
    //   459: aload_0
    //   460: getfield 90	com/tencent/mobileqq/adapter/PeopleAroundAdapter:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   463: aload_1
    //   464: bipush 32
    //   466: iload 6
    //   468: aload 4
    //   470: sipush 200
    //   473: iconst_0
    //   474: aload_3
    //   475: iload 9
    //   477: iconst_1
    //   478: iconst_1
    //   479: iload 10
    //   481: iconst_2
    //   482: invokevirtual 1023	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:setFaceDrawable	(Lcom/tencent/common/app/AppInterface;Landroid/graphics/drawable/Drawable;IILjava/lang/String;IZLcom/tencent/mobileqq/data/DynamicAvatar;ZZZZI)V
    //   485: aload_2
    //   486: iconst_1
    //   487: invokestatic 859	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   490: invokevirtual 860	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:setTag	(Ljava/lang/Object;)V
    //   493: return
    //   494: iconst_0
    //   495: istore 9
    //   497: goto -70 -> 427
    //   500: return
    //   501: iconst_1
    //   502: istore 10
    //   504: goto -227 -> 277
    //   507: aconst_null
    //   508: astore_1
    //   509: goto -316 -> 193
    //   512: iconst_0
    //   513: istore 9
    //   515: goto -269 -> 246
    //   518: iconst_1
    //   519: istore 10
    //   521: goto -63 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	PeopleAroundAdapter
    //   0	524	1	paramEncounterHolder	EncounterHolder
    //   0	524	2	paramDynamicAvatarView	DynamicAvatarView
    //   10	465	3	localDynamicAvatar	com.tencent.mobileqq.data.DynamicAvatar
    //   67	402	4	str	String
    //   4	381	5	localRespEncounterInfo	RespEncounterInfo
    //   31	436	6	n	int
    //   26	304	7	l1	long
    //   244	270	9	bool1	boolean
    //   247	273	10	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   11	24	308	java/lang/Throwable
    //   33	50	308	java/lang/Throwable
    //   62	84	308	java/lang/Throwable
    //   88	149	308	java/lang/Throwable
    //   149	174	308	java/lang/Throwable
    //   193	212	308	java/lang/Throwable
    //   212	229	308	java/lang/Throwable
    //   233	243	308	java/lang/Throwable
    //   249	274	308	java/lang/Throwable
    //   277	307	308	java/lang/Throwable
    //   314	331	308	java/lang/Throwable
    //   340	344	308	java/lang/Throwable
    //   347	398	308	java/lang/Throwable
    //   401	410	308	java/lang/Throwable
    //   414	424	308	java/lang/Throwable
    //   430	455	308	java/lang/Throwable
    //   458	493	308	java/lang/Throwable
    //   174	193	339	java/lang/Throwable
  }
  
  protected void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilIIconDecoder.a(1, String.valueOf(paramInt), 200, false, true);
    localObject = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), (Bitmap)localObject, false, false);
    if (this.m == 0) {
      this.m = ((int)(paramSingleLineTextView.a() * 1.1F + 0.5F));
    }
    ((StatableBitmapDrawable)localObject).setBounds(0, 0, this.m, this.m);
    paramSingleLineTextView.setCompoundDrawables((Drawable)localObject, null);
  }
  
  public void a(SingleLineTextView paramSingleLineTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
        this.jdField_a_of_type_AndroidContentResColorStateList = paramSingleLineTextView.getResources().getColorStateList(2131428329);
      }
      paramSingleLineTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      return;
    }
    if (this.jdField_b_of_type_AndroidContentResColorStateList == null) {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramSingleLineTextView.getResources().getColorStateList(2131428297);
    }
    paramSingleLineTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(this.l);
      int n;
      if (paramInt + 1 < this.jdField_a_of_type_JavaUtilList.size()) {
        n = paramInt + 1;
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.l /= 2;
        }
        label93:
        Object localObject;
        MultiHeadUrl.RspHeadInfo localRspHeadInfo;
        if (this.l + paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt = this.l + paramInt;
          if (n > paramInt) {
            break label258;
          }
          localObject = this.jdField_a_of_type_JavaUtilList.get(n);
          if ((localObject instanceof EncounterHolder.EncounterHolderOpt))
          {
            localObject = ((EncounterHolder.EncounterHolderOpt)localObject).jdField_a_of_type_ComTencentMobileqqNearpeopleEncounterHolder.encounter;
            if ((((RespEncounterInfo)localObject).vDateFaceInfo != null) && (((RespEncounterInfo)localObject).vDateFaceInfo.length > 0)) {
              localRspHeadInfo = new MultiHeadUrl.RspHeadInfo();
            }
          }
        }
        try
        {
          localRspHeadInfo.mergeFrom(((RespEncounterInfo)localObject).vDateFaceInfo);
          HeadRequest localHeadRequest = new HeadRequest();
          localHeadRequest.jdField_a_of_type_JavaLangString = String.valueOf(((RespEncounterInfo)localObject).tiny_id);
          localHeadRequest.jdField_a_of_type_Int = 202;
          localHeadRequest.jdField_b_of_type_Int = 32;
          localHeadRequest.jdField_a_of_type_AvatarInfoQQHeadInfo = new QQHeadInfo(localRspHeadInfo);
          localArrayList.add(localHeadRequest);
          n += 1;
          break label93;
          n = paramInt;
          continue;
          paramInt = this.jdField_a_of_type_JavaUtilList.size() - 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
      label258:
      if ((localArrayList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(localArrayList);
      }
    }
  }
  
  public int getCount()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    int n = i1;
    if (i1 == 0)
    {
      n = i1;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        n = i1 + 1;
      }
    }
    return n;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof AdGroup)) {
      return 3;
    }
    if ((localObject instanceof EncounterHolder.EncounterHolderOpt))
    {
      if (String.valueOf(((EncounterHolder.EncounterHolderOpt)localObject).jdField_a_of_type_ComTencentMobileqqNearpeopleEncounterHolder.encounter.lEctID).equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a())) {
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) && (this.jdField_a_of_type_AndroidViewView != null)) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    int n = getItemViewType(paramInt);
    Object localObject2;
    if (n == 3)
    {
      AdGroup localAdGroup = (AdGroup)getItem(paramInt);
      if (paramView != null)
      {
        localObject1 = (PeopleAroundAdapter.AdViewHolder)paramView.getTag();
        if (localObject1 != null) {
          break label328;
        }
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903633, paramViewGroup, false);
        localObject2 = new PeopleAroundAdapter.AdViewHolder();
        paramViewGroup.setTag(localObject2);
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramViewGroup.findViewById(2131299520));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131299518));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131299515));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131299519));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_c_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131299521));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_d_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131299522));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_e_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131299517));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131299516));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131299514));
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 11.0F);
        ((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(Math.round(((PeopleAroundAdapter.AdViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView.getResources().getDisplayMetrics().density * 1.0F));
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        a(paramInt, (PeopleAroundAdapter.AdViewHolder)localObject2, (AdData)localAdGroup.listAD.get(localAdGroup.currentIndex));
        n = paramInt;
        if (h > paramInt) {
          n = h;
        }
        h = n;
        return paramViewGroup;
        localObject1 = null;
        break;
        label328:
        localObject2 = localObject1;
        paramViewGroup = paramView;
        if (localAdGroup != null) {
          if (localAdGroup.currentIndex + 1 == localAdGroup.listAD.size())
          {
            localAdGroup.currentIndex = 0;
            localObject2 = localObject1;
            paramViewGroup = paramView;
          }
          else
          {
            localAdGroup.currentIndex += 1;
            localObject2 = localObject1;
            paramViewGroup = paramView;
          }
        }
      }
    }
    if (paramView != null) {}
    for (Object localObject1 = (PeopleAroundAdapter.ViewHolder)paramView.getTag();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903414, paramViewGroup, false);
        localObject2 = new PeopleAroundAdapter.ViewHolder();
        paramView.setTag(localObject2);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)paramView.findViewById(2131296790));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298497));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131297741));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298500));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298498));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_c_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131298510));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298502));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_e_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131298504));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298506));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131297537);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298507));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298505));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_e_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(0));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298398));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131298402));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetSimpleTextView = ((SimpleTextView)paramView.findViewById(2131298508));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_d_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131298509));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298511);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298512));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131298501);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131428297);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextSize(1, 11.0F);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetSimpleTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131427407));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetSimpleTextView.setGravity(19);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramView.findViewById(2131298503));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 11.0F);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(Math.round(this.jdField_a_of_type_Float * 1.0F));
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(-635272);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(-635272);
        ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetBorderTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131372239));
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramViewGroup = ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_JavaLangObject;
      ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_a_of_type_JavaLangObject = getItem(paramInt);
      ((PeopleAroundAdapter.ViewHolder)localObject2).jdField_b_of_type_Int = n;
      if ((n == 1) || (n == 0)) {
        a(paramInt, (PeopleAroundAdapter.ViewHolder)localObject2, paramViewGroup);
      }
      paramViewGroup = paramView;
      if (n != 1) {
        break;
      }
      a(paramInt);
      paramViewGroup = paramView;
      break;
    }
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\PeopleAroundAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */