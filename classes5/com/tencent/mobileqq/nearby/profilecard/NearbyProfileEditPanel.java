package com.tencent.mobileqq.nearby.profilecard;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.rn.BaseBusi;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.AutoSwitchIconView;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;
import tne;
import tnf;
import tnh;
import tnl;
import tnm;
import tnn;
import tno;
import tnp;
import tnq;
import tnr;
import tns;
import tnt;
import tnu;
import tnv;
import tnw;
import tnx;
import toa;
import tob;
import tof;
import toh;
import toi;
import toj;
import tok;
import tol;
import tom;
import ton;
import too;
import top;
import toq;
import tor;
import tos;

public class NearbyProfileEditPanel
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 4;
  static final int[] jdField_a_of_type_ArrayOfInt;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  static final int jdField_b_of_type_Int = 3;
  static final int[] jdField_b_of_type_ArrayOfInt;
  static final int jdField_d_of_type_Int = 1896;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new toi(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new tnu(this);
  public NearbyPeopleCard a;
  private PicInfo jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  public NearbyPeopleProfileActivity a;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new tob(this);
  AutoSwitchIconView jdField_a_of_type_ComTencentMobileqqWidgetAutoSwitchIconView;
  public BounceScrollView a;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public CustomImgView a;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public String a;
  public LinkedList a;
  private tos jdField_a_of_type_Tos;
  public boolean a;
  public final InterestTag[] a;
  final SavorTagIcon[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon;
  final SavorTagImg[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg;
  public EditText b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new tnv(this);
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CustomImgView jdField_b_of_type_ComTencentWidgetCustomImgView;
  public String b;
  final String[] jdField_b_of_type_ArrayOfJavaLangString;
  int jdField_c_of_type_Int;
  public EditText c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new toj(this);
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public String c;
  EditText jdField_d_of_type_AndroidWidgetEditText;
  LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public int e;
  public EditText e;
  LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  int jdField_f_of_type_Int;
  EditText jdField_f_of_type_AndroidWidgetEditText;
  LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  int jdField_g_of_type_Int;
  EditText jdField_g_of_type_AndroidWidgetEditText;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  public int h;
  public EditText h;
  public TextView h;
  public int i;
  public int j;
  int k;
  public int l;
  public int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 2131302016, 2131302017, 2131302018, 2131302019, 2131302020, 2131302021, 2131302022 };
    jdField_b_of_type_ArrayOfInt = new int[] { 1, 2, 3, 4, 5, 6, 7 };
  }
  
  public NearbyProfileEditPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, View paramView)
  {
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 2015;
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_Tos = new tos(this, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E);
    }
    this.k = ((int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D));
    this.jdField_b_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getStringArray(2131230782);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon = new SavorTagIcon[4];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg = new SavorTagImg[3];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag = new InterestTag[7];
    int n = 0;
    while (n < 7)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[n] = new InterestTag(jdField_b_of_type_ArrayOfInt[n]);
      n += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    a(this.jdField_a_of_type_AndroidViewView);
    o();
  }
  
  private View.OnClickListener a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new tnf(this);
    }
    return new tnh(this);
  }
  
  private CustomImgView a(PicInfo paramPicInfo, Drawable paramDrawable)
  {
    CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localCustomImgView.setBackground(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840637));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E);
    if (paramPicInfo != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo) {
      localLayoutParams.setMargins(0, 0, this.k, 0);
    }
    localCustomImgView.setLayoutParams(localLayoutParams);
    a(localCustomImgView, paramPicInfo, paramDrawable);
    localCustomImgView.setOnClickListener(a(false));
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPicInfo != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)
      {
        localCustomImgView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localCustomImgView.setOnDragListener(this.jdField_a_of_type_Tos);
      }
    }
    else {
      return localCustomImgView;
    }
    localCustomImgView.setOnDragListener(new toq(this));
    return localCustomImgView;
  }
  
  private void a(View paramView)
  {
    int i2 = 0;
    paramView.findViewById(2131297138).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297829));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297830));
    paramView.findViewById(2131297139).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)paramView.findViewById(2131302047));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoSwitchIconView = ((AutoSwitchIconView)paramView.findViewById(2131302048));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301976));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getLayoutParams();
    int n = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
    localLayoutParams.height = n;
    localLayoutParams.width = n;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131302046));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)paramView.findViewById(2131302049));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131302050));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302055));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302054));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131302053));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302051));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302052));
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131302061));
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).topMargin = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F / 2 + (int)(36.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams()).topMargin = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F / 2 + (int)(22.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131296932));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131302057));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131301243));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302063));
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131301059));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131302062));
    this.jdField_e_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131302064));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131302065));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302066));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302067));
    this.jdField_f_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131302069));
    this.jdField_g_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131302060));
    this.jdField_h_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131297923));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131302072));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131302073));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131302071));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131302044));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131302045));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302070));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131297137));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302043));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.h = 1;
    int i1 = 0;
    for (;;)
    {
      n = i2;
      if (i1 >= 4) {
        break;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1] = ((SavorTagIcon)this.jdField_a_of_type_AndroidViewView.findViewById(jdField_a_of_type_ArrayOfInt[i1]));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_b_of_type_ArrayOfJavaLangString[i1], this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList, null);
      i1 += 1;
    }
    while (n < 3)
    {
      i1 = n + 4;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[n] = ((SavorTagImg)this.jdField_a_of_type_AndroidViewView.findViewById(jdField_a_of_type_ArrayOfInt[i1]));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[n].a(this.jdField_b_of_type_ArrayOfJavaLangString[i1], this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList, null);
      n += 1;
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new tol(this, paramView2, paramView1), 300L);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int n = 2131428258;; n = 2131428262)
    {
      paramTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColorStateList(n));
      return;
    }
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    RichStatus localRichStatus;
    if (paramArrayOfByte != null)
    {
      localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131427409));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus == null) || (TextUtils.isEmpty(localRichStatus.actionText))) {
        break label219;
      }
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
        break label202;
      }
    }
    label202:
    for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.actionId, 200);; paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130842868))
    {
      paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
      int n = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramArrayOfByte.setBounds(0, 0, n, n);
      paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
      paramArrayOfByte.a(-0.1F);
      ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    label219:
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void a(PicInfo paramPicInfo, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() > 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.remove(paramPicInfo);
      if (paramView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
      {
        paramPicInfo = (PicInfo)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).getTag();
        a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, paramPicInfo, ((CustomImgView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0)).a());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(0);
      }
      for (;;)
      {
        k();
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(paramView);
      }
    }
    paramPicInfo = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "没有头像，怎么交朋友？请保留至少一张照片作为交友头像。", 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131367263, new tnm(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  private void a(CustomImgView paramCustomImgView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "setDrawable, pos:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(paramCustomImgView) + ",picInfo:" + paramPicInfo);
    }
    paramCustomImgView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841004);
    }
    if (paramPicInfo == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo) {
      if (paramCustomImgView != this.jdField_a_of_type_ComTencentWidgetCustomImgView) {
        paramCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841020));
      }
    }
    for (;;)
    {
      return;
      paramPicInfo = (RelativeLayout.LayoutParams)paramCustomImgView.getLayoutParams();
      int n = (int)(5.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float);
      int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F - n * 2;
      paramPicInfo.height = i1;
      paramPicInfo.width = i1;
      paramPicInfo.setMargins(n, n, n, n);
      paramCustomImgView.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      paramCustomImgView.setBackground(null);
      paramCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840897));
      paramCustomImgView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840898);
      return;
      if (paramCustomImgView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
      {
        paramDrawable = (RelativeLayout.LayoutParams)paramCustomImgView.getLayoutParams();
        n = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
        paramDrawable.height = n;
        paramDrawable.width = n;
        paramDrawable.setMargins(0, 0, 0, 0);
        paramCustomImgView.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramCustomImgView.setBackground(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840637));
        paramCustomImgView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.n) {
          break label629;
        }
        if (DynamicAvatarDownloadManager.c(paramPicInfo.e))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramDrawable = URLDrawable.URLDrawableOptions.obtain();
          paramDrawable.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
          paramDrawable.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
          paramDrawable.mFailedDrawable = ((Drawable)localObject);
          paramDrawable.mLoadingDrawable = ((Drawable)localObject);
          paramDrawable.mUseMemoryCache = false;
          localObject = new VideoDrawable.VideoDrawableParams();
          ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
          ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.U;
          paramDrawable.mExtraInfo = localObject;
          paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(new File(paramPicInfo.e), paramDrawable));
          return;
        }
        if (TextUtils.isEmpty(paramPicInfo.d)) {
          break label617;
        }
        if (!NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
          break label606;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c(paramPicInfo.d);
      }
      for (;;)
      {
        try
        {
          paramDrawable = URLDrawable.URLDrawableOptions.obtain();
          if (paramCustomImgView != this.jdField_a_of_type_ComTencentWidgetCustomImgView) {
            break label641;
          }
          paramDrawable.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
          paramDrawable.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.F;
          paramDrawable.mFailedDrawable = ((Drawable)localObject);
          paramDrawable.mLoadingDrawable = ((Drawable)localObject);
          if ((paramPicInfo.jdField_c_of_type_JavaLangString == null) || (paramPicInfo.jdField_c_of_type_JavaLangString.length() <= 0)) {
            break label666;
          }
          paramPicInfo = new File(paramPicInfo.jdField_c_of_type_JavaLangString).toURL();
          URLDrawable.removeMemoryCacheByUrl(paramPicInfo.toString());
          paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo, paramDrawable));
          return;
        }
        catch (MalformedURLException paramCustomImgView) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        paramPicInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + paramCustomImgView.getMessage(), paramCustomImgView);
        return;
        label606:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        continue;
        label617:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        label629:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        label641:
        paramDrawable.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E;
        paramDrawable.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.E;
      }
      label666:
      if (paramCustomImgView == this.jdField_a_of_type_ComTencentWidgetCustomImgView) {
        if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString)) {
          paramPicInfo = paramPicInfo.jdField_a_of_type_JavaLangString;
        }
      }
      while (!TextUtils.isEmpty(paramPicInfo))
      {
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(NearbyImgDownloader.a(paramPicInfo), paramDrawable));
        return;
        if (!TextUtils.isEmpty(paramPicInfo.jdField_b_of_type_JavaLangString))
        {
          paramPicInfo = paramPicInfo.jdField_b_of_type_JavaLangString;
          continue;
          if (!TextUtils.isEmpty(paramPicInfo.jdField_b_of_type_JavaLangString))
          {
            paramPicInfo = paramPicInfo.jdField_b_of_type_JavaLangString;
            continue;
          }
          if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString))
          {
            paramPicInfo = paramPicInfo.jdField_a_of_type_JavaLangString;
            continue;
          }
        }
        paramPicInfo = null;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131371596, new Object[] { this.jdField_a_of_type_JavaLangString });
      localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
      ((QQCustomDialog)localObject).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131371677), new tnl(this, (QQCustomDialog)localObject, paramBoolean));
      ((QQCustomDialog)localObject).show();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) && (QLog.isColorLevel())) {
        QLog.d("NearbyProfileEditPanel", 2, "mcard is null");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(paramBoolean, false);
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)) {}
    for (int n = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() - 1; n != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaUtilArrayList.size(); n = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size()) {
      return true;
    }
    int i1 = 0;
    while (i1 < n)
    {
      if (((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int != ((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean d()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (!StringUtil.b(str))
    {
      if (StringUtil.e(str).length() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b("交友昵称不允许全为空格");
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b("交友昵称不允许为空\"");
      return false;
    }
    return true;
  }
  
  private void j()
  {
    ActionSheet localActionSheet = ActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    Object localObject = (DispatchActionMoveScrollView)localActionSheet.findViewById(2131296881);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2130904203, null);
    ((IphonePickerView)localObject).a(this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    if (this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null)
    {
      int i1 = (byte)(((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() - 1);
      int n;
      if (i1 >= 0)
      {
        n = i1;
        if (i1 <= 3) {}
      }
      else
      {
        n = 0;
      }
      ((IphonePickerView)localObject).setSelection(0, n);
      ((IphonePickerView)localObject).setPickListener(new too(this, (IphonePickerView)localObject, localActionSheet));
      localActionSheet.a(new top(this));
      localActionSheet.b((View)localObject, null);
      localActionSheet.show();
      a(this.jdField_f_of_type_AndroidWidgetLinearLayout, localActionSheet.a());
      a(this.jdField_h_of_type_AndroidWidgetEditText, true);
    }
  }
  
  private void k()
  {
    l();
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() > NearbyPeopleProfileActivity.r) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() < NearbyPeopleProfileActivity.r) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo, null));
    }
    CustomImgView localCustomImgView;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo))
    {
      localCustomImgView = (CustomImgView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
      if (localCustomImgView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= NearbyPeopleProfileActivity.q) {
          break label359;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
          break label328;
        }
        localCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841136));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= 1)
    {
      m();
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
      label261:
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)) {
        break label394;
      }
    }
    label328:
    label359:
    label394:
    for (int n = 1;; n = 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() - n + "/" + NearbyPeopleProfileActivity.r);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break;
      }
      localCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841141));
      break;
      localCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130841020));
      break;
      n();
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
      break label261;
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add((PicInfo)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag());
    int n = 0;
    while (n < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add((PicInfo)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(n).getTag());
      n += 1;
    }
    if (QLog.isColorLevel())
    {
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "reorganizePicInfo:" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("编辑交友资料");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("交友信息仅陌生人可见");
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131297083).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297391);
    localTextView.setVisibility(0);
    localTextView.setText(2131367262);
    localTextView.setOnClickListener(new tnw(this));
    localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297183);
    localTextView.setVisibility(0);
    localTextView.setText(2131368729);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new tnx(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131297082).setOnClickListener(this);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Object localObject = new StringBuilder("正在上传照片(");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int - this.jdField_a_of_type_JavaUtilLinkedList.size() + 1).append("/").append(this.jdField_c_of_type_Int).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(((StringBuilder)localObject).toString());
      localObject = new tof(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a((Runnable)localObject);
      return;
    }
    e();
  }
  
  public int a()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    int n = 0;
    while (n < this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PicInfo localPicInfo = (PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(n);
      if ((localPicInfo != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo) && (localPicInfo.jdField_a_of_type_Int == -1)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(localPicInfo);
      }
      n += 1;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_JavaUtilLinkedList.size();
    return this.jdField_c_of_type_Int;
  }
  
  Intent a(String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = AppConstants.bj + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", "返回");
    localIntent.putExtra("FROM_WHERE", "FROM_NEARBY_PROFILE");
    localIntent.putExtra("is_change_head", paramBoolean);
    return localIntent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = this.jdField_e_of_type_Int - (paramInt1 + 1896);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(1, paramInt2 + 1, paramInt3 + 1);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
    int n = i1;
    if (((Calendar)localObject1).after(localObject2)) {
      n = i1 - 1;
    }
    i1 = n;
    if (n < 0) {
      i1 = 0;
    }
    paramInt1 += 1896;
    n = paramInt2 + 1;
    int i2 = paramInt3 + 1;
    localObject1 = Utils.a(paramInt2 + 1, paramInt3 + 1);
    paramInt2 = AgeSelectionActivity.a((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt1).append("-").append(n).append("-").append(i2).append(" ").append("(").append(i1).append("岁").append(" ").append((String)localObject1).append(")");
    this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject2).toString());
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(paramInt1 << 16 | n << 8 | i2), Integer.valueOf(i1), Integer.valueOf(paramInt2) });
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    Object localObject1;
    Object localObject2;
    label473:
    label489:
    label943:
    label949:
    label960:
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
                                do
                                {
                                  return;
                                } while ((paramInt2 != -1) || (paramIntent == null));
                                paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
                              } while (this.jdField_g_of_type_AndroidWidgetEditText == null);
                              a(this.jdField_g_of_type_AndroidWidgetEditText, paramIntent);
                              this.jdField_g_of_type_AndroidWidgetEditText.setTag(paramIntent);
                              return;
                            } while ((paramInt2 != -1) || (paramIntent == null));
                            localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
                            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_D_of_type_JavaLangString = paramIntent.getStringExtra("key_album_id");
                          } while (StringUtil.b((String)localObject1));
                          paramInt1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_D_of_type_Int;
                          paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                        } while ((paramInt1 != 1) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() >= NearbyPeopleProfileActivity.r + 1));
                        paramIntent = a((String)localObject1, true);
                        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
                        return;
                      } while ((paramInt2 != -1) || (paramIntent == null));
                      localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
                      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_D_of_type_JavaLangString = paramIntent.getStringExtra("key_album_id");
                    } while (StringUtil.b((String)localObject1));
                    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_D_of_type_Int;
                    paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                  } while ((paramInt1 != 1) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() >= NearbyPeopleProfileActivity.r + 1));
                  paramIntent = a((String)localObject1, false);
                  this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
                  return;
                } while ((paramInt2 != -1) || (paramIntent == null));
                for (;;)
                {
                  try
                  {
                    localObject2 = paramIntent.getParcelableArrayListExtra("choosed_interest_tags");
                    paramInt1 = paramIntent.getIntExtra("interest_tag_type", -1);
                    if ((paramInt1 >= 1) && (paramInt1 <= 7))
                    {
                      paramInt2 = paramInt1 - 1;
                      paramIntent = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[paramInt2];
                      paramIntent.jdField_a_of_type_JavaUtilArrayList.clear();
                      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                        paramIntent.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
                      }
                      if (paramInt2 < 4) {
                        break label473;
                      }
                      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[(paramInt2 - 4)].a(paramIntent.jdField_a_of_type_JavaUtilArrayList);
                    }
                    if (!QLog.isDevelopLevel()) {
                      break;
                    }
                    localObject1 = new StringBuilder().append("doOnActivity result code :11 ");
                    if (localObject2 != null) {
                      break label489;
                    }
                    paramIntent = "";
                    QLog.i("Q.nearby_people_card.", 4, paramIntent + " " + paramInt1);
                    return;
                  }
                  catch (Exception paramIntent) {}
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("Q.nearby_people_card.", 2, paramIntent.getMessage());
                  return;
                  this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[paramInt2].a(paramIntent.jdField_a_of_type_JavaUtilArrayList);
                  continue;
                  paramIntent = localObject2.toString();
                }
              } while ((paramInt2 != -1) || (this.jdField_d_of_type_AndroidWidgetEditText == null));
              localObject1 = paramIntent.getStringExtra("param_name");
              paramInt1 = paramIntent.getIntExtra("param_id", -1);
              localObject2 = paramIntent.getStringExtra("param_tag");
              paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
              if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
              {
                this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt2);
                this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              for (;;)
              {
                this.jdField_d_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
                this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(paramInt1));
                return;
                this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
              }
            } while (paramInt2 != -1);
            localObject2 = paramIntent.getStringArrayExtra("param_location");
            paramIntent = null;
            try
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String[])localObject2);
              paramIntent = (Intent)localObject1;
            }
            catch (Exception localException)
            {
              boolean bool2;
              boolean bool1;
              for (;;) {}
            }
            if (paramIntent != null)
            {
              localObject1 = paramIntent;
              if (!paramIntent.equals("不限")) {}
            }
            else
            {
              localObject1 = "";
            }
          } while (this.jdField_f_of_type_AndroidWidgetEditText == null);
          this.jdField_f_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
          this.jdField_f_of_type_AndroidWidgetEditText.setTag(localObject2);
          return;
        } while (paramInt2 != -1);
        if (paramIntent != null)
        {
          localObject1 = paramIntent.getStringExtra("param_college_name");
          bool2 = paramIntent.getBooleanExtra("param_college_name_is_valid", true);
          bool1 = bool2;
          paramIntent = (Intent)localObject1;
          if (NearbyUtils.b())
          {
            NearbyUtils.a("Q.nearby_people_card.", new Object[] { "editschoolfromRN", localObject1, Boolean.valueOf(bool2) });
            paramIntent = (Intent)localObject1;
            bool1 = bool2;
          }
          if (TextUtils.isEmpty(paramIntent)) {
            bool1 = true;
          }
          if ((!NearbyUtils.a(this.jdField_f_of_type_AndroidWidgetTextView.getText().toString(), paramIntent)) || (bool1)) {
            break label949;
          }
          if (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() != 8) {
            break label943;
          }
          bool1 = true;
        }
        for (;;)
        {
          if (!bool1) {
            break label960;
          }
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          paramIntent = (String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(), "temp_school_name", "");
          bool1 = ((Boolean)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(), "temp_validate", Boolean.valueOf(true))).booleanValue();
          if (NearbyUtils.b()) {
            NearbyUtils.a("Q.nearby_people_card.", new Object[] { "editschoolfromH5", paramIntent, Boolean.valueOf(bool1) });
          }
          ThreadManager.a(new tns(this), 5, null, false);
          break;
          bool1 = false;
          continue;
          this.jdField_f_of_type_AndroidWidgetTextView.setText(paramIntent);
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      localObject1 = paramIntent.getStringExtra("key_photo_file_path");
      localObject2 = paramIntent.getStringExtra("key_video_file_path");
      this.l = paramIntent.getIntExtra("key_video_duration", 0);
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("key_video_has_voice");
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("key_camera_id");
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("key_photo_selected_by_user", false);
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    paramIntent = new PicInfo();
    paramIntent.jdField_c_of_type_JavaLangString = ((String)localObject1);
    paramIntent.e = ((String)localObject2);
    a(paramIntent);
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.g) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo);
    }
    label107:
    label373:
    label464:
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
    {
      this.jdField_a_of_type_JavaLangString = "男";
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
        break label826;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131371603));
      c();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
      this.jdField_b_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
      n = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday;
      int i2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation;
      int i3 = (0xFF00 & i1) >> 8;
      int i4 = i1 & 0xFF;
      paramNearbyPeopleCard = Utils.a(i3, i4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i1 >> 16).append("-").append(i3).append("-").append(i4).append(" ").append("(").append(n).append("岁").append(" ").append(paramNearbyPeopleCard).append(")");
      this.jdField_c_of_type_AndroidWidgetEditText.setText(localStringBuilder.toString());
      this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(i2) });
      n = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d(n));
      if (!StringUtil.b(NearbyProfileUtil.d(n))) {
        break label902;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.e(n));
      this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(n));
      this.jdField_e_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
      this.jdField_e_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.collegeId != 0L) {
        break label935;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        break label924;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      f();
      a(this.jdField_g_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.jdField_g_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.jdField_h_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
      this.jdField_h_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby);
      if (NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo) == 0) {
        break label953;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
        break label947;
      }
      bool = true;
      label605:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams()).topMargin = 0;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131371595, new Object[] { this.jdField_a_of_type_JavaLangString });
        paramNearbyPeopleCard = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramNearbyPeopleCard, 0, 0, null, null);
        paramNearbyPeopleCard.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131371677), new tnn(this, paramNearbyPeopleCard));
        paramNearbyPeopleCard.show();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
      n = 0;
      while (n < 4)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[n].a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[n].jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[n].setOnClickListener(this);
        if (AppSetting.j) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[n].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[n].a() + ",进入选择兴趣标签页面");
        }
        n += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = "女";
      break;
      label826:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)) {}
      for (n = 1;; n = 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() - n <= NearbyPeopleProfileActivity.q) {
          break label900;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131371604, new Object[] { this.jdField_a_of_type_JavaLangString }));
        break;
      }
      label900:
      break label107;
      label902:
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a(n));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      break label373;
      label924:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      break label464;
      label935:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      break label464;
      label947:
      bool = false;
      break label605;
      label953:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams()).topMargin = AIOUtils.a(20.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
    }
    int n = 0;
    while (n < 3)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[n].a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[(n + 4)].jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[n].setOnClickListener(this);
      if (AppSetting.j) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[n].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[n].a() + ",进入选择兴趣标签页面");
      }
      n += 1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.i) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.R == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new tno(this), 300L);
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131302059).setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131302061).setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131302056).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131302058).setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131302062).setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131302068).setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoHeadFlag) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.g))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoSwitchIconView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoSwitchIconView.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new tnp(this));
      this.jdField_e_of_type_AndroidWidgetEditText.addTextChangedListener(new tnq(this));
      this.jdField_a_of_type_AndroidWidgetEditText.getViewTreeObserver().addOnGlobalLayoutListener(new tnr(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoSwitchIconView.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoSwitchIconView.setVisibility(8);
    }
  }
  
  void a(PicInfo paramPicInfo)
  {
    PicInfo localPicInfo = (PicInfo)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
    if ((localPicInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() < NearbyPeopleProfileActivity.r) || ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() == NearbyPeopleProfileActivity.r) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo))))) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(localPicInfo, null), 0);
    }
    a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, paramPicInfo, null);
    k();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetCustomImgView != null) && ((this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag() instanceof PicInfo)))
    {
      PicInfo localPicInfo = (PicInfo)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
      if ((localPicInfo != null) && (paramString.equals(localPicInfo.d))) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.runOnUiThread(new tor(this, paramBoolean, paramString));
      }
    }
  }
  
  public boolean a()
  {
    int n;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo))
    {
      n = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo)) {
        break label91;
      }
    }
    label91:
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaUtilArrayList.size() - 1;; i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if ((i1 > 0) || (n < 1)) {
        break label105;
      }
      return true;
      n = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size();
      break;
    }
    label105:
    if ((i1 >= 1) && (n <= 0)) {
      return true;
    }
    if ((i1 >= 1) && (n >= 1)) {
      return ((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != ((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
    }
    return false;
  }
  
  boolean a(PicInfo paramPicInfo)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() == 1) {
      a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, paramPicInfo, null);
    }
    for (;;)
    {
      k();
      return bool;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(paramPicInfo, null), this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
      bool = true;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.fullScroll(66);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_Boolean) {
      return true;
    }
    if (c()) {
      return true;
    }
    int n;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!Utils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if ((this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus)) {
        return true;
      }
      if (((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
      if (((Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job) {
        return true;
      }
      if (!StringUtil.e(this.jdField_e_of_type_AndroidWidgetEditText.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
        return true;
      }
      if (!StringUtil.e(this.jdField_f_of_type_AndroidWidgetTextView.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        return true;
      }
      if (!Arrays.equals((String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag(), new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict })) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) {
        return true;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby) {
        return true;
      }
      boolean bool2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible == 0L) {}
      for (boolean bool1 = true; bool2 != bool1; bool1 = false) {
        return true;
      }
      Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag;
      int i2 = localObject2.length;
      i1 = 0;
      n = 0;
      if (i1 >= i2) {
        break label593;
      }
      StringBuilder localStringBuilder = localObject2[i1];
      if (localStringBuilder == null) {}
      do
      {
        i1 += 1;
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(localStringBuilder.jdField_a_of_type_Int);
      } while ((localObject1 == null) && (localStringBuilder.jdField_a_of_type_JavaUtilArrayList.size() == 0));
      if (!localStringBuilder.equals(localObject1))
      {
        n = 1;
        label476:
        if (n == 0) {
          break label590;
        }
        i1 = n;
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          localStringBuilder = ((StringBuilder)localObject2).append("tagChanged \n").append("item: ").append(localStringBuilder.toString()).append("\n").append("tag: ");
          if (localObject1 != null) {
            break label580;
          }
          localObject1 = "null";
          label540:
          localStringBuilder.append((String)localObject1).append("\n");
          QLog.i("InterestTag", 4, ((StringBuilder)localObject2).toString());
        }
      }
    }
    label580:
    label590:
    label593:
    for (int i1 = n;; i1 = n)
    {
      if (i1 != 0)
      {
        return true;
        n = 0;
        break label476;
        localObject1 = ((InterestTag)localObject1).toString();
        break label540;
      }
      return false;
      break;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.oldPhotoCount > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age >= 14) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age <= 24) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= 1))
    {
      a(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481B", "0X800481B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      Object localObject = (PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0);
      a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, (PicInfo)localObject, null);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(a(true));
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnDragListener(this.jdField_a_of_type_Tos);
        localObject = new LayoutTransition();
        ((LayoutTransition)localObject).setAnimator(2, null);
        if (Build.VERSION.SDK_INT <= 15)
        {
          ((LayoutTransition)localObject).setAnimator(0, null);
          ((LayoutTransition)localObject).setAnimator(1, null);
          ((LayoutTransition)localObject).setAnimator(3, null);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutTransition((LayoutTransition)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int n = 1;
      while (n < this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(n), null));
        n += 1;
      }
      a(8);
    }
    k();
  }
  
  public void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "doOldSaveAction, picInfo size|" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size());
    }
    this.m = ((int)(System.currentTimeMillis() / 1000L));
    PicInfo localPicInfo = (PicInfo)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
    if ((localPicInfo != null) && (TextUtils.isEmpty(localPicInfo.f)) && (!TextUtils.isEmpty(localPicInfo.e)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a("正在上传视频");
      ThreadManager.a(new toa(this, localPicInfo), 8, null, true);
      return;
    }
    p();
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a("正在保存资料...");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
    if (c()) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    int n;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      Object localObject2 = (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[0];
      }
      localBundle.putByteArray("key_xuan_yan", (byte[])localObject1);
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag()))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname))
      {
        localBundle.putString("key_new_nickname", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
      }
      if ((this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus))
      {
        localBundle.putByte("key_marital_status", ((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 3, 0, "", "", "", "");
      }
      byte b1 = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
      if (b1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)
      {
        localBundle.putByte("sex", b1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
      }
      localObject1 = (Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag();
      n = ((Integer)localObject1[0]).intValue();
      if (n != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
      {
        localBundle.putInt("birthday", n);
        localBundle.putInt("age", ((Integer)localObject1[1]).intValue());
        localBundle.putInt("key_constellation", ((Integer)localObject1[2]).intValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
      }
      n = ((Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).intValue();
      if (n != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job)
      {
        localBundle.putInt("profession", n);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 6, 0, "", "", "", "");
      }
      localObject1 = this.jdField_e_of_type_AndroidWidgetEditText.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
      {
        localBundle.putString("company", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 7, 0, "", "", "", "");
      }
      localObject1 = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
      {
        localBundle.putString("college", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 8, 0, "", "", "", "");
      }
      localObject1 = (String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
      if (!Arrays.equals((Object[])localObject1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict }))
      {
        localBundle.putStringArray("hometown", (String[])localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 9, 0, "", "", "", "");
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (bool1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone)
      {
        if (!bool1) {
          break label1234;
        }
        n = 0;
        localBundle.putShort("key_qzone_switch", (short)n);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (!bool1) {
        break label1240;
      }
      localObject1 = "1";
      label964:
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004821", "0X8004821", 0, 0, (String)localObject1, "", "", "");
      bool1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (bool1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby)
      {
        if (!bool1) {
          break label1247;
        }
        n = 0;
        label1019:
        localBundle.putShort("key_hobby_switch", (short)n);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (!bool1) {
        break label1253;
      }
      localObject1 = "1";
      label1047:
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004822", "0X8004822", 0, 0, (String)localObject1, "", "", "");
      boolean bool2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
        break label1260;
      }
      bool1 = true;
      label1097:
      if (bool2 != bool1)
      {
        if (!bool2) {
          break label1266;
        }
        n = 0;
        label1112:
        localBundle.putShort("key_flower_visible_switch", (short)n);
        if (!bool2) {
          break label1272;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BB", "0X80060BB", 0, 0, "", "", "", "");
      }
      label1161:
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.update_profile", 2, "Q.nearby_people_card..saveNearbyProfileCard, modified_data = " + localBundle.toString());
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler;
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new toh(this, (NearbyCardHandler)localObject1, localBundle, localArrayList));
    }
    label1234:
    label1240:
    label1247:
    label1253:
    label1260:
    label1266:
    label1272:
    while (!QLog.isDevelopLevel())
    {
      return;
      n = 1;
      break;
      localObject1 = "0";
      break label964;
      n = 1;
      break label1019;
      localObject1 = "0";
      break label1047;
      bool1 = false;
      break label1097;
      n = 1;
      break label1112;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BC", "0X80060BC", 0, 0, "", "", "", "");
      break label1161;
    }
    QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {}
    String[] arrayOfString;
    String str;
    do
    {
      return;
      arrayOfString = new String[4];
      arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry;
      arrayOfString[1] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
      arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
      arrayOfString[3] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
      str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(arrayOfString);
    } while (this.jdField_f_of_type_AndroidWidgetEditText == null);
    if (!"不限".equals(str)) {
      this.jdField_f_of_type_AndroidWidgetEditText.setText(str);
    }
    this.jdField_f_of_type_AndroidWidgetEditText.setTag(arrayOfString);
  }
  
  public void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, JobSelectionActivity.class);
    if ((this.jdField_d_of_type_AndroidWidgetEditText != null) && (this.jdField_d_of_type_AndroidWidgetEditText.getTag() != null) && ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() instanceof Integer))) {
      localIntent.putExtra("param_id", (Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag());
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 3);
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(58);
    int n = localConditionSearchManager.a();
    Object localObject1;
    if (n != 0)
    {
      n = localConditionSearchManager.a(n);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "startLocationSelectActivity | update result = " + n);
      }
      if (n == 2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131369008, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
        return;
      }
      if (n == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131371450));
        localConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131371450));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      ((Handler)localObject1).sendEmptyMessageDelayed(206, 20000L);
      return;
    }
    Object localObject2 = (String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length == 4) {}
    }
    else
    {
      localObject1 = new String[4];
      localObject1[0] = "0";
      localObject1[1] = "0";
      localObject1[2] = "0";
      localObject1[3] = "0";
    }
    localIntent.putExtra("param_location", (String[])localObject1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", localConditionSearchManager.b((String[])localObject1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 4);
  }
  
  public void i()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, EditActivity.class);
    localIntent.putExtra("param_entry", 1);
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag());
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    int i1;
    if ((paramView.getId() == 2131302056) || (paramView == this.jdField_b_of_type_AndroidWidgetEditText))
    {
      localObject1 = ActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131296881);
      ((DispatchActionMoveScrollView)localObject2).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2130904203, null);
      ((IphonePickerView)localObject2).a(this.jdField_c_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
      if (this.jdField_b_of_type_AndroidWidgetEditText.getTag() != null)
      {
        i1 = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
        if (i1 >= 0)
        {
          n = i1;
          if (i1 <= 1) {}
        }
        else
        {
          n = 0;
        }
        ((IphonePickerView)localObject2).setSelection(0, n);
        ((IphonePickerView)localObject2).setPickListener(new tne(this, (IphonePickerView)localObject2, (ActionSheet)localObject1));
        ((ActionSheet)localObject1).a(new tnt(this));
        ((ActionSheet)localObject1).b((View)localObject2, null);
        ((ActionSheet)localObject1).show();
        a(paramView, ((ActionSheet)localObject1).a());
        a(this.jdField_b_of_type_AndroidWidgetEditText, true);
      }
    }
    int i2;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramView.getId() == 2131302062) || (paramView == this.jdField_d_of_type_AndroidWidgetEditText))
          {
            g();
            return;
          }
          if (paramView == this.jdField_d_of_type_AndroidWidgetLinearLayout)
          {
            paramView = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("busi_id", 24);
            ((Bundle)localObject1).putInt("busi_version", 1);
            ((Bundle)localObject1).putString("busi_from", "profileCard");
            ((Bundle)localObject1).putString("busi_title", "学校");
            ((Bundle)localObject1).putString("busi_extra", paramView);
            BaseBusi.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, true, 12, (Bundle)localObject1);
            return;
          }
          if ((paramView.getId() == 2131302068) || (paramView == this.jdField_f_of_type_AndroidWidgetEditText))
          {
            h();
            return;
          }
          if ((paramView.getId() == 2131302059) || (paramView == this.jdField_g_of_type_AndroidWidgetEditText))
          {
            i();
            return;
          }
          if ((paramView.getId() == 2131302061) || (paramView == this.jdField_h_of_type_AndroidWidgetEditText))
          {
            j();
            return;
          }
          if ((paramView.getId() != 2131302058) && (paramView != this.jdField_c_of_type_AndroidWidgetEditText)) {
            break;
          }
          localObject1 = ActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
          localObject2 = (DispatchActionMoveScrollView)((ActionSheet)localObject1).findViewById(2131296881);
          ((DispatchActionMoveScrollView)localObject2).jdField_a_of_type_Boolean = true;
          ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
          localObject2 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2130904203, null);
          ((IphonePickerView)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
        } while (this.jdField_c_of_type_AndroidWidgetEditText.getTag() == null);
        n = ((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue();
        if (n == 0)
        {
          i1 = 0;
          i2 = 94;
        }
        for (n = 0;; n = (n & 0xFF) - 1)
        {
          Calendar localCalendar = Calendar.getInstance();
          localCalendar.setTimeInMillis(System.currentTimeMillis());
          this.jdField_e_of_type_Int = localCalendar.get(1);
          this.jdField_f_of_type_Int = (localCalendar.get(2) + 1);
          this.jdField_g_of_type_Int = localCalendar.get(5);
          ((IphonePickerView)localObject2).setPickListener(new tok(this, (IphonePickerView)localObject2, (ActionSheet)localObject1));
          ((IphonePickerView)localObject2).setSelection(0, i2);
          ((IphonePickerView)localObject2).setSelection(1, i1);
          ((IphonePickerView)localObject2).setSelection(2, n);
          ((ActionSheet)localObject1).a(new tom(this));
          ((ActionSheet)localObject1).b((View)localObject2, null);
          ((ActionSheet)localObject1).show();
          a(paramView, ((ActionSheet)localObject1).a());
          a(this.jdField_c_of_type_AndroidWidgetEditText, true);
          return;
          i2 = (n >>> 16) - 1896;
          i1 = ((0xFF00 & n) >>> 8) - 1;
        }
        if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a("正在导入");
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(NearbyPeopleProfileActivity.r, 3);
          return;
        }
        if (paramView != this.jdField_a_of_type_AndroidWidgetImageView) {
          break label764;
        }
        if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
          break;
        }
      } while (!(this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag() instanceof PicInfo));
      paramView = (PicInfo)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
    } while (TextUtils.isEmpty(paramView.d));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c(paramView.d);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    return;
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131369008));
    return;
    label764:
    int n = 0;
    label767:
    if (n < 4) {
      if (paramView != this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[n]) {}
    }
    for (;;)
    {
      i2 = n;
      if (n == -1) {
        i1 = 0;
      }
      for (;;)
      {
        i2 = n;
        if (i1 < 3)
        {
          if (paramView == this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1]) {
            i2 = i1 + 4;
          }
        }
        else
        {
          if (i2 < 0) {
            break;
          }
          paramView = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i2];
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChooseInterestTagActivity.class);
          ((Intent)localObject1).putExtra("interest_tag_type", paramView.jdField_a_of_type_Int);
          ((Intent)localObject1).putExtra("is_from_judge", false);
          ((Intent)localObject1).putExtra("from_where", "NearbyPeopleProfileActivity");
          ((Intent)localObject1).putParcelableArrayListExtra("choosed_interest_tags", paramView.jdField_a_of_type_JavaUtilArrayList);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult((Intent)localObject1, 11);
          paramView = jdField_a_of_type_ArrayOfJavaLangString[i2];
          ThreadManager.b().post(new ton(this, paramView));
          return;
          n += 1;
          break label767;
        }
        i1 += 1;
      }
      n = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\profilecard\NearbyProfileEditPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */