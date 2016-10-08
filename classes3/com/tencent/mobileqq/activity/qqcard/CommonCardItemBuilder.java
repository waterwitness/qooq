package com.tencent.mobileqq.activity.qqcard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonCardItemBuilder
  extends BaseCardItemBuilder
  implements View.OnClickListener
{
  Resources jdField_a_of_type_AndroidContentResResources;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap;
  int b;
  
  public CommonCardItemBuilder(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.b = -1;
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = null;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(10);
    try
    {
      paramContext = ImageUtil.b(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130841830), 50, 50);
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, paramContext);
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130841790);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130841789);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, paramContext.toString());
        }
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, paramContext.toString());
        }
      }
    }
    catch (Error paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, paramContext.toString());
        }
      }
    }
  }
  
  private void a(CommonCardItemBuilder.ViewHolder paramViewHolder, QQCardItem paramQQCardItem, int paramInt)
  {
    if (paramQQCardItem.itemType == 0)
    {
      localObject2 = (Drawable)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    label264:
    while (paramQQCardItem.itemType != 5)
    {
      for (;;)
      {
        try
        {
          localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, this.jdField_a_of_type_AndroidGraphicsBitmap);
          localObject1 = localObject2;
        }
        catch (Exception localException1)
        {
          try
          {
            ((Drawable)localObject1).setBounds(0, 0, QQCardConstant.u, QQCardConstant.u);
            ((Drawable)localObject1).setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
            this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(Integer.valueOf(paramInt), localObject1);
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
            paramInt = QQCardManager.a(NetConnInfoCenter.getServerTimeMillis() / 1000L, paramQQCardItem.expireTime);
            if (paramInt >= 7) {
              break label264;
            }
            if (paramInt != 0) {
              break;
            }
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("即将于今天过期");
            return;
          }
          catch (Error localError2)
          {
            for (;;)
            {
              localObject2 = localObject1;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            localObject2 = localObject1;
            continue;
          }
          catch (Exception localException2)
          {
            Object localObject1;
            Object localObject2 = localObject1;
            continue;
          }
          localException1 = localException1;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 2, localException1.toString());
          localObject1 = localObject2;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 2, localOutOfMemoryError1.toString());
          localObject1 = localObject2;
          continue;
        }
        catch (Error localError1) {}
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, localError1.toString());
          localObject1 = localObject2;
        }
      }
      if (paramInt == 1)
      {
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("即将于明天过期");
        return;
      }
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("即将于%d天后过期", new Object[] { Integer.valueOf(paramInt) }));
      return;
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(QQCardConstant.a.format(new Date(paramQQCardItem.expireTime * 1000L)));
      return;
    }
    paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramQQCardItem.distance);
  }
  
  public BaseCardItemBuilder.BaseHolder a(View paramView)
  {
    return new CommonCardItemBuilder.ViewHolder(paramView);
  }
  
  public void a(Object paramObject, BaseCardItemBuilder.BaseHolder paramBaseHolder)
  {
    paramBaseHolder = (CommonCardItemBuilder.ViewHolder)paramBaseHolder;
    QQCardItem localQQCardItem = (QQCardItem)paramObject;
    if (!TextUtils.isEmpty(localQQCardItem.iconUrl)) {}
    for (;;)
    {
      label70:
      int k;
      int n;
      int j;
      int m;
      try
      {
        paramObject = new URL(localQQCardItem.iconUrl);
        if (paramObject != null)
        {
          paramObject = URLDrawableHelper.a((URL)paramObject, QQCardConstant.t, QQCardConstant.t, this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          ((URLDrawable)paramObject).setDecodeHandler(URLDrawableDecodeHandler.a);
          paramBaseHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramObject);
          paramBaseHolder.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          paramBaseHolder.jdField_c_of_type_AndroidViewView.setTag(localQQCardItem);
          paramBaseHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localQQCardItem.title);
          paramBaseHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localQQCardItem.subTitle);
          paramBaseHolder.d.setText(localQQCardItem.brand);
          k = this.b;
          n = this.b;
          i = k;
          j = k;
        }
      }
      catch (MalformedURLException paramObject)
      {
        try
        {
          paramObject = new URL(localQQCardItem.bgUrl);
          int i = paramBaseHolder.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          j = paramBaseHolder.jdField_b_of_type_AndroidViewView.getPaddingTop();
          k = paramBaseHolder.jdField_b_of_type_AndroidViewView.getPaddingRight();
          m = paramBaseHolder.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          if (paramObject == null) {
            break label427;
          }
          if ((paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardItem == null) || (!paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardItem.bgUrl.equals(localQQCardItem.bgUrl))) {
            paramBaseHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(URLDrawableHelper.a((URL)paramObject, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
          }
          paramBaseHolder.jdField_b_of_type_AndroidViewView.setPadding(m, j, k, i);
          paramBaseHolder.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardItem = localQQCardItem;
          return;
        }
        catch (MalformedURLException paramObject)
        {
          ((MalformedURLException)paramObject).printStackTrace();
        }
        paramObject = paramObject;
        ((MalformedURLException)paramObject).printStackTrace();
      }
      try
      {
        if (localQQCardItem.validTipsColor > -1)
        {
          j = k;
          i = Color.parseColor("#" + Integer.toHexString(localQQCardItem.validTipsColor));
        }
        m = n;
        k = i;
        j = i;
        if (localQQCardItem.fromColor > -1)
        {
          j = i;
          m = Color.parseColor("#" + Integer.toHexString(localQQCardItem.fromColor));
          k = i;
        }
      }
      catch (IllegalArgumentException paramObject)
      {
        m = n;
        k = j;
      }
    }
    a(paramBaseHolder, localQQCardItem, k);
    paramBaseHolder.jdField_c_of_type_AndroidWidgetTextView.setTextColor(k);
    paramBaseHolder.d.setTextColor(m);
    if (!TextUtils.isEmpty(localQQCardItem.bgUrl)) {}
    for (;;)
    {
      paramObject = null;
      break;
      paramBaseHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
      break label70;
      paramObject = null;
      continue;
      label427:
      paramBaseHolder.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof QQCardItem))
    {
      paramView = (QQCardItem)paramView;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView.jumpUrl);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\CommonCardItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */