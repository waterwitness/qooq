package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.compat.ViewCompat;
import com.tencent.biz.qqstory.takevideo.doodle.loader.ImageLoader;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LogoIconAdapter
  extends BaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "LogoIconAdapter";
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private FacePanelAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public LogoIconAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 30.0F);
    this.c = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.d = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 45.0F);
    this.e = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.f = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 7.5F);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private ImageView a(boolean paramBoolean)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.c, this.d);
    localImageView.setPadding(this.e, this.f, this.e, this.f);
    localImageView.setLayoutParams(localLayoutParams);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.5F)
    {
      ViewCompat.a(localImageView, f1);
      return localImageView;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(FacePanelAdapter paramFacePanelAdapter)
  {
    if (paramFacePanelAdapter == null) {
      throw new IllegalArgumentException("FacePanelAdapter is null.");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter = paramFacePanelAdapter;
    notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localImageView == null) {
      SLog.e("LogoIconAdapter", "position is illegal:" + paramInt + ", the array size: " + this.jdField_a_of_type_AndroidUtilSparseArray.size());
    }
    FacePackage localFacePackage;
    String str;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter.a()))
      {
        SLog.e("LogoIconAdapter", "position is illegal or Adapter is null, position:" + paramInt);
        return;
      }
      localFacePackage = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter.a(paramInt);
      if (localFacePackage == null)
      {
        SLog.e("LogoIconAdapter", "FacePackage is null.");
        return;
      }
      str = (String)localImageView.getTag(2131296665);
    } while ((!TextUtils.isEmpty(str)) && (str.equals(localFacePackage.c)));
    localImageView.setTag(2131296665, localFacePackage.c);
    ImageLoader.a().a(this.jdField_a_of_type_AndroidContentContext, localImageView, localFacePackage.c, this.b, this.b, null);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelAdapter == null) {
      return paramView;
    }
    if (paramView == null)
    {
      paramView = a(false);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
      if (paramInt == this.jdField_a_of_type_Int) {
        ViewCompat.a(paramView, 1.0F);
      }
      paramViewGroup = (FacePackage)getItem(paramInt);
      if (paramViewGroup != null)
      {
        if (paramViewGroup.a == null) {
          break label92;
        }
        SLog.b("LogoIconAdapter", "logo is already load. ");
        paramView.setImageDrawable(paramViewGroup.a);
      }
    }
    for (;;)
    {
      return paramView;
      paramView = (ImageView)paramView;
      ViewCompat.a(paramView, 0.5F);
      break;
      label92:
      String str = (String)paramView.getTag(2131296665);
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramViewGroup.c)))
      {
        paramView.setTag(2131296665, paramViewGroup.c);
        ImageLoader.a().a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup.c, this.b, this.b, null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\face\adapter\LogoIconAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */