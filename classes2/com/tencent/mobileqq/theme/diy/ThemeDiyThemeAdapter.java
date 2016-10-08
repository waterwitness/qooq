package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class ThemeDiyThemeAdapter
  extends ThemeDiyBgAdapter
{
  public int mSaveStatus;
  public int mSetStatus;
  public ResItemHolder selectResItem;
  
  public ThemeDiyThemeAdapter(QQAppInterface paramQQAppInterface, Context paramContext, ArrayList paramArrayList, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramArrayList, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    TAG = "ThemeDiyThemeAdapter";
  }
  
  void setItemState(ResItemHolder paramResItemHolder)
  {
    if ((paramResItemHolder == null) || (paramResItemHolder.convertView == null)) {}
    View localView;
    do
    {
      return;
      localView = paramResItemHolder.convertView;
    } while ((localView == null) || (localView.getTag() != paramResItemHolder));
    if (paramResItemHolder.id == this.resUsedID)
    {
      localView.findViewById(2131303409).setBackgroundResource(2130838194);
      if (paramResItemHolder.index != this.resTryOnPosition) {
        break label119;
      }
      localView.findViewById(2131303404).setBackgroundResource(2131427631);
    }
    for (;;)
    {
      if (paramResItemHolder.index != 0) {
        break label133;
      }
      ((TextView)localView.findViewById(2131303408)).setText(2131369588);
      localView.findViewById(2131303405).setVisibility(8);
      return;
      localView.findViewById(2131303409).setBackgroundDrawable(null);
      break;
      label119:
      localView.findViewById(2131303404).setBackgroundResource(2131427630);
    }
    label133:
    ((TextView)localView.findViewById(2131303408)).setText(null);
    localView.findViewById(2131303405).setVisibility(0);
  }
  
  void showThumn(int paramInt, View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramInt == 0) {
      if (paramView != null) {
        ((ImageView)paramView.findViewById(2131303405)).setBackgroundResource(2131427632);
      }
    }
    label234:
    label248:
    for (;;)
    {
      return;
      ResItemHolder localResItemHolder = (ResItemHolder)this.mData.get(paramInt);
      if (localResItemHolder != null)
      {
        View localView = paramView;
        if (paramView == null)
        {
          if (localResItemHolder.convertView != null)
          {
            if ((localResItemHolder.convertView.getTag() == null) || (localResItemHolder.convertView.getTag() != localResItemHolder))
            {
              localResItemHolder.convertView = null;
              return;
            }
            localView = localResItemHolder.convertView;
          }
        }
        else if (localResItemHolder == (ResItemHolder)localView.getTag())
        {
          ImageView localImageView = (ImageView)localView.findViewById(2131303405);
          if (localResItemHolder.thumResData == null)
          {
            localImageView.setBackgroundDrawable(null);
            return;
          }
          if (localResItemHolder.thumResData.from == 2)
          {
            paramView = ThemeDIYActivity.getAssetsDrawable(this.mContext, 0, localResItemHolder.thumResData.name);
            localImageView.setBackgroundDrawable(paramView);
            if (paramView == null) {
              break label234;
            }
            localResItemHolder.thumResData.state = 2;
          }
          for (;;)
          {
            if (paramBoolean) {
              break label248;
            }
            localResItemHolder.convertView = localView;
            return;
            paramView = localResItemHolder.thumResData.path;
            ResData localResData = localResItemHolder.thumResData;
            if (!paramBoolean) {
              bool = true;
            }
            paramView = getLocalDrawable(paramView, localResData, paramInt, bool);
            break;
            if (!paramBoolean) {
              localResItemHolder.thumResData.state = 1;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDiyThemeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */