package com.tencent.mobileqq.rn;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager;
import com.tencent.mobileqq.nearby.rn.NearbyScrollView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.ScrollStateDetector;
import com.tencent.mobileqq.widget.ScrollStateDetector.OnScrollListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class QAvatarHelper
  implements FaceDecoder.DecodeTaskCompletionListener, ScrollStateDetector.OnScrollListener
{
  static final int jdField_a_of_type_Int = 6;
  static QAvatarHelper jdField_a_of_type_ComTencentMobileqqRnQAvatarHelper;
  static final String jdField_a_of_type_JavaLangString = QAvatarHelper.class.getSimpleName();
  static final boolean jdField_a_of_type_Boolean = false;
  static final int jdField_b_of_type_Int = 10;
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplication.getContext().getResources();
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(NearbyRNAppManager.a());
  LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(40);
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(30);
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(40);
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  int c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private QAvatarHelper()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.b = new ArrayList(8);
  }
  
  public static QAvatarHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRnQAvatarHelper == null) {
      jdField_a_of_type_ComTencentMobileqqRnQAvatarHelper = new QAvatarHelper();
    }
    return jdField_a_of_type_ComTencentMobileqqRnQAvatarHelper;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRnQAvatarHelper != null) {
      jdField_a_of_type_ComTencentMobileqqRnQAvatarHelper.b();
    }
    jdField_a_of_type_ComTencentMobileqqRnQAvatarHelper = null;
  }
  
  RCTAvatar a(ViewGroup paramViewGroup)
  {
    RCTAvatar localRCTAvatar = null;
    Object localObject = null;
    if (paramViewGroup == null) {}
    int j;
    int i;
    do
    {
      do
      {
        return (RCTAvatar)localObject;
        j = paramViewGroup.getChildCount();
        i = 0;
        localObject = localRCTAvatar;
      } while (localRCTAvatar != null);
      localObject = localRCTAvatar;
    } while (i >= j);
    localObject = paramViewGroup.getChildAt(i);
    if ((localObject instanceof RCTAvatar)) {
      localRCTAvatar = (RCTAvatar)localObject;
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject instanceof ViewGroup)) {
        localRCTAvatar = a((ViewGroup)localObject);
      }
    }
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramInt1).append("_").append(paramInt2).append("_").append(paramString);
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramInt2 != 32) {
      return;
    }
    String str = a(3, 202, paramString);
    Integer localInteger = (Integer)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str);
    Object localObject = localInteger;
    if (localInteger == null)
    {
      str = a(3, 200, paramString);
      localObject = (Integer)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str);
    }
    if (localObject == null)
    {
      paramString = a(3, 204, paramString);
      localObject = (Integer)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localObject != null) && (((Integer)localObject).intValue() >= 0) && (((Integer)localObject).intValue() < this.jdField_a_of_type_JavaUtilArrayList.size())) {}
      for (localObject = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(((Integer)localObject).intValue());; localObject = null)
      {
        if (localObject == null)
        {
          localObject = null;
          if (localObject == null) {
            break label225;
          }
        }
        label225:
        for (str = a(((RCTAvatar)localObject).jdField_b_of_type_Int, ((RCTAvatar)localObject).jdField_c_of_type_Int, ((RCTAvatar)localObject).jdField_c_of_type_JavaLangString);; str = null)
        {
          if ((localObject == null) || (paramBitmap == null) || (!NearbyUtils.a(paramString, str))) {
            break label229;
          }
          ((RCTAvatar)localObject).setImageDrawable(paramString, new BitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, paramBitmap));
          return;
          localObject = (RCTAvatar)((WeakReference)localObject).get();
          break;
        }
        label229:
        break;
      }
      paramString = str;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    NearbyScrollView localNearbyScrollView;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localNearbyScrollView = (NearbyScrollView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localNearbyScrollView == paramView) {
        break label70;
      }
      if ((paramView instanceof NearbyScrollView)) {
        ((NearbyScrollView)paramView).setScrollListener(null);
      }
      if (localNearbyScrollView != null) {
        localNearbyScrollView.setScrollListener(new ScrollStateDetector(this, localNearbyScrollView.getContext()));
      }
    }
    label70:
    while (paramInt2 == paramInt1)
    {
      return;
      localNearbyScrollView = null;
      break;
    }
    this.jdField_c_of_type_Int = paramInt2;
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      c();
      return;
    case 1: 
      d();
      return;
    }
    d();
  }
  
  void a(RCTAvatar paramRCTAvatar)
  {
    RCTAvatar localRCTAvatar = paramRCTAvatar;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
        localRCTAvatar = paramRCTAvatar;
      }
    }
    else
    {
      paramRCTAvatar = localRCTAvatar.getParent();
      if (!(paramRCTAvatar instanceof NearbyScrollView)) {
        break label75;
      }
      paramRCTAvatar = (NearbyScrollView)paramRCTAvatar;
      paramRCTAvatar.setScrollListener(new ScrollStateDetector(this, paramRCTAvatar.getContext()));
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRCTAvatar);
      paramRCTAvatar = null;
    }
    for (;;)
    {
      localRCTAvatar = paramRCTAvatar;
      if (paramRCTAvatar != null) {
        break;
      }
      return;
      label75:
      if ((paramRCTAvatar instanceof View)) {
        paramRCTAvatar = (View)paramRCTAvatar;
      } else {
        paramRCTAvatar = null;
      }
    }
  }
  
  void a(String paramString, RCTAvatar paramRCTAvatar)
  {
    if ((paramRCTAvatar == null) || (!TextUtils.isEmpty(paramRCTAvatar.jdField_b_of_type_JavaLangString))) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramRCTAvatar.jdField_c_of_type_JavaLangString, paramRCTAvatar.jdField_c_of_type_Int, (byte)paramRCTAvatar.jdField_b_of_type_Int);
      if (localBitmap != null) {
        break;
      }
      if (!paramRCTAvatar.jdField_a_of_type_Boolean) {
        paramRCTAvatar.setImageDrawable(null, ImageUtil.b());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
      {
        paramRCTAvatar.jdField_b_of_type_Boolean = false;
        return;
      }
    } while (paramRCTAvatar.jdField_b_of_type_Boolean);
    paramRCTAvatar.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramRCTAvatar.jdField_c_of_type_JavaLangString, paramRCTAvatar.jdField_c_of_type_Int, true, false);
    return;
    paramRCTAvatar.setImageDrawable(paramString, new BitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, localBitmap));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(RCTAvatar paramRCTAvatar)
  {
    if (paramRCTAvatar == null) {
      return;
    }
    a(paramRCTAvatar);
    String str = a(paramRCTAvatar.jdField_b_of_type_Int, paramRCTAvatar.jdField_c_of_type_Int, paramRCTAvatar.jdField_c_of_type_JavaLangString);
    if ((paramRCTAvatar.jdField_a_of_type_Int <= 0) || (paramRCTAvatar.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      paramRCTAvatar.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    WeakReference localWeakReference = null;
    if (paramRCTAvatar.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(paramRCTAvatar.jdField_a_of_type_Int);
    }
    if ((localWeakReference == null) || (localWeakReference.get() == null)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRCTAvatar.jdField_a_of_type_Int, new WeakReference(paramRCTAvatar));
    }
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(str, Integer.valueOf(paramRCTAvatar.jdField_a_of_type_Int));
    a(str, paramRCTAvatar);
  }
  
  void c()
  {
    Object localObject3 = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    Object localObject2;
    Object localObject1;
    int k;
    int n;
    int m;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localObject2 = null;
      int j = Integer.MAX_VALUE;
      int i = -1;
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (((NearbyScrollView)localObject2).getChildCount() > 0)
        {
          localObject2 = ((NearbyScrollView)localObject2).getChildAt(0);
          localObject1 = localObject3;
          if ((localObject2 instanceof ViewGroup)) {
            localObject1 = (ViewGroup)localObject2;
          }
        }
      }
      this.b.clear();
      k = i;
      n = j;
      if (localObject1 == null) {
        break label257;
      }
      k = i;
      n = j;
      if (((ViewGroup)localObject1).getChildCount() <= 0) {
        break label257;
      }
      m = 0;
      label114:
      k = i;
      n = j;
      if (m >= ((ViewGroup)localObject1).getChildCount()) {
        break label257;
      }
      if (!(((ViewGroup)localObject1).getChildAt(m) instanceof ViewGroup)) {
        break label360;
      }
      localObject2 = a((ViewGroup)((ViewGroup)localObject1).getChildAt(m));
      if (localObject2 == null) {
        break label360;
      }
      this.b.add(localObject2);
      k = j;
      if (((RCTAvatar)localObject2).jdField_a_of_type_Int < j) {
        k = ((RCTAvatar)localObject2).jdField_a_of_type_Int;
      }
      if (((RCTAvatar)localObject2).jdField_a_of_type_Int <= i) {
        break label357;
      }
      i = ((RCTAvatar)localObject2).jdField_a_of_type_Int;
      label204:
      ((RCTAvatar)localObject2).jdField_b_of_type_Boolean = false;
      a(a(((RCTAvatar)localObject2).jdField_b_of_type_Int, ((RCTAvatar)localObject2).jdField_c_of_type_Int, ((RCTAvatar)localObject2).jdField_c_of_type_JavaLangString), (RCTAvatar)localObject2);
      j = k;
    }
    label257:
    label357:
    label360:
    for (;;)
    {
      m += 1;
      break label114;
      localObject2 = (NearbyScrollView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      break;
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeakReference)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
        {
          localObject2 = (RCTAvatar)((WeakReference)localObject2).get();
          if ((localObject2 != null) && (!this.b.contains(localObject2)) && ((((RCTAvatar)localObject2).jdField_a_of_type_Int < n - 6) || (((RCTAvatar)localObject2).jdField_a_of_type_Int > k + 6))) {
            ((RCTAvatar)localObject2).a();
          }
        }
      }
      this.b.clear();
      return;
      break label204;
    }
  }
  
  void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\QAvatarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */