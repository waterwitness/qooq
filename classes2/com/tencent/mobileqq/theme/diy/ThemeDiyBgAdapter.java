package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.util.ArrayList;

public class ThemeDiyBgAdapter
  extends BaseAdapter
{
  static final int DEFAULT_POSITION = 1;
  static final int HANDLER_MSG_SHOW_THUM = 100;
  static String TAG = "ThemeDiyBgAdapter";
  QQAppInterface app;
  String fileDir;
  int index = 0;
  public boolean isBigScreenType;
  protected Context mContext;
  ArrayList mData;
  Handler mHandler = new ThemeDiyBgAdapter.2(this, Looper.getMainLooper());
  LayoutInflater mInflater;
  int mResource;
  DownloadListener resDownloadListener = new ThemeDiyBgAdapter.1(this);
  int resTryOnPosition;
  int resUsedID;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ThemeDiyBgAdapter(QQAppInterface paramQQAppInterface, Context paramContext, ArrayList paramArrayList, int paramInt)
  {
    this.app = paramQQAppInterface;
    paramQQAppInterface = paramArrayList;
    if (paramArrayList == null) {
      paramQQAppInterface = new ArrayList();
    }
    this.mData = paramQQAppInterface;
    this.mContext = paramContext;
    this.mResource = paramInt;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mData == null) || (paramInt < 0) || (paramInt >= this.mData.size())) {
      return null;
    }
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  Drawable getLocalDrawable(String paramString, ResData paramResData, int paramInt, boolean paramBoolean)
  {
    File localFile = new File(paramString, paramResData.name);
    if (localFile.exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramString = BitmapManager.a(paramString + paramResData.name, localOptions);
      if (paramString != null) {
        return new ChatBackgroundDrawable(this.mContext.getResources(), paramString);
      }
    }
    if ((paramBoolean) && (paramResData.url != null))
    {
      paramString = new DownloadTask(paramResData.url, localFile);
      ((DownloaderFactory)this.app.getManager(46)).a(1).a(paramString, this.resDownloadListener, ThemeDIYActivity.getLoadParam(0, paramInt, paramResData.picType));
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.mInflater.inflate(this.mResource, paramViewGroup, false);
    }
    paramView = (ResItemHolder)this.mData.get(paramInt);
    paramView.convertView = localView;
    localView.setTag(paramView);
    setItemState(paramView);
    showThumn(paramInt, localView, false);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  void setItemState(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == paramInt2) {}
    label16:
    label89:
    do
    {
      return;
      if (paramBoolean)
      {
        int i = 0;
        int j = 0;
        int k;
        if (i < this.mData.size())
        {
          if ((j != 0) || (paramInt1 != ((ResItemHolder)this.mData.get(i)).id)) {
            break label89;
          }
          k = 1;
          setItemState((ResItemHolder)this.mData.get(i));
        }
        for (;;)
        {
          if (k != 0) {}
          i += 1;
          j = k;
          break label16;
          break;
          k = j;
          if (paramInt2 == ((ResItemHolder)this.mData.get(i)).id)
          {
            setItemState((ResItemHolder)this.mData.get(i));
            k = j;
          }
        }
      }
      if (paramInt1 >= 0) {
        setItemState((ResItemHolder)this.mData.get(paramInt1));
      }
    } while (paramInt2 < 0);
    setItemState((ResItemHolder)this.mData.get(paramInt2));
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
    if (paramResItemHolder.itemType == 0)
    {
      localView.findViewById(2131303405).setVisibility(8);
      localView.findViewById(2131303406).setVisibility(0);
      if (paramResItemHolder.id != this.resUsedID) {
        break label126;
      }
      localView.findViewById(2131303409).setBackgroundResource(2130838194);
    }
    for (;;)
    {
      if (paramResItemHolder.index != this.resTryOnPosition) {
        break label139;
      }
      localView.findViewById(2131303404).setBackgroundResource(2131427631);
      return;
      localView.findViewById(2131303405).setVisibility(0);
      localView.findViewById(2131303406).setVisibility(8);
      break;
      label126:
      localView.findViewById(2131303409).setBackgroundDrawable(null);
    }
    label139:
    localView.findViewById(2131303404).setBackgroundResource(2131427629);
  }
  
  void showThumn(int paramInt, View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramInt < 1) || (paramInt >= this.mData.size())) {}
    ResItemHolder localResItemHolder;
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          localResItemHolder = (ResItemHolder)this.mData.get(paramInt);
        } while (localResItemHolder == null);
        localView = paramView;
        if (paramView != null) {
          break;
        }
      } while (localResItemHolder.convertView == null);
      if ((localResItemHolder.convertView.getTag() == null) || (localResItemHolder.convertView.getTag() != localResItemHolder))
      {
        localResItemHolder.convertView = null;
        return;
      }
      localView = localResItemHolder.convertView;
    } while (localResItemHolder != (ResItemHolder)localView.getTag());
    ImageView localImageView = (ImageView)localView.findViewById(2131303405);
    if (localResItemHolder.thumResData == null)
    {
      localImageView.setBackgroundResource(2131427558);
      return;
    }
    if (localResItemHolder.thumResData.from == 2)
    {
      paramView = ThemeDIYActivity.getAssetsDrawable(this.mContext, 0, localResItemHolder.thumResData.name);
      label162:
      localImageView.setBackgroundDrawable(paramView);
      if (paramView == null) {
        break label248;
      }
      localResItemHolder.thumResData.state = 2;
    }
    for (;;)
    {
      localImageView.setBackgroundDrawable(paramView);
      if (paramView == null) {
        localImageView.setBackgroundResource(2131427559);
      }
      if (paramBoolean) {
        break;
      }
      localResItemHolder.convertView = localView;
      return;
      paramView = localResItemHolder.thumResData.path;
      ResData localResData = localResItemHolder.thumResData;
      if (!paramBoolean) {
        bool = true;
      }
      paramView = getLocalDrawable(paramView, localResData, paramInt, bool);
      break label162;
      label248:
      if (!paramBoolean) {
        localResItemHolder.thumResData.state = 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDiyBgAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */