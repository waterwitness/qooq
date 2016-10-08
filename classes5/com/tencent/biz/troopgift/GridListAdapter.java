package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import jen;

public class GridListAdapter
  extends BaseAdapter
{
  protected static HashMap a;
  protected int a;
  public Context a;
  protected Drawable a;
  protected LayoutInflater a;
  protected String a;
  protected ArrayList a;
  protected int b;
  
  public GridListAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842810);
    this.jdField_a_of_type_Int = -1;
    this.b = AIOUtils.a(9.0F, paramContext.getResources());
  }
  
  public Bitmap a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Object localObject1 = new Canvas(localBitmap);
      Object localObject2 = new Paint();
      ((Paint)localObject2).setColor(paramInt4);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setStrokeWidth(paramFloat2);
      ((Paint)localObject2).setAntiAlias(true);
      ((Canvas)localObject1).drawRoundRect(new RectF(paramFloat2 / 2.0F, paramFloat2 / 2.0F, paramInt1 - paramFloat2 / 2.0F, paramInt2 - paramFloat2 / 2.0F), paramInt3, paramInt3, (Paint)localObject2);
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      Paint localPaint = new Paint();
      ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
      paramFloat1 = (paramInt1 - paramFloat1) / 2.0F;
      ((Canvas)localObject2).drawRect(paramFloat1, 0.0F, paramInt1 - paramFloat1, paramInt3, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      ((Canvas)localObject2).drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      localBitmap.recycle();
      return (Bitmap)localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("GridListAdapter setData items = ");
      if (paramArrayList != null) {
        break label51;
      }
    }
    label51:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      QLog.d("zivonchen", 2, localObject);
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903901, null);
      paramView = new GridListAdapter.Holder();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131300601));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131300602));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131300603));
      paramView.c = ((TextView)paramViewGroup.findViewById(2131300600));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131300598);
      paramViewGroup.setTag(paramView);
    }
    GridListAdapter.Holder localHolder = (GridListAdapter.Holder)paramViewGroup.getTag();
    TroopGiftAioItemData localTroopGiftAioItemData = (TroopGiftAioItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localHolder.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftAioItemData = localTroopGiftAioItemData;
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopGiftAioItemData.i);
    if (localTroopGiftAioItemData.b > 0)
    {
      localHolder.b.setText(String.valueOf(localTroopGiftAioItemData.b));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, paramView);
        paramView.setBounds(0, 0, this.b, this.b);
        localHolder.b.setCompoundDrawables(paramView, null, null, null);
        label207:
        paramView = URLDrawable.URLDrawableOptions.obtain();
        if (!localTroopGiftAioItemData.a) {
          break label460;
        }
        if (localTroopGiftAioItemData.d >= 0) {
          break label421;
        }
        paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427884);
        localHolder.c.setText(localTroopGiftAioItemData.l);
        localHolder.c.setTextColor(paramInt);
        label263:
        localHolder.c.setVisibility(0);
        localHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localHolder.jdField_a_of_type_AndroidViewView.post(new jen(this, localHolder, localTroopGiftAioItemData, paramInt));
        paramView.mPlayGifImage = true;
        if ((jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.get(localTroopGiftAioItemData.k) != null))
        {
          Drawable localDrawable = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(localTroopGiftAioItemData.k);
          paramView.mFailedDrawable = localDrawable;
          paramView.mLoadingDrawable = localDrawable;
        }
        paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.j, paramView);
      }
    }
    for (;;)
    {
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      return paramViewGroup;
      paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break;
      localHolder.b.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364323));
      localHolder.b.setCompoundDrawables(null, null, null, null);
      break label207;
      label421:
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427885);
      localHolder.c.setText(localTroopGiftAioItemData.l);
      localHolder.c.setTextColor(paramInt);
      break label263;
      label460:
      localHolder.jdField_a_of_type_AndroidViewView.setVisibility(4);
      localHolder.c.setVisibility(4);
      paramView.mPlayGifImage = false;
      paramView = URLDrawable.getDrawable(localTroopGiftAioItemData.k, paramView);
      if (jdField_a_of_type_JavaUtilHashMap == null) {
        jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      jdField_a_of_type_JavaUtilHashMap.put(localTroopGiftAioItemData.k, paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\GridListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */