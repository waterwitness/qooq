package com.tencent.mobileqq.nearby.flat.async;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Adapter;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsFeedFactory;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.feed.FNDefaultItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.flat.canvas.UIElement;
import com.tencent.mobileqq.nearby.smooth.SimpleItemLoader;
import com.tencent.mobileqq.util.FaceDecoder;

public class FreshLayoutLoader
  extends SimpleItemLoader
{
  final Context jdField_a_of_type_AndroidContentContext;
  FreshNewsFeedAdapter jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter;
  final UIElementCache jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncUIElementCache;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  
  public FreshLayoutLoader(Context paramContext, UIElementCache paramUIElementCache, FaceDecoder paramFaceDecoder, FreshNewsFeedAdapter paramFreshNewsFeedAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncUIElementCache = paramUIElementCache;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter = paramFreshNewsFeedAdapter;
  }
  
  public FNDefaultItemData a(Adapter paramAdapter, int paramInt)
  {
    paramAdapter = paramAdapter.getItem(paramInt);
    if ((paramAdapter instanceof FNDefaultItemData)) {
      return (FNDefaultItemData)paramAdapter;
    }
    return null;
  }
  
  public UIElement a(FNDefaultItemData paramFNDefaultItemData)
  {
    FNDefaultItemBuilder localFNDefaultItemBuilder = (FNDefaultItemBuilder)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a.a(paramFNDefaultItemData);
    Bitmap localBitmap = localFNDefaultItemBuilder.a(paramFNDefaultItemData, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    return AsyncFlatElementFactory.a(this.jdField_a_of_type_AndroidContentContext, paramFNDefaultItemData, localBitmap, localFNDefaultItemBuilder);
  }
  
  public void a(View paramView, UIElement paramUIElement, boolean paramBoolean) {}
  
  public UIElement b(FNDefaultItemData paramFNDefaultItemData)
  {
    return (UIElement)this.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncUIElementCache.get(paramFNDefaultItemData.e);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\async\FreshLayoutLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */