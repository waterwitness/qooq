package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class GroupAreaWrapper$BaseInfo
  implements View.OnClickListener, Serializable
{
  public String address;
  public QQAppInterface app;
  public String desc;
  public String desc_url;
  public int distance;
  public String image_url;
  public boolean isShowZeroDistance;
  public int number;
  public String title;
  public String title_url;
  public String type;
  
  public GroupAreaWrapper$BaseInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.isShowZeroDistance = true;
  }
  
  public View createView(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130903672, paramViewGroup, false);
    paramViewGroup = new NearbyTroops.ActivityAndTopicViewHolder();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131299665));
    paramViewGroup.b = ((TextView)paramContext.findViewById(2131299667));
    paramViewGroup.c = ((TextView)paramContext.findViewById(2131299671));
    paramViewGroup.d = ((TextView)paramContext.findViewById(2131299672));
    paramViewGroup.e = ((TextView)paramContext.findViewById(2131299673));
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131299669));
    paramContext.setTag(paramViewGroup);
    initUI(paramContext);
    return paramContext;
  }
  
  public void fillView(View paramView)
  {
    NearbyTroops.ActivityAndTopicViewHolder localActivityAndTopicViewHolder = (NearbyTroops.ActivityAndTopicViewHolder)paramView.getTag();
    localActivityAndTopicViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.type);
    localActivityAndTopicViewHolder.b.setText(this.desc);
    localActivityAndTopicViewHolder.c.setText(this.title);
    DecimalFormat localDecimalFormat = new DecimalFormat("#.#");
    Object localObject = "";
    if ((this.isShowZeroDistance) || (this.distance > 0))
    {
      if (this.distance < 100) {
        break label257;
      }
      localObject = localDecimalFormat.format(Math.ceil(this.distance / 50) * 0.05D) + "km";
    }
    for (;;)
    {
      localActivityAndTopicViewHolder.d.setText(this.address + " " + (String)localObject);
      localActivityAndTopicViewHolder.d.setCompoundDrawablePadding(8);
      localActivityAndTopicViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(2130839388, 0, 0, 0);
      setNumberText(localActivityAndTopicViewHolder.e);
      localActivityAndTopicViewHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      try
      {
        int i = AIOUtils.a(70.0F, paramView.getResources());
        localActivityAndTopicViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(this.image_url, i, i));
        localObject = (RelativeLayout)paramView.findViewById(2131299664);
        if (localObject != null) {
          ((RelativeLayout)localObject).setOnClickListener(this);
        }
        paramView = (RelativeLayout)paramView.findViewById(2131299668);
        if (paramView != null) {
          paramView.setOnClickListener(this);
        }
        return;
        label257:
        localObject = "0.1km";
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
        }
      }
    }
  }
  
  protected abstract void initUI(View paramView);
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131299664)
    {
      localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.title_url);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
    }
    while (i != 2131299668) {
      return;
    }
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", this.desc_url);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramView.getContext().startActivity(localIntent);
  }
  
  protected abstract void setNumberText(TextView paramTextView);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\GroupAreaWrapper$BaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */