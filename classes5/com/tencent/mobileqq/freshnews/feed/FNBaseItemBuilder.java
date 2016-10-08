package com.tencent.mobileqq.freshnews.feed;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;

public abstract class FNBaseItemBuilder
{
  public static final int a = -1;
  public static final String b = "freshnews.small_pic_download";
  
  public FNBaseItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract View a(int paramInt, Object paramObject, FaceDecoder paramFaceDecoder, boolean paramBoolean, View paramView1, View paramView2, Context paramContext, View.OnClickListener paramOnClickListener);
  
  public void a(Context paramContext, View paramView, FNBaseItemData paramFNBaseItemData) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramView.getVisibility() != paramInt) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public void a(View paramView, Context paramContext, Object paramObject, Bitmap paramBitmap) {}
  
  public void a(View paramView, Bitmap paramBitmap) {}
  
  public void a(View paramView, FNBaseItemData paramFNBaseItemData, FaceDecoder paramFaceDecoder) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\feed\FNBaseItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */