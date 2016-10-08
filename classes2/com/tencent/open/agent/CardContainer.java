package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthItem;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wqt;
import wqu;
import wqv;

public class CardContainer
  extends RelativeLayout
{
  protected static final float a = 600.0F;
  public static final int a = 0;
  protected static final String a = "CardContainer";
  protected static final float b = 640.0F;
  public static final int b = 1;
  protected static final String b = "http://i.gtimg.cn/open/app_icon";
  protected static final float c = 0.9375F;
  public static final int c = -1;
  private static final int g = 10001;
  public Drawable a;
  public Handler a;
  protected LayoutInflater a;
  public View a;
  protected ImageView a;
  protected ListView a;
  protected RelativeLayout a;
  protected TextView a;
  protected URLDrawableDownListener.Adapter a;
  protected AnyScaleTypeImageView a;
  protected CardContainer.PermissionAdapter a;
  protected CardLargeView a;
  protected List a;
  protected ImageView b;
  protected RelativeLayout b;
  protected TextView b;
  public AnyScaleTypeImageView b;
  protected ImageView c;
  protected TextView c;
  protected int d;
  protected ImageView d;
  protected TextView d;
  protected final int e;
  protected TextView e;
  protected final int f;
  protected TextView f;
  protected TextView g;
  
  public CardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new wqt(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new wqu(this);
    new DisplayMetrics();
    paramAttributeSet = getResources().getDisplayMetrics();
    this.jdField_e_of_type_Int = paramAttributeSet.widthPixels;
    this.jdField_f_of_type_Int = paramAttributeSet.heightPixels;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public String a()
  {
    String str = AuthorityActivity.y;
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    int j = str.length();
    if (j >= 8) {}
    StringBuilder localStringBuilder;
    for (Object localObject = str.substring(j - 8);; localObject = str)
    {
      localStringBuilder = new StringBuilder("http://i.gtimg.cn/open/app_icon");
      int i = 2;
      j = 0;
      while (j < 8)
      {
        localStringBuilder.append("/");
        localStringBuilder.append(((String)localObject).substring(j, i));
        j += 2;
        i += 2;
      }
      localObject = new StringBuilder();
      i = 0;
      while (i < 8 - j)
      {
        ((StringBuilder)localObject).append("0");
        i += 1;
      }
    }
    localStringBuilder.append("/").append(str).append("_").append("android").append("_").append("ad").append("_").append("0.jpg");
    localStringBuilder.replace(0, 4, "gamead");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "--> result: " + (String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    ThreadManager.b(new wqv(this));
    if (paramInt == this.jdField_d_of_type_Int) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = paramInt;
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(paramString))
    {
      if (getTag() != null) {
        ((TextView)findViewById(2131298887)).setText("该服务由" + paramString + "提供，提供以下权限即可继续操作");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    int j;
    if (!TextUtils.isEmpty(paramString2))
    {
      j = 0;
      i = 0;
      if (j >= paramString2.length()) {
        break label212;
      }
      if (String.valueOf(paramString2.charAt(j)).getBytes().length <= 1) {
        break label194;
      }
      i += 2;
      label45:
      if (i <= 10) {
        break label203;
      }
    }
    label194:
    label203:
    label212:
    for (int i = 1;; i = 0)
    {
      String str = paramString2.substring(0, j);
      paramString2 = str;
      if (i != 0) {
        paramString2 = str + "...";
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = String.format(super.getContext().getString(2131363149), new Object[] { paramString1 });
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString1);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString1);
        if (this.g.getVisibility() == 0) {
          this.g.setVisibility(8);
        }
      }
      if (paramBitmap != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
      return;
      i += 1;
      break label45;
      j += 1;
      break;
    }
  }
  
  public boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = paramGetAuthApiListResponse.authorized_form_list.get();
    paramGetAuthApiListResponse = new StringBuilder(((List)localObject).size() * 128);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SdkAuthorize.AuthItem localAuthItem = (SdkAuthorize.AuthItem)((Iterator)localObject).next();
      if (localAuthItem.is_new.get() != 0)
      {
        CardContainer.Permission localPermission = new CardContainer.Permission();
        localPermission.jdField_b_of_type_JavaLangString = localAuthItem.api_list.get();
        localPermission.jdField_a_of_type_Int = localAuthItem.default_flag.get();
        localPermission.jdField_b_of_type_Int = localAuthItem.id.get();
        if (localAuthItem.is_new.get() == 0) {}
        for (bool = false;; bool = true)
        {
          localPermission.jdField_a_of_type_Boolean = bool;
          localPermission.jdField_a_of_type_JavaLangString = localAuthItem.title.get();
          if (QLog.isColorLevel()) {
            paramGetAuthApiListResponse.append("--> Permission p, api: ").append(localPermission.jdField_b_of_type_JavaLangString).append(" | flag: ").append(localPermission.jdField_a_of_type_Int).append(" | id: ").append(localPermission.jdField_b_of_type_Int).append(" | isNew: ").append(localPermission.jdField_a_of_type_Boolean).append(" | title: ").append(localPermission.jdField_a_of_type_JavaLangString).append("\n");
          }
          this.jdField_a_of_type_JavaUtilList.add(localPermission);
          break;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, paramGetAuthApiListResponse.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {}
    for (boolean bool = true; bool; bool = false)
    {
      paramGetAuthApiListResponse = this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
      a(1);
      this.g.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("CardContainer", 2, "--> has been authority.");
      }
      setAdImageByURL(paramGetAuthApiListResponse, a());
      return bool;
    }
    a(0);
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "--> has not been authority.");
    }
    if (this.jdField_a_of_type_ComTencentOpenAgentCardContainer$PermissionAdapter == null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer$PermissionAdapter = new CardContainer.PermissionAdapter(this);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentCardContainer$PermissionAdapter);
      return bool;
    }
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer$PermissionAdapter.notifyDataSetChanged();
    return bool;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298876));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298864));
    this.jdField_a_of_type_ComTencentOpenAgentCardLargeView = ((CardLargeView)super.findViewById(2131298865));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131298881));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131298869));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131298866);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298879));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298883));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298880));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298884));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298885));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298867));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298871));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298868));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298873));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298874));
    this.g = ((TextView)super.findViewById(2131298875));
    this.g.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131298888));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = super.getResources().getDimension(2131493860);
    f1 = this.jdField_e_of_type_Int - f1 * 2.0F;
    float f2 = f1 / 0.9375F;
    super.setMeasuredDimension((int)f1, (int)f2);
  }
  
  public void setAdImageByURL(AnyScaleTypeImageView paramAnyScaleTypeImageView, String paramString)
  {
    AnyScaleTypeImageView localAnyScaleTypeImageView = paramAnyScaleTypeImageView;
    if (paramAnyScaleTypeImageView == null) {
      localAnyScaleTypeImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
      for (paramAnyScaleTypeImageView = new ColorDrawable(0);; paramAnyScaleTypeImageView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
      {
        paramAnyScaleTypeImageView = URLDrawable.getDrawable(paramString, paramAnyScaleTypeImageView, paramAnyScaleTypeImageView);
        paramAnyScaleTypeImageView.setAutoDownload(true);
        if (QLog.isColorLevel()) {
          QLog.d("CardContainer", 2, "-->url drawabel status: " + paramAnyScaleTypeImageView.getStatus());
        }
        if (paramAnyScaleTypeImageView.getStatus() != 1) {
          break;
        }
        localAnyScaleTypeImageView.setVisibility(0);
        localAnyScaleTypeImageView.setImageDrawable(paramAnyScaleTypeImageView);
        return;
      }
    }
    catch (OutOfMemoryError paramAnyScaleTypeImageView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CardContainer", 2, "-->create color drawable oom.", paramAnyScaleTypeImageView);
        }
        paramAnyScaleTypeImageView = null;
        continue;
        localAnyScaleTypeImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\CardContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */