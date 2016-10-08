package com.tencent.mobileqq.activity.qqcard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObtainableCardBuilder
  extends BaseCardItemBuilder
  implements View.OnClickListener
{
  private Context b;
  
  public ObtainableCardBuilder(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramContext;
  }
  
  public BaseCardItemBuilder.BaseHolder a(View paramView)
  {
    return new ObtainableCardBuilder.ViewHolder(paramView);
  }
  
  public void a(Object paramObject, BaseCardItemBuilder.BaseHolder paramBaseHolder)
  {
    Drawable localDrawable = this.b.getResources().getDrawable(2130841830);
    paramBaseHolder = (ObtainableCardBuilder.ViewHolder)paramBaseHolder;
    paramObject = (QQCardItem)paramObject;
    paramBaseHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((QQCardItem)paramObject).title);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(((QQCardItem)paramObject).distance))
    {
      localStringBuffer.append(((QQCardItem)paramObject).distance);
      localStringBuffer.append("  ");
    }
    localStringBuffer.append(QQCardConstant.a.format(new Date(((QQCardItem)paramObject).expireTime * 1000L)));
    if (!TextUtils.isEmpty(((QQCardItem)paramObject).brand)) {
      localStringBuffer.append("  ").append(((QQCardItem)paramObject).brand);
    }
    paramBaseHolder.b.setText(localStringBuffer.toString());
    paramBaseHolder.c.setOnClickListener(this);
    paramBaseHolder.c.setTag(((QQCardItem)paramObject).jumpUrl);
    if (!TextUtils.isEmpty(((QQCardItem)paramObject).iconUrl)) {}
    for (;;)
    {
      try
      {
        paramObject = new URL(((QQCardItem)paramObject).iconUrl);
        if (paramObject == null) {
          break;
        }
        paramObject = URLDrawableHelper.a((URL)paramObject, QQCardConstant.t, QQCardConstant.t, localDrawable, localDrawable);
        ((URLDrawable)paramObject).setDecodeHandler(URLDrawableDecodeHandler.a);
        paramBaseHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramObject);
        return;
      }
      catch (MalformedURLException paramObject)
      {
        ((MalformedURLException)paramObject).printStackTrace();
      }
      paramObject = null;
    }
    paramBaseHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
    localIntent.putExtra("url", (String)paramView.getTag());
    this.b.startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\ObtainableCardBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */